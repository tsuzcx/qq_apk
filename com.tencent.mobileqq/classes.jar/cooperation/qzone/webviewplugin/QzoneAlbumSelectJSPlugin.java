package cooperation.qzone.webviewplugin;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import bgve;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
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
  
  private void handleSelectAlbum(bgve parambgve, String[] paramArrayOfString)
  {
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]);
      pickCallBack = paramArrayOfString.getString("callback");
      parambgve = new Bundle();
      parambgve.putInt("key_personal_album_enter_model", 0);
      parambgve.putBoolean("key_pass_result_by_bundle", true);
      parambgve.putString("key_accept_album_anonymity", paramArrayOfString.optString("acceptType"));
      parambgve.putString("key_deny_delect_tips", paramArrayOfString.optString("denyTips"));
      parambgve.putBoolean("key_can_new_album", false);
      parambgve.putString("key_from_type", paramArrayOfString.optString("fromType"));
      paramArrayOfString = QZoneHelper.UserInfo.getInstance();
      paramArrayOfString.qzone_uin = this.parentPlugin.mRuntime.a().getCurrentAccountUin();
      parambgve.putBoolean("key_need_change_to_jpg", false);
      QZoneHelper.forwardToPersonalAlbumSelect(this.parentPlugin.mRuntime.a(), paramArrayOfString, parambgve, QZoneHelper.generateRequestCode(this.parentPlugin, this.parentPlugin.mRuntime, 7));
      return;
    }
    catch (Exception parambgve)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w(TAG, 2, "handlePickQzoneAlbum,decode param error");
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals("Qzone")) || (this.parentPlugin == null) || (this.parentPlugin.mRuntime == null)) {}
    while (!paramString3.equalsIgnoreCase("PickQzoneAlbum")) {
      return false;
    }
    handleSelectAlbum(this.parentPlugin.mRuntime, paramVarArgs);
    return true;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    switch (paramByte)
    {
    }
    do
    {
      return;
    } while ((TextUtils.isEmpty(pickCallBack)) || (paramIntent == null));
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
      if (QLog.isDevelopLevel()) {
        QLog.d(TAG, 4, paramIntent.toString());
      }
      this.parentPlugin.callJs(pickCallBack, new String[] { paramIntent.toString() });
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneAlbumSelectJSPlugin
 * JD-Core Version:    0.7.0.1
 */