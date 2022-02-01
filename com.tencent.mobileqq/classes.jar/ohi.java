import com.tencent.biz.pubaccount.readinjoy.KanDianViewController.PullRefreshCompleteListener.1;
import com.tencent.biz.pubaccount.readinjoy.KanDianViewController.PullRefreshCompleteListener.2;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;

public class ohi
  implements svx
{
  public ohi(ohf paramohf) {}
  
  public void a(boolean paramBoolean)
  {
    AppInterface localAppInterface;
    if ((ohf.a(this.a) instanceof BaseActivity))
    {
      localAppInterface = ((BaseActivity)ohf.a(this.a)).getAppInterface();
      if ((localAppInterface != null) && (ohf.a(this.a) != null) && (!paramBoolean))
      {
        qtq localqtq = (qtq)localAppInterface.getManager(270);
        if ((localqtq.a() != 1) || (!localqtq.b())) {
          break label87;
        }
        ThreadManager.post(new KanDianViewController.PullRefreshCompleteListener.1(this), 8, null, true);
      }
    }
    label87:
    while (((qtw)localAppInterface.getManager(261)).a() != 1) {
      return;
    }
    ThreadManager.post(new KanDianViewController.PullRefreshCompleteListener.2(this), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ohi
 * JD-Core Version:    0.7.0.1
 */