package com.tencent.timi.game.smoba.impl.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.timi.game.base.ui.LoadingUtils;
import com.tencent.timi.game.base.ui.TimiGamePageLoadingView;
import com.tencent.timi.game.expand.hall.api.HallReportHelper;
import com.tencent.timi.game.expand.hall.api.IExpandHall;
import com.tencent.timi.game.expand.hall.api.IExpandHallService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.Callback;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.SwitchSmobaAccountCallback;
import com.tencent.timi.game.ui.widget.IDialogLoading;
import com.tencent.timi.game.ui.widget.SimpleSlideUpDialog;
import com.tencent.timi.game.utils.StatusBarUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.SmobaGameRoleAbsInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/smoba/impl/widget/SwitchAccountDialog;", "Lcom/tencent/timi/game/ui/widget/SimpleSlideUpDialog;", "Lcom/tencent/timi/game/ui/widget/IDialogLoading;", "context", "Landroid/content/Context;", "accountList", "", "Ltrpc/yes/common/GameDataServerOuterClass$SmobaGameRoleAbsInfo;", "cb", "Lcom/tencent/timi/game/smoba/api/IUserSmobaInfoService$SwitchSmobaAccountCallback;", "(Landroid/content/Context;Ljava/util/List;Lcom/tencent/timi/game/smoba/api/IUserSmobaInfoService$SwitchSmobaAccountCallback;)V", "getAccountList", "()Ljava/util/List;", "getCb", "()Lcom/tencent/timi/game/smoba/api/IUserSmobaInfoService$SwitchSmobaAccountCallback;", "contentView", "Landroid/view/View;", "hideLoadingView", "", "initViews", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "shadowBgView", "show", "showLoadingView", "loadingTextResId", "", "text", "", "switchAccount", "account", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class SwitchAccountDialog
  extends SimpleSlideUpDialog
  implements IDialogLoading
{
  @NotNull
  private final List<GameDataServerOuterClass.SmobaGameRoleAbsInfo> a;
  @Nullable
  private final IUserSmobaInfoService.SwitchSmobaAccountCallback b;
  
  public SwitchAccountDialog(@NotNull Context paramContext, @NotNull List<GameDataServerOuterClass.SmobaGameRoleAbsInfo> paramList, @Nullable IUserSmobaInfoService.SwitchSmobaAccountCallback paramSwitchSmobaAccountCallback)
  {
    super(paramContext);
    this.a = paramList;
    this.b = paramSwitchSmobaAccountCallback;
    setContentView(2131629526);
    e();
  }
  
  private final void a(GameDataServerOuterClass.SmobaGameRoleAbsInfo paramSmobaGameRoleAbsInfo)
  {
    LoadingUtils.a.a((DialogInterface)this);
    SwitchAccountDialog.switchAccount.setDefaultAccountCb.1 local1 = new SwitchAccountDialog.switchAccount.setDefaultAccountCb.1(this);
    ((IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class)).a(paramSmobaGameRoleAbsInfo, (IUserSmobaInfoService.Callback)local1);
  }
  
  private final void e()
  {
    Object localObject1 = ((IExpandHallService)ServiceCenter.a(IExpandHallService.class)).a();
    if (localObject1 != null) {
      localObject1 = ((IExpandHall)localObject1).e();
    } else {
      localObject1 = null;
    }
    if (localObject1 != null) {
      ((HallReportHelper)localObject1).a(this);
    }
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = (TextView)findViewById(2131431224);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "confirmTxv");
      ((HallReportHelper)localObject1).a((View)localObject2, ((HallReportHelper)localObject1).n());
    }
    if (localObject1 != null)
    {
      localObject2 = (ImageView)findViewById(2131430812);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "closeIconIgv");
      ((HallReportHelper)localObject1).a((View)localObject2, ((HallReportHelper)localObject1).m());
    }
    ((SmobaAccountSelectView)findViewById(2131446111)).setData(this.a);
    ((TextView)findViewById(2131431224)).setOnClickListener((View.OnClickListener)new SwitchAccountDialog.initViews.1(this));
    ((ImageView)findViewById(2131430812)).setOnClickListener((View.OnClickListener)new SwitchAccountDialog.initViews.2(this));
    findViewById(2131445743).setOnClickListener((View.OnClickListener)new SwitchAccountDialog.initViews.3(this));
  }
  
  @Nullable
  public final IUserSmobaInfoService.SwitchSmobaAccountCallback a()
  {
    return this.b;
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "text");
    int i;
    if (((CharSequence)paramString).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      paramString = this.e.getString(2131917232);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "context.getString(R.stri…ame_loading_hint_default)");
    }
    ((TimiGamePageLoadingView)findViewById(2131437626)).setHintText(paramString);
    ((TimiGamePageLoadingView)findViewById(2131437626)).a();
  }
  
  @NotNull
  public View b()
  {
    View localView = findViewById(2131445743);
    Intrinsics.checkExpressionValueIsNotNull(localView, "shadowView");
    return localView;
  }
  
  @NotNull
  public View c()
  {
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131431334);
    Intrinsics.checkExpressionValueIsNotNull(localLinearLayout, "contentRootView");
    return (View)localLinearLayout;
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    StatusBarUtil.b(getWindow());
  }
  
  public void r()
  {
    if ((TimiGamePageLoadingView)findViewById(2131437626) != null) {
      ((TimiGamePageLoadingView)findViewById(2131437626)).b();
    }
  }
  
  public void show()
  {
    super.show();
    IUserSmobaInfoService.SwitchSmobaAccountCallback localSwitchSmobaAccountCallback = this.b;
    if (localSwitchSmobaAccountCallback != null) {
      localSwitchSmobaAccountCallback.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.widget.SwitchAccountDialog
 * JD-Core Version:    0.7.0.1
 */