package com.tencent.mobileqq.kandian.biz.ugc.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/ugc/api/IRIJUGCDianDian;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getVideoUploadTaskSize", "", "secondClassDeliverOperationReport", "", "tabSource", "", "releaseType", "Companion", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IRIJUGCDianDian
  extends QRouteApi
{
  public static final IRIJUGCDianDian.Companion Companion = IRIJUGCDianDian.Companion.a;
  @NotNull
  public static final String RELEASE_TYPE_VIDEO = "2";
  @NotNull
  public static final String TAG_SOURCE_WEB_TOPIC = "2";
  
  public abstract int getVideoUploadTaskSize();
  
  public abstract void secondClassDeliverOperationReport(@Nullable String paramString1, @Nullable String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.api.IRIJUGCDianDian
 * JD-Core Version:    0.7.0.1
 */