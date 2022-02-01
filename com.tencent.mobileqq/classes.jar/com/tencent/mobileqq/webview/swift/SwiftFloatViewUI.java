package com.tencent.mobileqq.webview.swift;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.widgets.Hole;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.immersive.SystemBarTintManager;

public class SwiftFloatViewUI
{
  public int a;
  Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  public View a;
  public Hole a;
  public SwiftBrowserUIStyle a;
  public SwiftBrowserUIStyleHandler a;
  Runnable jdField_a_of_type_JavaLangRunnable = new SwiftFloatViewUI.3(this);
  public int b;
  public View b;
  int c;
  public View c;
  int d;
  public View d;
  public View e;
  public View f;
  public View g;
  public View h;
  public View i;
  
  public SwiftFloatViewUI(SwiftBrowserUIStyleHandler paramSwiftBrowserUIStyleHandler)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler = paramSwiftBrowserUIStyleHandler;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle = paramSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (8 == this.c.getVisibility()))
    {
      DisplayMetrics localDisplayMetrics;
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidAppActivity != null) {
        localDisplayMetrics = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics();
      } else {
        localDisplayMetrics = BaseApplication.getContext().getResources().getDisplayMetrics();
      }
      this.jdField_a_of_type_Int = localDisplayMetrics.widthPixels;
      this.jdField_b_of_type_Int = localDisplayMetrics.heightPixels;
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle;
      if ((localObject != null) && (((SwiftBrowserUIStyle)localObject).d) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.I))
      {
        c();
        return;
      }
      localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).leftMargin = ((int)(this.jdField_a_of_type_Int - localDisplayMetrics.density * 50.0F));
      ((FrameLayout.LayoutParams)localObject).topMargin = ((int)(this.jdField_b_of_type_Int - localDisplayMetrics.density * 100.0F));
      this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  @TargetApi(11)
  public void a(Activity paramActivity)
  {
    if (SystemBarTintManager.hasNavBar(paramActivity))
    {
      paramActivity = paramActivity.findViewById(16908290);
      paramActivity.addOnLayoutChangeListener(new SwiftFloatViewUI.4(this, paramActivity));
    }
  }
  
  public void a(View paramView)
  {
    int j = paramView.getResources().getColor(2131167254);
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_c_of_type_Boolean) {
      j = paramView.getResources().getColor(2131167255);
    }
    paramView = this.f;
    int k;
    if ((paramView != null) && ((paramView instanceof TextView)))
    {
      k = 2130842722;
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_c_of_type_Boolean) {
        k = 2130842723;
      }
      ((TextView)this.f).setCompoundDrawablesWithIntrinsicBounds(0, k, 0, 0);
      ((TextView)this.f).setTextColor(j);
    }
    paramView = this.g;
    if ((paramView != null) && ((paramView instanceof TextView)))
    {
      k = 2130842719;
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_c_of_type_Boolean) {
        k = 2130842720;
      }
      ((TextView)this.g).setCompoundDrawablesWithIntrinsicBounds(0, k, 0, 0);
      ((TextView)this.g).setTextColor(j);
    }
    paramView = this.e;
    if ((paramView != null) && ((paramView instanceof TextView)))
    {
      k = 2130842713;
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_c_of_type_Boolean) {
        k = 2130842714;
      }
      ((TextView)this.e).setCompoundDrawablesWithIntrinsicBounds(0, k, 0, 0);
      ((TextView)this.e).setTextColor(j);
    }
    paramView = this.d;
    if ((paramView != null) && ((paramView instanceof TextView)))
    {
      k = 2130842710;
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_c_of_type_Boolean) {
        k = 2130842711;
      }
      ((TextView)this.d).setCompoundDrawablesWithIntrinsicBounds(0, k, 0, 0);
      ((TextView)this.d).setTextColor(j);
    }
    paramView = this.jdField_a_of_type_AndroidViewView;
    if ((paramView != null) && ((paramView instanceof Button)))
    {
      j = 2130842706;
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_c_of_type_Boolean) {
        j = 2130842716;
      } else if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.I) {
        j = 2130842718;
      }
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(j);
    }
  }
  
  @TargetApi(16)
  public void a(View paramView, View.OnClickListener paramOnClickListener)
  {
    DisplayMetrics localDisplayMetrics;
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidAppActivity != null) {
      localDisplayMetrics = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics();
    } else {
      localDisplayMetrics = BaseApplication.getContext().getResources().getDisplayMetrics();
    }
    int j;
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.d)
    {
      if (localDisplayMetrics.heightPixels > localDisplayMetrics.widthPixels) {
        j = localDisplayMetrics.heightPixels;
      } else {
        j = localDisplayMetrics.widthPixels;
      }
      this.jdField_a_of_type_Int = j;
      if (localDisplayMetrics.heightPixels > localDisplayMetrics.widthPixels) {
        j = localDisplayMetrics.widthPixels;
      } else {
        j = localDisplayMetrics.heightPixels;
      }
      this.jdField_b_of_type_Int = j;
    }
    else
    {
      if (localDisplayMetrics.heightPixels < localDisplayMetrics.widthPixels) {
        j = localDisplayMetrics.heightPixels;
      } else {
        j = localDisplayMetrics.widthPixels;
      }
      this.jdField_a_of_type_Int = j;
      if (localDisplayMetrics.heightPixels < localDisplayMetrics.widthPixels) {
        j = localDisplayMetrics.widthPixels;
      } else {
        j = localDisplayMetrics.heightPixels;
      }
      this.jdField_b_of_type_Int = j;
    }
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131366974);
    this.c = paramView.findViewById(2131378732);
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131363790);
    this.d = paramView.findViewById(2131366350);
    this.f = paramView.findViewById(2131377360);
    this.g = paramView.findViewById(2131377235);
    this.h = paramView.findViewById(2131371472);
    this.e = paramView.findViewById(2131367053);
    this.i = paramView.findViewById(2131370699);
    this.jdField_a_of_type_ComTencentBizWidgetsHole = ((Hole)paramView.findViewById(2131368201));
    b();
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_c_of_type_Boolean) {
      a(paramView);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_c_of_type_Long & 1L) != 0L)
    {
      this.f.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_c_of_type_Long & 0x4) != 0L)
    {
      this.d.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_c_of_type_Long & 0x2) != 0L)
    {
      this.h.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    if ((((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.b & 0x800) != 0L) || ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.a & 0x80000000) != 0L)) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider != null) && (AuthorizeConfig.a().d("aio_authorize_config", this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getCurrentUrl())))
    {
      this.e.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("secondHandSharePre", 0);
    if (localSharedPreferences.getBoolean("first_float_tip", true))
    {
      this.c.setVisibility(0);
      localSharedPreferences.edit().putBoolean("first_float_tip", false).apply();
      paramView.getViewTreeObserver().addOnGlobalLayoutListener(new SwiftFloatViewUI.1(this, paramView, localDisplayMetrics));
    }
    else
    {
      this.c.setVisibility(8);
    }
    paramView = new SwiftFloatViewUI.2(this, localDisplayMetrics);
    this.d.setOnClickListener(paramOnClickListener);
    this.f.setOnClickListener(paramOnClickListener);
    this.h.setOnClickListener(paramOnClickListener);
    this.g.setOnClickListener(paramOnClickListener);
    this.e.setOnClickListener(paramOnClickListener);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(paramView);
    this.c.setOnTouchListener(paramView);
    this.i.setOnTouchListener(paramView);
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_c_of_type_Boolean)
    {
      paramView.setBackgroundResource(2130842716);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.I)
    {
      paramView.setBackgroundResource(2130842718);
      return;
    }
    if (paramBoolean)
    {
      paramView.setBackgroundResource(2130842706);
      return;
    }
    paramView.setBackgroundResource(2130842707);
  }
  
  public void a(boolean paramBoolean)
  {
    View localView = this.f;
    if (localView != null)
    {
      int j;
      if (paramBoolean) {
        j = 8;
      } else {
        j = 0;
      }
      localView.setVisibility(j);
    }
    if (!paramBoolean)
    {
      localView = this.jdField_a_of_type_AndroidViewView;
      if ((localView != null) && ((localView.getVisibility() == 8) || (this.jdField_a_of_type_AndroidViewView.getVisibility() == 4))) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
  }
  
  public void b()
  {
    SwiftBrowserUIStyle localSwiftBrowserUIStyle = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle;
    if ((localSwiftBrowserUIStyle != null) && (localSwiftBrowserUIStyle.d) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.I) && (this.jdField_a_of_type_AndroidViewView != null) && (8 == this.c.getVisibility())) {
      c();
    }
  }
  
  public void c()
  {
    int k = this.jdField_b_of_type_Int;
    int j = this.jdField_a_of_type_Int;
    int m;
    if (k > j)
    {
      m = j;
    }
    else
    {
      m = k;
      k = j;
    }
    DisplayMetrics localDisplayMetrics;
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidAppActivity != null) {
      localDisplayMetrics = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics();
    } else {
      localDisplayMetrics = BaseApplication.getContext().getResources().getDisplayMetrics();
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.leftMargin = ((int)(k - localDisplayMetrics.density * 70.0F));
    localLayoutParams.topMargin = (m / 2 - this.jdField_a_of_type_AndroidViewView.getWidth() / 2);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.SwiftFloatViewUI
 * JD-Core Version:    0.7.0.1
 */