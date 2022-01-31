import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import cooperation.readinjoy.ReadInJoyHelper;

public class lln
  implements Runnable
{
  public lln(KandianMergeManager paramKandianMergeManager) {}
  
  public void run()
  {
    ReadInJoyHelper.l(KandianMergeManager.a(this.a), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lln
 * JD-Core Version:    0.7.0.1
 */