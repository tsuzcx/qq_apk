package com.tencent.mobileqq.guild.navigatebar;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.troop.navigatebar.AioTips;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import java.util.Observer;

public class GuildAioTips
  extends AioTips
{
  GuildAioMsgNavigateBar a;
  protected GestureDetector b = null;
  
  public GuildAioTips(AIOContext paramAIOContext)
  {
    this.a = new GuildAioMsgNavigateBar(paramAIOContext);
  }
  
  protected void a()
  {
    this.a.a(this.D, this.E, this.K, this.F, this.G, this.I, this.J, this.L);
    this.b = new GestureDetector(this.E, new GuildAioTips.1(this));
    this.g = false;
    this.h = 0L;
    this.i = 0L;
    this.j = false;
  }
  
  public void a(int paramInt)
  {
    if (this.M) {
      this.a.c(paramInt);
    }
  }
  
  public void a(long paramLong)
  {
    if (this.M) {
      this.a.a(paramLong);
    }
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    this.g = true;
    this.h = paramLong1;
    this.i = paramLong2;
    this.j = paramBoolean;
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    if (this.M)
    {
      GestureDetector localGestureDetector = this.b;
      if (localGestureDetector != null) {
        localGestureDetector.onTouchEvent(paramMotionEvent);
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, Observer paramObserver, BaseSessionInfo paramBaseSessionInfo, RelativeLayout paramRelativeLayout, ChatAdapter1 paramChatAdapter1, ChatXListView paramChatXListView, ScrollerRunnable paramScrollerRunnable)
  {
    super.a(paramQQAppInterface, paramContext, paramObserver, paramBaseSessionInfo, paramRelativeLayout, paramChatAdapter1, paramChatXListView, paramScrollerRunnable);
    if (paramBaseSessionInfo.a == 10014)
    {
      if (!this.M)
      {
        this.M = true;
        a();
      }
    }
    else {
      this.M = false;
    }
  }
  
  protected void b()
  {
    this.a.v();
    this.g = false;
    this.h = 0L;
    this.i = 0L;
    this.j = false;
  }
  
  public void b(int paramInt)
  {
    if (this.M) {
      this.a.k();
    }
  }
  
  public GuildAioMsgNavigateBar c()
  {
    return this.a;
  }
  
  public boolean c(int paramInt)
  {
    if (this.M) {
      return this.a.d(paramInt);
    }
    return false;
  }
  
  public boolean cB_()
  {
    if (this.M) {
      return this.a.e();
    }
    return false;
  }
  
  public void d()
  {
    if ((this.M) && (!this.k)) {
      this.a.l();
    }
  }
  
  public void e()
  {
    if (this.M) {
      this.a.q();
    }
  }
  
  public boolean g()
  {
    if (this.M) {
      return this.a.j();
    }
    return false;
  }
  
  public boolean h()
  {
    if (this.M) {
      return this.a.j();
    }
    return false;
  }
  
  public int i()
  {
    if (this.M)
    {
      GuildAioMsgNavigateBar localGuildAioMsgNavigateBar = this.a;
      if (localGuildAioMsgNavigateBar != null) {
        return localGuildAioMsgNavigateBar.r();
      }
    }
    return -1;
  }
  
  public void j() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.navigatebar.GuildAioTips
 * JD-Core Version:    0.7.0.1
 */