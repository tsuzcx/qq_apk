package com.tencent.timi.game.expand.hall.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import androidx.annotation.MainThread;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import com.tencent.timi.game.expand.hall.api.ExpandHallLifeCycleListener;
import com.tencent.timi.game.expand.hall.api.IExpandHall;
import com.tencent.timi.game.expand.hall.api.IExpandHallService;
import com.tencent.timi.game.utils.Logger;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/expand/hall/impl/ExpandHallServiceImpl;", "Lcom/tencent/timi/game/expand/hall/api/IExpandHallService;", "()V", "TAG", "", "hall", "Lmqq/util/WeakReference;", "Lcom/tencent/timi/game/expand/hall/api/IExpandHall;", "listenerPool", "Ljava/util/LinkedList;", "Lcom/tencent/timi/game/expand/hall/api/ExpandHallLifeCycleListener;", "destroyHall", "", "getCurrentHall", "hallDestroy", "hallOnCreate", "init", "context", "Landroid/content/Context;", "joinHallRoomFailed", "errorCode", "", "errorMsg", "joinHallRoomSucceed", "roomId", "", "openExpandHall", "param", "Lcom/tencent/timi/game/api/param/ExpandHallLaunchParam;", "registerLifeCycleListener", "lifeCycleListener", "serviceDestroy", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandHallServiceImpl
  implements IExpandHallService
{
  private final String a = "ExpandHallImpl_";
  private WeakReference<IExpandHall> b;
  private final LinkedList<WeakReference<ExpandHallLifeCycleListener>> c = new LinkedList();
  
  @Nullable
  public IExpandHall a()
  {
    WeakReference localWeakReference = this.b;
    if (localWeakReference != null) {
      return (IExpandHall)localWeakReference.get();
    }
    return null;
  }
  
  public void a(int paramInt, @NotNull String paramString, @NotNull IExpandHall paramIExpandHall)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errorMsg");
    Intrinsics.checkParameterIsNotNull(paramIExpandHall, "hall");
    ThreadManagerV2.getUIHandlerV2().post((Runnable)new ExpandHallServiceImpl.joinHallRoomFailed.1(this, paramInt, paramString, paramIExpandHall));
  }
  
  public void a(long paramLong, @NotNull IExpandHall paramIExpandHall)
  {
    Intrinsics.checkParameterIsNotNull(paramIExpandHall, "hall");
    ThreadManagerV2.getUIHandlerV2().post((Runnable)new ExpandHallServiceImpl.joinHallRoomSucceed.1(this, paramLong, paramIExpandHall));
  }
  
  public void a(@Nullable Context paramContext)
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("init context:");
    localStringBuilder.append(paramContext);
    Logger.a(str, localStringBuilder.toString());
  }
  
  public void a(@NotNull Context paramContext, @NotNull ExpandHallLaunchParam paramExpandHallLaunchParam)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramExpandHallLaunchParam, "param");
    Object localObject = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("openExpandHall param=");
    localStringBuilder.append(paramExpandHallLaunchParam);
    localStringBuilder.append(", context=");
    localStringBuilder.append(paramContext);
    Logger.a((String)localObject, 1, localStringBuilder.toString());
    localObject = this.b;
    if (localObject != null)
    {
      localObject = (IExpandHall)((WeakReference)localObject).get();
      if (localObject != null) {
        ThreadManagerV2.getUIHandlerV2().postDelayed((Runnable)new ExpandHallServiceImpl.openExpandHall..inlined.run.lambda.1((IExpandHall)localObject, this), 500L);
      }
    }
    localObject = new Bundle();
    ((Bundle)localObject).putParcelable("key_expand_hall_launch_param", (Parcelable)paramExpandHallLaunchParam);
    paramExpandHallLaunchParam = new Intent();
    paramExpandHallLaunchParam.putExtras((Bundle)localObject);
    if (!(paramContext instanceof Activity)) {
      paramExpandHallLaunchParam.addFlags(268435456);
    }
    QPublicFragmentActivity.start(paramContext, paramExpandHallLaunchParam, ExpandHallFragment.class);
    Logger.a(this.a, 1, "openExpandHall QPublicFragmentActivity.start finish");
  }
  
  @MainThread
  public void a(@NotNull ExpandHallLifeCycleListener paramExpandHallLifeCycleListener)
  {
    Intrinsics.checkParameterIsNotNull(paramExpandHallLifeCycleListener, "lifeCycleListener");
    Object localObject = this.c.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (Intrinsics.areEqual((ExpandHallLifeCycleListener)((WeakReference)((Iterator)localObject).next()).get(), paramExpandHallLifeCycleListener)) {
        return;
      }
    }
    this.c.add(new WeakReference(paramExpandHallLifeCycleListener));
    paramExpandHallLifeCycleListener = this.c.iterator();
    Intrinsics.checkExpressionValueIsNotNull(paramExpandHallLifeCycleListener, "listenerPool.iterator()");
    while (paramExpandHallLifeCycleListener.hasNext())
    {
      localObject = paramExpandHallLifeCycleListener.next();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "iterator.next()");
      if (((WeakReference)localObject).get() == null) {
        paramExpandHallLifeCycleListener.remove();
      }
    }
  }
  
  public void a(@NotNull IExpandHall paramIExpandHall)
  {
    Intrinsics.checkParameterIsNotNull(paramIExpandHall, "hall");
    this.b = new WeakReference(paramIExpandHall);
    ThreadManagerV2.getUIHandlerV2().post((Runnable)new ExpandHallServiceImpl.hallOnCreate.1(this, paramIExpandHall));
  }
  
  public void b()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = (IExpandHall)((WeakReference)localObject).get();
      if (localObject != null)
      {
        Intrinsics.checkExpressionValueIsNotNull(localObject, "this");
        c((IExpandHall)localObject);
      }
    }
  }
  
  public void b(@NotNull IExpandHall paramIExpandHall)
  {
    Intrinsics.checkParameterIsNotNull(paramIExpandHall, "hall");
    Object localObject = this.b;
    if (localObject != null) {
      localObject = (IExpandHall)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    if (Intrinsics.areEqual(paramIExpandHall, localObject)) {
      this.b = ((WeakReference)null);
    }
    ThreadManagerV2.getUIHandlerV2().post((Runnable)new ExpandHallServiceImpl.hallDestroy.1(this, paramIExpandHall));
  }
  
  public void c(@NotNull IExpandHall paramIExpandHall)
  {
    Intrinsics.checkParameterIsNotNull(paramIExpandHall, "hall");
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("destroyHall hall:");
    localStringBuilder.append(paramIExpandHall);
    Logger.a(str, localStringBuilder.toString());
    paramIExpandHall.i();
  }
  
  public void g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.ExpandHallServiceImpl
 * JD-Core Version:    0.7.0.1
 */