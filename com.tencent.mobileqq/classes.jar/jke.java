import com.tencent.av.random.RandomController;
import com.tencent.av.random.RandomController.RandomListener;
import java.util.Iterator;
import java.util.List;

class jke
  implements Runnable
{
  jke(jkd paramjkd) {}
  
  public void run()
  {
    Iterator localIterator = RandomController.a(this.a.a).iterator();
    while (localIterator.hasNext()) {
      ((RandomController.RandomListener)localIterator.next()).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jke
 * JD-Core Version:    0.7.0.1
 */