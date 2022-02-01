package com.tencent.mobileqq.guild.live.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.live.livemanager.model.QQGuildLiveGiftMsgModel;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

public class GuildLiveGiftMsgAnimView
  extends LinearLayout
{
  private final String a = "QGL.GiftMsgAnimView";
  private final Handler b = new Handler(Looper.getMainLooper());
  private LinkedList<QQGuildLiveGiftMsgModel> c = new LinkedList();
  private ValueAnimator d;
  private final Runnable e = new GuildLiveGiftMsgAnimView.1(this);
  private boolean f;
  private boolean g;
  private ImageView h;
  private TextView i;
  private TextView j;
  private ImageView k;
  private final Runnable l = new GuildLiveGiftMsgAnimView.2(this);
  
  public GuildLiveGiftMsgAnimView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GuildLiveGiftMsgAnimView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GuildLiveGiftMsgAnimView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    inflate(paramContext, 2131625068, this);
    setBackgroundResource(2130840928);
    setOrientation(0);
    setGravity(16);
    this.h = ((ImageView)findViewById(2131434631));
    this.i = ((TextView)findViewById(2131434632));
    this.j = ((TextView)findViewById(2131434629));
    this.k = ((ImageView)findViewById(2131434630));
    setAlpha(0.0F);
  }
  
  private void a()
  {
    if (!this.c.isEmpty())
    {
      b();
      return;
    }
    this.g = false;
  }
  
  private void b()
  {
    if (!this.f) {
      return;
    }
    if (this.c.isEmpty()) {
      return;
    }
    d();
    QQGuildLiveGiftMsgModel localQQGuildLiveGiftMsgModel = (QQGuildLiveGiftMsgModel)this.c.poll();
    if (localQQGuildLiveGiftMsgModel != null)
    {
      String str = localQQGuildLiveGiftMsgModel.b();
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
      this.i.setText((CharSequence)localObject);
      this.j.setText(String.format(getResources().getString(2131890441), new Object[] { localQQGuildLiveGiftMsgModel.c() }));
      if (localQQGuildLiveGiftMsgModel.a() != null) {
        this.h.setImageDrawable(localQQGuildLiveGiftMsgModel.a());
      }
      if (localQQGuildLiveGiftMsgModel.d() != null) {
        this.k.setImageDrawable(localQQGuildLiveGiftMsgModel.d());
      }
    }
    setAlpha(1.0F);
    c();
    this.g = true;
  }
  
  private void c()
  {
    this.b.postDelayed(this.e, 1000L);
    this.b.postDelayed(this.l, 500L);
  }
  
  private void d()
  {
    ValueAnimator localValueAnimator = this.d;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      this.d.cancel();
    }
    this.b.removeCallbacksAndMessages(null);
  }
  
  private void e()
  {
    ValueAnimator localValueAnimator = this.d;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      this.d.cancel();
    }
    this.d = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.d.addUpdateListener(new GuildLiveGiftMsgAnimView.3(this));
    this.d.setDuration(500L);
    this.d.start();
  }
  
  public void a(@NonNull QQGuildLiveGiftMsgModel paramQQGuildLiveGiftMsgModel, boolean paramBoolean)
  {
    try
    {
      LinkedList localLinkedList = this.c;
      if (localLinkedList == null) {
        return;
      }
      if (this.c.size() >= 60) {
        this.c.pollFirst();
      }
      if (paramBoolean) {
        this.c.addFirst(paramQQGuildLiveGiftMsgModel);
      } else {
        this.c.addLast(paramQQGuildLiveGiftMsgModel);
      }
      paramBoolean = this.g;
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
    QLog.i("QGL.GiftMsgAnimView", 1, "onAttachedToWindow");
    this.f = true;
    b();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.f = false;
    d();
    this.g = false;
    QLog.i("QGL.GiftMsgAnimView", 1, "onDetachedFromWindow");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.widget.GuildLiveGiftMsgAnimView
 * JD-Core Version:    0.7.0.1
 */