package com.tencent.mobileqq.qwallet.hb.grap.impl;

import com.qwallet.temp.IQWalletTemp;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class RedPacketKuaKuaFragment$3
  implements Runnable
{
  RedPacketKuaKuaFragment$3(RedPacketKuaKuaFragment paramRedPacketKuaKuaFragment) {}
  
  public void run()
  {
    if (this.this$0.f())
    {
      if (QLog.isColorLevel()) {
        QLog.i("RedPacketKuaKuaFragment", 2, "ContactUtils.getBuddyNickName:getActivity() == null || getActivity().isFinishing()");
      }
      return;
    }
    ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).ContactUtils$getBuddyNickName(this.this$0.getQBaseActivity().getAppRuntime(), RedPacketKuaKuaFragment.b(this.this$0).senderuin, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.impl.RedPacketKuaKuaFragment.3
 * JD-Core Version:    0.7.0.1
 */