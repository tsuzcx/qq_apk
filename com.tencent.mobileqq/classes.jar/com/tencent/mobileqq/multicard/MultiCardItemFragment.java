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
  public static final ViewCache<MultiCardRootLayout> a = new ViewCache();
  public static final ViewCache<IntimateInfoViewDelegate> b = new ViewCache();
  public static final ViewCache<StrangerIntimateViewDelegate> c = new ViewCache();
  public static final ViewCache<View> d = new ViewCache();
  private MultiCardRootLayout e;
  private MultiCardCustomViewDelegate f;
  private int g;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  private boolean m;
  private QQAppInterface n;
  private CardContent o;
  private String p;
  
  private void a(Bundle paramBundle)
  {
    if (paramBundle != null) {
      this.g = paramBundle.getInt("KEY_POSITION");
    }
  }
  
  private void a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    if (this.e == null)
    {
      this.e = ((MultiCardRootLayout)a.a());
      if (this.e == null)
      {
        this.e = ((MultiCardRootLayout)paramLayoutInflater.inflate(2131625193, paramViewGroup, false));
        if (QLog.isColorLevel()) {
          QLog.d("MultiCardItemFragment", 2, "create rootView ");
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiCardItemFragment", 2, "reuse cache rootView ");
        }
        this.e.removeAllViews();
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("MultiCardItemFragment", 2, "rootview is valid");
    }
    this.e.setListener(this);
  }
  
  private void a(ViewGroup paramViewGroup)
  {
    MultiCardCustomViewDelegate localMultiCardCustomViewDelegate = this.f;
    if ((localMultiCardCustomViewDelegate != null) && (localMultiCardCustomViewDelegate.n() != null))
    {
      if (paramViewGroup != null) {
        paramViewGroup.removeView(this.f.n());
      }
      paramViewGroup = this.f;
      if ((paramViewGroup instanceof IntimateInfoViewDelegate)) {
        b.a((IntimateInfoViewDelegate)paramViewGroup);
      } else if ((paramViewGroup instanceof StrangerIntimateViewDelegate)) {
        c.a((StrangerIntimateViewDelegate)paramViewGroup);
      }
      this.f = null;
    }
    if (QLog.isColorLevel())
    {
      paramViewGroup = new StringBuilder();
      paramViewGroup.append("removeViewAndAddDelegateIntoCache, friendviewcache:");
      paramViewGroup.append(b.c());
      paramViewGroup.append(" strangerviewcache:");
      paramViewGroup.append(c.c());
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
        paramViewGroup = d;
        if (paramViewGroup != null)
        {
          paramViewGroup.a(paramView);
          if (QLog.isColorLevel())
          {
            paramViewGroup = new StringBuilder();
            paramViewGroup.append("removeViewAndAddDnaViewToCache");
            paramViewGroup.append(d.c());
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
  
  public static View b()
  {
    if (d != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getDnaViewFromCache");
        localStringBuilder.append(d.c());
        QLog.d("intimatetest", 2, localStringBuilder.toString());
      }
      return (View)d.a();
    }
    return null;
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.f != null)
    {
      Object localObject = new Bundle();
      ((Bundle)localObject).putString("uin", this.o.c());
      ((Bundle)localObject).putString("troopuin", this.p);
      this.f.a(this);
      this.f.b((Bundle)localObject);
      if (paramBoolean)
      {
        this.f.a(null);
        this.h = true;
      }
      this.f.a(this.o);
      localObject = getParentFragment();
      if ((localObject != null) && ((localObject instanceof MultiCardFragment)))
      {
        paramBoolean = ((MultiCardFragment)localObject).a();
        this.f.a(paramBoolean);
      }
    }
  }
  
  private void c()
  {
    Object localObject = this.e;
    if (localObject == null) {
      return;
    }
    if (this.o == null)
    {
      a((ViewGroup)localObject);
      this.e.b(true);
      return;
    }
    int i2 = 0;
    ((MultiCardRootLayout)localObject).b(false);
    if (this.o.a() == 0) {
      if (!(this.f instanceof IntimateInfoViewDelegate)) {}
    }
    int i1;
    do
    {
      i1 = 1;
      break;
      a(this.e);
      this.f = ((MultiCardCustomViewDelegate)b.a());
      localObject = this.f;
      if (localObject == null)
      {
        this.f = new IntimateInfoViewDelegate(this.n, getBaseActivity(), this.e.getContext(), this.e);
        i1 = i2;
        break;
      }
      ((MultiCardCustomViewDelegate)localObject).a(this.e);
      i1 = i2;
      break;
      i1 = i2;
      if (this.o.a() != 1) {
        break;
      }
    } while ((this.f instanceof StrangerIntimateViewDelegate));
    a(this.e);
    this.f = ((MultiCardCustomViewDelegate)c.a());
    localObject = this.f;
    if (localObject == null)
    {
      this.f = new StrangerIntimateViewDelegate(this.n, getBaseActivity(), this.e.getContext(), this.e);
      i1 = i2;
    }
    else
    {
      ((MultiCardCustomViewDelegate)localObject).a(this.e);
      i1 = i2;
      if (QLog.isColorLevel())
      {
        QLog.d("MultiCardItemFragment", 2, "reuse strangerdelegate");
        i1 = i2;
      }
    }
    if ((getUserVisibleHint()) && (!this.j))
    {
      localObject = this.f;
      if (localObject != null) {
        ((MultiCardCustomViewDelegate)localObject).c();
      }
      this.j = true;
    }
    b(i1 ^ 0x1);
  }
  
  private void d()
  {
    if (this.e == null) {
      return;
    }
    Object localObject = getParentFragment();
    if ((localObject != null) && ((localObject instanceof MultiCardFragment)))
    {
      localObject = ((MultiCardFragment)localObject).b();
      int i1 = ((MultiAIOBaseViewPager)localObject).getMeasuredWidth();
      int i2 = ((MultiAIOBaseViewPager)localObject).getPaddingLeft();
      int i3 = ((MultiAIOBaseViewPager)localObject).getPaddingRight();
      int i4 = ((MultiAIOBaseViewPager)localObject).getMeasuredHeight();
      int i5 = ((MultiAIOBaseViewPager)localObject).getPaddingTop();
      int i6 = ((MultiAIOBaseViewPager)localObject).getPaddingBottom();
      localObject = this.e.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = getResources().getDisplayMetrics().widthPixels;
      float f1 = (i1 - i2 - i3) * 1.0F / ((ViewGroup.LayoutParams)localObject).width;
      ((ViewGroup.LayoutParams)localObject).height = ((int)((i4 - i5 - i6) * 1.0F / f1 + 0.5F));
      this.e.setPivotX(-1.0F);
      this.e.setPivotY(-1.0F);
      this.e.setScaleX(f1);
      this.e.setScaleY(f1);
    }
  }
  
  private MultiAIOBaseViewPager e()
  {
    Fragment localFragment = getParentFragment();
    if ((localFragment != null) && ((localFragment instanceof MultiCardFragment))) {
      return ((MultiCardFragment)localFragment).b();
    }
    return null;
  }
  
  public int a()
  {
    return this.g;
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt, CardContent paramCardContent, String paramString)
  {
    this.n = paramQQAppInterface;
    this.g = paramInt;
    this.o = paramCardContent;
    this.p = paramString;
  }
  
  public void a(CardContent paramCardContent)
  {
    if ((this.o == null) && (paramCardContent == null)) {
      return;
    }
    if ((this.o != null) && (paramCardContent != null) && (paramCardContent.b() <= this.o.b())) {
      return;
    }
    this.o = paramCardContent;
    c();
  }
  
  public void a(MultiCardCustomViewDelegate paramMultiCardCustomViewDelegate)
  {
    paramMultiCardCustomViewDelegate = getParentFragment();
    if ((paramMultiCardCustomViewDelegate != null) && ((paramMultiCardCustomViewDelegate instanceof MultiCardFragment)) && (this.e != null))
    {
      MultiCardCustomViewDelegate localMultiCardCustomViewDelegate = this.f;
      if (localMultiCardCustomViewDelegate != null) {
        ((MultiCardFragment)paramMultiCardCustomViewDelegate).b(localMultiCardCustomViewDelegate);
      }
    }
  }
  
  public void a(MultiCardRootLayout paramMultiCardRootLayout)
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      if (localObject != paramMultiCardRootLayout) {
        return;
      }
      paramMultiCardRootLayout = getParentFragment();
      localObject = this.f;
      if ((localObject != null) && (paramMultiCardRootLayout != null) && ((paramMultiCardRootLayout instanceof MultiCardFragment))) {
        ((MultiCardFragment)paramMultiCardRootLayout).a(this.e, ((MultiCardCustomViewDelegate)localObject).n(), this.f);
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
      if (this.f == null) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getActionMasked();
    if (i1 != 1)
    {
      if (i1 != 2) {
        return false;
      }
      paramMotionEvent = e();
      return (paramMotionEvent != null) && (paramMotionEvent.getCurrentItem() != this.g);
    }
    MultiCardCustomViewDelegate localMultiCardCustomViewDelegate = this.f;
    return (localMultiCardCustomViewDelegate == null) || (!localMultiCardCustomViewDelegate.a(paramMotionEvent.getRawX(), paramMotionEvent.getRawY()));
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    MultiCardCustomViewDelegate localMultiCardCustomViewDelegate = this.f;
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
      ((StringBuilder)localObject).append(this.g);
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
    if (this.o == null)
    {
      paramLayoutInflater = getParentFragment();
      if ((paramLayoutInflater != null) && ((paramLayoutInflater instanceof MultiCardFragment))) {
        ((MultiCardFragment)paramLayoutInflater).a(this.g);
      }
    }
    c();
    paramLayoutInflater = new FrameLayout(getBaseActivity());
    paramLayoutInflater.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    paramLayoutInflater.addView(this.e);
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
      localStringBuilder.append(this.g);
      QLog.d("MultiCardItemFragment", 2, localStringBuilder.toString());
    }
    try
    {
      if (this.e != null)
      {
        this.e.setListener(null);
        a.a(this.e);
        this.e = null;
      }
      if (this.f == null) {
        break label111;
      }
      this.f.g();
      a(null);
      this.m = true;
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
      localStringBuilder.append(a.c());
      localStringBuilder.append(" friendviewcache:");
      localStringBuilder.append(b.c());
      localStringBuilder.append(" strangerviewcache:");
      localStringBuilder.append(c.c());
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
      ((StringBuilder)localObject).append(this.g);
      QLog.d("MultiCardItemFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = getView();
    if ((this.e != null) && ((localObject instanceof ViewGroup)))
    {
      MultiCardCustomViewDelegate localMultiCardCustomViewDelegate = this.f;
      if ((localMultiCardCustomViewDelegate != null) && (localMultiCardCustomViewDelegate.n() != null)) {
        this.e.removeView(this.f.n());
      }
      ((ViewGroup)localObject).removeView(this.e);
    }
    try
    {
      if (this.e != null)
      {
        this.e.setListener(null);
        a.a(this.e);
        this.e = null;
      }
      if (this.f == null) {
        break label171;
      }
      this.f.g();
      a(null);
      this.m = true;
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
      ((StringBuilder)localObject).append(a.c());
      ((StringBuilder)localObject).append(" friendviewcache:");
      ((StringBuilder)localObject).append(b.c());
      ((StringBuilder)localObject).append(" strangerviewcache:");
      ((StringBuilder)localObject).append(c.c());
      QLog.d("MultiCardItemFragment", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    paramIntent = this.f;
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
      ((StringBuilder)localObject).append(this.g);
      QLog.d("MultiCardItemFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.f;
    if ((localObject != null) && (this.h) && (this.i) && (this.j))
    {
      ((MultiCardCustomViewDelegate)localObject).d();
      this.k = true;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResume() called ");
      localStringBuilder.append(this.g);
      QLog.d("MultiCardItemFragment", 2, localStringBuilder.toString());
    }
    if ((this.f != null) && (getUserVisibleHint()))
    {
      this.f.c();
      this.j = true;
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putInt("KEY_POSITION", this.g);
  }
  
  public void onStart()
  {
    super.onStart();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStart() called ");
      localStringBuilder.append(this.g);
      QLog.d("MultiCardItemFragment", 2, localStringBuilder.toString());
    }
    if ((this.f != null) && (getUserVisibleHint()) && (this.h))
    {
      this.f.e();
      this.i = true;
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardItemFragment", 2, "onStop() called");
    }
    MultiCardCustomViewDelegate localMultiCardCustomViewDelegate = this.f;
    if ((localMultiCardCustomViewDelegate != null) && (this.k))
    {
      localMultiCardCustomViewDelegate.f();
      this.l = true;
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
      localStringBuilder.append(this.g);
      localStringBuilder.append("], savedInstanceState = ");
      localStringBuilder.append(paramBundle);
      QLog.d("MultiCardItemFragment", 2, localStringBuilder.toString());
    }
    paramView.setTag(Integer.valueOf(this.g));
    d();
    if ((paramView instanceof FrameLayout))
    {
      paramBundle = new MultiCardMaskView(getBaseActivity());
      paramBundle.setId(2131439021);
      paramBundle.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      ((FrameLayout)paramView).addView(paramBundle);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    MultiCardCustomViewDelegate localMultiCardCustomViewDelegate = this.f;
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
    if (this.e == null) {
      return;
    }
    if (paramBoolean)
    {
      ReportController.b(null, "dc00898", "", "", "0X800A213", "0X800A213", 0, 0, "", "", "", "");
      if (!this.h) {
        c();
      }
      if (!this.i)
      {
        localObject = this.f;
        if (localObject != null) {
          ((MultiCardCustomViewDelegate)localObject).e();
        }
        this.i = true;
      }
      localObject = this.f;
      if (localObject != null) {
        ((MultiCardCustomViewDelegate)localObject).c();
      }
      this.j = true;
      return;
    }
    if ((this.h) && (this.i) && (this.j))
    {
      localObject = this.f;
      if (localObject != null) {
        ((MultiCardCustomViewDelegate)localObject).d();
      }
      this.k = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardItemFragment
 * JD-Core Version:    0.7.0.1
 */