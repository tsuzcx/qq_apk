package cooperation.qzone.widget;

import android.graphics.drawable.BitmapDrawable;
import android.util.LruCache;
import bgfc;
import bglo;
import bglp;
import com.tencent.qphone.base.util.QLog;
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
      FastAnimationDrawable.a(this.this$0).set(FastAnimationDrawable.a(this.this$0).incrementAndGet() % FastAnimationDrawable.a(this.this$0).size());
      if (QLog.isColorLevel()) {
        QLog.d("FastAnimationDrawable", 2, "LoopReadWriteRunnable index:" + FastAnimationDrawable.a(this.this$0).get());
      }
      if ((this.this$0.a != null) && (this.this$0.a.get(Integer.valueOf(FastAnimationDrawable.a(this.this$0).get())) != null))
      {
        FastAnimationDrawable.a(this.this$0, (BitmapDrawable)this.this$0.a.get(Integer.valueOf(FastAnimationDrawable.a(this.this$0).get())));
        try
        {
          Thread.sleep(FastAnimationDrawable.a(this.this$0));
          FastAnimationDrawable.a(this.this$0).sendEmptyMessage(0);
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
        BitmapDrawable localBitmapDrawable = FastAnimationDrawable.a(this.this$0, (String)FastAnimationDrawable.a(this.this$0).get(FastAnimationDrawable.a(this.this$0).get()));
        if (localBitmapDrawable != null)
        {
          l = System.currentTimeMillis() - l;
          FastAnimationDrawable.a(this.this$0, localBitmapDrawable);
          if (QLog.isColorLevel()) {
            QLog.d("FastAnimationDrawable", 2, "LoopReadWriteRunnable decodeBitmap index:" + FastAnimationDrawable.a(this.this$0).get() + " cost:" + l + " delay:" + FastAnimationDrawable.a(this.this$0));
          }
          this.this$0.a.put(Integer.valueOf(FastAnimationDrawable.a(this.this$0).get()), localBitmapDrawable);
          if ((this.this$0.a.size() == FastAnimationDrawable.a(this.this$0).size()) && (FastAnimationDrawable.a(this.this$0) != null) && (this.this$0.a.size() <= bgfc.a().a())) {
            FastAnimationDrawable.a(this.this$0).a(this.this$0.a);
          }
          if (!FastAnimationDrawable.a(this.this$0).hasMessages(0)) {
            if (FastAnimationDrawable.a(this.this$0) > l) {
              FastAnimationDrawable.a(this.this$0).sendEmptyMessageDelayed(0, FastAnimationDrawable.a(this.this$0) - l);
            } else {
              FastAnimationDrawable.a(this.this$0).sendEmptyMessage(0);
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