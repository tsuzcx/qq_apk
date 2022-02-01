package cooperation.qzone.webviewplugin;

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
  public static final String NAMESPACE = "Qzone";
  private static final String TAG = "QZoneDNSAnalyzeJsPlugin";
  
  private void callJS(String paramString1, int paramInt, String paramString2)
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
        if ((this.parentPlugin != null) && (this.parentPlugin.mRuntime != null) && (this.parentPlugin.mRuntime.a() != null))
        {
          this.parentPlugin.mRuntime.a().callJs(paramString1, new String[] { paramString2 });
          return;
        }
      }
      catch (Exception paramString1)
      {
        QLog.e("QZoneDNSAnalyzeJsPlugin", 1, paramString1.getMessage());
      }
    }
  }
  
  private void handleGetHostIpAddress(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
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
    QzoneHandlerThreadFactory.getHandlerThread("BackGround_HandlerThread").post(new QZoneDNSAnalyzeJsPlugin.1(this, paramWebViewPlugin, paramArrayOfString));
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if ((paramLong == 8589934595L) && (paramMap != null))
    {
      paramString = paramMap.get("errorCode");
      if ((paramString != null) && ((paramString instanceof Integer)))
      {
        int i = ((Integer)paramString).intValue();
        QzoneHandlerThreadFactory.getHandlerThread("BackGround_HandlerThread").post(new QZoneDNSAnalyzeJsPlugin.2(this, i));
      }
    }
    return false;
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals("Qzone")) || (this.parentPlugin == null) || (this.parentPlugin.mRuntime == null)) {}
    while (!paramString3.equalsIgnoreCase("getHostIpAddress")) {
      return false;
    }
    handleGetHostIpAddress(this.parentPlugin, paramVarArgs);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneDNSAnalyzeJsPlugin
 * JD-Core Version:    0.7.0.1
 */