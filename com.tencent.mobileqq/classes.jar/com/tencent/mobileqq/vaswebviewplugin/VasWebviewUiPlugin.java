package com.tencent.mobileqq.vaswebviewplugin;

import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.jsp.DeviceApiPlugin;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public abstract class VasWebviewUiPlugin
  extends VasBasePlugin
{
  private static final String TAG = "VasWebviewUiPlugin";
  protected QQBrowserActivity activity;
  protected boolean isHomePageWatingBind = false;
  
  public VasWebviewUiPlugin()
  {
    this.mPluginNameSpace = String.valueOf(getPluginBusiness());
  }
  
  void OnActivityCreate() {}
  
  void OnActivityDestroy()
  {
    if (DeviceApiPlugin.b) {
      DeviceApiPlugin.a(false, null, false);
    }
    if (DeviceApiPlugin.a != null) {
      DeviceApiPlugin.a = null;
    }
  }
  
  void OnActivityPause()
  {
    if (DeviceApiPlugin.b) {
      DeviceApiPlugin.a(false, null, true);
    }
  }
  
  void OnActivityResume()
  {
    if (DeviceApiPlugin.b) {
      DeviceApiPlugin.a(true, this.mRuntime.d(), true);
    }
  }
  
  protected String decodeUrl(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("decodeUrl:");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("VasWebviewUiPlugin", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = paramString.replace("[uin]", this.activity.getAppRuntime().getAccount()).replace("[client]", "androidQQ").replace("[version]", "8.8.17.5770").replace("[sid]", "").replace("[platformId]", "2").replace("[device]", Build.DEVICE).replace("[system]", Build.VERSION.RELEASE);
    Intent localIntent = this.activity.getIntent();
    String str1 = localIntent.getStringExtra("updateTime");
    paramString = (String)localObject;
    if (str1 != null)
    {
      paramString = (String)localObject;
      if (str1.length() > 0) {
        paramString = ((String)localObject).replace("[updateTime]", str1);
      }
    }
    String str2 = localIntent.getStringExtra("adTag");
    localObject = paramString;
    if (str1 != null)
    {
      localObject = paramString;
      if (str1.length() > 0) {
        localObject = paramString.replace("[adTag]", str2);
      }
    }
    paramString = ((String)localObject).replace("[updateFlag]", Boolean.valueOf(localIntent.getBooleanExtra("updateFlag", false)).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(localIntent.getIntExtra("updateId", 0));
    return paramString.replace("[updateId]", ((StringBuilder)localObject).toString()).replace("[density]", ThemeUtil.getThemeDensity(this.activity));
  }
  
  void doAfterFinish() {}
  
  void doBeforeFinish() {}
  
  protected boolean excuteEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    return false;
  }
  
  /* Error */
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 87	com/tencent/mobileqq/vaswebviewplugin/VasWebviewUiPlugin:activity	Lcom/tencent/mobileqq/activity/QQBrowserActivity;
    //   4: ifnull +245 -> 249
    //   7: aload_0
    //   8: getfield 199	com/tencent/mobileqq/vaswebviewplugin/VasWebviewUiPlugin:business	J
    //   11: aload_0
    //   12: invokevirtual 22	com/tencent/mobileqq/vaswebviewplugin/VasWebviewUiPlugin:getPluginBusiness	()J
    //   15: land
    //   16: lconst_0
    //   17: lcmp
    //   18: ifne +5 -> 23
    //   21: iconst_0
    //   22: ireturn
    //   23: new 68	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   30: astore 6
    //   32: aload 6
    //   34: ldc 201
    //   36: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload 6
    //   42: lload_2
    //   43: invokevirtual 204	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload 6
    //   49: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: astore 6
    //   54: aconst_null
    //   55: aload 6
    //   57: invokestatic 209	com/tencent/mobileqq/utils/StartupTracker:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   60: lload_2
    //   61: lconst_1
    //   62: lcmp
    //   63: ifne +10 -> 73
    //   66: aload_0
    //   67: invokevirtual 211	com/tencent/mobileqq/vaswebviewplugin/VasWebviewUiPlugin:OnActivityCreate	()V
    //   70: goto +140 -> 210
    //   73: lload_2
    //   74: ldc2_w 212
    //   77: lcmp
    //   78: ifne +10 -> 88
    //   81: aload_0
    //   82: invokevirtual 215	com/tencent/mobileqq/vaswebviewplugin/VasWebviewUiPlugin:OnActivityDestroy	()V
    //   85: goto +125 -> 210
    //   88: lload_2
    //   89: ldc2_w 216
    //   92: lcmp
    //   93: ifne +10 -> 103
    //   96: aload_0
    //   97: invokevirtual 219	com/tencent/mobileqq/vaswebviewplugin/VasWebviewUiPlugin:OnActivityResume	()V
    //   100: goto +110 -> 210
    //   103: lload_2
    //   104: ldc2_w 220
    //   107: lcmp
    //   108: ifne +151 -> 259
    //   111: aload_0
    //   112: invokevirtual 223	com/tencent/mobileqq/vaswebviewplugin/VasWebviewUiPlugin:OnActivityPause	()V
    //   115: goto +95 -> 210
    //   118: lload_2
    //   119: ldc2_w 224
    //   122: lcmp
    //   123: ifne +60 -> 183
    //   126: aload_0
    //   127: aload 4
    //   129: ldc 227
    //   131: invokeinterface 233 2 0
    //   136: checkcast 235	java/lang/Integer
    //   139: invokevirtual 238	java/lang/Integer:intValue	()I
    //   142: aload 4
    //   144: ldc 240
    //   146: invokeinterface 233 2 0
    //   151: checkcast 235	java/lang/Integer
    //   154: invokevirtual 238	java/lang/Integer:intValue	()I
    //   157: aload 4
    //   159: ldc 242
    //   161: invokeinterface 233 2 0
    //   166: checkcast 140	android/content/Intent
    //   169: invokevirtual 246	com/tencent/mobileqq/vaswebviewplugin/VasWebviewUiPlugin:onActivityResult	(IILandroid/content/Intent;)Z
    //   172: istore 5
    //   174: aload 6
    //   176: aconst_null
    //   177: invokestatic 209	com/tencent/mobileqq/utils/StartupTracker:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   180: iload 5
    //   182: ireturn
    //   183: lload_2
    //   184: ldc2_w 247
    //   187: lcmp
    //   188: ifne +10 -> 198
    //   191: aload_0
    //   192: invokevirtual 250	com/tencent/mobileqq/vaswebviewplugin/VasWebviewUiPlugin:doBeforeFinish	()V
    //   195: goto +15 -> 210
    //   198: lload_2
    //   199: ldc2_w 251
    //   202: lcmp
    //   203: ifne +7 -> 210
    //   206: aload_0
    //   207: invokevirtual 254	com/tencent/mobileqq/vaswebviewplugin/VasWebviewUiPlugin:doAfterFinish	()V
    //   210: aload_0
    //   211: aload_1
    //   212: lload_2
    //   213: aload 4
    //   215: invokevirtual 256	com/tencent/mobileqq/vaswebviewplugin/VasWebviewUiPlugin:excuteEvent	(Ljava/lang/String;JLjava/util/Map;)Z
    //   218: istore 5
    //   220: aload 6
    //   222: aconst_null
    //   223: invokestatic 209	com/tencent/mobileqq/utils/StartupTracker:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   226: iload 5
    //   228: ireturn
    //   229: aload_1
    //   230: invokevirtual 259	java/lang/Exception:printStackTrace	()V
    //   233: aload 6
    //   235: aconst_null
    //   236: invokestatic 209	com/tencent/mobileqq/utils/StartupTracker:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   239: iconst_0
    //   240: ireturn
    //   241: aload 6
    //   243: aconst_null
    //   244: invokestatic 209	com/tencent/mobileqq/utils/StartupTracker:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   247: aload_1
    //   248: athrow
    //   249: iconst_0
    //   250: ireturn
    //   251: astore_1
    //   252: goto -11 -> 241
    //   255: astore_1
    //   256: goto -27 -> 229
    //   259: lload_2
    //   260: ldc2_w 260
    //   263: lcmp
    //   264: ifne -146 -> 118
    //   267: goto -57 -> 210
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	270	0	this	VasWebviewUiPlugin
    //   0	270	1	paramString	String
    //   0	270	2	paramLong	long
    //   0	270	4	paramMap	Map<String, Object>
    //   172	55	5	bool	boolean
    //   30	212	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   66	70	251	finally
    //   81	85	251	finally
    //   96	100	251	finally
    //   111	115	251	finally
    //   126	174	251	finally
    //   191	195	251	finally
    //   206	210	251	finally
    //   210	220	251	finally
    //   229	233	251	finally
    //   66	70	255	java/lang/Exception
    //   81	85	255	java/lang/Exception
    //   96	100	255	java/lang/Exception
    //   111	115	255	java/lang/Exception
    //   126	174	255	java/lang/Exception
    //   191	195	255	java/lang/Exception
    //   206	210	255	java/lang/Exception
    //   210	220	255	java/lang/Exception
  }
  
  boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    return false;
  }
  
  protected void onCreate()
  {
    super.onCreate();
    if ((this.mRuntime.d() instanceof QQBrowserActivity)) {
      this.activity = ((QQBrowserActivity)this.mRuntime.d());
    }
  }
  
  protected void sendRemoteReq(Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.business != 0L) && ((getPluginBusiness() & this.business) == 0L)) {
      return;
    }
    if (!((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded())
    {
      if (paramBoolean2) {
        Toast.makeText(BaseApplication.getContext(), HardCodeUtil.a(2131913260), 0).show();
      }
    }
    else
    {
      if (paramBoolean1)
      {
        ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReqWithoutTimeout(paramBundle);
        return;
      }
      ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(paramBundle);
    }
  }
  
  protected void webviewLoadUrl(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("now try open url: ");
      localStringBuilder.append(paramString);
      QLog.i("VasWebviewUiPlugin", 2, localStringBuilder.toString());
    }
    if (this.mRuntime.a() != null)
    {
      this.mRuntime.a().loadUrl(paramString);
      return;
    }
    ThreadManager.getUIHandler().post(new VasWebviewUiPlugin.1(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.VasWebviewUiPlugin
 * JD-Core Version:    0.7.0.1
 */