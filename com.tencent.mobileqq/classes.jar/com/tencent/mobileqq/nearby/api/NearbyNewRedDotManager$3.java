package com.tencent.mobileqq.nearby.api;

import com.tencent.imcore.message.BaseMessageProcessor;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.tianshu.api.IRedTouchServer;
import com.tencent.mobileqq.tianshu.data.NumRedGetMsgCallback;
import com.tencent.mobileqq.tianshu.pb.NumRedMsg.NumMsgBusi;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class NearbyNewRedDotManager$3
  extends NumRedGetMsgCallback
{
  NearbyNewRedDotManager$3(NearbyNewRedDotManager paramNearbyNewRedDotManager, QQAppInterface paramQQAppInterface) {}
  
  public void a(String paramString, List<NumRedMsg.NumMsgBusi> paramList)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateNumMsg: appid msgList.size = ");
      localStringBuilder.append(paramList.size());
      QLog.d("NearbyNewRedDotManagerQ.qqstory.redPoint", 2, localStringBuilder.toString());
    }
    if (("nearby_num_red_dot".equals(paramString)) && (paramList != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyApiNearbyNewRedDotManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList);
      ((IRedTouchServer)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IRedTouchServer.class, "")).notifyRedTouchUpdate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler();
      if ((paramString != null) && (paramString.a("businessbase_processor") != null)) {
        paramString.a("businessbase_processor").a(105, true, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.NearbyNewRedDotManager.3
 * JD-Core Version:    0.7.0.1
 */