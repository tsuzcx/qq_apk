package com.tencent.mobileqq.vaswebviewplugin;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import org.json.JSONObject;

class QQIliveJsPlugin$1
  implements EIPCResultCallback
{
  QQIliveJsPlugin$1(QQIliveJsPlugin paramQQIliveJsPlugin, Object paramObject, String paramString) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    int i = 0;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (paramEIPCResult.data != null) {
        i = paramEIPCResult.data.getInt("ret");
      }
      localJSONObject.put("ret", i);
      QLog.i("QQIliveJsPlugin", 1, "followAnchor ret = " + i + " type = " + this.val$type);
      this.this$0.callJs(this.val$callbackId, new String[] { localJSONObject.toString() });
      if (i == 0)
      {
        paramEIPCResult = new Intent();
        paramEIPCResult.setAction("action_follow_change");
        paramEIPCResult.putExtra("key_follow_state", (Integer)this.val$type);
        BaseApplicationImpl.getApplication().sendBroadcast(paramEIPCResult);
      }
      return;
    }
    catch (Throwable paramEIPCResult)
    {
      paramEIPCResult.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QQIliveJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */