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
    if (this.this$0.getCallback() == null) {
      return;
    }
    if (paramMessage.what != 1000) {
      return;
    }
    if (!ZipAnimationDrawable.access$100(this.this$0).aniResLoaded) {
      return;
    }
    if (!ZipAnimationDrawable.access$300(this.this$0)) {
      return;
    }
    int k = (int)((float)(SystemClock.uptimeMillis() - this.this$0.startTime) / (1000.0F / ZipAnimationDrawable.access$100(this.this$0).frameRate));
    boolean bool = ZipAnimationDrawable.access$400(this.this$0);
    int i = 0;
    int j;
    if ((bool) && (ZipAnimationDrawable.access$100(this.this$0).animationResLoader.getFrameCount() != 0))
    {
      j = k % ZipAnimationDrawable.access$100(this.this$0).animationResLoader.getFrameCount();
    }
    else
    {
      j = k;
      if (k >= ZipAnimationDrawable.access$100(this.this$0).animationResLoader.getFrameCount())
      {
        i = 1;
        j = k;
      }
    }
    ZipAnimationDrawable.access$100(this.this$0).animationResLoader.setFrame(j);
    if (i == 0)
    {
      long l = 1000 / ZipAnimationDrawable.access$100(this.this$0).frameRate;
      this.this$0.uiHandler.sendEmptyMessageDelayed(1000, (int)l);
      this.this$0.invalidateSelf();
      return;
    }
    this.this$0.stop();
    this.this$0.invalidateSelf();
    if (this.this$0.mListener != null) {
      this.this$0.mListener.onAnimationFinished();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.zipanimate.ZipAnimationDrawable.2
 * JD-Core Version:    0.7.0.1
 */