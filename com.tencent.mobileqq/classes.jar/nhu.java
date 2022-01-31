import com.tencent.biz.pubaccount.readinjoy.KanDianViewController.PullRefreshCompleteListener.1;
import com.tencent.biz.pubaccount.readinjoy.KanDianViewController.PullRefreshCompleteListener.2;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;

public class nhu
  implements ree
{
  public nhu(nhr paramnhr) {}
  
  public void a(boolean paramBoolean)
  {
    AppInterface localAppInterface;
    if ((nhr.a(this.a) instanceof BaseActivity))
    {
      localAppInterface = ((BaseActivity)nhr.a(this.a)).getAppInterface();
      if ((localAppInterface != null) && (nhr.a(this.a) != null) && (!paramBoolean))
      {
        pnh localpnh = (pnh)localAppInterface.getManager(270);
        if ((localpnh.a() != 1) || (!localpnh.b())) {
          break label87;
        }
        ThreadManager.post(new KanDianViewController.PullRefreshCompleteListener.1(this), 8, null, true);
      }
    }
    label87:
    while (((pnn)localAppInterface.getManager(261)).a() != 1) {
      return;
    }
    ThreadManager.post(new KanDianViewController.PullRefreshCompleteListener.2(this), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nhu
 * JD-Core Version:    0.7.0.1
 */