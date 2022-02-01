import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import com.tencent.av.utils.PopupDialog;
import com.tencent.qphone.base.util.QLog;

public class lvs
{
  private static int jdField_a_of_type_Int = 0;
  private static long jdField_a_of_type_Long = -1L;
  private static String jdField_a_of_type_JavaLangString = "";
  public static boolean a;
  
  public static int a()
  {
    return jdField_a_of_type_Int;
  }
  
  public static String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public static void a(int paramInt, String paramString)
  {
    jdField_a_of_type_Int = paramInt;
    jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static void a(Context paramContext)
  {
    if (!a(paramContext))
    {
      b(paramContext);
      PopupDialog.a(paramContext, 230, null, paramContext.getResources().getString(2131690177), 2131690620, 2131695151, new lvt(), null);
      bcef.b(null, "dc00898", "", "", "0X800B490", "0X800B490", 0, 0, "", "", "", "");
    }
  }
  
  private static boolean a(Context paramContext)
  {
    jdField_a_of_type_Long = bfyz.a(paramContext).getLong("screenshare_tips_show_before", -1L);
    return jdField_a_of_type_Long != -1L;
  }
  
  private static void b(Context paramContext)
  {
    jdField_a_of_type_Long = System.currentTimeMillis();
    paramContext = bfyz.a(paramContext).edit();
    paramContext.putLong("screenshare_tips_show_before", jdField_a_of_type_Long);
    paramContext.apply();
    QLog.w("ScreenShareTipsHelper", 1, "screenShareShowTipsTime save time[" + jdField_a_of_type_Long + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lvs
 * JD-Core Version:    0.7.0.1
 */