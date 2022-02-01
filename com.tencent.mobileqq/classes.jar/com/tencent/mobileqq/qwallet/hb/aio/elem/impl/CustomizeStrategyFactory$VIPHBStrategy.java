package com.tencent.mobileqq.qwallet.hb.aio.elem.impl;

import android.text.TextUtils;
import com.qwallet.temp.IIndividualRedPacket;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.qwallet.hb.aio.elem.ICustomizeStrategyFactory;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;
import com.tencent.qphone.base.util.QLog;

public class CustomizeStrategyFactory$VIPHBStrategy
  implements CustomizeStrategyFactory.HBCustomizeStrategy
{
  private BaseQQAppInterface a;
  
  public CustomizeStrategyFactory$VIPHBStrategy(BaseQQAppInterface paramBaseQQAppInterface)
  {
    this.a = paramBaseQQAppInterface;
  }
  
  public void a() {}
  
  public void a(RedPacketInfo paramRedPacketInfo)
  {
    if (paramRedPacketInfo != null)
    {
      if (TextUtils.isEmpty(paramRedPacketInfo.templateId)) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("VIPHBStrategy.get Id = ");
        ((StringBuilder)localObject).append(paramRedPacketInfo.templateId);
        ((StringBuilder)localObject).append("content = ");
        ((StringBuilder)localObject).append(paramRedPacketInfo.d);
        QLog.d("CustomizeStrategyFactory", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = (IIndividualRedPacket)this.a.getRuntimeService(IIndividualRedPacket.class);
      if ((localObject != null) && (((IIndividualRedPacket)localObject).isAllowShowRedpacket()) && (!((IIndividualRedPacket)localObject).isSDCardError()))
      {
        ThreadManager.post(new CustomizeStrategyFactory.VIPHBStrategy.1(this, (IIndividualRedPacket)localObject, paramRedPacketInfo), 8, null, true);
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("VIPHBStrategy get fail! Redpacket Disable or no TemplateInfo! ");
        if (localObject == null)
        {
          localObject = "redPacketManager == null";
        }
        else
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("isShowRedpacket:");
          localStringBuilder2.append(((IIndividualRedPacket)localObject).IndividualRedPacketResDownloader$isShowRedpacket());
          localStringBuilder2.append(", PacketEnable:");
          localStringBuilder2.append(((IIndividualRedPacket)localObject).isIndividualRedPacketEnable());
          localStringBuilder2.append(", mIsSDCardError:");
          localStringBuilder2.append(((IIndividualRedPacket)localObject).isSDCardError());
          localObject = localStringBuilder2.toString();
        }
        localStringBuilder1.append((String)localObject);
        QLog.d("CustomizeStrategyFactory", 2, localStringBuilder1.toString());
      }
      ((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).getCustomizeStrategyFactory().a(paramRedPacketInfo);
    }
  }
  
  public void a(RedPacketInfo paramRedPacketInfo, InterfaceRedPkgElem paramInterfaceRedPkgElem)
  {
    if ((paramRedPacketInfo != null) && ((paramInterfaceRedPkgElem instanceof VipRedPkgElem)))
    {
      paramInterfaceRedPkgElem = (VipRedPkgElem)paramInterfaceRedPkgElem;
      paramRedPacketInfo.e = paramInterfaceRedPkgElem.b;
      paramRedPacketInfo.i = paramInterfaceRedPkgElem.c;
      paramRedPacketInfo.h = paramInterfaceRedPkgElem.d;
      paramRedPacketInfo.g = paramInterfaceRedPkgElem.e;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.elem.impl.CustomizeStrategyFactory.VIPHBStrategy
 * JD-Core Version:    0.7.0.1
 */