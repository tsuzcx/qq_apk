import com.tencent.biz.pubaccount.readinjoy.KanDianViewController.PullRefreshCompleteListener.1;
import com.tencent.biz.pubaccount.readinjoy.KanDianViewController.PullRefreshCompleteListener.2;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;

public class nwf
  implements sgo
{
  public nwf(nwc paramnwc) {}
  
  public void a(boolean paramBoolean)
  {
    AppInterface localAppInterface;
    if ((nwc.a(this.a) instanceof BaseActivity))
    {
      localAppInterface = ((BaseActivity)nwc.a(this.a)).getAppInterface();
      if ((localAppInterface != null) && (nwc.a(this.a) != null) && (!paramBoolean))
      {
        qiu localqiu = (qiu)localAppInterface.getManager(270);
        if ((localqiu.a() != 1) || (!localqiu.b())) {
          break label87;
        }
        ThreadManager.post(new KanDianViewController.PullRefreshCompleteListener.1(this), 8, null, true);
      }
    }
    label87:
    while (((qja)localAppInterface.getManager(261)).a() != 1) {
      return;
    }
    ThreadManager.post(new KanDianViewController.PullRefreshCompleteListener.2(this), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nwf
 * JD-Core Version:    0.7.0.1
 */