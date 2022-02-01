package com.tencent.timi.game.base.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.timi.game.base.TimiGameActivityManager;
import com.tencent.timi.game.base.TimiGameBaseActivity;
import com.tencent.timi.game.base.TimiGameBaseFragment;
import com.tencent.timi.game.expand.hall.api.IExpandHallService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.ui.widget.IDialogLoading;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/base/ui/LoadingUtils;", "", "()V", "TAG", "", "hideLoading", "", "context", "Landroid/content/Context;", "hideLoadingInDialog", "dialogInterface", "Landroid/content/DialogInterface;", "isLoadingShowing", "", "obtainLoadingView", "Lcom/tencent/timi/game/base/ui/TimiGamePageLoadingView;", "showLoading", "loadingText", "showLoadingInDialog", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class LoadingUtils
{
  public static final LoadingUtils a = new LoadingUtils();
  
  public final void a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    String str = paramContext.getResources().getString(2131917232);
    Intrinsics.checkExpressionValueIsNotNull(str, "context.resources.getStr…ame_loading_hint_default)");
    a(paramContext, str);
  }
  
  public final void a(@NotNull Context paramContext, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramString, "loadingText");
    if ((paramContext instanceof TimiGameBaseActivity))
    {
      ((TimiGameBaseActivity)paramContext).a(paramString);
      return;
    }
    if ((paramContext instanceof QPublicFragmentActivity))
    {
      paramContext = (QPublicFragmentActivity)paramContext;
      if ((paramContext.getFragment() instanceof TimiGameBaseFragment))
      {
        paramContext = paramContext.getFragment();
        if (paramContext != null)
        {
          ((TimiGameBaseFragment)paramContext).a(paramString);
          return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.timi.game.base.TimiGameBaseFragment");
      }
    }
    paramContext = TimiGameActivityManager.a();
    if ((paramContext instanceof TimiGameBaseActivity))
    {
      ((TimiGameBaseActivity)paramContext).a(paramString);
      return;
    }
    paramContext = ((IExpandHallService)ServiceCenter.a(IExpandHallService.class)).a();
    if ((paramContext instanceof TimiGameBaseFragment)) {
      ((TimiGameBaseFragment)paramContext).a(paramString);
    }
  }
  
  public final void a(@NotNull DialogInterface paramDialogInterface)
  {
    Intrinsics.checkParameterIsNotNull(paramDialogInterface, "dialogInterface");
    Object localObject = BaseApplication.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplication.getContext()");
    localObject = ((BaseApplication)localObject).getResources().getString(2131917232);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplication.getConte…ame_loading_hint_default)");
    a(paramDialogInterface, (String)localObject);
  }
  
  public final void a(@NotNull DialogInterface paramDialogInterface, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramDialogInterface, "dialogInterface");
    Intrinsics.checkParameterIsNotNull(paramString, "loadingText");
    if ((paramDialogInterface instanceof IDialogLoading)) {
      ((IDialogLoading)paramDialogInterface).a(paramString);
    }
  }
  
  public final void b(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    if ((paramContext instanceof TimiGameBaseActivity))
    {
      ((TimiGameBaseActivity)paramContext).b();
      return;
    }
    if ((paramContext instanceof QPublicFragmentActivity))
    {
      paramContext = (QPublicFragmentActivity)paramContext;
      if ((paramContext.getFragment() instanceof TimiGameBaseFragment))
      {
        paramContext = paramContext.getFragment();
        if (paramContext != null)
        {
          ((TimiGameBaseFragment)paramContext).dL_();
          return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.timi.game.base.TimiGameBaseFragment");
      }
    }
    paramContext = TimiGameActivityManager.a();
    if ((paramContext instanceof TimiGameBaseActivity))
    {
      ((TimiGameBaseActivity)paramContext).b();
      return;
    }
    paramContext = ((IExpandHallService)ServiceCenter.a(IExpandHallService.class)).a();
    if ((paramContext instanceof TimiGameBaseFragment)) {
      ((TimiGameBaseFragment)paramContext).dL_();
    }
  }
  
  public final void b(@NotNull DialogInterface paramDialogInterface)
  {
    Intrinsics.checkParameterIsNotNull(paramDialogInterface, "dialogInterface");
    if ((paramDialogInterface instanceof IDialogLoading)) {
      ((IDialogLoading)paramDialogInterface).r();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.base.ui.LoadingUtils
 * JD-Core Version:    0.7.0.1
 */