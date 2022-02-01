package com.tencent.mobileqq.multicard;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

public class MultiCardItemFragment
  extends PublicBaseFragment
  implements MultiCardRootLayout.MultiCardRootLayoutListener
{
  public static final ViewCache<MultiCardRootLayout> a;
  public static final ViewCache<IntimateInfoViewDelegate> b;
  public static final ViewCache<StrangerIntimateViewDelegate> c;
  public static final ViewCache<View> d;
  private int jdField_a_of_type_Int;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private CardContent jdField_a_of_type_ComTencentMobileqqMulticardCardContent;
  private MultiCardCustomViewDelegate jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate;
  private MultiCardRootLayout jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  private boolean d;
  private boolean e;
  private boolean f;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqMulticardViewCache = new ViewCache();
    jdField_b_of_type_ComTencentMobileqqMulticardViewCache = new ViewCache();
    jdField_c_of_type_ComTencentMobileqqMulticardViewCache = new ViewCache();
    jdField_d_of_type_ComTencentMobileqqMulticardViewCache = new ViewCache();
  }
  
  public static View a()
  {
    if (jdField_d_of_type_ComTencentMobileqqMulticardViewCache != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getDnaViewFromCache");
        localStringBuilder.append(jdField_d_of_type_ComTencentMobileqqMulticardViewCache.a());
        QLog.d("intimatetest", 2, localStringBuilder.toString());
      }
      return (View)jdField_d_of_type_ComTencentMobileqqMulticardViewCache.a();
    }
    return null;
  }
  
  private MultiAIOBaseViewPager a()
  {
    Fragment localFragment = getParentFragment();
    if ((localFragment != null) && ((localFragment instanceof MultiCardFragment))) {
      return ((MultiCardFragment)localFragment).a();
    }
    return null;
  }
  
  private void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout;
    if (localObject == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMulticardCardContent == null)
    {
      a((ViewGroup)localObject);
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.b(true);
      return;
    }
    int j = 0;
    ((MultiCardRootLayout)localObject).b(false);
    if (this.jdField_a_of_type_ComTencentMobileqqMulticardCardContent.a() == 0) {
      if (!(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate instanceof IntimateInfoViewDelegate)) {}
    }
    int i;
    do
    {
      i = 1;
      break;
      a(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout);
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate = ((MultiCardCustomViewDelegate)jdField_b_of_type_ComTencentMobileqqMulticardViewCache.a());
      localObject = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate;
      if (localObject == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate = new IntimateInfoViewDelegate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.getContext(), this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout);
        i = j;
        break;
      }
      ((MultiCardCustomViewDelegate)localObject).a(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout);
      i = j;
      break;
      i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqMulticardCardContent.a() != 1) {
        break;
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate instanceof StrangerIntimateViewDelegate));
    a(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout);
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate = ((MultiCardCustomViewDelegate)jdField_c_of_type_ComTencentMobileqqMulticardViewCache.a());
    localObject = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate;
    if (localObject == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate = new StrangerIntimateViewDelegate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.getContext(), this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout);
      i = j;
    }
    else
    {
      ((MultiCardCustomViewDelegate)localObject).a(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout);
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("MultiCardItemFragment", 2, "reuse strangerdelegate");
        i = j;
      }
    }
    if ((getUserVisibleHint()) && (!this.jdField_c_of_type_Boolean))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate;
      if (localObject != null) {
        ((MultiCardCustomViewDelegate)localObject).c();
      }
      this.jdField_c_of_type_Boolean = true;
    }
    b(i ^ 0x1);
  }
  
  private void a(Bundle paramBundle)
  {
    if (paramBundle != null) {
      this.jdField_a_of_type_Int = paramBundle.getInt("KEY_POSITION");
    }
  }
  
  private void a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout = ((MultiCardRootLayout)jdField_a_of_type_ComTencentMobileqqMulticardViewCache.a());
      if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout = ((MultiCardRootLayout)paramLayoutInflater.inflate(2131559272, paramViewGroup, false));
        if (QLog.isColorLevel()) {
          QLog.d("MultiCardItemFragment", 2, "create rootView ");
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiCardItemFragment", 2, "reuse cache rootView ");
        }
        this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.removeAllViews();
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("MultiCardItemFragment", 2, "rootview is valid");
    }
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.setListener(this);
  }
  
  private void a(ViewGroup paramViewGroup)
  {
    MultiCardCustomViewDelegate localMultiCardCustomViewDelegate = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate;
    if ((localMultiCardCustomViewDelegate != null) && (localMultiCardCustomViewDelegate.a() != null))
    {
      if (paramViewGroup != null) {
        paramViewGroup.removeView(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate.a());
      }
      paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate;
      if ((paramViewGroup instanceof IntimateInfoViewDelegate)) {
        jdField_b_of_type_ComTencentMobileqqMulticardViewCache.a((IntimateInfoViewDelegate)paramViewGroup);
      } else if ((paramViewGroup instanceof StrangerIntimateViewDelegate)) {
        jdField_c_of_type_ComTencentMobileqqMulticardViewCache.a((StrangerIntimateViewDelegate)paramViewGroup);
      }
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate = null;
    }
    if (QLog.isColorLevel())
    {
      paramViewGroup = new StringBuilder();
      paramViewGroup.append("removeViewAndAddDelegateIntoCache, friendviewcache:");
      paramViewGroup.append(jdField_b_of_type_ComTencentMobileqqMulticardViewCache.a());
      paramViewGroup.append(" strangerviewcache:");
      paramViewGroup.append(jdField_c_of_type_ComTencentMobileqqMulticardViewCache.a());
      QLog.d("MultiCardItemFragment", 2, paramViewGroup.toString());
    }
  }
  
  public static void a(ViewGroup paramViewGroup, View paramView)
  {
    if ((paramViewGroup != null) && (paramView != null))
    {
      paramViewGroup.removeView(paramView);
      if (paramView != null)
      {
        paramViewGroup = jdField_d_of_type_ComTencentMobileqqMulticardViewCache;
        if (paramViewGroup != null)
        {
          paramViewGroup.a(paramView);
          if (QLog.isColorLevel())
          {
            paramViewGroup = new StringBuilder();
            paramViewGroup.append("removeViewAndAddDnaViewToCache");
            paramViewGroup.append(jdField_d_of_type_ComTencentMobileqqMulticardViewCache.a());
            QLog.d("intimatetest", 2, paramViewGroup.toString());
          }
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.e("intimatetest", 2, "removeViewAndAddDnaViewToCache in vie null");
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout == null) {
      return;
    }
    Object localObject = getParentFragment();
    if ((localObject != null) && ((localObject instanceof MultiCardFragment)))
    {
      localObject = ((MultiCardFragment)localObject).a();
      int i = ((MultiAIOBaseViewPager)localObject).getMeasuredWidth();
      int j = ((MultiAIOBaseViewPager)localObject).getPaddingLeft();
      int k = ((MultiAIOBaseViewPager)localObject).getPaddingRight();
      int m = ((MultiAIOBaseViewPager)localObject).getMeasuredHeight();
      int n = ((MultiAIOBaseViewPager)localObject).getPaddingTop();
      int i1 = ((MultiAIOBaseViewPager)localObject).getPaddingBottom();
      localObject = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = getResources().getDisplayMetrics().widthPixels;
      float f1 = (i - j - k) * 1.0F / ((ViewGroup.LayoutParams)localObject).width;
      ((ViewGroup.LayoutParams)localObject).height = ((int)((m - n - i1) * 1.0F / f1 + 0.5F));
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.setPivotX(-1.0F);
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.setPivotY(-1.0F);
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.setScaleX(f1);
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.setScaleY(f1);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate != null)
    {
      Object localObject = new Bundle();
      ((Bundle)localObject).putString("uin", this.jdField_a_of_type_ComTencentMobileqqMulticardCardContent.a());
      ((Bundle)localObject).putString("troopuin", this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate.a(this);
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate.a((Bundle)localObject);
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate.a(null);
        this.jdField_a_of_type_Boolean = true;
      }
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate.a(this.jdField_a_of_type_ComTencentMobileqqMulticardCardContent);
      localObject = getParentFragment();
      if ((localObject != null) && ((localObject instanceof MultiCardFragment)))
      {
        paramBoolean = ((MultiCardFragment)localObject).a();
        this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate.a(paramBoolean);
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt, CardContent paramCardContent, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqMulticardCardContent = paramCardContent;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(CardContent paramCardContent)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqMulticardCardContent == null) && (paramCardContent == null)) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqMulticardCardContent != null) && (paramCardContent != null) && (paramCardContent.a() <= this.jdField_a_of_type_ComTencentMobileqqMulticardCardContent.a())) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqMulticardCardContent = paramCardContent;
    a();
  }
  
  public void a(MultiCardCustomViewDelegate paramMultiCardCustomViewDelegate)
  {
    paramMultiCardCustomViewDelegate = getParentFragment();
    if ((paramMultiCardCustomViewDelegate != null) && ((paramMultiCardCustomViewDelegate instanceof MultiCardFragment)) && (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout != null))
    {
      MultiCardCustomViewDelegate localMultiCardCustomViewDelegate = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate;
      if (localMultiCardCustomViewDelegate != null) {
        ((MultiCardFragment)paramMultiCardCustomViewDelegate).b(localMultiCardCustomViewDelegate);
      }
    }
  }
  
  public void a(MultiCardRootLayout paramMultiCardRootLayout)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout;
    if (localObject != null)
    {
      if (localObject != paramMultiCardRootLayout) {
        return;
      }
      paramMultiCardRootLayout = getParentFragment();
      localObject = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate;
      if ((localObject != null) && (paramMultiCardRootLayout != null) && ((paramMultiCardRootLayout instanceof MultiCardFragment))) {
        ((MultiCardFragment)paramMultiCardRootLayout).a(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout, ((MultiCardCustomViewDelegate)localObject).a(), this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Fragment localFragment = getParentFragment();
    if ((localFragment != null) && ((localFragment instanceof MultiCardFragment))) {
      ((MultiCardFragment)localFragment).a(paramBoolean);
    }
  }
  
  public boolean a(int paramInt)
  {
    if (paramInt == 0)
    {
      a(true);
      if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate == null) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i != 1)
    {
      if (i != 2) {
        return false;
      }
      paramMotionEvent = a();
      return (paramMotionEvent != null) && (paramMotionEvent.a() != this.jdField_a_of_type_Int);
    }
    MultiCardCustomViewDelegate localMultiCardCustomViewDelegate = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate;
    return (localMultiCardCustomViewDelegate == null) || (!localMultiCardCustomViewDelegate.a(paramMotionEvent.getRawX(), paramMotionEvent.getRawY()));
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    MultiCardCustomViewDelegate localMultiCardCustomViewDelegate = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate;
    if (localMultiCardCustomViewDelegate != null) {
      localMultiCardCustomViewDelegate.h();
    }
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCreate() called with: savedInstanceState = [");
      ((StringBuilder)localObject).append(paramBundle);
      ((StringBuilder)localObject).append("], ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      QLog.d("MultiCardItemFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = getArguments();
    if (paramBundle == null) {
      paramBundle = (Bundle)localObject;
    }
    a(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    a(paramLayoutInflater, paramViewGroup);
    if (this.jdField_a_of_type_ComTencentMobileqqMulticardCardContent == null)
    {
      paramLayoutInflater = getParentFragment();
      if ((paramLayoutInflater != null) && ((paramLayoutInflater instanceof MultiCardFragment))) {
        ((MultiCardFragment)paramLayoutInflater).a(this.jdField_a_of_type_Int);
      }
    }
    a();
    paramLayoutInflater = new FrameLayout(getBaseActivity());
    paramLayoutInflater.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    paramLayoutInflater.addView(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDestroy() pos:");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.d("MultiCardItemFragment", 2, localStringBuilder.toString());
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.setListener(null);
        jdField_a_of_type_ComTencentMobileqqMulticardViewCache.a(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout);
        this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate == null) {
        break label111;
      }
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate.g();
      a(null);
      this.f = true;
    }
    catch (Exception localException)
    {
      label102:
      label111:
      break label102;
    }
    QLog.e("MultiCardItemFragment", 2, "onDestroy() called Exception");
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDestroy() rootcache :");
      localStringBuilder.append(jdField_a_of_type_ComTencentMobileqqMulticardViewCache.a());
      localStringBuilder.append(" friendviewcache:");
      localStringBuilder.append(jdField_b_of_type_ComTencentMobileqqMulticardViewCache.a());
      localStringBuilder.append(" strangerviewcache:");
      localStringBuilder.append(jdField_c_of_type_ComTencentMobileqqMulticardViewCache.a());
      QLog.d("MultiCardItemFragment", 2, localStringBuilder.toString());
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDestroyView() pos:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      QLog.d("MultiCardItemFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = getView();
    if ((this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout != null) && ((localObject instanceof ViewGroup)))
    {
      MultiCardCustomViewDelegate localMultiCardCustomViewDelegate = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate;
      if ((localMultiCardCustomViewDelegate != null) && (localMultiCardCustomViewDelegate.a() != null)) {
        this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate.a());
      }
      ((ViewGroup)localObject).removeView(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout);
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.setListener(null);
        jdField_a_of_type_ComTencentMobileqqMulticardViewCache.a(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout);
        this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate == null) {
        break label171;
      }
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate.g();
      a(null);
      this.f = true;
    }
    catch (Exception localException)
    {
      label162:
      break label162;
    }
    QLog.e("MultiCardItemFragment", 2, "onDestroyView() called Exception");
    label171:
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDestroyView() rootcache :");
      ((StringBuilder)localObject).append(jdField_a_of_type_ComTencentMobileqqMulticardViewCache.a());
      ((StringBuilder)localObject).append(" friendviewcache:");
      ((StringBuilder)localObject).append(jdField_b_of_type_ComTencentMobileqqMulticardViewCache.a());
      ((StringBuilder)localObject).append(" strangerviewcache:");
      ((StringBuilder)localObject).append(jdField_c_of_type_ComTencentMobileqqMulticardViewCache.a());
      QLog.d("MultiCardItemFragment", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    paramIntent = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate;
    if (paramIntent != null) {
      paramIntent.b();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPause() called ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      QLog.d("MultiCardItemFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate;
    if ((localObject != null) && (this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Boolean))
    {
      ((MultiCardCustomViewDelegate)localObject).d();
      this.jdField_d_of_type_Boolean = true;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResume() called ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.d("MultiCardItemFragment", 2, localStringBuilder.toString());
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate != null) && (getUserVisibleHint()))
    {
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate.c();
      this.jdField_c_of_type_Boolean = true;
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putInt("KEY_POSITION", this.jdField_a_of_type_Int);
  }
  
  public void onStart()
  {
    super.onStart();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStart() called ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.d("MultiCardItemFragment", 2, localStringBuilder.toString());
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate != null) && (getUserVisibleHint()) && (this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate.e();
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardItemFragment", 2, "onStop() called");
    }
    MultiCardCustomViewDelegate localMultiCardCustomViewDelegate = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate;
    if ((localMultiCardCustomViewDelegate != null) && (this.jdField_d_of_type_Boolean))
    {
      localMultiCardCustomViewDelegate.f();
      this.e = true;
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onViewCreated() called with: view = [");
      localStringBuilder.append(paramView);
      localStringBuilder.append("], mPosition = [");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append("], savedInstanceState = ");
      localStringBuilder.append(paramBundle);
      QLog.d("MultiCardItemFragment", 2, localStringBuilder.toString());
    }
    paramView.setTag(Integer.valueOf(this.jdField_a_of_type_Int));
    b();
    if ((paramView instanceof FrameLayout))
    {
      paramBundle = new MultiCardMaskView(getBaseActivity());
      paramBundle.setId(2131371609);
      paramBundle.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      ((FrameLayout)paramView).addView(paramBundle);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    MultiCardCustomViewDelegate localMultiCardCustomViewDelegate = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate;
    if (localMultiCardCustomViewDelegate != null) {
      localMultiCardCustomViewDelegate.b(paramBoolean);
    }
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setUserVisibleHint() called with: isVisibleToUser = [");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("] pos:");
      ((StringBuilder)localObject).append(a());
      QLog.d("MultiCardItemFragment", 2, ((StringBuilder)localObject).toString());
    }
    super.setUserVisibleHint(paramBoolean);
    if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout == null) {
      return;
    }
    if (paramBoolean)
    {
      ReportController.b(null, "dc00898", "", "", "0X800A213", "0X800A213", 0, 0, "", "", "", "");
      if (!this.jdField_a_of_type_Boolean) {
        a();
      }
      if (!this.jdField_b_of_type_Boolean)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate;
        if (localObject != null) {
          ((MultiCardCustomViewDelegate)localObject).e();
        }
        this.jdField_b_of_type_Boolean = true;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate;
      if (localObject != null) {
        ((MultiCardCustomViewDelegate)localObject).c();
      }
      this.jdField_c_of_type_Boolean = true;
      return;
    }
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Boolean))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate;
      if (localObject != null) {
        ((MultiCardCustomViewDelegate)localObject).d();
      }
      this.jdField_d_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardItemFragment
 * JD-Core Version:    0.7.0.1
 */