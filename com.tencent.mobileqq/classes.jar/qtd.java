import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class qtd
{
  public static long a;
  
  public static void a()
  {
    a = System.currentTimeMillis();
  }
  
  public static void a(Context paramContext)
  {
    long l = System.currentTimeMillis();
    if (l - a < 10000L)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_starttime", String.valueOf(l - a));
      onh.d(paramContext, onh.a(), true, localHashMap);
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsStartStatistic", 2, "doReportStartTime param_starttime=" + (l - a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qtd
 * JD-Core Version:    0.7.0.1
 */