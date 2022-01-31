package com.tencent.mobileqq.multimsg;

import aupg;
import azri;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class MultiMsgManager$5
  implements Runnable
{
  public MultiMsgManager$5(aupg paramaupg, QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
    int j;
    int k;
    StringBuilder localStringBuilder;
    if ((localObject != null) && ((localObject instanceof MessageForStructing)) && ("viewMultiMsg".equals(((MessageForStructing)localObject).structingMsg.mMsgAction)))
    {
      localObject = aupg.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
      if (localObject != null)
      {
        j = ((List)localObject).size();
        k = aupg.a().a((Collection)localObject);
        localObject = new HashMap();
        localStringBuilder = new StringBuilder();
        if (!this.jdField_a_of_type_Boolean) {
          break label228;
        }
      }
    }
    label228:
    for (int i = 0;; i = 1)
    {
      ((HashMap)localObject).put("result", i + "");
      ((HashMap)localObject).put("msgCount", j + "");
      ((HashMap)localObject).put("picCount", k + "");
      azri.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "multiMsgSend", this.jdField_a_of_type_Boolean, 30000L, 0L, (HashMap)localObject, "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.MultiMsgManager.5
 * JD-Core Version:    0.7.0.1
 */