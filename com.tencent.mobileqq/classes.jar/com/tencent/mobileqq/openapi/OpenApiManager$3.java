package com.tencent.mobileqq.openapi;

import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.openapi.entity.ThirdPartyApp;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class OpenApiManager$3
  extends MessageObserver
{
  OpenApiManager$3(OpenApiManager paramOpenApiManager) {}
  
  protected void onSendResult(boolean paramBoolean, String paramString, long paramLong)
  {
    if (OpenApiManager.access$300(this.a).containsKey(Long.valueOf(paramLong)))
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("onSendResult, isSuccess = ");
        paramString.append(paramBoolean);
        paramString.append(", uniseq = ");
        paramString.append(paramLong);
        QLog.d("OpenApi.Manager", 2, paramString.toString());
      }
      paramString = (String)OpenApiManager.access$300(this.a).remove(Long.valueOf(paramLong));
      paramString = (ThirdPartyApp)OpenApiManager.access$200(this.a).get(paramString);
      if (paramString != null)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("com.tencent.mobileqq.openapi.ACTION_MSG_SENDED.");
        ((StringBuilder)localObject).append(paramString.b);
        localObject = new Intent(((StringBuilder)localObject).toString());
        ((Intent)localObject).putExtra("msgid", paramString.a(String.valueOf(paramLong)));
        int i;
        if (paramBoolean) {
          i = 0;
        } else {
          i = -9;
        }
        ((Intent)localObject).putExtra("rs_code", i);
        BaseApplicationImpl.sApplication.sendBroadcast((Intent)localObject, paramString.c);
      }
    }
  }
  
  protected void onUpdateSendMsgError(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    onSendResult(false, paramString1, paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.openapi.OpenApiManager.3
 * JD-Core Version:    0.7.0.1
 */