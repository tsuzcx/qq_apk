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
    while (this.a.isRunning())
    {
      FastAnimationDrawable.a(this.a).set(FastAnimationDrawable.a(this.a).incrementAndGet() % FastAnimationDrawable.a(this.a).size());
      if (QLog.isColorLevel()) {
        QLog.d("FastAnimationDrawable", 2, "LoopReadWriteRunnable index:" + FastAnimationDrawable.a(this.a).get());
      }
      if ((this.a.a != null) && (this.a.a.get(Integer.valueOf(FastAnimationDrawable.a(this.a).get())) != null))
      {
        FastAnimationDrawable.a(this.a, (BitmapDrawable)this.a.a.get(Integer.valueOf(FastAnimationDrawable.a(this.a).get())));
        try
        {
          Thread.sleep(FastAnimationDrawable.a(this.a));
          FastAnimationDrawable.a(this.a).sendEmptyMessage(0);
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
        BitmapDrawable localBitmapDrawable = FastAnimationDrawable.a(this.a, (String)FastAnimationDrawable.a(this.a).get(FastAnimationDrawable.a(this.a).get()));
        if (localBitmapDrawable != null)
        {
          l = System.currentTimeMillis() - l;
          FastAnimationDrawable.a(this.a, localBitmapDrawable);
          if (QLog.isColorLevel()) {
            QLog.d("FastAnimationDrawable", 2, "LoopReadWriteRunnable decodeBitmap index:" + FastAnimationDrawable.a(this.a).get() + " cost:" + l + " delay:" + FastAnimationDrawable.a(this.a));
          }
          this.a.a.put(Integer.valueOf(FastAnimationDrawable.a(this.a).get()), localBitmapDrawable);
          if ((this.a.a.size() == FastAnimationDrawable.a(this.a).size()) && (FastAnimationDrawable.a(this.a) != null) && (this.a.a.size() <= GifAntishakeModule.a().a())) {
            FastAnimationDrawable.a(this.a).a(this.a.a);
          }
          if (!FastAnimationDrawable.a(this.a).hasMessages(0)) {
            if (FastAnimationDrawable.a(this.a) > l) {
              FastAnimationDrawable.a(this.a).sendEmptyMessageDelayed(0, FastAnimationDrawable.a(this.a) - l);
            } else {
              FastAnimationDrawable.a(this.a).sendEmptyMessage(0);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.widget.FastAnimationDrawable.LoopReadWriteRunnable
 * JD-Core Version:    0.7.0.1
 */