package com.tencent.mobileqq.qwallet.hb.impl;

import com.tencent.mobileqq.qwallet.hb.aio.elem.IRedPacket.OnGetSkinListener;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfoBase;

class RedPacketProxyImpl$2$1
  implements Runnable
{
  RedPacketProxyImpl$2$1(RedPacketProxyImpl.2 param2, RedPacketInfoBase paramRedPacketInfoBase) {}
  
  public void run()
  {
    this.b.a.onGetSkin(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.impl.RedPacketProxyImpl.2.1
 * JD-Core Version:    0.7.0.1
 */