import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import cooperation.readinjoy.ReadInJoyHelper;

public class loc
  implements Runnable
{
  public loc(KandianMergeManager paramKandianMergeManager) {}
  
  public void run()
  {
    ReadInJoyHelper.l(KandianMergeManager.a(this.a), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     loc
 * JD-Core Version:    0.7.0.1
 */