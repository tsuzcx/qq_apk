package com.tencent.plato.yoga;

import android.text.TextUtils;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaDisplay;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaFlexDirection;
import com.facebook.yoga.YogaJustify;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.YogaPositionType;
import com.facebook.yoga.YogaUnit;
import com.facebook.yoga.YogaValue;
import com.facebook.yoga.YogaWrap;
import com.tencent.plato.layout.PAlign;
import com.tencent.plato.layout.PDisplay;
import com.tencent.plato.layout.PEdge;
import com.tencent.plato.layout.PFlexDirection;
import com.tencent.plato.layout.PJustify;
import com.tencent.plato.layout.PMeasureFunction;
import com.tencent.plato.layout.PMeasureFunction.MeasureValue;
import com.tencent.plato.layout.PMeasureMode;
import com.tencent.plato.layout.PPositionType;
import com.tencent.plato.layout.PUnit;
import com.tencent.plato.layout.PValue;
import com.tencent.plato.layout.PWrap;
import com.tencent.plato.layout.PlatoNode;
import com.tencent.plato.sdk.utils.Dimension;

public class YogaPlatoNode
  implements PlatoNode
{
  private Object mData;
  private final int mNodeId;
  private final YogaNode mYogaNode;
  
  public YogaPlatoNode(int paramInt)
  {
    this.mNodeId = paramInt;
    this.mYogaNode = new YogaNode();
    this.mYogaNode.setData(this);
  }
  
  public final void addChildAt(PlatoNode paramPlatoNode, int paramInt)
  {
    if ((this.mYogaNode != null) && (paramPlatoNode != null) && (((YogaPlatoNode)paramPlatoNode).mYogaNode != null)) {
      this.mYogaNode.addChildAt(((YogaPlatoNode)paramPlatoNode).mYogaNode, paramInt);
    }
  }
  
  public final void calculateLayout(float paramFloat1, float paramFloat2)
  {
    this.mYogaNode.calculateLayout(paramFloat1, paramFloat2);
  }
  
  public void dirty()
  {
    this.mYogaNode.dirty();
  }
  
  public PAlign getAlignItems()
  {
    return PAlign.fromInt(this.mYogaNode.getAlignItems().intValue());
  }
  
  public final PlatoNode getChildAt(int paramInt)
  {
    YogaNode localYogaNode = this.mYogaNode.getChildAt(paramInt);
    if (localYogaNode == null) {
      return null;
    }
    return (PlatoNode)localYogaNode.getData();
  }
  
  public final int getChildCount()
  {
    return this.mYogaNode.getChildCount();
  }
  
  public Object getData()
  {
    return this.mData;
  }
  
  public PDisplay getDisplay()
  {
    return PDisplay.fromInt(this.mYogaNode.getDisplay().intValue());
  }
  
  public PFlexDirection getFlexDirection()
  {
    return PFlexDirection.fromInt(this.mYogaNode.getFlexDirection().intValue());
  }
  
  public PValue getHeight()
  {
    YogaValue localYogaValue = this.mYogaNode.getHeight();
    return new PValue(localYogaValue.value, PUnit.fromInt(localYogaValue.unit.intValue()));
  }
  
  public PJustify getJustifyContent()
  {
    return PJustify.fromInt(this.mYogaNode.getJustifyContent().intValue());
  }
  
  public final float getLayoutHeight()
  {
    return this.mYogaNode.getLayoutHeight();
  }
  
  public final float getLayoutWidth()
  {
    return this.mYogaNode.getLayoutWidth();
  }
  
  public final float getLayoutX()
  {
    return this.mYogaNode.getLayoutX();
  }
  
  public final float getLayoutY()
  {
    return this.mYogaNode.getLayoutY();
  }
  
  public PValue getMargin(PEdge paramPEdge)
  {
    paramPEdge = this.mYogaNode.getMargin(YogaEdge.fromInt(paramPEdge.intValue()));
    return new PValue(paramPEdge.value, PUnit.fromInt(paramPEdge.unit.intValue()));
  }
  
  public int getNodeId()
  {
    return this.mNodeId;
  }
  
  public PValue getPadding(PEdge paramPEdge)
  {
    paramPEdge = this.mYogaNode.getPadding(YogaEdge.fromInt(paramPEdge.intValue()));
    return new PValue(paramPEdge.value, PUnit.fromInt(paramPEdge.unit.intValue()));
  }
  
  public final PlatoNode getParent()
  {
    YogaNode localYogaNode = this.mYogaNode.getParent();
    if (localYogaNode == null) {
      return null;
    }
    return (PlatoNode)localYogaNode.getData();
  }
  
  public PValue getWidth()
  {
    YogaValue localYogaValue = this.mYogaNode.getWidth();
    return new PValue(localYogaValue.value, PUnit.fromInt(localYogaValue.unit.intValue()));
  }
  
  public final int indexOf(PlatoNode paramPlatoNode)
  {
    return this.mYogaNode.indexOf(((YogaPlatoNode)paramPlatoNode).mYogaNode);
  }
  
  public boolean isMeasureDefined()
  {
    return this.mYogaNode.isMeasureDefined();
  }
  
  public final void removeChildAt(int paramInt)
  {
    this.mYogaNode.removeChildAt(paramInt);
  }
  
  public final void setAlignItems(PAlign paramPAlign)
  {
    this.mYogaNode.setAlignItems(YogaAlign.fromInt(paramPAlign.intValue()));
  }
  
  public void setAlignItems(String paramString)
  {
    if (paramString.equals("center"))
    {
      setAlignItems(PAlign.CENTER);
      return;
    }
    if (paramString.equals("stretch"))
    {
      setAlignItems(PAlign.STRETCH);
      return;
    }
    if (paramString.equals("auto"))
    {
      setAlignItems(PAlign.AUTO);
      return;
    }
    if (paramString.equals("flex_start"))
    {
      setAlignItems(PAlign.FLEX_START);
      return;
    }
    if (paramString.equals("flex_end"))
    {
      setAlignItems(PAlign.FLEX_END);
      return;
    }
    if (paramString.equals("baseline"))
    {
      setAlignItems(PAlign.BASELINE);
      return;
    }
    if (paramString.equals("space_between"))
    {
      setAlignItems(PAlign.SPACE_BETWEEN);
      return;
    }
    if (paramString.equals("space_around"))
    {
      setAlignItems(PAlign.SPACE_AROUND);
      return;
    }
    setAlignItems(PAlign.STRETCH);
  }
  
  public final void setAlignSelf(PAlign paramPAlign)
  {
    this.mYogaNode.setAlignSelf(YogaAlign.fromInt(paramPAlign.intValue()));
  }
  
  public void setAlignSelf(String paramString)
  {
    if (paramString.equals("center"))
    {
      setAlignSelf(PAlign.CENTER);
      return;
    }
    if (paramString.equals("stretch"))
    {
      setAlignSelf(PAlign.STRETCH);
      return;
    }
    if (paramString.equals("auto"))
    {
      setAlignSelf(PAlign.AUTO);
      return;
    }
    if (paramString.equals("flex_start"))
    {
      setAlignSelf(PAlign.FLEX_START);
      return;
    }
    if (paramString.equals("flex_end"))
    {
      setAlignSelf(PAlign.FLEX_END);
      return;
    }
    if (paramString.equals("baseline"))
    {
      setAlignSelf(PAlign.BASELINE);
      return;
    }
    if (paramString.equals("space_between"))
    {
      setAlignSelf(PAlign.SPACE_BETWEEN);
      return;
    }
    if (paramString.equals("space_around"))
    {
      setAlignSelf(PAlign.SPACE_AROUND);
      return;
    }
    setAlignSelf(PAlign.AUTO);
  }
  
  public final void setBorder(PEdge paramPEdge, float paramFloat)
  {
    this.mYogaNode.setBorder(YogaEdge.fromInt(paramPEdge.intValue()), paramFloat);
  }
  
  public void setBorder(PEdge paramPEdge, String paramString)
  {
    setBorder(paramPEdge, (int)Dimension.parse(paramString).px);
  }
  
  public void setBorder(String paramString)
  {
    paramString = paramString.split(" ");
    if (paramString.length == 1)
    {
      setBorder(PEdge.TOP, paramString[0]);
      setBorder(PEdge.RIGHT, paramString[0]);
      setBorder(PEdge.BOTTOM, paramString[0]);
      setBorder(PEdge.LEFT, paramString[0]);
      return;
    }
    if (paramString.length == 4)
    {
      setBorder(PEdge.TOP, paramString[0]);
      setBorder(PEdge.RIGHT, paramString[1]);
      setBorder(PEdge.BOTTOM, paramString[2]);
      setBorder(PEdge.LEFT, paramString[3]);
      return;
    }
    setBorder(PEdge.TOP, (0.0F / 0.0F));
    setBorder(PEdge.RIGHT, (0.0F / 0.0F));
    setBorder(PEdge.BOTTOM, (0.0F / 0.0F));
    setBorder(PEdge.LEFT, (0.0F / 0.0F));
  }
  
  public void setData(Object paramObject)
  {
    this.mData = paramObject;
  }
  
  public final void setDisplay(PDisplay paramPDisplay)
  {
    this.mYogaNode.setDisplay(YogaDisplay.fromInt(paramPDisplay.intValue()));
  }
  
  public void setDisplay(String paramString)
  {
    if (paramString.equals("flex"))
    {
      setDisplay(PDisplay.FLEX);
      return;
    }
    if (paramString.equals("none"))
    {
      setDisplay(PDisplay.NONE);
      return;
    }
    setDisplay(PDisplay.FLEX);
  }
  
  public final void setFlex(float paramFloat)
  {
    this.mYogaNode.setFlex(paramFloat);
  }
  
  public void setFlex(String paramString)
  {
    if ("auto".equals(paramString))
    {
      setFlexGrow(1.0F);
      setFlexShrink(1.0F);
      setFlexBasis("auto");
    }
    do
    {
      return;
      if ("none".equals(paramString))
      {
        setFlexGrow(0.0F);
        setFlexShrink(0.0F);
        setFlexBasis("auto");
        return;
      }
      if (TextUtils.isEmpty(paramString)) {
        break;
      }
      paramString = paramString.split(" ");
      if (paramString.length == 1)
      {
        setFlex(Dimension.Float(paramString[0]));
        return;
      }
      if (paramString.length == 2)
      {
        setFlexGrow(Dimension.Float(paramString[0]));
        setFlexShrink(Dimension.Float(paramString[1]));
        return;
      }
    } while (paramString.length != 3);
    setFlexGrow(Dimension.Float(paramString[0]));
    setFlexShrink(Dimension.Float(paramString[1]));
    if (paramString[2].equals("auto"))
    {
      setFlexBasis("auto");
      return;
    }
    setFlexBasis(paramString[2]);
    return;
    setFlexGrow(0.0F);
    setFlexShrink(0.0F);
    setFlexBasis("auto");
  }
  
  public final void setFlexBasis(float paramFloat)
  {
    this.mYogaNode.setFlexBasis(paramFloat);
  }
  
  public void setFlexBasis(String paramString)
  {
    if ((paramString.equals("auto")) || (TextUtils.isEmpty(paramString)))
    {
      setFlexBasisAuto();
      return;
    }
    setFlexBasis(Dimension.parse(paramString).px);
  }
  
  public final void setFlexBasisAuto()
  {
    this.mYogaNode.setFlexBasisAuto();
  }
  
  public final void setFlexDirection(PFlexDirection paramPFlexDirection)
  {
    this.mYogaNode.setFlexDirection(YogaFlexDirection.fromInt(paramPFlexDirection.intValue()));
  }
  
  public void setFlexDirection(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      setFlexDirection(PFlexDirection.ROW);
      return;
    }
    if (paramString.equals("row"))
    {
      setFlexDirection(PFlexDirection.ROW);
      return;
    }
    if (paramString.equals("row-reverse"))
    {
      setFlexDirection(PFlexDirection.ROW_REVERSE);
      return;
    }
    if (paramString.equals("column"))
    {
      setFlexDirection(PFlexDirection.COLUMN);
      return;
    }
    if (paramString.equals("column-reverse"))
    {
      setFlexDirection(PFlexDirection.COLUMN_REVERSE);
      return;
    }
    setFlexDirection(PFlexDirection.ROW);
  }
  
  public final void setFlexGrow(float paramFloat)
  {
    this.mYogaNode.setFlexGrow(paramFloat);
  }
  
  public void setFlexGrow(String paramString)
  {
    this.mYogaNode.setFlexGrow(Dimension.Float(paramString));
  }
  
  public final void setFlexShrink(float paramFloat)
  {
    this.mYogaNode.setFlexShrink(paramFloat);
  }
  
  public void setFlexShrink(String paramString)
  {
    this.mYogaNode.setFlexShrink(Dimension.Float(paramString));
  }
  
  public final void setHeight(float paramFloat)
  {
    this.mYogaNode.setHeight(paramFloat);
  }
  
  public void setHeight(String paramString)
  {
    paramString = Dimension.parse(paramString);
    if (!Float.isNaN(paramString.px)) {
      setHeight(paramString.px);
    }
    while (Float.isNaN(paramString.percent)) {
      return;
    }
    setHeightPercent(paramString.percent);
  }
  
  public final void setHeightPercent(float paramFloat)
  {
    this.mYogaNode.setHeightPercent(paramFloat);
  }
  
  public final void setJustifyContent(PJustify paramPJustify)
  {
    this.mYogaNode.setJustifyContent(YogaJustify.fromInt(paramPJustify.intValue()));
  }
  
  public void setJustifyContent(String paramString)
  {
    if (paramString.equals("space-between"))
    {
      setJustifyContent(PJustify.SPACE_BETWEEN);
      return;
    }
    if (paramString.equals("space-around"))
    {
      setJustifyContent(PJustify.SPACE_AROUND);
      return;
    }
    if (paramString.equals("center"))
    {
      setJustifyContent(PJustify.CENTER);
      return;
    }
    if (paramString.equals("flex-start"))
    {
      setJustifyContent(PJustify.FLEX_START);
      return;
    }
    if (paramString.equals("flex-end"))
    {
      setJustifyContent(PJustify.FLEX_END);
      return;
    }
    setJustifyContent(PJustify.FLEX_START);
  }
  
  public final void setMargin(PEdge paramPEdge, float paramFloat)
  {
    this.mYogaNode.setMargin(YogaEdge.fromInt(paramPEdge.intValue()), paramFloat);
  }
  
  public void setMargin(PEdge paramPEdge, String paramString)
  {
    paramString = Dimension.parse(paramString);
    if (!Float.isNaN(paramString.px))
    {
      setMargin(paramPEdge, paramString.px);
      return;
    }
    if (!Float.isNaN(paramString.percent))
    {
      setMarginPercent(paramPEdge, paramString.percent);
      return;
    }
    setMargin(paramPEdge, (0.0F / 0.0F));
  }
  
  public void setMargin(String paramString)
  {
    paramString = paramString.split(" ");
    if (paramString.length == 1)
    {
      setMargin(PEdge.TOP, paramString[0]);
      setMargin(PEdge.RIGHT, paramString[0]);
      setMargin(PEdge.BOTTOM, paramString[0]);
      setMargin(PEdge.LEFT, paramString[0]);
      return;
    }
    if (paramString.length == 4)
    {
      setMargin(PEdge.TOP, paramString[0]);
      setMargin(PEdge.RIGHT, paramString[1]);
      setMargin(PEdge.BOTTOM, paramString[2]);
      setMargin(PEdge.LEFT, paramString[3]);
      return;
    }
    setMargin(PEdge.TOP, (0.0F / 0.0F));
    setMargin(PEdge.RIGHT, (0.0F / 0.0F));
    setMargin(PEdge.BOTTOM, (0.0F / 0.0F));
    setMargin(PEdge.LEFT, (0.0F / 0.0F));
  }
  
  public void setMarginAuto(PEdge paramPEdge)
  {
    this.mYogaNode.setMarginAuto(YogaEdge.fromInt(paramPEdge.intValue()));
  }
  
  public final void setMarginPercent(PEdge paramPEdge, float paramFloat)
  {
    this.mYogaNode.setMarginPercent(YogaEdge.fromInt(paramPEdge.intValue()), paramFloat);
  }
  
  public final void setMeasureFunction(final PMeasureFunction paramPMeasureFunction)
  {
    this.mYogaNode.setMeasureFunction(new YogaMeasureFunction()
    {
      public long measure(YogaNode paramAnonymousYogaNode, float paramAnonymousFloat1, YogaMeasureMode paramAnonymousYogaMeasureMode1, float paramAnonymousFloat2, YogaMeasureMode paramAnonymousYogaMeasureMode2)
      {
        paramAnonymousYogaNode = paramPMeasureFunction.onMeasure((PlatoNode)paramAnonymousYogaNode.getData(), paramAnonymousFloat1, PMeasureMode.fromInt(paramAnonymousYogaMeasureMode1.intValue()), paramAnonymousFloat2, PMeasureMode.fromInt(paramAnonymousYogaMeasureMode2.intValue()));
        return YogaMeasureOutput.make(paramAnonymousYogaNode.width, paramAnonymousYogaNode.height);
      }
    });
  }
  
  public final void setPadding(PEdge paramPEdge, float paramFloat)
  {
    this.mYogaNode.setPadding(YogaEdge.fromInt(paramPEdge.intValue()), paramFloat);
  }
  
  public void setPadding(PEdge paramPEdge, String paramString)
  {
    paramString = Dimension.parse(paramString);
    if (!Float.isNaN(paramString.px))
    {
      setPadding(paramPEdge, paramString.px);
      return;
    }
    if (!Float.isNaN(paramString.percent))
    {
      setPaddingPercent(paramPEdge, paramString.percent);
      return;
    }
    setPadding(paramPEdge, (0.0F / 0.0F));
  }
  
  public void setPadding(String paramString)
  {
    paramString = paramString.split(" ");
    if (paramString.length == 1)
    {
      setPadding(PEdge.TOP, paramString[0]);
      setPadding(PEdge.RIGHT, paramString[0]);
      setPadding(PEdge.BOTTOM, paramString[0]);
      setPadding(PEdge.LEFT, paramString[0]);
      return;
    }
    if (paramString.length == 4)
    {
      setPadding(PEdge.TOP, paramString[0]);
      setPadding(PEdge.RIGHT, paramString[1]);
      setPadding(PEdge.BOTTOM, paramString[2]);
      setPadding(PEdge.LEFT, paramString[3]);
      return;
    }
    setPadding(PEdge.TOP, (0.0F / 0.0F));
    setPadding(PEdge.RIGHT, (0.0F / 0.0F));
    setPadding(PEdge.BOTTOM, (0.0F / 0.0F));
    setPadding(PEdge.LEFT, (0.0F / 0.0F));
  }
  
  public final void setPaddingPercent(PEdge paramPEdge, float paramFloat)
  {
    this.mYogaNode.setPaddingPercent(YogaEdge.fromInt(paramPEdge.intValue()), paramFloat);
  }
  
  public final void setPosition(PEdge paramPEdge, float paramFloat)
  {
    this.mYogaNode.setPosition(YogaEdge.fromInt(paramPEdge.intValue()), paramFloat);
  }
  
  public void setPosition(PEdge paramPEdge, String paramString)
  {
    paramString = Dimension.parse(paramString);
    if (!Float.isNaN(paramString.percent)) {
      setPositionPercent(paramPEdge, paramString.percent);
    }
    while (Float.isNaN(paramString.px)) {
      return;
    }
    setPosition(paramPEdge, paramString.px);
  }
  
  public void setPosition(String paramString) {}
  
  public final void setPositionPercent(PEdge paramPEdge, float paramFloat)
  {
    this.mYogaNode.setPositionPercent(YogaEdge.fromInt(paramPEdge.intValue()), paramFloat);
  }
  
  public final void setPositionType(PPositionType paramPPositionType)
  {
    this.mYogaNode.setPositionType(YogaPositionType.fromInt(paramPPositionType.intValue()));
  }
  
  public void setPositionType(String paramString)
  {
    if ("absolute".equals(paramString))
    {
      setPositionType(PPositionType.ABSOLUTE);
      return;
    }
    setPositionType(PPositionType.RELATIVE);
  }
  
  public final void setWidth(float paramFloat)
  {
    this.mYogaNode.setWidth(paramFloat);
  }
  
  public void setWidth(String paramString)
  {
    paramString = Dimension.parse(paramString);
    if (!Float.isNaN(paramString.px)) {
      setWidth(paramString.px);
    }
    while (Float.isNaN(paramString.percent)) {
      return;
    }
    setWidthPercent(paramString.percent);
  }
  
  public final void setWidthPercent(float paramFloat)
  {
    this.mYogaNode.setWidthPercent(paramFloat);
  }
  
  public final void setWrap(PWrap paramPWrap)
  {
    this.mYogaNode.setWrap(YogaWrap.fromInt(paramPWrap.intValue()));
  }
  
  public void setWrap(String paramString)
  {
    if (paramString.equals("wrap"))
    {
      setWrap(PWrap.WRAP);
      return;
    }
    if (paramString.equals("wrap-reverse"))
    {
      setWrap(PWrap.WRAP_REVERSE);
      return;
    }
    if (paramString.equals("nowrap"))
    {
      setWrap(PWrap.NO_WRAP);
      return;
    }
    setWrap(PWrap.NO_WRAP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.yoga.YogaPlatoNode
 * JD-Core Version:    0.7.0.1
 */