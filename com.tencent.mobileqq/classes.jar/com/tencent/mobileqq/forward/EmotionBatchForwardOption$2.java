package com.tencent.mobileqq.forward;

import android.os.Bundle;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class EmotionBatchForwardOption$2
  implements Runnable
{
  EmotionBatchForwardOption$2(EmotionBatchForwardOption paramEmotionBatchForwardOption) {}
  
  public void run()
  {
    Object localObject1 = this.this$0.jdField_a_of_type_AndroidOsBundle.getString("uin");
    Object localObject2 = this.this$0.jdField_a_of_type_AndroidOsBundle.getString("troop_uin");
    int i = this.this$0.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.jdField_a_of_type_Int = i;
    localSessionInfo.jdField_a_of_type_JavaLangString = ((String)localObject1);
    localSessionInfo.b = ((String)localObject2);
    localObject1 = "";
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog instanceof QQCustomDialogWtihEmoticonInput))
    {
      localObject1 = ((QQCustomDialogWtihEmoticonInput)this.this$0.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog).getInputValue();
      if ((localObject1 != null) && (!((String)localObject1).equals(""))) {
        ChatActivityFacade.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_AndroidContentContext, localSessionInfo, (String)localObject1, null);
      }
      localObject1 = this.this$0.jdField_a_of_type_JavaUtilArrayList.iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        return;
      }
      localObject2 = (String)((Iterator)localObject1).next();
      String str = EmotionBatchForwardOption.a((String)localObject2);
      if ("MARK_EMOTION:".equals(str))
      {
        localObject2 = ((String)localObject2).substring(((String)localObject2).indexOf(":") + 1).split("_&_");
        if (localObject2.length < 2) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("EmotionBatchForwardOption", 2, "forwardOnConfirm epId:" + localObject2[0] + ",eId:" + localObject2[1]);
        }
        ((EmoticonManager)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(String.valueOf(localObject2[0]), localObject2[1], new EmotionBatchForwardOption.2.1(this, localSessionInfo));
        continue;
        if (!(this.this$0.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog instanceof ForwardNewVersionDialog)) {
          break;
        }
        localObject1 = ((ForwardNewVersionDialog)this.this$0.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog).getInputValue();
        break;
      }
      if ("PIC_EMOTION:".equals(str))
      {
        localObject2 = ((String)localObject2).substring(((String)localObject2).indexOf(":") + 1);
        if (QLog.isColorLevel()) {
          QLog.d("EmotionBatchForwardOption", 2, "forwardOnConfirm  path：" + (String)localObject2);
        }
        ChatActivityFacade.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_AndroidContentContext, localSessionInfo, (String)localObject2, false, "", null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.EmotionBatchForwardOption.2
 * JD-Core Version:    0.7.0.1
 */