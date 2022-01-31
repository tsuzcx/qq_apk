import com.tencent.biz.pubaccount.readinjoy.KanDianViewController;
import com.tencent.biz.pubaccount.readinjoy.KanDianViewController.PullRefreshCompleteListener;
import com.tencent.biz.pubaccount.readinjoy.skin.CommonSkinRes;
import java.io.File;

public class lbf
  implements Runnable
{
  public lbf(KanDianViewController.PullRefreshCompleteListener paramPullRefreshCompleteListener) {}
  
  public void run()
  {
    String str = CommonSkinRes.e();
    if ((str != null) && (new File(str).exists()))
    {
      KanDianViewController.a(this.a.a, str);
      KanDianViewController.a(this.a.a).removeMessages(3);
      KanDianViewController.a(this.a.a).sendEmptyMessage(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lbf
 * JD-Core Version:    0.7.0.1
 */