package com.tencent.mobileqq.guild.webview;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import org.json.JSONObject;

class QQGuildJsPlugin$1
  implements EIPCResultCallback
{
  QQGuildJsPlugin$1(QQGuildJsPlugin paramQQGuildJsPlugin, String paramString) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    try
    {
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("result", paramEIPCResult.data.getInt("errCode"));
      ((JSONObject)localObject1).put("msg", paramEIPCResult.data.getString("errMsg"));
      ((JSONObject)localObject1).put("key", paramEIPCResult.data.getString("key"));
      ((JSONObject)localObject1).put("actionCode", paramEIPCResult.data.getLong("actionCode"));
      ((JSONObject)localObject1).put("strPrompt", paramEIPCResult.data.getString("strPrompt"));
      ((JSONObject)localObject1).put("strDetail", paramEIPCResult.data.getString("strDetail"));
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("callbackId->");
        ((StringBuilder)localObject2).append(this.a);
        ((StringBuilder)localObject2).append(" callbackOk");
        ((StringBuilder)localObject2).append(paramEIPCResult.toString());
        QLog.d("QQGuildJsPlugin", 2, ((StringBuilder)localObject2).toString());
      }
      paramEIPCResult = this.b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.a);
      ((StringBuilder)localObject2).append("&&");
      ((StringBuilder)localObject2).append(this.a);
      ((StringBuilder)localObject2).append("(");
      ((StringBuilder)localObject2).append(((JSONObject)localObject1).toString());
      ((StringBuilder)localObject2).append(");");
      paramEIPCResult.callJs(((StringBuilder)localObject2).toString());
      return;
    }
    catch (Exception paramEIPCResult)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQGuildJsPlugin", 2, paramEIPCResult.getMessage());
      }
      Object localObject1 = this.b;
      Object localObject2 = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("exception:");
      localStringBuilder.append(paramEIPCResult.getMessage());
      ((QQGuildJsPlugin)localObject1).a((String)localObject2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.webview.QQGuildJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */