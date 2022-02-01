package com.tencent.mobileqq.extendfriend.fragment;

import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendSendMsgHelper;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendSendMsgHelper.ISendMsgInterface;
import com.tencent.qphone.base.util.QLog;

class ExtendFriendBaseFragment$1
  implements ExtendFriendSendMsgHelper.ISendMsgInterface
{
  ExtendFriendBaseFragment$1(ExtendFriendBaseFragment paramExtendFriendBaseFragment) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendBaseFragment.1
 * JD-Core Version:    0.7.0.1
 */