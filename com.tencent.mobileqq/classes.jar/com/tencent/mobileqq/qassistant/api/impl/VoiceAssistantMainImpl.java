package com.tencent.mobileqq.qassistant.api.impl;

import android.app.Activity;
import android.content.Intent;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qassistant.api.IVoiceAssistantMain;
import com.tencent.mobileqq.qassistant.audio.VoiceTimeTraceUtil;
import com.tencent.mobileqq.qassistant.config.QAssistantConfigItem;
import com.tencent.mobileqq.qassistant.config.QAssistantConfigUtils;
import com.tencent.mobileqq.qassistant.data.CommandInfo;
import com.tencent.mobileqq.qassistant.setting.AssistantSwitchImpl;
import com.tencent.mobileqq.qassistant.util.CommandUtils;
import com.tencent.mobileqq.qassistant.util.ReportUtils;
import com.tencent.mobileqq.qassistant.wake.WakeDialog;
import com.tencent.mobileqq.qassistant.wake.WakeManager;
import com.tencent.mobileqq.qassistant.wake.WakeServiceCallBack;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import java.util.List;
import mqq.app.AppRuntime;

public class VoiceAssistantMainImpl
  implements IVoiceAssistantMain
{
  public boolean allIsInit()
  {
    return WakeManager.a().a();
  }
  
  public CommandInfo buildShowRecordViewCommand(String paramString1, String paramString2, String paramString3)
  {
    return CommandUtils.a(paramString1, paramString2, paramString3);
  }
  
  public CommandInfo buildShowResendViewCommand()
  {
    return CommandUtils.b();
  }
  
  public CommandInfo buildShowSelectViewCommand(String paramString, CommandInfo paramCommandInfo)
  {
    return CommandUtils.a(paramString, paramCommandInfo);
  }
  
  public void forwardFiles(List<String> paramList, Activity paramActivity)
  {
    CommandUtils.b(paramList, paramActivity);
  }
  
  public void getAssistantImplSwitch(AppRuntime paramAppRuntime)
  {
    AssistantSwitchImpl.a(paramAppRuntime);
  }
  
  public boolean getCanOpenInSp()
  {
    return WakeManager.a().a;
  }
  
  public int getReportType()
  {
    return CommandUtils.a();
  }
  
  public boolean getWakeDialogWakeReport()
  {
    return WakeDialog.a;
  }
  
  public boolean getWakeManagerEnable()
  {
    return WakeManager.a().b();
  }
  
  public String getWakeManagerTag()
  {
    return "HelloQQWake";
  }
  
  public void initAndStartRecord(String paramString)
  {
    WakeManager.a().b().a(paramString);
  }
  
  public List<String> lastFileModified(String paramString, int paramInt)
  {
    return CommandUtils.a(paramString, paramInt);
  }
  
  public QAssistantConfigItem readItemFromIntent(Intent paramIntent)
  {
    return QAssistantConfigUtils.a(paramIntent);
  }
  
  public void reportQAssistantJump(String paramString)
  {
    QAssistantConfigUtils.a(paramString);
  }
  
  public void reportQAssistantJumpMonitor(String paramString1, String paramString2, int paramInt)
  {
    QAssistantConfigUtils.a(paramString1, paramString2, paramInt);
  }
  
  public void reportSureSendMessage(int paramInt)
  {
    ReportUtils.b(paramInt);
  }
  
  public void setAssistantImplSwitch(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    AssistantSwitchImpl.a(paramAppRuntime, paramBoolean);
  }
  
  public void setCanOpenInSp(boolean paramBoolean)
  {
    WakeManager.a().a(paramBoolean);
  }
  
  public void startRecord(QBaseActivity paramQBaseActivity, String paramString, WakeServiceCallBack paramWakeServiceCallBack)
  {
    WakeManager.a().a(paramQBaseActivity, paramString, paramWakeServiceCallBack);
  }
  
  public void startRecord(String paramString)
  {
    WakeManager.a().a(paramString);
  }
  
  public void stopRecord(String paramString)
  {
    WakeManager.a().b(paramString);
  }
  
  public void transSnapshotInner(Activity paramActivity)
  {
    VoiceTimeTraceUtil.a().a(paramActivity);
  }
  
  public void updateQAssistantConfig(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    QAssistantConfigUtils.a(paramBaseQQAppInterface, paramString);
  }
  
  public void writeToActivityRequest(QAssistantConfigItem paramQAssistantConfigItem, boolean paramBoolean, ActivityURIRequest paramActivityURIRequest)
  {
    QAssistantConfigUtils.a(paramQAssistantConfigItem, paramBoolean, paramActivityURIRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.api.impl.VoiceAssistantMainImpl
 * JD-Core Version:    0.7.0.1
 */