package cooperation.qzone.webviewplugin;

import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONObject;

public abstract class QzoneInternalWebViewPlugin
{
  protected WebViewPlugin parentPlugin;
  
  public static void dispatchEventImpl(CustomWebView paramCustomWebView, String paramString, JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (paramCustomWebView != null) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("event", paramString);
        if (paramJSONObject1 != null) {
          localJSONObject.put("data", paramJSONObject1);
        }
        if (paramJSONObject2 != null) {
          localJSONObject.put("options", paramJSONObject2);
        }
        paramString = new StringBuilder();
        paramString.append("jsbridge://event/dispatchEvent?p=");
        paramString.append(Uri.encode(localJSONObject.toString()));
        paramString = paramString.toString();
        if (QLog.isDebugVersion())
        {
          paramJSONObject1 = new StringBuilder();
          paramJSONObject1.append("dispatchEventImpl url:");
          paramJSONObject1.append(paramString);
          QLog.i("QzoneInternalWebViewPlugin", 1, paramJSONObject1.toString());
        }
        if (Looper.myLooper() == Looper.getMainLooper())
        {
          paramCustomWebView.loadUrl(paramString);
          return;
        }
        paramCustomWebView.post(new QzoneInternalWebViewPlugin.1(paramCustomWebView, paramString));
        return;
      }
      catch (Exception paramCustomWebView)
      {
        paramCustomWebView.printStackTrace();
      }
    }
  }
  
  public void dispatchEvent(String paramString, JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    Object localObject = this.parentPlugin;
    if ((localObject != null) && (((WebViewPlugin)localObject).mRuntime != null)) {
      localObject = this.parentPlugin.mRuntime.a();
    } else {
      localObject = null;
    }
    dispatchEventImpl((CustomWebView)localObject, paramString, paramJSONObject1, paramJSONObject2);
  }
  
  public Object handleEvent(String paramString, long paramLong)
  {
    return null;
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    return false;
  }
  
  public abstract boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs);
  
  public void initRuntime(WebViewPlugin paramWebViewPlugin)
  {
    this.parentPlugin = paramWebViewPlugin;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt) {}
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
 * JD-Core Version:    0.7.0.1
 */