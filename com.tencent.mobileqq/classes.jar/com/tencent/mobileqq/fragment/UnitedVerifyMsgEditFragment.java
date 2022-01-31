package com.tencent.mobileqq.fragment;

import adeg;
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

public class UnitedVerifyMsgEditFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = 100;
  public EditText a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  AddFriendVerifyActivity.MaxBytesTextWatcher jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity$MaxBytesTextWatcher;
  public BaseActivity a;
  
  protected int a()
  {
    return 2130970630;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_Int = getArguments().getInt("VERIFY_MSG_BYTES_LIMIT", 100);
    a(getString(2131433015));
    a(2131432998, null);
    b(2131433614, this);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_e_of_type_AndroidViewView.findViewById(2131362879));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131362878));
    this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity$MaxBytesTextWatcher = new AddFriendVerifyActivity.MaxBytesTextWatcher(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidWidgetEditText);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity$MaxBytesTextWatcher);
    ThreadManager.post(new adeg(this), 8, null, true);
  }
  
  public boolean d()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setResult(0);
    boolean bool = super.d();
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.overridePendingTransition(2131034131, 2131034135);
    return bool;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_e_of_type_AndroidWidgetTextView)
    {
      paramView = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      Intent localIntent = new Intent();
      localIntent.putExtra("VERIFY_MSG", paramView);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setResult(-1, localIntent);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.overridePendingTransition(2131034131, 2131034135);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = getActivity();
  }
  
  public void onDestroyView()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity$MaxBytesTextWatcher);
    super.onDestroyView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.UnitedVerifyMsgEditFragment
 * JD-Core Version:    0.7.0.1
 */