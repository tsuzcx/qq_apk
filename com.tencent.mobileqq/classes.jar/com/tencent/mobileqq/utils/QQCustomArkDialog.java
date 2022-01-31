package com.tencent.mobileqq.utils;

import ajpn;
import ajpo;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.ark.ArkViewImplement;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer.ArkAppModuleCallback;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.ark.ArkViewAdjustFromKeyboard;
import com.tencent.qphone.base.util.QLog;

public class QQCustomArkDialog
  extends QQCustomDialog
{
  int jdField_a_of_type_Int = 0;
  private ArkAppContainer.ArkAppModuleCallback jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer$ArkAppModuleCallback = new ajpn(this);
  ArkAppContainer jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer;
  ArkAppView jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
  boolean jdField_a_of_type_Boolean = false;
  int b = 0;
  int c = 0;
  
  public QQCustomArkDialog(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramInt);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private ArkAppContainer a(QQCustomArkDialog.AppInfo paramAppInfo)
  {
    if (this.jdField_a_of_type_Boolean) {}
    for (Object localObject = new ArkAioContainerWrapper();; localObject = new ArkAppContainer())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer = ((ArkAppContainer)localObject);
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getWidth();
      int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getHeight();
      if (QLog.isDebugVersion()) {
        QLog.d("QQCustomArkDialog", 4, "w=" + i + ",h=" + j + ", appName:" + paramAppInfo.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer.a(paramAppInfo.jdField_a_of_type_JavaLangString, paramAppInfo.b, paramAppInfo.c, paramAppInfo.d, paramAppInfo.jdField_a_of_type_Float, paramAppInfo.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer.setFixSize(this.c, -1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer.setMaxSize(this.c, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer.setMinSize(this.c, this.b);
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer;
    }
  }
  
  private void a(Bundle paramBundle)
  {
    paramBundle = a(new QQCustomArkDialog.AppInfo(paramBundle));
    paramBundle.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer$ArkAppModuleCallback);
    if (QLog.isColorLevel()) {
      QLog.w("QQCustomArkDialog", 2, "init");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.initArkView(paramBundle);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer.doOnEvent(paramInt);
  }
  
  public void a(Context paramContext, Bundle paramBundle)
  {
    try
    {
      getWindow().setFlags(16777216, 16777216);
      if (QLog.isColorLevel()) {
        QLog.i("QQCustomArkDialog", 2, "initArkView:" + paramBundle);
      }
      setContentView(2130968851);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView = new ArkAppView(paramContext, null);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setBorderType(0);
      boolean bool = paramBundle.getBoolean("is_ark_display_share", false);
      if (QLog.isColorLevel()) {
        QLog.d("QQCustomArkDialog", 2, "from Forward:" + bool);
      }
      if (this.bodyLayout != null)
      {
        Object localObject1 = (RelativeLayout.LayoutParams)this.bodyLayout.getLayoutParams();
        if (!bool)
        {
          Object localObject3 = findViewById(2131364012);
          if (localObject3 != null) {
            ((View)localObject3).setVisibility(8);
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView);
          localObject3 = findViewById(2131364009);
          if (localObject3 != null) {
            ((View)localObject3).setVisibility(8);
          }
          localObject3 = findViewById(2131364011);
          if (localObject3 != null) {
            ((View)localObject3).setVisibility(8);
          }
          if (localObject1 != null)
          {
            ((RelativeLayout.LayoutParams)localObject1).setMargins(0, 0, 0, 0);
            this.bodyLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
          i = 0;
          localObject1 = new LinearLayout.LayoutParams(-1, -2);
          j = AIOUtils.a(1.0F, paramContext.getResources());
          ((LinearLayout.LayoutParams)localObject1).setMargins(j, j, j, j);
          localObject3 = new GradientDrawable();
          ((GradientDrawable)localObject3).setStroke(j, 436207616);
          if (this.bodyLayout != null) {
            this.bodyLayout.setBackgroundDrawable((Drawable)localObject3);
          }
          addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView, (LinearLayout.LayoutParams)localObject1);
          this.jdField_a_of_type_Int = AIOUtils.a(390.0F, paramContext.getResources());
          this.b = AIOUtils.a(132.0F, paramContext.getResources());
          this.c = (AIOUtils.a(296.0F, paramContext.getResources()) - i - j * 2);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.post(new ajpo(this, paramBundle));
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setInputHolderAnchor((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getRootView());
          if (!(paramContext instanceof Activity)) {
            break label502;
          }
          paramContext = (Activity)paramContext;
          if (paramContext != null) {
            ArkViewAdjustFromKeyboard.a(paramContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView);
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        int j;
        if (QLog.isColorLevel())
        {
          QLog.w("QQCustomArkDialog", 2, localException.getMessage());
          continue;
          if (localException != null)
          {
            i = localException.leftMargin;
            j = localException.rightMargin + i;
            i = j;
            if (QLog.isColorLevel())
            {
              QLog.d("QQCustomArkDialog", 2, "margin=" + j);
              i = j;
              continue;
              label502:
              paramContext = null;
            }
          }
          else
          {
            i = 0;
            continue;
            Object localObject2 = null;
          }
        }
      }
    }
  }
  
  public void dismiss()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer.doOnEvent(2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQCustomArkDialog", 2, "dismiss");
    }
    super.dismiss();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView != null) && (paramMotionEvent.getAction() == 0) && ((paramMotionEvent.getX() < this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getX() - 10.0F) || (paramMotionEvent.getX() > this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getX() + this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getWidth() + 10.0F) || (paramMotionEvent.getY() < this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getY() - 10.0F) || (paramMotionEvent.getY() > this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getY() + this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getHeight() + 10.0F)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.mViewImpl.resetInputState();
      InputMethodManager localInputMethodManager = (InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getContext().getSystemService("input_method");
      if (localInputMethodManager != null) {
        localInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getWindowToken(), 0);
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setOnDismissListener(@Nullable DialogInterface.OnDismissListener paramOnDismissListener)
  {
    super.setOnDismissListener(paramOnDismissListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomArkDialog
 * JD-Core Version:    0.7.0.1
 */