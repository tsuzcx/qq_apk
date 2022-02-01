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
  private Activity a;
  private Animation b;
  private TranslatePopupActionSheetMenuDialog.OnClickActionListener c;
  private TranslatePopupActionSheetMenuDialog.OnDismissListener d;
  private TranslatePopupActionSheetMenuDialog.MenuItem e;
  private int f;
  private WindowManager.LayoutParams g;
  private View h;
  
  public void dismiss()
  {
    try
    {
      this.a.getWindowManager().removeView(this.h);
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
      localObject = this.c;
      if (localObject != null)
      {
        TranslatePopupActionSheetMenuDialog.MenuItem localMenuItem = this.e;
        if (localMenuItem != null) {
          ((TranslatePopupActionSheetMenuDialog.OnClickActionListener)localObject).a(localMenuItem);
        }
      }
      this.e = null;
      localObject = this.d;
      if (localObject != null) {
        ((TranslatePopupActionSheetMenuDialog.OnDismissListener)localObject).a();
      }
    }
    else if (isShowing())
    {
      localObject = this.b;
      if ((localObject != null) && (!((Animation)localObject).hasEnded())) {
        return;
      }
      if (this.b == null)
      {
        this.b = AnimationUtils.loadAnimation(this.a, 2130772464);
        this.b.setAnimationListener(this);
      }
      getContentView().startAnimation(this.b);
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
    paramAnimation = this.c;
    if (paramAnimation != null)
    {
      TranslatePopupActionSheetMenuDialog.MenuItem localMenuItem = this.e;
      if (localMenuItem != null) {
        paramAnimation.a(localMenuItem);
      }
    }
    this.e = null;
    paramAnimation = this.d;
    if (paramAnimation != null) {
      paramAnimation.a();
    }
    super.dismiss();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick(View paramView)
  {
    this.e = ((TranslatePopupActionSheetMenuDialog.MenuItem)paramView.getTag());
    dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2)
  {
    int i = getMaxAvailableHeight(paramView, paramInt2);
    if (i < this.f) {
      setHeight(i);
    }
    try
    {
      this.a.getWindowManager().addView(this.h, this.g);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.TranslatePopupActionSheetMenuDialog
 * JD-Core Version:    0.7.0.1
 */