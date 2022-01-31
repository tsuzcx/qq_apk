import android.os.Handler;
import com.tencent.component.media.ILog;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.ImageLoader.Options;
import com.tencent.component.media.photogif.NewAnimationDrawable;
import com.tencent.component.media.utils.LruCache;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;

public class pix
  implements Comparable, Runnable
{
  private pix(NewAnimationDrawable paramNewAnimationDrawable) {}
  
  public int a(pix parampix)
  {
    return 0;
  }
  
  public void run()
  {
    long l = 0L;
    if (!this.a.canAnimate())
    {
      NewAnimationDrawable.a(this.a).removeMessages(0);
      NewAnimationDrawable.a(this.a).sendEmptyMessageDelayed(0, NewAnimationDrawable.a(this.a));
      ImageManagerEnv.getLogger().d("NewAnimationDrawable", new Object[] { "canAnimate:false,so don't invalidate" });
    }
    Object localObject2;
    int i;
    label286:
    label297:
    Object localObject4;
    do
    {
      return;
      if (!NewAnimationDrawable.a(this.a))
      {
        ImageManagerEnv.getLogger().d("NewAnimationDrawable", new Object[] { "DecodeTask:mIsRunning=false, return" });
        return;
      }
      if ((NewAnimationDrawable.a(this.a) == -1) || (NewAnimationDrawable.a(this.a) >= NewAnimationDrawable.a(this.a).photoList.size())) {
        NewAnimationDrawable.a(this.a, 0);
      }
      localObject2 = (String)NewAnimationDrawable.a(this.a).photoList.get(NewAnimationDrawable.a(this.a));
      ??? = (BitmapReference)NewAnimationDrawable.a(this.a).get(localObject2);
      if (NewAnimationDrawable.b(this.a) == null)
      {
        i = 1;
        if (??? == null) {
          break label297;
        }
        NewAnimationDrawable.b(this.a, (BitmapReference)???);
        NewAnimationDrawable.a(this.a).removeMessages(0);
        ??? = NewAnimationDrawable.a(this.a);
        if (i == 0) {
          break label286;
        }
      }
      for (l = 0L;; l = NewAnimationDrawable.a(this.a))
      {
        ((Handler)???).sendEmptyMessageDelayed(0, l);
        ImageManagerEnv.getLogger().d("NewAnimationDrawable", new Object[] { "get from cache: index=" + NewAnimationDrawable.a(this.a) });
        return;
        i = 0;
        break;
      }
      localObject4 = NewAnimationDrawable.a(this.a, (String)localObject2);
    } while (localObject4 == null);
    for (;;)
    {
      synchronized (NewAnimationDrawable.a(this.a))
      {
        NewAnimationDrawable.b(this.a, (BitmapReference)localObject4);
        NewAnimationDrawable.a(this.a).put(localObject2, localObject4);
        localObject4 = new piy((BitmapReference)localObject4);
        NewAnimationDrawable.a(this.a).put(localObject2, new WeakReference(localObject4));
        NewAnimationDrawable.a(this.a).removeMessages(0);
        localObject2 = NewAnimationDrawable.a(this.a);
        if (i != 0)
        {
          ((Handler)localObject2).sendEmptyMessageDelayed(0, l);
          ImageManagerEnv.getLogger().d("NewAnimationDrawable", new Object[] { "get from decoder:index=" + NewAnimationDrawable.a(this.a) });
          return;
        }
      }
      l = NewAnimationDrawable.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pix
 * JD-Core Version:    0.7.0.1
 */