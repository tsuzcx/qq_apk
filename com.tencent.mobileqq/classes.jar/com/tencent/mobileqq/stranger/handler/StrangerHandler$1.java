package com.tencent.mobileqq.stranger.handler;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.stranger.data.Stranger;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class StrangerHandler$1
  implements Runnable
{
  StrangerHandler$1(StrangerHandler paramStrangerHandler) {}
  
  public void run()
  {
    try
    {
      EntityManager localEntityManager = StrangerHandler.a(this.this$0).getEntityManagerFactory().createEntityManager();
      List localList = localEntityManager.query(Stranger.class);
      Object localObject = localList;
      if (localList == null) {
        localObject = new ArrayList();
      }
      localEntityManager.close();
      this.this$0.notifyUI(1, true, localObject);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("StrangerHandler", 1, "getLocalList fail.", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.stranger.handler.StrangerHandler.1
 * JD-Core Version:    0.7.0.1
 */