package com.tencent.mobileqq.webview.swift;

import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class SwiftFloatViewUI$2
  implements View.OnTouchListener
{
  int jdField_a_of_type_Int;
  boolean jdField_a_of_type_Boolean;
  int b;
  int c;
  int d;
  int e = 2000;
  int f;
  int g;
  int h;
  int i;
  
  SwiftFloatViewUI$2(SwiftFloatViewUI paramSwiftFloatViewUI, DisplayMetrics paramDisplayMetrics) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView == this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_a_of_type_AndroidViewView)
    {
      int j = paramMotionEvent.getAction();
      if (j != 0)
      {
        if (j != 1) {
          if (j != 2)
          {
            if (j != 3) {
              return true;
            }
          }
          else
          {
            if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_b_of_type_AndroidViewView.getVisibility() == 0) {
              return true;
            }
            j = (int)paramMotionEvent.getRawX() - this.jdField_a_of_type_Int;
            k = (int)paramMotionEvent.getRawY() - this.jdField_b_of_type_Int;
            this.e = (paramView.getLeft() + j);
            this.f = (paramView.getTop() + k);
            this.g = (paramView.getRight() + j);
            this.h = (paramView.getBottom() + k);
            if (this.e < 0)
            {
              this.e = 0;
              this.g = (this.e + paramView.getWidth());
            }
            else if (this.g > this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_a_of_type_Int)
            {
              this.g = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_a_of_type_Int;
              this.e = (this.g - paramView.getWidth());
            }
            if (this.f < 0)
            {
              this.f = 0;
              this.h = (this.f + paramView.getHeight());
            }
            else if (this.h > this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_b_of_type_Int)
            {
              this.h = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_b_of_type_Int;
              this.f = (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_b_of_type_Int - paramView.getHeight());
            }
            paramView.layout(this.e, this.f, this.g, this.h);
            this.jdField_a_of_type_Int = ((int)paramMotionEvent.getRawX());
            this.jdField_b_of_type_Int = ((int)paramMotionEvent.getRawY());
            if ((this.jdField_a_of_type_Boolean) || ((Math.abs(paramMotionEvent.getRawX() - this.c) <= this.jdField_a_of_type_AndroidUtilDisplayMetrics.density * 5.0F) && (Math.abs(paramMotionEvent.getRawY() - this.d) <= this.jdField_a_of_type_AndroidUtilDisplayMetrics.density * 5.0F))) {
              break label1059;
            }
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_b_of_type_AndroidViewView.setVisibility(8);
            paramView = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI;
            paramView.a(paramView.jdField_a_of_type_AndroidViewView, true);
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.i.setVisibility(8);
            this.jdField_a_of_type_Boolean = true;
            return true;
          }
        }
        paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI;
        paramMotionEvent.a(paramMotionEvent.jdField_a_of_type_AndroidViewView, true);
        if (!this.jdField_a_of_type_Boolean)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_b_of_type_AndroidViewView.getVisibility() == 0)
          {
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_b_of_type_AndroidViewView.setVisibility(8);
            paramView = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI;
            paramView.a(paramView.jdField_a_of_type_AndroidViewView, true);
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.i.setVisibility(8);
            return true;
          }
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_b_of_type_AndroidViewView.setVisibility(0);
          paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI;
          paramMotionEvent.a(paramMotionEvent.jdField_a_of_type_AndroidViewView, false);
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.i.setVisibility(0);
          j = paramView.getTop();
          k = paramView.getWidth() / 2;
          if (this.e + k < this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_a_of_type_Int / 2)
          {
            if (Build.VERSION.SDK_INT >= 11) {
              try
              {
                this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_a_of_type_AndroidViewView.setRotationY(180.0F);
              }
              catch (Throwable paramView)
              {
                QLog.e("WebLog_SwiftFloatViewUI", 1, "floatbtn.setrotationy error!", paramView);
              }
            }
            paramView = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_b_of_type_AndroidViewView.getLayoutParams();
            paramView.gravity = 3;
            paramView.leftMargin = (this.e + k);
            paramView.topMargin = j;
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_b_of_type_AndroidViewView.setLayoutParams(paramView);
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_b_of_type_AndroidViewView.setPadding((int)(this.jdField_a_of_type_AndroidUtilDisplayMetrics.density * 35.0F), this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_b_of_type_AndroidViewView.getPaddingTop(), (int)(this.jdField_a_of_type_AndroidUtilDisplayMetrics.density * 20.0F), this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_b_of_type_AndroidViewView.getPaddingBottom());
          }
          else
          {
            if (Build.VERSION.SDK_INT >= 11) {
              try
              {
                this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_a_of_type_AndroidViewView.setRotationY(0.0F);
              }
              catch (Throwable paramMotionEvent)
              {
                QLog.e("WebLog_SwiftFloatViewUI", 1, "floatbtn.setrotationy error!", paramMotionEvent);
              }
            }
            paramMotionEvent = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_b_of_type_AndroidViewView.getLayoutParams();
            paramMotionEvent.gravity = 5;
            paramMotionEvent.rightMargin = (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_a_of_type_Int - paramView.getRight() + k);
            paramMotionEvent.topMargin = j;
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_b_of_type_AndroidViewView.setLayoutParams(paramMotionEvent);
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_b_of_type_AndroidViewView.setPadding((int)(this.jdField_a_of_type_AndroidUtilDisplayMetrics.density * 20.0F), this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_b_of_type_AndroidViewView.getPaddingTop(), (int)(this.jdField_a_of_type_AndroidUtilDisplayMetrics.density * 35.0F), this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_b_of_type_AndroidViewView.getPaddingBottom());
          }
          paramView = new StringBuilder();
          paramView.append(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.c);
          paramView.append("");
          ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "float_bar_show", 0, 1, 0, paramView.toString(), "", "", "");
          return true;
        }
        this.i = Math.min(this.e, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_a_of_type_Int - this.g);
        j = this.i;
        int k = this.e;
        if (j == k)
        {
          paramMotionEvent = new TranslateAnimation(0.0F, -k, 0.0F, 0.0F);
          this.e = 0;
          this.g = (this.e + paramView.getWidth());
        }
        else
        {
          paramMotionEvent = new TranslateAnimation(0.0F, j, 0.0F, 0.0F);
          this.g = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_a_of_type_Int;
          this.e = (this.g - paramView.getWidth());
        }
        paramMotionEvent.setDuration(500L);
        paramView.setVisibility(8);
        paramMotionEvent.setAnimationListener(new SwiftFloatViewUI.2.1(this, paramView));
        paramView.startAnimation(paramMotionEvent);
        return true;
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.c.setVisibility(8);
        j = (int)paramMotionEvent.getRawX();
        this.jdField_a_of_type_Int = j;
        this.c = j;
        j = (int)paramMotionEvent.getRawY();
        this.jdField_b_of_type_Int = j;
        this.d = j;
      }
      label1059:
      return true;
    }
    if (paramView == this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.c)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.c.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_b_of_type_AndroidViewView.setVisibility(8);
      paramView = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI;
      paramView.a(paramView.jdField_a_of_type_AndroidViewView, true);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.i.setVisibility(8);
      return true;
    }
    if (paramView == this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.i)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.c.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_b_of_type_AndroidViewView.setVisibility(8);
      paramView = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI;
      paramView.a(paramView.jdField_a_of_type_AndroidViewView, true);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.i.setVisibility(8);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.SwiftFloatViewUI.2
 * JD-Core Version:    0.7.0.1
 */