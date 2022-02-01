package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;

class KandianMergeManager$2
  implements Runnable
{
  KandianMergeManager$2(KandianMergeManager paramKandianMergeManager) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)ReadInJoyUtils.a();
    TroopBarAssistantManager.a().i(localQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager.2
 * JD-Core Version:    0.7.0.1
 */