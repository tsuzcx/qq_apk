package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.graphics.Color;
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
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer.ArkAppModuleCallback;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer.ArkViewExtraInterface;
import com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.ark.ArkViewAdjustFromKeyboard;
import com.tencent.mobileqq.data.ArkAppMessage.Config;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkApp.Size;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class QQCustomArkDialog
  extends QQCustomDialogWtihEmoticonInput
{
  int jdField_a_of_type_Int = 0;
  private ArkViewImplement.LoadCallback jdField_a_of_type_ComTencentArkArkViewImplement$LoadCallback = new QQCustomArkDialog.2(this);
  private ArkAppContainer.ArkAppModuleCallback jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer$ArkAppModuleCallback = new QQCustomArkDialog.1(this);
  ArkAppContainer jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer;
  ArkAppLoadLayout jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout;
  ArkAppView jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference = null;
  int b;
  int c;
  int jdField_d_of_type_Int = 0;
  private boolean jdField_d_of_type_Boolean = false;
  int jdField_e_of_type_Int = 0;
  private boolean jdField_e_of_type_Boolean = false;
  int jdField_f_of_type_Int = 0;
  private boolean jdField_f_of_type_Boolean = false;
  int g = -1;
  
  public QQCustomArkDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
  }
  
  private ArkAppContainer a(QQCustomArkDialog.AppInfo paramAppInfo, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer = new ArkAppContainer();
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getWidth();
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getHeight();
    StringBuilder localStringBuilder;
    if (QLog.isDebugVersion())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("w=");
      localStringBuilder.append(i);
      localStringBuilder.append(",h=");
      localStringBuilder.append(j);
      localStringBuilder.append(", appName:");
      localStringBuilder.append(paramAppInfo.jdField_a_of_type_JavaLangString);
      QLog.d("QQCustomArkDialog", 4, localStringBuilder.toString());
    }
    i = paramBundle.getInt("req_type");
    if (ArkFullScreenAppActivity.a(paramBundle))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer.a(paramAppInfo.jdField_a_of_type_JavaLangString, paramAppInfo.b, paramAppInfo.c, paramAppInfo.d, paramAppInfo.jdField_a_of_type_Float, paramAppInfo.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    else
    {
      paramBundle = a(paramBundle, "com.tencent.structmsg");
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(",metaData=");
        localStringBuilder.append(paramBundle);
        QLog.d("QQCustomArkDialog", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer.a("com.tencent.structmsg", ArkMessageBuilder.a(i), "0.0.0.1", paramBundle, ArkAppCenterUtil.a(), paramAppInfo.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    i = this.jdField_e_of_type_Int;
    if (i != 0)
    {
      j = this.jdField_f_of_type_Int;
      if (j != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer.setFixSize(i, j);
        break label302;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer.setFixSize(this.jdField_d_of_type_Int, this.g);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer.setMaxSize(this.jdField_d_of_type_Int, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer.setMinSize(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
    label302:
    com.tencent.mobileqq.ark.api.module.ArkAppQQModuleBase.a = false;
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer;
  }
  
  public static String a(Bundle paramBundle, String paramString)
  {
    int i = paramBundle.getInt("req_type");
    long l = paramBundle.getLong("req_share_id");
    Object localObject1 = paramBundle.getString("title");
    String str3 = paramBundle.getString("desc");
    String str4 = paramBundle.getString("struct_share_key_source_url");
    Object localObject2 = paramBundle.getString("image_url_remote");
    String str6 = paramBundle.getString("image_url");
    paramBundle.getString("res_pkg_name");
    String str1 = paramBundle.getString("audio_url");
    String str5 = paramBundle.getString("appName");
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject2.put("title", localObject1);
        String str2 = "music";
        if (i == 2)
        {
          str1 = a(str1);
          localJSONObject2.put("musicUrl", str1);
          paramBundle = "music";
        }
        else if (i == 4)
        {
          paramBundle = "video";
        }
        else
        {
          paramBundle = "news";
        }
        boolean bool = TextUtils.isEmpty(str3);
        localObject1 = str3;
        if (!bool)
        {
          localObject1 = str3;
          if (str3.contains(HardCodeUtil.a(2131710148))) {
            localObject1 = str3.replace(HardCodeUtil.a(2131710152), "");
          }
        }
        localJSONObject2.put("desc", localObject1);
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          paramString = (String)localObject2;
        }
        else
        {
          if (TextUtils.isEmpty(str6)) {
            break label453;
          }
          localObject1 = b(str6);
          paramString = ArkEnvironmentManager.getInstance().getAppResPath(paramString);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramString);
          ((StringBuilder)localObject2).append(File.separator);
          ((StringBuilder)localObject2).append((String)localObject1);
          FileUtils.copyFile(str6, ((StringBuilder)localObject2).toString());
          paramString = new StringBuilder();
          paramString.append("res:");
          paramString.append((String)localObject1);
          paramString = paramString.toString();
        }
        localJSONObject2.put("preview", paramString);
        localJSONObject2.put("tag", str5);
        if (i != 2) {
          break label459;
        }
        localJSONObject2.put("musicUrl", str1);
        paramBundle = str2;
        localJSONObject2.put("jumpUrl", a(str4));
        localJSONObject2.put("appid", l);
        localJSONObject2.put("app_type", 1);
        localJSONObject1.put(paramBundle, localJSONObject2);
      }
      catch (Exception paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQCustomArkDialog", 2, paramBundle.toString());
        }
      }
      paramString = localJSONObject1.toString();
      paramBundle = paramString;
      if (!TextUtils.isEmpty(paramString)) {
        paramBundle = paramString.replace("\\/", "/");
      }
      return paramBundle;
      label453:
      paramString = "";
      continue;
      label459:
      if (i == 4) {
        paramBundle = "video";
      }
    }
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    String str = paramString;
    if (paramString.contains("http://")) {
      str = paramString.replace("http://", "");
    }
    paramString = str;
    if (str.contains("https://")) {
      paramString = str.replace("https://", "");
    }
    return paramString;
  }
  
  private void a(Bundle paramBundle)
  {
    QQCustomArkDialog.AppInfo localAppInfo = new QQCustomArkDialog.AppInfo(paramBundle);
    localAppInfo.jdField_a_of_type_Float = ArkAppCenterUtil.a();
    paramBundle = a(localAppInfo, paramBundle);
    paramBundle.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer$ArkAppModuleCallback);
    if (QLog.isColorLevel()) {
      QLog.w("QQCustomArkDialog", 2, "init");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.a(paramBundle, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout);
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    int i = paramString.lastIndexOf(File.separator);
    if (i == -1) {
      return paramString;
    }
    return paramString.substring(i + 1);
  }
  
  private void d(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null) {
      localObject = (Activity)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    if ((localObject != null) && (!((Activity)localObject).isFinishing()))
    {
      if (paramInt != 1)
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(14);
        paramInt = this.jdField_d_of_type_Int;
        ((RelativeLayout.LayoutParams)localObject).width = paramInt;
        ((RelativeLayout.LayoutParams)localObject).height = paramInt;
        ((RelativeLayout.LayoutParams)localObject).setMargins(0, 0, 0, 0);
        this.rBtn.setEnabled(false);
        this.rBtn.setTextColor(Color.parseColor("#656565"));
        return;
      }
      this.rBtn.setEnabled(true);
      return;
    }
    QLog.d("QQCustomArkDialog", 1, "onLoadFinish.right now activity is null or finished");
  }
  
  public void a()
  {
    ((LinearLayout)findViewById(2131368885)).setVisibility(8);
  }
  
  public void a(int paramInt)
  {
    ArkAppContainer localArkAppContainer = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer;
    if (localArkAppContainer == null) {
      return;
    }
    localArkAppContainer.doOnEvent(paramInt);
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
    QLog.i("QQCustomArkDialog", 1, "get init dialog stack", new Exception("InitQQCustomArkDialogStack"));
    b(7);
    setContentView(2131558990);
    View localView = LayoutInflater.from(paramContext).inflate(2131558797, null);
    localView.setPadding(0, 0, 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView = ((ArkAppView)localView.findViewById(2131362947));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout = ((ArkAppLoadLayout)localView.findViewById(2131370350));
    Object localObject1 = localView.findViewById(2131362973);
    ((RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams()).addRule(14);
    ((View)localObject1).setPadding(0, 0, 0, 0);
    ((LinearLayout)localView.findViewById(2131362956)).setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setBorderType(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setLoadCallback(this.jdField_a_of_type_ComTencentArkArkViewImplement$LoadCallback);
    boolean bool1 = paramBundle.getBoolean("is_ark_display_share", false);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("from Forward:");
      ((StringBuilder)localObject1).append(bool1);
      QLog.d("QQCustomArkDialog", 2, ((StringBuilder)localObject1).toString());
    }
    localObject1 = new ArkAppMessage.Config();
    Object localObject2 = paramBundle.getString("forward_ark_app_config");
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      ((ArkAppMessage.Config)localObject1).fromString((String)localObject2);
    }
    if ((ArkFullScreenAppActivity.a(paramBundle)) && ("card".equals(((ArkAppMessage.Config)localObject1).type))) {
      this.g = ArkAppCenterUtil.jdField_a_of_type_Int;
    }
    boolean bool2 = MessageForArkApp.isSetSizeByConfig((ArkAppMessage.Config)localObject1);
    if (bool2)
    {
      localObject2 = MessageForArkApp.limitToSizeRange(ArkAppCenterUtil.a(), ((ArkAppMessage.Config)localObject1).width.intValue(), ((ArkAppMessage.Config)localObject1).height.intValue());
      if (localObject2 != null)
      {
        this.jdField_e_of_type_Int = ((MessageForArkApp.Size)localObject2).width;
        if ((((ArkAppMessage.Config)localObject1).autoSize != null) && (((ArkAppMessage.Config)localObject1).autoSize.intValue() == 1)) {
          this.jdField_e_of_type_Int = ArkAppCenterUtil.jdField_a_of_type_Int;
        }
        this.jdField_f_of_type_Int = ((MessageForArkApp.Size)localObject2).height;
        if (QLog.isColorLevel())
        {
          float f1 = ArkAppCenterUtil.a();
          i = (int)(((MessageForArkApp.Size)localObject2).width / f1);
          j = (int)(((MessageForArkApp.Size)localObject2).height / f1);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("width_from_sdk:");
          ((StringBuilder)localObject2).append(((ArkAppMessage.Config)localObject1).width);
          ((StringBuilder)localObject2).append(", height_from_sdk:");
          ((StringBuilder)localObject2).append(((ArkAppMessage.Config)localObject1).height);
          ((StringBuilder)localObject2).append(", scale:");
          ((StringBuilder)localObject2).append(f1);
          ((StringBuilder)localObject2).append(", realwidth:");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append(", realheight:");
          ((StringBuilder)localObject2).append(j);
          QLog.d("QQCustomArkDialog", 2, ((StringBuilder)localObject2).toString());
        }
      }
    }
    if (this.bodyLayout != null)
    {
      localObject1 = (RelativeLayout.LayoutParams)this.bodyLayout.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).topMargin = ((int)paramContext.getResources().getDimension(2131296902));
      ((RelativeLayout.LayoutParams)localObject1).leftMargin = ((int)paramContext.getResources().getDimension(2131296873));
      ((RelativeLayout.LayoutParams)localObject1).rightMargin = ((int)paramContext.getResources().getDimension(2131296874));
      ((RelativeLayout.LayoutParams)localObject1).bottomMargin = ((int)paramContext.getResources().getDimension(2131296898));
    }
    else
    {
      localObject1 = null;
    }
    if (!bool1)
    {
      localObject2 = findViewById(2131363832);
      if (localObject2 != null) {
        ((View)localObject2).setVisibility(8);
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
      ((ArkAppView)localObject2).setOnTouchListener((View.OnTouchListener)localObject2);
      localObject2 = findViewById(2131365604);
      if (localObject2 != null) {
        ((View)localObject2).setVisibility(8);
      }
      localObject2 = findViewById(2131365624);
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
      i = ((RelativeLayout.LayoutParams)localObject1).leftMargin;
      j = ((RelativeLayout.LayoutParams)localObject1).rightMargin;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("margin=");
        ((StringBuilder)localObject2).append(i + j);
        QLog.d("QQCustomArkDialog", 2, ((StringBuilder)localObject2).toString());
      }
    }
    localObject2 = new LinearLayout.LayoutParams(-1, -2);
    int i = MessageForArkApp.dp2px(1.0F);
    ((LinearLayout.LayoutParams)localObject2).setMargins(i, i, i, i);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setStroke(i, 436207616);
    if (this.bodyLayout != null)
    {
      if (!bool2) {
        this.bodyLayout.setBackgroundDrawable(localGradientDrawable);
      }
      addCenterView(localView, (LinearLayout.LayoutParams)localObject2);
    }
    this.jdField_a_of_type_Int = MessageForArkApp.dp2px(390.0F);
    this.jdField_b_of_type_Int = MessageForArkApp.dp2px(30.0F);
    this.jdField_c_of_type_Int = MessageForArkApp.dp2px(30.0F);
    int j = paramContext.getResources().getDimensionPixelSize(2131296897);
    if (localObject1 != null) {
      i = ((RelativeLayout.LayoutParams)localObject1).leftMargin + ((RelativeLayout.LayoutParams)localObject1).rightMargin;
    } else {
      i = 0;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("init bundle mWidth=");
    ((StringBuilder)localObject1).append(this.jdField_d_of_type_Int);
    ((StringBuilder)localObject1).append(", dialogWidth=");
    ((StringBuilder)localObject1).append(j);
    ((StringBuilder)localObject1).append(",bodyMargin=");
    ((StringBuilder)localObject1).append(i);
    QLog.i("QQCustomArkDialog", 1, ((StringBuilder)localObject1).toString());
    this.jdField_d_of_type_Int = (j - i);
    localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).addRule(14);
    i = this.jdField_d_of_type_Int;
    ((RelativeLayout.LayoutParams)localObject1).width = i;
    ((RelativeLayout.LayoutParams)localObject1).height = i;
    ((RelativeLayout.LayoutParams)localObject1).setMargins(0, 0, 0, 0);
    ThreadManager.getUIHandler().post(new QQCustomArkDialog.3(this, paramBundle));
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
    paramBundle.setInputHolderAnchor((ViewGroup)paramBundle.getRootView());
    if ((paramContext instanceof Activity)) {
      paramContext = (Activity)paramContext;
    } else {
      paramContext = null;
    }
    if (paramContext != null)
    {
      ArkViewAdjustFromKeyboard.a(paramContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView);
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    }
    ThreadManager.getUIHandler().postDelayed(new QQCustomArkDialog.4(this), 200L);
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.title.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131380091)).setText(paramString);
  }
  
  public void dismiss()
  {
    ArkAppContainer localArkAppContainer = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer;
    if (localArkAppContainer != null) {
      localArkAppContainer.doOnEvent(2);
    }
    QLog.d("QQCustomArkDialog", 1, "dismiss");
    com.tencent.mobileqq.ark.api.module.ArkAppQQModuleBase.a = true;
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
  
  public void show()
  {
    this.jdField_d_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("QQCustomArkDialog", 2, new Object[] { "dialog show,arkViewLoadFinish = ", Boolean.valueOf(this.jdField_e_of_type_Boolean), ";alreadyShowDialog:", Boolean.valueOf(this.jdField_f_of_type_Boolean) });
    }
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_f_of_type_Boolean = true;
      super.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomArkDialog
 * JD-Core Version:    0.7.0.1
 */