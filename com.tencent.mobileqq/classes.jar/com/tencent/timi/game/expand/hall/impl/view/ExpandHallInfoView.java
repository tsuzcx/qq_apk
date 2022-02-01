package com.tencent.timi.game.expand.hall.impl.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.timi.game.expand.hall.api.HallReportHelper;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService;
import com.tencent.timi.game.test.api.ITimiGameTestService;
import com.tencent.timi.game.ui.widget.RoundCornerImageView;
import com.tencent.timi.game.utils.CommonExKt;
import com.tencent.timi.game.utils.Logger;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaAuthInfoRsp;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaDefaultRoleRsp;
import trpc.yes.common.GameDataServerOuterClass.SmobaGameRoleInfo;
import trpc.yes.wuji.WujiYoloRoomOuterClass.WujiYoloCommunityRoomConf;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/expand/hall/impl/view/ExpandHallInfoView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "reporterHelper", "Lcom/tencent/timi/game/expand/hall/api/HallReportHelper;", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/tencent/timi/game/expand/hall/api/HallReportHelper;)V", "colorDrawable", "Landroid/graphics/drawable/ColorDrawable;", "mHallInfo", "Ltrpc/yes/wuji/WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf;", "mReportHelper", "mSmobaAuthClickListener", "Landroid/view/View$OnClickListener;", "mState", "mState$annotations", "()V", "bindValue", "", "owner", "Lcom/tencent/mobileqq/app/QBaseActivity;", "getState", "hide", "hideAnim", "hideSelf", "hideShadow", "init", "data", "initViews", "refreshAccountUI", "defaultAccount", "Ltrpc/yes/common/GameDataServerOuterClass$GetSmobaDefaultRoleRsp;", "refreshHallInfoUI", "setSmobaAuthClickListener", "listener", "show", "showAnim", "showShadow", "switchShadow", "", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandHallInfoView
  extends FrameLayout
{
  public static final ExpandHallInfoView.Companion a = new ExpandHallInfoView.Companion(null);
  private int b = 2;
  private View.OnClickListener c;
  private WujiYoloRoomOuterClass.WujiYoloCommunityRoomConf d;
  private final HallReportHelper e;
  private ColorDrawable f;
  private HashMap g;
  
  @JvmOverloads
  public ExpandHallInfoView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, null, 14, null);
  }
  
  @JvmOverloads
  public ExpandHallInfoView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, null, 12, null);
  }
  
  @JvmOverloads
  public ExpandHallInfoView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, null, 8, null);
  }
  
  @JvmOverloads
  public ExpandHallInfoView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt, @NotNull HallReportHelper paramHallReportHelper)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.e = paramHallReportHelper;
    this.f = new ColorDrawable(16052712);
    View.inflate(paramContext, 2131629519, (ViewGroup)this);
    ((ITimiGameTestService)ServiceCenter.a(ITimiGameTestService.class)).a((View)this);
    setBackgroundResource(2131168376);
    c();
  }
  
  private final void a(QBaseActivity paramQBaseActivity)
  {
    LiveData localLiveData = ((IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class)).a();
    LifecycleOwner localLifecycleOwner = (LifecycleOwner)paramQBaseActivity;
    localLiveData.observe(localLifecycleOwner, (Observer)new ExpandHallInfoView.bindValue.1(this, paramQBaseActivity));
    ((IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class)).c().observe(localLifecycleOwner, (Observer)new ExpandHallInfoView.bindValue.2(this, paramQBaseActivity));
    ((IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class)).b(null);
    a(paramQBaseActivity, (GameDataServerOuterClass.GetSmobaDefaultRoleRsp)localLiveData.getValue());
  }
  
  private final void a(QBaseActivity paramQBaseActivity, GameDataServerOuterClass.GetSmobaDefaultRoleRsp paramGetSmobaDefaultRoleRsp)
  {
    ((LinearLayout)a(2131445109)).setOnClickListener((View.OnClickListener)new ExpandHallInfoView.refreshAccountUI.1(this, paramQBaseActivity, paramGetSmobaDefaultRoleRsp));
    paramQBaseActivity = new StringBuilder();
    paramQBaseActivity.append("refreshAccountUI defaultAccount:");
    paramQBaseActivity.append(paramGetSmobaDefaultRoleRsp);
    Logger.a("ExpandHallInfoView_", paramQBaseActivity.toString());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("refreshAccountUI defaultAccount name:");
    if (paramGetSmobaDefaultRoleRsp != null)
    {
      paramQBaseActivity = paramGetSmobaDefaultRoleRsp.role_info;
      if (paramQBaseActivity != null)
      {
        paramQBaseActivity = paramQBaseActivity.role_name;
        if (paramQBaseActivity != null)
        {
          paramQBaseActivity = paramQBaseActivity.get();
          break label102;
        }
      }
    }
    paramQBaseActivity = null;
    label102:
    localStringBuilder.append(paramQBaseActivity);
    Logger.a("ExpandHallInfoView_", localStringBuilder.toString());
    paramQBaseActivity = (LinearLayout)a(2131445109);
    Intrinsics.checkExpressionValueIsNotNull(paramQBaseActivity, "roleNameLl");
    paramQBaseActivity.setVisibility(0);
    paramQBaseActivity = (GameDataServerOuterClass.GetSmobaAuthInfoRsp)((IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class)).c().getValue();
    if ((paramGetSmobaDefaultRoleRsp != null) && (paramQBaseActivity != null) && (paramQBaseActivity.is_auth.get()))
    {
      paramQBaseActivity = (ImageView)a(2131445110);
      Intrinsics.checkExpressionValueIsNotNull(paramQBaseActivity, "roleNameRightHintIcon");
      paramQBaseActivity.setVisibility(0);
      paramQBaseActivity = (TextView)a(2131445112);
      Intrinsics.checkExpressionValueIsNotNull(paramQBaseActivity, "roleNameTxv");
      paramQBaseActivity.setText((CharSequence)paramGetSmobaDefaultRoleRsp.role_info.role_name.get());
      return;
    }
    paramQBaseActivity = (ImageView)a(2131445110);
    Intrinsics.checkExpressionValueIsNotNull(paramQBaseActivity, "roleNameRightHintIcon");
    paramQBaseActivity.setVisibility(0);
    paramQBaseActivity = (TextView)a(2131445112);
    Intrinsics.checkExpressionValueIsNotNull(paramQBaseActivity, "roleNameTxv");
    paramQBaseActivity.setText((CharSequence)"去绑定");
  }
  
  private final void c()
  {
    setOnClickListener((View.OnClickListener)new ExpandHallInfoView.initViews.1(this));
    ((RelativeLayout)a(2131431332)).setOnClickListener((View.OnClickListener)ExpandHallInfoView.initViews.2.a);
    HallReportHelper localHallReportHelper = this.e;
    LinearLayout localLinearLayout = (LinearLayout)a(2131445109);
    Intrinsics.checkExpressionValueIsNotNull(localLinearLayout, "roleNameLl");
    localHallReportHelper.a((View)localLinearLayout, this.e.d());
    localHallReportHelper = this.e;
    localLinearLayout = (LinearLayout)a(2131428880);
    Intrinsics.checkExpressionValueIsNotNull(localLinearLayout, "authHintLl");
    localHallReportHelper.a((View)localLinearLayout, this.e.e());
    ((LinearLayout)a(2131428880)).setOnClickListener((View.OnClickListener)new ExpandHallInfoView.initViews.3(this));
    RoundCornerImageView.setRadius$default((RoundCornerImageView)a(2131434887), CommonExKt.a(15), CommonExKt.a(15), 0.0F, 0.0F, 12, null);
    ((RoundCornerImageView)a(2131434790)).setRadius(CommonExKt.b(18));
  }
  
  private final void d()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("refreshUI mHallInfo=");
    ((StringBuilder)localObject1).append(this.d);
    Logger.a("ExpandHallInfoView_", ((StringBuilder)localObject1).toString());
    localObject1 = this.d;
    if (localObject1 != null)
    {
      Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
      Object localObject3 = this.f;
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject3);
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject3);
      localObject3 = ((WujiYoloRoomOuterClass.WujiYoloCommunityRoomConf)localObject1).room_detail_background_img.get();
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("refreshUI coverBgUrl=");
      ((StringBuilder)localObject4).append((String)localObject3);
      Logger.a("ExpandHallInfoView_", ((StringBuilder)localObject4).toString());
      localObject4 = (RoundCornerImageView)a(2131434887);
      Intrinsics.checkExpressionValueIsNotNull(localObject4, "headBgIgv");
      localObject4 = (URLImageView)localObject4;
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "coverBgUrl");
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "options");
      CommonExKt.a((URLImageView)localObject4, (String)localObject3, (URLDrawable.URLDrawableOptions)localObject2);
      localObject3 = ((WujiYoloRoomOuterClass.WujiYoloCommunityRoomConf)localObject1).room_cover.get();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("refreshUI hallIconUrl=");
      ((StringBuilder)localObject4).append((String)localObject3);
      Logger.a("ExpandHallInfoView_", ((StringBuilder)localObject4).toString());
      localObject4 = (RoundCornerImageView)a(2131434790);
      Intrinsics.checkExpressionValueIsNotNull(localObject4, "hallIconIgv");
      localObject4 = (URLImageView)localObject4;
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "hallIconUrl");
      CommonExKt.a((URLImageView)localObject4, (String)localObject3, (URLDrawable.URLDrawableOptions)localObject2);
      localObject2 = (TextView)a(2131432658);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "expandHallNameTxv");
      ((TextView)localObject2).setText((CharSequence)((WujiYoloRoomOuterClass.WujiYoloCommunityRoomConf)localObject1).introduce.get());
      localObject2 = (TextView)a(2131432659);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "expandHallNoticeTxv");
      ((TextView)localObject2).setText((CharSequence)((WujiYoloRoomOuterClass.WujiYoloCommunityRoomConf)localObject1).notice.get());
    }
  }
  
  private final void e()
  {
    setVisibility(0);
    post((Runnable)new ExpandHallInfoView.showAnim.1(this));
  }
  
  private final void f()
  {
    post((Runnable)new ExpandHallInfoView.hideAnim.1(this));
  }
  
  private final void g()
  {
    setVisibility(8);
    this.b = 2;
  }
  
  public View a(int paramInt)
  {
    if (this.g == null) {
      this.g = new HashMap();
    }
    View localView2 = (View)this.g.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.g.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public final void a()
  {
    if (this.b == 1) {
      return;
    }
    this.b = 1;
    e();
  }
  
  public final void a(@NotNull QBaseActivity paramQBaseActivity, @Nullable WujiYoloRoomOuterClass.WujiYoloCommunityRoomConf paramWujiYoloCommunityRoomConf)
  {
    Intrinsics.checkParameterIsNotNull(paramQBaseActivity, "owner");
    this.d = paramWujiYoloCommunityRoomConf;
    a(paramQBaseActivity);
    d();
  }
  
  public final void b()
  {
    if (this.b == 2) {
      return;
    }
    this.b = 2;
    f();
  }
  
  public final int getState()
  {
    return this.b;
  }
  
  public final void setSmobaAuthClickListener(@NotNull View.OnClickListener paramOnClickListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOnClickListener, "listener");
    this.c = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.view.ExpandHallInfoView
 * JD-Core Version:    0.7.0.1
 */