package com.tencent.mobileqq.listentogether.lyrics;

import aekt;
import alpo;
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
import atjk;
import atjl;
import atjm;
import atjx;

public class FloatTextLayout
  extends FloatBaseLayout
  implements View.OnClickListener, atjx
{
  View a;
  public atjm a;
  boolean d = true;
  
  public FloatTextLayout(@NonNull Context paramContext)
  {
    super(paramContext);
    f();
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131560798, null);
    this.jdField_a_of_type_Atjm = ((atjm)this.jdField_a_of_type_AndroidViewView.findViewById(2131369884));
    this.jdField_a_of_type_Atjm.setStrokeColor(-1);
    this.jdField_a_of_type_Atjm.setStrokeWidth(aekt.a(1.5F, getResources()));
    ((TextView)this.jdField_a_of_type_Atjm).setTextColor(-8293377);
    ((TextView)this.jdField_a_of_type_Atjm).getPaint().setFakeBoldText(true);
    ((TextView)this.jdField_a_of_type_Atjm).setTextSize(1, 18.0F);
    ((TextView)this.jdField_a_of_type_Atjm).setOnClickListener(this);
    ((TextView)this.jdField_a_of_type_Atjm).setContentDescription(alpo.a(2131705018));
    this.jdField_b_of_type_Int = aekt.a(40.0F, getResources());
    int i = (int)getResources().getDimension(2131297175);
    int j = getResources().getDisplayMetrics().widthPixels;
    this.jdField_a_of_type_Int = ((int)(Math.min(j * 0.85F, j - aekt.a(16.0F, getResources())) - i));
    this.jdField_a_of_type_Atjm.setLineMaxWidth(this.jdField_a_of_type_Int);
    addView(this.jdField_a_of_type_AndroidViewView, new FrameLayout.LayoutParams(-2, this.jdField_b_of_type_Int));
    this.jdField_a_of_type_Atjm.setOnSizeChangeListener(this);
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = this.jdField_b_of_type_Int;
  }
  
  public int a(atjl paramatjl)
  {
    if (paramatjl.jdField_a_of_type_Boolean) {
      return paramatjl.jdField_a_of_type_Int + paramatjl.jdField_c_of_type_Int / 2;
    }
    return paramatjl.jdField_a_of_type_Int - paramatjl.jdField_c_of_type_Int / 2 - this.jdField_a_of_type_Int;
  }
  
  public atjm a()
  {
    return this.jdField_a_of_type_Atjm;
  }
  
  public void a(atjl paramatjl)
  {
    if (paramatjl == null) {}
    label138:
    label143:
    label146:
    for (;;)
    {
      return;
      Object localObject;
      int i;
      if ((paramatjl.f) && (!paramatjl.g) && (!paramatjl.jdField_b_of_type_Boolean))
      {
        if (!paramatjl.jdField_c_of_type_Boolean) {
          this.jdField_a_of_type_Atjm.setAlign(Paint.Align.CENTER);
        }
      }
      else
      {
        this.d = paramatjl.jdField_a_of_type_Boolean;
        localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        i = ((FrameLayout.LayoutParams)localObject).gravity;
        if (!paramatjl.jdField_c_of_type_Boolean) {
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
        if (paramatjl.jdField_a_of_type_Boolean) {}
        for (localObject = Paint.Align.RIGHT;; localObject = Paint.Align.LEFT)
        {
          this.jdField_a_of_type_Atjm.setAlign((Paint.Align)localObject);
          break;
        }
        i = 3;
        continue;
        i = 1;
      }
    }
  }
  
  public boolean a(atjl paramatjl)
  {
    boolean bool = true;
    if (paramatjl == null) {
      return false;
    }
    if ((paramatjl.f) && (!paramatjl.g) && (!paramatjl.jdField_b_of_type_Boolean)) {
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
  
  public int b(atjl paramatjl)
  {
    return paramatjl.jdField_b_of_type_Int - this.jdField_b_of_type_Int / 2;
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_Atjm != null)
    {
      this.jdField_a_of_type_Atjm.setOnSizeChangeListener(null);
      this.jdField_a_of_type_Atjm.c();
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != this.jdField_a_of_type_Int) && (this.jdField_a_of_type_Atjk != null)) {
      this.jdField_a_of_type_Atjk.b(paramInt1, paramInt2);
    }
  }
  
  public boolean b()
  {
    boolean bool = super.b();
    if (this.jdField_a_of_type_Atjm != null) {
      this.jdField_a_of_type_Atjm.c();
    }
    return bool;
  }
  
  public void e()
  {
    int i = (int)getResources().getDimension(2131297175);
    int j = getResources().getDisplayMetrics().widthPixels;
    this.jdField_a_of_type_Int = ((int)(Math.min(j * 0.85F, j - aekt.a(16.0F, getResources())) - i));
    this.jdField_a_of_type_Atjm.setLineMaxWidth(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = this.jdField_a_of_type_Int;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Atjk != null) {
      this.jdField_a_of_type_Atjk.b();
    }
  }
  
  public void setFloatWidth(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.lyrics.FloatTextLayout
 * JD-Core Version:    0.7.0.1
 */