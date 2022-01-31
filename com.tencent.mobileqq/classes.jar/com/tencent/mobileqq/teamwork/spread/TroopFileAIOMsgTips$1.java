package com.tencent.mobileqq.teamwork.spread;

import ancy;
import andb;
import awzy;
import ayha;
import ayhl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class TroopFileAIOMsgTips$1
  implements Runnable
{
  public TroopFileAIOMsgTips$1(ayhl paramayhl, ayha paramayha) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopFileAIOMsgTips", 1, "sub Thread getWordsList by TroopFile[" + System.currentTimeMillis() + "]");
    }
    long l1 = awzy.a();
    ArrayList localArrayList = new ArrayList();
    int i = andb.a().a();
    List localList = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.this$0.jdField_a_of_type_JavaLangString, 1, 9223372036854775807L, 3, 9223372036854775807L, new int[] { -2017 }, i);
    if ((localList == null) || (localList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopFileAIOMsgTips", 1, "current AIO has not File,peerType[" + this.this$0.jdField_a_of_type_Int + "]");
      }
      this.a.a(localArrayList);
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopFileAIOMsgTips", 1, "current AIO msg count[" + localList.size() + "]");
    }
    long l2 = andb.a().c() * 3600;
    i = 0;
    if (i < localList.size())
    {
      Object localObject = (MessageRecord)localList.get(i);
      if (!(localObject instanceof MessageForTroopFile)) {}
      for (;;)
      {
        i += 1;
        break;
        if ((this.this$0.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq != ((MessageRecord)localObject).uniseq) && (new ayhl(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ChatMessage)localObject, this.this$0.jdField_a_of_type_Ayhf).a()))
        {
          localObject = (MessageForTroopFile)localObject;
          if (l1 - ((MessageForTroopFile)localObject).time <= l2) {
            localArrayList.add(((MessageForTroopFile)localObject).fileName);
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopFileAIOMsgTips", 1, "find file msg count[" + localArrayList.size() + "]");
    }
    this.a.a(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.TroopFileAIOMsgTips.1
 * JD-Core Version:    0.7.0.1
 */