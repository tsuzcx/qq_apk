import com.tencent.biz.pubaccount.readinjoy.KanDianViewController.PullRefreshCompleteListener.1;
import com.tencent.biz.pubaccount.readinjoy.KanDianViewController.PullRefreshCompleteListener.2;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;

public class oga
  implements tff
{
  public oga(ofx paramofx) {}
  
  public void a(boolean paramBoolean)
  {
    AppInterface localAppInterface;
    if ((ofx.a(this.a) instanceof BaseActivity))
    {
      localAppInterface = ((BaseActivity)ofx.a(this.a)).getAppInterface();
      if ((localAppInterface != null) && (ofx.a(this.a) != null) && (!paramBoolean))
      {
        rcx localrcx = (rcx)localAppInterface.getManager(270);
        if ((localrcx.a() != 1) || (!localrcx.b())) {
          break label87;
        }
        ThreadManager.post(new KanDianViewController.PullRefreshCompleteListener.1(this), 8, null, true);
      }
    }
    label87:
    while (((rdd)localAppInterface.getManager(261)).a() != 1) {
      return;
    }
    ThreadManager.post(new KanDianViewController.PullRefreshCompleteListener.2(this), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oga
 * JD-Core Version:    0.7.0.1
 */