package com.tencent.mobileqq.kandian.biz.skin.api;

import android.content.Context;
import com.tencent.mobileqq.kandian.biz.skin.entity.SkinData;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/skin/api/IReadInJoyRefreshManagerService;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getRefreshData", "Lcom/tencent/mobileqq/kandian/biz/skin/entity/SkinData;", "ctx", "Landroid/content/Context;", "source", "", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReadInJoyRefreshManagerService
  extends QRouteApi
{
  @Nullable
  public abstract SkinData getRefreshData(@Nullable Context paramContext, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.api.IReadInJoyRefreshManagerService
 * JD-Core Version:    0.7.0.1
 */