import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.OnTabRedNumsChangeListenner;
import java.util.Iterator;
import java.util.List;

public class loe
  implements Runnable
{
  public loe(KandianMergeManager paramKandianMergeManager) {}
  
  public void run()
  {
    if (KandianMergeManager.a(this.a) != null)
    {
      Iterator localIterator = KandianMergeManager.a(this.a).iterator();
      while (localIterator.hasNext()) {
        ((KandianMergeManager.OnTabRedNumsChangeListenner)localIterator.next()).b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     loe
 * JD-Core Version:    0.7.0.1
 */