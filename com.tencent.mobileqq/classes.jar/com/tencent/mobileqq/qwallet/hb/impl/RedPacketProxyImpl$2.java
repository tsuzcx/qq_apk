package com.tencent.mobileqq.qwallet.hb.impl;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.mobileqq.qwallet.hb.aio.elem.IRedPacket.OnGetSkinListener;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfoBase;
import cooperation.qwallet.plugin.impl.QWalletHelperImpl;
import mqq.app.AppRuntime;

class RedPacketProxyImpl$2
  extends ResultReceiver
{
  RedPacketProxyImpl$2(RedPacketProxyImpl paramRedPacketProxyImpl, Handler paramHandler, IRedPacket.OnGetSkinListener paramOnGetSkinListener)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    paramBundle.setClassLoader(getClass().getClassLoader());
    paramBundle = (RedPacketInfoBase)paramBundle.getParcelable("key_red_packet_info");
    AppRuntime localAppRuntime = QWalletHelperImpl.getAppRuntime();
    if (localAppRuntime != null) {
      localAppRuntime.runOnUiThread(new RedPacketProxyImpl.2.1(this, paramBundle));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.impl.RedPacketProxyImpl.2
 * JD-Core Version:    0.7.0.1
 */