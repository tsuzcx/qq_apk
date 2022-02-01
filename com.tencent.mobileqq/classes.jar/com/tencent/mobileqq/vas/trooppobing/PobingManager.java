package com.tencent.mobileqq.vas.trooppobing;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.statistics.ReportController;
import common.config.service.QzoneConfig;
import java.util.HashMap;

public class PobingManager
{
  static HashMap<Long, Boolean> a = new HashMap();
  public static final HashMap<Integer, Integer> b = new PobingManager.1();
  public static final HashMap<Integer, Integer> c = new PobingManager.2();
  public static final HashMap<Integer, Integer> d = new PobingManager.3();
  
  public static String a(int paramInt)
  {
    return "pobing.bitmap.cache." + b.get(Integer.valueOf(paramInt));
  }
  
  public static void a()
  {
    a.clear();
  }
  
  public static void a(long paramLong)
  {
    a.put(Long.valueOf(paramLong), Boolean.valueOf(false));
  }
  
  public static void a(Context paramContext)
  {
    String str = QzoneConfig.getInstance().getConfig("qqsetting", "addgroupvasjumpurl", "https://m.vip.qq.com/freedom/newbird.html?_cwv=1&_wv=553648133&g_ch=aio");
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", str);
    paramContext.startActivity(localIntent);
    ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A4F7", 3, 0, "", "", "", "");
  }
  
  public static boolean a(long paramLong)
  {
    Boolean localBoolean = (Boolean)a.get(Long.valueOf(paramLong));
    return (localBoolean == null) || (localBoolean.equals(Boolean.valueOf(true)));
  }
  
  public static String b(int paramInt)
  {
    return "pobing.preview.cache." + b.get(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.trooppobing.PobingManager
 * JD-Core Version:    0.7.0.1
 */