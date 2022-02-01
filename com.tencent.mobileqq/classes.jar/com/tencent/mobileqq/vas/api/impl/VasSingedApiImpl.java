package com.tencent.mobileqq.vas.api.impl;

import com.tencent.mobileqq.vas.api.IVasManager;
import com.tencent.mobileqq.vas.api.IVasSingedApi;
import com.tencent.mobileqq.vas.api.RemoteProxy;
import com.tencent.mobileqq.vas.floatscreen.ColorScreenManagerImpl;
import com.tencent.mobileqq.vip.IVipStatusManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/api/impl/VasSingedApiImpl;", "Lcom/tencent/mobileqq/vas/api/IVasSingedApi;", "()V", "colorScreen", "Lcom/tencent/mobileqq/vas/floatscreen/ColorScreenManagerImpl;", "getColorScreen", "()Lcom/tencent/mobileqq/vas/floatscreen/ColorScreenManagerImpl;", "colorScreen$delegate", "Lkotlin/Lazy;", "vipStatus", "Lcom/tencent/mobileqq/vip/IVipStatusManager;", "getVipStatus", "()Lcom/tencent/mobileqq/vip/IVipStatusManager;", "vipStatus$delegate", "dynamicCall", "T", "Lcom/tencent/mobileqq/vas/api/IVasManager;", "impl", "", "(Ljava/lang/Object;)Lcom/tencent/mobileqq/vas/api/IVasManager;", "onCreate", "", "appRuntime", "Lmqq/app/AppRuntime;", "onDestroy", "Companion", "vas-impl_release"}, k=1, mv={1, 1, 16})
public final class VasSingedApiImpl
  implements IVasSingedApi
{
  public static final VasSingedApiImpl.Companion Companion = new VasSingedApiImpl.Companion(null);
  private static final String MAIN_PROCESS_NAME;
  private static final String PROCESS_NAME = MobileQQ.processName;
  @NotNull
  public static final String TAG = "VasSingedApiImpl";
  @NotNull
  private final Lazy colorScreen$delegate = LazyKt.lazy((Function0)VasSingedApiImpl.colorScreen.2.INSTANCE);
  @NotNull
  private final Lazy vipStatus$delegate = LazyKt.lazy((Function0)new VasSingedApiImpl.vipStatus.2(this));
  
  static
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localBaseApplication, "BaseApplication.getContext()");
    MAIN_PROCESS_NAME = localBaseApplication.getPackageName();
  }
  
  private final <T extends IVasManager> T dynamicCall(Object paramObject)
  {
    paramObject = RemoteProxy.a(paramObject.getClass());
    if (paramObject != null) {
      return (IVasManager)paramObject;
    }
    throw new TypeCastException("null cannot be cast to non-null type T");
  }
  
  @NotNull
  public ColorScreenManagerImpl getColorScreen()
  {
    return (ColorScreenManagerImpl)this.colorScreen$delegate.getValue();
  }
  
  @NotNull
  public IVipStatusManager getVipStatus()
  {
    return (IVipStatusManager)this.vipStatus$delegate.getValue();
  }
  
  public void onCreate(@NotNull AppRuntime paramAppRuntime)
  {
    Intrinsics.checkParameterIsNotNull(paramAppRuntime, "appRuntime");
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("onCreate on ");
    paramAppRuntime.append(PROCESS_NAME);
    QLog.i("VasSingedApiImpl", 1, paramAppRuntime.toString());
  }
  
  public void onDestroy()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDestroy on ");
    localStringBuilder.append(PROCESS_NAME);
    QLog.i("VasSingedApiImpl", 1, localStringBuilder.toString());
    getColorScreen().onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.api.impl.VasSingedApiImpl
 * JD-Core Version:    0.7.0.1
 */