package cooperation.readinjoy;

import android.content.SharedPreferences;
import bjxj;
import mqq.app.AppRuntime;

public final class ReadInJoyHelper$2
  implements Runnable
{
  public ReadInJoyHelper$2(AppRuntime paramAppRuntime) {}
  
  public void run()
  {
    int i = 1;
    SharedPreferences localSharedPreferences = bjxj.a(this.a, true, true);
    if (localSharedPreferences == null) {
      return;
    }
    if (localSharedPreferences.getBoolean("free_time_refresh_push", true)) {}
    for (;;)
    {
      bjxj.a(i);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.readinjoy.ReadInJoyHelper.2
 * JD-Core Version:    0.7.0.1
 */