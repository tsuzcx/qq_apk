package com.tencent.mobileqq.qqexpand.fragment;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qqexpand.chat.ExtendFriendSendMsgHelper;
import com.tencent.mobileqq.qqexpand.chat.ISendMsgInterface;
import com.tencent.qphone.base.util.QLog;

class ExtendFriendBaseFragment$3
  implements ISendMsgInterface
{
  ExtendFriendBaseFragment$3(ExtendFriendBaseFragment paramExtendFriendBaseFragment) {}
  
  public void enterAio(String paramString1, String paramString2)
  {
    ExtendFriendSendMsgHelper.a(this.a.a, paramString1, paramString2);
  }
  
  public void showMatchCountDialog()
  {
    ExtendFriendSendMsgHelper.a(this.a.a);
  }
  
  public void showToast(int paramInt)
  {
    if (this.a.a == null)
    {
      QLog.d("ExtendFriendBaseFragment", 1, "sendMsgDirectly()-> showToast() mActivity is null just return");
      return;
    }
    ExtendFriendSendMsgHelper.a(this.a.a, this.a.a.getString(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendBaseFragment.3
 * JD-Core Version:    0.7.0.1
 */