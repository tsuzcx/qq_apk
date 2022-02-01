package com.tencent.mobileqq.qassistant.core;

import android.app.Activity;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qassistant.audio.AudioNewRecorder;
import com.tencent.mobileqq.qassistant.audio.VoicePttInfo;
import com.tencent.mobileqq.qassistant.data.CommandInfo;
import com.tencent.mobileqq.qassistant.data.VoiceAssiatantRespInfo.ConfirmSendInfo;
import com.tencent.mobileqq.qassistant.data.VoiceItemInfo;
import com.tencent.mobileqq.qassistant.listener.IPanelEventListener;
import com.tencent.mobileqq.qassistant.listener.IVoiceCommandListener;
import com.tencent.mobileqq.qassistant.listener.IVoiceVadListener;
import com.tencent.mobileqq.qassistant.statemachine.VoiceAssistantStateMachine;
import com.tencent.mobileqq.qassistant.tts.IPlayEventListener;
import com.tencent.mobileqq.qassistant.tts.TTSPlayerManager;
import com.tencent.mobileqq.qassistant.util.CommandUtils;
import com.tencent.mobileqq.qassistant.util.ReportUtils;
import com.tencent.mobileqq.qassistant.wake.WakeManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class VoiceAssistantManager
  implements Handler.Callback, Manager
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private VoiceAssistantManager.VoiceAssistantReceiver jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager$VoiceAssistantReceiver;
  private VoiceMainPresenter jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceMainPresenter;
  private VoiceAssistantStateMachine jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine;
  private TTSPlayerManager jdField_a_of_type_ComTencentMobileqqQassistantTtsTTSPlayerManager;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  public VoiceAssistantManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(boolean paramBoolean)
  {
    if (!WakeManager.a().b()) {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceAssistantManager", 2, "quitePanel not allow");
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine != null) {
        this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine.a(4, Boolean.valueOf(paramBoolean));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceMainPresenter != null) {
        this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceMainPresenter.b();
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqQassistantTtsTTSPlayerManager == null);
    this.jdField_a_of_type_ComTencentMobileqqQassistantTtsTTSPlayerManager.c();
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) && (this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager$VoiceAssistantReceiver == null))
    {
      this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager$VoiceAssistantReceiver = new VoiceAssistantManager.VoiceAssistantReceiver(this, null);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("mqq.intent.action.QQ_BACKGROUND");
      localIntentFilter.addAction("mqq.intent.action.QQ_FOREGROUND");
      localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
      localIntentFilter.addAction("tencent.av.v2q.StopVideoChat");
      localIntentFilter.addAction("mqq.intent.action.ACCOUNT_KICKED");
      localIntentFilter.addAction("com.tencent.mobileqq.action.ae.OPEN_CAMERA");
      localIntentFilter.addAction("com.tencent.mobileqq.action.ae.CLOSE_CAMERA");
      localIntentFilter.addAction("tencent.avgame.notify.voice.record.off");
      localIntentFilter.addAction("tencent.avgame.notify.voice.record.on");
      BaseApplicationImpl.context.registerReceiver(this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager$VoiceAssistantReceiver, localIntentFilter);
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1), 30000L);
    }
  }
  
  public Activity a()
  {
    return BaseActivity.sTopActivity;
  }
  
  public QQAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  public VoicePttInfo a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine != null) {
      return this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine.a();
    }
    return null;
  }
  
  public List<VoiceItemInfo> a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceMainPresenter != null) {
      return this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceMainPresenter.a();
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqQassistantTtsTTSPlayerManager = new TTSPlayerManager();
    this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceMainPresenter = new VoiceMainPresenter(this);
    f();
    new ViewCommandModelCheck();
    this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine = new VoiceAssistantStateMachine("VoiceAssistantManager", this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceMainPresenter);
    this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine.e();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new VoiceAssistantManager.1(this), 500L);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine != null) {
      this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine.b(paramInt);
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine != null) {
      this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine.b(paramInt, paramObject);
    }
  }
  
  public void a(CommandInfo paramCommandInfo)
  {
    if (!WakeManager.a().b()) {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceAssistantManager", 2, "executeCommand not allow");
      }
    }
    do
    {
      do
      {
        return;
        if ((c()) && (paramCommandInfo != null)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("VoiceAssistantManager", 2, "do not execute command");
      return;
      if ((!TextUtils.isEmpty(paramCommandInfo.b)) && (paramCommandInfo.b.equals("发消息")) && (this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine != null) && (this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine.a() != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VoiceAssistantManager", 2, "showChooseView");
        }
        this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine.a().f();
        g();
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceMainPresenter == null);
    if (Looper.getMainLooper() == Looper.myLooper()) {
      this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceMainPresenter.p(paramCommandInfo);
    }
    for (;;)
    {
      g();
      return;
      ThreadManager.getUIHandler().post(new VoiceAssistantManager.2(this, paramCommandInfo));
    }
  }
  
  public void a(VoiceAssiatantRespInfo.ConfirmSendInfo paramConfirmSendInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine != null) {
      this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine.a(paramConfirmSendInfo);
    }
  }
  
  public void a(IPanelEventListener paramIPanelEventListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine != null) {
      this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine.a(paramIPanelEventListener);
    }
  }
  
  public void a(IVoiceCommandListener paramIVoiceCommandListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine != null) {
      this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine.a(paramIVoiceCommandListener);
    }
  }
  
  public void a(IVoiceVadListener paramIVoiceVadListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine != null) {
      this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine.a(paramIVoiceVadListener);
    }
  }
  
  public void a(IPlayEventListener paramIPlayEventListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantTtsTTSPlayerManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqQassistantTtsTTSPlayerManager.a(paramIPlayEventListener);
    }
  }
  
  public void a(String paramString)
  {
    TTSPlayerManager localTTSPlayerManager;
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantTtsTTSPlayerManager != null)
    {
      localTTSPlayerManager = this.jdField_a_of_type_ComTencentMobileqqQassistantTtsTTSPlayerManager;
      if (AudioNewRecorder.a <= 0) {
        break label29;
      }
    }
    label29:
    for (int i = AudioNewRecorder.a;; i = 0)
    {
      localTTSPlayerManager.a(paramString, i);
      return;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      a(CommandUtils.c());
      return;
    }
    a(paramBoolean1);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceMainPresenter != null) && (this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceMainPresenter.a());
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine != null) {
      this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine.f();
    }
  }
  
  public void b(String paramString) {}
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp() != null))
    {
      AudioManager localAudioManager = (AudioManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSystemService("audio");
      int i = localAudioManager.getStreamVolume(3);
      int j = localAudioManager.getStreamMaxVolume(3);
      return i / j < 0.18F;
    }
    return false;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine != null) {
      this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine.g();
    }
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine != null) && (this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine.a());
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceAssistantManager", 2, "resendVoice");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine != null) {
      this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine.h();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine != null) {
      this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine.i();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      a(true, true);
      ReportUtils.d(4);
    }
  }
  
  public void onDestroy()
  {
    WakeManager.a().b("VoiceAssistantManager onDestroy");
    WakeManager.a().c = false;
    this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceMainPresenter = null;
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantTtsTTSPlayerManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqQassistantTtsTTSPlayerManager.c();
      this.jdField_a_of_type_ComTencentMobileqqQassistantTtsTTSPlayerManager = null;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false)) {
      BaseApplicationImpl.context.unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager$VoiceAssistantReceiver);
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine.j();
      this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.core.VoiceAssistantManager
 * JD-Core Version:    0.7.0.1
 */