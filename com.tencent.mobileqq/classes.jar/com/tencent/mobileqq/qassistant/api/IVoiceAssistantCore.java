package com.tencent.mobileqq.qassistant.api;

import android.app.Activity;
import com.tencent.mobileqq.qassistant.data.CommandInfo;
import com.tencent.mobileqq.qassistant.data.ConfirmSendInfo;
import com.tencent.mobileqq.qassistant.data.VoiceItemInfo;
import com.tencent.mobileqq.qassistant.data.VoicePttInfo;
import com.tencent.mobileqq.qassistant.listener.IPanelEventListener;
import com.tencent.mobileqq.qassistant.listener.IPlayEventListener;
import com.tencent.mobileqq.qassistant.listener.IVoiceCommandListener;
import com.tencent.mobileqq.qassistant.listener.IVoiceVadListener;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IVoiceAssistantCore
  extends IRuntimeService
{
  public abstract void cancelSendVoice();
  
  public abstract void executeCommand(CommandInfo paramCommandInfo);
  
  public abstract Activity getActivity();
  
  public abstract List<VoiceItemInfo> getCurrentVoiceItemInfo();
  
  public abstract VoicePttInfo getVoicePttInfo();
  
  public abstract void initReceiver();
  
  public abstract void initVoiceAssistant();
  
  public abstract boolean isInSession();
  
  public abstract boolean isSilent();
  
  public abstract boolean isVoicePanelShow();
  
  public abstract boolean isVoicePlaying();
  
  public abstract void onConfirmSend(ConfirmSendInfo paramConfirmSendInfo);
  
  public abstract void onCreate(AppRuntime paramAppRuntime);
  
  public abstract void onDestroy();
  
  public abstract void onStartRecord();
  
  public abstract void onVoiceMessageCallBack(int paramInt, Object paramObject);
  
  public abstract void play(String paramString);
  
  public abstract void quitePanel(boolean paramBoolean);
  
  public abstract void quiteVoicePanel(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void resendVoice();
  
  public abstract void sendMessage(int paramInt);
  
  public abstract void sendQuitPanelMessage();
  
  public abstract void setPanelEventListener(IPanelEventListener paramIPanelEventListener);
  
  public abstract void setPerformanceText(String paramString);
  
  public abstract void setPlayEventListener(IPlayEventListener paramIPlayEventListener);
  
  public abstract void setVoiceCommandListener(IVoiceCommandListener paramIVoiceCommandListener);
  
  public abstract void setVoiceVadListener(IVoiceVadListener paramIVoiceVadListener);
  
  public abstract void startPanelTipsAnimation();
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.api.IVoiceAssistantCore
 * JD-Core Version:    0.7.0.1
 */