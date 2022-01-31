package cooperation.vip.tianshu;

import biam;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class TianShuManager$1
  implements Runnable
{
  public TianShuManager$1(biam parambiam) {}
  
  public void run()
  {
    synchronized (biam.a(this.this$0))
    {
      ArrayList localArrayList2 = new ArrayList(biam.a(this.this$0));
      biam.a(this.this$0).clear();
      biam.a(this.this$0).set(false);
      biam.a(this.this$0, localArrayList2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.vip.tianshu.TianShuManager.1
 * JD-Core Version:    0.7.0.1
 */