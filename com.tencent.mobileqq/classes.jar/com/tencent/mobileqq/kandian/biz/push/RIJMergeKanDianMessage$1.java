package com.tencent.mobileqq.kandian.biz.push;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;

final class RIJMergeKanDianMessage$1
  implements Runnable
{
  RIJMergeKanDianMessage$1(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    ((KandianMergeManager)this.a.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).B();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.push.RIJMergeKanDianMessage.1
 * JD-Core Version:    0.7.0.1
 */