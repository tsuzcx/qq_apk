package com.tencent.mobileqq.profilecommon.processor;

import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profilecommon.handler.ProfileCommonHandler;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;

@KeepClassConstructor
public class ExampleProcessor
  extends AbsProfileCommonProcessor
{
  public ExampleProcessor(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
  }
  
  public String getProcessorKey()
  {
    return "ExampleProcessor";
  }
  
  public boolean interceptProfileModifyPush(int paramInt)
  {
    return paramInt == 42377;
  }
  
  public boolean onGetProfileDetailRequestForLogin(oidb_0x5eb.ReqBody paramReqBody)
  {
    paramReqBody.uint32_flag_profile_weishi_switch.set(1);
    return true;
  }
  
  public void onGetProfileDetailResponse(Bundle paramBundle, boolean paramBoolean, oidb_0x5eb.UdcUinData paramUdcUinData)
  {
    boolean bool = QLog.isColorLevel();
    int j = 0;
    if (bool) {
      QLog.d("ExampleProcessor", 2, String.format("onGetProfileDetailResponse extras=%s success=%s", new Object[] { paramBundle, Boolean.valueOf(paramBoolean) }));
    }
    int i = j;
    if (paramUdcUinData != null)
    {
      i = j;
      if (paramUdcUinData.uint32_profile_weishi_switch.has()) {
        i = paramUdcUinData.uint32_profile_weishi_switch.get();
      }
    }
    this.handler.notifyUI(1, paramBoolean, Integer.valueOf(i));
  }
  
  public void onProcessProfileModifyPush(int paramInt, ByteStringMicro paramByteStringMicro) {}
  
  public void onProcessProfileModifyPushBegin(long paramLong) {}
  
  public void onProcessProfileModifyPushEnd() {}
  
  public void onSetProfileDetailResponse(Bundle paramBundle, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExampleProcessor", 2, String.format("onSetProfileDetailResponse extras=%s success=%s", new Object[] { paramBundle, Boolean.valueOf(paramBoolean) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilecommon.processor.ExampleProcessor
 * JD-Core Version:    0.7.0.1
 */