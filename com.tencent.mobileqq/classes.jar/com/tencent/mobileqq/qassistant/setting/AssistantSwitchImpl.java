package com.tencent.mobileqq.qassistant.setting;

import android.os.Bundle;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profilecommon.handler.ProfileCommonHandler;
import com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor;
import com.tencent.mobileqq.profilecommon.utils.ProfileCommonUtils;
import com.tencent.mobileqq.qassistant.core.AssistantUtils;
import com.tencent.mobileqq.qassistant.wake.WakeManager;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x587.oidb_0x587.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;

@KeepClassConstructor
public class AssistantSwitchImpl
  extends AbsProfileCommonProcessor
{
  public AssistantSwitchImpl(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
  }
  
  public static Boolean a(int paramInt)
  {
    boolean bool;
    if (paramInt == 2) {
      bool = true;
    } else {
      bool = false;
    }
    return Boolean.valueOf(bool);
  }
  
  public static void a(AppRuntime paramAppRuntime)
  {
    try
    {
      paramAppRuntime = (AssistantSwitchImpl)ProfileCommonUtils.a(AssistantSwitchImpl.class, paramAppRuntime);
      if (paramAppRuntime != null)
      {
        paramAppRuntime.a();
        return;
      }
    }
    catch (Exception paramAppRuntime)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AssistantSwitchImpl getSwitch fail.");
      localStringBuilder.append(paramAppRuntime.getMessage());
      AssistantUtils.a("HelloQQWake", localStringBuilder.toString());
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    try
    {
      paramAppRuntime = (AssistantSwitchImpl)ProfileCommonUtils.a(AssistantSwitchImpl.class, paramAppRuntime);
      if (paramAppRuntime != null)
      {
        paramAppRuntime.a(paramBoolean);
        return;
      }
    }
    catch (Exception paramAppRuntime)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AssistantSwitchImpl setSwitch fail.");
      localStringBuilder.append(paramAppRuntime.getMessage());
      AssistantUtils.a("HelloQQWake", localStringBuilder.toString());
    }
  }
  
  public void a()
  {
    AssistantUtils.a("HelloQQWake", "getqqAssistantSwitch");
    oidb_0x5eb.ReqBody localReqBody = new oidb_0x5eb.ReqBody();
    localReqBody.rpt_uint64_uins.add(Long.valueOf(this.appRuntime.getLongAccountUin()));
    localReqBody.uint32_qq_assistant_switch.set(1);
    getProfileDetail(localReqBody, null);
  }
  
  public void a(boolean paramBoolean)
  {
    int i = 1;
    AssistantUtils.a("HelloQQWake", String.format("setWeiShiSwitch value=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    oidb_0x587.ReqBody localReqBody = new oidb_0x587.ReqBody();
    localReqBody.rpt_uint64_uins.add(Long.valueOf(this.appRuntime.getLongAccountUin()));
    PBUInt32Field localPBUInt32Field = localReqBody.uint32_qq_assistant_switch;
    if (paramBoolean) {
      i = 2;
    }
    localPBUInt32Field.set(i);
    setProfileDetail(localReqBody, null);
  }
  
  public String getProcessorKey()
  {
    return "AssistantSwitchImpl";
  }
  
  public boolean onGetProfileDetailRequestForLogin(oidb_0x5eb.ReqBody paramReqBody)
  {
    paramReqBody.uint32_qq_assistant_switch.set(1);
    AssistantUtils.a("HelloQQWake", "processGetProfileInfoForLogin");
    return true;
  }
  
  public void onGetProfileDetailResponse(Bundle paramBundle, boolean paramBoolean, oidb_0x5eb.UdcUinData paramUdcUinData)
  {
    if (paramUdcUinData != null)
    {
      boolean bool = paramUdcUinData.uint32_qq_assistant_switch.has();
      int i;
      if (bool)
      {
        i = paramUdcUinData.uint32_qq_assistant_switch.get();
        WakeManager.a().a(a(i).booleanValue());
      }
      else
      {
        i = 0;
      }
      AssistantUtils.a("HelloQQWake", String.format("onGetProfileDetailResponse hasWeiShiSwitch=%s weiShiSwitchValue=%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) }));
      this.handler.notifyUI(2, paramBoolean, a(i));
    }
  }
  
  public void onSetProfileDetailResponse(Bundle paramBundle, boolean paramBoolean)
  {
    AssistantUtils.a("HelloQQWake", String.format("onSetProfileDetailResponse request=%s success=%s", new Object[] { paramBundle, Boolean.valueOf(paramBoolean) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.setting.AssistantSwitchImpl
 * JD-Core Version:    0.7.0.1
 */