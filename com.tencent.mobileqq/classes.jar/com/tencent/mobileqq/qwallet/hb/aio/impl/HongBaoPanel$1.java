package com.tencent.mobileqq.qwallet.hb.aio.impl;

import com.tencent.mobileqq.qwallet.hb.aio.elem.ICustomizeStrategyFactory.OnCustomizeListener;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;
import com.tencent.qphone.base.util.QLog;

class HongBaoPanel$1
  implements ICustomizeStrategyFactory.OnCustomizeListener
{
  HongBaoPanel$1(HongBaoPanel paramHongBaoPanel) {}
  
  public void a(int paramInt, RedPacketInfo paramRedPacketInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("action info.icon = ");
      localStringBuilder.append(paramRedPacketInfo.icon);
      localStringBuilder.append(",info.skinType = ");
      localStringBuilder.append(paramRedPacketInfo.skinType);
      QLog.d("HongBaoPanel", 2, localStringBuilder.toString());
    }
    if (paramRedPacketInfo != null) {
      HongBaoPanel.a(this.a, paramRedPacketInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.impl.HongBaoPanel.1
 * JD-Core Version:    0.7.0.1
 */