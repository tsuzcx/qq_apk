package com.tencent.mobileqq.vas.qqvaluecard;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.apollo.handler.IVasExtensionHandler;
import com.tencent.mobileqq.apollo.utils.ApolloClassFactoryApi;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt64Field;
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
    if (localQQAppInterface != null)
    {
      if (TextUtils.isEmpty(localQQAppInterface.getCurrentUin())) {
        return;
      }
      NewIntent localNewIntent = new NewIntent(localQQAppInterface.getApp(), ApolloClassFactoryApi.b());
      localNewIntent.putExtra("cmd", "qqvalue.GetQQValue");
      qqvalue.GetQQValueReq localGetQQValueReq = new qqvalue.GetQQValueReq();
      localGetQQValueReq.uin.set(Long.valueOf(localQQAppInterface.getCurrentUin()).longValue());
      localNewIntent.putExtra("data", localGetQQValueReq.toByteArray());
      localNewIntent.putExtra("timeout", 30000);
      localQQAppInterface.startServlet(localNewIntent);
    }
  }
  
  private void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    paramIntent = new qqvalue.GetQQValueRsp();
    if (paramArrayOfByte == null) {
      return;
    }
    try
    {
      paramIntent.mergeFrom(paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException paramIntent)
    {
      label22:
      break label22;
    }
    paramIntent = null;
    if ((paramIntent != null) && (paramIntent.qq_value.has()))
    {
      if (!paramIntent.qq_value.uin.has()) {
        return;
      }
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append(paramIntent.qq_value.uin.get());
      paramFromServiceMsg.append("");
      paramFromServiceMsg = paramFromServiceMsg.toString();
      QQValueInfoManage.a().b(paramFromServiceMsg, paramIntent.qq_value);
    }
  }
  
  public void a(IApolloExtensionHandler paramIApolloExtensionHandler, Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    a(paramIntent, paramFromServiceMsg, paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qqvaluecard.QqValueGetValueHandler
 * JD-Core Version:    0.7.0.1
 */