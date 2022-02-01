package com.tencent.xweb.xwalk;

import android.content.Context;
import android.text.TextUtils;
import org.xwalk.core.Log;
import org.xwalk.core.WebViewExtension;
import org.xwalk.core.WebViewExtensionListener;
import org.xwalk.core.XWalkCoreWrapper;
import org.xwalk.core.XWalkEnvironment;

class XWalkWebFactory$b
{
  private static boolean a = false;
  private static boolean b = false;
  private static boolean c = false;
  
  public static void a(WebViewExtensionListener paramWebViewExtensionListener)
  {
    if (b) {
      return;
    }
    Log.i("XWebViewHelper", "initCallback");
    WebViewExtension.SetExtension(paramWebViewExtensionListener);
    b = true;
  }
  
  public static boolean a()
  {
    return a;
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool = a;
    if (bool) {
      return bool;
    }
    Log.i("XWebViewHelper", "preInit");
    if (k.a(paramContext))
    {
      Log.i("XWebViewHelper", "preInit finished");
      a = true;
      c = true;
      Object localObject = XWalkEnvironment.getProcessName();
      paramContext = (Context)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramContext = XWalkEnvironment.getApplicationContext().getPackageName();
      }
      paramContext = paramContext.replace(":", ".");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramContext);
      ((StringBuilder)localObject).append(".");
      ((StringBuilder)localObject).append(XWalkEnvironment.getGrayValue());
      XWalkCoreWrapper.invokeRuntimeChannel(90002, new Object[] { ((StringBuilder)localObject).toString() });
    }
    else
    {
      Log.i("XWebViewHelper", "preInit xwalk is not available");
    }
    return a;
  }
  
  public static boolean b()
  {
    return b;
  }
  
  public static boolean c()
  {
    return c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.XWalkWebFactory.b
 * JD-Core Version:    0.7.0.1
 */