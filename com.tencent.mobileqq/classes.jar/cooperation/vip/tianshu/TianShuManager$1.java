package cooperation.vip.tianshu;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

class TianShuManager$1
  implements Runnable
{
  TianShuManager$1(TianShuManager paramTianShuManager) {}
  
  public void run()
  {
    synchronized (TianShuManager.access$000(this.this$0))
    {
      ArrayList localArrayList2 = new ArrayList(TianShuManager.access$000(this.this$0));
      TianShuManager.access$000(this.this$0).clear();
      TianShuManager.access$100(this.this$0).set(false);
      TianShuManager.access$200(this.this$0, localArrayList2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.tianshu.TianShuManager.1
 * JD-Core Version:    0.7.0.1
 */