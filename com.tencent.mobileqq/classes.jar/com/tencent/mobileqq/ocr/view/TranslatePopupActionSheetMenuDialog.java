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
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TranslatePopupActionSheetMenuDialog", 2, localException.toString());
      }
    }
    Object localObject;
    if (Build.VERSION.SDK_INT >= 11)
    {
      super.dismiss();
      localObject = this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslatePopupActionSheetMenuDialog$OnClickActionListener;
      if (localObject != null)
      {
        TranslatePopupActionSheetMenuDialog.MenuItem localMenuItem = this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslatePopupActionSheetMenuDialog$MenuItem;
        if (localMenuItem != null) {
          ((TranslatePopupActionSheetMenuDialog.OnClickActionListener)localObject).a(localMenuItem);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslatePopupActionSheetMenuDialog$MenuItem = null;
      localObject = this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslatePopupActionSheetMenuDialog$OnDismissListener;
      if (localObject != null) {
        ((TranslatePopupActionSheetMenuDialog.OnDismissListener)localObject).a();
      }
    }
    else if (isShowing())
    {
      localObject = this.jdField_a_of_type_AndroidViewAnimationAnimation;
      if ((localObject != null) && (!((Animation)localObject).hasEnded())) {
        return;
      }
      if (this.jdField_a_of_type_AndroidViewAnimationAnimation == null)
      {
        this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidAppActivity, 2130772372);
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
    paramAnimation = this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslatePopupActionSheetMenuDialog$OnClickActionListener;
    if (paramAnimation != null)
    {
      TranslatePopupActionSheetMenuDialog.MenuItem localMenuItem = this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslatePopupActionSheetMenuDialog$MenuItem;
      if (localMenuItem != null) {
        paramAnimation.a(localMenuItem);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslatePopupActionSheetMenuDialog$MenuItem = null;
    paramAnimation = this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslatePopupActionSheetMenuDialog$OnDismissListener;
    if (paramAnimation != null) {
      paramAnimation.a();
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
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TranslatePopupActionSheetMenuDialog", 2, localException.toString());
      }
    }
    super.showAsDropDown(paramView, paramInt1, paramInt2);
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("showAsDropDown ");
      paramView.append(isAboveAnchor());
      QLog.i("TranslatePopupActionSheetMenuDialog", 2, paramView.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.TranslatePopupActionSheetMenuDialog
 * JD-Core Version:    0.7.0.1
 */