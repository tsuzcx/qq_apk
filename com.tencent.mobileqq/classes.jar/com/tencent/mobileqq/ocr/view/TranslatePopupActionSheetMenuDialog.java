package com.tencent.mobileqq.ocr.view;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.PopupWindow;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class TranslatePopupActionSheetMenuDialog
  extends PopupWindow
  implements View.OnClickListener, Animation.AnimationListener
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private TranslatePopupActionSheetMenuDialog.MenuItem jdField_a_of_type_ComTencentMobileqqOcrViewTranslatePopupActionSheetMenuDialog$MenuItem;
  private TranslatePopupActionSheetMenuDialog.OnClickActionListener jdField_a_of_type_ComTencentMobileqqOcrViewTranslatePopupActionSheetMenuDialog$OnClickActionListener;
  private TranslatePopupActionSheetMenuDialog.OnDismissListener jdField_a_of_type_ComTencentMobileqqOcrViewTranslatePopupActionSheetMenuDialog$OnDismissListener;
  
  public void dismiss()
  {
    try
    {
      this.jdField_a_of_type_AndroidAppActivity.getWindowManager().removeView(this.jdField_a_of_type_AndroidViewView);
      if (Build.VERSION.SDK_INT >= 11)
      {
        super.dismiss();
        if ((this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslatePopupActionSheetMenuDialog$OnClickActionListener != null) && (this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslatePopupActionSheetMenuDialog$MenuItem != null)) {
          this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslatePopupActionSheetMenuDialog$OnClickActionListener.a(this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslatePopupActionSheetMenuDialog$MenuItem);
        }
        this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslatePopupActionSheetMenuDialog$MenuItem = null;
        if (this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslatePopupActionSheetMenuDialog$OnDismissListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslatePopupActionSheetMenuDialog$OnDismissListener.a();
        }
        return;
      }
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("TranslatePopupActionSheetMenuDialog", 2, localException.toString());
          }
        }
      } while ((!isShowing()) || ((this.jdField_a_of_type_AndroidViewAnimationAnimation != null) && (!this.jdField_a_of_type_AndroidViewAnimationAnimation.hasEnded())));
      if (this.jdField_a_of_type_AndroidViewAnimationAnimation == null)
      {
        this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidAppActivity, 2130772342);
        this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
      }
      getContentView().startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
    }
  }
  
  public int getMaxAvailableHeight(View paramView, int paramInt)
  {
    Rect localRect = new Rect();
    paramView.getRootView().getWindowVisibleDisplayFrame(localRect);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    return localRect.bottom - (arrayOfInt[1] + paramView.getHeight()) - paramInt;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TranslatePopupActionSheetMenuDialog", 2, "onAnimationEnd");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslatePopupActionSheetMenuDialog$OnClickActionListener != null) && (this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslatePopupActionSheetMenuDialog$MenuItem != null)) {
      this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslatePopupActionSheetMenuDialog$OnClickActionListener.a(this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslatePopupActionSheetMenuDialog$MenuItem);
    }
    this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslatePopupActionSheetMenuDialog$MenuItem = null;
    if (this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslatePopupActionSheetMenuDialog$OnDismissListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslatePopupActionSheetMenuDialog$OnDismissListener.a();
    }
    super.dismiss();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslatePopupActionSheetMenuDialog$MenuItem = ((TranslatePopupActionSheetMenuDialog.MenuItem)paramView.getTag());
    dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2)
  {
    int i = getMaxAvailableHeight(paramView, paramInt2);
    if (i < this.jdField_a_of_type_Int) {
      setHeight(i);
    }
    try
    {
      this.jdField_a_of_type_AndroidAppActivity.getWindowManager().addView(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
      super.showAsDropDown(paramView, paramInt1, paramInt2);
      if (QLog.isColorLevel()) {
        QLog.i("TranslatePopupActionSheetMenuDialog", 2, "showAsDropDown " + isAboveAnchor());
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("TranslatePopupActionSheetMenuDialog", 2, localException.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.TranslatePopupActionSheetMenuDialog
 * JD-Core Version:    0.7.0.1
 */