package com.tencent.timi.game.liveroom.impl.notice;

import android.content.Context;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoomOperation;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.component.qqlive.api.TgLiveAnchorUserInfo;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.ui.widget.BaseSlideUpDialog;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.Logger;
import java.util.ArrayList;

public class TimiNoticeDialog
  extends BaseSlideUpDialog
  implements View.OnClickListener, SimpleEventReceiver
{
  private ImageView a;
  private ImageView b;
  private TextView c;
  private ConstraintLayout d;
  private LinearLayout i;
  private View j;
  private long k;
  private long l;
  private String m;
  
  public TimiNoticeDialog(Context paramContext, long paramLong1, long paramLong2)
  {
    super(paramContext);
    this.k = paramLong1;
    this.l = paramLong2;
  }
  
  private void a()
  {
    this.a = ((ImageView)findViewById(2131439432));
    this.b = ((ImageView)findViewById(2131439429));
    this.c = ((TextView)findViewById(2131439431));
    this.d = ((ConstraintLayout)findViewById(2131439430));
    this.i = ((LinearLayout)findViewById(2131439433));
    this.j = findViewById(2131439434);
    this.c.setMovementMethod(LinkMovementMethod.getInstance());
    b(this.d);
    c(this.j);
  }
  
  public static void a(Context paramContext, long paramLong)
  {
    BaseRoomInfo localBaseRoomInfo = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).h(paramLong);
    TgLiveAnchorUserInfo localTgLiveAnchorUserInfo = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).i(paramLong);
    if ((localBaseRoomInfo != null) && (localTgLiveAnchorUserInfo != null))
    {
      long l1 = localTgLiveAnchorUserInfo.getAnchorUid();
      if ((paramLong != 0L) && (l1 != 0L))
      {
        new TimiNoticeDialog(paramContext, paramLong, l1).show();
        return;
      }
      CustomToastView.a("获取roomId、anchorId失败");
      return;
    }
    CustomToastView.a("进房失败");
  }
  
  private void b()
  {
    this.a.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.d.setOnClickListener(this);
    setOnDismissListener(new TimiNoticeDialog.1(this));
  }
  
  private void c()
  {
    d();
  }
  
  private void d()
  {
    ILiveRoomOperation localILiveRoomOperation = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).k(this.k);
    if (localILiveRoomOperation != null) {
      localILiveRoomOperation.getRoomAnnounce(this.k, new TimiNoticeDialog.2(this));
    }
  }
  
  private void e()
  {
    TimiNoticeEditFragment.a(getContext(), this.m, this.k, this.l);
  }
  
  private void f()
  {
    dismiss();
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(UpdateNoticeEvent.class);
    return localArrayList;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131439432) {
      e();
    } else if (paramView.getId() == 2131439429) {
      f();
    } else if (paramView.getId() == 2131439434) {
      f();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131629453);
    a();
    b();
    c();
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof UpdateNoticeEvent))
    {
      Logger.a("Timi_Notice", "onReceiveEvent : UpdateNoticeEvent");
      d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.notice.TimiNoticeDialog
 * JD-Core Version:    0.7.0.1
 */