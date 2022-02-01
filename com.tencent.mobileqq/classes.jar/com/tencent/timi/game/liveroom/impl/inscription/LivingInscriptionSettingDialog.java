package com.tencent.timi.game.liveroom.impl.inscription;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.timi.game.base.ui.TimiGamePageLoadingView;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.component.qqlive.api.TgLiveAnchorUserInfo;
import com.tencent.timi.game.datareport.api.ILiveReportService;
import com.tencent.timi.game.datareport.api.ILiveReportService.DefaultImpls;
import com.tencent.timi.game.ex.LayoutExKt;
import com.tencent.timi.game.ex.ViewExKt;
import com.tencent.timi.game.liveroom.impl.inscription.net.GetAnchorGameRoleListRequest;
import com.tencent.timi.game.liveroom.impl.inscription.net.SetAnchorGameEquipRoleRequest;
import com.tencent.timi.game.liveroom.impl.report.TGReportUtil;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.ui.widget.BaseSlideUpDialog;
import com.tencent.timi.game.ui.widget.CommonDialog;
import com.tencent.timi.game.ui.widget.CommonDialog.Builder;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.NoDoubleClickUtils;
import com.tencent.widget.Switch;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.SmobaGameRoleAbsInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/inscription/LivingInscriptionSettingDialog;", "Lcom/tencent/timi/game/ui/widget/BaseSlideUpDialog;", "Landroid/view/View$OnClickListener;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "dialogContext", "Landroid/content/Context;", "roomId", "", "gameId", "", "(Landroid/content/Context;JI)V", "TAG", "", "accountTitleText", "Landroid/view/View;", "closeEmptyView", "commitRoleListener", "com/tencent/timi/game/liveroom/impl/inscription/LivingInscriptionSettingDialog$commitRoleListener$1", "Lcom/tencent/timi/game/liveroom/impl/inscription/LivingInscriptionSettingDialog$commitRoleListener$1;", "getGameId", "()I", "isFinished", "", "isOpenEquip", "isReport", "livingInscriptionSettingListener", "Lcom/tencent/timi/game/liveroom/impl/inscription/LivingInscriptionSettingListener;", "getLivingInscriptionSettingListener", "()Lcom/tencent/timi/game/liveroom/impl/inscription/LivingInscriptionSettingListener;", "setLivingInscriptionSettingListener", "(Lcom/tencent/timi/game/liveroom/impl/inscription/LivingInscriptionSettingListener;)V", "loadingView", "Lcom/tencent/timi/game/base/ui/TimiGamePageLoadingView;", "roleInfoListLinear", "Landroid/widget/LinearLayout;", "roleInfoScrollView", "roleList", "", "Ltrpc/yes/common/GameDataServerOuterClass$SmobaGameRoleAbsInfo;", "roleListListener", "com/tencent/timi/game/liveroom/impl/inscription/LivingInscriptionSettingDialog$roleListListener$1", "Lcom/tencent/timi/game/liveroom/impl/inscription/LivingInscriptionSettingDialog$roleListListener$1;", "rootView", "Landroid/view/ViewGroup;", "selectedRolePosition", "switchButton", "Lcom/tencent/widget/Switch;", "acquireReportModuleMap", "", "commitRole", "", "dismiss", "hideLoadingView", "initItemView", "view", "info", "initView", "itemSelected", "index", "loadRoleData", "onCheckedChanged", "buttonView", "Landroid/widget/CompoundButton;", "isChecked", "onClick", "v", "report", "setRoleListData", "setSwitchWithoutListener", "checked", "setViewStateWhenChecked", "showCloseSwitchDialog", "showLoadingView", "showSelectDialog", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class LivingInscriptionSettingDialog
  extends BaseSlideUpDialog
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public static final LivingInscriptionSettingDialog.Companion a = new LivingInscriptionSettingDialog.Companion(null);
  private final String b;
  private ViewGroup c;
  private Switch d;
  private View i;
  private LinearLayout j;
  private View k;
  private View l;
  private TimiGamePageLoadingView m;
  private boolean n;
  private List<GameDataServerOuterClass.SmobaGameRoleAbsInfo> o;
  private int p;
  @Nullable
  private LivingInscriptionSettingListener q;
  private boolean r;
  private final LivingInscriptionSettingDialog.roleListListener.1 s;
  private boolean t;
  private final LivingInscriptionSettingDialog.commitRoleListener.1 u;
  private final long v;
  private final int w;
  
  public LivingInscriptionSettingDialog(@NotNull Context paramContext, long paramLong, int paramInt)
  {
    super(paramContext);
    this.v = paramLong;
    this.w = paramInt;
    this.b = "LivingInscriptionSettingDialog";
    this.o = ((List)new ArrayList());
    this.p = -1;
    this.s = new LivingInscriptionSettingDialog.roleListListener.1(this);
    setContentView(2131629451);
    f();
    this.u = new LivingInscriptionSettingDialog.commitRoleListener.1(this);
  }
  
  private final void a(int paramInt)
  {
    this.p = paramInt;
    LinearLayout localLinearLayout = this.j;
    if (localLinearLayout != null)
    {
      int i3 = localLinearLayout.getChildCount();
      int i1 = 0;
      while (i1 < i3)
      {
        int i2;
        if (i1 == paramInt) {
          i2 = 1;
        } else {
          i2 = 0;
        }
        if (i2 != 0) {
          i2 = 2130852992;
        } else {
          i2 = 2130852991;
        }
        ImageView localImageView = (ImageView)localLinearLayout.getChildAt(i1).findViewById(2131445509);
        if (localImageView != null) {
          localImageView.setImageResource(i2);
        }
        i1 += 1;
      }
    }
  }
  
  private final void a(View paramView, GameDataServerOuterClass.SmobaGameRoleAbsInfo paramSmobaGameRoleAbsInfo)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131445111);
    if (localTextView != null) {
      localTextView.setText((CharSequence)paramSmobaGameRoleAbsInfo.role_name.get());
    }
    paramView = (TextView)paramView.findViewById(2131445103);
    if (paramView != null) {
      paramView.setText((CharSequence)paramSmobaGameRoleAbsInfo.role_desc.get());
    }
  }
  
  private final void a(boolean paramBoolean)
  {
    Switch localSwitch = this.d;
    if (localSwitch != null) {
      localSwitch.setOnCheckedChangeListener(null);
    }
    localSwitch = this.d;
    if (localSwitch != null) {
      localSwitch.setChecked(paramBoolean);
    }
    e();
    localSwitch = this.d;
    if (localSwitch != null) {
      localSwitch.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)this);
    }
  }
  
  private final void b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= this.o.size()))
    {
      String str = ((GameDataServerOuterClass.SmobaGameRoleAbsInfo)this.o.get(paramInt)).role_name.get();
      Object localObject = this.e;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
      localObject = new CommonDialog.Builder((Context)localObject);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("确认将展示的游戏角色修改为 ");
      localStringBuilder.append(str);
      localStringBuilder.append(" 吗？");
      ((CommonDialog.Builder)localObject).c(localStringBuilder.toString()).e("取消").b((DialogInterface.OnClickListener)LivingInscriptionSettingDialog.showSelectDialog.1.a).d("确认").a((DialogInterface.OnClickListener)new LivingInscriptionSettingDialog.showSelectDialog.2(this, paramInt)).a().show();
    }
  }
  
  private final void e()
  {
    Object localObject = this.d;
    boolean bool2 = false;
    boolean bool1;
    if (localObject != null) {
      bool1 = ((Switch)localObject).isChecked();
    } else {
      bool1 = false;
    }
    localObject = this.k;
    if (localObject != null) {
      ViewExKt.a((View)localObject, bool1);
    }
    localObject = this.i;
    if (localObject != null) {
      ViewExKt.a((View)localObject, bool1);
    }
    localObject = this.l;
    if (localObject != null)
    {
      if (!bool1) {
        bool2 = true;
      }
      ViewExKt.a((View)localObject, bool2);
    }
  }
  
  private final void f()
  {
    Object localObject = findViewById(2131437978);
    if (localObject != null) {
      ((View)localObject).setOnClickListener((View.OnClickListener)this);
    }
    localObject = findViewById(2131430808);
    if (localObject != null) {
      ((View)localObject).setOnClickListener((View.OnClickListener)this);
    }
    this.i = findViewById(2131445107);
    this.d = ((Switch)findViewById(2131446673));
    this.j = ((LinearLayout)findViewById(2131445106));
    this.k = findViewById(2131427420);
    this.l = findViewById(2131430809);
    this.c = ((ViewGroup)findViewById(2131445143));
    this.m = ((TimiGamePageLoadingView)findViewById(2131437626));
    localObject = this.c;
    if (localObject != null) {
      b((View)localObject);
    }
    h();
  }
  
  private final void g()
  {
    if (this.t) {
      return;
    }
    Object localObject = findViewById(2131431872);
    if (localObject != null) {
      ((ILiveReportService)ServiceCenter.a(ILiveReportService.class)).a(localObject, "pg_qqlive_anchorlive", (Map)TGReportUtil.a.a());
    }
    localObject = this.c;
    if (localObject != null) {
      ((ILiveReportService)ServiceCenter.a(ILiveReportService.class)).a((View)localObject, true, null, "em_qqlive_equipshow_board", b());
    }
    localObject = this.d;
    if (localObject != null)
    {
      ILiveReportService.DefaultImpls.a((ILiveReportService)ServiceCenter.a(ILiveReportService.class), (View)localObject, true, null, "em_qqlive_equipshow_switch", null, 16, null);
      VideoReport.setEventDynamicParams(localObject, (IDynamicParams)new LivingInscriptionSettingDialog.report..inlined.let.lambda.1(this));
    }
    this.t = true;
  }
  
  private final void h()
  {
    Object localObject1 = (ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class);
    if (localObject1 != null)
    {
      localObject2 = ((ITgLiveRoomService)localObject1).f();
      if (localObject2 != null)
      {
        l1 = ((LiveUserInfo)localObject2).uid;
        break label38;
      }
    }
    long l1 = 0L;
    label38:
    if (localObject1 != null)
    {
      localObject1 = ((ITgLiveRoomService)localObject1).i(this.v);
      if (localObject1 != null)
      {
        localObject1 = ((TgLiveAnchorUserInfo)localObject1).d;
        if (localObject1 != null) {
          break label73;
        }
      }
    }
    localObject1 = "";
    label73:
    Object localObject2 = this.d;
    if (localObject2 != null) {
      ViewExKt.a((View)localObject2, false);
    }
    GetAnchorGameRoleListRequest.a.a((String)localObject1, this.w, l1, (IResultListener)this.s);
  }
  
  private final void i()
  {
    Object localObject1 = this.j;
    if (localObject1 != null) {
      ((LinearLayout)localObject1).removeAllViews();
    }
    int i2 = LayoutExKt.b(80);
    localObject1 = ((Iterable)this.o).iterator();
    int i1 = 0;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i1 < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      Object localObject3 = (GameDataServerOuterClass.SmobaGameRoleAbsInfo)localObject2;
      localObject2 = LayoutInflater.from(this.e).inflate(2131629450, null);
      ((View)localObject2).setOnClickListener((View.OnClickListener)new LivingInscriptionSettingDialog.setRoleListData..inlined.forEachIndexed.lambda.1(i1, this, i2));
      if (((GameDataServerOuterClass.SmobaGameRoleAbsInfo)localObject3).is_default.get()) {
        this.p = i1;
      }
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "view");
      a((View)localObject2, (GameDataServerOuterClass.SmobaGameRoleAbsInfo)localObject3);
      localObject3 = this.j;
      if (localObject3 != null) {
        ((LinearLayout)localObject3).addView((View)localObject2, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, i2));
      }
      i1 += 1;
    }
    if (this.p == -1) {
      this.p = 0;
    }
    a(this.p);
  }
  
  private final void j()
  {
    Context localContext = this.e;
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    new CommonDialog.Builder(localContext).c("是否关闭出装铭文展示").e("取消").b((DialogInterface.OnClickListener)LivingInscriptionSettingDialog.showCloseSwitchDialog.1.a).d("确认").a((DialogInterface.OnClickListener)new LivingInscriptionSettingDialog.showCloseSwitchDialog.2(this)).a().show();
  }
  
  private final void k()
  {
    int i1 = this.p;
    if ((i1 >= 0) && (i1 < this.o.size()))
    {
      Object localObject1 = (ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class);
      if (localObject1 != null)
      {
        localObject2 = ((ITgLiveRoomService)localObject1).f();
        if (localObject2 != null)
        {
          l1 = ((LiveUserInfo)localObject2).uid;
          break label63;
        }
      }
      long l1 = 0L;
      label63:
      if (localObject1 != null)
      {
        localObject1 = ((ITgLiveRoomService)localObject1).i(this.v);
        if (localObject1 != null)
        {
          localObject1 = ((TgLiveAnchorUserInfo)localObject1).d;
          if (localObject1 != null) {
            break label106;
          }
        }
      }
      localObject1 = "";
      label106:
      Object localObject2 = (GameDataServerOuterClass.SmobaGameRoleAbsInfo)this.o.get(this.p);
      Switch localSwitch = this.d;
      boolean bool;
      if (localSwitch != null) {
        bool = localSwitch.isChecked();
      } else {
        bool = true;
      }
      if (bool) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      d();
      SetAnchorGameEquipRoleRequest.a.a((String)localObject1, ((GameDataServerOuterClass.SmobaGameRoleAbsInfo)localObject2).area.get(), ((GameDataServerOuterClass.SmobaGameRoleAbsInfo)localObject2).partition.get(), i1, l1, this.v, (IResultListener)this.u);
    }
  }
  
  @Nullable
  public final LivingInscriptionSettingListener a()
  {
    return this.q;
  }
  
  public final void a(@Nullable LivingInscriptionSettingListener paramLivingInscriptionSettingListener)
  {
    this.q = paramLivingInscriptionSettingListener;
  }
  
  @NotNull
  protected final Map<String, String> b()
  {
    Map localMap = (Map)new LinkedHashMap();
    localMap.put("zengzhi_moduleid", "em_qqlive_equipshow_entrance");
    return localMap;
  }
  
  public final void c()
  {
    TimiGamePageLoadingView localTimiGamePageLoadingView = this.m;
    if (localTimiGamePageLoadingView != null) {
      localTimiGamePageLoadingView.b();
    }
  }
  
  public final void d()
  {
    TimiGamePageLoadingView localTimiGamePageLoadingView = this.m;
    if (localTimiGamePageLoadingView != null) {
      localTimiGamePageLoadingView.setHintText(2131917232);
    }
    localTimiGamePageLoadingView = this.m;
    if (localTimiGamePageLoadingView != null) {
      localTimiGamePageLoadingView.a();
    }
  }
  
  public void dismiss()
  {
    this.n = true;
    super.dismiss();
  }
  
  public void onCheckedChanged(@Nullable CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      a(true);
      j();
    }
    else
    {
      e();
      k();
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  public void onClick(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "v");
    if (!NoDoubleClickUtils.a())
    {
      int i1 = paramView.getId();
      if ((i1 == 2131437978) || (i1 == 2131430808)) {
        dismiss();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.inscription.LivingInscriptionSettingDialog
 * JD-Core Version:    0.7.0.1
 */