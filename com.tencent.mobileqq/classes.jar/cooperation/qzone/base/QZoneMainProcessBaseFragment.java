package cooperation.qzone.base;

import android.app.Fragment;
import com.tencent.biz.richframework.compat.CompatAndroidXFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.qzone.api.QZoneApiProxy;
import mqq.app.MobileQQ;

public abstract class QZoneMainProcessBaseFragment
  extends CompatAndroidXFragment
{
  private static final String TAG = "QZoneMainProcessBaseFragment";
  
  protected Fragment createSupportFragment()
  {
    if (getActivity() != null) {
      return QZoneApiProxy.createLebaFragment(getActivity(), getQQAppInterface(), getQZoneFragmentClassName());
    }
    return null;
  }
  
  public QQAppInterface getQQAppInterface()
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
      return localQQAppInterface;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  protected abstract String getQZoneFragmentClassName();
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
    if (getActivity() != null) {
      QZoneApiProxy.onAccountChange(getActivity(), getQQAppInterface());
    }
  }
  
  protected void onFragmentCreatedInstance(Fragment paramFragment)
  {
    if (getActivity() != null)
    {
      QZoneApiProxy.initEnv(getActivity(), getQQAppInterface());
      QZoneApiProxy.initServlet(getActivity(), getQQAppInterface());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.base.QZoneMainProcessBaseFragment
 * JD-Core Version:    0.7.0.1
 */