package com.tencent.mobileqq.kandian.repo.aladdin.handlers;

import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.repo.aladdin.AladdinParseUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJDailyModeAladdinConfig;
import com.tencent.mobileqq.kandian.repo.common.RIJShowKanDianTabSp;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class DailyModeConfigHandler
  extends SimpleConfigHandler
{
  public static int a = 41505;
  private static String jdField_a_of_type_JavaLangString;
  private static boolean jdField_a_of_type_Boolean = false;
  private static int jdField_b_of_type_Int;
  private static String jdField_b_of_type_JavaLangString;
  private static String c;
  private static String d;
  
  public static float a()
  {
    float f2 = 1.0F;
    Float localFloat = (Float)RIJSPUtils.a("readinjoy_daily_mode_drag_threshold", Float.valueOf(1.0F));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[getJumpThreshold] ");
    localStringBuilder.append(localFloat);
    QLog.d("DailyModeConfigHandler", 1, localStringBuilder.toString());
    float f1 = f2;
    if (localFloat.floatValue() > 0.001D)
    {
      f1 = f2;
      if (localFloat.floatValue() < 10.0F) {
        f1 = localFloat.floatValue();
      }
    }
    return f1;
  }
  
  public static int a()
  {
    if (b(jdField_a_of_type_Int))
    {
      QLog.d("DailyModeConfigHandler", 1, "[getMode] isDailyUnlimitChannel MODE_LOAD_MORE");
      return 2;
    }
    Integer localInteger = (Integer)RIJSPUtils.a("readinjoy_daily_mode_plan_number", Integer.valueOf(-1));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[getMode] ");
    localStringBuilder.append(localInteger);
    QLog.d("DailyModeConfigHandler", 1, localStringBuilder.toString());
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
    String str = jdField_b_of_type_JavaLangString;
    if (str != null) {
      return str;
    }
    jdField_b_of_type_JavaLangString = (String)RIJSPUtils.a("readinjoy_daily_mode_bottom_jump", "");
    return jdField_b_of_type_JavaLangString;
  }
  
  public static JSONObject a()
  {
    if (TextUtils.isEmpty(d)) {
      d = (String)RIJSPUtils.a("readinjoy_daily_mode_footer_pts", "");
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getFooterData pts = ");
    ((StringBuilder)localObject).append(d);
    QLog.i("DailyModeConfigHandler", 1, ((StringBuilder)localObject).toString());
    try
    {
      localObject = new JSONObject(d);
      return localObject;
    }
    catch (JSONException localJSONException1)
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("getFooterData e = ");
      localStringBuilder1.append(localJSONException1);
      QLog.e("DailyModeConfigHandler", 1, localStringBuilder1.toString());
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("style_ID", "ReadInjoy_daily_footer");
        localJSONObject.put("title_EN", "TENCENT KANDIAN");
        localJSONObject.put("title_CN", HardCodeUtil.a(2131702884));
        return localJSONObject;
      }
      catch (JSONException localJSONException2)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("getFooterData e = ");
        localStringBuilder2.append(localJSONException2);
        QLog.e("DailyModeConfigHandler", 1, localStringBuilder2.toString());
      }
      return localJSONObject;
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
    if (paramString == null) {
      return;
    }
    try
    {
      paramString = new JSONObject(paramString);
      jdField_a_of_type_JavaLangString = paramString.optString("bottom_text");
      jdField_b_of_type_JavaLangString = paramString.optString("jump_url");
      c = paramString.optString("jump_src");
      d = paramString.optString("ReadInjoy_daily_footer_pts");
      if (jdField_a_of_type_JavaLangString != null) {
        RIJSPUtils.a("readinjoy_daily_mode_bottom_text", jdField_a_of_type_JavaLangString);
      }
      if (jdField_b_of_type_JavaLangString != null) {
        RIJSPUtils.a("readinjoy_daily_mode_bottom_jump", jdField_b_of_type_JavaLangString);
      }
      if (c != null) {
        RIJSPUtils.a("readinjoy_daily_mode_bottom_jump_src", c);
      }
      if (d != null)
      {
        RIJSPUtils.a("readinjoy_daily_mode_footer_pts", d);
        return;
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
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
    if (a() == 1) {
      return "1";
    }
    String str = c;
    if (str != null) {
      return str;
    }
    c = (String)RIJSPUtils.a("readinjoy_daily_mode_bottom_jump_src", "0");
    return c;
  }
  
  public static void b()
  {
    jdField_a_of_type_Boolean = "1".equals((String)RIJSPUtils.a("readinjoy_daily_mode_refresh_mode", "0"));
    jdField_a_of_type_Int = ((Integer)RIJSPUtils.a("readinjoy_daily_mode_channel_id", Integer.valueOf(41505))).intValue();
    if (!RIJShowKanDianTabSp.a())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("非独立看点->进入无限流 refreshDailyConfig   ");
      localStringBuilder.append(jdField_a_of_type_Int);
      QLog.i("DailyModeConfigHandler", 1, localStringBuilder.toString());
      jdField_a_of_type_Int = 41697;
    }
    if (b(jdField_a_of_type_Int)) {
      jdField_a_of_type_Boolean = true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("refreshDailyConfig ");
    localStringBuilder.append(jdField_a_of_type_Boolean);
    localStringBuilder.append("  ");
    localStringBuilder.append(jdField_a_of_type_Int);
    QLog.i("DailyModeConfigHandler", 1, localStringBuilder.toString());
    jdField_b_of_type_Int = jdField_a_of_type_Int;
    if (RIJTransMergeKanDianReport.jdField_a_of_type_Boolean) {
      jdField_a_of_type_Int = 41697;
    }
  }
  
  public static boolean b()
  {
    boolean bool2 = a();
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (RIJDailyModeAladdinConfig.a.a() == 1) {
      bool1 = true;
    }
    return bool1;
  }
  
  public static boolean b(int paramInt)
  {
    boolean bool2 = a(jdField_a_of_type_Int);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (jdField_a_of_type_Int == paramInt) {
      bool1 = true;
    }
    return bool1;
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
    super.onReceiveConfig(paramInt1, paramInt2, paramString);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onReceiveConfig] ");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("DailyModeConfigHandler", 1, ((StringBuilder)localObject).toString());
    paramString = AladdinParseUtils.a(paramString);
    localObject = paramString.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str1 = (String)((Iterator)localObject).next();
      String str2 = (String)paramString.get(str1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onReceiveConfig] key=");
      localStringBuilder.append(str1);
      localStringBuilder.append(", value=");
      localStringBuilder.append(str2);
      QLog.d("DailyModeConfigHandler", 2, localStringBuilder.toString());
      if (TextUtils.equals(str1, "daily_plan_number")) {
        RIJSPUtils.a("readinjoy_daily_mode_plan_number", Integer.valueOf(str2));
      } else if (TextUtils.equals(str1, "daily_drag_threshold")) {
        RIJSPUtils.a("readinjoy_daily_mode_drag_threshold", Float.valueOf(str2));
      }
    }
    return true;
  }
  
  public void onWipeConfig(int paramInt)
  {
    super.onWipeConfig(paramInt);
    QLog.d("DailyModeConfigHandler", 1, "[onWipeConfig]");
    RIJSPUtils.a("readinjoy_daily_mode_plan_number", Integer.valueOf(-1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler
 * JD-Core Version:    0.7.0.1
 */