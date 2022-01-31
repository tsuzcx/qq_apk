package com.tencent.mobileqq.multicard;

import actn;
import ahnt;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.OverScroller;
import aspy;
import asqm;
import asqv;
import asqx;
import asrc;
import asrd;
import asre;
import asrf;
import asrg;
import asrj;
import asro;
import assn;
import asso;
import assp;
import assq;
import baxk;
import baxl;
import bbdr;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.multiaio.widget.IcsLinearLayout;
import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeRecentDynamicAvatarView;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class MultiCardPageIndicator
  extends HorizontalScrollView
  implements asqx, baxl
{
  private static float jdField_b_of_type_Float = 1.0F;
  private static float jdField_c_of_type_Float = 1.333F;
  private float jdField_a_of_type_Float;
  private final int jdField_a_of_type_Int = 99;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private asqm jdField_a_of_type_Asqm;
  private asqv jdField_a_of_type_Asqv;
  private asrc jdField_a_of_type_Asrc;
  private asre jdField_a_of_type_Asre;
  private asrf jdField_a_of_type_Asrf;
  private asrg jdField_a_of_type_Asrg;
  private asro jdField_a_of_type_Asro;
  private baxk jdField_a_of_type_Baxk;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IcsLinearLayout jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout;
  private MultiAIOBaseViewPager jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private Hashtable<String, Bitmap> jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  private List<asrd> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt = new int[2];
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private final View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new assn(this);
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -1;
  private boolean jdField_c_of_type_Boolean;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h = 0;
  private int i;
  private int j;
  private int k = 2147483647;
  
  public MultiCardPageIndicator(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MultiCardPageIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MultiCardPageIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramInt);
  }
  
  private Drawable a(String paramString)
  {
    if (this.jdField_a_of_type_Baxk == null)
    {
      this.jdField_a_of_type_Baxk = new baxk(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_Baxk.a(this);
    }
    Bitmap localBitmap = this.jdField_a_of_type_Baxk.a(1, paramString, 0, (byte)4);
    if (localBitmap != null) {
      return new BitmapDrawable(localBitmap);
    }
    if (!this.jdField_a_of_type_Baxk.a()) {
      this.jdField_a_of_type_Baxk.a(paramString, 200, false, 1, true, (byte)0, 4);
    }
    return null;
  }
  
  private void a(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    setHorizontalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout = new IcsLinearLayout(paramContext, paramInt);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(getContext(), new asso(this), new Handler(Looper.getMainLooper()));
    addView(this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout, new ViewGroup.LayoutParams(-2, -1));
    g();
    this.jdField_a_of_type_Asqv.a(new assp(this));
    h();
  }
  
  private void a(View paramView)
  {
    paramView.setFocusable(true);
    paramView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.removeView(paramView);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.addView(paramView, new LinearLayout.LayoutParams(-2, -1));
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof assq)) {}
    for (paramView = (assq)paramView;; paramView = null)
    {
      if (paramView != null)
      {
        paramView = paramView.jdField_a_of_type_AndroidWidgetImageView;
        if (!paramBoolean) {
          break label38;
        }
      }
      label38:
      for (int m = 0;; m = 4)
      {
        paramView.setVisibility(m);
        return;
      }
    }
  }
  
  private void a(assq paramassq, asrj paramasrj, Drawable paramDrawable)
  {
    if ((paramassq == null) || (paramasrj == null)) {
      return;
    }
    if (paramDrawable == null)
    {
      paramasrj.a();
      paramDrawable = a(paramasrj.a());
    }
    for (;;)
    {
      Drawable localDrawable = paramDrawable;
      if (paramDrawable == null) {
        localDrawable = bbdr.b();
      }
      b(paramassq, paramasrj, localDrawable);
      return;
    }
  }
  
  private void b(assq paramassq, asrj paramasrj, Drawable paramDrawable)
  {
    if ((paramassq == null) || (paramasrj == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("TabPageIndicator", 2, "holder|param invalidate");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardFragment", 2, "getView position: ");
    }
    boolean bool;
    if (a(paramasrj.a()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("TabPageIndicator", 2, "bindview user:" + paramasrj.a());
      }
      int n = ((Integer)ahnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramasrj.a(), paramasrj.a()).first).intValue();
      int m = n;
      if (n == 103) {
        m = 1;
      }
      ThemeRecentDynamicAvatarView localThemeRecentDynamicAvatarView = paramassq.jdField_a_of_type_ComTencentWidgetThemeRecentDynamicAvatarView;
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      paramasrj = paramasrj.a();
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a() == 1)
      {
        bool = true;
        label162:
        localThemeRecentDynamicAvatarView.setFaceDrawable(localQQAppInterface, paramDrawable, m, paramasrj, 100, false, bool, 0);
      }
    }
    for (;;)
    {
      paramassq.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      paramassq.jdField_a_of_type_JavaLangString = String.valueOf(0);
      paramassq.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(4);
      if ((!"1103".equals(ThemeUtil.curThemeId)) && (!"2920".equals(ThemeUtil.curThemeId))) {
        break;
      }
      paramassq.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837937);
      return;
      bool = false;
      break label162;
      paramassq.jdField_a_of_type_ComTencentWidgetThemeRecentDynamicAvatarView.setImageDrawable(paramDrawable);
    }
  }
  
  private void c(int paramInt)
  {
    View localView = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getChildAt(paramInt);
    if (localView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TabPageIndicator", 2, "animateToTab error, tabView is null!");
      }
      return;
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    this.jdField_a_of_type_JavaLangRunnable = new MultiCardPageIndicator.4(this, localView);
    post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  private boolean c()
  {
    return ((this.h == 1) || (this.h == 2)) && (this.i == 0);
  }
  
  private void d(int paramInt)
  {
    a(this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getChildAt(paramInt), false);
  }
  
  private boolean d()
  {
    try
    {
      if (this.jdField_c_of_type_Boolean)
      {
        Field localField = HorizontalScrollView.class.getDeclaredField("mScroller");
        localField.setAccessible(true);
        boolean bool = ((OverScroller)localField.get(this)).isFinished();
        return bool;
      }
    }
    catch (Exception localException)
    {
      QLog.e("TabPageIndicator", 1, "isFinishScroll: ", localException);
    }
    return true;
  }
  
  private void e(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      int n = this.jdField_a_of_type_JavaUtilList.size();
      int m = 0;
      while (m < n)
      {
        asrd localasrd = (asrd)this.jdField_a_of_type_JavaUtilList.get(m);
        if (localasrd != null) {
          localasrd.a(paramInt);
        }
        m += 1;
      }
    }
    f(paramInt);
  }
  
  private void f()
  {
    try
    {
      Object localObject = HorizontalScrollView.class.getDeclaredField("mVelocityTracker");
      ((Field)localObject).setAccessible(true);
      localObject = (VelocityTracker)((Field)localObject).get(this);
      if (localObject != null) {
        this.jdField_a_of_type_Float = ((VelocityTracker)localObject).getXVelocity();
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("TabPageIndicator", 1, "readLastInitVelocity: ", localException);
    }
  }
  
  private void f(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TabPageIndicator", 2, "onPageScrollStateChangedInternal() called with: state = [" + paramInt + "]");
    }
    switch (paramInt)
    {
    }
  }
  
  private void g()
  {
    try
    {
      Field localField = HorizontalScrollView.class.getDeclaredField("mScroller");
      localField.setAccessible(true);
      asqv localasqv = new asqv(getContext());
      localField.set(this, localasqv);
      this.jdField_a_of_type_Asqv = ((asqv)localasqv);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("TabPageIndicator", 1, "replaceOverScroller: ", localException);
    }
  }
  
  private void h()
  {
    try
    {
      Field localField = HorizontalScrollView.class.getDeclaredField("mMaximumVelocity");
      localField.setAccessible(true);
      int m = localField.getInt(this);
      this.j = aspy.a(getContext(), m);
      localField.set(this, Integer.valueOf(this.j));
      return;
    }
    catch (Exception localException)
    {
      QLog.e("TabPageIndicator", 1, "setMaxVelocity: ", localException);
    }
  }
  
  private void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TabPageIndicator", 2, "onFinishScroll() called");
    }
    this.k = 2147483647;
    this.jdField_c_of_type_Boolean = false;
    setScrollState(0);
    if (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager.b())
    {
      if (QLog.isColorLevel()) {
        QLog.d("TabPageIndicator", 2, "computeScroll() isFakeDragging");
      }
      this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager.e();
    }
    int n = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager.a();
    this.d = n;
    int i1 = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getChildCount();
    int m = 0;
    if (m < i1)
    {
      View localView = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getChildAt(m);
      if (m == n) {}
      for (boolean bool = true;; bool = false)
      {
        localView.setSelected(bool);
        m += 1;
        break;
      }
    }
    this.jdField_c_of_type_Int = n;
  }
  
  public View a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardFragment", 2, "getView position: " + paramInt);
    }
    if (this.jdField_a_of_type_Asro == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiCardFragment", 2, "getView position: " + paramInt);
      }
      return null;
    }
    asrj localasrj = this.jdField_a_of_type_Asro.a(paramInt);
    assq localassq = new assq();
    View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558562, null);
    localassq.jdField_a_of_type_ComTencentWidgetThemeRecentDynamicAvatarView = ((ThemeRecentDynamicAvatarView)localView.findViewById(2131376808));
    localassq.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)localView.findViewById(2131378601));
    localassq.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131362792));
    localassq.jdField_a_of_type_Int = paramInt;
    localView.setTag(localassq);
    StringBuilder localStringBuilder = new StringBuilder();
    Drawable localDrawable2 = a(localasrj.a());
    Drawable localDrawable1 = localDrawable2;
    if (localDrawable2 == null) {
      localDrawable1 = bbdr.b();
    }
    b(localassq, localasrj, localDrawable1);
    localStringBuilder.append(localasrj.b());
    if (AppSetting.d) {
      localView.setContentDescription(localStringBuilder.toString());
    }
    return localView;
  }
  
  public void a()
  {
    try
    {
      Field localField = HorizontalScrollView.class.getDeclaredField("mScroller");
      localField.setAccessible(true);
      ((OverScroller)localField.get(this)).abortAnimation();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("TabPageIndicator", 1, "abortAnimation: ", localException);
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TabPageIndicator", 2, "onPageSelected() called with: position = [" + paramInt + "]");
    }
    setCurrentItem(paramInt);
    if (this.jdField_a_of_type_Asqm != null) {
      this.jdField_a_of_type_Asqm.a(paramInt);
    }
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.jdField_a_of_type_Asqm != null) {
      this.jdField_a_of_type_Asqm.a(paramInt1, paramFloat, paramInt2);
    }
    paramInt1 = (int)((paramInt1 + paramFloat) * this.g);
    if (b())
    {
      if (QLog.isColorLevel()) {
        QLog.d("TabPageIndicator", 2, "onPageScrolled() scrollFromViewPager ");
      }
      smoothScrollTo(paramInt1, 0);
    }
  }
  
  public void a(asrd paramasrd)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramasrd);
  }
  
  public void a(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramFragmentActivity;
    this.f = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimensionPixelSize(2131298095);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.setPadding(this.f, 0, this.f, 0);
    this.e = getResources().getDisplayMetrics().widthPixels;
  }
  
  public boolean a()
  {
    try
    {
      Field localField = HorizontalScrollView.class.getDeclaredField("mScroller");
      localField.setAccessible(true);
      boolean bool = ((OverScroller)localField.get(this)).isFinished();
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("TabPageIndicator", 1, "isScrollerFinished: ", localException);
    }
    return false;
  }
  
  protected boolean a(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1000) || (paramInt == 1004) || (paramInt == 1003) || (paramInt == 10004) || (paramInt == 1021) || (paramInt == 1022) || (paramInt == 1023);
  }
  
  public void b()
  {
    int n = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager.a();
    int m = 0;
    if (m < this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getChildCount())
    {
      View localView = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getChildAt(m);
      if (localView != null) {
        if (n != m) {
          break label57;
        }
      }
      label57:
      for (boolean bool = true;; bool = false)
      {
        a(localView, bool);
        m += 1;
        break;
      }
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TabPageIndicator", 2, " onPageScrollStateChanged  state = " + paramInt);
    }
    if (this.jdField_a_of_type_Asqm != null) {
      this.jdField_a_of_type_Asqm.b(paramInt);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getChildAt(this.d);
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((View)localObject).getTag();
    } while (!(localObject instanceof assq));
    localObject = (assq)localObject;
    switch (paramInt)
    {
    }
  }
  
  public boolean b()
  {
    return (this.i == 1) && (this.h == 0);
  }
  
  public void c()
  {
    int m = 0;
    while (m < this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getChildCount())
    {
      View localView = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getChildAt(m);
      if (localView != null) {
        a(localView, false);
      }
      m += 1;
    }
  }
  
  public void computeScroll()
  {
    int n = 1;
    this.jdField_a_of_type_Boolean = false;
    int m = this.jdField_a_of_type_Asqv.getFinalX();
    super.computeScroll();
    if ((this.jdField_a_of_type_Asqv.getFinalX() < m) && (QLog.isColorLevel())) {
      QLog.d("TabPageIndicator", 2, "computeScroll() called afterComputeFinalX < beforeComputeFinalX");
    }
    requestLayout();
    if (this.h == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TabPageIndicator", 2, "computeScroll() ScrollX = " + getScrollX() + ", Scroller.FinialX = " + this.jdField_a_of_type_Asqv.getFinalX());
      }
      if (this.jdField_a_of_type_Boolean) {
        break label311;
      }
      if (!d()) {
        break label294;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TabPageIndicator", 2, "computeScroll() mCallOnScrollChanged = false, I'm not scrolling ? Build.MANUFACTURER = " + Build.MANUFACTURER + ", Build.MODEL = " + Build.MODEL);
      }
      if ((!"HUAWEI".equalsIgnoreCase(Build.MANUFACTURER)) || (!"LYA-AL00".equalsIgnoreCase(Build.MODEL)) || (!this.jdField_c_of_type_Boolean)) {
        break label230;
      }
      m = 1;
      if (m == 0) {
        break label289;
      }
      if (this.k != getScrollX()) {
        break label235;
      }
      m = n;
      if (m == 0) {
        break label240;
      }
      i();
    }
    label230:
    label235:
    label240:
    while (!QLog.isColorLevel())
    {
      do
      {
        for (;;)
        {
          return;
          m = 0;
          continue;
          m = 0;
        }
        if (QLog.isColorLevel()) {
          QLog.d("TabPageIndicator", 2, "scrollTo() mPendingFinalX = " + this.k);
        }
        scrollTo(this.k, getScrollY());
        return;
        i();
        return;
      } while (!QLog.isColorLevel());
      QLog.d("TabPageIndicator", 2, "computeScroll() isFinishScroll = false");
      return;
    }
    label289:
    label294:
    label311:
    QLog.d("TabPageIndicator", 2, "computeScroll() mCallOnScrollChanged = true");
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Baxk != null)
    {
      this.jdField_a_of_type_Baxk.d();
      this.jdField_a_of_type_Baxk = null;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TabPageIndicator", 2, "dispatchTouchEvent() called with: ev = [" + paramMotionEvent + "]");
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    if (QLog.isColorLevel()) {
      QLog.d("TabPageIndicator", 2, "dispatchTouchEvent() called with: ev = [" + paramMotionEvent + "], handled = " + bool);
    }
    if (bool) {
      if (this.jdField_a_of_type_Asrg != null) {
        this.jdField_a_of_type_Asrg.b(this, paramMotionEvent);
      }
    }
    switch (paramMotionEvent.getActionMasked())
    {
    case 2: 
    default: 
    case 0: 
      do
      {
        return bool;
        getParent().requestDisallowInterceptTouchEvent(true);
        this.jdField_b_of_type_Boolean = true;
        this.jdField_c_of_type_Boolean = false;
        setScrollState(1);
      } while (!QLog.isColorLevel());
      QLog.d("TabPageIndicator", 2, "dispatchTouchEvent()  ACTION_DOWN called with: mScrollState = " + this.h);
      return bool;
    }
    getParent().requestDisallowInterceptTouchEvent(false);
    if ((!this.jdField_b_of_type_Boolean) || (this.jdField_c_of_type_Boolean)) {}
    for (;;)
    {
      this.jdField_b_of_type_Boolean = false;
      setScrollState(2);
      invalidate();
      return bool;
      this.jdField_a_of_type_Asqv.forceFinished(true);
      if (this.jdField_a_of_type_Asrc != null)
      {
        int m = (int)this.jdField_a_of_type_Float;
        this.jdField_a_of_type_Asrc.a(m);
      }
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.removeAllViews();
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Asro.a();
    int m = 0;
    while (m < this.jdField_b_of_type_Int)
    {
      new LinearLayout.LayoutParams(-2, -2).gravity = 17;
      long l = SystemClock.elapsedRealtime();
      View localView = a(m);
      if (QLog.isColorLevel()) {
        QLog.d("TabPageIndicator", 2, "createView() cost " + (SystemClock.elapsedRealtime() - l) + " ms");
      }
      a(localView);
      m += 1;
    }
    if (this.d > this.jdField_b_of_type_Int) {
      this.d = (this.jdField_b_of_type_Int - 1);
    }
    setCurrentItem(this.d);
    requestLayout();
  }
  
  public void fling(int paramInt)
  {
    long l = SystemClock.uptimeMillis();
    this.jdField_c_of_type_Boolean = true;
    if (paramInt > 0) {}
    int i3;
    int i4;
    int n;
    for (boolean bool = true;; bool = false)
    {
      i3 = getWidth() - getPaddingRight() - getPaddingLeft();
      i4 = getChildAt(0).getWidth();
      this.jdField_a_of_type_Asqv.fling(getScrollX(), getScrollY(), paramInt, 0, 0, Math.max(0, i4 - i3), 0, 0, i3 / 2, 0);
      n = this.jdField_a_of_type_Asqv.getFinalX();
      if (this.g != 0) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TabPageIndicator", 2, "fling() itemwidth = 0");
      }
      return;
    }
    int m = n / this.g;
    float f1 = n * 1.0F / this.g;
    if (QLog.isColorLevel()) {
      QLog.d("TabPageIndicator", 2, "fling() called with: getScrollX() = " + getScrollX() + ", velocityX = [" + paramInt + "], pageFloat = " + f1 + ", pageInt = " + m + ", flingFromRight2Left = " + bool + ", flingDistance = " + (n - getScrollX()));
    }
    if (bool)
    {
      if (f1 - m < 0.5F) {
        break label756;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TabPageIndicator", 2, "fling() 手向左滑 增加滑动一点到下一页");
      }
      n = 1;
      m += 1;
    }
    for (;;)
    {
      label268:
      int i1 = m;
      if (m < 0) {
        i1 = 0;
      }
      this.k = (i1 * this.g);
      m = 0;
      int i2 = 2147483647;
      i1 = paramInt;
      paramInt = i2;
      if (QLog.isColorLevel()) {
        QLog.d("TabPageIndicator", 2, "fling() called mPendingFinalX = [" + this.k + "], currentFinalX = [" + this.jdField_a_of_type_Asqv.getFinalX() + "]");
      }
      i2 = Math.abs(this.jdField_a_of_type_Asqv.getFinalX() - this.k);
      if ((paramInt != 2147483647) && (i2 > paramInt + 1)) {
        QLog.e("TabPageIndicator", 1, "fling: error state deltaDistance " + i2 + ", lastDeltaDistance = " + paramInt);
      }
      while (i2 == 0)
      {
        this.jdField_a_of_type_Asqv.forceFinished(true);
        setScrollState(2);
        super.fling(i1);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("TabPageIndicator", 2, "fling() called with: velocityX = [" + i1 + "], final ScrollX = " + this.jdField_a_of_type_Asqv.getFinalX() + ", exec time = " + (SystemClock.uptimeMillis() - l) + " ms");
        return;
        if (f1 - m >= 0.5F)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TabPageIndicator", 2, "fling() 手向右滑 增加滑动一点到下一页");
          }
          n = 0;
          m += 1;
          break label268;
        }
        n = 1;
        break label268;
      }
      while (!this.jdField_a_of_type_Asqv.isFinished()) {
        this.jdField_a_of_type_Asqv.forceFinished(true);
      }
      if (bool) {
        if (n != 0) {
          paramInt = i1 + i2;
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TabPageIndicator", 2, "fling() called with: try " + m + ", velocityX = [" + paramInt + "], deltaVelocity = " + i2 + ", deltaDistance = " + i2);
        }
        this.jdField_a_of_type_Asqv.fling(getScrollX(), getScrollY(), paramInt, 0, 0, Math.max(0, i4 - i3), 0, 0, i3 / 2, 0);
        i1 = i2;
        m += 1;
        i2 = paramInt;
        paramInt = i1;
        i1 = i2;
        break;
        paramInt = i1 - i2;
        continue;
        if (n != 0) {
          paramInt = i1 - i2;
        } else {
          paramInt = i1 + i2;
        }
      }
      label756:
      n = 0;
    }
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      post(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String arg3, Bitmap paramBitmap)
  {
    if (TextUtils.isEmpty(???)) {}
    long l;
    for (;;)
    {
      return;
      if ((paramBitmap != null) || (paramInt1 <= 0))
      {
        if (paramBitmap != null) {}
        try
        {
          this.jdField_a_of_type_JavaUtilHashtable.put(paramInt2 + ":" + ???, paramBitmap);
          l = System.currentTimeMillis();
          if ((this.jdField_a_of_type_Long > 0L) && (l - this.jdField_a_of_type_Long > 300L))
          {
            paramInt2 = 1;
            if ((paramInt1 > 0) && (paramInt2 == 0)) {
              continue;
            }
            synchronized (this.jdField_a_of_type_JavaUtilHashtable)
            {
              if (this.jdField_a_of_type_JavaUtilHashtable.size() == 0) {
                return;
              }
            }
          }
        }
        catch (OutOfMemoryError ???)
        {
          for (;;)
          {
            System.gc();
            ???.printStackTrace();
            QLog.i("TabPageIndicator", 1, "onDecodeTaskCompleted error:" + ???.getMessage());
            continue;
            paramInt2 = 0;
          }
        }
      }
    }
    boolean bool;
    if (paramInt1 == 0)
    {
      this.jdField_a_of_type_Long = 0L;
      paramInt2 = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getChildCount();
      paramInt1 = 0;
      bool = false;
    }
    for (;;)
    {
      if (paramInt1 < paramInt2)
      {
        paramBitmap = this.jdField_a_of_type_Asro.a(paramInt1);
        if (paramBitmap == null)
        {
          break label429;
          this.jdField_a_of_type_Long = l;
          break;
        }
        Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getChildAt(paramInt1).getTag();
        if (!(localObject1 instanceof assq)) {
          break label429;
        }
        localObject1 = (assq)localObject1;
        int m = paramBitmap.a();
        m = ((Integer)ahnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, m, paramBitmap.a()).first).intValue();
        if (m == -2147483648) {
          break label429;
        }
        Object localObject2 = m + ":" + paramBitmap.a();
        localObject2 = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(localObject2);
        if (localObject2 == null) {
          break label429;
        }
        a((assq)localObject1, paramBitmap, new BitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), (Bitmap)localObject2));
        bool = true;
        break label429;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("TabPageIndicator", 4, "decodecomplete|faceCache size = " + this.jdField_a_of_type_JavaUtilHashtable.size() + ", isNeedUpdateAvatar=" + bool);
      }
      this.jdField_a_of_type_JavaUtilHashtable.clear();
      return;
      label429:
      paramInt1 += 1;
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt2 = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getChildCount();
    paramInt1 = 0;
    if (paramInt1 < paramInt2)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getChildAt(paramInt1);
      ((View)localObject).getLocationOnScreen(this.jdField_a_of_type_ArrayOfInt);
      paramInt3 = Math.abs(this.jdField_a_of_type_ArrayOfInt[0] - this.f);
      float f1 = paramInt3 / this.g;
      double d1;
      if (paramInt3 <= this.g) {
        d1 = jdField_b_of_type_Float;
      }
      for (f1 = Math.min((float)(Math.cos(f1 * 1.570796326794897D) * (jdField_c_of_type_Float - jdField_b_of_type_Float) + d1), jdField_c_of_type_Float);; f1 = jdField_b_of_type_Float)
      {
        localObject = ((View)localObject).getTag();
        if ((localObject instanceof assq))
        {
          localObject = (assq)localObject;
          ((assq)localObject).jdField_a_of_type_ComTencentWidgetThemeRecentDynamicAvatarView.setScaleX(f1);
          ((assq)localObject).jdField_a_of_type_ComTencentWidgetThemeRecentDynamicAvatarView.setScaleY(f1);
        }
        paramInt1 += 1;
        break;
      }
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    boolean bool;
    int m;
    if (View.MeasureSpec.getMode(paramInt1) == 1073741824)
    {
      bool = true;
      setFillViewport(bool);
      m = getMeasuredWidth();
      super.onMeasure(paramInt1, paramInt2);
      paramInt1 = getMeasuredWidth();
      if (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getChildCount() <= 0) {
        break label137;
      }
      this.g = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getChildAt(0).getMeasuredWidth();
      paramInt2 = this.e;
      int n = this.g;
      int i1 = this.f;
      this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.setPadding(this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getPaddingLeft(), this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getPaddingTop(), paramInt2 - n - i1, this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getPaddingBottom());
    }
    for (;;)
    {
      if ((bool) && (m != paramInt1)) {
        setCurrentItem(this.d);
      }
      return;
      bool = false;
      break;
      label137:
      this.g = actn.a(56.0F, getResources());
    }
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_Boolean = true;
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (c())
    {
      paramInt3 = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager.getWidth() - this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager.getPaddingLeft() - this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager.getPaddingRight() + this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager.b();
      paramInt2 = paramInt1 / this.g;
      float f1 = paramInt1 % this.g * 1.0F / this.g;
      float f2 = paramInt2 * paramInt3;
      paramInt1 = (int)(paramInt3 * f1 + f2);
      if ((this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager.b()) || (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager.a()))
      {
        f1 = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager.getScrollX() - paramInt1;
        paramInt1 = Math.abs(paramInt2 - this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager.a());
        if (QLog.isColorLevel()) {
          QLog.d("TabPageIndicator", 2, "onScrollChanged() CurrentItem = [" + this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager.a() + "], position = [" + paramInt2 + "], deltaPosition = " + paramInt1);
        }
        if (paramInt1 != 0) {
          this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager.b(paramInt2);
        }
        this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager.a(f1);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int n = 0;
    int i1 = 1;
    int m = i1;
    if (this.jdField_b_of_type_Long > 0L)
    {
      m = i1;
      if (SystemClock.uptimeMillis() - this.jdField_b_of_type_Long < 250L) {
        m = 0;
      }
    }
    if (!a()) {
      m = n;
    }
    for (;;)
    {
      if (m != 0) {
        this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
      }
      if (QLog.isColorLevel()) {
        QLog.d("TabPageIndicator", 2, "onTouchEvent() called with: ev = [" + paramMotionEvent + "]");
      }
      boolean bool = super.onTouchEvent(paramMotionEvent);
      if (QLog.isColorLevel()) {
        QLog.d("TabPageIndicator", 2, "onTouchEvent() called with: ev = [" + paramMotionEvent + "], handled = " + bool);
      }
      return bool;
    }
  }
  
  public void setCurrentItem(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TabPageIndicator", 2, "setCurrentItem() called with: item = [" + paramInt + "], mSelectedTabIndex = [" + this.d + "]");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager == null) {
      throw new IllegalStateException("ViewPager has not been bound.");
    }
    if (this.jdField_c_of_type_Int == paramInt)
    {
      c(paramInt);
      return;
    }
    this.d = paramInt;
    int n = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getChildCount();
    int m = 0;
    if (m < n)
    {
      View localView = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getChildAt(m);
      if (m == paramInt) {}
      for (boolean bool = true;; bool = false)
      {
        localView.setSelected(bool);
        if (bool) {
          c(paramInt);
        }
        if (this.jdField_c_of_type_Int == m) {
          d(this.jdField_c_of_type_Int);
        }
        m += 1;
        break;
      }
    }
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void setMultiCardContext(asro paramasro)
  {
    this.jdField_a_of_type_Asro = paramasro;
  }
  
  public void setOnActionUpNotFling(asrc paramasrc)
  {
    this.jdField_a_of_type_Asrc = paramasrc;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    super.setOnClickListener(paramOnClickListener);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void setOnPageChangeListener(asqm paramasqm)
  {
    this.jdField_a_of_type_Asqm = paramasqm;
  }
  
  public void setOnTabClickListener(asre paramasre)
  {
    this.jdField_a_of_type_Asre = paramasre;
  }
  
  public void setOnTabReselectedListener(asrf paramasrf)
  {
    this.jdField_a_of_type_Asrf = paramasrf;
  }
  
  public void setScrollState(int paramInt)
  {
    if (this.h == paramInt) {
      return;
    }
    this.h = paramInt;
    e(paramInt);
  }
  
  public void setTouchEventConsumer(asrg paramasrg)
  {
    this.jdField_a_of_type_Asrg = paramasrg;
  }
  
  public void setViewPager(MultiAIOBaseViewPager paramMultiAIOBaseViewPager)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager == paramMultiAIOBaseViewPager) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager != null) {
      this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager.setOnPageChangeListener(null);
    }
    if (paramMultiAIOBaseViewPager.a() == null) {
      throw new IllegalStateException("ViewPager does not have adapter instance.");
    }
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager = paramMultiAIOBaseViewPager;
    paramMultiAIOBaseViewPager.setOnPageChangeListener(this);
    e();
  }
  
  public void setViewPager(MultiAIOBaseViewPager paramMultiAIOBaseViewPager, int paramInt)
  {
    setViewPager(paramMultiAIOBaseViewPager);
    setCurrentItem(paramInt);
  }
  
  public void setViewPagerBusy(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int m = 1;; m = 0)
    {
      this.i = m;
      if (QLog.isColorLevel()) {
        QLog.d("TabPageIndicator", 2, "setViewPagerBusy() called with: mViewPagerBusy = " + this.i);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardPageIndicator
 * JD-Core Version:    0.7.0.1
 */