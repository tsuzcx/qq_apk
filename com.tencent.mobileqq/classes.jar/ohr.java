import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class ohr
{
  public static int a(AppRuntime paramAppRuntime, String paramString)
  {
    try
    {
      int i = paramAppRuntime.getApplication().getSharedPreferences("ecshop_pref", 4).getInt(paramString, 0);
      return i;
    }
    catch (Exception paramAppRuntime)
    {
      QLog.e("Ecshop_SharedPreferencesUtil", 1, "[getValueFromSP] fail.", paramAppRuntime);
    }
    return 0;
  }
  
  public static String a(AppRuntime paramAppRuntime, String paramString)
  {
    try
    {
      paramAppRuntime = paramAppRuntime.getApplication().getSharedPreferences("ecshop_pref", 4).getString(paramString, "");
      return paramAppRuntime;
    }
    catch (Exception paramAppRuntime)
    {
      QLog.e("Ecshop_SharedPreferencesUtil", 1, "[saveValueToSP] fail.", paramAppRuntime);
    }
    return "";
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString)
  {
    try
    {
      paramAppRuntime.getApplication().getSharedPreferences("ecshop_pref", 4).edit().remove(paramString).apply();
      return;
    }
    catch (Exception paramAppRuntime)
    {
      QLog.e("Ecshop_SharedPreferencesUtil", 1, "[saveValueToSP] fail.", paramAppRuntime);
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString, int paramInt)
  {
    try
    {
      paramAppRuntime.getApplication().getSharedPreferences("ecshop_pref", 4).edit().putInt(paramString, paramInt).apply();
      return;
    }
    catch (Exception paramAppRuntime)
    {
      QLog.e("Ecshop_SharedPreferencesUtil", 1, "[saveValueToSP] fail.", paramAppRuntime);
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    try
    {
      paramAppRuntime.getApplication().getSharedPreferences("ecshop_pref", 4).edit().putString(paramString1, paramString2).apply();
      return;
    }
    catch (Exception paramAppRuntime)
    {
      QLog.e("Ecshop_SharedPreferencesUtil", 1, "[saveValueToSP] fail.", paramAppRuntime);
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean)
  {
    try
    {
      paramAppRuntime.getApplication().getSharedPreferences("ecshop_pref", 4).edit().putBoolean(paramString, paramBoolean).apply();
      return;
    }
    catch (Exception paramAppRuntime)
    {
      QLog.e("Ecshop_SharedPreferencesUtil", 1, "[saveValueToSP] fail.", paramAppRuntime);
    }
  }
  
  public static boolean a(AppRuntime paramAppRuntime, String paramString)
  {
    try
    {
      boolean bool = paramAppRuntime.getApplication().getSharedPreferences("ecshop_pref", 4).getBoolean(paramString, false);
      return bool;
    }
    catch (Exception paramAppRuntime)
    {
      QLog.e("Ecshop_SharedPreferencesUtil", 1, "[getValueFromSP] fail.", paramAppRuntime);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ohr
 * JD-Core Version:    0.7.0.1
 */