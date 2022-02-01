package com.tencent.timi.game.team.impl.input;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.team.impl.main.IWidgetListener;
import com.tencent.timi.game.team.impl.operate.ITeamActionBtn;
import com.tencent.timi.game.team.impl.operate.ITeamMicBtn;
import com.tencent.timi.game.team.impl.operate.ITeamSpeakerBtn;
import com.tencent.timi.game.team.impl.operate.TeamActionBtnView;
import com.tencent.timi.game.team.impl.operate.TeamMicView;
import com.tencent.timi.game.team.impl.operate.TeamSpeakerView;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;

public class TeamOperateView
  extends LinearLayout
  implements View.OnClickListener, IWidgetListener
{
  private TeamOperateView.OnActionClickListener a;
  private ImageView b;
  private ImageView c;
  private TeamActionBtnView d;
  private TeamSpeakerView e;
  private TeamMicView f;
  private boolean g;
  
  public TeamOperateView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public TeamOperateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public TeamOperateView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    b();
    c();
    d();
    e();
  }
  
  private void b()
  {
    setGravity(17);
  }
  
  private void c()
  {
    inflate(getContext(), 2131629505, this);
  }
  
  private void d()
  {
    this.b = ((ImageView)findViewById(2131446905));
    this.c = ((ImageView)findViewById(2131446904));
    this.d = ((TeamActionBtnView)findViewById(2131446903));
    this.e = ((TeamSpeakerView)findViewById(2131446908));
    this.f = ((TeamMicView)findViewById(2131446907));
  }
  
  private void e()
  {
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
  }
  
  public void a(YoloRoomOuterClass.YoloRoomInfo paramYoloRoomInfo)
  {
    long l = paramYoloRoomInfo.room_id.get();
    this.d.a(l);
    if (this.g)
    {
      this.f.a(l);
      this.e.a(l);
      return;
    }
    this.f.setVisibility(8);
    this.e.setVisibility(8);
  }
  
  public ITeamActionBtn getActionBtn()
  {
    return this.d;
  }
  
  public View getGiftBtn()
  {
    return this.c;
  }
  
  public ITeamMicBtn getMicBtn()
  {
    return this.f;
  }
  
  public ITeamSpeakerBtn getSpeakerBtn()
  {
    return this.e;
  }
  
  public void onClick(View paramView)
  {
    TeamOperateView.OnActionClickListener localOnActionClickListener;
    if (paramView.getId() == 2131446905)
    {
      localOnActionClickListener = this.a;
      if (localOnActionClickListener != null) {
        localOnActionClickListener.a(paramView);
      }
    }
    else if (paramView.getId() == 2131446904)
    {
      localOnActionClickListener = this.a;
      if (localOnActionClickListener != null) {
        localOnActionClickListener.b(paramView);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setOnActionClickListener(TeamOperateView.OnActionClickListener paramOnActionClickListener)
  {
    this.a = paramOnActionClickListener;
  }
  
  public void setVoiceEnable(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.input.TeamOperateView
 * JD-Core Version:    0.7.0.1
 */