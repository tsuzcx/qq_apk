package com.tencent.mobileqq.multiaio.widget;

import ahbe;
import akaq;
import akbm;
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
import android.support.v4.view.PagerAdapter;
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
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.OverScroller;
import artu;
import arui;
import arur;
import arut;
import aruu;
import aruv;
import aruw;
import arux;
import aruy;
import aruz;
import arva;
import arvb;
import arvc;
import azwh;
import beih;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentCallItem;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.RecentDynamicAvatarView;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class TabPageIndicator
  extends HorizontalScrollView
  implements arut, azwh
{
  private static float jdField_b_of_type_Float = 1.0F;
  private static float jdField_c_of_type_Float = 1.333F;
  private float jdField_a_of_type_Float;
  private final int jdField_a_of_type_Int = 99;
  private long jdField_a_of_type_Long;
  protected ahbe a;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private arui jdField_a_of_type_Arui;
  private arur jdField_a_of_type_Arur;
  private aruy jdField_a_of_type_Aruy;
  private arva jdField_a_of_type_Arva;
  private arvb jdField_a_of_type_Arvb;
  private arvc jdField_a_of_type_Arvc;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IcsLinearLayout jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout;
  private MultiAIOBaseViewPager jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private Hashtable<String, Bitmap> jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  private List<RecentBaseData> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt = new int[2];
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private final View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new aruu(this);
  private List<aruz> jdField_b_of_type_JavaUtilList;
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
  
  public TabPageIndicator(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TabPageIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TabPageIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramInt);
  }
  
  private void a(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    setHorizontalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout = new IcsLinearLayout(paramContext, paramInt);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(getContext(), new aruv(this), new Handler(Looper.getMainLooper()));
    addView(this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout, new ViewGroup.LayoutParams(-2, -1));
    g();
    this.jdField_a_of_type_Arur.a(new aruw(this));
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
    if ((paramView instanceof arux)) {}
    for (paramView = (arux)paramView;; paramView = null)
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
  
  private void a(arux paramarux, RecentBaseData paramRecentBaseData, Drawable paramDrawable)
  {
    if ((paramarux == null) || (paramRecentBaseData == null)) {
      return;
    }
    Drawable localDrawable = paramDrawable;
    int m;
    if (paramDrawable == null)
    {
      m = paramRecentBaseData.a();
      if ((!(paramRecentBaseData instanceof RecentCallItem)) || (!((RecentCallItem)paramRecentBaseData).b())) {
        break label68;
      }
      m = 3002;
    }
    label68:
    for (;;)
    {
      localDrawable = this.jdField_a_of_type_Ahbe.a(m, paramRecentBaseData.a());
      b(paramarux, paramRecentBaseData, localDrawable);
      return;
    }
  }
  
  private void b(arux paramarux, RecentBaseData paramRecentBaseData, Drawable paramDrawable)
  {
    if ((paramarux == null) || (paramRecentBaseData == null)) {
      if (QLog.isColorLevel()) {
        QLog.i("TabPageIndicator", 2, "holder|param invalidate");
      }
    }
    label173:
    label201:
    label364:
    label373:
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MultiAioFragment", 2, "getView position: ");
      }
      int n;
      int m;
      boolean bool;
      if (a(paramRecentBaseData))
      {
        if (QLog.isColorLevel()) {
          QLog.i("TabPageIndicator", 2, "bindview user:" + paramRecentBaseData.a());
        }
        n = ((Integer)ahbe.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData.a(), paramRecentBaseData.a()).first).intValue();
        m = n;
        if (n == 103) {
          m = 1;
        }
        RecentDynamicAvatarView localRecentDynamicAvatarView = paramarux.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView;
        QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        String str = paramRecentBaseData.a();
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a() == 1)
        {
          bool = true;
          localRecentDynamicAvatarView.setFaceDrawable(localQQAppInterface, paramDrawable, m, str, 100, false, bool, 0);
          paramarux.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          n = paramRecentBaseData.mUnreadNum;
          if (n <= 99) {
            break label315;
          }
          paramarux.jdField_a_of_type_JavaLangString = "99+";
          if (n <= 0) {
            break label364;
          }
          if (paramRecentBaseData.mUnreadFlag != 3) {
            break label327;
          }
          m = 2130843921;
          paramarux.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(1, null);
          paramarux.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131100173));
          label248:
          beih.a(paramarux.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, 3, n, m, 99, null);
        }
      }
      for (;;)
      {
        if ((!"1103".equals(ThemeUtil.curThemeId)) && (!"2920".equals(ThemeUtil.curThemeId))) {
          break label373;
        }
        paramarux.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837928);
        return;
        bool = false;
        break;
        paramarux.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageDrawable(paramDrawable);
        break label173;
        paramarux.jdField_a_of_type_JavaLangString = String.valueOf(n);
        break label201;
        m = 2130849057;
        paramarux.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, null);
        paramarux.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131101379));
        break label248;
        paramarux.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(4);
      }
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
    this.jdField_a_of_type_JavaLangRunnable = new TabPageIndicator.5(this, localView);
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
    if (this.jdField_b_of_type_JavaUtilList != null)
    {
      int n = this.jdField_b_of_type_JavaUtilList.size();
      int m = 0;
      while (m < n)
      {
        aruz localaruz = (aruz)this.jdField_b_of_type_JavaUtilList.get(m);
        if (localaruz != null) {
          localaruz.a(paramInt);
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
      arur localarur = new arur(getContext());
      localField.set(this, localarur);
      this.jdField_a_of_type_Arur = ((arur)localarur);
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
      this.j = artu.a(getContext(), m);
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
      QLog.d("MultiAioFragment", 2, "getView position: " + paramInt);
    }
    RecentBaseData localRecentBaseData = (RecentBaseData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    arux localarux = new arux();
    View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131493009, null);
    localarux.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)localView.findViewById(2131310999));
    localarux.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)localView.findViewById(2131312777));
    localarux.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131297252));
    localarux.jdField_a_of_type_Int = paramInt;
    localView.setTag(localarux);
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.jdField_a_of_type_Ahbe != null) {}
    for (Drawable localDrawable = this.jdField_a_of_type_Ahbe.a(localRecentBaseData);; localDrawable = null)
    {
      b(localarux, localRecentBaseData, localDrawable);
      localStringBuilder.append(localRecentBaseData.b());
      if (AppSetting.jdField_c_of_type_Boolean) {
        localView.setContentDescription(localStringBuilder.toString());
      }
      return localView;
    }
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
    if (QLog.isColorLevel()) {
      QLog.d("TabPageIndicator", 2, "onPageSelected() called with: position = [" + paramInt + "]");
    }
    setCurrentItem(paramInt);
    if (this.jdField_a_of_type_Arui != null) {
      this.jdField_a_of_type_Arui.a(paramInt);
    }
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.jdField_a_of_type_Arui != null) {
      this.jdField_a_of_type_Arui.a(paramInt1, paramFloat, paramInt2);
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
  
  public void a(arux paramarux, RecentBaseData paramRecentBaseData)
  {
    if ((paramarux == null) || (paramRecentBaseData == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("TabPageIndicator", 2, "updateItem|invalidate error");
      }
      return;
    }
    int n = paramRecentBaseData.mUnreadNum;
    int m;
    if (n > 99)
    {
      paramarux.jdField_a_of_type_JavaLangString = "99+";
      if (n <= 0) {
        break label287;
      }
      if (paramRecentBaseData.a() != 1) {
        break label170;
      }
      m = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(paramRecentBaseData.a());
      if (m != 1) {
        break label147;
      }
      paramRecentBaseData.mUnreadFlag = 1;
      label79:
      if (paramRecentBaseData.mUnreadFlag != 3) {
        break label251;
      }
      m = 2130843921;
      paramarux.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(1, null);
      paramarux.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131100173));
    }
    for (;;)
    {
      beih.a(paramarux.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, 3, n, m, 99, null);
      return;
      paramarux.jdField_a_of_type_JavaLangString = String.valueOf(n);
      break;
      label147:
      if ((m != 2) && (m != 3) && (m != 4)) {
        break label79;
      }
      paramRecentBaseData.mUnreadFlag = 3;
      break label79;
      label170:
      if (paramRecentBaseData.a() == 3000)
      {
        if (akbm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData.a(), paramRecentBaseData.a()))
        {
          paramRecentBaseData.mUnreadFlag = 3;
          break label79;
        }
        paramRecentBaseData.mUnreadFlag = 1;
        break label79;
      }
      if (paramRecentBaseData.a() != 0) {
        break label79;
      }
      if (FriendsStatusUtil.a(paramRecentBaseData.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        paramRecentBaseData.mUnreadFlag = 3;
        break label79;
      }
      paramRecentBaseData.mUnreadFlag = 1;
      break label79;
      label251:
      m = 2130849057;
      paramarux.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, null);
      paramarux.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131101379));
    }
    label287:
    paramarux.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(4);
  }
  
  public void a(aruz paramaruz)
  {
    if (this.jdField_b_of_type_JavaUtilList == null) {
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_b_of_type_JavaUtilList.add(paramaruz);
  }
  
  public void a(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramFragmentActivity;
    this.f = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimensionPixelSize(2131167003);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.setPadding(this.f, 0, this.f, 0);
    this.e = getResources().getDisplayMetrics().widthPixels;
    this.jdField_a_of_type_Ahbe = new ahbe(paramQQAppInterface, this, false);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TabPageIndicator", 2, "updateUnReadMsgState called with:");
    }
    int m = 0;
    if (m < this.jdField_a_of_type_JavaUtilList.size() - 1)
    {
      RecentBaseData localRecentBaseData = (RecentBaseData)this.jdField_a_of_type_JavaUtilList.get(m);
      Object localObject;
      if ((TextUtils.equals(paramString, localRecentBaseData.a())) && (paramInt == localRecentBaseData.a()))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        if (localObject == null) {
          break label128;
        }
        localRecentBaseData.mUnreadNum = ((akaq)localObject).a(localRecentBaseData.a(), localRecentBaseData.a());
        label102:
        if ((this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager.a() != m) || (localRecentBaseData.mUnreadNum <= 0)) {
          break label137;
        }
      }
      for (;;)
      {
        m += 1;
        break;
        label128:
        localRecentBaseData.mUnreadNum = 0;
        break label102;
        label137:
        localObject = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getChildAt(m).getTag();
        if ((localObject instanceof arux))
        {
          localObject = (arux)localObject;
          this.jdField_a_of_type_AndroidOsHandler.post(new TabPageIndicator.1(this, (arux)localObject, localRecentBaseData));
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("TabPageIndicator", 2, "updateUnReadMsgState() called with: MultiAIOHolder is null!");
        }
      }
    }
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
  
  protected boolean a(RecentBaseData paramRecentBaseData)
  {
    int m = paramRecentBaseData.a();
    return (m == 0) || (m == 1000) || (m == 1004) || (m == 1003) || (m == 10004) || (m == 1021) || (m == 1022) || (m == 1023);
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
    if (this.jdField_a_of_type_Arui != null) {
      this.jdField_a_of_type_Arui.b(paramInt);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getChildAt(this.d).getTag();
    if ((localObject instanceof arux)) {
      localObject = (arux)localObject;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      ((arux)localObject).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    ((arux)localObject).jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
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
    this.jdField_a_of_type_Boolean = false;
    int m = this.jdField_a_of_type_Arur.getFinalX();
    super.computeScroll();
    if ((this.jdField_a_of_type_Arur.getFinalX() < m) && (QLog.isColorLevel())) {
      QLog.d("TabPageIndicator", 2, "computeScroll() called afterComputeFinalX < beforeComputeFinalX");
    }
    requestLayout();
    if (this.h == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TabPageIndicator", 2, "computeScroll() ScrollX = " + getScrollX() + ", Scroller.FinialX = " + this.jdField_a_of_type_Arur.getFinalX());
      }
      if (this.jdField_a_of_type_Boolean) {
        break label187;
      }
      if (!d()) {
        break label171;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TabPageIndicator", 2, "computeScroll() mCallOnScrollChanged = false, I'm not scrolling ? Build.MANUFACTURER = " + Build.MANUFACTURER + ", Build.MODEL = " + Build.MODEL);
      }
      i();
    }
    label171:
    label187:
    while (!QLog.isColorLevel())
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("TabPageIndicator", 2, "computeScroll() isFinishScroll = false");
      return;
    }
    QLog.d("TabPageIndicator", 2, "computeScroll() mCallOnScrollChanged = true");
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Ahbe != null) {
      this.jdField_a_of_type_Ahbe.a();
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
      if (this.jdField_a_of_type_Arvc != null) {
        this.jdField_a_of_type_Arvc.b(this, paramMotionEvent);
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
        this.jdField_b_of_type_Boolean = true;
        this.jdField_c_of_type_Boolean = false;
        setScrollState(1);
      } while (!QLog.isColorLevel());
      QLog.d("TabPageIndicator", 2, "dispatchTouchEvent()  ACTION_DOWN called with: mScrollState = " + this.h);
      return bool;
    }
    if ((!this.jdField_b_of_type_Boolean) || (this.jdField_c_of_type_Boolean)) {}
    for (;;)
    {
      this.jdField_b_of_type_Boolean = false;
      setScrollState(2);
      invalidate();
      return bool;
      this.jdField_a_of_type_Arur.forceFinished(true);
      if (this.jdField_a_of_type_Aruy != null)
      {
        int m = (int)this.jdField_a_of_type_Float;
        this.jdField_a_of_type_Aruy.a(m);
      }
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.removeAllViews();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager.a();
    this.jdField_b_of_type_Int = ((PagerAdapter)localObject).getCount();
    if ((localObject instanceof MultiAIOPagerAdapter))
    {
      this.jdField_a_of_type_JavaUtilList = ((MultiAIOPagerAdapter)localObject).a();
      int m = 0;
      while (m < this.jdField_b_of_type_Int)
      {
        new LinearLayout.LayoutParams(-2, -2).gravity = 17;
        long l = SystemClock.elapsedRealtime();
        localObject = a(m);
        if (QLog.isColorLevel()) {
          QLog.d("TabPageIndicator", 2, "createView() cost " + (SystemClock.elapsedRealtime() - l) + " ms");
        }
        a((View)localObject);
        m += 1;
      }
      if (this.d > this.jdField_b_of_type_Int) {
        this.d = (this.jdField_b_of_type_Int - 1);
      }
      setCurrentItem(this.d);
      requestLayout();
    }
  }
  
  public void fling(int paramInt)
  {
    long l = SystemClock.uptimeMillis();
    this.jdField_c_of_type_Boolean = true;
    boolean bool;
    int i3;
    int i4;
    int n;
    int m;
    float f1;
    if (paramInt > 0)
    {
      bool = true;
      i3 = getWidth() - getPaddingRight() - getPaddingLeft();
      i4 = getChildAt(0).getWidth();
      this.jdField_a_of_type_Arur.fling(getScrollX(), getScrollY(), paramInt, 0, 0, Math.max(0, i4 - i3), 0, 0, i3 / 2, 0);
      n = this.jdField_a_of_type_Arur.getFinalX();
      m = n / this.g;
      f1 = n * 1.0F / this.g;
      if (QLog.isColorLevel()) {
        QLog.d("TabPageIndicator", 2, "fling() called with: getScrollX() = " + getScrollX() + ", velocityX = [" + paramInt + "], pageFloat = " + f1 + ", pageInt = " + m + ", flingFromRight2Left = " + bool + ", flingDistance = " + (n - getScrollX()));
      }
      if (!bool) {
        break label490;
      }
      if (f1 - m < 0.5F) {
        break label725;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TabPageIndicator", 2, "fling() 手向左滑 增加滑动一点到下一页");
      }
      n = 1;
      m += 1;
    }
    for (;;)
    {
      label236:
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
        QLog.d("TabPageIndicator", 2, "fling() called mPendingFinalX = [" + this.k + "], currentFinalX = [" + this.jdField_a_of_type_Arur.getFinalX() + "]");
      }
      i2 = Math.abs(this.jdField_a_of_type_Arur.getFinalX() - this.k);
      if ((paramInt != 2147483647) && (i2 > paramInt + 1)) {
        QLog.e("TabPageIndicator", 1, "fling: error state deltaDistance " + i2 + ", lastDeltaDistance = " + paramInt);
      }
      label490:
      while (i2 == 0)
      {
        this.jdField_a_of_type_Arur.forceFinished(true);
        setScrollState(2);
        super.fling(i1);
        if (QLog.isColorLevel()) {
          QLog.d("TabPageIndicator", 2, "fling() called with: velocityX = [" + i1 + "], final ScrollX = " + this.jdField_a_of_type_Arur.getFinalX() + ", exec time = " + (SystemClock.uptimeMillis() - l) + " ms");
        }
        return;
        bool = false;
        break;
        if (f1 - m >= 0.5F)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TabPageIndicator", 2, "fling() 手向右滑 增加滑动一点到下一页");
          }
          n = 0;
          m += 1;
          break label236;
        }
        n = 1;
        break label236;
      }
      while (!this.jdField_a_of_type_Arur.isFinished()) {
        this.jdField_a_of_type_Arur.forceFinished(true);
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
        this.jdField_a_of_type_Arur.fling(getScrollX(), getScrollY(), paramInt, 0, 0, Math.max(0, i4 - i3), 0, 0, i3 / 2, 0);
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
      label725:
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
        paramBitmap = (RecentBaseData)this.jdField_a_of_type_JavaUtilList.get(paramInt1);
        if (paramBitmap == null)
        {
          break label432;
          this.jdField_a_of_type_Long = l;
          break;
        }
        Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getChildAt(paramInt1).getTag();
        if (!(localObject1 instanceof arux)) {
          break label432;
        }
        localObject1 = (arux)localObject1;
        int m = paramBitmap.a();
        m = ((Integer)ahbe.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, m, paramBitmap.a()).first).intValue();
        if (m == -2147483648) {
          break label432;
        }
        Object localObject2 = m + ":" + paramBitmap.a();
        localObject2 = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(localObject2);
        if (localObject2 == null) {
          break label432;
        }
        a((arux)localObject1, paramBitmap, new BitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), (Bitmap)localObject2));
        bool = true;
        break label432;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("TabPageIndicator", 4, "decodecomplete|faceCache size = " + this.jdField_a_of_type_JavaUtilHashtable.size() + ", isNeedUpdateAvatar=" + bool);
      }
      this.jdField_a_of_type_JavaUtilHashtable.clear();
      return;
      label432:
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
        if ((localObject instanceof arux))
        {
          localObject = (arux)localObject;
          ((arux)localObject).jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setScaleX(f1);
          ((arux)localObject).jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setScaleY(f1);
        }
        paramInt1 += 1;
        break;
      }
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (View.MeasureSpec.getMode(paramInt1) == 1073741824) {}
    for (boolean bool = true;; bool = false)
    {
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
        this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.setPadding(this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getPaddingLeft(), this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getPaddingTop(), paramInt2 - n - i1, this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getPaddingBottom());
      }
      if ((bool) && (m != paramInt1)) {
        setCurrentItem(this.d);
      }
      return;
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
  
  public void setOnActionUpNotFling(aruy paramaruy)
  {
    this.jdField_a_of_type_Aruy = paramaruy;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    super.setOnClickListener(paramOnClickListener);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void setOnPageChangeListener(arui paramarui)
  {
    this.jdField_a_of_type_Arui = paramarui;
  }
  
  public void setOnTabClickListener(arva paramarva)
  {
    this.jdField_a_of_type_Arva = paramarva;
  }
  
  public void setOnTabReselectedListener(arvb paramarvb)
  {
    this.jdField_a_of_type_Arvb = paramarvb;
  }
  
  public void setScrollState(int paramInt)
  {
    if (this.h == paramInt) {
      return;
    }
    this.h = paramInt;
    e(paramInt);
  }
  
  public void setTouchEventConsumer(arvc paramarvc)
  {
    this.jdField_a_of_type_Arvc = paramarvc;
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
 * Qualified Name:     com.tencent.mobileqq.multiaio.widget.TabPageIndicator
 * JD-Core Version:    0.7.0.1
 */