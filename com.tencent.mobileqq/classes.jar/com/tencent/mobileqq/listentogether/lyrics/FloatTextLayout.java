package com.tencent.mobileqq.listentogether.lyrics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint.Align;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class FloatTextLayout
  extends FloatBaseLayout
  implements View.OnClickListener, OnSizeChangeListener
{
  public ILyricView o;
  boolean p = true;
  View q;
  
  public FloatTextLayout(@NonNull Context paramContext)
  {
    super(paramContext);
    i();
  }
  
  private void i()
  {
    this.q = LayoutInflater.from(getContext()).inflate(2131627278, null);
    this.o = ((ILyricView)this.q.findViewById(2131437793));
    this.o.setStrokeColor(-1);
    this.o.setStrokeWidth(AIOUtils.b(1.5F, getResources()));
    ((TextView)this.o).setTextColor(-8293377);
    ((TextView)this.o).getPaint().setFakeBoldText(true);
    ((TextView)this.o).setTextSize(1, 18.0F);
    ((TextView)this.o).setOnClickListener(this);
    ((TextView)this.o).setContentDescription(HardCodeUtil.a(2131902645));
    this.c = AIOUtils.b(40.0F, getResources());
    int i = (int)getResources().getDimension(2131297752);
    int j = getResources().getDisplayMetrics().widthPixels;
    this.b = ((int)(Math.min(j * 0.85F, j - AIOUtils.b(16.0F, getResources())) - i));
    this.o.setLineMaxWidth(this.b);
    addView(this.q, new FrameLayout.LayoutParams(-2, this.c));
    this.o.setOnSizeChangeListener(this);
    this.e.width = this.b;
    this.e.height = this.c;
  }
  
  public void a(FloatParams paramFloatParams)
  {
    if (paramFloatParams == null) {
      return;
    }
    if ((paramFloatParams.k) && (!paramFloatParams.l) && (!paramFloatParams.f)) {
      if (!paramFloatParams.h)
      {
        this.o.setAlign(Paint.Align.CENTER);
      }
      else
      {
        if (paramFloatParams.e) {
          localObject = Paint.Align.RIGHT;
        } else {
          localObject = Paint.Align.LEFT;
        }
        this.o.setAlign((Paint.Align)localObject);
      }
    }
    this.p = paramFloatParams.e;
    Object localObject = (FrameLayout.LayoutParams)this.q.getLayoutParams();
    int i = ((FrameLayout.LayoutParams)localObject).gravity;
    if (paramFloatParams.h)
    {
      if (this.p) {
        i = 5;
      } else {
        i = 3;
      }
    }
    else {
      i = 1;
    }
    if (((FrameLayout.LayoutParams)localObject).gravity != i)
    {
      ((FrameLayout.LayoutParams)localObject).gravity = i;
      this.q.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != this.b) && (this.a != null)) {
      this.a.b(paramInt1, paramInt2);
    }
  }
  
  public boolean b(FloatParams paramFloatParams)
  {
    if (paramFloatParams == null) {
      return false;
    }
    boolean bool;
    if ((paramFloatParams.k) && (!paramFloatParams.l) && (!paramFloatParams.f)) {
      bool = a();
    } else {
      bool = c();
    }
    return bool ^ true;
  }
  
  public int c(FloatParams paramFloatParams)
  {
    if (paramFloatParams.e) {
      return paramFloatParams.a + paramFloatParams.c / 2;
    }
    return paramFloatParams.a - paramFloatParams.c / 2 - this.b;
  }
  
  public boolean c()
  {
    boolean bool = super.c();
    ILyricView localILyricView = this.o;
    if (localILyricView != null) {
      localILyricView.c();
    }
    return bool;
  }
  
  public int d(FloatParams paramFloatParams)
  {
    return paramFloatParams.b - this.c / 2;
  }
  
  public void e()
  {
    super.e();
    ILyricView localILyricView = this.o;
    if (localILyricView != null)
    {
      localILyricView.setOnSizeChangeListener(null);
      this.o.c();
    }
  }
  
  public ILyricView getLyricView()
  {
    return this.o;
  }
  
  public void h()
  {
    int i = (int)getResources().getDimension(2131297752);
    int j = getResources().getDisplayMetrics().widthPixels;
    this.b = ((int)(Math.min(j * 0.85F, j - AIOUtils.b(16.0F, getResources())) - i));
    this.o.setLineMaxWidth(this.b);
    this.e.width = this.b;
  }
  
  public void onClick(View paramView)
  {
    if (this.a != null) {
      this.a.b();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setFloatWidth(int paramInt)
  {
    this.b = paramInt;
    this.e.width = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.lyrics.FloatTextLayout
 * JD-Core Version:    0.7.0.1
 */