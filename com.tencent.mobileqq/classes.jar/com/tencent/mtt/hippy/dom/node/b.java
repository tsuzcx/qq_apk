package com.tencent.mtt.hippy.dom.node;

import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.smtt.flexbox.FlexNode;

public class b
  extends FlexNode
{
  private int mID;
  private boolean mIsJustLayout = false;
  boolean mIsLazy = false;
  float mLastHeight;
  float mLastWidth;
  float mLastX;
  float mLastY;
  private boolean mNodeUpdated = true;
  boolean mShouldNotifyOnlayout = false;
  HippyMap mTotalProps = null;
  private String mViewClassName;
  
  public void addChildAt(FlexNode paramFlexNode, int paramInt)
  {
    super.addChildAt(paramFlexNode, paramInt);
    markUpdated();
  }
  
  public void dirty()
  {
    if (!isVirtual()) {
      super.dirty();
    }
  }
  
  public b getChildAt(int paramInt)
  {
    return (b)super.getChildAt(paramInt);
  }
  
  public final int getId()
  {
    return this.mID;
  }
  
  public b getParent()
  {
    return (b)super.getParent();
  }
  
  public HippyMap getTotalProps()
  {
    return this.mTotalProps;
  }
  
  public final String getViewClass()
  {
    return this.mViewClassName;
  }
  
  public final boolean hasUpdates()
  {
    return (this.mNodeUpdated) || (hasNewLayout()) || (isDirty());
  }
  
  public boolean isJustLayout()
  {
    return this.mIsJustLayout;
  }
  
  public boolean isLazy()
  {
    return this.mIsLazy;
  }
  
  public boolean isVirtual()
  {
    return false;
  }
  
  public void layoutAfter(HippyEngineContext paramHippyEngineContext) {}
  
  public void layoutBefore(HippyEngineContext paramHippyEngineContext) {}
  
  public final void markUpdateSeen()
  {
    this.mNodeUpdated = false;
    if (hasNewLayout()) {
      markLayoutSeen();
    }
  }
  
  public void markUpdated()
  {
    if (this.mNodeUpdated) {}
    b localb;
    do
    {
      return;
      this.mNodeUpdated = true;
      localb = getParent();
    } while (localb == null);
    localb.markUpdated();
  }
  
  public b removeChildAt(int paramInt)
  {
    b localb = (b)super.removeChildAt(paramInt);
    markUpdated();
    return localb;
  }
  
  public void setDefaultPadding(int paramInt, float paramFloat)
  {
    super.setPadding(paramInt, paramFloat);
  }
  
  public void setId(int paramInt)
  {
    this.mID = paramInt;
  }
  
  public void setIsJustLayout(boolean paramBoolean)
  {
    this.mIsJustLayout = paramBoolean;
  }
  
  public void setLazy(boolean paramBoolean)
  {
    this.mIsLazy = paramBoolean;
  }
  
  public void setProps(HippyMap paramHippyMap)
  {
    this.mTotalProps = paramHippyMap;
  }
  
  public void setShouldNotifyOnLayout(boolean paramBoolean)
  {
    this.mShouldNotifyOnlayout = paramBoolean;
  }
  
  public void setViewClassName(String paramString)
  {
    this.mViewClassName = paramString;
  }
  
  public boolean shouldNotifyOnLayout()
  {
    return this.mShouldNotifyOnlayout;
  }
  
  public boolean shouldUpdateLayout(float paramFloat1, float paramFloat2)
  {
    if ((this.mLastX != paramFloat1) || (this.mLastY != paramFloat2) || (this.mLastWidth != getLayoutWidth()) || (this.mLastHeight != getLayoutHeight())) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        this.mLastX = paramFloat1;
        this.mLastY = paramFloat2;
        this.mLastWidth = getLayoutWidth();
        this.mLastHeight = getLayoutHeight();
      }
      return bool;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    toStringWithIndentation(localStringBuilder, 0);
    return localStringBuilder.toString();
  }
  
  public void toStringWithIndentation(StringBuilder paramStringBuilder, int paramInt)
  {
    int j = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramInt)
    {
      localStringBuilder.append("__");
      i += 1;
    }
    paramStringBuilder.append(localStringBuilder.toString());
    paramStringBuilder.append("id:" + getId());
    paramStringBuilder.append(" className:" + getViewClass() + " ");
    paramStringBuilder.append(resultToString());
    if (getChildCount() == 0) {
      return;
    }
    paramStringBuilder.append(", children: [\n");
    i = j;
    while (i < getChildCount())
    {
      getChildAt(i).toStringWithIndentation(paramStringBuilder, paramInt + 1);
      paramStringBuilder.append("\n");
      i += 1;
    }
    paramStringBuilder.append(localStringBuilder + "]");
  }
  
  public void updateProps(HippyMap paramHippyMap) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.dom.node.b
 * JD-Core Version:    0.7.0.1
 */