package com.tencent.mobileqq.widget;

import android.graphics.Path;
import android.view.View;
import com.tencent.mobileqq.hotchat.anim.HeartAnimator;
import com.tencent.mobileqq.hotchat.anim.HeartAnimator.Config;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class NearbyZanAnimator
  extends HeartAnimator
{
  public NearbyZanAnimator(HeartLayout paramHeartLayout)
  {
    super(paramHeartLayout);
  }
  
  public Path a(int paramInt1, int paramInt2, AtomicInteger paramAtomicInteger, View paramView)
  {
    Random localRandom = this.a;
    Path localPath = new Path();
    boolean bool = this.b.m;
    int i = 1;
    int j = 1;
    int k;
    int n;
    int m;
    float f1;
    float f2;
    if (!bool)
    {
      if ((paramInt1 >= 0) && (paramInt1 <= paramView.getWidth())) {
        this.b.b = (paramInt1 - (int)(this.b.a * 20.0F / 3.0F));
      } else {
        this.b.b = ((paramView.getWidth() - (int)(this.b.a * 20.0F)) / 2);
      }
      if ((paramInt2 >= 0) && (paramInt2 <= paramView.getHeight())) {
        this.b.c = (paramView.getHeight() - paramInt2 + (int)(this.b.a * 20.0F / 3.0F));
      } else {
        this.b.c = ((int)(this.b.a * 20.0F));
      }
      if (this.a.nextBoolean()) {
        paramInt1 = j;
      } else {
        paramInt1 = -1;
      }
      j = (localRandom.nextInt(this.b.d) + this.b.e) * paramInt1;
      k = (localRandom.nextInt(this.b.d) + this.b.e) * paramInt1;
      n = paramView.getHeight() - this.b.c;
      paramInt2 = (int)(paramAtomicInteger.intValue() * 4 * this.b.a) + this.b.h + localRandom.nextInt(this.b.g);
      m = paramInt2 / this.b.f;
      paramInt1 = n - paramInt2;
      if (paramInt1 < 0) {
        paramInt1 = 0;
      }
      i = n - paramInt2 / 2;
      paramInt2 = i;
      if (i < 0) {
        paramInt2 = 0;
      }
      localPath.moveTo(this.b.b, n);
      f1 = this.b.b;
      f2 = n - m;
      float f3 = this.b.b + j;
      float f4 = paramInt2 + m;
      float f5 = this.b.b + j;
      float f6 = paramInt2;
      localPath.cubicTo(f1, f2, f3, f4, f5, f6);
      localPath.moveTo(this.b.b + j, f6);
      paramInt2 -= m;
      if (paramInt2 >= 0)
      {
        localPath.cubicTo(this.b.b + j, paramInt2, this.b.b + k, m + paramInt1, this.b.b + k, paramInt1);
        return localPath;
      }
    }
    else
    {
      k = this.b.o;
      m = this.b.n;
      n = this.b.i / 2;
      if (!this.a.nextBoolean()) {
        i = -1;
      }
      int i1 = localRandom.nextInt(this.b.d);
      int i2 = this.b.e;
      int i3 = localRandom.nextInt(this.b.d);
      int i4 = this.b.e;
      j = Math.abs(k - paramInt2) / (this.a.nextInt(3) + 2);
      if (k > paramInt2) {
        j = k - j;
      } else {
        j += k;
      }
      localPath.moveTo(paramInt1 - this.b.i / 2, paramInt2 - this.b.j / 2);
      f1 = (i1 + i2) * i + paramInt1;
      f2 = j;
      localPath.cubicTo(f1, f2, paramInt1 - i * (i3 + i4), f2, m - n, k);
    }
    return localPath;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.NearbyZanAnimator
 * JD-Core Version:    0.7.0.1
 */