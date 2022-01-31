package com.tencent.mobileqq.webview.swift;

import akug;
import akuh;
import akuj;
import akuk;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.webviewplugin.Hole;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.immersive.SystemBarTintManager;

public class SwiftFloatViewUI
{
  public int a;
  public Rect a;
  public View a;
  public Hole a;
  public SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle a;
  public SwiftBrowserUIStyleHandler a;
  public Runnable a;
  public int b;
  public View b;
  public int c;
  public View c;
  public int d;
  public View d;
  public View e;
  public View f;
  public View g;
  public View h;
  public View i;
  
  public SwiftFloatViewUI(SwiftBrowserUIStyleHandler paramSwiftBrowserUIStyleHandler)
  {
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_JavaLangRunnable = new akuj(this);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler = paramSwiftBrowserUIStyleHandler;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle = paramSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
  }
  
  public void a()
  {
    DisplayMetrics localDisplayMetrics = BaseApplicationImpl.getContext().getResources().getDisplayMetrics();
    this.jdField_a_of_type_Int = localDisplayMetrics.widthPixels;
    this.jdField_b_of_type_Int = localDisplayMetrics.heightPixels;
    if ((this.jdField_a_of_type_AndroidViewView != null) && (8 == this.c.getVisibility()))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.C)) {
        c();
      }
    }
    else {
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.leftMargin = ((int)(this.jdField_a_of_type_Int - 50.0F * localDisplayMetrics.density));
    localLayoutParams.topMargin = ((int)(this.jdField_b_of_type_Int - localDisplayMetrics.density * 100.0F));
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
  }
  
  @TargetApi(11)
  public void a(Activity paramActivity)
  {
    if (SystemBarTintManager.a(paramActivity))
    {
      paramActivity = paramActivity.findViewById(16908290);
      paramActivity.addOnLayoutChangeListener(new akuk(this, paramActivity));
    }
  }
  
  @TargetApi(16)
  public void a(View paramView, View.OnClickListener paramOnClickListener)
  {
    DisplayMetrics localDisplayMetrics = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics();
    int j;
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_c_of_type_Boolean) {
      if (localDisplayMetrics.heightPixels > localDisplayMetrics.widthPixels)
      {
        j = localDisplayMetrics.heightPixels;
        this.jdField_a_of_type_Int = j;
        if (localDisplayMetrics.heightPixels <= localDisplayMetrics.widthPixels) {
          break label502;
        }
        j = localDisplayMetrics.widthPixels;
        label64:
        this.jdField_b_of_type_Int = j;
        this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131366784);
        this.c = paramView.findViewById(2131366777);
        this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131366779);
        this.d = paramView.findViewById(2131366783);
        this.f = paramView.findViewById(2131366780);
        this.g = paramView.findViewById(2131366781);
        this.h = paramView.findViewById(2131362720);
        this.e = paramView.findViewById(2131366782);
        this.i = paramView.findViewById(2131365602);
        this.jdField_a_of_type_ComTencentBizWebviewpluginHole = ((Hole)paramView.findViewById(2131366778));
        b();
        if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_c_of_type_Long & 1L) != 0L)
        {
          this.f.setVisibility(0);
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_c_of_type_Long & 0x4) != 0L)
        {
          this.d.setVisibility(0);
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_c_of_type_Long & 0x2) != 0L)
        {
          this.h.setVisibility(0);
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        }
        if ((((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.b & 0x800) != 0L) || ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.a & 0x80000000) != 0L)) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) && (AuthorizeConfig.a().f(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.g)))
        {
          this.e.setVisibility(0);
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        }
        SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("secondHandSharePre", 0);
        if (!localSharedPreferences.getBoolean("first_float_tip", true)) {
          break label580;
        }
        this.c.setVisibility(0);
        localSharedPreferences.edit().putBoolean("first_float_tip", false).apply();
        paramView.getViewTreeObserver().addOnGlobalLayoutListener(new akug(this, paramView, localDisplayMetrics));
      }
    }
    for (;;)
    {
      paramView = new akuh(this, localDisplayMetrics);
      this.d.setOnClickListener(paramOnClickListener);
      this.f.setOnClickListener(paramOnClickListener);
      this.h.setOnClickListener(paramOnClickListener);
      this.g.setOnClickListener(paramOnClickListener);
      this.e.setOnClickListener(paramOnClickListener);
      this.jdField_a_of_type_AndroidViewView.setOnTouchListener(paramView);
      this.c.setOnTouchListener(paramView);
      this.i.setOnTouchListener(paramView);
      return;
      j = localDisplayMetrics.widthPixels;
      break;
      label502:
      j = localDisplayMetrics.heightPixels;
      break label64;
      if (localDisplayMetrics.heightPixels < localDisplayMetrics.widthPixels)
      {
        j = localDisplayMetrics.heightPixels;
        label530:
        this.jdField_a_of_type_Int = j;
        if (localDisplayMetrics.heightPixels >= localDisplayMetrics.widthPixels) {
          break label571;
        }
      }
      label571:
      for (j = localDisplayMetrics.widthPixels;; j = localDisplayMetrics.heightPixels)
      {
        this.jdField_b_of_type_Int = j;
        break;
        j = localDisplayMetrics.widthPixels;
        break label530;
      }
      label580:
      this.c.setVisibility(8);
    }
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.C)
    {
      paramView.setBackgroundResource(2130840672);
      return;
    }
    if (paramBoolean)
    {
      paramView.setBackgroundResource(2130840663);
      return;
    }
    paramView.setBackgroundResource(2130840664);
  }
  
  public void a(boolean paramBoolean)
  {
    View localView;
    if (this.f != null)
    {
      localView = this.f;
      if (!paramBoolean) {
        break label67;
      }
    }
    label67:
    for (int j = 8;; j = 0)
    {
      localView.setVisibility(j);
      if ((!paramBoolean) && (this.jdField_a_of_type_AndroidViewView != null) && ((this.jdField_a_of_type_AndroidViewView.getVisibility() == 8) || (this.jdField_a_of_type_AndroidViewView.getVisibility() == 4))) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      return;
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.C) && (this.jdField_a_of_type_AndroidViewView != null) && (8 == this.c.getVisibility())) {
      c();
    }
  }
  
  public void c()
  {
    int j;
    if (this.jdField_b_of_type_Int > this.jdField_a_of_type_Int) {
      j = this.jdField_a_of_type_Int;
    }
    for (int k = this.jdField_b_of_type_Int;; k = this.jdField_a_of_type_Int)
    {
      DisplayMetrics localDisplayMetrics = BaseApplicationImpl.getContext().getResources().getDisplayMetrics();
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      localLayoutParams.leftMargin = ((int)(k - localDisplayMetrics.density * 70.0F));
      localLayoutParams.topMargin = (j / 2 - this.jdField_a_of_type_AndroidViewView.getWidth() / 2);
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      return;
      j = this.jdField_b_of_type_Int;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.SwiftFloatViewUI
 * JD-Core Version:    0.7.0.1
 */