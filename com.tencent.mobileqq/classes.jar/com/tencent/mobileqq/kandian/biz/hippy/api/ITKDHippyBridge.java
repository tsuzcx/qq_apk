package com.tencent.mobileqq.kandian.biz.hippy.api;

import com.tencent.mobileqq.kandian.biz.hippy.entity.AccountInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.modules.Promise;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/hippy/api/ITKDHippyBridge;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getAccountInfo", "", "promise", "Lcom/tencent/mtt/hippy/modules/Promise;", "getCurAccountInfo", "Lcom/tencent/mobileqq/kandian/biz/hippy/entity/AccountInfo;", "getDeviceInfo", "getNSHippyProvider", "Lcom/tencent/mtt/hippy/HippyAPIProvider;", "getTKDApiProvider", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface ITKDHippyBridge
  extends QRouteApi
{
  public abstract void getAccountInfo(@Nullable Promise paramPromise);
  
  @NotNull
  public abstract AccountInfo getCurAccountInfo();
  
  public abstract void getDeviceInfo(@Nullable Promise paramPromise);
  
  @NotNull
  public abstract HippyAPIProvider getNSHippyProvider();
  
  @NotNull
  public abstract HippyAPIProvider getTKDApiProvider();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.api.ITKDHippyBridge
 * JD-Core Version:    0.7.0.1
 */