package com.tencent.mobileqq.listentogether.lyrics;

import amtj;
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
import avar;
import avas;
import avat;
import avbe;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class FloatTextLayout
  extends FloatBaseLayout
  implements View.OnClickListener, avbe
{
  View a;
  public avat a;
  boolean d = true;
  
  public FloatTextLayout(@NonNull Context paramContext)
  {
    super(paramContext);
    f();
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131560926, null);
    this.jdField_a_of_type_Avat = ((avat)this.jdField_a_of_type_AndroidViewView.findViewById(2131370415));
    this.jdField_a_of_type_Avat.setStrokeColor(-1);
    this.jdField_a_of_type_Avat.setStrokeWidth(AIOUtils.dp2px(1.5F, getResources()));
    ((TextView)this.jdField_a_of_type_Avat).setTextColor(-8293377);
    ((TextView)this.jdField_a_of_type_Avat).getPaint().setFakeBoldText(true);
    ((TextView)this.jdField_a_of_type_Avat).setTextSize(1, 18.0F);
    ((TextView)this.jdField_a_of_type_Avat).setOnClickListener(this);
    ((TextView)this.jdField_a_of_type_Avat).setContentDescription(amtj.a(2131703763));
    this.jdField_b_of_type_Int = AIOUtils.dp2px(40.0F, getResources());
    int i = (int)getResources().getDimension(2131297305);
    int j = getResources().getDisplayMetrics().widthPixels;
    this.jdField_a_of_type_Int = ((int)(Math.min(j * 0.85F, j - AIOUtils.dp2px(16.0F, getResources())) - i));
    this.jdField_a_of_type_Avat.setLineMaxWidth(this.jdField_a_of_type_Int);
    addView(this.jdField_a_of_type_AndroidViewView, new FrameLayout.LayoutParams(-2, this.jdField_b_of_type_Int));
    this.jdField_a_of_type_Avat.setOnSizeChangeListener(this);
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = this.jdField_b_of_type_Int;
  }
  
  public int a(avas paramavas)
  {
    if (paramavas.jdField_a_of_type_Boolean) {
      return paramavas.jdField_a_of_type_Int + paramavas.jdField_c_of_type_Int / 2;
    }
    return paramavas.jdField_a_of_type_Int - paramavas.jdField_c_of_type_Int / 2 - this.jdField_a_of_type_Int;
  }
  
  public avat a()
  {
    return this.jdField_a_of_type_Avat;
  }
  
  public void a(avas paramavas)
  {
    if (paramavas == null) {}
    label138:
    label143:
    label146:
    for (;;)
    {
      return;
      Object localObject;
      int i;
      if ((paramavas.f) && (!paramavas.g) && (!paramavas.jdField_b_of_type_Boolean))
      {
        if (!paramavas.jdField_c_of_type_Boolean) {
          this.jdField_a_of_type_Avat.setAlign(Paint.Align.CENTER);
        }
      }
      else
      {
        this.d = paramavas.jdField_a_of_type_Boolean;
        localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        i = ((FrameLayout.LayoutParams)localObject).gravity;
        if (!paramavas.jdField_c_of_type_Boolean) {
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
        if (paramavas.jdField_a_of_type_Boolean) {}
        for (localObject = Paint.Align.RIGHT;; localObject = Paint.Align.LEFT)
        {
          this.jdField_a_of_type_Avat.setAlign((Paint.Align)localObject);
          break;
        }
        i = 3;
        continue;
        i = 1;
      }
    }
  }
  
  public boolean a(avas paramavas)
  {
    boolean bool = true;
    if (paramavas == null) {
      return false;
    }
    if ((paramavas.f) && (!paramavas.g) && (!paramavas.jdField_b_of_type_Boolean)) {
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
  
  public int b(avas paramavas)
  {
    return paramavas.jdField_b_of_type_Int - this.jdField_b_of_type_Int / 2;
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_Avat != null)
    {
      this.jdField_a_of_type_Avat.setOnSizeChangeListener(null);
      this.jdField_a_of_type_Avat.c();
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != this.jdField_a_of_type_Int) && (this.jdField_a_of_type_Avar != null)) {
      this.jdField_a_of_type_Avar.b(paramInt1, paramInt2);
    }
  }
  
  public boolean b()
  {
    boolean bool = super.b();
    if (this.jdField_a_of_type_Avat != null) {
      this.jdField_a_of_type_Avat.c();
    }
    return bool;
  }
  
  public void e()
  {
    int i = (int)getResources().getDimension(2131297305);
    int j = getResources().getDisplayMetrics().widthPixels;
    this.jdField_a_of_type_Int = ((int)(Math.min(j * 0.85F, j - AIOUtils.dp2px(16.0F, getResources())) - i));
    this.jdField_a_of_type_Avat.setLineMaxWidth(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = this.jdField_a_of_type_Int;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Avar != null) {
      this.jdField_a_of_type_Avar.b();
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