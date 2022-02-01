package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyLogicEngine$2
  implements Runnable
{
  ReadInJoyLogicEngine$2(ReadInJoyLogicEngine paramReadInJoyLogicEngine, int paramInt) {}
  
  public void run()
  {
    QLog.d("ReadInJoyLogicEngine", 1, new Object[] { "onLoadMoreArticle, channelID = ", Integer.valueOf(this.a) });
    ReadInJoyLogicEngineEventDispatcher.a().b(false, this.a, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine.2
 * JD-Core Version:    0.7.0.1
 */