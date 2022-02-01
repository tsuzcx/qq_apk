package com.tencent.mobileqq.profilecommon.processor;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.troop.api.handler.ITroopListHandler;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;

@KeepClassConstructor
public class TroopHonorSwitchProcessor
  extends AbsProfileCommonProcessor
{
  public TroopHonorSwitchProcessor(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
  }
  
  private void a(boolean paramBoolean)
  {
    FriendsManager localFriendsManager = (FriendsManager)this.appRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Card localCard = localFriendsManager.a(this.appRuntime.getCurrentUin());
    if ((localCard != null) && (localCard.troopHonorSwitch != paramBoolean))
    {
      localCard.troopHonorSwitch = paramBoolean;
      localFriendsManager.a(localCard);
      if ((this.appRuntime instanceof QQAppInterface))
      {
        ((CardHandler)((QQAppInterface)this.appRuntime).getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).notifyUI(110, true, Boolean.valueOf(localCard.troopHonorSwitch));
        ((ITroopListHandler)((QQAppInterface)this.appRuntime).getBusinessHandler(BusinessHandlerFactory.TROOP_LIST_HANDLER)).a(TroopObserver.TYPE_NOTIFY_UPDATE_RECENT_LIST, true, null);
      }
    }
  }
  
  public String getProcessorKey()
  {
    return "TroopHonorSwitchProcessor";
  }
  
  public boolean interceptProfileModifyPush(int paramInt)
  {
    return paramInt == 42360;
  }
  
  public boolean onGetProfileDetailRequestForLogin(oidb_0x5eb.ReqBody paramReqBody)
  {
    paramReqBody.uint32_troophonor_switch.set(1);
    return true;
  }
  
  public void onGetProfileDetailResponse(Bundle paramBundle, boolean paramBoolean, oidb_0x5eb.UdcUinData paramUdcUinData)
  {
    if (paramBoolean)
    {
      boolean bool = paramUdcUinData.uint32_troophonor_switch.has();
      if ((bool) && (paramUdcUinData.uint32_troophonor_switch.get() != 0)) {
        paramBoolean = false;
      } else {
        paramBoolean = true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopHonorSwitchProcessor", 2, String.format("onGetProfileDetailResponse hasHonorSwitch=%s honorSwitch=%s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) }));
      }
      a(paramBoolean);
      return;
    }
    if ((this.appRuntime instanceof QQAppInterface)) {
      ((CardHandler)((QQAppInterface)this.appRuntime).getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).notifyUI(110, false, null);
    }
  }
  
  public void onProcessProfileModifyPush(int paramInt, ByteStringMicro paramByteStringMicro)
  {
    if (paramInt == 42360)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopHonorSwitchProcessor", 2, "get apollo head update push.");
      }
      boolean bool;
      if (ByteBuffer.wrap(paramByteStringMicro.toByteArray()).asShortBuffer().get() == 0) {
        bool = true;
      } else {
        bool = false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, new Object[] { "c2c online push, field id: 42495, changed troopLuckyCharacterSwitch: ", Boolean.valueOf(bool) });
      }
      a(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecommon.processor.TroopHonorSwitchProcessor
 * JD-Core Version:    0.7.0.1
 */