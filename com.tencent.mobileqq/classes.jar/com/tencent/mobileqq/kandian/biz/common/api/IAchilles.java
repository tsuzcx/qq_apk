package com.tencent.mobileqq.kandian.biz.common.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/common/api/IAchilles;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "installIfDownloaded", "", "callBack", "", "packageName", "runtime", "", "installWhenJump2Web", "queryPreDownloadInfoAladdin", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IAchilles
  extends QRouteApi
{
  public abstract boolean installIfDownloaded(@Nullable String paramString1, @Nullable String paramString2, @Nullable Object paramObject, boolean paramBoolean);
  
  @Nullable
  public abstract String queryPreDownloadInfoAladdin(@Nullable String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.api.IAchilles
 * JD-Core Version:    0.7.0.1
 */