import com.tencent.biz.pubaccount.readinjoy.KanDianViewController;
import com.tencent.biz.pubaccount.readinjoy.KanDianViewController.PullRefreshCompleteListener;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshRes;
import java.io.File;

public class lcy
  implements Runnable
{
  public lcy(KanDianViewController.PullRefreshCompleteListener paramPullRefreshCompleteListener) {}
  
  public void run()
  {
    String str = RefreshRes.e();
    if ((str != null) && (new File(str).exists()))
    {
      KanDianViewController.a(this.a.a, str);
      KanDianViewController.a(this.a.a).removeMessages(3);
      KanDianViewController.a(this.a.a).sendEmptyMessage(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lcy
 * JD-Core Version:    0.7.0.1
 */