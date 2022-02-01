package com.tencent.mobileqq.cmshow.crossengine.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.crossengine.font.FontPixelsFactory;
import com.tencent.crossengine.font.FontPixelsFactory.FontOption;
import com.tencent.mobileqq.cmshow.engine.util.FontUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;

public class CEFontPixelsFactory
  implements FontPixelsFactory
{
  private int a = -1;
  
  public Bitmap a(String paramString, FontPixelsFactory.FontOption paramFontOption)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = FontUtils.a(paramString, this.a);
    return FontUtils.a((int)(paramFontOption.a / DeviceInfoUtil.a()), paramFontOption.b, (int)paramFontOption.c, (int)paramFontOption.d, 1, "", paramString, this.a);
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.util.CEFontPixelsFactory
 * JD-Core Version:    0.7.0.1
 */