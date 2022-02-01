package com.tencent.timi.game.initer.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasTempApi;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.initer.api.OnPAGLibraryLoadedListener;
import eipc.EIPCClient;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/initer/impl/LibraryInitManager;", "Landroid/content/BroadcastReceiver;", "()V", "ACTION_DOWNLOAD_AE_RES", "", "AE_KIT_IPC_MODULE_NAME", "KEY_RES_PREFIX", "STATE_LOADED", "", "STATE_NOT_LOAD", "TAG", "broadcastHasRegistered", "", "pagLibraryLoadedListenerList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lmqq/util/WeakReference;", "Lcom/tencent/timi/game/initer/api/OnPAGLibraryLoadedListener;", "status", "isPAGLibraryLoaded", "loadPAG", "", "loadPAGWithIPC", "notifyPAGLibraryLoaded", "result", "onReceive", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "registerOnPAGLibraryLoadedListener", "listener", "unregisterOnPAGLibraryLoadedListener", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class LibraryInitManager
  extends BroadcastReceiver
{
  public static final LibraryInitManager a;
  private static volatile int b;
  private static boolean c;
  private static final CopyOnWriteArrayList<WeakReference<OnPAGLibraryLoadedListener>> d;
  
  static
  {
    LibraryInitManager localLibraryInitManager = new LibraryInitManager();
    a = localLibraryInitManager;
    b = 1;
    d = new CopyOnWriteArrayList();
    localLibraryInitManager.b();
  }
  
  private final void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      Logger.INSTANCE.e(new String[] { "LibraryInitManager", "PAG download failed" });
      return;
    }
    b = 3;
    if (c)
    {
      BaseApplication.getContext().unregisterReceiver((BroadcastReceiver)this);
      c = false;
    }
    Iterator localIterator = ((Iterable)d).iterator();
    while (localIterator.hasNext())
    {
      OnPAGLibraryLoadedListener localOnPAGLibraryLoadedListener = (OnPAGLibraryLoadedListener)((WeakReference)localIterator.next()).get();
      if (localOnPAGLibraryLoadedListener != null) {
        localOnPAGLibraryLoadedListener.a();
      }
    }
  }
  
  private final void b()
  {
    if (a()) {
      return;
    }
    c();
  }
  
  private final void c()
  {
    Object localObject1 = IVasTempApi.Companion;
    localObject1 = QRoute.api(IVasTempApi.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "QRoute.api(IVasTempApi::class.java)");
    localObject1 = (IVasTempApi)localObject1;
    if (MobileQQ.sProcessId != 1) {
      try
      {
        if (((IAEResUtil)QRoute.api(IAEResUtil.class)).isAEResExist(AEResInfo.LIGHT_RES_BASE_PACKAGE))
        {
          QLog.i("LibraryInitManager", 1, "already download");
          a(((IVasTempApi)localObject1).initPagSo());
          return;
        }
        localObject1 = BaseApplication.getContext();
        localObject2 = (BroadcastReceiver)this;
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction(AEResInfo.LIGHT_RES_BASE_PACKAGE.resPrefix);
        ((BaseApplication)localObject1).registerReceiver((BroadcastReceiver)localObject2, localIntentFilter);
        c = true;
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("KEY_RES_PREFIX", AEResInfo.LIGHT_RES_BASE_PACKAGE.resPrefix);
        localObject2 = QIPCClientHelper.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "QIPCClientHelper.getInstance()");
        ((QIPCClientHelper)localObject2).getClient().callServer("AECameraGetInfoServer", "ACTION_DOWNLOAD_AE_RES", (Bundle)localObject1);
        return;
      }
      catch (Throwable localThrowable)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("loadPagWithIPC throw e:");
        ((StringBuilder)localObject2).append(localThrowable.getMessage());
        QLog.e("LibraryInitManager", 1, ((StringBuilder)localObject2).toString());
        return;
      }
    }
    localThrowable.requestPagDownload((Function0)new LibraryInitManager.loadPAGWithIPC.2(localThrowable));
  }
  
  public final void a(@NotNull OnPAGLibraryLoadedListener paramOnPAGLibraryLoadedListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOnPAGLibraryLoadedListener, "listener");
    b(paramOnPAGLibraryLoadedListener);
    d.add(new WeakReference(paramOnPAGLibraryLoadedListener));
  }
  
  public final boolean a()
  {
    return b == 3;
  }
  
  public final void b(@NotNull OnPAGLibraryLoadedListener paramOnPAGLibraryLoadedListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOnPAGLibraryLoadedListener, "listener");
    CollectionsKt.removeAll((List)d, (Function1)new LibraryInitManager.unregisterOnPAGLibraryLoadedListener.1(paramOnPAGLibraryLoadedListener));
  }
  
  public void onReceive(@Nullable Context paramContext, @Nullable Intent paramIntent)
  {
    paramContext = IVasTempApi.Companion;
    paramContext = QRoute.api(IVasTempApi.class);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "QRoute.api(IVasTempApi::class.java)");
    a(((IVasTempApi)paramContext).initPagSo());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.initer.impl.LibraryInitManager
 * JD-Core Version:    0.7.0.1
 */