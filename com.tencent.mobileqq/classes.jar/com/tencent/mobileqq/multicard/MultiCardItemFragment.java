package com.tencent.mobileqq.multicard;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import axfy;
import axga;
import axge;
import axho;
import axhp;
import axhy;
import bdla;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;

public class MultiCardItemFragment
  extends PublicBaseFragment
  implements axho
{
  public static final axhy<MultiCardRootLayout> a;
  public static final axhy<axga> b;
  public static final axhy<axhp> c;
  public static final axhy<View> d;
  private int jdField_a_of_type_Int;
  private axfy jdField_a_of_type_Axfy;
  private axge jdField_a_of_type_Axge;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
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
    jdField_a_of_type_Axhy = new axhy();
    jdField_b_of_type_Axhy = new axhy();
    jdField_c_of_type_Axhy = new axhy();
    jdField_d_of_type_Axhy = new axhy();
  }
  
  public static View a()
  {
    View localView = null;
    if (jdField_d_of_type_Axhy != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("intimatetest", 2, "getDnaViewFromCache" + jdField_d_of_type_Axhy.a());
      }
      localView = (View)jdField_d_of_type_Axhy.a();
    }
    return localView;
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
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout == null) {
      return;
    }
    if (this.jdField_a_of_type_Axfy == null)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout);
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.b(true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.b(false);
    int i;
    if (this.jdField_a_of_type_Axfy.a() == 0) {
      if ((this.jdField_a_of_type_Axge instanceof axga))
      {
        i = 1;
        if ((getUserVisibleHint()) && (!this.jdField_c_of_type_Boolean))
        {
          if (this.jdField_a_of_type_Axge != null) {
            this.jdField_a_of_type_Axge.c();
          }
          this.jdField_c_of_type_Boolean = true;
        }
        if (i != 0) {
          break label305;
        }
      }
    }
    for (;;)
    {
      b(bool);
      return;
      a(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout);
      this.jdField_a_of_type_Axge = ((axge)jdField_b_of_type_Axhy.a());
      if (this.jdField_a_of_type_Axge == null)
      {
        this.jdField_a_of_type_Axge = new axga(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.getContext(), this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout);
        i = 0;
        break;
      }
      this.jdField_a_of_type_Axge.a(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout);
      i = 0;
      break;
      if (this.jdField_a_of_type_Axfy.a() == 1)
      {
        if ((this.jdField_a_of_type_Axge instanceof axhp))
        {
          i = 1;
          break;
        }
        a(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout);
        this.jdField_a_of_type_Axge = ((axge)jdField_c_of_type_Axhy.a());
        if (this.jdField_a_of_type_Axge == null)
        {
          this.jdField_a_of_type_Axge = new axhp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.getContext(), this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout);
          i = 0;
          break;
        }
        this.jdField_a_of_type_Axge.a(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout);
        if (QLog.isColorLevel()) {
          QLog.d("MultiCardItemFragment", 2, "reuse strangerdelegate");
        }
      }
      i = 0;
      break;
      label305:
      bool = false;
    }
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
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout = ((MultiCardRootLayout)jdField_a_of_type_Axhy.a());
      if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout = ((MultiCardRootLayout)paramLayoutInflater.inflate(2131559332, paramViewGroup, false));
        if (QLog.isColorLevel()) {
          QLog.d("MultiCardItemFragment", 2, "create rootView ");
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.setListener(this);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MultiCardItemFragment", 2, "reuse cache rootView ");
      }
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.removeAllViews();
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("MultiCardItemFragment", 2, "rootview is valid");
      }
    }
  }
  
  private void a(ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_Axge != null) && (this.jdField_a_of_type_Axge.a() != null))
    {
      if (paramViewGroup != null) {
        paramViewGroup.removeView(this.jdField_a_of_type_Axge.a());
      }
      if (!(this.jdField_a_of_type_Axge instanceof axga)) {
        break label111;
      }
      jdField_b_of_type_Axhy.a((axga)this.jdField_a_of_type_Axge);
    }
    for (;;)
    {
      this.jdField_a_of_type_Axge = null;
      if (QLog.isColorLevel()) {
        QLog.d("MultiCardItemFragment", 2, "removeViewAndAddDelegateIntoCache, friendviewcache:" + jdField_b_of_type_Axhy.a() + " strangerviewcache:" + jdField_c_of_type_Axhy.a());
      }
      return;
      label111:
      if ((this.jdField_a_of_type_Axge instanceof axhp)) {
        jdField_c_of_type_Axhy.a((axhp)this.jdField_a_of_type_Axge);
      }
    }
  }
  
  public static void a(ViewGroup paramViewGroup, View paramView)
  {
    if ((paramViewGroup != null) && (paramView != null))
    {
      paramViewGroup.removeView(paramView);
      if ((paramView != null) && (jdField_d_of_type_Axhy != null))
      {
        jdField_d_of_type_Axhy.a(paramView);
        if (QLog.isColorLevel()) {
          QLog.d("intimatetest", 2, "removeViewAndAddDnaViewToCache" + jdField_d_of_type_Axhy.a());
        }
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("intimatetest", 2, "removeViewAndAddDnaViewToCache in vie null");
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout == null) {}
    do
    {
      return;
      localObject = getParentFragment();
    } while ((localObject == null) || (!(localObject instanceof MultiCardFragment)));
    Object localObject = ((MultiCardFragment)localObject).a();
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
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Axge != null)
    {
      Object localObject = new Bundle();
      ((Bundle)localObject).putString("uin", this.jdField_a_of_type_Axfy.a());
      ((Bundle)localObject).putString("troopuin", this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Axge.a(this);
      this.jdField_a_of_type_Axge.a((Bundle)localObject);
      if (paramBoolean)
      {
        this.jdField_a_of_type_Axge.a(null);
        this.jdField_a_of_type_Boolean = true;
      }
      this.jdField_a_of_type_Axge.a(this.jdField_a_of_type_Axfy);
      localObject = getParentFragment();
      if ((localObject != null) && ((localObject instanceof MultiCardFragment)))
      {
        paramBoolean = ((MultiCardFragment)localObject).a();
        this.jdField_a_of_type_Axge.a(paramBoolean);
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a(axfy paramaxfy)
  {
    if ((this.jdField_a_of_type_Axfy == null) && (paramaxfy == null)) {}
    while ((this.jdField_a_of_type_Axfy != null) && (paramaxfy != null) && (paramaxfy.a() <= this.jdField_a_of_type_Axfy.a())) {
      return;
    }
    this.jdField_a_of_type_Axfy = paramaxfy;
    a();
  }
  
  public void a(axge paramaxge)
  {
    paramaxge = getParentFragment();
    if ((paramaxge != null) && ((paramaxge instanceof MultiCardFragment)) && (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout != null) && (this.jdField_a_of_type_Axge != null)) {
      ((MultiCardFragment)paramaxge).b(this.jdField_a_of_type_Axge);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt, axfy paramaxfy, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Axfy = paramaxfy;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(MultiCardRootLayout paramMultiCardRootLayout)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout != paramMultiCardRootLayout)) {}
    do
    {
      return;
      paramMultiCardRootLayout = getParentFragment();
    } while ((this.jdField_a_of_type_Axge == null) || (paramMultiCardRootLayout == null) || (!(paramMultiCardRootLayout instanceof MultiCardFragment)));
    ((MultiCardFragment)paramMultiCardRootLayout).a(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout, this.jdField_a_of_type_Axge.a(), this.jdField_a_of_type_Axge);
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
    switch (paramInt)
    {
    }
    do
    {
      return false;
      a(true);
    } while (this.jdField_a_of_type_Axge != null);
    return true;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool1;
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        paramMotionEvent = a();
        if ((paramMotionEvent == null) || (paramMotionEvent.a() == this.jdField_a_of_type_Int)) {
          break;
        }
        return true;
        bool1 = bool2;
      } while (this.jdField_a_of_type_Axge == null);
      bool1 = bool2;
    } while (!this.jdField_a_of_type_Axge.a(paramMotionEvent.getRawX(), paramMotionEvent.getRawY()));
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Axge != null) {
      this.jdField_a_of_type_Axge.h();
    }
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardItemFragment", 2, "onCreate() called with: savedInstanceState = [" + paramBundle + "], " + this.jdField_a_of_type_Int);
    }
    Bundle localBundle = getArguments();
    if (paramBundle != null) {}
    for (;;)
    {
      a(paramBundle);
      return;
      paramBundle = localBundle;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    a(paramLayoutInflater, paramViewGroup);
    if (this.jdField_a_of_type_Axfy == null)
    {
      paramLayoutInflater = getParentFragment();
      if ((paramLayoutInflater != null) && ((paramLayoutInflater instanceof MultiCardFragment))) {
        ((MultiCardFragment)paramLayoutInflater).a(this.jdField_a_of_type_Int);
      }
    }
    a();
    paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardItemFragment", 2, "onDestroy() pos:" + this.jdField_a_of_type_Int);
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.setListener(null);
        jdField_a_of_type_Axhy.a(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout);
        this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout = null;
      }
      if (this.jdField_a_of_type_Axge != null)
      {
        this.jdField_a_of_type_Axge.g();
        a(null);
        this.f = true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("MultiCardItemFragment", 2, "onDestroy() called Exception");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardItemFragment", 2, "onDestroy() rootcache :" + jdField_a_of_type_Axhy.a() + " friendviewcache:" + jdField_b_of_type_Axhy.a() + " strangerviewcache:" + jdField_c_of_type_Axhy.a());
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardItemFragment", 2, "onDestroyView() pos:" + this.jdField_a_of_type_Int);
    }
    View localView = getView();
    if ((this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout != null) && ((localView instanceof ViewGroup)))
    {
      if ((this.jdField_a_of_type_Axge != null) && (this.jdField_a_of_type_Axge.a() != null)) {
        this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.removeView(this.jdField_a_of_type_Axge.a());
      }
      ((ViewGroup)localView).removeView(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout);
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.setListener(null);
        jdField_a_of_type_Axhy.a(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout);
        this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout = null;
      }
      if (this.jdField_a_of_type_Axge != null)
      {
        this.jdField_a_of_type_Axge.g();
        a(null);
        this.f = true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("MultiCardItemFragment", 2, "onDestroyView() called Exception");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardItemFragment", 2, "onDestroyView() rootcache :" + jdField_a_of_type_Axhy.a() + " friendviewcache:" + jdField_b_of_type_Axhy.a() + " strangerviewcache:" + jdField_c_of_type_Axhy.a());
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (this.jdField_a_of_type_Axge != null) {
      this.jdField_a_of_type_Axge.b();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardItemFragment", 2, "onPause() called " + this.jdField_a_of_type_Int);
    }
    if ((this.jdField_a_of_type_Axge != null) && (this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Boolean))
    {
      this.jdField_a_of_type_Axge.d();
      this.jdField_d_of_type_Boolean = true;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardItemFragment", 2, "onResume() called " + this.jdField_a_of_type_Int);
    }
    if ((this.jdField_a_of_type_Axge != null) && (getUserVisibleHint()))
    {
      this.jdField_a_of_type_Axge.c();
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
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardItemFragment", 2, "onStart() called " + this.jdField_a_of_type_Int);
    }
    if ((this.jdField_a_of_type_Axge != null) && (getUserVisibleHint()) && (this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Axge.e();
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardItemFragment", 2, "onStop() called");
    }
    if ((this.jdField_a_of_type_Axge != null) && (this.jdField_d_of_type_Boolean))
    {
      this.jdField_a_of_type_Axge.f();
      this.e = true;
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardItemFragment", 2, "onViewCreated() called with: view = [" + paramView + "], mPosition = [" + this.jdField_a_of_type_Int + "], savedInstanceState = " + paramBundle);
    }
    paramView.setTag(Integer.valueOf(this.jdField_a_of_type_Int));
    b();
    if ((paramView instanceof FrameLayout))
    {
      paramBundle = new MultiCardMaskView(getActivity());
      paramBundle.setId(2131371690);
      paramBundle.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      ((FrameLayout)paramView).addView(paramBundle);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (this.jdField_a_of_type_Axge != null) {
      this.jdField_a_of_type_Axge.b(paramBoolean);
    }
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardItemFragment", 2, "setUserVisibleHint() called with: isVisibleToUser = [" + paramBoolean + "] pos:" + a());
    }
    super.setUserVisibleHint(paramBoolean);
    if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout == null) {}
    do
    {
      return;
      if (paramBoolean)
      {
        bdla.b(null, "dc00898", "", "", "0X800A213", "0X800A213", 0, 0, "", "", "", "");
        if (!this.jdField_a_of_type_Boolean) {
          a();
        }
        if (!this.jdField_b_of_type_Boolean)
        {
          if (this.jdField_a_of_type_Axge != null) {
            this.jdField_a_of_type_Axge.e();
          }
          this.jdField_b_of_type_Boolean = true;
        }
        if (this.jdField_a_of_type_Axge != null) {
          this.jdField_a_of_type_Axge.c();
        }
        this.jdField_c_of_type_Boolean = true;
        return;
      }
    } while ((!this.jdField_a_of_type_Boolean) || (!this.jdField_b_of_type_Boolean) || (!this.jdField_c_of_type_Boolean));
    if (this.jdField_a_of_type_Axge != null) {
      this.jdField_a_of_type_Axge.d();
    }
    this.jdField_d_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardItemFragment
 * JD-Core Version:    0.7.0.1
 */