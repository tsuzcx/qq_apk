package com.tencent.mobileqq.listentogether.lyrics;

import actn;
import ajyc;
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
import arsn;
import arso;
import arsp;
import arta;

public class FloatTextLayout
  extends FloatBaseLayout
  implements View.OnClickListener, arta
{
  View a;
  public arsp a;
  boolean d = true;
  
  public FloatTextLayout(@NonNull Context paramContext)
  {
    super(paramContext);
    f();
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131560624, null);
    this.jdField_a_of_type_Arsp = ((arsp)this.jdField_a_of_type_AndroidViewView.findViewById(2131369621));
    this.jdField_a_of_type_Arsp.setStrokeColor(-1);
    this.jdField_a_of_type_Arsp.setStrokeWidth(actn.a(1.5F, getResources()));
    ((TextView)this.jdField_a_of_type_Arsp).setTextColor(-8293377);
    ((TextView)this.jdField_a_of_type_Arsp).getPaint().setFakeBoldText(true);
    ((TextView)this.jdField_a_of_type_Arsp).setTextSize(1, 18.0F);
    ((TextView)this.jdField_a_of_type_Arsp).setOnClickListener(this);
    ((TextView)this.jdField_a_of_type_Arsp).setContentDescription(ajyc.a(2131704635));
    this.jdField_b_of_type_Int = actn.a(40.0F, getResources());
    int i = (int)getResources().getDimension(2131297158);
    int j = getResources().getDisplayMetrics().widthPixels;
    this.jdField_a_of_type_Int = ((int)(Math.min(j * 0.85F, j - actn.a(16.0F, getResources())) - i));
    this.jdField_a_of_type_Arsp.setLineMaxWidth(this.jdField_a_of_type_Int);
    addView(this.jdField_a_of_type_AndroidViewView, new FrameLayout.LayoutParams(-2, this.jdField_b_of_type_Int));
    this.jdField_a_of_type_Arsp.setOnSizeChangeListener(this);
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = this.jdField_b_of_type_Int;
  }
  
  public int a(arso paramarso)
  {
    if (paramarso.jdField_a_of_type_Boolean) {
      return paramarso.jdField_a_of_type_Int + paramarso.jdField_c_of_type_Int / 2;
    }
    return paramarso.jdField_a_of_type_Int - paramarso.jdField_c_of_type_Int / 2 - this.jdField_a_of_type_Int;
  }
  
  public arsp a()
  {
    return this.jdField_a_of_type_Arsp;
  }
  
  public void a(arso paramarso)
  {
    if (paramarso == null) {}
    label138:
    label143:
    label146:
    for (;;)
    {
      return;
      Object localObject;
      int i;
      if ((paramarso.f) && (!paramarso.g) && (!paramarso.jdField_b_of_type_Boolean))
      {
        if (!paramarso.jdField_c_of_type_Boolean) {
          this.jdField_a_of_type_Arsp.setAlign(Paint.Align.CENTER);
        }
      }
      else
      {
        this.d = paramarso.jdField_a_of_type_Boolean;
        localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        i = ((FrameLayout.LayoutParams)localObject).gravity;
        if (!paramarso.jdField_c_of_type_Boolean) {
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
        if (paramarso.jdField_a_of_type_Boolean) {}
        for (localObject = Paint.Align.RIGHT;; localObject = Paint.Align.LEFT)
        {
          this.jdField_a_of_type_Arsp.setAlign((Paint.Align)localObject);
          break;
        }
        i = 3;
        continue;
        i = 1;
      }
    }
  }
  
  public boolean a(arso paramarso)
  {
    boolean bool = true;
    if (paramarso == null) {
      return false;
    }
    if ((paramarso.f) && (!paramarso.g) && (!paramarso.jdField_b_of_type_Boolean)) {
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
  
  public int b(arso paramarso)
  {
    return paramarso.jdField_b_of_type_Int - this.jdField_b_of_type_Int / 2;
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_Arsp != null)
    {
      this.jdField_a_of_type_Arsp.setOnSizeChangeListener(null);
      this.jdField_a_of_type_Arsp.c();
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != this.jdField_a_of_type_Int) && (this.jdField_a_of_type_Arsn != null)) {
      this.jdField_a_of_type_Arsn.b(paramInt1, paramInt2);
    }
  }
  
  public boolean b()
  {
    boolean bool = super.b();
    if (this.jdField_a_of_type_Arsp != null) {
      this.jdField_a_of_type_Arsp.c();
    }
    return bool;
  }
  
  public void e()
  {
    int i = (int)getResources().getDimension(2131297158);
    int j = getResources().getDisplayMetrics().widthPixels;
    this.jdField_a_of_type_Int = ((int)(Math.min(j * 0.85F, j - actn.a(16.0F, getResources())) - i));
    this.jdField_a_of_type_Arsp.setLineMaxWidth(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = this.jdField_a_of_type_Int;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Arsn != null) {
      this.jdField_a_of_type_Arsn.b();
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