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
import android.view.View.OnTouchListener;
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
  ArkAppView a;
  ArkAppContainer b;
  ArkAppLoadLayout c;
  int d = 0;
  int e = 0;
  int f = 0;
  int g = 0;
  int h = 0;
  int i = 0;
  int j = -1;
  private ArkAppContainer.ArkAppModuleCallback k = new QQCustomArkDialogForAio.1(this);
  private ArkViewImplement.LoadCallback l = new QQCustomArkDialogForAio.2(this);
  
  public QQCustomArkDialogForAio(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  private ArkAppContainer a(QQCustomArkDialogForAio.AppInfo paramAppInfo)
  {
    this.b = new ArkAioContainerWrapper();
    int m = this.a.getWidth();
    int n = this.a.getHeight();
    if (QLog.isDebugVersion())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("w=");
      localStringBuilder.append(m);
      localStringBuilder.append(",h=");
      localStringBuilder.append(n);
      localStringBuilder.append(", appName:");
      localStringBuilder.append(paramAppInfo.a);
      QLog.d("QQCustomArkDialog", 4, localStringBuilder.toString());
    }
    this.b.a(paramAppInfo.a, paramAppInfo.b, paramAppInfo.c, paramAppInfo.d, paramAppInfo.e, paramAppInfo.f);
    m = this.h;
    if (m != 0)
    {
      n = this.i;
      if (n != 0)
      {
        this.b.setFixSize(m, n);
        break label208;
      }
    }
    this.b.setFixSize(this.g, this.j);
    this.b.setMaxSize(this.g, this.d);
    this.b.setMinSize(this.e, this.f);
    label208:
    com.tencent.mobileqq.ark.api.module.ArkAppQQModuleBase.j = false;
    return this.b;
  }
  
  private void a(int paramInt)
  {
    if (paramInt != 1)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
      localLayoutParams.addRule(14);
      paramInt = this.g;
      localLayoutParams.width = paramInt;
      localLayoutParams.height = paramInt;
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
    paramBundle.a(this.k);
    if (QLog.isColorLevel()) {
      QLog.w("QQCustomArkDialog", 2, "init");
    }
    this.a.a(paramBundle, this.c);
  }
  
  public void a(Context paramContext, Bundle paramBundle)
  {
    try
    {
      getWindow().setFlags(16777216, 16777216);
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w("QQCustomArkDialog", 2, localException.getMessage());
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("initArkView:");
      ((StringBuilder)localObject1).append(paramBundle);
      QLog.i("QQCustomArkDialog", 2, ((StringBuilder)localObject1).toString());
    }
    setContentView(2131624611);
    View localView = LayoutInflater.from(paramContext).inflate(2131624417, null);
    localView.setPadding(0, 0, 0, 0);
    this.a = ((ArkAppView)localView.findViewById(2131428746));
    this.c = ((ArkAppLoadLayout)localView.findViewById(2131437612));
    localView.findViewById(2131428772).setPadding(0, 0, 0, 0);
    ((LinearLayout)localView.findViewById(2131428755)).setVisibility(8);
    this.a.setBorderType(0);
    this.a.setLoadCallback(this.l);
    boolean bool1 = paramBundle.getBoolean("is_ark_display_share", false);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("from Forward:");
      ((StringBuilder)localObject1).append(bool1);
      QLog.d("QQCustomArkDialog", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new ArkAppMessage.Config();
    Object localObject2 = paramBundle.getString("forward_ark_app_config");
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      ((ArkAppMessage.Config)localObject1).fromString((String)localObject2);
    }
    if ("card".equals(((ArkAppMessage.Config)localObject1).type)) {
      this.j = BaseChatItemLayout.e;
    }
    boolean bool2 = MessageForArkApp.isSetSizeByConfig((ArkAppMessage.Config)localObject1);
    if (bool2)
    {
      localObject2 = MessageForArkApp.limitToSizeRange(ArkAppCenterUtil.d(), ((ArkAppMessage.Config)localObject1).width.intValue(), ((ArkAppMessage.Config)localObject1).height.intValue());
      if (localObject2 != null)
      {
        this.h = ((MessageForArkApp.Size)localObject2).width;
        if ((((ArkAppMessage.Config)localObject1).autoSize != null) && (((ArkAppMessage.Config)localObject1).autoSize.intValue() == 1)) {
          this.h = BaseChatItemLayout.e;
        }
        this.i = ((MessageForArkApp.Size)localObject2).height;
        if (QLog.isColorLevel())
        {
          float f1 = ArkAppCenterUtil.d();
          m = (int)(((MessageForArkApp.Size)localObject2).width / f1);
          n = (int)(((MessageForArkApp.Size)localObject2).height / f1);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("width_from_sdk:");
          ((StringBuilder)localObject2).append(((ArkAppMessage.Config)localObject1).width);
          ((StringBuilder)localObject2).append(", height_from_sdk:");
          ((StringBuilder)localObject2).append(((ArkAppMessage.Config)localObject1).height);
          ((StringBuilder)localObject2).append(", scale:");
          ((StringBuilder)localObject2).append(f1);
          ((StringBuilder)localObject2).append(", realwidth:");
          ((StringBuilder)localObject2).append(m);
          ((StringBuilder)localObject2).append(", realheight:");
          ((StringBuilder)localObject2).append(n);
          QLog.d("QQCustomArkDialog", 2, ((StringBuilder)localObject2).toString());
        }
      }
    }
    if (this.bodyLayout != null) {
      localObject1 = (RelativeLayout.LayoutParams)this.bodyLayout.getLayoutParams();
    } else {
      localObject1 = null;
    }
    this.rootView.setPadding(0, 0, 0, 0);
    if (!bool1)
    {
      localObject2 = findViewById(2131429772);
      if (localObject2 != null) {
        ((View)localObject2).setVisibility(8);
      }
      localObject2 = this.a;
      ((ArkAppView)localObject2).setOnTouchListener((View.OnTouchListener)localObject2);
      localObject2 = findViewById(2131431835);
      if (localObject2 != null) {
        ((View)localObject2).setVisibility(8);
      }
      localObject2 = findViewById(2131431855);
      if (localObject2 != null) {
        ((View)localObject2).setVisibility(8);
      }
      if (localObject1 != null)
      {
        ((RelativeLayout.LayoutParams)localObject1).setMargins(0, 0, 0, 0);
        this.bodyLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
    }
    else if (localObject1 != null)
    {
      m = ((RelativeLayout.LayoutParams)localObject1).leftMargin;
      n = ((RelativeLayout.LayoutParams)localObject1).rightMargin + m;
      m = n;
      if (!QLog.isColorLevel()) {
        break label739;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("margin=");
      ((StringBuilder)localObject1).append(n);
      QLog.d("QQCustomArkDialog", 2, ((StringBuilder)localObject1).toString());
      m = n;
      break label739;
    }
    int m = 0;
    label739:
    localObject1 = new LinearLayout.LayoutParams(-1, -2);
    int n = MessageForArkApp.dp2px(1.0F);
    ((LinearLayout.LayoutParams)localObject1).setMargins(n, n, n, n);
    localObject2 = new GradientDrawable();
    ((GradientDrawable)localObject2).setStroke(n, 436207616);
    if (this.bodyLayout != null)
    {
      if (!bool2) {
        this.bodyLayout.setBackgroundDrawable((Drawable)localObject2);
      }
      addCenterView(localView, (LinearLayout.LayoutParams)localObject1);
    }
    this.d = MessageForArkApp.dp2px(390.0F);
    this.e = MessageForArkApp.dp2px(30.0F);
    this.f = MessageForArkApp.dp2px(30.0F);
    this.g = (MessageForArkApp.dp2px(296.0F) - m - n * 2);
    localObject1 = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).addRule(14);
    m = this.g;
    ((RelativeLayout.LayoutParams)localObject1).width = m;
    ((RelativeLayout.LayoutParams)localObject1).height = m;
    ((RelativeLayout.LayoutParams)localObject1).setMargins(0, 0, 0, 0);
    this.a.post(new QQCustomArkDialogForAio.3(this, paramBundle));
    paramBundle = this.a;
    paramBundle.setInputHolderAnchor((ViewGroup)paramBundle.getRootView());
    if ((paramContext instanceof Activity)) {
      paramContext = (Activity)paramContext;
    } else {
      paramContext = null;
    }
    if (paramContext != null) {
      ArkViewAdjustFromKeyboard.a(paramContext, this.a);
    }
  }
  
  public void dismiss()
  {
    ArkAppContainer localArkAppContainer = this.b;
    if (localArkAppContainer != null) {
      localArkAppContainer.doOnEvent(2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQCustomArkDialog", 2, "dismiss");
    }
    com.tencent.mobileqq.ark.api.module.ArkAppQQModuleBase.j = true;
    super.dismiss();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.a != null) && (paramMotionEvent.getAction() == 0) && ((paramMotionEvent.getX() < this.a.getX() - 10.0F) || (paramMotionEvent.getX() > this.a.getX() + this.a.getWidth() + 10.0F) || (paramMotionEvent.getY() < this.a.getY() - 10.0F) || (paramMotionEvent.getY() > this.a.getY() + this.a.getHeight() + 10.0F)))
    {
      this.a.mViewImpl.resetInputState();
      InputMethodManager localInputMethodManager = (InputMethodManager)this.a.getContext().getSystemService("input_method");
      if (localInputMethodManager != null) {
        localInputMethodManager.hideSoftInputFromWindow(this.a.getWindowToken(), 0);
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setOnDismissListener(@Nullable DialogInterface.OnDismissListener paramOnDismissListener)
  {
    super.setOnDismissListener(paramOnDismissListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomArkDialogForAio
 * JD-Core Version:    0.7.0.1
 */