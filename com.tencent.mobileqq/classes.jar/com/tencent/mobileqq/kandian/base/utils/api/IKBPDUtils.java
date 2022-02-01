package com.tencent.mobileqq.kandian.base.utils.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/utils/api/IKBPDUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "queryKBPreDownloadInfo", "", "appRuntime", "Lmqq/app/AppRuntime;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IKBPDUtils
  extends QRouteApi
{
  @Nullable
  public abstract String queryKBPreDownloadInfo(@Nullable AppRuntime paramAppRuntime);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.api.IKBPDUtils
 * JD-Core Version:    0.7.0.1
 */