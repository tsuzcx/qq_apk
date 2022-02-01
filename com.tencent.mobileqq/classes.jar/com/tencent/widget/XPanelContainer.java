package com.tencent.widget;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.voicetextpanel.view.BaseVoicetoTextView;
import com.tencent.mobileqq.emoticonview.EmoticonPanelViewBinder;
import com.tencent.mobileqq.utils.BaseSharedPreUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.kapalaiadapter.DeviceInfoUtil2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AnimateUtils;
import com.tencent.util.VersionUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarTintManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppActivity;

public class XPanelContainer
  extends FrameLayout
  implements Runnable
{
  public static int a = 0;
  public static int b = 0;
  public static boolean b = false;
  public static int c = 0;
  public static volatile int d = 0;
  private static boolean d = false;
  private static int jdField_e_of_type_Int;
  private long jdField_a_of_type_Long;
  private SparseArray<View> jdField_a_of_type_AndroidUtilSparseArray;
  private View jdField_a_of_type_AndroidViewView;
  public XPanelContainer.OnChangeMultiScreenListener a;
  private XPanelContainer.PanelCallback jdField_a_of_type_ComTencentWidgetXPanelContainer$PanelCallback;
  private XPanelContainer.ReadyToShowChangeListener jdField_a_of_type_ComTencentWidgetXPanelContainer$ReadyToShowChangeListener;
  public WeakReference<XPanelContainer.OnGoingToShowPanelListener> a;
  private List<IKeyboardHiddenCallback> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt;
  private View b;
  public boolean c;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int;
  private boolean jdField_i_of_type_Boolean;
  private int jdField_j_of_type_Int;
  private boolean jdField_j_of_type_Boolean;
  private int jdField_k_of_type_Int;
  private boolean jdField_k_of_type_Boolean;
  private int l;
  private int m;
  private int n;
  private int o;
  
  static
  {
    jdField_d_of_type_Boolean = VersionUtils.e();
  }
  
  public XPanelContainer(Context paramContext)
  {
    this(paramContext, null);
  }
  
  @TargetApi(11)
  public XPanelContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int i1 = 0;
    this.jdField_g_of_type_Int = 0;
    this.jdField_h_of_type_Int = -1;
    this.jdField_i_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(4);
    this.jdField_j_of_type_Int = -1;
    this.jdField_k_of_type_Int = -1;
    this.l = -1;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_ArrayOfInt = new int[2];
    this.n = 0;
    this.jdField_i_of_type_Boolean = true;
    this.jdField_k_of_type_Boolean = false;
    this.o = 0;
    this.jdField_a_of_type_Long = -1L;
    i();
    if (jdField_a_of_type_Int == 0)
    {
      jdField_b_of_type_Int = (int)(b() * paramContext.getResources().getDisplayMetrics().density);
      jdField_a_of_type_Int = d();
      double d1;
      if (SystemBarTintManager.hasNavBar(paramContext))
      {
        i1 = SystemBarTintManager.getNavigationBarHeight(paramContext);
        d1 = paramContext.getResources().getDisplayMetrics().heightPixels + i1;
        Double.isNaN(d1);
        jdField_c_of_type_Int = (int)(d1 * 0.5D);
      }
      else
      {
        d1 = paramContext.getResources().getDisplayMetrics().heightPixels;
        Double.isNaN(d1);
        jdField_c_of_type_Int = (int)(d1 * 0.5D);
      }
      if (QLog.isColorLevel())
      {
        paramAttributeSet = new StringBuilder();
        paramAttributeSet.append(" mMAXExternalPanelheight = ");
        paramAttributeSet.append(jdField_c_of_type_Int);
        paramAttributeSet.append("mExternalPanelheight=");
        paramAttributeSet.append(jdField_a_of_type_Int);
        QLog.d("Q.aio.XPanelContainer", 2, paramAttributeSet.toString());
      }
      if (QLog.isColorLevel())
      {
        paramAttributeSet = new StringBuilder();
        paramAttributeSet.append(" mDefaultExternalPanelheight = ");
        paramAttributeSet.append(jdField_b_of_type_Int);
        paramAttributeSet.append("mMAXExternalPanelheight=");
        paramAttributeSet.append(jdField_c_of_type_Int);
        paramAttributeSet.append("density=");
        paramAttributeSet.append(paramContext.getResources().getDisplayMetrics().density);
        paramAttributeSet.append("mNavigationBarHeight=");
        paramAttributeSet.append(i1);
        QLog.d("XPanelContainer", 2, paramAttributeSet.toString());
      }
    }
    this.m = ImmersiveUtils.getStatusBarHeight(getContext());
    if ((Build.VERSION.SDK_INT >= 21) && (Build.VERSION.SDK_INT < 24) && (!DeviceInfoUtil2.a())) {
      setOnSystemUiVisibilityChangeListener(new XPanelContainer.1(this));
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (XPanelContainer.OnGoingToShowPanelListener)((WeakReference)localObject).get();
    }
    if (localObject != null) {
      ((XPanelContainer.OnGoingToShowPanelListener)localObject).b(paramInt1, paramInt2);
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, View paramView)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.aio.XPanelContainer", 4, " onLayout use default layout = ");
    }
    if ((this.jdField_b_of_type_AndroidViewView instanceof BaseVoicetoTextView))
    {
      paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt4 - paramInt2 - jdField_a_of_type_Int, 1073741824));
      paramView.layout(paramInt1, paramInt2, paramInt3, paramInt4 - jdField_a_of_type_Int);
      ((BaseVoicetoTextView)this.jdField_b_of_type_AndroidViewView).a(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean);
      return;
    }
    paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt4 - paramInt2, 1073741824));
    paramView.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilList;
    if (localObject1 != null)
    {
      Object localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (IKeyboardHiddenCallback)((Iterator)localObject2).next();
        if (!((IKeyboardHiddenCallback)localObject1).a(paramBoolean))
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("don't hide keyboard, it intercepted by ");
            ((StringBuilder)localObject2).append(localObject1);
            QLog.d("XPanelContainer", 2, ((StringBuilder)localObject2).toString());
          }
          return;
        }
      }
    }
    a();
  }
  
  private void a(boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean2, View paramView)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" onLayout bom panel mannule layout  =  softInputShowing ");
      ((StringBuilder)localObject).append(paramBoolean2);
      ((StringBuilder)localObject).append(" changed = ");
      ((StringBuilder)localObject).append(paramBoolean1);
      QLog.d("Q.aio.XPanelContainer", 4, ((StringBuilder)localObject).toString());
    }
    if ((paramBoolean2) && (paramBoolean1))
    {
      requestLayout();
      return;
    }
    g();
    int i1;
    if ((jdField_d_of_type_Boolean) && (this.jdField_g_of_type_Boolean))
    {
      if (this.jdField_e_of_type_Boolean) {
        i1 = this.o;
      } else {
        i1 = jdField_a_of_type_Int;
      }
    }
    else
    {
      if (!this.jdField_g_of_type_Boolean) {
        this.jdField_g_of_type_Boolean = true;
      }
      i1 = jdField_a_of_type_Int - this.o;
    }
    Object localObject = this.jdField_b_of_type_AndroidViewView;
    if (localObject == null)
    {
      QLog.e("XPanelContainer", 1, " onLayout panel error:curPanel==nulll ,restore status NONE ");
      c(0);
      this.jdField_h_of_type_Int = -1;
      requestLayout();
      return;
    }
    int i2;
    if ((localObject instanceof BaseVoicetoTextView))
    {
      localObject = (BaseVoicetoTextView)localObject;
      i2 = paramInt4 - i1;
      ((BaseVoicetoTextView)localObject).a(paramInt1, i2, paramInt3, i2 + jdField_a_of_type_Int, paramBoolean2);
    }
    else
    {
      ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(jdField_a_of_type_Int, 1073741824));
      localObject = this.jdField_b_of_type_AndroidViewView;
      i2 = paramInt4 - i1;
      ((View)localObject).layout(paramInt1, i2, paramInt3, jdField_a_of_type_Int + i2);
    }
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" onLayout bom panel mannule layout calcposition d= ");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append("mAnimationPosition = ");
      ((StringBuilder)localObject).append(this.o);
      ((StringBuilder)localObject).append("isOpenAnim=");
      ((StringBuilder)localObject).append(this.jdField_e_of_type_Boolean);
      ((StringBuilder)localObject).append("mExternalPanelheight=");
      ((StringBuilder)localObject).append(jdField_a_of_type_Int);
      QLog.d("Q.aio.XPanelContainer", 4, ((StringBuilder)localObject).toString());
    }
    paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt4 - paramInt2 - i1, 1073741824));
    paramView.layout(paramInt1, paramInt2, paramInt3, paramInt4 - i1);
    if ((!this.jdField_e_of_type_Boolean) && ((this.o == 0) || (this.jdField_h_of_type_Int > 1)))
    {
      c(this.jdField_h_of_type_Int);
      this.jdField_h_of_type_Int = -1;
      if (QLog.isDevelopLevel())
      {
        paramView = new StringBuilder();
        paramView.append(" onLayout bom panel mannule layout,end ，not canvas =  isOpenAnim ");
        paramView.append(this.jdField_e_of_type_Boolean);
        paramView.append(" mAnimationPosition = ");
        paramView.append(this.o);
        QLog.d("Q.aio.XPanelContainer", 4, paramView.toString());
      }
    }
    else
    {
      if (jdField_d_of_type_Boolean) {
        return;
      }
      postDelayed(this, 1L);
    }
  }
  
  private boolean a(int paramInt)
  {
    if (jdField_b_of_type_Boolean)
    {
      Object localObject1;
      if (paramInt == 1)
      {
        if (this.jdField_a_of_type_AndroidViewView.requestFocusFromTouch())
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.aio.XPanelContainer", 2, " requestFocusFromTouch success ");
          }
        }
        else if (QLog.isColorLevel()) {
          QLog.e("Q.aio.XPanelContainer", 2, " requestFocusFromTouch fail ");
        }
        BaseAIOUtils.a(this.jdField_a_of_type_AndroidViewView);
        localObject1 = this.jdField_b_of_type_AndroidViewView;
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
      }
      else if (paramInt > 1)
      {
        a();
        if (this.jdField_g_of_type_Int == 1) {
          this.jdField_g_of_type_Int = 0;
        }
        Object localObject2 = (View)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer$PanelCallback.a(paramInt))
          {
            this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
            removeView((View)localObject2);
            localObject1 = null;
          }
        }
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          try
          {
            localObject2 = this.jdField_a_of_type_ComTencentWidgetXPanelContainer$PanelCallback.a(paramInt);
          }
          catch (Exception localException)
          {
            localObject2 = localObject1;
            if (QLog.isColorLevel())
            {
              QLog.d("XPanelContainer", 2, localException, new Object[0]);
              localObject2 = localObject1;
            }
          }
          if (localObject2 == null) {
            return true;
          }
          addView((View)localObject2);
          this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject2);
        }
        localObject1 = this.jdField_b_of_type_AndroidViewView;
        if (localObject2 != localObject1)
        {
          if (localObject1 != null) {
            ((View)localObject1).setVisibility(8);
          }
          ((View)localObject2).setVisibility(0);
          this.jdField_b_of_type_AndroidViewView = ((View)localObject2);
        }
      }
      else
      {
        a();
      }
      requestLayout();
      return true;
    }
    return false;
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject;
    if (this.jdField_c_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_ComTencentWidgetXPanelContainer$OnChangeMultiScreenListener;
      if (localObject != null) {
        ((XPanelContainer.OnChangeMultiScreenListener)localObject).h(jdField_b_of_type_Boolean);
      }
      this.jdField_c_of_type_Boolean = false;
    }
    if (this.jdField_h_of_type_Boolean)
    {
      this.jdField_h_of_type_Boolean = false;
      localObject = this.jdField_a_of_type_ComTencentWidgetXPanelContainer$OnChangeMultiScreenListener;
      if (localObject != null) {
        ((XPanelContainer.OnChangeMultiScreenListener)localObject).h(jdField_b_of_type_Boolean);
      }
      if (this.jdField_b_of_type_AndroidViewView != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.XPanelContainer", 2, "  multi screen change to normal ");
        }
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        this.jdField_b_of_type_AndroidViewView = null;
      }
      ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
      c();
      c(0);
      this.n = 0;
      this.jdField_h_of_type_Int = -1;
      jdField_b_of_type_Int = (int)(b() * getContext().getResources().getDisplayMetrics().density);
      jdField_a_of_type_Int = jdField_b_of_type_Int;
      jdField_d_of_type_Int = 0;
      try
      {
        paramInt1 = paramInt3 - paramInt1 - getPaddingRight();
        paramInt3 = getPaddingLeft();
        paramInt2 = paramInt4 - paramInt2 - getPaddingBottom();
        paramInt4 = getPaddingTop();
        localObject = getChildAt(0);
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt1 - paramInt3, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2 - paramInt4, 1073741824));
        ((View)localObject).layout(paramInt3, paramInt4, paramInt1, paramInt2);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("  error = ");
          localStringBuilder.append(localException);
          QLog.d("Q.aio.XPanelContainer", 2, localStringBuilder.toString());
        }
      }
      return true;
    }
    return false;
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    if (jdField_b_of_type_Boolean)
    {
      jdField_b_of_type_Int = (int)(b() * getContext().getResources().getDisplayMetrics().density);
      jdField_a_of_type_Int = c();
      jdField_d_of_type_Int = 0;
      int i1 = this.n;
      if (i1 == 1)
      {
        paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt4 - paramInt2, 1073741824));
        paramView.layout(paramInt1, paramInt2, paramInt3, paramInt4);
      }
      else if (i1 == 0)
      {
        paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt4 - paramInt2, 1073741824));
        paramView.layout(paramInt1, paramInt2, paramInt3, paramInt4);
      }
      else
      {
        View localView = this.jdField_b_of_type_AndroidViewView;
        if ((localView == null) || (localView.getVisibility() != 0)) {
          break label250;
        }
        localView = this.jdField_b_of_type_AndroidViewView;
        i1 = paramInt3 - paramInt1;
        localView.measure(View.MeasureSpec.makeMeasureSpec(i1, 1073741824), View.MeasureSpec.makeMeasureSpec(jdField_a_of_type_Int, 1073741824));
        this.jdField_b_of_type_AndroidViewView.layout(paramInt1, paramInt4 - jdField_a_of_type_Int, paramInt3, paramInt4);
        paramView.measure(View.MeasureSpec.makeMeasureSpec(i1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt4 - paramInt2 - jdField_a_of_type_Int, 1073741824));
        paramView.layout(paramInt1, paramInt2, paramInt3, paramInt4 - jdField_a_of_type_Int);
      }
      c(this.n);
      this.jdField_h_of_type_Int = 0;
      return true;
      label250:
      this.n = 0;
      this.jdField_h_of_type_Int = -1;
      c(this.n);
      requestLayout();
      return true;
    }
    return false;
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, View paramView)
  {
    int i1;
    if (QLog.isDevelopLevel())
    {
      localObject = this.jdField_b_of_type_AndroidViewView;
      if (localObject == null) {
        i1 = 0;
      } else {
        i1 = ((View)localObject).getVisibility();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" onLayout bom panel ,confirm it mExternalPanelheight= ");
      ((StringBuilder)localObject).append(jdField_a_of_type_Int);
      ((StringBuilder)localObject).append(" bottom = ");
      ((StringBuilder)localObject).append(paramInt4);
      ((StringBuilder)localObject).append("  mCurPanel.getVisibility() ");
      ((StringBuilder)localObject).append(i1);
      QLog.d("Q.aio.XPanelContainer", 4, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_b_of_type_AndroidViewView;
    if ((localObject != null) && (((View)localObject).getVisibility() == 0))
    {
      if (QLog.isDevelopLevel())
      {
        localObject = this.jdField_b_of_type_AndroidViewView.getParent();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" onLayout bom panel ,confirm it vp.ViewParent = ");
        localStringBuilder.append(localObject.getClass().getName());
        QLog.d("Q.aio.XPanelContainer", 4, localStringBuilder.toString());
      }
      i1 = paramInt3 - paramInt1;
      paramView.measure(View.MeasureSpec.makeMeasureSpec(i1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt4 - paramInt2 - jdField_a_of_type_Int, 1073741824));
      paramView.layout(paramInt1, paramInt2, paramInt3, paramInt4 - jdField_a_of_type_Int);
      paramView = this.jdField_b_of_type_AndroidViewView;
      if (!(paramView instanceof BaseVoicetoTextView))
      {
        paramView.measure(View.MeasureSpec.makeMeasureSpec(i1, 1073741824), View.MeasureSpec.makeMeasureSpec(jdField_a_of_type_Int, 1073741824));
        this.jdField_b_of_type_AndroidViewView.layout(paramInt1, paramInt4 - jdField_a_of_type_Int, paramInt3, paramInt4);
        return false;
      }
      ((BaseVoicetoTextView)paramView).a(paramInt1, paramInt4 - jdField_a_of_type_Int, paramInt3, paramInt4, paramBoolean);
      return false;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.aio.XPanelContainer", 4, " onLayout panel hold on error ,restore status NONE ");
    }
    c(0);
    this.jdField_h_of_type_Int = -1;
    requestLayout();
    return true;
  }
  
  private boolean a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Object localObject;
    if ((this.jdField_i_of_type_Int < 0) && (paramBoolean) && (paramInt1 > 0))
    {
      localObject = getResources().getConfiguration();
      this.jdField_j_of_type_Int = ((Configuration)localObject).orientation;
      if (VersionUtils.f())
      {
        this.jdField_k_of_type_Int = ((Configuration)localObject).screenWidthDp;
        this.l = ((Configuration)localObject).screenHeightDp;
      }
      this.jdField_i_of_type_Int = paramInt1;
    }
    else if (paramInt1 > this.jdField_i_of_type_Int)
    {
      this.jdField_i_of_type_Int = paramInt1;
    }
    float f1;
    if (getResources().getConfiguration().orientation == 2) {
      f1 = 0.3F;
    } else {
      f1 = 0.2F;
    }
    int i1 = (int)(this.jdField_i_of_type_Int * f1);
    int i2 = this.jdField_i_of_type_Int;
    boolean bool1;
    if ((i2 > paramInt1) && (i2 - paramInt1 > i1)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (bool1 == this.jdField_j_of_type_Boolean) {
      this.jdField_k_of_type_Boolean = false;
    } else {
      this.jdField_k_of_type_Boolean = true;
    }
    this.jdField_j_of_type_Boolean = bool1;
    if (QLog.isColorLevel())
    {
      i2 = this.jdField_g_of_type_Int;
      int i3 = this.jdField_h_of_type_Int;
      boolean bool2 = jdField_b_of_type_Boolean;
      int i4 = this.jdField_a_of_type_ArrayOfInt[1];
      int i5 = this.n;
      int i6 = this.jdField_i_of_type_Int;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" dHeight = ");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append(" mSoftInputChange=");
      ((StringBuilder)localObject).append(this.jdField_k_of_type_Boolean);
      QLog.d("Q.aio.XPanelContainer", 2, new Object[] { " setStatus onLayout before finalStatus = ", Integer.valueOf(paramInt2), " softInputShowing = ", Boolean.valueOf(bool1), " mStatus = ", Integer.valueOf(i2), " changed = ", Boolean.valueOf(paramBoolean), " mPendingStatus = ", Integer.valueOf(i3), " mIsMultiScreen = ", Boolean.valueOf(bool2), " mCoordinates[1] = ", Integer.valueOf(i4), " mClickStatus = ", Integer.valueOf(i5), "mNormalSize = ", Integer.valueOf(i6), " height = ", Integer.valueOf(paramInt1), ((StringBuilder)localObject).toString() });
    }
    return bool1;
  }
  
  private boolean a(boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean2, View paramView)
  {
    if ((!paramBoolean2) && (this.jdField_g_of_type_Int != 1) && (this.jdField_f_of_type_Int == 0))
    {
      this.jdField_f_of_type_Int = paramInt4;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init mDefaultBottom: ");
      localStringBuilder.append(paramInt4);
      QLog.i("XPanelContainer", 1, localStringBuilder.toString());
    }
    if (getResources().getConfiguration().orientation == 2)
    {
      if (jdField_d_of_type_Int != 0) {
        c();
      }
      jdField_d_of_type_Int = 0;
      jdField_b_of_type_Int = (int)(b() * getContext().getResources().getDisplayMetrics().density);
      jdField_a_of_type_Int = c();
    }
    if ((paramBoolean2) && (this.jdField_g_of_type_Int != 1))
    {
      c(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean2, paramView);
      return false;
    }
    if ((this.jdField_h_of_type_Int > 1) && ((!paramBoolean2) || (paramBoolean1)))
    {
      a(paramBoolean1, paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean2, paramView);
      return true;
    }
    if ((this.jdField_h_of_type_Int == 0) && (this.jdField_g_of_type_Int > 1))
    {
      b(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean2, paramView);
      return true;
    }
    if ((this.jdField_g_of_type_Int > 1) && (!paramBoolean2))
    {
      if (a(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean2, paramView)) {
        return true;
      }
    }
    else {
      a(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean2, paramView);
    }
    return false;
  }
  
  public static int b()
  {
    return 196;
  }
  
  private void b(int paramInt)
  {
    int i1 = this.o;
    if ((i1 != 0) && (i1 != jdField_a_of_type_Int))
    {
      if (QLog.isColorLevel()) {
        QLog.d("XPanelContainer", 2, new Object[] { "mAnimationPosition went wrong. mAnimationPosition = ", Integer.valueOf(this.o), " mExternalPanelheight = ", Integer.valueOf(jdField_a_of_type_Int) });
      }
      this.o = jdField_a_of_type_Int;
      this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
    }
    this.jdField_h_of_type_Int = paramInt;
    a();
    if ((this.o == 0) && (!this.jdField_j_of_type_Boolean) && (this.jdField_i_of_type_Int > 0) && (getHeight() >= this.jdField_i_of_type_Int))
    {
      if (QLog.isColorLevel()) {
        QLog.w("XPanelContainer", 2, "soft input status error, reset");
      }
      b();
    }
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, View paramView)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" onLayout reget =  mAnimationPosition = ");
      ((StringBuilder)localObject).append(this.o);
      QLog.d("Q.aio.XPanelContainer", 4, ((StringBuilder)localObject).toString());
    }
    g();
    Object localObject = this.jdField_b_of_type_AndroidViewView;
    if (localObject == null)
    {
      QLog.e("XPanelContainer", 1, " onLayout panel error:curPanel==nulll ,restore status NONE ");
      c(0);
      this.jdField_h_of_type_Int = -1;
      requestLayout();
      return;
    }
    int i1;
    if ((localObject instanceof BaseVoicetoTextView))
    {
      localObject = (BaseVoicetoTextView)localObject;
      i1 = this.o;
      ((BaseVoicetoTextView)localObject).a(paramInt1, paramInt4 - i1, paramInt3, paramInt4 - i1 + jdField_a_of_type_Int, paramBoolean);
    }
    else
    {
      ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(jdField_a_of_type_Int, 1073741824));
      localObject = this.jdField_b_of_type_AndroidViewView;
      i1 = this.o;
      ((View)localObject).layout(paramInt1, paramInt4 - i1, paramInt3, paramInt4 - i1 + jdField_a_of_type_Int);
    }
    paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt4 - paramInt2 - this.o, 1073741824));
    paramView.layout(paramInt1, paramInt2, paramInt3, paramInt4 - this.o);
    if (this.o == 0)
    {
      c(this.jdField_h_of_type_Int);
      this.jdField_h_of_type_Int = -1;
      return;
    }
    if (jdField_d_of_type_Boolean) {
      return;
    }
    postDelayed(this, 1L);
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" showExternalPanel mAnimationPosition= ");
      ((StringBuilder)localObject).append(this.o);
      ((StringBuilder)localObject).append("mExternalPanelheight=");
      ((StringBuilder)localObject).append(jdField_a_of_type_Int);
      QLog.d("Q.aio.XPanelContainer", 4, ((StringBuilder)localObject).toString());
    }
    if (this.o > 0) {
      return;
    }
    this.jdField_h_of_type_Int = paramInt;
    URLDrawable.pause();
    ApngImage.pauseByTag(0);
    this.jdField_g_of_type_Boolean = paramBoolean;
    if ((jdField_d_of_type_Boolean) && (paramBoolean))
    {
      this.jdField_e_of_type_Boolean = true;
      paramInt = getHeight();
      localObject = ValueAnimator.ofInt(new int[] { paramInt, paramInt - jdField_a_of_type_Int });
      ((ValueAnimator)localObject).setDuration(150L);
      ((ValueAnimator)localObject).addUpdateListener(new XPanelContainer.3(this, paramInt));
      ((ValueAnimator)localObject).start();
      return;
    }
    this.o = jdField_a_of_type_Int;
    this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
    requestLayout();
  }
  
  private void b(boolean paramBoolean)
  {
    XPanelContainer.ReadyToShowChangeListener localReadyToShowChangeListener = this.jdField_a_of_type_ComTencentWidgetXPanelContainer$ReadyToShowChangeListener;
    if (localReadyToShowChangeListener != null) {
      localReadyToShowChangeListener.a(paramBoolean);
    }
  }
  
  private int c()
  {
    View localView = this.jdField_b_of_type_AndroidViewView;
    if ((localView != null) && ((localView instanceof ResetPanelInterface))) {
      return ((ResetPanelInterface)localView).a();
    }
    return jdField_b_of_type_Int;
  }
  
  private void c(int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setStatus status=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" mStatus=");
      ((StringBuilder)localObject).append(this.jdField_g_of_type_Int);
      ((StringBuilder)localObject).append(" mSoftInputChange=");
      ((StringBuilder)localObject).append(this.jdField_k_of_type_Boolean);
      ((StringBuilder)localObject).append(" mSoftInputShowing=");
      ((StringBuilder)localObject).append(this.jdField_j_of_type_Boolean);
      QLog.d("XPanelContainer", 2, ((StringBuilder)localObject).toString());
    }
    int i1 = this.jdField_g_of_type_Int;
    if (paramInt != i1)
    {
      this.jdField_g_of_type_Int = paramInt;
      localObject = this.jdField_a_of_type_ComTencentWidgetXPanelContainer$PanelCallback;
      if (localObject != null) {
        ((XPanelContainer.PanelCallback)localObject).a(i1, this.jdField_g_of_type_Int);
      }
      URLDrawable.resume();
      ApngImage.playByTag(0);
      localObject = this.jdField_b_of_type_AndroidViewView;
      if ((localObject != null) && (paramInt <= 1) && ((!(localObject instanceof BaseVoicetoTextView)) || (paramInt != 1)))
      {
        if ((this.jdField_k_of_type_Boolean) && (!this.jdField_j_of_type_Boolean))
        {
          if ((this.jdField_b_of_type_AndroidViewView instanceof BaseVoicetoTextView)) {
            this.jdField_g_of_type_Int = 36;
          }
          return;
        }
        if (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0)
        {
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
          this.jdField_b_of_type_AndroidViewView = null;
          postDelayed(this, 1L);
          return;
        }
        this.jdField_b_of_type_AndroidViewView = null;
      }
    }
  }
  
  private void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, View paramView)
  {
    View localView = this.jdField_b_of_type_AndroidViewView;
    if ((localView instanceof BaseVoicetoTextView))
    {
      ((BaseVoicetoTextView)localView).a(true);
      paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt4 - paramInt2 - jdField_a_of_type_Int, 1073741824));
      paramView.layout(paramInt1, paramInt2, paramInt3, paramInt4 - jdField_a_of_type_Int);
      ((BaseVoicetoTextView)this.jdField_b_of_type_AndroidViewView).a(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean);
    }
    else
    {
      paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt4 - paramInt2, 1073741824));
      paramView.layout(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    paramInt1 = this.jdField_f_of_type_Int - paramInt4;
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.XPanelContainer", 2, new Object[] { " onLayout inputHeight ", Integer.valueOf(paramInt1), " mExternalPanelheight = ", Integer.valueOf(jdField_a_of_type_Int), " mDefaultExternalPanelheight = ", Integer.valueOf(jdField_b_of_type_Int), " mAddedHeight = ", Integer.valueOf(jdField_d_of_type_Int) });
    }
    if (getResources().getConfiguration().orientation == 1)
    {
      jdField_b_of_type_Int = (int)(b() * getContext().getResources().getDisplayMetrics().density);
      if (jdField_a_of_type_Int != paramInt1)
      {
        if (QLog.isColorLevel())
        {
          paramView = new StringBuilder();
          paramView.append(" mExternalPanelheight=");
          paramView.append(jdField_a_of_type_Int);
          paramView.append(" inputHeight=");
          paramView.append(paramInt1);
          paramView.append(" mDefaultExternalPanelheight=");
          paramView.append(jdField_b_of_type_Int);
          paramView.append(" mMAXHExternalPanelheight=");
          paramView.append(jdField_c_of_type_Int);
          paramView.append(" mAnimationPosition=");
          paramView.append(this.o);
          paramView.append(" mDefaultBottom=");
          paramView.append(this.jdField_f_of_type_Int);
          QLog.d("Q.aio.XPanelContainer", 2, paramView.toString());
        }
        if (this.o == 0)
        {
          paramInt2 = jdField_b_of_type_Int;
          if (paramInt1 > paramInt2)
          {
            paramInt3 = jdField_c_of_type_Int;
            if (paramInt1 > paramInt3)
            {
              if (paramInt3 > paramInt2) {
                jdField_a_of_type_Int = paramInt3;
              } else {
                jdField_a_of_type_Int = paramInt2;
              }
            }
            else
            {
              jdField_a_of_type_Int = paramInt1;
              jdField_e_of_type_Int = paramInt1;
              h();
            }
          }
          else
          {
            jdField_a_of_type_Int = paramInt2;
            if (paramInt1 < paramInt2 / 2)
            {
              this.jdField_f_of_type_Int = 0;
              QLog.i("XPanelContainer", 1, "reset mDefaultBottom");
            }
          }
          jdField_d_of_type_Int = jdField_a_of_type_Int - jdField_b_of_type_Int;
        }
        c();
        if (QLog.isColorLevel())
        {
          paramView = new StringBuilder();
          paramView.append("mExternalPanelheight=");
          paramView.append(jdField_a_of_type_Int);
          paramView.append("mAddedHeight=");
          paramView.append(jdField_d_of_type_Int);
          QLog.d("XPanelContainer", 2, paramView.toString());
        }
      }
    }
  }
  
  private static int d()
  {
    int i1 = jdField_e_of_type_Int;
    if (i1 > 0) {
      return i1;
    }
    return ViewUtils.a(196.0F);
  }
  
  private boolean d()
  {
    boolean bool2 = e();
    boolean bool1 = true;
    if (bool2)
    {
      if (this.jdField_g_of_type_Int <= 1) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  private void e()
  {
    if ((getContext() instanceof AppActivity))
    {
      int i1 = ((Activity)getContext()).getWindow().getAttributes().softInputMode;
      if ((i1 & 0xFF) != 18)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("illegal soft input mode: ");
        localStringBuilder.append(i1);
        QLog.e("XPanelContainer", 1, localStringBuilder.toString());
        ((Activity)getContext()).getWindow().setSoftInputMode(i1 & 0xFFFFFF00 | 0x12);
        requestLayout();
      }
    }
  }
  
  private boolean e()
  {
    return (DeviceInfoUtil.i()) && (Build.VERSION.SDK_INT >= 30);
  }
  
  private void f()
  {
    boolean bool;
    StringBuilder localStringBuilder;
    if (Build.VERSION.SDK_INT >= 24)
    {
      if (jdField_b_of_type_Boolean)
      {
        long l1 = System.currentTimeMillis();
        if ((getContext() instanceof Activity))
        {
          bool = ((Activity)getContext()).isInMultiWindowMode();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("targetSdk > 24 tmpIsMultiScreen= ");
          localStringBuilder.append(bool);
          localStringBuilder.append(",calltime = ");
          localStringBuilder.append(System.currentTimeMillis() - l1);
          QLog.d("XPanelContainer", 1, localStringBuilder.toString());
          if (jdField_b_of_type_Boolean != bool)
          {
            this.jdField_h_of_type_Boolean = true;
            jdField_b_of_type_Boolean = bool;
          }
        }
      }
    }
    else if ((Build.VERSION.SDK_INT >= 21) && (getSystemUiVisibility() == 0))
    {
      if (getParent() != null) {
        ((View)getParent()).getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
      }
      if (this.jdField_a_of_type_ArrayOfInt[1] < this.m - 5) {
        bool = true;
      } else {
        bool = false;
      }
      if (jdField_b_of_type_Boolean != bool)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("tmpIsMultiScreen= ");
        localStringBuilder.append(bool);
        localStringBuilder.append(", coordinate ");
        localStringBuilder.append(this.jdField_a_of_type_ArrayOfInt[1]);
        localStringBuilder.append(", default top ");
        localStringBuilder.append(this.m);
        QLog.d("XPanelContainer", 1, localStringBuilder.toString());
        this.jdField_h_of_type_Boolean = true;
        jdField_b_of_type_Boolean = bool;
      }
    }
  }
  
  @TargetApi(11)
  private void g()
  {
    if ((jdField_d_of_type_Boolean) && (this.jdField_g_of_type_Boolean))
    {
      if (this.jdField_e_of_type_Boolean)
      {
        if (this.o >= jdField_a_of_type_Int)
        {
          this.o = 0;
          this.jdField_e_of_type_Boolean = false;
        }
        return;
      }
      if (this.jdField_f_of_type_Boolean) {
        if (this.o <= 0)
        {
          this.o = 0;
          this.jdField_f_of_type_Boolean = false;
        }
      }
    }
    else
    {
      if (AnimationUtils.currentAnimationTimeMillis() >= this.jdField_a_of_type_Long + 0L)
      {
        this.o = 0;
        return;
      }
      float f1 = (float)(AnimationUtils.currentAnimationTimeMillis() - this.jdField_a_of_type_Long) / 0.0F;
      this.o = ((int)(jdField_a_of_type_Int - AnimateUtils.a(f1) * jdField_a_of_type_Int));
    }
  }
  
  private void h()
  {
    int i1 = jdField_e_of_type_Int;
    if (i1 > 0)
    {
      BaseSharedPreUtil.a(BaseApplication.getContext(), "", true, "sp_key_input_height", Integer.valueOf(i1));
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("saveInputMethodPanelHeight.height = ");
        localStringBuilder.append(i1);
        QLog.i("XPanelContainer", 2, localStringBuilder.toString());
      }
    }
  }
  
  private void i()
  {
    if (jdField_e_of_type_Int == 0) {
      jdField_e_of_type_Int = ((Integer)BaseSharedPreUtil.a(getContext(), "", "sp_key_input_height", Integer.valueOf(0))).intValue();
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initInputMethodPanelHeight.height = ");
      localStringBuilder.append(jdField_e_of_type_Int);
      QLog.i("XPanelContainer", 2, localStringBuilder.toString());
    }
  }
  
  public int a()
  {
    return this.jdField_g_of_type_Int;
  }
  
  public View a()
  {
    return this.jdField_b_of_type_AndroidViewView;
  }
  
  public void a()
  {
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
  }
  
  public void a(int paramInt)
  {
    a(paramInt, true);
  }
  
  @TargetApi(11)
  public void a(int paramInt, boolean paramBoolean)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(" showExternalPanel panelId = ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(" mStatus = ");
      ((StringBuilder)localObject1).append(this.jdField_g_of_type_Int);
      ((StringBuilder)localObject1).append(" ready = ");
      ((StringBuilder)localObject1).append(this.jdField_i_of_type_Boolean);
      QLog.d("Q.aio.XPanelContainer", 2, ((StringBuilder)localObject1).toString());
    }
    if (!this.jdField_i_of_type_Boolean) {
      return;
    }
    this.n = paramInt;
    a(this.jdField_g_of_type_Int, paramInt);
    if (a(paramInt)) {
      return;
    }
    if (paramInt == 1)
    {
      BaseAIOUtils.a(this.jdField_a_of_type_AndroidViewView);
      return;
    }
    if (paramInt > 1)
    {
      this.jdField_a_of_type_Boolean = false;
      Object localObject2 = (View)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer$PanelCallback.a(paramInt))
        {
          this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
          removeView((View)localObject2);
          localObject1 = null;
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        try
        {
          localObject2 = this.jdField_a_of_type_ComTencentWidgetXPanelContainer$PanelCallback.a(paramInt);
        }
        catch (Exception localException)
        {
          localObject2 = localObject1;
          if (QLog.isColorLevel())
          {
            QLog.d("XPanelContainer", 2, localException, new Object[0]);
            localObject2 = localObject1;
          }
        }
        if (localObject2 == null) {
          return;
        }
        addView((View)localObject2);
        this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject2);
      }
      localObject1 = this.jdField_b_of_type_AndroidViewView;
      if (localObject2 != localObject1)
      {
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
        ((View)localObject2).setVisibility(0);
        this.jdField_b_of_type_AndroidViewView = ((View)localObject2);
      }
      int i1 = this.jdField_g_of_type_Int;
      if (i1 == 0)
      {
        b(paramInt, paramBoolean);
        return;
      }
      if (i1 == 1)
      {
        b(paramInt);
        return;
      }
      if (i1 != paramInt) {
        c(paramInt);
      }
      return;
    }
    throw new IllegalArgumentException("wrong argument..must be SOFT_INPUT,EXTERNAL_EMOTICON,EXTERNAL_INPUT");
  }
  
  public void a(View paramView)
  {
    a(paramView, true);
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    if (paramView.getOnFocusChangeListener() == null) {
      paramView.setOnFocusChangeListener(new XPanelContainer.2(this));
    }
    if ((paramBoolean) && (paramView.getParent() != null) && ((paramView.getParent() instanceof ViewGroup)))
    {
      paramView = (ViewGroup)paramView.getParent();
      paramView.setDescendantFocusability(131072);
      paramView.setFocusableInTouchMode(true);
    }
  }
  
  public void a(IKeyboardHiddenCallback paramIKeyboardHiddenCallback)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramIKeyboardHiddenCallback);
  }
  
  @TargetApi(11)
  public boolean a()
  {
    return a(true);
  }
  
  @TargetApi(11)
  public boolean a(boolean paramBoolean)
  {
    return a(paramBoolean, false);
  }
  
  @TargetApi(11)
  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    XPanelContainer.PanelCallback localPanelCallback = this.jdField_a_of_type_ComTencentWidgetXPanelContainer$PanelCallback;
    if (localPanelCallback != null) {
      localPanelCallback.s();
    }
    boolean bool;
    if (this.jdField_g_of_type_Int > 0) {
      bool = true;
    } else {
      bool = false;
    }
    if (jdField_b_of_type_Boolean)
    {
      if (this.jdField_g_of_type_Int == 1) {
        a(paramBoolean2);
      }
      this.n = 0;
      requestLayout();
      return bool;
    }
    int i1 = this.jdField_g_of_type_Int;
    if (i1 == 1) {
      try
      {
        a(paramBoolean2);
        return bool;
      }
      catch (Exception localException)
      {
        QLog.e("XPanelContainer", 1, localException, new Object[0]);
        return bool;
      }
    }
    if (i1 > 1)
    {
      Object localObject;
      if (this.o > 0)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("  hideAllPanel return  mAnimationPosition = ");
          ((StringBuilder)localObject).append(this.o);
          QLog.d("Q.aio.XPanelContainer", 2, ((StringBuilder)localObject).toString());
        }
        return true;
      }
      this.n = 0;
      this.jdField_h_of_type_Int = 0;
      if (paramBoolean1) {
        i1 = jdField_a_of_type_Int;
      } else {
        i1 = 0;
      }
      this.o = i1;
      this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
      if ((jdField_d_of_type_Boolean) && (paramBoolean1))
      {
        this.jdField_f_of_type_Boolean = true;
        i1 = getHeight();
        localObject = ValueAnimator.ofInt(new int[] { i1 - jdField_a_of_type_Int, i1 });
        ((ValueAnimator)localObject).setDuration(150L);
        ((ValueAnimator)localObject).addUpdateListener(new XPanelContainer.4(this, i1));
        ((ValueAnimator)localObject).start();
        return bool;
      }
      requestLayout();
    }
    return bool;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("XPanelContainer", 2, "-->finish--reset resetPosition");
    }
    this.jdField_h_of_type_Int = -1;
    c(0);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.o = 0;
    requestLayout();
  }
  
  @TargetApi(11)
  public boolean b()
  {
    return a(true, true);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.XPanelContainer", 2, " clearAllPanel ");
    }
    if ((this.jdField_b_of_type_AndroidViewView instanceof BaseVoicetoTextView)) {
      return;
    }
    int i1 = 0;
    try
    {
      while (i1 < this.jdField_a_of_type_AndroidUtilSparseArray.size())
      {
        View localView = (View)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i1));
        if (localView.getParent() != null) {
          removeView(localView);
        }
        i1 += 1;
      }
    }
    catch (Exception localException)
    {
      label77:
      break label77;
    }
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    this.jdField_b_of_type_AndroidViewView = null;
    EmoticonPanelViewBinder.destroyViewPool();
  }
  
  public boolean c()
  {
    return this.jdField_i_of_type_Boolean;
  }
  
  public void d()
  {
    if (jdField_b_of_type_Boolean)
    {
      Object localObject = this.jdField_a_of_type_ComTencentWidgetXPanelContainer$PanelCallback;
      this.jdField_g_of_type_Int = 1;
      this.n = 1;
      this.jdField_h_of_type_Int = 0;
      localObject = this.jdField_b_of_type_AndroidViewView;
      if (localObject != null)
      {
        if (((View)localObject).getVisibility() == 0)
        {
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
          this.jdField_b_of_type_AndroidViewView = null;
          return;
        }
        this.jdField_b_of_type_AndroidViewView = null;
      }
    }
  }
  
  @TargetApi(13)
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (VersionUtils.f())
    {
      if ((paramConfiguration.orientation != this.jdField_j_of_type_Int) && ((this.jdField_k_of_type_Int != paramConfiguration.screenWidthDp) || (this.l != paramConfiguration.screenHeightDp)))
      {
        this.jdField_j_of_type_Int = -1;
        this.l = -1;
        this.l = -1;
        this.jdField_i_of_type_Int = -1;
        a();
      }
    }
    else if (paramConfiguration.orientation != this.jdField_j_of_type_Int)
    {
      this.jdField_j_of_type_Int = -1;
      this.jdField_i_of_type_Int = -1;
      a();
    }
  }
  
  @TargetApi(13)
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("  changed = ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("top=");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("bottom=");
      ((StringBuilder)localObject).append(paramInt4);
      ((StringBuilder)localObject).append(" mAnimationPosition = ");
      ((StringBuilder)localObject).append(this.o);
      QLog.d("Q.aio.XPanelContainer", 2, ((StringBuilder)localObject).toString());
    }
    e();
    int i4 = getPaddingRight();
    int i1 = getPaddingLeft();
    int i3 = getPaddingBottom();
    int i2 = getPaddingTop();
    f();
    if (a(paramInt1, paramInt2, paramInt3, paramInt4)) {
      return;
    }
    paramInt4 -= paramInt2;
    paramInt2 = this.jdField_g_of_type_Int;
    boolean bool1 = a(paramBoolean, paramInt4, paramInt2);
    paramInt1 = paramInt3 - paramInt1 - i4;
    paramInt3 = paramInt4 - i3;
    Object localObject = getChildAt(0);
    try
    {
      if (a(i1, i2, paramInt1, paramInt3, (View)localObject)) {
        return;
      }
      boolean bool2 = a(paramBoolean, i1, i2, paramInt1, paramInt3, bool1, (View)localObject);
      if (bool2) {
        return;
      }
      if ((paramBoolean) && (bool1))
      {
        this.jdField_h_of_type_Int = -1;
        paramInt1 = 1;
      }
      else if (this.jdField_h_of_type_Int != 0)
      {
        paramInt1 = paramInt2;
        if (d())
        {
          paramInt1 = paramInt2;
          if (paramBoolean)
          {
            paramInt1 = paramInt2;
            if (bool1) {}
          }
        }
      }
      else
      {
        if (paramBoolean)
        {
          paramInt1 = paramInt2;
          if (paramInt2 == 28) {
            break label297;
          }
          if (paramInt2 == 35)
          {
            paramInt1 = paramInt2;
            break label297;
          }
        }
        paramInt1 = 0;
        label297:
        this.jdField_h_of_type_Int = -1;
      }
      c(paramInt1);
      this.n = paramInt1;
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.XPanelContainer", 2, new Object[] { " onLayout after finalStatus = ", Integer.valueOf(paramInt1), " softInputShowing = ", Boolean.valueOf(bool1), " mStatus = ", Integer.valueOf(this.jdField_g_of_type_Int), " changed = ", Boolean.valueOf(paramBoolean), " mPendingStatus = ", Integer.valueOf(this.jdField_h_of_type_Int) });
      }
      localObject = this.jdField_b_of_type_AndroidViewView;
      if ((localObject instanceof BaseVoicetoTextView)) {
        ((BaseVoicetoTextView)localObject).a();
      }
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("main.getContext: ");
      localStringBuilder.append(((View)localObject).getContext());
      localStringBuilder.append(" \n ");
      localStringBuilder.append(localException.toString());
      localStringBuilder.append(" crash happen restore init status");
      QLog.e("Q.aio.XPanelContainer", 1, localStringBuilder.toString(), localException);
      localObject = this.jdField_b_of_type_AndroidViewView;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      c(0);
      this.jdField_h_of_type_Int = -1;
      requestLayout();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), paramInt1), getDefaultSize(getSuggestedMinimumHeight(), paramInt2));
  }
  
  public void run()
  {
    requestLayout();
  }
  
  public void setIsInMultiScreen(boolean paramBoolean)
  {
    if (jdField_b_of_type_Boolean != paramBoolean)
    {
      this.jdField_h_of_type_Boolean = true;
      jdField_b_of_type_Boolean = paramBoolean;
    }
  }
  
  public void setOnChangeMultiScreenListener(XPanelContainer.OnChangeMultiScreenListener paramOnChangeMultiScreenListener)
  {
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer$OnChangeMultiScreenListener = paramOnChangeMultiScreenListener;
  }
  
  public void setOnGoingToShowPanelListener(XPanelContainer.OnGoingToShowPanelListener paramOnGoingToShowPanelListener)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramOnGoingToShowPanelListener);
  }
  
  public void setOnPanelChangeListener(XPanelContainer.PanelCallback paramPanelCallback)
  {
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer$PanelCallback = paramPanelCallback;
  }
  
  public void setReadyToShow(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setReadyToShow() called with: readyToShow = [");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.d("XPanelContainer", 2, localStringBuilder.toString());
    }
    if (this.jdField_i_of_type_Boolean != paramBoolean)
    {
      this.jdField_i_of_type_Boolean = paramBoolean;
      b(paramBoolean);
    }
  }
  
  public void setReadyToShowChangeListener(XPanelContainer.ReadyToShowChangeListener paramReadyToShowChangeListener)
  {
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer$ReadyToShowChangeListener = paramReadyToShowChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.XPanelContainer
 * JD-Core Version:    0.7.0.1
 */