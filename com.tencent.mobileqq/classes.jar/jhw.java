import com.tencent.av.gaudio.AVNotifyCenter;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class jhw
  implements Runnable
{
  public jhw(AVNotifyCenter paramAVNotifyCenter) {}
  
  public void run()
  {
    if (this.a.a == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.a.a.keySet().iterator();
      long l;
      while (localIterator.hasNext())
      {
        l = ((Long)localIterator.next()).longValue();
        this.a.a(l, 2, this.a.b(l), false);
        this.a.a(1, 2, l, null, 0L);
        this.a.a(21, 2, l, 0L);
        localIterator.remove();
      }
      localIterator = this.a.b.keySet().iterator();
      while (localIterator.hasNext())
      {
        l = ((Long)localIterator.next()).longValue();
        this.a.a(l, 1, this.a.b(l), false);
        this.a.a(1, l, 10, 21, 0);
        this.a.a(2, 1, l, null, 0L);
        this.a.a(21, 1, l, 0L);
        localIterator.remove();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     jhw
 * JD-Core Version:    0.7.0.1
 */