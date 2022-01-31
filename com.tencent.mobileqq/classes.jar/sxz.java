import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.network.handler.RecentTabHaloPresenter.ReadStoryVideoEventReceiver.1;
import com.tencent.biz.qqstory.network.handler.RecentTabHaloPresenter.ReadStoryVideoEventReceiver.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.List;
import mqq.os.MqqHandler;

public final class sxz
  extends QQUIEventReceiver<sxw, sqy>
{
  public sxz(@NonNull sxw paramsxw)
  {
    super(paramsxw);
  }
  
  private void b(sxw paramsxw, sqy paramsqy)
  {
    Object localObject = ((stf)sxw.a(paramsxw).getManager(251)).a().a(3, "");
    if ((localObject != null) && (paramsqy.b.equals(((ssm)localObject).e))) {
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "onEvent: invoked. Message: guideInfo: " + localObject);
      }
    }
    ssm localssm;
    do
    {
      return;
      localObject = (sgj)sxw.a(paramsxw).getManager(197);
      localssm = ((sgj)localObject).b(paramsqy.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "syncHaloReadStatus: invoked. Message: haloNodeInfo: " + localssm + "\nmanager: " + localObject);
      }
    } while (localssm == null);
    int i = localssm.a.size() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        ste localste = (ste)localssm.a.get(i);
        if ((localste.jdField_a_of_type_Long == paramsqy.jdField_a_of_type_Long) && (!localste.jdField_a_of_type_Boolean))
        {
          localste.jdField_a_of_type_Boolean = true;
          localssm.b -= 1;
        }
      }
      else
      {
        ((sgj)localObject).c(localssm);
        ((sgj)localObject).b(localssm);
        paramsxw = new RecentTabHaloPresenter.ReadStoryVideoEventReceiver.2(this, paramsxw);
        ThreadManager.getUIHandler().post(paramsxw);
        return;
      }
      i -= 1;
    }
  }
  
  public void a(@NonNull sxw paramsxw, @NonNull sqy paramsqy)
  {
    ThreadManager.post(new RecentTabHaloPresenter.ReadStoryVideoEventReceiver.1(this, paramsxw, paramsqy), 8, null, true);
  }
  
  public Class acceptEventClass()
  {
    return sqy.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sxz
 * JD-Core Version:    0.7.0.1
 */