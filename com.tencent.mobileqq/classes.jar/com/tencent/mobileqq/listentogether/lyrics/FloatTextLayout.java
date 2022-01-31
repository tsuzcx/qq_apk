package com.tencent.mobileqq.listentogether.lyrics;

import aciy;
import ajjy;
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
import aqwx;
import aqwy;
import aqwz;
import aqxk;

public class FloatTextLayout
  extends FloatBaseLayout
  implements View.OnClickListener, aqxk
{
  View a;
  public aqwz a;
  boolean d = true;
  
  public FloatTextLayout(@NonNull Context paramContext)
  {
    super(paramContext);
    f();
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131495050, null);
    this.jdField_a_of_type_Aqwz = ((aqwz)this.jdField_a_of_type_AndroidViewView.findViewById(2131303945));
    this.jdField_a_of_type_Aqwz.setStrokeColor(-1);
    this.jdField_a_of_type_Aqwz.setStrokeWidth(aciy.a(1.5F, getResources()));
    ((TextView)this.jdField_a_of_type_Aqwz).setTextColor(-8293377);
    ((TextView)this.jdField_a_of_type_Aqwz).getPaint().setFakeBoldText(true);
    ((TextView)this.jdField_a_of_type_Aqwz).setTextSize(1, 18.0F);
    ((TextView)this.jdField_a_of_type_Aqwz).setOnClickListener(this);
    ((TextView)this.jdField_a_of_type_Aqwz).setContentDescription(ajjy.a(2131638850));
    this.jdField_b_of_type_Int = aciy.a(40.0F, getResources());
    int i = (int)getResources().getDimension(2131166080);
    int j = getResources().getDisplayMetrics().widthPixels;
    this.jdField_a_of_type_Int = ((int)(Math.min(j * 0.85F, j - aciy.a(16.0F, getResources())) - i));
    this.jdField_a_of_type_Aqwz.setLineMaxWidth(this.jdField_a_of_type_Int);
    addView(this.jdField_a_of_type_AndroidViewView, new FrameLayout.LayoutParams(-2, this.jdField_b_of_type_Int));
    this.jdField_a_of_type_Aqwz.setOnSizeChangeListener(this);
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = this.jdField_b_of_type_Int;
  }
  
  public int a(aqwy paramaqwy)
  {
    if (paramaqwy.jdField_a_of_type_Boolean) {
      return paramaqwy.jdField_a_of_type_Int + paramaqwy.jdField_c_of_type_Int / 2;
    }
    return paramaqwy.jdField_a_of_type_Int - paramaqwy.jdField_c_of_type_Int / 2 - this.jdField_a_of_type_Int;
  }
  
  public aqwz a()
  {
    return this.jdField_a_of_type_Aqwz;
  }
  
  public void a(aqwy paramaqwy)
  {
    if (paramaqwy == null) {}
    label138:
    label143:
    label146:
    for (;;)
    {
      return;
      Object localObject;
      int i;
      if ((paramaqwy.f) && (!paramaqwy.g) && (!paramaqwy.jdField_b_of_type_Boolean))
      {
        if (!paramaqwy.jdField_c_of_type_Boolean) {
          this.jdField_a_of_type_Aqwz.setAlign(Paint.Align.CENTER);
        }
      }
      else
      {
        this.d = paramaqwy.jdField_a_of_type_Boolean;
        localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        i = ((FrameLayout.LayoutParams)localObject).gravity;
        if (!paramaqwy.jdField_c_of_type_Boolean) {
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
        if (paramaqwy.jdField_a_of_type_Boolean) {}
        for (localObject = Paint.Align.RIGHT;; localObject = Paint.Align.LEFT)
        {
          this.jdField_a_of_type_Aqwz.setAlign((Paint.Align)localObject);
          break;
        }
        i = 3;
        continue;
        i = 1;
      }
    }
  }
  
  public boolean a(aqwy paramaqwy)
  {
    boolean bool = true;
    if (paramaqwy == null) {
      return false;
    }
    if ((paramaqwy.f) && (!paramaqwy.g) && (!paramaqwy.jdField_b_of_type_Boolean)) {
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
  
  public int b(aqwy paramaqwy)
  {
    return paramaqwy.jdField_b_of_type_Int - this.jdField_b_of_type_Int / 2;
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_Aqwz != null)
    {
      this.jdField_a_of_type_Aqwz.setOnSizeChangeListener(null);
      this.jdField_a_of_type_Aqwz.c();
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != this.jdField_a_of_type_Int) && (this.jdField_a_of_type_Aqwx != null)) {
      this.jdField_a_of_type_Aqwx.b(paramInt1, paramInt2);
    }
  }
  
  public boolean b()
  {
    boolean bool = super.b();
    if (this.jdField_a_of_type_Aqwz != null) {
      this.jdField_a_of_type_Aqwz.c();
    }
    return bool;
  }
  
  public void e()
  {
    int i = (int)getResources().getDimension(2131166080);
    int j = getResources().getDisplayMetrics().widthPixels;
    this.jdField_a_of_type_Int = ((int)(Math.min(j * 0.85F, j - aciy.a(16.0F, getResources())) - i));
    this.jdField_a_of_type_Aqwz.setLineMaxWidth(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = this.jdField_a_of_type_Int;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Aqwx != null) {
      this.jdField_a_of_type_Aqwx.b();
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