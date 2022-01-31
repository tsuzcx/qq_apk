import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.KandianSetTopInfo;

public class llm
  implements Runnable
{
  public llm(KandianMergeManager paramKandianMergeManager) {}
  
  public void run()
  {
    KandianMergeManager.a(this.a).trySetTopKandianMsg(KandianMergeManager.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     llm
 * JD-Core Version:    0.7.0.1
 */