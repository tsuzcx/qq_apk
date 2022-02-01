package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;

class KandianMergeManager$4
  implements Runnable
{
  KandianMergeManager$4(KandianMergeManager paramKandianMergeManager) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)ReadInJoyUtils.b();
    TroopBarAssistantManager.a().q(localQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager.4
 * JD-Core Version:    0.7.0.1
 */