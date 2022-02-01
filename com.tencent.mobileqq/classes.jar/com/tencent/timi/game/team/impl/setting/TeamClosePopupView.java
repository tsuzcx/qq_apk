package com.tencent.timi.game.team.impl.setting;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.datareport.api.IReportService;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.wrapper.IRoomGetDataService;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.router.ServiceCenter;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;

public class TeamClosePopupView
  extends LinearLayout
  implements View.OnClickListener
{
  private TextView a;
  private TextView b;
  private PopupWindow c;
  private TeamClosePopupView.OnActionClickListener d;
  private YoloRoomOuterClass.YoloRoomInfo e;
  private long f;
  
  public TeamClosePopupView(Context paramContext, long paramLong)
  {
    super(paramContext);
    a(paramLong);
  }
  
  private void a()
  {
    setOrientation(1);
    setPadding(0, 0, ViewUtils.dip2px(16.0F), 0);
  }
  
  private void a(long paramLong)
  {
    this.f = paramLong;
    a();
    c();
    d();
    b();
  }
  
  private void b()
  {
    this.a.setOnClickListener(this);
    this.b.setOnClickListener(this);
  }
  
  private void b(long paramLong)
  {
    ((IReportService)ServiceCenter.a(IReportService.class)).a(this.c.getContentView(), "pg_yes_smoba_team");
    this.e = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(paramLong).b();
    if (this.e != null)
    {
      ((IReportService)ServiceCenter.a(IReportService.class)).a(this.a, false, "收起车队按钮", "em_yes_minsize_team", YoloRoomUtil.c(this.e));
      ((IReportService)ServiceCenter.a(IReportService.class)).a(this.b, false, "退出车队按钮", "em_yes_leave_team", YoloRoomUtil.c(this.e));
    }
  }
  
  private void c()
  {
    inflate(getContext(), 2131629498, this);
  }
  
  private void d()
  {
    this.a = ((TextView)findViewById(2131446913));
    this.b = ((TextView)findViewById(2131446914));
  }
  
  public void a(View paramView)
  {
    this.c = new PopupWindow(this, -2, -2);
    this.c.setOutsideTouchable(true);
    this.c.showAsDropDown(paramView);
    b(this.f);
    if (this.e != null)
    {
      ((IReportService)ServiceCenter.a(IReportService.class)).a("imp", this.b, YoloRoomUtil.c(this.e));
      ((IReportService)ServiceCenter.a(IReportService.class)).a("imp", this.a, YoloRoomUtil.c(this.e));
    }
  }
  
  public void onClick(View paramView)
  {
    TeamClosePopupView.OnActionClickListener localOnActionClickListener;
    if (paramView.getId() == 2131446913)
    {
      localOnActionClickListener = this.d;
      if (localOnActionClickListener != null) {
        localOnActionClickListener.a();
      }
    }
    else if (paramView.getId() == 2131446914)
    {
      localOnActionClickListener = this.d;
      if (localOnActionClickListener != null) {
        localOnActionClickListener.b();
      }
    }
    this.c.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setOnActionClickListener(TeamClosePopupView.OnActionClickListener paramOnActionClickListener)
  {
    this.d = paramOnActionClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.setting.TeamClosePopupView
 * JD-Core Version:    0.7.0.1
 */