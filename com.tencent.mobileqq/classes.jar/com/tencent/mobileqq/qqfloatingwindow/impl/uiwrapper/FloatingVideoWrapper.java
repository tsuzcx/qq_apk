package com.tencent.mobileqq.qqfloatingwindow.impl.uiwrapper;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow;
import com.tencent.mobileqq.qqfloatingwindow.impl.FloatingOutlineProvider;
import com.tencent.mobileqq.qqfloatingwindow.impl.FloatingScreenContainer;
import com.tencent.mobileqq.qqfloatingwindow.impl.FloatingScreenContainer.OnBackPressListener;
import com.tencent.mobileqq.qqfloatingwindow.impl.FloatingScreenReporter;
import com.tencent.mobileqq.qqfloatingwindow.impl.FloatingScreenStatusReceiver;
import com.tencent.mobileqq.qqfloatingwindow.impl.FloatingScreenUtils;
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
  extends FloatingBaseWrapper
  implements SeekBar.OnSeekBarChangeListener, FloatingScreenContainer.OnBackPressListener, IVideoOuterStatusListener
{
  public static final String CLASS_NAME = FloatingVideoWrapper.class.getName();
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
  private Runnable jdField_a_of_type_JavaLangRunnable = new FloatingVideoWrapper.3(this);
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
    this.h = (this.g % 60);
    this.i = (this.g / 60 % 60);
    this.j = (this.g / 3600);
    this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
    if (this.j > 0) {
      return this.jdField_a_of_type_JavaUtilFormatter.format("%d:%02d:%02d", new Object[] { Integer.valueOf(this.j), Integer.valueOf(this.i), Integer.valueOf(this.h) }).toString();
    }
    return this.jdField_a_of_type_JavaUtilFormatter.format("%02d:%02d", new Object[] { Integer.valueOf(this.i), Integer.valueOf(this.h) }).toString();
  }
  
  private void a(boolean paramBoolean)
  {
    int n = -2;
    if (this.mContext == null) {}
    Resources localResources;
    label64:
    label118:
    do
    {
      for (;;)
      {
        return;
        localResources = this.mContext.getResources();
        Object localObject;
        int k;
        int m;
        if (this.jdField_d_of_type_AndroidWidgetImageView != null)
        {
          localObject = this.jdField_d_of_type_AndroidWidgetImageView.getLayoutParams();
          if (paramBoolean)
          {
            ((ViewGroup.LayoutParams)localObject).width = -2;
            ((ViewGroup.LayoutParams)localObject).height = -2;
            this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130838159);
            this.jdField_d_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
        }
        else
        {
          if (this.jdField_e_of_type_AndroidWidgetImageView != null)
          {
            localObject = (LinearLayout.LayoutParams)this.jdField_e_of_type_AndroidWidgetImageView.getLayoutParams();
            if (!paramBoolean) {
              break label235;
            }
            k = 32;
            m = n;
            if (localResources != null)
            {
              k = FloatingScreenUtils.a(16.0F, localResources);
              m = n;
            }
            ((LinearLayout.LayoutParams)localObject).width = m;
            ((LinearLayout.LayoutParams)localObject).height = m;
            ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, 0, k);
            this.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
          if (this.jdField_c_of_type_AndroidWidgetTextView != null)
          {
            if (!paramBoolean) {
              break label265;
            }
            this.jdField_c_of_type_AndroidWidgetTextView.setTextSize(17.0F);
          }
        }
        for (;;)
        {
          if (this.mRootLayout == null) {
            break label275;
          }
          if ((this.jdField_c_of_type_Int != 2) && (this.jdField_c_of_type_Int != 3)) {
            break label277;
          }
          if (localResources == null) {
            break;
          }
          this.mRootLayout.setBackgroundColor(localResources.getColor(2131166982));
          return;
          ((ViewGroup.LayoutParams)localObject).width = -1;
          ((ViewGroup.LayoutParams)localObject).height = -1;
          this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130846593);
          break label64;
          m = 40;
          k = 16;
          if (localResources == null) {
            break label118;
          }
          m = FloatingScreenUtils.a(20.0F, localResources);
          k = FloatingScreenUtils.a(8.0F, localResources);
          break label118;
          this.jdField_c_of_type_AndroidWidgetTextView.setTextSize(12.0F);
        }
      }
      if ((Build.VERSION.SDK_INT >= 23) && (paramBoolean))
      {
        this.mRootLayout.setBackgroundResource(2130846594);
        return;
      }
    } while (localResources == null);
    label235:
    this.mRootLayout.setBackgroundColor(localResources.getColor(2131167305));
    label265:
    label275:
    label277:
    return;
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 401) || (paramInt == 402) || (paramInt == 403);
  }
  
  private void b(boolean paramBoolean)
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
  
  private void c(int paramInt)
  {
    i();
    if (this.mFloatingContainer != null) {
      b(this.mFloatingContainer.c());
    }
    a(false, new View[] { this.jdField_d_of_type_AndroidWidgetImageView });
    a(true, new View[] { this.jdField_c_of_type_AndroidWidgetTextView });
    if ((this.mRootLayout != null) && (paramInt != 400)) {
      this.mRootLayout.setBackgroundColor(this.mContext.getResources().getColor(2131166982));
    }
    if (this.jdField_e_of_type_AndroidWidgetImageView != null)
    {
      if (!a(paramInt)) {
        break label145;
      }
      this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130846592);
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      if (this.jdField_c_of_type_AndroidWidgetTextView != null)
      {
        if (paramInt != 400) {
          break;
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131699668);
      }
      return;
      label145:
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (paramInt == 401)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131699669);
      return;
    }
    if (paramInt == 402)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131699671);
      return;
    }
    if (paramInt == 403)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131699670);
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText(2131699669);
  }
  
  private void c(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (this.mFloatingContainer != null) {
        this.mFloatingContainer.setClipToOutline(paramBoolean);
      }
      if ((this.mFloatingWidgetWrapper != null) && (this.mContext != null) && (this.mContext.getResources() != null))
      {
        this.mFloatingWidgetWrapper.setClipToOutline(paramBoolean);
        if (!paramBoolean) {
          break label80;
        }
        this.mFloatingWidgetWrapper.setBackground(this.mContext.getResources().getDrawable(2130846588));
      }
    }
    return;
    label80:
    this.mFloatingWidgetWrapper.setBackground(this.mContext.getResources().getDrawable(2130846587));
  }
  
  private void d(int paramInt)
  {
    float f1 = 1.0F;
    float f2 = 0.0F;
    if (paramInt == 0) {}
    for (;;)
    {
      if (this.mRootLayout != null)
      {
        PropertyValuesHolder localPropertyValuesHolder = PropertyValuesHolder.ofFloat("alpha", new float[] { f2, f1 });
        this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(this.mRootLayout, new PropertyValuesHolder[] { localPropertyValuesHolder });
        this.jdField_a_of_type_AndroidAnimationObjectAnimator.addUpdateListener(new FloatingVideoWrapper.4(this, f2, f1));
        this.jdField_a_of_type_AndroidAnimationObjectAnimator.addListener(new FloatingVideoWrapper.5(this, paramInt));
        this.jdField_a_of_type_AndroidAnimationObjectAnimator.setDuration(300L).start();
      }
      do
      {
        return;
      } while (paramInt != 1);
      f2 = 1.0F;
      f1 = 0.0F;
    }
  }
  
  private void e()
  {
    if ((this.mContext != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (FloatingScreenUtils.b(this.mContext)))
    {
      k = FloatingScreenUtils.a(this.mContext);
      m = FloatingScreenUtils.b(this.mContext);
      if (QLog.isColorLevel()) {
        QLog.d("FloatingVideoWrapper", 2, "screenRealHeight = " + k + " screenPureHeight = " + m);
      }
      if ((k > 0) && (m > 0)) {}
    }
    else
    {
      return;
    }
    int k = Math.min(Math.max(k - m, 0), 100);
    int m = FloatingScreenUtils.a(16.0F, this.mContext.getResources());
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    localLayoutParams.bottomMargin = (m + k);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
  }
  
  private void f()
  {
    if ((this.mFloatingContainer == null) || (!this.mFloatingContainer.a())) {}
    label95:
    do
    {
      return;
      if (this.mFloatingContainer.b())
      {
        if ((this.mWindowClickListener == null) || (!this.mWindowClickListener.a(this.mFloatingContainer.a(), this.mFloatingContainer.b())))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIFullScreenEnterListener == null) {
            break label95;
          }
          this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIFullScreenEnterListener.onEnter(this.mFloatingContainer.a(), this.mFloatingContainer.b());
        }
        for (;;)
        {
          FloatingScreenReporter.e();
          return;
          g();
        }
      }
    } while (!this.mFloatingContainer.c());
    k();
  }
  
  private void g()
  {
    if (this.mFloatingContainer != null)
    {
      if (!this.mFloatingContainer.b()) {
        return;
      }
      this.mFloatingContainer.a(true, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, true);
      this.mFloatingContainer.f();
      b(true);
      a(true);
      a(false, new View[] { this.mFloatingCloseBtn, this.jdField_d_of_type_AndroidWidgetTextView });
    }
    i();
    c(false);
    j();
  }
  
  private void h()
  {
    if (this.mFloatingContainer != null)
    {
      if (!this.mFloatingContainer.c()) {
        return;
      }
      this.mFloatingContainer.a(false, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, false);
      this.mFloatingContainer.g();
      b(false);
      a(false);
      a(true, new View[] { this.mFloatingCloseBtn });
    }
    if (this.mFullScreenViewClickListener != null) {
      this.mFullScreenViewClickListener.a();
    }
    this.jdField_a_of_type_AndroidAnimationObjectAnimator = null;
    c(true);
    j();
  }
  
  private void i()
  {
    if (this.mRootLayout != null)
    {
      if (this.mRootLayout.getVisibility() != 0) {
        this.mRootLayout.setVisibility(0);
      }
      if (this.mRootLayout.getAlpha() != 1.0F) {
        this.mRootLayout.setAlpha(1.0F);
      }
    }
    this.jdField_f_of_type_Int = 0;
  }
  
  private void j()
  {
    if (this.mFloatingContainer == null) {}
    do
    {
      return;
      if (this.mFloatingContainer.b())
      {
        if (this.jdField_c_of_type_Int == 1)
        {
          this.mRootLayout.setContentDescription(this.mContext.getResources().getString(2131699664));
          return;
        }
        this.mRootLayout.setContentDescription(this.mContext.getResources().getString(2131699656));
        return;
      }
      if (this.jdField_f_of_type_Int == 0)
      {
        this.mRootLayout.setContentDescription(this.mContext.getResources().getString(2131699673));
        return;
      }
    } while (this.jdField_f_of_type_Int != 1);
    this.mRootLayout.setContentDescription(this.mContext.getResources().getString(2131699657));
  }
  
  private void k()
  {
    switch (this.jdField_f_of_type_Int)
    {
    case 2: 
    default: 
    case 0: 
      do
      {
        return;
      } while ((this.jdField_c_of_type_Int != 0) && (this.jdField_c_of_type_Int != 1));
      d(1);
      return;
    }
    d(0);
  }
  
  private void l()
  {
    onVideoStart(this.jdField_b_of_type_Int);
    if (this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIVideoInnerStatusListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIVideoInnerStatusListener.notifyVideoStart();
    }
  }
  
  private void m()
  {
    onVideoStop();
    if (this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIVideoInnerStatusListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIVideoInnerStatusListener.notifyVideoStop();
    }
  }
  
  public int a(FloatingScreenParams paramFloatingScreenParams, View paramView)
  {
    int k = super.a(paramFloatingScreenParams, paramView);
    if (this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIVideoInnerStatusListener != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIVideoInnerStatusListener.notifyVideoClose(6);
      this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIVideoInnerStatusListener = null;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIFullScreenEnterListener = null;
      this.jdField_b_of_type_Int = 0;
      return k;
      FloatingScreenReporter.a();
      if ((k == 0) && (paramFloatingScreenParams != null) && (paramFloatingScreenParams.getCanZoom())) {
        b();
      }
    }
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
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (this.mFloatingContainer != null)
      {
        this.mFloatingContainer.setOutlineProvider(new FloatingOutlineProvider(paramInt2));
        this.mFloatingContainer.setClipToOutline(true);
      }
      if (this.mFloatingWidgetWrapper != null)
      {
        this.mFloatingWidgetWrapper.setOutlineProvider(new FloatingOutlineProvider(paramInt1));
        this.mFloatingWidgetWrapper.setClipToOutline(true);
        this.mFloatingWidgetWrapper.setElevation(15.0F);
        this.mFloatingWidgetWrapper.setBackground(this.mContext.getResources().getDrawable(2130846588));
      }
    }
  }
  
  public void a(Context paramContext)
  {
    super.a(paramContext);
    this.mFloatingContainer.setOnBackPressListener(this);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(this.mContext);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setId(2131374880);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.mContext);
    this.jdField_a_of_type_AndroidWidgetImageView.setId(2131374865);
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.mRootLayout.findViewById(2131374870));
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(this.mContext.getResources().getString(2131699655));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.mRootLayout.findViewById(2131374868));
    this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(this.mContext.getResources().getString(2131699654));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mRootLayout.findViewById(2131374876));
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.mContext.getResources().getString(2131699665));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.mRootLayout.findViewById(2131374875));
    this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(this.mContext.getResources().getString(2131699659));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.mRootLayout.findViewById(2131374873));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.mRootLayout.findViewById(2131374871));
    this.jdField_d_of_type_AndroidWidgetImageView.setContentDescription(this.mContext.getResources().getString(2131699664));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.mRootLayout.findViewById(2131374877));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.mRootLayout.findViewById(2131374872));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.mRootLayout.findViewById(2131374879));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.mRootLayout.findViewById(2131374878));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.mRootLayout.findViewById(2131374869));
    this.jdField_d_of_type_AndroidWidgetTextView.setShadowLayer(3.0F, 1.0F, 1.0F, -16777216);
    a(new View[] { this.jdField_b_of_type_AndroidWidgetImageView, this.jdField_c_of_type_AndroidWidgetImageView, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_d_of_type_AndroidWidgetImageView });
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.mRootLayout.findViewById(2131374882));
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setThumb(paramContext.getResources().getDrawable(2130850167));
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgressDrawable(paramContext.getResources().getDrawable(2130846348));
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
    e();
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
    b(paramView);
    paramView.setId(2131374883);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(paramView, new FrameLayout.LayoutParams(-1, -1));
    b(this.jdField_a_of_type_AndroidWidgetImageView);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, new FrameLayout.LayoutParams(-1, -1));
    this.mFloatingWidgetWrapper.removeAllViews();
    b(this.jdField_a_of_type_AndroidWidgetFrameLayout);
    this.mFloatingWidgetWrapper.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout, new FrameLayout.LayoutParams(-1, -1));
    b(this.mRootLayout);
    this.mFloatingWidgetWrapper.addView(this.mRootLayout, new FrameLayout.LayoutParams(-1, -1));
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
  
  public void b()
  {
    if (this.mContext == null) {}
    while (((Boolean)BaseSharedPreUtil.a(this.mContext, "", "key_float_video_has_show_tips", Boolean.valueOf(false))).booleanValue()) {
      return;
    }
    a(true, new View[] { this.jdField_d_of_type_AndroidWidgetTextView });
    BaseSharedPreUtil.a(this.mContext, "", true, "key_float_video_has_show_tips", Boolean.valueOf(true));
    ThreadManager.getUIHandler().postDelayed(new FloatingVideoWrapper.2(this), 3000L);
  }
  
  public void b(int paramInt)
  {
    if ((this.mFloatingContainer != null) && (this.mFloatingContainer.b())) {
      ((IQQFloatingWindow)QRoute.api(IQQFloatingWindow.class)).saveFloatingCenter(this.mFloatingContainer.a(), this.mFloatingContainer.b());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIVideoInnerStatusListener != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIVideoInnerStatusListener.notifyVideoClose(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIVideoInnerStatusListener = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIFullScreenEnterListener = null;
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    super.b(paramInt);
  }
  
  public void c()
  {
    a(true, new View[] { this.mFloatingContainer, this.mFloatingCloseBtn, this.jdField_b_of_type_AndroidWidgetTextView });
    a(false, new View[] { this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_c_of_type_AndroidWidgetTextView, this.jdField_e_of_type_AndroidWidgetImageView, this.jdField_d_of_type_AndroidWidgetImageView, this.jdField_a_of_type_AndroidWidgetImageView });
    b(true, new View[] { this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetSeekBar });
    i();
    a(false);
    b(false);
    j();
  }
  
  public void d()
  {
    if (this.mStatusReceiver == null)
    {
      this.mStatusReceiver = new FloatingScreenStatusReceiver(this.mContext);
      this.mStatusReceiver.a(0, new FloatingVideoWrapper.1(this));
    }
  }
  
  public void onClick(View paramView)
  {
    int k = paramView.getId();
    if (k == 2131374867)
    {
      b(1);
      FloatingScreenReporter.d();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (k == 2131374868)
      {
        b(2);
        FloatingScreenReporter.k();
      }
      else if (k == 2131374870)
      {
        h();
        FloatingScreenReporter.f();
      }
      else if (k == 2131374876)
      {
        l();
        FloatingScreenReporter.h();
      }
      else if (k == 2131374875)
      {
        m();
        FloatingScreenReporter.h();
      }
      else if (k == 2131374871)
      {
        l();
      }
      else if (k == 2131374874)
      {
        f();
      }
    }
  }
  
  public void onOrientationChange(boolean paramBoolean)
  {
    if ((this.mFloatingContainer != null) && (this.mFloatingContainer.a())) {
      this.mFloatingContainer.a(paramBoolean);
    }
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt;
    if ((this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIVideoInnerStatusListener != null) && (paramBoolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIVideoInnerStatusListener.notifyVideoSeek(this.jdField_a_of_type_Int);
      onVideoProgressUpdate((int)(this.jdField_a_of_type_Int * this.jdField_b_of_type_Int / 100.0D));
    }
  }
  
  public void onSetVideoCover(Bitmap paramBitmap)
  {
    if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (paramBitmap != null))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  public void onSetVideoCover(Drawable paramDrawable)
  {
    if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (paramDrawable != null))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onVideoBuffering()
  {
    c(400);
    b(true, new View[] { this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetSeekBar });
    this.jdField_c_of_type_Int = 3;
  }
  
  public void onVideoComplete(boolean paramBoolean)
  {
    if (this.mFloatingContainer.b()) {
      FloatingScreenReporter.i();
    }
    for (;;)
    {
      a(true, new View[] { this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_d_of_type_AndroidWidgetImageView });
      a(false, new View[] { this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_c_of_type_AndroidWidgetTextView, this.jdField_e_of_type_AndroidWidgetImageView });
      a(paramBoolean, new View[] { this.jdField_a_of_type_AndroidWidgetImageView });
      b(true, new View[] { this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView });
      b(false, new View[] { this.jdField_a_of_type_AndroidWidgetSeekBar });
      this.jdField_e_of_type_AndroidWidgetTextView.setText(a(this.jdField_b_of_type_Int));
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(100);
      this.jdField_c_of_type_Int = 1;
      j();
      return;
      FloatingScreenReporter.j();
    }
  }
  
  public void onVideoError(int paramInt)
  {
    c(401);
    b(false, new View[] { this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetSeekBar });
    this.jdField_c_of_type_Int = 2;
  }
  
  public void onVideoProgressUpdate(int paramInt)
  {
    if (this.jdField_b_of_type_Int == 0) {
      return;
    }
    int k;
    if (paramInt < 0) {
      k = 0;
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = ((int)(100.0D * k / this.jdField_b_of_type_Int));
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(this.jdField_a_of_type_Int);
      this.jdField_e_of_type_AndroidWidgetTextView.setText(a(k));
      return;
      k = paramInt;
      if (paramInt > this.jdField_b_of_type_Int) {
        k = this.jdField_b_of_type_Int;
      }
    }
  }
  
  public void onVideoSize(int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0) {
      this.jdField_d_of_type_Int = paramInt1;
    }
    if (paramInt2 > 0) {
      this.jdField_e_of_type_Int = paramInt2;
    }
    FloatingScreenContainer localFloatingScreenContainer;
    if ((this.mFloatingContainer != null) && (this.mFloatingContainer.a()))
    {
      localFloatingScreenContainer = this.mFloatingContainer;
      if (this.mFloatingContainer.b()) {
        break label69;
      }
    }
    label69:
    for (boolean bool = true;; bool = false)
    {
      localFloatingScreenContainer.a(bool, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, false);
      return;
    }
  }
  
  public void onVideoStart(int paramInt)
  {
    if (this.jdField_b_of_type_Int != paramInt) {
      FloatingScreenReporter.c(paramInt);
    }
    a(false, new View[] { this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_d_of_type_AndroidWidgetImageView, this.jdField_c_of_type_AndroidWidgetTextView, this.jdField_e_of_type_AndroidWidgetImageView });
    a(true, new View[] { this.jdField_b_of_type_AndroidWidgetTextView });
    b(true, new View[] { this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetSeekBar });
    ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 300L);
    if (this.mRootLayout != null)
    {
      if ((Build.VERSION.SDK_INT < 23) || (this.mFloatingContainer == null) || (!this.mFloatingContainer.c())) {
        break label172;
      }
      this.mRootLayout.setBackgroundResource(2130846594);
    }
    label172:
    do
    {
      for (;;)
      {
        this.jdField_c_of_type_Int = 0;
        j();
        if ((paramInt > 0) && (this.jdField_b_of_type_Int != paramInt)) {
          break;
        }
        return;
        if ((this.mContext != null) && (this.mContext.getResources() != null)) {
          this.mRootLayout.setBackgroundColor(this.mContext.getResources().getColor(2131167305));
        }
      }
      this.jdField_b_of_type_Int = paramInt;
    } while (this.jdField_f_of_type_AndroidWidgetTextView == null);
    this.jdField_f_of_type_AndroidWidgetTextView.setText(a(this.jdField_b_of_type_Int));
  }
  
  public void onVideoStop()
  {
    a(true, new View[] { this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_d_of_type_AndroidWidgetImageView });
    a(false, new View[] { this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_c_of_type_AndroidWidgetTextView, this.jdField_e_of_type_AndroidWidgetImageView });
    b(true, new View[] { this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetSeekBar });
    this.jdField_c_of_type_Int = 1;
    j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qqfloatingwindow.impl.uiwrapper.FloatingVideoWrapper
 * JD-Core Version:    0.7.0.1
 */