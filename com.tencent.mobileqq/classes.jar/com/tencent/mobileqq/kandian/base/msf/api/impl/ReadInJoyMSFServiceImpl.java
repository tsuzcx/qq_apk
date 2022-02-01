package com.tencent.mobileqq.kandian.base.msf.api.impl;

import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.msf.api.IReadInJoyMSFService;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/msf/api/impl/ReadInJoyMSFServiceImpl;", "Lcom/tencent/mobileqq/kandian/base/msf/api/IReadInJoyMSFService;", "()V", "handleRequest", "", "request", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "handleResponse", "success", "", "req", "resp", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "ex", "Ljava/lang/Exception;", "Lkotlin/Exception;", "unInitialize", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyMSFServiceImpl
  implements IReadInJoyMSFService
{
  public ReadInJoyMSFServiceImpl()
  {
    ReadInJoyMSFService localReadInJoyMSFService = ReadInJoyMSFService.getInstance();
    Intrinsics.checkExpressionValueIsNotNull(localReadInJoyMSFService, "ReadInJoyMSFService.getInstance()");
    this.$$delegate_0 = localReadInJoyMSFService;
  }
  
  public void handleRequest(@Nullable ToServiceMsg paramToServiceMsg)
  {
    this.$$delegate_0.handleRequest(paramToServiceMsg);
  }
  
  public void handleResponse(boolean paramBoolean, @Nullable ToServiceMsg paramToServiceMsg, @Nullable FromServiceMsg paramFromServiceMsg, @Nullable Exception paramException)
  {
    this.$$delegate_0.handleResponse(paramBoolean, paramToServiceMsg, paramFromServiceMsg, paramException);
  }
  
  public void unInitialize()
  {
    this.$$delegate_0.unInitialize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.msf.api.impl.ReadInJoyMSFServiceImpl
 * JD-Core Version:    0.7.0.1
 */