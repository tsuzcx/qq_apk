package com.tencent.smtt.flexbox;

import com.tencent.mtt.hippy.dom.a.b;
import com.tencent.mtt.hippy.dom.a.d;
import com.tencent.mtt.hippy.dom.a.e;
import com.tencent.mtt.hippy.dom.a.f;
import com.tencent.mtt.hippy.dom.a.g;
import com.tencent.mtt.hippy.dom.a.g.a;
import com.tencent.mtt.hippy.dom.a.i;
import com.tencent.mtt.hippy.dom.a.j;
import com.tencent.mtt.hippy.dom.a.k;
import com.tencent.mtt.hippy.dom.a.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FlexNode
  implements g<FlexNode>
{
  private static final int BORDER = 4;
  private static final int MARGIN = 1;
  private static final int PADDING = 2;
  private float mBorderBottom = 0.0F;
  private float mBorderLeft = 0.0F;
  private float mBorderRight = 0.0F;
  private float mBorderTop = 0.0F;
  private List<FlexNode> mChildren;
  private Object mData;
  private boolean mDirty = true;
  private int mEdgeSetFlag = 0;
  protected FlexNodeStyle mFlexNodeStyle = null;
  private boolean mHasNewLayout = true;
  private boolean mHasSetPosition = false;
  private float mHeight = (0.0F / 0.0F);
  private float mLeft = (0.0F / 0.0F);
  private float mMarginBottom = 0.0F;
  private float mMarginLeft = 0.0F;
  private float mMarginRight = 0.0F;
  private float mMarginTop = 0.0F;
  private g.a mMeasureFunction = null;
  private long mNativeFlexNode = nativeFlexNodeNew();
  private float mPaddingBottom = 0.0F;
  private float mPaddingLeft = 0.0F;
  private float mPaddingRight = 0.0F;
  private float mPaddingTop = 0.0F;
  private FlexNode mParent;
  private float mTop = (0.0F / 0.0F);
  private float mWidth = (0.0F / 0.0F);
  
  static
  {
    com.tencent.mtt.hippy.bridge.a.a.a("flexbox");
  }
  
  public FlexNode()
  {
    if (this.mNativeFlexNode == 0L) {
      throw new IllegalStateException("Failed to allocate native memory");
    }
    this.mFlexNodeStyle = new FlexNodeStyle(this.mNativeFlexNode);
    reset();
  }
  
  private int TotalChildCount()
  {
    if (this.mChildren == null) {
      return 0;
    }
    int j = getChildCount();
    int i = 0;
    while (i < this.mChildren.size())
    {
      j += ((FlexNode)this.mChildren.get(i)).TotalChildCount();
      i += 1;
    }
    return j;
  }
  
  private int TotalDirtyChildCount()
  {
    if (this.mChildren == null) {
      return 0;
    }
    int j = getDirtyChildCount();
    int i = 0;
    while (i < this.mChildren.size())
    {
      j += ((FlexNode)this.mChildren.get(i)).TotalDirtyChildCount();
      i += 1;
    }
    return j;
  }
  
  private long measureFunc(float paramFloat1, int paramInt1, float paramFloat2, int paramInt2)
  {
    return measure(paramFloat1, paramInt1, paramFloat2, paramInt2);
  }
  
  private native void nativeFlexNodeCalculateLayout(long paramLong, float paramFloat1, float paramFloat2, long[] paramArrayOfLong, FlexNode[] paramArrayOfFlexNode, int paramInt);
  
  private native void nativeFlexNodeFree(long paramLong);
  
  private native float nativeFlexNodeGetBorderBottom(long paramLong);
  
  private native float nativeFlexNodeGetBorderLeft(long paramLong);
  
  private native float nativeFlexNodeGetBorderRight(long paramLong);
  
  private native float nativeFlexNodeGetBorderTop(long paramLong);
  
  private native float nativeFlexNodeGetBottom(long paramLong);
  
  private native float nativeFlexNodeGetHeight(long paramLong);
  
  private native float nativeFlexNodeGetLeft(long paramLong);
  
  private native float nativeFlexNodeGetMarginBottom(long paramLong);
  
  private native float nativeFlexNodeGetMarginLeft(long paramLong);
  
  private native float nativeFlexNodeGetMarginRight(long paramLong);
  
  private native float nativeFlexNodeGetMarginTop(long paramLong);
  
  private native float nativeFlexNodeGetPaddingBottom(long paramLong);
  
  private native float nativeFlexNodeGetPaddingLeft(long paramLong);
  
  private native float nativeFlexNodeGetPaddingRight(long paramLong);
  
  private native float nativeFlexNodeGetPaddingTop(long paramLong);
  
  private native float nativeFlexNodeGetRight(long paramLong);
  
  private native float nativeFlexNodeGetTop(long paramLong);
  
  private native float nativeFlexNodeGetWidth(long paramLong);
  
  private native void nativeFlexNodeInsertChild(long paramLong1, long paramLong2, int paramInt);
  
  private native long nativeFlexNodeNew();
  
  private native boolean nativeFlexNodeNodeIsDirty(long paramLong);
  
  private native void nativeFlexNodeNodeMarkDirty(long paramLong);
  
  private native void nativeFlexNodeNodeSetHasBaselineFunc(long paramLong, boolean paramBoolean);
  
  private native void nativeFlexNodeNodeSetHasMeasureFunc(long paramLong, boolean paramBoolean);
  
  private native void nativeFlexNodeRemoveChild(long paramLong1, long paramLong2);
  
  private native void nativeFlexNodeSetBorderBottom(long paramLong, float paramFloat);
  
  private native void nativeFlexNodeSetBorderLeft(long paramLong, float paramFloat);
  
  private native void nativeFlexNodeSetBorderRight(long paramLong, float paramFloat);
  
  private native void nativeFlexNodeSetBorderTop(long paramLong, float paramFloat);
  
  private native void nativeFlexNodeSetBottom(long paramLong, float paramFloat);
  
  private native void nativeFlexNodeSetHeight(long paramLong, float paramFloat);
  
  private native void nativeFlexNodeSetLeft(long paramLong, float paramFloat);
  
  private native void nativeFlexNodeSetMarginBottom(long paramLong, float paramFloat);
  
  private native void nativeFlexNodeSetMarginLeft(long paramLong, float paramFloat);
  
  private native void nativeFlexNodeSetMarginRight(long paramLong, float paramFloat);
  
  private native void nativeFlexNodeSetMarginTop(long paramLong, float paramFloat);
  
  private native void nativeFlexNodeSetPaddingBottom(long paramLong, float paramFloat);
  
  private native void nativeFlexNodeSetPaddingLeft(long paramLong, float paramFloat);
  
  private native void nativeFlexNodeSetPaddingRight(long paramLong, float paramFloat);
  
  private native void nativeFlexNodeSetPaddingTop(long paramLong, float paramFloat);
  
  private native void nativeFlexNodeSetRight(long paramLong, float paramFloat);
  
  private native void nativeFlexNodeSetTop(long paramLong, float paramFloat);
  
  private native void nativeFlexNodeSetWidth(long paramLong, float paramFloat);
  
  private native boolean nativeFlexNodehasNewLayout(long paramLong);
  
  private native void nativeFlexNodemarkHasNewLayout(long paramLong);
  
  private native void nativeFlexNodemarkLayoutSeen(long paramLong);
  
  private native void nativeFlexNodereset(long paramLong);
  
  public FlexNodeStyle Style()
  {
    return this.mFlexNodeStyle;
  }
  
  public void addChildAt(FlexNode paramFlexNode, int paramInt)
  {
    if (paramFlexNode.mParent != null) {
      throw new IllegalStateException("Child already has a parent, it must be removed first.");
    }
    if (this.mChildren == null) {
      this.mChildren = new ArrayList(4);
    }
    this.mChildren.add(paramInt, paramFlexNode);
    paramFlexNode.mParent = this;
    nativeFlexNodeInsertChild(this.mNativeFlexNode, paramFlexNode.mNativeFlexNode, paramInt);
  }
  
  public void calculateLayout()
  {
    calculateLayout((0.0F / 0.0F), (0.0F / 0.0F), getStyleDirection());
  }
  
  public void calculateLayout(float paramFloat1, float paramFloat2, d paramd)
  {
    int j = 0;
    Object localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(this);
    int i = 0;
    while (i < ((ArrayList)localObject1).size())
    {
      localObject2 = ((FlexNode)((ArrayList)localObject1).get(i)).mChildren;
      if (localObject2 != null) {
        ((ArrayList)localObject1).addAll((Collection)localObject2);
      }
      i += 1;
    }
    localObject1 = (FlexNode[])((ArrayList)localObject1).toArray(new FlexNode[((ArrayList)localObject1).size()]);
    Object localObject2 = new long[localObject1.length];
    i = j;
    while (i < localObject1.length)
    {
      localObject2[i] = localObject1[i].mNativeFlexNode;
      i += 1;
    }
    nativeFlexNodeCalculateLayout(this.mNativeFlexNode, paramFloat1, paramFloat2, (long[])localObject2, (FlexNode[])localObject1, paramd.ordinal());
  }
  
  public void dirty()
  {
    nativeFlexNodeNodeMarkDirty(this.mNativeFlexNode);
  }
  
  protected void finalize()
  {
    try
    {
      nativeFlexNodeFree(this.mNativeFlexNode);
      this.mFlexNodeStyle = null;
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public com.tencent.mtt.hippy.dom.a.a getAlignContent()
  {
    return Style().f();
  }
  
  public com.tencent.mtt.hippy.dom.a.a getAlignItems()
  {
    return Style().d();
  }
  
  public com.tencent.mtt.hippy.dom.a.a getAlignSelf()
  {
    return Style().e();
  }
  
  public float getBorder(int paramInt)
  {
    switch (FlexNode.1.a[FlexNodeStyle.b.a(paramInt).ordinal()])
    {
    default: 
      return Style().c(FlexNodeStyle.b.a(paramInt)).a();
    case 1: 
    case 2: 
      return this.mBorderLeft;
    case 3: 
      return this.mBorderTop;
    case 4: 
    case 5: 
      return this.mBorderRight;
    }
    return this.mBorderBottom;
  }
  
  public FlexNode getChildAt(int paramInt)
  {
    return (FlexNode)this.mChildren.get(paramInt);
  }
  
  public int getChildCount()
  {
    if (this.mChildren == null) {
      return 0;
    }
    return this.mChildren.size();
  }
  
  public Object getData()
  {
    return this.mData;
  }
  
  public d getDirection()
  {
    return Style().a();
  }
  
  public int getDirtyChildCount()
  {
    if (this.mChildren == null) {
      return 0;
    }
    int i = 0;
    int k;
    for (int j = 0; i < this.mChildren.size(); j = k)
    {
      k = j;
      if (((FlexNode)this.mChildren.get(i)).isDirty()) {
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  public float getFlexBasis()
  {
    return Style().l().a();
  }
  
  public b getFlexDirection()
  {
    return Style().b();
  }
  
  public float getFlexGrow()
  {
    return Style().j();
  }
  
  public float getFlexShrink()
  {
    return Style().k();
  }
  
  public e getJustifyContent()
  {
    return Style().c();
  }
  
  public d getLayoutDirection()
  {
    return Style().a();
  }
  
  public float getLayoutHeight()
  {
    return this.mHeight;
  }
  
  public float getLayoutWidth()
  {
    return this.mWidth;
  }
  
  public float getLayoutX()
  {
    return this.mLeft;
  }
  
  public float getLayoutY()
  {
    return this.mTop;
  }
  
  public float getMargin(int paramInt)
  {
    switch (FlexNode.1.a[FlexNodeStyle.b.a(paramInt).ordinal()])
    {
    default: 
      return Style().a(FlexNodeStyle.b.a(paramInt)).a();
    case 1: 
    case 2: 
      return this.mMarginLeft;
    case 3: 
      return this.mMarginTop;
    case 4: 
    case 5: 
      return this.mMarginRight;
    }
    return this.mMarginBottom;
  }
  
  public i getOverflow()
  {
    return Style().i();
  }
  
  public float getPadding(int paramInt)
  {
    switch (FlexNode.1.a[FlexNodeStyle.b.a(paramInt).ordinal()])
    {
    default: 
      return Style().b(FlexNodeStyle.b.a(paramInt)).a();
    case 1: 
    case 2: 
      return this.mPaddingLeft;
    case 3: 
      return this.mPaddingTop;
    case 4: 
    case 5: 
      return this.mPaddingRight;
    }
    return this.mPaddingBottom;
  }
  
  public FlexNode getParent()
  {
    return this.mParent;
  }
  
  public float getPosition(int paramInt)
  {
    return Style().d(FlexNodeStyle.b.a(paramInt)).a();
  }
  
  public j getPositionType()
  {
    return Style().g();
  }
  
  public d getStyleDirection()
  {
    return Style().a();
  }
  
  public float getStyleHeight()
  {
    return Style().n().a();
  }
  
  public float getStyleMaxHeight()
  {
    return Style().r().a();
  }
  
  public float getStyleMaxWidth()
  {
    return Style().q().a();
  }
  
  public float getStyleMinHeight()
  {
    return Style().p().a();
  }
  
  public float getStyleMinWidth()
  {
    return Style().o().a();
  }
  
  public float getStyleWidth()
  {
    return Style().m().a();
  }
  
  public boolean hasNewLayout()
  {
    return this.mHasNewLayout;
  }
  
  public int indexOf(FlexNode paramFlexNode)
  {
    if (this.mChildren == null) {
      return -1;
    }
    return this.mChildren.indexOf(paramFlexNode);
  }
  
  public boolean isDirty()
  {
    return nativeFlexNodeNodeIsDirty(this.mNativeFlexNode);
  }
  
  public boolean isMeasureDefined()
  {
    return this.mMeasureFunction != null;
  }
  
  public void markLayoutSeen()
  {
    this.mHasNewLayout = false;
    nativeFlexNodemarkLayoutSeen(this.mNativeFlexNode);
  }
  
  public final long measure(float paramFloat1, int paramInt1, float paramFloat2, int paramInt2)
  {
    if (!isMeasureDefined()) {
      throw new RuntimeException("Measure function isn't defined!");
    }
    return this.mMeasureFunction.measure(this, paramFloat1, f.a(paramInt1), paramFloat2, f.a(paramInt2));
  }
  
  public FlexNode removeChildAt(int paramInt)
  {
    FlexNode localFlexNode = (FlexNode)this.mChildren.remove(paramInt);
    localFlexNode.mParent = null;
    nativeFlexNodeRemoveChild(this.mNativeFlexNode, localFlexNode.mNativeFlexNode);
    return localFlexNode;
  }
  
  public void reset()
  {
    if ((this.mParent != null) || ((this.mChildren != null) && (this.mChildren.size() > 0))) {
      return;
    }
    nativeFlexNodereset(this.mNativeFlexNode);
    setDirection(d.b);
    setFlexDirection(b.c);
    setJustifyContent(e.a);
    setAlignContent(com.tencent.mtt.hippy.dom.a.a.b);
    setAlignItems(com.tencent.mtt.hippy.dom.a.a.e);
    setAlignSelf(com.tencent.mtt.hippy.dom.a.a.a);
    setPositionType(j.a);
    setWrap(k.a);
    setOverflow(i.a);
    setFlexGrow(0.0F);
    setFlexShrink(0.0F);
    setFlexBasis((0.0F / 0.0F));
    this.mMeasureFunction = null;
    this.mEdgeSetFlag = 0;
    this.mHasSetPosition = false;
    this.mHasNewLayout = true;
    this.mWidth = (0.0F / 0.0F);
    this.mHeight = (0.0F / 0.0F);
    this.mTop = (0.0F / 0.0F);
    this.mLeft = (0.0F / 0.0F);
    this.mMarginLeft = 0.0F;
    this.mMarginTop = 0.0F;
    this.mMarginRight = 0.0F;
    this.mMarginBottom = 0.0F;
    this.mPaddingLeft = 0.0F;
    this.mPaddingTop = 0.0F;
    this.mPaddingRight = 0.0F;
    this.mPaddingBottom = 0.0F;
    this.mBorderLeft = 0.0F;
    this.mBorderTop = 0.0F;
    this.mBorderRight = 0.0F;
    this.mBorderBottom = 0.0F;
  }
  
  protected String resultToString()
  {
    return "layout: {left: " + getLayoutX() + ", top: " + getLayoutY() + ", width: " + getLayoutWidth() + ", height: " + getLayoutHeight() + ", }";
  }
  
  public void setAlignContent(com.tencent.mtt.hippy.dom.a.a parama)
  {
    Style().c(parama);
  }
  
  public void setAlignItems(com.tencent.mtt.hippy.dom.a.a parama)
  {
    Style().a(parama);
  }
  
  public void setAlignSelf(com.tencent.mtt.hippy.dom.a.a parama)
  {
    Style().b(parama);
  }
  
  public void setBorder(int paramInt, float paramFloat)
  {
    this.mEdgeSetFlag |= 0x4;
    Style().c(FlexNodeStyle.b.a(paramInt), paramFloat);
  }
  
  public void setData(Object paramObject)
  {
    this.mData = paramObject;
  }
  
  public void setDirection(d paramd)
  {
    Style().a(paramd);
  }
  
  public void setDisplay(FlexNodeStyle.a parama)
  {
    Style().a(parama);
  }
  
  public void setFlex(float paramFloat)
  {
    Style().a(paramFloat);
  }
  
  public void setFlexBasis(float paramFloat)
  {
    Style().d(paramFloat);
  }
  
  public void setFlexDirection(b paramb)
  {
    Style().a(paramb);
  }
  
  public void setFlexGrow(float paramFloat)
  {
    Style().b(paramFloat);
  }
  
  public void setFlexShrink(float paramFloat)
  {
    Style().c(paramFloat);
  }
  
  public void setJustifyContent(e parame)
  {
    Style().a(parame);
  }
  
  public void setMargin(int paramInt, float paramFloat)
  {
    this.mEdgeSetFlag |= 0x1;
    Style().a(FlexNodeStyle.b.a(paramInt), paramFloat);
  }
  
  public void setMeasureFunction(g.a parama)
  {
    this.mMeasureFunction = parama;
    long l = this.mNativeFlexNode;
    if (parama != null) {}
    for (boolean bool = true;; bool = false)
    {
      nativeFlexNodeNodeSetHasMeasureFunc(l, bool);
      return;
    }
  }
  
  public void setOverflow(i parami)
  {
    Style().a(parami);
  }
  
  public void setPadding(int paramInt, float paramFloat)
  {
    this.mEdgeSetFlag |= 0x2;
    Style().b(FlexNodeStyle.b.a(paramInt), paramFloat);
  }
  
  public void setPosition(int paramInt, float paramFloat)
  {
    this.mHasSetPosition = true;
    Style().d(FlexNodeStyle.b.a(paramInt), paramFloat);
  }
  
  public void setPositionType(j paramj)
  {
    Style().a(paramj);
  }
  
  public void setStyleHeight(float paramFloat)
  {
    Style().f(paramFloat);
  }
  
  public void setStyleMaxHeight(float paramFloat)
  {
    Style().j(paramFloat);
  }
  
  public void setStyleMaxWidth(float paramFloat)
  {
    Style().i(paramFloat);
  }
  
  public void setStyleMinHeight(float paramFloat)
  {
    Style().h(paramFloat);
  }
  
  public void setStyleMinWidth(float paramFloat)
  {
    Style().g(paramFloat);
  }
  
  public void setStyleWidth(float paramFloat)
  {
    Style().e(paramFloat);
  }
  
  public void setWrap(k paramk)
  {
    Style().a(paramk);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    toStringWithIndentation(localStringBuilder, 0);
    return localStringBuilder.toString();
  }
  
  protected void toStringWithIndentation(StringBuilder paramStringBuilder, int paramInt)
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
    paramStringBuilder.append(this.mFlexNodeStyle.toString());
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
  
  public boolean valuesEqual(float paramFloat1, float paramFloat2)
  {
    return l.a(paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.flexbox.FlexNode
 * JD-Core Version:    0.7.0.1
 */