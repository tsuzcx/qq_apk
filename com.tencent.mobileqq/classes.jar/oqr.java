import com.tencent.biz.pubaccount.readinjoy.KanDianViewController.PullRefreshCompleteListener.1;
import com.tencent.biz.pubaccount.readinjoy.KanDianViewController.PullRefreshCompleteListener.2;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;

public class oqr
  implements tnf
{
  public oqr(oqo paramoqo) {}
  
  public void a(boolean paramBoolean)
  {
    AppInterface localAppInterface;
    if ((oqo.a(this.a) instanceof BaseActivity))
    {
      localAppInterface = ((BaseActivity)oqo.a(this.a)).getAppInterface();
      if ((localAppInterface != null) && (oqo.a(this.a) != null) && (!paramBoolean))
      {
        rmu localrmu = (rmu)localAppInterface.getManager(QQManagerFactory.READ_INJOY_REFRESH_MANAGER);
        if ((localrmu.a() != 1) || (!localrmu.b())) {
          break label87;
        }
        ThreadManager.post(new KanDianViewController.PullRefreshCompleteListener.1(this), 8, null, true);
      }
    }
    label87:
    while (((rna)localAppInterface.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER)).a() != 1) {
      return;
    }
    ThreadManager.post(new KanDianViewController.PullRefreshCompleteListener.2(this), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oqr
 * JD-Core Version:    0.7.0.1
 */