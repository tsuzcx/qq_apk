package com.tencent.timi.game.smoba.api.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.timi.game.expand.hall.api.HallReportHelper;
import com.tencent.timi.game.expand.hall.api.IExpandHall;
import com.tencent.timi.game.expand.hall.api.IExpandHallService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.smoba.api.SmobaAuthAndDefaultAccountChecker;
import com.tencent.timi.game.smoba.api.SmobaAuthAndDefaultAccountChecker.CheckListener;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaAuthInfoRsp;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaDefaultRoleRsp;
import trpc.yes.common.GameDataServerOuterClass.GetUserSmobaRoleListRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/smoba/api/view/SmobaAuthAndBindHintView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/timi/game/smoba/api/SmobaAuthAndDefaultAccountChecker$CheckListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mLifecycleContext", "Lcom/tencent/mobileqq/app/QBaseActivity;", "hideHintView", "", "defaultAccount", "Ltrpc/yes/common/GameDataServerOuterClass$GetSmobaDefaultRoleRsp;", "init", "owner", "showHintView", "authInfo", "Ltrpc/yes/common/GameDataServerOuterClass$GetSmobaAuthInfoRsp;", "accountList", "Ltrpc/yes/common/GameDataServerOuterClass$GetUserSmobaRoleListRsp;", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class SmobaAuthAndBindHintView
  extends RelativeLayout
  implements SmobaAuthAndDefaultAccountChecker.CheckListener
{
  public static final SmobaAuthAndBindHintView.Companion a = new SmobaAuthAndBindHintView.Companion(null);
  private QBaseActivity b;
  
  @JvmOverloads
  public SmobaAuthAndBindHintView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public SmobaAuthAndBindHintView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public SmobaAuthAndBindHintView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    View.inflate(paramContext, 2131629518, (ViewGroup)this);
  }
  
  public final void a(@NotNull QBaseActivity paramQBaseActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramQBaseActivity, "owner");
    this.b = paramQBaseActivity;
    SmobaAuthAndDefaultAccountChecker.a.a((SmobaAuthAndDefaultAccountChecker.CheckListener)this);
    SmobaAuthAndDefaultAccountChecker.a.a();
  }
  
  public void a(@Nullable GameDataServerOuterClass.GetSmobaAuthInfoRsp paramGetSmobaAuthInfoRsp, @Nullable GameDataServerOuterClass.GetUserSmobaRoleListRsp paramGetUserSmobaRoleListRsp)
  {
    Object localObject = ((IExpandHallService)ServiceCenter.a(IExpandHallService.class)).a();
    if (localObject != null) {
      localObject = ((IExpandHall)localObject).e();
    } else {
      localObject = null;
    }
    if (localObject != null) {
      ((HallReportHelper)localObject).a((View)this, ((HallReportHelper)localObject).h());
    }
    localObject = Logger.INSTANCE;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showHintView authInfo:");
    localStringBuilder.append(paramGetSmobaAuthInfoRsp);
    localStringBuilder.append(", accountList:");
    localStringBuilder.append(paramGetUserSmobaRoleListRsp);
    ((Logger)localObject).i(new String[] { "SmobaAuthAndBindHintView_", localStringBuilder.toString() });
    setOnClickListener((View.OnClickListener)new SmobaAuthAndBindHintView.showHintView.2(this, paramGetSmobaAuthInfoRsp, paramGetUserSmobaRoleListRsp));
    setVisibility(0);
  }
  
  public void a(@NotNull GameDataServerOuterClass.GetSmobaDefaultRoleRsp paramGetSmobaDefaultRoleRsp)
  {
    Intrinsics.checkParameterIsNotNull(paramGetSmobaDefaultRoleRsp, "defaultAccount");
    Logger localLogger = Logger.INSTANCE;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hideHintView defaultAccount:");
    localStringBuilder.append(paramGetSmobaDefaultRoleRsp);
    localLogger.i(new String[] { "SmobaAuthAndBindHintView_", localStringBuilder.toString() });
    setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.api.view.SmobaAuthAndBindHintView
 * JD-Core Version:    0.7.0.1
 */