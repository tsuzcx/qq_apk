package com.tencent.mobileqq.vas;

import ajrm;
import ajrp;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import badq;
import banf;
import bang;
import bbmv;
import bbmy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import java.util.concurrent.atomic.AtomicBoolean;

public class FriendCloneSettingFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  public int a;
  private ajrp jdField_a_of_type_Ajrp = new bang(this);
  private DialogInterface.OnCancelListener jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener = new banf(this);
  public FragmentActivity a;
  View jdField_a_of_type_AndroidViewView;
  public bbmv a;
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
    setTitle(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131633624));
    this.leftView.setText(2131624770);
    this.mContentView.findViewById(2131302693).setOnClickListener(this);
    this.mContentView.findViewById(2131302729).setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131302694);
    this.jdField_b_of_type_AndroidViewView = this.mContentView.findViewById(2131302730);
    this.jdField_a_of_type_Bbmv = new bbmv(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131495446);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajrp);
    if (!badq.g(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)) {
      bbmy.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, 2131626719, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
    }
    for (;;)
    {
      VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "friendscloning", "friendscloning3", "", 1, 0, 0, "", "", "");
      return;
      ((ajrm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true, 257);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      this.jdField_a_of_type_Bbmv.a(0, getString(2131652843), 0, this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener);
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131495915;
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    do
    {
      return;
      if (!badq.g(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity))
      {
        bbmy.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, 2131626719, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
        return;
      }
    } while (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    ajrm localajrm = (ajrm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13);
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      this.jdField_a_of_type_Bbmv.a(0, getString(2131652843), 0, this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener);
      return;
      VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "friendscloning", "friendscloning4", "", 1, 0, 0, "", "", "");
      localajrm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false, 258);
      a(0);
      continue;
      VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "friendscloning", "friendscloning5", "", 1, 0, 0, "", "", "");
      localajrm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true, 258);
      a(1);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajrp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.vas.FriendCloneSettingFragment
 * JD-Core Version:    0.7.0.1
 */