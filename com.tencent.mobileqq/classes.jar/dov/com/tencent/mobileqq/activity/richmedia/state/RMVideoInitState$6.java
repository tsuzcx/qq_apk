package dov.com.tencent.mobileqq.activity.richmedia.state;

import ajli;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import azcx;
import bnbe;
import bndb;
import com.tencent.common.app.BaseApplicationImpl;

public class RMVideoInitState$6
  implements Runnable
{
  public RMVideoInitState$6(bndb parambndb) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
    boolean bool1 = localSharedPreferences.getBoolean("sv_has_reported_front_camera_compatibility", false);
    boolean bool2 = localSharedPreferences.getBoolean("sv_has_reported_back_camera_compatibility", false);
    azcx localazcx = azcx.a();
    if ((!bool1) && (ajli.a == 1))
    {
      bnbe.a(localazcx.a(), "front");
      localSharedPreferences.edit().putBoolean("sv_has_reported_front_camera_compatibility", true).commit();
    }
    while ((bool2) || (ajli.a != 2)) {
      return;
    }
    bnbe.a(localazcx.a(), "back");
    localSharedPreferences.edit().putBoolean("sv_has_reported_back_camera_compatibility", true).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoInitState.6
 * JD-Core Version:    0.7.0.1
 */