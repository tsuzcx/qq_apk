package com.tencent.viola.ui.dom.style;

import android.support.annotation.NonNull;
import com.tencent.viola.utils.ViolaLogUtils;
import com.tencent.viola.utils.ViolaUtils;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class FlexNode
{
  public static final Object LOCK = new Object();
  public static String TAG = "FlexNode";
  public final FlexLayout flexLayout = new FlexLayout();
  public final FlexStyle flexStyle = new FlexStyle();
  public final FlexLayoutCache lastLayout = new FlexLayoutCache();
  public int lineIndex = 0;
  private ArrayList<FlexNode> mChildren;
  private boolean mIsLayoutChanged = true;
  private AtomicReference<FlexNode.LayoutState> mLayoutStateAtomicReference = new AtomicReference(FlexNode.LayoutState.DIRTY);
  private FlexNode.MeasureFunction mMeasureFunction = null;
  private FlexNode mParent;
  protected String mRef;
  private boolean mShow = true;
  FlexNode nextAbsoluteChild;
  FlexNode nextFlexChild;
  FlexNode nextMinHeightChild;
  
  private void toStringWithIndentation(StringBuilder paramStringBuilder, int paramInt)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    int j = 0;
    int i = 0;
    while (i < paramInt)
    {
      localStringBuilder1.append("__");
      i += 1;
    }
    paramStringBuilder.append(localStringBuilder1.toString());
    paramStringBuilder.append(this.mRef);
    paramStringBuilder.append(this.flexLayout.toString());
    paramStringBuilder.append(this.flexStyle.toString());
    if (getChildCount() == 0) {
      return;
    }
    paramStringBuilder.append(", children: [\n");
    i = j;
    while (i < getChildCount())
    {
      if (getChildAt(i) != null) {
        getChildAt(i).toStringWithIndentation(paramStringBuilder, paramInt + 1);
      }
      paramStringBuilder.append("\n");
      i += 1;
    }
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(localStringBuilder1);
    localStringBuilder2.append("]");
    paramStringBuilder.append(localStringBuilder2.toString());
  }
  
  public void addChildAt(FlexNode paramFlexNode, int paramInt)
  {
    if (paramFlexNode.mParent == null)
    {
      if (this.mChildren == null) {
        this.mChildren = new ArrayList(4);
      }
      this.mChildren.add(paramInt, paramFlexNode);
      paramFlexNode.mParent = this;
      dirty();
      return;
    }
    throw new IllegalStateException("Child already has a parent, it must be removed first.");
  }
  
  public void calculateLayout(FlexLayoutContext paramFlexLayoutContext)
  {
    synchronized (LOCK)
    {
      this.flexLayout.resetResult();
      Layout.layoutNode(paramFlexLayoutContext, this, (0.0F / 0.0F), null);
      return;
    }
  }
  
  protected void dirty()
  {
    if (this.mLayoutStateAtomicReference.get() == FlexNode.LayoutState.DIRTY) {
      return;
    }
    if ((this.mLayoutStateAtomicReference.get() == FlexNode.LayoutState.HAS_NEW_LAYOUT) && (hasNewLayout())) {
      markLayoutSeen();
    }
    this.mLayoutStateAtomicReference.getAndSet(FlexNode.LayoutState.DIRTY);
    FlexNode localFlexNode = this.mParent;
    if ((localFlexNode != null) && (!localFlexNode.isDirty())) {
      this.mParent.dirty();
    }
  }
  
  public FlexAlign getAlignItems()
  {
    return this.flexStyle.alignItems;
  }
  
  public FlexAlign getAlignSelf()
  {
    return this.flexStyle.alignSelf;
  }
  
  @NonNull
  public StyleSpace getBorder()
  {
    return this.flexStyle.border;
  }
  
  public FlexNode getChildAt(int paramInt)
  {
    ArrayList localArrayList = this.mChildren;
    if ((localArrayList != null) && (localArrayList.size() > paramInt)) {
      return (FlexNode)this.mChildren.get(paramInt);
    }
    return null;
  }
  
  public int getChildCount()
  {
    ArrayList localArrayList = this.mChildren;
    if (localArrayList == null) {
      return 0;
    }
    return localArrayList.size();
  }
  
  public float getFlex()
  {
    return this.flexStyle.flex;
  }
  
  public FlexDirection getFlexDirection()
  {
    return this.flexStyle.flexDirection;
  }
  
  public FlexJustifyContent getJustifyContent()
  {
    return this.flexStyle.justifyContent;
  }
  
  public FlexLayoutDirection getLayoutDirection()
  {
    return this.flexLayout.direction;
  }
  
  public float getLayoutHeight()
  {
    return ViolaUtils.getFloatSafely(this.flexLayout.dimensions[1]);
  }
  
  public float getLayoutWidth()
  {
    return ViolaUtils.getFloatSafely(this.flexLayout.dimensions[0]);
  }
  
  public float getLayoutX()
  {
    return this.flexLayout.position[0];
  }
  
  public float getLayoutY()
  {
    return this.flexLayout.position[1];
  }
  
  @NonNull
  public StyleSpace getMargin()
  {
    return this.flexStyle.margin;
  }
  
  public float getMarginHorizontal()
  {
    if (!FlexConstants.isUndefined(this.flexStyle.margin.get(8))) {
      return ViolaUtils.getFloatSafely(this.flexStyle.margin.get(8)) * 2.0F;
    }
    return ViolaUtils.getFloatSafely(this.flexStyle.margin.get(0)) + ViolaUtils.getFloatSafely(this.flexStyle.margin.get(2));
  }
  
  public float getMarginVertical()
  {
    if (!FlexConstants.isUndefined(this.flexStyle.margin.get(8))) {
      return ViolaUtils.getFloatSafely(this.flexStyle.margin.get(8)) * 2.0F;
    }
    return ViolaUtils.getFloatSafely(this.flexStyle.margin.get(1)) + ViolaUtils.getFloatSafely(this.flexStyle.margin.get(3));
  }
  
  @NonNull
  public StyleSpace getPadding()
  {
    return this.flexStyle.padding;
  }
  
  public FlexNode getParent()
  {
    return this.mParent;
  }
  
  public float getPositionBottom()
  {
    return this.flexStyle.position[3];
  }
  
  public float getPositionLeft()
  {
    return this.flexStyle.position[0];
  }
  
  public float getPositionRight()
  {
    return this.flexStyle.position[2];
  }
  
  public float getPositionTop()
  {
    return this.flexStyle.position[1];
  }
  
  public FlexPositionType getPositionType()
  {
    return this.flexStyle.positionType;
  }
  
  public String getRef()
  {
    return this.mRef;
  }
  
  public FlexLayoutDirection getStyleDirection()
  {
    return this.flexStyle.direction;
  }
  
  public float getStyleHeight()
  {
    return this.flexStyle.dimensions[1];
  }
  
  public float getStyleWidth()
  {
    return this.flexStyle.dimensions[0];
  }
  
  public boolean hasNewLayout()
  {
    return this.mLayoutStateAtomicReference.get() == FlexNode.LayoutState.HAS_NEW_LAYOUT;
  }
  
  public int indexOf(FlexNode paramFlexNode)
  {
    return this.mChildren.indexOf(paramFlexNode);
  }
  
  public boolean isDirty()
  {
    return this.mLayoutStateAtomicReference.get() == FlexNode.LayoutState.DIRTY;
  }
  
  public boolean isLayoutChanged()
  {
    return this.mIsLayoutChanged;
  }
  
  public boolean isMeasureDefined()
  {
    return this.mMeasureFunction != null;
  }
  
  public boolean isShow()
  {
    return this.mShow;
  }
  
  public void markDirty()
  {
    try
    {
      dirty();
      return;
    }
    catch (Exception localException)
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("markDirty Exception e:");
      localStringBuilder.append(localException.getMessage());
      ViolaLogUtils.e(str, localStringBuilder.toString());
    }
  }
  
  void markHasNewLayout()
  {
    this.mLayoutStateAtomicReference.getAndSet(FlexNode.LayoutState.HAS_NEW_LAYOUT);
  }
  
  public void markLayoutSeen()
  {
    if (!hasNewLayout())
    {
      ViolaLogUtils.e(TAG, "Expected node to have a new csslayout to be seen!");
      return;
    }
    this.mLayoutStateAtomicReference.getAndSet(FlexNode.LayoutState.UP_TO_DATE);
  }
  
  public void markLayoutStateUpdated()
  {
    this.mLayoutStateAtomicReference.getAndSet(FlexNode.LayoutState.UP_TO_DATE);
  }
  
  protected MeasureOutput measure(MeasureOutput paramMeasureOutput, float paramFloat)
  {
    if (isMeasureDefined())
    {
      paramMeasureOutput.height = (0.0F / 0.0F);
      paramMeasureOutput.width = (0.0F / 0.0F);
      FlexNode.MeasureFunction localMeasureFunction = this.mMeasureFunction;
      if (localMeasureFunction != null) {
        localMeasureFunction.measure(this, paramFloat, paramMeasureOutput);
      }
      return paramMeasureOutput;
    }
    throw new RuntimeException("Measure function isn't defined!");
  }
  
  public FlexNode removeChildAt(int paramInt)
  {
    FlexNode localFlexNode = (FlexNode)this.mChildren.remove(paramInt);
    localFlexNode.mParent = null;
    dirty();
    return localFlexNode;
  }
  
  public void reset()
  {
    if (this.mParent == null)
    {
      ArrayList localArrayList = this.mChildren;
      if ((localArrayList == null) || (localArrayList.size() <= 0))
      {
        this.flexStyle.reset();
        this.flexLayout.resetResult();
        this.lineIndex = 0;
        this.mLayoutStateAtomicReference.getAndSet(FlexNode.LayoutState.DIRTY);
        return;
      }
    }
    ViolaLogUtils.e(TAG, "You should not reset an attached CSSNode!");
  }
  
  public void setAlignItems(FlexAlign paramFlexAlign)
  {
    if (this.flexStyle.alignItems != paramFlexAlign)
    {
      this.flexStyle.alignItems = paramFlexAlign;
      dirty();
    }
  }
  
  public void setAlignSelf(FlexAlign paramFlexAlign)
  {
    if (this.flexStyle.alignSelf != paramFlexAlign)
    {
      this.flexStyle.alignSelf = paramFlexAlign;
      dirty();
    }
  }
  
  public void setBorder(int paramInt, float paramFloat)
  {
    if (this.flexStyle.border.set(paramInt, paramFloat)) {
      dirty();
    }
  }
  
  public void setDefaultPadding(int paramInt, float paramFloat)
  {
    if (this.flexStyle.padding.setDefault(paramInt, paramFloat)) {
      dirty();
    }
  }
  
  public void setDirection(FlexLayoutDirection paramFlexLayoutDirection)
  {
    if (this.flexStyle.direction != paramFlexLayoutDirection)
    {
      this.flexStyle.direction = paramFlexLayoutDirection;
      dirty();
    }
  }
  
  public void setFlex(float paramFloat)
  {
    if (!valuesEqual(this.flexStyle.flex, paramFloat))
    {
      this.flexStyle.flex = paramFloat;
      dirty();
    }
  }
  
  public void setFlexDirection(FlexDirection paramFlexDirection)
  {
    if (this.flexStyle.flexDirection != paramFlexDirection)
    {
      this.flexStyle.flexDirection = paramFlexDirection;
      dirty();
    }
  }
  
  public void setJustifyContent(FlexJustifyContent paramFlexJustifyContent)
  {
    if (this.flexStyle.justifyContent != paramFlexJustifyContent)
    {
      this.flexStyle.justifyContent = paramFlexJustifyContent;
      dirty();
    }
  }
  
  public void setLayoutHeight(float paramFloat)
  {
    this.flexLayout.dimensions[1] = paramFloat;
  }
  
  public void setLayoutWidth(float paramFloat)
  {
    this.flexLayout.dimensions[0] = paramFloat;
  }
  
  public void setLayoutX(float paramFloat)
  {
    this.flexLayout.position[0] = paramFloat;
  }
  
  public void setLayoutY(float paramFloat)
  {
    this.flexLayout.position[1] = paramFloat;
  }
  
  public void setMargin(int paramInt, float paramFloat)
  {
    if (this.flexStyle.margin.set(paramInt, paramFloat)) {
      dirty();
    }
  }
  
  public void setMaxHeight(float paramFloat)
  {
    if (!valuesEqual(this.flexStyle.maxHeight, paramFloat))
    {
      this.flexStyle.maxHeight = paramFloat;
      dirty();
    }
  }
  
  public void setMaxWidth(float paramFloat)
  {
    if (!valuesEqual(this.flexStyle.maxWidth, paramFloat))
    {
      this.flexStyle.maxWidth = paramFloat;
      dirty();
    }
  }
  
  public void setMeasureFunction(FlexNode.MeasureFunction paramMeasureFunction)
  {
    if (this.mMeasureFunction != paramMeasureFunction)
    {
      this.mMeasureFunction = paramMeasureFunction;
      dirty();
    }
  }
  
  public void setMinHeight(float paramFloat)
  {
    if (!valuesEqual(this.flexStyle.minHeight, paramFloat))
    {
      FlexStyle localFlexStyle = this.flexStyle;
      localFlexStyle.minHeight = paramFloat;
      localFlexStyle.minDimensions[1] = paramFloat;
      dirty();
    }
  }
  
  public void setMinWidth(float paramFloat)
  {
    if (!valuesEqual(this.flexStyle.minWidth, paramFloat))
    {
      this.flexStyle.minWidth = paramFloat;
      dirty();
    }
  }
  
  public void setPadding(int paramInt, float paramFloat)
  {
    if (this.flexStyle.padding.set(paramInt, paramFloat)) {
      dirty();
    }
  }
  
  public void setParentNull()
  {
    this.mParent = null;
  }
  
  public void setPositionBottom(float paramFloat)
  {
    if (!valuesEqual(this.flexStyle.position[3], paramFloat))
    {
      this.flexStyle.position[3] = paramFloat;
      dirty();
    }
  }
  
  public void setPositionLeft(float paramFloat)
  {
    if (!valuesEqual(this.flexStyle.position[0], paramFloat))
    {
      this.flexStyle.position[0] = paramFloat;
      dirty();
    }
  }
  
  public void setPositionRight(float paramFloat)
  {
    if (!valuesEqual(this.flexStyle.position[2], paramFloat))
    {
      this.flexStyle.position[2] = paramFloat;
      dirty();
    }
  }
  
  public void setPositionTop(float paramFloat)
  {
    if (!valuesEqual(this.flexStyle.position[1], paramFloat))
    {
      this.flexStyle.position[1] = paramFloat;
      dirty();
    }
  }
  
  public void setPositionType(FlexPositionType paramFlexPositionType)
  {
    if (this.flexStyle.positionType != paramFlexPositionType)
    {
      this.flexStyle.positionType = paramFlexPositionType;
      dirty();
    }
  }
  
  public void setStyleHeight(float paramFloat)
  {
    if (!valuesEqual(this.flexStyle.dimensions[1], paramFloat))
    {
      this.flexStyle.dimensions[1] = paramFloat;
      dirty();
    }
  }
  
  public void setStyleWidth(float paramFloat)
  {
    if (!valuesEqual(this.flexStyle.dimensions[0], paramFloat))
    {
      this.flexStyle.dimensions[0] = paramFloat;
      dirty();
    }
  }
  
  public void setVisible(boolean paramBoolean)
  {
    if ((!this.mShow) && (paramBoolean)) {
      this.mLayoutStateAtomicReference.getAndSet(FlexNode.LayoutState.UP_TO_DATE);
    }
    this.mShow = paramBoolean;
    dirty();
  }
  
  public void setWrap(FlexWrap paramFlexWrap)
  {
    if (this.flexStyle.flexWrap != paramFlexWrap)
    {
      this.flexStyle.flexWrap = paramFlexWrap;
      dirty();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    toStringWithIndentation(localStringBuilder, 0);
    return localStringBuilder.toString();
  }
  
  public boolean updateLastLayout(FlexLayout paramFlexLayout)
  {
    this.mIsLayoutChanged = (this.lastLayout.equals(paramFlexLayout) ^ true);
    if (this.mIsLayoutChanged) {
      this.lastLayout.copy(paramFlexLayout);
    }
    return this.mIsLayoutChanged;
  }
  
  protected boolean valuesEqual(float paramFloat1, float paramFloat2)
  {
    return FloatUtils.floatsEqual(paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.dom.style.FlexNode
 * JD-Core Version:    0.7.0.1
 */