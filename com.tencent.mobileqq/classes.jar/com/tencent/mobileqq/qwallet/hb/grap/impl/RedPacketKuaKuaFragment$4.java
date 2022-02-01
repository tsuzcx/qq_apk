package com.tencent.mobileqq.qwallet.hb.grap.impl;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.QwUtils;

class RedPacketKuaKuaFragment$4
  extends Handler
{
  RedPacketKuaKuaFragment$4(RedPacketKuaKuaFragment paramRedPacketKuaKuaFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (this.a.f())
    {
      if (QLog.isColorLevel()) {
        QLog.i("RedPacketKuaKuaFragment", 2, "handleMessage:getActivity() == null || getActivity().isFinishing()");
      }
      return;
    }
    if (paramMessage.what != 10000) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("RedPacketKuaKuaFragment", 2, "handleMessage() returned:输入完成");
    }
    if (NetConnInfoCenter.getServerTime() - RedPacketKuaKuaFragment.h(this.a) < RedPacketKuaKuaFragment.i(this.a)) {
      return;
    }
    if (TextUtils.isEmpty(RedPacketKuaKuaFragment.j(this.a).getText().toString()))
    {
      this.a.a(HardCodeUtil.a(R.string.bq));
      return;
    }
    QwUtils.a(this.a.getQBaseActivity().getAppRuntime(), "tenpay.com", new RedPacketKuaKuaFragment.4.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.impl.RedPacketKuaKuaFragment.4
 * JD-Core Version:    0.7.0.1
 */