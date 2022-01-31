import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import cooperation.readinjoy.ReadInJoyHelper;

public class lls
  implements Runnable
{
  public lls(KandianMergeManager paramKandianMergeManager) {}
  
  public void run()
  {
    ReadInJoyHelper.l(KandianMergeManager.a(this.a), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lls
 * JD-Core Version:    0.7.0.1
 */