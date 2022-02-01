package com.tencent.timi.game.profile.impl.dialog;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.timi.game.ex.LayoutExKt;
import com.tencent.timi.game.ex.ViewExKt;
import com.tencent.timi.game.profile.api.ProfileReportUtil;
import com.tencent.timi.game.profile.api.listener.FleetProfileClickListener;
import com.tencent.timi.game.profile.impl.report.ProfileFleetReport;
import com.tencent.timi.game.profile.impl.view.SexAtView;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.wrapper.IRoomGetDataService;
import com.tencent.timi.game.router.ServiceCenter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomDataInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/profile/impl/dialog/FleetProfileDialogImpl;", "Lcom/tencent/timi/game/profile/impl/dialog/ProfileBaseInfoDialog;", "activity", "Lcom/tencent/mobileqq/app/QBaseActivity;", "userId", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "isCaptain", "", "reportParamMap", "", "", "roomId", "", "(Lcom/tencent/mobileqq/app/QBaseActivity;Ltrpc/yes/common/CommonOuterClass$QQUserId;ZLjava/util/Map;J)V", "clickListener", "Lcom/tencent/timi/game/profile/api/listener/FleetProfileClickListener;", "profileFleetReport", "Lcom/tencent/timi/game/profile/impl/report/ProfileFleetReport;", "selfQQUserId", "getSelfQQUserId", "()Ltrpc/yes/common/CommonOuterClass$QQUserId;", "setSelfQQUserId", "(Ltrpc/yes/common/CommonOuterClass$QQUserId;)V", "acquireAddFriendShowFlag", "addBottomView", "", "addOperationView", "canChangeRole", "init", "setItemClickListener", "listener", "", "setReceiveVoiceState", "needShow", "isReceiveVoice", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class FleetProfileDialogImpl
  extends ProfileBaseInfoDialog
{
  private FleetProfileClickListener a;
  @Nullable
  private CommonOuterClass.QQUserId b;
  private ProfileFleetReport c;
  
  public FleetProfileDialogImpl(@NotNull QBaseActivity paramQBaseActivity, @NotNull CommonOuterClass.QQUserId paramQQUserId, boolean paramBoolean, @NotNull Map<String, String> paramMap, long paramLong)
  {
    super(paramQBaseActivity, paramQQUserId, false, paramBoolean, paramMap, Long.valueOf(paramLong), false);
  }
  
  private final boolean u()
  {
    Object localObject = q();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      long l = ((Number)localObject).longValue();
      localObject = (IRoomService)ServiceCenter.a(IRoomService.class);
      if (localObject != null)
      {
        localObject = ((IRoomService)localObject).a(l);
        if (localObject != null)
        {
          localObject = ((IRoomGetDataService)localObject).b();
          if (localObject != null)
          {
            localObject = ((YoloRoomOuterClass.YoloRoomInfo)localObject).room_data_info;
            if (localObject != null)
            {
              localObject = ((YoloRoomOuterClass.YoloRoomDataInfo)localObject).sub_create_from;
              if (localObject != null)
              {
                i = ((PBInt32Field)localObject).get();
                break label105;
              }
            }
          }
        }
      }
      int i = -1;
      label105:
      if (i != 0)
      {
        bool1 = bool2;
        if (i != 1) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private final void v()
  {
    Object localObject = new FleetProfileDialogImpl.addOperationView.viewClickListener.1(this);
    View localView1 = LayoutInflater.from(this.e).inflate(2131629465, null);
    View localView2 = localView1.findViewById(2131437205);
    if (localView2 != null) {
      ViewExKt.a(localView2, o());
    }
    localView2 = localView1.findViewById(2131439654);
    if (localView2 != null) {
      ViewExKt.a(localView2, o());
    }
    localView2 = localView1.findViewById(2131439655);
    if (localView2 != null) {
      ViewExKt.a(localView2, LayoutExKt.b(10), new int[] { Color.parseColor("#80F5F5F5") });
    }
    localView2 = localView1.findViewById(2131439656);
    if (localView2 != null) {
      ViewExKt.a(localView2, LayoutExKt.b(10), new int[] { Color.parseColor("#80F5F5F5") });
    }
    localView2 = localView1.findViewById(2131439654);
    if (localView2 != null) {
      localView2.setOnClickListener((View.OnClickListener)localObject);
    }
    localView2 = localView1.findViewById(2131439650);
    if (localView2 != null) {
      ViewExKt.a(localView2, false);
    }
    localView2 = localView1.findViewById(2131439652);
    if (localView2 != null) {
      ViewExKt.a(localView2, false);
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
    localObject = this.c;
    if (localObject != null) {
      ((ProfileFleetReport)localObject).a(localView1.findViewById(2131439645));
    }
    localObject = this.c;
    if (localObject != null) {
      ((ProfileFleetReport)localObject).b(localView1.findViewById(2131439647));
    }
    localObject = this.c;
    if (localObject != null) {
      ((ProfileFleetReport)localObject).c(localView1.findViewById(2131439654));
    }
  }
  
  private final void w()
  {
    Object localObject;
    ProfileFleetReport localProfileFleetReport;
    if (!e())
    {
      if ((u()) && (!g()))
      {
        localObject = a(2131917189, -1, Color.parseColor("#F5A300"));
        ((TextView)localObject).setOnClickListener((View.OnClickListener)new FleetProfileDialogImpl.addBottomView.1(this));
        localObject = (View)localObject;
        a(new View[] { localObject });
        localProfileFleetReport = this.c;
        if (localProfileFleetReport != null) {
          localProfileFleetReport.d((View)localObject);
        }
      }
    }
    else
    {
      localObject = a(2131917194, -16777216, Color.parseColor("#F5F5F5"));
      ((TextView)localObject).setOnClickListener((View.OnClickListener)new FleetProfileDialogImpl.addBottomView.2(this));
      localObject = (View)localObject;
      a(new View[] { localObject });
      localProfileFleetReport = this.c;
      if (localProfileFleetReport != null) {
        localProfileFleetReport.f((View)localObject);
      }
    }
  }
  
  public void a(@Nullable Object paramObject)
  {
    if ((paramObject instanceof FleetProfileClickListener)) {
      this.a = ((FleetProfileClickListener)paramObject);
    }
  }
  
  public final void a(@Nullable CommonOuterClass.QQUserId paramQQUserId)
  {
    this.b = paramQQUserId;
  }
  
  public void b()
  {
    ProfileReportUtil.a.a(this, "pg_yes_smoba_team");
    h();
    this.c = new ProfileFleetReport(p());
    if (!e()) {
      v();
    }
    w();
    ProfileFleetReport localProfileFleetReport = this.c;
    if (localProfileFleetReport != null) {
      localProfileFleetReport.a(e(), i());
    }
    localProfileFleetReport = this.c;
    if (localProfileFleetReport != null) {
      localProfileFleetReport.e(j());
    }
  }
  
  @Nullable
  public final CommonOuterClass.QQUserId c()
  {
    return this.b;
  }
  
  public boolean d()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.profile.impl.dialog.FleetProfileDialogImpl
 * JD-Core Version:    0.7.0.1
 */