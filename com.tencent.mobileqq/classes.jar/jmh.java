import com.tencent.av.random.RandomController;
import com.tencent.av.random.RandomController.RandomListener;
import java.util.Iterator;
import java.util.List;

class jmh
  implements Runnable
{
  jmh(jmg paramjmg) {}
  
  public void run()
  {
    Iterator localIterator = RandomController.a(this.a.a).iterator();
    while (localIterator.hasNext()) {
      ((RandomController.RandomListener)localIterator.next()).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jmh
 * JD-Core Version:    0.7.0.1
 */