package com.tencent.mobileqq.flashshow.helper;

import android.graphics.Typeface;
import com.tencent.mobileqq.flashshow.callback.AccountIdentityCallBack;
import com.tencent.mobileqq.servlet.LoginVerifyServlet;
import com.tencent.theme.TextHook;
import mqq.app.MobileQQ;

public class FSStaticInvokeHelper
{
  private static final String TAG = "FSStaticInvokeHelper";
  
  public static Typeface getSystemDefaultFont()
  {
    return TextHook.getInstance().getSystemDefaultFont();
  }
  
  public static void sendAccountIdentityRequest(AccountIdentityCallBack paramAccountIdentityCallBack)
  {
    LoginVerifyServlet.b(MobileQQ.sMobileQQ.waitAppRuntime(null), new FSStaticInvokeHelper.1(paramAccountIdentityCallBack));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.helper.FSStaticInvokeHelper
 * JD-Core Version:    0.7.0.1
 */