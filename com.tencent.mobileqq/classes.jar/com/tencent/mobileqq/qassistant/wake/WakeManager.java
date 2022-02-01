package com.tencent.mobileqq.qassistant.wake;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.profilecommon.observer.ProfileCommonObserver;
import com.tencent.mobileqq.qassistant.api.IVoiceAssistantCore;
import com.tencent.mobileqq.qassistant.audio.AudioNewController;
import com.tencent.mobileqq.qassistant.core.AssistantUtils;
import com.tencent.mobileqq.qassistant.core.FriendSortHelper;
import com.tencent.mobileqq.qassistant.core.LoadManager;
import com.tencent.mobileqq.qassistant.setting.QassistantConfig;
import com.tencent.mobileqq.qassistant.wake.aicore.QQWakeAIEngine;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class WakeManager
  implements Handler.Callback
{
  long jdField_a_of_type_Long;
  private volatile Handler jdField_a_of_type_AndroidOsHandler;
  private volatile HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private ProfileCommonObserver jdField_a_of_type_ComTencentMobileqqProfilecommonObserverProfileCommonObserver;
  private AudioNewController jdField_a_of_type_ComTencentMobileqqQassistantAudioAudioNewController;
  private volatile HelloQQHelper jdField_a_of_type_ComTencentMobileqqQassistantWakeHelloQQHelper;
  private WakeManager.WakeLoadCallBack jdField_a_of_type_ComTencentMobileqqQassistantWakeWakeManager$WakeLoadCallBack = new WakeManager.WakeLoadCallBack();
  private WakeServiceCallBack jdField_a_of_type_ComTencentMobileqqQassistantWakeWakeServiceCallBack;
  private volatile WakeVadDataPool jdField_a_of_type_ComTencentMobileqqQassistantWakeWakeVadDataPool;
  public volatile boolean a;
  private Handler b;
  public volatile boolean b;
  public boolean c = false;
  public volatile boolean d;
  public volatile boolean e;
  public volatile boolean f;
  public volatile boolean g;
  public volatile boolean h;
  public boolean i = false;
  private boolean j = false;
  
  private WakeManager()
  {
    this.jdField_b_of_type_AndroidOsHandler = null;
    AssistantUtils.a("HelloQQWake", "WakeManager()");
  }
  
  private long a()
  {
    return 100L;
  }
  
  public static WakeManager a()
  {
    return WakeManager.WakeManagerHolder.a();
  }
  
  public static String a()
  {
    try
    {
      String str = AssistantUtils.a().getAccount();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("enable");
      localStringBuilder.append(str);
      str = localStringBuilder.toString();
      return str;
    }
    catch (Exception localException) {}
    return "enable";
  }
  
  private boolean c()
  {
    if (this.f)
    {
      AssistantUtils.a("HelloQQWake", "canStart() isBackstage is true");
      return false;
    }
    if (this.g)
    {
      AssistantUtils.a("HelloQQWake", "canStart() isCameraOrChat is true");
      return false;
    }
    if (this.h)
    {
      AssistantUtils.a("HelloQQWake", "canStart() isAvGame is true");
      return false;
    }
    if (!b())
    {
      AssistantUtils.a("HelloQQWake", "canStart() enable is false");
      return false;
    }
    if (!QQWakeAIEngine.jdField_b_of_type_Boolean)
    {
      AssistantUtils.a("HelloQQWake", "canStart() QQWakeAIEngine.sCanInit is  false");
      return false;
    }
    if (!this.j)
    {
      AssistantUtils.a("HelloQQWake", "canStart() wakeManagerInit is false");
      return false;
    }
    if (QQAssistantGuider.jdField_b_of_type_Boolean)
    {
      AssistantUtils.a("HelloQQWake", "canStart() QQAssistantGuider.isShow");
      return false;
    }
    return true;
  }
  
  private void d()
  {
    try
    {
      if (d())
      {
        if (this.jdField_a_of_type_AndroidOsHandler == null) {
          this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
        }
        if (this.jdField_a_of_type_AndroidOsHandlerThread == null)
        {
          this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("QQWAKE_THREAD");
          this.jdField_a_of_type_AndroidOsHandlerThread.start();
        }
        if (this.jdField_b_of_type_AndroidOsHandler == null) {
          this.jdField_b_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqQassistantWakeWakeVadDataPool == null) {
          this.jdField_a_of_type_ComTencentMobileqqQassistantWakeWakeVadDataPool = new WakeVadDataPool();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqQassistantWakeWakeManager$WakeLoadCallBack == null) {
          this.jdField_a_of_type_ComTencentMobileqqQassistantWakeWakeManager$WakeLoadCallBack = new WakeManager.WakeLoadCallBack();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqQassistantWakeWakeServiceCallBack == null) {
          this.jdField_a_of_type_ComTencentMobileqqQassistantWakeWakeServiceCallBack = WakeServiceCallBack.a();
        }
        if (((this.jdField_a_of_type_ComTencentMobileqqQassistantWakeHelloQQHelper == null) || (!this.jdField_a_of_type_ComTencentMobileqqQassistantWakeHelloQQHelper.b())) && (LoadManager.a(this.jdField_a_of_type_ComTencentMobileqqQassistantWakeWakeManager$WakeLoadCallBack)))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqQassistantWakeHelloQQHelper == null) {
            this.jdField_a_of_type_ComTencentMobileqqQassistantWakeHelloQQHelper = new HelloQQHelper();
          }
          this.jdField_a_of_type_ComTencentMobileqqQassistantWakeHelloQQHelper.a(new WakeManager.ServiceHelloQQCallback(this));
          this.jdField_a_of_type_ComTencentMobileqqQassistantWakeHelloQQHelper.a(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
        }
        this.c = true;
        if (a()) {
          a("WakeManager init");
        }
      }
      return;
    }
    finally {}
  }
  
  private boolean d()
  {
    if (!LoadManager.a(this.jdField_a_of_type_ComTencentMobileqqQassistantWakeWakeManager$WakeLoadCallBack))
    {
      AssistantUtils.a("HelloQQWake", "canInit() no model");
      return false;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      AssistantUtils.a("HelloQQWake", "canInit() canOpenInSp false");
      return false;
    }
    int k;
    if (MobileQQ.sProcessId == 1) {
      k = 1;
    } else {
      k = 0;
    }
    if (k == 0)
    {
      AssistantUtils.a("HelloQQWake", "canInit() not in MainProcess");
      return false;
    }
    if ((Build.VERSION.SDK_INT >= 23) && (MobileQQ.sMobileQQ.checkSelfPermission("android.permission.RECORD_AUDIO") != 0)) {
      k = 0;
    } else {
      k = 1;
    }
    if (k == 0)
    {
      AssistantUtils.a("HelloQQWake", "canInit() no record permission");
      return false;
    }
    if (!AssistantUtils.a().isLogin())
    {
      AssistantUtils.a("HelloQQWake", "canInit() not login");
      return false;
    }
    return true;
  }
  
  private void e()
  {
    AudioNewController localAudioNewController = a();
    if (localAudioNewController != null)
    {
      this.jdField_b_of_type_Boolean = localAudioNewController.a(new WakeManager.4(this, a()));
      if (!this.jdField_b_of_type_Boolean) {
        AssistantUtils.a("HelloQQWake", "Recorder init failure");
      }
    }
  }
  
  private boolean e()
  {
    return a().jdField_a_of_type_Boolean;
  }
  
  private boolean f()
  {
    boolean bool = ((KeyguardManager)AssistantUtils.a().getApplicationContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MSG_IS_IN_BACKGROUND_ROTATION isBackgroundStop:");
    localStringBuilder.append(AssistantUtils.a().isBackgroundStop);
    localStringBuilder.append(",isScreenLocked:");
    localStringBuilder.append(bool);
    AssistantUtils.a("HelloQQWake", localStringBuilder.toString());
    return (AssistantUtils.a().isBackgroundStop) || (bool);
  }
  
  private boolean g()
  {
    return MobileQQ.sProcessId == 1;
  }
  
  public AudioNewController a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantAudioAudioNewController == null) {
      this.jdField_a_of_type_ComTencentMobileqqQassistantAudioAudioNewController = new AudioNewController();
    }
    return this.jdField_a_of_type_ComTencentMobileqqQassistantAudioAudioNewController;
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_AndroidOsHandler != null)
    {
      AssistantUtils.a("HelloQQWake", "release() MSG_RELEASE");
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(1003);
    }
  }
  
  public void a(QBaseActivity paramQBaseActivity, String paramString)
  {
    try
    {
      WakeServiceCallBack localWakeServiceCallBack;
      if (QQAssistantGuider.jdField_a_of_type_Boolean) {
        localWakeServiceCallBack = WakeServiceCallBackWithTips.b();
      } else {
        localWakeServiceCallBack = WakeServiceCallBack.a();
      }
      a(paramQBaseActivity, paramString, localWakeServiceCallBack);
      return;
    }
    finally {}
  }
  
  public void a(QBaseActivity paramQBaseActivity, String paramString, WakeServiceCallBack paramWakeServiceCallBack)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startRecord():from:");
      localStringBuilder.append(paramString);
      AssistantUtils.a("HelloQQWake", localStringBuilder.toString());
      if (c()) {
        if ((this.d) && (QQAssistantGuiderUtil.a()))
        {
          if ((g()) && (paramQBaseActivity != null))
          {
            paramString = new StringBuilder();
            paramString.append("startRecord() guider: ");
            paramString.append(paramQBaseActivity.getActivityName());
            AssistantUtils.a("HelloQQWake", paramString.toString());
            if (!QQAssistantGuider.jdField_b_of_type_Boolean) {
              paramQBaseActivity.runOnUiThread(new WakeManager.2(this, paramQBaseActivity));
            }
            QQAssistantGuider.jdField_b_of_type_Boolean = true;
            ReportController.b(null, "dc00898", "", "", "0X800B162", "0X800B162", 0, 0, "", "", "", "");
          }
        }
        else if (a())
        {
          AssistantUtils.a("HelloQQWake", "startRecord() no guider");
          this.jdField_a_of_type_ComTencentMobileqqQassistantWakeWakeServiceCallBack = paramWakeServiceCallBack;
          paramQBaseActivity = AssistantUtils.a();
          if (paramQBaseActivity != null) {
            paramQBaseActivity.sendMessage(1);
          }
          if ("firstInit".equals(paramString)) {
            ReportController.b(null, "dc00898", "", "", "0X800B160", "0X800B160", 0, 0, "", "", "", "");
          }
        }
        else
        {
          AssistantUtils.a("HelloQQWake", "startRecord() initRecorder");
          d();
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    try
    {
      a(QBaseActivity.sTopActivity, paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setCanOpenInSp:");
    ((StringBuilder)localObject).append(paramBoolean);
    AssistantUtils.a("HelloQQWake", ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_Boolean = paramBoolean;
    try
    {
      localObject = MobileQQ.sMobileQQ.getSharedPreferences("qq_assistant_sp_key", 0).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("qq_assistant_wake_open", paramBoolean);
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
    catch (Exception localException)
    {
      AssistantUtils.a("HelloQQWake", localException.getMessage());
    }
  }
  
  public boolean a()
  {
    if (!this.c)
    {
      AssistantUtils.a("HelloQQWake", "allInit() wakeInit false");
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqQassistantWakeHelloQQHelper != null) && (this.jdField_a_of_type_ComTencentMobileqqQassistantWakeHelloQQHelper.b()))
    {
      AssistantUtils.a("HelloQQWake", "allInit() wakeInit true");
      return true;
    }
    AssistantUtils.a("HelloQQWake", "allInit() HelloQQHelper.isInit() false");
    return false;
  }
  
  public WakeManager b()
  {
    AssistantUtils.a("HelloQQWake", "init()");
    Object localObject = MobileQQ.sMobileQQ.getSharedPreferences("qq_assistant_sp_key", 0);
    this.jdField_a_of_type_Boolean = ((SharedPreferences)localObject).getBoolean("qq_assistant_wake_open", false);
    this.d = ((SharedPreferences)localObject).getBoolean(a(), false);
    this.e = ((SharedPreferences)localObject).getBoolean("ban", false);
    this.i = SoLoadUtil.a();
    FriendSortHelper.a(((SharedPreferences)localObject).getString("confidence", String.valueOf(0.85F)));
    if (b())
    {
      localObject = AssistantUtils.a();
      if (localObject != null) {
        ((IVoiceAssistantCore)localObject).initVoiceAssistant();
      }
    }
    this.jdField_b_of_type_Boolean = false;
    this.f = false;
    this.g = false;
    this.h = false;
    localObject = AssistantUtils.a();
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqProfilecommonObserverProfileCommonObserver = new WakeManager.1(this);
      ((AppInterface)localObject).addObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecommonObserverProfileCommonObserver);
    }
    this.j = true;
    return this;
  }
  
  public void b()
  {
    Handler localHandler = this.jdField_b_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.sendEmptyMessage(1000);
    }
  }
  
  public void b(String paramString)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stopRecord() from:");
      localStringBuilder.append(paramString);
      AssistantUtils.a("HelloQQWake", localStringBuilder.toString());
      paramString = AssistantUtils.a();
      if (paramString != null) {
        paramString.sendMessage(5);
      }
      return;
    }
    finally {}
  }
  
  public boolean b()
  {
    StringBuilder localStringBuilder;
    if (Build.VERSION.SDK_INT < 21)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getEnable() VERSION : ");
      localStringBuilder.append(Build.VERSION.SDK_INT);
      AssistantUtils.a("HelloQQWake", localStringBuilder.toString());
      return false;
    }
    if (this.i)
    {
      AssistantUtils.a("HelloQQWake", "getEnable() cpuBan true.it is x86 cpu");
      return false;
    }
    if (this.e)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getEnable() needBan :MANUFACTURER:");
      localStringBuilder.append(Build.MANUFACTURER);
      localStringBuilder.append(",BRAND:");
      localStringBuilder.append(Build.BRAND);
      localStringBuilder.append(",MODEL:");
      localStringBuilder.append(Build.MODEL);
      localStringBuilder.append(",FINGERPRINT:");
      localStringBuilder.append(Build.FINGERPRINT);
      localStringBuilder.append(",ANDROID_ID:");
      localStringBuilder.append(DeviceInfoUtil.f());
      AssistantUtils.a("HelloQQWake", localStringBuilder.toString());
      return false;
    }
    if ((!this.d) && (!QassistantConfig.a()))
    {
      AssistantUtils.a("HelloQQWake", "getEnable() enable and isPublicVersion: false");
      return false;
    }
    return true;
  }
  
  public void c()
  {
    Handler localHandler = this.jdField_b_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.sendEmptyMessage(1001);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1004: 
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(1004);
      AssistantUtils.a("HelloQQWake", "MSG_IS_IN_BACKGROUND_ROTATION");
      if (f())
      {
        AssistantUtils.a("HelloQQWake", "MSG_IS_IN_BACKGROUND_ROTATION isBackground true");
        b("MSG_IS_IN_BACKGROUND_ROTATION");
      }
      if (this.jdField_b_of_type_Boolean)
      {
        paramMessage = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(1004);
        this.jdField_b_of_type_AndroidOsHandler.sendMessageDelayed(paramMessage, 10000L);
        return false;
      }
      break;
    case 1003: 
      AssistantUtils.a("HelloQQWake", "releaseQQWake()");
      if (this.jdField_a_of_type_ComTencentMobileqqQassistantWakeHelloQQHelper != null)
      {
        AssistantUtils.a("HelloQQWake", "releaseQQWake() in");
        this.jdField_a_of_type_ComTencentMobileqqQassistantWakeHelloQQHelper.a();
        this.jdField_a_of_type_ComTencentMobileqqQassistantWakeHelloQQHelper = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqQassistantWakeWakeVadDataPool != null) {
        this.jdField_a_of_type_ComTencentMobileqqQassistantWakeWakeVadDataPool.a();
      }
      this.c = false;
      return false;
    case 1002: 
      if (((paramMessage.obj instanceof byte[])) && (this.jdField_a_of_type_ComTencentMobileqqQassistantWakeWakeVadDataPool != null) && (this.jdField_a_of_type_ComTencentMobileqqQassistantWakeHelloQQHelper != null))
      {
        paramMessage = (byte[])paramMessage.obj;
        paramMessage = this.jdField_a_of_type_ComTencentMobileqqQassistantWakeWakeVadDataPool.a(paramMessage);
        if ((paramMessage != null) && (!paramMessage.isEmpty()))
        {
          this.jdField_a_of_type_ComTencentMobileqqQassistantWakeHelloQQHelper.a(paramMessage);
          return false;
        }
      }
      break;
    case 1001: 
      paramMessage = new StringBuilder();
      paramMessage.append("WakeService stopRecord isMonitor:");
      paramMessage.append(this.jdField_b_of_type_Boolean);
      AssistantUtils.a("HelloQQWake", paramMessage.toString());
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = false;
        a().b();
        if (this.jdField_a_of_type_ComTencentMobileqqQassistantWakeHelloQQHelper != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqQassistantWakeHelloQQHelper.b();
          return false;
        }
      }
      break;
    case 1000: 
      AssistantUtils.a("HelloQQWake", "WakeService MSG_START_RECORD");
      if ((!this.jdField_b_of_type_Boolean) || (!e()))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqQassistantWakeHelloQQHelper != null) {
          this.jdField_a_of_type_ComTencentMobileqqQassistantWakeHelloQQHelper.b();
        }
        e();
        paramMessage = new StringBuilder();
        paramMessage.append("WakeService MSG_START_RECORD isMonitor：");
        paramMessage.append(this.jdField_b_of_type_Boolean);
        AssistantUtils.a("HelloQQWake", paramMessage.toString());
        if (this.jdField_b_of_type_Boolean)
        {
          paramMessage = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(1004);
          this.jdField_b_of_type_AndroidOsHandler.sendMessageDelayed(paramMessage, 10000L);
        }
        this.jdField_a_of_type_AndroidOsHandler.post(new WakeManager.3(this));
      }
      break;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.wake.WakeManager
 * JD-Core Version:    0.7.0.1
 */