package com.tencent.mobileqq.kandian.biz.reward;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/reward/RIJVideoRewardCoinManager$Companion;", "", "()V", "ERROR_CODE_COIN_INSUFFICEINT", "", "INDEX_FIRST_ITEM", "INDEX_SECOND_ITEM", "MSG_COIN_INSUFFICEINT", "", "MSG_REWARD_DUPLICATE", "MSG_REWARD_FAIL", "MSG_REWARD_SUCCESS", "SCENE_ARTICLE_BOTTOM_BAR", "SCENE_ARTICLE_CONTENT", "SCENE_VIDEO_THREE_NATIVE", "SCENE_VIDEO_THREE_VIOLA", "TAG", "URL_MINE_COIN_PAGE", "URL_MULTI_COIN_ANIM", "URL_ONE_COIN_ANIM", "getRewardCoinCount", "index", "report", "", "bigT", "reportData", "Lcom/tencent/mobileqq/kandian/biz/reward/RIJVideoRewardCoinManager$RIJRewardData;", "sceneType", "showHasCoined", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJVideoRewardCoinManager$Companion
{
  public final int a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return 0;
      }
      return RIJRewardTaskConfig.a.f();
    }
    return RIJRewardTaskConfig.a.e();
  }
  
  public final void a()
  {
    QQToast.a((Context)BaseApplicationImpl.getContext(), (CharSequence)HardCodeUtil.a(2131718310), 0).a();
  }
  
  public final void a(@NotNull String paramString, @Nullable RIJVideoRewardCoinManager.RIJRewardData paramRIJRewardData, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "bigT");
    if (paramRIJRewardData != null)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("status", paramRIJRewardData.a());
        localJSONObject.put("rowkey", paramRIJRewardData.a());
        localJSONObject.put("video_mode", paramInt);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", paramString, paramString, 0, 0, paramRIJRewardData.a(), "", "", localJSONObject.toString(), false);
        return;
      }
      catch (Exception paramString)
      {
        paramRIJRewardData = new StringBuilder();
        paramRIJRewardData.append("report error, msg =");
        paramRIJRewardData.append(paramString);
        QLog.d("RIJVideoRewardCoinManager", 1, paramRIJRewardData.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.RIJVideoRewardCoinManager.Companion
 * JD-Core Version:    0.7.0.1
 */