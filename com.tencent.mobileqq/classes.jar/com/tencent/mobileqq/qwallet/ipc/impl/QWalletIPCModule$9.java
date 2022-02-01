package com.tencent.mobileqq.qwallet.ipc.impl;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.mobileqq.qwallet.hb.aio.elem.IRedPacket.OnGetSkinListener;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfoBase;
import com.tencent.qphone.base.util.QLog;

class QWalletIPCModule$9
  implements IRedPacket.OnGetSkinListener
{
  QWalletIPCModule$9(QWalletIPCModule paramQWalletIPCModule, Bundle paramBundle, ResultReceiver paramResultReceiver) {}
  
  public void onGetSkin(RedPacketInfoBase paramRedPacketInfoBase)
  {
    this.a.putParcelable("key_red_packet_info", paramRedPacketInfoBase);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getRedPacketBundle | info resPath = ");
      localStringBuilder.append(paramRedPacketInfoBase.resPath);
      QLog.d("QWalletIPCModule", 2, localStringBuilder.toString());
    }
    paramRedPacketInfoBase = this.b;
    if (paramRedPacketInfoBase != null) {
      paramRedPacketInfoBase.send(0, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.ipc.impl.QWalletIPCModule.9
 * JD-Core Version:    0.7.0.1
 */