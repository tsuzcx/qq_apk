package dov.com.tencent.mobileqq.activity.richmedia.state;

import ahhj;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import awij;
import biyr;
import bjao;
import com.tencent.common.app.BaseApplicationImpl;

public class RMVideoInitState$6
  implements Runnable
{
  public RMVideoInitState$6(bjao parambjao) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
    boolean bool1 = localSharedPreferences.getBoolean("sv_has_reported_front_camera_compatibility", false);
    boolean bool2 = localSharedPreferences.getBoolean("sv_has_reported_back_camera_compatibility", false);
    awij localawij = awij.a();
    if ((!bool1) && (ahhj.a == 1))
    {
      biyr.a(localawij.a(), "front");
      localSharedPreferences.edit().putBoolean("sv_has_reported_front_camera_compatibility", true).commit();
    }
    while ((bool2) || (ahhj.a != 2)) {
      return;
    }
    biyr.a(localawij.a(), "back");
    localSharedPreferences.edit().putBoolean("sv_has_reported_back_camera_compatibility", true).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoInitState.6
 * JD-Core Version:    0.7.0.1
 */