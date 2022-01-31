import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.onMainVideoTabRedChangeListener;
import java.util.Iterator;
import java.util.List;

public class llq
  implements Runnable
{
  public llq(KandianMergeManager paramKandianMergeManager) {}
  
  public void run()
  {
    if (KandianMergeManager.b(this.a) != null)
    {
      Iterator localIterator = KandianMergeManager.b(this.a).iterator();
      while (localIterator.hasNext()) {
        ((KandianMergeManager.onMainVideoTabRedChangeListener)localIterator.next()).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     llq
 * JD-Core Version:    0.7.0.1
 */