package com.tencent.mobileqq.listentogether.lyrics;

import aepi;
import alud;
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
import atnt;
import atnu;
import atnv;
import atog;

public class FloatTextLayout
  extends FloatBaseLayout
  implements View.OnClickListener, atog
{
  View a;
  public atnv a;
  boolean d = true;
  
  public FloatTextLayout(@NonNull Context paramContext)
  {
    super(paramContext);
    f();
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131560816, null);
    this.jdField_a_of_type_Atnv = ((atnv)this.jdField_a_of_type_AndroidViewView.findViewById(2131369903));
    this.jdField_a_of_type_Atnv.setStrokeColor(-1);
    this.jdField_a_of_type_Atnv.setStrokeWidth(aepi.a(1.5F, getResources()));
    ((TextView)this.jdField_a_of_type_Atnv).setTextColor(-8293377);
    ((TextView)this.jdField_a_of_type_Atnv).getPaint().setFakeBoldText(true);
    ((TextView)this.jdField_a_of_type_Atnv).setTextSize(1, 18.0F);
    ((TextView)this.jdField_a_of_type_Atnv).setOnClickListener(this);
    ((TextView)this.jdField_a_of_type_Atnv).setContentDescription(alud.a(2131705030));
    this.jdField_b_of_type_Int = aepi.a(40.0F, getResources());
    int i = (int)getResources().getDimension(2131297175);
    int j = getResources().getDisplayMetrics().widthPixels;
    this.jdField_a_of_type_Int = ((int)(Math.min(j * 0.85F, j - aepi.a(16.0F, getResources())) - i));
    this.jdField_a_of_type_Atnv.setLineMaxWidth(this.jdField_a_of_type_Int);
    addView(this.jdField_a_of_type_AndroidViewView, new FrameLayout.LayoutParams(-2, this.jdField_b_of_type_Int));
    this.jdField_a_of_type_Atnv.setOnSizeChangeListener(this);
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = this.jdField_b_of_type_Int;
  }
  
  public int a(atnu paramatnu)
  {
    if (paramatnu.jdField_a_of_type_Boolean) {
      return paramatnu.jdField_a_of_type_Int + paramatnu.jdField_c_of_type_Int / 2;
    }
    return paramatnu.jdField_a_of_type_Int - paramatnu.jdField_c_of_type_Int / 2 - this.jdField_a_of_type_Int;
  }
  
  public atnv a()
  {
    return this.jdField_a_of_type_Atnv;
  }
  
  public void a(atnu paramatnu)
  {
    if (paramatnu == null) {}
    label138:
    label143:
    label146:
    for (;;)
    {
      return;
      Object localObject;
      int i;
      if ((paramatnu.f) && (!paramatnu.g) && (!paramatnu.jdField_b_of_type_Boolean))
      {
        if (!paramatnu.jdField_c_of_type_Boolean) {
          this.jdField_a_of_type_Atnv.setAlign(Paint.Align.CENTER);
        }
      }
      else
      {
        this.d = paramatnu.jdField_a_of_type_Boolean;
        localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        i = ((FrameLayout.LayoutParams)localObject).gravity;
        if (!paramatnu.jdField_c_of_type_Boolean) {
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
        if (paramatnu.jdField_a_of_type_Boolean) {}
        for (localObject = Paint.Align.RIGHT;; localObject = Paint.Align.LEFT)
        {
          this.jdField_a_of_type_Atnv.setAlign((Paint.Align)localObject);
          break;
        }
        i = 3;
        continue;
        i = 1;
      }
    }
  }
  
  public boolean a(atnu paramatnu)
  {
    boolean bool = true;
    if (paramatnu == null) {
      return false;
    }
    if ((paramatnu.f) && (!paramatnu.g) && (!paramatnu.jdField_b_of_type_Boolean)) {
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
  
  public int b(atnu paramatnu)
  {
    return paramatnu.jdField_b_of_type_Int - this.jdField_b_of_type_Int / 2;
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_Atnv != null)
    {
      this.jdField_a_of_type_Atnv.setOnSizeChangeListener(null);
      this.jdField_a_of_type_Atnv.c();
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != this.jdField_a_of_type_Int) && (this.jdField_a_of_type_Atnt != null)) {
      this.jdField_a_of_type_Atnt.b(paramInt1, paramInt2);
    }
  }
  
  public boolean b()
  {
    boolean bool = super.b();
    if (this.jdField_a_of_type_Atnv != null) {
      this.jdField_a_of_type_Atnv.c();
    }
    return bool;
  }
  
  public void e()
  {
    int i = (int)getResources().getDimension(2131297175);
    int j = getResources().getDisplayMetrics().widthPixels;
    this.jdField_a_of_type_Int = ((int)(Math.min(j * 0.85F, j - aepi.a(16.0F, getResources())) - i));
    this.jdField_a_of_type_Atnv.setLineMaxWidth(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = this.jdField_a_of_type_Int;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Atnt != null) {
      this.jdField_a_of_type_Atnt.b();
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