package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;
import org.json.JSONObject;

public class ScreenJsPlugin
  extends BaseJsPlugin
{
  public static final String EVENT_GET_SCREEN_BRIGHTNESS = "getScreenBrightness";
  private static final String EVENT_ON_USER_CAPTURE_SCREEN = "onUserCaptureScreen";
  public static final String EVENT_SET_KEEP_SCREEN_ON = "setKeepScreenOn";
  public static final String EVENT_SET_SCREEN_BRIGHTNESS = "setScreenBrightness";
  private static final Set<String> S_EVENT_MAP = new ScreenJsPlugin.1();
  private static final String TAG = "[mini] ScreenJsPlugin";
  
  /* Error */
  public static float getScreenBrightness(Activity paramActivity)
  {
    // Byte code:
    //   0: fconst_0
    //   1: fstore_1
    //   2: fconst_0
    //   3: fstore_3
    //   4: aload_0
    //   5: invokevirtual 43	android/app/Activity:getWindow	()Landroid/view/Window;
    //   8: astore 5
    //   10: aload 5
    //   12: ifnonnull +8 -> 20
    //   15: ldc 44
    //   17: fstore_1
    //   18: fload_1
    //   19: freturn
    //   20: aload 5
    //   22: invokevirtual 50	android/view/Window:getAttributes	()Landroid/view/WindowManager$LayoutParams;
    //   25: getfield 56	android/view/WindowManager$LayoutParams:screenBrightness	F
    //   28: fstore_2
    //   29: fload_2
    //   30: fconst_0
    //   31: fcmpg
    //   32: iflt +11 -> 43
    //   35: fload_2
    //   36: fstore_1
    //   37: fload_2
    //   38: fconst_1
    //   39: fcmpl
    //   40: ifle +21 -> 61
    //   43: aload_0
    //   44: invokevirtual 60	android/app/Activity:getContentResolver	()Landroid/content/ContentResolver;
    //   47: ldc 62
    //   49: invokestatic 68	android/provider/Settings$System:getInt	(Landroid/content/ContentResolver;Ljava/lang/String;)I
    //   52: istore 4
    //   54: iload 4
    //   56: i2f
    //   57: ldc 69
    //   59: fdiv
    //   60: fstore_1
    //   61: fload_1
    //   62: fstore_2
    //   63: fload_1
    //   64: fconst_1
    //   65: fcmpl
    //   66: ifle +5 -> 71
    //   69: fconst_1
    //   70: fstore_2
    //   71: fload_3
    //   72: fstore_1
    //   73: fload_2
    //   74: fconst_0
    //   75: fcmpg
    //   76: iflt -58 -> 18
    //   79: fload_2
    //   80: freturn
    //   81: astore_0
    //   82: ldc 23
    //   84: iconst_1
    //   85: aload_0
    //   86: iconst_0
    //   87: anewarray 71	java/lang/Object
    //   90: invokestatic 77	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   93: fload_1
    //   94: freturn
    //   95: astore_0
    //   96: fload_2
    //   97: fstore_1
    //   98: goto -16 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	paramActivity	Activity
    //   1	97	1	f1	float
    //   28	69	2	f2	float
    //   3	69	3	f3	float
    //   52	3	4	i	int
    //   8	13	5	localWindow	Window
    // Exception table:
    //   from	to	target	type
    //   20	29	81	java/lang/Exception
    //   43	54	95	java/lang/Exception
  }
  
  public static boolean keepScreenOn(Activity paramActivity, boolean paramBoolean)
  {
    if (paramActivity != null) {}
    for (paramActivity = paramActivity.getWindow(); paramActivity == null; paramActivity = null) {
      return false;
    }
    if (paramBoolean)
    {
      paramActivity.addFlags(128);
      paramActivity.clearFlags(1);
      return true;
    }
    paramActivity.clearFlags(128);
    paramActivity.addFlags(1);
    return true;
  }
  
  public static void setScreenBrightness(Activity paramActivity, float paramFloat)
  {
    if (paramActivity == null) {}
    do
    {
      return;
      paramActivity = paramActivity.getWindow();
    } while (paramActivity == null);
    WindowManager.LayoutParams localLayoutParams = paramActivity.getAttributes();
    localLayoutParams.screenBrightness = paramFloat;
    paramActivity.setAttributes(localLayoutParams);
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    QLog.d("[mini] ScreenJsPlugin", 2, "handleNativeRequest event=" + paramString1 + ",jsonParams=" + paramString2 + ",callbackId=" + paramInt + ",webview=" + paramJsRuntime);
    if ("setScreenBrightness".equals(paramString1)) {
      AppBrandTask.runTaskOnUiThread(new ScreenJsPlugin.3(this, paramString2, paramJsRuntime, paramString1, paramInt));
    }
    for (;;)
    {
      return super.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
      if ("getScreenBrightness".equals(paramString1)) {
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("value", getScreenBrightness(this.jsPluginEngine.appBrandRuntime.activity));
          this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, localJSONObject, paramInt);
        }
        catch (Throwable localThrowable)
        {
          QLog.e("[mini] ScreenJsPlugin", 2, localThrowable, new Object[0]);
        }
      } else if ("setKeepScreenOn".equals(paramString1)) {
        AppBrandTask.runTaskOnUiThread(new ScreenJsPlugin.4(this, paramString2, paramJsRuntime, paramString1, paramInt));
      }
    }
  }
  
  public void onCreate(BaseJsPluginEngine paramBaseJsPluginEngine)
  {
    super.onCreate(paramBaseJsPluginEngine);
    paramBaseJsPluginEngine = ScreenJsPlugin.ScreenShotListenManager.newInstance(paramBaseJsPluginEngine.appBrandRuntime.activity);
    paramBaseJsPluginEngine.setListener(new ScreenJsPlugin.2(this));
    paramBaseJsPluginEngine.startListen();
  }
  
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.ScreenJsPlugin
 * JD-Core Version:    0.7.0.1
 */