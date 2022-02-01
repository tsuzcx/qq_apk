package com.tencent.mobileqq.kandian.biz.framework.handlers;

import com.tencent.mobileqq.kandian.repo.biu.RIJNewBiuCardTransformManager;
import com.tencent.qphone.base.util.QLog;

class FrameworkHandler$5
  implements Runnable
{
  FrameworkHandler$5(FrameworkHandler paramFrameworkHandler) {}
  
  public void run()
  {
    RIJNewBiuCardTransformManager.a().a();
    QLog.d("FrameworkHandler", 2, "transformCommentBiuCard | in recommend feeds and transform ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.handlers.FrameworkHandler.5
 * JD-Core Version:    0.7.0.1
 */