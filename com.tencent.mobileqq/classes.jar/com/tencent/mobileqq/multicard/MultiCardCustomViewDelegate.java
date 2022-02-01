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
  private int jdField_a_of_type_Int = -1;
  public Context a;
  public Bundle a;
  public ViewGroup a;
  public BaseActivity a;
  public QQAppInterface a;
  public CardContent a;
  private MultiCardCustomLayout jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout;
  private MultiCardCustomViewDelegate.MultiCardCustomViewDelegateListener jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate$MultiCardCustomViewDelegateListener;
  public WeakReference<MultiCardItemFragment> a;
  public List<View> a;
  private boolean jdField_a_of_type_Boolean = false;
  
  public MultiCardCustomViewDelegate()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public MultiCardCustomViewDelegate(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, Context paramContext, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  private boolean a(View paramView, float paramFloat1, float paramFloat2)
  {
    if (paramView == null) {
      return false;
    }
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    int k = paramView.getMeasuredWidth();
    int m = paramView.getMeasuredHeight();
    return (paramFloat2 >= j) && (paramFloat2 <= m + j) && (paramFloat1 >= i) && (paramFloat1 <= k + i);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Bundle a()
  {
    return this.jdField_a_of_type_AndroidOsBundle;
  }
  
  public View a()
  {
    return MultiCardItemFragment.a();
  }
  
  public CardContent a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqMulticardCardContent;
  }
  
  public MultiCardCustomLayout a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout;
  }
  
  public String a()
  {
    Bundle localBundle = this.jdField_a_of_type_AndroidOsBundle;
    if (localBundle != null) {
      return localBundle.getString("troopuin");
    }
    return null;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardCustomViewDelegete", 2, "unInit");
    }
    this.jdField_a_of_type_Int = -1;
    MultiCardCustomLayout localMultiCardCustomLayout = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout;
    if (localMultiCardCustomLayout != null)
    {
      localMultiCardCustomLayout.a(false);
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.setDispatchTouchEventOnLongClickListener(null);
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentMobileqqMulticardCardContent = null;
    this.jdField_a_of_type_AndroidViewViewGroup = null;
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_AndroidOsBundle = null;
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
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout = ((MultiCardCustomLayout)paramView);
    paramView = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout;
    if ((paramView != null) && (paramView != null)) {
      paramView.setDispatchTouchEventOnLongClickListener(new MultiCardCustomViewDelegate.1(this));
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  public void a(ViewGroup paramViewGroup, View paramView)
  {
    MultiCardItemFragment.a(paramViewGroup, paramView);
  }
  
  public void a(CardContent paramCardContent)
  {
    this.jdField_a_of_type_ComTencentMobileqqMulticardCardContent = paramCardContent;
  }
  
  public void a(MultiCardCustomViewDelegate.MultiCardCustomViewDelegateListener paramMultiCardCustomViewDelegateListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate$MultiCardCustomViewDelegateListener = paramMultiCardCustomViewDelegateListener;
  }
  
  public void a(MultiCardItemFragment paramMultiCardItemFragment)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramMultiCardItemFragment);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    MultiCardCustomViewDelegate.MultiCardCustomViewDelegateListener localMultiCardCustomViewDelegateListener = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate$MultiCardCustomViewDelegateListener;
    if (localMultiCardCustomViewDelegateListener != null) {
      localMultiCardCustomViewDelegateListener.a(this);
    }
    return true;
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      return false;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
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
    if (this.jdField_a_of_type_Int != paramInt)
    {
      this.jdField_a_of_type_Int = paramInt;
      a(this.jdField_a_of_type_Int);
    }
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
    ViewGroup localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
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
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramView)) {
      this.jdField_a_of_type_JavaUtilList.add(paramView);
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
    this.jdField_a_of_type_AndroidViewViewGroup = null;
    this.jdField_a_of_type_ComTencentMobileqqMulticardCardContent = null;
  }
  
  public void h() {}
  
  public void i() {}
  
  public void j() {}
  
  public void k()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public boolean onLongClick(View paramView)
  {
    paramView = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate$MultiCardCustomViewDelegateListener;
    if (paramView != null) {
      paramView.a(this);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardCustomViewDelegate
 * JD-Core Version:    0.7.0.1
 */