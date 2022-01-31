package dov.com.tencent.mobileqq.activity.richmedia.state;

import ahty;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import axhr;
import bkpu;
import bkrr;
import com.tencent.common.app.BaseApplicationImpl;

public class RMVideoInitState$6
  implements Runnable
{
  public RMVideoInitState$6(bkrr parambkrr) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
    boolean bool1 = localSharedPreferences.getBoolean("sv_has_reported_front_camera_compatibility", false);
    boolean bool2 = localSharedPreferences.getBoolean("sv_has_reported_back_camera_compatibility", false);
    axhr localaxhr = axhr.a();
    if ((!bool1) && (ahty.a == 1))
    {
      bkpu.a(localaxhr.a(), "front");
      localSharedPreferences.edit().putBoolean("sv_has_reported_front_camera_compatibility", true).commit();
    }
    while ((bool2) || (ahty.a != 2)) {
      return;
    }
    bkpu.a(localaxhr.a(), "back");
    localSharedPreferences.edit().putBoolean("sv_has_reported_back_camera_compatibility", true).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoInitState.6
 * JD-Core Version:    0.7.0.1
 */