package com.tencent.mobileqq.teamwork.spread;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.tendoc.TencentDocTipsConfigBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocTipsConfigProcessor;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class TroopFileAIOMsgTips$1
  implements Runnable
{
  TroopFileAIOMsgTips$1(TroopFileAIOMsgTips paramTroopFileAIOMsgTips, BaseTimAIOTipsProcessor.ListResult paramListResult) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("sub Thread getWordsList by TroopFile[");
      ((StringBuilder)localObject1).append(System.currentTimeMillis());
      ((StringBuilder)localObject1).append("]");
      QLog.i("TroopFileAIOMsgTips", 1, ((StringBuilder)localObject1).toString());
    }
    long l1 = MessageCache.a();
    Object localObject1 = new ArrayList();
    int i = TencentDocTipsConfigProcessor.a().a();
    Object localObject2 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.this$0.jdField_a_of_type_JavaLangString, 1, 9223372036854775807L, 3, 9223372036854775807L, new int[] { -2017 }, i);
    if ((localObject2 != null) && (((List)localObject2).size() != 0))
    {
      Object localObject3;
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("current AIO msg count[");
        ((StringBuilder)localObject3).append(((List)localObject2).size());
        ((StringBuilder)localObject3).append("]");
        QLog.i("TroopFileAIOMsgTips", 1, ((StringBuilder)localObject3).toString());
      }
      long l2 = TencentDocTipsConfigProcessor.a().c() * 3600;
      i = 0;
      while (i < ((List)localObject2).size())
      {
        localObject3 = (MessageRecord)((List)localObject2).get(i);
        if (((localObject3 instanceof MessageForTroopFile)) && (this.this$0.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq != ((MessageRecord)localObject3).uniseq) && (new TroopFileAIOMsgTips(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ChatMessage)localObject3, this.this$0.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSetting).a()))
        {
          localObject3 = (MessageForTroopFile)localObject3;
          if (l1 - ((MessageForTroopFile)localObject3).time <= l2) {
            ((List)localObject1).add(((MessageForTroopFile)localObject3).fileName);
          }
        }
        i += 1;
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("find file msg count[");
        ((StringBuilder)localObject2).append(((List)localObject1).size());
        ((StringBuilder)localObject2).append("]");
        QLog.i("TroopFileAIOMsgTips", 1, ((StringBuilder)localObject2).toString());
      }
      this.a.a((List)localObject1);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("current AIO has not File,peerType[");
      ((StringBuilder)localObject2).append(this.this$0.jdField_a_of_type_Int);
      ((StringBuilder)localObject2).append("]");
      QLog.i("TroopFileAIOMsgTips", 1, ((StringBuilder)localObject2).toString());
    }
    this.a.a((List)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.TroopFileAIOMsgTips.1
 * JD-Core Version:    0.7.0.1
 */