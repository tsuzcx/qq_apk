package com.tencent.mobileqq.kandian.base.msf.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/msf/api/IReadInJoyMSFService;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "handleRequest", "", "request", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "handleResponse", "success", "", "req", "resp", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "ex", "Ljava/lang/Exception;", "Lkotlin/Exception;", "unInitialize", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReadInJoyMSFService
  extends QRouteApi
{
  public abstract void handleRequest(@Nullable ToServiceMsg paramToServiceMsg);
  
  public abstract void handleResponse(boolean paramBoolean, @Nullable ToServiceMsg paramToServiceMsg, @Nullable FromServiceMsg paramFromServiceMsg, @Nullable Exception paramException);
  
  public abstract void unInitialize();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.msf.api.IReadInJoyMSFService
 * JD-Core Version:    0.7.0.1
 */