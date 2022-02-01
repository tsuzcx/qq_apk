package com.tencent.timi.game.profile.impl.dialog;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.timi.game.ex.LayoutExKt;
import com.tencent.timi.game.ex.ViewExKt;
import com.tencent.timi.game.profile.api.ProfileReportUtil;
import com.tencent.timi.game.profile.api.listener.CommunityClickListener;
import com.tencent.timi.game.profile.impl.report.ProfileCommunityReport;
import com.tencent.timi.game.profile.impl.view.SexAtView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/profile/impl/dialog/CommunityProfileDialogImpl;", "Lcom/tencent/timi/game/profile/impl/dialog/ProfileBaseInfoDialog;", "activity", "Lcom/tencent/mobileqq/app/QBaseActivity;", "userId", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "reportParamMap", "", "", "roomId", "", "(Lcom/tencent/mobileqq/app/QBaseActivity;Ltrpc/yes/common/CommonOuterClass$QQUserId;Ljava/util/Map;J)V", "clickListener", "Lcom/tencent/timi/game/profile/api/listener/CommunityClickListener;", "profileCommunityReport", "Lcom/tencent/timi/game/profile/impl/report/ProfileCommunityReport;", "addMasterBottomView", "", "addOperationView", "init", "setItemClickListener", "listener", "", "setReceiveVoiceState", "needShow", "", "isReceiveVoice", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class CommunityProfileDialogImpl
  extends ProfileBaseInfoDialog
{
  private CommunityClickListener a;
  private ProfileCommunityReport b;
  
  public CommunityProfileDialogImpl(@NotNull QBaseActivity paramQBaseActivity, @NotNull CommonOuterClass.QQUserId paramQQUserId, @NotNull Map<String, String> paramMap, long paramLong)
  {
    super(paramQBaseActivity, paramQQUserId, true, false, paramMap, Long.valueOf(paramLong), true);
  }
  
  private final void c()
  {
    View localView = l();
    if (localView != null)
    {
      ProfileCommunityReport localProfileCommunityReport = this.b;
      if (localProfileCommunityReport != null) {
        localProfileCommunityReport.f(localView);
      }
    }
  }
  
  private final void u()
  {
    Object localObject = new CommunityProfileDialogImpl.addOperationView.viewClickListener.1(this);
    View localView1 = LayoutInflater.from(this.e).inflate(2131629465, null);
    View localView2 = localView1.findViewById(2131439656);
    if (localView2 != null) {
      ViewExKt.a(localView2, LayoutExKt.b(10), new int[] { Color.parseColor("#80F5F5F5") });
    }
    localView2 = localView1.findViewById(2131439650);
    if (localView2 != null) {
      localView2.setOnClickListener((View.OnClickListener)new CommunityProfileDialogImpl.addOperationView.1(this));
    }
    localView2 = localView1.findViewById(2131439645);
    if (localView2 != null) {
      localView2.setOnClickListener((View.OnClickListener)localObject);
    }
    localView2 = localView1.findViewById(2131439647);
    if (localView2 != null) {
      localView2.setOnClickListener((View.OnClickListener)localObject);
    }
    localObject = (SexAtView)localView1.findViewById(2131439645);
    if (localObject != null) {
      ((SexAtView)localObject).setUserId(n());
    }
    Intrinsics.checkExpressionValueIsNotNull(localView1, "operationPanel");
    a(localView1);
    localObject = this.b;
    if (localObject != null) {
      ((ProfileCommunityReport)localObject).a(localView1.findViewById(2131439645));
    }
    localObject = this.b;
    if (localObject != null) {
      ((ProfileCommunityReport)localObject).b(localView1.findViewById(2131439647));
    }
    localObject = this.b;
    if (localObject != null) {
      ((ProfileCommunityReport)localObject).c(localView1.findViewById(2131439650));
    }
  }
  
  public void a(@Nullable Object paramObject)
  {
    if ((paramObject instanceof CommunityClickListener)) {
      this.a = ((CommunityClickListener)paramObject);
    }
  }
  
  public void b()
  {
    ProfileReportUtil.a.a(this, "pg_sgrp_smoba_cpdd");
    this.b = new ProfileCommunityReport(p());
    if (!e()) {
      u();
    } else {
      c();
    }
    ProfileCommunityReport localProfileCommunityReport = this.b;
    if (localProfileCommunityReport != null) {
      localProfileCommunityReport.a(i(), e());
    }
    localProfileCommunityReport = this.b;
    if (localProfileCommunityReport != null) {
      localProfileCommunityReport.d(j());
    }
    localProfileCommunityReport = this.b;
    if (localProfileCommunityReport != null) {
      localProfileCommunityReport.e(k());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.profile.impl.dialog.CommunityProfileDialogImpl
 * JD-Core Version:    0.7.0.1
 */