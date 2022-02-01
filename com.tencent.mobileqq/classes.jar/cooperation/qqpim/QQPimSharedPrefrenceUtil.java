package cooperation.qqpim;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class QQPimSharedPrefrenceUtil
{
  public static long a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("QQPIM_SETTING", 0).getLong(paramString, 0L);
  }
  
  public static void a(Context paramContext, String paramString, long paramLong)
  {
    paramContext.getSharedPreferences("QQPIM_SETTING", 0).edit().putLong(paramString, paramLong).commit();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    if (paramString2 == null) {
      return;
    }
    paramContext.getSharedPreferences("QQPIM_SETTING", 0).edit().putString(paramString1, paramString2).commit();
  }
  
  public static String b(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("QQPIM_SETTING", 0).getString(paramString, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqpim.QQPimSharedPrefrenceUtil
 * JD-Core Version:    0.7.0.1
 */