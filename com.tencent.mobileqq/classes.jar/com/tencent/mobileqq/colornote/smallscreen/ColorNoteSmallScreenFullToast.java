package com.tencent.mobileqq.colornote.smallscreen;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.view.WindowManager;
import android.view.WindowManager.BadTokenException;
import android.view.WindowManager.LayoutParams;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ColorNoteSmallScreenFullToast
  extends RelativeLayout
  implements View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams();
  private WindowManager jdField_a_of_type_AndroidViewWindowManager;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout.LayoutParams jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  private ColorNoteSmallScreenFullToast.IColorNoteSmallScreenFullToastListener jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenFullToast$IColorNoteSmallScreenFullToastListener;
  boolean jdField_a_of_type_Boolean = false;
  
  public ColorNoteSmallScreenFullToast(Context paramContext, ColorNoteSmallScreenFullToast.IColorNoteSmallScreenFullToastListener paramIColorNoteSmallScreenFullToastListener)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenFullToast$IColorNoteSmallScreenFullToastListener = paramIColorNoteSmallScreenFullToastListener;
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window"));
    paramIColorNoteSmallScreenFullToastListener = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
    paramIColorNoteSmallScreenFullToastListener.height = -1;
    paramIColorNoteSmallScreenFullToastListener.width = -1;
    paramIColorNoteSmallScreenFullToastListener.format = -3;
    paramIColorNoteSmallScreenFullToastListener.windowAnimations = 0;
    paramIColorNoteSmallScreenFullToastListener.gravity = 51;
    paramIColorNoteSmallScreenFullToastListener.setTitle("Toast");
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.flags = 768;
    if (Build.VERSION.SDK_INT >= 26) {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.type = 2038;
    } else {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.type = 2002;
    }
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(paramContext.getResources().getString(2131690902));
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130839257);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = new RelativeLayout.LayoutParams(Utils.a(24.0F, paramContext.getResources()), Utils.a(24.0F, paramContext.getResources()));
    addView(this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("ColorNoteSmallScreenFullToast", 2, "stopHandler removeView start");
          }
          if (this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams != null)
          {
            this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.leftMargin = 0;
            this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin = 0;
            this.jdField_a_of_type_AndroidWidgetImageView.requestLayout();
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_a_of_type_AndroidViewWindowManager.removeView(this);
          if (QLog.isColorLevel()) {
            QLog.d("ColorNoteSmallScreenFullToast", 2, "stopHandler removeView end");
          }
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("stopHandler error : ");
            localStringBuilder.append(localIllegalArgumentException);
            QLog.d("ColorNoteSmallScreenFullToast", 2, localStringBuilder.toString());
          }
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
    if (localObject != null)
    {
      ((RelativeLayout.LayoutParams)localObject).leftMargin = (paramInt1 - Utils.a(12.0F, getResources()));
      localObject = new int[2];
      getLocationOnScreen((int[])localObject);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin = (paramInt2 - Utils.a(5.5F, getResources()) - localObject[1]);
      this.jdField_a_of_type_AndroidWidgetImageView.requestLayout();
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 8) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(0.0F);
    this.jdField_a_of_type_AndroidWidgetImageView.animate().alpha(1.0F).setDuration(150L).setInterpolator(new LinearInterpolator()).start();
  }
  
  public boolean a()
  {
    for (;;)
    {
      try
      {
        bool1 = this.jdField_a_of_type_Boolean;
        bool2 = false;
        if (bool1) {
          break label382;
        }
        this.jdField_a_of_type_Boolean = true;
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("ColorNoteSmallScreenFullToast", 2, "startHandler addView start");
          }
          this.jdField_a_of_type_AndroidViewWindowManager.addView(this, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
          if (!QLog.isColorLevel()) {
            break label382;
          }
          QLog.d("ColorNoteSmallScreenFullToast", 2, "startHandler addView end");
        }
        catch (Exception localException)
        {
          this.jdField_a_of_type_Boolean = false;
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("startHandler error : ");
          localStringBuilder2.append(localException);
          QLog.d("ColorNoteSmallScreenFullToast", 2, localStringBuilder2.toString());
          bool1 = bool2;
          continue;
        }
        catch (SecurityException localSecurityException)
        {
          this.jdField_a_of_type_Boolean = false;
          bool1 = bool2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("startHandler error : ");
          localStringBuilder2.append(localSecurityException);
          QLog.d("ColorNoteSmallScreenFullToast", 2, localStringBuilder2.toString());
          bool1 = bool2;
          continue;
        }
        catch (WindowManager.BadTokenException localBadTokenException)
        {
          this.jdField_a_of_type_Boolean = false;
          bool1 = bool2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("startHandler error : ");
          localStringBuilder2.append(localBadTokenException);
          QLog.d("ColorNoteSmallScreenFullToast", 2, localStringBuilder2.toString());
          bool1 = bool2;
          continue;
        }
        catch (IllegalStateException localIllegalStateException)
        {
          this.jdField_a_of_type_AndroidViewWindowManager.updateViewLayout(this, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
          if (!QLog.isColorLevel()) {
            break label382;
          }
        }
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("startHandler error : ");
        localStringBuilder2.append(localIllegalStateException);
        QLog.d("ColorNoteSmallScreenFullToast", 2, localStringBuilder2.toString());
      }
      finally {}
      boolean bool2 = bool1;
      if ((WindowManager.LayoutParams)getLayoutParams() != null)
      {
        bool2 = bool1;
        if (bool1) {
          bool2 = ColorNoteSmallScreenPermissionUtil.a(this.jdField_a_of_type_AndroidContentContext);
        }
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("startHandler mIsVisibe = ");
        localStringBuilder1.append(this.jdField_a_of_type_Boolean);
        QLog.d("ColorNoteSmallScreenFullToast", 2, localStringBuilder1.toString());
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("startHandler result = ");
        localStringBuilder1.append(bool2);
        QLog.d("ColorNoteSmallScreenFullToast", 2, localStringBuilder1.toString());
      }
      return bool2;
      label382:
      boolean bool1 = true;
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getKeyCode() == 4)
    {
      paramKeyEvent = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenFullToast$IColorNoteSmallScreenFullToastListener;
      if (paramKeyEvent != null) {
        paramKeyEvent.a();
      }
      a();
      return true;
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    a();
    ColorNoteSmallScreenFullToast.IColorNoteSmallScreenFullToastListener localIColorNoteSmallScreenFullToastListener;
    if (paramView == this)
    {
      localIColorNoteSmallScreenFullToastListener = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenFullToast$IColorNoteSmallScreenFullToastListener;
      if (localIColorNoteSmallScreenFullToastListener != null) {
        localIColorNoteSmallScreenFullToastListener.c();
      }
    }
    else if (paramView == this.jdField_a_of_type_AndroidWidgetImageView)
    {
      localIColorNoteSmallScreenFullToastListener = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenFullToast$IColorNoteSmallScreenFullToastListener;
      if (localIColorNoteSmallScreenFullToastListener != null) {
        localIColorNoteSmallScreenFullToastListener.d();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenFullToast
 * JD-Core Version:    0.7.0.1
 */