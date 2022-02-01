package com.tencent.mobileqq.scribble;

import com.tencent.mobileqq.data.MessageForScribble;

class ScribbleDownloader$1
  implements Runnable
{
  ScribbleDownloader$1(ScribbleDownloader paramScribbleDownloader, ScribbleDownloadInfo paramScribbleDownloadInfo) {}
  
  public void run()
  {
    ScribbleDownloader.a(this.this$0, "dowmthreak", "start download ,uniseq:" + this.a.a.uniseq);
    new ScribbleBaseOperator(this.this$0.a).a(this.a.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.scribble.ScribbleDownloader.1
 * JD-Core Version:    0.7.0.1
 */