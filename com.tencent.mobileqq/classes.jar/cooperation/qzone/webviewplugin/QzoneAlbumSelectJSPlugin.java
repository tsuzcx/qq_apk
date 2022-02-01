package cooperation.qzone.webviewplugin;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.impl.QZoneHelperProxyImpl;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class QzoneAlbumSelectJSPlugin
  extends QzoneInternalWebViewPlugin
{
  public static final String NAMESPACE = "Qzone";
  private static final String TAG = QzoneBlogJsPlugin.class.getSimpleName();
  private static String pickCallBack = "";
  
  private void handleSelectAlbum(WebViewPlugin.PluginRuntime paramPluginRuntime, String[] paramArrayOfString)
  {
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]);
      pickCallBack = paramArrayOfString.getString("callback");
      paramPluginRuntime = new Bundle();
      paramPluginRuntime.putInt("key_personal_album_enter_model", 0);
      paramPluginRuntime.putBoolean("key_pass_result_by_bundle", true);
      paramPluginRuntime.putString("key_accept_album_anonymity", paramArrayOfString.optString("acceptType"));
      paramPluginRuntime.putString("key_deny_delect_tips", paramArrayOfString.optString("denyTips"));
      paramPluginRuntime.putBoolean("key_can_new_album", false);
      paramPluginRuntime.putString("key_from_type", paramArrayOfString.optString("fromType"));
      paramArrayOfString = QZoneHelper.UserInfo.getInstance();
      paramArrayOfString.qzone_uin = this.parentPlugin.mRuntime.a().getCurrentAccountUin();
      paramPluginRuntime.putBoolean("key_need_change_to_jpg", false);
      QZoneHelper.forwardToPersonalAlbumSelect(this.parentPlugin.mRuntime.a(), paramArrayOfString, paramPluginRuntime, QZoneHelperProxyImpl.generateRequestCode(this.parentPlugin, this.parentPlugin.mRuntime, 7));
      return;
    }
    catch (Exception paramPluginRuntime)
    {
      label145:
      break label145;
    }
    if (QLog.isColorLevel()) {
      QLog.w(TAG, 2, "handlePickQzoneAlbum,decode param error");
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((paramString2.equals("Qzone")) && (this.parentPlugin != null))
    {
      if (this.parentPlugin.mRuntime == null) {
        return false;
      }
      if (paramString3.equalsIgnoreCase("PickQzoneAlbum"))
      {
        handleSelectAlbum(this.parentPlugin.mRuntime, paramVarArgs);
        return true;
      }
    }
    return false;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    if (paramByte != 7) {
      return;
    }
    if ((!TextUtils.isEmpty(pickCallBack)) && (paramIntent != null))
    {
      String str1 = paramIntent.getStringExtra("key_selected_albuminfo.id");
      String str2 = paramIntent.getStringExtra("key_selected_albuminfo.name");
      paramIntent.getStringExtra("key_selected_albuminfo.cover");
      paramIntent.getIntExtra("key_selected_albuminfo.permission", 0);
      paramByte = paramIntent.getIntExtra("key_selected_albuminfo.type", 0);
      paramInt = paramIntent.getIntExtra("key_selected_albuminfo.anonymity", 0);
      paramIntent = new JSONObject();
      try
      {
        paramIntent.put("albumid", str1);
        paramIntent.put("albumtype", paramByte);
        paramIntent.put("albumname", str2);
        paramIntent.put("albumanonymity", paramInt);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      if (QLog.isDevelopLevel()) {
        QLog.d(TAG, 4, paramIntent.toString());
      }
      this.parentPlugin.callJs(pickCallBack, new String[] { paramIntent.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneAlbumSelectJSPlugin
 * JD-Core Version:    0.7.0.1
 */