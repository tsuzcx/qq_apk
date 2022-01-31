import com.tencent.biz.pubaccount.readinjoy.KanDianViewController.PullRefreshCompleteListener.1;
import com.tencent.biz.pubaccount.readinjoy.KanDianViewController.PullRefreshCompleteListener.2;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;

public class ntb
  implements rqp
{
  public ntb(nsy paramnsy) {}
  
  public void a(boolean paramBoolean)
  {
    AppInterface localAppInterface;
    if ((nsy.a(this.a) instanceof BaseActivity))
    {
      localAppInterface = ((BaseActivity)nsy.a(this.a)).getAppInterface();
      if ((localAppInterface != null) && (nsy.a(this.a) != null) && (!paramBoolean))
      {
        pyz localpyz = (pyz)localAppInterface.getManager(270);
        if ((localpyz.a() != 1) || (!localpyz.b())) {
          break label87;
        }
        ThreadManager.post(new KanDianViewController.PullRefreshCompleteListener.1(this), 8, null, true);
      }
    }
    label87:
    while (((pzf)localAppInterface.getManager(261)).a() != 1) {
      return;
    }
    ThreadManager.post(new KanDianViewController.PullRefreshCompleteListener.2(this), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ntb
 * JD-Core Version:    0.7.0.1
 */