package com.tencent.mobileqq.troop.api.troopcreate.impl;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.troop.api.ITroopCreateInfoService;
import com.tencent.mobileqq.troop.api.troopcreate.ITroopCreateGrayMsg;
import com.tencent.mobileqq.troop.data.TroopCreateInfo;
import com.tencent.mobileqq.troop.data.TroopCreateInfo.InviteMemberInfo;
import com.tencent.mobileqq.troop.troopcreate.TroopCreateUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class TroopCreateGrayMsgImpl
  implements ITroopCreateGrayMsg
{
  protected static final String TAG = "TroopCreateLogic";
  QQAppInterface app;
  protected TroopCreateInfo createInfo;
  
  public void addCreateNewTroopGrayTips(String paramString1, boolean paramBoolean, String paramString2)
  {
    MessageForGrayTips localMessageForGrayTips = (MessageForGrayTips)MessageRecordFactory.a(2024);
    localMessageForGrayTips.frienduin = paramString1;
    if ((paramBoolean) && ((this.createInfo.inviteMembers == null) || (this.createInfo.inviteMembers.size() == 0))) {
      return;
    }
    long l2 = 0L;
    Object localObject1 = this.createInfo;
    long l1;
    if ((localObject1 != null) && (paramString1.equals(((TroopCreateInfo)localObject1).troopUin)))
    {
      if (this.createInfo.hasAddGrayTips) {
        return;
      }
      localObject1 = this.createInfo;
      ((TroopCreateInfo)localObject1).hasAddGrayTips = true;
      l2 = ((TroopCreateInfo)localObject1).maxSeq;
      l1 = l2;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("addCreateNewTroopGrayTips troopMaxMsgseq:");
        ((StringBuilder)localObject1).append(l2);
        QLog.d("TroopCreatGrayTip", 2, ((StringBuilder)localObject1).toString());
        l1 = l2;
      }
    }
    else
    {
      l1 = l2;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("addCreateNewTroopGrayTips createInfo is null. troopUin = ");
        ((StringBuilder)localObject1).append(paramString1);
        QLog.d("TroopCreatGrayTip", 2, ((StringBuilder)localObject1).toString());
        l1 = l2;
      }
    }
    localObject1 = HardCodeUtil.a(2131912549);
    if (paramBoolean)
    {
      paramString2 = HardCodeUtil.a(2131912547);
      StringBuffer localStringBuffer = new StringBuffer();
      Iterator localIterator = this.createInfo.inviteMembers.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (TroopCreateInfo.InviteMemberInfo)localIterator.next();
        if (!((TroopCreateInfo.InviteMemberInfo)localObject2).a.equals(this.app.getCurrentAccountUin()))
        {
          localObject2 = TroopCreateUtils.a(this.app, (TroopCreateInfo.InviteMemberInfo)localObject2, paramString1);
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localStringBuffer.append((String)localObject2);
            localStringBuffer.append("、");
          }
        }
      }
      localStringBuffer.delete(localStringBuffer.length() - 1, localStringBuffer.length());
      paramString2 = String.format(paramString2, new Object[] { localStringBuffer.toString() });
    }
    else if (!TextUtils.isEmpty(paramString2))
    {
      paramString2 = String.format(HardCodeUtil.a(2131912546), new Object[] { paramString2 });
    }
    else
    {
      paramString2 = HardCodeUtil.a(2131912548);
    }
    localMessageForGrayTips.init(this.app.getCurrentAccountUin(), paramString1, paramString1, paramString2, NetConnInfoCenter.getServerTime(), -1047, 1, 0L);
    localMessageForGrayTips.shmsgseq = l1;
    paramString1 = new Bundle();
    paramString1.putInt("key_action", 25);
    int i = paramString2.indexOf((String)localObject1);
    localMessageForGrayTips.addHightlightItem(i, ((String)localObject1).length() + i, paramString1);
    if (!MessageHandlerUtils.a(this.app, localMessageForGrayTips, false)) {
      this.app.getMessageFacade().a(localMessageForGrayTips, this.app.getCurrentAccountUin());
    }
  }
  
  public void addTroopCreatedGrayTipsMr(String paramString)
  {
    Object localObject1 = this.app;
    if ((localObject1 != null) && ((localObject1 instanceof QQAppInterface)))
    {
      localObject1 = this.createInfo;
      if ((localObject1 != null) && (paramString.equals(((TroopCreateInfo)localObject1).troopUin))) {
        return;
      }
      localObject1 = (MessageForGrayTips)MessageRecordFactory.a(2024);
      ((MessageForGrayTips)localObject1).frienduin = paramString;
      Object localObject2 = BaseApplicationImpl.getApplication().getResources();
      String str1 = ((Resources)localObject2).getString(2131895078);
      String str2 = ((Resources)localObject2).getString(2131895076);
      localObject2 = ((Resources)localObject2).getString(2131895077);
      ((MessageForGrayTips)localObject1).init(this.app.getCurrentAccountUin(), paramString, paramString, str1, NetConnInfoCenter.getServerTime(), -1047, 1, 0L);
      ((MessageForGrayTips)localObject1).setTextGravity(17);
      paramString = new Bundle();
      paramString.putInt("key_action", 7);
      int i = str1.indexOf(str2);
      ((MessageForGrayTips)localObject1).addHightlightItem(i, str2.length() + i, paramString);
      paramString = new Bundle();
      paramString.putInt("key_action", 6);
      i = str1.indexOf((String)localObject2);
      ((MessageForGrayTips)localObject1).addHightlightItem(i, ((String)localObject2).length() + i, paramString);
      if (!MessageHandlerUtils.a(this.app, (MessageRecord)localObject1, false)) {
        this.app.getMessageFacade().a((MessageRecord)localObject1, this.app.getCurrentAccountUin());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("addTroopCreatedGrayTipsMr");
      if (this.app == null) {
        paramString = "app is null";
      } else {
        paramString = "app error";
      }
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("TroopCreateLogic", 1, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.app = ((QQAppInterface)paramAppRuntime);
    this.createInfo = ((ITroopCreateInfoService)paramAppRuntime.getRuntimeService(ITroopCreateInfoService.class, "")).getTroopCreateInfo();
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.troopcreate.impl.TroopCreateGrayMsgImpl
 * JD-Core Version:    0.7.0.1
 */