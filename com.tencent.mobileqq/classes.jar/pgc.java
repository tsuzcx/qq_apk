import com.tencent.component.media.gif.AnimationListener;
import com.tencent.component.media.gif.NewGifDrawable;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

class pgc
  implements Runnable
{
  pgc(pgb parampgb) {}
  
  public void run()
  {
    Iterator localIterator = this.a.b.a.iterator();
    while (localIterator.hasNext()) {
      ((AnimationListener)localIterator.next()).onAnimationCompleted();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pgc
 * JD-Core Version:    0.7.0.1
 */