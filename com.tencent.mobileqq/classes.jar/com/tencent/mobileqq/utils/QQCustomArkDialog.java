package com.tencent.mobileqq.utils;

import akli;
import aklj;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
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
import com.tencent.mobileqq.data.ArkAppMessage.Config;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkApp.Size;
import com.tencent.qphone.base.util.QLog;

public class QQCustomArkDialog
  extends QQCustomDialog
{
  int jdField_a_of_type_Int = 0;
  private ArkAppContainer.ArkAppModuleCallback jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer$ArkAppModuleCallback = new akli(this);
  ArkAppContainer jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer;
  ArkAppView jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
  boolean jdField_a_of_type_Boolean = false;
  int b = 0;
  int c = 0;
  int d = 0;
  int e = 0;
  
  public QQCustomArkDialog(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramInt);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private ArkAppContainer a(QQCustomArkDialog.AppInfo paramAppInfo)
  {
    Object localObject;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = new ArkAioContainerWrapper();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer = ((ArkAppContainer)localObject);
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getWidth();
      int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getHeight();
      if (QLog.isDebugVersion()) {
        QLog.d("QQCustomArkDialog", 4, "w=" + i + ",h=" + j + ", appName:" + paramAppInfo.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer.a(paramAppInfo.jdField_a_of_type_JavaLangString, paramAppInfo.b, paramAppInfo.c, paramAppInfo.d, paramAppInfo.jdField_a_of_type_Float, paramAppInfo.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      if ((this.d == 0) || (this.e == 0)) {
        break label168;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer.setFixSize(this.d, this.e);
    }
    for (;;)
    {
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer;
      localObject = new ArkAppContainer();
      break;
      label168:
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer.setFixSize(this.c, -1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer.setMaxSize(this.c, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer.setMinSize(this.c, this.b);
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
      setContentView(2130968855);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView = new ArkAppView(paramContext, null);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setBorderType(0);
      boolean bool1 = paramBundle.getBoolean("is_ark_display_share", false);
      if (QLog.isColorLevel()) {
        QLog.d("QQCustomArkDialog", 2, "from Forward:" + bool1);
      }
      Object localObject1 = new ArkAppMessage.Config();
      localObject3 = paramBundle.getString("forward_ark_app_config");
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        ((ArkAppMessage.Config)localObject1).fromString((String)localObject3);
      }
      boolean bool2 = MessageForArkApp.isSetSizeByConfig((ArkAppMessage.Config)localObject1);
      if (bool2)
      {
        localObject3 = MessageForArkApp.limitToSizeRange(paramContext, ((ArkAppMessage.Config)localObject1).width.intValue(), ((ArkAppMessage.Config)localObject1).height.intValue());
        if (localObject3 != null)
        {
          this.d = ((MessageForArkApp.Size)localObject3).width;
          this.e = ((MessageForArkApp.Size)localObject3).height;
          if (QLog.isColorLevel())
          {
            float f = paramContext.getResources().getDisplayMetrics().scaledDensity;
            i = (int)(((MessageForArkApp.Size)localObject3).width / f);
            j = (int)(((MessageForArkApp.Size)localObject3).height / f);
            QLog.d("QQCustomArkDialog", 2, "width_from_sdk:" + ((ArkAppMessage.Config)localObject1).width + ", height_from_sdk:" + ((ArkAppMessage.Config)localObject1).height + ", scale:" + f + ", realwidth:" + i + ", realheight:" + j);
          }
        }
      }
      if (this.bodyLayout != null)
      {
        localObject1 = (RelativeLayout.LayoutParams)this.bodyLayout.getLayoutParams();
        if (!bool1)
        {
          localObject3 = findViewById(2131364061);
          if (localObject3 != null) {
            ((View)localObject3).setVisibility(8);
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView);
          localObject3 = findViewById(2131364058);
          if (localObject3 != null) {
            ((View)localObject3).setVisibility(8);
          }
          localObject3 = findViewById(2131364060);
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
          if (this.bodyLayout != null)
          {
            if (!bool2) {
              break label713;
            }
            addCenterView(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView, (LinearLayout.LayoutParams)localObject1);
          }
          this.jdField_a_of_type_Int = AIOUtils.a(390.0F, paramContext.getResources());
          this.b = AIOUtils.a(132.0F, paramContext.getResources());
          this.c = (AIOUtils.a(296.0F, paramContext.getResources()) - i - j * 2);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.post(new aklj(this, paramBundle));
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setInputHolderAnchor((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getRootView());
          if (!(paramContext instanceof Activity)) {
            break label736;
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
        Object localObject3;
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
              label713:
              this.bodyLayout.setBackgroundDrawable((Drawable)localObject3);
              addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView, localException);
              continue;
              label736:
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