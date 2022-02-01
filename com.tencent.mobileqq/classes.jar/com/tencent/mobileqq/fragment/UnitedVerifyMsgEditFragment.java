package com.tencent.mobileqq.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity.MaxBytesTextWatcher;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class UnitedVerifyMsgEditFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = 100;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  AddFriendVerifyActivity.MaxBytesTextWatcher jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity$MaxBytesTextWatcher;
  BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_Int = getArguments().getInt("VERIFY_MSG_BYTES_LIMIT", 100);
    setTitle(getString(2131689609));
    setLeftButton(2131690728, null);
    setRightButton(2131690820, this);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.mContentView.findViewById(2131376446));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131376447));
    this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity$MaxBytesTextWatcher = new AddFriendVerifyActivity.MaxBytesTextWatcher(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidWidgetEditText);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity$MaxBytesTextWatcher);
    ThreadManager.post(new UnitedVerifyMsgEditFragment.1(this), 8, null, true);
  }
  
  protected int getContentLayoutId()
  {
    return 2131561573;
  }
  
  public boolean onBackEvent()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setResult(0);
    boolean bool = super.onBackEvent();
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.overridePendingTransition(2130772004, 2130772015);
    return bool;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.rightViewText)
    {
      String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      Intent localIntent = new Intent();
      localIntent.putExtra("VERIFY_MSG", str);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setResult(-1, localIntent);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.overridePendingTransition(2130772004, 2130772015);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = getBaseActivity();
  }
  
  public void onDestroyView()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity$MaxBytesTextWatcher);
    super.onDestroyView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.UnitedVerifyMsgEditFragment
 * JD-Core Version:    0.7.0.1
 */