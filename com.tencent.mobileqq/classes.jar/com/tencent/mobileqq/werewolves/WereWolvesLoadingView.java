package com.tencent.mobileqq.werewolves;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;

public class WereWolvesLoadingView
  extends FrameLayout
{
  int jdField_a_of_type_Int;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  View jdField_a_of_type_AndroidViewView;
  public TextView a;
  WereWolvesLoadingView.LoadingCallback jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView$LoadingCallback;
  Runnable jdField_a_of_type_JavaLangRunnable = new WereWolvesLoadingView.1(this);
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int = 0;
  public View b;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  Runnable jdField_b_of_type_JavaLangRunnable = new WereWolvesLoadingView.2(this);
  boolean jdField_b_of_type_Boolean = false;
  
  public WereWolvesLoadingView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    a();
  }
  
  public WereWolvesLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    a();
  }
  
  void a()
  {
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131559487, this);
    this.jdField_a_of_type_Int = findViewById(2131373135).getLayoutParams().width;
    this.jdField_a_of_type_AndroidViewView = findViewById(2131373132);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373159));
    setProgress(0);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378745));
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#323e6f"));
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
    localObject = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/nearby_game_room_bg.jpg", (URLDrawable.URLDrawableOptions)localObject);
    this.jdField_b_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
  }
  
  public void b()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 10L);
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void setComplete(WereWolvesLoadingView.LoadingCallback paramLoadingCallback)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView$LoadingCallback = paramLoadingCallback;
    this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void setProgress(int paramInt)
  {
    int i;
    if (paramInt < 0)
    {
      i = 0;
    }
    else
    {
      i = paramInt;
      if (paramInt > 100) {
        i = 100;
      }
    }
    paramInt = this.jdField_a_of_type_Int * i / 100;
    Object localObject;
    if (paramInt != 0)
    {
      localObject = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = paramInt;
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    else
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_b_of_type_Int = i;
    this.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("%d%%", new Object[] { Integer.valueOf(i) }));
    if (this.jdField_b_of_type_Int >= 100)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView$LoadingCallback;
      if ((localObject != null) && (!this.jdField_a_of_type_Boolean))
      {
        ((WereWolvesLoadingView.LoadingCallback)localObject).a();
        this.jdField_a_of_type_Boolean = true;
      }
    }
    else
    {
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void setTips(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.werewolves.WereWolvesLoadingView
 * JD-Core Version:    0.7.0.1
 */