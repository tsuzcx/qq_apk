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
import anvx;
import awgu;
import awgv;
import awgw;
import awhh;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class FloatTextLayout
  extends FloatBaseLayout
  implements View.OnClickListener, awhh
{
  View a;
  public awgw a;
  boolean d = true;
  
  public FloatTextLayout(@NonNull Context paramContext)
  {
    super(paramContext);
    f();
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131560987, null);
    this.jdField_a_of_type_Awgw = ((awgw)this.jdField_a_of_type_AndroidViewView.findViewById(2131370598));
    this.jdField_a_of_type_Awgw.setStrokeColor(-1);
    this.jdField_a_of_type_Awgw.setStrokeWidth(AIOUtils.dp2px(1.5F, getResources()));
    ((TextView)this.jdField_a_of_type_Awgw).setTextColor(-8293377);
    ((TextView)this.jdField_a_of_type_Awgw).getPaint().setFakeBoldText(true);
    ((TextView)this.jdField_a_of_type_Awgw).setTextSize(1, 18.0F);
    ((TextView)this.jdField_a_of_type_Awgw).setOnClickListener(this);
    ((TextView)this.jdField_a_of_type_Awgw).setContentDescription(anvx.a(2131704114));
    this.jdField_b_of_type_Int = AIOUtils.dp2px(40.0F, getResources());
    int i = (int)getResources().getDimension(2131297306);
    int j = getResources().getDisplayMetrics().widthPixels;
    this.jdField_a_of_type_Int = ((int)(Math.min(j * 0.85F, j - AIOUtils.dp2px(16.0F, getResources())) - i));
    this.jdField_a_of_type_Awgw.setLineMaxWidth(this.jdField_a_of_type_Int);
    addView(this.jdField_a_of_type_AndroidViewView, new FrameLayout.LayoutParams(-2, this.jdField_b_of_type_Int));
    this.jdField_a_of_type_Awgw.setOnSizeChangeListener(this);
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = this.jdField_b_of_type_Int;
  }
  
  public int a(awgv paramawgv)
  {
    if (paramawgv.jdField_a_of_type_Boolean) {
      return paramawgv.jdField_a_of_type_Int + paramawgv.jdField_c_of_type_Int / 2;
    }
    return paramawgv.jdField_a_of_type_Int - paramawgv.jdField_c_of_type_Int / 2 - this.jdField_a_of_type_Int;
  }
  
  public awgw a()
  {
    return this.jdField_a_of_type_Awgw;
  }
  
  public void a(awgv paramawgv)
  {
    if (paramawgv == null) {}
    label138:
    label143:
    label146:
    for (;;)
    {
      return;
      Object localObject;
      int i;
      if ((paramawgv.f) && (!paramawgv.g) && (!paramawgv.jdField_b_of_type_Boolean))
      {
        if (!paramawgv.jdField_c_of_type_Boolean) {
          this.jdField_a_of_type_Awgw.setAlign(Paint.Align.CENTER);
        }
      }
      else
      {
        this.d = paramawgv.jdField_a_of_type_Boolean;
        localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        i = ((FrameLayout.LayoutParams)localObject).gravity;
        if (!paramawgv.jdField_c_of_type_Boolean) {
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
        if (paramawgv.jdField_a_of_type_Boolean) {}
        for (localObject = Paint.Align.RIGHT;; localObject = Paint.Align.LEFT)
        {
          this.jdField_a_of_type_Awgw.setAlign((Paint.Align)localObject);
          break;
        }
        i = 3;
        continue;
        i = 1;
      }
    }
  }
  
  public boolean a(awgv paramawgv)
  {
    boolean bool = true;
    if (paramawgv == null) {
      return false;
    }
    if ((paramawgv.f) && (!paramawgv.g) && (!paramawgv.jdField_b_of_type_Boolean)) {
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
  
  public int b(awgv paramawgv)
  {
    return paramawgv.jdField_b_of_type_Int - this.jdField_b_of_type_Int / 2;
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_Awgw != null)
    {
      this.jdField_a_of_type_Awgw.setOnSizeChangeListener(null);
      this.jdField_a_of_type_Awgw.c();
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != this.jdField_a_of_type_Int) && (this.jdField_a_of_type_Awgu != null)) {
      this.jdField_a_of_type_Awgu.b(paramInt1, paramInt2);
    }
  }
  
  public boolean b()
  {
    boolean bool = super.b();
    if (this.jdField_a_of_type_Awgw != null) {
      this.jdField_a_of_type_Awgw.c();
    }
    return bool;
  }
  
  public void e()
  {
    int i = (int)getResources().getDimension(2131297306);
    int j = getResources().getDisplayMetrics().widthPixels;
    this.jdField_a_of_type_Int = ((int)(Math.min(j * 0.85F, j - AIOUtils.dp2px(16.0F, getResources())) - i));
    this.jdField_a_of_type_Awgw.setLineMaxWidth(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = this.jdField_a_of_type_Int;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Awgu != null) {
      this.jdField_a_of_type_Awgu.b();
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