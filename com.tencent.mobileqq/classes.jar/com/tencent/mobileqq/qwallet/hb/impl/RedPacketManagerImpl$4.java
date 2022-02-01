package com.tencent.mobileqq.qwallet.hb.impl;

import com.tencent.mobileqq.qwallet.hb.aio.elem.ICustomizeStrategyFactory.OnCustomizeListener;
import com.tencent.mobileqq.qwallet.hb.aio.elem.IRedPacket.OnGetSkinListener;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfoBase;
import java.lang.ref.WeakReference;

class RedPacketManagerImpl$4
  implements ICustomizeStrategyFactory.OnCustomizeListener
{
  RedPacketManagerImpl$4(RedPacketManagerImpl paramRedPacketManagerImpl, RedPacketInfoBase paramRedPacketInfoBase, WeakReference paramWeakReference) {}
  
  public void a(int paramInt, RedPacketInfo paramRedPacketInfo)
  {
    paramRedPacketInfo.isCache = this.a.isCache;
    IRedPacket.OnGetSkinListener localOnGetSkinListener = (IRedPacket.OnGetSkinListener)this.b.get();
    if (localOnGetSkinListener != null) {
      localOnGetSkinListener.onGetSkin(paramRedPacketInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.impl.RedPacketManagerImpl.4
 * JD-Core Version:    0.7.0.1
 */