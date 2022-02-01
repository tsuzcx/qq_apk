package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.biz.pubaccount.util.PAVideoStructMsgUtil;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVideo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

final class VideoReporter$2
  implements Runnable
{
  VideoReporter$2(int paramInt1, QQAppInterface paramQQAppInterface, String paramString, int paramInt2, long paramLong) {}
  
  public void run()
  {
    long l1;
    Object localObject3;
    if (this.jdField_a_of_type_Int == -2011)
    {
      l1 = System.currentTimeMillis();
      localObject3 = PAVideoStructMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Long));
      if (localObject3 == null) {}
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        Object localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("vid", ((StructMsgItemVideo)localObject3).ae);
        ((JSONObject)localObject1).put("os", "1");
        if (UinTypeUtil.b(this.b))
        {
          i = 1;
        }
        else if (this.b == 1)
        {
          i = 2;
        }
        else
        {
          if (this.b != 3000) {
            break label266;
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
      IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      if (((StructMsgItemVideo)localObject3).aj == null) {
        localObject3 = "0";
      } else {
        localObject3 = ((StructMsgItemVideo)localObject3).aj;
      }
      localIPublicAccountReportUtils.publicAccountReportClickEvent(null, "", "0X80077DF", "0X80077DF", 0, 0, "0", "1", (String)localObject3, (String)localObject2, false);
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("reportVideoStructMsgSendSuc cost = ");
        ((StringBuilder)localObject2).append(l2 - l1);
        ((StringBuilder)localObject2).append("ms");
        QLog.d("VideoReporter", 2, ((StringBuilder)localObject2).toString());
      }
      return;
      label266:
      int i = 4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter.2
 * JD-Core Version:    0.7.0.1
 */