package com.tencent.mobileqq.forward;

import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import tencent.im.msg.im_msg_body.RichText;

class ForwardMultServerShare$1
  implements UpCallBack
{
  ForwardMultServerShare$1(ForwardMultServerShare paramForwardMultServerShare) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(UpCallBack.SendResult paramSendResult)
  {
    if ((paramSendResult != null) && (QLog.isColorLevel()))
    {
      String str = ForwardMultServerShare.d();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestNormalShare updateMsg info =");
      localStringBuilder.append(paramSendResult);
      QLog.d(str, 2, localStringBuilder.toString());
    }
  }
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    Object localObject2 = this.a.a.getString("uin");
    HashMap localHashMap = new HashMap();
    if (ForwardMultServerShare.a(this.a)) {
      localObject1 = "1";
    } else {
      localObject1 = "0";
    }
    localHashMap.put("param_time_out", localObject1);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    ForwardStatisticsReporter.a("KEY_STAGE_2_SEND_MSG_BY_SERVER", (String)localObject1, localHashMap, ForwardUtils.a(paramSendResult));
    QLog.d(ForwardMultServerShare.d(), 1, new Object[] { "requestNormalShare onSend result =", paramSendResult, ", isTimeOut=", Boolean.valueOf(ForwardMultServerShare.a(this.a)) });
    if (ForwardMultServerShare.a(this.a)) {
      return;
    }
    if (ForwardUtils.a(paramSendResult))
    {
      paramSendResult = (String[])paramSendResult.l;
      localObject1 = ForwardMultServerShare.d();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("requestNormalShare onSend urls=");
      ((StringBuilder)localObject2).append(paramSendResult[0]);
      ((StringBuilder)localObject2).append(" ,");
      ((StringBuilder)localObject2).append(paramSendResult[1]);
      QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      ForwardMultServerShare.a(this.a, paramSendResult[0], paramSendResult[1]);
      return;
    }
    int i = paramSendResult.b;
    boolean bool = ForwardUtils.a(ForwardMultServerShare.b(this.a));
    localObject1 = (String[])paramSendResult.l;
    localObject2 = ForwardMultServerShare.d();
    int j = paramSendResult.a;
    paramSendResult = new StringBuilder();
    paramSendResult.append(", errCode=");
    paramSendResult.append(i);
    paramSendResult.append(", hasSDPermission=");
    paramSendResult.append(bool);
    QLog.e((String)localObject2, 1, new Object[] { "requestNormalShare onSend error result.result : ", Integer.valueOf(j), paramSendResult.toString() });
    if ((i == 9402) && (!bool) && (localObject1 != null) && (localObject1.length == 2))
    {
      ForwardMultServerShare.a(this.a, localObject1[0], localObject1[1]);
      return;
    }
    ForwardMultServerShare.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardMultServerShare.1
 * JD-Core Version:    0.7.0.1
 */