package com.tencent.mobileqq.profilecard.utils;

import android.content.Context;
import com.tencent.mobileqq.widget.QQToast;
import mqq.app.MobileQQ;

public class ProfileUIUtils
{
  public static final ProfileUIUtils.ViewAlphaOnTouchListener ALPHA_TOUCH_LISTENER = new ProfileUIUtils.ViewAlphaOnTouchListener();
  
  public static void notifyUser(int paramInt1, int paramInt2)
  {
    notifyUser(paramInt1, MobileQQ.sMobileQQ.getApplicationContext().getString(paramInt2));
  }
  
  public static void notifyUser(int paramInt, String paramString)
  {
    QQToast.a(MobileQQ.sMobileQQ.getApplicationContext(), paramInt, paramString, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.utils.ProfileUIUtils
 * JD-Core Version:    0.7.0.1
 */