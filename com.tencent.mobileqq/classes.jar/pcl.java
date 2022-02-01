import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.aladdin.config.handlers.AladdinConfigHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class pcl
  implements AladdinConfigHandler
{
  private static int jdField_a_of_type_Int = 41505;
  private static String jdField_a_of_type_JavaLangString;
  private static boolean jdField_a_of_type_Boolean;
  private static int jdField_b_of_type_Int;
  private static String jdField_b_of_type_JavaLangString;
  private static String c;
  private static String d;
  
  public static float a()
  {
    Float localFloat = (Float)bkwm.a("readinjoy_daily_mode_drag_threshold", Float.valueOf(1.0F));
    QLog.d("DailyModeConfigHandler", 1, "[getJumpThreshold] " + localFloat);
    if ((localFloat.floatValue() > 0.001D) && (localFloat.floatValue() < 10.0F)) {
      return localFloat.floatValue();
    }
    return 1.0F;
  }
  
  public static int a()
  {
    if (b(jdField_a_of_type_Int))
    {
      QLog.d("DailyModeConfigHandler", 1, "[getMode] isDailyUnlimitChannel MODE_LOAD_MORE");
      return 2;
    }
    Integer localInteger = (Integer)bkwm.a("readinjoy_daily_mode_plan_number", Integer.valueOf(-1));
    QLog.d("DailyModeConfigHandler", 1, "[getMode] " + localInteger);
    if (localInteger.intValue() == 2) {
      return 2;
    }
    if (localInteger.intValue() == 1) {
      return 1;
    }
    return 3;
  }
  
  public static String a()
  {
    if (jdField_b_of_type_JavaLangString != null) {
      return jdField_b_of_type_JavaLangString;
    }
    jdField_b_of_type_JavaLangString = (String)bkwm.a("readinjoy_daily_mode_bottom_jump", "");
    return jdField_b_of_type_JavaLangString;
  }
  
  public static JSONObject a()
  {
    if (TextUtils.isEmpty(d)) {
      d = (String)bkwm.a("readinjoy_daily_mode_footer_pts", "");
    }
    QLog.i("DailyModeConfigHandler", 1, "getFooterData pts = " + d);
    try
    {
      JSONObject localJSONObject1 = new JSONObject(d);
      return localJSONObject1;
    }
    catch (JSONException localJSONException1)
    {
      QLog.e("DailyModeConfigHandler", 1, "getFooterData e = " + localJSONException1);
      JSONObject localJSONObject2 = new JSONObject();
      try
      {
        localJSONObject2.put("style_ID", "ReadInjoy_daily_footer");
        localJSONObject2.put("title_EN", "TENCENT KANDIAN");
        localJSONObject2.put("title_CN", amtj.a(2131701852));
        return localJSONObject2;
      }
      catch (JSONException localJSONException2)
      {
        QLog.e("DailyModeConfigHandler", 1, "getFooterData e = " + localJSONException2);
      }
      return localJSONObject2;
    }
  }
  
  public static void a()
  {
    QLog.d("DailyModeConfigHandler", 1, "DailyModeConfigHandler reset.");
    jdField_a_of_type_JavaLangString = null;
    jdField_b_of_type_JavaLangString = null;
    c = null;
    d = null;
  }
  
  public static void a(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return;
      try
      {
        paramString = new JSONObject(paramString);
        jdField_a_of_type_JavaLangString = paramString.optString("bottom_text");
        jdField_b_of_type_JavaLangString = paramString.optString("jump_url");
        c = paramString.optString("jump_src");
        d = paramString.optString("ReadInjoy_daily_footer_pts");
        if (jdField_a_of_type_JavaLangString != null) {
          bkwm.a("readinjoy_daily_mode_bottom_text", jdField_a_of_type_JavaLangString);
        }
        if (jdField_b_of_type_JavaLangString != null) {
          bkwm.a("readinjoy_daily_mode_bottom_jump", jdField_b_of_type_JavaLangString);
        }
        if (c != null) {
          bkwm.a("readinjoy_daily_mode_bottom_jump_src", c);
        }
        if (d != null)
        {
          bkwm.a("readinjoy_daily_mode_footer_pts", d);
          return;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public static boolean a(int paramInt)
  {
    return paramInt == 41505;
  }
  
  public static int b()
  {
    return jdField_a_of_type_Int;
  }
  
  public static String b()
  {
    if (ojm.a() == 1) {
      return "1";
    }
    if (c != null) {
      return c;
    }
    c = (String)bkwm.a("readinjoy_daily_mode_bottom_jump_src", "0");
    return c;
  }
  
  public static void b()
  {
    jdField_a_of_type_Boolean = "1".equals((String)bkwm.a("readinjoy_daily_mode_refresh_mode", "0"));
    jdField_a_of_type_Int = ((Integer)bkwm.a("readinjoy_daily_mode_channel_id", Integer.valueOf(41505))).intValue();
    if (!bkwm.g())
    {
      QLog.i("DailyModeConfigHandler", 1, "非独立看点->进入无限流 refreshDailyConfig   " + jdField_a_of_type_Int);
      jdField_a_of_type_Int = 41697;
    }
    if (b(jdField_a_of_type_Int)) {
      jdField_a_of_type_Boolean = true;
    }
    QLog.i("DailyModeConfigHandler", 1, "refreshDailyConfig " + jdField_a_of_type_Boolean + "  " + jdField_a_of_type_Int);
    jdField_b_of_type_Int = jdField_a_of_type_Int;
    if (pay.c) {
      jdField_a_of_type_Int = 41697;
    }
  }
  
  public static boolean b()
  {
    boolean bool = true;
    if (a()) {
      return false;
    }
    if (Aladdin.getConfig(157).getIntegerFromString("enable_dynamic_header", 0) == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean b(int paramInt)
  {
    if (a(jdField_a_of_type_Int)) {}
    while (jdField_a_of_type_Int != paramInt) {
      return false;
    }
    return true;
  }
  
  public static void c()
  {
    jdField_a_of_type_Int = jdField_b_of_type_Int;
  }
  
  public static boolean c(int paramInt)
  {
    if (a(paramInt)) {
      return true;
    }
    return b(paramInt);
  }
  
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    QLog.d("DailyModeConfigHandler", 1, "[onReceiveConfig] " + paramString);
    paramString = pbt.a(paramString);
    Iterator localIterator = paramString.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)paramString.get(str1);
      QLog.d("DailyModeConfigHandler", 2, "[onReceiveConfig] key=" + str1 + ", value=" + str2);
      if (TextUtils.equals(str1, "daily_plan_number")) {
        bkwm.a("readinjoy_daily_mode_plan_number", Integer.valueOf(str2));
      } else if (TextUtils.equals(str1, "daily_drag_threshold")) {
        bkwm.a("readinjoy_daily_mode_drag_threshold", Float.valueOf(str2));
      }
    }
    return true;
  }
  
  public void onWipeConfig(int paramInt)
  {
    QLog.d("DailyModeConfigHandler", 1, "[onWipeConfig]");
    bkwm.a("readinjoy_daily_mode_plan_number", Integer.valueOf(-1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pcl
 * JD-Core Version:    0.7.0.1
 */