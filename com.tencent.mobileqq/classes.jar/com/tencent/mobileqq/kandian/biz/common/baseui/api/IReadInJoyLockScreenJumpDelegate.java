package com.tencent.mobileqq.kandian.biz.common.baseui.api;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.kandian.repo.feeds.entity.KandianRedDotInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/common/baseui/api/IReadInJoyLockScreenJumpDelegate;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getJumpDailyFragmentIntent", "Landroid/content/Intent;", "ctx", "Landroid/content/Context;", "launchFrom", "", "redDotInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/KandianRedDotInfo;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReadInJoyLockScreenJumpDelegate
  extends QRouteApi
{
  @NotNull
  public abstract Intent getJumpDailyFragmentIntent(@Nullable Context paramContext, int paramInt, @Nullable KandianRedDotInfo paramKandianRedDotInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.baseui.api.IReadInJoyLockScreenJumpDelegate
 * JD-Core Version:    0.7.0.1
 */