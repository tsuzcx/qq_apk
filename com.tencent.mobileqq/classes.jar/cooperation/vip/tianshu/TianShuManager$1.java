package cooperation.vip.tianshu;

import bkci;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class TianShuManager$1
  implements Runnable
{
  public TianShuManager$1(bkci parambkci) {}
  
  public void run()
  {
    synchronized (bkci.a(this.this$0))
    {
      ArrayList localArrayList2 = new ArrayList(bkci.a(this.this$0));
      bkci.a(this.this$0).clear();
      bkci.a(this.this$0).set(false);
      bkci.a(this.this$0, localArrayList2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.vip.tianshu.TianShuManager.1
 * JD-Core Version:    0.7.0.1
 */