package com.tencent.mobileqq.multicard;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MultiCardCustomViewDelegate
  implements View.OnLongClickListener
{
  private MultiCardCustomViewDelegate.MultiCardCustomViewDelegateListener a;
  public QQAppInterface b;
  public BaseActivity c;
  public Context d;
  public CardContent e;
  public ViewGroup f;
  public List<View> g = new ArrayList();
  public Bundle h;
  public WeakReference<MultiCardItemFragment> i;
  private int j = -1;
  private MultiCardCustomLayout k;
  private boolean l = false;
  
  public MultiCardCustomViewDelegate() {}
  
  public MultiCardCustomViewDelegate(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, Context paramContext, ViewGroup paramViewGroup)
  {
    this.b = paramQQAppInterface;
    this.c = paramBaseActivity;
    this.d = paramContext;
    this.f = paramViewGroup;
  }
  
  private boolean a(View paramView, float paramFloat1, float paramFloat2)
  {
    if (paramView == null) {
      return false;
    }
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int m = arrayOfInt[0];
    int n = arrayOfInt[1];
    int i1 = paramView.getMeasuredWidth();
    int i2 = paramView.getMeasuredHeight();
    return (paramFloat2 >= n) && (paramFloat2 <= i2 + n) && (paramFloat1 >= m) && (paramFloat1 <= i1 + m);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardCustomViewDelegete", 2, "unInit");
    }
    this.j = -1;
    MultiCardCustomLayout localMultiCardCustomLayout = this.k;
    if (localMultiCardCustomLayout != null)
    {
      localMultiCardCustomLayout.a(false);
      this.k.setDispatchTouchEventOnLongClickListener(null);
      this.k = null;
    }
    this.b = null;
    this.c = null;
    this.d = null;
    this.e = null;
    this.f = null;
    this.g.clear();
    this.h = null;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCardModeChanged：");
      localStringBuilder.append(paramInt);
      QLog.d("MultiCardCustomViewDelegete", 2, localStringBuilder.toString());
    }
  }
  
  public void a(View paramView)
  {
    this.k = ((MultiCardCustomLayout)paramView);
    paramView = this.k;
    if ((paramView != null) && (paramView != null)) {
      paramView.setDispatchTouchEventOnLongClickListener(new MultiCardCustomViewDelegate.1(this));
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    this.f = paramViewGroup;
  }
  
  public void a(ViewGroup paramViewGroup, View paramView)
  {
    MultiCardItemFragment.a(paramViewGroup, paramView);
  }
  
  public void a(CardContent paramCardContent)
  {
    this.e = paramCardContent;
  }
  
  public void a(MultiCardCustomViewDelegate.MultiCardCustomViewDelegateListener paramMultiCardCustomViewDelegateListener)
  {
    this.a = paramMultiCardCustomViewDelegateListener;
  }
  
  public void a(MultiCardItemFragment paramMultiCardItemFragment)
  {
    this.i = new WeakReference(paramMultiCardItemFragment);
  }
  
  public void a(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    if (this.g.size() == 0) {
      return false;
    }
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext()) {
      if (a((View)localIterator.next(), paramFloat1, paramFloat2)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardCustomViewDelegete", 2, "doOnCreate() called");
    }
    return true;
  }
  
  public void b() {}
  
  public void b(int paramInt)
  {
    if (this.j != paramInt)
    {
      this.j = paramInt;
      a(this.j);
    }
  }
  
  public void b(Bundle paramBundle)
  {
    this.h = paramBundle;
  }
  
  public void b(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (paramView.getParent() != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiCardCustomViewDelegete", 2, "infoview has parent. error!!");
      }
      if ((paramView.getParent() instanceof ViewGroup))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiCardCustomViewDelegete", 2, "infoview has parent. remove infoview");
        }
        ((ViewGroup)paramView.getParent()).removeView(paramView);
      }
    }
    ViewGroup localViewGroup = this.f;
    if (localViewGroup != null) {
      localViewGroup.addView(paramView);
    }
  }
  
  public void b(boolean paramBoolean) {}
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardCustomViewDelegete", 2, "doOnResume() called");
    }
  }
  
  public void c(View paramView)
  {
    if (!this.g.contains(paramView)) {
      this.g.add(paramView);
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardCustomViewDelegete", 2, "doOnPause() called");
    }
  }
  
  public void e() {}
  
  public void f() {}
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardCustomViewDelegete", 2, "doOnDestroy");
    }
    this.f = null;
    this.e = null;
  }
  
  public void h() {}
  
  public void i() {}
  
  public void j() {}
  
  public Bundle k()
  {
    return this.h;
  }
  
  public CardContent l()
  {
    return this.e;
  }
  
  public String m()
  {
    Bundle localBundle = this.h;
    if (localBundle != null) {
      return localBundle.getString("troopuin");
    }
    return null;
  }
  
  public MultiCardCustomLayout n()
  {
    return this.k;
  }
  
  public void o()
  {
    this.g.clear();
  }
  
  public boolean onLongClick(View paramView)
  {
    paramView = this.a;
    if (paramView != null) {
      paramView.a(this);
    }
    return true;
  }
  
  public int p()
  {
    return this.j;
  }
  
  public boolean q()
  {
    MultiCardCustomViewDelegate.MultiCardCustomViewDelegateListener localMultiCardCustomViewDelegateListener = this.a;
    if (localMultiCardCustomViewDelegateListener != null) {
      localMultiCardCustomViewDelegateListener.a(this);
    }
    return true;
  }
  
  public View r()
  {
    return MultiCardItemFragment.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardCustomViewDelegate
 * JD-Core Version:    0.7.0.1
 */