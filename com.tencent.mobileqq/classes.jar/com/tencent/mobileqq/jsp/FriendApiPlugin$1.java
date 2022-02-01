package com.tencent.mobileqq.jsp;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import org.json.JSONException;
import org.json.JSONObject;

class FriendApiPlugin$1
  implements EIPCResultCallback
{
  FriendApiPlugin$1(FriendApiPlugin paramFriendApiPlugin, String[] paramArrayOfString) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    int i = paramEIPCResult.data.getInt("KEY_SUCCESS");
    paramEIPCResult = new StringBuilder();
    paramEIPCResult.append("retCode is ");
    paramEIPCResult.append(i);
    QLog.i("FriendApiPlugin", 1, paramEIPCResult.toString());
    paramEIPCResult = this.a;
    if ((paramEIPCResult != null) && (paramEIPCResult.length > 0)) {
      try
      {
        paramEIPCResult = new JSONObject(paramEIPCResult[0]).optString("callback");
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("result", i);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("result ");
        localStringBuilder.append(localJSONObject);
        QLog.i("FriendApiPlugin", 1, localStringBuilder.toString());
        this.b.callJs(paramEIPCResult, new String[] { localJSONObject.toString() });
        return;
      }
      catch (JSONException paramEIPCResult)
      {
        paramEIPCResult.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.FriendApiPlugin.1
 * JD-Core Version:    0.7.0.1
 */