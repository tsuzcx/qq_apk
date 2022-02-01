package com.tencent.mobileqq.kandian.biz.hippy.api.impl;

import com.tencent.mobileqq.kandian.biz.hippy.api.ITKDHippyBridge;
import com.tencent.mobileqq.kandian.biz.hippy.entity.AccountInfo;
import com.tencent.mobileqq.kandian.biz.hippy.module.TKDAccountModule;
import com.tencent.mobileqq.kandian.biz.hippy.module.TKDDeviceModule;
import com.tencent.mobileqq.kandian.biz.hippy.provider.NSHippyProvider;
import com.tencent.mobileqq.kandian.biz.hippy.provider.TKDApiProvider;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.modules.Promise;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/hippy/api/impl/TKDHippyBridgeImpl;", "Lcom/tencent/mobileqq/kandian/biz/hippy/api/ITKDHippyBridge;", "()V", "getAccountInfo", "", "promise", "Lcom/tencent/mtt/hippy/modules/Promise;", "getCurAccountInfo", "Lcom/tencent/mobileqq/kandian/biz/hippy/entity/AccountInfo;", "getDeviceInfo", "getNSHippyProvider", "Lcom/tencent/mtt/hippy/HippyAPIProvider;", "getTKDApiProvider", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class TKDHippyBridgeImpl
  implements ITKDHippyBridge
{
  public void getAccountInfo(@Nullable Promise paramPromise)
  {
    if (paramPromise != null) {
      paramPromise.resolve(TKDAccountModule.convertAccountInfo2HippyMap(TKDAccountModule.getCurAccountInfo()));
    }
  }
  
  @NotNull
  public AccountInfo getCurAccountInfo()
  {
    AccountInfo localAccountInfo = TKDAccountModule.getCurAccountInfo();
    Intrinsics.checkExpressionValueIsNotNull(localAccountInfo, "TKDAccountModule.getCurAccountInfo()");
    return localAccountInfo;
  }
  
  public void getDeviceInfo(@Nullable Promise paramPromise)
  {
    if (paramPromise != null) {
      paramPromise.resolve(TKDDeviceModule.getDeviceInfo());
    }
  }
  
  @NotNull
  public HippyAPIProvider getNSHippyProvider()
  {
    return (HippyAPIProvider)new NSHippyProvider();
  }
  
  @NotNull
  public HippyAPIProvider getTKDApiProvider()
  {
    return (HippyAPIProvider)new TKDApiProvider();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.api.impl.TKDHippyBridgeImpl
 * JD-Core Version:    0.7.0.1
 */