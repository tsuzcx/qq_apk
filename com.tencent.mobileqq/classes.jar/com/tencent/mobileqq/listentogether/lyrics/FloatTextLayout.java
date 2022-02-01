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
  View a;
  public ILyricView a;
  boolean d = true;
  
  public FloatTextLayout(@NonNull Context paramContext)
  {
    super(paramContext);
    f();
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131561073, null);
    this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsILyricView = ((ILyricView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370886));
    this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsILyricView.setStrokeColor(-1);
    this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsILyricView.setStrokeWidth(AIOUtils.a(1.5F, getResources()));
    ((TextView)this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsILyricView).setTextColor(-8293377);
    ((TextView)this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsILyricView).getPaint().setFakeBoldText(true);
    ((TextView)this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsILyricView).setTextSize(1, 18.0F);
    ((TextView)this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsILyricView).setOnClickListener(this);
    ((TextView)this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsILyricView).setContentDescription(HardCodeUtil.a(2131704662));
    this.jdField_b_of_type_Int = AIOUtils.a(40.0F, getResources());
    int i = (int)getResources().getDimension(2131297332);
    int j = getResources().getDisplayMetrics().widthPixels;
    this.jdField_a_of_type_Int = ((int)(Math.min(j * 0.85F, j - AIOUtils.a(16.0F, getResources())) - i));
    this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsILyricView.setLineMaxWidth(this.jdField_a_of_type_Int);
    addView(this.jdField_a_of_type_AndroidViewView, new FrameLayout.LayoutParams(-2, this.jdField_b_of_type_Int));
    this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsILyricView.setOnSizeChangeListener(this);
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = this.jdField_b_of_type_Int;
  }
  
  public int a(FloatParams paramFloatParams)
  {
    if (paramFloatParams.jdField_a_of_type_Boolean) {
      return paramFloatParams.jdField_a_of_type_Int + paramFloatParams.jdField_c_of_type_Int / 2;
    }
    return paramFloatParams.jdField_a_of_type_Int - paramFloatParams.jdField_c_of_type_Int / 2 - this.jdField_a_of_type_Int;
  }
  
  public ILyricView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsILyricView;
  }
  
  public void a(FloatParams paramFloatParams)
  {
    if (paramFloatParams == null) {}
    label138:
    label143:
    label146:
    for (;;)
    {
      return;
      Object localObject;
      int i;
      if ((paramFloatParams.f) && (!paramFloatParams.g) && (!paramFloatParams.jdField_b_of_type_Boolean))
      {
        if (!paramFloatParams.jdField_c_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsILyricView.setAlign(Paint.Align.CENTER);
        }
      }
      else
      {
        this.d = paramFloatParams.jdField_a_of_type_Boolean;
        localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        i = ((FrameLayout.LayoutParams)localObject).gravity;
        if (!paramFloatParams.jdField_c_of_type_Boolean) {
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
        if (paramFloatParams.jdField_a_of_type_Boolean) {}
        for (localObject = Paint.Align.RIGHT;; localObject = Paint.Align.LEFT)
        {
          this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsILyricView.setAlign((Paint.Align)localObject);
          break;
        }
        i = 3;
        continue;
        i = 1;
      }
    }
  }
  
  public boolean a(FloatParams paramFloatParams)
  {
    boolean bool = true;
    if (paramFloatParams == null) {
      return false;
    }
    if ((paramFloatParams.f) && (!paramFloatParams.g) && (!paramFloatParams.jdField_b_of_type_Boolean)) {
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
  
  public int b(FloatParams paramFloatParams)
  {
    return paramFloatParams.jdField_b_of_type_Int - this.jdField_b_of_type_Int / 2;
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsILyricView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsILyricView.setOnSizeChangeListener(null);
      this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsILyricView.c();
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != this.jdField_a_of_type_Int) && (this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatLayoutCallback != null)) {
      this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatLayoutCallback.b(paramInt1, paramInt2);
    }
  }
  
  public boolean b()
  {
    boolean bool = super.b();
    if (this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsILyricView != null) {
      this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsILyricView.c();
    }
    return bool;
  }
  
  public void e()
  {
    int i = (int)getResources().getDimension(2131297332);
    int j = getResources().getDisplayMetrics().widthPixels;
    this.jdField_a_of_type_Int = ((int)(Math.min(j * 0.85F, j - AIOUtils.a(16.0F, getResources())) - i));
    this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsILyricView.setLineMaxWidth(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = this.jdField_a_of_type_Int;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatLayoutCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatLayoutCallback.b();
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