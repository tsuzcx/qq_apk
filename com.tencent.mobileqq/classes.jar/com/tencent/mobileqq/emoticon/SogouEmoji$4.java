package com.tencent.mobileqq.emoticon;

import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.api.EmojiManagerServiceConstant;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class SogouEmoji$4
  implements Runnable
{
  SogouEmoji$4(SogouEmoji paramSogouEmoji, List paramList) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("func pullMultipleEmojiKey begins, allPackId:");
      ((StringBuilder)localObject1).append(this.a);
      QLog.d("SogouEmoji", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = this.a;
    if ((localObject1 != null) && (((List)localObject1).size() != 0))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("func pullMultipleEmojiKey,size:");
        ((StringBuilder)localObject1).append(this.a.size());
        QLog.d("SogouEmoji", 2, ((StringBuilder)localObject1).toString());
      }
      localObject1 = null;
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject2 = this.this$0.jdField_a_of_type_ComTencentMobileqqEmosmApiIEmoticonManagerService.syncFindEmoticonPackageById(str);
        if (localObject2 == null)
        {
          this.this$0.jdField_a_of_type_ComTencentMobileqqEmoticonApiIEmojiManagerService.startDownloadEmosmJson(str, EmojiManagerServiceConstant.JSON_EMOSM_MALL);
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("func pullMultipleEmojiKey, packId=");
            ((StringBuilder)localObject2).append(str);
            ((StringBuilder)localObject2).append(",fail to search 【the pack】 from db, try get json from svr.");
            QLog.d("SogouEmoji", 2, ((StringBuilder)localObject2).toString());
          }
        }
        else
        {
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("func pullMultipleEmojiKey, packId=");
            ((StringBuilder)localObject3).append(str);
            ((StringBuilder)localObject3).append(",type:");
            ((StringBuilder)localObject3).append(((EmoticonPackage)localObject2).type);
            ((StringBuilder)localObject3).append(",json exists in local db.");
            QLog.d("SogouEmoji", 2, ((StringBuilder)localObject3).toString());
          }
          Object localObject3 = this.this$0.jdField_a_of_type_ComTencentMobileqqEmosmApiIEmoticonManagerService.syncGetSubEmoticonsByPackageId(str, true);
          localObject2 = localObject1;
          if ((localObject3 instanceof ArrayList))
          {
            localObject1 = (ArrayList)localObject3;
            localObject2 = this.this$0.a((ArrayList)localObject1);
          }
          localObject1 = localObject2;
          if (localObject2 != null) {
            if (((ArrayList)localObject2).size() == 0)
            {
              localObject1 = localObject2;
            }
            else
            {
              this.this$0.a(str, (ArrayList)localObject2);
              localObject1 = localObject2;
              if (QLog.isColorLevel())
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("func pullMultipleEmojiKey ends, packId=");
                ((StringBuilder)localObject1).append(str);
                ((StringBuilder)localObject1).append(", try get keys from svr.");
                QLog.d("SogouEmoji", 2, ((StringBuilder)localObject1).toString());
                localObject1 = localObject2;
              }
            }
          }
        }
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmoji", 2, "func pullMultipleEmojiKey ends, param packid is null.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.SogouEmoji.4
 * JD-Core Version:    0.7.0.1
 */