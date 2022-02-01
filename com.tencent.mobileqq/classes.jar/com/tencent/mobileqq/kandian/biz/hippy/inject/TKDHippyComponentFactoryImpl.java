package com.tencent.mobileqq.kandian.biz.hippy.inject;

import com.tencent.hippy.qq.api.IHippyComponentFactory;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.biz.hippy.provider.TKDApiProvider;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.uimanager.HippyCustomViewCreator;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/hippy/inject/TKDHippyComponentFactoryImpl;", "Lcom/tencent/hippy/qq/api/IHippyComponentFactory;", "()V", "getApiProvider", "Lcom/tencent/mtt/hippy/HippyAPIProvider;", "getViewCreator", "Lcom/tencent/mtt/hippy/uimanager/HippyCustomViewCreator;", "matchName", "", "module", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class TKDHippyComponentFactoryImpl
  implements IHippyComponentFactory
{
  @NotNull
  public HippyAPIProvider getApiProvider()
  {
    return (HippyAPIProvider)new TKDApiProvider();
  }
  
  @NotNull
  public HippyCustomViewCreator getViewCreator()
  {
    Object localObject = ((IRIJAdService)QRoute.api(IRIJAdService.class)).createHippyCustomViewCreator();
    if (localObject != null)
    {
      localObject = (HippyCustomViewCreator)localObject;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      return localObject;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mtt.hippy.uimanager.HippyCustomViewCreator");
  }
  
  public boolean matchName(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "module");
    return StringsKt.startsWith$default(paramString, "tkd", false, 2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.inject.TKDHippyComponentFactoryImpl
 * JD-Core Version:    0.7.0.1
 */