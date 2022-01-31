package cooperation.vip.tianshu;

import bhzv;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class TianShuManager$1
  implements Runnable
{
  public TianShuManager$1(bhzv parambhzv) {}
  
  public void run()
  {
    synchronized (bhzv.a(this.this$0))
    {
      ArrayList localArrayList2 = new ArrayList(bhzv.a(this.this$0));
      bhzv.a(this.this$0).clear();
      bhzv.a(this.this$0).set(false);
      bhzv.a(this.this$0, localArrayList2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.vip.tianshu.TianShuManager.1
 * JD-Core Version:    0.7.0.1
 */