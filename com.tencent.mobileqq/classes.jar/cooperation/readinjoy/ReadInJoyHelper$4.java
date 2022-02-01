package cooperation.readinjoy;

import bkwm;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public final class ReadInJoyHelper$4
  implements Runnable
{
  public ReadInJoyHelper$4(AppRuntime paramAppRuntime) {}
  
  public void run()
  {
    int m = 0;
    int n = -1;
    Object localObject2 = bkwm.a("remote_kd_tab_switch");
    Object localObject1 = bkwm.a("local_kd_tab_switch");
    int j;
    int i1;
    int i2;
    label69:
    int k;
    if (bkwm.i())
    {
      j = 1;
      i1 = bkwm.a("local_kd_tab_switch").intValue();
      i2 = bkwm.a("local_kd_tab_switch_prefix").intValue();
      if (!(localObject2 instanceof Boolean)) {
        break label233;
      }
      if (!((Boolean)localObject2).booleanValue()) {
        break label228;
      }
      i = 1;
      k = i;
      label71:
      localObject2 = bkwm.a("local_kd_tab_has_set");
      if (!(localObject1 instanceof Boolean)) {
        break label244;
      }
      i = m;
      if (!((Boolean)localObject1).booleanValue()) {}
    }
    label228:
    label233:
    label238:
    label244:
    for (int i = 1;; i = -1)
    {
      m = n;
      if ((localObject2 instanceof Boolean)) {
        if (((Boolean)localObject2).booleanValue()) {
          break label238;
        }
      }
      for (m = n;; m = i)
      {
        QLog.d("ReadInJoyHelper", 1, this.a.getAccount() + " ui_switch:" + j + "  ui_cache_switch:" + i1 + "  db_cache_switch:" + i2 + "  remote_switch:" + k + " localSwitch:" + i + "  userHasSet:" + localObject2 + "  user_switch: " + m);
        return;
        j = 0;
        break;
        i = 0;
        break label69;
        k = -1;
        break label71;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.readinjoy.ReadInJoyHelper.4
 * JD-Core Version:    0.7.0.1
 */