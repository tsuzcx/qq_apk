package com.tencent.mobileqq.scribble.impl;

import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.scribble.IScribbleMsgUtils;
import com.tencent.mobileqq.scribble.ScribbleDownloadInfo;

class ScribbleDownloaderImpl$1
  implements Runnable
{
  ScribbleDownloaderImpl$1(ScribbleDownloaderImpl paramScribbleDownloaderImpl, ScribbleDownloadInfo paramScribbleDownloadInfo) {}
  
  public void run()
  {
    ScribbleDownloaderImpl localScribbleDownloaderImpl = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start download ,uniseq:");
    localStringBuilder.append(this.a.a.uniseq);
    ScribbleDownloaderImpl.access$000(localScribbleDownloaderImpl, "dowmthreak", localStringBuilder.toString());
    ((IScribbleMsgUtils)QRoute.api(IScribbleMsgUtils.class)).downloadScribble(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.scribble.impl.ScribbleDownloaderImpl.1
 * JD-Core Version:    0.7.0.1
 */