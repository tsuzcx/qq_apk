package org.jbox2d.collision.broadphase;

import java.util.Arrays;
import org.jbox2d.callbacks.DebugDraw;
import org.jbox2d.callbacks.PairCallback;
import org.jbox2d.callbacks.TreeCallback;
import org.jbox2d.callbacks.TreeRayCastCallback;
import org.jbox2d.collision.AABB;
import org.jbox2d.collision.RayCastInput;
import org.jbox2d.common.Vec2;

public class BroadPhase
  implements TreeCallback
{
  public static final int NULL_PROXY = -1;
  private int[] m_moveBuffer;
  private int m_moveCapacity;
  private int m_moveCount;
  private Pair[] m_pairBuffer = new Pair[this.m_pairCapacity];
  private int m_pairCapacity = 16;
  private int m_pairCount = 0;
  private int m_proxyCount = 0;
  private int m_queryProxyId;
  private final BroadPhaseStrategy m_tree;
  
  public BroadPhase(BroadPhaseStrategy paramBroadPhaseStrategy)
  {
    int i = 0;
    while (i < this.m_pairCapacity)
    {
      this.m_pairBuffer[i] = new Pair();
      i += 1;
    }
    this.m_moveCapacity = 16;
    this.m_moveCount = 0;
    this.m_moveBuffer = new int[this.m_moveCapacity];
    this.m_tree = paramBroadPhaseStrategy;
    this.m_queryProxyId = -1;
  }
  
  protected final void bufferMove(int paramInt)
  {
    int i = this.m_moveCount;
    int j = this.m_moveCapacity;
    if (i == j)
    {
      arrayOfInt = this.m_moveBuffer;
      this.m_moveCapacity = (j * 2);
      this.m_moveBuffer = new int[this.m_moveCapacity];
      System.arraycopy(arrayOfInt, 0, this.m_moveBuffer, 0, arrayOfInt.length);
    }
    int[] arrayOfInt = this.m_moveBuffer;
    i = this.m_moveCount;
    arrayOfInt[i] = paramInt;
    this.m_moveCount = (i + 1);
  }
  
  public final int createProxy(AABB paramAABB, Object paramObject)
  {
    int i = this.m_tree.createProxy(paramAABB, paramObject);
    this.m_proxyCount += 1;
    bufferMove(i);
    return i;
  }
  
  public final void destroyProxy(int paramInt)
  {
    unbufferMove(paramInt);
    this.m_proxyCount -= 1;
    this.m_tree.destroyProxy(paramInt);
  }
  
  public void drawTree(DebugDraw paramDebugDraw)
  {
    this.m_tree.drawTree(paramDebugDraw);
  }
  
  public AABB getFatAABB(int paramInt)
  {
    return this.m_tree.getFatAABB(paramInt);
  }
  
  public final int getProxyCount()
  {
    return this.m_proxyCount;
  }
  
  public int getTreeBalance()
  {
    return this.m_tree.getMaxBalance();
  }
  
  public final int getTreeHeight()
  {
    return this.m_tree.computeHeight();
  }
  
  public float getTreeQuality()
  {
    return this.m_tree.getAreaRatio();
  }
  
  public Object getUserData(int paramInt)
  {
    return this.m_tree.getUserData(paramInt);
  }
  
  public final void moveProxy(int paramInt, AABB paramAABB, Vec2 paramVec2)
  {
    if (this.m_tree.moveProxy(paramInt, paramAABB, paramVec2)) {
      bufferMove(paramInt);
    }
  }
  
  public final void query(TreeCallback paramTreeCallback, AABB paramAABB)
  {
    this.m_tree.query(paramTreeCallback, paramAABB);
  }
  
  public final void raycast(TreeRayCastCallback paramTreeRayCastCallback, RayCastInput paramRayCastInput)
  {
    this.m_tree.raycast(paramTreeRayCastCallback, paramRayCastInput);
  }
  
  public boolean testOverlap(int paramInt1, int paramInt2)
  {
    AABB localAABB1 = this.m_tree.getFatAABB(paramInt1);
    AABB localAABB2 = this.m_tree.getFatAABB(paramInt2);
    if (localAABB2.lowerBound.x - localAABB1.upperBound.x <= 0.0F)
    {
      if (localAABB2.lowerBound.y - localAABB1.upperBound.y > 0.0F) {
        return false;
      }
      if (localAABB1.lowerBound.x - localAABB2.upperBound.x <= 0.0F) {
        return localAABB1.lowerBound.y - localAABB2.upperBound.y <= 0.0F;
      }
    }
    return false;
  }
  
  public void touchProxy(int paramInt)
  {
    bufferMove(paramInt);
  }
  
  public final boolean treeCallback(int paramInt)
  {
    if (paramInt == this.m_queryProxyId) {
      return true;
    }
    int i = this.m_pairCount;
    int j = this.m_pairCapacity;
    Pair[] arrayOfPair;
    if (i == j)
    {
      arrayOfPair = this.m_pairBuffer;
      this.m_pairCapacity = (j * 2);
      this.m_pairBuffer = new Pair[this.m_pairCapacity];
      System.arraycopy(arrayOfPair, 0, this.m_pairBuffer, 0, arrayOfPair.length);
      i = arrayOfPair.length;
      while (i < this.m_pairCapacity)
      {
        this.m_pairBuffer[i] = new Pair();
        i += 1;
      }
    }
    i = this.m_queryProxyId;
    if (paramInt < i)
    {
      arrayOfPair = this.m_pairBuffer;
      j = this.m_pairCount;
      arrayOfPair[j].proxyIdA = paramInt;
      arrayOfPair[j].proxyIdB = i;
    }
    else
    {
      arrayOfPair = this.m_pairBuffer;
      j = this.m_pairCount;
      arrayOfPair[j].proxyIdA = i;
      arrayOfPair[j].proxyIdB = paramInt;
    }
    this.m_pairCount += 1;
    return true;
  }
  
  protected final void unbufferMove(int paramInt)
  {
    int i = 0;
    while (i < this.m_moveCount)
    {
      int[] arrayOfInt = this.m_moveBuffer;
      if (arrayOfInt[i] == paramInt) {
        arrayOfInt[i] = -1;
      }
      i += 1;
    }
  }
  
  public final void updatePairs(PairCallback paramPairCallback)
  {
    int j = 0;
    this.m_pairCount = 0;
    int i = 0;
    Object localObject;
    while (i < this.m_moveCount)
    {
      this.m_queryProxyId = this.m_moveBuffer[i];
      int k = this.m_queryProxyId;
      if (k != -1)
      {
        localObject = this.m_tree.getFatAABB(k);
        this.m_tree.query(this, (AABB)localObject);
      }
      i += 1;
    }
    this.m_moveCount = 0;
    Arrays.sort(this.m_pairBuffer, 0, this.m_pairCount);
    i = j;
    while (i < this.m_pairCount)
    {
      localObject = this.m_pairBuffer[i];
      paramPairCallback.addPair(this.m_tree.getUserData(((Pair)localObject).proxyIdA), this.m_tree.getUserData(((Pair)localObject).proxyIdB));
      Pair localPair;
      do
      {
        j = i + 1;
        i = j;
        if (j >= this.m_pairCount) {
          break;
        }
        localPair = this.m_pairBuffer[j];
        i = j;
        if (localPair.proxyIdA != ((Pair)localObject).proxyIdA) {
          break;
        }
        i = j;
      } while (localPair.proxyIdB == ((Pair)localObject).proxyIdB);
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.collision.broadphase.BroadPhase
 * JD-Core Version:    0.7.0.1
 */