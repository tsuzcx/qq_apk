package com.tencent.mobileqq.forward;

import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import tencent.im.msg.im_msg_body.RichText;

class ForwardShareByServerHelper$1
  implements UpCallBack
{
  ForwardShareByServerHelper$1(ForwardShareByServerHelper paramForwardShareByServerHelper) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(UpCallBack.SendResult paramSendResult)
  {
    if (paramSendResult != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("upCallBack updateMsg info =");
      localStringBuilder.append(paramSendResult);
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, localStringBuilder.toString());
    }
  }
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    String str1 = ForwardShareByServerHelper.a(this.a).getString("uin");
    HashMap localHashMap = new HashMap();
    boolean bool = ForwardShareByServerHelper.b(this.a);
    String str2 = "1";
    if (bool) {
      localObject = "1";
    } else {
      localObject = "0";
    }
    localHashMap.put("param_time_out", localObject);
    if (ForwardShareByServerHelper.c(this.a)) {
      localObject = str2;
    } else {
      localObject = "0";
    }
    localHashMap.put("param_is_first_show", localObject);
    Object localObject = str1;
    if (str1 == null) {
      localObject = "";
    }
    ForwardStatisticsReporter.a("KEY_STAGE_2_SEND_MSG_BY_SERVER", (String)localObject, localHashMap, ForwardUtils.a(paramSendResult));
    QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, new Object[] { "UpCallBack onSend result =", paramSendResult, ", isTimeOut=", Boolean.valueOf(ForwardShareByServerHelper.b(this.a)), ", isFirstShow =", Boolean.valueOf(ForwardShareByServerHelper.c(this.a)) });
    if (!ForwardShareByServerHelper.c(this.a)) {
      return;
    }
    if (ForwardShareByServerHelper.b(this.a)) {
      return;
    }
    int i = paramSendResult.a;
    if (i == 0)
    {
      paramSendResult = (String[])paramSendResult.l;
      if ((paramSendResult != null) && (paramSendResult.length == 2))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("UpCallBack onSend urls=");
        ((StringBuilder)localObject).append(paramSendResult[0]);
        ((StringBuilder)localObject).append(" ,");
        ((StringBuilder)localObject).append(paramSendResult[1]);
        QLog.i("SDK_SHARE.ForwardShareByServerHelper", 1, ((StringBuilder)localObject).toString());
        localObject = this.a;
        ForwardShareByServerHelper.a((ForwardShareByServerHelper)localObject, ForwardShareByServerHelper.a((ForwardShareByServerHelper)localObject), paramSendResult[0], paramSendResult[1]);
        return;
      }
      QLog.e("SDK_SHARE.ForwardShareByServerHelper", 1, "onSend updateMsg error !");
      return;
    }
    if (-1 == i)
    {
      i = paramSendResult.b;
      bool = ForwardUtils.a(ForwardShareByServerHelper.d(this.a));
      paramSendResult = (String[])paramSendResult.l;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("UpCallBack onSend failed errCode=");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(", hasSDPermission=");
      ((StringBuilder)localObject).append(bool);
      QLog.i("SDK_SHARE.ForwardShareByServerHelper", 1, ((StringBuilder)localObject).toString());
      if ((i == 9402) && (!bool) && (paramSendResult != null) && (paramSendResult.length == 2))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("UpCallBack onSend failed urls=");
        ((StringBuilder)localObject).append(paramSendResult[0]);
        ((StringBuilder)localObject).append(" ,");
        ((StringBuilder)localObject).append(paramSendResult[1]);
        QLog.i("SDK_SHARE.ForwardShareByServerHelper", 1, ((StringBuilder)localObject).toString());
        localObject = this.a;
        ForwardShareByServerHelper.a((ForwardShareByServerHelper)localObject, ForwardShareByServerHelper.a((ForwardShareByServerHelper)localObject), paramSendResult[0], paramSendResult[1]);
        return;
      }
      ForwardShareByServerHelper.a(this.a, ForwardShareByServerHelper.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardShareByServerHelper.1
 * JD-Core Version:    0.7.0.1
 */