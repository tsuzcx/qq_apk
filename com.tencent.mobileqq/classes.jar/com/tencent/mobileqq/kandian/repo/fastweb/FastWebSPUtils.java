package com.tencent.mobileqq.kandian.repo.fastweb;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class FastWebSPUtils
{
  private static int a = -1;
  
  public static int a(AppRuntime paramAppRuntime)
  {
    int i = a;
    if ((i != 0) && (i != 1))
    {
      paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
      if (paramAppRuntime == null)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "getKandianConifgFastWebCloseBiuCntSwitch() failed");
        return 0;
      }
      a = paramAppRuntime.getInt("fast_web_close_biu_cnt_switch", 0);
      return a;
    }
    return a;
  }
  
  public static String a(AppRuntime paramAppRuntime)
  {
    return Aladdin.getConfig(178).getString("native_engine_timeout_config", "1000,10000,10000,2000,15000");
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigFastWebCloseBiuCntSwtich() failed");
      return;
    }
    try
    {
      int i = Integer.parseInt(paramString);
      if (i < 0)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigFastWebCloseBiuCntSwtich() biuCntSwitch < 0");
        return;
      }
      if (i > 1)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigFastWebCloseBiuCntSwtich() biuCntSwitch > 1");
        return;
      }
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putInt("fast_web_close_biu_cnt_switch", i);
      RIJSPUtils.a(paramAppRuntime, true);
      a = i;
      return;
    }
    catch (Exception paramAppRuntime)
    {
      label79:
      break label79;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigFastWebCloseBiuCntSwtich() biuCntSwitch failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.fastweb.FastWebSPUtils
 * JD-Core Version:    0.7.0.1
 */