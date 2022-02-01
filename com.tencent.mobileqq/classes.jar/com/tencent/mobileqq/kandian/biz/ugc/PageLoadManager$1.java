package com.tencent.mobileqq.kandian.biz.ugc;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

class PageLoadManager$1
  implements Runnable
{
  PageLoadManager$1(PageLoadManager paramPageLoadManager, PageLoadManager.QueryProvider paramQueryProvider) {}
  
  public void run()
  {
    try
    {
      List localList = this.a.a(PageLoadManager.a(this.this$0), PageLoadManager.b(this.this$0));
      ThreadManager.getUIHandler().post(new PageLoadManager.1.1(this, localList));
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("exception in queryImageList(), e=");
        localStringBuilder.append(localThrowable.getMessage());
        QLog.e("PageLoadManager", 2, localStringBuilder.toString());
      }
      ThreadManager.getUIHandler().post(new PageLoadManager.1.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.PageLoadManager.1
 * JD-Core Version:    0.7.0.1
 */