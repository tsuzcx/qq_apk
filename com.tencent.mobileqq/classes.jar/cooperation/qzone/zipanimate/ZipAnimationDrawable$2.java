package cooperation.qzone.zipanimate;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

class ZipAnimationDrawable$2
  extends Handler
{
  ZipAnimationDrawable$2(ZipAnimationDrawable paramZipAnimationDrawable, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int j = 0;
    if (this.this$0.getCallback() == null) {}
    do
    {
      do
      {
        return;
      } while ((paramMessage.what != 1000) || (!ZipAnimationDrawable.access$100(this.this$0).aniResLoaded) || (!ZipAnimationDrawable.access$300(this.this$0)));
      int k = (int)((float)(SystemClock.uptimeMillis() - this.this$0.startTime) / (1000.0F / ZipAnimationDrawable.access$100(this.this$0).frameRate));
      int i;
      if ((ZipAnimationDrawable.access$400(this.this$0)) && (ZipAnimationDrawable.access$100(this.this$0).animationResLoader.getFrameCount() != 0)) {
        i = k % ZipAnimationDrawable.access$100(this.this$0).animationResLoader.getFrameCount();
      }
      for (;;)
      {
        ZipAnimationDrawable.access$100(this.this$0).animationResLoader.setFrame(i);
        if (j != 0) {
          break;
        }
        long l = 1000 / ZipAnimationDrawable.access$100(this.this$0).frameRate;
        this.this$0.uiHandler.sendEmptyMessageDelayed(1000, (int)l);
        this.this$0.invalidateSelf();
        return;
        i = k;
        if (k >= ZipAnimationDrawable.access$100(this.this$0).animationResLoader.getFrameCount())
        {
          j = 1;
          i = k;
        }
      }
      this.this$0.stop();
      this.this$0.invalidateSelf();
    } while (this.this$0.mListener == null);
    this.this$0.mListener.onAnimationFinished();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.zipanimate.ZipAnimationDrawable.2
 * JD-Core Version:    0.7.0.1
 */