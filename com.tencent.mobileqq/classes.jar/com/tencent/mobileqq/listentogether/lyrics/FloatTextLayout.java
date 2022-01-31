package com.tencent.mobileqq.listentogether.lyrics;

import actj;
import ajya;
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
import arsp;
import arsq;
import arsr;
import artc;

public class FloatTextLayout
  extends FloatBaseLayout
  implements View.OnClickListener, artc
{
  View a;
  public arsr a;
  boolean d = true;
  
  public FloatTextLayout(@NonNull Context paramContext)
  {
    super(paramContext);
    f();
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131560623, null);
    this.jdField_a_of_type_Arsr = ((arsr)this.jdField_a_of_type_AndroidViewView.findViewById(2131369620));
    this.jdField_a_of_type_Arsr.setStrokeColor(-1);
    this.jdField_a_of_type_Arsr.setStrokeWidth(actj.a(1.5F, getResources()));
    ((TextView)this.jdField_a_of_type_Arsr).setTextColor(-8293377);
    ((TextView)this.jdField_a_of_type_Arsr).getPaint().setFakeBoldText(true);
    ((TextView)this.jdField_a_of_type_Arsr).setTextSize(1, 18.0F);
    ((TextView)this.jdField_a_of_type_Arsr).setOnClickListener(this);
    ((TextView)this.jdField_a_of_type_Arsr).setContentDescription(ajya.a(2131704646));
    this.jdField_b_of_type_Int = actj.a(40.0F, getResources());
    int i = (int)getResources().getDimension(2131297158);
    int j = getResources().getDisplayMetrics().widthPixels;
    this.jdField_a_of_type_Int = ((int)(Math.min(j * 0.85F, j - actj.a(16.0F, getResources())) - i));
    this.jdField_a_of_type_Arsr.setLineMaxWidth(this.jdField_a_of_type_Int);
    addView(this.jdField_a_of_type_AndroidViewView, new FrameLayout.LayoutParams(-2, this.jdField_b_of_type_Int));
    this.jdField_a_of_type_Arsr.setOnSizeChangeListener(this);
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = this.jdField_b_of_type_Int;
  }
  
  public int a(arsq paramarsq)
  {
    if (paramarsq.jdField_a_of_type_Boolean) {
      return paramarsq.jdField_a_of_type_Int + paramarsq.jdField_c_of_type_Int / 2;
    }
    return paramarsq.jdField_a_of_type_Int - paramarsq.jdField_c_of_type_Int / 2 - this.jdField_a_of_type_Int;
  }
  
  public arsr a()
  {
    return this.jdField_a_of_type_Arsr;
  }
  
  public void a(arsq paramarsq)
  {
    if (paramarsq == null) {}
    label138:
    label143:
    label146:
    for (;;)
    {
      return;
      Object localObject;
      int i;
      if ((paramarsq.f) && (!paramarsq.g) && (!paramarsq.jdField_b_of_type_Boolean))
      {
        if (!paramarsq.jdField_c_of_type_Boolean) {
          this.jdField_a_of_type_Arsr.setAlign(Paint.Align.CENTER);
        }
      }
      else
      {
        this.d = paramarsq.jdField_a_of_type_Boolean;
        localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        i = ((FrameLayout.LayoutParams)localObject).gravity;
        if (!paramarsq.jdField_c_of_type_Boolean) {
          break label143;
        }
        if (!this.d) {
          break label138;
        }
        i = 5;
      }
      for (;;)
      {
        if (((FrameLayout.LayoutParams)localObject).gravity == i) {
          break label146;
        }
        ((FrameLayout.LayoutParams)localObject).gravity = i;
        this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        return;
        if (paramarsq.jdField_a_of_type_Boolean) {}
        for (localObject = Paint.Align.RIGHT;; localObject = Paint.Align.LEFT)
        {
          this.jdField_a_of_type_Arsr.setAlign((Paint.Align)localObject);
          break;
        }
        i = 3;
        continue;
        i = 1;
      }
    }
  }
  
  public boolean a(arsq paramarsq)
  {
    boolean bool = true;
    if (paramarsq == null) {
      return false;
    }
    if ((paramarsq.f) && (!paramarsq.g) && (!paramarsq.jdField_b_of_type_Boolean)) {
      if (a()) {}
    }
    for (;;)
    {
      return bool;
      bool = false;
      continue;
      if (b()) {
        bool = false;
      }
    }
  }
  
  public int b(arsq paramarsq)
  {
    return paramarsq.jdField_b_of_type_Int - this.jdField_b_of_type_Int / 2;
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_Arsr != null)
    {
      this.jdField_a_of_type_Arsr.setOnSizeChangeListener(null);
      this.jdField_a_of_type_Arsr.c();
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != this.jdField_a_of_type_Int) && (this.jdField_a_of_type_Arsp != null)) {
      this.jdField_a_of_type_Arsp.b(paramInt1, paramInt2);
    }
  }
  
  public boolean b()
  {
    boolean bool = super.b();
    if (this.jdField_a_of_type_Arsr != null) {
      this.jdField_a_of_type_Arsr.c();
    }
    return bool;
  }
  
  public void e()
  {
    int i = (int)getResources().getDimension(2131297158);
    int j = getResources().getDisplayMetrics().widthPixels;
    this.jdField_a_of_type_Int = ((int)(Math.min(j * 0.85F, j - actj.a(16.0F, getResources())) - i));
    this.jdField_a_of_type_Arsr.setLineMaxWidth(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = this.jdField_a_of_type_Int;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Arsp != null) {
      this.jdField_a_of_type_Arsp.b();
    }
  }
  
  public void setFloatWidth(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.lyrics.FloatTextLayout
 * JD-Core Version:    0.7.0.1
 */