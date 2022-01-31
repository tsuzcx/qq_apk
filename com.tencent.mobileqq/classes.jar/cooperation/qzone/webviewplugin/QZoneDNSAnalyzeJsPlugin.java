package cooperation.qzone.webviewplugin;

import anbj;
import anbk;
import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class QZoneDNSAnalyzeJsPlugin
  extends QzoneInternalWebViewPlugin
{
  private void a(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return;
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.a();
    } while ((paramWebViewPlugin == null) || (paramWebViewPlugin.isFinishing()));
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]);
      paramWebViewPlugin = paramArrayOfString.optString("host");
      paramArrayOfString = paramArrayOfString.optString("callback");
      if (TextUtils.isEmpty(paramArrayOfString))
      {
        QLog.e("QZoneDNSAnalyzeJsPlugin", 1, "callback is empty.");
        return;
      }
    }
    catch (JSONException paramWebViewPlugin)
    {
      paramWebViewPlugin.printStackTrace();
      return;
    }
    if (TextUtils.isEmpty(paramWebViewPlugin))
    {
      QLog.e("QZoneDNSAnalyzeJsPlugin", 1, "host is empty.");
      return;
    }
    QzoneHandlerThreadFactory.getHandlerThread("BackGround_HandlerThread").post(new anbj(this, paramWebViewPlugin, paramArrayOfString));
  }
  
  private void a(String paramString1, int paramInt, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      QLog.e("QZoneDNSAnalyzeJsPlugin", 1, "callback is null");
    }
    for (;;)
    {
      return;
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("ret", paramInt);
        localJSONObject.put("host_ip", paramString2);
        paramString2 = localJSONObject.toString();
        if ((this.a != null) && (this.a.mRuntime != null) && (this.a.mRuntime.a() != null))
        {
          this.a.mRuntime.a().a(paramString1, new String[] { paramString2 });
          return;
        }
      }
      catch (Exception paramString1)
      {
        QLog.e("QZoneDNSAnalyzeJsPlugin", 1, paramString1.getMessage());
      }
    }
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals("Qzone")) || (this.a == null) || (this.a.mRuntime == null)) {}
    while (!paramString3.equalsIgnoreCase("getHostIpAddress")) {
      return false;
    }
    a(this.a, paramVarArgs);
    return true;
  }
  
  public boolean a(String paramString, long paramLong, Map paramMap)
  {
    if ((paramLong == 8589934595L) && (paramMap != null))
    {
      paramString = paramMap.get("errorCode");
      if ((paramString != null) && ((paramString instanceof Integer)))
      {
        int i = ((Integer)paramString).intValue();
        QzoneHandlerThreadFactory.getHandlerThread("BackGround_HandlerThread").post(new anbk(this, i));
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneDNSAnalyzeJsPlugin
 * JD-Core Version:    0.7.0.1
 */