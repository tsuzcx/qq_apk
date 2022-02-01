package com.tencent.timi.game.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.timi.game.api.cb.ExpandHallListener;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import com.tencent.timi.game.expand.hall.impl.ExpandHallFragment;
import com.tencent.timi.game.expand.hall.impl.util.HallListenerFactory;
import com.tencent.timi.game.ui.widget.EmptyDialog;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/api/impl/TimiGameApp;", "", "()V", "MAX_WAIT_DURATION", "", "SHOW_LOADING_DURATION", "TAG", "", "createExpandHallFragment", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "context", "Landroid/content/Context;", "expandHallOpenParam", "Lcom/tencent/timi/game/api/param/ExpandHallLaunchParam;", "listener", "Lcom/tencent/timi/game/api/cb/ExpandHallListener;", "hideWaitDialog", "", "dialog", "Landroid/content/DialogInterface;", "openExpandHall", "openLiveRoom", "isAnchor", "", "startTask", "task", "Lcom/tencent/timi/game/api/impl/TimiGameApp$IStartTask;", "IStartTask", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TimiGameApp
{
  public static final TimiGameApp a = new TimiGameApp();
  
  private final void a(Context paramContext, TimiGameApp.IStartTask paramIStartTask, ExpandHallLaunchParam paramExpandHallLaunchParam)
  {
    Ref.ObjectRef localObjectRef = new Ref.ObjectRef();
    localObjectRef.element = ((EmptyDialog)null);
    if ((paramContext instanceof Activity))
    {
      localObjectRef.element = new EmptyDialog(paramContext);
    }
    else if (QBaseActivity.sTopActivity != null)
    {
      paramContext = QBaseActivity.sTopActivity;
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "QBaseActivity.sTopActivity");
      localObjectRef.element = new EmptyDialog((Context)paramContext);
    }
    else
    {
      Logger.c("TimiGameApp_", "openExpandHall need activity context！");
    }
    ThreadManagerV2.excute((Runnable)new TimiGameApp.startTask.initTaskWrapper.1(paramExpandHallLaunchParam, System.currentTimeMillis(), paramIStartTask, localObjectRef), 16, null, false);
  }
  
  private final void a(DialogInterface paramDialogInterface)
  {
    ThreadManagerV2.getUIHandlerV2().post((Runnable)new TimiGameApp.hideWaitDialog.1(paramDialogInterface));
  }
  
  @NotNull
  public final QPublicBaseFragment a(@NotNull Context paramContext, @NotNull ExpandHallLaunchParam paramExpandHallLaunchParam, @Nullable ExpandHallListener paramExpandHallListener)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramExpandHallLaunchParam, "expandHallOpenParam");
    a(paramContext, (TimiGameApp.IStartTask)new TimiGameApp.createExpandHallFragment.task.1(System.currentTimeMillis()), paramExpandHallLaunchParam);
    paramContext = new ExpandHallFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_expand_hall_launch_param", (Parcelable)paramExpandHallLaunchParam);
    paramContext.setArguments(localBundle);
    if (paramExpandHallListener == null) {
      paramContext.a(HallListenerFactory.a.a(paramExpandHallLaunchParam));
    } else {
      paramContext.a(paramExpandHallListener);
    }
    return (QPublicBaseFragment)paramContext;
  }
  
  public final void a(@NotNull Context paramContext, @NotNull ExpandHallLaunchParam paramExpandHallLaunchParam)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramExpandHallLaunchParam, "expandHallOpenParam");
    a(paramContext, (TimiGameApp.IStartTask)new TimiGameApp.openExpandHall.task.1(paramContext, paramExpandHallLaunchParam, System.currentTimeMillis()), paramExpandHallLaunchParam);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.api.impl.TimiGameApp
 * JD-Core Version:    0.7.0.1
 */