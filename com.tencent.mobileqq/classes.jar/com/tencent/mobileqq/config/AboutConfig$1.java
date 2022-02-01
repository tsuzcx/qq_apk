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
    ??? = AboutConfig.a(this.this$0).getEntityManagerFactory().createEntityManager();
    int i = 0;
    List localList = ResourcePluginInfo.getAll((EntityManager)???, 32, false);
    ((EntityManager)???).close();
    if (localList != null)
    {
      int j = localList.size();
      i = j;
      if (j > 0) {
        synchronized (AboutConfig.b(this.this$0))
        {
          AboutConfig.c(this.this$0);
          AboutConfig.a(this.this$0, localList);
          this.this$0.b();
          i = j;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Load about config from DB = ");
      localStringBuilder.append(AboutConfig.b(this.this$0));
      localStringBuilder.append(",asynchronous=");
      localStringBuilder.append(this.a);
      localStringBuilder.append(",size=");
      localStringBuilder.append(i);
      QLog.d("AboutConfig", 2, localStringBuilder.toString());
    }
    AboutConfig.a(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.AboutConfig.1
 * JD-Core Version:    0.7.0.1
 */