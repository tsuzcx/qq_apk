package com.tencent.mobileqq.utils;

import agnx;
import agoa;
import agob;
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
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anvx;
import apzv;
import bhci;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
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
  private static final String DISABLE_COLOR = "#656565";
  private static final long SHOW_DIALO_GOVERTIME = 200L;
  private static final String TAG = "QQCustomArkDialog";
  int adjustHeight = -1;
  private boolean alreadyShowDialog;
  private boolean arkViewLoadFinish;
  int arkapp_height_fromsdk = 0;
  int arkapp_width_fromsdk = 0;
  private WeakReference<Activity> mActivityRef;
  agnx mAppContainer;
  ArkAppLoadLayout mArkLoadLayout;
  ArkAppView mArkView;
  private agoa mCallback = new QQCustomArkDialog.1(this);
  private ArkViewImplement.LoadCallback mLoadCallback = new QQCustomArkDialog.2(this);
  int mWidth = 0;
  int maxHight = 0;
  int minHight = 0;
  int minWidth = 0;
  private boolean outsideShowDialog;
  
  public QQCustomArkDialog(Context paramContext)
  {
    super(paramContext, 2131755829);
  }
  
  public QQCustomArkDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  private void _onLoadState(int paramInt)
  {
    Object localObject;
    if (this.mActivityRef != null) {
      localObject = (Activity)this.mActivityRef.get();
    }
    while ((localObject != null) && (!((Activity)localObject).isFinishing())) {
      if (paramInt != 1)
      {
        localObject = (RelativeLayout.LayoutParams)this.mArkLoadLayout.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(14);
        ((RelativeLayout.LayoutParams)localObject).width = this.mWidth;
        ((RelativeLayout.LayoutParams)localObject).height = this.mWidth;
        ((RelativeLayout.LayoutParams)localObject).setMargins(0, 0, 0, 0);
        this.rBtn.setEnabled(false);
        this.rBtn.setTextColor(Color.parseColor("#656565"));
        return;
        localObject = null;
      }
      else
      {
        this.rBtn.setEnabled(true);
        return;
      }
    }
    QLog.d("QQCustomArkDialog", 1, "onLoadFinish.right now activity is null or finished");
  }
  
  private agnx createApp(QQCustomArkDialog.AppInfo paramAppInfo, Bundle paramBundle)
  {
    this.mAppContainer = new agnx();
    int i = this.mArkView.getWidth();
    int j = this.mArkView.getHeight();
    if (QLog.isDebugVersion()) {
      QLog.d("QQCustomArkDialog", 4, "w=" + i + ",h=" + j + ", appName:" + paramAppInfo.appName);
    }
    i = paramBundle.getInt("req_type");
    if (ArkFullScreenAppActivity.a(paramBundle))
    {
      this.mAppContainer.a(paramAppInfo.appName, paramAppInfo.appView, paramAppInfo.appMinVersion, paramAppInfo.metaData, paramAppInfo.scale, paramAppInfo.session);
      if ((this.arkapp_width_fromsdk == 0) || (this.arkapp_height_fromsdk == 0)) {
        break label232;
      }
      this.mAppContainer.setFixSize(this.arkapp_width_fromsdk, this.arkapp_height_fromsdk);
    }
    for (;;)
    {
      apsl.a = false;
      return this.mAppContainer;
      paramBundle = getMetaData(paramBundle, "com.tencent.structmsg");
      if (QLog.isColorLevel()) {
        QLog.d("QQCustomArkDialog", 2, ",metaData=" + paramBundle);
      }
      this.mAppContainer.a("com.tencent.structmsg", bhci.a(i), "0.0.0.1", paramBundle, ArkAppCenterUtil.getDensity(), paramAppInfo.session);
      break;
      label232:
      this.mAppContainer.setFixSize(this.mWidth, this.adjustHeight);
      this.mAppContainer.setMaxSize(this.mWidth, this.maxHight);
      this.mAppContainer.setMinSize(this.minWidth, this.minHight);
    }
  }
  
  public static String getFileName(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    int i;
    do
    {
      return str;
      i = paramString.lastIndexOf(File.separator);
      str = paramString;
    } while (i == -1);
    return paramString.substring(i + 1);
  }
  
  public static String getMetaData(Bundle paramBundle, String paramString)
  {
    int i = paramBundle.getInt("req_type");
    long l = paramBundle.getLong("req_share_id");
    Object localObject = paramBundle.getString("title");
    String str3 = paramBundle.getString("desc");
    String str4 = paramBundle.getString("struct_share_key_source_url");
    String str2 = paramBundle.getString("image_url_remote");
    String str6 = paramBundle.getString("image_url");
    paramBundle.getString("res_pkg_name");
    String str1 = paramBundle.getString("audio_url");
    String str5 = paramBundle.getString("app_name");
    paramBundle = "news";
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      localJSONObject2.put("title", localObject);
      if (i != 2) {
        break label326;
      }
      paramBundle = "music";
      localObject = getNoneHeadUrl(str1);
      localJSONObject2.put("musicUrl", localObject);
      str1 = str3;
      if (!TextUtils.isEmpty(str3))
      {
        str1 = str3;
        if (str3.contains(anvx.a(2131709651))) {
          str1 = str3.replace(anvx.a(2131709655), "");
        }
      }
      localJSONObject2.put("desc", str1);
      if (TextUtils.isEmpty(str2)) {
        break label346;
      }
      paramString = str2;
    }
    catch (Exception paramBundle)
    {
      label326:
      for (;;)
      {
        label214:
        label346:
        if (QLog.isColorLevel())
        {
          QLog.e("QQCustomArkDialog", 2, paramBundle.toString());
          continue;
          paramString = "";
        }
      }
    }
    localJSONObject2.put("preview", paramString);
    localJSONObject2.put("tag", str5);
    if (i == 2)
    {
      paramBundle = "music";
      localJSONObject2.put("musicUrl", localObject);
    }
    for (;;)
    {
      localJSONObject2.put("jumpUrl", getNoneHeadUrl(str4));
      localJSONObject2.put("appid", l);
      localJSONObject2.put("app_type", 1);
      localJSONObject1.put(paramBundle, localJSONObject2);
      paramString = localJSONObject1.toString();
      paramBundle = paramString;
      if (!TextUtils.isEmpty(paramString)) {
        paramBundle = paramString.replace("\\/", "/");
      }
      return paramBundle;
      localObject = str1;
      if (i != 4) {
        break;
      }
      paramBundle = "video";
      localObject = str1;
      break;
      if (TextUtils.isEmpty(str6)) {
        break label457;
      }
      str1 = getFileName(str6);
      paramString = ArkEnvironmentManager.getInstance().getAppResPath(paramString);
      FileUtils.copyFile(str6, paramString + File.separator + str1);
      paramString = "res:" + str1;
      break label214;
      if (i == 4) {
        paramBundle = "video";
      }
    }
  }
  
  public static String getNoneHeadUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    String str;
    do
    {
      return paramString;
      str = paramString;
      if (paramString.contains("http://")) {
        str = paramString.replace("http://", "");
      }
      paramString = str;
    } while (!str.contains("https://"));
    return str.replace("https://", "");
  }
  
  private void init(Bundle paramBundle)
  {
    QQCustomArkDialog.AppInfo localAppInfo = new QQCustomArkDialog.AppInfo(paramBundle);
    localAppInfo.scale = ArkAppCenterUtil.getDensity();
    paramBundle = createApp(localAppInfo, paramBundle);
    paramBundle.a(this.mCallback);
    if (QLog.isColorLevel()) {
      QLog.w("QQCustomArkDialog", 2, "init");
    }
    this.mArkView.a(paramBundle, this.mArkLoadLayout);
  }
  
  public void dismiss()
  {
    if (this.mAppContainer != null) {
      this.mAppContainer.doOnEvent(2);
    }
    QLog.d("QQCustomArkDialog", 1, "dismiss");
    apsl.a = true;
    super.dismiss();
  }
  
  public void hideForwardTargetAvatar(String paramString)
  {
    this.mRlTitle.setVisibility(0);
    this.title.setVisibility(8);
    this.mRlMultiForwardTarget.setVisibility(8);
    this.mRlForwardTarget.setVisibility(8);
    ((TextView)this.mRlTitle.findViewById(2131380385)).setText(paramString);
  }
  
  public void hideInputContainer()
  {
    ((LinearLayout)findViewById(2131368921)).setVisibility(8);
  }
  
  public void initArkView(Context paramContext, Bundle paramBundle)
  {
    try
    {
      getWindow().setFlags(16777216, 16777216);
      if (QLog.isColorLevel()) {
        QLog.i("QQCustomArkDialog", 2, "initArkView:" + paramBundle);
      }
      QLog.i("QQCustomArkDialog", 1, "get init dialog stack", new Exception("InitQQCustomArkDialogStack"));
      setEmoticonType(7);
      setContentView(2131559055);
      View localView = LayoutInflater.from(paramContext).inflate(2131558859, null);
      localView.setPadding(0, 0, 0, 0);
      this.mArkView = ((ArkAppView)localView.findViewById(2131362957));
      this.mArkLoadLayout = ((ArkAppLoadLayout)localView.findViewById(2131370436));
      Object localObject1 = localView.findViewById(2131362983);
      ((RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams()).addRule(14);
      ((View)localObject1).setPadding(0, 0, 0, 0);
      ((LinearLayout)localView.findViewById(2131362966)).setVisibility(8);
      this.mArkView.setBorderType(0);
      this.mArkView.setLoadCallback(this.mLoadCallback);
      boolean bool1 = paramBundle.getBoolean("is_ark_display_share", false);
      if (QLog.isColorLevel()) {
        QLog.d("QQCustomArkDialog", 2, "from Forward:" + bool1);
      }
      localObject1 = new ArkAppMessage.Config();
      Object localObject2 = paramBundle.getString("forward_ark_app_config");
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        ((ArkAppMessage.Config)localObject1).fromString((String)localObject2);
      }
      if ((ArkFullScreenAppActivity.a(paramBundle)) && ("card".equals(((ArkAppMessage.Config)localObject1).type))) {
        this.adjustHeight = ArkAppCenterUtil.sChatBubbleMaxWidth;
      }
      boolean bool2 = MessageForArkApp.isSetSizeByConfig((ArkAppMessage.Config)localObject1);
      if (bool2)
      {
        localObject2 = MessageForArkApp.limitToSizeRange(ArkAppCenterUtil.getDensity(), ((ArkAppMessage.Config)localObject1).width.intValue(), ((ArkAppMessage.Config)localObject1).height.intValue());
        if (localObject2 != null)
        {
          this.arkapp_width_fromsdk = ((MessageForArkApp.Size)localObject2).width;
          if ((((ArkAppMessage.Config)localObject1).autoSize != null) && (((ArkAppMessage.Config)localObject1).autoSize.intValue() == 1)) {
            this.arkapp_width_fromsdk = ArkAppCenterUtil.sChatBubbleMaxWidth;
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
      if (this.bodyLayout != null)
      {
        localObject1 = (RelativeLayout.LayoutParams)this.bodyLayout.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).topMargin = ((int)paramContext.getResources().getDimension(2131296902));
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = ((int)paramContext.getResources().getDimension(2131296873));
        ((RelativeLayout.LayoutParams)localObject1).rightMargin = ((int)paramContext.getResources().getDimension(2131296874));
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = ((int)paramContext.getResources().getDimension(2131296898));
      }
      if (!bool1)
      {
        localObject2 = findViewById(2131363805);
        if (localObject2 != null) {
          ((View)localObject2).setVisibility(8);
        }
        this.mArkView.setOnTouchListener(this.mArkView);
        localObject2 = findViewById(2131365606);
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
        localObject2 = new LinearLayout.LayoutParams(-1, -2);
        i = MessageForArkApp.dp2px(1.0F);
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
        this.maxHight = MessageForArkApp.dp2px(390.0F);
        this.minWidth = MessageForArkApp.dp2px(30.0F);
        this.minHight = MessageForArkApp.dp2px(30.0F);
        i = paramContext.getResources().getDimensionPixelSize(2131296897);
        j = ((RelativeLayout.LayoutParams)localObject1).leftMargin;
        j = ((RelativeLayout.LayoutParams)localObject1).rightMargin + j;
        QLog.i("QQCustomArkDialog", 1, "init bundle mWidth=" + this.mWidth + ", dialogWidth=" + i + ",bodyMargin=" + j);
        this.mWidth = (i - j);
        localObject1 = (RelativeLayout.LayoutParams)this.mArkLoadLayout.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).addRule(14);
        ((RelativeLayout.LayoutParams)localObject1).width = this.mWidth;
        ((RelativeLayout.LayoutParams)localObject1).height = this.mWidth;
        ((RelativeLayout.LayoutParams)localObject1).setMargins(0, 0, 0, 0);
        ThreadManager.getUIHandler().post(new QQCustomArkDialog.3(this, paramBundle));
        this.mArkView.setInputHolderAnchor((ViewGroup)this.mArkView.getRootView());
        if (!(paramContext instanceof Activity)) {
          break label1096;
        }
        paramContext = (Activity)paramContext;
        if (paramContext != null)
        {
          apzv.a(paramContext, this.mArkView);
          this.mActivityRef = new WeakReference(paramContext);
        }
        ThreadManager.getUIHandler().postDelayed(new QQCustomArkDialog.4(this), 200L);
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
            j = localException.rightMargin;
            if (QLog.isColorLevel())
            {
              QLog.d("QQCustomArkDialog", 2, "margin=" + (i + j));
              continue;
              label1096:
              paramContext = null;
            }
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
  
  public void show()
  {
    this.outsideShowDialog = true;
    if (QLog.isColorLevel()) {
      QLog.d("QQCustomArkDialog", 2, new Object[] { "dialog show,arkViewLoadFinish = ", Boolean.valueOf(this.arkViewLoadFinish), ";alreadyShowDialog:", Boolean.valueOf(this.alreadyShowDialog) });
    }
    if (this.arkViewLoadFinish)
    {
      this.alreadyShowDialog = true;
      super.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomArkDialog
 * JD-Core Version:    0.7.0.1
 */