package com.tencent.mobileqq.extendfriend.fragment;

import android.support.v4.app.FragmentActivity;
import android.text.SpannableStringBuilder;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class ExtendFriendCampusNewFragment$6
  implements Runnable
{
  ExtendFriendCampusNewFragment$6(ExtendFriendCampusNewFragment paramExtendFriendCampusNewFragment) {}
  
  public void run()
  {
    if (this.this$0.a == null) {
      this.this$0.a = DialogUtil.a(ExtendFriendCampusNewFragment.a(this.this$0), 230);
    }
    SpannableStringBuilder localSpannableStringBuilder = ExtendFriendManager.a(ExtendFriendCampusNewFragment.a(this.this$0), this.this$0.getActivity().getString(2131698744), false, ExtendFriendCampusNewFragment.a(this.this$0));
    this.this$0.a.setTitle(ExtendFriendCampusNewFragment.a(this.this$0).getString(2131698746)).setMessage(localSpannableStringBuilder).setPositiveButton(ExtendFriendCampusNewFragment.a(this.this$0).getString(2131698743), new ExtendFriendCampusNewFragment.6.2(this)).setOnKeyListener(new ExtendFriendCampusNewFragment.6.1(this));
    this.this$0.a.show();
    this.this$0.a.setCanceledOnTouchOutside(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendCampusNewFragment.6
 * JD-Core Version:    0.7.0.1
 */