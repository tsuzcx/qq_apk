package com.tencent.mobileqq.kandian.biz.diandian;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.daily.ReadInJoyDailyViewController;
import com.tencent.mobileqq.kandian.glue.report.KandianDailyReportUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.common.RIJShowKanDianTabSp;
import com.tencent.mobileqq.kandian.repo.diandian.IEntranceButtonDataSource;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class DailyFeedsDiandianEntranceManager
{
  private static DailyFeedsDiandianEntranceManager jdField_a_of_type_ComTencentMobileqqKandianBizDiandianDailyFeedsDiandianEntranceManager;
  private int jdField_a_of_type_Int = 0;
  private int b = 0;
  
  private DailyFeedsDiandianEntranceManager()
  {
    Object localObject = Aladdin.getConfig(218);
    if (localObject != null)
    {
      this.jdField_a_of_type_Int = ((AladdinConfig)localObject).getIntegerFromString("daily_diandian_icon_mode_pure", 0);
      this.b = ((AladdinConfig)localObject).getIntegerFromString("daily_diandian_icon_mode_mix", 0);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Daily entry pure : ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append(", mix : ");
      ((StringBuilder)localObject).append(this.b);
      QLog.d("DailyFeedsDiandianEntranceManager", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public static DailyFeedsDiandianEntranceManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqKandianBizDiandianDailyFeedsDiandianEntranceManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqKandianBizDiandianDailyFeedsDiandianEntranceManager == null) {
          jdField_a_of_type_ComTencentMobileqqKandianBizDiandianDailyFeedsDiandianEntranceManager = new DailyFeedsDiandianEntranceManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqKandianBizDiandianDailyFeedsDiandianEntranceManager;
  }
  
  public static IEntranceButtonDataSource a(Bundle paramBundle)
  {
    paramBundle = paramBundle.getParcelable("daily_bottom_entry_data");
    if ((paramBundle instanceof IEntranceButtonDataSource)) {
      return (IEntranceButtonDataSource)paramBundle;
    }
    return null;
  }
  
  private String a()
  {
    int i = a();
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
      ((JSONObject)localObject).put("channel_id", KandianDailyReportUtils.b());
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  public static boolean a(Bundle paramBundle)
  {
    return paramBundle.containsKey("daily_bottom_entry_data");
  }
  
  public int a()
  {
    if (!RIJShowKanDianTabSp.c())
    {
      QLog.d("DailyFeedsDiandianEntranceManager", 1, "getEntryMode | hide mode");
      return 0;
    }
    if (DailyModeConfigHandler.a(DailyModeConfigHandler.b()))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getEntryMode |  entryModeInNormalDaily : ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.d("DailyFeedsDiandianEntranceManager", 1, localStringBuilder.toString());
      return this.jdField_a_of_type_Int;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getEntryMode |  entryModeInMixDaily : ");
    localStringBuilder.append(this.b);
    QLog.d("DailyFeedsDiandianEntranceManager", 1, localStringBuilder.toString());
    return this.b;
  }
  
  public View.OnClickListener a(Activity paramActivity, View paramView, ReadInJoyDailyViewController paramReadInJoyDailyViewController)
  {
    int i = a();
    if (i != 0)
    {
      if (i != 2)
      {
        if (i != 3) {
          return new DailyFeedsDiandianEntranceManager.3(this, paramActivity);
        }
        return new DailyFeedsDiandianEntranceManager.1(this, paramReadInJoyDailyViewController);
      }
      return new DailyFeedsDiandianEntranceManager.2(this, paramActivity);
    }
    return null;
  }
  
  public void a()
  {
    if (a() != 0) {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80094FE", "0X80094FE", 0, 0, "", "", "", a(), false);
    }
  }
  
  public boolean a()
  {
    return a() != 0;
  }
  
  public void b()
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80094FF", "0X80094FF", 0, 0, "", "", "", a(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.diandian.DailyFeedsDiandianEntranceManager
 * JD-Core Version:    0.7.0.1
 */