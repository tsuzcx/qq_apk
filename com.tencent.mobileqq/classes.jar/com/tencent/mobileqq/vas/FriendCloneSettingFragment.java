package com.tencent.mobileqq.vas;

import akfw;
import akfz;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import bbev;
import bbpb;
import bbpc;
import bcpt;
import bcpw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import java.util.concurrent.atomic.AtomicBoolean;

public class FriendCloneSettingFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  public int a;
  private akfz jdField_a_of_type_Akfz = new bbpc(this);
  private DialogInterface.OnCancelListener jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener = new bbpb(this);
  public FragmentActivity a;
  View jdField_a_of_type_AndroidViewView;
  public bcpt a;
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
    setTitle(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131699392));
    this.leftView.setText(2131690331);
    this.mContentView.findViewById(2131368315).setOnClickListener(this);
    this.mContentView.findViewById(2131368353).setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131368316);
    this.jdField_b_of_type_AndroidViewView = this.mContentView.findViewById(2131368354);
    this.jdField_a_of_type_Bcpt = new bcpt(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131561033);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akfz);
    if (!bbev.g(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)) {
      bcpw.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, 2131692321, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
    }
    for (;;)
    {
      VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "friendscloning", "friendscloning3", "", 1, 0, 0, "", "", "");
      return;
      ((akfw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true, 257);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      this.jdField_a_of_type_Bcpt.a(0, getString(2131718668), 0, this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener);
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131561507;
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    do
    {
      return;
      if (!bbev.g(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity))
      {
        bcpw.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, 2131692321, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
        return;
      }
    } while (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    akfw localakfw = (akfw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13);
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      this.jdField_a_of_type_Bcpt.a(0, getString(2131718668), 0, this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener);
      return;
      VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "friendscloning", "friendscloning4", "", 1, 0, 0, "", "", "");
      localakfw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false, 258);
      a(0);
      continue;
      VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "friendscloning", "friendscloning5", "", 1, 0, 0, "", "", "");
      localakfw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true, 258);
      a(1);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akfz);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.vas.FriendCloneSettingFragment
 * JD-Core Version:    0.7.0.1
 */