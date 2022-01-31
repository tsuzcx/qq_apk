package cooperation.readinjoy;

import bhvh;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import noo;
import org.json.JSONObject;

public final class ReadInJoyHelper$4
  implements Runnable
{
  public ReadInJoyHelper$4(AppRuntime paramAppRuntime) {}
  
  public void run()
  {
    Object localObject1 = bhvh.a("remote_kd_tab_switch");
    Object localObject2 = bhvh.a("local_kd_tab_switch");
    int k;
    int n;
    int i1;
    label63:
    int m;
    if (bhvh.i())
    {
      k = 1;
      n = bhvh.a("local_kd_tab_switch").intValue();
      i1 = bhvh.a("local_kd_tab_switch_prefix").intValue();
      if (!(localObject1 instanceof Boolean)) {
        break label285;
      }
      if (!((Boolean)localObject1).booleanValue()) {
        break label280;
      }
      i = 1;
      m = i;
      label66:
      localObject1 = bhvh.a("local_kd_tab_has_set");
      if (!(localObject2 instanceof Boolean)) {
        break label346;
      }
      if (!((Boolean)localObject2).booleanValue()) {
        break label291;
      }
    }
    label280:
    label285:
    label291:
    label346:
    for (int i = 1;; i = -1)
    {
      label94:
      if ((localObject1 instanceof Boolean)) {
        if (((Boolean)localObject1).booleanValue()) {}
      }
      for (int j = -1;; j = -1) {
        for (;;)
        {
          localObject2 = new JSONObject();
          try
          {
            ((JSONObject)localObject2).put("ui_cache_switch", String.valueOf(n));
            ((JSONObject)localObject2).put("db_cache_switch", String.valueOf(i1));
            bhvh.a((JSONObject)localObject2);
            noo.a(null, this.a.getAccount(), "0X8009663", "0X8009663", 0, 0, String.valueOf(i), String.valueOf(j), String.valueOf(k), ((JSONObject)localObject2).toString(), false);
            QLog.d("ReadInJoyHelper", 1, this.a.getAccount() + " ui_switch:" + k + "  ui_cache_switch:" + n + "  db_cache_switch:" + i1 + "  remote_switch:" + m + " localSwitch:" + i + "  userHasSet:" + localObject1);
            return;
            k = 0;
            break;
            i = 0;
            break label63;
            m = -1;
            break label66;
            i = 0;
            break label94;
            j = i;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("ReadInJoyHelper", 2, "only kandian tab switch, report error:" + localException.toString());
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.readinjoy.ReadInJoyHelper.4
 * JD-Core Version:    0.7.0.1
 */