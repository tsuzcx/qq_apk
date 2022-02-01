package com.tencent.mobileqq.profile.vote;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.LikeRankingListActivity;
import com.tencent.mobileqq.flutter.router.PageRouterBuilder;
import com.tencent.mobileqq.flutter.router.QFlutterPageRouter;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public class LikeRankingUtil
{
  public static final void a(Activity paramActivity, boolean paramBoolean)
  {
    QLog.d("", 1, String.format("openLikeRankingList flutterPage=%b", new Object[] { Boolean.valueOf(paramBoolean) }));
    if (paramBoolean)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("kUin", BaseApplicationImpl.getApplication().getRuntime().getAccount());
      QFlutterPageRouter.a(paramActivity, new PageRouterBuilder().a("zanLeaderboardSetting").b("ZanLeaderboardPage").a(localHashMap).b(true).c(false).a(), 1024);
      return;
    }
    paramActivity.startActivity(new Intent(paramActivity, LikeRankingListActivity.class));
  }
  
  public static final void a(Context paramContext, String paramString)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((!TextUtils.isEmpty(paramString)) && (localObject != null))
    {
      if (paramString.equals(((AppRuntime)localObject).getAccount())) {
        localObject = "1";
      } else {
        localObject = "2";
      }
      ReportController.b(null, "dc00898", "", "", "0X8007616", "0X8007616", 0, 0, (String)localObject, "", "", "");
      ProfileUtils.openProfileCard(paramContext, new AllInOne(paramString, 1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.vote.LikeRankingUtil
 * JD-Core Version:    0.7.0.1
 */