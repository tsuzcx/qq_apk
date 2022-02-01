package com.tencent.mobileqq.extendfriend.fragment;

import android.support.v4.app.Fragment;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceView.DeleteIconClickListener;
import com.tencent.widget.XEditTextEx;

class ExtendFriendProfileEditFragment$2
  implements ExtendFriendVoiceView.DeleteIconClickListener
{
  ExtendFriendProfileEditFragment$2(ExtendFriendProfileEditFragment paramExtendFriendProfileEditFragment) {}
  
  public void a()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.a()) {
      this.a.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.b();
    }
    this.a.b = "";
    ExtendFriendProfileEditFragment.b(this.a, 0);
    Fragment localFragment = this.a.getParentFragment();
    if ((localFragment != null) && ((localFragment instanceof ExtendFriendEditFragment))) {
      ((ExtendFriendEditFragment)localFragment).a = null;
    }
    ExtendFriendProfileEditFragment.a(this.a, null);
    ExtendFriendProfileEditFragment.c(this.a);
    if (ExtendFriendProfileEditFragment.b(this.a))
    {
      ExtendFriendProfileEditFragment.a(this.a, true);
      ExtendFriendProfileEditFragment.b(this.a);
    }
    for (;;)
    {
      this.a.c = true;
      ExtendFriendProfileEditFragment.b(this.a);
      return;
      ExtendFriendProfileEditFragment.a(this.a, false);
      if ((this.a.jdField_a_of_type_JavaLangString != null) && (this.a.jdField_a_of_type_JavaLangString.equals(this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString()))) {
        ExtendFriendProfileEditFragment.a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment.2
 * JD-Core Version:    0.7.0.1
 */