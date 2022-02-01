package com.tencent.mtt.hippy.views.common;

import com.tencent.mtt.hippy.dom.a.c;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.supportui.views.asyncimage.BackgroundDrawable;

public class CommonBackgroundDrawable
  extends BackgroundDrawable
{
  public void setBorderRadius(float paramFloat, int paramInt)
  {
    if (!c.a(paramFloat)) {
      super.setBorderRadius(PixelUtil.dp2px(paramFloat), paramInt);
    }
  }
  
  public void setBorderWidth(float paramFloat, int paramInt)
  {
    if (!c.a(paramFloat)) {
      super.setBorderWidth(PixelUtil.dp2px(paramFloat), paramInt);
    }
  }
  
  public void setShadowOffsetX(float paramFloat)
  {
    if (!c.a(paramFloat)) {
      super.setShadowOffsetX(PixelUtil.dp2px(paramFloat));
    }
  }
  
  public void setShadowOffsetY(float paramFloat)
  {
    if (!c.a(paramFloat)) {
      super.setShadowOffsetY(PixelUtil.dp2px(paramFloat));
    }
  }
  
  public void setShadowRadius(float paramFloat)
  {
    if (!c.a(paramFloat)) {
      super.setShadowRadius(PixelUtil.dp2px(paramFloat));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.common.CommonBackgroundDrawable
 * JD-Core Version:    0.7.0.1
 */