package com.tencent.mobileqq.intervideo.od;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.intervideo.huayang.HuayangJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ODAppJSPlugin
  extends HuayangJsPlugin
  implements TroopMemberApiClient.Callback
{
  private String c;
  
  public ODAppJSPlugin()
  {
    this.mPluginNameSpace = "odapp";
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    while ((!"onOpenRoomResult".equals(paramBundle.getString("method"))) || (this.c == null)) {
      return;
    }
    int i = paramBundle.getInt("code", 0);
    paramBundle = new JSONObject();
    try
    {
      paramBundle.put("code", i);
      callJs(this.c, new String[] { paramBundle.toString() });
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
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!"odapp".equals(paramString2)) {}
    label255:
    do
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.i("XProxy|ODAppJSPlugin", 2, "handleJsRequest: url = " + paramString1 + ", pkgName = " + paramString2 + ", method = " + paramString3 + ", args = " + paramVarArgs);
      }
      Object localObject = this.mRuntime.a().getCurrentAccountUin();
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("pre_huayang_plugin_new_start_mode", 4).edit();
      if (TextUtils.equals(paramString3, "open"))
      {
        localEditor.putBoolean("huayang_plugin_new_start_mode" + (String)localObject, true);
        localEditor.commit();
      }
      while ((TextUtils.equals(paramString3, "open")) || (TextUtils.equals(paramString3, "cancelPage")))
      {
        super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
        return false;
        if (TextUtils.equals(paramString3, "odOpenRoom"))
        {
          localEditor.putBoolean("huayang_plugin_new_start_mode" + (String)localObject, false);
          localEditor.commit();
        }
      }
      paramString2 = "";
      paramString1 = "";
      paramJsBridgeListener = null;
      try
      {
        localObject = new JSONObject(paramVarArgs[0]);
        paramJsBridgeListener = (JsBridgeListener)localObject;
      }
      catch (JSONException localJSONException)
      {
        break label255;
        int j = 0;
        int i = 0;
        paramJsBridgeListener = paramString2;
        continue;
      }
      if (paramJsBridgeListener == null) {
        break;
      }
      localObject = paramJsBridgeListener.optString("callback");
      i = paramJsBridgeListener.optInt("roomid");
      paramString2 = paramJsBridgeListener.optString("vasname");
      paramString1 = paramJsBridgeListener.optString("userdata");
      j = paramJsBridgeListener.optInt("fromid");
      this.c = ((String)localObject);
      paramJsBridgeListener = paramString2;
    } while ((!"odOpenRoom".equals(paramString3)) || (paramVarArgs.length != 1));
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(0, i, paramJsBridgeListener, paramString1, j);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.od.ODAppJSPlugin
 * JD-Core Version:    0.7.0.1
 */