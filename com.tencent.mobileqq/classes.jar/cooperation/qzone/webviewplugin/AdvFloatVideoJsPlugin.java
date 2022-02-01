package cooperation.qzone.webviewplugin;

import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.smtt.sdk.WebView;
import cooperation.qzone.util.QZLog;
import cooperation.vip.AdvVideoFloat.AdvGerneralProxy;
import org.json.JSONObject;

public class AdvFloatVideoJsPlugin
  extends QzoneInternalWebViewPlugin
{
  public static final String ADVCLICKBLANKAREA = "AdvClickBlankArea";
  public static final String ADVLOADEDNOTIFY = "AdvLoadedNotify";
  public static final String ADVREPORTVAS = "AdvReportVas";
  public static final int CURRENTWEBVIEWREADY = 0;
  public static final String NAMESPACE = "Qzone";
  public static final String TAG = "AdvFloatVideoJsPlugin";
  public String mCallback = "";
  
  public void handleAdvClickBlankArea(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      if (paramArrayOfString.length < 1) {
        return;
      }
      try
      {
        QZLog.i("AdvFloatVideoJsPlugin", "@advWebview handleAdvClickBlankArea");
        paramArrayOfString = new JSONObject(paramArrayOfString[0]).optString("advid");
        AdvGerneralProxy.getInstance().notifyVideoBlankClick(paramArrayOfString);
        return;
      }
      catch (Exception paramArrayOfString)
      {
        QZLog.e("AdvFloatVideoJsPlugin", paramArrayOfString.toString());
      }
    }
  }
  
  public void handleAdvLoadedNotify(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      if (paramArrayOfString.length < 1) {
        return;
      }
      try
      {
        QZLog.i("AdvFloatVideoJsPlugin", "handleAdvLoadedNotify @advWebview");
        Object localObject2 = new JSONObject(paramArrayOfString[0]);
        int i = ((JSONObject)localObject2).getInt("status");
        localObject1 = this.parentPlugin.mRuntime.a();
        if (localObject1 == null) {
          return;
        }
        paramArrayOfString = (String)((WebView)localObject1).getTag(AdvGerneralProxy.getInstance().getFirstKey());
        if (i == 0)
        {
          this.mCallback = ((JSONObject)localObject2).getString("callback");
          if (QZLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("@advWebview onlykey =");
            ((StringBuilder)localObject2).append(paramArrayOfString);
            QZLog.i("AdvFloatVideoJsPlugin", ((StringBuilder)localObject2).toString());
          }
          this.parentPlugin.callJs(this.mCallback, new String[] { AdvGerneralProxy.getInstance().getCallBackData(paramArrayOfString) });
          ((WebView)localObject1).setTag(AdvGerneralProxy.getInstance().getFourthKey(), this.mCallback);
          return;
        }
        if (i == 1)
        {
          localObject2 = ((JSONObject)localObject2).getString("id");
          ((WebView)localObject1).setTag(AdvGerneralProxy.getInstance().getSecondKey(), Integer.valueOf(1));
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(paramArrayOfString);
            ((StringBuilder)localObject1).append("_");
            ((StringBuilder)localObject1).append((String)localObject2);
            paramArrayOfString = ((StringBuilder)localObject1).toString();
            AdvGerneralProxy.getInstance().notifyH5PageReady(paramArrayOfString);
            return;
          }
        }
      }
      catch (Exception paramArrayOfString)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handleAdvLoadedNotify eroo");
        ((StringBuilder)localObject1).append(paramArrayOfString.toString());
        QZLog.e("AdvFloatVideoJsPlugin", ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  public void handleAdvReportVas(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      if (paramArrayOfString.length < 1) {
        return;
      }
      try
      {
        QZLog.i("AdvFloatVideoJsPlugin", "handleAdvReportVas");
        int i = new JSONObject(paramArrayOfString[0]).optInt("area", -1);
        AdvGerneralProxy.getInstance().notifyOnlyReportClickArea(i);
        return;
      }
      catch (Exception paramArrayOfString)
      {
        QZLog.e("AdvFloatVideoJsPlugin", paramArrayOfString.toString());
      }
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((paramString2 != null) && (paramString2.equals("Qzone")) && (paramString3 != null) && (this.parentPlugin != null))
    {
      if (this.parentPlugin.mRuntime == null) {
        return false;
      }
      if ((paramString3.equals("AdvLoadedNotify")) && (paramVarArgs.length >= 1))
      {
        QZLog.i("AdvFloatVideoJsPlugin", "AdvLoadedNotify");
        handleAdvLoadedNotify(paramVarArgs);
        return true;
      }
      if (paramString3.equals("AdvClickBlankArea"))
      {
        QZLog.i("AdvFloatVideoJsPlugin", "AdvClickBlankArea");
        handleAdvClickBlankArea(paramVarArgs);
        return true;
      }
      if (paramString3.equals("AdvReportVas"))
      {
        QZLog.i("AdvFloatVideoJsPlugin", "AdvReportVas");
        handleAdvReportVas(paramVarArgs);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.AdvFloatVideoJsPlugin
 * JD-Core Version:    0.7.0.1
 */