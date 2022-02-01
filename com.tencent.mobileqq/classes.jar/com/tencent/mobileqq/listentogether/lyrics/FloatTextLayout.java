package com.tencent.mobileqq.listentogether.lyrics;

import afur;
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
import anni;
import avus;
import avut;
import avuu;
import avvf;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class FloatTextLayout
  extends FloatBaseLayout
  implements View.OnClickListener, avvf
{
  View a;
  public avuu a;
  boolean d = true;
  
  public FloatTextLayout(@NonNull Context paramContext)
  {
    super(paramContext);
    f();
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131561020, null);
    this.jdField_a_of_type_Avuu = ((avuu)this.jdField_a_of_type_AndroidViewView.findViewById(2131370345));
    this.jdField_a_of_type_Avuu.setStrokeColor(-1);
    this.jdField_a_of_type_Avuu.setStrokeWidth(afur.a(1.5F, getResources()));
    ((TextView)this.jdField_a_of_type_Avuu).setTextColor(-8293377);
    ((TextView)this.jdField_a_of_type_Avuu).getPaint().setFakeBoldText(true);
    ((TextView)this.jdField_a_of_type_Avuu).setTextSize(1, 18.0F);
    ((TextView)this.jdField_a_of_type_Avuu).setOnClickListener(this);
    ((TextView)this.jdField_a_of_type_Avuu).setContentDescription(anni.a(2131703426));
    this.jdField_b_of_type_Int = afur.a(40.0F, getResources());
    int i = (int)getResources().getDimension(2131297238);
    int j = getResources().getDisplayMetrics().widthPixels;
    this.jdField_a_of_type_Int = ((int)(Math.min(j * 0.85F, j - afur.a(16.0F, getResources())) - i));
    this.jdField_a_of_type_Avuu.setLineMaxWidth(this.jdField_a_of_type_Int);
    addView(this.jdField_a_of_type_AndroidViewView, new FrameLayout.LayoutParams(-2, this.jdField_b_of_type_Int));
    this.jdField_a_of_type_Avuu.setOnSizeChangeListener(this);
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = this.jdField_b_of_type_Int;
  }
  
  public int a(avut paramavut)
  {
    if (paramavut.jdField_a_of_type_Boolean) {
      return paramavut.jdField_a_of_type_Int + paramavut.jdField_c_of_type_Int / 2;
    }
    return paramavut.jdField_a_of_type_Int - paramavut.jdField_c_of_type_Int / 2 - this.jdField_a_of_type_Int;
  }
  
  public avuu a()
  {
    return this.jdField_a_of_type_Avuu;
  }
  
  public void a(avut paramavut)
  {
    if (paramavut == null) {}
    label138:
    label143:
    label146:
    for (;;)
    {
      return;
      Object localObject;
      int i;
      if ((paramavut.f) && (!paramavut.g) && (!paramavut.jdField_b_of_type_Boolean))
      {
        if (!paramavut.jdField_c_of_type_Boolean) {
          this.jdField_a_of_type_Avuu.setAlign(Paint.Align.CENTER);
        }
      }
      else
      {
        this.d = paramavut.jdField_a_of_type_Boolean;
        localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        i = ((FrameLayout.LayoutParams)localObject).gravity;
        if (!paramavut.jdField_c_of_type_Boolean) {
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
        if (paramavut.jdField_a_of_type_Boolean) {}
        for (localObject = Paint.Align.RIGHT;; localObject = Paint.Align.LEFT)
        {
          this.jdField_a_of_type_Avuu.setAlign((Paint.Align)localObject);
          break;
        }
        i = 3;
        continue;
        i = 1;
      }
    }
  }
  
  public boolean a(avut paramavut)
  {
    boolean bool = true;
    if (paramavut == null) {
      return false;
    }
    if ((paramavut.f) && (!paramavut.g) && (!paramavut.jdField_b_of_type_Boolean)) {
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
  
  public int b(avut paramavut)
  {
    return paramavut.jdField_b_of_type_Int - this.jdField_b_of_type_Int / 2;
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_Avuu != null)
    {
      this.jdField_a_of_type_Avuu.setOnSizeChangeListener(null);
      this.jdField_a_of_type_Avuu.c();
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != this.jdField_a_of_type_Int) && (this.jdField_a_of_type_Avus != null)) {
      this.jdField_a_of_type_Avus.b(paramInt1, paramInt2);
    }
  }
  
  public boolean b()
  {
    boolean bool = super.b();
    if (this.jdField_a_of_type_Avuu != null) {
      this.jdField_a_of_type_Avuu.c();
    }
    return bool;
  }
  
  public void e()
  {
    int i = (int)getResources().getDimension(2131297238);
    int j = getResources().getDisplayMetrics().widthPixels;
    this.jdField_a_of_type_Int = ((int)(Math.min(j * 0.85F, j - afur.a(16.0F, getResources())) - i));
    this.jdField_a_of_type_Avuu.setLineMaxWidth(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = this.jdField_a_of_type_Int;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Avus != null) {
      this.jdField_a_of_type_Avus.b();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setFloatWidth(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.lyrics.FloatTextLayout
 * JD-Core Version:    0.7.0.1
 */