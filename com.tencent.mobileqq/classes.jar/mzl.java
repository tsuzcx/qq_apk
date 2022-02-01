import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl;
import com.tencent.superplayer.api.ISuperPlayer;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class mzl
  extends Handler
{
  public mzl(WatchTogetherMediaPlayCtrl paramWatchTogetherMediaPlayCtrl, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 256: 
    case 257: 
    case 260: 
    case 258: 
    case 259: 
    case 261: 
    case 289: 
      Object localObject;
      float f;
      do
      {
        do
        {
          for (;;)
          {
            return;
            WatchTogetherMediaPlayCtrl.a(this.a, 1);
            return;
            WatchTogetherMediaPlayCtrl.a(this.a, 1.0F);
            WatchTogetherMediaPlayCtrl.b(this.a, false);
            if (paramMessage.arg2 == 1) {}
            int i;
            for (boolean bool = true;; bool = false)
            {
              i = paramMessage.arg1;
              WatchTogetherMediaPlayCtrl.a(this.a, 4);
              WatchTogetherMediaPlayCtrl.a(this.a, i, bool);
              if (bool) {
                break;
              }
              paramMessage = (String)paramMessage.obj;
              localObject = WatchTogetherMediaPlayCtrl.a(this.a).iterator();
              while (((Iterator)localObject).hasNext())
              {
                WeakReference localWeakReference = (WeakReference)((Iterator)localObject).next();
                if ((localWeakReference != null) && (localWeakReference.get() != null)) {
                  ((myk)localWeakReference.get()).a(paramMessage);
                }
              }
              break;
            }
            if ((WatchTogetherMediaPlayCtrl.a(this.a) != null) && ((WatchTogetherMediaPlayCtrl.a(this.a) == null) || (!WatchTogetherMediaPlayCtrl.a(this.a).a())))
            {
              i = ((Integer)paramMessage.obj).intValue();
              WatchTogetherMediaPlayCtrl.a(this.a).seekTo(i, 3);
              if (paramMessage.arg1 != 1)
              {
                WatchTogetherMediaPlayCtrl.a(this.a, false);
                paramMessage = WatchTogetherMediaPlayCtrl.a(this.a).iterator();
                while (paramMessage.hasNext())
                {
                  localObject = (WeakReference)paramMessage.next();
                  if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
                    ((myk)((WeakReference)localObject).get()).a(i, (int)WatchTogetherMediaPlayCtrl.a(this.a).getDurationMs());
                  }
                }
                continue;
                if (WatchTogetherMediaPlayCtrl.a(this.a) != null)
                {
                  WatchTogetherMediaPlayCtrl.a(this.a).start();
                  WatchTogetherMediaPlayCtrl.a(this.a, 5);
                  paramMessage = WatchTogetherMediaPlayCtrl.a(this.a).iterator();
                  while (paramMessage.hasNext())
                  {
                    localObject = (WeakReference)paramMessage.next();
                    if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
                      ((myk)((WeakReference)localObject).get()).d();
                    }
                  }
                  continue;
                  if ((WatchTogetherMediaPlayCtrl.a(this.a) != null) && (WatchTogetherMediaPlayCtrl.b(this.a) != 7))
                  {
                    WatchTogetherMediaPlayCtrl.a(this.a).pause();
                    WatchTogetherMediaPlayCtrl.a(this.a, 7);
                    paramMessage = WatchTogetherMediaPlayCtrl.a(this.a).iterator();
                    while (paramMessage.hasNext())
                    {
                      localObject = (WeakReference)paramMessage.next();
                      if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
                        ((myk)((WeakReference)localObject).get()).c();
                      }
                    }
                  }
                }
              }
            }
          }
        } while (WatchTogetherMediaPlayCtrl.a(this.a) == null);
        WatchTogetherMediaPlayCtrl.d(this.a);
        return;
        f = ((Float)paramMessage.obj).floatValue();
        WatchTogetherMediaPlayCtrl.a(this.a, f);
      } while (WatchTogetherMediaPlayCtrl.a(this.a) == null);
      WatchTogetherMediaPlayCtrl.a(this.a).setPlaySpeedRatio(f);
      paramMessage = WatchTogetherMediaPlayCtrl.a(this.a).iterator();
      while (paramMessage.hasNext())
      {
        localObject = (WeakReference)paramMessage.next();
        if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
          ((myk)((WeakReference)localObject).get()).a(WatchTogetherMediaPlayCtrl.a(this.a));
        }
      }
    }
    WatchTogetherMediaPlayCtrl.e(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mzl
 * JD-Core Version:    0.7.0.1
 */