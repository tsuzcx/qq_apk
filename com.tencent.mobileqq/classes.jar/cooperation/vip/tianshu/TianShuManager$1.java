package cooperation.vip.tianshu;

import bmvi;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class TianShuManager$1
  implements Runnable
{
  public TianShuManager$1(bmvi parambmvi) {}
  
  public void run()
  {
    synchronized (bmvi.a(this.this$0))
    {
      ArrayList localArrayList2 = new ArrayList(bmvi.a(this.this$0));
      bmvi.a(this.this$0).clear();
      bmvi.a(this.this$0).set(false);
      bmvi.a(this.this$0, localArrayList2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.tianshu.TianShuManager.1
 * JD-Core Version:    0.7.0.1
 */