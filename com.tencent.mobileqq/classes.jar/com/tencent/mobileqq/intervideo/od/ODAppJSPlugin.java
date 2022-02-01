package com.tencent.mobileqq.intervideo.od;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.intervideo.huayang.impl.HuayangJsPluginImpl;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ODAppJSPlugin
  extends HuayangJsPluginImpl
  implements ITroopMemberApiClientApi.Callback
{
  public static final String NAMESPACE = "odapp";
  private String mJsCallback;
  
  public ODAppJSPlugin()
  {
    this.mPluginNameSpace = "odapp";
  }
  
  public void callback(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    if (("onOpenRoomResult".equals(paramBundle.getString("method"))) && (this.mJsCallback != null))
    {
      int i = paramBundle.getInt("code", 0);
      paramBundle = new JSONObject();
      try
      {
        paramBundle.put("code", i);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      callJs(this.mJsCallback, new String[] { paramBundle.toString() });
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!"odapp".equals(paramString2)) {
      return false;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleJsRequest: url = ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", pkgName = ");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(", method = ");
      ((StringBuilder)localObject).append(paramString3);
      ((StringBuilder)localObject).append(", args = ");
      ((StringBuilder)localObject).append(paramVarArgs);
      QLog.i("XProxy|ODAppJSPlugin", 2, ((StringBuilder)localObject).toString());
    }
    if ((!TextUtils.equals(paramString3, "open")) && (!TextUtils.equals(paramString3, "cancelPage"))) {
      paramJsBridgeListener = null;
    }
    try
    {
      paramString1 = new JSONObject(paramVarArgs[0]);
      paramJsBridgeListener = paramString1;
    }
    catch (JSONException paramString1)
    {
      label138:
      int j;
      int i;
      break label138;
    }
    if (paramJsBridgeListener != null)
    {
      localObject = paramJsBridgeListener.optString("callback");
      j = paramJsBridgeListener.optInt("roomid");
      paramString2 = paramJsBridgeListener.optString("vasname");
      paramString1 = paramJsBridgeListener.optString("userdata");
      i = paramJsBridgeListener.optInt("fromid");
      this.mJsCallback = ((String)localObject);
      paramJsBridgeListener = paramString2;
    }
    else
    {
      paramJsBridgeListener = "";
      paramString1 = paramJsBridgeListener;
      j = 0;
      i = 0;
    }
    if (("odOpenRoom".equals(paramString3)) && (paramVarArgs.length == 1))
    {
      this.mClient.a(0, j, paramJsBridgeListener, paramString1, i);
      return true;
      super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.od.ODAppJSPlugin
 * JD-Core Version:    0.7.0.1
 */