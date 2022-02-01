package cooperation.ilive.lite.service;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.falco.base.floatwindow.permission.FWPermission;
import com.tencent.falco.base.libapi.floatwindow.FloatWindowConfigServiceInterface;
import cooperation.ilive.lite.floatwindow.IliveFloatWindowHelper;

public class IliveFloatWindowConfigServiceInterface
  implements FloatWindowConfigServiceInterface
{
  public void clearEventOutput() {}
  
  public boolean getFloatWindowEnabledAllTime()
  {
    return (FWPermission.hasPermission(BaseApplicationImpl.getContext())) && (IliveFloatWindowHelper.a());
  }
  
  public boolean getFloatWindowEnabledOnce()
  {
    return (FWPermission.hasPermission(BaseApplicationImpl.getContext())) && (IliveFloatWindowHelper.a());
  }
  
  public void onCreate(Context paramContext) {}
  
  public void onDestroy() {}
  
  public void setFloatWindowEnabledAllTime(boolean paramBoolean) {}
  
  public void setFloatWindowEnabledOnce(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.lite.service.IliveFloatWindowConfigServiceInterface
 * JD-Core Version:    0.7.0.1
 */