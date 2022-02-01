package com.tencent.mobileqq.vas.api.impl;

import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManagerImpl;
import com.tencent.mobileqq.hiboom.api.impl.HiBoomManagerImpl;
import com.tencent.mobileqq.vas.api.IVasManager;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.api.RemoteProxy;
import com.tencent.mobileqq.vas.manager.api.IKingCardManager;
import com.tencent.mobileqq.vas.manager.api.impl.ThemeSwitchManagerImpl;
import com.tencent.mobileqq.vas.tianshu.ITianshuWebManager;
import com.tencent.mobileqq.vas.treasurecard.api.impl.VasFTManagerImpl;
import com.tencent.mobileqq.vas.vipav.api.IVipFunCallManager;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/api/impl/VasServiceImpl;", "Lcom/tencent/mobileqq/vas/api/IVasService;", "()V", "funCallManager", "Lcom/tencent/mobileqq/vas/vipav/api/IVipFunCallManager;", "getFunCallManager", "()Lcom/tencent/mobileqq/vas/vipav/api/IVipFunCallManager;", "funCallManager$delegate", "Lkotlin/Lazy;", "hiBoomManager", "Lcom/tencent/mobileqq/hiboom/api/impl/HiBoomManagerImpl;", "getHiBoomManager", "()Lcom/tencent/mobileqq/hiboom/api/impl/HiBoomManagerImpl;", "hiBoomManager$delegate", "kingCardManager", "Lcom/tencent/mobileqq/vas/manager/api/IKingCardManager;", "getKingCardManager", "()Lcom/tencent/mobileqq/vas/manager/api/IKingCardManager;", "kingCardManager$delegate", "specialSoundManager", "Lcom/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManagerImpl;", "getSpecialSoundManager", "()Lcom/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManagerImpl;", "specialSoundManager$delegate", "themeSwitchManager", "Lcom/tencent/mobileqq/vas/manager/api/impl/ThemeSwitchManagerImpl;", "getThemeSwitchManager", "()Lcom/tencent/mobileqq/vas/manager/api/impl/ThemeSwitchManagerImpl;", "themeSwitchManager$delegate", "tianshuWebManager", "Lcom/tencent/mobileqq/vas/tianshu/ITianshuWebManager;", "getTianshuWebManager", "()Lcom/tencent/mobileqq/vas/tianshu/ITianshuWebManager;", "tianshuWebManager$delegate", "vasFtManager", "Lcom/tencent/mobileqq/vas/treasurecard/api/impl/VasFTManagerImpl;", "getVasFtManager", "()Lcom/tencent/mobileqq/vas/treasurecard/api/impl/VasFTManagerImpl;", "vasFtManager$delegate", "dynamicCall", "T", "Lcom/tencent/mobileqq/vas/api/IVasManager;", "impl", "", "(Ljava/lang/Object;)Lcom/tencent/mobileqq/vas/api/IVasManager;", "isInMainProcess", "", "onCreate", "", "appRuntime", "Lmqq/app/AppRuntime;", "onDestroy", "Companion", "DynamicProxy", "vas-impl_release"}, k=1, mv={1, 1, 16})
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
  private final Lazy funCallManager$delegate = LazyKt.lazy((Function0)new VasServiceImpl.funCallManager.2(this));
  @NotNull
  private final Lazy hiBoomManager$delegate = LazyKt.lazy((Function0)new VasServiceImpl.hiBoomManager.2(this));
  @NotNull
  private final Lazy kingCardManager$delegate = LazyKt.lazy((Function0)new VasServiceImpl.kingCardManager.2(this));
  @NotNull
  private final Lazy specialSoundManager$delegate = LazyKt.lazy((Function0)VasServiceImpl.specialSoundManager.2.INSTANCE);
  @NotNull
  private final Lazy themeSwitchManager$delegate = LazyKt.lazy((Function0)VasServiceImpl.themeSwitchManager.2.INSTANCE);
  @NotNull
  private final Lazy tianshuWebManager$delegate = LazyKt.lazy((Function0)new VasServiceImpl.tianshuWebManager.2(this));
  @NotNull
  private final Lazy vasFtManager$delegate = LazyKt.lazy((Function0)VasServiceImpl.vasFtManager.2.INSTANCE);
  
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
    if (paramObject != null) {
      return (IVasManager)paramObject;
    }
    throw new TypeCastException("null cannot be cast to non-null type T");
  }
  
  private final boolean isInMainProcess()
  {
    return Intrinsics.areEqual(PROCESS_NAME, MAIN_PROCESS_NAME);
  }
  
  @NotNull
  public IVipFunCallManager getFunCallManager()
  {
    return (IVipFunCallManager)this.funCallManager$delegate.getValue();
  }
  
  @NotNull
  public HiBoomManagerImpl getHiBoomManager()
  {
    return (HiBoomManagerImpl)this.hiBoomManager$delegate.getValue();
  }
  
  @NotNull
  public IKingCardManager getKingCardManager()
  {
    return (IKingCardManager)this.kingCardManager$delegate.getValue();
  }
  
  @NotNull
  public QvipSpecialSoundManagerImpl getSpecialSoundManager()
  {
    return (QvipSpecialSoundManagerImpl)this.specialSoundManager$delegate.getValue();
  }
  
  @NotNull
  public ThemeSwitchManagerImpl getThemeSwitchManager()
  {
    return (ThemeSwitchManagerImpl)this.themeSwitchManager$delegate.getValue();
  }
  
  @NotNull
  public ITianshuWebManager getTianshuWebManager()
  {
    return (ITianshuWebManager)this.tianshuWebManager$delegate.getValue();
  }
  
  @NotNull
  public VasFTManagerImpl getVasFtManager()
  {
    return (VasFTManagerImpl)this.vasFtManager$delegate.getValue();
  }
  
  public void onCreate(@NotNull AppRuntime paramAppRuntime)
  {
    Intrinsics.checkParameterIsNotNull(paramAppRuntime, "appRuntime");
    if (isInMainProcess()) {
      getHiBoomManager().onCreate(paramAppRuntime);
    }
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("onCreate on ");
    paramAppRuntime.append(PROCESS_NAME);
    QLog.i("VasServiceImpl", 1, paramAppRuntime.toString());
  }
  
  public void onDestroy()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDestroy on ");
    localStringBuilder.append(PROCESS_NAME);
    QLog.i("VasServiceImpl", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.api.impl.VasServiceImpl
 * JD-Core Version:    0.7.0.1
 */