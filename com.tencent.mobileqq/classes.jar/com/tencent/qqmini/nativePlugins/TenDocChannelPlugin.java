package com.tencent.qqmini.nativePlugins;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin(secondary=true)
public class TenDocChannelPlugin
  extends BaseJsPlugin
{
  private JSONObject a(RequestEvent paramRequestEvent)
  {
    try
    {
      localObject = new JSONObject(paramRequestEvent.jsonParams);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      Object localObject;
      label14:
      break label14;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Failed to parse jsonParams=");
    ((StringBuilder)localObject).append(paramRequestEvent.jsonParams);
    QLog.e("TenDocChannelPlugin", 1, ((StringBuilder)localObject).toString());
    return null;
  }
  
  /* Error */
  private void a(Activity paramActivity, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 18	org/json/JSONObject
    //   5: dup
    //   6: aload_2
    //   7: invokespecial 27	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10: astore 7
    //   12: aload 7
    //   14: ldc 53
    //   16: invokevirtual 57	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   19: istore_3
    //   20: aload 7
    //   22: ldc 59
    //   24: invokevirtual 63	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   27: astore 5
    //   29: aload 7
    //   31: ldc 65
    //   33: invokevirtual 63	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   36: astore_2
    //   37: new 67	android/os/Bundle
    //   40: dup
    //   41: invokespecial 68	android/os/Bundle:<init>	()V
    //   44: astore 6
    //   46: aload 6
    //   48: ldc 70
    //   50: iload_3
    //   51: invokevirtual 74	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   54: aload 6
    //   56: ldc 59
    //   58: aload 5
    //   60: invokevirtual 78	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: aload 6
    //   65: ldc 65
    //   67: aload_2
    //   68: invokevirtual 78	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: aconst_null
    //   72: astore 4
    //   74: aload 4
    //   76: astore_2
    //   77: aload_1
    //   78: instanceof 80
    //   81: ifeq +27 -> 108
    //   84: aload 4
    //   86: astore_2
    //   87: aload_1
    //   88: checkcast 80	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity
    //   91: invokevirtual 84	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity:getHostWebView	()Lcom/tencent/smtt/sdk/WebView;
    //   94: ifnull +14 -> 108
    //   97: aload_1
    //   98: checkcast 80	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity
    //   101: invokevirtual 84	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity:getHostWebView	()Lcom/tencent/smtt/sdk/WebView;
    //   104: invokevirtual 89	com/tencent/smtt/sdk/WebView:getUrl	()Ljava/lang/String;
    //   107: astore_2
    //   108: aload_2
    //   109: astore_1
    //   110: aload_2
    //   111: invokestatic 95	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   114: ifeq +11 -> 125
    //   117: aload 7
    //   119: ldc 97
    //   121: invokevirtual 63	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   124: astore_1
    //   125: aload 6
    //   127: ldc 99
    //   129: aload_1
    //   130: invokevirtual 78	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   133: aload 6
    //   135: ldc 101
    //   137: invokestatic 107	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   140: aload 5
    //   142: invokevirtual 110	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   145: invokevirtual 78	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: aload 6
    //   150: ldc 112
    //   152: iconst_1
    //   153: invokevirtual 74	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   156: invokestatic 117	com/tencent/mobileqq/qipc/QIPCClientHelper:getInstance	()Lcom/tencent/mobileqq/qipc/QIPCClientHelper;
    //   159: invokevirtual 121	com/tencent/mobileqq/qipc/QIPCClientHelper:getClient	()Leipc/EIPCClient;
    //   162: ldc 123
    //   164: ldc 125
    //   166: aload 6
    //   168: invokevirtual 131	eipc/EIPCClient:callServer	(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Leipc/EIPCResult;
    //   171: pop
    //   172: goto +42 -> 214
    //   175: astore_1
    //   176: goto +41 -> 217
    //   179: astore_1
    //   180: new 29	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   187: astore_2
    //   188: aload_2
    //   189: ldc 133
    //   191: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload_2
    //   196: aload_1
    //   197: invokevirtual 134	java/lang/Exception:toString	()Ljava/lang/String;
    //   200: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: ldc 38
    //   206: iconst_1
    //   207: aload_2
    //   208: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: invokestatic 48	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   214: aload_0
    //   215: monitorexit
    //   216: return
    //   217: aload_0
    //   218: monitorexit
    //   219: aload_1
    //   220: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	221	0	this	TenDocChannelPlugin
    //   0	221	1	paramActivity	Activity
    //   0	221	2	paramString	String
    //   19	32	3	bool	boolean
    //   72	13	4	localObject	Object
    //   27	114	5	str	String
    //   44	123	6	localBundle	android.os.Bundle
    //   10	108	7	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   2	71	175	finally
    //   77	84	175	finally
    //   87	108	175	finally
    //   110	125	175	finally
    //   125	172	175	finally
    //   180	214	175	finally
    //   2	71	179	java/lang/Exception
    //   77	84	179	java/lang/Exception
    //   87	108	179	java/lang/Exception
    //   110	125	179	java/lang/Exception
    //   125	172	179	java/lang/Exception
  }
  
  /* Error */
  private void b(Activity paramActivity, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 18	org/json/JSONObject
    //   5: dup
    //   6: aload_2
    //   7: invokespecial 27	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10: ldc 65
    //   12: invokevirtual 63	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15: astore_1
    //   16: new 67	android/os/Bundle
    //   19: dup
    //   20: invokespecial 68	android/os/Bundle:<init>	()V
    //   23: astore_2
    //   24: aload_2
    //   25: ldc 65
    //   27: aload_1
    //   28: invokevirtual 78	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: ldc 38
    //   33: iconst_1
    //   34: ldc 137
    //   36: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   39: aload_2
    //   40: ldc 112
    //   42: iconst_1
    //   43: invokevirtual 74	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   46: invokestatic 117	com/tencent/mobileqq/qipc/QIPCClientHelper:getInstance	()Lcom/tencent/mobileqq/qipc/QIPCClientHelper;
    //   49: invokevirtual 121	com/tencent/mobileqq/qipc/QIPCClientHelper:getClient	()Leipc/EIPCClient;
    //   52: ldc 123
    //   54: ldc 142
    //   56: aload_2
    //   57: invokevirtual 131	eipc/EIPCClient:callServer	(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Leipc/EIPCResult;
    //   60: pop
    //   61: aconst_null
    //   62: ldc 144
    //   64: invokestatic 149	com/tencent/mobileqq/teamwork/tencentdocreport/TenDocLogReportHelper:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;)V
    //   67: goto +42 -> 109
    //   70: astore_1
    //   71: goto +41 -> 112
    //   74: astore_1
    //   75: new 29	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   82: astore_2
    //   83: aload_2
    //   84: ldc 151
    //   86: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload_2
    //   91: aload_1
    //   92: invokevirtual 134	java/lang/Exception:toString	()Ljava/lang/String;
    //   95: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: ldc 38
    //   101: iconst_1
    //   102: aload_2
    //   103: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokestatic 48	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   109: aload_0
    //   110: monitorexit
    //   111: return
    //   112: aload_0
    //   113: monitorexit
    //   114: aload_1
    //   115: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	this	TenDocChannelPlugin
    //   0	116	1	paramActivity	Activity
    //   0	116	2	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	67	70	finally
    //   75	109	70	finally
    //   2	67	74	java/lang/Exception
  }
  
  /* Error */
  private void c(Activity paramActivity, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 18	org/json/JSONObject
    //   5: dup
    //   6: aload_2
    //   7: invokespecial 27	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10: ldc 154
    //   12: invokevirtual 63	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15: astore_2
    //   16: new 156	android/content/Intent
    //   19: dup
    //   20: invokespecial 157	android/content/Intent:<init>	()V
    //   23: astore_3
    //   24: aload_3
    //   25: aload_1
    //   26: ldc 159
    //   28: invokevirtual 163	android/content/Intent:setClassName	(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;
    //   31: pop
    //   32: aload_3
    //   33: getstatic 168	com/tencent/mobileqq/teamwork/TeamWorkConstants:f	Ljava/lang/String;
    //   36: iconst_1
    //   37: invokevirtual 172	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   40: pop
    //   41: aload_3
    //   42: ldc 173
    //   44: invokevirtual 177	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   47: pop
    //   48: aload_3
    //   49: ldc 179
    //   51: iconst_1
    //   52: invokevirtual 172	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   55: pop
    //   56: aload_3
    //   57: ldc 181
    //   59: bipush 9
    //   61: invokevirtual 184	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   64: pop
    //   65: aload_3
    //   66: ldc 186
    //   68: sipush 10006
    //   71: invokevirtual 184	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   74: pop
    //   75: aload_3
    //   76: ldc 188
    //   78: bipush 9
    //   80: invokevirtual 184	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   83: pop
    //   84: aload_3
    //   85: ldc 190
    //   87: bipush 7
    //   89: invokevirtual 184	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   92: pop
    //   93: aload_3
    //   94: ldc 192
    //   96: iconst_1
    //   97: invokevirtual 172	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   100: pop
    //   101: aload_3
    //   102: getstatic 195	com/tencent/mobileqq/teamwork/TeamWorkConstants:g	Ljava/lang/String;
    //   105: aload_2
    //   106: invokevirtual 198	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   109: pop
    //   110: aload_3
    //   111: ldc 200
    //   113: bipush 8
    //   115: invokevirtual 184	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   118: pop
    //   119: aload_1
    //   120: aload_3
    //   121: invokevirtual 206	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   124: goto +17 -> 141
    //   127: astore_1
    //   128: goto +16 -> 144
    //   131: astore_1
    //   132: ldc 38
    //   134: iconst_1
    //   135: ldc 208
    //   137: aload_1
    //   138: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   141: aload_0
    //   142: monitorexit
    //   143: return
    //   144: aload_0
    //   145: monitorexit
    //   146: aload_1
    //   147: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	this	TenDocChannelPlugin
    //   0	148	1	paramActivity	Activity
    //   0	148	2	paramString	String
    //   23	98	3	localIntent	android.content.Intent
    // Exception table:
    //   from	to	target	type
    //   2	124	127	finally
    //   132	141	127	finally
    //   2	124	131	java/lang/Exception
  }
  
  @JsEvent({"tdoc_channel"})
  public void tdocChannel(RequestEvent paramRequestEvent)
  {
    try
    {
      paramRequestEvent = a(paramRequestEvent);
      if (paramRequestEvent != null)
      {
        Object localObject = new JSONObject(paramRequestEvent.optString("data"));
        paramRequestEvent = ((JSONObject)localObject).getString("action");
        localObject = ((JSONObject)localObject).getString("data");
        Activity localActivity = this.mMiniAppContext.getAttachedActivity();
        if (TextUtils.equals(paramRequestEvent, "openLocalFilesToImport"))
        {
          c(localActivity, (String)localObject);
          return;
        }
        if (TextUtils.equals(paramRequestEvent, "txDocsStartExport"))
        {
          b(localActivity, (String)localObject);
          return;
        }
        if (TextUtils.equals(paramRequestEvent, "openExportedFile"))
        {
          a(localActivity, (String)localObject);
          return;
        }
      }
    }
    catch (JSONException paramRequestEvent)
    {
      QLog.e("TenDocChannelPlugin", 1, "parse param failed", paramRequestEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.TenDocChannelPlugin
 * JD-Core Version:    0.7.0.1
 */