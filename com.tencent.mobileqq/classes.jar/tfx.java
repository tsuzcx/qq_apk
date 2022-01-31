import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qcall.QCallFacade;
import mqq.os.MqqHandler;

public class tfx
  implements Runnable
{
  public tfx(MainFragment paramMainFragment) {}
  
  public void run()
  {
    QCallFacade localQCallFacade = (QCallFacade)MainFragment.a(this.a).getManager(37);
    if (localQCallFacade != null) {}
    for (int i = localQCallFacade.a();; i = 0)
    {
      ThreadManager.getUIHandler().post(new tfy(this, i));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tfx
 * JD-Core Version:    0.7.0.1
 */