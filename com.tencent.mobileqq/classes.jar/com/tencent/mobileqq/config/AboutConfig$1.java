package com.tencent.mobileqq.config;

import aojv;
import awgf;
import awgg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class AboutConfig$1
  implements Runnable
{
  public AboutConfig$1(aojv paramaojv, boolean paramBoolean) {}
  
  public void run()
  {
    int i = 0;
    ??? = aojv.a(this.this$0).getEntityManagerFactory().createEntityManager();
    List localList = ResourcePluginInfo.getAll((awgf)???, 32, false);
    ((awgf)???).a();
    int j;
    if (localList != null)
    {
      j = localList.size();
      i = j;
      if (j <= 0) {}
    }
    synchronized (aojv.a(this.this$0))
    {
      aojv.a(this.this$0);
      aojv.a(this.this$0, localList);
      this.this$0.b();
      i = j;
      if (QLog.isColorLevel()) {
        QLog.d("AboutConfig", 2, "Load about config from DB = " + aojv.a(this.this$0) + ",asynchronous=" + this.a + ",size=" + i);
      }
      aojv.a(this.this$0, true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.AboutConfig.1
 * JD-Core Version:    0.7.0.1
 */