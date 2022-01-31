package cooperation.vip.tianshu;

import bkgp;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class TianShuManager$1
  implements Runnable
{
  public TianShuManager$1(bkgp parambkgp) {}
  
  public void run()
  {
    synchronized (bkgp.a(this.this$0))
    {
      ArrayList localArrayList2 = new ArrayList(bkgp.a(this.this$0));
      bkgp.a(this.this$0).clear();
      bkgp.a(this.this$0).set(false);
      bkgp.a(this.this$0, localArrayList2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.vip.tianshu.TianShuManager.1
 * JD-Core Version:    0.7.0.1
 */