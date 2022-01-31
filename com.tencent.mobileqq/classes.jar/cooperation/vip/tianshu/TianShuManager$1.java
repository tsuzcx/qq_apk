package cooperation.vip.tianshu;

import bgqw;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class TianShuManager$1
  implements Runnable
{
  public TianShuManager$1(bgqw parambgqw) {}
  
  public void run()
  {
    synchronized (bgqw.a(this.this$0))
    {
      ArrayList localArrayList2 = new ArrayList(bgqw.a(this.this$0));
      bgqw.a(this.this$0).clear();
      bgqw.a(this.this$0).set(false);
      bgqw.a(this.this$0, localArrayList2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.vip.tianshu.TianShuManager.1
 * JD-Core Version:    0.7.0.1
 */