package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.biz.pubaccount.util.PAVideoStructMsgUtil;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVideo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

final class VideoReporter$3
  implements Runnable
{
  VideoReporter$3(MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    long l1;
    Object localObject3;
    if ((this.a.msgtype == -2011) && (!this.a.isSend()))
    {
      l1 = System.currentTimeMillis();
      localObject3 = PAVideoStructMsgUtil.a(this.a);
      if (localObject3 == null) {}
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        Object localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("vid", ((StructMsgItemVideo)localObject3).az);
        ((JSONObject)localObject1).put("os", "1");
        if (UinTypeUtil.b(this.a.istroop))
        {
          i = 1;
        }
        else if (this.a.istroop == 1)
        {
          i = 2;
        }
        else
        {
          if (this.a.istroop != 3000) {
            break label256;
          }
          i = 3;
        }
        ((JSONObject)localObject1).put("aiotype", i);
        localObject1 = ((JSONObject)localObject1).toString();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localObject2 = "";
      }
      if (((StructMsgItemVideo)localObject3).aO == null) {
        localObject3 = "0";
      } else {
        localObject3 = ((StructMsgItemVideo)localObject3).aO;
      }
      PublicAccountReportUtils.a(null, "", "0X80077DF", "0X80077DF", 0, 0, "0", "2", (String)localObject3, (String)localObject2, false);
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("reportVideoStructMsgRecv cost = ");
        ((StringBuilder)localObject2).append(l2 - l1);
        ((StringBuilder)localObject2).append("ms");
        QLog.d("VideoReporter", 2, ((StringBuilder)localObject2).toString());
      }
      return;
      label256:
      int i = 4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter.3
 * JD-Core Version:    0.7.0.1
 */