package com.tencent.mobileqq.guild.widget;

import android.content.Context;
import com.tencent.mobileqq.transfile.BaseURLDrawableHelper;
import com.tencent.mobileqq.utils.DisplayUtils;
import mqq.app.MobileQQ;

public class URLDrawableHelper
  extends BaseURLDrawableHelper
{
  public static int a = 45;
  
  static
  {
    Context localContext = MobileQQ.sMobileQQ.getApplicationContext();
    if (localContext != null) {
      a = (int)DisplayUtils.a(localContext, 45.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.widget.URLDrawableHelper
 * JD-Core Version:    0.7.0.1
 */