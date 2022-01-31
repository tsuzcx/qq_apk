package com.tencent.mobileqq.multiaio;

import aeqq;
import aijq;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout;
import aukv;
import aukw;
import aukx;
import auky;
import aukz;
import aula;
import aulg;
import auma;
import bhtv;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.FitSystemWindowsRelativeLayout;
import com.tencent.widget.ListView;

public class MultiAIOItemFragment
  extends PublicBaseFragment
{
  private int jdField_a_of_type_Int;
  private aijq jdField_a_of_type_Aijq;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private auma jdField_a_of_type_Auma;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  private boolean d;
  private boolean e;
  private boolean f;
  
  private Intent a(Activity paramActivity)
  {
    return paramActivity.getIntent();
  }
  
  @Nullable
  private View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    aulg localaulg = a();
    if (localaulg == null)
    {
      getActivity().finish();
      return null;
    }
    this.jdField_a_of_type_Aijq = localaulg.a(this);
    if (this.jdField_a_of_type_Aijq == null)
    {
      getActivity().finish();
      return null;
    }
    if ((paramBundle == null) && (!getUserVisibleHint())) {}
    paramBundle = localaulg.a(this.jdField_a_of_type_Int);
    paramLayoutInflater = this.jdField_a_of_type_Aijq.a(paramLayoutInflater, paramBundle, paramViewGroup);
    this.jdField_a_of_type_Aijq.a();
    this.jdField_a_of_type_Boolean = true;
    if (paramLayoutInflater == null)
    {
      getActivity().finish();
      return null;
    }
    return paramLayoutInflater;
  }
  
  private aulg a()
  {
    Fragment localFragment = getParentFragment();
    if ((localFragment instanceof MultiAIOFragment)) {
      return ((MultiAIOFragment)localFragment).a();
    }
    return null;
  }
  
  private RecentBaseData a(int paramInt)
  {
    Fragment localFragment = getParentFragment();
    if ((localFragment instanceof MultiAIOFragment)) {
      return ((MultiAIOFragment)localFragment).a(paramInt);
    }
    return null;
  }
  
  private MultiAIOBaseViewPager a()
  {
    Fragment localFragment = getParentFragment();
    if ((localFragment != null) && ((localFragment instanceof MultiAIOFragment))) {
      return ((MultiAIOFragment)localFragment).a();
    }
    return null;
  }
  
  private void a()
  {
    ListView localListView = (ListView)getView().findViewById(2131369527);
    Object localObject = localListView.getOnScrollListener();
    localListView.setOnScrollListener(new auky(this, (bhtv)localObject));
    MultiAIOBaseViewPager localMultiAIOBaseViewPager = a();
    if (localMultiAIOBaseViewPager != null)
    {
      this.jdField_a_of_type_Auma = new aukz(this, (bhtv)localObject, localListView);
      localMultiAIOBaseViewPager.a(this.jdField_a_of_type_Auma);
    }
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_Aijq != null) && ((localListView instanceof ChatXListView)))
    {
      localObject = b();
      if ((localObject != null) && (localObject.length == 2) && (localObject[0] >= 0))
      {
        localListView.post(new MultiAIOItemFragment.6(this, localListView, (int[])localObject));
        this.jdField_a_of_type_Aijq.b(true);
        localListView.postDelayed(new MultiAIOItemFragment.7(this), 500L);
      }
      localListView.addOnLayoutChangeListener(new aula(this, localListView));
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Fragment localFragment = getParentFragment();
    if ((localFragment instanceof MultiAIOFragment)) {
      ((MultiAIOFragment)localFragment).a(paramInt1, paramInt2);
    }
  }
  
  private void a(Bundle paramBundle)
  {
    boolean bool = false;
    if (paramBundle != null) {
      this.jdField_a_of_type_Int = paramBundle.getInt("KEY_POSITION");
    }
    paramBundle = a(getActivity());
    Object localObject = a(this.jdField_a_of_type_Int);
    if (localObject == null)
    {
      QLog.e("MultiAIOItemFragment", 1, "initData: recentBaseData == null");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = ((RecentBaseData)localObject).a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = ((RecentBaseData)localObject).a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = ((RecentBaseData)localObject).b();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f = paramBundle.getIntExtra("key_mini_from", 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Aeqq = new aeqq();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Aeqq.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130849475);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Aeqq.jdField_a_of_type_AndroidContentResColorStateList = getResources().getColorStateList(2131165304);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int = ChatTextSizeSettingActivity.a(getActivity());
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a();
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = new Bundle();
    }
    if (!isVisible()) {
      bool = true;
    }
    paramBundle.putBoolean("KEY_DELAY_SET_READ", bool);
    paramBundle.putBoolean("KEY_IS_IN_MULTI_AIO", true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a(paramBundle);
  }
  
  private void a(View paramView)
  {
    FitSystemWindowsRelativeLayout localFitSystemWindowsRelativeLayout = (FitSystemWindowsRelativeLayout)paramView.findViewById(2131362208);
    if (localFitSystemWindowsRelativeLayout == null) {
      if (QLog.isColorLevel()) {
        QLog.d("MultiAIOItemFragment", 2, "initAIORootView() afRoot == null");
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramView.getContext(), new aukv(this), new Handler(Looper.getMainLooper()));
      localFitSystemWindowsRelativeLayout.setDispatchTouchEventListener(new aukw(this));
      localFitSystemWindowsRelativeLayout.setOnInterceptTouchEventListener(new aukx(this));
      paramView = getParentFragment();
    } while ((paramView == null) || (!(paramView instanceof MultiAIOFragment)));
    paramView = ((MultiAIOFragment)paramView).a();
    int i = paramView.getMeasuredWidth();
    int j = paramView.getPaddingLeft();
    int k = paramView.getPaddingRight();
    int m = paramView.getMeasuredHeight();
    int n = paramView.getPaddingTop();
    int i1 = paramView.getPaddingBottom();
    paramView = localFitSystemWindowsRelativeLayout.getLayoutParams();
    paramView.width = getResources().getDisplayMetrics().widthPixels;
    float f1 = (i - j - k) * 1.0F / paramView.width;
    paramView.height = ((int)((m - n - i1) * 1.0F / f1 + 0.5F));
    localFitSystemWindowsRelativeLayout.setPivotX(-1.0F);
    localFitSystemWindowsRelativeLayout.setPivotY(-1.0F);
    localFitSystemWindowsRelativeLayout.setScaleX(f1);
    localFitSystemWindowsRelativeLayout.setScaleY(f1);
  }
  
  private int[] a()
  {
    int[] arrayOfInt = new int[2];
    Fragment localFragment = getParentFragment();
    if ((localFragment instanceof MultiAIOFragment)) {
      return ((MultiAIOFragment)localFragment).b();
    }
    return arrayOfInt;
  }
  
  private int[] b()
  {
    Fragment localFragment = getParentFragment();
    if ((localFragment instanceof MultiAIOFragment)) {
      return ((MultiAIOFragment)localFragment).a();
    }
    return new int[0];
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public SessionInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  }
  
  public void a(int paramInt)
  {
    aijq localaijq;
    if (this.jdField_a_of_type_Aijq != null)
    {
      localaijq = this.jdField_a_of_type_Aijq;
      if (this.jdField_a_of_type_Int == paramInt) {
        break label35;
      }
    }
    label35:
    for (boolean bool = true;; bool = false)
    {
      localaijq.d(bool);
      this.jdField_a_of_type_Aijq.x();
      return;
    }
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_Aijq != null) && (paramInt == this.jdField_a_of_type_Int)) {
      this.jdField_a_of_type_Aijq.l();
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Aijq != null) {
      this.jdField_a_of_type_Aijq.r();
    }
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOItemFragment", 2, "onCreate() called with: savedInstanceState = [" + paramBundle + "], " + this.jdField_a_of_type_Int);
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
    return a(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOItemFragment", 2, "onDestroy() called");
    }
    try
    {
      if (this.jdField_a_of_type_Aijq != null)
      {
        this.jdField_a_of_type_Aijq.p();
        this.f = true;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MultiAIOItemFragment", 2, "onDestroy() called Exception");
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    Object localObject = getView();
    if (localObject != null)
    {
      localObject = ((View)localObject).findViewById(2131362208);
      aulg localaulg = a();
      if (localaulg != null) {
        localaulg.a((View)localObject);
      }
    }
    localObject = a();
    if (localObject != null) {
      ((MultiAIOBaseViewPager)localObject).b(this.jdField_a_of_type_Auma);
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (this.jdField_a_of_type_Aijq != null) {
      this.jdField_a_of_type_Aijq.j();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOItemFragment", 2, "onPause() called " + this.jdField_a_of_type_Int);
    }
    if ((this.jdField_a_of_type_Aijq != null) && (this.jdField_a_of_type_Boolean) && (this.b) && (this.c))
    {
      this.jdField_a_of_type_Aijq.m();
      this.d = true;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOItemFragment", 2, "onResume() called " + this.jdField_a_of_type_Int);
    }
    if ((this.jdField_a_of_type_Aijq != null) && (getUserVisibleHint()))
    {
      this.jdField_a_of_type_Aijq.k();
      this.c = true;
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
      QLog.d("MultiAIOItemFragment", 2, "onStart() called " + this.jdField_a_of_type_Int);
    }
    if ((this.jdField_a_of_type_Aijq != null) && (getUserVisibleHint()) && (this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Aijq.n();
      this.b = true;
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOItemFragment", 2, "onStop() called");
    }
    if ((this.jdField_a_of_type_Aijq != null) && (this.d))
    {
      this.jdField_a_of_type_Aijq.o();
      this.e = true;
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOItemFragment", 2, "onViewCreated() called with: view = [" + paramView + "], mPosition = [" + this.jdField_a_of_type_Int + "], savedInstanceState = " + paramBundle);
    }
    paramView.setTag(Integer.valueOf(this.jdField_a_of_type_Int));
    a(paramView);
    if ((paramView instanceof FrameLayout))
    {
      paramBundle = new View(getActivity());
      paramBundle.setId(2131370868);
      paramBundle.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      ((FrameLayout)paramView).addView(paramBundle);
    }
    if (this.jdField_a_of_type_Boolean) {
      a();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (this.jdField_a_of_type_Aijq != null) {
      this.jdField_a_of_type_Aijq.c(paramBoolean);
    }
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOItemFragment", 2, "setUserVisibleHint() called with: isVisibleToUser = [" + paramBoolean + "]");
    }
    super.setUserVisibleHint(paramBoolean);
    if (this.jdField_a_of_type_Aijq == null) {}
    do
    {
      return;
      if (paramBoolean)
      {
        this.jdField_a_of_type_Aijq.d(false);
        if (!this.jdField_a_of_type_Boolean)
        {
          View localView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
          localView = this.jdField_a_of_type_Aijq.a(null, localView, null);
          this.jdField_a_of_type_Aijq.a();
          this.jdField_a_of_type_Boolean = true;
          a(localView);
          a();
        }
        if (!this.b)
        {
          this.jdField_a_of_type_Aijq.n();
          this.b = true;
        }
        this.jdField_a_of_type_Aijq.k();
        this.c = true;
        return;
      }
      this.jdField_a_of_type_Aijq.d(true);
    } while ((!this.jdField_a_of_type_Boolean) || (!this.b) || (!this.c));
    this.jdField_a_of_type_Aijq.m();
    this.d = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.MultiAIOItemFragment
 * JD-Core Version:    0.7.0.1
 */