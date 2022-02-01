import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;

public class mcm
{
  private static String a = "QAVPreSetting";
  private static String b = "BeautyFeature";
  private static String c = "BeautyValue";
  private static String d = "BeautyConfig";
  private static String e = "BeautyResetGuide";
  
  public static int a(String paramString)
  {
    return BaseApplicationImpl.getApplication().getApplicationContext().getSharedPreferences(a, 0).getInt(c + paramString, -1);
  }
  
  public static String a(String paramString)
  {
    return BaseApplicationImpl.getApplication().getApplicationContext().getSharedPreferences(a, 0).getString(d + paramString, "");
  }
  
  public static void a(String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getApplicationContext().getSharedPreferences(a, 0);
    paramString = e + paramString;
    localSharedPreferences.edit().putInt(paramString, paramInt).apply();
  }
  
  public static void a(String paramString1, String paramString2)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getApplicationContext().getSharedPreferences(a, 0);
    paramString1 = d + paramString1;
    localSharedPreferences.edit().putString(paramString1, paramString2).apply();
  }
  
  public static boolean a(String paramString)
  {
    paramString = BaseApplicationImpl.getApplication().getSharedPreferences(a, 0);
    String str = b;
    int j = paramString.getInt(str, -1);
    int i = j;
    if (j == -1) {
      if (!llq.d()) {
        break label67;
      }
    }
    label67:
    for (i = 1;; i = 0)
    {
      paramString.edit().putInt(str, i).commit();
      return i >= 1;
    }
  }
  
  public static int b(String paramString)
  {
    return BaseApplicationImpl.getApplication().getApplicationContext().getSharedPreferences(a, 0).getInt(e + paramString, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mcm
 * JD-Core Version:    0.7.0.1
 */