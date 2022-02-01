package com.tencent.mobileqq.utils;

import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.troop.data.TroopGiftBagInfo;
import com.tencent.mobileqq.troop.utils.TroopGiftCallback;
import com.tencent.qphone.base.util.QLog;

class AIOAnimationControlManager$10
  extends TroopGiftCallback
{
  AIOAnimationControlManager$10(AIOAnimationControlManager paramAIOAnimationControlManager, MessageForDeliverGiftTips paramMessageForDeliverGiftTips, String paramString, boolean paramBoolean) {}
  
  public void a(int paramInt, String paramString)
  {
    Object localObject1 = this.a;
    ((MessageForDeliverGiftTips)localObject1).hasFetchButFailed = true;
    ((MessageForDeliverGiftTips)localObject1).showButton = true;
    Object localObject2;
    String str;
    StringBuilder localStringBuilder;
    if ((this.d.p instanceof QQAppInterface))
    {
      localObject1 = this.a;
      localObject2 = (QQAppInterface)this.d.p;
      str = this.b;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.a.senderUin);
      ((MessageForDeliverGiftTips)localObject1).senderName = ContactUtils.b((AppInterface)localObject2, str, localStringBuilder.toString());
    }
    else if ((this.d.p instanceof VideoAppInterface))
    {
      localObject1 = this.a;
      localObject2 = (VideoAppInterface)this.d.p;
      str = this.b;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a.senderUin);
      localStringBuilder.append("");
      ((MessageForDeliverGiftTips)localObject1).senderName = ((VideoAppInterface)localObject2).a(1, str, localStringBuilder.toString());
    }
    else
    {
      this.a.senderName = null;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("playGiftBigAnimation getGrabBagInfo onError. errorCode:");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(" errorMsg:");
      ((StringBuilder)localObject1).append(paramString);
      QLog.i(".troop.send_gift", 2, ((StringBuilder)localObject1).toString());
    }
    this.d.j.post(new AIOAnimationControlManager.10.2(this));
  }
  
  public void a(TroopGiftBagInfo paramTroopGiftBagInfo)
  {
    if (paramTroopGiftBagInfo.myGrabResult == null)
    {
      paramTroopGiftBagInfo = this.a;
      paramTroopGiftBagInfo.hasFetchButFailed = true;
      paramTroopGiftBagInfo.showButton = true;
      Object localObject;
      String str;
      StringBuilder localStringBuilder;
      if ((this.d.p instanceof QQAppInterface))
      {
        paramTroopGiftBagInfo = this.a;
        localObject = (QQAppInterface)this.d.p;
        str = this.b;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(this.a.senderUin);
        paramTroopGiftBagInfo.senderName = ContactUtils.b((AppInterface)localObject, str, localStringBuilder.toString());
      }
      else if ((this.d.p instanceof VideoAppInterface))
      {
        paramTroopGiftBagInfo = this.a;
        localObject = (VideoAppInterface)this.d.p;
        str = this.b;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.a.senderUin);
        localStringBuilder.append("");
        paramTroopGiftBagInfo.senderName = ((VideoAppInterface)localObject).a(1, str, localStringBuilder.toString());
      }
      else
      {
        this.a.senderName = null;
      }
    }
    this.d.j.post(new AIOAnimationControlManager.10.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AIOAnimationControlManager.10
 * JD-Core Version:    0.7.0.1
 */