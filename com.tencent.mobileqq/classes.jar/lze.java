import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class lze
{
  protected static int a(Context paramContext, String paramString, int paramInt)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString, paramInt);
  }
  
  protected static long a(Context paramContext, String paramString, long paramLong)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getLong(paramString, paramLong);
  }
  
  protected static void a(Context paramContext, String paramString, int paramInt)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putInt(paramString, paramInt).commit();
  }
  
  protected static void a(Context paramContext, String paramString, long paramLong)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putLong(paramString, paramLong).commit();
  }
  
  protected static void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putBoolean(paramString, paramBoolean).commit();
  }
  
  protected static boolean a(Context paramContext, String paramString, boolean paramBoolean)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean(paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lze
 * JD-Core Version:    0.7.0.1
 */