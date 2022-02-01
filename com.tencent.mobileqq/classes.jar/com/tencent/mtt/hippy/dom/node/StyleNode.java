package com.tencent.mtt.hippy.dom.node;

import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.dom.a.a;
import com.tencent.mtt.hippy.dom.a.c;
import com.tencent.mtt.hippy.dom.a.e;
import com.tencent.mtt.hippy.dom.a.i;
import com.tencent.mtt.hippy.dom.a.j;
import com.tencent.mtt.hippy.dom.a.k;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.smtt.flexbox.FlexNodeStyle.a;
import java.util.Locale;

public class StyleNode
  extends b
{
  @HippyControllerProps(name="alignItems")
  public void setAlignItems(String paramString)
  {
    if (paramString == null) {}
    for (paramString = a.e;; paramString = a.valueOf(paramString.toUpperCase(Locale.US).replace("-", "_")))
    {
      setAlignItems(paramString);
      return;
    }
  }
  
  @HippyControllerProps(name="alignSelf")
  public void setAlignSelf(String paramString)
  {
    if (paramString == null) {}
    for (paramString = a.a;; paramString = a.valueOf(paramString.toUpperCase(Locale.US).replace("-", "_")))
    {
      setAlignSelf(paramString);
      return;
    }
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="borderWidth")
  public void setBorderWidths(float paramFloat)
  {
    setBorder(8, PixelUtil.dp2px(paramFloat));
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="borderBottomWidth")
  public void setBottomBorderWidths(float paramFloat)
  {
    setBorder(3, PixelUtil.dp2px(paramFloat));
  }
  
  @HippyControllerProps(defaultNumber=(0.0D / 0.0D), defaultType="number", name="bottom")
  public void setBottomPositionValues(float paramFloat)
  {
    if (c.a(paramFloat)) {}
    for (;;)
    {
      setPosition(3, paramFloat);
      return;
      paramFloat = PixelUtil.dp2px(paramFloat);
    }
  }
  
  @HippyControllerProps(name="display")
  public void setDisplay(String paramString)
  {
    FlexNodeStyle.a locala = FlexNodeStyle.a.a;
    int i = -1;
    switch (paramString.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    for (paramString = locala;; paramString = FlexNodeStyle.a.b)
    {
      setDisplay(paramString);
      return;
      if (!paramString.equals("none")) {
        break;
      }
      i = 0;
      break;
    }
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="flex")
  public void setFlex(float paramFloat)
  {
    super.setFlex(paramFloat);
  }
  
  @HippyControllerProps(defaultNumber=(0.0D / 0.0D), defaultType="number", name="flexBasis")
  public void setFlexBasis(float paramFloat)
  {
    super.setFlexBasis(paramFloat);
  }
  
  @HippyControllerProps(name="flexDirection")
  public void setFlexDirection(String paramString)
  {
    if (paramString == null) {}
    for (paramString = com.tencent.mtt.hippy.dom.a.b.c;; paramString = com.tencent.mtt.hippy.dom.a.b.valueOf(paramString.toUpperCase(Locale.US).replace("-", "_")))
    {
      setFlexDirection(paramString);
      return;
    }
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="flexGrow")
  public void setFlexGrow(float paramFloat)
  {
    super.setFlexGrow(paramFloat);
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="flexShrink")
  public void setFlexShrink(float paramFloat)
  {
    super.setFlexShrink(paramFloat);
  }
  
  @HippyControllerProps(name="flexWrap")
  public void setFlexWrap(String paramString)
  {
    if (paramString == null) {}
    for (paramString = k.a;; paramString = k.valueOf(paramString.toUpperCase(Locale.US)))
    {
      setWrap(paramString);
      return;
    }
  }
  
  @HippyControllerProps(defaultNumber=(0.0D / 0.0D), defaultType="number", name="height")
  public void setHeight(float paramFloat)
  {
    if (c.a(paramFloat)) {}
    for (;;)
    {
      setStyleHeight(paramFloat);
      return;
      paramFloat = PixelUtil.dp2px(paramFloat);
    }
  }
  
  @HippyControllerProps(name="justifyContent")
  public void setJustifyContent(String paramString)
  {
    if (paramString == null) {}
    for (paramString = e.a;; paramString = e.valueOf(paramString.toUpperCase(Locale.US).replace("-", "_")))
    {
      setJustifyContent(paramString);
      return;
    }
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="borderLeftWidth")
  public void setLeftBorderWidths(float paramFloat)
  {
    setBorder(0, PixelUtil.dp2px(paramFloat));
  }
  
  @HippyControllerProps(defaultNumber=(0.0D / 0.0D), defaultType="number", name="left")
  public void setLeftPositionValues(float paramFloat)
  {
    if (c.a(paramFloat)) {}
    for (;;)
    {
      setPosition(0, paramFloat);
      return;
      paramFloat = PixelUtil.dp2px(paramFloat);
    }
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="margin")
  public void setMargin(float paramFloat)
  {
    setMargin(8, PixelUtil.dp2px(paramFloat));
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="marginBottom")
  public void setMarginBottom(float paramFloat)
  {
    setMargin(3, PixelUtil.dp2px(paramFloat));
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="marginHorizontal")
  public void setMarginHoriziontal(float paramFloat)
  {
    setMargin(6, PixelUtil.dp2px(paramFloat));
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="marginLeft")
  public void setMarginLeft(float paramFloat)
  {
    setMargin(0, PixelUtil.dp2px(paramFloat));
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="marginRight")
  public void setMarginRight(float paramFloat)
  {
    setMargin(2, PixelUtil.dp2px(paramFloat));
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="marginTop")
  public void setMarginTop(float paramFloat)
  {
    setMargin(1, PixelUtil.dp2px(paramFloat));
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="marginVertical")
  public void setMarginVertical(float paramFloat)
  {
    setMargin(7, PixelUtil.dp2px(paramFloat));
  }
  
  @HippyControllerProps(defaultNumber=(0.0D / 0.0D), defaultType="number", name="maxHeight")
  public void setMaxHeight(float paramFloat)
  {
    if (c.a(paramFloat)) {}
    for (;;)
    {
      setStyleMaxHeight(paramFloat);
      return;
      paramFloat = PixelUtil.dp2px(paramFloat);
    }
  }
  
  @HippyControllerProps(defaultNumber=(0.0D / 0.0D), defaultType="number", name="maxWidth")
  public void setMaxWidth(float paramFloat)
  {
    if (c.a(paramFloat)) {}
    for (;;)
    {
      setStyleMaxWidth(paramFloat);
      return;
      paramFloat = PixelUtil.dp2px(paramFloat);
    }
  }
  
  @HippyControllerProps(defaultNumber=(0.0D / 0.0D), defaultType="number", name="minHeight")
  public void setMinHeight(float paramFloat)
  {
    if (c.a(paramFloat)) {}
    for (;;)
    {
      setStyleMinHeight(paramFloat);
      return;
      paramFloat = PixelUtil.dp2px(paramFloat);
    }
  }
  
  @HippyControllerProps(defaultNumber=(0.0D / 0.0D), defaultType="number", name="minWidth")
  public void setMinWidth(float paramFloat)
  {
    if (c.a(paramFloat)) {}
    for (;;)
    {
      setStyleMinWidth(paramFloat);
      return;
      paramFloat = PixelUtil.dp2px(paramFloat);
    }
  }
  
  @HippyControllerProps(name="overflow")
  public void setOverflow(String paramString)
  {
    if (paramString == null) {}
    for (paramString = i.a;; paramString = i.valueOf(paramString.toUpperCase(Locale.US).replace("-", "_")))
    {
      setOverflow(paramString);
      return;
    }
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="padding")
  public void setPadding(float paramFloat)
  {
    if (c.a(paramFloat)) {}
    for (;;)
    {
      setPadding(8, paramFloat);
      return;
      paramFloat = PixelUtil.dp2px(paramFloat);
    }
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="paddingBottom")
  public void setPaddingBottom(float paramFloat)
  {
    if (c.a(paramFloat)) {}
    for (;;)
    {
      setPadding(3, paramFloat);
      return;
      paramFloat = PixelUtil.dp2px(paramFloat);
    }
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="paddingHorizontal")
  public void setPaddingHorizontal(float paramFloat)
  {
    if (c.a(paramFloat)) {}
    for (;;)
    {
      setPadding(6, paramFloat);
      return;
      paramFloat = PixelUtil.dp2px(paramFloat);
    }
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="paddingLeft")
  public void setPaddingLeft(float paramFloat)
  {
    if (c.a(paramFloat)) {}
    for (;;)
    {
      setPadding(0, paramFloat);
      return;
      paramFloat = PixelUtil.dp2px(paramFloat);
    }
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="paddingRight")
  public void setPaddingRight(float paramFloat)
  {
    if (c.a(paramFloat)) {}
    for (;;)
    {
      setPadding(2, paramFloat);
      return;
      paramFloat = PixelUtil.dp2px(paramFloat);
    }
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="paddingTop")
  public void setPaddingTop(float paramFloat)
  {
    if (c.a(paramFloat)) {}
    for (;;)
    {
      setPadding(1, paramFloat);
      return;
      paramFloat = PixelUtil.dp2px(paramFloat);
    }
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="paddingVertical")
  public void setPaddingVertical(float paramFloat)
  {
    if (c.a(paramFloat)) {}
    for (;;)
    {
      setPadding(7, paramFloat);
      return;
      paramFloat = PixelUtil.dp2px(paramFloat);
    }
  }
  
  @HippyControllerProps(name="position")
  public void setPosition(String paramString)
  {
    if (paramString == null) {}
    for (paramString = j.a;; paramString = j.valueOf(paramString.toUpperCase(Locale.US)))
    {
      setPositionType(paramString);
      return;
    }
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="borderRightWidth")
  public void setRightBorderWidths(float paramFloat)
  {
    setBorder(2, PixelUtil.dp2px(paramFloat));
  }
  
  @HippyControllerProps(defaultNumber=(0.0D / 0.0D), defaultType="number", name="right")
  public void setRightPositionValues(float paramFloat)
  {
    if (c.a(paramFloat)) {}
    for (;;)
    {
      setPosition(2, paramFloat);
      return;
      paramFloat = PixelUtil.dp2px(paramFloat);
    }
  }
  
  @HippyControllerProps(defaultType="boolean", name="onLayout")
  public void setShouldNotifyOnLayout(boolean paramBoolean)
  {
    super.setShouldNotifyOnLayout(paramBoolean);
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="borderTopWidth")
  public void setTopBorderWidths(float paramFloat)
  {
    setBorder(1, PixelUtil.dp2px(paramFloat));
  }
  
  @HippyControllerProps(defaultNumber=(0.0D / 0.0D), defaultType="number", name="top")
  public void setTopPositionValues(float paramFloat)
  {
    if (c.a(paramFloat)) {}
    for (;;)
    {
      setPosition(1, paramFloat);
      return;
      paramFloat = PixelUtil.dp2px(paramFloat);
    }
  }
  
  @HippyControllerProps(defaultNumber=(0.0D / 0.0D), defaultType="number", name="width")
  public void setWidth(float paramFloat)
  {
    if (c.a(paramFloat)) {}
    for (;;)
    {
      setStyleWidth(paramFloat);
      return;
      paramFloat = PixelUtil.dp2px(paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.dom.node.StyleNode
 * JD-Core Version:    0.7.0.1
 */