package dov.com.qq.im.ae.gif.video;

import android.os.Handler;
import android.os.Looper;

class PngsCreateWorkingQueue$3
  implements Runnable
{
  PngsCreateWorkingQueue$3(PngsCreateWorkingQueue paramPngsCreateWorkingQueue, boolean paramBoolean) {}
  
  public void run()
  {
    PngsCreateWorkingQueue.a(this.this$0).a();
    if (this.a) {
      PngsCreateWorkingQueue.a(this.this$0);
    }
    PngsCreateWorkingQueue.a(this.this$0).getLooper().quit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.video.PngsCreateWorkingQueue.3
 * JD-Core Version:    0.7.0.1
 */