import com.tencent.component.media.gif.AnimationListener;
import com.tencent.component.media.gif.NewGifDrawable;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

class pku
  implements Runnable
{
  pku(pkt parampkt) {}
  
  public void run()
  {
    Iterator localIterator = this.a.b.a.iterator();
    while (localIterator.hasNext()) {
      ((AnimationListener)localIterator.next()).onAnimationCompleted();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pku
 * JD-Core Version:    0.7.0.1
 */