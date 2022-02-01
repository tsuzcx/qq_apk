package com.tencent.mobileqq.gamecenter.media;

import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import androidx.core.util.Pools.Pool;
import com.tencent.mobileqq.text.QQText;

class DanmakuLayout$DrawItem
{
  DanmakuHost.Item a;
  long b = -1L;
  boolean c = true;
  float d;
  int e;
  float f;
  long g;
  int h = 0;
  int i = 0;
  float j = 0.0F;
  TextView k;
  
  private DanmakuLayout$DrawItem(DanmakuLayout paramDanmakuLayout)
  {
    this.k = new TextView(paramDanmakuLayout.getContext());
    this.k.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
  }
  
  private long a(float paramFloat)
  {
    if (paramFloat < 40.0F) {
      return 4000L;
    }
    if (paramFloat <= 50.0F) {
      return 4500L;
    }
    if (paramFloat <= 130.0F) {
      return 5000L;
    }
    return 6000L;
  }
  
  private void b()
  {
    if (this.f == 0.0F)
    {
      this.k.setText(new QQText(this.a.a, 3, 16, -1));
      this.k.measure(0, 0);
      this.h = this.k.getMeasuredWidth();
      this.i = this.k.getMeasuredHeight();
      this.j = (this.h + DanmakuLayout.g(this.l));
      if (this.a.d == 0.0D) {
        this.g = a(this.h);
      } else {
        this.g = ((this.a.d * 1000.0D));
      }
      this.f = (this.j / (float)this.g);
    }
  }
  
  void a()
  {
    this.a = null;
    this.b = -1L;
    this.c = false;
    this.d = 0.0F;
    this.e = 0;
    this.f = 0.0F;
    this.g = 0L;
    this.h = 0;
    this.i = 0;
    this.j = 0.0F;
    this.k.setText("");
    this.k.setBackgroundDrawable(null);
    if (this.k.getParent() != null) {
      this.l.removeView(this.k);
    }
    DanmakuLayout.i(this.l).release(this);
  }
  
  void a(DanmakuHost.Item paramItem)
  {
    this.a = paramItem;
    this.k.setTextSize(0, DanmakuLayout.h(this.l));
    if (this.a.f != 0) {
      this.k.setBackgroundColor(this.a.f);
    }
    this.k.setTextColor(this.a.e);
  }
  
  boolean a(long paramLong, int paramInt)
  {
    if (this.b == -1L) {
      this.b = paramLong;
    }
    b();
    long l1 = this.g;
    if (l1 != 0L) {
      f1 = (float)(paramLong - this.b) / (float)l1;
    } else if (paramLong < this.b) {
      f1 = 0.0F;
    } else {
      f1 = 1.0F;
    }
    if (f1 >= 1.0F) {
      m = 1;
    } else {
      m = 0;
    }
    this.c = (0x1 ^ m);
    float f1 = Math.max(Math.min(f1, 1.0F), 0.0F);
    this.d = (this.j * f1);
    this.e = ((int)(DanmakuLayout.g(this.l) - this.d));
    TextView localTextView = this.k;
    int m = this.e;
    localTextView.layout(m, paramInt, this.h + m, this.i + paramInt);
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.media.DanmakuLayout.DrawItem
 * JD-Core Version:    0.7.0.1
 */