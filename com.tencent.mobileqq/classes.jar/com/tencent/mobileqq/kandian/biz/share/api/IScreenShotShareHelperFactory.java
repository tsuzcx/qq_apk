package com.tencent.mobileqq.kandian.biz.share.api;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/share/api/IScreenShotShareHelperFactory;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "createScreenShotShareHelper", "Lcom/tencent/mobileqq/kandian/biz/share/api/IScreenShotShareHelper;", "activity", "Landroid/app/Activity;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IScreenShotShareHelperFactory
  extends QRouteApi
{
  @NotNull
  public abstract IScreenShotShareHelper createScreenShotShareHelper(@NotNull Activity paramActivity);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.api.IScreenShotShareHelperFactory
 * JD-Core Version:    0.7.0.1
 */