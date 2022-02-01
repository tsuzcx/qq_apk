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
    if (paramSendResult != null) {
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, "upCallBack updateMsg info =" + paramSendResult);
    }
  }
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    String str2 = ForwardShareByServerHelper.a(this.a).getString("uin");
    HashMap localHashMap = new HashMap();
    String str1;
    if (ForwardShareByServerHelper.a(this.a))
    {
      str1 = "1";
      localHashMap.put("param_time_out", str1);
      if (!ForwardShareByServerHelper.b(this.a)) {
        break label167;
      }
      str1 = "1";
      label61:
      localHashMap.put("param_is_first_show", str1);
      if (str2 != null) {
        break label174;
      }
      str1 = "";
      label80:
      ForwardStatisticsReporter.a("KEY_STAGE_2_SEND_MSG_BY_SERVER", str1, localHashMap, ForwardUtils.a(paramSendResult));
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, new Object[] { "UpCallBack onSend result =", paramSendResult, ", isTimeOut=", Boolean.valueOf(ForwardShareByServerHelper.a(this.a)), ", isFirstShow =", Boolean.valueOf(ForwardShareByServerHelper.b(this.a)) });
      if (ForwardShareByServerHelper.b(this.a)) {
        break label181;
      }
    }
    label167:
    label174:
    label181:
    do
    {
      do
      {
        return;
        str1 = "0";
        break;
        str1 = "0";
        break label61;
        str1 = str2;
        break label80;
      } while (ForwardShareByServerHelper.a(this.a));
      i = paramSendResult.jdField_a_of_type_Int;
      if (i == 0)
      {
        paramSendResult = (String[])paramSendResult.jdField_a_of_type_JavaLangObject;
        if ((paramSendResult != null) && (paramSendResult.length == 2))
        {
          QLog.i("SDK_SHARE.ForwardShareByServerHelper", 1, "UpCallBack onSend urls=" + paramSendResult[0] + " ," + paramSendResult[1]);
          ForwardShareByServerHelper.a(this.a, ForwardShareByServerHelper.a(this.a), paramSendResult[0], paramSendResult[1]);
          return;
        }
        QLog.e("SDK_SHARE.ForwardShareByServerHelper", 1, "onSend updateMsg error !");
        return;
      }
    } while (-1 != i);
    int i = paramSendResult.b;
    boolean bool = ForwardUtils.a(ForwardShareByServerHelper.a(this.a));
    paramSendResult = (String[])paramSendResult.jdField_a_of_type_JavaLangObject;
    QLog.i("SDK_SHARE.ForwardShareByServerHelper", 1, "UpCallBack onSend failed errCode=" + i + ", hasSDPermission=" + bool);
    if ((i == 9402) && (!bool) && (paramSendResult != null) && (paramSendResult.length == 2))
    {
      QLog.i("SDK_SHARE.ForwardShareByServerHelper", 1, "UpCallBack onSend failed urls=" + paramSendResult[0] + " ," + paramSendResult[1]);
      ForwardShareByServerHelper.a(this.a, ForwardShareByServerHelper.a(this.a), paramSendResult[0], paramSendResult[1]);
      return;
    }
    ForwardShareByServerHelper.a(this.a, ForwardShareByServerHelper.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardShareByServerHelper.1
 * JD-Core Version:    0.7.0.1
 */