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
  private static String b;
  private static String c;
  private static String d;
  private static String e;
  private static boolean f = false;
  private static int g;
  
  public static int a()
  {
    if (b(a))
    {
      QLog.d("DailyModeConfigHandler", 1, "[getMode] isDailyUnlimitChannel MODE_LOAD_MORE");
      return 2;
    }
    Integer localInteger = (Integer)RIJSPUtils.b("readinjoy_daily_mode_plan_number", Integer.valueOf(-1));
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
  
  public static void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    try
    {
      paramString = new JSONObject(paramString);
      b = paramString.optString("bottom_text");
      c = paramString.optString("jump_url");
      d = paramString.optString("jump_src");
      e = paramString.optString("ReadInjoy_daily_footer_pts");
      if (b != null) {
        RIJSPUtils.a("readinjoy_daily_mode_bottom_text", b);
      }
      if (c != null) {
        RIJSPUtils.a("readinjoy_daily_mode_bottom_jump", c);
      }
      if (d != null) {
        RIJSPUtils.a("readinjoy_daily_mode_bottom_jump_src", d);
      }
      if (e != null)
      {
        RIJSPUtils.a("readinjoy_daily_mode_footer_pts", e);
        return;
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static boolean a(int paramInt)
  {
    return paramInt == 41505;
  }
  
  public static float b()
  {
    float f2 = 1.0F;
    Float localFloat = (Float)RIJSPUtils.b("readinjoy_daily_mode_drag_threshold", Float.valueOf(1.0F));
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
  
  public static boolean b(int paramInt)
  {
    boolean bool2 = a(a);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (a == paramInt) {
      bool1 = true;
    }
    return bool1;
  }
  
  public static String c()
  {
    String str = c;
    if (str != null) {
      return str;
    }
    c = (String)RIJSPUtils.b("readinjoy_daily_mode_bottom_jump", "");
    return c;
  }
  
  public static boolean c(int paramInt)
  {
    if (a(paramInt)) {
      return true;
    }
    return b(paramInt);
  }
  
  public static JSONObject d()
  {
    if (TextUtils.isEmpty(e)) {
      e = (String)RIJSPUtils.b("readinjoy_daily_mode_footer_pts", "");
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getFooterData pts = ");
    ((StringBuilder)localObject).append(e);
    QLog.i("DailyModeConfigHandler", 1, ((StringBuilder)localObject).toString());
    try
    {
      localObject = new JSONObject(e);
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
        localJSONObject.put("title_CN", HardCodeUtil.a(2131900862));
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
  
  public static String e()
  {
    if (a() == 1) {
      return "1";
    }
    String str = d;
    if (str != null) {
      return str;
    }
    d = (String)RIJSPUtils.b("readinjoy_daily_mode_bottom_jump_src", "0");
    return d;
  }
  
  public static void f()
  {
    QLog.d("DailyModeConfigHandler", 1, "DailyModeConfigHandler reset.");
    b = null;
    c = null;
    d = null;
    e = null;
  }
  
  public static boolean g()
  {
    return f;
  }
  
  public static void h()
  {
    f = "1".equals((String)RIJSPUtils.b("readinjoy_daily_mode_refresh_mode", "0"));
    a = ((Integer)RIJSPUtils.b("readinjoy_daily_mode_channel_id", Integer.valueOf(41505))).intValue();
    if (!RIJShowKanDianTabSp.a())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("非独立看点->进入无限流 refreshDailyConfig   ");
      localStringBuilder.append(a);
      QLog.i("DailyModeConfigHandler", 1, localStringBuilder.toString());
      a = 41697;
    }
    if (b(a)) {
      f = true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("refreshDailyConfig ");
    localStringBuilder.append(f);
    localStringBuilder.append("  ");
    localStringBuilder.append(a);
    QLog.i("DailyModeConfigHandler", 1, localStringBuilder.toString());
    g = a;
    if (RIJTransMergeKanDianReport.b) {
      a = 41697;
    }
  }
  
  public static void i()
  {
    a = g;
  }
  
  public static int j()
  {
    return a;
  }
  
  public static boolean k()
  {
    boolean bool2 = g();
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (RIJDailyModeAladdinConfig.a.a() == 1) {
      bool1 = true;
    }
    return bool1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler
 * JD-Core Version:    0.7.0.1
 */