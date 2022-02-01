package com.tencent.mobileqq.guild.mainframe.attachcontainer;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.qphone.base.util.QLog;

public class GuildChatFrameGestureManager
{
  private GuildMainViewContext a;
  private ViewGroup b;
  private GuildMainFrameRelativeLayout c;
  private GuildChatFramePosNotifyHelper d;
  private GuildChatFrameLayoutAnimator e;
  private GuildChatFrameGestureHelper f;
  
  public GuildChatFrameGestureManager(GuildMainViewContext paramGuildMainViewContext)
  {
    this.a = paramGuildMainViewContext;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuildChatFrameGestureManager", 2, "onDestroy");
    }
    Object localObject = this.c;
    if (localObject != null) {
      ((GuildMainFrameRelativeLayout)localObject).a();
    }
    localObject = this.d;
    if (localObject != null) {
      ((GuildChatFramePosNotifyHelper)localObject).d();
    }
  }
  
  public void a(View paramView1, View paramView2)
  {
    this.b = ((FrameLayout)paramView2);
    this.c = ((GuildMainFrameRelativeLayout)paramView1);
    this.d = new GuildChatFramePosNotifyHelper(GuildChatFrameGestureUtil.a(), GuildChatFrameGestureUtil.a(this.b.getContext()));
    this.e = new GuildChatFrameLayoutAnimator(this.b, this.d);
    this.c.a(this.a, this.b, this.d, this.e);
    this.f = new GuildChatFrameGestureHelper(this.b, this.e, this.d);
  }
  
  public void a(AbsGestureListener paramAbsGestureListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuildChatFrameGestureManager", 2, "addGestureListener");
    }
    this.d.a(paramAbsGestureListener);
  }
  
  public void a(boolean paramBoolean)
  {
    this.e.a(paramBoolean);
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleOnTouchEvent event = ");
      localStringBuilder.append(paramMotionEvent.getAction());
      QLog.d("GuildChatFrameGestureManager", 2, localStringBuilder.toString());
    }
    return this.f.a(paramMotionEvent);
  }
  
  public void b(AbsGestureListener paramAbsGestureListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuildChatFrameGestureManager", 2, "removeGestureListener");
    }
    this.d.b(paramAbsGestureListener);
  }
  
  public void b(boolean paramBoolean)
  {
    this.e.b(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.attachcontainer.GuildChatFrameGestureManager
 * JD-Core Version:    0.7.0.1
 */