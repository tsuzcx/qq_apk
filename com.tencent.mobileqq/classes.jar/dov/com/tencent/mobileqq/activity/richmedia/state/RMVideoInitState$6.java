package dov.com.tencent.mobileqq.activity.richmedia.state;

import aluf;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bday;
import bqyo;
import bral;
import com.tencent.common.app.BaseApplicationImpl;

public class RMVideoInitState$6
  implements Runnable
{
  public RMVideoInitState$6(bral parambral) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
    boolean bool1 = localSharedPreferences.getBoolean("sv_has_reported_front_camera_compatibility", false);
    boolean bool2 = localSharedPreferences.getBoolean("sv_has_reported_back_camera_compatibility", false);
    bday localbday = bday.a();
    if ((!bool1) && (aluf.a == 1))
    {
      bqyo.a(localbday.a(), "front");
      localSharedPreferences.edit().putBoolean("sv_has_reported_front_camera_compatibility", true).commit();
    }
    while ((bool2) || (aluf.a != 2)) {
      return;
    }
    bqyo.a(localbday.a(), "back");
    localSharedPreferences.edit().putBoolean("sv_has_reported_back_camera_compatibility", true).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoInitState.6
 * JD-Core Version:    0.7.0.1
 */