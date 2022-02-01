import com.tencent.biz.pubaccount.readinjoy.KanDianViewController.PullRefreshCompleteListener.1;
import com.tencent.biz.pubaccount.readinjoy.KanDianViewController.PullRefreshCompleteListener.2;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;

public class oiv
  implements szx
{
  public oiv(ois paramois) {}
  
  public void a(boolean paramBoolean)
  {
    AppInterface localAppInterface;
    if ((ois.a(this.a) instanceof BaseActivity))
    {
      localAppInterface = ((BaseActivity)ois.a(this.a)).getAppInterface();
      if ((localAppInterface != null) && (ois.a(this.a) != null) && (!paramBoolean))
      {
        rao localrao = (rao)localAppInterface.getManager(270);
        if ((localrao.a() != 1) || (!localrao.b())) {
          break label87;
        }
        ThreadManager.post(new KanDianViewController.PullRefreshCompleteListener.1(this), 8, null, true);
      }
    }
    label87:
    while (((rau)localAppInterface.getManager(261)).a() != 1) {
      return;
    }
    ThreadManager.post(new KanDianViewController.PullRefreshCompleteListener.2(this), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oiv
 * JD-Core Version:    0.7.0.1
 */