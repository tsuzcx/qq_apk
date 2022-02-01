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
  private boolean F = false;
  private boolean G = false;
  private boolean H = false;
  private WeakReference<Activity> I = null;
  private ArkAppContainer.ArkAppModuleCallback J = new QQCustomArkDialog.1(this);
  private ArkViewImplement.LoadCallback K = new QQCustomArkDialog.2(this);
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
  
  public QQCustomArkDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  private ArkAppContainer a(QQCustomArkDialog.AppInfo paramAppInfo, Bundle paramBundle)
  {
    this.b = new ArkAppContainer();
    int k = this.a.getWidth();
    int m = this.a.getHeight();
    StringBuilder localStringBuilder;
    if (QLog.isDebugVersion())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("w=");
      localStringBuilder.append(k);
      localStringBuilder.append(",h=");
      localStringBuilder.append(m);
      localStringBuilder.append(", appName:");
      localStringBuilder.append(paramAppInfo.a);
      QLog.d("QQCustomArkDialog", 4, localStringBuilder.toString());
    }
    k = paramBundle.getInt("req_type");
    if (ArkFullScreenAppActivity.a(paramBundle))
    {
      this.b.a(paramAppInfo.a, paramAppInfo.b, paramAppInfo.c, paramAppInfo.d, paramAppInfo.e, paramAppInfo.f);
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
      this.b.a("com.tencent.structmsg", ArkMessageBuilder.a(k), "0.0.0.1", paramBundle, ArkAppCenterUtil.d(), paramAppInfo.f);
    }
    k = this.h;
    if (k != 0)
    {
      m = this.i;
      if (m != 0)
      {
        this.b.setFixSize(k, m);
        break label302;
      }
    }
    this.b.setFixSize(this.g, this.j);
    this.b.setMaxSize(this.g, this.d);
    this.b.setMinSize(this.e, this.f);
    label302:
    com.tencent.mobileqq.ark.api.module.ArkAppQQModuleBase.j = false;
    return this.b;
  }
  
  public static String a(Bundle paramBundle, String paramString)
  {
    int k = paramBundle.getInt("req_type");
    long l = paramBundle.getLong("req_share_id");
    Object localObject1 = paramBundle.getString("title");
    String str3 = paramBundle.getString("desc");
    String str4 = paramBundle.getString("struct_share_key_source_url");
    Object localObject2 = paramBundle.getString("image_url_remote");
    String str6 = paramBundle.getString("image_url");
    paramBundle.getString("res_pkg_name");
    String str1 = paramBundle.getString("audio_url");
    String str5 = paramBundle.getString("app_name");
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject2.put("title", localObject1);
        String str2 = "music";
        if (k == 2)
        {
          str1 = b(str1);
          localJSONObject2.put("musicUrl", str1);
          paramBundle = "music";
        }
        else if (k == 4)
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
          if (str3.contains(HardCodeUtil.a(2131907853))) {
            localObject1 = str3.replace(HardCodeUtil.a(2131907857), "");
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
          localObject1 = c(str6);
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
        if (k != 2) {
          break label459;
        }
        localJSONObject2.put("musicUrl", str1);
        paramBundle = str2;
        localJSONObject2.put("jumpUrl", b(str4));
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
      if (k == 4) {
        paramBundle = "video";
      }
    }
  }
  
  private void a(Bundle paramBundle)
  {
    QQCustomArkDialog.AppInfo localAppInfo = new QQCustomArkDialog.AppInfo(paramBundle);
    localAppInfo.e = ArkAppCenterUtil.d();
    paramBundle = a(localAppInfo, paramBundle);
    paramBundle.a(this.J);
    if (QLog.isColorLevel()) {
      QLog.w("QQCustomArkDialog", 2, "init");
    }
    this.a.a(paramBundle, this.c);
  }
  
  public static String b(String paramString)
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
  
  public static String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    int k = paramString.lastIndexOf(File.separator);
    if (k == -1) {
      return paramString;
    }
    return paramString.substring(k + 1);
  }
  
  private void d(int paramInt)
  {
    Object localObject = this.I;
    if (localObject != null) {
      localObject = (Activity)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    if ((localObject != null) && (!((Activity)localObject).isFinishing()))
    {
      if (paramInt != 1)
      {
        localObject = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(14);
        paramInt = this.g;
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
    ((LinearLayout)findViewById(2131435825)).setVisibility(8);
  }
  
  public void a(int paramInt)
  {
    ArkAppContainer localArkAppContainer = this.b;
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
    setContentView(2131624623);
    View localView = LayoutInflater.from(paramContext).inflate(2131624417, null);
    localView.setPadding(0, 0, 0, 0);
    this.a = ((ArkAppView)localView.findViewById(2131428746));
    this.c = ((ArkAppLoadLayout)localView.findViewById(2131437612));
    Object localObject1 = localView.findViewById(2131428772);
    ((RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams()).addRule(14);
    ((View)localObject1).setPadding(0, 0, 0, 0);
    ((LinearLayout)localView.findViewById(2131428755)).setVisibility(8);
    this.a.setBorderType(0);
    this.a.setLoadCallback(this.K);
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
      this.j = ArkAppCenterUtil.a;
    }
    boolean bool2 = MessageForArkApp.isSetSizeByConfig((ArkAppMessage.Config)localObject1);
    if (bool2)
    {
      localObject2 = MessageForArkApp.limitToSizeRange(ArkAppCenterUtil.d(), ((ArkAppMessage.Config)localObject1).width.intValue(), ((ArkAppMessage.Config)localObject1).height.intValue());
      if (localObject2 != null)
      {
        this.h = ((MessageForArkApp.Size)localObject2).width;
        if ((((ArkAppMessage.Config)localObject1).autoSize != null) && (((ArkAppMessage.Config)localObject1).autoSize.intValue() == 1)) {
          this.h = ArkAppCenterUtil.a;
        }
        this.i = ((MessageForArkApp.Size)localObject2).height;
        if (QLog.isColorLevel())
        {
          float f1 = ArkAppCenterUtil.d();
          k = (int)(((MessageForArkApp.Size)localObject2).width / f1);
          m = (int)(((MessageForArkApp.Size)localObject2).height / f1);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("width_from_sdk:");
          ((StringBuilder)localObject2).append(((ArkAppMessage.Config)localObject1).width);
          ((StringBuilder)localObject2).append(", height_from_sdk:");
          ((StringBuilder)localObject2).append(((ArkAppMessage.Config)localObject1).height);
          ((StringBuilder)localObject2).append(", scale:");
          ((StringBuilder)localObject2).append(f1);
          ((StringBuilder)localObject2).append(", realwidth:");
          ((StringBuilder)localObject2).append(k);
          ((StringBuilder)localObject2).append(", realheight:");
          ((StringBuilder)localObject2).append(m);
          QLog.d("QQCustomArkDialog", 2, ((StringBuilder)localObject2).toString());
        }
      }
    }
    if (this.bodyLayout != null)
    {
      localObject1 = (RelativeLayout.LayoutParams)this.bodyLayout.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).topMargin = ((int)paramContext.getResources().getDimension(2131297281));
      ((RelativeLayout.LayoutParams)localObject1).leftMargin = ((int)paramContext.getResources().getDimension(2131297252));
      ((RelativeLayout.LayoutParams)localObject1).rightMargin = ((int)paramContext.getResources().getDimension(2131297253));
      ((RelativeLayout.LayoutParams)localObject1).bottomMargin = ((int)paramContext.getResources().getDimension(2131297277));
    }
    else
    {
      localObject1 = null;
    }
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
      k = ((RelativeLayout.LayoutParams)localObject1).leftMargin;
      m = ((RelativeLayout.LayoutParams)localObject1).rightMargin;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("margin=");
        ((StringBuilder)localObject2).append(k + m);
        QLog.d("QQCustomArkDialog", 2, ((StringBuilder)localObject2).toString());
      }
    }
    localObject2 = new LinearLayout.LayoutParams(-1, -2);
    int k = MessageForArkApp.dp2px(1.0F);
    ((LinearLayout.LayoutParams)localObject2).setMargins(k, k, k, k);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setStroke(k, 436207616);
    if (this.bodyLayout != null)
    {
      if (!bool2) {
        this.bodyLayout.setBackgroundDrawable(localGradientDrawable);
      }
      addCenterView(localView, (LinearLayout.LayoutParams)localObject2);
    }
    this.d = MessageForArkApp.dp2px(390.0F);
    this.e = MessageForArkApp.dp2px(30.0F);
    this.f = MessageForArkApp.dp2px(30.0F);
    int m = paramContext.getResources().getDimensionPixelSize(2131297276);
    if (localObject1 != null) {
      k = ((RelativeLayout.LayoutParams)localObject1).leftMargin + ((RelativeLayout.LayoutParams)localObject1).rightMargin;
    } else {
      k = 0;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("init bundle mWidth=");
    ((StringBuilder)localObject1).append(this.g);
    ((StringBuilder)localObject1).append(", dialogWidth=");
    ((StringBuilder)localObject1).append(m);
    ((StringBuilder)localObject1).append(",bodyMargin=");
    ((StringBuilder)localObject1).append(k);
    QLog.i("QQCustomArkDialog", 1, ((StringBuilder)localObject1).toString());
    this.g = (m - k);
    localObject1 = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).addRule(14);
    k = this.g;
    ((RelativeLayout.LayoutParams)localObject1).width = k;
    ((RelativeLayout.LayoutParams)localObject1).height = k;
    ((RelativeLayout.LayoutParams)localObject1).setMargins(0, 0, 0, 0);
    ThreadManager.getUIHandler().post(new QQCustomArkDialog.3(this, paramBundle));
    paramBundle = this.a;
    paramBundle.setInputHolderAnchor((ViewGroup)paramBundle.getRootView());
    if ((paramContext instanceof Activity)) {
      paramContext = (Activity)paramContext;
    } else {
      paramContext = null;
    }
    if (paramContext != null)
    {
      ArkViewAdjustFromKeyboard.a(paramContext, this.a);
      this.I = new WeakReference(paramContext);
    }
    ThreadManager.getUIHandler().postDelayed(new QQCustomArkDialog.4(this), 200L);
  }
  
  public void a(String paramString)
  {
    this.A.setVisibility(0);
    this.title.setVisibility(8);
    this.D.setVisibility(8);
    this.C.setVisibility(8);
    ((TextView)this.A.findViewById(2131449004)).setText(paramString);
  }
  
  public void dismiss()
  {
    ArkAppContainer localArkAppContainer = this.b;
    if (localArkAppContainer != null) {
      localArkAppContainer.doOnEvent(2);
    }
    QLog.d("QQCustomArkDialog", 1, "dismiss");
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
  
  public void show()
  {
    this.F = true;
    if (QLog.isColorLevel()) {
      QLog.d("QQCustomArkDialog", 2, new Object[] { "dialog show,arkViewLoadFinish = ", Boolean.valueOf(this.G), ";alreadyShowDialog:", Boolean.valueOf(this.H) });
    }
    if (this.G)
    {
      this.H = true;
      super.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomArkDialog
 * JD-Core Version:    0.7.0.1
 */