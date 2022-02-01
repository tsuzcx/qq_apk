package com.tencent.mobileqq.vas.qqvaluecard;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.api.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.apollo.api.handler.IApolloExtensionServlet;
import com.tencent.mobileqq.apollo.api.handler.IVasExtensionHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.pb.qqvalue.qqvalue.GetQQValueReq;
import com.tencent.pb.qqvalue.qqvalue.GetQQValueRsp;
import com.tencent.pb.qqvalue.qqvalue.UserQQValueInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import mqq.app.NewIntent;

public class QqValueGetValueHandler
  implements IVasExtensionHandler
{
  public static void a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((localQQAppInterface == null) || (TextUtils.isEmpty(localQQAppInterface.getCurrentUin()))) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(localQQAppInterface.getApp(), ((IApolloExtensionServlet)QRoute.api(IApolloExtensionServlet.class)).getImplClass());
    localNewIntent.putExtra("cmd", "qqvalue.GetQQValue");
    qqvalue.GetQQValueReq localGetQQValueReq = new qqvalue.GetQQValueReq();
    localGetQQValueReq.uin.set(Long.valueOf(localQQAppInterface.getCurrentUin()).longValue());
    localNewIntent.putExtra("data", localGetQQValueReq.toByteArray());
    localNewIntent.putExtra("timeout", 30000);
    localQQAppInterface.startServlet(localNewIntent);
  }
  
  private void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    paramIntent = new qqvalue.GetQQValueRsp();
    if (paramArrayOfByte == null) {}
    for (;;)
    {
      return;
      try
      {
        paramIntent.mergeFrom(paramArrayOfByte);
        if ((paramIntent == null) || (!paramIntent.qq_value.has()) || (!paramIntent.qq_value.uin.has())) {
          continue;
        }
        paramFromServiceMsg = paramIntent.qq_value.uin.get() + "";
        QQValueInfoManage.a().b(paramFromServiceMsg, paramIntent.qq_value);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramIntent)
      {
        for (;;)
        {
          paramIntent = null;
        }
      }
    }
  }
  
  public void a(IApolloExtensionHandler paramIApolloExtensionHandler, Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    a(paramIntent, paramFromServiceMsg, paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qqvaluecard.QqValueGetValueHandler
 * JD-Core Version:    0.7.0.1
 */