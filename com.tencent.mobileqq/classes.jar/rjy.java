import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/reward/RIJRewardTaskConfig;", "", "()V", "CONFIG_KEY_ARTICLE_STATIONARY_TASK_CONSUME_TIME", "", "CONFIG_KEY_ARTICLE_TASK_CONSUME_TIME", "CONFIG_KEY_CONSUME_SINGLE_TASK_TOTAL_TIME", "CONFIG_KEY_CONSUME_TASK_TOTAL_COUNT", "CONFIG_KEY_GUIDE_CONDITION_VIDEO_PROGRESS", "CONFIG_KEY_GUIDE_TIMES_PER_DAY", "CONFIG_KEY_GUIDE_TIMES_PER_PERSON", "CONFIG_KEY_LAST_SHOW_GUIDE_TIMES_STAMPS", "CONFIG_KEY_REWARD_ENABLE", "CONFIG_KEY_REWARD_GUIDE_WORD", "CONFIG_KEY_SEND_COIN_DIALOG_FIRST_BTN_NUM", "CONFIG_KEY_SEND_COIN_DIALOG_HINT", "CONFIG_KEY_SEND_COIN_DIALOG_SECOND_BTN_NUM", "CONFIG_KEY_SEND_COIN_SUCCESS_ANIM_ENABLE", "CONFIG_KEY_SEND_COIN_SUCCESS_TIPS", "CONFIG_KEY_SEND_COIN_TWO_BTN_ANIM", "CONFIG_KEY_TODAY_SHOW_GUIDE_TIMES", "CONFIG_KEY_TOTAL_SHOW_GUIDE_TIMES", "DEFAULT_GUIDE_CONDITION_VIDEO_PROGRESS", "", "DEFAULT_GUIDE_TIMES_PER_DAY", "", "DEFAULT_GUIDE_TIMES_PER_PERSON", "DEFAULT_MAX_TASK_TIME_FOR_ARTICLE_IN_SEC", "DEFAULT_MAX_TASK_TIME_FOR_ARTICLE_STATIONARY_IN_SEC", "DEFAULT_MISSION_COMPLETED_TIME_IN_MIN", "DEFAULT_MISSION_COUNT_DAILY", "DEFAULT_REWARD_GUIDE_WORD", "DEFAULT_SEND_COIN_DIALOG_FIRST_BTN_NUM", "DEFAULT_SEND_COIN_DIALOG_HINT", "DEFAULT_SEND_COIN_DIALOG_SECOND_BTN_NUM", "DEFAULT_SEND_COIN_SUCCESS_TIPS", "TAG", "aladdinConfig", "Lcom/tencent/aladdin/config/AladdinConfig;", "getAladdinConfig", "()Lcom/tencent/aladdin/config/AladdinConfig;", "dailyMissionCount", "dailyMissionCount$annotations", "getDailyMissionCount", "()I", "enable", "", "enable$annotations", "getEnable", "()Z", "guideConditionVideoPercent", "getGuideConditionVideoPercent", "()F", "maxTaskTimeForArticleInMs", "maxTaskTimeForArticleInMs$annotations", "getMaxTaskTimeForArticleInMs", "maxTaskTimeWhenArticleStationaryInMs", "maxTaskTimeWhenArticleStationaryInMs$annotations", "getMaxTaskTimeWhenArticleStationaryInMs", "missionCompletedTimeInMs", "missionCompletedTimeInMs$annotations", "getMissionCompletedTimeInMs", "needShowGuide", "getNeedShowGuide", "rewardCoinDialogFisrtBtnNum", "getRewardCoinDialogFisrtBtnNum", "rewardCoinDialogHint", "getRewardCoinDialogHint", "()Ljava/lang/String;", "rewardCoinDialogSecondBtnNum", "getRewardCoinDialogSecondBtnNum", "rewardCoinGuideWords", "getRewardCoinGuideWords", "rewardDialogBtnAnimEnable", "getRewardDialogBtnAnimEnable", "rewardSuccessAnimEnable", "getRewardSuccessAnimEnable", "rewardSuccessTipsWords", "getRewardSuccessTipsWords", "updateShowGuideConfig", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class rjy
{
  public static final rjy a = new rjy();
  
  public static final int a()
  {
    if (rls.a()) {
      return (int)(a.a().getFloatFromString("consume_single_task_total_time", 30.0F) * 60 * 1000);
    }
    return rle.c();
  }
  
  private final AladdinConfig a()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(372);
    Intrinsics.checkExpressionValueIsNotNull(localAladdinConfig, "Aladdin.getConfig(QQAlad…KANDIAN_COIN_REWARD_TASK)");
    return localAladdinConfig;
  }
  
  public static final boolean a()
  {
    if (rls.a())
    {
      if (a.a().getIntegerFromString("reward_enable", 0) == 1) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        boolean bool2 = bdvn.a();
        boolean bool3 = qgx.a().a(5);
        QLog.i("RIJRewardTaskConfig", 1, "isHighestRewardTaskAuthorityOn: " + bool1 + " ,isStudyMode=" + bool2 + ", userLevelEnable=" + bool3);
        if ((!bool1) || (bool2) || (!bool3)) {
          break;
        }
        return true;
      }
      return false;
    }
    return rle.b();
  }
  
  public static final int b()
  {
    if (rls.a()) {
      return a.a().getIntegerFromString("consume_task_total_count", 1);
    }
    return rle.d();
  }
  
  public static final int c()
  {
    if (rls.a()) {
      return a.a().getIntegerFromString("reward_single_articel_task_consume_time", 40) * 1000;
    }
    return rle.e();
  }
  
  public static final int d()
  {
    if (rls.a()) {
      return a.a().getIntegerFromString("reward_articel_stationary_consume", 3) * 1000;
    }
    return rle.f();
  }
  
  public final float a()
  {
    return a().getFloatFromString("reward_guide_condition_video_progress", 0.8F);
  }
  
  @NotNull
  public final String a()
  {
    String str = a().getString("reward_send_coin_dialog_header_hint", "投喂数量决定视频额外推荐量");
    Intrinsics.checkExpressionValueIsNotNull(str, "aladdinConfig.getString(…LT_SEND_COIN_DIALOG_HINT)");
    return str;
  }
  
  public final void a()
  {
    Integer localInteger1 = (Integer)bmhv.a("total_show_guide_times", Integer.valueOf(0));
    Integer localInteger2 = (Integer)bmhv.a("today_show_guide_times", Integer.valueOf(0));
    bmhv.a("total_show_guide_times", Integer.valueOf(localInteger1.intValue() + 1));
    bmhv.a("today_show_guide_times", Integer.valueOf(localInteger2.intValue() + 1));
    bmhv.a("last_show_guide_times_stamps", Long.valueOf(System.currentTimeMillis()));
  }
  
  @NotNull
  public final String b()
  {
    String str = a().getString("reward_guide_word", "喜欢就喂个月饼吧~ ");
    Intrinsics.checkExpressionValueIsNotNull(str, "aladdinConfig.getString(…EFAULT_REWARD_GUIDE_WORD)");
    return str;
  }
  
  public final boolean b()
  {
    return a().getIntegerFromString("reward_send_coin_dialog_anim", 1) == 1;
  }
  
  @NotNull
  public final String c()
  {
    String str = a().getString("reward_send_coin_success_tips", "感谢支持~ Y(^o^)Y，我会加油的");
    Intrinsics.checkExpressionValueIsNotNull(str, "aladdinConfig.getString(…T_SEND_COIN_SUCCESS_TIPS)");
    return str;
  }
  
  public final boolean c()
  {
    return a().getIntegerFromString("reward_send_coin_dialog_two_btn_anim", 1) == 1;
  }
  
  public final boolean d()
  {
    int i = a().getIntegerFromString("reward_guide_times_per_person", 3);
    Integer localInteger = (Integer)bmhv.a("total_show_guide_times", Integer.valueOf(0));
    if (QLog.isColorLevel()) {
      QLog.d("RIJRewardTaskConfig", 2, "RIJRewardTaskConfig: guideTimesPerPerson=" + i + ", totalShowGuideTimes=" + localInteger);
    }
    if (Intrinsics.compare(localInteger.intValue(), i) >= 0) {
      return false;
    }
    localInteger = (Integer)bmhv.a("last_show_guide_times_stamps", Integer.valueOf(0));
    long l = System.currentTimeMillis();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("RIJRewardTaskConfig: lastShowGuideTime=").append(localInteger).append(", curTime=").append(l).append(", offset=");
      Intrinsics.checkExpressionValueIsNotNull(localInteger, "lastShowGuideTime");
      if (l - localInteger.intValue() <= TimeUnit.DAYS.toMillis(1L)) {
        break label308;
      }
    }
    label308:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("RIJRewardTaskConfig", 2, bool);
      Intrinsics.checkExpressionValueIsNotNull(localInteger, "lastShowGuideTime");
      if (l - localInteger.intValue() > TimeUnit.DAYS.toMillis(1L)) {
        bmhv.a("today_show_guide_times", Integer.valueOf(0));
      }
      localInteger = (Integer)bmhv.a("today_show_guide_times", Integer.valueOf(0));
      i = a().getIntegerFromString("reward_guide_times_per_day", 1);
      if (QLog.isColorLevel()) {
        QLog.d("RIJRewardTaskConfig", 2, "RIJRewardTaskConfig: todayShowGuideTimes=" + localInteger + ", guideTimesPerDay=" + i);
      }
      if (Intrinsics.compare(localInteger.intValue(), i) < 0) {
        break;
      }
      return false;
    }
    return true;
  }
  
  public final int e()
  {
    return a().getIntegerFromString("reward_send_coin_dialog_first_btn_num", 1);
  }
  
  public final int f()
  {
    return a().getIntegerFromString("reward_send_coin_dialog_second_btn_num", 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rjy
 * JD-Core Version:    0.7.0.1
 */