package cooperation.qzone.widget;

import android.graphics.drawable.BitmapDrawable;
import android.util.LruCache;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.GifAntishakeModule;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class FastAnimationDrawable$LoopReadWriteRunnable
  implements Runnable
{
  public FastAnimationDrawable$LoopReadWriteRunnable(FastAnimationDrawable paramFastAnimationDrawable) {}
  
  public void run()
  {
    while (this.this$0.isRunning())
    {
      FastAnimationDrawable.access$100(this.this$0).set(FastAnimationDrawable.access$100(this.this$0).incrementAndGet() % FastAnimationDrawable.access$200(this.this$0).size());
      if (QLog.isColorLevel()) {
        QLog.d("FastAnimationDrawable", 2, "LoopReadWriteRunnable index:" + FastAnimationDrawable.access$100(this.this$0).get());
      }
      if ((this.this$0.mMemoryCache != null) && (this.this$0.mMemoryCache.get(Integer.valueOf(FastAnimationDrawable.access$100(this.this$0).get())) != null))
      {
        FastAnimationDrawable.access$302(this.this$0, (BitmapDrawable)this.this$0.mMemoryCache.get(Integer.valueOf(FastAnimationDrawable.access$100(this.this$0).get())));
        try
        {
          Thread.sleep(FastAnimationDrawable.access$400(this.this$0));
          FastAnimationDrawable.access$500(this.this$0).sendEmptyMessage(0);
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
      else
      {
        long l = System.currentTimeMillis();
        BitmapDrawable localBitmapDrawable = FastAnimationDrawable.access$600(this.this$0, (String)FastAnimationDrawable.access$200(this.this$0).get(FastAnimationDrawable.access$100(this.this$0).get()));
        if (localBitmapDrawable != null)
        {
          l = System.currentTimeMillis() - l;
          FastAnimationDrawable.access$302(this.this$0, localBitmapDrawable);
          if (QLog.isColorLevel()) {
            QLog.d("FastAnimationDrawable", 2, "LoopReadWriteRunnable decodeBitmap index:" + FastAnimationDrawable.access$100(this.this$0).get() + " cost:" + l + " delay:" + FastAnimationDrawable.access$400(this.this$0));
          }
          this.this$0.mMemoryCache.put(Integer.valueOf(FastAnimationDrawable.access$100(this.this$0).get()), localBitmapDrawable);
          if ((this.this$0.mMemoryCache.size() == FastAnimationDrawable.access$200(this.this$0).size()) && (FastAnimationDrawable.access$700(this.this$0) != null) && (this.this$0.mMemoryCache.size() <= GifAntishakeModule.getInstance().getMaxGifAntishakeFrameNum())) {
            FastAnimationDrawable.access$700(this.this$0).antiShake(this.this$0.mMemoryCache);
          }
          if (!FastAnimationDrawable.access$500(this.this$0).hasMessages(0)) {
            if (FastAnimationDrawable.access$400(this.this$0) > l) {
              FastAnimationDrawable.access$500(this.this$0).sendEmptyMessageDelayed(0, FastAnimationDrawable.access$400(this.this$0) - l);
            } else {
              FastAnimationDrawable.access$500(this.this$0).sendEmptyMessage(0);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.widget.FastAnimationDrawable.LoopReadWriteRunnable
 * JD-Core Version:    0.7.0.1
 */