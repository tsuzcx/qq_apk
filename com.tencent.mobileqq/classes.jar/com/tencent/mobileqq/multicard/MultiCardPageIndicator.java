package com.tencent.mobileqq.multicard;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
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
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.recent.RecentFaceDecoder;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.multiaio.utils.VelocityUtil;
import com.tencent.mobileqq.multiaio.widget.IcsLinearLayout;
import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager;
import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager.OnPageChangeListener;
import com.tencent.mobileqq.multiaio.widget.MultiAioOverScroller;
import com.tencent.mobileqq.multiaio.widget.PageIndicator;
import com.tencent.mobileqq.multiaio.widget.TabPageIndicator.OnActionUpNotFling;
import com.tencent.mobileqq.multiaio.widget.TabPageIndicator.OnPageChangeListener;
import com.tencent.mobileqq.multiaio.widget.TabPageIndicator.OnTabClickListener;
import com.tencent.mobileqq.multiaio.widget.TabPageIndicator.OnTabReselectedListener;
import com.tencent.mobileqq.multiaio.widget.TouchEventConsumer;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeRecentDynamicAvatarView;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class MultiCardPageIndicator
  extends HorizontalScrollView
  implements DecodeTaskCompletionListener, PageIndicator
{
  private static float jdField_b_of_type_Float = 1.0F;
  private static float jdField_c_of_type_Float = 1.333F;
  private float jdField_a_of_type_Float;
  private final int jdField_a_of_type_Int = 99;
  private long jdField_a_of_type_Long = 0L;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  private IcsLinearLayout jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout;
  private MultiAIOBaseViewPager.OnPageChangeListener jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$OnPageChangeListener;
  private MultiAIOBaseViewPager jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager;
  private MultiAioOverScroller jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAioOverScroller;
  private TabPageIndicator.OnActionUpNotFling jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator$OnActionUpNotFling;
  private TabPageIndicator.OnTabClickListener jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator$OnTabClickListener;
  private TabPageIndicator.OnTabReselectedListener jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator$OnTabReselectedListener;
  private TouchEventConsumer jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTouchEventConsumer;
  private MultiCardContext jdField_a_of_type_ComTencentMobileqqMulticardMultiCardContext;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private Hashtable<String, Bitmap> jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  private List<TabPageIndicator.OnPageChangeListener> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt = new int[2];
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private final View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new MultiCardPageIndicator.1(this);
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -1;
  private boolean jdField_c_of_type_Boolean;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h = 0;
  private int i = 0;
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
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
    }
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(1, paramString, 0, (byte)4);
    if (localBitmap != null) {
      return new BitmapDrawable(localBitmap);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing()) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramString, 200, false, 1, true, (byte)0, 4);
    }
    return null;
  }
  
  private void a(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    setHorizontalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout = new IcsLinearLayout(paramContext, paramInt);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(getContext(), new MultiCardPageIndicator.2(this), new Handler(Looper.getMainLooper()));
    addView(this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout, new ViewGroup.LayoutParams(-2, -1));
    g();
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAioOverScroller.a(new MultiCardPageIndicator.3(this));
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
    if ((paramView instanceof MultiCardPageIndicator.MultiAIOHolder)) {
      paramView = (MultiCardPageIndicator.MultiAIOHolder)paramView;
    } else {
      paramView = null;
    }
    if (paramView != null)
    {
      paramView = paramView.jdField_a_of_type_AndroidWidgetImageView;
      int m;
      if (paramBoolean) {
        m = 0;
      } else {
        m = 4;
      }
      paramView.setVisibility(m);
    }
  }
  
  private void a(MultiCardPageIndicator.MultiAIOHolder paramMultiAIOHolder, CardIndicator paramCardIndicator, Drawable paramDrawable)
  {
    if (paramMultiAIOHolder != null)
    {
      if (paramCardIndicator == null) {
        return;
      }
      Drawable localDrawable = paramDrawable;
      if (paramDrawable == null)
      {
        paramCardIndicator.a();
        localDrawable = a(paramCardIndicator.a());
      }
      paramDrawable = localDrawable;
      if (localDrawable == null) {
        paramDrawable = ImageUtil.e();
      }
      b(paramMultiAIOHolder, paramCardIndicator, paramDrawable);
    }
  }
  
  private void b(MultiCardPageIndicator.MultiAIOHolder paramMultiAIOHolder, CardIndicator paramCardIndicator, Drawable paramDrawable)
  {
    if ((paramMultiAIOHolder != null) && (paramCardIndicator != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiCardFragment", 2, "getView position: ");
      }
      if (a(paramCardIndicator.a()))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("bindview user:");
          ((StringBuilder)localObject).append(paramCardIndicator.a());
          QLog.i("TabPageIndicator", 2, ((StringBuilder)localObject).toString());
        }
        int m = ((Integer)RecentFaceDecoder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramCardIndicator.a(), paramCardIndicator.a()).first).intValue();
        if (m == 103) {
          m = 1;
        }
        Object localObject = paramMultiAIOHolder.jdField_a_of_type_ComTencentWidgetThemeRecentDynamicAvatarView;
        QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        paramCardIndicator = paramCardIndicator.a();
        boolean bool;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.mAutomator.a() == 1) {
          bool = true;
        } else {
          bool = false;
        }
        ((ThemeRecentDynamicAvatarView)localObject).setFaceDrawable(localQQAppInterface, paramDrawable, m, paramCardIndicator, 100, false, bool, 0);
      }
      else
      {
        paramMultiAIOHolder.jdField_a_of_type_ComTencentWidgetThemeRecentDynamicAvatarView.setImageDrawable(paramDrawable);
      }
      paramMultiAIOHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      paramMultiAIOHolder.jdField_a_of_type_JavaLangString = String.valueOf(0);
      paramMultiAIOHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(4);
      if (("1103".equals(ThemeUtil.curThemeId)) || ("2920".equals(ThemeUtil.curThemeId))) {
        paramMultiAIOHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838047);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TabPageIndicator", 2, "holder|param invalidate");
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
    Runnable localRunnable = this.jdField_a_of_type_JavaLangRunnable;
    if (localRunnable != null) {
      removeCallbacks(localRunnable);
    }
    this.jdField_a_of_type_JavaLangRunnable = new MultiCardPageIndicator.4(this, localView);
    post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  private boolean c()
  {
    int m = this.h;
    return ((m == 1) || (m == 2)) && (this.i == 0);
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
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null)
    {
      int m = 0;
      int n = ((List)localObject).size();
      while (m < n)
      {
        localObject = (TabPageIndicator.OnPageChangeListener)this.jdField_a_of_type_JavaUtilList.get(m);
        if (localObject != null) {
          ((TabPageIndicator.OnPageChangeListener)localObject).a(paramInt);
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
      if (localObject != null)
      {
        this.jdField_a_of_type_Float = ((VelocityTracker)localObject).getXVelocity();
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("TabPageIndicator", 1, "readLastInitVelocity: ", localException);
    }
  }
  
  private void f(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPageScrollStateChangedInternal() called with: state = [");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.d("TabPageIndicator", 2, localStringBuilder.toString());
    }
    if (paramInt != 0) {}
  }
  
  private void g()
  {
    try
    {
      Field localField = HorizontalScrollView.class.getDeclaredField("mScroller");
      localField.setAccessible(true);
      MultiAioOverScroller localMultiAioOverScroller = new MultiAioOverScroller(getContext());
      localField.set(this, localMultiAioOverScroller);
      this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAioOverScroller = ((MultiAioOverScroller)localMultiAioOverScroller);
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
      this.j = VelocityUtil.a(getContext(), m);
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
    while (m < i1)
    {
      View localView = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getChildAt(m);
      boolean bool;
      if (m == n) {
        bool = true;
      } else {
        bool = false;
      }
      localView.setSelected(bool);
      m += 1;
    }
    this.jdField_c_of_type_Int = n;
  }
  
  public View a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getView position: ");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("MultiCardFragment", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardContext;
    Object localObject1 = null;
    if (localObject2 == null)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getView position: ");
        ((StringBuilder)localObject1).append(paramInt);
        QLog.d("MultiCardFragment", 2, ((StringBuilder)localObject1).toString());
      }
      return null;
    }
    CardIndicator localCardIndicator = ((MultiCardContext)localObject2).a(paramInt);
    MultiCardPageIndicator.MultiAIOHolder localMultiAIOHolder = new MultiCardPageIndicator.MultiAIOHolder();
    View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558559, null);
    localMultiAIOHolder.jdField_a_of_type_ComTencentWidgetThemeRecentDynamicAvatarView = ((ThemeRecentDynamicAvatarView)localView.findViewById(2131378232));
    localMultiAIOHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)localView.findViewById(2131380161));
    localMultiAIOHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131362975));
    localMultiAIOHolder.jdField_a_of_type_Int = paramInt;
    localView.setTag(localMultiAIOHolder);
    StringBuilder localStringBuilder = new StringBuilder();
    if (localCardIndicator != null) {
      localObject1 = a(localCardIndicator.a());
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = ImageUtil.e();
    }
    b(localMultiAIOHolder, localCardIndicator, (Drawable)localObject2);
    if (localCardIndicator != null) {
      localStringBuilder.append(localCardIndicator.b());
    }
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
  
  public void a(float paramFloat)
  {
    try
    {
      Field localField = HorizontalScrollView.class.getDeclaredField("mMaximumVelocity");
      localField.setAccessible(true);
      localField.set(this, Integer.valueOf((int)(this.j * paramFloat)));
      return;
    }
    catch (Exception localException)
    {
      QLog.e("TabPageIndicator", 1, "updateMaxVelocity: ", localException);
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPageSelected() called with: position = [");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("]");
      QLog.d("TabPageIndicator", 2, ((StringBuilder)localObject).toString());
    }
    setCurrentItem(paramInt);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$OnPageChangeListener;
    if (localObject != null) {
      ((MultiAIOBaseViewPager.OnPageChangeListener)localObject).a(paramInt);
    }
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2)
  {
    MultiAIOBaseViewPager.OnPageChangeListener localOnPageChangeListener = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$OnPageChangeListener;
    if (localOnPageChangeListener != null) {
      localOnPageChangeListener.a(paramInt1, paramFloat, paramInt2);
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
  
  public void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.f = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimensionPixelSize(2131298362);
    paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout;
    int m = this.f;
    paramQQAppInterface.setPadding(m, 0, m, 0);
    this.e = getResources().getDisplayMetrics().widthPixels;
  }
  
  public void a(TabPageIndicator.OnPageChangeListener paramOnPageChangeListener)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramOnPageChangeListener);
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
    return (paramInt == 0) || (paramInt == 1000) || (paramInt == 1004) || (paramInt == 1003) || (paramInt == 10004) || (paramInt == 1021) || (paramInt == 1022) || (paramInt == 1023) || (paramInt == 10008);
  }
  
  public void b()
  {
    int n = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager.a();
    int m = 0;
    while (m < this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getChildCount())
    {
      View localView = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getChildAt(m);
      if (localView != null)
      {
        boolean bool;
        if (n == m) {
          bool = true;
        } else {
          bool = false;
        }
        a(localView, bool);
      }
      m += 1;
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" onPageScrollStateChanged  state = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("TabPageIndicator", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$OnPageChangeListener;
    if (localObject != null) {
      ((MultiAIOBaseViewPager.OnPageChangeListener)localObject).b(paramInt);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getChildAt(this.d);
    if (localObject == null) {
      return;
    }
    localObject = ((View)localObject).getTag();
    if ((localObject instanceof MultiCardPageIndicator.MultiAIOHolder)) {
      localObject = (MultiCardPageIndicator.MultiAIOHolder)localObject;
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
    int n = 0;
    this.jdField_a_of_type_Boolean = false;
    int m = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAioOverScroller.getFinalX();
    super.computeScroll();
    if ((this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAioOverScroller.getFinalX() < m) && (QLog.isColorLevel())) {
      QLog.d("TabPageIndicator", 2, "computeScroll() called afterComputeFinalX < beforeComputeFinalX");
    }
    requestLayout();
    if (this.h == 2)
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("computeScroll() ScrollX = ");
        localStringBuilder.append(getScrollX());
        localStringBuilder.append(", Scroller.FinialX = ");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAioOverScroller.getFinalX());
        QLog.d("TabPageIndicator", 2, localStringBuilder.toString());
      }
      if (!this.jdField_a_of_type_Boolean)
      {
        if (d())
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("computeScroll() mCallOnScrollChanged = false, I'm not scrolling ? Build.MANUFACTURER = ");
            localStringBuilder.append(Build.MANUFACTURER);
            localStringBuilder.append(", Build.MODEL = ");
            localStringBuilder.append(Build.MODEL);
            QLog.d("TabPageIndicator", 2, localStringBuilder.toString());
          }
          if (("HUAWEI".equalsIgnoreCase(Build.MANUFACTURER)) && ("LYA-AL00".equalsIgnoreCase(Build.MODEL)) && (this.jdField_c_of_type_Boolean)) {
            m = 1;
          } else {
            m = 0;
          }
          if (m != 0)
          {
            m = n;
            if (this.k == getScrollX()) {
              m = 1;
            }
            if (m != 0)
            {
              i();
              return;
            }
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("scrollTo() mPendingFinalX = ");
              localStringBuilder.append(this.k);
              QLog.d("TabPageIndicator", 2, localStringBuilder.toString());
            }
            scrollTo(this.k, getScrollY());
            return;
          }
          i();
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("TabPageIndicator", 2, "computeScroll() isFinishScroll = false");
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("TabPageIndicator", 2, "computeScroll() mCallOnScrollChanged = true");
      }
    }
  }
  
  public void d()
  {
    IFaceDecoder localIFaceDecoder = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localIFaceDecoder != null)
    {
      localIFaceDecoder.destory();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = null;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dispatchTouchEvent() called with: ev = [");
      ((StringBuilder)localObject).append(paramMotionEvent);
      ((StringBuilder)localObject).append("]");
      QLog.d("TabPageIndicator", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dispatchTouchEvent() called with: ev = [");
      ((StringBuilder)localObject).append(paramMotionEvent);
      ((StringBuilder)localObject).append("], handled = ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("TabPageIndicator", 2, ((StringBuilder)localObject).toString());
    }
    if (bool)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTouchEventConsumer;
      if (localObject != null) {
        ((TouchEventConsumer)localObject).b(this, paramMotionEvent);
      }
      int m = paramMotionEvent.getActionMasked();
      if (m != 0)
      {
        if ((m != 1) && (m != 3)) {
          return bool;
        }
        getParent().requestDisallowInterceptTouchEvent(false);
        if ((this.jdField_b_of_type_Boolean) && (!this.jdField_c_of_type_Boolean))
        {
          this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAioOverScroller.forceFinished(true);
          paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator$OnActionUpNotFling;
          if (paramMotionEvent != null) {
            paramMotionEvent.a((int)this.jdField_a_of_type_Float);
          }
        }
        this.jdField_b_of_type_Boolean = false;
        setScrollState(2);
        invalidate();
        return bool;
      }
      getParent().requestDisallowInterceptTouchEvent(true);
      this.jdField_b_of_type_Boolean = true;
      this.jdField_c_of_type_Boolean = false;
      setScrollState(1);
      if (QLog.isColorLevel())
      {
        paramMotionEvent = new StringBuilder();
        paramMotionEvent.append("dispatchTouchEvent()  ACTION_DOWN called with: mScrollState = ");
        paramMotionEvent.append(this.h);
        QLog.d("TabPageIndicator", 2, paramMotionEvent.toString());
      }
    }
    return bool;
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.removeAllViews();
    this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardContext.a();
    int m = 0;
    int n;
    for (;;)
    {
      n = this.jdField_b_of_type_Int;
      if (m >= n) {
        break;
      }
      new LinearLayout.LayoutParams(-2, -2).gravity = 17;
      long l = SystemClock.elapsedRealtime();
      View localView = a(m);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("createView() cost ");
        localStringBuilder.append(SystemClock.elapsedRealtime() - l);
        localStringBuilder.append(" ms");
        QLog.d("TabPageIndicator", 2, localStringBuilder.toString());
      }
      a(localView);
      m += 1;
    }
    if (this.d > n) {
      this.d = (n - 1);
    }
    setCurrentItem(this.d);
    requestLayout();
  }
  
  public void fling(int paramInt)
  {
    int m = paramInt;
    long l = SystemClock.uptimeMillis();
    this.jdField_c_of_type_Boolean = true;
    boolean bool;
    if (m > 0) {
      bool = true;
    } else {
      bool = false;
    }
    int i2 = getWidth() - getPaddingRight() - getPaddingLeft();
    int i3 = getChildAt(0).getWidth();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAioOverScroller;
    int n = getScrollX();
    int i1 = getScrollY();
    i3 -= i2;
    int i5 = Math.max(0, i3);
    int i4 = i2 / 2;
    ((MultiAioOverScroller)localObject).fling(n, i1, paramInt, 0, 0, i5, 0, 0, i4, 0);
    paramInt = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAioOverScroller.getFinalX();
    i1 = this.g;
    if (i1 == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TabPageIndicator", 2, "fling() itemwidth = 0");
      }
      return;
    }
    n = paramInt / i1;
    float f1 = paramInt * 1.0F / i1;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fling() called with: getScrollX() = ");
      ((StringBuilder)localObject).append(getScrollX());
      ((StringBuilder)localObject).append(", velocityX = [");
      ((StringBuilder)localObject).append(m);
      ((StringBuilder)localObject).append("], pageFloat = ");
      ((StringBuilder)localObject).append(f1);
      ((StringBuilder)localObject).append(", pageInt = ");
      ((StringBuilder)localObject).append(n);
      ((StringBuilder)localObject).append(", flingFromRight2Left = ");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append(", flingDistance = ");
      ((StringBuilder)localObject).append(paramInt - getScrollX());
      QLog.d("TabPageIndicator", 2, ((StringBuilder)localObject).toString());
    }
    if (bool)
    {
      paramInt = n;
      if (f1 - n >= 0.5F)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TabPageIndicator", 2, "fling() 手向左滑 增加滑动一点到下一页");
        }
        paramInt = n + 1;
        break label385;
      }
    }
    for (;;)
    {
      n = 0;
      break label388;
      paramInt = n;
      if (f1 - n < 0.5F) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TabPageIndicator", 2, "fling() 手向右滑 增加滑动一点到下一页");
      }
      paramInt = n + 1;
    }
    label385:
    n = 1;
    label388:
    i1 = paramInt;
    if (paramInt < 0) {
      i1 = 0;
    }
    this.k = (this.g * i1);
    i1 = 2147483647;
    i2 = 0;
    paramInt = m;
    m = i2;
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("fling() called mPendingFinalX = [");
        ((StringBuilder)localObject).append(this.k);
        ((StringBuilder)localObject).append("], currentFinalX = [");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAioOverScroller.getFinalX());
        ((StringBuilder)localObject).append("]");
        QLog.d("TabPageIndicator", 2, ((StringBuilder)localObject).toString());
      }
      i2 = Math.abs(this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAioOverScroller.getFinalX() - this.k);
      if ((i1 != 2147483647) && (i2 > i1 + 1))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("fling: error state deltaDistance ");
        ((StringBuilder)localObject).append(i2);
        ((StringBuilder)localObject).append(", lastDeltaDistance = ");
        ((StringBuilder)localObject).append(i1);
        QLog.e("TabPageIndicator", 1, ((StringBuilder)localObject).toString());
      }
      else
      {
        if (i2 != 0) {
          break label708;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAioOverScroller.forceFinished(true);
      setScrollState(2);
      super.fling(paramInt);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("fling() called with: velocityX = [");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append("], final ScrollX = ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAioOverScroller.getFinalX());
        ((StringBuilder)localObject).append(", exec time = ");
        ((StringBuilder)localObject).append(SystemClock.uptimeMillis() - l);
        ((StringBuilder)localObject).append(" ms");
        QLog.d("TabPageIndicator", 2, ((StringBuilder)localObject).toString());
      }
      return;
      label708:
      while (!this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAioOverScroller.isFinished()) {
        this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAioOverScroller.forceFinished(true);
      }
      if (bool ? n == 0 : n != 0) {
        paramInt -= i2;
      } else {
        paramInt += i2;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("fling() called with: try ");
        ((StringBuilder)localObject).append(m);
        ((StringBuilder)localObject).append(", velocityX = [");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append("], deltaVelocity = ");
        ((StringBuilder)localObject).append(i2);
        ((StringBuilder)localObject).append(", deltaDistance = ");
        ((StringBuilder)localObject).append(i2);
        QLog.d("TabPageIndicator", 2, ((StringBuilder)localObject).toString());
      }
      m += 1;
      this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAioOverScroller.fling(getScrollX(), getScrollY(), paramInt, 0, 0, Math.max(0, i3), 0, 0, i4, 0);
      i1 = i2;
    }
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Runnable localRunnable = this.jdField_a_of_type_JavaLangRunnable;
    if (localRunnable != null) {
      post(localRunnable);
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String arg3, Bitmap paramBitmap)
  {
    if (TextUtils.isEmpty(???)) {
      return;
    }
    if ((paramBitmap == null) && (paramInt1 > 0)) {
      return;
    }
    Object localObject1;
    Object localObject2;
    if (paramBitmap != null) {
      try
      {
        localObject1 = this.jdField_a_of_type_JavaUtilHashtable;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramInt2);
        ((StringBuilder)localObject2).append(":");
        ((StringBuilder)localObject2).append(???);
        ((Hashtable)localObject1).put(((StringBuilder)localObject2).toString(), paramBitmap);
      }
      catch (OutOfMemoryError ???)
      {
        System.gc();
        ???.printStackTrace();
        paramBitmap = new StringBuilder();
        paramBitmap.append("onDecodeTaskCompleted error:");
        paramBitmap.append(???.getMessage());
        QLog.i("TabPageIndicator", 1, paramBitmap.toString());
      }
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    int m = 0;
    if ((l2 > 0L) && (l1 - l2 > 300L)) {
      paramInt2 = 1;
    } else {
      paramInt2 = 0;
    }
    if ((paramInt1 > 0) && (paramInt2 == 0)) {
      return;
    }
    boolean bool1;
    boolean bool2;
    synchronized (this.jdField_a_of_type_JavaUtilHashtable)
    {
      if (this.jdField_a_of_type_JavaUtilHashtable.size() == 0) {
        return;
      }
      if (paramInt1 == 0) {
        this.jdField_a_of_type_Long = 0L;
      } else {
        this.jdField_a_of_type_Long = l1;
      }
      paramInt2 = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getChildCount();
      bool1 = false;
      paramInt1 = m;
      if (paramInt1 < paramInt2)
      {
        paramBitmap = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardContext.a(paramInt1);
        if (paramBitmap == null)
        {
          bool2 = bool1;
        }
        else
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getChildAt(paramInt1).getTag();
          bool2 = bool1;
          if ((localObject1 instanceof MultiCardPageIndicator.MultiAIOHolder))
          {
            localObject1 = (MultiCardPageIndicator.MultiAIOHolder)localObject1;
            m = paramBitmap.a();
            m = ((Integer)RecentFaceDecoder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, m, paramBitmap.a()).first).intValue();
            bool2 = bool1;
            if (m != -2147483648)
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(m);
              ((StringBuilder)localObject2).append(":");
              ((StringBuilder)localObject2).append(paramBitmap.a());
              localObject2 = ((StringBuilder)localObject2).toString();
              localObject2 = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(localObject2);
              bool2 = bool1;
              if (localObject2 != null)
              {
                a((MultiCardPageIndicator.MultiAIOHolder)localObject1, paramBitmap, new BitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), (Bitmap)localObject2));
                bool2 = true;
              }
            }
          }
        }
      }
      else
      {
        if (QLog.isDevelopLevel())
        {
          paramBitmap = new StringBuilder();
          paramBitmap.append("decodecomplete|faceCache size = ");
          paramBitmap.append(this.jdField_a_of_type_JavaUtilHashtable.size());
          paramBitmap.append(", isNeedUpdateAvatar=");
          paramBitmap.append(bool1);
          QLog.i("TabPageIndicator", 4, paramBitmap.toString());
        }
        this.jdField_a_of_type_JavaUtilHashtable.clear();
        return;
      }
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Runnable localRunnable = this.jdField_a_of_type_JavaLangRunnable;
    if (localRunnable != null) {
      removeCallbacks(localRunnable);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt2 = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getChildCount();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getChildAt(paramInt1);
      ((View)localObject).getLocationOnScreen(this.jdField_a_of_type_ArrayOfInt);
      paramInt3 = Math.abs(this.jdField_a_of_type_ArrayOfInt[0] - this.f);
      float f1 = paramInt3;
      paramInt4 = this.g;
      f1 /= paramInt4;
      if (paramInt3 <= paramInt4)
      {
        double d1 = jdField_b_of_type_Float;
        double d2 = f1;
        Double.isNaN(d2);
        d2 = Math.cos(d2 * 1.570796326794897D);
        f1 = jdField_c_of_type_Float;
        double d3 = f1 - jdField_b_of_type_Float;
        Double.isNaN(d3);
        Double.isNaN(d1);
        f1 = Math.min((float)(d1 + d2 * d3), f1);
      }
      else
      {
        f1 = jdField_b_of_type_Float;
      }
      localObject = ((View)localObject).getTag();
      if ((localObject instanceof MultiCardPageIndicator.MultiAIOHolder))
      {
        localObject = (MultiCardPageIndicator.MultiAIOHolder)localObject;
        ((MultiCardPageIndicator.MultiAIOHolder)localObject).jdField_a_of_type_ComTencentWidgetThemeRecentDynamicAvatarView.setScaleX(f1);
        ((MultiCardPageIndicator.MultiAIOHolder)localObject).jdField_a_of_type_ComTencentWidgetThemeRecentDynamicAvatarView.setScaleY(f1);
      }
      paramInt1 += 1;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    boolean bool;
    if (View.MeasureSpec.getMode(paramInt1) == 1073741824) {
      bool = true;
    } else {
      bool = false;
    }
    setFillViewport(bool);
    int m = getMeasuredWidth();
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = getMeasuredWidth();
    if (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getChildCount() > 0)
    {
      this.g = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getChildAt(0).getMeasuredWidth();
      paramInt2 = this.e;
      int n = this.g;
      int i1 = this.f;
      IcsLinearLayout localIcsLinearLayout = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout;
      localIcsLinearLayout.setPadding(localIcsLinearLayout.getPaddingLeft(), this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getPaddingTop(), paramInt2 - n - i1, this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getPaddingBottom());
    }
    else
    {
      this.g = AIOUtils.b(56.0F, getResources());
    }
    if ((bool) && (m != paramInt1)) {
      setCurrentItem(this.d);
    }
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_Boolean = true;
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (c())
    {
      paramInt3 = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager.getWidth() - this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager.getPaddingLeft() - this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager.getPaddingRight() + this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager.b();
      paramInt4 = this.g;
      paramInt2 = paramInt1 / paramInt4;
      float f1 = paramInt1 % paramInt4 * 1.0F / paramInt4;
      paramInt1 = (int)(paramInt2 * paramInt3 + f1 * paramInt3);
      if ((this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager.b()) || (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager.a()))
      {
        f1 = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager.getScrollX() - paramInt1;
        paramInt1 = Math.abs(paramInt2 - this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager.a());
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onScrollChanged() CurrentItem = [");
          localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager.a());
          localStringBuilder.append("], position = [");
          localStringBuilder.append(paramInt2);
          localStringBuilder.append("], deltaPosition = ");
          localStringBuilder.append(paramInt1);
          QLog.d("TabPageIndicator", 2, localStringBuilder.toString());
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
    int m;
    if ((this.jdField_b_of_type_Long > 0L) && (SystemClock.uptimeMillis() - this.jdField_b_of_type_Long < 250L)) {
      m = 0;
    } else {
      m = 1;
    }
    if (!a()) {
      m = 0;
    }
    if (m != 0) {
      this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onTouchEvent() called with: ev = [");
      localStringBuilder.append(paramMotionEvent);
      localStringBuilder.append("]");
      QLog.d("TabPageIndicator", 2, localStringBuilder.toString());
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onTouchEvent() called with: ev = [");
      localStringBuilder.append(paramMotionEvent);
      localStringBuilder.append("], handled = ");
      localStringBuilder.append(bool);
      QLog.d("TabPageIndicator", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  public void setCurrentItem(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setCurrentItem() called with: item = [");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("], mSelectedTabIndex = [");
      ((StringBuilder)localObject).append(this.d);
      ((StringBuilder)localObject).append("]");
      QLog.d("TabPageIndicator", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager != null)
    {
      if (this.jdField_c_of_type_Int == paramInt)
      {
        c(paramInt);
        return;
      }
      this.d = paramInt;
      int n = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getChildCount();
      int m = 0;
      while (m < n)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getChildAt(m);
        boolean bool;
        if (m == paramInt) {
          bool = true;
        } else {
          bool = false;
        }
        ((View)localObject).setSelected(bool);
        if (bool) {
          c(paramInt);
        }
        int i1 = this.jdField_c_of_type_Int;
        if (i1 == m) {
          d(i1);
        }
        m += 1;
      }
      this.jdField_c_of_type_Int = paramInt;
      return;
    }
    Object localObject = new IllegalStateException("ViewPager has not been bound.");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public void setMultiCardContext(MultiCardContext paramMultiCardContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardContext = paramMultiCardContext;
  }
  
  public void setOnActionUpNotFling(TabPageIndicator.OnActionUpNotFling paramOnActionUpNotFling)
  {
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator$OnActionUpNotFling = paramOnActionUpNotFling;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    super.setOnClickListener(paramOnClickListener);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void setOnPageChangeListener(MultiAIOBaseViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$OnPageChangeListener = paramOnPageChangeListener;
  }
  
  public void setOnTabClickListener(TabPageIndicator.OnTabClickListener paramOnTabClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator$OnTabClickListener = paramOnTabClickListener;
  }
  
  public void setOnTabReselectedListener(TabPageIndicator.OnTabReselectedListener paramOnTabReselectedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator$OnTabReselectedListener = paramOnTabReselectedListener;
  }
  
  public void setScrollState(int paramInt)
  {
    if (this.h == paramInt) {
      return;
    }
    this.h = paramInt;
    e(paramInt);
  }
  
  public void setTouchEventConsumer(TouchEventConsumer paramTouchEventConsumer)
  {
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTouchEventConsumer = paramTouchEventConsumer;
  }
  
  public void setViewPager(MultiAIOBaseViewPager paramMultiAIOBaseViewPager)
  {
    MultiAIOBaseViewPager localMultiAIOBaseViewPager = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager;
    if (localMultiAIOBaseViewPager == paramMultiAIOBaseViewPager) {
      return;
    }
    if (localMultiAIOBaseViewPager != null) {
      localMultiAIOBaseViewPager.setOnPageChangeListener(null);
    }
    if (paramMultiAIOBaseViewPager.a() != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager = paramMultiAIOBaseViewPager;
      paramMultiAIOBaseViewPager.setOnPageChangeListener(this);
      e();
      return;
    }
    throw new IllegalStateException("ViewPager does not have adapter instance.");
  }
  
  public void setViewPager(MultiAIOBaseViewPager paramMultiAIOBaseViewPager, int paramInt)
  {
    setViewPager(paramMultiAIOBaseViewPager);
    setCurrentItem(paramInt);
  }
  
  public void setViewPagerBusy(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardPageIndicator
 * JD-Core Version:    0.7.0.1
 */