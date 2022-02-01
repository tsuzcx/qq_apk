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
  Animation A;
  boolean B = false;
  int C = -1;
  int D = 0;
  int E = 240;
  int F = 0;
  int G = 255;
  boolean H = true;
  String I = null;
  String J = null;
  ValueAnimation.AnimationUpdateListener<Integer> K = new SwiftIphoneTitleBarUI.1(this);
  String L = null;
  TouchWebView.OnScrollChangedListener M = new SwiftIphoneTitleBarUI.2(this);
  public WebViewTopTabView N;
  public WebViewTopTabHelper O = null;
  public boolean P = false;
  private View Q;
  private boolean R = false;
  private int S;
  @Nullable
  private Intent T;
  public SwiftBrowserUIStyleHandler a;
  public SwiftBrowserUIStyle b;
  Intent c;
  public TextView d;
  public TextView e;
  public TextView f;
  public TextView g;
  public ImageView h;
  public ImageView i;
  public FadeIconImageView j;
  public View k;
  public ImageView l;
  public TextView m;
  public View n;
  public ViewGroup o;
  public ViewGroup p;
  public RelativeLayout q;
  public String r = null;
  public APICallback s = null;
  public JsBridgeListener t = null;
  public boolean u = false;
  boolean v;
  boolean w;
  Drawable x;
  boolean y = false;
  Animation z;
  
  public SwiftIphoneTitleBarUI(SwiftBrowserUIStyleHandler paramSwiftBrowserUIStyleHandler)
  {
    this.a = paramSwiftBrowserUIStyleHandler;
    this.b = paramSwiftBrowserUIStyleHandler.f;
    this.O = new WebViewTopTabHelper(paramSwiftBrowserUIStyleHandler);
  }
  
  private void a(String paramString1, String paramString2, int paramInt1, int paramInt2, JsBridgeListener paramJsBridgeListener, View.OnClickListener paramOnClickListener, APICallback paramAPICallback, boolean paramBoolean)
  {
    this.f.setVisibility(8);
    if (!this.b.Q)
    {
      this.h.setVisibility(0);
      s();
    }
    Object localObject = this.b;
    boolean bool;
    if (paramInt1 != 4) {
      bool = true;
    } else {
      bool = false;
    }
    ((SwiftBrowserUIStyle)localObject).l = bool;
    RelativeLayout.LayoutParams localLayoutParams;
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
            this.h.setVisibility(8);
            break;
          case 18: 
            this.a.a(this.h, false, 2130840115, 2130840117);
            this.h.setContentDescription(BaseApplication.getContext().getResources().getString(2131886199));
            localObject = (RelativeLayout)this.o.findViewById(2131445049);
            if (localObject == null) {
              break;
            }
            localLayoutParams = (RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
            localLayoutParams.rightMargin = ViewUtils.dpToPx(10.0F);
            ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
            break;
          case 17: 
            this.a.a(this.h, false, 2130853400, 2130853400);
            localObject = this.h;
            ((ImageView)localObject).setImageDrawable(BaseImageUtil.a(((ImageView)localObject).getResources().getDrawable(2130853400), this.h.getResources().getColor(2131167990)));
            this.h.setContentDescription(BaseApplication.getContext().getResources().getString(2131889655));
            break;
          case 16: 
            this.a.a(this.h, false, 2130848142, 2130848141);
            this.h.setContentDescription(BaseApplication.getContext().getResources().getString(2131889657));
          }
          break;
        case 9: 
          this.a.a(this.h, false, 2130839015, 2130839015);
          this.h.setContentDescription(BaseApplication.getContext().getResources().getString(2131889657));
          break;
        case 8: 
        case 11: 
          this.a.a(this.h, false, 2130852265, 2130852269);
          this.h.setContentDescription(BaseApplication.getContext().getResources().getString(2131886199));
          break;
        case 7: 
          this.a.a(this.h, false, 2130843565, 2130843568);
          this.h.setContentDescription(BaseApplication.getContext().getResources().getString(2131886199));
          break;
        case 6: 
        case 10: 
          this.a.a(this.h, false, 2130852467, 2130852467);
          this.h.setContentDescription(BaseApplication.getContext().getResources().getString(2131889657));
          break;
        case 5: 
          this.h.setImageResource(2130845007);
          this.h.setContentDescription(BaseApplication.getContext().getResources().getString(2131889659));
          ((AnimationDrawable)this.h.getDrawable()).start();
          break;
        case 4: 
          this.a.a(this.h, false, 2130839550, 2130839550);
          this.h.setContentDescription(BaseApplication.getContext().getResources().getString(2131889658));
          break;
        case 3: 
          this.a.a(this.h, false, 2130841091, 2130841091);
          this.h.setContentDescription(BaseApplication.getContext().getResources().getString(2131889656));
          break;
        case 2: 
          this.a.a(this.h, false, 2130844962, 2130844962);
          this.h.setContentDescription(BaseApplication.getContext().getResources().getString(2131889653));
          break;
        case 1: 
          this.a.a(this.h, false, 2130844964, 2130844963);
          localObject = this.h;
          ((ImageView)localObject).setImageDrawable(BaseImageUtil.a(((ImageView)localObject).getResources().getDrawable(2130844964), this.h.getResources().getColor(2131167990)));
          this.h.setContentDescription(BaseApplication.getContext().getResources().getString(2131889654));
          break;
        }
      }
      else
      {
        this.a.a(this.h, false, 2130841091, 2130841091);
        this.h.setContentDescription(BaseApplication.getContext().getResources().getString(2131916361));
      }
    }
    else
    {
      localObject = URLDrawable.getDrawable(QzoneConfig.getInstance().getConfig("QZoneSetting", "sweetIconRUL", "https://qzonestyle.gtimg.cn/aoi/sola/20170905110724_aew14oIQKq.png"), null);
      if (localObject != null)
      {
        this.h.setBackgroundDrawable((Drawable)localObject);
        localObject = (RelativeLayout)this.o.findViewById(2131445049);
        if (localObject != null)
        {
          localLayoutParams = (RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
          localLayoutParams.rightMargin = ViewUtils.dpToPx(10.0F);
          ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
        }
      }
    }
    if ((paramInt2 == 0) && (this.u)) {
      paramInt2 = 10000;
    }
    if (paramInt2 != 0)
    {
      if (this.i == null)
      {
        this.i = new ImageView(BaseApplication.getContext());
        localObject = (RelativeLayout)this.o.findViewById(2131445049);
        localObject = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131436194);
        ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131436194);
        ((RelativeLayout.LayoutParams)localObject).setMargins(0, 0, 0, 0);
        this.i.setLayoutParams((ViewGroup.LayoutParams)localObject);
        if ((this.h.getParent() instanceof RelativeLayout)) {
          ((RelativeLayout)this.h.getParent()).addView(this.i);
        }
      }
      this.i.setVisibility(0);
      if (paramInt2 != 6)
      {
        if ((paramInt2 != 13) && (paramInt2 != 10000)) {
          this.i.setVisibility(8);
        } else {
          this.i.setImageResource(2130852588);
        }
      }
      else {
        this.i.setImageResource(2130844798);
      }
    }
    else
    {
      localObject = this.i;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(8);
      }
    }
    if (!TextUtils.isEmpty(paramString2)) {
      this.h.setContentDescription(paramString2);
    }
    if (paramOnClickListener != null)
    {
      this.h.setOnClickListener(paramOnClickListener);
    }
    else if ((paramString1 != null) && (!paramBoolean))
    {
      this.r = paramString1.trim();
    }
    else if (paramAPICallback != null)
    {
      this.s = paramAPICallback;
    }
    else
    {
      this.r = null;
      this.t = paramJsBridgeListener;
    }
    this.v = false;
    this.w = false;
  }
  
  private void a(JSONObject paramJSONObject, View paramView)
  {
    String str = paramJSONObject.optString("bgclr", "");
    boolean bool = TextUtils.isEmpty(str);
    int i2 = -1;
    if (!bool)
    {
      localObject = str;
      if (!str.startsWith("#"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("#");
        ((StringBuilder)localObject).append(str);
        localObject = ((StringBuilder)localObject).toString();
      }
      i1 = Color.parseColor((String)localObject);
    }
    else
    {
      i1 = -1;
      localObject = str;
    }
    paramView.setBackgroundColor(i1);
    if ((this.a.r != null) && (this.a.r.getWebTitleBarInterface().l() != null))
    {
      i1 = 0;
      str = paramJSONObject.optString("statusclr", "");
      if (!TextUtils.isEmpty(str))
      {
        paramView = str;
        if (!str.startsWith("#"))
        {
          paramView = new StringBuilder();
          paramView.append("#");
          paramView.append((String)localObject);
          paramView = paramView.toString();
        }
        i1 = Color.parseColor(paramView);
      }
      this.a.r.getWebTitleBarInterface().l().setBackgroundColor(i1);
      SimpleUIUtil.a(true, i1, this.a.i.getWindow());
    }
    Object localObject = paramJSONObject.optString("txtclr", "");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramView = (View)localObject;
      if (!((String)localObject).startsWith("#"))
      {
        paramView = new StringBuilder();
        paramView.append("#");
        paramView.append((String)localObject);
        paramView = paramView.toString();
      }
      i1 = Color.parseColor(paramView);
    }
    else
    {
      i1 = -1;
    }
    this.d.setTextColor(i1);
    paramView = this.j;
    if ((paramView != null) && (paramView.getVisibility() == 0))
    {
      paramView = BaseImageUtil.a(this.j.getDrawable(), i1);
      if (paramView != null) {
        this.j.setImageDrawable(paramView);
      }
    }
    this.f.setTextColor(i1);
    paramView = BaseImageUtil.a(this.d.getBackground(), i1);
    if (paramView != null) {
      this.d.setBackgroundDrawable(paramView);
    }
    paramView = BaseImageUtil.a(this.h.getDrawable(), i1);
    if (paramView != null)
    {
      this.h.setImageDrawable(paramView);
      c(i1);
    }
    paramView = this.Q.findViewById(2131438587);
    localObject = BaseImageUtil.a(paramView.getBackground(), i1);
    if (localObject != null) {
      paramView.setBackgroundDrawable((Drawable)localObject);
    }
    paramView = paramJSONObject.optString("titleclr", "");
    int i1 = i2;
    if (!TextUtils.isEmpty(paramView))
    {
      paramJSONObject = paramView;
      if (!paramView.startsWith("#"))
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("#");
        paramJSONObject.append(paramView);
        paramJSONObject = paramJSONObject.toString();
      }
      i1 = Color.parseColor(paramJSONObject);
    }
    if ((TextUtils.isEmpty(this.e.getText())) && (!TextUtils.isEmpty(this.a.G))) {
      this.e.setText(this.a.G);
    }
    this.e.setTextColor(i1);
  }
  
  private void b(Intent paramIntent)
  {
    if ((this.b.c & 0x4) == 0L)
    {
      if (!SwiftWebViewUtils.d())
      {
        this.d.setText(BaseApplication.getContext().getResources().getString(2131887625));
        return;
      }
      if (paramIntent.getBooleanExtra("hide_title_left_arrow", false)) {
        this.d.setText(BaseApplication.getContext().getResources().getString(2131887625));
      }
    }
  }
  
  private void q()
  {
    if (!TextUtils.isEmpty(this.b.h)) {}
    for (;;)
    {
      String[] arrayOfString;
      try
      {
        Object localObject1 = new JSONObject(URLDecoder.decode(this.b.h));
        if (!((JSONObject)localObject1).has("tabNum")) {
          break label148;
        }
        i1 = ((JSONObject)localObject1).getInt("tabNum");
        if (!((JSONObject)localObject1).has("subTextArray")) {
          break label153;
        }
        localObject1 = ((JSONObject)localObject1).getJSONArray("subTextArray");
        if ((localObject1 == null) || (((JSONArray)localObject1).length() <= 0)) {
          break label164;
        }
        arrayOfString = new String[((JSONArray)localObject1).length()];
        int i2 = 0;
        if (i2 >= ((JSONArray)localObject1).length()) {
          break label158;
        }
        arrayOfString[i2] = ((JSONArray)localObject1).getString(i2);
        i2 += 1;
        continue;
        a(new SwiftIphoneTitleBarUI.SubTabParam(this.b.i, i1, null, null, (String[])localObject1));
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      return;
      label148:
      int i1 = 2;
      continue;
      label153:
      Object localObject2 = null;
      continue;
      label158:
      localObject2 = arrayOfString;
      continue;
      label164:
      localObject2 = null;
    }
  }
  
  private void r()
  {
    this.b.l = true;
    this.f.setVisibility(8);
    this.h.setVisibility(8);
    ImageView localImageView = this.i;
    if (localImageView != null) {
      localImageView.setVisibility(8);
    }
    g(false);
  }
  
  private void s()
  {
    if (this.T != null)
    {
      if (this.h == null) {
        return;
      }
      boolean bool1 = ZhuoXusManager.a().d();
      boolean bool2 = this.T.getBooleanExtra("fromAio", false);
      if ((bool1) && (bool2)) {
        this.h.setVisibility(8);
      }
    }
  }
  
  public void a() {}
  
  @TargetApi(11)
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.f.setEnabled(false);
      if (Build.VERSION.SDK_INT >= 11) {
        this.f.setAlpha(0.5F);
      }
    }
    else
    {
      this.f.setEnabled(true);
      if (Build.VERSION.SDK_INT >= 11) {
        this.f.setAlpha(1.0F);
      }
    }
  }
  
  public void a(int paramInt1, Drawable paramDrawable, int paramInt2)
  {
    Drawable[] arrayOfDrawable = this.e.getCompoundDrawables();
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
      this.e.setCompoundDrawables(paramDrawable, (Drawable)localObject2, (Drawable)localObject1, localDrawable2);
      this.e.setCompoundDrawablePadding(paramInt2);
      this.e.setGravity(17);
    }
  }
  
  void a(int paramInt, boolean paramBoolean)
  {
    if (this.B)
    {
      ViewGroup localViewGroup = null;
      Object localObject;
      if ((paramInt >= this.E) && (this.b.E))
      {
        this.b.E = false;
        if (paramBoolean)
        {
          localObject = this.z;
        }
        else
        {
          b(this.G);
          localObject = localViewGroup;
        }
      }
      else
      {
        localObject = localViewGroup;
        if (paramInt < this.E)
        {
          localObject = localViewGroup;
          if (!this.b.E)
          {
            this.b.E = true;
            if (paramBoolean)
            {
              localObject = this.A;
            }
            else
            {
              b(this.F);
              localObject = localViewGroup;
            }
          }
        }
      }
      localViewGroup = this.o;
      if ((localViewGroup != null) && (localObject != null) && (localObject != localViewGroup.getAnimation()))
      {
        ((Animation)localObject).reset();
        this.o.startAnimation((Animation)localObject);
      }
    }
  }
  
  public void a(Intent paramIntent)
  {
    boolean bool1;
    boolean bool2;
    if ((this.d != null) && (paramIntent != null) && (paramIntent.getExtras() != null))
    {
      try
      {
        String str2 = paramIntent.getExtras().getString("leftViewText");
        int i1 = paramIntent.getExtras().getInt("individuation_url_type");
        str1 = str2;
        if (i1 >= 40300)
        {
          str1 = str2;
          if (i1 <= 40313)
          {
            str1 = str2;
            if (!TextUtils.isEmpty(str2))
            {
              str1 = str2;
              if (str2.contains(BaseApplication.getContext().getString(2131912004))) {
                str1 = BaseApplication.getContext().getString(2131887625);
              }
            }
          }
        }
        bool1 = paramIntent.getBooleanExtra("hide_left_button", false);
        bool2 = paramIntent.getBooleanExtra("fromOneCLickCLose", false);
        paramIntent = str1;
        if (str1 == null) {
          paramIntent = BaseApplication.getContext().getString(2131887625);
        }
        if (!SwiftWebViewUtils.d()) {
          this.d.setText(paramIntent);
        } else if (this.d.getBackground() == null) {
          this.d.setText(paramIntent);
        }
      }
      catch (Exception paramIntent)
      {
        String str1;
        QLog.e("WebLog_SwiftIphoneTitleBarUI", 1, "setLeftViewName exception e = ", paramIntent);
      }
      this.d.setVisibility(0);
    }
    for (;;)
    {
      this.d.setVisibility(4);
      if (AppSetting.e)
      {
        str1 = this.d.getText().toString();
        paramIntent = str1;
        if (!str1.contains(BaseApplication.getContext().getString(2131887625)))
        {
          paramIntent = new StringBuilder();
          paramIntent.append(BaseApplication.getContext().getString(2131887625));
          paramIntent.append(str1);
          paramIntent = paramIntent.toString();
        }
        this.d.setContentDescription(paramIntent);
      }
      if (this.j != null)
      {
        if (bool2)
        {
          this.j.setVisibility(0);
          return;
        }
        this.j.setVisibility(8);
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
    LayoutInflater.from(this.a.x.getContext()).inflate(2131624346, this.a.x);
    this.T = paramIntent;
    this.o = ((ViewGroup)this.a.x.findViewById(2131444897));
    a(this.o);
    this.Q = this.o.findViewById(2131445072);
    this.Q.setVisibility(8);
    this.Q.setPadding(0, -ViewUtils.dpToPx(12.0F), 0, 0);
    this.d = ((TextView)this.o.findViewById(2131436180));
    this.d.setOnClickListener(paramOnClickListener);
    a(this.d);
    if (AppSetting.e) {
      AccessibilityUtil.b(this.d, Button.class.getName());
    }
    if (paramIntent.getBooleanExtra("hide_title_left_arrow", false)) {
      this.d.setBackgroundDrawable(null);
    }
    this.j = ((FadeIconImageView)this.o.findViewById(2131436183));
    this.j.setOnClickListener(paramOnClickListener);
    this.j.setContentDescription(BaseApplication.getContext().getResources().getString(2131886475));
    a(paramIntent);
    this.e = ((TextView)this.o.findViewById(2131436227));
    this.q = ((RelativeLayout)this.o.findViewById(2131445050));
    this.f = ((TextView)this.o.findViewById(2131436211));
    this.h = ((ImageView)this.o.findViewById(2131436194));
    a(this.f);
    a(this.h);
    this.f.setOnClickListener(paramOnClickListener);
    this.h.setOnClickListener(paramOnClickListener);
    this.k = this.a.x.findViewById(2131447671);
    this.l = ((ImageView)this.k.findViewById(2131447670));
    this.m = ((TextView)this.k.findViewById(2131447672));
    this.n = this.k.findViewById(2131447669);
    this.n.setOnClickListener(new SwiftIphoneTitleBarUI.3(this));
    this.p = ((ViewGroup)this.o.findViewById(2131447534));
    g();
    b(this.L);
    b();
  }
  
  public void a(Intent paramIntent, String paramString)
  {
    if ((paramIntent != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (this.b.a) {
        return;
      }
      b(paramIntent);
      if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("youxi.vip.qq.com/imoj"))) {
        paramIntent.putExtra("isScreenOrientationPortrait", true);
      }
      Object localObject = paramIntent.getStringExtra("title");
      this.b.s = paramIntent.getBooleanExtra("ishiderefresh", false);
      this.b.t = paramIntent.getBooleanExtra("ishidebackforward", false);
      boolean bool = paramIntent.getBooleanExtra("hide_left_button", false);
      this.b.u = paramIntent.getBooleanExtra("show_right_close_button", false);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("QQBrowser url=");
        localStringBuilder.append(Util.b(paramString, new String[0]));
        QLog.d("QQBrowser", 2, localStringBuilder.toString());
      }
      if ((localObject != null) && (((String)localObject).length() > 0)) {
        this.e.setText((CharSequence)localObject);
      } else {
        this.e.setText("");
      }
      this.h.setContentDescription(BaseApplication.getContext().getResources().getString(2131887617));
      if (!this.b.l)
      {
        this.h.setVisibility(0);
        localObject = this.h.getResources().getDrawable(2130841091);
        if ((!this.a.f.b) && (!this.b.v))
        {
          paramString = (String)localObject;
          if (this.b.R != null) {
            paramString = BaseImageUtil.a((Drawable)localObject, this.b.R.e);
          }
        }
        else
        {
          paramString = BaseImageUtil.a((Drawable)localObject, -1);
        }
        this.h.setImageDrawable(paramString);
        this.h.setContentDescription(BaseApplication.getContext().getResources().getString(2131889658));
        s();
      }
      if (n()) {
        if ((!this.a.f.b) && (!this.b.v))
        {
          if (this.b.R != null) {
            c(this.b.R.e);
          }
        }
        else {
          c(-1);
        }
      }
      if (bool) {
        this.d.setVisibility(4);
      }
      int i1;
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        i1 = ImmersiveUtils.getStatusBarHeight(this.a.i) + 0;
      } else {
        i1 = 0;
      }
      int i2 = View.MeasureSpec.makeMeasureSpec(0, 0);
      int i3 = View.MeasureSpec.makeMeasureSpec(0, 0);
      this.o.measure(i2, i3);
      i1 += this.o.getMeasuredHeight();
      if (this.b.y)
      {
        i2 = this.o.getTop();
        i3 = this.o.getBottom();
        paramString = this.o;
        paramString.layout(paramString.getLeft(), i2 - i1, this.o.getRight(), i3 - i1);
        this.o.setVisibility(8);
      }
      else
      {
        i2 = this.o.getTop();
        i3 = this.o.getBottom();
        paramString = this.o;
        paramString.layout(paramString.getLeft(), i2 + i1, this.o.getRight(), i3 + i1);
        this.o.setVisibility(0);
      }
      if (this.b.u) {
        a(paramIntent.getStringExtra("left_close_button_text"));
      }
      q();
      a();
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
    this.b.G = true;
    paramView.startAnimation(localValueAnimation);
  }
  
  public void a(TouchWebView paramTouchWebView)
  {
    ViewGroup localViewGroup = this.o;
    if ((this.b.B) && (localViewGroup != null) && (!this.b.F) && (f()))
    {
      SwiftBrowserUIStyle localSwiftBrowserUIStyle = this.b;
      localSwiftBrowserUIStyle.F = true;
      localSwiftBrowserUIStyle.C = true;
      localSwiftBrowserUIStyle.E = true;
      localViewGroup.setBackgroundResource(2130853488);
      if (ThemeUtil.isNowThemeIsNight(MobileQQ.sMobileQQ.waitAppRuntime(null), false, null)) {
        this.h.setBackgroundDrawable(null);
      }
      paramTouchWebView.setOnScrollChangedListenerForBiz(new SwiftIphoneTitleBarUI.5(this));
    }
  }
  
  public void a(TouchWebView paramTouchWebView, boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean2, String paramString1, String paramString2, String paramString3)
  {
    if (paramTouchWebView == null) {
      return;
    }
    if (!this.y)
    {
      paramTouchWebView.setOnScrollChangedListenerForBiz(this.M);
      this.y = true;
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
    this.B = paramBoolean1;
    Object localObject = BaseApplication.getContext();
    this.E = ((int)(paramInt1 * ((Context)localObject).getResources().getDisplayMetrics().density + 0.5F));
    this.F = paramInt2;
    this.G = paramInt3;
    this.z = new ValueAnimation(Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), this.K);
    this.z.setDuration(300L);
    this.z.setInterpolator((Context)localObject, 17432581);
    this.A = new ValueAnimation(Integer.valueOf(paramInt3), Integer.valueOf(paramInt2), this.K);
    this.A.setDuration(300L);
    this.A.setInterpolator((Context)localObject, 17432581);
    this.H = paramBoolean2;
    this.I = paramString1;
    this.J = paramString2;
    this.C = -1;
    a(this.D, false);
    if (TextUtils.isEmpty(paramString3)) {
      return;
    }
    paramString1 = new JSONObject();
    try
    {
      paramString1.put("result", 0);
      paramString1.put("message", "ok");
      label380:
      paramTouchWebView.callJs(paramString3, new String[] { paramString1.toString() });
      return;
    }
    catch (Exception paramString2)
    {
      break label380;
    }
  }
  
  public void a(SwiftIphoneTitleBarUI.SubTabParam paramSubTabParam)
  {
    if (paramSubTabParam != null)
    {
      this.N = new WebViewTopTabView(BaseApplication.getContext());
      this.N.setButtonNum(paramSubTabParam.b, paramSubTabParam.a);
      this.N.setButtonText(paramSubTabParam.e);
      this.N.setButtonBackgroundResource(2130853469, 2130853470, 2130853471);
      this.N.setButtonTextColorStateList(2131168436);
      this.N.setLeftAndRightPaddingByDp(10);
      a(this.b.E);
      int i1 = -1;
      try
      {
        this.q.removeAllViews();
        this.q.addView(this.N, new RelativeLayout.LayoutParams(-2, -1));
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
      this.N.setOnCheckedChangeListener(new SwiftIphoneTitleBarUI.7(this));
      Object localObject = this.O;
      if (localObject != null) {
        ((WebViewTopTabHelper)localObject).a(paramSubTabParam.d, true);
      }
      TouchWebView localTouchWebView = this.a.l();
      if ((localTouchWebView != null) && (!TextUtils.isEmpty(paramSubTabParam.c)))
      {
        if (TextUtils.isEmpty(paramSubTabParam.d))
        {
          localObject = "the subTabCallback isEmpty";
        }
        else
        {
          localObject = "ok";
          i1 = 0;
        }
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("code", i1);
          localJSONObject.put("message", localObject);
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
        }
        localTouchWebView.callJs(paramSubTabParam.c, new String[] { localJSONObject.toString() });
      }
    }
  }
  
  public void a(SwiftIphoneTitleBarUI.SubTabRedHotParam paramSubTabRedHotParam)
  {
    if (paramSubTabRedHotParam != null)
    {
      Object localObject1 = this.N;
      if (localObject1 != null)
      {
        Object localObject2 = paramSubTabRedHotParam.a;
        boolean bool;
        if (paramSubTabRedHotParam.b == 1) {
          bool = true;
        } else {
          bool = false;
        }
        ((WebViewTopTabView)localObject1).setRedHotStatus((int[])localObject2, bool);
        localObject2 = this.a.l();
        if (localObject2 == null) {
          return;
        }
        JSONObject localJSONObject = new JSONObject();
        Object localObject3 = this.N.getRedHotStatus();
        int i1;
        String str;
        if ((localObject3 != null) && (localObject3.length != 0))
        {
          try
          {
            localObject1 = new JSONArray();
            i1 = 0;
            while (i1 < localObject3.length)
            {
              ((JSONArray)localObject1).put(localObject3[i1]);
              i1 += 1;
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
            i1 = 0;
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
            i1 = -3;
            str = "construction json error";
          }
        }
        else
        {
          i1 = -2;
          str = "sub tab num is error";
        }
        localObject3 = new JSONObject();
        try
        {
          ((JSONObject)localObject3).put("code", i1);
          ((JSONObject)localObject3).put("message", str);
          ((JSONObject)localObject3).put("data", localJSONObject);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        if (!TextUtils.isEmpty(paramSubTabRedHotParam.c)) {
          ((TouchWebView)localObject2).callJs(paramSubTabRedHotParam.c, new String[] { ((JSONObject)localObject3).toString() });
        }
      }
    }
  }
  
  public void a(WebView paramWebView, String paramString, boolean paramBoolean)
  {
    if (this.o != null)
    {
      if (this.b.a) {
        return;
      }
      Object localObject = (RelativeLayout)this.p.findViewById(2131447534);
      if (localObject != null)
      {
        paramWebView = (TextView)((RelativeLayout)localObject).findViewById(2131447581);
        localObject = (TextView)((RelativeLayout)localObject).findViewById(2131447497);
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
    if (this.f != null)
    {
      if (!TextUtils.isEmpty(paramString)) {
        this.f.setText(paramString);
      } else {
        this.f.setText(2131886475);
      }
      this.f.setVisibility(0);
      this.f.bringToFront();
    }
    paramString = this.h;
    if (paramString != null)
    {
      paramString.setImageResource(0);
      this.h.setBackgroundColor(0);
      this.h.setVisibility(8);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 != null) && (paramString1.length() != 0))
    {
      this.d.setVisibility(0);
      if (!SwiftWebViewUtils.d()) {
        this.d.setText(paramString1);
      } else if (this.d.getBackground() == null) {
        this.d.setText(paramString1);
      }
    }
    else
    {
      this.d.setVisibility(4);
    }
    if ((paramString2 != null) && (paramString2.length() != 0))
    {
      this.f.setText(paramString2);
      this.f.setVisibility(0);
      this.h.setVisibility(8);
    }
    else
    {
      this.f.setVisibility(8);
    }
    if (TextUtils.isEmpty(paramString3)) {
      paramString3 = "";
    }
    c(paramString3);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, JsBridgeListener paramJsBridgeListener, View.OnClickListener paramOnClickListener, APICallback paramAPICallback)
  {
    boolean bool;
    if ((paramJsBridgeListener != null) && (paramJsBridgeListener.c)) {
      bool = true;
    } else {
      bool = false;
    }
    if (paramBoolean)
    {
      r();
      return;
    }
    Intent localIntent = this.T;
    if ((localIntent != null) && (localIntent.getIntExtra("reqType", -1) == 7))
    {
      this.f.setVisibility(8);
      this.h.setVisibility(8);
      return;
    }
    if (n()) {
      g(true);
    } else {
      g(false);
    }
    if (paramInt1 == 0)
    {
      if (!TextUtils.isEmpty(paramString2))
      {
        this.f.setText(paramString2);
        this.f.setVisibility(0);
        this.f.bringToFront();
        this.h.setImageResource(0);
        this.h.setBackgroundColor(0);
        this.h.setVisibility(8);
      }
      if ((paramString3 != null) && (paramString3.length() <= 0)) {}
    }
    try
    {
      paramInt1 = Color.parseColor(paramString3);
    }
    catch (Exception paramString2)
    {
      label176:
      break label176;
    }
    paramInt1 = 0;
    this.h.setBackgroundColor(paramInt1);
    if ((paramString1 != null) && (!bool))
    {
      this.r = paramString1.trim();
    }
    else if (paramAPICallback != null)
    {
      this.s = paramAPICallback;
    }
    else
    {
      this.t = paramJsBridgeListener;
      this.r = null;
      break label254;
      a(paramString1, paramString2, paramInt1, paramInt2, paramJsBridgeListener, paramOnClickListener, paramAPICallback, bool);
    }
    label254:
    if (this.b.I.has("txtclr"))
    {
      paramString2 = this.b.I.optString("txtclr", "");
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
          paramString1 = BaseImageUtil.a(this.h.getDrawable(), paramInt1);
          if (paramString1 != null)
          {
            this.h.setImageDrawable(paramString1);
            c(paramInt1);
          }
        }
        catch (Exception paramString1)
        {
          QLog.e("WebLog_SwiftIphoneTitleBarUI", 1, paramString1, new Object[0]);
        }
      }
    }
    a(this.b.E);
  }
  
  public void a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    if (paramJSONObject != null) {}
    label292:
    try
    {
      if ((paramJSONObject.length() > 0) && (!this.b.F))
      {
        this.b.F = f();
        if ((this.b.N) && (this.a.D != null)) {
          this.a.D.setPadding(0, (int)DisplayUtils.a(BaseApplication.getContext(), 30.0F), 0, 0);
        }
      }
      if (paramJSONObject == null) {
        break label292;
      }
      if (!this.b.F) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("titlebar config:");
        ((StringBuilder)localObject).append(paramJSONObject.toString());
        QLog.d("WebLog_SwiftIphoneTitleBarUI", 2, ((StringBuilder)localObject).toString());
      }
      localObject = this.o;
      if (localObject == null) {
        return;
      }
      if (paramBoolean) {
        a(paramJSONObject, (View)localObject);
      }
      if (paramJSONObject.optInt("trans", -1) == 0) {
        break label292;
      }
      paramBoolean = paramJSONObject.optBoolean("anim", false);
      int i1 = paramJSONObject.optInt("dur", 0);
      int i2 = paramJSONObject.optInt("alpha", 0);
      if ((paramBoolean) && (i1 > 0))
      {
        a((View)localObject, this.b.H, i2, i1);
        return;
      }
      ((View)localObject).getBackground().mutate().setAlpha(i2);
      this.b.H = i2;
      return;
    }
    catch (Exception localException)
    {
      Object localObject;
      label249:
      break label249;
    }
    if (QLog.isColorLevel())
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("game center,doTransparent error:");
      paramJSONObject.append(((Exception)localObject).toString());
      QLog.d("WebLog_SwiftIphoneTitleBarUI", 2, paramJSONObject.toString());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.b.E = paramBoolean;
    String str;
    if (paramBoolean)
    {
      str = this.I;
      if (str != null)
      {
        c(str);
        return;
      }
    }
    if (!paramBoolean)
    {
      str = this.J;
      if (str != null) {
        c(str);
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    View localView = this.k;
    if (localView != null)
    {
      if (paramBoolean)
      {
        paramInt1 = QQToast.getIconRes(paramInt1);
        this.l.setImageDrawable(this.k.getResources().getDrawable(paramInt1));
        this.m.setText(this.k.getResources().getString(paramInt2));
        this.k.setVisibility(0);
        return;
      }
      localView.setVisibility(8);
    }
  }
  
  public void b() {}
  
  public void b(int paramInt)
  {
    if (this.o == null) {
      return;
    }
    if (paramInt == this.C) {
      return;
    }
    this.C = paramInt;
    paramInt = Math.max(0, Math.min(paramInt, 255));
    this.o.getBackground().mutate().setAlpha(paramInt);
    if ((this.a.r != null) && (this.a.r.getWebTitleBarInterface().l() != null)) {
      this.a.r.getWebTitleBarInterface().l().getBackground().mutate().setAlpha(paramInt);
    }
    if (paramInt == this.F)
    {
      a(true);
      return;
    }
    if (paramInt == this.G) {
      a(false);
    }
  }
  
  public void b(String paramString)
  {
    this.L = paramString;
    paramString = this.a.l();
    if ((paramString != null) && (!this.y))
    {
      paramString.setOnScrollChangedListenerForBiz(this.M);
      this.y = true;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      this.b.l = true;
      localObject = this.f;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
      localObject = this.h;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(8);
      }
      localObject = this.i;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(8);
      }
    }
    else
    {
      localObject = this.f;
      if ((localObject != null) && (!TextUtils.isEmpty(((TextView)localObject).getText()))) {
        this.f.setVisibility(0);
      }
      localObject = this.h;
      if (localObject != null)
      {
        ((ImageView)localObject).setVisibility(0);
        s();
      }
      localObject = this.i;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(0);
      }
    }
  }
  
  public void c()
  {
    if (this.b.P)
    {
      if ((!this.b.b) && (!this.b.v))
      {
        Resources localResources = this.a.i.getResources();
        this.o.setBackgroundColor(localResources.getColor(2131168335));
        if ((this.a.r != null) && (this.a.r.getWebTitleBarInterface().l() != null)) {
          this.a.r.getWebTitleBarInterface().l().setBackgroundColor(0);
        }
      }
      this.d.setTextColor(-1);
      this.f.setTextColor(-1);
      this.e.setTextColor(-1);
      this.a.a(this.d, true, 2130852243, 2130853297);
      this.a.a(this.h, false, 2130841091, 2130841087);
    }
  }
  
  public void c(int paramInt)
  {
    if (n())
    {
      View localView = this.Q.findViewById(2131438587);
      localView.setBackgroundDrawable(BaseImageUtil.a(localView.getBackground(), paramInt));
    }
  }
  
  public void c(String paramString)
  {
    this.e.setText(paramString);
  }
  
  public void c(boolean paramBoolean)
  {
    this.R = paramBoolean;
  }
  
  @TargetApi(11)
  public JSONObject d(String paramString)
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
  
  public void d()
  {
    Object localObject = this.f;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    localObject = this.h;
    if (localObject != null)
    {
      ((ImageView)localObject).setVisibility(0);
      s();
    }
  }
  
  public void d(int paramInt)
  {
    this.e.setTextColor(paramInt);
  }
  
  public boolean d(boolean paramBoolean)
  {
    WebViewTopTabView localWebViewTopTabView = this.N;
    int i1 = 0;
    if (localWebViewTopTabView == null) {
      return false;
    }
    if (!paramBoolean) {
      i1 = 8;
    }
    localWebViewTopTabView.setVisibility(i1);
    return true;
  }
  
  public void e()
  {
    TouchWebView localTouchWebView = this.a.l();
    if (localTouchWebView != null) {
      localTouchWebView.setOnScrollChangedListenerForBiz(null);
    }
  }
  
  public void e(int paramInt)
  {
    this.S = paramInt;
  }
  
  public boolean e(boolean paramBoolean)
  {
    if (this.o == null) {
      return false;
    }
    if (paramBoolean)
    {
      this.C = -1;
      a(this.D, this.H);
      this.o.setVisibility(0);
      if (!this.a.f.a) {
        this.a.i.getWindow().clearFlags(1024);
      }
    }
    else
    {
      b(0);
      this.o.setVisibility(8);
      this.a.i.getWindow().addFlags(1024);
    }
    return true;
  }
  
  public void f(int paramInt)
  {
    int i1 = this.d.getCurrentTextColor();
    if ((i1 != paramInt) && (!this.R))
    {
      c(true);
      e(i1);
    }
    this.d.setTextColor(paramInt);
    this.f.setTextColor(paramInt);
    Object localObject = this.j;
    if ((localObject != null) && (((FadeIconImageView)localObject).getVisibility() == 0))
    {
      localObject = BaseImageUtil.a(this.j.getDrawable(), paramInt);
      if (localObject != null) {
        this.j.setImageDrawable((Drawable)localObject);
      }
    }
    Drawable localDrawable = this.d.getBackground();
    localObject = this.h.getDrawable();
    if (localDrawable != null)
    {
      if (!this.v)
      {
        this.x = localDrawable;
        this.v = true;
      }
      localDrawable = BaseImageUtil.a(localDrawable, paramInt);
      if (localDrawable != null) {
        this.d.setBackgroundDrawable(localDrawable);
      }
    }
    if (localObject != null)
    {
      if (!this.w) {
        this.w = true;
      }
      localObject = BaseImageUtil.a((Drawable)localObject, paramInt);
      if (localObject != null)
      {
        this.h.setImageDrawable((Drawable)localObject);
        c(paramInt);
      }
    }
    this.h.setColorFilter(paramInt);
  }
  
  public void f(boolean paramBoolean)
  {
    if ((this.u) && (!paramBoolean))
    {
      ImageView localImageView = this.i;
      if (localImageView != null) {
        localImageView.setVisibility(8);
      }
    }
    this.u = paramBoolean;
  }
  
  @TargetApi(17)
  public boolean f()
  {
    if ((!this.a.f.b) && (!this.b.v) && (this.o != null) && (this.a.x != null) && (Build.VERSION.SDK_INT >= 17))
    {
      Object localObject1 = (TextView)this.a.x.findViewById(2131429744);
      if (localObject1 != null)
      {
        localObject2 = (LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
        if (localObject2 != null)
        {
          ((LinearLayout.LayoutParams)localObject2).topMargin -= ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext());
          ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
      }
      localObject1 = this.a.x.findViewById(2131450099);
      Object localObject2 = (FrameLayout.LayoutParams)((View)localObject1).getLayoutParams();
      if (localObject2 != null)
      {
        ((FrameLayout.LayoutParams)localObject2).topMargin -= BaseApplication.getContext().getResources().getDimensionPixelSize(2131299927);
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      return true;
    }
    return false;
  }
  
  @TargetApi(11)
  public void g()
  {
    if (Build.VERSION.SDK_INT == 16) {
      this.o.setLayerType(0, null);
    }
  }
  
  public void g(int paramInt)
  {
    this.b.i = paramInt;
    WebViewTopTabView localWebViewTopTabView = this.N;
    if (localWebViewTopTabView != null) {
      localWebViewTopTabView.setSelectedTab(paramInt);
    }
  }
  
  public void g(boolean paramBoolean)
  {
    if (this.a.r != null)
    {
      ISwiftMiniAIO localISwiftMiniAIO = (ISwiftMiniAIO)this.a.r.getComponentProvider().a(256);
      if ((paramBoolean) && (n()))
      {
        localISwiftMiniAIO.a(100);
        localISwiftMiniAIO.b();
        localISwiftMiniAIO.a(true);
        return;
      }
      localISwiftMiniAIO.a(false);
    }
  }
  
  public String h()
  {
    TextView localTextView = this.e;
    if (localTextView == null) {
      return "";
    }
    return localTextView.getText().toString();
  }
  
  public void i()
  {
    if (this.R)
    {
      f(this.S);
      this.R = false;
    }
  }
  
  public void j()
  {
    this.d.setTextColor(BaseApplication.getContext().getResources().getColorStateList(2131167987));
    this.f.setTextColor(BaseApplication.getContext().getResources().getColorStateList(2131167987));
    this.e.setTextColor(BaseApplication.getContext().getResources().getColor(2131167990));
    Object localObject = this.h;
    if (localObject != null)
    {
      localObject = ((ImageView)localObject).getDrawable();
      if (localObject != null)
      {
        ((Drawable)localObject).clearColorFilter();
        ((Drawable)localObject).invalidateSelf();
      }
      this.h.setImageDrawable((Drawable)localObject);
    }
    if (o())
    {
      localObject = this.Q.findViewById(2131438587);
      Drawable localDrawable = ((View)localObject).getBackground();
      if (localDrawable != null)
      {
        localDrawable.clearColorFilter();
        localDrawable.invalidateSelf();
      }
      ((View)localObject).setBackgroundDrawable(localDrawable);
    }
    this.d.setBackgroundDrawable(this.x);
  }
  
  public void k()
  {
    if (this.o == null) {
      return;
    }
    SwiftBrowserUIStyle localSwiftBrowserUIStyle;
    if ((this.b.E) && (this.b.D))
    {
      localSwiftBrowserUIStyle = this.b;
      localSwiftBrowserUIStyle.D = false;
      localSwiftBrowserUIStyle.D = true;
      this.o.setBackgroundResource(2130853488);
      this.e.setTextColor(-1);
      return;
    }
    if ((!this.b.E) && (this.b.D))
    {
      localSwiftBrowserUIStyle = this.b;
      localSwiftBrowserUIStyle.D = false;
      localSwiftBrowserUIStyle.D = true;
      this.o.setBackgroundColor(BaseApplication.getContext().getResources().getColor(2131168092));
      j();
    }
  }
  
  public int l()
  {
    if (this.N != null)
    {
      int i1 = 0;
      while (i1 < this.N.getChildCount())
      {
        if (((RadioButton)this.N.getChildAt(i1)).isChecked()) {
          return i1;
        }
        i1 += 1;
      }
    }
    return -1;
  }
  
  public void m()
  {
    Object localObject = this.z;
    if (localObject != null) {
      ((Animation)localObject).setAnimationListener(null);
    }
    localObject = this.A;
    if (localObject != null) {
      ((Animation)localObject).setAnimationListener(null);
    }
    localObject = this.N;
    if (localObject != null) {
      ((WebViewTopTabView)localObject).setOnCheckedChangeListener(null);
    }
  }
  
  public boolean n()
  {
    TouchWebView localTouchWebView = this.a.l();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localTouchWebView != null)
    {
      if (this.a.l().getPluginEngine() == null) {
        return false;
      }
      if (this.P) {
        return false;
      }
      if (!this.b.S)
      {
        bool1 = bool2;
        if (!this.b.T) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean o()
  {
    return p().getVisibility() == 0;
  }
  
  public View p()
  {
    return this.Q;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI
 * JD-Core Version:    0.7.0.1
 */