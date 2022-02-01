package com.tencent.mobileqq.webview.swift;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.haoliyou.orion.ZhuoXusManager;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.webview.WebViewTitleStyle;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.mobileqq.webview.ui.WebViewTopTabHelper;
import com.tencent.mobileqq.webview.ui.WebViewTopTabView;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.FadeIconImageView;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.Set;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@KeepClassConstructor
public class SwiftIphoneTitleBarUI
{
  int jdField_a_of_type_Int = -1;
  Intent jdField_a_of_type_AndroidContentIntent;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public View a;
  public ViewGroup a;
  Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  public ImageView a;
  public RelativeLayout a;
  public TextView a;
  TouchWebView.OnScrollChangedListener jdField_a_of_type_ComTencentBizUiTouchWebView$OnScrollChangedListener = new SwiftIphoneTitleBarUI.2(this);
  public APICallback a;
  ValueAnimation.AnimationUpdateListener<Integer> jdField_a_of_type_ComTencentMobileqqUtilsValueAnimation$AnimationUpdateListener = new SwiftIphoneTitleBarUI.1(this);
  public JsBridgeListener a;
  public SwiftBrowserUIStyle a;
  public SwiftBrowserUIStyleHandler a;
  public WebViewTopTabHelper a;
  public WebViewTopTabView a;
  public FadeIconImageView a;
  public String a;
  public boolean a;
  int jdField_b_of_type_Int = 0;
  @Nullable
  private Intent jdField_b_of_type_AndroidContentIntent;
  public View b;
  public ViewGroup b;
  Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  public ImageView b;
  public TextView b;
  String jdField_b_of_type_JavaLangString = null;
  boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int = 240;
  private View jdField_c_of_type_AndroidViewView;
  public ImageView c;
  public TextView c;
  String jdField_c_of_type_JavaLangString = null;
  boolean jdField_c_of_type_Boolean;
  int jdField_d_of_type_Int = 0;
  public TextView d;
  String jdField_d_of_type_JavaLangString = null;
  boolean jdField_d_of_type_Boolean = false;
  int jdField_e_of_type_Int = 255;
  public TextView e;
  boolean jdField_e_of_type_Boolean = false;
  private int jdField_f_of_type_Int;
  boolean jdField_f_of_type_Boolean = true;
  public boolean g = false;
  private boolean h = false;
  
