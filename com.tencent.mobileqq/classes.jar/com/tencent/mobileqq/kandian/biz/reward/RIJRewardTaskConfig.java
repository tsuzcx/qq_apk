package com.tencent.mobileqq.kandian.biz.reward;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.reward.aidl.RIJAidlClientRedPacketModule;
import com.tencent.mobileqq.kandian.biz.reward.utils.Utils;
import com.tencent.mobileqq.kandian.repo.account.RIJUserLevelModule;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/reward/RIJRewardTaskConfig;", "", "()V", "CONFIG_KEY_ARTICLE_STATIONARY_TASK_CONSUME_TIME", "", "CONFIG_KEY_ARTICLE_TASK_CONSUME_TIME", "CONFIG_KEY_CONSUME_SINGLE_TASK_TOTAL_TIME", "CONFIG_KEY_CONSUME_TASK_TOTAL_COUNT", "CONFIG_KEY_GUIDE_CONDITION_VIDEO_PROGRESS", "CONFIG_KEY_GUIDE_TIMES_PER_DAY", "CONFIG_KEY_GUIDE_TIMES_PER_PERSON", "CONFIG_KEY_LAST_SHOW_GUIDE_TIMES_STAMPS", "CONFIG_KEY_REWARD_ENABLE", "CONFIG_KEY_REWARD_GUIDE_WORD", "CONFIG_KEY_REWARD_SEND_ONE_COIN_TEXT", "CONFIG_KEY_REWARD_SEND_ONE_COIN_TEXT_WHITE", "CONFIG_KEY_REWARD_SEND_THREE_COIN_TEXT", "CONFIG_KEY_REWARD_SEND_THREE_COIN_TEXT_WHITE", "CONFIG_KEY_SEND_COIN_DIALOG_FIRST_BTN_NUM", "CONFIG_KEY_SEND_COIN_DIALOG_HINT", "CONFIG_KEY_SEND_COIN_DIALOG_SECOND_BTN_NUM", "CONFIG_KEY_SEND_COIN_SUCCESS_ANIM_ENABLE", "CONFIG_KEY_SEND_COIN_SUCCESS_TIPS", "CONFIG_KEY_SEND_COIN_TWO_BTN_ANIM", "CONFIG_KEY_TODAY_SHOW_GUIDE_TIMES", "CONFIG_KEY_TOTAL_SHOW_GUIDE_TIMES", "DEFAULT_GUIDE_CONDITION_VIDEO_PROGRESS", "", "DEFAULT_GUIDE_TIMES_PER_DAY", "", "DEFAULT_GUIDE_TIMES_PER_PERSON", "DEFAULT_MAX_TASK_TIME_FOR_ARTICLE_IN_SEC", "DEFAULT_MAX_TASK_TIME_FOR_ARTICLE_STATIONARY_IN_SEC", "DEFAULT_MISSION_COMPLETED_TIME_IN_MIN", "DEFAULT_MISSION_COUNT_DAILY", "DEFAULT_REWARD_GUIDE_WORD", "DEFAULT_SEND_COIN_DIALOG_FIRST_BTN_NUM", "DEFAULT_SEND_COIN_DIALOG_HINT", "DEFAULT_SEND_COIN_DIALOG_SECOND_BTN_NUM", "DEFAULT_SEND_COIN_SUCCESS_TIPS", "TAG", "aladdinConfig", "Lcom/tencent/aladdin/config/AladdinConfig;", "getAladdinConfig", "()Lcom/tencent/aladdin/config/AladdinConfig;", "dailyMissionCount", "dailyMissionCount$annotations", "getDailyMissionCount", "()I", "enable", "", "enable$annotations", "getEnable", "()Z", "guideConditionVideoPercent", "getGuideConditionVideoPercent", "()F", "maxTaskTimeForArticleInMs", "maxTaskTimeForArticleInMs$annotations", "getMaxTaskTimeForArticleInMs", "maxTaskTimeWhenArticleStationaryInMs", "maxTaskTimeWhenArticleStationaryInMs$annotations", "getMaxTaskTimeWhenArticleStationaryInMs", "missionCompletedTimeInMs", "missionCompletedTimeInMs$annotations", "getMissionCompletedTimeInMs", "needShowGuide", "getNeedShowGuide", "rewardCoinDialogFisrtBtnNum", "getRewardCoinDialogFisrtBtnNum", "rewardCoinDialogHint", "getRewardCoinDialogHint", "()Ljava/lang/String;", "rewardCoinDialogSecondBtnNum", "getRewardCoinDialogSecondBtnNum", "rewardCoinGuideWords", "getRewardCoinGuideWords", "rewardDialogBtnAnimEnable", "getRewardDialogBtnAnimEnable", "rewardOneCoinTextUrl", "getRewardOneCoinTextUrl", "rewardOneCoinTextWhiteUrl", "getRewardOneCoinTextWhiteUrl", "rewardSuccessAnimEnable", "getRewardSuccessAnimEnable", "rewardSuccessTipsWords", "getRewardSuccessTipsWords", "rewardThreeCoinTextUrl", "getRewardThreeCoinTextUrl", "rewardThreeCoinTextWhiteUrl", "getRewardThreeCoinTextWhiteUrl", "updateShowGuideConfig", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJRewardTaskConfig
{
  public static final RIJRewardTaskConfig a = new RIJRewardTaskConfig();
  
  public static final boolean a()
  {
    boolean bool1 = Utils.a();
    boolean bool3 = false;
    boolean bool2;
    if (bool1)
    {
      if (a.t().getIntegerFromString("reward_enable", 0) == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      boolean bool4 = StudyModeManager.h();
      boolean bool5 = RIJUserLevelModule.getInstance().getCacheUserLevel(5);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isHighestRewardTaskAuthorityOn: ");
      localStringBuilder.append(bool1);
      localStringBuilder.append(" ,isStudyMode=");
      localStringBuilder.append(bool4);
      localStringBuilder.append(", userLevelEnable=");
      localStringBuilder.append(bool5);
      QLog.i("RIJRewardTaskConfig", 1, localStringBuilder.toString());
      bool2 = bool3;
      if (bool1)
      {
        bool2 = bool3;
        if (!bool4)
        {
          bool2 = bool3;
          if (bool5) {
            return true;
          }
        }
      }
    }
    else
    {
      bool2 = RIJAidlClientRedPacketModule.f();
    }
    return bool2;
  }
  
  public static final int b()
  {
    if (Utils.a()) {
      return (int)(a.t().getFloatFromString("consume_single_task_total_time", 30.0F) * 60 * 1000);
    }
    return RIJAidlClientRedPacketModule.g();
  }
  
  public static final int c()
  {
    if (Utils.a()) {
      return a.t().getIntegerFromString("consume_task_total_count", 1);
    }
    return RIJAidlClientRedPacketModule.h();
  }
  
  public static final int d()
  {
    if (Utils.a()) {
      return a.t().getIntegerFromString("reward_single_articel_task_consume_time", 40) * 1000;
    }
    return RIJAidlClientRedPacketModule.i();
  }
  
  public static final int e()
  {
    if (Utils.a()) {
      return a.t().getIntegerFromString("reward_articel_stationary_consume", 3) * 1000;
    }
    return RIJAidlClientRedPacketModule.j();
  }
  
  private final AladdinConfig t()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(372);
    Intrinsics.checkExpressionValueIsNotNull(localAladdinConfig, "Aladdin.getConfig(QQAlad…KANDIAN_COIN_REWARD_TASK)");
    return localAladdinConfig;
  }
  
  @NotNull
  public final String f()
  {
    String str = t().getString("reward_send_coin_dialog_header_hint", "投币数量决定内容额外推荐量");
    Intrinsics.checkExpressionValueIsNotNull(str, "aladdinConfig.getString(…LT_SEND_COIN_DIALOG_HINT)");
    return str;
  }
  
  public final int g()
  {
    return t().getIntegerFromString("reward_send_coin_dialog_first_btn_num", 1);
  }
  
  public final int h()
  {
    return t().getIntegerFromString("reward_send_coin_dialog_second_btn_num", 3);
  }
  
  public final float i()
  {
    return t().getFloatFromString("reward_guide_condition_video_progress", 0.8F);
  }
  
  @NotNull
  public final String j()
  {
    String str = t().getString("reward_guide_word", "喜欢就投个硬币吧~ ");
    Intrinsics.checkExpressionValueIsNotNull(str, "aladdinConfig.getString(…EFAULT_REWARD_GUIDE_WORD)");
    return str;
  }
  
  @NotNull
  public final String k()
  {
    String str = t().getString("reward_send_coin_success_tips", "感谢支持~ Y(^o^)Y，我会加油的");
    Intrinsics.checkExpressionValueIsNotNull(str, "aladdinConfig.getString(…T_SEND_COIN_SUCCESS_TIPS)");
    return str;
  }
  
  public final boolean l()
  {
    return t().getIntegerFromString("reward_send_coin_dialog_anim", 1) == 1;
  }
  
  public final boolean m()
  {
    return t().getIntegerFromString("reward_send_coin_dialog_two_btn_anim", 1) == 1;
  }
  
  @NotNull
  public final String n()
  {
    String str = t().getString("reward_send_one_coin_text", "");
    Intrinsics.checkExpressionValueIsNotNull(str, "aladdinConfig.getString(…D_SEND_ONE_COIN_TEXT, \"\")");
    return str;
  }
  
  @NotNull
  public final String o()
  {
    String str = t().getString("reward_send_three_coin_text", "");
    Intrinsics.checkExpressionValueIsNotNull(str, "aladdinConfig.getString(…SEND_THREE_COIN_TEXT, \"\")");
    return str;
  }
  
  @NotNull
  public final String p()
  {
    String str = t().getString("reward_send_one_coin_text_white", "");
    Intrinsics.checkExpressionValueIsNotNull(str, "aladdinConfig.getString(…_ONE_COIN_TEXT_WHITE, \"\")");
    return str;
  }
  
  @NotNull
  public final String q()
  {
    String str = t().getString("reward_send_three_coin_text_white", "");
    Intrinsics.checkExpressionValueIsNotNull(str, "aladdinConfig.getString(…HREE_COIN_TEXT_WHITE, \"\")");
    return str;
  }
  
  public final boolean r()
  {
    int i = t().getIntegerFromString("reward_guide_times_per_person", 3);
    Integer localInteger = Integer.valueOf(0);
    Object localObject = (Integer)RIJSPUtils.b("total_show_guide_times", localInteger);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("RIJRewardTaskConfig: guideTimesPerPerson=");
      localStringBuilder.append(i);
      localStringBuilder.append(", totalShowGuideTimes=");
      localStringBuilder.append(localObject);
      QLog.d("RIJRewardTaskConfig", 2, localStringBuilder.toString());
    }
    if (Intrinsics.compare(((Integer)localObject).intValue(), i) >= 0) {
      return false;
    }
    localObject = (Integer)RIJSPUtils.b("last_show_guide_times_stamps", localInteger);
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("RIJRewardTaskConfig: lastShowGuideTime=");
      localStringBuilder.append(localObject);
      localStringBuilder.append(", curTime=");
      localStringBuilder.append(l);
      localStringBuilder.append(", offset=");
      Intrinsics.checkExpressionValueIsNotNull(localObject, "lastShowGuideTime");
      boolean bool;
      if (l - ((Integer)localObject).intValue() > TimeUnit.DAYS.toMillis(1L)) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      QLog.d("RIJRewardTaskConfig", 2, localStringBuilder.toString());
    }
    Intrinsics.checkExpressionValueIsNotNull(localObject, "lastShowGuideTime");
    if (l - ((Integer)localObject).intValue() > TimeUnit.DAYS.toMillis(1L)) {
      RIJSPUtils.a("today_show_guide_times", localInteger);
    }
    localInteger = (Integer)RIJSPUtils.b("today_show_guide_times", localInteger);
    i = t().getIntegerFromString("reward_guide_times_per_day", 1);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("RIJRewardTaskConfig: todayShowGuideTimes=");
      ((StringBuilder)localObject).append(localInteger);
      ((StringBuilder)localObject).append(", guideTimesPerDay=");
      ((StringBuilder)localObject).append(i);
      QLog.d("RIJRewardTaskConfig", 2, ((StringBuilder)localObject).toString());
    }
    return Intrinsics.compare(localInteger.intValue(), i) < 0;
  }
  
  public final void s()
  {
    Integer localInteger2 = Integer.valueOf(0);
    Integer localInteger1 = (Integer)RIJSPUtils.b("total_show_guide_times", localInteger2);
    localInteger2 = (Integer)RIJSPUtils.b("today_show_guide_times", localInteger2);
    RIJSPUtils.a("total_show_guide_times", Integer.valueOf(localInteger1.intValue() + 1));
    RIJSPUtils.a("today_show_guide_times", Integer.valueOf(localInteger2.intValue() + 1));
    RIJSPUtils.a("last_show_guide_times_stamps", Long.valueOf(System.currentTimeMillis()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.RIJRewardTaskConfig
 * JD-Core Version:    0.7.0.1
 */