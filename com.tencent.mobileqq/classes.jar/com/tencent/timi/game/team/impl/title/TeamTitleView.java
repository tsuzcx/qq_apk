package com.tencent.timi.game.team.impl.title;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.base.TimiGameActivityManager;
import com.tencent.timi.game.datareport.api.IReportService;
import com.tencent.timi.game.logincore.api.ILoginCoreService;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.wrapper.IRoomGetDataService;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.smoba.api.ISmobaService;
import com.tencent.timi.game.team.api.ITeamService;
import com.tencent.timi.game.team.impl.main.IWidgetListener;
import com.tencent.timi.game.team.impl.main.TeamConfigPageHelper;
import com.tencent.timi.game.team.impl.setting.TeamClosePopupView;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomSpeakingPosInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloSmobaGameDataInfo;

public class TeamTitleView
  extends RelativeLayout
  implements View.OnClickListener, IWidgetListener
{
  private static final String a = "TeamTitleView";
  private TextView b;
  private TextView c;
  private TextView d;
  private ImageView e;
  private ImageView f;
  private ImageView g;
  private View.OnClickListener h;
  private long i;
  private YoloRoomOuterClass.YoloRoomInfo j;
  
  public TeamTitleView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public TeamTitleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public TeamTitleView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void b()
  {
    c();
    d();
    e();
  }
  
  private void c()
  {
    inflate(getContext(), 2131629499, this);
  }
  
  private void d()
  {
    this.b = ((TextView)findViewById(2131446899));
    this.c = ((TextView)findViewById(2131446897));
    this.d = ((TextView)findViewById(2131446898));
    this.e = ((ImageView)findViewById(2131446902));
    this.f = ((ImageView)findViewById(2131446901));
    this.g = ((ImageView)findViewById(2131446896));
  }
  
  private void e()
  {
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
  }
  
  private void f()
  {
    QBaseActivity localQBaseActivity = TimiGameActivityManager.a();
    if (localQBaseActivity != null)
    {
      YoloRoomOuterClass.YoloRoomSpeakingPosInfo localYoloRoomSpeakingPosInfo = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(this.j.room_id.get()).b(((ILoginCoreService)ServiceCenter.a(ILoginCoreService.class)).a());
      if ((localYoloRoomSpeakingPosInfo != null) && (localYoloRoomSpeakingPosInfo.guild_id.get() != 0L))
      {
        IGuildMainFrameApi localIGuildMainFrameApi = (IGuildMainFrameApi)QRoute.api(IGuildMainFrameApi.class);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localYoloRoomSpeakingPosInfo.guild_id.get());
        localStringBuilder.append("");
        localIGuildMainFrameApi.openTeamSharePage(localQBaseActivity, localStringBuilder.toString(), this.j.room_id.get());
      }
    }
  }
  
  private void g()
  {
    QBaseActivity localQBaseActivity = TimiGameActivityManager.a();
    if (localQBaseActivity != null) {
      TeamConfigPageHelper.a(localQBaseActivity, this.i);
    }
  }
  
  private void h()
  {
    TeamClosePopupView localTeamClosePopupView = new TeamClosePopupView(getContext(), this.i);
    localTeamClosePopupView.setOnActionClickListener(new TeamTitleView.1(this));
    localTeamClosePopupView.a(this.g);
  }
  
  public void a()
  {
    Object localObject2 = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(this.i).g();
    Object localObject1 = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(this.i).b();
    if ((localObject2 != null) && (localObject1 != null))
    {
      TextView localTextView = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((ISmobaService)ServiceCenter.a(ISmobaService.class)).a(((YoloRoomOuterClass.YoloSmobaGameDataInfo)localObject2).grade_list.get()));
      localStringBuilder.append(" | ");
      localTextView.setText(localStringBuilder.toString());
      this.d.setText(((YoloRoomOuterClass.YoloSmobaGameDataInfo)localObject2).mode_name.get());
      this.b.setText(((YoloRoomOuterClass.YoloRoomInfo)localObject1).introduce.get());
    }
    localObject2 = this.f;
    int k;
    if (((ITeamService)ServiceCenter.a(ITeamService.class)).b(this.i)) {
      k = 0;
    } else {
      k = 8;
    }
    ((ImageView)localObject2).setVisibility(k);
    this.e.setVisibility(8);
    localObject1 = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(((YoloRoomOuterClass.YoloRoomInfo)localObject1).room_id.get()).b(((ILoginCoreService)ServiceCenter.a(ILoginCoreService.class)).a());
    if ((localObject1 != null) && (((YoloRoomOuterClass.YoloRoomSpeakingPosInfo)localObject1).guild_id.get() != 0L)) {
      this.e.setVisibility(0);
    }
  }
  
  public void a(long paramLong)
  {
    ((IReportService)ServiceCenter.a(IReportService.class)).a(this, "pg_yes_smoba_team");
    YoloRoomOuterClass.YoloRoomInfo localYoloRoomInfo = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(paramLong).b();
    ((IReportService)ServiceCenter.a(IReportService.class)).a(this.f, true, "设置按钮", "em_yes_config", YoloRoomUtil.c(localYoloRoomInfo));
  }
  
  public void a(YoloRoomOuterClass.YoloRoomInfo paramYoloRoomInfo)
  {
    this.i = paramYoloRoomInfo.room_id.get();
    this.j = paramYoloRoomInfo;
    a();
    a(paramYoloRoomInfo.room_id.get());
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131446902) {
      f();
    } else if (paramView.getId() == 2131446901) {
      g();
    } else if (paramView.getId() == 2131446896) {
      h();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setOnCollectClickListener(View.OnClickListener paramOnClickListener)
  {
    this.h = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.title.TeamTitleView
 * JD-Core Version:    0.7.0.1
 */