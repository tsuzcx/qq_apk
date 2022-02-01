package com.tencent.mobileqq.kandian.glue.viola;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Scroller;
import android.widget.TextView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.ui.dom.style.CornerViewOutlineProvider;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import org.json.JSONObject;

public class CommonSuspensionGestureLayout
  extends FrameLayout
  implements View.OnTouchListener
{
  public static int a = 0;
  public static int b = 1;
  public static int c = 2;
  public static int d = 3;
  public static int e = 4;
  public static int f = 5;
  public static int g = 500;
  public static int h = 300;
  float jdField_a_of_type_Float;
  private long jdField_a_of_type_Long;
  private ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker = null;
  private View.OnLayoutChangeListener jdField_a_of_type_AndroidViewView$OnLayoutChangeListener;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private AnimationSet jdField_a_of_type_AndroidViewAnimationAnimationSet;
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  Scroller jdField_a_of_type_AndroidWidgetScroller;
  private CommonSuspensionGestureLayout.ContentScrollListener jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout$ContentScrollListener;
  private CommonSuspensionGestureLayout.SuspensionGestureListener jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout$SuspensionGestureListener;
  private Boolean jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
  private boolean jdField_a_of_type_Boolean = true;
  float jdField_b_of_type_Float;
  private View jdField_b_of_type_AndroidViewView;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private TranslateAnimation jdField_b_of_type_AndroidViewAnimationTranslateAnimation;
  private boolean jdField_b_of_type_Boolean = true;
  float jdField_c_of_type_Float;
  private View jdField_c_of_type_AndroidViewView;
  private boolean jdField_c_of_type_Boolean = false;
  float jdField_d_of_type_Float;
  private View jdField_d_of_type_AndroidViewView;
  private boolean jdField_d_of_type_Boolean = true;
  private float jdField_e_of_type_Float;
  private View jdField_e_of_type_AndroidViewView;
  private boolean jdField_e_of_type_Boolean = true;
  private View jdField_f_of_type_AndroidViewView;
  private boolean jdField_f_of_type_Boolean = false;
  private View jdField_g_of_type_AndroidViewView;
  private boolean jdField_g_of_type_Boolean = false;
  private boolean h;
  private int jdField_i_of_type_Int = 0;
  private boolean jdField_i_of_type_Boolean = false;
  private int jdField_j_of_type_Int = 120;
  private boolean jdField_j_of_type_Boolean = false;
  private int jdField_k_of_type_Int = 10;
  private boolean jdField_k_of_type_Boolean = false;
  private int jdField_l_of_type_Int = -1;
  private boolean jdField_l_of_type_Boolean = false;
  private int jdField_m_of_type_Int = 0;
  private boolean jdField_m_of_type_Boolean = true;
  private int n = 0;
  private int o = 0;
  private int p = -1;
  private int q = -1;
  private int r = -1;
  private int s = 0;
  private int t = -ViewUtils.b(this.jdField_j_of_type_Int);
  
  public CommonSuspensionGestureLayout(Context paramContext, Bundle paramBundle)
  {
    super(paramContext, null, 0);
    this.jdField_h_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    paramBundle = this.jdField_a_of_type_AndroidOsBundle;
    if ((paramBundle != null) && (paramBundle.containsKey("float_layer_back_view"))) {
      this.jdField_f_of_type_Boolean = this.jdField_a_of_type_AndroidOsBundle.getBoolean("float_layer_back_view", false);
    }
    paramBundle = this.jdField_a_of_type_AndroidOsBundle;
    if ((paramBundle != null) && (paramBundle.containsKey("margin_top"))) {
      this.jdField_j_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("margin_top", 120);
    }
    paramBundle = this.jdField_a_of_type_AndroidOsBundle;
    if ((paramBundle != null) && (paramBundle.containsKey("scroll_to_top"))) {
      this.jdField_b_of_type_Boolean = this.jdField_a_of_type_AndroidOsBundle.getBoolean("scroll_to_top", true);
    }
    setOnTouchListener(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    l();
    m();
    n();
    setOnClickListener(new CommonSuspensionGestureLayout.1(this));
    this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener = new CommonSuspensionGestureLayout.2(this);
    addOnLayoutChangeListener(this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener);
  }
  
  public static int a(Activity paramActivity)
  {
    int i1 = 0;
    StringBuilder localStringBuilder;
    try
    {
      int i2;
      if (ScreenUtil.checkDeviceHasNavigationBar(paramActivity.getApplicationContext()))
      {
        i2 = ScreenUtil.getNavigationBarHeight(paramActivity.getApplicationContext());
        i1 = i2;
      }
      else
      {
        i1 = 0;
      }
      try
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getNavigationBarHeight ");
        localStringBuilder.append(i1);
        localStringBuilder.append(",isNavShow:");
        localStringBuilder.append(a(paramActivity));
        localStringBuilder.append(",build name:");
        localStringBuilder.append(Build.MANUFACTURER);
        localStringBuilder.append("，build module:");
        localStringBuilder.append(Build.MODEL);
        localStringBuilder.append(",getContentHeight:");
        localStringBuilder.append(b(paramActivity));
        localStringBuilder.append(",screenHeight:");
        localStringBuilder.append(DisplayUtil.getScreenHeight(paramActivity));
        QLog.d("CommonSuspensionGestureLayout", 1, localStringBuilder.toString());
        if (i1 != 0)
        {
          if (!a(paramActivity)) {
            return 0;
          }
          if ((Build.MANUFACTURER.contains("OnePlus")) && (Build.MODEL.contains("HD1900")) && (b(paramActivity) >= DisplayUtil.getScreenHeight(paramActivity)))
          {
            i2 = b(paramActivity);
            int i3 = DisplayUtil.getScreenHeight(paramActivity);
            return i2 - i3;
          }
        }
        return i1;
      }
      catch (Exception paramActivity) {}
      localStringBuilder = new StringBuilder();
    }
    catch (Exception paramActivity) {}
    localStringBuilder.append("getNavigationBarHeight error:");
    localStringBuilder.append(paramActivity.getMessage());
    QLog.e("CommonSuspensionGestureLayout", 1, localStringBuilder.toString());
    paramActivity.printStackTrace();
    return i1;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetScroller == null) {
      this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(this.jdField_a_of_type_AndroidContentContext);
    }
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject == null) {
      return;
    }
    if (this.jdField_i_of_type_Int == jdField_f_of_type_Int) {
      return;
    }
    int i1 = ((View)localObject).getScrollX();
    int i2 = this.jdField_a_of_type_AndroidViewView.getScrollY();
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout$ContentScrollListener;
    if ((localObject != null) && (!((CommonSuspensionGestureLayout.ContentScrollListener)localObject).a()) && ((i2 > 0) || (i2 >= jdField_h_of_type_Int)))
    {
      this.jdField_i_of_type_Int = jdField_f_of_type_Int;
      this.jdField_a_of_type_AndroidViewView.scrollTo(0, 0);
      postInvalidate();
      return;
    }
    if ((i2 < 0) && (i2 > -jdField_g_of_type_Int)) {
      this.jdField_i_of_type_Int = jdField_b_of_type_Int;
    } else if (i2 <= -jdField_g_of_type_Int) {
      this.jdField_i_of_type_Int = jdField_c_of_type_Int;
    } else if ((i2 > 0) && (i2 < jdField_h_of_type_Int)) {
      this.jdField_i_of_type_Int = jdField_d_of_type_Int;
    } else if (i2 >= jdField_h_of_type_Int) {
      this.jdField_i_of_type_Int = jdField_e_of_type_Int;
    }
    if ((e()) && (this.jdField_e_of_type_Float > 0.0F))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout$ContentScrollListener;
      if ((localObject != null) && (((CommonSuspensionGestureLayout.ContentScrollListener)localObject).a()) && (!paramBoolean))
      {
        this.jdField_i_of_type_Int = jdField_f_of_type_Int;
        this.jdField_a_of_type_AndroidViewView.scrollTo(0, -ViewUtils.b(this.jdField_j_of_type_Int));
        u();
        postInvalidate();
        break label298;
      }
    }
    this.jdField_a_of_type_AndroidWidgetScroller.startScroll(i1, i2, paramInt1 - i1, paramInt2 - i2, paramInt3);
    invalidate();
    label298:
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout$SuspensionGestureListener.a(this.jdField_i_of_type_Int);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() != 0) && (paramMotionEvent.getAction() != 2))
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000);
      float f1 = this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity(0);
      if ((this.jdField_a_of_type_AndroidViewView.getScrollY() != -ViewUtils.b(this.jdField_j_of_type_Int)) && (f1 < 0.0F)) {
        a(0, -ViewUtils.b(this.jdField_j_of_type_Int), 200, false);
      }
    }
  }
  
  private void a(FrameLayout paramFrameLayout)
  {
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(getContext());
      Object localObject = new FrameLayout.LayoutParams(-1, ViewUtils.b(20.0F));
      if (this.jdField_i_of_type_Boolean) {
        ((FrameLayout.LayoutParams)localObject).topMargin = (-ViewUtils.b(20.0F));
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(this.jdField_l_of_type_Int);
      localObject = new View(getContext());
      int i1 = Color.parseColor("#FFB0B3BF");
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(ViewUtils.b(60.0F), ViewUtils.b(4.0F));
      localLayoutParams.gravity = 17;
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setCornerRadius(66.0F);
      localGradientDrawable.setColor(i1);
      ((View)localObject).setBackgroundDrawable(localGradientDrawable);
      ((View)localObject).setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject);
      c(this.jdField_a_of_type_AndroidWidgetFrameLayout);
      paramFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_h_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_d_of_type_AndroidViewView.getParent());
    this.jdField_b_of_type_AndroidViewViewGroup.removeView(this.jdField_d_of_type_AndroidViewView);
    if (this.jdField_b_of_type_Boolean)
    {
      addView(this.jdField_d_of_type_AndroidViewView);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_d_of_type_AndroidViewView.getLayoutParams();
      if (this.jdField_j_of_type_Boolean)
      {
        localLayoutParams.height = (this.n + ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext()));
        localLayoutParams.topMargin = 0;
        this.jdField_d_of_type_AndroidViewView.setPadding(0, ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext()), 0, 0);
        this.jdField_d_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      }
      else
      {
        localLayoutParams.topMargin = ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext());
        this.jdField_d_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      }
      if (paramBoolean) {
        this.jdField_a_of_type_AndroidViewView.setPadding(0, this.n, 0, 0);
      }
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  private void a(boolean paramBoolean, View paramView)
  {
    paramView.setVisibility(0);
    paramView.setLayerType(2, null);
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(paramView, View.ALPHA, new float[] { 0.0F, 1.0F });
    } else {
      this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(paramView, View.ALPHA, new float[] { 1.0F, 0.0F });
    }
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.addListener(new CommonSuspensionGestureLayout.9(this, paramView));
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.setDuration(250L);
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.setInterpolator(new LinearInterpolator());
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
  }
  
  private boolean a(int paramInt, float paramFloat)
  {
    return ((paramInt < -jdField_g_of_type_Int) && (paramFloat > -100.0F)) || ((paramInt < -50) && (paramFloat >= 2800.0F));
  }
  
  public static boolean a(Activity paramActivity)
  {
    ViewGroup localViewGroup = (ViewGroup)paramActivity.getWindow().getDecorView();
    if (localViewGroup != null)
    {
      int i1 = 0;
      while (i1 < localViewGroup.getChildCount())
      {
        localViewGroup.getChildAt(i1).getContext().getPackageName();
        if ((localViewGroup.getChildAt(i1).getId() != -1) && ("navigationBarBackground".equals(paramActivity.getResources().getResourceEntryName(localViewGroup.getChildAt(i1).getId()))) && (localViewGroup.getChildAt(i1).getHeight() != 0)) {
          return true;
        }
        i1 += 1;
      }
    }
    return false;
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_b_of_type_Boolean) && (paramMotionEvent.getAction() != 0)) {
      if (this.s < 0)
      {
        if (paramMotionEvent.getAction() == 2)
        {
          if (b(paramMotionEvent)) {
            return true;
          }
          b(paramMotionEvent);
        }
        else
        {
          h();
        }
      }
      else if ((this.jdField_c_of_type_Boolean) && (!this.jdField_k_of_type_Boolean) && (this.jdField_d_of_type_AndroidViewView != null)) {
        c(paramMotionEvent);
      }
    }
    return false;
  }
  
  public static int b(Activity paramActivity)
  {
    if ((paramActivity != null) && (paramActivity.getWindow() != null) && (paramActivity.getWindow().getDecorView() != null))
    {
      Rect localRect = new Rect();
      paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
      return localRect.height();
    }
    return 0;
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    a(true, this.jdField_c_of_type_AndroidViewView);
    o();
    if (paramInt1 != -1) {
      a(paramInt1);
    }
    if (paramInt2 != -1) {
      b(paramInt2);
    }
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    float f2 = this.jdField_b_of_type_Float;
    float f1 = 0.0F;
    if (f2 != 0.0F) {
      f1 = paramMotionEvent.getRawY() - this.jdField_b_of_type_Float;
    }
    this.jdField_a_of_type_Float = f1;
    if (this.jdField_a_of_type_Float < -3.0F)
    {
      i();
      j();
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_d_of_type_AndroidViewView == null) {
      r();
    }
    this.jdField_c_of_type_Boolean = true;
    c(paramBoolean);
    s();
    w();
  }
  
  private boolean b(int paramInt, float paramFloat)
  {
    return ((paramInt > jdField_h_of_type_Int) || (paramFloat < -6500.0F)) && (this.jdField_a_of_type_JavaLangBoolean.booleanValue()) && (paramFloat < 100.0F) && (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 200L) && (this.jdField_e_of_type_Float < 0.0F) && (this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout$ContentScrollListener.a());
  }
  
  private boolean b(MotionEvent paramMotionEvent)
  {
    return (this.jdField_a_of_type_AndroidViewView.getScrollY() < 0) && (paramMotionEvent.getRawY() <= Math.abs(this.jdField_a_of_type_AndroidViewView.getScrollY()));
  }
  
  private void c(MotionEvent paramMotionEvent)
  {
    float f1;
    if (this.jdField_b_of_type_Float != 0.0F) {
      f1 = paramMotionEvent.getRawY() - this.jdField_b_of_type_Float;
    } else {
      f1 = 0.0F;
    }
    this.jdField_a_of_type_Float = f1;
    if ((this.jdField_a_of_type_AndroidViewView.getScrollY() < 0) && (this.jdField_a_of_type_Float > 0.0F))
    {
      this.jdField_k_of_type_Boolean = true;
      a(false, this.jdField_d_of_type_AndroidViewView);
    }
  }
  
  private void c(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      int i1 = this.jdField_k_of_type_Int;
      if (i1 != 0)
      {
        paramView.setOutlineProvider(new CornerViewOutlineProvider(ViewUtils.b(i1), FlexConvertUtils.getScreenHeight(getContext()) - ViewUtils.b(this.jdField_j_of_type_Int), 1));
        paramView.setClipToOutline(true);
      }
    }
  }
  
  private void c(boolean paramBoolean)
  {
    Object localObject = this.jdField_d_of_type_AndroidViewView;
    if ((localObject != null) && ((((View)localObject).getAlpha() != 1.0F) || (this.jdField_d_of_type_AndroidViewView.getVisibility() != 0) || (paramBoolean)))
    {
      this.jdField_k_of_type_Boolean = false;
      localObject = this.jdField_a_of_type_AndroidAnimationObjectAnimator;
      if ((localObject != null) && ((!((ObjectAnimator)localObject).isRunning()) || (paramBoolean))) {
        a(true, this.jdField_d_of_type_AndroidViewView);
      }
    }
  }
  
  public static boolean c()
  {
    return (Build.MANUFACTURER.contains("Xiaomi")) && ((Build.MODEL.contains("MIX 2S")) || (Build.MODEL.contains("MI 8")) || (Build.MODEL.contains("MI 9")) || (Build.MODEL.contains("MIX 2")) || (Build.MODEL.contains("MIX 3")));
  }
  
  private boolean c(int paramInt, float paramFloat)
  {
    return ((paramInt < -jdField_g_of_type_Int) && (paramFloat > -100.0F)) || ((paramInt < -50) && (paramFloat >= 2800.0F));
  }
  
  private void d(int paramInt)
  {
    int i1 = this.s;
    if ((i1 < 0) && (i1 > -ViewUtils.b(this.jdField_j_of_type_Int)))
    {
      if (this.s <= -ViewUtils.b(this.jdField_j_of_type_Int))
      {
        a(0, -ViewUtils.b(this.jdField_j_of_type_Int), 200, false);
        u();
      }
    }
    else if ((this.s == 0) && (paramInt < -ViewUtils.b(this.jdField_j_of_type_Int)))
    {
      a(0, -ViewUtils.b(this.jdField_j_of_type_Int), 200, false);
      u();
    }
  }
  
  private boolean d(int paramInt, float paramFloat)
  {
    return ((paramInt > jdField_h_of_type_Int) || (paramFloat < -6500.0F)) && (this.jdField_a_of_type_JavaLangBoolean.booleanValue()) && (paramFloat < 100.0F) && (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 200L) && (this.jdField_e_of_type_Float < 0.0F) && (this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout$ContentScrollListener.a());
  }
  
  private void e(int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if ((this.jdField_a_of_type_AndroidOsBundle != null) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("floating_window_business"))) {
        localJSONObject.put("Float_type", this.jdField_a_of_type_AndroidOsBundle.get("floating_window_business"));
      }
      if ((this.jdField_a_of_type_AndroidOsBundle != null) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("floating_window_scene"))) {
        localJSONObject.put("source", this.jdField_a_of_type_AndroidOsBundle.get("floating_window_scene"));
      }
      localJSONObject.put("type", paramInt);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X800A9B8", "0X800A9B8", 0, 0, "", "", "", localJSONObject.toString(), false);
  }
  
  private boolean e()
  {
    int i1 = this.jdField_i_of_type_Int;
    return (i1 == jdField_e_of_type_Int) || (i1 == jdField_d_of_type_Int);
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000);
    float f1 = this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity(0);
    if (Math.abs(this.jdField_a_of_type_AndroidViewView.getScrollY()) <= this.n)
    {
      b();
      return;
    }
    if ((f1 < 0.0F) && (Math.abs(f1) >= 3500.0F) && (this.jdField_i_of_type_Int != jdField_f_of_type_Int)) {
      b();
    }
  }
  
  private void i()
  {
    int i1 = (int)(this.jdField_a_of_type_AndroidViewView.getScrollY() - this.jdField_a_of_type_Float);
    if (i1 < 0)
    {
      a(0, i1, 0, true);
      return;
    }
    a(0, 0, 0, true);
  }
  
  private void j()
  {
    View localView = this.jdField_d_of_type_AndroidViewView;
    if ((localView != null) && (localView.getVisibility() != 0) && (Math.abs(this.jdField_a_of_type_AndroidViewView.getScrollY()) <= this.n)) {
      t();
    }
  }
  
  private void k()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject == null) {
      return;
    }
    if (this.jdField_i_of_type_Int == jdField_f_of_type_Int)
    {
      this.jdField_i_of_type_Int = jdField_a_of_type_Int;
      return;
    }
    int i1 = ((View)localObject).getScrollY();
    float f1 = this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity(0);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("closeOrSpringBack judge deltaY:");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append(",velocityY:");
      ((StringBuilder)localObject).append(f1);
      ((StringBuilder)localObject).append(",mCanCloseFromBottom:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangBoolean);
      ((StringBuilder)localObject).append(" , mStateBottomTime ");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - this.jdField_a_of_type_Long);
      ((StringBuilder)localObject).append(", mInterceptDeltaY ");
      ((StringBuilder)localObject).append(this.jdField_e_of_type_Float);
      QLog.d("CommonSuspensionGestureLayout", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_b_of_type_Boolean)
    {
      if (a(i1, f1))
      {
        if (this.jdField_c_of_type_Boolean)
        {
          a(0, -ViewUtils.b(this.jdField_j_of_type_Int), 200, false);
          u();
          return;
        }
        a(i1, 1);
        return;
      }
      if (b(i1, f1))
      {
        c(i1);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout$ContentScrollListener.a()) {
        d(i1);
      } else {
        a(0, -ViewUtils.b(this.jdField_j_of_type_Int), 200, true);
      }
      this.jdField_i_of_type_Int = jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout$SuspensionGestureListener.a(this.jdField_i_of_type_Int);
      return;
    }
    if (c(i1, f1))
    {
      a(i1, 1);
      return;
    }
    if (d(i1, f1))
    {
      c(i1);
      return;
    }
    a(0, -ViewUtils.b(this.jdField_j_of_type_Int), 200, true);
    this.jdField_i_of_type_Int = jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout$SuspensionGestureListener.a(this.jdField_i_of_type_Int);
  }
  
  private void l()
  {
    this.jdField_c_of_type_AndroidViewView = new View(getContext());
    this.jdField_c_of_type_AndroidViewView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.jdField_c_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#66000000"));
    addView(this.jdField_c_of_type_AndroidViewView);
  }
  
  private void m()
  {
    if ((this.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_AndroidWidgetLinearLayout == null))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(getContext());
      Object localObject1 = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject1).setMargins(0, ViewUtils.b(40.0F), 0, 0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130849804);
      localObject1 = new TextView(getContext());
      Object localObject2 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject2).setMargins(ViewUtils.b(12.0F), 0, 0, 0);
      ((LinearLayout.LayoutParams)localObject2).gravity = 16;
      ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((TextView)localObject1).setTextSize(2, 14.0F);
      ((TextView)localObject1).setText("返回");
      localObject2 = new ImageView(getContext());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.setMargins(ViewUtils.b(6.0F), 0, 0, 0);
      localLayoutParams.gravity = 16;
      ((ImageView)localObject2).setLayoutParams(localLayoutParams);
      ((ImageView)localObject2).setBackgroundResource(2130849803);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
      addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new CommonSuspensionGestureLayout.10(this));
    }
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_AndroidViewAnimationAnimationSet == null)
    {
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet = ((AnimationSet)AnimationUtils.loadAnimation(getContext(), 2130772111));
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setDuration(200L);
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setInterpolator(new AccelerateDecelerateInterpolator());
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setAnimationListener(new CommonSuspensionGestureLayout.11(this));
    }
  }
  
  private void o()
  {
    this.jdField_a_of_type_AndroidViewViewGroup.addView(this, this.jdField_m_of_type_Int);
  }
  
  private void p()
  {
    this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimationSet);
  }
  
  private void q()
  {
    b(false);
  }
  
  private void r()
  {
    FrameLayout localFrameLayout = this.jdField_a_of_type_AndroidWidgetFrameLayout;
    if ((localFrameLayout != null) && (localFrameLayout.getVisibility() != 8)) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.jdField_b_of_type_AndroidViewView.setOutlineProvider(null);
      this.jdField_b_of_type_AndroidViewView.setClipToOutline(false);
    }
  }
  
  private void s()
  {
    View localView = this.jdField_f_of_type_AndroidViewView;
    if (localView != null) {
      localView.scrollTo(0, 0);
    }
    localView = this.jdField_g_of_type_AndroidViewView;
    if (localView != null) {
      localView.scrollTo(0, 0);
    }
  }
  
  private void t()
  {
    Object localObject = this.jdField_d_of_type_AndroidViewView;
    if ((localObject != null) && ((((View)localObject).getAlpha() != 1.0F) || (this.jdField_d_of_type_AndroidViewView.getVisibility() != 0)))
    {
      this.jdField_k_of_type_Boolean = false;
      localObject = this.jdField_a_of_type_AndroidAnimationObjectAnimator;
      if ((localObject != null) && (!((ObjectAnimator)localObject).isRunning()))
      {
        a();
        a(true, this.jdField_d_of_type_AndroidViewView);
      }
    }
  }
  
  private void u()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetFrameLayout;
    if ((localObject != null) && (((FrameLayout)localObject).getVisibility() != 0)) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    }
    if (!this.jdField_i_of_type_Boolean) {
      c(this.jdField_b_of_type_AndroidViewView);
    }
    this.jdField_c_of_type_Boolean = false;
    this.jdField_k_of_type_Boolean = false;
    localObject = this.jdField_d_of_type_AndroidViewView;
    if ((localObject != null) && (((View)localObject).getVisibility() != 8)) {
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.jdField_f_of_type_AndroidViewView != null)
    {
      int i1 = (FlexConvertUtils.getScreenHeight(getContext()) - ViewUtils.b(this.jdField_j_of_type_Int) - this.jdField_f_of_type_AndroidViewView.getHeight()) / 2;
      this.jdField_f_of_type_AndroidViewView.scrollTo(0, -i1);
    }
    localObject = this.jdField_g_of_type_AndroidViewView;
    if (localObject != null) {
      ((View)localObject).scrollTo(0, ViewUtils.b(this.jdField_j_of_type_Int));
    }
  }
  
  private void v()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if ((this.jdField_a_of_type_AndroidOsBundle != null) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("floating_window_business"))) {
        localJSONObject.put("Float_type", this.jdField_a_of_type_AndroidOsBundle.get("floating_window_business"));
      }
      if ((this.jdField_a_of_type_AndroidOsBundle != null) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("floating_window_scene"))) {
        localJSONObject.put("source", this.jdField_a_of_type_AndroidOsBundle.get("floating_window_scene"));
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X800A9B6", "0X800A9B6", 0, 0, "", "", "", localJSONObject.toString(), false);
  }
  
  private void w()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if ((this.jdField_a_of_type_AndroidOsBundle != null) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("floating_window_business"))) {
        localJSONObject.put("Float_type", this.jdField_a_of_type_AndroidOsBundle.get("floating_window_business"));
      }
      if ((this.jdField_a_of_type_AndroidOsBundle != null) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("floating_window_scene"))) {
        localJSONObject.put("source", this.jdField_a_of_type_AndroidOsBundle.get("floating_window_scene"));
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X800A9B7", "0X800A9B7", 0, 0, "", "", "", localJSONObject.toString(), false);
  }
  
  public int a()
  {
    return this.n;
  }
  
  public void a()
  {
    if (this.jdField_h_of_type_Boolean) {
      return;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      Object localObject = this.jdField_d_of_type_AndroidViewView;
      if ((localObject != null) && (this.jdField_j_of_type_Boolean) && ((((View)localObject).getLayoutParams() instanceof FrameLayout.LayoutParams)))
      {
        localObject = (FrameLayout.LayoutParams)this.jdField_d_of_type_AndroidViewView.getLayoutParams();
        if (((FrameLayout.LayoutParams)localObject).height != this.n + ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext()))
        {
          ((FrameLayout.LayoutParams)localObject).height = (this.n + ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext()));
          ((FrameLayout.LayoutParams)localObject).topMargin = 0;
          this.jdField_d_of_type_AndroidViewView.setPadding(0, ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext()), 0, 0);
          this.jdField_d_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_d_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(paramInt);
    a(this.jdField_d_of_type_AndroidViewView);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout$SuspensionGestureListener.a(true, paramInt1);
      return;
    }
    if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation == null) {
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = ((TranslateAnimation)AnimationUtils.loadAnimation(getContext(), 2130772015));
    }
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new CommonSuspensionGestureLayout.7(this, paramInt1, paramInt2));
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(200L);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setInterpolator(new AccelerateInterpolator());
    this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    a(false, this.jdField_c_of_type_AndroidViewView);
  }
  
  public void a(View paramView)
  {
    a(paramView, 0.0F);
  }
  
  public void a(View paramView, float paramFloat)
  {
    this.jdField_d_of_type_AndroidViewView = paramView;
    View localView = this.jdField_d_of_type_AndroidViewView;
    if ((localView != null) && ((localView.getParent() instanceof ViewGroup)) && (this.p != paramView.hashCode()))
    {
      this.p = paramView.hashCode();
      this.jdField_d_of_type_AndroidViewView.setVisibility(4);
      if (this.n != 0)
      {
        a(false);
        return;
      }
      this.n = ((int)paramFloat);
      if (this.n == 0)
      {
        this.jdField_d_of_type_AndroidViewView.post(new CommonSuspensionGestureLayout.3(this));
        return;
      }
      a(true);
    }
  }
  
  public void a(QBaseActivity paramQBaseActivity, int paramInt1, int paramInt2)
  {
    a(paramQBaseActivity, paramInt1, paramInt2, false);
  }
  
  public void a(QBaseActivity paramQBaseActivity, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramQBaseActivity;
    this.jdField_a_of_type_AndroidViewView = ((ViewGroup)paramQBaseActivity.getWindow().getDecorView()).getChildAt(0);
    if ((this.jdField_a_of_type_AndroidViewView.getParent() instanceof ViewGroup))
    {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.getParent());
      this.jdField_m_of_type_Int = this.jdField_a_of_type_AndroidViewViewGroup.indexOfChild(this.jdField_a_of_type_AndroidViewView);
      paramQBaseActivity = new FrameLayout(getContext());
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_AndroidViewView);
      paramQBaseActivity.addView(this.jdField_a_of_type_AndroidViewView);
      paramQBaseActivity.setBackgroundColor(0);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView;
      this.jdField_a_of_type_AndroidViewView = paramQBaseActivity;
      a(paramQBaseActivity);
      addView(paramQBaseActivity);
      this.jdField_a_of_type_AndroidViewView.scrollTo(0, -ViewUtils.b(this.jdField_j_of_type_Int));
      this.s = (-ViewUtils.b(this.jdField_j_of_type_Int));
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(this.jdField_l_of_type_Int);
    }
    if (!this.jdField_i_of_type_Boolean) {
      c(this.jdField_b_of_type_AndroidViewView);
    }
    if (this.jdField_b_of_type_Boolean)
    {
      int i1 = this.n;
      if (i1 != 0) {
        this.jdField_a_of_type_AndroidViewView.setPadding(0, i1, 0, 0);
      }
    }
    if (this.jdField_e_of_type_Boolean)
    {
      if (paramBoolean)
      {
        ViolaSDKManager.getInstance().postOnUiThreadDelay(new CommonSuspensionGestureLayout.5(this, paramInt1, paramInt2), 150L);
        return;
      }
      b(paramInt1, paramInt2);
      p();
      return;
    }
    b(paramInt1, paramInt2);
    paramQBaseActivity = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout$SuspensionGestureListener;
    if (paramQBaseActivity != null) {
      paramQBaseActivity.a();
    }
    v();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_AndroidViewView.getScrollY() >= 0;
  }
  
  public boolean a(float paramFloat, MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout$ContentScrollListener != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("test isAllowedInterceptTouchEvent,positionState:");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout$ContentScrollListener.a());
        localStringBuilder.append(",deltaY:");
        localStringBuilder.append(paramFloat);
        localStringBuilder.append(",event:");
        localStringBuilder.append(paramMotionEvent.getAction());
        QLog.d("CommonSuspensionGestureLayout", 2, localStringBuilder.toString());
      }
      else
      {
        QLog.d("CommonSuspensionGestureLayout", 2, "mContentScrollListener is null");
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout$ContentScrollListener != null) && (paramMotionEvent.getAction() != 0))
    {
      int i1 = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout$ContentScrollListener.a();
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout$SuspensionGestureListener.b(i1);
      if ((i1 == 1) && (paramFloat > 5.0F))
      {
        this.jdField_a_of_type_Long = 0L;
        return true;
      }
      if ((i1 == 2) && (paramFloat < 0.0F) && (this.jdField_a_of_type_JavaLangBoolean.booleanValue()))
      {
        if (this.jdField_a_of_type_Long == 0L) {
          this.jdField_a_of_type_Long = System.currentTimeMillis();
        }
        return true;
      }
      paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout$ContentScrollListener;
      if ((paramMotionEvent != null) && (!paramMotionEvent.a()) && (paramFloat < -10.0F))
      {
        this.jdField_a_of_type_Long = 0L;
        return true;
      }
      this.jdField_a_of_type_Long = 0L;
    }
    return false;
  }
  
  public void b()
  {
    a(0, 0, 100, true);
    q();
    t();
  }
  
  public void b(int paramInt)
  {
    b(this.jdField_b_of_type_AndroidViewView.findViewById(paramInt));
  }
  
  public void b(View paramView)
  {
    this.jdField_e_of_type_AndroidViewView = paramView;
    paramView = this.jdField_e_of_type_AndroidViewView;
    if ((paramView != null) && ((paramView.getParent() instanceof ViewGroup))) {
      this.jdField_e_of_type_AndroidViewView.post(new CommonSuspensionGestureLayout.4(this));
    }
  }
  
  public void b(View paramView, float paramFloat)
  {
    this.jdField_f_of_type_AndroidViewView = paramView;
    if ((this.jdField_f_of_type_AndroidViewView != null) && (this.q != paramView.hashCode()))
    {
      this.q = paramView.hashCode();
      int i1 = (int)(FlexConvertUtils.getScreenHeight(getContext()) - ViewUtils.b(this.jdField_j_of_type_Int) - paramFloat) / 2;
      this.jdField_f_of_type_AndroidViewView.scrollTo(0, -i1);
    }
  }
  
  public boolean b()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public void c()
  {
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      Object localObject = this.jdField_e_of_type_AndroidViewView;
      if (localObject != null)
      {
        int i1;
        if (((View)localObject).getVisibility() == 8) {
          i1 = 0;
        } else {
          i1 = this.jdField_e_of_type_AndroidViewView.getHeight();
        }
        int i2 = i1;
        if (!this.jdField_b_of_type_Boolean)
        {
          int i3 = this.jdField_j_of_type_Int;
          i2 = i1;
          if (i3 > 0) {
            i2 = i1 + ViewUtils.b(i3);
          }
        }
        this.jdField_b_of_type_AndroidViewView.setPadding(0, 0, 0, i2);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("heightPadding ");
        ((StringBuilder)localObject).append(i2);
        QLog.d("CommonSuspensionGestureLayout", 1, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void c(int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout$SuspensionGestureListener.a(false, paramInt);
      return;
    }
    if (this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation == null) {
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = ((TranslateAnimation)AnimationUtils.loadAnimation(getContext(), 2130772191));
    }
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new CommonSuspensionGestureLayout.8(this, paramInt));
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(200L);
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setInterpolator(new AccelerateInterpolator());
    this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation);
    a(false, this.jdField_c_of_type_AndroidViewView);
  }
  
  public void c(View paramView, float paramFloat)
  {
    this.jdField_g_of_type_AndroidViewView = paramView;
    if ((this.jdField_g_of_type_AndroidViewView != null) && (this.r != paramView.hashCode()))
    {
      this.r = paramView.hashCode();
      this.jdField_g_of_type_AndroidViewView.scrollTo(0, ViewUtils.b(this.jdField_j_of_type_Int));
    }
  }
  
  public void computeScroll()
  {
    if (this.jdField_a_of_type_AndroidWidgetScroller == null) {
      this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(this.jdField_a_of_type_AndroidContentContext);
    }
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
    {
      if (!this.jdField_b_of_type_Boolean)
      {
        if (Math.abs(this.jdField_a_of_type_AndroidWidgetScroller.getCurrY()) >= ViewUtils.b(this.jdField_j_of_type_Int)) {
          this.jdField_a_of_type_AndroidViewView.scrollTo(this.jdField_a_of_type_AndroidWidgetScroller.getCurrX(), this.jdField_a_of_type_AndroidWidgetScroller.getCurrY());
        }
      }
      else if ((this.jdField_a_of_type_AndroidViewView.getScrollY() <= 0) && (this.jdField_a_of_type_AndroidWidgetScroller.getCurrY() > 0))
      {
        this.jdField_a_of_type_AndroidViewView.scrollTo(this.jdField_a_of_type_AndroidWidgetScroller.getCurrX(), 0);
        q();
        t();
      }
      else
      {
        this.jdField_a_of_type_AndroidViewView.scrollTo(this.jdField_a_of_type_AndroidWidgetScroller.getCurrX(), this.jdField_a_of_type_AndroidWidgetScroller.getCurrY());
      }
      postInvalidate();
      return;
    }
    if ((this.jdField_a_of_type_AndroidViewView.getScrollY() == 0) && (this.jdField_i_of_type_Int != jdField_a_of_type_Int)) {
      ViolaSDKManager.getInstance().postOnUiThreadDelay(new CommonSuspensionGestureLayout.6(this), 32L);
    }
  }
  
  public void d()
  {
    e(4);
  }
  
  public boolean d()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      this.s = this.jdField_a_of_type_AndroidViewView.getScrollY();
    }
    if (this.jdField_l_of_type_Boolean) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    CommonSuspensionGestureLayout.ContentScrollListener localContentScrollListener = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout$ContentScrollListener;
    if ((localContentScrollListener != null) && (!localContentScrollListener.a()))
    {
      a(paramMotionEvent);
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (a(paramMotionEvent)) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    this.jdField_b_of_type_Float = paramMotionEvent.getRawY();
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void e()
  {
    View.OnLayoutChangeListener localOnLayoutChangeListener = this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener;
    if (localOnLayoutChangeListener != null) {
      removeOnLayoutChangeListener(localOnLayoutChangeListener);
    }
  }
  
  public void f()
  {
    this.jdField_l_of_type_Boolean = true;
    this.jdField_m_of_type_Boolean = this.jdField_b_of_type_Boolean;
    this.jdField_b_of_type_Boolean = true;
    b();
  }
  
  public void g()
  {
    this.jdField_l_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = this.jdField_m_of_type_Boolean;
    if (!this.jdField_b_of_type_Boolean)
    {
      a(0, -ViewUtils.b(this.jdField_j_of_type_Int), 200, false);
      u();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    VelocityTracker localVelocityTracker = this.jdField_a_of_type_AndroidViewVelocityTracker;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
    e();
    super.onDetachedFromWindow();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (!this.jdField_l_of_type_Boolean))
    {
      float f2 = this.jdField_d_of_type_Float;
      float f1 = 0.0F;
      if (f2 != 0.0F) {
        f1 = paramMotionEvent.getRawY() - this.jdField_d_of_type_Float;
      }
      this.jdField_e_of_type_Float = f1;
      this.jdField_c_of_type_Float = paramMotionEvent.getRawX();
      this.jdField_d_of_type_Float = paramMotionEvent.getRawY();
      return a(this.jdField_e_of_type_Float, paramMotionEvent);
    }
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (paramMotionEvent.getAction() != 0))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout$ContentScrollListener == null) {
        return false;
      }
      if ((this.jdField_a_of_type_AndroidViewView.getScrollY() < 0) && (paramMotionEvent.getRawY() <= Math.abs(this.jdField_a_of_type_AndroidViewView.getScrollY())) && (this.jdField_a_of_type_AndroidViewView.getScrollY() >= -ViewUtils.b(this.jdField_j_of_type_Int))) {
        return false;
      }
      if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
        this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
      }
      this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
      float f1;
      if (this.jdField_d_of_type_Float != 0.0F) {
        f1 = paramMotionEvent.getRawY() - this.jdField_d_of_type_Float;
      } else {
        f1 = 0.0F;
      }
      this.jdField_c_of_type_Float = paramMotionEvent.getRawX();
      this.jdField_d_of_type_Float = paramMotionEvent.getRawY();
      if (paramMotionEvent.getAction() != 2)
      {
        this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000);
        f1 = this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity(0);
        paramView = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout$ContentScrollListener;
        if ((paramView != null) && (!paramView.a()) && (this.jdField_a_of_type_AndroidViewView.getScrollY() != -ViewUtils.b(this.jdField_j_of_type_Int)) && (f1 < 0.0F))
        {
          a(0, -ViewUtils.b(this.jdField_j_of_type_Int), 200, false);
          return true;
        }
        if (this.jdField_b_of_type_Boolean)
        {
          if (paramMotionEvent.getRawY() >= Math.abs(this.jdField_a_of_type_AndroidViewView.getScrollY()) + Math.abs(this.jdField_a_of_type_AndroidViewView.getPaddingTop()))
          {
            k();
            return true;
          }
          if (this.jdField_a_of_type_AndroidViewView.getScrollY() != 0)
          {
            a(0, 2);
            return true;
          }
        }
        else
        {
          k();
        }
        return true;
      }
      int i1 = (int)(this.jdField_a_of_type_AndroidViewView.getScrollY() - f1);
      if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout$ContentScrollListener.a())
      {
        a(0, i1, 0, false);
        return true;
      }
      if (i1 <= this.s) {
        a(0, i1, 0, false);
      }
      return true;
    }
    return false;
  }
  
  public void setBorderRadius(int paramInt)
  {
    this.jdField_k_of_type_Int = paramInt;
  }
  
  public void setCanCloseFromBottom(boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(paramBoolean);
  }
  
  public void setContainerColor(int paramInt)
  {
    this.jdField_l_of_type_Int = paramInt;
  }
  
  public void setContentMarginTop(int paramInt)
  {
    this.jdField_j_of_type_Int = paramInt;
  }
  
  public void setContentScrollListener(CommonSuspensionGestureLayout.ContentScrollListener paramContentScrollListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout$ContentScrollListener = paramContentScrollListener;
  }
  
  public void setIsAutoSuctionTop(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setIsNeedChangeTitleAlpha(boolean paramBoolean)
  {
    this.jdField_h_of_type_Boolean = paramBoolean;
  }
  
  public void setIsNeedGrayBarFloat(boolean paramBoolean)
  {
    this.jdField_i_of_type_Boolean = paramBoolean;
  }
  
  public void setIsNeedInterruptBack(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = paramBoolean;
  }
  
  public void setIsNeedPopAnim(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public void setIsNeedShowBackView(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
    if (!this.jdField_f_of_type_Boolean)
    {
      LinearLayout localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      if (localLinearLayout != null) {
        localLinearLayout.setVisibility(8);
      }
    }
    else
    {
      m();
    }
  }
  
  public void setIsShowGrayBar(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void setIsStatusImmersive(boolean paramBoolean)
  {
    this.jdField_j_of_type_Boolean = paramBoolean;
  }
  
  public void setIsUseDefaultAnim(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setMaskBackGroundDrawable(Drawable paramDrawable)
  {
    Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
    if ((localActivity != null) && (localActivity.getWindow() != null)) {
      this.jdField_a_of_type_AndroidAppActivity.getWindow().setBackgroundDrawable(paramDrawable);
    }
  }
  
  public void setTitleBarHeight(int paramInt)
  {
    this.n = ViewUtils.b(paramInt);
  }
  
  public void setViolaGestureListener(CommonSuspensionGestureLayout.SuspensionGestureListener paramSuspensionGestureListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout$SuspensionGestureListener = paramSuspensionGestureListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.CommonSuspensionGestureLayout
 * JD-Core Version:    0.7.0.1
 */