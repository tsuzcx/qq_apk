package com.tencent.mobileqq.qwallet.hb.aio.impl;

import android.widget.ImageView;
import com.tencent.mobileqq.qwallet.hb.aio.elem.ICustomizeStrategyFactory.OnCustomizeListener;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class HongBaoPanel$4
  implements ICustomizeStrategyFactory.OnCustomizeListener
{
  HongBaoPanel$4(HongBaoPanel paramHongBaoPanel, String paramString, ImageView paramImageView, int paramInt) {}
  
  public void a(int paramInt, RedPacketInfo paramRedPacketInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("templateId = ");
      localStringBuilder.append(this.a);
      localStringBuilder.append(",action info.icon = ");
      localStringBuilder.append(paramRedPacketInfo.icon);
      localStringBuilder.append(",imageView.getTag() = ");
      localStringBuilder.append(this.b.getTag());
      localStringBuilder.append(",info.skinType = ");
      localStringBuilder.append(paramRedPacketInfo.skinType);
      QLog.d("HongBaoPanel", 2, localStringBuilder.toString());
    }
    if (this.a.equals(this.b.getTag()))
    {
      if (paramRedPacketInfo.icon != null)
      {
        this.b.setImageBitmap(paramRedPacketInfo.icon);
        return;
      }
      HongBaoPanel.d(this.d).add(Integer.valueOf(this.c));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.impl.HongBaoPanel.4
 * JD-Core Version:    0.7.0.1
 */