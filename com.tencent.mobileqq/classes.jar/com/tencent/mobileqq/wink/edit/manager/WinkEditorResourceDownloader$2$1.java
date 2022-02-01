package com.tencent.mobileqq.wink.edit.manager;

import com.tencent.mobileqq.wink.edit.bean.AEEditorDownloadResBean;
import com.tencent.mobileqq.wink.edit.log.WinkQLog;
import java.util.concurrent.CountDownLatch;

class WinkEditorResourceDownloader$2$1
  implements WinkEditorResourceDownloader.ResDownLoadListener
{
  WinkEditorResourceDownloader$2$1(WinkEditorResourceDownloader.2 param2, int paramInt, AEEditorDownloadResBean paramAEEditorDownloadResBean, CountDownLatch paramCountDownLatch) {}
  
  public void a(int paramInt) {}
  
  public void a(boolean paramBoolean)
  {
    String str = this.d.this$0.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("preDownloadAllRes---[finish] ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", id=");
    localStringBuilder.append(this.b.getId());
    WinkQLog.b(str, localStringBuilder.toString());
    this.c.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader.2.1
 * JD-Core Version:    0.7.0.1
 */