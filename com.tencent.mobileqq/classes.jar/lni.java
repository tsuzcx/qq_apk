import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.app.QQAppInterface;

public final class lni
  implements Runnable
{
  public lni(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    ((KandianMergeManager)this.a.getManager(161)).i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lni
 * JD-Core Version:    0.7.0.1
 */