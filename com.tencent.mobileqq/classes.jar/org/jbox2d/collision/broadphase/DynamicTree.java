package org.jbox2d.collision.broadphase;

import org.jbox2d.callbacks.DebugDraw;
import org.jbox2d.callbacks.TreeCallback;
import org.jbox2d.callbacks.TreeRayCastCallback;
import org.jbox2d.collision.AABB;
import org.jbox2d.collision.RayCastInput;
import org.jbox2d.common.Color3f;
import org.jbox2d.common.IViewportTransform;
import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Vec2;

public class DynamicTree
  implements BroadPhaseStrategy
{
  public static final int MAX_STACK_SIZE = 64;
  public static final int NULL_NODE = -1;
  private final AABB aabb = new AABB();
  private final Color3f color = new Color3f();
  private final AABB combinedAABB = new AABB();
  private final Vec2[] drawVecs = new Vec2[4];
  private int m_freeList;
  private int m_insertionCount;
  private int m_nodeCapacity;
  private int m_nodeCount;
  private DynamicTreeNode[] m_nodes;
  private DynamicTreeNode m_root = null;
  private final DynamicTree.TreeNodeStack nodeStack = new DynamicTree.TreeNodeStack(this, 10);
  private final Vec2 r = new Vec2();
  private final RayCastInput subInput = new RayCastInput();
  private final Vec2 textVec = new Vec2();
  
  public DynamicTree()
  {
    int j = 0;
    this.m_nodeCount = 0;
    this.m_nodeCapacity = 16;
    this.m_nodes = new DynamicTreeNode[16];
    int i = this.m_nodeCapacity - 1;
    Object localObject1;
    while (i >= 0)
    {
      this.m_nodes[i] = new DynamicTreeNode(i);
      localObject1 = this.m_nodes;
      Object localObject2 = localObject1[i];
      if (i == this.m_nodeCapacity - 1) {
        localObject1 = null;
      } else {
        localObject1 = localObject1[(i + 1)];
      }
      localObject2.parent = ((DynamicTreeNode)localObject1);
      this.m_nodes[i].height = -1;
      i -= 1;
    }
    this.m_freeList = 0;
    this.m_insertionCount = 0;
    i = j;
    for (;;)
    {
      localObject1 = this.drawVecs;
      if (i >= localObject1.length) {
        break;
      }
      localObject1[i] = new Vec2();
      i += 1;
    }
  }
  
  private final DynamicTreeNode allocateNode()
  {
    int i = this.m_freeList;
    int j = -1;
    if (i == -1)
    {
      localObject1 = this.m_nodes;
      this.m_nodeCapacity *= 2;
      this.m_nodes = new DynamicTreeNode[this.m_nodeCapacity];
      System.arraycopy(localObject1, 0, this.m_nodes, 0, localObject1.length);
      i = this.m_nodeCapacity - 1;
      int k;
      for (;;)
      {
        k = this.m_nodeCount;
        if (i < k) {
          break;
        }
        this.m_nodes[i] = new DynamicTreeNode(i);
        localObject1 = this.m_nodes;
        Object localObject2 = localObject1[i];
        if (i == this.m_nodeCapacity - 1) {
          localObject1 = null;
        } else {
          localObject1 = localObject1[(i + 1)];
        }
        localObject2.parent = ((DynamicTreeNode)localObject1);
        this.m_nodes[i].height = -1;
        i -= 1;
      }
      this.m_freeList = k;
    }
    i = this.m_freeList;
    Object localObject1 = this.m_nodes[i];
    i = j;
    if (((DynamicTreeNode)localObject1).parent != null) {
      i = ((DynamicTreeNode)localObject1).parent.id;
    }
    this.m_freeList = i;
    ((DynamicTreeNode)localObject1).parent = null;
    ((DynamicTreeNode)localObject1).child1 = null;
    ((DynamicTreeNode)localObject1).child2 = null;
    ((DynamicTreeNode)localObject1).height = 0;
    ((DynamicTreeNode)localObject1).userData = null;
    this.m_nodeCount += 1;
    return localObject1;
  }
  
  private DynamicTreeNode balance(DynamicTreeNode paramDynamicTreeNode)
  {
    if (!paramDynamicTreeNode.isLeaf())
    {
      if (paramDynamicTreeNode.height < 2) {
        return paramDynamicTreeNode;
      }
      DynamicTreeNode localDynamicTreeNode1 = paramDynamicTreeNode.child1;
      DynamicTreeNode localDynamicTreeNode2 = paramDynamicTreeNode.child2;
      int i = localDynamicTreeNode2.height - localDynamicTreeNode1.height;
      DynamicTreeNode localDynamicTreeNode3;
      DynamicTreeNode localDynamicTreeNode4;
      if (i > 1)
      {
        localDynamicTreeNode3 = localDynamicTreeNode2.child1;
        localDynamicTreeNode4 = localDynamicTreeNode2.child2;
        localDynamicTreeNode2.child1 = paramDynamicTreeNode;
        localDynamicTreeNode2.parent = paramDynamicTreeNode.parent;
        paramDynamicTreeNode.parent = localDynamicTreeNode2;
        if (localDynamicTreeNode2.parent != null)
        {
          if (localDynamicTreeNode2.parent.child1 == paramDynamicTreeNode) {
            localDynamicTreeNode2.parent.child1 = localDynamicTreeNode2;
          } else {
            localDynamicTreeNode2.parent.child2 = localDynamicTreeNode2;
          }
        }
        else {
          this.m_root = localDynamicTreeNode2;
        }
        if (localDynamicTreeNode3.height > localDynamicTreeNode4.height)
        {
          localDynamicTreeNode2.child2 = localDynamicTreeNode3;
          paramDynamicTreeNode.child2 = localDynamicTreeNode4;
          localDynamicTreeNode4.parent = paramDynamicTreeNode;
          paramDynamicTreeNode.aabb.combine(localDynamicTreeNode1.aabb, localDynamicTreeNode4.aabb);
          localDynamicTreeNode2.aabb.combine(paramDynamicTreeNode.aabb, localDynamicTreeNode3.aabb);
          paramDynamicTreeNode.height = (MathUtils.max(localDynamicTreeNode1.height, localDynamicTreeNode4.height) + 1);
          localDynamicTreeNode2.height = (MathUtils.max(paramDynamicTreeNode.height, localDynamicTreeNode3.height) + 1);
          return localDynamicTreeNode2;
        }
        localDynamicTreeNode2.child2 = localDynamicTreeNode4;
        paramDynamicTreeNode.child2 = localDynamicTreeNode3;
        localDynamicTreeNode3.parent = paramDynamicTreeNode;
        paramDynamicTreeNode.aabb.combine(localDynamicTreeNode1.aabb, localDynamicTreeNode3.aabb);
        localDynamicTreeNode2.aabb.combine(paramDynamicTreeNode.aabb, localDynamicTreeNode4.aabb);
        paramDynamicTreeNode.height = (MathUtils.max(localDynamicTreeNode1.height, localDynamicTreeNode3.height) + 1);
        localDynamicTreeNode2.height = (MathUtils.max(paramDynamicTreeNode.height, localDynamicTreeNode4.height) + 1);
        return localDynamicTreeNode2;
      }
      if (i < -1)
      {
        localDynamicTreeNode3 = localDynamicTreeNode1.child1;
        localDynamicTreeNode4 = localDynamicTreeNode1.child2;
        localDynamicTreeNode1.child1 = paramDynamicTreeNode;
        localDynamicTreeNode1.parent = paramDynamicTreeNode.parent;
        paramDynamicTreeNode.parent = localDynamicTreeNode1;
        if (localDynamicTreeNode1.parent != null)
        {
          if (localDynamicTreeNode1.parent.child1 == paramDynamicTreeNode) {
            localDynamicTreeNode1.parent.child1 = localDynamicTreeNode1;
          } else {
            localDynamicTreeNode1.parent.child2 = localDynamicTreeNode1;
          }
        }
        else {
          this.m_root = localDynamicTreeNode1;
        }
        if (localDynamicTreeNode3.height > localDynamicTreeNode4.height)
        {
          localDynamicTreeNode1.child2 = localDynamicTreeNode3;
          paramDynamicTreeNode.child1 = localDynamicTreeNode4;
          localDynamicTreeNode4.parent = paramDynamicTreeNode;
          paramDynamicTreeNode.aabb.combine(localDynamicTreeNode2.aabb, localDynamicTreeNode4.aabb);
          localDynamicTreeNode1.aabb.combine(paramDynamicTreeNode.aabb, localDynamicTreeNode3.aabb);
          paramDynamicTreeNode.height = (MathUtils.max(localDynamicTreeNode2.height, localDynamicTreeNode4.height) + 1);
          localDynamicTreeNode1.height = (MathUtils.max(paramDynamicTreeNode.height, localDynamicTreeNode3.height) + 1);
          return localDynamicTreeNode1;
        }
        localDynamicTreeNode1.child2 = localDynamicTreeNode4;
        paramDynamicTreeNode.child1 = localDynamicTreeNode3;
        localDynamicTreeNode3.parent = paramDynamicTreeNode;
        paramDynamicTreeNode.aabb.combine(localDynamicTreeNode2.aabb, localDynamicTreeNode3.aabb);
        localDynamicTreeNode1.aabb.combine(paramDynamicTreeNode.aabb, localDynamicTreeNode4.aabb);
        paramDynamicTreeNode.height = (MathUtils.max(localDynamicTreeNode2.height, localDynamicTreeNode3.height) + 1);
        localDynamicTreeNode1.height = (MathUtils.max(paramDynamicTreeNode.height, localDynamicTreeNode4.height) + 1);
        return localDynamicTreeNode1;
      }
    }
    return paramDynamicTreeNode;
  }
  
  private final int computeHeight(DynamicTreeNode paramDynamicTreeNode)
  {
    if (paramDynamicTreeNode.isLeaf()) {
      return 0;
    }
    return MathUtils.max(computeHeight(paramDynamicTreeNode.child1), computeHeight(paramDynamicTreeNode.child2)) + 1;
  }
  
  private final void freeNode(DynamicTreeNode paramDynamicTreeNode)
  {
    int i = this.m_freeList;
    DynamicTreeNode localDynamicTreeNode;
    if (i != -1) {
      localDynamicTreeNode = this.m_nodes[i];
    } else {
      localDynamicTreeNode = null;
    }
    paramDynamicTreeNode.parent = localDynamicTreeNode;
    paramDynamicTreeNode.height = -1;
    this.m_freeList = paramDynamicTreeNode.id;
    this.m_nodeCount -= 1;
  }
  
  private final void insertLeaf(int paramInt)
  {
    this.m_insertionCount += 1;
    DynamicTreeNode localDynamicTreeNode3 = this.m_nodes[paramInt];
    if (this.m_root == null)
    {
      this.m_root = localDynamicTreeNode3;
      this.m_root.parent = null;
      return;
    }
    AABB localAABB = localDynamicTreeNode3.aabb;
    Object localObject = this.m_root;
    while (((DynamicTreeNode)localObject).child1 != null)
    {
      localDynamicTreeNode1 = ((DynamicTreeNode)localObject).child1;
      localDynamicTreeNode2 = ((DynamicTreeNode)localObject).child2;
      float f1 = ((DynamicTreeNode)localObject).aabb.getPerimeter();
      this.combinedAABB.combine(((DynamicTreeNode)localObject).aabb, localAABB);
      float f2 = this.combinedAABB.getPerimeter();
      float f3 = f2 * 2.0F;
      f2 = (f2 - f1) * 2.0F;
      if (localDynamicTreeNode1.isLeaf())
      {
        this.combinedAABB.combine(localAABB, localDynamicTreeNode1.aabb);
        f1 = this.combinedAABB.getPerimeter() + f2;
      }
      else
      {
        this.combinedAABB.combine(localAABB, localDynamicTreeNode1.aabb);
        f1 = localDynamicTreeNode1.aabb.getPerimeter();
        f1 = this.combinedAABB.getPerimeter() - f1 + f2;
      }
      if (localDynamicTreeNode2.isLeaf())
      {
        this.combinedAABB.combine(localAABB, localDynamicTreeNode2.aabb);
        f2 = this.combinedAABB.getPerimeter() + f2;
      }
      else
      {
        this.combinedAABB.combine(localAABB, localDynamicTreeNode2.aabb);
        float f4 = localDynamicTreeNode2.aabb.getPerimeter();
        f2 = this.combinedAABB.getPerimeter() - f4 + f2;
      }
      if ((f3 < f1) && (f3 < f2)) {
        break;
      }
      if (f1 < f2) {
        localObject = localDynamicTreeNode1;
      } else {
        localObject = localDynamicTreeNode2;
      }
    }
    DynamicTreeNode localDynamicTreeNode1 = this.m_nodes[localObject.id].parent;
    DynamicTreeNode localDynamicTreeNode2 = allocateNode();
    localDynamicTreeNode2.parent = localDynamicTreeNode1;
    localDynamicTreeNode2.userData = null;
    localDynamicTreeNode2.aabb.combine(localAABB, ((DynamicTreeNode)localObject).aabb);
    localDynamicTreeNode2.height = (((DynamicTreeNode)localObject).height + 1);
    if (localDynamicTreeNode1 != null)
    {
      if (localDynamicTreeNode1.child1 == localObject) {
        localDynamicTreeNode1.child1 = localDynamicTreeNode2;
      } else {
        localDynamicTreeNode1.child2 = localDynamicTreeNode2;
      }
      localDynamicTreeNode2.child1 = ((DynamicTreeNode)localObject);
      localDynamicTreeNode2.child2 = localDynamicTreeNode3;
      ((DynamicTreeNode)localObject).parent = localDynamicTreeNode2;
      localDynamicTreeNode3.parent = localDynamicTreeNode2;
    }
    else
    {
      localDynamicTreeNode2.child1 = ((DynamicTreeNode)localObject);
      localDynamicTreeNode2.child2 = localDynamicTreeNode3;
      ((DynamicTreeNode)localObject).parent = localDynamicTreeNode2;
      localDynamicTreeNode3.parent = localDynamicTreeNode2;
      this.m_root = localDynamicTreeNode2;
    }
    for (localObject = localDynamicTreeNode3.parent; localObject != null; localObject = ((DynamicTreeNode)localObject).parent)
    {
      localObject = balance((DynamicTreeNode)localObject);
      localDynamicTreeNode1 = ((DynamicTreeNode)localObject).child1;
      localDynamicTreeNode2 = ((DynamicTreeNode)localObject).child2;
      ((DynamicTreeNode)localObject).height = (MathUtils.max(localDynamicTreeNode1.height, localDynamicTreeNode2.height) + 1);
      ((DynamicTreeNode)localObject).aabb.combine(localDynamicTreeNode1.aabb, localDynamicTreeNode2.aabb);
    }
  }
  
  private final void removeLeaf(DynamicTreeNode paramDynamicTreeNode)
  {
    if (paramDynamicTreeNode == this.m_root)
    {
      this.m_root = null;
      return;
    }
    DynamicTreeNode localDynamicTreeNode2 = paramDynamicTreeNode.parent;
    DynamicTreeNode localDynamicTreeNode1 = localDynamicTreeNode2.parent;
    if (localDynamicTreeNode2.child1 == paramDynamicTreeNode) {
      paramDynamicTreeNode = localDynamicTreeNode2.child2;
    } else {
      paramDynamicTreeNode = localDynamicTreeNode2.child1;
    }
    if (localDynamicTreeNode1 != null)
    {
      if (localDynamicTreeNode1.child1 == localDynamicTreeNode2) {
        localDynamicTreeNode1.child1 = paramDynamicTreeNode;
      } else {
        localDynamicTreeNode1.child2 = paramDynamicTreeNode;
      }
      paramDynamicTreeNode.parent = localDynamicTreeNode1;
      freeNode(localDynamicTreeNode2);
      for (paramDynamicTreeNode = localDynamicTreeNode1; paramDynamicTreeNode != null; paramDynamicTreeNode = paramDynamicTreeNode.parent)
      {
        paramDynamicTreeNode = balance(paramDynamicTreeNode);
        localDynamicTreeNode1 = paramDynamicTreeNode.child1;
        localDynamicTreeNode2 = paramDynamicTreeNode.child2;
        paramDynamicTreeNode.aabb.combine(localDynamicTreeNode1.aabb, localDynamicTreeNode2.aabb);
        paramDynamicTreeNode.height = (MathUtils.max(localDynamicTreeNode1.height, localDynamicTreeNode2.height) + 1);
      }
    }
    this.m_root = paramDynamicTreeNode;
    paramDynamicTreeNode.parent = null;
    freeNode(localDynamicTreeNode2);
  }
  
  private void validateMetrics(DynamicTreeNode paramDynamicTreeNode)
  {
    if (paramDynamicTreeNode == null) {
      return;
    }
    DynamicTreeNode localDynamicTreeNode1 = paramDynamicTreeNode.child1;
    DynamicTreeNode localDynamicTreeNode2 = paramDynamicTreeNode.child2;
    if (paramDynamicTreeNode.isLeaf()) {
      return;
    }
    MathUtils.max(localDynamicTreeNode1.height, localDynamicTreeNode2.height);
    new AABB().combine(localDynamicTreeNode1.aabb, localDynamicTreeNode2.aabb);
    validateMetrics(localDynamicTreeNode1);
    validateMetrics(localDynamicTreeNode2);
  }
  
  private void validateStructure(DynamicTreeNode paramDynamicTreeNode)
  {
    if (paramDynamicTreeNode == null) {
      return;
    }
    DynamicTreeNode localDynamicTreeNode1 = this.m_root;
    localDynamicTreeNode1 = paramDynamicTreeNode.child1;
    DynamicTreeNode localDynamicTreeNode2 = paramDynamicTreeNode.child2;
    if (paramDynamicTreeNode.isLeaf()) {
      return;
    }
    validateStructure(localDynamicTreeNode1);
    validateStructure(localDynamicTreeNode2);
  }
  
  public final int computeHeight()
  {
    return computeHeight(this.m_root);
  }
  
  public final int createProxy(AABB paramAABB, Object paramObject)
  {
    DynamicTreeNode localDynamicTreeNode = allocateNode();
    int i = localDynamicTreeNode.id;
    AABB localAABB = localDynamicTreeNode.aabb;
    paramAABB.lowerBound.x -= 0.1F;
    paramAABB.lowerBound.y -= 0.1F;
    paramAABB.upperBound.x += 0.1F;
    paramAABB.upperBound.y += 0.1F;
    localDynamicTreeNode.userData = paramObject;
    insertLeaf(i);
    return i;
  }
  
  public final void destroyProxy(int paramInt)
  {
    DynamicTreeNode localDynamicTreeNode = this.m_nodes[paramInt];
    removeLeaf(localDynamicTreeNode);
    freeNode(localDynamicTreeNode);
  }
  
  public void drawTree(DebugDraw paramDebugDraw)
  {
    if (this.m_root == null) {
      return;
    }
    int i = computeHeight();
    drawTree(paramDebugDraw, this.m_root, 0, i);
  }
  
  public void drawTree(DebugDraw paramDebugDraw, DynamicTreeNode paramDynamicTreeNode, int paramInt1, int paramInt2)
  {
    paramDynamicTreeNode.aabb.getVertices(this.drawVecs);
    Object localObject = this.color;
    float f1 = (paramInt2 - paramInt1) * 1.0F / paramInt2;
    ((Color3f)localObject).set(1.0F, f1, f1);
    paramDebugDraw.drawPolygon(this.drawVecs, 4, this.color);
    paramDebugDraw.getViewportTranform().getWorldToScreen(paramDynamicTreeNode.aabb.upperBound, this.textVec);
    f1 = this.textVec.x;
    float f2 = this.textVec.y;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramDynamicTreeNode.id);
    ((StringBuilder)localObject).append("-");
    paramInt1 += 1;
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(paramInt2);
    paramDebugDraw.drawString(f1, f2, ((StringBuilder)localObject).toString(), this.color);
    if (paramDynamicTreeNode.child1 != null) {
      drawTree(paramDebugDraw, paramDynamicTreeNode.child1, paramInt1, paramInt2);
    }
    if (paramDynamicTreeNode.child2 != null) {
      drawTree(paramDebugDraw, paramDynamicTreeNode.child2, paramInt1, paramInt2);
    }
  }
  
  public float getAreaRatio()
  {
    DynamicTreeNode localDynamicTreeNode = this.m_root;
    float f1 = 0.0F;
    if (localDynamicTreeNode == null) {
      return 0.0F;
    }
    float f2 = localDynamicTreeNode.aabb.getPerimeter();
    int i = 0;
    while (i < this.m_nodeCapacity)
    {
      localDynamicTreeNode = this.m_nodes[i];
      if (localDynamicTreeNode.height >= 0) {
        f1 += localDynamicTreeNode.aabb.getPerimeter();
      }
      i += 1;
    }
    return f1 / f2;
  }
  
  public final AABB getFatAABB(int paramInt)
  {
    return this.m_nodes[paramInt].aabb;
  }
  
  public int getHeight()
  {
    DynamicTreeNode localDynamicTreeNode = this.m_root;
    if (localDynamicTreeNode == null) {
      return 0;
    }
    return localDynamicTreeNode.height;
  }
  
  public int getInsertionCount()
  {
    return this.m_insertionCount;
  }
  
  public int getMaxBalance()
  {
    int i = 0;
    int j = 0;
    while (i < this.m_nodeCapacity)
    {
      DynamicTreeNode localDynamicTreeNode1 = this.m_nodes[i];
      if (localDynamicTreeNode1.height > 1)
      {
        DynamicTreeNode localDynamicTreeNode2 = localDynamicTreeNode1.child1;
        j = MathUtils.max(j, MathUtils.abs(localDynamicTreeNode1.child2.height - localDynamicTreeNode2.height));
      }
      i += 1;
    }
    return j;
  }
  
  public final Object getUserData(int paramInt)
  {
    return this.m_nodes[paramInt].userData;
  }
  
  public final boolean moveProxy(int paramInt, AABB paramAABB, Vec2 paramVec2)
  {
    Object localObject2 = this.m_nodes[paramInt];
    Object localObject1 = ((DynamicTreeNode)localObject2).aabb;
    if ((((AABB)localObject1).lowerBound.x > paramAABB.lowerBound.x) && (((AABB)localObject1).lowerBound.y > paramAABB.lowerBound.y) && (paramAABB.upperBound.x > ((AABB)localObject1).upperBound.x) && (paramAABB.upperBound.y > ((AABB)localObject1).upperBound.y)) {
      return false;
    }
    removeLeaf((DynamicTreeNode)localObject2);
    localObject2 = ((AABB)localObject1).lowerBound;
    localObject1 = ((AABB)localObject1).upperBound;
    ((Vec2)localObject2).x = (paramAABB.lowerBound.x - 0.1F);
    ((Vec2)localObject2).y = (paramAABB.lowerBound.y - 0.1F);
    ((Vec2)localObject1).x = (paramAABB.upperBound.x + 0.1F);
    ((Vec2)localObject1).y = (paramAABB.upperBound.y + 0.1F);
    float f1 = paramVec2.x * 2.0F;
    float f2 = paramVec2.y * 2.0F;
    if (f1 < 0.0F) {
      ((Vec2)localObject2).x += f1;
    } else {
      ((Vec2)localObject1).x += f1;
    }
    if (f2 < 0.0F) {
      ((Vec2)localObject2).y += f2;
    } else {
      ((Vec2)localObject1).y += f2;
    }
    insertLeaf(paramInt);
    return true;
  }
  
  public final void query(TreeCallback paramTreeCallback, AABB paramAABB)
  {
    this.nodeStack.reset();
    this.nodeStack.push(this.m_root);
    while (this.nodeStack.getCount() > 0)
    {
      DynamicTreeNode localDynamicTreeNode = this.nodeStack.pop();
      if ((localDynamicTreeNode != null) && (AABB.testOverlap(localDynamicTreeNode.aabb, paramAABB))) {
        if (localDynamicTreeNode.child1 == null)
        {
          if (paramTreeCallback.treeCallback(localDynamicTreeNode.id)) {}
        }
        else
        {
          this.nodeStack.push(localDynamicTreeNode.child1);
          this.nodeStack.push(localDynamicTreeNode.child2);
        }
      }
    }
  }
  
  public void raycast(TreeRayCastCallback paramTreeRayCastCallback, RayCastInput paramRayCastInput)
  {
    Object localObject1 = paramRayCastInput.p1;
    Object localObject2 = paramRayCastInput.p2;
    float f1 = ((Vec2)localObject1).x;
    float f9 = ((Vec2)localObject2).x;
    float f2 = ((Vec2)localObject1).y;
    float f10 = ((Vec2)localObject2).y;
    localObject1 = this.r;
    float f6 = f9 - f1;
    ((Vec2)localObject1).x = f6;
    float f7 = f10 - f2;
    ((Vec2)localObject1).y = f7;
    ((Vec2)localObject1).normalize();
    float f3 = this.r.x;
    float f11 = this.r.y * -1.0F;
    float f12 = f3 * 1.0F;
    float f13 = MathUtils.abs(f11);
    float f14 = MathUtils.abs(f12);
    float f8 = paramRayCastInput.maxFraction;
    paramRayCastInput = this.aabb;
    float f4 = f6 * f8 + f1;
    f3 = f7 * f8 + f2;
    localObject1 = paramRayCastInput.lowerBound;
    if (f1 < f4) {
      f5 = f1;
    } else {
      f5 = f4;
    }
    ((Vec2)localObject1).x = f5;
    localObject1 = paramRayCastInput.lowerBound;
    if (f2 < f3) {
      f5 = f2;
    } else {
      f5 = f3;
    }
    ((Vec2)localObject1).y = f5;
    localObject1 = paramRayCastInput.upperBound;
    float f5 = f4;
    if (f1 > f4) {
      f5 = f1;
    }
    ((Vec2)localObject1).x = f5;
    localObject1 = paramRayCastInput.upperBound;
    f4 = f3;
    if (f2 > f3) {
      f4 = f2;
    }
    ((Vec2)localObject1).y = f4;
    this.nodeStack.reset();
    this.nodeStack.push(this.m_root);
    f5 = f8;
    f4 = f7;
    f3 = f6;
    while (this.nodeStack.getCount() > 0)
    {
      localObject2 = this.nodeStack.pop();
      Object localObject3;
      if (localObject2 != null)
      {
        do
        {
          localObject3 = ((DynamicTreeNode)localObject2).aabb;
        } while (!AABB.testOverlap((AABB)localObject3, paramRayCastInput));
        f6 = ((AABB)localObject3).lowerBound.x;
        localObject1 = paramRayCastInput;
        f7 = ((AABB)localObject3).upperBound.x;
        f8 = ((AABB)localObject3).lowerBound.y;
        float f15 = ((AABB)localObject3).upperBound.y;
        float f16 = ((AABB)localObject3).upperBound.x;
        float f17 = ((AABB)localObject3).lowerBound.x;
        float f18 = ((AABB)localObject3).upperBound.y;
        float f19 = ((AABB)localObject3).lowerBound.y;
        if (MathUtils.abs((f1 - (f6 + f7) * 0.5F) * f11 + (f2 - (f8 + f15) * 0.5F) * f12) - ((f16 - f17) * 0.5F * f13 + (f18 - f19) * 0.5F * f14) > 0.0F) {
          break;
        }
      }
      else
      {
        for (;;)
        {
          if (((DynamicTreeNode)localObject2).isLeaf())
          {
            this.subInput.p1.x = f1;
            this.subInput.p1.y = f2;
            this.subInput.p2.x = f9;
            this.subInput.p2.y = f10;
            localObject3 = this.subInput;
            ((RayCastInput)localObject3).maxFraction = f5;
            f8 = paramTreeRayCastCallback.raycastCallback((RayCastInput)localObject3, ((DynamicTreeNode)localObject2).id);
            if (f8 == 0.0F) {
              return;
            }
            if (f8 > 0.0F)
            {
              f6 = f3 * f8 + f1;
              f5 = f4 * f8 + f2;
              paramRayCastInput = (RayCastInput)localObject1;
              localObject1 = paramRayCastInput.lowerBound;
              if (f1 < f6) {
                f7 = f1;
              } else {
                f7 = f6;
              }
              ((Vec2)localObject1).x = f7;
              localObject1 = paramRayCastInput.lowerBound;
              if (f2 < f5) {
                f7 = f2;
              } else {
                f7 = f5;
              }
              ((Vec2)localObject1).y = f7;
              localObject1 = paramRayCastInput.upperBound;
              f7 = f6;
              if (f1 > f6) {
                f7 = f1;
              }
              ((Vec2)localObject1).x = f7;
              localObject1 = paramRayCastInput.upperBound;
              f6 = f5;
              if (f2 > f5) {
                f6 = f2;
              }
              ((Vec2)localObject1).y = f6;
              f5 = f8;
            }
          }
          else
          {
            paramRayCastInput = (RayCastInput)localObject1;
            this.nodeStack.push(((DynamicTreeNode)localObject2).child1);
            this.nodeStack.push(((DynamicTreeNode)localObject2).child2);
          }
        }
      }
    }
  }
  
  public void rebuildBottomUp()
  {
    int[] arrayOfInt = new int[this.m_nodeCount];
    int j = 0;
    int i = 0;
    while (j < this.m_nodeCapacity)
    {
      if (this.m_nodes[j].height >= 0)
      {
        localObject1 = this.m_nodes[j];
        if (((DynamicTreeNode)localObject1).isLeaf())
        {
          ((DynamicTreeNode)localObject1).parent = null;
          arrayOfInt[i] = j;
          i += 1;
        }
        else
        {
          freeNode((DynamicTreeNode)localObject1);
        }
      }
      j += 1;
    }
    Object localObject1 = new AABB();
    int n = i;
    while (n > 1)
    {
      j = -1;
      i = 0;
      int k = -1;
      float f1 = 3.4028235E+38F;
      while (i < n)
      {
        localAABB = this.m_nodes[arrayOfInt[i]].aabb;
        int i1 = i + 1;
        m = j;
        j = i1;
        while (j < n)
        {
          ((AABB)localObject1).combine(localAABB, this.m_nodes[arrayOfInt[j]].aabb);
          float f3 = ((AABB)localObject1).getPerimeter();
          float f2 = f1;
          if (f3 < f1)
          {
            m = i;
            k = j;
            f2 = f3;
          }
          j += 1;
          f1 = f2;
        }
        j = m;
        i = i1;
      }
      i = arrayOfInt[j];
      int m = arrayOfInt[k];
      Object localObject2 = this.m_nodes;
      AABB localAABB = localObject2[i];
      localObject2 = localObject2[m];
      DynamicTreeNode localDynamicTreeNode = allocateNode();
      localDynamicTreeNode.child1 = localAABB;
      localDynamicTreeNode.child2 = ((DynamicTreeNode)localObject2);
      localDynamicTreeNode.height = (MathUtils.max(localAABB.height, ((DynamicTreeNode)localObject2).height) + 1);
      localDynamicTreeNode.aabb.combine(localAABB.aabb, ((DynamicTreeNode)localObject2).aabb);
      localDynamicTreeNode.parent = null;
      localAABB.parent = localDynamicTreeNode;
      ((DynamicTreeNode)localObject2).parent = localDynamicTreeNode;
      arrayOfInt[k] = arrayOfInt[(n - 1)];
      arrayOfInt[j] = localDynamicTreeNode.id;
      n -= 1;
    }
    this.m_root = this.m_nodes[arrayOfInt[0]];
    validate();
  }
  
  public void validate()
  {
    validateStructure(this.m_root);
    validateMetrics(this.m_root);
    int i = this.m_freeList;
    if (i != -1) {
      localDynamicTreeNode = this.m_nodes[i];
    }
    for (DynamicTreeNode localDynamicTreeNode = null; localDynamicTreeNode != null; localDynamicTreeNode = localDynamicTreeNode.parent) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.collision.broadphase.DynamicTree
 * JD-Core Version:    0.7.0.1
 */