package com.tencent.mobileqq.kandian.biz.diandian;

import android.os.Bundle;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.report.KandianDailyReportUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.common.RIJShowKanDianTabSp;
import com.tencent.mobileqq.kandian.repo.diandian.IEntranceButtonDataSource;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class DailyFeedsDiandianEntranceManager
{
  private static DailyFeedsDiandianEntranceManager a;
  private int b = 0;
  private int c = 0;
  
  private DailyFeedsDiandianEntranceManager()
  {
    Object localObject = Aladdin.getConfig(218);
    if (localObject != null)
    {
      this.b = ((AladdinConfig)localObject).getIntegerFromString("daily_diandian_icon_mode_pure", 0);
      this.c = ((AladdinConfig)localObject).getIntegerFromString("daily_diandian_icon_mode_mix", 0);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Daily entry pure : ");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append(", mix : ");
      ((StringBuilder)localObject).append(this.c);
      QLog.d("DailyFeedsDiandianEntranceManager", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public static DailyFeedsDiandianEntranceManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new DailyFeedsDiandianEntranceManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  public static boolean a(Bundle paramBundle)
  {
    return paramBundle.containsKey("daily_bottom_entry_data");
  }
  
  public static IEntranceButtonDataSource b(Bundle paramBundle)
  {
    paramBundle = paramBundle.getParcelable("daily_bottom_entry_data");
    if ((paramBundle instanceof IEntranceButtonDataSource)) {
      return (IEntranceButtonDataSource)paramBundle;
    }
    return null;
  }
  
  private String e()
  {
    int i = c();
    if (i == 2) {
      i = 5;
    } else if (i == 3) {
      i = 6;
    } else if (i == 1) {
      i = RecommendFeedsDiandianEntranceManager.getInstance().getEntryFeedsType();
    } else {
      i = -1;
    }
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("diandianfeeds_type", i);
      ((JSONObject)localObject).put("trigger_src", 1);
      ((JSONObject)localObject).put("channel_id", KandianDailyReportUtils.h());
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  public void b()
  {
    if (c() != 0) {
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80094FE", "0X80094FE", 0, 0, "", "", "", e(), false);
    }
  }
  
  public int c()
  {
    if (!RIJShowKanDianTabSp.c())
    {
      QLog.d("DailyFeedsDiandianEntranceManager", 1, "getEntryMode | hide mode");
      return 0;
    }
    if (DailyModeConfigHandler.a(DailyModeConfigHandler.j()))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getEntryMode |  entryModeInNormalDaily : ");
      localStringBuilder.append(this.b);
      QLog.d("DailyFeedsDiandianEntranceManager", 1, localStringBuilder.toString());
      return this.b;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getEntryMode |  entryModeInMixDaily : ");
    localStringBuilder.append(this.c);
    QLog.d("DailyFeedsDiandianEntranceManager", 1, localStringBuilder.toString());
    return this.c;
  }
  
  public void d()
  {
    PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80094FF", "0X80094FF", 0, 0, "", "", "", e(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.diandian.DailyFeedsDiandianEntranceManager
 * JD-Core Version:    0.7.0.1
 */