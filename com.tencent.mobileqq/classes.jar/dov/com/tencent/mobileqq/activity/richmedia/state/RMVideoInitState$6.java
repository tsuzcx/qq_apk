package dov.com.tencent.mobileqq.activity.richmedia.state;

import alps;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bdax;
import bpii;
import bpke;
import com.tencent.common.app.BaseApplicationImpl;

public class RMVideoInitState$6
  implements Runnable
{
  public RMVideoInitState$6(bpke parambpke) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
    boolean bool1 = localSharedPreferences.getBoolean("sv_has_reported_front_camera_compatibility", false);
    boolean bool2 = localSharedPreferences.getBoolean("sv_has_reported_back_camera_compatibility", false);
    bdax localbdax = bdax.a();
    if ((!bool1) && (alps.a == 1))
    {
      bpii.a(localbdax.a(), "front");
      localSharedPreferences.edit().putBoolean("sv_has_reported_front_camera_compatibility", true).commit();
    }
    while ((bool2) || (alps.a != 2)) {
      return;
    }
    bpii.a(localbdax.a(), "back");
    localSharedPreferences.edit().putBoolean("sv_has_reported_back_camera_compatibility", true).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoInitState.6
 * JD-Core Version:    0.7.0.1
 */