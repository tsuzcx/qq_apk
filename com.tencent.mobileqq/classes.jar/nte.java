import com.tencent.biz.pubaccount.readinjoy.KanDianViewController.PullRefreshCompleteListener.1;
import com.tencent.biz.pubaccount.readinjoy.KanDianViewController.PullRefreshCompleteListener.2;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;

public class nte
  implements rqs
{
  public nte(ntb paramntb) {}
  
  public void a(boolean paramBoolean)
  {
    AppInterface localAppInterface;
    if ((ntb.a(this.a) instanceof BaseActivity))
    {
      localAppInterface = ((BaseActivity)ntb.a(this.a)).getAppInterface();
      if ((localAppInterface != null) && (ntb.a(this.a) != null) && (!paramBoolean))
      {
        pzc localpzc = (pzc)localAppInterface.getManager(270);
        if ((localpzc.a() != 1) || (!localpzc.b())) {
          break label87;
        }
        ThreadManager.post(new KanDianViewController.PullRefreshCompleteListener.1(this), 8, null, true);
      }
    }
    label87:
    while (((pzi)localAppInterface.getManager(261)).a() != 1) {
      return;
    }
    ThreadManager.post(new KanDianViewController.PullRefreshCompleteListener.2(this), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nte
 * JD-Core Version:    0.7.0.1
 */