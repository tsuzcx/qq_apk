package com.tencent.mobileqq.vas.api.impl;

import com.tencent.mobileqq.vas.api.IVasManager;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.api.RemoteProxy;
import com.tencent.mobileqq.vas.kingcard.IKingCardManager;
import com.tencent.mobileqq.vas.tianshu.ITianshuWebManager;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/api/impl/VasServiceImpl;", "Lcom/tencent/mobileqq/vas/api/IVasService;", "()V", "kingCardManager", "Lcom/tencent/mobileqq/vas/kingcard/IKingCardManager;", "getKingCardManager", "()Lcom/tencent/mobileqq/vas/kingcard/IKingCardManager;", "kingCardManager$delegate", "Lkotlin/Lazy;", "tianshuWebManager", "Lcom/tencent/mobileqq/vas/tianshu/ITianshuWebManager;", "getTianshuWebManager", "()Lcom/tencent/mobileqq/vas/tianshu/ITianshuWebManager;", "tianshuWebManager$delegate", "dynamicCall", "T", "Lcom/tencent/mobileqq/vas/api/IVasManager;", "impl", "", "(Ljava/lang/Object;)Lcom/tencent/mobileqq/vas/api/IVasManager;", "onCreate", "", "appRuntime", "Lmqq/app/AppRuntime;", "onDestroy", "Companion", "DynamicProxy", "vas-impl_release"}, k=1, mv={1, 1, 16})
public final class VasServiceImpl
  implements IVasService
{
  private static final ClassLoader CLASS_LOADER;
  public static final VasServiceImpl.Companion Companion = new VasServiceImpl.Companion(null);
  private static final String MAIN_PROCESS_NAME;
  private static final String PROCESS_NAME;
  @NotNull
  public static final String TAG = "VasServiceImpl";
  @NotNull
  private final Lazy kingCardManager$delegate = LazyKt.lazy((Function0)new VasServiceImpl.kingCardManager.2(this));
  @NotNull
  private final Lazy tianshuWebManager$delegate = LazyKt.lazy((Function0)new VasServiceImpl.tianshuWebManager.2(this));
  
  static
  {
    Object localObject = BaseApplication.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplication.getContext()");
    MAIN_PROCESS_NAME = ((BaseApplication)localObject).getPackageName();
    PROCESS_NAME = MobileQQ.processName;
    localObject = Companion.getClass().getClassLoader();
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    CLASS_LOADER = (ClassLoader)localObject;
  }
  
  private final <T extends IVasManager> T dynamicCall(Object paramObject)
  {
    paramObject = RemoteProxy.a(paramObject.getClass());
    if (paramObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type T");
    }
    return (IVasManager)paramObject;
  }
  
  @NotNull
  public IKingCardManager getKingCardManager()
  {
    return (IKingCardManager)this.kingCardManager$delegate.getValue();
  }
  
  @NotNull
  public ITianshuWebManager getTianshuWebManager()
  {
    return (ITianshuWebManager)this.tianshuWebManager$delegate.getValue();
  }
  
  public void onCreate(@NotNull AppRuntime paramAppRuntime)
  {
    Intrinsics.checkParameterIsNotNull(paramAppRuntime, "appRuntime");
    QLog.i("VasServiceImpl", 1, "onCreate on " + PROCESS_NAME);
  }
  
  public void onDestroy()
  {
    QLog.i("VasServiceImpl", 1, "onDestroy on " + PROCESS_NAME);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.api.impl.VasServiceImpl
 * JD-Core Version:    0.7.0.1
 */