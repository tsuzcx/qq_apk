package com.tencent.mobileqq.qassistant.api;

import android.app.Activity;
import android.content.Intent;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qassistant.config.QAssistantConfigItem;
import com.tencent.mobileqq.qassistant.data.CommandInfo;
import com.tencent.mobileqq.qassistant.wake.WakeServiceCallBack;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import java.util.List;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IVoiceAssistantMain
  extends QRouteApi
{
  public abstract boolean allIsInit();
  
  public abstract CommandInfo buildShowRecordViewCommand(String paramString1, String paramString2, String paramString3);
  
  public abstract CommandInfo buildShowResendViewCommand();
  
  public abstract CommandInfo buildShowSelectViewCommand(String paramString, CommandInfo paramCommandInfo);
  
  public abstract void forwardFiles(List<String> paramList, Activity paramActivity);
  
  public abstract void getAssistantImplSwitch(AppRuntime paramAppRuntime);
  
  public abstract boolean getCanOpenInSp();
  
  public abstract int getReportType();
  
  public abstract boolean getWakeDialogWakeReport();
  
  public abstract boolean getWakeManagerEnable();
  
  public abstract String getWakeManagerTag();
  
  public abstract void initAndStartRecord(String paramString);
  
  public abstract List<String> lastFileModified(String paramString, int paramInt);
  
  public abstract QAssistantConfigItem readItemFromIntent(Intent paramIntent);
  
  public abstract void reportQAssistantJump(String paramString);
  
  public abstract void reportQAssistantJumpMonitor(String paramString1, String paramString2, int paramInt);
  
  public abstract void reportSureSendMessage(int paramInt);
  
  public abstract void setAssistantImplSwitch(AppRuntime paramAppRuntime, boolean paramBoolean);
  
  public abstract void setCanOpenInSp(boolean paramBoolean);
  
  public abstract void startRecord(QBaseActivity paramQBaseActivity, String paramString, WakeServiceCallBack paramWakeServiceCallBack);
  
  public abstract void startRecord(String paramString);
  
  public abstract void stopRecord(String paramString);
  
  public abstract void transSnapshotInner(Activity paramActivity);
  
  public abstract void updateQAssistantConfig(BaseQQAppInterface paramBaseQQAppInterface, String paramString);
  
  public abstract void writeToActivityRequest(QAssistantConfigItem paramQAssistantConfigItem, boolean paramBoolean, ActivityURIRequest paramActivityURIRequest);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.api.IVoiceAssistantMain
 * JD-Core Version:    0.7.0.1
 */