package com.tencent.mobileqq.extendfriend.config;

import android.annotation.SuppressLint;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.utils.ExpandSharePreUtils;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profilecard.api.IProfileDataService;
import com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;

@KeepClassConstructor
public class ExpandProfileProcessor
  extends AbsProfileCommonProcessor
{
  private static volatile boolean a = false;
  
  public ExpandProfileProcessor(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
  }
  
  public String getProcessorKey()
  {
    return "expand.enter.ExpandProcessor";
  }
  
  public boolean onGetProfileDetailRequestForLogin(oidb_0x5eb.ReqBody paramReqBody)
  {
    paramReqBody.uint32_extend_friend_switch.set(1);
    return true;
  }
  
  @SuppressLint({"DefaultLocale"})
  public void onGetProfileDetailResponse(Bundle paramBundle, boolean paramBoolean, oidb_0x5eb.UdcUinData paramUdcUinData)
  {
    int i;
    if ((paramUdcUinData != null) && (paramUdcUinData.uint32_extend_friend_switch.has()))
    {
      i = paramUdcUinData.uint32_extend_friend_switch.get();
      paramUdcUinData = (IProfileDataService)this.appRuntime.getRuntimeService(IProfileDataService.class, "all");
      Card localCard = paramUdcUinData.getProfileCard(String.valueOf(this.appRuntime.getCurrentUin()), true);
      localCard.extendFriendEntryAddFriend = ((short)i);
      paramUdcUinData.saveProfileCard(localCard);
      if (QLog.isColorLevel()) {
        QLog.d("expand.enter.ExpandProcessor", 2, "saveProfileCard extendFriendEntryAddFriend:" + i);
      }
      ExpandSharePreUtils.a(this.appRuntime.getCurrentUin(), i);
      if (i == 1) {
        ((ExtendFriendManager)this.appRuntime.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a((QQAppInterface)this.appRuntime);
      }
    }
    for (;;)
    {
      QLog.d("expand.enter.ExpandProcessor", 1, String.format("end getExpandSwitch extras=%s success=%s expandSwitch=%d", new Object[] { paramBundle, Boolean.valueOf(paramBoolean), Integer.valueOf(i) }));
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.config.ExpandProfileProcessor
 * JD-Core Version:    0.7.0.1
 */