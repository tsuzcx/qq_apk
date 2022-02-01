package com.tencent.mobileqq.qqexpand.config.profile;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profilecard.api.IProfileDataService;
import com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor;
import com.tencent.mobileqq.qqexpand.manager.IExpandManagerProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;

@KeepClassConstructor
public class ExpandProfileProcessor
  extends AbsProfileCommonProcessor
{
  public ExpandProfileProcessor(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
  }
  
  private SharedPreferences a(String paramString1, String paramString2)
  {
    MobileQQ localMobileQQ = MobileQQ.sMobileQQ;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append(paramString1);
    return localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 0);
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
      int j = paramUdcUinData.uint32_extend_friend_switch.get();
      paramUdcUinData = (IProfileDataService)this.appRuntime.getRuntimeService(IProfileDataService.class, "all");
      Card localCard = paramUdcUinData.getProfileCard(String.valueOf(this.appRuntime.getCurrentUin()), true);
      localCard.extendFriendEntryAddFriend = ((short)j);
      paramUdcUinData.saveProfileCard(localCard);
      if (QLog.isColorLevel())
      {
        paramUdcUinData = new StringBuilder();
        paramUdcUinData.append("saveProfileCard extendFriendEntryAddFriend:");
        paramUdcUinData.append(j);
        QLog.d("expand.enter.ExpandProcessor", 2, paramUdcUinData.toString());
      }
      a(this.appRuntime.getCurrentAccountUin(), "extend_friend_config_785").edit().putInt("sp_extend_friend_entry_add_friend", j).apply();
      i = j;
      if (j == 1)
      {
        ((IExpandManagerProxy)QRoute.api(IExpandManagerProxy.class)).setExpandEntry(this.appRuntime);
        i = j;
      }
    }
    else
    {
      i = 0;
    }
    QLog.d("expand.enter.ExpandProcessor", 1, String.format("end getExpandSwitch extras=%s success=%s expandSwitch=%d", new Object[] { paramBundle, Boolean.valueOf(paramBoolean), Integer.valueOf(i) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.config.profile.ExpandProfileProcessor
 * JD-Core Version:    0.7.0.1
 */