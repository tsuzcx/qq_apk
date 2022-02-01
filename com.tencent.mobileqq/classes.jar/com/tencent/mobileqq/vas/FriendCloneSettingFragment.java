package com.tencent.mobileqq.vas;

import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import aogu;
import aogx;
import bhnv;
import bhxw;
import bhxx;
import bjbv;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.concurrent.atomic.AtomicBoolean;

public class FriendCloneSettingFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  public int a;
  private DialogInterface.OnCancelListener jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener = new bhxw(this);
  public FragmentActivity a;
  View jdField_a_of_type_AndroidViewView;
  private aogx jdField_a_of_type_Aogx = new bhxx(this);
  public bjbv a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public AtomicBoolean a;
  public int b;
  View b;
  
  public FriendCloneSettingFragment()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app;
    } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
    setTitle(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698341));
    this.leftView.setText(2131690384);
    this.mContentView.findViewById(2131368854).setOnClickListener(this);
    this.mContentView.findViewById(2131368938).setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131368855);
    this.jdField_b_of_type_AndroidViewView = this.mContentView.findViewById(2131368939);
    this.jdField_a_of_type_Bjbv = new bjbv(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131561501);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aogx);
    if (!bhnv.g(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)) {
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, 2131691989, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
    }
    for (;;)
    {
      VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "friendscloning", "friendscloning3", "", 1, 0, 0, "", "", "");
      return;
      ((aogu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true, 257);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      this.jdField_a_of_type_Bjbv.a(0, getString(2131717414), 0, this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener);
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131561992;
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (bhnv.g(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)) {
          break;
        }
        QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, 2131691989, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      }
    } while (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    aogu localaogu = (aogu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13);
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      this.jdField_a_of_type_Bjbv.a(0, getString(2131717414), 0, this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener);
      break;
      VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "friendscloning", "friendscloning4", "", 1, 0, 0, "", "", "");
      localaogu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false, 258);
      a(0);
      continue;
      VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "friendscloning", "friendscloning5", "", 1, 0, 0, "", "", "");
      localaogu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true, 258);
      a(1);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aogx);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.FriendCloneSettingFragment
 * JD-Core Version:    0.7.0.1
 */