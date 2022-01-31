package dov.com.tencent.mobileqq.shortvideo;

import bnln;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

public class ShortVideoPreDownloader$2
  extends TimerTask
{
  public void run()
  {
    if (!this.this$0.a.get())
    {
      this.this$0.a.set(true);
      bnln.a("off", "Timer count off, mIsPreDownloaderOpen=" + this.this$0.a.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader.2
 * JD-Core Version:    0.7.0.1
 */