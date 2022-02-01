package com.tencent.mobileqq.qqexpand.fragment;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

class ExtendFriendNewEditFragment$10
  implements Runnable
{
  ExtendFriendNewEditFragment$10(ExtendFriendNewEditFragment paramExtendFriendNewEditFragment, String paramString) {}
  
  public void run()
  {
    if (ExtendFriendNewEditFragment.c(this.this$0).isFinishing()) {
      return;
    }
    if (ExtendFriendNewEditFragment.r(this.this$0) == null)
    {
      ExtendFriendNewEditFragment localExtendFriendNewEditFragment = this.this$0;
      ExtendFriendNewEditFragment.a(localExtendFriendNewEditFragment, new QQProgressDialog(ExtendFriendNewEditFragment.c(localExtendFriendNewEditFragment), ExtendFriendNewEditFragment.c(this.this$0).getTitleBarHeight()));
    }
    ExtendFriendNewEditFragment.r(this.this$0).a(this.a);
    if (ExtendFriendNewEditFragment.c(this.this$0).isFinishing()) {
      return;
    }
    ExtendFriendNewEditFragment.r(this.this$0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendNewEditFragment.10
 * JD-Core Version:    0.7.0.1
 */