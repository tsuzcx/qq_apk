import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.AladdinConfigHandler;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class opj
  implements AladdinConfigHandler
{
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    paramString = oof.a(paramString);
    Iterator localIterator = paramString.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)paramString.get(str1);
      if (TextUtils.equals("check_period_ms", str1)) {
        bhvy.a("sp_key_kandian_thread_pool_check_period", Long.valueOf(str2));
      } else if (TextUtils.equals("time_out_threshold_ms", str1)) {
        bhvy.a("sp_key_kandian_thread_pool_time_out_threshold", Long.valueOf(str2));
      } else if (TextUtils.equals("thread_pool_monitor_enable", str1)) {
        bhvy.a("sp_key_kandian_thread_pool_monitor_enable", Boolean.valueOf(TextUtils.equals(str2, "1")));
      }
    }
    return true;
  }
  
  public void onWipeConfig(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     opj
 * JD-Core Version:    0.7.0.1
 */