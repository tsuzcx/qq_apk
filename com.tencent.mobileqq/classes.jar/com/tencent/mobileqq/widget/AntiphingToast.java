package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import java.util.Timer;

public class AntiphingToast
{
  private int jdField_a_of_type_Int = 0;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  Handler jdField_a_of_type_AndroidOsHandler = new AntiphingToast.1(this, Looper.getMainLooper());
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View jdField_a_of_type_AndroidViewView = null;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout = null;
  private CharSequence jdField_a_of_type_JavaLangCharSequence = null;
  private String jdField_a_of_type_JavaLangString = "AntiPhing";
  private boolean jdField_a_of_type_Boolean = true;
  
  public void a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, paramFloat1, paramFloat2);
    localTranslateAnimation.setFillAfter(true);
    localTranslateAnimation.setDuration(700L);
    localTranslateAnimation.setStartOffset(20L);
    if (paramBoolean == true) {
      localTranslateAnimation.setAnimationListener(new AntiphingToast.2(this));
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.startAnimation(localTranslateAnimation);
  }
  
  public void a(int paramInt)
  {
    a(this.jdField_a_of_type_AndroidContentResResources.getString(paramInt));
  }
  
  public void a(int paramInt1, int paramInt2, FrameLayout paramFrameLayout)
  {
    a(paramFrameLayout);
    a(paramInt1);
    b(paramInt2);
  }
  
  public void a(FrameLayout paramFrameLayout)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = paramFrameLayout;
    this.jdField_a_of_type_AndroidContentResResources = paramFrameLayout.getContext().getResources();
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
  }
  
  public boolean a(String paramString)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      Object localObject = this.jdField_a_of_type_AndroidWidgetFrameLayout;
      if (localObject == null) {
        return false;
      }
      this.jdField_a_of_type_Boolean = false;
      ((FrameLayout)localObject).removeAllViewsInLayout();
      if (this.jdField_a_of_type_AndroidViewLayoutInflater == null) {
        this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidWidgetFrameLayout.getContext());
      }
      if (this.jdField_a_of_type_AndroidViewView == null)
      {
        this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561859, null);
        localObject = this.jdField_a_of_type_AndroidViewView;
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(2131362721);
          if ((localObject != null) && (paramString != null)) {
            ((TextView)localObject).setText(paramString);
          }
        }
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setFocusable(false);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.bringToFront();
      a(-80.0F, 0.0F, false);
      new Timer().schedule(new AntiphingToast.3(this), this.jdField_a_of_type_Int + 700);
      return true;
    }
    return false;
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AntiphingToast
 * JD-Core Version:    0.7.0.1
 */