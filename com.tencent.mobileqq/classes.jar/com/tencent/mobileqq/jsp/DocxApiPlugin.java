package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment;
import com.tencent.mobileqq.activity.TeamWorkPicBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.tendoc.TencentDocPreloadConfigBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocPreloadConfigProcessor;
import com.tencent.mobileqq.doc.TencentDocEntryUtils;
import com.tencent.mobileqq.doc.TencentDocGuideDialog;
import com.tencent.mobileqq.doc.TencentDocGuideHelper;
import com.tencent.mobileqq.picbrowser.PicInfo;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qmethodmonitor.monitor.ClipboardMonitor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.SharePolicyInfo;
import com.tencent.mobileqq.teamwork.TeamWorkConstants;
import com.tencent.mobileqq.teamwork.TeamWorkForceShare;
import com.tencent.mobileqq.teamwork.TeamWorkHandlerUtils;
import com.tencent.mobileqq.teamwork.TeamWorkShareActionSheetBuilder;
import com.tencent.mobileqq.teamwork.TenDocWebPreLoadHelper;
import com.tencent.mobileqq.teamwork.TenDocWebViewPool;
import com.tencent.mobileqq.teamwork.api.ICameraHelper;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFacadeCreator;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamwork.api.IVoiceInputHelper;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.webview.swift.IPreCreatePluginChecker;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.UnVisibleWebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import eipc.EIPCClient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DocxApiPlugin
  extends WebViewPlugin
  implements IPreCreatePluginChecker
{
  private TencentDocGuideDialog a = null;
  private ICameraHelper b;
  private IVoiceInputHelper c;
  private String d = null;
  
  public DocxApiPlugin()
  {
    this.mPluginNameSpace = "docx";
  }
  
  private void a()
  {
    ThreadManager.excute(new DocxApiPlugin.6(this), 64, null, false);
  }
  
  public static void a(String paramString, TouchWebView paramTouchWebView)
  {
    if (!TencentDocPreloadConfigProcessor.a().c()) {
      try
      {
        paramString = new JSONObject();
        paramString.put("retcode", 1);
        ThreadManager.getUIHandler().post(new DocxApiPlugin.7(paramTouchWebView, paramString));
        return;
      }
      catch (JSONException paramString)
      {
        QLog.e("DocxApiPlugin", 1, "JSONException ", paramString);
        return;
      }
    }
    if ((!TextUtils.isEmpty(paramString)) && (TenDocWebViewPool.a != null) && (TenDocWebViewPool.a.get(paramString) != null) && (((Integer)TenDocWebViewPool.a.get(paramString)).intValue() == 2))
    {
      TenDocWebViewPool.a.remove(paramString);
      if (TeamWorkHandlerUtils.c(paramString))
      {
        ThreadManager.excute(new DocxApiPlugin.8(paramString, paramTouchWebView), 64, null, false);
        return;
      }
      try
      {
        paramString = new JSONObject();
        paramString.put("retcode", 1);
        ThreadManager.getUIHandler().post(new DocxApiPlugin.9(paramTouchWebView, paramString));
        return;
      }
      catch (JSONException paramString)
      {
        QLog.e("DocxApiPlugin", 1, "JSONException ", paramString);
      }
    }
  }
  
  private void a(ArrayList<String> paramArrayList)
  {
    ThreadManager.excute(new DocxApiPlugin.5(this, paramArrayList), 128, null, false);
  }
  
  private void h(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("req json = ");
    localStringBuilder.append(paramString);
    QLog.d("DocxApiPlugin", 2, localStringBuilder.toString());
    try
    {
      paramString = new JSONObject(paramString);
      this.d = paramString.optString("callback");
      new TeamWorkForceShare(this, paramString).a();
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 58	org/json/JSONObject
    //   5: dup
    //   6: aload_1
    //   7: invokespecial 156	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10: astore 6
    //   12: aload 6
    //   14: ldc 174
    //   16: invokevirtual 177	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   19: istore_2
    //   20: aload 6
    //   22: ldc 179
    //   24: invokevirtual 162	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   27: astore 4
    //   29: aload 6
    //   31: ldc 181
    //   33: invokevirtual 162	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   36: astore_1
    //   37: new 183	android/os/Bundle
    //   40: dup
    //   41: invokespecial 184	android/os/Bundle:<init>	()V
    //   44: astore 5
    //   46: aload 5
    //   48: ldc 186
    //   50: iload_2
    //   51: invokevirtual 190	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   54: aload 5
    //   56: ldc 179
    //   58: aload 4
    //   60: invokevirtual 194	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: aload 5
    //   65: ldc 181
    //   67: aload_1
    //   68: invokevirtual 194	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: aload_0
    //   72: getfield 198	com/tencent/mobileqq/jsp/DocxApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   75: invokevirtual 203	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:d	()Landroid/app/Activity;
    //   78: astore 7
    //   80: aconst_null
    //   81: astore_3
    //   82: aload_3
    //   83: astore_1
    //   84: aload 7
    //   86: instanceof 205
    //   89: ifeq +28 -> 117
    //   92: aload_3
    //   93: astore_1
    //   94: aload 7
    //   96: checkcast 205	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity
    //   99: invokevirtual 209	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity:getHostWebView	()Lcom/tencent/smtt/sdk/WebView;
    //   102: ifnull +15 -> 117
    //   105: aload 7
    //   107: checkcast 205	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity
    //   110: invokevirtual 209	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity:getHostWebView	()Lcom/tencent/smtt/sdk/WebView;
    //   113: invokevirtual 214	com/tencent/smtt/sdk/WebView:getUrl	()Ljava/lang/String;
    //   116: astore_1
    //   117: aload_1
    //   118: astore_3
    //   119: aload_1
    //   120: invokestatic 96	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   123: ifeq +11 -> 134
    //   126: aload 6
    //   128: ldc 216
    //   130: invokevirtual 162	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   133: astore_3
    //   134: aload 5
    //   136: ldc 218
    //   138: aload_3
    //   139: invokevirtual 194	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   142: aload 5
    //   144: ldc 220
    //   146: invokestatic 226	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   149: aload 4
    //   151: invokevirtual 229	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   154: invokevirtual 194	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   157: invokestatic 234	com/tencent/mobileqq/qipc/QIPCClientHelper:getInstance	()Lcom/tencent/mobileqq/qipc/QIPCClientHelper;
    //   160: invokevirtual 238	com/tencent/mobileqq/qipc/QIPCClientHelper:getClient	()Leipc/EIPCClient;
    //   163: ldc 240
    //   165: ldc 242
    //   167: aload 5
    //   169: invokevirtual 248	eipc/EIPCClient:callServer	(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Leipc/EIPCResult;
    //   172: pop
    //   173: goto +42 -> 215
    //   176: astore_1
    //   177: goto +41 -> 218
    //   180: astore_1
    //   181: new 140	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   188: astore_3
    //   189: aload_3
    //   190: ldc 250
    //   192: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload_3
    //   197: aload_1
    //   198: invokevirtual 251	java/lang/Exception:toString	()Ljava/lang/String;
    //   201: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: ldc 82
    //   207: iconst_1
    //   208: aload_3
    //   209: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 253	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   215: aload_0
    //   216: monitorexit
    //   217: return
    //   218: aload_0
    //   219: monitorexit
    //   220: aload_1
    //   221: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	this	DocxApiPlugin
    //   0	222	1	paramString	String
    //   19	32	2	bool	boolean
    //   81	128	3	localObject	Object
    //   27	123	4	str	String
    //   44	124	5	localBundle	android.os.Bundle
    //   10	117	6	localJSONObject	JSONObject
    //   78	28	7	localActivity	Activity
    // Exception table:
    //   from	to	target	type
    //   2	80	176	finally
    //   84	92	176	finally
    //   94	117	176	finally
    //   119	134	176	finally
    //   134	173	176	finally
    //   181	215	176	finally
    //   2	80	180	java/lang/Exception
    //   84	92	180	java/lang/Exception
    //   94	117	180	java/lang/Exception
    //   119	134	180	java/lang/Exception
    //   134	173	180	java/lang/Exception
  }
  
  /* Error */
  public void b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 58	org/json/JSONObject
    //   5: dup
    //   6: aload_1
    //   7: invokespecial 156	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10: astore 6
    //   12: aload 6
    //   14: ldc 174
    //   16: invokevirtual 177	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   19: istore_2
    //   20: aload 6
    //   22: ldc 179
    //   24: invokevirtual 162	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   27: astore 4
    //   29: aload 6
    //   31: ldc 181
    //   33: invokevirtual 162	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   36: astore 5
    //   38: aload_0
    //   39: getfield 198	com/tencent/mobileqq/jsp/DocxApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   42: invokevirtual 203	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:d	()Landroid/app/Activity;
    //   45: astore 7
    //   47: aconst_null
    //   48: astore_3
    //   49: aload_3
    //   50: astore_1
    //   51: aload 7
    //   53: instanceof 205
    //   56: ifeq +28 -> 84
    //   59: aload_3
    //   60: astore_1
    //   61: aload 7
    //   63: checkcast 205	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity
    //   66: invokevirtual 209	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity:getHostWebView	()Lcom/tencent/smtt/sdk/WebView;
    //   69: ifnull +15 -> 84
    //   72: aload 7
    //   74: checkcast 205	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity
    //   77: invokevirtual 209	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity:getHostWebView	()Lcom/tencent/smtt/sdk/WebView;
    //   80: invokevirtual 214	com/tencent/smtt/sdk/WebView:getUrl	()Ljava/lang/String;
    //   83: astore_1
    //   84: aload_1
    //   85: astore_3
    //   86: aload_1
    //   87: invokestatic 96	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   90: ifeq +11 -> 101
    //   93: aload 6
    //   95: ldc 216
    //   97: invokevirtual 162	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   100: astore_3
    //   101: invokestatic 226	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   104: aload 4
    //   106: invokevirtual 229	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   109: astore_1
    //   110: new 183	android/os/Bundle
    //   113: dup
    //   114: invokespecial 184	android/os/Bundle:<init>	()V
    //   117: astore 6
    //   119: aload 6
    //   121: ldc 186
    //   123: iload_2
    //   124: invokevirtual 190	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   127: aload 6
    //   129: ldc 179
    //   131: aload 4
    //   133: invokevirtual 194	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: aload 6
    //   138: ldc 181
    //   140: aload 5
    //   142: invokevirtual 194	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   145: aload 6
    //   147: ldc 218
    //   149: aload_3
    //   150: invokevirtual 194	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   153: aload 6
    //   155: ldc 220
    //   157: aload_1
    //   158: invokevirtual 194	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: aload 6
    //   163: ldc 255
    //   165: iconst_0
    //   166: invokevirtual 190	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   169: aload_0
    //   170: getfield 198	com/tencent/mobileqq/jsp/DocxApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   173: invokevirtual 203	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:d	()Landroid/app/Activity;
    //   176: aload 5
    //   178: invokestatic 260	com/tencent/mobileqq/teamwork/TeamWorkExportUtil:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/filemanager/data/ForwardFileInfo;
    //   181: aload 6
    //   183: invokestatic 263	com/tencent/mobileqq/teamwork/TeamWorkExportUtil:a	(Landroid/app/Activity;Lcom/tencent/mobileqq/filemanager/data/ForwardFileInfo;Landroid/os/Bundle;)V
    //   186: goto +43 -> 229
    //   189: astore_1
    //   190: goto +42 -> 232
    //   193: astore_1
    //   194: new 140	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   201: astore_3
    //   202: aload_3
    //   203: ldc_w 265
    //   206: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: aload_3
    //   211: aload_1
    //   212: invokevirtual 251	java/lang/Exception:toString	()Ljava/lang/String;
    //   215: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: ldc 82
    //   221: iconst_1
    //   222: aload_3
    //   223: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 253	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   229: aload_0
    //   230: monitorexit
    //   231: return
    //   232: aload_0
    //   233: monitorexit
    //   234: aload_1
    //   235: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	236	0	this	DocxApiPlugin
    //   0	236	1	paramString	String
    //   19	105	2	bool	boolean
    //   48	175	3	localObject1	Object
    //   27	105	4	str1	String
    //   36	141	5	str2	String
    //   10	172	6	localObject2	Object
    //   45	28	7	localActivity	Activity
    // Exception table:
    //   from	to	target	type
    //   2	47	189	finally
    //   51	59	189	finally
    //   61	84	189	finally
    //   86	101	189	finally
    //   101	186	189	finally
    //   194	229	189	finally
    //   2	47	193	java/lang/Exception
    //   51	59	193	java/lang/Exception
    //   61	84	193	java/lang/Exception
    //   86	101	193	java/lang/Exception
    //   101	186	193	java/lang/Exception
  }
  
  /* Error */
  public void c(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 58	org/json/JSONObject
    //   5: dup
    //   6: aload_1
    //   7: invokespecial 156	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10: ldc 181
    //   12: invokevirtual 162	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15: astore_1
    //   16: new 183	android/os/Bundle
    //   19: dup
    //   20: invokespecial 184	android/os/Bundle:<init>	()V
    //   23: ldc 181
    //   25: aload_1
    //   26: invokevirtual 194	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: aload_0
    //   30: getfield 198	com/tencent/mobileqq/jsp/DocxApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   33: invokevirtual 203	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:d	()Landroid/app/Activity;
    //   36: aload_1
    //   37: invokestatic 268	com/tencent/mobileqq/teamwork/TeamWorkExportUtil:a	(Landroid/app/Activity;Ljava/lang/String;)V
    //   40: goto +43 -> 83
    //   43: astore_1
    //   44: goto +42 -> 86
    //   47: astore_1
    //   48: new 140	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   55: astore_2
    //   56: aload_2
    //   57: ldc_w 270
    //   60: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload_2
    //   65: aload_1
    //   66: invokevirtual 251	java/lang/Exception:toString	()Ljava/lang/String;
    //   69: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: ldc 82
    //   75: iconst_1
    //   76: aload_2
    //   77: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 253	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   83: aload_0
    //   84: monitorexit
    //   85: return
    //   86: aload_0
    //   87: monitorexit
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	DocxApiPlugin
    //   0	90	1	paramString	String
    //   55	22	2	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	40	43	finally
    //   48	83	43	finally
    //   2	40	47	java/lang/Exception
  }
  
  /* Error */
  public void d(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 58	org/json/JSONObject
    //   5: dup
    //   6: aload_1
    //   7: invokespecial 156	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10: ldc_w 272
    //   13: invokevirtual 162	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16: astore_1
    //   17: aload_0
    //   18: getfield 198	com/tencent/mobileqq/jsp/DocxApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   21: invokevirtual 203	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:d	()Landroid/app/Activity;
    //   24: checkcast 274	com/tencent/mobileqq/activity/QQBrowserActivity
    //   27: astore_2
    //   28: new 276	com/tencent/mobileqq/jsp/DocxApiPlugin$10
    //   31: dup
    //   32: aload_0
    //   33: aload_2
    //   34: aload_2
    //   35: invokevirtual 277	com/tencent/mobileqq/activity/QQBrowserActivity:getHostWebView	()Lcom/tencent/smtt/sdk/WebView;
    //   38: invokevirtual 214	com/tencent/smtt/sdk/WebView:getUrl	()Ljava/lang/String;
    //   41: invokespecial 280	com/tencent/mobileqq/jsp/DocxApiPlugin$10:<init>	(Lcom/tencent/mobileqq/jsp/DocxApiPlugin;Lcom/tencent/mobileqq/activity/QQBrowserActivity;Ljava/lang/String;)V
    //   44: aconst_null
    //   45: iconst_1
    //   46: invokestatic 284	com/tencent/mobileqq/app/ThreadManager:postImmediately	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   49: ldc_w 286
    //   52: invokestatic 292	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   55: checkcast 286	com/tencent/mobileqq/filemanager/api/IQQFileSelector
    //   58: aload_2
    //   59: aload_1
    //   60: invokeinterface 295 3 0
    //   65: aload_2
    //   66: ldc_w 296
    //   69: ldc_w 297
    //   72: invokevirtual 301	com/tencent/mobileqq/activity/QQBrowserActivity:overridePendingTransition	(II)V
    //   75: goto +43 -> 118
    //   78: astore_1
    //   79: goto +42 -> 121
    //   82: astore_1
    //   83: new 140	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   90: astore_2
    //   91: aload_2
    //   92: ldc_w 303
    //   95: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload_2
    //   100: aload_1
    //   101: invokevirtual 251	java/lang/Exception:toString	()Ljava/lang/String;
    //   104: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: ldc 82
    //   110: iconst_1
    //   111: aload_2
    //   112: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 253	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   118: aload_0
    //   119: monitorexit
    //   120: return
    //   121: aload_0
    //   122: monitorexit
    //   123: aload_1
    //   124: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	DocxApiPlugin
    //   0	125	1	paramString	String
    //   27	85	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	75	78	finally
    //   83	118	78	finally
    //   2	75	82	java/lang/Exception
  }
  
  public boolean e(String paramString)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
        return false;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("DocxApiPlugin");
      ((StringBuilder)localObject1).append(TeamWorkConstants.j);
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("sendDocToChat been called. strJson = ");
      ((StringBuilder)localObject2).append(paramString);
      QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      localObject2 = "https://url.cn/UQoBHn";
    }
    finally
    {
      Object localObject1;
      String str3;
      String str2;
      String str7;
      String str4;
      String str8;
      String str9;
      String str5;
      String str6;
      int i;
      QQBrowserActivity localQQBrowserActivity;
      label757:
      for (;;)
      {
        label252:
        throw paramString;
      }
    }
    try
    {
      paramString = new JSONObject(paramString);
      str3 = paramString.optString("title");
      str2 = paramString.optString("desc");
      str7 = paramString.optString("share_url");
      str4 = paramString.optString("image_url");
      str8 = paramString.optString("type");
      str9 = paramString.optString("miniprogram_image_url");
      str5 = paramString.optString("graytipsinfo");
      str6 = paramString.optString("to_uin");
      i = paramString.optInt("uin_type");
      localQQBrowserActivity = (QQBrowserActivity)this.mRuntime.d();
      localObject1 = localQQBrowserActivity.getIntent().getStringExtra("sourceName");
      if (!((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).isDocsUrl(str7)) {
        break label811;
      }
      localObject1 = HardCodeUtil.a(2131901518);
      paramString = "https://docs.qq.com/desktop/m/index.html?_wv=2";
      str1 = "web";
      localObject2 = "https://docs.qq.com/desktop/favicon.ico";
      l = 101458937L;
    }
    catch (JSONException paramString)
    {
      break label757;
      str1 = " ";
      l = 801097412L;
      localIntent = null;
      paramString = (String)localObject2;
      localObject2 = localIntent;
      break label252;
    }
    localIntent = new Intent();
    localIntent.putExtra("type", str8);
    localIntent.putExtra("miniprogram_image_url", str9);
    localIntent.putExtra("key_flag_from_plugin", true);
    localIntent.setClass(localQQBrowserActivity, ForwardRecentActivity.class);
    localIntent.putExtra("isFromShare", true);
    localIntent.putExtra("forward_type", 1001);
    localIntent.putExtra("pluginName", "web_share");
    localIntent.putExtra("req_type", 95);
    localIntent.putExtra("detail_url", str7);
    localIntent.putExtra("image_url_remote", str4);
    if (l != -1L) {
      localIntent.putExtra("req_share_id", l);
    }
    localIntent.putExtra("source_url", paramString);
    localIntent.putExtra("app_name", (String)localObject1);
    localIntent.putExtra("struct_share_key_source_icon", (String)localObject2);
    localIntent.putExtra("struct_share_key_source_action", str1);
    localIntent.putExtra("pubUin", "");
    localIntent.putExtra("struct_uin", "");
    paramString = str3;
    if (str3 != null)
    {
      paramString = str3;
      if (str3.length() > 45)
      {
        paramString = new StringBuilder();
        paramString.append(str3.substring(0, 45));
        paramString.append("…");
        paramString = paramString.toString();
      }
    }
    localIntent.putExtra("title", paramString);
    localObject1 = str2;
    if (str2 != null)
    {
      localObject1 = str2;
      if (str2.length() > 60)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(str2.substring(0, 60));
        ((StringBuilder)localObject1).append("…");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    localIntent.putExtra("desc", (String)localObject1);
    localIntent.putExtra("forward_thumb", str4);
    localIntent.putExtra("struct_share_key_content_action", "web");
    localIntent.putExtra("req_share_id", -1L);
    localIntent.putExtra("brief_key", localQQBrowserActivity.getString(2131894173, new Object[] { paramString }));
    localIntent.putExtra("to_uin", str6);
    localIntent.putExtra("uin_type", i);
    if (!TextUtils.isEmpty(str5))
    {
      localIntent.putExtra("docs_gray_tips_info_json", str5);
    }
    else
    {
      paramString = new StringBuilder();
      paramString.append("DocxApiPlugin");
      paramString.append(TeamWorkConstants.j);
      QLog.i(paramString.toString(), 1, "sendDocToChat. docsGrayInfoJson is empty.");
    }
    QIPCClientHelper.getInstance().getClient().callServer("TeamWorkModule", "send_to_chat_msg", localIntent.getExtras());
    for (;;)
    {
      return false;
      paramString = new StringBuilder();
      paramString.append("DocxApiPlugin");
      paramString.append(TeamWorkConstants.j);
      QLog.e(paramString.toString(), 1, "sendDocToChat param error");
    }
  }
  
  void f(String paramString)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handleWriteClipboard jsonString = ");
        ((StringBuilder)localObject1).append(paramString);
        QLog.d("DocxApiPlugin", 2, ((StringBuilder)localObject1).toString());
      }
      if (TextUtils.isEmpty(paramString))
      {
        QLog.d("DocxApiPlugin", 1, "handleWriteClipboard return for empty json");
        return;
      }
      Object localObject1 = this.mRuntime.d();
      if (localObject1 == null)
      {
        QLog.d("DocxApiPlugin", 1, "handleWriteClipboard return for null activity");
        return;
      }
      paramString = new JSONObject(paramString);
      String str1 = paramString.optString("plain");
      String str2 = paramString.optString("html");
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("handleWriteClipboard text = ");
        paramString.append(str1);
        paramString.append(",html = ");
        paramString.append(str2);
        QLog.d("DocxApiPlugin", 2, paramString.toString());
      }
      if ((TextUtils.isEmpty(str1)) && (TextUtils.isEmpty(str2)))
      {
        QLog.d("DocxApiPlugin", 1, "handleWriteClipboard return for empty text and html");
        return;
      }
      ClipboardManager localClipboardManager = (ClipboardManager)((Activity)localObject1).getSystemService("clipboard");
      Object localObject2 = null;
      int i = Build.VERSION.SDK_INT;
      if (i >= 16)
      {
        ClipData.Item localItem = new ClipData.Item(str1, str2);
        boolean bool = TextUtils.isEmpty(str1);
        if ((!bool) && (!TextUtils.isEmpty(str2)))
        {
          paramString = new String[2];
          paramString[0] = "text/plain";
          paramString[1] = "text/html";
          localObject1 = localItem;
        }
        else if ((!TextUtils.isEmpty(str1)) && (TextUtils.isEmpty(str2)))
        {
          paramString = new String[1];
          paramString[0] = "text/plain";
          localObject1 = localItem;
        }
        else
        {
          paramString = localObject2;
          localObject1 = localItem;
          if (TextUtils.isEmpty(str1))
          {
            paramString = localObject2;
            localObject1 = localItem;
            if (!TextUtils.isEmpty(str2))
            {
              paramString = new String[1];
              paramString[0] = "text/html";
              localObject1 = localItem;
            }
          }
        }
      }
      else
      {
        localObject1 = new ClipData.Item(str1);
        paramString = new String[1];
        paramString[0] = "text/plain";
      }
      paramString = new ClipData("", paramString, (ClipData.Item)localObject1);
      ClipboardMonitor.setPrimaryClip(localClipboardManager, paramString);
      localClipboardManager.setPrimaryClip(paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      QLog.d("DocxApiPlugin", 1, "handleWriteClipboard exception", paramString);
    }
  }
  
  void g(String paramString)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handleReadClipboard jsonString = ");
        ((StringBuilder)localObject1).append(paramString);
        QLog.d("DocxApiPlugin", 2, ((StringBuilder)localObject1).toString());
      }
      if (TextUtils.isEmpty(paramString))
      {
        QLog.d("DocxApiPlugin", 1, "handleReadClipboard return for empty json");
        return;
      }
      str2 = new JSONObject(paramString).optString("callback");
      j = -1;
      localJSONObject = new JSONObject();
      localObject1 = this.mRuntime.d();
      if (localObject1 == null)
      {
        QLog.d("DocxApiPlugin", 1, "handleReadClipboard return for null activity");
        callJs(str2, new String[] { String.valueOf(-2), localJSONObject.toString() });
        return;
      }
      localObject1 = (ClipboardManager)((Activity)localObject1).getSystemService("clipboard");
      ClipboardMonitor.getPrimaryClip((ClipboardManager)localObject1);
      localObject3 = ((ClipboardManager)localObject1).getPrimaryClip();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handleReadClipboard ClipData = ");
        ((StringBuilder)localObject1).append(localObject3);
        QLog.d("DocxApiPlugin", 2, ((StringBuilder)localObject1).toString());
      }
      localObject4 = null;
      localObject1 = null;
      str1 = null;
      if (localObject3 == null) {
        break label500;
      }
      if (((ClipData)localObject3).getItemCount() <= 0) {
        break label494;
      }
      localObject3 = ((ClipData)localObject3).getItemAt(0);
      str1 = ((ClipData.Item)localObject3).getText().toString();
      if (Build.VERSION.SDK_INT < 16) {
        break label491;
      }
      localObject1 = ((ClipData.Item)localObject3).getHtmlText();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1;
        String str2;
        int j;
        JSONObject localJSONObject;
        Object localObject4;
        String str1;
        localException.printStackTrace();
        QLog.d("DocxApiPlugin", 1, "handleReadClipboard exception", localException);
        try
        {
          callJs(new JSONObject(paramString).optString("callback"), new String[] { String.valueOf(-3), new JSONObject().toString() });
          return;
        }
        catch (Exception paramString)
        {
          QLog.d("DocxApiPlugin", 1, "handleReadClipboard Exception e1", paramString);
          return;
        }
        label491:
        continue;
        label494:
        Object localObject2 = null;
        continue;
        label500:
        Object localObject3 = null;
        continue;
        int i = 0;
      }
    }
    localObject3 = localObject1;
    localObject4 = str1;
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("handleReadClipboard text  = ");
      ((StringBuilder)localObject3).append(str1);
      ((StringBuilder)localObject3).append(",html = ");
      ((StringBuilder)localObject3).append((String)localObject1);
      QLog.d("DocxApiPlugin", 2, ((StringBuilder)localObject3).toString());
      localObject3 = localObject1;
      localObject4 = str1;
    }
    if ((TextUtils.isEmpty(localObject4)) && (TextUtils.isEmpty((CharSequence)localObject3)))
    {
      i = 1;
      if (i == 0)
      {
        localJSONObject.put("plain", localObject4);
        localJSONObject.put("html", localObject3);
        j = 0;
      }
      callJs(str2, new String[] { String.valueOf(j), localJSONObject.toString() });
      return;
    }
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 8589934615L;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleEvent ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", type=");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(", info=");
      ((StringBuilder)localObject).append(paramMap);
      QLog.i("DocxApiPlugin", 2, ((StringBuilder)localObject).toString());
    }
    if (paramLong == 8589934601L)
    {
      if ((this.mRuntime != null) && (this.mRuntime.d() != null) && ((this.mRuntime.d() instanceof QQBrowserActivity)))
      {
        if (!this.mRuntime.d().getIntent().getBooleanExtra("doc_from_aio", false))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("handleEvent not fromAIO, url=");
          ((StringBuilder)localObject).append(paramString);
          QLog.e("DocxApiPlugin", 1, ((StringBuilder)localObject).toString());
        }
        if (this.a != null)
        {
          QLog.e("DocxApiPlugin", 1, "handleEvent guide has shown");
          return super.handleEvent(paramString, paramLong, paramMap);
        }
        localObject = TencentDocEntryUtils.b(this.mRuntime.b());
        boolean bool = ((Boolean)((Pair)localObject).first).booleanValue();
        int i = ((Integer)((Pair)localObject).second).intValue();
        int j = TencentDocGuideHelper.a(this.mRuntime.b(), this.mRuntime.d());
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("handleEvent enable=");
          ((StringBuilder)localObject).append(bool);
          ((StringBuilder)localObject).append(", total=");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(", shown=");
          ((StringBuilder)localObject).append(j);
          QLog.i("DocxApiPlugin", 2, ((StringBuilder)localObject).toString());
        }
        if (!bool)
        {
          QLog.e("DocxApiPlugin", 1, "handleEvent not enable");
          return super.handleEvent(paramString, paramLong, paramMap);
        }
        if (j >= i)
        {
          QLog.e("DocxApiPlugin", 1, "handleEvent shown >= total");
          return super.handleEvent(paramString, paramLong, paramMap);
        }
        this.a = new TencentDocGuideDialog(this.mRuntime.d());
        this.a.a(new DocxApiPlugin.1(this));
        TencentDocGuideHelper.a(this.mRuntime.b(), this.mRuntime.d(), j + 1);
        try
        {
          this.a.show();
          ReportController.b(null, "CliOper", "", "", "0X80094EA", "0X80094EA", 0, 0, "", "", "", "");
          return true;
        }
        catch (Throwable localThrowable)
        {
          QLog.e("DocxApiPlugin", 1, "", localThrowable);
          return super.handleEvent(paramString, paramLong, paramMap);
        }
      }
      QLog.e("DocxApiPlugin", 1, "handleEvent sth is null or not instanceof QQBrowserActivity");
      return super.handleEvent(paramString, paramLong, paramMap);
    }
    if (paramLong == 8589934597L)
    {
      IVoiceInputHelper localIVoiceInputHelper = this.c;
      if (localIVoiceInputHelper != null) {
        localIVoiceInputHelper.stop();
      }
    }
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" handleJsRequest url = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" pkgName = ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(",method = ");
      localStringBuilder.append(paramString3);
      QLog.d("DocxApiPlugin", 2, localStringBuilder.toString());
    }
    if ("docx".equals(paramString2))
    {
      addOpenApiListenerIfNeeded(paramString3, paramJsBridgeListener);
      if (("readyToInsertImageCallBack".equals(paramString3)) && (paramVarArgs.length <= 1))
      {
        try
        {
          if (paramVarArgs.length != 1) {
            break label2319;
          }
          paramString1 = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener = paramString1.getString("attachmentId");
          paramString1 = paramString1.getString("localpath");
          paramString2 = this.mRuntime.d();
          if (QLog.isColorLevel())
          {
            paramString3 = new StringBuilder();
            paramString3.append("回调id = ");
            paramString3.append(paramJsBridgeListener);
            paramString3.append(" localPath = ");
            paramString3.append(paramString1);
            QLog.i("TeamWorkDocEditBrowserActivity", 2, paramString3.toString());
          }
          if ((paramString2 == null) || (!(paramString2 instanceof TeamWorkDocEditBrowserActivity))) {
            break label2319;
          }
          ThreadManager.postImmediately(new DocxApiPlugin.2(this, paramString2, paramString1, paramJsBridgeListener), null, false);
          return false;
        }
        catch (Exception paramJsBridgeListener)
        {
          if (!QLog.isDevelopLevel()) {
            break label2319;
          }
        }
        paramString1 = new StringBuilder();
        paramString1.append("readyToInsertImageCallBack failed:");
        paramString1.append(paramJsBridgeListener);
        QLog.d("DocxApiPlugin", 4, paramString1.toString());
        return false;
      }
      else if ((!"getDocxImageIndex".equals(paramString3)) || (paramVarArgs.length > 1)) {}
    }
    for (;;)
    {
      try
      {
        if (paramVarArgs.length != 1) {
          break label2319;
        }
        paramString1 = new JSONObject(paramVarArgs[0]);
        paramJsBridgeListener = new ArrayList();
        if (!paramString1.has("currentImageIndex")) {
          break label2321;
        }
        i = paramString1.getInt("currentImageIndex");
        if (paramString1.has("imageList"))
        {
          paramString1 = paramString1.getJSONArray("imageList");
          if (paramString1 != null)
          {
            j = 0;
            if (j < paramString1.length())
            {
              paramJsBridgeListener.add((String)paramString1.get(j));
              j += 1;
              continue;
            }
          }
        }
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append(" index = ");
          paramString1.append(i);
          paramString1.append(" urls.size = ");
          paramString1.append(paramJsBridgeListener.size());
          QLog.i("TeamWorkDocEditBrowserActivity", 2, paramString1.toString());
        }
        paramString1 = this.mRuntime.d();
        if ((paramString1 == null) || (!(paramString1 instanceof TeamWorkDocEditBrowserActivity)) || (i == -1)) {
          break label2319;
        }
        paramString2 = new ArrayList();
        int j = 0;
        if (j < paramJsBridgeListener.size())
        {
          paramString3 = new PicInfo();
          paramString3.b = ((String)paramJsBridgeListener.get(j));
          paramString3.c = ((String)paramJsBridgeListener.get(j));
          paramString2.add(paramString3);
          j += 1;
          continue;
        }
        paramJsBridgeListener = new Intent(paramString1, TeamWorkPicBrowserActivity.class);
        paramJsBridgeListener.putExtra("intent_param_index", i);
        paramJsBridgeListener.putExtra("intent_param_pic_infos", paramString2);
        paramJsBridgeListener.addFlags(536870912);
        paramString1.startActivity(paramJsBridgeListener);
        return false;
      }
      catch (Exception paramJsBridgeListener)
      {
        if (!QLog.isDevelopLevel()) {
          break label2319;
        }
      }
      paramString1 = new StringBuilder();
      paramString1.append("getDocxImageList failed:");
      paramString1.append(paramJsBridgeListener);
      QLog.d("DocxApiPlugin", 4, paramString1.toString());
      return false;
      if (("setAuthForSharePad".equals(paramString3)) && (paramVarArgs.length <= 1))
      {
        try
        {
          if ((paramVarArgs.length != 1) || (!(this.mRuntime.d() instanceof QQBrowserActivity))) {
            break label2319;
          }
          paramJsBridgeListener = new SharePolicyInfo();
          paramString1 = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener.a = ((String)paramString1.opt("authFirstLineInfo"));
          paramJsBridgeListener.b = ((String)paramString1.opt("authSecondLineInfo"));
          paramJsBridgeListener.c = ((Integer)paramString1.opt("policy")).intValue();
          paramJsBridgeListener.d = ((Boolean)paramString1.opt("isCreator")).booleanValue();
          paramJsBridgeListener.e = ((String)paramString1.opt("docName"));
          paramJsBridgeListener.f = ((Integer)paramString1.opt("docType")).intValue();
          paramJsBridgeListener.g = ((String)paramString1.opt("docIconUrl"));
          paramJsBridgeListener.h = ((Integer)paramString1.opt("taskType")).intValue();
          paramJsBridgeListener.i = ((String)paramString1.opt("share_url"));
          paramJsBridgeListener.j = ((Integer)paramString1.opt("memLength")).intValue();
          paramJsBridgeListener.k = ((String)paramString1.opt("memListPrefix"));
          paramJsBridgeListener.l = ((String)paramString1.opt("descriptionSuffix"));
          paramJsBridgeListener.m = ((String)paramString1.opt("padId"));
          paramJsBridgeListener.n = ((String)paramString1.opt("domainId"));
          paramJsBridgeListener.o = ((String)paramString1.opt("padTitle"));
          paramJsBridgeListener.p = ((String)paramString1.opt("folderId"));
          paramString1 = (QQBrowserActivity)this.mRuntime.d();
          if ((paramString1 == null) || (paramString1.getCurrentWebViewFragment() == null)) {
            break label2319;
          }
          paramString1 = paramString1.getCurrentWebViewFragment();
          if (paramString1 == null) {
            break label2319;
          }
          ((Share)paramString1.getShare()).a(paramJsBridgeListener);
          paramJsBridgeListener = paramString1.getComponentProvider();
          if (paramJsBridgeListener == null) {
            break label2319;
          }
          paramJsBridgeListener = (SwiftBrowserShareMenuHandler)paramJsBridgeListener.a(4);
          if ((paramJsBridgeListener == null) || (!(paramJsBridgeListener.h instanceof TeamWorkShareActionSheetBuilder))) {
            break label2319;
          }
          paramJsBridgeListener.h.updateUIIfShowing();
          return false;
        }
        catch (Exception paramJsBridgeListener)
        {
          paramString1 = new StringBuilder();
          paramString1.append("setAuthForSharePad error:");
          paramString1.append(paramJsBridgeListener);
          QLog.d("DocxApiPlugin", 1, paramString1.toString());
          return false;
        }
      }
      else
      {
        if (("sendDocToChat".equals(paramString3)) && (paramVarArgs.length <= 1)) {
          return e(paramVarArgs[0]);
        }
        if (("writeSystemClipboard".equals(paramString3)) && (paramVarArgs.length <= 1))
        {
          if (paramVarArgs.length == 1)
          {
            f(paramVarArgs[0]);
            return false;
          }
        }
        else if (("readSystemClipboard".equals(paramString3)) && (paramVarArgs.length <= 1))
        {
          if (paramVarArgs.length == 1)
          {
            g(paramVarArgs[0]);
            return false;
          }
        }
        else
        {
          if (("eventShare".equals(paramString3)) && (paramVarArgs.length == 1))
          {
            h(paramVarArgs[0]);
            return false;
          }
          if (("openLocalFilesToImport".equals(paramString3)) && (paramVarArgs.length <= 1))
          {
            d(paramVarArgs[0]);
            return false;
          }
          if (("openExportedFile".equals(paramString3)) && (paramVarArgs.length <= 1))
          {
            a(paramVarArgs[0]);
            return false;
          }
          if (("openExportedFileAndDownload".equals(paramString3)) && (paramVarArgs.length <= 1))
          {
            if (NetworkUtil.isNetSupport(this.mRuntime.d()))
            {
              b(paramVarArgs[0]);
              return false;
            }
            QQToast.makeText(this.mRuntime.d(), this.mRuntime.d().getString(2131891334), 0).show();
            return false;
          }
          if (("txDocsStartExport".equals(paramString3)) && (paramVarArgs.length <= 1))
          {
            if ((this.mRuntime != null) && (this.mRuntime.d() != null))
            {
              if (NetworkUtil.isNetSupport(this.mRuntime.d()))
              {
                c(paramVarArgs[0]);
                return false;
              }
              QQToast.makeText(this.mRuntime.d(), this.mRuntime.d().getString(2131891334), 0).show();
              return false;
            }
          }
          else if (("voiceInputSetup".equals(paramString3)) && (paramVarArgs.length <= 1))
          {
            paramJsBridgeListener = this.c;
            if (paramJsBridgeListener == null)
            {
              this.c = ((ITeamWorkFacadeCreator)QRoute.api(ITeamWorkFacadeCreator.class)).getIVoiceInputHelper(this);
              this.c.setup();
              return false;
            }
            if (!paramJsBridgeListener.isInitialized())
            {
              this.c.setup();
              return false;
            }
          }
          else
          {
            boolean bool;
            if (("voiceInputStart".equals(paramString3)) && (paramVarArgs.length <= 1))
            {
              if (this.c != null)
              {
                if (paramVarArgs.length == 1) {
                  try
                  {
                    paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
                    bool = this.c.start(paramJsBridgeListener);
                    return bool;
                  }
                  catch (Throwable paramJsBridgeListener)
                  {
                    QLog.e("DocxApiPlugin", 1, "VoiceInputHelper start error", paramJsBridgeListener);
                    return false;
                  }
                }
                QLog.e("DocxApiPlugin", 1, "VoiceInputHelper start args error.");
                return false;
              }
              QLog.e("DocxApiPlugin", 1, "VoiceInputHelper has destroyed, start failed.");
              return false;
            }
            if (("voiceInputStop".equals(paramString3)) && (paramVarArgs.length <= 1))
            {
              paramJsBridgeListener = this.c;
              if (paramJsBridgeListener != null)
              {
                paramJsBridgeListener.stop();
                return false;
              }
            }
            else
            {
              if (("cameraCheckPermission".equals(paramString3)) && (paramVarArgs.length <= 1))
              {
                if (this.b == null) {
                  this.b = ((ITeamWorkFacadeCreator)QRoute.api(ITeamWorkFacadeCreator.class)).getCameraHelper(this);
                }
                if (paramVarArgs.length == 1) {
                  try
                  {
                    paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
                    bool = this.b.checkPermission(paramJsBridgeListener);
                    return bool;
                  }
                  catch (Throwable paramJsBridgeListener)
                  {
                    QLog.e("DocxApiPlugin", 1, "CameraHelper checkPermission error", paramJsBridgeListener);
                    return false;
                  }
                }
                QLog.e("DocxApiPlugin", 1, "CameraHelper checkPermission args error.");
                return false;
              }
              if (("recordCheckPermission".equals(paramString3)) && (paramVarArgs.length <= 1))
              {
                if (this.c == null) {
                  this.c = ((ITeamWorkFacadeCreator)QRoute.api(ITeamWorkFacadeCreator.class)).getIVoiceInputHelper(this);
                }
                if (paramVarArgs.length == 1) {
                  try
                  {
                    paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
                    bool = this.c.checkPermission(paramJsBridgeListener);
                    return bool;
                  }
                  catch (Throwable paramJsBridgeListener)
                  {
                    QLog.e("DocxApiPlugin", 1, "VoiceInputHelper checkPermission error", paramJsBridgeListener);
                    return false;
                  }
                }
                QLog.e("DocxApiPlugin", 1, "VoiceInputHelper checkPermission args error.");
                return false;
              }
              if (("getTcntDocData".equals(paramString3)) && (paramVarArgs.length <= 1)) {
                try
                {
                  paramString1 = new JSONObject(paramVarArgs[0]);
                  paramJsBridgeListener = paramString1.optString("url");
                  paramString1 = paramString1.optString("callback");
                  ThreadManager.excute(new DocxApiPlugin.3(this, TeamWorkHandlerUtils.a(paramJsBridgeListener), paramString1, paramJsBridgeListener), 64, null, false);
                  return false;
                }
                catch (Exception paramJsBridgeListener)
                {
                  QLog.e("DocxApiPlugin", 1, "JSONException ", paramJsBridgeListener);
                  return false;
                }
              }
              if (("delTcntDocData".equals(paramString3)) && (paramVarArgs.length <= 1)) {
                try
                {
                  ThreadManager.excute(new DocxApiPlugin.4(this, TeamWorkHandlerUtils.a(new JSONObject(paramVarArgs[0]).optString("url"))), 64, null, false);
                  return false;
                }
                catch (JSONException paramJsBridgeListener)
                {
                  QLog.e("DocxApiPlugin", 1, "JSONException ", paramJsBridgeListener);
                  return false;
                }
              }
              if (("preFetchTcntDocData".equals(paramString3)) && (paramVarArgs.length <= 1))
              {
                paramString1 = TencentDocPreloadConfigProcessor.a();
                if (paramString1.a())
                {
                  if (!paramString1.b()) {
                    return false;
                  }
                  a();
                  try
                  {
                    paramString2 = new JSONObject(paramVarArgs[0]).optJSONArray("keys");
                    if (paramString2 == null) {
                      break label2319;
                    }
                    paramJsBridgeListener = new ArrayList(paramString2.length());
                    i = 0;
                    while (i < paramString2.length())
                    {
                      paramJsBridgeListener.add(paramString2.getJSONObject(i).optString("doc_url"));
                      i += 1;
                    }
                    if ((paramString1.c()) && (!paramJsBridgeListener.isEmpty()))
                    {
                      paramString1 = (String)paramJsBridgeListener.get(0);
                      if (((QBaseActivity)this.mRuntime.d()).getSupportFragmentManager().findFragmentByTag("doc_preload") == null)
                      {
                        QLog.e("DocxApiPlugin", 1, "tendocpreload UnVisibleWebViewFragment create ");
                        TenDocWebPreLoadHelper.a(paramString1);
                        paramString2 = new Intent();
                        paramString2.putExtra("url", paramString1);
                        paramString2.putExtra("hide_more_button", true);
                        paramString2.putExtra("webStyle", "noBottomBar");
                        paramString2.putExtra("isScreenOrientationPortrait", true);
                        paramString2.putExtra("title", " ");
                        paramString1 = UnVisibleWebViewFragment.a(paramString2);
                        ((QBaseActivity)this.mRuntime.d()).getSupportFragmentManager().beginTransaction().add(paramString1, "doc_preload").commitAllowingStateLoss();
                      }
                    }
                    a(paramJsBridgeListener);
                    return false;
                  }
                  catch (JSONException paramJsBridgeListener)
                  {
                    QLog.e("DocxApiPlugin", 1, "JSONException ", paramJsBridgeListener);
                    return false;
                  }
                }
                else
                {
                  return false;
                }
              }
              else if (("showShareView".equals(paramString3)) && (paramVarArgs.length <= 1))
              {
                paramJsBridgeListener = (QQBrowserActivity)this.mRuntime.d();
                if ((paramJsBridgeListener != null) && (paramJsBridgeListener.getCurrentWebViewFragment() != null))
                {
                  paramJsBridgeListener = paramJsBridgeListener.getCurrentWebViewFragment();
                  if ((paramJsBridgeListener != null) && ((paramJsBridgeListener instanceof TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment))) {
                    ((TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment)paramJsBridgeListener).a();
                  }
                }
              }
            }
          }
        }
      }
      label2319:
      return false;
      label2321:
      int i = -1;
    }
  }
  
  public boolean isNeedPreCreatePlugin(Intent paramIntent, String paramString1, String paramString2)
  {
    return (paramString1.contains("docx.qq.com")) || (paramString1.contains("docs.qq.com"));
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    paramIntent = this.d;
    if ((paramIntent != null) && (!TextUtils.isEmpty(paramIntent)))
    {
      paramIntent = "user canceled";
      int i;
      int k;
      int j;
      if (paramByte == 17)
      {
        paramIntent = "user canceld share panel";
        i = 0;
        k = paramInt;
        j = 0;
        paramInt = k;
      }
      else
      {
        if ((paramByte != 18) && (paramByte != 52)) {
          if ((paramByte != 86) && (paramByte != 120)) {
            i = 0;
          }
        }
        for (j = 0;; j = 2)
        {
          paramIntent = "ok";
          paramInt = 0;
          break label297;
          if (paramByte == 86) {
            j = 3;
          } else {
            j = 4;
          }
          i = j;
          k = paramInt;
          switch (paramInt)
          {
          case -2: 
          default: 
            paramIntent = "ok";
            i = j;
            k = paramInt;
            break;
          case 0: 
            paramIntent = "ok";
            k = 2;
            i = j;
            j = k;
            break;
          case -1: 
            paramIntent = "err comm";
            i = j;
            k = paramInt;
            break;
          case -3: 
            paramIntent = "sent failed";
            i = j;
            k = paramInt;
            break;
          case -4: 
            paramIntent = "auth denied";
            i = j;
            k = paramInt;
            break;
          case -5: 
            paramIntent = "unsupport";
            i = j;
            k = paramInt;
            break;
          case -6: 
            paramIntent = "err ban";
            i = j;
            k = paramInt;
            break;
            if (paramByte == 18) {
              i = 1;
            } else {
              i = 2;
            }
            if (paramInt == 0)
            {
              k = -1;
              break;
            }
            break;
          }
        }
      }
      label297:
      paramIntent = String.format("{\"type\":%d,\"action\":%d,\"ec\":%d,\"em\":\"%s\"}", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt), paramIntent });
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("rsp json = ");
      localStringBuilder.append(paramIntent);
      QLog.d("DocxApiPlugin", 2, localStringBuilder.toString());
      callJs(this.d, new String[] { paramIntent });
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
    IVoiceInputHelper localIVoiceInputHelper = ((ITeamWorkFacadeCreator)QRoute.api(ITeamWorkFacadeCreator.class)).getIVoiceInputHelper(this);
    AppInterface localAppInterface;
    if (this.mRuntime == null) {
      localAppInterface = null;
    } else {
      localAppInterface = this.mRuntime.b();
    }
    localIVoiceInputHelper.preInit(localAppInterface);
  }
  
  protected void onDestroy()
  {
    this.a = null;
    Object localObject = this.b;
    if (localObject != null)
    {
      ((ICameraHelper)localObject).destroy();
      this.b = null;
    }
    localObject = this.c;
    if (localObject != null)
    {
      ((IVoiceInputHelper)localObject).destroy();
      this.c = null;
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.DocxApiPlugin
 * JD-Core Version:    0.7.0.1
 */