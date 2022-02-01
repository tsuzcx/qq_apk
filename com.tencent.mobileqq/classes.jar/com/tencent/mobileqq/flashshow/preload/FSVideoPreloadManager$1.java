package com.tencent.mobileqq.flashshow.preload;

import com.tencent.qphone.base.util.QLog;
import java.util.List;

class FSVideoPreloadManager$1
  implements Runnable
{
  FSVideoPreloadManager$1(FSVideoPreloadManager paramFSVideoPreloadManager, List paramList) {}
  
  public void run()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      if (((List)localObject).size() <= 0) {
        return;
      }
      localObject = FSVideoPreloadManager.b();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start preload size:");
      localStringBuilder.append(this.a.size());
      QLog.d((String)localObject, 1, localStringBuilder.toString());
      FSVideoPreloadManager.a(this.this$0, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.preload.FSVideoPreloadManager.1
 * JD-Core Version:    0.7.0.1
 */