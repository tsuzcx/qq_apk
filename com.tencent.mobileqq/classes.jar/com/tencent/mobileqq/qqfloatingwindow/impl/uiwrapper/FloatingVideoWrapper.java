package com.tencent.mobileqq.qqfloatingwindow.impl.uiwrapper;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqfloatingwindow.FloatingBaseProxyWrapper;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenReporter;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow;
import com.tencent.mobileqq.qqfloatingwindow.impl.FloatingScreenUtils;
import com.tencent.mobileqq.qqfloatingwindow.listener.IContainerBackPressListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IFullScreenEnterListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IFullScreenViewClickListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IWindowClickListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.BaseSharedPreUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LiuHaiUtils;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.os.MqqHandler;

public class FloatingVideoWrapper
  extends FloatingBaseProxyWrapper
  implements SeekBar.OnSeekBarChangeListener, IContainerBackPressListener, IVideoOuterStatusListener
{
  public static final String CLASS_NAME = "com.tencent.mobileqq.qqfloatingwindow.impl.uiwrapper.FloatingVideoWrapper";
  public static final String TAG = "FloatingVideoWrapper";
  private int jdField_a_of_type_Int = 0;
  private ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private IFullScreenEnterListener jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIFullScreenEnterListener;
  private IVideoInnerStatusListener jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIVideoInnerStatusListener;
  private Runnable jdField_a_of_type_JavaLangRunnable = new FloatingVideoWrapper.12(this);
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder;
  private Formatter jdField_a_of_type_JavaUtilFormatter;
  private List<View> jdField_a_of_type_JavaUtilList;
  private int jdField_b_of_type_Int = 0;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private int jdField_c_of_type_Int = -1;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private int jdField_d_of_type_Int = -1;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private int jdField_e_of_type_Int = -1;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private int jdField_f_of_type_Int = 0;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private int g = 0;
  private int h = 0;
  private int i = 0;
  private int j = 0;
  public IFullScreenViewClickListener mFullScreenViewClickListener;
  
  public FloatingVideoWrapper(Context paramContext)
  {
    super(paramContext);
  }
  
  private String a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilFormatter == null)
    {
      this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
      this.jdField_a_of_type_JavaUtilFormatter = new Formatter(this.jdField_a_of_type_JavaLangStringBuilder, Locale.getDefault());
    }
    this.g = ((int)(paramLong / 1000L));
    int k = this.g;
    this.h = (k % 60);
    this.i = (k / 60 % 60);
    this.j = (k / 3600);
    this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
    k = this.j;
    if (k > 0) {
      return this.jdField_a_of_type_JavaUtilFormatter.format("%d:%02d:%02d", new Object[] { Integer.valueOf(k), Integer.valueOf(this.i), Integer.valueOf(this.h) }).toString();
    }
    return this.jdField_a_of_type_JavaUtilFormatter.format("%02d:%02d", new Object[] { Integer.valueOf(this.i), Integer.valueOf(this.h) }).toString();
  }
  
  private void a(Bitmap paramBitmap)
  {
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if ((localImageView != null) && (paramBitmap != null))
    {
      localImageView.setImageBitmap(paramBitmap);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 401) || (paramInt == 402) || (paramInt == 403);
  }
  
  private void b(Drawable paramDrawable)
  {
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if ((localImageView != null) && (paramDrawable != null))
    {
      localImageView.setImageDrawable(paramDrawable);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0) {
      this.jdField_d_of_type_Int = paramInt1;
    }
    if (paramInt2 > 0) {
      this.jdField_e_of_type_Int = paramInt2;
    }
    if (d()) {
      a(b() ^ true, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, false);
    }
  }
  
  private void e(int paramInt)
  {
    a(false, new View[] { this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_d_of_type_AndroidWidgetImageView, this.jdField_c_of_type_AndroidWidgetTextView, this.jdField_e_of_type_AndroidWidgetImageView });
    a(true, new View[] { this.jdField_b_of_type_AndroidWidgetTextView });
    b(true, new View[] { this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetSeekBar });
    g();
    this.jdField_c_of_type_Int = 0;
    t();
    if (paramInt > 0)
    {
      if (this.jdField_b_of_type_Int == paramInt) {
        return;
      }
      this.jdField_b_of_type_Int = paramInt;
      TextView localTextView = this.jdField_f_of_type_AndroidWidgetTextView;
      if (localTextView != null) {
        localTextView.setText(a(this.jdField_b_of_type_Int));
      }
    }
  }
  
  private void f(int paramInt)
  {
    int k;
    if (paramInt < 0)
    {
      k = 0;
    }
    else
    {
      int m = this.jdField_b_of_type_Int;
      k = paramInt;
      if (paramInt > m) {
        k = m;
      }
    }
    double d1 = k;
    Double.isNaN(d1);
    double d2 = this.jdField_b_of_type_Int;
    Double.isNaN(d2);
    this.jdField_a_of_type_Int = ((int)(d1 * 100.0D / d2));
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(this.jdField_a_of_type_Int);
    this.jdField_e_of_type_AndroidWidgetTextView.setText(a(k));
  }
  
  private void f(boolean paramBoolean)
  {
    a(true, new View[] { this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_d_of_type_AndroidWidgetImageView });
    a(false, new View[] { this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_c_of_type_AndroidWidgetTextView, this.jdField_e_of_type_AndroidWidgetImageView });
    a(paramBoolean, new View[] { this.jdField_a_of_type_AndroidWidgetImageView });
    b(true, new View[] { this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView });
    b(false, new View[] { this.jdField_a_of_type_AndroidWidgetSeekBar });
    this.jdField_e_of_type_AndroidWidgetTextView.setText(a(this.jdField_b_of_type_Int));
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(100);
    this.jdField_c_of_type_Int = 1;
    t();
  }
  
  private static boolean f()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }
  
  private void g(int paramInt)
  {
    s();
    if (!a()) {
      h(c());
    }
    a(false, new View[] { this.jdField_d_of_type_AndroidWidgetImageView });
    a(true, new View[] { this.jdField_c_of_type_AndroidWidgetTextView });
    if (paramInt != 400)
    {
      localObject = a();
      if (localObject != null) {
        c(((Context)localObject).getResources().getColor(2131167004));
      }
    }
    if (this.jdField_e_of_type_AndroidWidgetImageView != null) {
      if (a(paramInt))
      {
        this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130846472);
        this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      else
      {
        this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    Object localObject = this.jdField_c_of_type_AndroidWidgetTextView;
    if (localObject != null)
    {
      if (paramInt == 400)
      {
        ((TextView)localObject).setText(2131699800);
        return;
      }
      if (paramInt == 401)
      {
        ((TextView)localObject).setText(2131699801);
        return;
      }
      if (paramInt == 402)
      {
        ((TextView)localObject).setText(2131699803);
        return;
      }
      if (paramInt == 403)
      {
        ((TextView)localObject).setText(2131699802);
        return;
      }
      ((TextView)localObject).setText(2131699801);
    }
  }
  
  private void g(boolean paramBoolean)
  {
    Object localObject1 = a();
    if (localObject1 == null) {
      return;
    }
    localObject1 = ((Context)localObject1).getResources();
    Object localObject2 = this.jdField_d_of_type_AndroidWidgetImageView;
    int n = -2;
    if (localObject2 != null)
    {
      localObject2 = ((ImageView)localObject2).getLayoutParams();
      if (paramBoolean)
      {
        ((ViewGroup.LayoutParams)localObject2).width = -2;
        ((ViewGroup.LayoutParams)localObject2).height = -2;
        this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130838000);
      }
      else
      {
        ((ViewGroup.LayoutParams)localObject2).width = -1;
        ((ViewGroup.LayoutParams)localObject2).height = -1;
        this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130846473);
      }
      this.jdField_d_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    localObject2 = this.jdField_e_of_type_AndroidWidgetImageView;
    if (localObject2 != null)
    {
      localObject2 = (LinearLayout.LayoutParams)((ImageView)localObject2).getLayoutParams();
      int m;
      if (paramBoolean)
      {
        k = 32;
        m = n;
        if (localObject1 != null)
        {
          k = FloatingScreenUtils.a(16.0F, (Resources)localObject1);
          m = n;
        }
      }
      else
      {
        m = 40;
        k = 16;
        if (localObject1 != null)
        {
          m = FloatingScreenUtils.a(20.0F, (Resources)localObject1);
          k = FloatingScreenUtils.a(8.0F, (Resources)localObject1);
        }
      }
      ((LinearLayout.LayoutParams)localObject2).width = m;
      ((LinearLayout.LayoutParams)localObject2).height = m;
      ((LinearLayout.LayoutParams)localObject2).setMargins(0, 0, 0, k);
      this.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    localObject2 = this.jdField_c_of_type_AndroidWidgetTextView;
    if (localObject2 != null) {
      if (paramBoolean) {
        ((TextView)localObject2).setTextSize(17.0F);
      } else {
        ((TextView)localObject2).setTextSize(12.0F);
      }
    }
    int k = this.jdField_c_of_type_Int;
    if ((k != 2) && (k != 3))
    {
      if ((Build.VERSION.SDK_INT >= 23) && (paramBoolean))
      {
        d(2130846474);
        return;
      }
      if (localObject1 != null) {
        c(((Resources)localObject1).getColor(2131167333));
      }
    }
    else if (localObject1 != null)
    {
      c(((Resources)localObject1).getColor(2131167004));
    }
  }
  
  private void h(int paramInt)
  {
    float f1 = 1.0F;
    float f2 = 0.0F;
    if (paramInt == 0)
    {
      f1 = 0.0F;
      f2 = 1.0F;
    }
    else if (paramInt != 1)
    {
      return;
    }
    View localView = a();
    if (localView != null)
    {
      this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(localView, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("alpha", new float[] { f1, f2 }) });
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.addUpdateListener(new FloatingVideoWrapper.13(this, f1, f2, localView));
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.addListener(new FloatingVideoWrapper.14(this, paramInt, localView));
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.setDuration(300L).start();
    }
  }
  
  private void h(boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      if (localView != null) {
        if (paramBoolean) {
          localView.setVisibility(0);
        } else {
          localView.setVisibility(4);
        }
      }
    }
  }
  
  private void i(boolean paramBoolean)
  {
    d(paramBoolean);
    e(paramBoolean);
    Context localContext = a();
    if (localContext != null)
    {
      if (localContext.getResources() == null) {
        return;
      }
      if (paramBoolean)
      {
        a(localContext.getResources().getDrawable(2130846468));
        return;
      }
      a(localContext.getResources().getDrawable(2130846467));
    }
  }
  
  private void l()
  {
    Object localObject = a();
    if ((localObject != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (FloatingScreenUtils.b((Context)localObject)))
    {
      int k = FloatingScreenUtils.a((Context)localObject);
      int m = FloatingScreenUtils.b((Context)localObject);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("screenRealHeight = ");
        localStringBuilder.append(k);
        localStringBuilder.append(" screenPureHeight = ");
        localStringBuilder.append(m);
        QLog.d("FloatingVideoWrapper", 2, localStringBuilder.toString());
      }
      if (k > 0)
      {
        if (m <= 0) {
          return;
        }
        k = Math.min(Math.max(k - m, 0), 100);
        m = FloatingScreenUtils.a(16.0F, ((Context)localObject).getResources());
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = (m + k);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  private void m()
  {
    a(true, new View[] { this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_d_of_type_AndroidWidgetImageView });
    a(false, new View[] { this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_c_of_type_AndroidWidgetTextView, this.jdField_e_of_type_AndroidWidgetImageView });
    b(true, new View[] { this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetSeekBar });
    this.jdField_c_of_type_Int = 1;
    t();
  }
  
  private void n()
  {
    g(400);
    b(true, new View[] { this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetSeekBar });
    this.jdField_c_of_type_Int = 3;
  }
  
  private void o()
  {
    g(401);
    b(false, new View[] { this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetSeekBar });
    this.jdField_c_of_type_Int = 2;
  }
  
  private void p()
  {
    if (!a())
    {
      if (!d()) {
        return;
      }
      if (b())
      {
        if ((e()) || (!a(b(), c())))
        {
          IFullScreenEnterListener localIFullScreenEnterListener = this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIFullScreenEnterListener;
          if (localIFullScreenEnterListener != null) {
            localIFullScreenEnterListener.onEnter(b(), c());
          } else {
            q();
          }
        }
        FloatingScreenReporter.e();
        return;
      }
      if (c()) {
        u();
      }
    }
  }
  
  private void q()
  {
    if (!a())
    {
      if (!b()) {
        return;
      }
      a(true, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, true);
      h();
      h(true);
      g(true);
      a(false, new View[] { this.jdField_d_of_type_AndroidWidgetTextView });
      b(false);
    }
    s();
    i(false);
    t();
  }
  
  private void r()
  {
    if (!a())
    {
      if (!c()) {
        return;
      }
      a(false, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, false);
      i();
      h(false);
      g(false);
      b(true);
    }
    IFullScreenViewClickListener localIFullScreenViewClickListener = this.mFullScreenViewClickListener;
    if (localIFullScreenViewClickListener != null) {
      localIFullScreenViewClickListener.a();
    }
    this.jdField_a_of_type_AndroidAnimationObjectAnimator = null;
    i(true);
    t();
  }
  
  private void s()
  {
    j();
    b(1.0F);
    this.jdField_f_of_type_Int = 0;
  }
  
  private void t()
  {
    if (a()) {
      return;
    }
    Context localContext = a();
    if (localContext == null) {
      return;
    }
    if (b())
    {
      if (this.jdField_c_of_type_Int == 1)
      {
        b(localContext.getResources().getString(2131699796));
        return;
      }
      b(localContext.getResources().getString(2131699786));
      return;
    }
    int k = this.jdField_f_of_type_Int;
    if (k == 0)
    {
      b(localContext.getResources().getString(2131699805));
      return;
    }
    if (k == 1) {
      b(localContext.getResources().getString(2131699787));
    }
  }
  
  private void u()
  {
    int k = this.jdField_f_of_type_Int;
    if (k != 0)
    {
      if (k != 1) {
        return;
      }
      h(0);
      return;
    }
    k = this.jdField_c_of_type_Int;
    if ((k == 0) || (k == 1)) {
      h(1);
    }
  }
  
  private void v()
  {
    onVideoStart(this.jdField_b_of_type_Int);
    IVideoInnerStatusListener localIVideoInnerStatusListener = this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIVideoInnerStatusListener;
    if (localIVideoInnerStatusListener != null) {
      localIVideoInnerStatusListener.notifyVideoStart();
    }
  }
  
  private void w()
  {
    onVideoStop();
    IVideoInnerStatusListener localIVideoInnerStatusListener = this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIVideoInnerStatusListener;
    if (localIVideoInnerStatusListener != null) {
      localIVideoInnerStatusListener.notifyVideoStop();
    }
  }
  
  public int a(FloatingScreenParams paramFloatingScreenParams, View paramView)
  {
    int k = super.a(paramFloatingScreenParams, paramView);
    paramView = this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIVideoInnerStatusListener;
    if (paramView != null)
    {
      paramView.notifyVideoClose(6);
      this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIVideoInnerStatusListener = null;
    }
    else
    {
      FloatingScreenReporter.a();
      if ((k == 0) && (paramFloatingScreenParams != null) && (paramFloatingScreenParams.getCanZoom())) {
        k();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIFullScreenEnterListener = null;
    this.jdField_b_of_type_Int = 0;
    return k;
  }
  
  public IVideoOuterStatusListener a(IVideoInnerStatusListener paramIVideoInnerStatusListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIVideoInnerStatusListener = paramIVideoInnerStatusListener;
    return this;
  }
  
  public void a()
  {
    b(3);
    FloatingScreenReporter.g();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    b(paramInt1, paramInt2);
  }
  
  public void a(Context paramContext)
  {
    super.a(paramContext);
    a(this);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(paramContext);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setId(2131374415);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_a_of_type_AndroidWidgetImageView.setId(2131374400);
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131374405));
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(paramContext.getResources().getString(2131699785));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)a(2131374403));
    this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(paramContext.getResources().getString(2131699784));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131374411));
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramContext.getResources().getString(2131699797));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131374410));
    this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(paramContext.getResources().getString(2131699789));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131374408));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)a(2131374406));
    this.jdField_d_of_type_AndroidWidgetImageView.setContentDescription(paramContext.getResources().getString(2131699796));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)a(2131374412));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)a(2131374407));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)a(2131374414));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)a(2131374413));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)a(2131374404));
    this.jdField_d_of_type_AndroidWidgetTextView.setShadowLayer(3.0F, 1.0F, 1.0F, -16777216);
    a(this, new View[] { this.jdField_b_of_type_AndroidWidgetImageView, this.jdField_c_of_type_AndroidWidgetImageView, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_d_of_type_AndroidWidgetImageView });
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)a(2131374417));
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setThumb(paramContext.getResources().getDrawable(2130850094));
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgressDrawable(paramContext.getResources().getDrawable(2130846221));
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList(4);
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    this.jdField_a_of_type_JavaUtilList.add(this.jdField_b_of_type_AndroidWidgetImageView);
    this.jdField_a_of_type_JavaUtilList.add(this.jdField_c_of_type_AndroidWidgetImageView);
    if (LiuHaiUtils.b())
    {
      RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams1.addRule(10, -1);
      RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams2.addRule(10, -1);
      int k = LiuHaiUtils.jdField_a_of_type_Int - FloatingScreenUtils.a(12.0F, paramContext.getResources());
      localLayoutParams1.topMargin = k;
      localLayoutParams2.topMargin = k;
    }
    l();
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
    b(paramView);
    paramView.setId(2131374418);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(paramView, new FrameLayout.LayoutParams(-1, -1));
    b(this.jdField_a_of_type_AndroidWidgetImageView);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, new FrameLayout.LayoutParams(-1, -1));
    f();
    b(this.jdField_a_of_type_AndroidWidgetFrameLayout);
    a(this.jdField_a_of_type_AndroidWidgetFrameLayout, new FrameLayout.LayoutParams(-1, -1));
    e();
    a(new FrameLayout.LayoutParams(-1, -1));
  }
  
  public void a(IFullScreenEnterListener paramIFullScreenEnterListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIFullScreenEnterListener = paramIFullScreenEnterListener;
  }
  
  public void a(IFullScreenViewClickListener paramIFullScreenViewClickListener)
  {
    this.mFullScreenViewClickListener = paramIFullScreenViewClickListener;
  }
  
  public void a(IWindowClickListener paramIWindowClickListener)
  {
    super.a(paramIWindowClickListener);
  }
  
  public void aT_()
  {
    a(true, new View[] { this.jdField_b_of_type_AndroidWidgetTextView });
    a(true);
    b(true);
    a(false, new View[] { this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_c_of_type_AndroidWidgetTextView, this.jdField_e_of_type_AndroidWidgetImageView, this.jdField_d_of_type_AndroidWidgetImageView, this.jdField_a_of_type_AndroidWidgetImageView });
    b(true, new View[] { this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetSeekBar });
    s();
    g(false);
    h(false);
    t();
  }
  
  public void b(int paramInt)
  {
    if ((!a()) && (b())) {
      ((IQQFloatingWindow)QRoute.api(IQQFloatingWindow.class)).saveFloatingCenter(b(), c());
    }
    IVideoInnerStatusListener localIVideoInnerStatusListener = this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIVideoInnerStatusListener;
    if (localIVideoInnerStatusListener != null)
    {
      localIVideoInnerStatusListener.notifyVideoClose(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIVideoInnerStatusListener = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIFullScreenEnterListener = null;
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    super.b(paramInt);
  }
  
  public void c()
  {
    a(0, new FloatingVideoWrapper.1(this));
  }
  
  public void k()
  {
    Context localContext = a();
    if (localContext == null) {
      return;
    }
    if (!((Boolean)BaseSharedPreUtil.a(localContext, "", "key_float_video_has_show_tips", Boolean.valueOf(false))).booleanValue())
    {
      a(true, new View[] { this.jdField_d_of_type_AndroidWidgetTextView });
      BaseSharedPreUtil.a(localContext, "", true, "key_float_video_has_show_tips", Boolean.valueOf(true));
      ThreadManager.getUIHandler().postDelayed(new FloatingVideoWrapper.2(this), 3000L);
    }
  }
  
  public void onClick(View paramView)
  {
    int k = paramView.getId();
    if (k == 2131374402)
    {
      b(1);
      FloatingScreenReporter.d();
    }
    else if (k == 2131374403)
    {
      b(2);
      FloatingScreenReporter.k();
    }
    else if (k == 2131374405)
    {
      r();
      FloatingScreenReporter.f();
    }
    else if (k == 2131374411)
    {
      v();
      FloatingScreenReporter.h();
    }
    else if (k == 2131374410)
    {
      w();
      FloatingScreenReporter.h();
    }
    else if (k == 2131374406)
    {
      v();
    }
    else if (k == 2131374409)
    {
      p();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onOrientationChange(boolean paramBoolean)
  {
    c(paramBoolean);
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt;
    paramSeekBar = this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIVideoInnerStatusListener;
    if ((paramSeekBar != null) && (paramBoolean))
    {
      paramSeekBar.notifyVideoSeek(this.jdField_a_of_type_Int);
      double d1 = this.jdField_a_of_type_Int;
      double d2 = this.jdField_b_of_type_Int;
      Double.isNaN(d1);
      Double.isNaN(d2);
      onVideoProgressUpdate((int)(d1 * d2 / 100.0D));
    }
  }
  
  public void onSetVideoCover(Bitmap paramBitmap)
  {
    if (f())
    {
      a(paramBitmap);
      return;
    }
    ThreadManager.getUIHandler().post(new FloatingVideoWrapper.11(this, paramBitmap));
  }
  
  public void onSetVideoCover(Drawable paramDrawable)
  {
    if (f())
    {
      b(paramDrawable);
      return;
    }
    ThreadManager.getUIHandler().post(new FloatingVideoWrapper.10(this, paramDrawable));
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onVideoBuffering()
  {
    if (f())
    {
      n();
      return;
    }
    ThreadManager.getUIHandler().post(new FloatingVideoWrapper.7(this));
  }
  
  public void onVideoComplete(boolean paramBoolean)
  {
    if (b()) {
      FloatingScreenReporter.i();
    } else {
      FloatingScreenReporter.j();
    }
    if (f())
    {
      f(paramBoolean);
      return;
    }
    ThreadManager.getUIHandler().post(new FloatingVideoWrapper.5(this, paramBoolean));
  }
  
  public void onVideoError(int paramInt)
  {
    if (f())
    {
      o();
      return;
    }
    ThreadManager.getUIHandler().post(new FloatingVideoWrapper.8(this));
  }
  
  public void onVideoProgressUpdate(int paramInt)
  {
    if (this.jdField_b_of_type_Int == 0) {
      return;
    }
    if (f())
    {
      f(paramInt);
      return;
    }
    ThreadManager.getUIHandler().post(new FloatingVideoWrapper.6(this, paramInt));
  }
  
  public void onVideoSize(int paramInt1, int paramInt2)
  {
    if (f())
    {
      c(paramInt1, paramInt2);
      return;
    }
    ThreadManager.getUIHandler().post(new FloatingVideoWrapper.9(this, paramInt1, paramInt2));
  }
  
  public void onVideoStart(int paramInt)
  {
    if (this.jdField_b_of_type_Int != paramInt) {
      FloatingScreenReporter.c(paramInt);
    }
    if (f()) {
      e(paramInt);
    } else {
      ThreadManager.getUIHandler().post(new FloatingVideoWrapper.3(this, paramInt));
    }
    ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 300L);
  }
  
  public void onVideoStop()
  {
    if (f())
    {
      m();
      return;
    }
    ThreadManager.getUIHandler().post(new FloatingVideoWrapper.4(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqfloatingwindow.impl.uiwrapper.FloatingVideoWrapper
 * JD-Core Version:    0.7.0.1
 */