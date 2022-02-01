package cooperation.vip.tianshu;

import blbw;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class TianShuManager$1
  implements Runnable
{
  public TianShuManager$1(blbw paramblbw) {}
  
  public void run()
  {
    synchronized (blbw.a(this.this$0))
    {
      ArrayList localArrayList2 = new ArrayList(blbw.a(this.this$0));
      blbw.a(this.this$0).clear();
      blbw.a(this.this$0).set(false);
      blbw.a(this.this$0, localArrayList2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.tianshu.TianShuManager.1
 * JD-Core Version:    0.7.0.1
 */