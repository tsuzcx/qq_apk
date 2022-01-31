package com.tencent.plato.layout;

import com.tencent.plato.jni.HybridObject;
import java.util.ArrayList;
import java.util.List;

public class PlatoNodeImpl
  extends HybridObject
  implements PlatoNode
{
  private static final int BORDER = 4;
  private static final int MARGIN = 1;
  private static final int PADDING = 2;
  private List<PlatoNode> mChildren;
  private Object mData;
  private int mEdgeSetFlag;
  private PMeasureFunction mMeasureFunction;
  private final int mNodeId;
  private PlatoNode mParent;
  
  public PlatoNodeImpl(LayoutEngine paramLayoutEngine, int paramInt)
  {
    this.mNodeId = paramInt;
    setNativePointer(paramLayoutEngine.newNativePlatoNode(this, paramInt));
  }
  
  private native void jniAddChildAt(long paramLong1, long paramLong2, int paramInt);
  
  private native void jniCalculateLayout(long paramLong, float paramFloat1, float paramFloat2);
  
  private native void jniFree(long paramLong);
  
  private native int jniGetAlignItems(long paramLong);
  
  private native int jniGetDisplay(long paramLong);
  
  private native int jniGetFlexDirection(long paramLong);
  
  private native Object jniGetHeight(long paramLong);
  
  private native int jniGetJustifyContent(long paramLong);
  
  private native float jniGetLayoutHeight(long paramLong);
  
  private native float jniGetLayoutWidth(long paramLong);
  
  private native float jniGetLayoutX(long paramLong);
  
  private native float jniGetLayoutY(long paramLong);
  
  private native Object jniGetMargin(long paramLong, int paramInt);
  
  private native Object jniGetPadding(long paramLong, int paramInt);
  
  private native Object jniGetWidth(long paramLong);
  
  private native void jniMarkDirty(long paramLong);
  
  private native void jniRemoveChild(long paramLong1, long paramLong2);
  
  private native void jniSetAlignItems(long paramLong, int paramInt);
  
  private native void jniSetAlignItemsWithStr(long paramLong, String paramString);
  
  private native void jniSetAlignSelf(long paramLong, int paramInt);
  
  private native void jniSetAlignSelfWithStr(long paramLong, String paramString);
  
  private native void jniSetBorder(long paramLong, int paramInt, float paramFloat);
  
  private native void jniSetBorderV(long paramLong, String paramString);
  
  private native void jniSetBorderWithStr(long paramLong, int paramInt, String paramString);
  
  private native void jniSetDisplay(long paramLong, int paramInt);
  
  private native void jniSetDisplayWithStr(long paramLong, String paramString);
  
  private native void jniSetFlex(long paramLong, String paramString);
  
  private native void jniSetFlexBasis(long paramLong, String paramString);
  
  private native void jniSetFlexBasisAuto(long paramLong);
  
  private native void jniSetFlexBasisPx(long paramLong, float paramFloat);
  
  private native void jniSetFlexDirection(long paramLong, int paramInt);
  
  private native void jniSetFlexDirectionWithStr(long paramLong, String paramString);
  
  private native void jniSetFlexGrow(long paramLong, float paramFloat);
  
  private native void jniSetFlexGrowWithStr(long paramLong, String paramString);
  
  private native void jniSetFlexShrink(long paramLong, float paramFloat);
  
  private native void jniSetFlexShrinkWithStr(long paramLong, String paramString);
  
  private native void jniSetFlexWrap(long paramLong, int paramInt);
  
  private native void jniSetFlexWrapWithStr(long paramLong, String paramString);
  
  private native void jniSetHasMeasureFunc(long paramLong, boolean paramBoolean);
  
  private native void jniSetHeight(long paramLong, String paramString);
  
  private native void jniSetHeightPercent(long paramLong, float paramFloat);
  
  private native void jniSetHeightPx(long paramLong, float paramFloat);
  
  private native void jniSetJustifyContent(long paramLong, int paramInt);
  
  private native void jniSetJustifyContentWithStr(long paramLong, String paramString);
  
  private native void jniSetMargin(long paramLong, int paramInt, String paramString);
  
  private native void jniSetMarginAuto(long paramLong);
  
  private native void jniSetMarginPercent(long paramLong, int paramInt, float paramFloat);
  
  private native void jniSetMarginPx(long paramLong, int paramInt, float paramFloat);
  
  private native void jniSetMarginV(long paramLong, String paramString);
  
  private native void jniSetPadding(long paramLong, int paramInt, String paramString);
  
  private native void jniSetPaddingPercent(long paramLong, int paramInt, float paramFloat);
  
  private native void jniSetPaddingPx(long paramLong, int paramInt, float paramFloat);
  
  private native void jniSetPaddingV(long paramLong, String paramString);
  
  private native void jniSetPosition(long paramLong, int paramInt, String paramString);
  
  private native void jniSetPositionPercent(long paramLong, int paramInt, float paramFloat);
  
  private native void jniSetPositionPx(long paramLong, int paramInt, float paramFloat);
  
  private native void jniSetPositionType(long paramLong, int paramInt);
  
  private native void jniSetPositionTypeWithStr(long paramLong, String paramString);
  
  private native void jniSetPositionV(long paramLong, String paramString);
  
  private native void jniSetWidth(long paramLong, String paramString);
  
  private native void jniSetWidthPercent(long paramLong, float paramFloat);
  
  private native void jniSetWidthPx(long paramLong, float paramFloat);
  
  public final void addChildAt(PlatoNode paramPlatoNode, int paramInt)
  {
    paramPlatoNode = (PlatoNodeImpl)paramPlatoNode;
    if (paramPlatoNode.mParent != null) {
      throw new IllegalStateException("Child already has a parent, it must be removed first.");
    }
    if (this.mChildren == null) {
      this.mChildren = new ArrayList(4);
    }
    this.mChildren.add(paramInt, paramPlatoNode);
    paramPlatoNode.mParent = this;
    jniAddChildAt(this.nativePointer, paramPlatoNode.nativePointer, paramInt);
  }
  
  public final void calculateLayout(float paramFloat1, float paramFloat2)
  {
    jniCalculateLayout(this.nativePointer, paramFloat1, paramFloat2);
  }
  
  public void dirty()
  {
    jniMarkDirty(this.nativePointer);
  }
  
  protected void finalize()
    throws Throwable
  {
    try
    {
      jniFree(this.nativePointer);
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public PAlign getAlignItems()
  {
    return PAlign.fromInt(jniGetAlignItems(this.nativePointer));
  }
  
  public final PlatoNode getChildAt(int paramInt)
  {
    return (PlatoNode)this.mChildren.get(paramInt);
  }
  
  public final int getChildCount()
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
  
  public PDisplay getDisplay()
  {
    return PDisplay.fromInt(jniGetDisplay(this.nativePointer));
  }
  
  public PFlexDirection getFlexDirection()
  {
    return PFlexDirection.fromInt(jniGetFlexDirection(this.nativePointer));
  }
  
  public PValue getHeight()
  {
    return (PValue)jniGetHeight(this.nativePointer);
  }
  
  public PJustify getJustifyContent()
  {
    return PJustify.fromInt(jniGetJustifyContent(this.nativePointer));
  }
  
  public final float getLayoutHeight()
  {
    return jniGetLayoutHeight(this.nativePointer);
  }
  
  public final float getLayoutWidth()
  {
    return jniGetLayoutWidth(this.nativePointer);
  }
  
  public final float getLayoutX()
  {
    return jniGetLayoutX(this.nativePointer);
  }
  
  public final float getLayoutY()
  {
    return jniGetLayoutY(this.nativePointer);
  }
  
  public PValue getMargin(PEdge paramPEdge)
  {
    if ((this.mEdgeSetFlag & 0x1) != 1) {
      return PValue.UNDEFINED;
    }
    return (PValue)jniGetMargin(this.nativePointer, paramPEdge.intValue());
  }
  
  public int getNodeId()
  {
    return this.mNodeId;
  }
  
  public PValue getPadding(PEdge paramPEdge)
  {
    if ((this.mEdgeSetFlag & 0x2) != 2) {
      return PValue.UNDEFINED;
    }
    return (PValue)jniGetPadding(this.nativePointer, paramPEdge.intValue());
  }
  
  public final PlatoNode getParent()
  {
    return this.mParent;
  }
  
  public PValue getWidth()
  {
    return (PValue)jniGetWidth(this.nativePointer);
  }
  
  public final int indexOf(PlatoNode paramPlatoNode)
  {
    if (this.mChildren == null) {
      return -1;
    }
    return this.mChildren.indexOf(paramPlatoNode);
  }
  
  public boolean isMeasureDefined()
  {
    return this.mMeasureFunction != null;
  }
  
  public final long measure(float paramFloat1, int paramInt1, float paramFloat2, int paramInt2)
  {
    if (!isMeasureDefined()) {
      throw new RuntimeException("Measure function isn't defined!");
    }
    PMeasureFunction.MeasureValue localMeasureValue = this.mMeasureFunction.onMeasure(this, paramFloat1, PMeasureMode.fromInt(paramInt1), paramFloat2, PMeasureMode.fromInt(paramInt2));
    paramInt1 = Float.floatToRawIntBits(localMeasureValue.width);
    paramInt2 = Float.floatToRawIntBits(localMeasureValue.height);
    return paramInt1 << 32 | paramInt2;
  }
  
  public final void removeChildAt(int paramInt)
  {
    PlatoNodeImpl localPlatoNodeImpl = (PlatoNodeImpl)this.mChildren.remove(paramInt);
    localPlatoNodeImpl.mParent = null;
    jniRemoveChild(this.nativePointer, localPlatoNodeImpl.nativePointer);
  }
  
  public void setAlignItems(PAlign paramPAlign)
  {
    jniSetAlignItems(this.nativePointer, paramPAlign.intValue());
  }
  
  public final void setAlignItems(String paramString)
  {
    jniSetAlignItemsWithStr(this.nativePointer, paramString);
  }
  
  public void setAlignSelf(PAlign paramPAlign)
  {
    jniSetAlignSelf(this.nativePointer, paramPAlign.intValue());
  }
  
  public final void setAlignSelf(String paramString)
  {
    jniSetAlignSelfWithStr(this.nativePointer, paramString);
  }
  
  public void setBorder(PEdge paramPEdge, float paramFloat)
  {
    jniSetBorder(this.nativePointer, paramPEdge.intValue(), paramFloat);
  }
  
  public final void setBorder(PEdge paramPEdge, String paramString)
  {
    this.mEdgeSetFlag |= 0x4;
    jniSetBorderWithStr(this.nativePointer, paramPEdge.intValue(), paramString);
  }
  
  public void setBorder(String paramString)
  {
    this.mEdgeSetFlag |= 0x4;
    jniSetBorderV(this.nativePointer, paramString);
  }
  
  public void setData(Object paramObject)
  {
    this.mData = paramObject;
  }
  
  public final void setDisplay(PDisplay paramPDisplay)
  {
    jniSetDisplay(this.nativePointer, paramPDisplay.intValue());
  }
  
  public final void setDisplay(String paramString)
  {
    jniSetDisplayWithStr(this.nativePointer, paramString);
  }
  
  public void setFlex(String paramString)
  {
    jniSetFlex(this.nativePointer, paramString);
  }
  
  public void setFlexBasis(float paramFloat)
  {
    jniSetFlexBasisPx(this.nativePointer, paramFloat);
  }
  
  public final void setFlexBasis(String paramString)
  {
    jniSetFlexBasis(this.nativePointer, paramString);
  }
  
  public void setFlexBasisAuto()
  {
    jniSetFlexBasisAuto(this.nativePointer);
  }
  
  public void setFlexDirection(PFlexDirection paramPFlexDirection)
  {
    jniSetFlexDirection(this.nativePointer, paramPFlexDirection.intValue());
  }
  
  public final void setFlexDirection(String paramString)
  {
    jniSetFlexDirectionWithStr(this.nativePointer, paramString);
  }
  
  public final void setFlexGrow(float paramFloat)
  {
    jniSetFlexGrow(this.nativePointer, paramFloat);
  }
  
  public void setFlexGrow(String paramString)
  {
    jniSetFlexGrowWithStr(this.nativePointer, paramString);
  }
  
  public final void setFlexShrink(float paramFloat)
  {
    jniSetFlexShrink(this.nativePointer, paramFloat);
  }
  
  public void setFlexShrink(String paramString)
  {
    jniSetFlexShrinkWithStr(this.nativePointer, paramString);
  }
  
  public void setHeight(float paramFloat)
  {
    jniSetHeightPx(this.nativePointer, paramFloat);
  }
  
  public final void setHeight(String paramString)
  {
    jniSetHeight(this.nativePointer, paramString);
  }
  
  public void setHeightPercent(float paramFloat)
  {
    jniSetHeightPercent(this.nativePointer, paramFloat);
  }
  
  public void setJustifyContent(PJustify paramPJustify)
  {
    jniSetJustifyContent(this.nativePointer, paramPJustify.intValue());
  }
  
  public final void setJustifyContent(String paramString)
  {
    jniSetJustifyContentWithStr(this.nativePointer, paramString);
  }
  
  public void setMargin(PEdge paramPEdge, float paramFloat)
  {
    jniSetMarginPx(this.nativePointer, paramPEdge.intValue(), paramFloat);
  }
  
  public final void setMargin(PEdge paramPEdge, String paramString)
  {
    this.mEdgeSetFlag |= 0x1;
    jniSetMargin(this.nativePointer, paramPEdge.intValue(), paramString);
  }
  
  public void setMargin(String paramString)
  {
    this.mEdgeSetFlag |= 0x1;
    jniSetMarginV(this.nativePointer, paramString);
  }
  
  public void setMarginAuto(PEdge paramPEdge)
  {
    jniSetMarginAuto(this.nativePointer);
  }
  
  public void setMarginPercent(PEdge paramPEdge, float paramFloat)
  {
    jniSetMarginPercent(this.nativePointer, paramPEdge.intValue(), paramFloat);
  }
  
  public final void setMeasureFunction(PMeasureFunction paramPMeasureFunction)
  {
    this.mMeasureFunction = paramPMeasureFunction;
    long l = this.nativePointer;
    if (paramPMeasureFunction != null) {}
    for (boolean bool = true;; bool = false)
    {
      jniSetHasMeasureFunc(l, bool);
      return;
    }
  }
  
  public void setPadding(PEdge paramPEdge, float paramFloat)
  {
    jniSetPaddingPx(this.nativePointer, paramPEdge.intValue(), paramFloat);
  }
  
  public final void setPadding(PEdge paramPEdge, String paramString)
  {
    this.mEdgeSetFlag |= 0x2;
    jniSetPadding(this.nativePointer, paramPEdge.intValue(), paramString);
  }
  
  public void setPadding(String paramString)
  {
    jniSetPaddingV(this.nativePointer, paramString);
  }
  
  public void setPaddingPercent(PEdge paramPEdge, float paramFloat)
  {
    jniSetPaddingPercent(this.nativePointer, paramPEdge.intValue(), paramFloat);
  }
  
  public void setPosition(PEdge paramPEdge, float paramFloat)
  {
    jniSetPositionPx(this.nativePointer, paramPEdge.intValue(), paramFloat);
  }
  
  public final void setPosition(PEdge paramPEdge, String paramString)
  {
    jniSetPosition(this.nativePointer, paramPEdge.intValue(), paramString);
  }
  
  public void setPosition(String paramString)
  {
    jniSetPositionV(this.nativePointer, paramString);
  }
  
  public void setPositionPercent(PEdge paramPEdge, float paramFloat)
  {
    jniSetPositionPercent(this.nativePointer, paramPEdge.intValue(), paramFloat);
  }
  
  public void setPositionType(PPositionType paramPPositionType)
  {
    jniSetPositionType(this.nativePointer, paramPPositionType.intValue());
  }
  
  public final void setPositionType(String paramString)
  {
    jniSetPositionTypeWithStr(this.nativePointer, paramString);
  }
  
  public void setWidth(float paramFloat)
  {
    jniSetWidthPx(this.nativePointer, paramFloat);
  }
  
  public final void setWidth(String paramString)
  {
    jniSetWidth(this.nativePointer, paramString);
  }
  
  public void setWidthPercent(float paramFloat)
  {
    jniSetWidthPercent(this.nativePointer, paramFloat);
  }
  
  public void setWrap(PWrap paramPWrap)
  {
    jniSetFlexWrap(this.nativePointer, paramPWrap.intValue());
  }
  
  public final void setWrap(String paramString)
  {
    jniSetFlexWrapWithStr(this.nativePointer, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.plato.layout.PlatoNodeImpl
 * JD-Core Version:    0.7.0.1
 */