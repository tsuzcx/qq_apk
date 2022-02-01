package com.tencent.mobileqq.kandian.biz.reward.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/reward/api/IRIJAidlClient;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "bindService", "", "context", "Landroid/content/Context;", "unbindService", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IRIJAidlClient
  extends QRouteApi
{
  public abstract void bindService(@NotNull Context paramContext);
  
  public abstract void unbindService(@NotNull Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.api.IRIJAidlClient
 * JD-Core Version:    0.7.0.1
 */