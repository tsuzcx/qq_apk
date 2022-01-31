import com.tencent.biz.pubaccount.readinjoy.KanDianViewController;
import com.tencent.biz.pubaccount.readinjoy.skin.CommonSkinRes;
import java.io.File;

public class lbc
  implements Runnable
{
  public lbc(KanDianViewController paramKanDianViewController) {}
  
  public void run()
  {
    String str = CommonSkinRes.e();
    if ((str != null) && (new File(str).exists()))
    {
      KanDianViewController.a(this.a).removeMessages(2);
      KanDianViewController.a(this.a).sendEmptyMessage(3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lbc
 * JD-Core Version:    0.7.0.1
 */