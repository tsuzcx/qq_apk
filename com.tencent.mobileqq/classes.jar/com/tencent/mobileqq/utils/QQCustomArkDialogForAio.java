package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer.ArkAppModuleCallback;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer.ArkViewExtraInterface;
import com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.ark.ArkViewAdjustFromKeyboard;
import com.tencent.mobileqq.data.ArkAppMessage.Config;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkApp.Size;
import com.tencent.qphone.base.util.QLog;

public class QQCustomArkDialogForAio
  extends QQCustomDialog
{
  int jdField_a_of_type_Int = 0;
  private ArkViewImplement.LoadCallback jdField_a_of_type_ComTencentArkArkViewImplement$LoadCallback = new QQCustomArkDialogForAio.2(this);
  private ArkAppContainer.ArkAppModuleCallback jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer$ArkAppModuleCallback = new QQCustomArkDialogForAio.1(this);
  ArkAppContainer jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer;
  ArkAppLoadLayout jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout;
  ArkAppView jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
  int b = 0;
  int c = 0;
  int d = 0;
  int e = 0;
  int f = 0;
  int g = -1;
  
  public QQCustomArkDialogForAio(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  private ArkAppContainer a(QQCustomArkDialogForAio.AppInfo paramAppInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer = new ArkAioContainerWrapper();
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getWidth();
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getHeight();
    if (QLog.isDebugVersion()) {
      QLog.d("QQCustomArkDialog", 4, "w=" + i + ",h=" + j + ", appName:" + paramAppInfo.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer.a(paramAppInfo.jdField_a_of_type_JavaLangString, paramAppInfo.b, paramAppInfo.c, paramAppInfo.d, paramAppInfo.jdField_a_of_type_Float, paramAppInfo.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    if ((this.e != 0) && (this.f != 0)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer.setFixSize(this.e, this.f);
    }
    for (;;)
    {
      com.tencent.mobileqq.ark.API.ArkAppModuleBase.a = false;
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer.setFixSize(this.d, this.g);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer.setMaxSize(this.d, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer.setMinSize(this.b, this.c);
    }
  }
  
  private void a(int paramInt)
  {
    if (paramInt != 1)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.getLayoutParams();
      localLayoutParams.addRule(14);
      localLayoutParams.width = this.d;
      localLayoutParams.height = this.d;
      localLayoutParams.setMargins(0, 0, 0, 0);
      this.rBtn.setEnabled(false);
      this.rBtn.setTextColor(Color.parseColor("#656565"));
      return;
    }
    this.rBtn.setEnabled(true);
  }
  
  private void a(Bundle paramBundle)
  {
    paramBundle = a(new QQCustomArkDialogForAio.AppInfo(paramBundle));
    paramBundle.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer$ArkAppModuleCallback);
    if (QLog.isColorLevel()) {
      QLog.w("QQCustomArkDialog", 2, "init");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.a(paramBundle, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout);
  }
  
  public void a(Context paramContext, Bundle paramBundle)
  {
    try
    {
      getWindow().setFlags(16777216, 16777216);
      if (QLog.isColorLevel()) {
        QLog.i("QQCustomArkDialog", 2, "initArkView:" + paramBundle);
      }
      setContentView(2131559084);
      View localView = LayoutInflater.from(paramContext).inflate(2131558899, null);
      localView.setPadding(0, 0, 0, 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView = ((ArkAppView)localView.findViewById(2131362998));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout = ((ArkAppLoadLayout)localView.findViewById(2131370713));
      localView.findViewById(2131363025).setPadding(0, 0, 0, 0);
      ((LinearLayout)localView.findViewById(2131363007)).setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setBorderType(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setLoadCallback(this.jdField_a_of_type_ComTencentArkArkViewImplement$LoadCallback);
      boolean bool1 = paramBundle.getBoolean("is_ark_display_share", false);
      if (QLog.isColorLevel()) {
        QLog.d("QQCustomArkDialog", 2, "from Forward:" + bool1);
      }
      Object localObject1 = new ArkAppMessage.Config();
      Object localObject2 = paramBundle.getString("forward_ark_app_config");
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        ((ArkAppMessage.Config)localObject1).fromString((String)localObject2);
      }
      if ("card".equals(((ArkAppMessage.Config)localObject1).type)) {
        this.g = BaseChatItemLayout.e;
      }
      boolean bool2 = MessageForArkApp.isSetSizeByConfig((ArkAppMessage.Config)localObject1);
      if (bool2)
      {
        localObject2 = MessageForArkApp.limitToSizeRange(ArkAppCenterUtil.a(), ((ArkAppMessage.Config)localObject1).width.intValue(), ((ArkAppMessage.Config)localObject1).height.intValue());
        if (localObject2 != null)
        {
          this.e = ((MessageForArkApp.Size)localObject2).width;
          if ((((ArkAppMessage.Config)localObject1).autoSize != null) && (((ArkAppMessage.Config)localObject1).autoSize.intValue() == 1)) {
            this.e = BaseChatItemLayout.e;
          }
          this.f = ((MessageForArkApp.Size)localObject2).height;
          if (QLog.isColorLevel())
          {
            float f1 = ArkAppCenterUtil.a();
            i = (int)(((MessageForArkApp.Size)localObject2).width / f1);
            j = (int)(((MessageForArkApp.Size)localObject2).height / f1);
            QLog.d("QQCustomArkDialog", 2, "width_from_sdk:" + ((ArkAppMessage.Config)localObject1).width + ", height_from_sdk:" + ((ArkAppMessage.Config)localObject1).height + ", scale:" + f1 + ", realwidth:" + i + ", realheight:" + j);
          }
        }
      }
      localObject1 = null;
      if (this.bodyLayout != null) {
        localObject1 = (RelativeLayout.LayoutParams)this.bodyLayout.getLayoutParams();
      }
      this.rootView.setPadding(0, 0, 0, 0);
      if (!bool1)
      {
        localObject2 = findViewById(2131363904);
        if (localObject2 != null) {
          ((View)localObject2).setVisibility(8);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView);
        localObject2 = findViewById(2131365767);
        if (localObject2 != null) {
          ((View)localObject2).setVisibility(8);
        }
        localObject2 = findViewById(2131365787);
        if (localObject2 != null) {
          ((View)localObject2).setVisibility(8);
        }
        if (localObject1 != null)
        {
          ((RelativeLayout.LayoutParams)localObject1).setMargins(0, 0, 0, 0);
          this.bodyLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        i = 0;
        localObject1 = new LinearLayout.LayoutParams(-1, -2);
        j = MessageForArkApp.dp2px(1.0F);
        ((LinearLayout.LayoutParams)localObject1).setMargins(j, j, j, j);
        localObject2 = new GradientDrawable();
        ((GradientDrawable)localObject2).setStroke(j, 436207616);
        if (this.bodyLayout != null)
        {
          if (!bool2) {
            this.bodyLayout.setBackgroundDrawable((Drawable)localObject2);
          }
          addCenterView(localView, (LinearLayout.LayoutParams)localObject1);
        }
        this.jdField_a_of_type_Int = MessageForArkApp.dp2px(390.0F);
        this.b = MessageForArkApp.dp2px(30.0F);
        this.c = MessageForArkApp.dp2px(30.0F);
        this.d = (MessageForArkApp.dp2px(296.0F) - i - j * 2);
        localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).addRule(14);
        ((RelativeLayout.LayoutParams)localObject1).width = this.d;
        ((RelativeLayout.LayoutParams)localObject1).height = this.d;
        ((RelativeLayout.LayoutParams)localObject1).setMargins(0, 0, 0, 0);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.post(new QQCustomArkDialogForAio.3(this, paramBundle));
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setInputHolderAnchor((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getRootView());
        if (!(paramContext instanceof Activity)) {
          break label897;
        }
        paramContext = (Activity)paramContext;
        if (paramContext != null) {
          ArkViewAdjustFromKeyboard.a(paramContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView);
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
              label897:
              paramContext = null;
            }
          }
          else
          {
            i = 0;
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
    com.tencent.mobileqq.ark.API.ArkAppModuleBase.a = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomArkDialogForAio
 * JD-Core Version:    0.7.0.1
 */