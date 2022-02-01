package cooperation.qzone.webviewplugin.ugcsetting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.service.qzone.QZoneUnreadServletLogic;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;
import cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin;
import org.json.JSONObject;

public class QzoneUgcSettingJsPlugin
  extends QzoneInternalWebViewPlugin
{
  public static final String NAMESPACE = "Qzone";
  private String TAG = QzoneUgcSettingJsPlugin.class.getSimpleName();
  
  private void getLiveUgcSetting(String paramString1, String paramString2)
  {
    paramString1 = this.parentPlugin.mRuntime.d();
    if ((paramString1 != null) && (!paramString1.isFinishing()))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      paramString1 = paramString1.getIntent();
      if (paramString1 == null) {
        return;
      }
      paramString1 = paramString1.getExtras();
      if (paramString1 == null) {
        return;
      }
      paramString1 = UgcSettingUtil.liveUgcSettingToJson(paramString1);
      this.parentPlugin.callJs(paramString2, new String[] { paramString1 });
    }
  }
  
  private void getUgcSetting(String paramString)
  {
    Object localObject = this.parentPlugin.mRuntime.d();
    if ((localObject != null) && (!((Activity)localObject).isFinishing()))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      localObject = ((Activity)localObject).getIntent();
      if (localObject == null) {
        return;
      }
      localObject = ((Intent)localObject).getExtras();
      if (localObject == null) {
        return;
      }
      localObject = UgcSettingUtil.ugcSettingToJson((Bundle)localObject);
      this.parentPlugin.callJs(paramString, new String[] { localObject });
    }
  }
  
  private void handleCancellationStatus(WebViewPlugin.PluginRuntime paramPluginRuntime, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      if (new JSONObject(paramString).getInt("result") == 1)
      {
        QZoneUnreadServletLogic.a(0, paramPluginRuntime.b().getLongAccountUin());
        return;
      }
    }
    catch (Throwable paramPluginRuntime)
    {
      QLog.e(this.TAG, 1, "handleCancellationStatus... e:", paramPluginRuntime);
    }
  }
  
  private void setLiveUgcSetting(String paramString1, String paramString2)
  {
    Object localObject = this.parentPlugin.mRuntime.d();
    if (localObject != null)
    {
      if (((Activity)localObject).isFinishing()) {
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtras(UgcSettingUtil.parseLiveJson(localIntent.getExtras(), paramString1));
      ((Activity)localObject).setResult(-1, localIntent);
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString1 = localIntent.getStringExtra("key_parse_json_status");
        if (!TextUtils.isEmpty(paramString1))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("{\"ret\":-1, \"msg\":\"");
          ((StringBuilder)localObject).append(paramString1);
          ((StringBuilder)localObject).append("\"}");
          paramString1 = ((StringBuilder)localObject).toString();
        }
        else
        {
          paramString1 = "{\"ret\":0, \"msg\":\"sucess\"}";
        }
        this.parentPlugin.callJs(paramString2, new String[] { paramString1 });
      }
    }
  }
  
  private void setUgcSetting(String paramString1, String paramString2)
  {
    Object localObject = this.parentPlugin.mRuntime.d();
    if (localObject != null)
    {
      if (((Activity)localObject).isFinishing()) {
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtras(UgcSettingUtil.parseJson(localIntent.getExtras(), paramString1));
      ((Activity)localObject).setResult(-1, localIntent);
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString1 = localIntent.getStringExtra("key_parse_json_status");
        if (!TextUtils.isEmpty(paramString1))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("{\"ret\":-1, \"msg\":\"");
          ((StringBuilder)localObject).append(paramString1);
          ((StringBuilder)localObject).append("\"}");
          paramString1 = ((StringBuilder)localObject).toString();
        }
        else
        {
          paramString1 = "{\"ret\":0, \"msg\":\"sucess\"}";
        }
        this.parentPlugin.callJs(paramString2, new String[] { paramString1 });
      }
    }
  }
  
  private void updateFriendSetting(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      paramString = new JSONObject(paramString);
      String str1 = paramString.getString("type");
      String str2 = paramString.getString("value");
      long l = paramString.getLong("uin");
      paramString.getString("callback");
      RemoteHandleManager.getInstance().getSender().updateFriendSetting(str1, str2, l);
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e(this.TAG, 1, "error process friend setting json string.", paramString);
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((paramString2.equals("Qzone")) && (this.parentPlugin != null))
    {
      if (this.parentPlugin.mRuntime == null) {
        return false;
      }
      if ((paramString3.equals("getUgcSetting")) && (paramVarArgs != null) && (paramVarArgs.length >= 1)) {
        try
        {
          getUgcSetting(new JSONObject(paramVarArgs[0]).optString("callback"));
          return true;
        }
        catch (Exception paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
          return true;
        }
      }
      if ((paramString3.equals("setUgcSetting")) && (paramVarArgs != null) && (paramVarArgs.length >= 1)) {
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          setUgcSetting(paramVarArgs[0], paramJsBridgeListener.optString("callback"));
          return true;
        }
        catch (Exception paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
          return true;
        }
      }
      if ((paramString3.equals("getLiveUgcSetting")) && (paramVarArgs != null) && (paramVarArgs.length >= 1)) {
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          getLiveUgcSetting(paramVarArgs[0], paramJsBridgeListener.optString("callback"));
          return true;
        }
        catch (Exception paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
          return true;
        }
      }
      if ((paramString3.equals("setLiveUgcSetting")) && (paramVarArgs != null) && (paramVarArgs.length >= 1)) {
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          setLiveUgcSetting(paramVarArgs[0], paramJsBridgeListener.optString("callback"));
          return true;
        }
        catch (Exception paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
          return true;
        }
      }
      if ((paramString3.equals("UpdateFriendSetting")) && (paramVarArgs != null) && (paramVarArgs.length >= 1))
      {
        updateFriendSetting(paramVarArgs[0]);
        return true;
      }
      if ((paramString3.equals("reopenQzone")) && (paramVarArgs != null) && (paramVarArgs.length >= 1))
      {
        handleCancellationStatus(this.parentPlugin.mRuntime, paramVarArgs[0]);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.ugcsetting.QzoneUgcSettingJsPlugin
 * JD-Core Version:    0.7.0.1
 */