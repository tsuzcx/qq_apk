package com.tencent.mobileqq.utils;

import afvh;
import afvi;
import afvl;
import afvm;
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
import aowr;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.data.ArkAppMessage.Config;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkApp.Size;
import com.tencent.qphone.base.util.QLog;

public class QQCustomArkDialogForAio
  extends QQCustomDialog
{
  private static final String DISABLE_COLOR = "#656565";
  private static final String TAG = "QQCustomArkDialog";
  int adjustHeight = -1;
  int arkapp_height_fromsdk = 0;
  int arkapp_width_fromsdk = 0;
  afvi mAppContainer;
  ArkAppLoadLayout mArkLoadLayout;
  ArkAppView mArkView;
  private afvl mCallback = new QQCustomArkDialogForAio.1(this);
  private ArkViewImplement.LoadCallback mLoadCallback = new QQCustomArkDialogForAio.2(this);
  int mWidth = 0;
  int maxHight = 0;
  int minHight = 0;
  int minWidth = 0;
  
  public QQCustomArkDialogForAio(Context paramContext)
  {
    super(paramContext);
  }
  
  public QQCustomArkDialogForAio(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  private afvi createApp(QQCustomArkDialogForAio.AppInfo paramAppInfo)
  {
    this.mAppContainer = new afvh();
    int i = this.mArkView.getWidth();
    int j = this.mArkView.getHeight();
    if (QLog.isDebugVersion()) {
      QLog.d("QQCustomArkDialog", 4, "w=" + i + ",h=" + j + ", appName:" + paramAppInfo.appName);
    }
    this.mAppContainer.a(paramAppInfo.appName, paramAppInfo.appView, paramAppInfo.appMinVersion, paramAppInfo.metaData, paramAppInfo.scale, paramAppInfo.session);
    if ((this.arkapp_width_fromsdk != 0) && (this.arkapp_height_fromsdk != 0)) {
      this.mAppContainer.setFixSize(this.arkapp_width_fromsdk, this.arkapp_height_fromsdk);
    }
    for (;;)
    {
      aopk.a = false;
      return this.mAppContainer;
      this.mAppContainer.setFixSize(this.mWidth, this.adjustHeight);
      this.mAppContainer.setMaxSize(this.mWidth, this.maxHight);
      this.mAppContainer.setMinSize(this.minWidth, this.minHight);
    }
  }
  
  private void init(Bundle paramBundle)
  {
    paramBundle = createApp(new QQCustomArkDialogForAio.AppInfo(paramBundle));
    paramBundle.a(this.mCallback);
    if (QLog.isColorLevel()) {
      QLog.w("QQCustomArkDialog", 2, "init");
    }
    this.mArkView.a(paramBundle, this.mArkLoadLayout);
  }
  
  private void onLoadCallback(int paramInt)
  {
    if (paramInt != 1)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.mArkLoadLayout.getLayoutParams();
      localLayoutParams.addRule(14);
      localLayoutParams.width = this.mWidth;
      localLayoutParams.height = this.mWidth;
      localLayoutParams.setMargins(0, 0, 0, 0);
      this.rBtn.setEnabled(false);
      this.rBtn.setTextColor(Color.parseColor("#656565"));
      return;
    }
    this.rBtn.setEnabled(true);
  }
  
  public void dismiss()
  {
    if (this.mAppContainer != null) {
      this.mAppContainer.doOnEvent(2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQCustomArkDialog", 2, "dismiss");
    }
    aopk.a = true;
    super.dismiss();
  }
  
  public void initArkView(Context paramContext, Bundle paramBundle)
  {
    try
    {
      getWindow().setFlags(16777216, 16777216);
      if (QLog.isColorLevel()) {
        QLog.i("QQCustomArkDialog", 2, "initArkView:" + paramBundle);
      }
      setContentView(2131559016);
      View localView = LayoutInflater.from(paramContext).inflate(2131558834, null);
      localView.setPadding(0, 0, 0, 0);
      this.mArkView = ((ArkAppView)localView.findViewById(2131362940));
      this.mArkLoadLayout = ((ArkAppLoadLayout)localView.findViewById(2131370257));
      localView.findViewById(2131362966).setPadding(0, 0, 0, 0);
      ((LinearLayout)localView.findViewById(2131362949)).setVisibility(8);
      this.mArkView.setBorderType(0);
      this.mArkView.setLoadCallback(this.mLoadCallback);
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
        this.adjustHeight = BaseChatItemLayout.e;
      }
      boolean bool2 = MessageForArkApp.isSetSizeByConfig((ArkAppMessage.Config)localObject1);
      if (bool2)
      {
        localObject2 = MessageForArkApp.limitToSizeRange(ArkAppCenterUtil.getDensity(), ((ArkAppMessage.Config)localObject1).width.intValue(), ((ArkAppMessage.Config)localObject1).height.intValue());
        if (localObject2 != null)
        {
          this.arkapp_width_fromsdk = ((MessageForArkApp.Size)localObject2).width;
          if ((((ArkAppMessage.Config)localObject1).autoSize != null) && (((ArkAppMessage.Config)localObject1).autoSize.intValue() == 1)) {
            this.arkapp_width_fromsdk = BaseChatItemLayout.e;
          }
          this.arkapp_height_fromsdk = ((MessageForArkApp.Size)localObject2).height;
          if (QLog.isColorLevel())
          {
            float f = ArkAppCenterUtil.getDensity();
            i = (int)(((MessageForArkApp.Size)localObject2).width / f);
            j = (int)(((MessageForArkApp.Size)localObject2).height / f);
            QLog.d("QQCustomArkDialog", 2, "width_from_sdk:" + ((ArkAppMessage.Config)localObject1).width + ", height_from_sdk:" + ((ArkAppMessage.Config)localObject1).height + ", scale:" + f + ", realwidth:" + i + ", realheight:" + j);
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
        localObject2 = findViewById(2131363734);
        if (localObject2 != null) {
          ((View)localObject2).setVisibility(8);
        }
        this.mArkView.setOnTouchListener(this.mArkView);
        localObject2 = findViewById(2131365514);
        if (localObject2 != null) {
          ((View)localObject2).setVisibility(8);
        }
        localObject2 = findViewById(2131365532);
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
        this.maxHight = MessageForArkApp.dp2px(390.0F);
        this.minWidth = MessageForArkApp.dp2px(30.0F);
        this.minHight = MessageForArkApp.dp2px(30.0F);
        this.mWidth = (MessageForArkApp.dp2px(296.0F) - i - j * 2);
        localObject1 = (RelativeLayout.LayoutParams)this.mArkLoadLayout.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).addRule(14);
        ((RelativeLayout.LayoutParams)localObject1).width = this.mWidth;
        ((RelativeLayout.LayoutParams)localObject1).height = this.mWidth;
        ((RelativeLayout.LayoutParams)localObject1).setMargins(0, 0, 0, 0);
        this.mArkView.post(new QQCustomArkDialogForAio.3(this, paramBundle));
        this.mArkView.setInputHolderAnchor((ViewGroup)this.mArkView.getRootView());
        if (!(paramContext instanceof Activity)) {
          break label902;
        }
        paramContext = (Activity)paramContext;
        if (paramContext != null) {
          aowr.a(paramContext, this.mArkView);
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
              label902:
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
  
  public void onEvent(int paramInt)
  {
    if (this.mAppContainer == null) {
      return;
    }
    this.mAppContainer.doOnEvent(paramInt);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.mArkView != null) && (paramMotionEvent.getAction() == 0) && ((paramMotionEvent.getX() < this.mArkView.getX() - 10.0F) || (paramMotionEvent.getX() > this.mArkView.getX() + this.mArkView.getWidth() + 10.0F) || (paramMotionEvent.getY() < this.mArkView.getY() - 10.0F) || (paramMotionEvent.getY() > this.mArkView.getY() + this.mArkView.getHeight() + 10.0F)))
    {
      this.mArkView.mViewImpl.resetInputState();
      InputMethodManager localInputMethodManager = (InputMethodManager)this.mArkView.getContext().getSystemService("input_method");
      if (localInputMethodManager != null) {
        localInputMethodManager.hideSoftInputFromWindow(this.mArkView.getWindowToken(), 0);
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