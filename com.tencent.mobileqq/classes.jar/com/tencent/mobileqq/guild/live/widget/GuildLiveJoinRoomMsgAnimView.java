package com.tencent.mobileqq.guild.live.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

public class GuildLiveJoinRoomMsgAnimView
  extends LinearLayout
{
  private final String a = "QGL.JoinRoomAnimView";
  private final TextView b;
  private final ImageView c;
  private final Handler d = new Handler(Looper.getMainLooper());
  private LinkedList<String> e = new LinkedList();
  private ValueAnimator f;
  private final Runnable g = new GuildLiveJoinRoomMsgAnimView.1(this);
  private boolean h;
  private boolean i;
  private final Runnable j = new GuildLiveJoinRoomMsgAnimView.2(this);
  
  public GuildLiveJoinRoomMsgAnimView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GuildLiveJoinRoomMsgAnimView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GuildLiveJoinRoomMsgAnimView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2131625069, this);
    setBackgroundResource(2130840917);
    setOrientation(0);
    setGravity(16);
    this.b = ((TextView)findViewById(2131434637));
    this.c = ((ImageView)findViewById(2131434635));
  }
  
  private void a()
  {
    if (!this.e.isEmpty())
    {
      b();
      return;
    }
    this.i = false;
  }
  
  private void b()
  {
    if (!this.h) {
      return;
    }
    if (this.e.isEmpty()) {
      return;
    }
    d();
    String str = (String)this.e.poll();
    Object localObject = str;
    if (str != null)
    {
      localObject = str;
      if (str.length() > 10)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str.substring(0, 10));
        ((StringBuilder)localObject).append("...");
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    localObject = String.format(getResources().getString(2131890448), new Object[] { localObject });
    this.b.setText((CharSequence)localObject);
    setAlpha(1.0F);
    c();
    this.i = true;
  }
  
  private void c()
  {
    this.d.postDelayed(this.g, 1000L);
    this.d.postDelayed(this.j, 500L);
  }
  
  private void d()
  {
    ValueAnimator localValueAnimator = this.f;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      this.f.cancel();
    }
    this.d.removeCallbacksAndMessages(null);
  }
  
  private void e()
  {
    ValueAnimator localValueAnimator = this.f;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      this.f.cancel();
    }
    this.f = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.f.addUpdateListener(new GuildLiveJoinRoomMsgAnimView.3(this));
    this.f.setDuration(500L);
    this.f.start();
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    try
    {
      LinkedList localLinkedList = this.e;
      if (localLinkedList == null) {
        return;
      }
      if (this.e.size() >= 60) {
        this.e.pollFirst();
      }
      if (paramBoolean) {
        this.e.addFirst(paramString);
      } else {
        this.e.addLast(paramString);
      }
      paramBoolean = this.i;
      if (paramBoolean) {
        return;
      }
      b();
      return;
    }
    finally {}
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    QLog.i("QGL.JoinRoomAnimView", 1, "onAttachedToWindow");
    ImageView localImageView = this.c;
    if (localImageView != null) {
      localImageView.setImageResource(2130840932);
    }
    this.h = true;
    b();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.h = false;
    d();
    setAlpha(0.0F);
    this.i = false;
    QLog.i("QGL.JoinRoomAnimView", 1, "onDetachedFromWindow");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.widget.GuildLiveJoinRoomMsgAnimView
 * JD-Core Version:    0.7.0.1
 */