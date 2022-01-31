import android.content.Context;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import org.json.JSONException;
import org.json.JSONObject;

public class rup
{
  public static int a()
  {
    return ((Integer)bgmq.a("readinjoy_user_data_switch", Integer.valueOf(0))).intValue();
  }
  
  public static void a(int paramInt)
  {
    bgmq.a("readinjoy_user_data_switch", Integer.valueOf(paramInt));
  }
  
  public static void a(Context paramContext, int paramInt, Runnable paramRunnable)
  {
    int k = Aladdin.getConfig(232).getIntegerFromString("user_data_alert_switch", 0);
    String str = Aladdin.getConfig(232).getString("user_data_alert_content", paramContext.getString(2131652780));
    int j = Aladdin.getConfig(232).getIntegerFromString("user_data_alert_interval", 1);
    int i = ((Integer)bgmq.a("readinjoy_user_data_state", Integer.valueOf(0))).intValue();
    long l1 = ((Long)bgmq.a("readinjoy_user_data_time", Long.valueOf(0L))).longValue();
    int m = ((Integer)bgmq.a("readinjoy_user_data_switch", Integer.valueOf(1))).intValue();
    long l2;
    if ((k == 1) && (m == 1))
    {
      l2 = System.currentTimeMillis();
      if (l2 - l1 < j * 86400000L) {
        break label329;
      }
      i = 0;
    }
    label329:
    for (;;)
    {
      if ((1 << paramInt & i) == 0)
      {
        bgmq.a("readinjoy_user_data_time", Long.valueOf(l2));
        bgmq.a("readinjoy_user_data_state", Integer.valueOf(i | 1 << paramInt));
        bafb localbafb = babr.a(paramContext, 230);
        localbafb.setTitle(null);
        localbafb.setMessage(str);
        localbafb.setPositiveButton(paramContext.getString(2131654986), new ruq(paramInt, j, paramRunnable));
        localbafb.setNegativeButton(paramContext.getString(2131654989), new rur(paramInt, j, paramRunnable));
        localbafb.show();
        paramContext = new JSONObject();
        if (paramInt == 1) {
          paramInt = 0;
        }
      }
      do
      {
        do
        {
          try
          {
            for (;;)
            {
              paramContext.put("exp_src", paramInt);
              paramContext.put("user_data_alert_interval", j);
              ndn.a(null, "", "0X800A808", "0X800A808", 0, 0, "", "", "", paramContext.toString(), false);
              return;
              paramInt = 1;
            }
          }
          catch (JSONException paramRunnable)
          {
            for (;;)
            {
              paramRunnable.printStackTrace();
            }
          }
        } while (paramRunnable == null);
        paramRunnable.run();
        return;
      } while (paramRunnable == null);
      paramRunnable.run();
      return;
    }
  }
  
  public static int b()
  {
    int i = Aladdin.getConfig(232).getIntegerFromString("user_data_alert_switch", 0);
    int j = Aladdin.getConfig(232).getIntegerFromString("user_data_switch_switch", 0);
    if ((i == 0) && (j == 0)) {
      return 0;
    }
    if (a() == 0) {
      return 1;
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rup
 * JD-Core Version:    0.7.0.1
 */