package com.tencent.timi.game.profile.impl.dialog;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.ex.LayoutExKt;
import com.tencent.timi.game.ex.ViewExKt;
import com.tencent.timi.game.profile.api.ProfileReportUtil;
import com.tencent.timi.game.profile.api.listener.CPDDProfileClickListener;
import com.tencent.timi.game.profile.impl.report.ProfileCPDDReport;
import com.tencent.timi.game.profile.impl.view.SexAtView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/profile/impl/dialog/CPDDProfileDialogImpl;", "Lcom/tencent/timi/game/profile/impl/dialog/ProfileBaseInfoDialog;", "activity", "Lcom/tencent/mobileqq/app/QBaseActivity;", "userId", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "isVoiceRoom", "", "reportParamMap", "", "", "roomId", "", "(Lcom/tencent/mobileqq/app/QBaseActivity;Ltrpc/yes/common/CommonOuterClass$QQUserId;ZLjava/util/Map;J)V", "clickListener", "Lcom/tencent/timi/game/profile/api/listener/CPDDProfileClickListener;", "operationReceiveVoice", "Landroid/view/View;", "profileCPDDReport", "Lcom/tencent/timi/game/profile/impl/report/ProfileCPDDReport;", "voiceImage", "Landroid/widget/ImageView;", "addBottomView", "", "addMasterBottomView", "addOperationView", "init", "onClick", "v", "setItemClickListener", "listener", "", "setReceiveVoiceState", "needShow", "isReceiveVoice", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class CPDDProfileDialogImpl
  extends ProfileBaseInfoDialog
{
  private CPDDProfileClickListener a;
  private ImageView b;
  private View c;
  private ProfileCPDDReport d;
  private final boolean i;
  
  public CPDDProfileDialogImpl(@NotNull QBaseActivity paramQBaseActivity, @NotNull CommonOuterClass.QQUserId paramQQUserId, boolean paramBoolean, @NotNull Map<String, String> paramMap, long paramLong)
  {
    super(paramQBaseActivity, paramQQUserId, true, false, paramMap, Long.valueOf(paramLong), true);
    this.i = paramBoolean;
  }
  
  private final void c()
  {
    Object localObject = new CPDDProfileDialogImpl.addOperationView.viewClickListener.1(this);
    View localView1 = LayoutInflater.from(this.e).inflate(2131629465, null);
    this.b = ((ImageView)localView1.findViewById(2131449960));
    this.c = localView1.findViewById(2131439653);
    View localView2 = localView1.findViewById(2131439645);
    if (localView2 != null) {
      localView2.setOnClickListener((View.OnClickListener)localObject);
    }
    localView2 = localView1.findViewById(2131439650);
    if (localView2 != null) {
      localView2.setOnClickListener((View.OnClickListener)new CPDDProfileDialogImpl.addOperationView.1(this));
    }
    localView2 = localView1.findViewById(2131439647);
    if (localView2 != null) {
      localView2.setOnClickListener((View.OnClickListener)localObject);
    }
    localView2 = localView1.findViewById(2131439653);
    if (localView2 != null) {
      localView2.setOnClickListener((View.OnClickListener)localObject);
    }
    localObject = (SexAtView)localView1.findViewById(2131439645);
    if (localObject != null) {
      ((SexAtView)localObject).setUserId(n());
    }
    localObject = localView1.findViewById(2131439655);
    if (localObject != null) {
      ViewExKt.a((View)localObject, LayoutExKt.b(10), new int[] { Color.parseColor("#80F5F5F5") });
    }
    localObject = localView1.findViewById(2131439656);
    if (localObject != null) {
      ViewExKt.a((View)localObject, LayoutExKt.b(10), new int[] { Color.parseColor("#80F5F5F5") });
    }
    Intrinsics.checkExpressionValueIsNotNull(localView1, "operationPanel");
    a(localView1);
    localObject = this.d;
    if (localObject != null) {
      ((ProfileCPDDReport)localObject).a(localView1.findViewById(2131439645));
    }
    localObject = this.d;
    if (localObject != null) {
      ((ProfileCPDDReport)localObject).b(localView1.findViewById(2131439647));
    }
    localObject = this.d;
    if (localObject != null) {
      ((ProfileCPDDReport)localObject).c(localView1.findViewById(2131439650));
    }
  }
  
  private final void u()
  {
    View localView = l();
    if (localView != null)
    {
      ProfileCPDDReport localProfileCPDDReport = this.d;
      if (localProfileCPDDReport != null) {
        localProfileCPDDReport.h(localView);
      }
    }
  }
  
  private final void v()
  {
    int j;
    if (g()) {
      j = 2131917198;
    } else {
      j = 2131917197;
    }
    TextView localTextView = a(j, -16777216, Color.parseColor("#F5F5F5"));
    localTextView.setOnClickListener((View.OnClickListener)new CPDDProfileDialogImpl.addBottomView.1(this));
    if (!g())
    {
      Object localObject2 = a(2131917189, -1, Color.parseColor("#F5A300"));
      ((TextView)localObject2).setOnClickListener((View.OnClickListener)new CPDDProfileDialogImpl.addBottomView.2(this));
      localObject1 = (View)localTextView;
      localObject2 = (View)localObject2;
      a(new View[] { localObject1, localObject2 });
      localObject1 = this.d;
      if (localObject1 != null) {
        ((ProfileCPDDReport)localObject1).e((View)localObject2);
      }
    }
    else
    {
      a(new View[] { (View)localTextView });
    }
    Object localObject1 = this.d;
    if (localObject1 != null) {
      ((ProfileCPDDReport)localObject1).d((View)localTextView);
    }
  }
  
  public void a(@Nullable Object paramObject)
  {
    if ((paramObject instanceof CPDDProfileClickListener)) {
      this.a = ((CPDDProfileClickListener)paramObject);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = this.c;
    if (localObject != null) {
      ViewExKt.a((View)localObject, paramBoolean1);
    }
    localObject = this.b;
    if (localObject != null) {
      ((ImageView)localObject).setSelected(paramBoolean2 ^ true);
    }
  }
  
  public void b()
  {
    ProfileReportUtil.a.a(this, "pg_kl_smoba_cpdd");
    this.d = new ProfileCPDDReport(p());
    if (!e())
    {
      c();
      v();
    }
    else
    {
      u();
    }
    ProfileCPDDReport localProfileCPDDReport = this.d;
    if (localProfileCPDDReport != null) {
      localProfileCPDDReport.a(i(), e());
    }
    localProfileCPDDReport = this.d;
    if (localProfileCPDDReport != null) {
      localProfileCPDDReport.f(j());
    }
    localProfileCPDDReport = this.d;
    if (localProfileCPDDReport != null) {
      localProfileCPDDReport.g(k());
    }
  }
  
  public void onClick(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "v");
    super.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.profile.impl.dialog.CPDDProfileDialogImpl
 * JD-Core Version:    0.7.0.1
 */