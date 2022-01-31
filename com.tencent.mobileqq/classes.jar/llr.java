import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.KandianSetTopInfo;

public class llr
  implements Runnable
{
  public llr(KandianMergeManager paramKandianMergeManager) {}
  
  public void run()
  {
    KandianMergeManager.a(this.a).trySetTopKandianMsg(KandianMergeManager.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     llr
 * JD-Core Version:    0.7.0.1
 */