package com.tencent.timi.game.profile.impl.dialog;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import com.tencent.av.utils.UITools;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.accusation.api.TimiGameAccusationApi;
import com.tencent.timi.game.ex.LayoutExKt;
import com.tencent.timi.game.ex.ViewExKt;
import com.tencent.timi.game.image.api.IDrawableService;
import com.tencent.timi.game.logincore.api.ILoginCoreService;
import com.tencent.timi.game.profile.api.ui.ProfileDialog;
import com.tencent.timi.game.profile.impl.view.ProfileItemInTeamView;
import com.tencent.timi.game.profile.impl.view.ProfileUserInfoView;
import com.tencent.timi.game.profile.impl.view.record.ProfileSmobaRecordView;
import com.tencent.timi.game.relationship.api.ITGRelationshipService;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.wrapper.IRoomGetDataService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.BindSmobaAccountCallback;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.SwitchSmobaAccountCallback;
import com.tencent.timi.game.test.api.ITimiGameTestService;
import com.tencent.timi.game.userinfo.api.IUserInfoService;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import com.tencent.timi.game.utils.NoDoubleClickUtils;
import com.tencent.timi.game.widget.MediumBoldTextView;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaDefaultRoleRsp;
import trpc.yes.common.GameDataServerOuterClass.SmobaGameRoleInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomSpeakingPosInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/profile/impl/dialog/ProfileBaseInfoDialog;", "Lcom/tencent/timi/game/profile/api/ui/ProfileDialog;", "Landroid/view/View$OnClickListener;", "activity", "Lcom/tencent/mobileqq/app/QBaseActivity;", "userId", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "isHeightWrap", "", "isCaptain", "reportParamMap", "", "", "roomId", "", "showFleetState", "(Lcom/tencent/mobileqq/app/QBaseActivity;Ltrpc/yes/common/CommonOuterClass$QQUserId;ZZLjava/util/Map;Ljava/lang/Long;Z)V", "TAG", "getActivity", "()Lcom/tencent/mobileqq/app/QBaseActivity;", "bottomLinear", "Landroid/widget/LinearLayout;", "closeButton", "Landroid/view/View;", "currentTime", "defaultAvatarUrl", "()Z", "setCaptain", "(Z)V", "isDismissed", "isMaster", "setMaster", "operationFrame", "Landroid/view/ViewGroup;", "profileAvatarBgView", "Lcom/tencent/mobileqq/widget/RoundImageView;", "profileItemInTeamView", "Lcom/tencent/timi/game/profile/impl/view/ProfileItemInTeamView;", "profileRelView", "getProfileRelView", "()Landroid/view/View;", "setProfileRelView", "(Landroid/view/View;)V", "reportButton", "getReportParamMap", "()Ljava/util/Map;", "setReportParamMap", "(Ljava/util/Map;)V", "roleInfoFrame", "roleNameText", "Landroid/widget/TextView;", "getRoomId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "rootView", "getShowFleetState", "smobaRecordView", "Lcom/tencent/timi/game/profile/impl/view/record/ProfileSmobaRecordView;", "speakingListener", "com/tencent/timi/game/profile/impl/dialog/ProfileBaseInfoDialog$speakingListener$1", "Lcom/tencent/timi/game/profile/impl/dialog/ProfileBaseInfoDialog$speakingListener$1;", "getUserId", "()Ltrpc/yes/common/CommonOuterClass$QQUserId;", "userInfoView", "Lcom/tencent/timi/game/profile/impl/view/ProfileUserInfoView;", "acquireCloseButton", "acquireCostTime", "acquireMicReportParam", "acquireName", "acquireReportButton", "acquireRoleButton", "acquireShowName", "addMasterMicExitView", "addOperationViewToPanel", "", "view", "addToBottomOperationView", "views", "", "([Landroid/view/View;)V", "canChangeRole", "dismiss", "generateBottomOperateView", "textResId", "", "textColor", "backgroundColor", "init", "initUserData", "initView", "isFriend", "isMicrophoneEnable", "onClick", "v", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "printPerformanceTime", "value", "realChangeRole", "refreshSmobaAccountText", "roleName", "rootNoBackColor", "setAvatarBackground", "setOperationViewMargin", "operationPanel", "show", "showSmobaAccountSelectDialog", "updateRoleInfo", "selectedDefaultAccount", "Ltrpc/yes/common/GameDataServerOuterClass$GetSmobaDefaultRoleRsp;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract class ProfileBaseInfoDialog
  extends ProfileDialog
  implements View.OnClickListener
{
  @NotNull
  private Map<String, String> A;
  @Nullable
  private final Long B;
  private final boolean C;
  private final String a;
  private ViewGroup b;
  private ProfileUserInfoView c;
  private View d;
  private ProfileSmobaRecordView i;
  private View j;
  private ViewGroup k;
  private LinearLayout l;
  private TextView m;
  private RoundImageView n;
  private View o;
  private ProfileItemInTeamView p;
  private final String q;
  @Nullable
  private View r;
  private final long s;
  private boolean t;
  private boolean u;
  private final ProfileBaseInfoDialog.speakingListener.1 v;
  @NotNull
  private final QBaseActivity w;
  @NotNull
  private final CommonOuterClass.QQUserId x;
  private final boolean y;
  private boolean z;
  
  public ProfileBaseInfoDialog(@NotNull QBaseActivity paramQBaseActivity, @NotNull CommonOuterClass.QQUserId paramQQUserId, boolean paramBoolean1, boolean paramBoolean2, @NotNull Map<String, String> paramMap, @Nullable Long paramLong, boolean paramBoolean3)
  {
    super((Context)paramQBaseActivity);
    this.w = paramQBaseActivity;
    this.x = paramQQUserId;
    this.y = paramBoolean1;
    this.z = paramBoolean2;
    this.A = paramMap;
    this.B = paramLong;
    this.C = paramBoolean3;
    this.a = "ProfileBaseInfoDialog";
    this.q = "https://cdn.yes.qq.com/tg_profile_dialog_backgroud_ic";
    this.s = System.currentTimeMillis();
    a("init start ======");
    if (this.y) {
      setContentView(2131629464);
    } else {
      setContentView(2131629462);
    }
    ((ITimiGameTestService)ServiceCenter.a(ITimiGameTestService.class)).a(findViewById(16908290));
    paramQBaseActivity = ServiceCenter.a(ILoginCoreService.class);
    Intrinsics.checkExpressionValueIsNotNull(paramQBaseActivity, "ServiceCenter.getService…nCoreService::class.java)");
    if (((ILoginCoreService)paramQBaseActivity).a() == this.x.uid.get()) {
      paramBoolean1 = true;
    } else {
      paramBoolean1 = false;
    }
    this.t = paramBoolean1;
    c();
    v();
    a("outer init start ");
    b();
    a("outer init end ");
    paramQBaseActivity = this.p;
    if (paramQBaseActivity != null) {
      paramQBaseActivity.setClickListener((View.OnClickListener)new ProfileBaseInfoDialog.1(this));
    }
    this.v = new ProfileBaseInfoDialog.speakingListener.1();
  }
  
  private final void a(String paramString) {}
  
  private final void a(GameDataServerOuterClass.GetSmobaDefaultRoleRsp paramGetSmobaDefaultRoleRsp)
  {
    Logger.a(this.a, "updateRoleInfo ");
    b(paramGetSmobaDefaultRoleRsp.role_info.role_name.get());
  }
  
  private final void b(String paramString)
  {
    paramString = (CharSequence)paramString;
    if (TextUtils.isEmpty(paramString))
    {
      paramString = this.m;
      if (paramString != null) {
        paramString.setText((CharSequence)"去绑定");
      }
    }
    else
    {
      TextView localTextView = this.m;
      if (localTextView != null) {
        localTextView.setText(paramString);
      }
    }
  }
  
  private final void c()
  {
    this.r = findViewById(2131440684);
    this.c = ((ProfileUserInfoView)findViewById(2131449229));
    this.d = findViewById(2131445105);
    this.b = ((ViewGroup)findViewById(2131445143));
    this.i = ((ProfileSmobaRecordView)findViewById(2131446114));
    this.j = findViewById(2131444660);
    this.k = ((ViewGroup)findViewById(2131439646));
    this.l = ((LinearLayout)findViewById(2131429630));
    this.m = ((TextView)findViewById(2131445111));
    this.n = ((RoundImageView)findViewById(2131440681));
    this.p = ((ProfileItemInTeamView)findViewById(2131440683));
    Object localObject = this.b;
    if (localObject != null)
    {
      b((View)localObject);
      ViewExKt.a(ViewExKt.a((View)localObject, new int[] { -1 }), LayoutExKt.b(15.0F), LayoutExKt.b(15.0F), 0.0F, 0.0F);
    }
    localObject = this.d;
    if (localObject != null) {
      ViewExKt.a((View)localObject, LayoutExKt.b(10), new int[] { Color.parseColor("#80F5F5F5") });
    }
    localObject = this.d;
    if (localObject != null) {
      ((View)localObject).setOnClickListener((View.OnClickListener)this);
    }
    localObject = this.j;
    if (localObject != null) {
      ((View)localObject).setOnClickListener((View.OnClickListener)this);
    }
    localObject = findViewById(2131437978);
    if (localObject != null) {
      ((View)localObject).setOnClickListener((View.OnClickListener)this);
    }
    this.o = findViewById(2131430808);
    localObject = this.o;
    if (localObject != null) {
      ((View)localObject).setOnClickListener((View.OnClickListener)this);
    }
    u();
    if (!d())
    {
      localObject = this.m;
      if (localObject != null) {
        ((TextView)localObject).setCompoundDrawables(null, null, null, null);
      }
    }
    a("initView end ");
  }
  
  private final void d(View paramView)
  {
    View localView2 = paramView.findViewById(2131439653);
    View localView3 = paramView.findViewById(2131439654);
    View localView1 = paramView.findViewById(2131439656);
    if ((localView2 != null) && (localView2.getVisibility() == 8) && (localView3 != null) && (localView3.getVisibility() == 8))
    {
      if (localView1 != null) {
        paramView = localView1.getLayoutParams();
      } else {
        paramView = null;
      }
      if ((paramView instanceof LinearLayout.LayoutParams))
      {
        ((LinearLayout.LayoutParams)paramView).topMargin = 0;
        localView1.setLayoutParams(paramView);
        localView1.requestLayout();
      }
    }
  }
  
  private final void u()
  {
    int i1 = (int)UITools.a(this.e, 15.0F);
    Object localObject1 = this.n;
    if (localObject1 != null) {
      ((RoundImageView)localObject1).setmRadius(i1, false);
    }
    localObject1 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ((Drawable)new ColorDrawable(0));
    ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = ((Drawable)new ColorDrawable(0));
    try
    {
      localObject2 = this.n;
      if (localObject2 != null)
      {
        ((RoundImageView)localObject2).setImageDrawable((Drawable)((IDrawableService)ServiceCenter.a(IDrawableService.class)).a(this.q, (URLDrawable.URLDrawableOptions)localObject1));
        return;
      }
    }
    catch (Exception localException)
    {
      Object localObject2 = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setAvatarBackground error ");
      localStringBuilder.append(localException);
      Logger.c((String)localObject2, localStringBuilder.toString());
    }
  }
  
  private final void v()
  {
    ((IUserInfoService)ServiceCenter.a(IUserInfoService.class)).d(this.x.uid.get(), (IResultListener)new ProfileBaseInfoDialog.initUserData.1(this));
    Object localObject = this.j;
    if (localObject != null) {
      ViewExKt.a((View)localObject, this.t ^ true);
    }
    localObject = this.i;
    if (localObject != null) {
      ((ProfileSmobaRecordView)localObject).setUserId(this.x.uid.get());
    }
    localObject = this.c;
    if (localObject != null) {
      ((ProfileUserInfoView)localObject).setData(this.x);
    }
    GameDataServerOuterClass.GetSmobaDefaultRoleRsp localGetSmobaDefaultRoleRsp = (GameDataServerOuterClass.GetSmobaDefaultRoleRsp)((IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class)).a().getValue();
    localObject = this.d;
    if (localObject != null) {
      ViewExKt.a((View)localObject, this.t);
    }
    if (localGetSmobaDefaultRoleRsp != null)
    {
      localObject = localGetSmobaDefaultRoleRsp.role_info;
      if (localObject != null)
      {
        localObject = ((GameDataServerOuterClass.SmobaGameRoleInfo)localObject).role_name;
        if (localObject != null)
        {
          localObject = ((PBStringField)localObject).get();
          break label164;
        }
      }
    }
    localObject = null;
    label164:
    b((String)localObject);
    localObject = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initUserData  - defaultAccount=");
    localStringBuilder.append(localGetSmobaDefaultRoleRsp);
    Logger.b((String)localObject, localStringBuilder.toString());
    localObject = this.p;
    if (localObject != null) {
      ((ProfileItemInTeamView)localObject).a(this.x);
    }
  }
  
  private final void w()
  {
    Object localObject = (GameDataServerOuterClass.GetSmobaDefaultRoleRsp)((IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class)).a().getValue();
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showSmobaAccountSelectDialog  - defaultAccount=");
    localStringBuilder.append(localObject);
    Logger.b(str, localStringBuilder.toString());
    if (localObject != null)
    {
      x();
      return;
    }
    localObject = new ProfileBaseInfoDialog.showSmobaAccountSelectDialog.bindListener.1(this);
    ((IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class)).a(this.w, true, null, (IUserSmobaInfoService.BindSmobaAccountCallback)localObject);
  }
  
  private final void x()
  {
    ProfileBaseInfoDialog.realChangeRole.cb.1 local1 = new ProfileBaseInfoDialog.realChangeRole.cb.1(this);
    ((IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class)).a(this.w, (IUserSmobaInfoService.SwitchSmobaAccountCallback)local1);
  }
  
  private final Map<String, String> y()
  {
    Map localMap = (Map)new HashMap(this.A);
    localMap.put("yes_leave_reason", "0");
    Object localObject = this.B;
    if (localObject != null)
    {
      ((Number)localObject).longValue();
      localObject = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(this.B.longValue());
      if (localObject != null)
      {
        localObject = ((IRoomGetDataService)localObject).b(this.x.uid.get());
        if (localObject != null)
        {
          localObject = ((YoloRoomOuterClass.YoloRoomSpeakingPosInfo)localObject).in_speaking_time;
          if (localObject != null)
          {
            i1 = ((PBUInt32Field)localObject).get();
            break label125;
          }
        }
      }
      int i1 = 0;
      label125:
      long l2 = System.currentTimeMillis() / 1000 - i1;
      long l1 = l2;
      if (l2 < 0L) {
        l1 = 0L;
      }
      localMap.put("yes_stay_duration", String.valueOf(l1));
    }
    return localMap;
  }
  
  private final boolean z()
  {
    Object localObject = this.B;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      ((Number)localObject).longValue();
      localObject = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(this.B.longValue());
      bool1 = bool2;
      if (localObject != null) {
        bool1 = ((IRoomGetDataService)localObject).a(this.x.uid.get());
      }
    }
    return bool1;
  }
  
  @NotNull
  protected final TextView a(int paramInt1, int paramInt2, int paramInt3)
  {
    MediumBoldTextView localMediumBoldTextView = new MediumBoldTextView(this.e);
    ViewExKt.a((View)localMediumBoldTextView, LayoutExKt.b(4), new int[] { paramInt3 });
    localMediumBoldTextView.setGravity(17);
    localMediumBoldTextView.setTextSize(1, 17.0F);
    localMediumBoldTextView.setTextColor(paramInt2);
    localMediumBoldTextView.setText(paramInt1);
    return (TextView)localMediumBoldTextView;
  }
  
  @Nullable
  public String a()
  {
    return f();
  }
  
  public final void a(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    ViewGroup localViewGroup = this.k;
    if (localViewGroup != null) {
      ViewExKt.a((View)localViewGroup, true);
    }
    localViewGroup = this.k;
    if (localViewGroup != null) {
      localViewGroup.addView(paramView, new ViewGroup.LayoutParams(-1, -2));
    }
    d(paramView);
  }
  
  protected final void a(@NotNull View... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "views");
    Object localObject = this.l;
    if (localObject != null) {
      ViewExKt.a((View)localObject, true);
    }
    localObject = this.l;
    if (localObject != null) {
      ((LinearLayout)localObject).removeAllViews();
    }
    int i2 = paramVarArgs.length;
    int i3 = (int)UITools.a(this.e, 6.0F);
    int i1 = 0;
    while (i1 < i2)
    {
      localObject = new LinearLayout.LayoutParams(0, -1);
      ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
      if (i1 != 0) {
        ((LinearLayout.LayoutParams)localObject).leftMargin = i3;
      }
      if (i1 != i2 - 1) {
        ((LinearLayout.LayoutParams)localObject).rightMargin = i3;
      }
      LinearLayout localLinearLayout = this.l;
      if (localLinearLayout != null) {
        localLinearLayout.addView(paramVarArgs[i1], (ViewGroup.LayoutParams)localObject);
      }
      i1 += 1;
    }
  }
  
  public abstract void b();
  
  public boolean d()
  {
    return true;
  }
  
  public void dismiss()
  {
    a("dismiss start ");
    super.dismiss();
    this.u = true;
    a("dismiss end ======");
  }
  
  protected final boolean e()
  {
    return this.t;
  }
  
  @NotNull
  public final String f()
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = ((ProfileUserInfoView)localObject).a();
      if (localObject != null) {
        return localObject;
      }
    }
    return "";
  }
  
  protected final boolean g()
  {
    ITGRelationshipService localITGRelationshipService = (ITGRelationshipService)ServiceCenter.a(ITGRelationshipService.class);
    long l1 = this.x.uid.get();
    AppRuntime localAppRuntime = this.w.getAppRuntime();
    Intrinsics.checkExpressionValueIsNotNull(localAppRuntime, "activity.appRuntime");
    return localITGRelationshipService.a(String.valueOf(l1), localAppRuntime);
  }
  
  protected final void h()
  {
    View localView = this.r;
    if (localView != null) {
      localView.setBackgroundColor(0);
    }
    this.f = false;
  }
  
  @Nullable
  public final View i()
  {
    return this.o;
  }
  
  @Nullable
  public final View j()
  {
    return this.j;
  }
  
  @Nullable
  public final View k()
  {
    return this.d;
  }
  
  @Nullable
  protected final View l()
  {
    if (z())
    {
      Object localObject = a(2131917193, -16777216, Color.parseColor("#F5F5F5"));
      ((TextView)localObject).setOnClickListener((View.OnClickListener)new ProfileBaseInfoDialog.addMasterMicExitView.1(this));
      localObject = (View)localObject;
      a(new View[] { localObject });
      return localObject;
    }
    return null;
  }
  
  @NotNull
  protected final QBaseActivity m()
  {
    return this.w;
  }
  
  @NotNull
  protected final CommonOuterClass.QQUserId n()
  {
    return this.x;
  }
  
  protected final boolean o()
  {
    return this.z;
  }
  
  public void onClick(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "v");
    if (!NoDoubleClickUtils.a())
    {
      int i1 = paramView.getId();
      if (i1 == 2131437978)
      {
        dismiss();
      }
      else if (i1 == 2131430808)
      {
        dismiss();
      }
      else if (i1 == 2131445105)
      {
        if (d()) {
          w();
        }
      }
      else if (i1 == 2131444660)
      {
        TimiGameAccusationApi.a(String.valueOf(this.x.uid.get()));
        dismiss();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    a("onCreate start ");
    super.onCreate(paramBundle);
    a("onCreate end ");
  }
  
  protected void onStart()
  {
    a("onStart start ");
    super.onStart();
    a("onStart end ");
  }
  
  @NotNull
  protected final Map<String, String> p()
  {
    return this.A;
  }
  
  @Nullable
  protected final Long q()
  {
    return this.B;
  }
  
  public final boolean r()
  {
    return this.C;
  }
  
  public void show()
  {
    a("show start ");
    super.show();
    a("show end ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.profile.impl.dialog.ProfileBaseInfoDialog
 * JD-Core Version:    0.7.0.1
 */