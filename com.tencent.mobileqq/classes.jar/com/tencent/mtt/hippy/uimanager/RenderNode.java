package com.tencent.mtt.hippy.uimanager;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.utils.LogUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class RenderNode
{
  final List<RenderNode> mChildPendingList = new ArrayList();
  final List<RenderNode> mChildren = new ArrayList();
  final String mClassName;
  final ControllerManager mComponentManager;
  SparseArray<Integer> mDeletedIdIndexMap;
  public boolean mHasSetDteblId = false;
  boolean mHasUpdateLayout = false;
  int mHeight;
  final int mId;
  boolean mIsDelete = false;
  boolean mIsLazyLoad = false;
  boolean mIsRootHasDelete = false;
  List<Promise> mMeasureInWindows = null;
  List<RenderNode.a> mMoveHolders = null;
  boolean mNotifyManageChildren = false;
  RenderNode mParent = null;
  HippyMap mProps = null;
  HippyMap mPropsToUpdate;
  HippyRootView mRootView;
  Object mTextExtra;
  Object mTextExtraUpdate;
  List<RenderNode.b> mUIFunction = null;
  int mWidth;
  int mX;
  int mY;
  
  public RenderNode(int paramInt, HippyMap paramHippyMap, String paramString, HippyRootView paramHippyRootView, ControllerManager paramControllerManager, boolean paramBoolean)
  {
    this.mId = paramInt;
    this.mPropsToUpdate = paramHippyMap;
    this.mClassName = paramString;
    this.mRootView = paramHippyRootView;
    this.mComponentManager = paramControllerManager;
    this.mIsLazyLoad = paramBoolean;
    this.mProps = paramHippyMap;
  }
  
  public RenderNode(int paramInt, String paramString, ControllerManager paramControllerManager)
  {
    this.mId = paramInt;
    this.mClassName = paramString;
    this.mComponentManager = paramControllerManager;
  }
  
  private boolean shouldCreateView()
  {
    return (!this.mIsLazyLoad) && (!this.mComponentManager.a(this.mId));
  }
  
  private boolean shouldUpdateView()
  {
    return this.mComponentManager.a(this.mId);
  }
  
  void addChild(RenderNode paramRenderNode, int paramInt)
  {
    this.mChildren.add(paramInt, paramRenderNode);
    paramRenderNode.mParent = this;
  }
  
  protected void addChildToPendingList(RenderNode paramRenderNode)
  {
    this.mChildPendingList.add(paramRenderNode);
  }
  
  public void addDeleteId(int paramInt, RenderNode paramRenderNode)
  {
    if (shouldUpdateView())
    {
      if (this.mDeletedIdIndexMap == null) {
        this.mDeletedIdIndexMap = new SparseArray();
      }
      this.mDeletedIdIndexMap.put(paramInt, Integer.valueOf(this.mChildren.indexOf(paramRenderNode)));
    }
  }
  
  public void batchComplete()
  {
    if ((!this.mIsLazyLoad) && (!this.mIsDelete)) {
      this.mComponentManager.a(this.mClassName, this.mId);
    }
  }
  
  public View createView()
  {
    Object localObject = this.mDeletedIdIndexMap;
    if ((localObject != null) && (((SparseArray)localObject).size() > 0))
    {
      int i = 0;
      while (i < this.mDeletedIdIndexMap.size())
      {
        int j = this.mDeletedIdIndexMap.keyAt(i);
        this.mComponentManager.b(this.mId, this.mDeletedIdIndexMap.keyAt(i), ((Integer)this.mDeletedIdIndexMap.get(j)).intValue());
        i += 1;
      }
      this.mDeletedIdIndexMap.clear();
      this.mNotifyManageChildren = true;
    }
    if ((this.mIsDelete) && (TextUtils.equals("RootNode", this.mClassName)) && (!this.mIsRootHasDelete))
    {
      this.mIsRootHasDelete = true;
      this.mComponentManager.b(this.mId);
    }
    if ((shouldCreateView()) && (!TextUtils.equals("RootNode", this.mClassName)))
    {
      localObject = this.mParent;
      if (localObject != null)
      {
        this.mPropsToUpdate = null;
        ((RenderNode)localObject).addChildToPendingList(this);
        return this.mComponentManager.b(this.mRootView, this.mId, this.mClassName, this.mProps);
      }
    }
    return null;
  }
  
  public View createViewRecursive()
  {
    View localView = createView();
    this.mHasUpdateLayout = true;
    this.mTextExtraUpdate = this.mTextExtra;
    Iterator localIterator = this.mChildren.iterator();
    while (localIterator.hasNext()) {
      ((RenderNode)localIterator.next()).createViewRecursive();
    }
    return localView;
  }
  
  public void dispatchUIFunction(String paramString, HippyArray paramHippyArray, Promise paramPromise)
  {
    if (this.mUIFunction == null) {
      this.mUIFunction = new ArrayList();
    }
    this.mUIFunction.add(new RenderNode.b(this, paramString, paramHippyArray, paramPromise));
  }
  
  public RenderNode getChildAt(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getChildCount())) {
      return (RenderNode)this.mChildren.get(paramInt);
    }
    return null;
  }
  
  public int getChildCount()
  {
    return this.mChildren.size();
  }
  
  public String getClassName()
  {
    return this.mClassName;
  }
  
  public int getHeight()
  {
    return this.mHeight;
  }
  
  public int getId()
  {
    return this.mId;
  }
  
  public RenderNode getParent()
  {
    return this.mParent;
  }
  
  public HippyMap getProps()
  {
    return this.mProps;
  }
  
  public int getWidth()
  {
    return this.mWidth;
  }
  
  public int getX()
  {
    return this.mX;
  }
  
  public int getY()
  {
    return this.mY;
  }
  
  int indexFromParent()
  {
    RenderNode localRenderNode = this.mParent;
    if (localRenderNode != null) {
      return localRenderNode.mChildren.indexOf(this);
    }
    return 0;
  }
  
  public boolean isDelete()
  {
    return this.mIsDelete;
  }
  
  public boolean isIsLazyLoad()
  {
    return this.mIsLazyLoad;
  }
  
  public void manageChildrenComplete()
  {
    if ((!this.mIsLazyLoad) && (!this.mIsDelete)) {
      this.mComponentManager.b(this.mClassName, this.mId);
    }
  }
  
  public void measureInWindow(Promise paramPromise)
  {
    if (this.mMeasureInWindows == null) {
      this.mMeasureInWindows = new ArrayList();
    }
    this.mMeasureInWindows.add(paramPromise);
  }
  
  public void move(List<RenderNode> paramList, int paramInt)
  {
    if (shouldUpdateView())
    {
      if (this.mMoveHolders == null) {
        this.mMoveHolders = new ArrayList();
      }
      this.mMoveHolders.add(new RenderNode.a(this, paramList, paramInt));
    }
  }
  
  void printChild(RenderNode paramRenderNode, StringBuilder paramStringBuilder)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" [Id:");
    localStringBuilder.append(paramRenderNode.getId());
    localStringBuilder.append(paramRenderNode.mClassName);
    paramStringBuilder.append(localStringBuilder.toString());
    paramRenderNode = paramRenderNode.mChildren.iterator();
    while (paramRenderNode.hasNext()) {
      printChild((RenderNode)paramRenderNode.next(), paramStringBuilder);
    }
    paramStringBuilder.append("]");
  }
  
  public void remove(int paramInt)
  {
    ((RenderNode)this.mChildren.remove(paramInt)).mParent = null;
  }
  
  public boolean removeChild(RenderNode paramRenderNode)
  {
    paramRenderNode.mParent = null;
    return this.mChildren.remove(paramRenderNode);
  }
  
  public void setDelete(boolean paramBoolean)
  {
    this.mIsDelete = paramBoolean;
  }
  
  void setLazy(RenderNode paramRenderNode, boolean paramBoolean)
  {
    paramRenderNode.mIsLazyLoad = paramBoolean;
    int i = 0;
    while (i < paramRenderNode.getChildCount())
    {
      setLazy(paramRenderNode.getChildAt(i), paramBoolean);
      i += 1;
    }
  }
  
  public void setLazy(boolean paramBoolean)
  {
    setLazy(this, paramBoolean);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    printChild(this, localStringBuilder);
    return localStringBuilder.toString();
  }
  
  public void update()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mId");
    ((StringBuilder)localObject).append(this.mId);
    ((StringBuilder)localObject).append(" updateStyle");
    LogUtils.d("UINode", ((StringBuilder)localObject).toString());
    if (shouldUpdateView())
    {
      int i;
      if (this.mChildPendingList.size() > 0)
      {
        Collections.sort(this.mChildPendingList, new RenderNode.1(this));
        i = 0;
        while (i < this.mChildPendingList.size())
        {
          localObject = (RenderNode)this.mChildPendingList.get(i);
          this.mComponentManager.c(this.mId, ((RenderNode)localObject).getId(), ((RenderNode)localObject).indexFromParent());
          i += 1;
        }
        this.mChildPendingList.clear();
        this.mNotifyManageChildren = true;
      }
      localObject = this.mPropsToUpdate;
      if (localObject != null)
      {
        this.mComponentManager.a(this.mId, this.mClassName, (HippyMap)localObject);
        this.mPropsToUpdate = null;
      }
      localObject = this.mMoveHolders;
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          RenderNode.a locala = (RenderNode.a)((Iterator)localObject).next();
          Collections.sort(locala.a, new RenderNode.2(this));
          i = 0;
          while (i < locala.a.size())
          {
            RenderNode localRenderNode = (RenderNode)locala.a.get(i);
            this.mComponentManager.a(localRenderNode.getId(), locala.b, localRenderNode.indexFromParent());
            i += 1;
          }
        }
        this.mMoveHolders = null;
      }
      if ((this.mHasUpdateLayout) && (!TextUtils.equals("RootNode", this.mClassName)))
      {
        this.mComponentManager.a(this.mClassName, this.mId, this.mX, this.mY, this.mWidth, this.mHeight);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("mId");
        ((StringBuilder)localObject).append(this.mId);
        ((StringBuilder)localObject).append(" updateLayout");
        LogUtils.d("UINode", ((StringBuilder)localObject).toString());
        this.mHasUpdateLayout = false;
      }
      localObject = this.mTextExtraUpdate;
      if (localObject != null)
      {
        this.mComponentManager.a(this.mId, this.mClassName, localObject);
        this.mTextExtraUpdate = null;
      }
      localObject = this.mUIFunction;
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        i = 0;
        while (i < this.mUIFunction.size())
        {
          localObject = (RenderNode.b)this.mUIFunction.get(i);
          this.mComponentManager.a(this.mId, this.mClassName, ((RenderNode.b)localObject).a, ((RenderNode.b)localObject).b, ((RenderNode.b)localObject).c);
          i += 1;
        }
        this.mUIFunction.clear();
        this.mUIFunction = null;
      }
      localObject = this.mMeasureInWindows;
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        i = 0;
        while (i < this.mMeasureInWindows.size())
        {
          localObject = (Promise)this.mMeasureInWindows.get(i);
          this.mComponentManager.a(this.mId, (Promise)localObject);
          i += 1;
        }
        this.mMeasureInWindows.clear();
        this.mMeasureInWindows = null;
      }
      if (this.mNotifyManageChildren)
      {
        manageChildrenComplete();
        this.mNotifyManageChildren = false;
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mId");
    ((StringBuilder)localObject).append(this.mId);
    ((StringBuilder)localObject).append(" end updateStyle");
    LogUtils.d("UINode", ((StringBuilder)localObject).toString());
  }
  
  public void updateExtra(Object paramObject)
  {
    this.mTextExtra = paramObject;
    this.mTextExtraUpdate = paramObject;
  }
  
  public void updateLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mX = paramInt1;
    this.mY = paramInt2;
    this.mWidth = paramInt3;
    this.mHeight = paramInt4;
    this.mHasUpdateLayout = true;
  }
  
  public void updateNode(HippyMap paramHippyMap)
  {
    Object localObject1 = this.mPropsToUpdate;
    if (localObject1 != null)
    {
      HippyMap localHippyMap2 = DiffUtils.diffProps((HippyMap)localObject1, paramHippyMap, 0);
      if ((localHippyMap2 != null) && (localHippyMap2.size() > 0))
      {
        Iterator localIterator = localHippyMap2.keySet().iterator();
        String str1;
        do
        {
          if (!localIterator.hasNext()) {
            break label210;
          }
          str1 = (String)localIterator.next();
          if (!TextUtils.equals("style", str1)) {
            break;
          }
          localHippyMap1 = localHippyMap2.getMap(str1);
        } while (localHippyMap1 == null);
        Object localObject2 = this.mPropsToUpdate.getMap(str1);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new HippyMap();
        }
        localObject2 = localHippyMap1.keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          String str2 = (String)((Iterator)localObject2).next();
          ((HippyMap)localObject1).pushObject(str2, localHippyMap1.get(str2));
        }
        HippyMap localHippyMap1 = this.mPropsToUpdate;
        localObject2 = localObject1;
        localObject1 = localHippyMap1;
        for (;;)
        {
          ((HippyMap)localObject1).pushObject(str1, localObject2);
          break;
          localObject1 = this.mPropsToUpdate;
          localObject2 = localHippyMap2.get(str1);
        }
      }
    }
    else
    {
      this.mPropsToUpdate = DiffUtils.diffProps(this.mProps, paramHippyMap, 0);
    }
    label210:
    this.mProps = paramHippyMap;
  }
  
  public void updateViewRecursive()
  {
    update();
    Iterator localIterator = this.mChildren.iterator();
    while (localIterator.hasNext()) {
      ((RenderNode)localIterator.next()).updateViewRecursive();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.uimanager.RenderNode
 * JD-Core Version:    0.7.0.1
 */