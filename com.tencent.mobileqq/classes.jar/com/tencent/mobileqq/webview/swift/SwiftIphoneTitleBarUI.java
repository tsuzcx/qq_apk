package com.tencent.mobileqq.webview.swift;

import akmu;
import akmv;
import akmw;
import akmx;
import akmy;
import akmz;
import akna;
import aknb;
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
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.webview.WebViewTitleStyle;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle;
import com.tencent.mobileqq.webview.ui.WebViewTopTabHelper;
import com.tencent.mobileqq.webview.ui.WebViewTopTabView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SwiftIphoneTitleBarUI
{
  int jdField_a_of_type_Int = -1;
  public Intent a;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  public ViewGroup a;
  Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  public ImageView a;
  public RelativeLayout a;
  public TextView a;
  TouchWebView.OnScrollChangedListener jdField_a_of_type_ComTencentBizUiTouchWebView$OnScrollChangedListener = new akmv(this);
  ValueAnimation.AnimationUpdateListener jdField_a_of_type_ComTencentMobileqqUtilsValueAnimation$AnimationUpdateListener = new akmu(this);
  public JsBridgeListener a;
  public SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle a;
  public SwiftBrowserUIStyleHandler a;
  public WebViewTopTabHelper a;
  public WebViewTopTabView a;
  public String a;
  public boolean a;
  public int b;
  public ViewGroup b;
  Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  public ImageView b;
  public TextView b;
  String jdField_b_of_type_JavaLangString = null;
  boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int = 240;
  public ImageView c;
  public TextView c;
  String jdField_c_of_type_JavaLangString = null;
  boolean jdField_c_of_type_Boolean;
  int jdField_d_of_type_Int = 0;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  public TextView d;
  public String d;
  boolean jdField_d_of_type_Boolean = false;
  int jdField_e_of_type_Int = 255;
  boolean jdField_e_of_type_Boolean = false;
  public boolean f = true;
  
  public SwiftIphoneTitleBarUI(SwiftBrowserUIStyleHandler paramSwiftBrowserUIStyleHandler)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler = paramSwiftBrowserUIStyleHandler;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle = paramSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
    this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabHelper = new WebViewTopTabHelper(paramSwiftBrowserUIStyleHandler);
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
  
  @TargetApi(11)
  public JSONObject a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    JSONObject localJSONObject;
    for (;;)
    {
      return null;
      if (Build.VERSION.SDK_INT >= 11)
      {
        localJSONObject = new JSONObject();
        try
        {
          paramString = Uri.parse(paramString);
          Object localObject = paramString.getQueryParameterNames();
          if ((localObject != null) && (((Set)localObject).size() != 0))
          {
            localObject = ((Set)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              String str1 = (String)((Iterator)localObject).next();
              if (str1.contains("_nav_"))
              {
                String str2 = paramString.getQueryParameter(str1);
                localJSONObject.put(str1.replace("_nav_", ""), str2);
                continue;
                return paramString;
              }
            }
          }
        }
        catch (Exception paramString)
        {
          QLog.e("WebLog_SwiftIphoneTitleBarUI", 1, "getTitlebarConfig error!", paramString);
          paramString = null;
        }
      }
    }
    for (;;)
    {
      paramString = localJSONObject;
    }
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
    do
    {
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setEnabled(true);
    } while (Build.VERSION.SDK_INT < 11);
    this.jdField_c_of_type_AndroidWidgetTextView.setAlpha(1.0F);
  }
  
  public void a(int paramInt1, Drawable paramDrawable, int paramInt2)
  {
    Object localObject4 = null;
    Drawable[] arrayOfDrawable = this.jdField_b_of_type_AndroidWidgetTextView.getCompoundDrawables();
    Object localObject3 = arrayOfDrawable[0];
    Drawable localDrawable = arrayOfDrawable[1];
    Object localObject2 = arrayOfDrawable[2];
    Object localObject1 = arrayOfDrawable[3];
    switch (paramInt1)
    {
    default: 
      paramDrawable = (Drawable)localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
    for (;;)
    {
      if ((localObject2 != arrayOfDrawable[0]) || (localDrawable != arrayOfDrawable[1]) || (localObject1 != arrayOfDrawable[2]) || (paramDrawable != arrayOfDrawable[3]))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject2, localDrawable, (Drawable)localObject1, paramDrawable);
        this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(paramInt2);
        this.jdField_b_of_type_AndroidWidgetTextView.setGravity(17);
      }
      return;
      if (paramDrawable != null)
      {
        paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
        if (localObject2 == null)
        {
          localObject2 = new ColorDrawable(0);
          ((Drawable)localObject2).setBounds(paramDrawable.getBounds());
          localObject3 = localObject1;
          localObject1 = localObject2;
          localObject2 = paramDrawable;
          paramDrawable = (Drawable)localObject3;
          continue;
        }
        if ((localObject2 instanceof ColorDrawable))
        {
          ((Drawable)localObject2).setBounds(paramDrawable.getBounds());
          localObject3 = localObject1;
          localObject1 = localObject2;
          localObject2 = paramDrawable;
          paramDrawable = (Drawable)localObject3;
        }
      }
      else if ((localObject2 instanceof ColorDrawable))
      {
        localObject3 = localObject1;
        localObject1 = null;
        localObject2 = paramDrawable;
        paramDrawable = (Drawable)localObject3;
        continue;
        if (paramDrawable != null)
        {
          paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
          localDrawable = paramDrawable;
          paramDrawable = (Drawable)localObject1;
          localObject1 = localObject2;
          localObject2 = localObject3;
          continue;
          if (paramDrawable != null)
          {
            paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
            if (localObject3 == null)
            {
              localObject2 = new ColorDrawable(0);
              ((Drawable)localObject2).setBounds(paramDrawable.getBounds());
              localObject3 = localObject1;
              localObject1 = paramDrawable;
              paramDrawable = (Drawable)localObject3;
              continue;
            }
            if ((localObject3 instanceof ColorDrawable))
            {
              ((Drawable)localObject3).setBounds(paramDrawable.getBounds());
              localObject2 = localObject3;
              localObject3 = paramDrawable;
              paramDrawable = (Drawable)localObject1;
              localObject1 = localObject3;
            }
          }
          else if ((localObject3 instanceof ColorDrawable))
          {
            localObject3 = localObject1;
            localObject1 = paramDrawable;
            localObject2 = localObject4;
            paramDrawable = (Drawable)localObject3;
            continue;
            if (paramDrawable != null) {
              paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
            }
            localObject1 = localObject2;
            localObject2 = localObject3;
            continue;
          }
          localObject2 = localObject3;
          localObject3 = paramDrawable;
          paramDrawable = (Drawable)localObject1;
          localObject1 = localObject3;
          continue;
        }
        localDrawable = paramDrawable;
        paramDrawable = (Drawable)localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
      }
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = paramDrawable;
      paramDrawable = (Drawable)localObject3;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    Object localObject2;
    Object localObject1;
    if (this.jdField_e_of_type_Boolean)
    {
      localObject2 = null;
      if ((paramInt < this.jdField_c_of_type_Int) || (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.q)) {
        break label94;
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.q = false;
      if (!paramBoolean) {
        break label80;
      }
      localObject1 = this.jdField_a_of_type_AndroidViewAnimationAnimation;
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (localObject1 != null) && (localObject1 != this.jdField_a_of_type_AndroidViewViewGroup.getAnimation()))
      {
        ((Animation)localObject1).reset();
        this.jdField_a_of_type_AndroidViewViewGroup.startAnimation((Animation)localObject1);
      }
      return;
      label80:
      b(this.jdField_e_of_type_Int);
      localObject1 = localObject2;
      continue;
      label94:
      localObject1 = localObject2;
      if (paramInt < this.jdField_c_of_type_Int)
      {
        localObject1 = localObject2;
        if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.q)
        {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.q = true;
          if (paramBoolean)
          {
            localObject1 = this.jdField_b_of_type_AndroidViewAnimationAnimation;
          }
          else
          {
            b(this.jdField_d_of_type_Int);
            localObject1 = localObject2;
          }
        }
      }
    }
  }
  
  public void a(Intent paramIntent)
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (paramIntent != null) && (paramIntent.getExtras() != null)) {
      try
      {
        String str2 = paramIntent.getExtras().getString("leftViewText");
        int i = paramIntent.getExtras().getInt("individuation_url_type");
        String str1 = str2;
        if (i >= 40300)
        {
          str1 = str2;
          if (i <= 40313)
          {
            str1 = str2;
            if (!TextUtils.isEmpty(str2))
            {
              str1 = str2;
              if (str2.contains("消息")) {
                str1 = BaseApplicationImpl.getApplication().getString(2131433698);
              }
            }
          }
        }
        boolean bool = paramIntent.getBooleanExtra("hide_left_button", false);
        paramIntent = str1;
        if (str1 == null) {
          paramIntent = BaseApplicationImpl.getApplication().getString(2131433698);
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramIntent);
        if (bool) {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        }
        while (AppSetting.jdField_b_of_type_Boolean)
        {
          str1 = this.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
          paramIntent = str1;
          if (!str1.contains(BaseApplicationImpl.getApplication().getString(2131433698))) {
            paramIntent = BaseApplicationImpl.getApplication().getString(2131433698) + str1;
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramIntent);
          return;
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        }
        return;
      }
      catch (Exception paramIntent)
      {
        QLog.e("WebLog_SwiftIphoneTitleBarUI", 1, "setLeftViewName exception e = ", paramIntent);
      }
    }
  }
  
  public final void a(Intent paramIntent, View.OnClickListener paramOnClickListener)
  {
    LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_b_of_type_AndroidViewViewGroup.getContext()).inflate(2130968732, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_b_of_type_AndroidViewViewGroup);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131363244));
    a(this.jdField_a_of_type_AndroidViewViewGroup);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363245));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
    a(this.jdField_a_of_type_AndroidWidgetTextView);
    if (AppSetting.jdField_b_of_type_Boolean) {
      AccessibilityUtil.b(this.jdField_a_of_type_AndroidWidgetTextView, Button.class.getName());
    }
    if (paramIntent.getBooleanExtra("hide_title_left_arrow", false)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
    }
    a(paramIntent);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363381));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363468));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363428));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363474));
    a(this.jdField_c_of_type_AndroidWidgetTextView);
    a(this.jdField_a_of_type_AndroidWidgetImageView);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363476));
    this.jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130846345);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(new akmw(this));
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363380));
    d();
    b(this.jdField_d_of_type_JavaLangString);
  }
  
  public void a(Intent paramIntent, String paramString)
  {
    int j = 2;
    String[] arrayOfString = null;
    if ((paramIntent == null) || (TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_Boolean)) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_Long & 0x4) == 0L) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(BaseApplicationImpl.getApplication().getResources().getString(2131433698));
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("youxi.vip.qq.com/imoj"))) {
      paramIntent.putExtra("isScreenOrientationPortrait", true);
    }
    String str = paramIntent.getStringExtra("title");
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.h = paramIntent.getBooleanExtra("ishiderefresh", false);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.i = paramIntent.getBooleanExtra("ishidebackforward", false);
    boolean bool = paramIntent.getBooleanExtra("hide_left_button", false);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.j = paramIntent.getBooleanExtra("show_right_close_button", false);
    if (QLog.isColorLevel()) {
      QLog.d("QQBrowser", 2, "QQBrowser url=" + Util.b(paramString, new String[0]));
    }
    label305:
    int i;
    if ((str != null) && (str.length() > 0))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(str);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(BaseApplicationImpl.getApplication().getResources().getString(2131435682));
      if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_d_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramString = this.jdField_a_of_type_AndroidWidgetImageView.getResources().getDrawable(2130839151);
        if ((!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.k) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle != null)) {
          break label575;
        }
        paramString = ImageUtil.a(paramString, -1);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(BaseApplicationImpl.getApplication().getResources().getString(2131434737));
      }
      if (b())
      {
        if ((!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.k) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle != null)) {
          break label593;
        }
        i = -1;
      }
    }
    for (;;)
    {
      for (;;)
      {
        label374:
        c(i);
        this.jdField_d_of_type_AndroidWidgetImageView.setContentDescription(BaseApplicationImpl.getApplication().getResources().getString(2131434746));
        if (bool) {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.j) {
          a(paramIntent.getStringExtra("left_close_button_text"));
        }
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_JavaLangString)) {}
        try
        {
          paramIntent = new JSONObject(URLDecoder.decode(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_JavaLangString));
          i = j;
          if (paramIntent.has("tabNum")) {
            i = paramIntent.getInt("tabNum");
          }
          if (paramIntent.has("subTextArray")) {}
          for (paramIntent = paramIntent.getJSONArray("subTextArray");; paramIntent = null)
          {
            paramString = arrayOfString;
            if (paramIntent == null) {
              break label622;
            }
            paramString = arrayOfString;
            if (paramIntent.length() <= 0) {
              break label622;
            }
            arrayOfString = new String[paramIntent.length()];
            j = 0;
            for (;;)
            {
              paramString = arrayOfString;
              if (j >= paramIntent.length()) {
                break;
              }
              arrayOfString[j] = paramIntent.getString(j);
              j += 1;
            }
            this.jdField_b_of_type_AndroidWidgetTextView.setText("");
            break;
            label575:
            paramString = ImageUtil.a(paramString, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle.jdField_d_of_type_Int);
            break label305;
            label593:
            if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle == null) {
              break label657;
            }
            i = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle.jdField_d_of_type_Int;
            break label374;
          }
          label622:
          a(new SwiftIphoneTitleBarUI.SubTabParam(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_Int, i, null, null, paramString));
        }
        catch (JSONException paramIntent)
        {
          for (;;)
          {
            paramIntent.printStackTrace();
          }
          label657:
          i = -1;
        }
      }
      a();
      return;
    }
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    paramOnClickListener = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a().a().a(45, true);
    if ((paramOnClickListener instanceof UiApiPlugin)) {
      ((UiApiPlugin)paramOnClickListener).d();
    }
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {}
    while (Build.VERSION.SDK_INT <= 10) {
      return;
    }
    paramView.setLayerType(0, null);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 0)
    {
      paramView.getBackground().mutate().setAlpha(paramInt2);
      return;
    }
    ValueAnimation localValueAnimation = new ValueAnimation(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), new akmx(this, paramView, paramInt2));
    localValueAnimation.setDuration(paramInt3);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.s = true;
    paramView.startAnimation(localValueAnimation);
  }
  
  public void a(TouchWebView paramTouchWebView)
  {
    ViewGroup localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.n) && (localViewGroup != null) && (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.r) && (a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.r = true;
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.o = true;
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.q = true;
      localViewGroup.setBackgroundResource(2130846385);
      if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      }
      paramTouchWebView.setOnScrollChangedListener(new akmy(this));
    }
  }
  
  public void a(TouchWebView paramTouchWebView, boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean2, String paramString1, String paramString2, String paramString3)
  {
    if (paramTouchWebView == null) {}
    do
    {
      return;
      if (!this.jdField_d_of_type_Boolean)
      {
        paramTouchWebView.setOnScrollChangedListener(this.jdField_a_of_type_ComTencentBizUiTouchWebView$OnScrollChangedListener);
        this.jdField_d_of_type_Boolean = true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_SwiftIphoneTitleBarUI", 2, "setTitleBarScrollChange:" + paramBoolean1 + ", @" + paramInt1 + ", from " + paramInt2 + " to " + paramInt3 + ", " + paramBoolean2 + ", Before: " + paramString1 + ", After: " + paramString2);
      }
      this.jdField_e_of_type_Boolean = paramBoolean1;
      BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
      this.jdField_c_of_type_Int = ((int)(paramInt1 * localBaseApplicationImpl.getResources().getDisplayMetrics().density + 0.5F));
      this.jdField_d_of_type_Int = paramInt2;
      this.jdField_e_of_type_Int = paramInt3;
      this.jdField_a_of_type_AndroidViewAnimationAnimation = new ValueAnimation(Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), this.jdField_a_of_type_ComTencentMobileqqUtilsValueAnimation$AnimationUpdateListener);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(300L);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setInterpolator(localBaseApplicationImpl, 17432581);
      this.jdField_b_of_type_AndroidViewAnimationAnimation = new ValueAnimation(Integer.valueOf(paramInt3), Integer.valueOf(paramInt2), this.jdField_a_of_type_ComTencentMobileqqUtilsValueAnimation$AnimationUpdateListener);
      this.jdField_b_of_type_AndroidViewAnimationAnimation.setDuration(300L);
      this.jdField_b_of_type_AndroidViewAnimationAnimation.setInterpolator(localBaseApplicationImpl, 17432581);
      this.f = paramBoolean2;
      this.jdField_b_of_type_JavaLangString = paramString1;
      this.jdField_c_of_type_JavaLangString = paramString2;
      this.jdField_a_of_type_Int = -1;
      a(this.jdField_b_of_type_Int, false);
    } while (TextUtils.isEmpty(paramString3));
    paramString1 = new JSONObject();
    try
    {
      paramString1.put("result", 0);
      paramString1.put("message", "ok");
      label331:
      paramTouchWebView.a(paramString3, new String[] { paramString1.toString() });
      return;
    }
    catch (Exception paramString2)
    {
      break label331;
    }
  }
  
  public void a(SwiftIphoneTitleBarUI.SubTabParam paramSubTabParam)
  {
    int i = -1;
    if (paramSubTabParam != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView = new WebViewTopTabView(BaseApplicationImpl.getContext());
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setButtonNum(paramSubTabParam.jdField_b_of_type_Int, paramSubTabParam.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setButtonText(paramSubTabParam.jdField_a_of_type_ArrayOfJavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setButtonBackgroundResource(2130846352, 2130846356, 2130846360);
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setButtonTextColorStateList(2131494321);
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setLeftAndRightPaddingByDp(10);
      a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.q);
    }
    try
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView, new RelativeLayout.LayoutParams(-2, -1));
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setOnCheckedChangeListener(new aknb(this));
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabHelper != null) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabHelper.a(paramSubTabParam.jdField_b_of_type_JavaLangString, true);
      }
      localTouchWebView = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a();
      if ((localTouchWebView != null) && (!TextUtils.isEmpty(paramSubTabParam.jdField_a_of_type_JavaLangString)))
      {
        str = "ok";
        if (!TextUtils.isEmpty(paramSubTabParam.jdField_b_of_type_JavaLangString)) {
          break label263;
        }
        str = "the subTabCallback isEmpty";
        localJSONObject = new JSONObject();
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          TouchWebView localTouchWebView;
          String str;
          JSONObject localJSONObject;
          localJSONObject.put("code", i);
          localJSONObject.put("message", str);
          localTouchWebView.a(paramSubTabParam.jdField_a_of_type_JavaLangString, new String[] { localJSONObject.toString() });
          return;
          localException1 = localException1;
          localException1.printStackTrace();
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          continue;
        }
        label263:
        i = 0;
      }
    }
  }
  
  public void a(SwiftIphoneTitleBarUI.SubTabRedHotParam paramSubTabRedHotParam)
  {
    Object localObject1;
    Object localObject2;
    boolean bool;
    if ((paramSubTabRedHotParam != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView != null))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView;
      localObject2 = paramSubTabRedHotParam.jdField_a_of_type_ArrayOfInt;
      if (paramSubTabRedHotParam.jdField_a_of_type_Int != 1) {
        break label56;
      }
      bool = true;
      ((WebViewTopTabView)localObject1).setRedHotStatus((int[])localObject2, bool);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a();
      if (localObject2 != null) {
        break label61;
      }
    }
    for (;;)
    {
      return;
      label56:
      bool = false;
      break;
      label61:
      localObject1 = "OK";
      JSONObject localJSONObject = new JSONObject();
      Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.a();
      int i;
      if ((localObject3 == null) || (localObject3.length == 0))
      {
        i = -2;
        localObject1 = "sub tab num is error";
        localObject3 = new JSONObject();
      }
      try
      {
        for (;;)
        {
          ((JSONObject)localObject3).put("code", i);
          ((JSONObject)localObject3).put("message", localObject1);
          ((JSONObject)localObject3).put("data", localJSONObject);
          if (TextUtils.isEmpty(paramSubTabRedHotParam.jdField_a_of_type_JavaLangString)) {
            break;
          }
          ((TouchWebView)localObject2).a(paramSubTabRedHotParam.jdField_a_of_type_JavaLangString, new String[] { ((JSONObject)localObject3).toString() });
          return;
          try
          {
            JSONArray localJSONArray = new JSONArray();
            i = 0;
            while (i < localObject3.length)
            {
              localJSONArray.put(localObject3[i]);
              i += 1;
            }
            localJSONObject.put("tabsStatus", localJSONArray);
            if (QLog.isColorLevel()) {
              QLog.i("WebLog_SwiftIphoneTitleBarUI", 2, "tabsStatusArray = " + localJSONArray.toString());
            }
            i = 0;
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
            i = -3;
            String str = "construction json error";
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public void a(WebView paramWebView, String paramString, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.k)) {}
    do
    {
      return;
      localObject = (RelativeLayout)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131363380);
    } while (localObject == null);
    paramWebView = (TextView)((RelativeLayout)localObject).findViewById(2131363470);
    Object localObject = (TextView)((RelativeLayout)localObject).findViewById(2131363471);
    if (paramBoolean)
    {
      new Handler(Looper.getMainLooper()).postDelayed(new akna(this, (TextView)localObject, paramWebView, paramString), 50L);
      return;
    }
    if (!TextUtils.isEmpty(((TextView)localObject).getText().toString()))
    {
      paramWebView.setText(paramString);
      return;
    }
    c(paramString);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_c_of_type_AndroidWidgetTextView != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        break label70;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.bringToFront();
      if (this.jdField_a_of_type_AndroidWidgetImageView != null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundColor(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      return;
      label70:
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131434937);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      if ((paramString2 != null) && (paramString2.length() != 0)) {
        break label71;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      label39:
      if (TextUtils.isEmpty(paramString3)) {
        break label99;
      }
    }
    for (;;)
    {
      c(paramString3);
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString1);
      break;
      label71:
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString2);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label39;
      label99:
      paramString3 = "";
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, JsBridgeListener paramJsBridgeListener, View.OnClickListener paramOnClickListener)
  {
    if ((paramJsBridgeListener != null) && (paramJsBridgeListener.jdField_a_of_type_Boolean)) {}
    for (int i = 1; paramBoolean; i = 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_d_of_type_Boolean = true;
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      return;
    }
    Object localObject;
    if (b())
    {
      localObject = new akmz(this);
      this.jdField_a_of_type_AndroidViewView$OnClickListener = ((View.OnClickListener)localObject);
      a((View.OnClickListener)localObject);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      if (this.jdField_c_of_type_AndroidWidgetImageView == null)
      {
        this.jdField_c_of_type_AndroidWidgetImageView = new ImageView(BaseApplicationImpl.getApplication());
        localObject = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131363476);
        ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131363476);
        ((RelativeLayout.LayoutParams)localObject).setMargins(0, 0, 0, 0);
        this.jdField_c_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        if ((this.jdField_d_of_type_AndroidWidgetImageView.getParent() instanceof RelativeLayout))
        {
          ((RelativeLayout)this.jdField_d_of_type_AndroidWidgetImageView.getParent()).addView(this.jdField_c_of_type_AndroidWidgetImageView);
          this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130846051);
          this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
    }
    for (;;)
    {
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
        if (paramString3 != null)
        {
          paramInt1 = 0;
          if (paramString3.length() <= 0) {}
        }
        try
        {
          paramInt1 = Color.parseColor(paramString3);
          this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundColor(paramInt1);
          if ((paramString1 != null) && (i == 0))
          {
            this.jdField_a_of_type_JavaLangString = paramString1.trim();
            if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_OrgJsonJSONObject.has("txtclr"))
            {
              paramString2 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_OrgJsonJSONObject.optString("txtclr", "");
              if (!TextUtils.isEmpty(paramString2))
              {
                paramString1 = paramString2;
                if (!paramString2.startsWith("#")) {
                  paramString1 = "#" + paramString2;
                }
              }
            }
          }
          try
          {
            paramInt1 = Color.parseColor(paramString1);
            paramString1 = ImageUtil.a(this.jdField_a_of_type_AndroidWidgetImageView.getDrawable(), paramInt1);
            if (paramString1 != null)
            {
              this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString1);
              c(paramInt1);
            }
          }
          catch (Exception paramString1)
          {
            for (;;)
            {
              QLog.e("WebLog_SwiftIphoneTitleBarUI", 1, paramString1, new Object[0]);
            }
          }
          a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.q);
          return;
          if (this.jdField_d_of_type_AndroidWidgetImageView != null) {
            this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
          }
          if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
            this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          }
        }
        catch (Exception paramString2)
        {
          for (;;)
          {
            paramInt1 = 0;
            continue;
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener = paramJsBridgeListener;
            this.jdField_a_of_type_JavaLangString = null;
          }
        }
      }
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    paramString3 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
    if (paramInt1 != 4)
    {
      paramBoolean = true;
      label567:
      paramString3.jdField_d_of_type_Boolean = paramBoolean;
      switch (paramInt1)
      {
      default: 
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        label689:
        paramInt1 = paramInt2;
        if (paramInt2 == 0)
        {
          paramInt1 = paramInt2;
          if (this.jdField_a_of_type_Boolean) {
            paramInt1 = 10000;
          }
        }
        if (paramInt1 != 0)
        {
          if (this.jdField_b_of_type_AndroidWidgetImageView == null)
          {
            this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(BaseApplicationImpl.getApplication());
            paramString3 = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131362695);
            paramString3 = new RelativeLayout.LayoutParams(-2, -2);
            paramString3.addRule(7, 2131363474);
            paramString3.addRule(6, 2131363474);
            paramString3.setMargins(0, 0, 0, 0);
            this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams(paramString3);
            if ((this.jdField_a_of_type_AndroidWidgetImageView.getParent() instanceof RelativeLayout)) {
              ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetImageView.getParent()).addView(this.jdField_b_of_type_AndroidWidgetImageView);
            }
          }
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          switch (paramInt1)
          {
          default: 
            this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            label877:
            if (!TextUtils.isEmpty(paramString2)) {
              this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(paramString2);
            }
            if (paramOnClickListener != null) {
              this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
            }
            break;
          }
        }
        break;
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_c_of_type_Boolean = false;
      break;
      paramBoolean = false;
      break label567;
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a(this.jdField_a_of_type_AndroidWidgetImageView, false, 2130841458, 2130841457);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(BaseApplicationImpl.getApplication().getResources().getString(2131434742));
      break label689;
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a(this.jdField_a_of_type_AndroidWidgetImageView, false, 2130841456, 2130841456);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(BaseApplicationImpl.getApplication().getResources().getString(2131434739));
      break label689;
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a(this.jdField_a_of_type_AndroidWidgetImageView, false, 2130839151, 2130839151);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(BaseApplicationImpl.getApplication().getResources().getString(2131434735));
      break label689;
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a(this.jdField_a_of_type_AndroidWidgetImageView, false, 2130838570, 2130838570);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(BaseApplicationImpl.getApplication().getResources().getString(2131434737));
      break label689;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841491);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(BaseApplicationImpl.getApplication().getResources().getString(2131434740));
      ((AnimationDrawable)this.jdField_a_of_type_AndroidWidgetImageView.getDrawable()).start();
      break label689;
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a(this.jdField_a_of_type_AndroidWidgetImageView, false, 2130840567, 2130840570);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(BaseApplicationImpl.getApplication().getResources().getString(2131434741));
      break label689;
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a(this.jdField_a_of_type_AndroidWidgetImageView, false, 2130845896, 2130845900);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(BaseApplicationImpl.getApplication().getResources().getString(2131434741));
      break label689;
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a(this.jdField_a_of_type_AndroidWidgetImageView, false, 2130838289, 2130838289);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(BaseApplicationImpl.getApplication().getResources().getString(2131434738));
      break label689;
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a(this.jdField_a_of_type_AndroidWidgetImageView, false, 2130845963, 2130845963);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(BaseApplicationImpl.getApplication().getResources().getString(2131434738));
      break label689;
      paramString3 = URLDrawable.getDrawable(QzoneConfig.getInstance().getConfig("QZoneSetting", "sweetIconRUL", "http://qzonestyle.gtimg.cn/aoi/sola/20170905110724_aew14oIQKq.png"), null);
      if (paramString3 == null) {
        break label689;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(paramString3);
      paramString3 = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131362695);
      if (paramString3 == null) {
        break label689;
      }
      localObject = (RelativeLayout.LayoutParams)paramString3.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).rightMargin = ViewUtils.b(10.0F);
      paramString3.setLayoutParams((ViewGroup.LayoutParams)localObject);
      break label689;
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841285);
      break label877;
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846051);
      break label877;
      if (this.jdField_b_of_type_AndroidWidgetImageView == null) {
        break label877;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      break label877;
      if ((paramString1 != null) && (i == 0))
      {
        this.jdField_a_of_type_JavaLangString = paramString1.trim();
      }
      else
      {
        this.jdField_a_of_type_JavaLangString = null;
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener = paramJsBridgeListener;
      }
    }
  }
  
  public void a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    int j = -1;
    int k = 0;
    if (paramJSONObject != null) {}
    try
    {
      if ((paramJSONObject.length() > 0) && (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.r))
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.r = a();
        if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.x) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_b_of_type_AndroidViewView != null)) {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_b_of_type_AndroidViewView.setPadding(0, (int)DisplayUtils.a(BaseApplicationImpl.getApplication(), 30.0F), 0, 0);
        }
      }
      if (paramJSONObject == null) {
        return;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.r) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_SwiftIphoneTitleBarUI", 2, "titlebar config:" + paramJSONObject.toString());
      }
      localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
      if (localViewGroup == null) {
        return;
      }
      if (!paramBoolean) {
        break label562;
      }
      str = paramJSONObject.optString("bgclr", "");
      if (TextUtils.isEmpty(str)) {
        break label701;
      }
      localObject = str;
      if (!str.startsWith("#")) {
        localObject = "#" + str;
      }
      i = Color.parseColor((String)localObject);
    }
    catch (Exception paramJSONObject)
    {
      ViewGroup localViewGroup;
      String str;
      Object localObject;
      int i;
      label562:
      while (QLog.isColorLevel())
      {
        QLog.d("WebLog_SwiftIphoneTitleBarUI", 2, "game center,doTransparent error:" + paramJSONObject.toString());
        return;
        localViewGroup.getBackground().mutate().setAlpha(j);
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_d_of_type_Int = j;
        return;
        continue;
        i = -1;
        continue;
        localObject = str;
        continue;
        label701:
        localObject = str;
        i = -1;
      }
    }
    localViewGroup.setBackgroundColor(i);
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.d != null))
    {
      str = paramJSONObject.optString("statusclr", "");
      i = k;
      if (!TextUtils.isEmpty(str))
      {
        if (!str.startsWith("#"))
        {
          localObject = "#" + (String)localObject;
          i = Color.parseColor((String)localObject);
        }
      }
      else {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.d.setBackgroundColor(i);
      }
    }
    else
    {
      str = paramJSONObject.optString("txtclr", "");
      if (!TextUtils.isEmpty(str))
      {
        localObject = str;
        if (!str.startsWith("#")) {
          localObject = "#" + str;
        }
        i = Color.parseColor((String)localObject);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i);
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(i);
        localObject = ImageUtil.a(this.jdField_a_of_type_AndroidWidgetTextView.getBackground(), i);
        if (localObject != null) {
          this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable((Drawable)localObject);
        }
        localObject = ImageUtil.a(this.jdField_a_of_type_AndroidWidgetImageView.getDrawable(), i);
        if (localObject != null)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
          c(i);
        }
        localObject = paramJSONObject.optString("titleclr", "");
        i = j;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          if (!((String)localObject).startsWith("#"))
          {
            localObject = "#" + (String)localObject;
            i = Color.parseColor((String)localObject);
          }
        }
        else
        {
          if ((TextUtils.isEmpty(this.jdField_b_of_type_AndroidWidgetTextView.getText())) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_JavaLangString))) {
            this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_JavaLangString);
          }
          this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(i);
          if (paramJSONObject.optInt("trans", -1) == 0) {
            return;
          }
          paramBoolean = paramJSONObject.optBoolean("anim", false);
          i = paramJSONObject.optInt("dur", 0);
          j = paramJSONObject.optInt("alpha", 0);
          if ((paramBoolean) && (i > 0))
          {
            a(localViewGroup, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_d_of_type_Int, j, i);
            return;
          }
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.q = paramBoolean;
    if ((paramBoolean) && (this.jdField_b_of_type_JavaLangString != null)) {
      c(this.jdField_b_of_type_JavaLangString);
    }
    while ((paramBoolean) || (this.jdField_c_of_type_JavaLangString == null)) {
      return;
    }
    c(this.jdField_c_of_type_JavaLangString);
  }
  
  @TargetApi(17)
  public boolean a()
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.k) && (this.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_b_of_type_AndroidViewViewGroup != null) && (Build.VERSION.SDK_INT >= 17))
    {
      Object localObject1 = (TextView)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131366767);
      if (localObject1 != null)
      {
        localObject2 = (LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
        if (localObject2 != null)
        {
          ((LinearLayout.LayoutParams)localObject2).topMargin -= ImmersiveUtils.a(BaseApplicationImpl.getApplication());
          ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131366769);
      Object localObject2 = (FrameLayout.LayoutParams)((View)localObject1).getLayoutParams();
      if (localObject2 != null)
      {
        ((FrameLayout.LayoutParams)localObject2).topMargin -= BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131558449);
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      return true;
    }
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    int i = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView == null) {
      return false;
    }
    WebViewTopTabView localWebViewTopTabView = this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView;
    if (paramBoolean) {}
    for (;;)
    {
      localWebViewTopTabView.setVisibility(i);
      return true;
      i = 8;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.z)
    {
      if ((!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.k))
      {
        Resources localResources = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidAppActivity.getResources();
        this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(localResources.getColor(2131492921));
        if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.d != null)) {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.d.setBackgroundColor(0);
        }
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a(this.jdField_a_of_type_AndroidWidgetTextView, true, 2130845881, 2130846264);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a(this.jdField_a_of_type_AndroidWidgetImageView, false, 2130839151, 2130839147);
    }
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {}
    do
    {
      do
      {
        return;
      } while (paramInt == this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Int = paramInt;
      paramInt = Math.max(0, Math.min(paramInt, 255));
      this.jdField_a_of_type_AndroidViewViewGroup.getBackground().mutate().setAlpha(paramInt);
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.d != null)) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.d.getBackground().mutate().setAlpha(paramInt);
      }
      if (paramInt == this.jdField_d_of_type_Int)
      {
        a(true);
        return;
      }
    } while (paramInt != this.jdField_e_of_type_Int);
    a(false);
  }
  
  public void b(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
    paramString = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a();
    if ((paramString != null) && (!this.jdField_d_of_type_Boolean))
    {
      paramString.setOnScrollChangedListener(this.jdField_a_of_type_ComTencentBizUiTouchWebView$OnScrollChangedListener);
      this.jdField_d_of_type_Boolean = true;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_d_of_type_Boolean = true;
      if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    do
    {
      return;
      if ((this.jdField_c_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(this.jdField_c_of_type_AndroidWidgetTextView.getText()))) {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    } while (this.jdField_b_of_type_AndroidWidgetImageView == null);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a() == null) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a().a() == null)) {}
    WebViewPlugin localWebViewPlugin;
    do
    {
      return false;
      localWebViewPlugin = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a().a().a(45, false);
    } while (((localWebViewPlugin instanceof UiApiPlugin)) && (((UiApiPlugin)localWebViewPlugin).g));
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.A) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.B)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {
      return false;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Int = -1;
      a(this.jdField_b_of_type_Int, this.f);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidAppActivity.getWindow().clearFlags(1024);
      }
    }
    for (;;)
    {
      return true;
      b(0);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidAppActivity.getWindow().addFlags(1024);
    }
  }
  
  public void c()
  {
    if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  public void c(int paramInt)
  {
    if (b()) {
      if (this.jdField_d_of_type_AndroidWidgetImageView.getDrawable() == null) {
        break label40;
      }
    }
    label40:
    for (Drawable localDrawable = this.jdField_d_of_type_AndroidWidgetImageView.getDrawable();; localDrawable = this.jdField_d_of_type_AndroidWidgetImageView.getResources().getDrawable(2130846345))
    {
      localDrawable = ImageUtil.a(localDrawable, paramInt);
      this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
      return;
    }
  }
  
  public void c(String paramString)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void c(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Boolean) && (!paramBoolean) && (this.jdField_b_of_type_AndroidWidgetImageView != null)) {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean c()
  {
    return this.jdField_d_of_type_AndroidWidgetImageView.getVisibility() == 0;
  }
  
  @TargetApi(11)
  public void d()
  {
    if (Build.VERSION.SDK_INT == 16) {
      this.jdField_a_of_type_AndroidViewViewGroup.setLayerType(0, null);
    }
  }
  
  public void d(int paramInt)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramInt);
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.jdField_d_of_type_AndroidWidgetImageView != null)
    {
      if ((!paramBoolean) || (!b()) || (this.jdField_a_of_type_AndroidViewView$OnClickListener == null)) {
        break label34;
      }
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    label34:
    do
    {
      return;
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    } while (this.jdField_c_of_type_AndroidWidgetImageView == null);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(BaseApplicationImpl.getApplication().getResources().getColorStateList(2131494210));
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(BaseApplicationImpl.getApplication().getResources().getColorStateList(2131494210));
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(BaseApplicationImpl.getApplication().getResources().getColor(2131494212));
    Drawable localDrawable;
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      localDrawable = this.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
      if (localDrawable != null)
      {
        localDrawable.clearColorFilter();
        localDrawable.invalidateSelf();
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
    }
    if (c())
    {
      localDrawable = this.jdField_d_of_type_AndroidWidgetImageView.getDrawable();
      if (localDrawable != null)
      {
        localDrawable.clearColorFilter();
        localDrawable.invalidateSelf();
      }
      this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  public void e(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramInt);
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(paramInt);
    Drawable localDrawable2 = this.jdField_a_of_type_AndroidWidgetTextView.getBackground();
    Drawable localDrawable1 = this.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
    if (localDrawable2 != null)
    {
      if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = localDrawable2;
        this.jdField_b_of_type_Boolean = true;
      }
      localDrawable2 = ImageUtil.a(localDrawable2, paramInt);
      if (localDrawable2 != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(localDrawable2);
      }
    }
    if (localDrawable1 != null)
    {
      if (!this.jdField_c_of_type_Boolean) {
        this.jdField_c_of_type_Boolean = true;
      }
      localDrawable1 = ImageUtil.a(localDrawable1, paramInt);
      if (localDrawable1 != null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable1);
        c(paramInt);
      }
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.q) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.p))
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.p = false;
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.p = true;
        this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130846385);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
        return;
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.q) || (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.p));
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.p = false;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.p = true;
    this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(BaseApplicationImpl.getApplication().getResources().getColor(2131494254));
    e();
  }
  
  public void f(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setSelectedTab(paramInt);
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_AndroidViewAnimationAnimation != null) {
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(null);
    }
    if (this.jdField_b_of_type_AndroidViewAnimationAnimation != null) {
      this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setOnCheckedChangeListener(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI
 * JD-Core Version:    0.7.0.1
 */