  public SwiftIphoneTitleBarUI(SwiftBrowserUIStyleHandler paramSwiftBrowserUIStyleHandler)
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback = null;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabHelper = null;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler = paramSwiftBrowserUIStyleHandler;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle = paramSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle;
    this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabHelper = new WebViewTopTabHelper(paramSwiftBrowserUIStyleHandler);
  }
  
  private void k()
  {
    if (this.jdField_b_of_type_AndroidContentIntent != null)
    {
      if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
        return;
      }
      boolean bool1 = ZhuoXusManager.a().c();
      boolean bool2 = this.jdField_b_of_type_AndroidContentIntent.getBooleanExtra("fromAio", false);
      if ((bool1) && (bool2)) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView != null)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.getChildCount())
      {
        if (((RadioButton)this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.getChildAt(i)).isChecked()) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public View a()
  {
    return this.jdField_c_of_type_AndroidViewView;
  }
  
  public String a()
  {
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localTextView == null) {
      return "";
    }
    return localTextView.getText().toString();
  }
  
  @TargetApi(11)
  public JSONObject a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        Uri localUri = Uri.parse(paramString);
        paramString = localUri.getQueryParameterNames();
        if (paramString != null)
        {
          if (paramString.size() == 0) {
            return null;
          }
          Iterator localIterator = paramString.iterator();
          for (;;)
          {
            paramString = localJSONObject;
            if (!localIterator.hasNext()) {
              break;
            }
            paramString = (String)localIterator.next();
            if (paramString.contains("_nav_"))
            {
              String str = localUri.getQueryParameter(paramString);
              localJSONObject.put(paramString.replace("_nav_", ""), str);
            }
          }
        }
        return null;
      }
      catch (Exception paramString)
      {
        QLog.e("WebLog_SwiftIphoneTitleBarUI", 1, "getTitlebarConfig error!", paramString);
        paramString = null;
      }
      return paramString;
    }
    return null;
  }
  
  public void a() {}
  
  @TargetApi(11)
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setEnabled(false);
      if (Build.VERSION.SDK_INT >= 11) {
        this.jdField_c_of_type_AndroidWidgetTextView.setAlpha(0.5F);
      }
    }
    else
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setEnabled(true);
      if (Build.VERSION.SDK_INT >= 11) {
        this.jdField_c_of_type_AndroidWidgetTextView.setAlpha(1.0F);
      }
    }
  }
  
  public void a(int paramInt1, Drawable paramDrawable, int paramInt2)
  {
    Drawable[] arrayOfDrawable = this.jdField_b_of_type_AndroidWidgetTextView.getCompoundDrawables();
    Object localObject2 = arrayOfDrawable[0];
    Drawable localDrawable3 = arrayOfDrawable[1];
    Drawable localDrawable1 = arrayOfDrawable[2];
    Drawable localDrawable2 = arrayOfDrawable[3];
    Object localObject1;
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2)
        {
          if (paramInt1 != 3)
          {
            paramDrawable = (Drawable)localObject2;
            localObject2 = localDrawable3;
            localObject1 = localDrawable1;
          }
          else
          {
            if (paramDrawable != null) {
              paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
            }
            localDrawable2 = paramDrawable;
            paramDrawable = (Drawable)localObject2;
            localObject2 = localDrawable3;
            localObject1 = localDrawable1;
          }
        }
        else
        {
          if (paramDrawable != null)
          {
            paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
            if (localObject2 == null)
            {
              localObject1 = new ColorDrawable(0);
              ((Drawable)localObject1).setBounds(paramDrawable.getBounds());
            }
            else
            {
              localObject1 = localObject2;
              if ((localObject2 instanceof ColorDrawable))
              {
                ((Drawable)localObject2).setBounds(paramDrawable.getBounds());
                localObject1 = localObject2;
              }
            }
          }
          else
          {
            localObject1 = localObject2;
            if ((localObject2 instanceof ColorDrawable))
            {
              localObject1 = paramDrawable;
              paramDrawable = null;
              localObject2 = localDrawable3;
              break label349;
            }
          }
          localDrawable1 = paramDrawable;
          paramDrawable = (Drawable)localObject1;
          localObject2 = localDrawable3;
          localObject1 = localDrawable1;
        }
      }
      else
      {
        if (paramDrawable != null) {
          paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
        }
        localObject1 = paramDrawable;
        paramDrawable = (Drawable)localObject2;
        localObject2 = localObject1;
        localObject1 = localDrawable1;
      }
    }
    else
    {
      if (paramDrawable != null)
      {
        paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
        if (localDrawable1 == null)
        {
          localObject1 = new ColorDrawable(0);
          ((Drawable)localObject1).setBounds(paramDrawable.getBounds());
        }
        else
        {
          localObject1 = localDrawable1;
          if ((localDrawable1 instanceof ColorDrawable))
          {
            localDrawable1.setBounds(paramDrawable.getBounds());
            localObject1 = localDrawable1;
          }
        }
      }
      else
      {
        localObject1 = localDrawable1;
        if ((localDrawable1 instanceof ColorDrawable))
        {
          localObject1 = null;
          localObject2 = localDrawable3;
          break label349;
        }
      }
      localObject2 = localDrawable3;
    }
    label349:
    if ((paramDrawable != arrayOfDrawable[0]) || (localObject2 != arrayOfDrawable[1]) || (localObject1 != arrayOfDrawable[2]) || (localDrawable2 != arrayOfDrawable[3]))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(paramDrawable, (Drawable)localObject2, (Drawable)localObject1, localDrawable2);
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(paramInt2);
      this.jdField_b_of_type_AndroidWidgetTextView.setGravity(17);
    }
  }
  
  void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_e_of_type_Boolean)
    {
      ViewGroup localViewGroup = null;
      Object localObject;
      if ((paramInt >= this.jdField_c_of_type_Int) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.v))
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.v = false;
        if (paramBoolean)
        {
          localObject = this.jdField_a_of_type_AndroidViewAnimationAnimation;
        }
        else
        {
          b(this.jdField_e_of_type_Int);
          localObject = localViewGroup;
        }
      }
      else
      {
        localObject = localViewGroup;
        if (paramInt < this.jdField_c_of_type_Int)
        {
          localObject = localViewGroup;
          if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.v)
          {
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.v = true;
            if (paramBoolean)
            {
              localObject = this.jdField_b_of_type_AndroidViewAnimationAnimation;
            }
            else
            {
              b(this.jdField_d_of_type_Int);
              localObject = localViewGroup;
            }
          }
        }
      }
      localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
      if ((localViewGroup != null) && (localObject != null) && (localObject != localViewGroup.getAnimation()))
      {
        ((Animation)localObject).reset();
        this.jdField_a_of_type_AndroidViewViewGroup.startAnimation((Animation)localObject);
      }
    }
  }
  
  public void a(Intent paramIntent)
  {
    boolean bool1;
    boolean bool2;
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (paramIntent != null) && (paramIntent.getExtras() != null))
    {
      try
      {
        String str2 = paramIntent.getExtras().getString("leftViewText");
        int i = paramIntent.getExtras().getInt("individuation_url_type");
        str1 = str2;
        if (i >= 40300)
        {
          str1 = str2;
          if (i <= 40313)
          {
            str1 = str2;
            if (!TextUtils.isEmpty(str2))
            {
              str1 = str2;
              if (str2.contains(BaseApplication.getContext().getString(2131714495))) {
                str1 = BaseApplication.getContext().getString(2131690706);
              }
            }
          }
        }
        bool1 = paramIntent.getBooleanExtra("hide_left_button", false);
        bool2 = paramIntent.getBooleanExtra("fromOneCLickCLose", false);
        paramIntent = str1;
        if (str1 == null) {
          paramIntent = BaseApplication.getContext().getString(2131690706);
        }
        if (!SwiftWebViewUtils.a()) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(paramIntent);
        } else if (this.jdField_a_of_type_AndroidWidgetTextView.getBackground() == null) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(paramIntent);
        }
      }
      catch (Exception paramIntent)
      {
        String str1;
        QLog.e("WebLog_SwiftIphoneTitleBarUI", 1, "setLeftViewName exception e = ", paramIntent);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      if (AppSetting.jdField_d_of_type_Boolean)
      {
        str1 = this.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
        paramIntent = str1;
        if (!str1.contains(BaseApplication.getContext().getString(2131690706)))
        {
          paramIntent = new StringBuilder();
          paramIntent.append(BaseApplication.getContext().getString(2131690706));
          paramIntent.append(str1);
          paramIntent = paramIntent.toString();
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramIntent);
      }
      if (this.jdField_a_of_type_ComTencentWidgetFadeIconImageView != null)
      {
        if (bool2)
        {
          this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setVisibility(0);
          return;
        }
        this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setVisibility(8);
        return;
      }
      return;
      if (!bool1) {
        if (!bool2) {
          break;
        }
      }
    }
  }
  
  public final void a(Intent paramIntent, View.OnClickListener paramOnClickListener)
  {
    LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.d.getContext()).inflate(2131558726, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.d);
    this.jdField_b_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.d.findViewById(2131376636));
    a(this.jdField_a_of_type_AndroidViewViewGroup);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376777);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_c_of_type_AndroidViewView.setPadding(0, -ViewUtils.b(12.0F), 0, 0);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369202));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
    a(this.jdField_a_of_type_AndroidWidgetTextView);
    if (AppSetting.jdField_d_of_type_Boolean) {
      AccessibilityUtil.b(this.jdField_a_of_type_AndroidWidgetTextView, Button.class.getName());
    }
    if (paramIntent.getBooleanExtra("hide_title_left_arrow", false)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
    }
    this.jdField_a_of_type_ComTencentWidgetFadeIconImageView = ((FadeIconImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369205));
    this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setOnClickListener(paramOnClickListener);
    this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setContentDescription(BaseApplication.getContext().getResources().getString(2131689834));
    a(paramIntent);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369249));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376757));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369233));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369216));
    a(this.jdField_c_of_type_AndroidWidgetTextView);
    a(this.jdField_a_of_type_AndroidWidgetImageView);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.d.findViewById(2131378962);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378961));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378963));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131378960);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new SwiftIphoneTitleBarUI.3(this));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378837));
    f();
    b(this.jdField_d_of_type_JavaLangString);
    b();
  }
  
  public void a(Intent paramIntent, String paramString)
  {
    int j;
    int i;
    if ((paramIntent != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_Boolean) {
        return;
      }
      long l = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_Long;
      j = 0;
      if ((l & 0x4) == 0L) {
        if (!SwiftWebViewUtils.a()) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(BaseApplication.getContext().getResources().getString(2131690706));
        } else if (paramIntent.getBooleanExtra("hide_title_left_arrow", false)) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(BaseApplication.getContext().getResources().getString(2131690706));
        }
      }
      if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("youxi.vip.qq.com/imoj"))) {
        paramIntent.putExtra("isScreenOrientationPortrait", true);
      }
      Object localObject = paramIntent.getStringExtra("title");
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.j = paramIntent.getBooleanExtra("ishiderefresh", false);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.k = paramIntent.getBooleanExtra("ishidebackforward", false);
      boolean bool = paramIntent.getBooleanExtra("hide_left_button", false);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.l = paramIntent.getBooleanExtra("show_right_close_button", false);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("QQBrowser url=");
        localStringBuilder.append(Util.b(paramString, new String[0]));
        QLog.d("QQBrowser", 2, localStringBuilder.toString());
      }
      if ((localObject != null) && (((String)localObject).length() > 0)) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      } else {
        this.jdField_b_of_type_AndroidWidgetTextView.setText("");
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(BaseApplication.getContext().getResources().getString(2131690698));
      if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_e_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        localObject = this.jdField_a_of_type_AndroidWidgetImageView.getResources().getDrawable(2130840351);
        if ((!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.m))
        {
          paramString = (String)localObject;
          if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle != null) {
            paramString = BaseImageUtil.a((Drawable)localObject, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle.jdField_e_of_type_Int);
          }
        }
        else
        {
          paramString = BaseImageUtil.a((Drawable)localObject, -1);
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(BaseApplication.getContext().getResources().getString(2131692635));
        k();
      }
      if (b()) {
        if ((!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.m))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle != null) {
            c(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle.jdField_e_of_type_Int);
          }
        }
        else {
          c(-1);
        }
      }
      if (bool) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      }
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        i = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidAppActivity) + 0;
      } else {
        i = 0;
      }
      int k = View.MeasureSpec.makeMeasureSpec(0, 0);
      int m = View.MeasureSpec.makeMeasureSpec(0, 0);
      this.jdField_a_of_type_AndroidViewViewGroup.measure(k, m);
      i += this.jdField_a_of_type_AndroidViewViewGroup.getMeasuredHeight();
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.p)
      {
        k = this.jdField_a_of_type_AndroidViewViewGroup.getTop();
        m = this.jdField_a_of_type_AndroidViewViewGroup.getBottom();
        paramString = this.jdField_a_of_type_AndroidViewViewGroup;
        paramString.layout(paramString.getLeft(), k - i, this.jdField_a_of_type_AndroidViewViewGroup.getRight(), m - i);
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      }
      else
      {
        k = this.jdField_a_of_type_AndroidViewViewGroup.getTop();
        m = this.jdField_a_of_type_AndroidViewViewGroup.getBottom();
        paramString = this.jdField_a_of_type_AndroidViewViewGroup;
        paramString.layout(paramString.getLeft(), k + i, this.jdField_a_of_type_AndroidViewViewGroup.getRight(), m + i);
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.l) {
        a(paramIntent.getStringExtra("left_close_button_text"));
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_JavaLangString)) {}
    }
    for (;;)
    {
      try
      {
        paramIntent = new JSONObject(URLDecoder.decode(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_JavaLangString));
        if (!paramIntent.has("tabNum")) {
          break label861;
        }
        i = paramIntent.getInt("tabNum");
        if (!paramIntent.has("subTextArray")) {
          break label866;
        }
        paramIntent = paramIntent.getJSONArray("subTextArray");
        if ((paramIntent == null) || (paramIntent.length() <= 0)) {
          break label876;
        }
        paramString = new String[paramIntent.length()];
        if (j >= paramIntent.length()) {
          break label871;
        }
        paramString[j] = paramIntent.getString(j);
        j += 1;
        continue;
        a(new SwiftIphoneTitleBarUI.SubTabParam(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_Int, i, null, null, paramIntent));
      }
      catch (JSONException paramIntent)
      {
        paramIntent.printStackTrace();
      }
      a();
      return;
      label861:
      i = 2;
      continue;
      label866:
      paramIntent = null;
      continue;
      label871:
      paramIntent = paramString;
      continue;
      label876:
      paramIntent = null;
    }
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (Build.VERSION.SDK_INT > 10) {
      paramView.setLayerType(0, null);
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 0)
    {
      paramView.getBackground().mutate().setAlpha(paramInt2);
      return;
    }
    ValueAnimation localValueAnimation = new ValueAnimation(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), new SwiftIphoneTitleBarUI.4(this, paramView, paramInt2));
    localValueAnimation.setDuration(paramInt3);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.x = true;
    paramView.startAnimation(localValueAnimation);
  }
  
  public void a(TouchWebView paramTouchWebView)
  {
    ViewGroup localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.s) && (localViewGroup != null) && (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.w) && (a()))
    {
      SwiftBrowserUIStyle localSwiftBrowserUIStyle = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle;
      localSwiftBrowserUIStyle.w = true;
      localSwiftBrowserUIStyle.t = true;
      localSwiftBrowserUIStyle.v = true;
      localViewGroup.setBackgroundResource(2130851231);
      if (ThemeUtil.isNowThemeIsNight(MobileQQ.sMobileQQ.waitAppRuntime(null), false, null)) {
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      }
      paramTouchWebView.setOnScrollChangedListenerForBiz(new SwiftIphoneTitleBarUI.5(this));
    }
  }
  
  public void a(TouchWebView paramTouchWebView, boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean2, String paramString1, String paramString2, String paramString3)
  {
    if (paramTouchWebView == null) {
      return;
    }
    if (!this.jdField_d_of_type_Boolean)
    {
      paramTouchWebView.setOnScrollChangedListenerForBiz(this.jdField_a_of_type_ComTencentBizUiTouchWebView$OnScrollChangedListener);
      this.jdField_d_of_type_Boolean = true;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setTitleBarScrollChange:");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(", @");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", from ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(" to ");
      ((StringBuilder)localObject).append(paramInt3);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramBoolean2);
      ((StringBuilder)localObject).append(", Before: ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", After: ");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("WebLog_SwiftIphoneTitleBarUI", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_e_of_type_Boolean = paramBoolean1;
    Object localObject = BaseApplication.getContext();
    this.jdField_c_of_type_Int = ((int)(paramInt1 * ((Context)localObject).getResources().getDisplayMetrics().density + 0.5F));
    this.jdField_d_of_type_Int = paramInt2;
    this.jdField_e_of_type_Int = paramInt3;
    this.jdField_a_of_type_AndroidViewAnimationAnimation = new ValueAnimation(Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), this.jdField_a_of_type_ComTencentMobileqqUtilsValueAnimation$AnimationUpdateListener);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(300L);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setInterpolator((Context)localObject, 17432581);
    this.jdField_b_of_type_AndroidViewAnimationAnimation = new ValueAnimation(Integer.valueOf(paramInt3), Integer.valueOf(paramInt2), this.jdField_a_of_type_ComTencentMobileqqUtilsValueAnimation$AnimationUpdateListener);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setDuration(300L);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setInterpolator((Context)localObject, 17432581);
    this.jdField_f_of_type_Boolean = paramBoolean2;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Int = -1;
    a(this.jdField_b_of_type_Int, false);
    if (TextUtils.isEmpty(paramString3)) {
      return;
    }
    paramString1 = new JSONObject();
    try
    {
      paramString1.put("result", 0);
      paramString1.put("message", "ok");
      label378:
      paramTouchWebView.callJs(paramString3, new String[] { paramString1.toString() });
      return;
    }
    catch (Exception paramString2)
    {
      break label378;
    }
  }
  
  public void a(SwiftIphoneTitleBarUI.SubTabParam paramSubTabParam)
  {
    if (paramSubTabParam != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView = new WebViewTopTabView(BaseApplication.getContext());
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setButtonNum(paramSubTabParam.jdField_b_of_type_Int, paramSubTabParam.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setButtonText(paramSubTabParam.jdField_a_of_type_ArrayOfJavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setButtonBackgroundResource(2130851213, 2130851214, 2130851215);
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setButtonTextColorStateList(2131167381);
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setLeftAndRightPaddingByDp(10);
      a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.v);
      int i = -1;
      try
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView, new RelativeLayout.LayoutParams(-2, -1));
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setOnCheckedChangeListener(new SwiftIphoneTitleBarUI.7(this));
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabHelper;
      if (localObject != null) {
        ((WebViewTopTabHelper)localObject).a(paramSubTabParam.jdField_b_of_type_JavaLangString, true);
      }
      TouchWebView localTouchWebView = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a();
      if ((localTouchWebView != null) && (!TextUtils.isEmpty(paramSubTabParam.jdField_a_of_type_JavaLangString)))
      {
        if (TextUtils.isEmpty(paramSubTabParam.jdField_b_of_type_JavaLangString))
        {
          localObject = "the subTabCallback isEmpty";
        }
        else
        {
          localObject = "ok";
          i = 0;
        }
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("code", i);
          localJSONObject.put("message", localObject);
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
        }
        localTouchWebView.callJs(paramSubTabParam.jdField_a_of_type_JavaLangString, new String[] { localJSONObject.toString() });
      }
    }
  }
  
  public void a(SwiftIphoneTitleBarUI.SubTabRedHotParam paramSubTabRedHotParam)
  {
    if (paramSubTabRedHotParam != null)
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView;
      if (localObject1 != null)
      {
        Object localObject2 = paramSubTabRedHotParam.jdField_a_of_type_ArrayOfInt;
        boolean bool;
        if (paramSubTabRedHotParam.jdField_a_of_type_Int == 1) {
          bool = true;
        } else {
          bool = false;
        }
        ((WebViewTopTabView)localObject1).setRedHotStatus((int[])localObject2, bool);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a();
        if (localObject2 == null) {
          return;
        }
        JSONObject localJSONObject = new JSONObject();
        Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.a();
        int i;
        String str;
        if ((localObject3 != null) && (localObject3.length != 0))
        {
          try
          {
            localObject1 = new JSONArray();
            i = 0;
            while (i < localObject3.length)
            {
              ((JSONArray)localObject1).put(localObject3[i]);
              i += 1;
            }
            localJSONObject.put("tabsStatus", localObject1);
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("tabsStatusArray = ");
              ((StringBuilder)localObject3).append(((JSONArray)localObject1).toString());
              QLog.i("WebLog_SwiftIphoneTitleBarUI", 2, ((StringBuilder)localObject3).toString());
            }
            localObject1 = "OK";
            i = 0;
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
            i = -3;
            str = "construction json error";
          }
        }
        else
        {
          i = -2;
          str = "sub tab num is error";
        }
        localObject3 = new JSONObject();
        try
        {
          ((JSONObject)localObject3).put("code", i);
          ((JSONObject)localObject3).put("message", str);
          ((JSONObject)localObject3).put("data", localJSONObject);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        if (!TextUtils.isEmpty(paramSubTabRedHotParam.jdField_a_of_type_JavaLangString)) {
          ((TouchWebView)localObject2).callJs(paramSubTabRedHotParam.jdField_a_of_type_JavaLangString, new String[] { ((JSONObject)localObject3).toString() });
        }
      }
    }
  }
  
  public void a(WebView paramWebView, String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_Boolean) {
        return;
      }
      Object localObject = (RelativeLayout)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131378837);
      if (localObject != null)
      {
        paramWebView = (TextView)((RelativeLayout)localObject).findViewById(2131378880);
        localObject = (TextView)((RelativeLayout)localObject).findViewById(2131378814);
        if (paramBoolean)
        {
          new Handler(Looper.getMainLooper()).postDelayed(new SwiftIphoneTitleBarUI.6(this, (TextView)localObject, paramWebView, paramString), 50L);
          return;
        }
        if (!TextUtils.isEmpty(((TextView)localObject).getText().toString()))
        {
          paramWebView.setText(paramString);
          return;
        }
        c(paramString);
      }
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_c_of_type_AndroidWidgetTextView != null)
    {
      if (!TextUtils.isEmpty(paramString)) {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString);
      } else {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131689834);
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.bringToFront();
    }
    paramString = this.jdField_a_of_type_AndroidWidgetImageView;
    if (paramString != null)
    {
      paramString.setImageResource(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundColor(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 != null) && (paramString1.length() != 0))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (!SwiftWebViewUtils.a()) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString1);
      } else if (this.jdField_a_of_type_AndroidWidgetTextView.getBackground() == null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString1);
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    if ((paramString2 != null) && (paramString2.length() != 0))
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString2);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    else
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (TextUtils.isEmpty(paramString3)) {
      paramString3 = "";
    }
    c(paramString3);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, JsBridgeListener paramJsBridgeListener, View.OnClickListener paramOnClickListener, APICallback paramAPICallback)
  {
    int i;
    if ((paramJsBridgeListener != null) && (paramJsBridgeListener.jdField_a_of_type_Boolean)) {
      i = 1;
    } else {
      i = 0;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_e_of_type_Boolean = true;
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramString1 = this.jdField_b_of_type_AndroidWidgetImageView;
      if (paramString1 != null) {
        paramString1.setVisibility(8);
      }
      e(false);
      return;
    }
    Object localObject = this.jdField_b_of_type_AndroidContentIntent;
    if ((localObject != null) && (((Intent)localObject).getIntExtra("reqType", -1) == 7))
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    if (b()) {
      e(true);
    } else {
      e(false);
    }
    if (paramInt1 == 0)
    {
      if (!TextUtils.isEmpty(paramString2))
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString2);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.bringToFront();
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundColor(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if ((paramString3 != null) && (paramString3.length() <= 0)) {}
    }
    try
    {
      paramInt1 = Color.parseColor(paramString3);
    }
    catch (Exception paramString2)
    {
      label218:
      break label218;
    }
    paramInt1 = 0;
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundColor(paramInt1);
    if ((paramString1 != null) && (i == 0))
    {
      this.jdField_a_of_type_JavaLangString = paramString1.trim();
    }
    else if (paramAPICallback != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback = paramAPICallback;
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener = paramJsBridgeListener;
      this.jdField_a_of_type_JavaLangString = null;
      break label1473;
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.F)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        k();
      }
      paramString3 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle;
      if (paramInt1 != 4) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramString3.jdField_e_of_type_Boolean = paramBoolean;
      if (paramInt1 != 1001)
      {
        if (paramInt1 != 1002)
        {
          switch (paramInt1)
          {
          default: 
            switch (paramInt1)
            {
            default: 
              this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
              break;
            case 18: 
              this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a(this.jdField_a_of_type_AndroidWidgetImageView, false, 2130839646, 2130839648);
              this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(BaseApplication.getContext().getResources().getString(2131689589));
              paramString3 = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376756);
              if (paramString3 == null) {
                break;
              }
              localObject = (RelativeLayout.LayoutParams)paramString3.getLayoutParams();
              ((RelativeLayout.LayoutParams)localObject).rightMargin = ViewUtils.b(10.0F);
              paramString3.setLayoutParams((ViewGroup.LayoutParams)localObject);
              break;
            case 17: 
              this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a(this.jdField_a_of_type_AndroidWidgetImageView, false, 2130851155, 2130851155);
              paramString3 = this.jdField_a_of_type_AndroidWidgetImageView;
              paramString3.setImageDrawable(BaseImageUtil.a(paramString3.getResources().getDrawable(2130851155), this.jdField_a_of_type_AndroidWidgetImageView.getResources().getColor(2131167053)));
              this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(BaseApplication.getContext().getResources().getString(2131692632));
              break;
            case 16: 
              this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a(this.jdField_a_of_type_AndroidWidgetImageView, false, 2130846599, 2130846598);
              this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(BaseApplication.getContext().getResources().getString(2131692634));
            }
            break;
          case 9: 
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a(this.jdField_a_of_type_AndroidWidgetImageView, false, 2130838831, 2130838831);
            this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(BaseApplication.getContext().getResources().getString(2131692634));
            break;
          case 8: 
          case 11: 
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a(this.jdField_a_of_type_AndroidWidgetImageView, false, 2130850469, 2130850473);
            this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(BaseApplication.getContext().getResources().getString(2131689589));
            break;
          case 7: 
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a(this.jdField_a_of_type_AndroidWidgetImageView, false, 2130842612, 2130842615);
            this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(BaseApplication.getContext().getResources().getString(2131689589));
            break;
          case 6: 
          case 10: 
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a(this.jdField_a_of_type_AndroidWidgetImageView, false, 2130850663, 2130850663);
            this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(BaseApplication.getContext().getResources().getString(2131692634));
            break;
          case 5: 
            this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844052);
            this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(BaseApplication.getContext().getResources().getString(2131692636));
            ((AnimationDrawable)this.jdField_a_of_type_AndroidWidgetImageView.getDrawable()).start();
            break;
          case 4: 
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a(this.jdField_a_of_type_AndroidWidgetImageView, false, 2130839368, 2130839368);
            this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(BaseApplication.getContext().getResources().getString(2131692635));
            break;
          case 3: 
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a(this.jdField_a_of_type_AndroidWidgetImageView, false, 2130840351, 2130840351);
            this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(BaseApplication.getContext().getResources().getString(2131692633));
            break;
          case 2: 
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a(this.jdField_a_of_type_AndroidWidgetImageView, false, 2130844007, 2130844007);
            this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(BaseApplication.getContext().getResources().getString(2131692630));
            break;
          case 1: 
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a(this.jdField_a_of_type_AndroidWidgetImageView, false, 2130844009, 2130844008);
            paramString3 = this.jdField_a_of_type_AndroidWidgetImageView;
            paramString3.setImageDrawable(BaseImageUtil.a(paramString3.getResources().getDrawable(2130844009), this.jdField_a_of_type_AndroidWidgetImageView.getResources().getColor(2131167053)));
            this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(BaseApplication.getContext().getResources().getString(2131692631));
            break;
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a(this.jdField_a_of_type_AndroidWidgetImageView, false, 2130840351, 2130840351);
          this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(BaseApplication.getContext().getResources().getString(2131718832));
        }
      }
      else
      {
        paramString3 = URLDrawable.getDrawable(QzoneConfig.getInstance().getConfig("QZoneSetting", "sweetIconRUL", "https://qzonestyle.gtimg.cn/aoi/sola/20170905110724_aew14oIQKq.png"), null);
        if (paramString3 != null)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(paramString3);
          paramString3 = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376756);
          if (paramString3 != null)
          {
            localObject = (RelativeLayout.LayoutParams)paramString3.getLayoutParams();
            ((RelativeLayout.LayoutParams)localObject).rightMargin = ViewUtils.b(10.0F);
            paramString3.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
        }
      }
      if ((paramInt2 == 0) && (this.jdField_a_of_type_Boolean)) {
        paramInt2 = 10000;
      }
      if (paramInt2 != 0)
      {
        if (this.jdField_b_of_type_AndroidWidgetImageView == null)
        {
          this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(BaseApplication.getContext());
          paramString3 = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376756);
          paramString3 = new RelativeLayout.LayoutParams(-2, -2);
          paramString3.addRule(7, 2131369216);
          paramString3.addRule(6, 2131369216);
          paramString3.setMargins(0, 0, 0, 0);
          this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams(paramString3);
          if ((this.jdField_a_of_type_AndroidWidgetImageView.getParent() instanceof RelativeLayout)) {
            ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetImageView.getParent()).addView(this.jdField_b_of_type_AndroidWidgetImageView);
          }
        }
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        if (paramInt2 != 6)
        {
          if ((paramInt2 != 13) && (paramInt2 != 10000)) {
            this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          } else {
            this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130850766);
          }
        }
        else {
          this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130843844);
        }
      }
      else
      {
        paramString3 = this.jdField_b_of_type_AndroidWidgetImageView;
        if (paramString3 != null) {
          paramString3.setVisibility(8);
        }
      }
      if (!TextUtils.isEmpty(paramString2)) {
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(paramString2);
      }
      if (paramOnClickListener != null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
      }
      else if ((paramString1 != null) && (i == 0))
      {
        this.jdField_a_of_type_JavaLangString = paramString1.trim();
      }
      else if (paramAPICallback != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback = paramAPICallback;
      }
      else
      {
        this.jdField_a_of_type_JavaLangString = null;
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener = paramJsBridgeListener;
      }
      this.jdField_b_of_type_Boolean = false;
      this.jdField_c_of_type_Boolean = false;
    }
    label1473:
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_OrgJsonJSONObject.has("txtclr"))
    {
      paramString2 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_OrgJsonJSONObject.optString("txtclr", "");
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString1 = paramString2;
        if (!paramString2.startsWith("#"))
        {
          paramString1 = new StringBuilder();
          paramString1.append("#");
          paramString1.append(paramString2);
          paramString1 = paramString1.toString();
        }
        try
        {
          paramInt1 = Color.parseColor(paramString1);
          paramString1 = BaseImageUtil.a(this.jdField_a_of_type_AndroidWidgetImageView.getDrawable(), paramInt1);
          if (paramString1 != null)
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString1);
            c(paramInt1);
          }
        }
        catch (Exception paramString1)
        {
          QLog.e("WebLog_SwiftIphoneTitleBarUI", 1, paramString1, new Object[0]);
        }
      }
    }
    a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.v);
  }
  
  public void a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    if (paramJSONObject != null) {}
    try
    {
      if ((paramJSONObject.length() > 0) && (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.w))
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.w = a();
        if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.C) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_c_of_type_AndroidViewView != null)) {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_c_of_type_AndroidViewView.setPadding(0, (int)DisplayUtils.a(BaseApplication.getContext(), 30.0F), 0, 0);
        }
      }
      if (paramJSONObject == null) {
        break label863;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.w) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("titlebar config:");
        ((StringBuilder)localObject1).append(paramJSONObject.toString());
        QLog.d("WebLog_SwiftIphoneTitleBarUI", 2, ((StringBuilder)localObject1).toString());
      }
      localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
      if (localViewGroup == null) {
        return;
      }
      if (!paramBoolean) {
        break label734;
      }
      localObject3 = paramJSONObject.optString("bgclr", "");
      paramBoolean = TextUtils.isEmpty((CharSequence)localObject3);
      if (paramBoolean) {
        break label869;
      }
      localObject1 = localObject3;
      if (!((String)localObject3).startsWith("#"))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("#");
        ((StringBuilder)localObject1).append((String)localObject3);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      i = Color.parseColor((String)localObject1);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1;
        ViewGroup localViewGroup;
        Object localObject3;
        String str;
        label734:
        int j;
        label863:
        continue;
        int i = -1;
        Object localObject2 = localObject3;
        continue;
        i = 0;
        continue;
        i = -1;
        continue;
        i = -1;
      }
    }
    localViewGroup.setBackgroundColor(i);
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getWebTitleBarInterface().a() != null))
    {
      str = paramJSONObject.optString("statusclr", "");
      if (!TextUtils.isEmpty(str))
      {
        localObject3 = str;
        if (!str.startsWith("#"))
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("#");
          ((StringBuilder)localObject3).append((String)localObject1);
          localObject3 = ((StringBuilder)localObject3).toString();
        }
        i = Color.parseColor((String)localObject3);
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getWebTitleBarInterface().a().setBackgroundColor(i);
        SimpleUIUtil.a(true, i, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidAppActivity.getWindow());
      }
    }
    else
    {
      localObject3 = paramJSONObject.optString("txtclr", "");
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        break label883;
      }
      localObject1 = localObject3;
      if (!((String)localObject3).startsWith("#"))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("#");
        ((StringBuilder)localObject1).append((String)localObject3);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      i = Color.parseColor((String)localObject1);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i);
      if ((this.jdField_a_of_type_ComTencentWidgetFadeIconImageView != null) && (this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.getVisibility() == 0))
      {
        localObject1 = BaseImageUtil.a(this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.getDrawable(), i);
        if (localObject1 != null) {
          this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setImageDrawable((Drawable)localObject1);
        }
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(i);
      localObject1 = BaseImageUtil.a(this.jdField_a_of_type_AndroidWidgetTextView.getBackground(), i);
      if (localObject1 != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable((Drawable)localObject1);
      }
      localObject1 = BaseImageUtil.a(this.jdField_a_of_type_AndroidWidgetImageView.getDrawable(), i);
      if (localObject1 != null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
        c(i);
      }
      localObject1 = this.jdField_c_of_type_AndroidViewView.findViewById(2131371243);
      localObject3 = BaseImageUtil.a(((View)localObject1).getBackground(), i);
      if (localObject3 != null) {
        ((View)localObject1).setBackgroundDrawable((Drawable)localObject3);
      }
      localObject3 = paramJSONObject.optString("titleclr", "");
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        break label888;
      }
      localObject1 = localObject3;
      if (!((String)localObject3).startsWith("#"))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("#");
        ((StringBuilder)localObject1).append((String)localObject3);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      i = Color.parseColor((String)localObject1);
      if ((TextUtils.isEmpty(this.jdField_b_of_type_AndroidWidgetTextView.getText())) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_JavaLangString))) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_JavaLangString);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(i);
      if (paramJSONObject.optInt("trans", -1) != 0)
      {
        paramBoolean = paramJSONObject.optBoolean("anim", false);
        i = paramJSONObject.optInt("dur", 0);
        j = paramJSONObject.optInt("alpha", 0);
        if ((paramBoolean) && (i > 0))
        {
          a(localViewGroup, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_d_of_type_Int, j, i);
          return;
        }
        localViewGroup.getBackground().mutate().setAlpha(j);
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_d_of_type_Int = j;
        return;
        if (QLog.isColorLevel())
        {
          paramJSONObject = new StringBuilder();
          paramJSONObject.append("game center,doTransparent error:");
          paramJSONObject.append(((Exception)localObject1).toString());
          QLog.d("WebLog_SwiftIphoneTitleBarUI", 2, paramJSONObject.toString());
        }
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.v = paramBoolean;
    String str;
    if (paramBoolean)
    {
      str = this.jdField_b_of_type_JavaLangString;
      if (str != null)
      {
        c(str);
        return;
      }
    }
    if (!paramBoolean)
    {
      str = this.jdField_c_of_type_JavaLangString;
      if (str != null) {
        c(str);
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null)
    {
      if (paramBoolean)
      {
        paramInt1 = QQToast.a(paramInt1);
        this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidViewView.getResources().getDrawable(paramInt1));
        this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidViewView.getResources().getString(paramInt2));
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        return;
      }
      localView.setVisibility(8);
    }
  }
  
  @TargetApi(17)
  public boolean a()
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.m) && (this.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.d != null) && (Build.VERSION.SDK_INT >= 17))
    {
      Object localObject1 = (TextView)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.d.findViewById(2131363811);
      if (localObject1 != null)
      {
        localObject2 = (LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
        if (localObject2 != null)
        {
          ((LinearLayout.LayoutParams)localObject2).topMargin -= ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext());
          ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.d.findViewById(2131381085);
      Object localObject2 = (FrameLayout.LayoutParams)((View)localObject1).getLayoutParams();
      if (localObject2 != null)
      {
        ((FrameLayout.LayoutParams)localObject2).topMargin -= BaseApplication.getContext().getResources().getDimensionPixelSize(2131299175);
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      return true;
    }
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    WebViewTopTabView localWebViewTopTabView = this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView;
    int i = 0;
    if (localWebViewTopTabView == null) {
      return false;
    }
    if (!paramBoolean) {
      i = 8;
    }
    localWebViewTopTabView.setVisibility(i);
    return true;
  }
  
  public void b() {}
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {
      return;
    }
    if (paramInt == this.jdField_a_of_type_Int) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    paramInt = Math.max(0, Math.min(paramInt, 255));
    this.jdField_a_of_type_AndroidViewViewGroup.getBackground().mutate().setAlpha(paramInt);
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getWebTitleBarInterface().a() != null)) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getWebTitleBarInterface().a().getBackground().mutate().setAlpha(paramInt);
    }
    if (paramInt == this.jdField_d_of_type_Int)
    {
      a(true);
      return;
    }
    if (paramInt == this.jdField_e_of_type_Int) {
      a(false);
    }
  }
  
  public void b(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
    paramString = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a();
    if ((paramString != null) && (!this.jdField_d_of_type_Boolean))
    {
      paramString.setOnScrollChangedListenerForBiz(this.jdField_a_of_type_ComTencentBizUiTouchWebView$OnScrollChangedListener);
      this.jdField_d_of_type_Boolean = true;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_e_of_type_Boolean = true;
      localObject = this.jdField_c_of_type_AndroidWidgetTextView;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
      localObject = this.jdField_a_of_type_AndroidWidgetImageView;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(8);
      }
      localObject = this.jdField_b_of_type_AndroidWidgetImageView;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(8);
      }
    }
    else
    {
      localObject = this.jdField_c_of_type_AndroidWidgetTextView;
      if ((localObject != null) && (!TextUtils.isEmpty(((TextView)localObject).getText()))) {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      localObject = this.jdField_a_of_type_AndroidWidgetImageView;
      if (localObject != null)
      {
        ((ImageView)localObject).setVisibility(0);
        k();
      }
      localObject = this.jdField_b_of_type_AndroidWidgetImageView;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(0);
      }
    }
  }
  
  public boolean b()
  {
    TouchWebView localTouchWebView = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localTouchWebView != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a().getPluginEngine() == null) {
        return false;
      }
      if (this.g) {
        return false;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.G)
      {
        bool1 = bool2;
        if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.H) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {
      return false;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Int = -1;
      a(this.jdField_b_of_type_Int, this.jdField_f_of_type_Boolean);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidAppActivity.getWindow().clearFlags(1024);
      }
    }
    else
    {
      b(0);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidAppActivity.getWindow().addFlags(1024);
    }
    return true;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.E)
    {
      if ((!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.m))
      {
        Resources localResources = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidAppActivity.getResources();
        this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(localResources.getColor(2131167296));
        if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getWebTitleBarInterface().a() != null)) {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getWebTitleBarInterface().a().setBackgroundColor(0);
        }
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a(this.jdField_a_of_type_AndroidWidgetTextView, true, 2130850447, 2130851066);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a(this.jdField_a_of_type_AndroidWidgetImageView, false, 2130840351, 2130840347);
    }
  }
  
  public void c(int paramInt)
  {
    if (b())
    {
      View localView = this.jdField_c_of_type_AndroidViewView.findViewById(2131371243);
      localView.setBackgroundDrawable(BaseImageUtil.a(localView.getBackground(), paramInt));
    }
  }
  
  public void c(String paramString)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void c(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public boolean c()
  {
    return a().getVisibility() == 0;
  }
  
  public void d()
  {
    Object localObject = this.jdField_c_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject != null)
    {
      ((ImageView)localObject).setVisibility(0);
      k();
    }
  }
  
  public void d(int paramInt)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramInt);
  }
  
  public void d(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Boolean) && (!paramBoolean))
    {
      ImageView localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
      if (localImageView != null) {
        localImageView.setVisibility(8);
      }
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void e()
  {
    TouchWebView localTouchWebView = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a();
    if (localTouchWebView != null) {
      localTouchWebView.setOnScrollChangedListenerForBiz(null);
    }
  }
  
  public void e(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
  }
  
  public void e(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider != null)
    {
      ISwiftMiniAIO localISwiftMiniAIO = (ISwiftMiniAIO)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getComponentProvider().a(256);
      if ((paramBoolean) && (b()))
      {
        localISwiftMiniAIO.a(100);
        localISwiftMiniAIO.b();
        localISwiftMiniAIO.a(true);
        return;
      }
      localISwiftMiniAIO.a(false);
    }
  }
  
  @TargetApi(11)
  public void f()
  {
    if (Build.VERSION.SDK_INT == 16) {
      this.jdField_a_of_type_AndroidViewViewGroup.setLayerType(0, null);
    }
  }
  
  public void f(int paramInt)
  {
    int i = this.jdField_a_of_type_AndroidWidgetTextView.getCurrentTextColor();
    if ((i != paramInt) && (!this.h))
    {
      c(true);
      e(i);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramInt);
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(paramInt);
    Object localObject = this.jdField_a_of_type_ComTencentWidgetFadeIconImageView;
    if ((localObject != null) && (((FadeIconImageView)localObject).getVisibility() == 0))
    {
      localObject = BaseImageUtil.a(this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.getDrawable(), paramInt);
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setImageDrawable((Drawable)localObject);
      }
    }
    Drawable localDrawable = this.jdField_a_of_type_AndroidWidgetTextView.getBackground();
    localObject = this.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
    if (localDrawable != null)
    {
      if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = localDrawable;
        this.jdField_b_of_type_Boolean = true;
      }
      localDrawable = BaseImageUtil.a(localDrawable, paramInt);
      if (localDrawable != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(localDrawable);
      }
    }
    if (localObject != null)
    {
      if (!this.jdField_c_of_type_Boolean) {
        this.jdField_c_of_type_Boolean = true;
      }
      localObject = BaseImageUtil.a((Drawable)localObject, paramInt);
      if (localObject != null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        c(paramInt);
      }
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(paramInt);
  }
  
  public void g()
  {
    if (this.h)
    {
      f(this.jdField_f_of_type_Int);
      this.h = false;
    }
  }
  
  public void g(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_Int = paramInt;
    WebViewTopTabView localWebViewTopTabView = this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView;
    if (localWebViewTopTabView != null) {
      localWebViewTopTabView.setSelectedTab(paramInt);
    }
  }
  
  public void h()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(BaseApplication.getContext().getResources().getColorStateList(2131167050));
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(BaseApplication.getContext().getResources().getColorStateList(2131167050));
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(BaseApplication.getContext().getResources().getColor(2131167053));
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject != null)
    {
      localObject = ((ImageView)localObject).getDrawable();
      if (localObject != null)
      {
        ((Drawable)localObject).clearColorFilter();
        ((Drawable)localObject).invalidateSelf();
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    }
    if (c())
    {
      localObject = this.jdField_c_of_type_AndroidViewView.findViewById(2131371243);
      Drawable localDrawable = ((View)localObject).getBackground();
      if (localDrawable != null)
      {
        localDrawable.clearColorFilter();
        localDrawable.invalidateSelf();
      }
      ((View)localObject).setBackgroundDrawable(localDrawable);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {
      return;
    }
    SwiftBrowserUIStyle localSwiftBrowserUIStyle;
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.v) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.u))
    {
      localSwiftBrowserUIStyle = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle;
      localSwiftBrowserUIStyle.u = false;
      localSwiftBrowserUIStyle.u = true;
      this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130851231);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
      return;
    }
    if ((!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.v) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.u))
    {
      localSwiftBrowserUIStyle = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle;
      localSwiftBrowserUIStyle.u = false;
      localSwiftBrowserUIStyle.u = true;
      this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(BaseApplication.getContext().getResources().getColor(2131167114));
      h();
    }
  }
  
  public void j()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewAnimationAnimation;
    if (localObject != null) {
      ((Animation)localObject).setAnimationListener(null);
    }
    localObject = this.jdField_b_of_type_AndroidViewAnimationAnimation;
    if (localObject != null) {
      ((Animation)localObject).setAnimationListener(null);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView;
    if (localObject != null) {
      ((WebViewTopTabView)localObject).setOnCheckedChangeListener(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI
 * JD-Core Version:    0.7.0.1
 */