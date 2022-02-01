package com.tencent.mobileqq.kandian.glue.businesshandler.api.impl;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.glue.businesshandler.api.IKandianSubscribeManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianSubscribeManager;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/businesshandler/api/impl/KandianSubscribeManagerImpl;", "Lcom/tencent/mobileqq/kandian/glue/businesshandler/api/IKandianSubscribeManager;", "()V", "manager", "Lcom/tencent/mobileqq/kandian/glue/businesshandler/engine/KandianSubscribeManager;", "getAggregateAvate", "Landroid/graphics/drawable/Drawable;", "oriIcon", "app", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "getMessageObserver", "Lcom/tencent/mobileqq/app/BusinessObserver;", "lanuchKandianSubscribeActivity", "", "context", "Landroid/content/Context;", "enterType", "", "launchFrom", "onCreate", "appRuntime", "Lmqq/app/AppRuntime;", "onDestroy", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class KandianSubscribeManagerImpl
  implements IKandianSubscribeManager
{
  private KandianSubscribeManager manager;
  
  @Nullable
  public Drawable getAggregateAvate(@Nullable Drawable paramDrawable, @NotNull BaseQQAppInterface paramBaseQQAppInterface)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseQQAppInterface, "app");
    return KandianSubscribeManager.a(paramDrawable, paramBaseQQAppInterface);
  }
  
  @NotNull
  public BusinessObserver getMessageObserver()
  {
    Object localObject = this.manager;
    if (localObject != null) {
      localObject = ((KandianSubscribeManager)localObject).a();
    } else {
      localObject = null;
    }
    if (localObject != null) {
      return (BusinessObserver)localObject;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.BusinessObserver");
  }
  
  public void lanuchKandianSubscribeActivity(@NotNull Context paramContext, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    KandianSubscribeManager.a(paramContext, paramInt);
  }
  
  public void lanuchKandianSubscribeActivity(@NotNull Context paramContext, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    KandianSubscribeManager.a(paramContext, paramInt1, paramInt2);
  }
  
  public void onCreate(@NotNull AppRuntime paramAppRuntime)
  {
    Intrinsics.checkParameterIsNotNull(paramAppRuntime, "appRuntime");
    Manager localManager = paramAppRuntime.getManager(QQManagerFactory.KANDIAN_SUBSCRIBE_MANAGER);
    paramAppRuntime = localManager;
    if (!(localManager instanceof KandianSubscribeManager)) {
      paramAppRuntime = null;
    }
    this.manager = ((KandianSubscribeManager)paramAppRuntime);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.api.impl.KandianSubscribeManagerImpl
 * JD-Core Version:    0.7.0.1
 */