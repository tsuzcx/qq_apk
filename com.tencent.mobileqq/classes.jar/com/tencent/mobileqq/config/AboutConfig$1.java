package com.tencent.mobileqq.config;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class AboutConfig$1
  implements Runnable
{
  AboutConfig$1(AboutConfig paramAboutConfig, boolean paramBoolean) {}
  
  public void run()
  {
    int i = 0;
    ??? = AboutConfig.a(this.this$0).getEntityManagerFactory().createEntityManager();
    List localList = ResourcePluginInfo.getAll((EntityManager)???, 32, false);
    ((EntityManager)???).close();
    int j;
    if (localList != null)
    {
      j = localList.size();
      i = j;
      if (j <= 0) {}
    }
    synchronized (AboutConfig.a(this.this$0))
    {
      AboutConfig.a(this.this$0);
      AboutConfig.a(this.this$0, localList);
      this.this$0.b();
      i = j;
      if (QLog.isColorLevel()) {
        QLog.d("AboutConfig", 2, "Load about config from DB = " + AboutConfig.a(this.this$0) + ",asynchronous=" + this.a + ",size=" + i);
      }
      AboutConfig.a(this.this$0, true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.AboutConfig.1
 * JD-Core Version:    0.7.0.1
 */