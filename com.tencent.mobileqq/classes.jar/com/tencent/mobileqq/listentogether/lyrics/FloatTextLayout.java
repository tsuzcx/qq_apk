package com.tencent.mobileqq.listentogether.lyrics;

import agej;
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
import anzj;
import awnn;
import awno;
import awnp;
import awoa;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class FloatTextLayout
  extends FloatBaseLayout
  implements View.OnClickListener, awoa
{
  View a;
  public awnp a;
  boolean d = true;
  
  public FloatTextLayout(@NonNull Context paramContext)
  {
    super(paramContext);
    f();
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131561055, null);
    this.jdField_a_of_type_Awnp = ((awnp)this.jdField_a_of_type_AndroidViewView.findViewById(2131370447));
    this.jdField_a_of_type_Awnp.setStrokeColor(-1);
    this.jdField_a_of_type_Awnp.setStrokeWidth(agej.a(1.5F, getResources()));
    ((TextView)this.jdField_a_of_type_Awnp).setTextColor(-8293377);
    ((TextView)this.jdField_a_of_type_Awnp).getPaint().setFakeBoldText(true);
    ((TextView)this.jdField_a_of_type_Awnp).setTextSize(1, 18.0F);
    ((TextView)this.jdField_a_of_type_Awnp).setOnClickListener(this);
    ((TextView)this.jdField_a_of_type_Awnp).setContentDescription(anzj.a(2131703533));
    this.jdField_b_of_type_Int = agej.a(40.0F, getResources());
    int i = (int)getResources().getDimension(2131297250);
    int j = getResources().getDisplayMetrics().widthPixels;
    this.jdField_a_of_type_Int = ((int)(Math.min(j * 0.85F, j - agej.a(16.0F, getResources())) - i));
    this.jdField_a_of_type_Awnp.setLineMaxWidth(this.jdField_a_of_type_Int);
    addView(this.jdField_a_of_type_AndroidViewView, new FrameLayout.LayoutParams(-2, this.jdField_b_of_type_Int));
    this.jdField_a_of_type_Awnp.setOnSizeChangeListener(this);
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = this.jdField_b_of_type_Int;
  }
  
  public int a(awno paramawno)
  {
    if (paramawno.jdField_a_of_type_Boolean) {
      return paramawno.jdField_a_of_type_Int + paramawno.jdField_c_of_type_Int / 2;
    }
    return paramawno.jdField_a_of_type_Int - paramawno.jdField_c_of_type_Int / 2 - this.jdField_a_of_type_Int;
  }
  
  public awnp a()
  {
    return this.jdField_a_of_type_Awnp;
  }
  
  public void a(awno paramawno)
  {
    if (paramawno == null) {}
    label138:
    label143:
    label146:
    for (;;)
    {
      return;
      Object localObject;
      int i;
      if ((paramawno.f) && (!paramawno.g) && (!paramawno.jdField_b_of_type_Boolean))
      {
        if (!paramawno.jdField_c_of_type_Boolean) {
          this.jdField_a_of_type_Awnp.setAlign(Paint.Align.CENTER);
        }
      }
      else
      {
        this.d = paramawno.jdField_a_of_type_Boolean;
        localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        i = ((FrameLayout.LayoutParams)localObject).gravity;
        if (!paramawno.jdField_c_of_type_Boolean) {
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
        if (paramawno.jdField_a_of_type_Boolean) {}
        for (localObject = Paint.Align.RIGHT;; localObject = Paint.Align.LEFT)
        {
          this.jdField_a_of_type_Awnp.setAlign((Paint.Align)localObject);
          break;
        }
        i = 3;
        continue;
        i = 1;
      }
    }
  }
  
  public boolean a(awno paramawno)
  {
    boolean bool = true;
    if (paramawno == null) {
      return false;
    }
    if ((paramawno.f) && (!paramawno.g) && (!paramawno.jdField_b_of_type_Boolean)) {
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
  
  public int b(awno paramawno)
  {
    return paramawno.jdField_b_of_type_Int - this.jdField_b_of_type_Int / 2;
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_Awnp != null)
    {
      this.jdField_a_of_type_Awnp.setOnSizeChangeListener(null);
      this.jdField_a_of_type_Awnp.c();
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != this.jdField_a_of_type_Int) && (this.jdField_a_of_type_Awnn != null)) {
      this.jdField_a_of_type_Awnn.b(paramInt1, paramInt2);
    }
  }
  
  public boolean b()
  {
    boolean bool = super.b();
    if (this.jdField_a_of_type_Awnp != null) {
      this.jdField_a_of_type_Awnp.c();
    }
    return bool;
  }
  
  public void e()
  {
    int i = (int)getResources().getDimension(2131297250);
    int j = getResources().getDisplayMetrics().widthPixels;
    this.jdField_a_of_type_Int = ((int)(Math.min(j * 0.85F, j - agej.a(16.0F, getResources())) - i));
    this.jdField_a_of_type_Awnp.setLineMaxWidth(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = this.jdField_a_of_type_Int;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Awnn != null) {
      this.jdField_a_of_type_Awnn.b();
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