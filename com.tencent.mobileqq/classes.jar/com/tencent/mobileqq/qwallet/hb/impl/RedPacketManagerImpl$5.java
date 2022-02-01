package com.tencent.mobileqq.qwallet.hb.impl;

import com.tencent.mobileqq.qwallet.hb.aio.elem.ICustomizeStrategyFactory.OnCustomizeListener;
import com.tencent.mobileqq.qwallet.hb.aio.elem.IRedPacket.OnGetSkinListener;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;

class RedPacketManagerImpl$5
  implements ICustomizeStrategyFactory.OnCustomizeListener
{
  RedPacketManagerImpl$5(RedPacketManagerImpl paramRedPacketManagerImpl, IRedPacket.OnGetSkinListener paramOnGetSkinListener) {}
  
  public void a(int paramInt, RedPacketInfo paramRedPacketInfo)
  {
    this.a.onGetSkin(paramRedPacketInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.impl.RedPacketManagerImpl.5
 * JD-Core Version:    0.7.0.1
 */