package cooperation.vip.tianshu;

import bnwq;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class TianShuManager$1
  implements Runnable
{
  public TianShuManager$1(bnwq parambnwq) {}
  
  public void run()
  {
    synchronized (bnwq.a(this.this$0))
    {
      ArrayList localArrayList2 = new ArrayList(bnwq.a(this.this$0));
      bnwq.a(this.this$0).clear();
      bnwq.a(this.this$0).set(false);
      bnwq.a(this.this$0, localArrayList2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.tianshu.TianShuManager.1
 * JD-Core Version:    0.7.0.1
 */