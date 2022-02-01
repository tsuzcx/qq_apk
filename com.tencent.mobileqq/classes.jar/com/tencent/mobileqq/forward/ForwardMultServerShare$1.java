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
    if ((paramSendResult != null) && (QLog.isColorLevel())) {
      QLog.d(ForwardMultServerShare.a(), 2, "requestNormalShare updateMsg info =" + paramSendResult);
    }
  }
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    String str = ForwardMultServerShare.a(this.a).getString("uin");
    HashMap localHashMap = new HashMap();
    if (ForwardMultServerShare.a(this.a))
    {
      localObject = "1";
      localHashMap.put("param_time_out", localObject);
      if (str != null) {
        break label125;
      }
    }
    label125:
    for (Object localObject = "";; localObject = str)
    {
      ForwardStatisticsReporter.a("KEY_STAGE_2_SEND_MSG_BY_SERVER", (String)localObject, localHashMap, ForwardUtils.a(paramSendResult));
      QLog.d(ForwardMultServerShare.a(), 1, new Object[] { "requestNormalShare onSend result =", paramSendResult, ", isTimeOut=", Boolean.valueOf(ForwardMultServerShare.a(this.a)) });
      if (!ForwardMultServerShare.a(this.a)) {
        break label132;
      }
      return;
      localObject = "0";
      break;
    }
    label132:
    if (ForwardUtils.a(paramSendResult))
    {
      paramSendResult = (String[])paramSendResult.jdField_a_of_type_JavaLangObject;
      QLog.i(ForwardMultServerShare.a(), 1, "requestNormalShare onSend urls=" + paramSendResult[0] + " ," + paramSendResult[1]);
      ForwardMultServerShare.a(this.a, paramSendResult[0], paramSendResult[1]);
      return;
    }
    int i = paramSendResult.b;
    boolean bool = ForwardUtils.a(ForwardMultServerShare.a(this.a));
    localObject = (String[])paramSendResult.jdField_a_of_type_JavaLangObject;
    QLog.e(ForwardMultServerShare.a(), 1, new Object[] { "requestNormalShare onSend error result.result : ", Integer.valueOf(paramSendResult.jdField_a_of_type_Int), ", errCode=" + i + ", hasSDPermission=" + bool });
    if ((i == 9402) && (!bool) && (localObject != null) && (localObject.length == 2))
    {
      ForwardMultServerShare.a(this.a, localObject[0], localObject[1]);
      return;
    }
    ForwardMultServerShare.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardMultServerShare.1
 * JD-Core Version:    0.7.0.1
 */