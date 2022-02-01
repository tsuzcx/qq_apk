package com.tencent.mobileqq.profilecommon.processor;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.troop.luckycharacter.TroopLuckyCharacterUtil;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;

@KeepClassConstructor
public class TroopLuckyCharacterProcessor
  extends AbsProfileCommonProcessor
{
  public TroopLuckyCharacterProcessor(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
  }
  
  public String getProcessorKey()
  {
    return "TroopLuckyCharacterProcessor";
  }
  
  public boolean interceptProfileModifyPush(int paramInt)
  {
    return paramInt == 42495;
  }
  
  public boolean onGetProfileDetailRequestForLogin(oidb_0x5eb.ReqBody paramReqBody)
  {
    paramReqBody.uint32_troop_lucky_character_switch.set(1);
    return true;
  }
  
  public void onGetProfileDetailResponse(Bundle paramBundle, boolean paramBoolean, oidb_0x5eb.UdcUinData paramUdcUinData)
  {
    boolean bool = paramUdcUinData.uint32_troop_lucky_character_switch.has();
    if (bool) {
      if (paramUdcUinData.uint32_troop_lucky_character_switch.get() == 0) {
        paramBoolean = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopLuckyCharacterProcessor", 2, String.format("handleGetProfileInfoForLogin hasLuckyCharacterSwitch=%s luckyCharacterSwitch=%s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) }));
      }
      if ((this.appRuntime instanceof QQAppInterface)) {
        TroopLuckyCharacterUtil.a((QQAppInterface)this.appRuntime, paramBoolean);
      }
      return;
      paramBoolean = false;
      continue;
      paramBoolean = true;
    }
  }
  
  public void onProcessProfileModifyPush(int paramInt, ByteStringMicro paramByteStringMicro)
  {
    if (paramInt == 42495)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopLuckyCharacterProcessor", 2, "get apollo head update push.");
      }
      if (ByteBuffer.wrap(paramByteStringMicro.toByteArray()).asShortBuffer().get() != 0) {
        break label88;
      }
    }
    label88:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, new Object[] { "c2c online push, field id: 42495, changed troopLuckyCharacterSwitch: ", Boolean.valueOf(bool) });
      }
      if ((this.appRuntime instanceof QQAppInterface)) {
        TroopLuckyCharacterUtil.a((QQAppInterface)this.appRuntime, bool);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecommon.processor.TroopLuckyCharacterProcessor
 * JD-Core Version:    0.7.0.1
 */