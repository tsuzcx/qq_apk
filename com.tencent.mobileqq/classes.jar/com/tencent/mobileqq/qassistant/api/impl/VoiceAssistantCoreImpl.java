package com.tencent.mobileqq.qassistant.api.impl;

import android.app.Activity;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qassistant.api.IQAssistantTempApi;
import com.tencent.mobileqq.qassistant.api.IVoiceAssistantCore;
import com.tencent.mobileqq.qassistant.audio.AudioNewRecorder;
import com.tencent.mobileqq.qassistant.core.AssistantUtils;
import com.tencent.mobileqq.qassistant.core.ViewCommandModelCheck;
import com.tencent.mobileqq.qassistant.core.VoiceAssistantReceiver;
import com.tencent.mobileqq.qassistant.core.VoiceMainPresenter;
import com.tencent.mobileqq.qassistant.data.CommandInfo;
import com.tencent.mobileqq.qassistant.data.ConfirmSendInfo;
import com.tencent.mobileqq.qassistant.data.VoiceItemInfo;
import com.tencent.mobileqq.qassistant.data.VoicePttInfo;
import com.tencent.mobileqq.qassistant.listener.IPanelEventListener;
import com.tencent.mobileqq.qassistant.listener.IPlayEventListener;
import com.tencent.mobileqq.qassistant.listener.IVoiceCommandListener;
import com.tencent.mobileqq.qassistant.listener.IVoiceVadListener;
import com.tencent.mobileqq.qassistant.statemachine.VoiceAssistantStateMachine;
import com.tencent.mobileqq.qassistant.tts.TTSPlayerManager;
import com.tencent.mobileqq.qassistant.util.CommandUtils;
import com.tencent.mobileqq.qassistant.util.ReportUtils;
import com.tencent.mobileqq.qassistant.wake.WakeManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class VoiceAssistantCoreImpl
  implements Handler.Callback, IVoiceAssistantCore
{
  private static final int MAX_STAY_TIME = 30000;
  private static final int QUIT_VOICE_PANEL_MESSAGE = 1;
  private static final String TAG = "VoiceAssistantServiceImpl";
  private final AtomicBoolean isReceiverRegister = new AtomicBoolean(false);
  private Handler mHandler;
  private VoiceAssistantReceiver mReceiver;
  private TTSPlayerManager mTTSPlayerManager;
  private VoiceAssistantStateMachine mVoiceAssistantStateMachine;
  private VoiceMainPresenter mVoicePresenter;
  
  public void cancelSendVoice()
  {
    VoiceAssistantStateMachine localVoiceAssistantStateMachine = this.mVoiceAssistantStateMachine;
    if (localVoiceAssistantStateMachine != null) {
      localVoiceAssistantStateMachine.n();
    }
  }
  
  public void executeCommand(CommandInfo paramCommandInfo)
  {
    if (!WakeManager.a().h())
    {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceAssistantServiceImpl", 2, "executeCommand not allow");
      }
      return;
    }
    if ((isVoicePanelShow()) && (paramCommandInfo != null))
    {
      if ((!TextUtils.isEmpty(paramCommandInfo.h)) && (paramCommandInfo.h.equals("发消息")))
      {
        VoiceAssistantStateMachine localVoiceAssistantStateMachine = this.mVoiceAssistantStateMachine;
        if ((localVoiceAssistantStateMachine != null) && (localVoiceAssistantStateMachine.g() != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("VoiceAssistantServiceImpl", 2, "showChooseView");
          }
          this.mVoiceAssistantStateMachine.g().f();
          sendQuitPanelMessage();
          return;
        }
      }
      if (this.mVoicePresenter != null)
      {
        if (Looper.getMainLooper() == Looper.myLooper()) {
          this.mVoicePresenter.p(paramCommandInfo);
        } else {
          ThreadManager.getUIHandler().post(new VoiceAssistantCoreImpl.2(this, paramCommandInfo));
        }
        sendQuitPanelMessage();
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VoiceAssistantServiceImpl", 2, "do not execute command");
    }
  }
  
  public Activity getActivity()
  {
    return QBaseActivity.sTopActivity;
  }
  
  public List<VoiceItemInfo> getCurrentVoiceItemInfo()
  {
    VoiceMainPresenter localVoiceMainPresenter = this.mVoicePresenter;
    if (localVoiceMainPresenter != null) {
      return localVoiceMainPresenter.d();
    }
    return null;
  }
  
  public VoicePttInfo getVoicePttInfo()
  {
    VoiceAssistantStateMachine localVoiceAssistantStateMachine = this.mVoiceAssistantStateMachine;
    if (localVoiceAssistantStateMachine != null) {
      return localVoiceAssistantStateMachine.m();
    }
    return null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      quiteVoicePanel(true, true);
      ReportUtils.d(4);
    }
    return false;
  }
  
  public void initReceiver()
  {
    if ((this.isReceiverRegister.compareAndSet(false, true)) && (this.mReceiver == null))
    {
      this.mReceiver = new VoiceAssistantReceiver();
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("mqq.intent.action.QQ_BACKGROUND");
      localIntentFilter.addAction("mqq.intent.action.QQ_FOREGROUND");
      localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
      localIntentFilter.addAction("tencent.av.v2q.StopVideoChat");
      localIntentFilter.addAction("mqq.intent.action.ACCOUNT_KICKED");
      localIntentFilter.addAction("com.tencent.mobileqq.action.ae.OPEN_CAMERA");
      localIntentFilter.addAction("com.tencent.mobileqq.action.ae.CLOSE_CAMERA");
      IQAssistantTempApi localIQAssistantTempApi = (IQAssistantTempApi)QRoute.api(IQAssistantTempApi.class);
      localIntentFilter.addAction(localIQAssistantTempApi.getIpcConstants_ACTION_VOICE_RECORD_OFF());
      localIntentFilter.addAction(localIQAssistantTempApi.getIpcConstants_ACTION_VOICE_RECORD_ON());
      AssistantUtils.d().registerReceiver(this.mReceiver, localIntentFilter);
    }
  }
  
  public void initVoiceAssistant()
  {
    this.mTTSPlayerManager = new TTSPlayerManager();
    this.mVoicePresenter = new VoiceMainPresenter(this);
    initReceiver();
    new ViewCommandModelCheck();
    this.mVoiceAssistantStateMachine = new VoiceAssistantStateMachine("VoiceAssistantServiceImpl", this.mVoicePresenter);
    this.mVoiceAssistantStateMachine.f();
    this.mHandler = new Handler(Looper.getMainLooper(), this);
    this.mHandler.postDelayed(new VoiceAssistantCoreImpl.1(this), 500L);
  }
  
  public boolean isInSession()
  {
    VoiceMainPresenter localVoiceMainPresenter = this.mVoicePresenter;
    return (localVoiceMainPresenter != null) && (localVoiceMainPresenter.c());
  }
  
  public boolean isSilent()
  {
    Object localObject = AssistantUtils.d();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      localObject = (AudioManager)AssistantUtils.d().getSystemService("audio");
      int i = ((AudioManager)localObject).getStreamVolume(3);
      int j = ((AudioManager)localObject).getStreamMaxVolume(3);
      bool1 = bool2;
      if (i / j < 0.18F) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean isVoicePanelShow()
  {
    VoiceAssistantStateMachine localVoiceAssistantStateMachine = this.mVoiceAssistantStateMachine;
    return (localVoiceAssistantStateMachine != null) && (localVoiceAssistantStateMachine.l());
  }
  
  public boolean isVoicePlaying()
  {
    TTSPlayerManager localTTSPlayerManager = this.mTTSPlayerManager;
    return (localTTSPlayerManager != null) && (localTTSPlayerManager.a());
  }
  
  public void onConfirmSend(ConfirmSendInfo paramConfirmSendInfo)
  {
    VoiceAssistantStateMachine localVoiceAssistantStateMachine = this.mVoiceAssistantStateMachine;
    if (localVoiceAssistantStateMachine != null) {
      localVoiceAssistantStateMachine.a(paramConfirmSendInfo);
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime) {}
  
  public void onDestroy()
  {
    WakeManager.a().b("VoiceAssistantManager onDestroy");
    WakeManager.a().c = false;
    this.mVoicePresenter = null;
    Object localObject = this.mTTSPlayerManager;
    if (localObject != null)
    {
      ((TTSPlayerManager)localObject).d();
      this.mTTSPlayerManager = null;
    }
    if (this.isReceiverRegister.compareAndSet(true, false)) {
      AssistantUtils.d().unregisterReceiver(this.mReceiver);
    }
    localObject = this.mHandler;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacksAndMessages(null);
      this.mHandler = null;
    }
    localObject = this.mVoiceAssistantStateMachine;
    if (localObject != null)
    {
      ((VoiceAssistantStateMachine)localObject).q();
      this.mVoiceAssistantStateMachine = null;
    }
  }
  
  public void onStartRecord()
  {
    VoiceAssistantStateMachine localVoiceAssistantStateMachine = this.mVoiceAssistantStateMachine;
    if (localVoiceAssistantStateMachine != null) {
      localVoiceAssistantStateMachine.p();
    }
  }
  
  public void onVoiceMessageCallBack(int paramInt, Object paramObject)
  {
    VoiceAssistantStateMachine localVoiceAssistantStateMachine = this.mVoiceAssistantStateMachine;
    if (localVoiceAssistantStateMachine != null) {
      localVoiceAssistantStateMachine.c(paramInt, paramObject);
    }
  }
  
  public void play(String paramString)
  {
    TTSPlayerManager localTTSPlayerManager = this.mTTSPlayerManager;
    if (localTTSPlayerManager != null) {
      localTTSPlayerManager.a(paramString, Math.max(AudioNewRecorder.a, 0));
    }
  }
  
  public void quitePanel(boolean paramBoolean)
  {
    if (!WakeManager.a().h())
    {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceAssistantServiceImpl", 2, "quitePanel not allow");
      }
      return;
    }
    Object localObject = this.mVoiceAssistantStateMachine;
    if (localObject != null) {
      ((VoiceAssistantStateMachine)localObject).b(4, Boolean.valueOf(paramBoolean));
    }
    localObject = this.mVoicePresenter;
    if (localObject != null) {
      ((VoiceMainPresenter)localObject).e();
    }
    localObject = this.mTTSPlayerManager;
    if (localObject != null) {
      ((TTSPlayerManager)localObject).d();
    }
  }
  
  public void quiteVoicePanel(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      executeCommand(CommandUtils.c());
      return;
    }
    quitePanel(paramBoolean1);
  }
  
  public void resendVoice()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceAssistantServiceImpl", 2, "resendVoice");
    }
    VoiceAssistantStateMachine localVoiceAssistantStateMachine = this.mVoiceAssistantStateMachine;
    if (localVoiceAssistantStateMachine != null) {
      localVoiceAssistantStateMachine.o();
    }
  }
  
  public void sendMessage(int paramInt)
  {
    VoiceAssistantStateMachine localVoiceAssistantStateMachine = this.mVoiceAssistantStateMachine;
    if (localVoiceAssistantStateMachine != null) {
      localVoiceAssistantStateMachine.d(paramInt);
    }
  }
  
  public void sendQuitPanelMessage()
  {
    Handler localHandler = this.mHandler;
    if (localHandler != null)
    {
      localHandler.removeMessages(1);
      localHandler = this.mHandler;
      localHandler.sendMessageDelayed(localHandler.obtainMessage(1), 30000L);
    }
  }
  
  public void setPanelEventListener(IPanelEventListener paramIPanelEventListener)
  {
    VoiceAssistantStateMachine localVoiceAssistantStateMachine = this.mVoiceAssistantStateMachine;
    if (localVoiceAssistantStateMachine != null) {
      localVoiceAssistantStateMachine.a(paramIPanelEventListener);
    }
  }
  
  public void setPerformanceText(String paramString) {}
  
  public void setPlayEventListener(IPlayEventListener paramIPlayEventListener)
  {
    TTSPlayerManager localTTSPlayerManager = this.mTTSPlayerManager;
    if (localTTSPlayerManager != null) {
      localTTSPlayerManager.a(paramIPlayEventListener);
    }
  }
  
  public void setVoiceCommandListener(IVoiceCommandListener paramIVoiceCommandListener)
  {
    VoiceAssistantStateMachine localVoiceAssistantStateMachine = this.mVoiceAssistantStateMachine;
    if (localVoiceAssistantStateMachine != null) {
      localVoiceAssistantStateMachine.a(paramIVoiceCommandListener);
    }
  }
  
  public void setVoiceVadListener(IVoiceVadListener paramIVoiceVadListener)
  {
    VoiceAssistantStateMachine localVoiceAssistantStateMachine = this.mVoiceAssistantStateMachine;
    if (localVoiceAssistantStateMachine != null) {
      localVoiceAssistantStateMachine.a(paramIVoiceVadListener);
    }
  }
  
  public void startPanelTipsAnimation()
  {
    VoiceAssistantStateMachine localVoiceAssistantStateMachine = this.mVoiceAssistantStateMachine;
    if (localVoiceAssistantStateMachine != null) {
      localVoiceAssistantStateMachine.j();
    }
  }
  
  public void stop()
  {
    TTSPlayerManager localTTSPlayerManager = this.mTTSPlayerManager;
    if (localTTSPlayerManager != null) {
      localTTSPlayerManager.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.api.impl.VoiceAssistantCoreImpl
 * JD-Core Version:    0.7.0.1
 */