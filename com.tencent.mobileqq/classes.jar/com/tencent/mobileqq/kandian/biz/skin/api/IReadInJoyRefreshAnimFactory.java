package com.tencent.mobileqq.kandian.biz.skin.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.widget.pull2refresh.anim.IAnimManager;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/skin/api/IReadInJoyRefreshAnimFactory;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getAnimManger", "Lcom/tencent/widget/pull2refresh/anim/IAnimManager;", "context", "Landroid/content/Context;", "animType", "", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReadInJoyRefreshAnimFactory
  extends QRouteApi
{
  @Nullable
  public abstract IAnimManager getAnimManger(@Nullable Context paramContext, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.api.IReadInJoyRefreshAnimFactory
 * JD-Core Version:    0.7.0.1
 */