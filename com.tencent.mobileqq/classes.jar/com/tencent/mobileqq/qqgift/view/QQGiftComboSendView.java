package com.tencent.mobileqq.qqgift.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qqgift.mvvm.business.banner.BannerResManager;
import com.tencent.mobileqq.qqgift.utils.LongClickHandler;
import com.tencent.mobileqq.qqgift.utils.ThreadManager;
import com.tencent.mobileqq.qqgift.view.anim.ComboBoomAnimation;
import com.tencent.mobileqq.qqgift.view.anim.ComboCountDownAnimation;
import com.tencent.mobileqq.qqgift.view.anim.ComboSendBtnAnimation;
import com.tencent.mobileqq.qqgift.view.anim.ComboStimulateEnterAnimation;
import com.tencent.mobileqq.qqgift.view.anim.ComboWaveAnimation;
import com.tencent.mobileqq.qqgift.view.anim.CountDownEndListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

public class QQGiftComboSendView
  extends FrameLayout
  implements CountDownEndListener
{
  private QQGiftComboSendViewListener a;
  private int b = 1;
  private int c = -1;
  private int d = 2147483647;
  private long e = 0L;
  private int f = 0;
  private int g = 2130847975;
  private final ImageView h;
  private final ImageView i;
  private final TextView j;
  private final LongClickHandler k;
  private final ComboCountDownAnimation l;
  private final ComboSendBtnAnimation m;
  private final ComboWaveAnimation n;
  private final ComboBoomAnimation o;
  private final ComboSendBtnAnimation p;
  private final ComboStimulateEnterAnimation q;
  private BannerResManager r;
  
  public QQGiftComboSendView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(paramContext).inflate(2131627978, this, true);
    this.h = ((ImageView)findViewById(2131446393));
    this.p = new ComboSendBtnAnimation(this.h);
    this.q = new ComboStimulateEnterAnimation(this.h);
    paramContext = (QQGiftCircleProgress)findViewById(2131440726);
    paramContext.setStrokeWidth(ImmersiveUtils.dpToPx(1.0F));
    paramContext.setBgAndProgressColor(0, 0, 100, Color.parseColor("#FFE99F"));
    paramContext.setProgress(100.0F);
    this.l = new ComboCountDownAnimation(paramContext, 3000);
    this.l.a(this);
    this.n = new ComboWaveAnimation(findViewById(2131450039));
    this.o = new ComboBoomAnimation(findViewById(2131429607));
    this.j = ((TextView)findViewById(2131431016));
    this.i = ((ImageView)findViewById(2131445580));
    this.m = new ComboSendBtnAnimation(this.i);
    this.i.setOnClickListener(new QQGiftComboSendView.1(this, 200));
    this.k = new LongClickHandler(this.i);
    this.k.a(new QQGiftComboSendView.2(this), 200);
  }
  
  private void c()
  {
    QQGiftComboSendViewListener localQQGiftComboSendViewListener = this.a;
    if (localQQGiftComboSendViewListener != null)
    {
      int i1 = this.f;
      if (i1 > 0) {
        localQQGiftComboSendViewListener.a(i1, this.b);
      }
    }
    this.f = 0;
  }
  
  private void d()
  {
    this.l.b();
    this.l.a();
    g();
  }
  
  private void e()
  {
    g();
  }
  
  private void f()
  {
    if (this.h.getVisibility() != 0)
    {
      this.h.setVisibility(0);
      this.q.a();
      return;
    }
    this.q.b();
    this.p.a();
  }
  
  private void g()
  {
    if (this.b == this.d)
    {
      this.a.g();
      return;
    }
    f();
    this.m.a();
    this.b += 1;
    QQGiftComboSendViewListener localQQGiftComboSendViewListener = this.a;
    if (localQQGiftComboSendViewListener != null) {
      localQQGiftComboSendViewListener.b(this.b);
    }
    m();
    l();
    j();
    long l1 = System.currentTimeMillis();
    this.f += 1;
    if (this.b == this.d)
    {
      c();
      return;
    }
    if (l1 - this.e > 1000L)
    {
      this.e = l1;
      ThreadManager.a(new QQGiftComboSendView.DelaySendRunnable(this, null), 1000L);
    }
  }
  
  private int getCurrentLevel()
  {
    int i1 = this.b;
    if (i1 < 10) {
      return 1;
    }
    if (i1 < 50) {
      return 2;
    }
    if (i1 < 100) {
      return 3;
    }
    return 4;
  }
  
  private void h()
  {
    this.l.b();
    g();
  }
  
  private void i()
  {
    this.l.a();
  }
  
  private void j()
  {
    int i1 = getCurrentLevel();
    if (i1 != this.c)
    {
      this.c = i1;
      k();
    }
  }
  
  private void k()
  {
    this.n.a(this.c);
    this.h.setImageBitmap(this.r.f(this.c));
    this.i.setImageBitmap(this.r.g(this.c));
  }
  
  private void l()
  {
    int i1 = this.b;
    if ((i1 == 7) || (i1 == 17) || (i1 == 47)) {
      this.o.b();
    }
  }
  
  private void m()
  {
    TextView localTextView = this.j;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("x");
    localStringBuilder.append(this.b);
    localTextView.setText(localStringBuilder.toString());
    int i1 = this.b;
    if (i1 / 10 == 0)
    {
      if (this.g != 2130847975)
      {
        this.g = 2130847975;
        this.j.setBackgroundResource(2130847975);
      }
      return;
    }
    if (i1 / 100 == 0)
    {
      if (this.g != 2130847976)
      {
        this.g = 2130847976;
        this.j.setBackgroundResource(2130847976);
      }
      return;
    }
    if (this.g != 2130847977)
    {
      this.g = 2130847977;
      this.j.setBackgroundResource(2130847977);
    }
  }
  
  public void a()
  {
    c();
    this.k.a();
    this.h.setVisibility(0);
    this.n.b();
    this.l.b();
    this.c = -1;
    this.b = 1;
    this.f = 0;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2)
    {
      QLog.e("QQGiftComboSendView", 1, "initCombo > maxCombo");
      return;
    }
    this.b = paramInt1;
    this.d = paramInt2;
    m();
    j();
    this.l.a();
    this.n.a(this.c);
  }
  
  public void a(BannerResManager paramBannerResManager)
  {
    this.r = paramBannerResManager;
  }
  
  public void b()
  {
    c();
    QQGiftComboSendViewListener localQQGiftComboSendViewListener = this.a;
    if (localQQGiftComboSendViewListener != null) {
      localQQGiftComboSendViewListener.c(this.b);
    }
  }
  
  public int getCurComboNum()
  {
    return this.b;
  }
  
  public void setComboListener(QQGiftComboSendViewListener paramQQGiftComboSendViewListener)
  {
    this.a = paramQQGiftComboSendViewListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.view.QQGiftComboSendView
 * JD-Core Version:    0.7.0.1
 */