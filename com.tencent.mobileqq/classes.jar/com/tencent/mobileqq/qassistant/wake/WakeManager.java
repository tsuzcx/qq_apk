package com.tencent.mobileqq.qassistant.wake;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profilecommon.observer.ProfileCommonObserver;
import com.tencent.mobileqq.qassistant.audio.AudioNewController;
import com.tencent.mobileqq.qassistant.core.AssistantUtils;
import com.tencent.mobileqq.qassistant.core.FriendSortHelper;
import com.tencent.mobileqq.qassistant.core.LoadManager;
import com.tencent.mobileqq.qassistant.core.VoiceAssistantManager;
import com.tencent.mobileqq.qassistant.setting.QassistantConfig;
import com.tencent.mobileqq.qassistant.wake.aicore.QQWakeAIEngine;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AppUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;

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
      str = "enable" + str;
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
    if (QQAssistantGuider.c)
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
    if (BaseApplicationImpl.sProcessId == 1) {}
    for (int k = 1; k == 0; k = 0)
    {
      AssistantUtils.a("HelloQQWake", "canInit() not in MainProcess");
      return false;
    }
    if (Build.VERSION.SDK_INT >= 23) {
      if (BaseApplicationImpl.getContext().checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
        k = 1;
      }
    }
    for (;;)
    {
      if (k == 0)
      {
        AssistantUtils.a("HelloQQWake", "canInit() no record permission");
        return false;
        k = 0;
      }
      else
      {
        QQAppInterface localQQAppInterface = AssistantUtils.a();
        if ((localQQAppInterface == null) || (!localQQAppInterface.isLogin()))
        {
          AssistantUtils.a("HelloQQWake", "canInit() not login");
          return false;
        }
        return true;
        k = 1;
      }
    }
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
  
  /* Error */
  public void a(BaseActivity paramBaseActivity, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 258	com/tencent/mobileqq/qassistant/wake/QQAssistantGuider:jdField_b_of_type_Boolean	Z
    //   5: ifeq +17 -> 22
    //   8: invokestatic 262	com/tencent/mobileqq/qassistant/wake/WakeServiceCallBack$WakeServiceCallBackWithTips:b	()Lcom/tencent/mobileqq/qassistant/wake/WakeServiceCallBack;
    //   11: astore_3
    //   12: aload_0
    //   13: aload_1
    //   14: aload_2
    //   15: aload_3
    //   16: invokevirtual 265	com/tencent/mobileqq/qassistant/wake/WakeManager:a	(Lcom/tencent/mobileqq/app/BaseActivity;Ljava/lang/String;Lcom/tencent/mobileqq/qassistant/wake/WakeServiceCallBack;)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: invokestatic 163	com/tencent/mobileqq/qassistant/wake/WakeServiceCallBack:a	()Lcom/tencent/mobileqq/qassistant/wake/WakeServiceCallBack;
    //   25: astore_3
    //   26: goto -14 -> 12
    //   29: astore_1
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	WakeManager
    //   0	34	1	paramBaseActivity	BaseActivity
    //   0	34	2	paramString	String
    //   11	15	3	localWakeServiceCallBack	WakeServiceCallBack
    // Exception table:
    //   from	to	target	type
    //   2	12	29	finally
    //   12	19	29	finally
    //   22	26	29	finally
  }
  
  public void a(BaseActivity paramBaseActivity, String paramString, WakeServiceCallBack paramWakeServiceCallBack)
  {
    for (;;)
    {
      try
      {
        AssistantUtils.a("HelloQQWake", "startRecord():from:" + paramString);
        if (c())
        {
          if ((!this.d) || (!QQAssistantGuider.a())) {
            continue;
          }
          if ((AppUtil.a()) && (paramBaseActivity != null))
          {
            AssistantUtils.a("HelloQQWake", "startRecord() guider: " + paramBaseActivity.getActivityName());
            if (!QQAssistantGuider.c) {
              paramBaseActivity.runOnUiThread(new WakeManager.2(this, paramBaseActivity));
            }
            QQAssistantGuider.c = true;
            ReportController.b(null, "dc00898", "", "", "0X800B162", "0X800B162", 0, 0, "", "", "", "");
          }
        }
        return;
        if (a())
        {
          AssistantUtils.a("HelloQQWake", "startRecord() no guider");
          this.jdField_a_of_type_ComTencentMobileqqQassistantWakeWakeServiceCallBack = paramWakeServiceCallBack;
          paramBaseActivity = AssistantUtils.a();
          if (paramBaseActivity != null) {
            paramBaseActivity.a(1);
          }
          if (!"firstInit".equals(paramString)) {
            continue;
          }
          ReportController.b(null, "dc00898", "", "", "0X800B160", "0X800B160", 0, 0, "", "", "", "");
          continue;
        }
        AssistantUtils.a("HelloQQWake", "startRecord() initRecorder");
      }
      finally {}
      d();
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      a(BaseActivity.sTopActivity, paramString);
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
    AssistantUtils.a("HelloQQWake", "setCanOpenInSp:" + paramBoolean);
    this.jdField_a_of_type_Boolean = paramBoolean;
    try
    {
      SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("qq_assistant_sp_key", 0).edit();
      localEditor.putBoolean("qq_assistant_wake_open", paramBoolean);
      localEditor.commit();
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
    if ((this.jdField_a_of_type_ComTencentMobileqqQassistantWakeHelloQQHelper == null) || (!this.jdField_a_of_type_ComTencentMobileqqQassistantWakeHelloQQHelper.b()))
    {
      AssistantUtils.a("HelloQQWake", "allInit() HelloQQHelper.isInit() false");
      return false;
    }
    AssistantUtils.a("HelloQQWake", "allInit() wakeInit true");
    return true;
  }
  
  public WakeManager b()
  {
    AssistantUtils.a("HelloQQWake", "init()");
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("qq_assistant_sp_key", 0);
    this.jdField_a_of_type_Boolean = ((SharedPreferences)localObject).getBoolean("qq_assistant_wake_open", false);
    this.d = ((SharedPreferences)localObject).getBoolean(a(), false);
    this.e = ((SharedPreferences)localObject).getBoolean("ban", false);
    this.i = SoLoadUtil.a();
    FriendSortHelper.a(((SharedPreferences)localObject).getString("confidence", String.valueOf(0.85F)));
    if (b())
    {
      localObject = AssistantUtils.a();
      if (localObject != null) {
        ((VoiceAssistantManager)localObject).a();
      }
    }
    this.jdField_b_of_type_Boolean = false;
    this.f = false;
    this.g = false;
    this.h = false;
    this.jdField_a_of_type_ComTencentMobileqqProfilecommonObserverProfileCommonObserver = new WakeManager.1(this);
    localObject = AssistantUtils.a();
    if (localObject != null) {
      ((QQAppInterface)localObject).addObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecommonObserverProfileCommonObserver);
    }
    this.j = true;
    return this;
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_AndroidOsHandler != null) {
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(1000);
    }
  }
  
  public void b(String paramString)
  {
    try
    {
      AssistantUtils.a("HelloQQWake", "stopRecord() from:" + paramString);
      paramString = AssistantUtils.a();
      if (paramString != null) {
        paramString.a(5);
      }
      return;
    }
    finally {}
  }
  
  public boolean b()
  {
    if (Build.VERSION.SDK_INT < 21)
    {
      AssistantUtils.a("HelloQQWake", "getEnable() VERSION : " + Build.VERSION.SDK_INT);
      return false;
    }
    if (this.i)
    {
      AssistantUtils.a("HelloQQWake", "getEnable() cpuBan true.it is x86 cpu");
      return false;
    }
    if (this.e)
    {
      AssistantUtils.a("HelloQQWake", "getEnable() needBan :MANUFACTURER:" + Build.MANUFACTURER + ",BRAND:" + Build.BRAND + ",MODEL:" + Build.MODEL + ",FINGERPRINT:" + Build.FINGERPRINT + ",ANDROID_ID:" + DeviceInfoUtil.f());
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
    if (this.jdField_b_of_type_AndroidOsHandler != null) {
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(1001);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return false;
                AssistantUtils.a("HelloQQWake", "WakeService MSG_START_RECORD");
              } while ((this.jdField_b_of_type_Boolean) && (e()));
              if (this.jdField_a_of_type_ComTencentMobileqqQassistantWakeHelloQQHelper != null) {
                this.jdField_a_of_type_ComTencentMobileqqQassistantWakeHelloQQHelper.b();
              }
              e();
              AssistantUtils.a("HelloQQWake", "WakeService MSG_START_RECORD isMonitor：" + this.jdField_b_of_type_Boolean);
              if (this.jdField_b_of_type_Boolean)
              {
                paramMessage = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(1004);
                this.jdField_b_of_type_AndroidOsHandler.sendMessageDelayed(paramMessage, 10000L);
              }
              this.jdField_a_of_type_AndroidOsHandler.post(new WakeManager.3(this));
              return false;
              AssistantUtils.a("HelloQQWake", "WakeService stopRecord isMonitor:" + this.jdField_b_of_type_Boolean);
            } while (!this.jdField_b_of_type_Boolean);
            this.jdField_b_of_type_Boolean = false;
            a().b();
          } while (this.jdField_a_of_type_ComTencentMobileqqQassistantWakeHelloQQHelper == null);
          this.jdField_a_of_type_ComTencentMobileqqQassistantWakeHelloQQHelper.b();
          return false;
        } while ((!(paramMessage.obj instanceof byte[])) || (this.jdField_a_of_type_ComTencentMobileqqQassistantWakeWakeVadDataPool == null) || (this.jdField_a_of_type_ComTencentMobileqqQassistantWakeHelloQQHelper == null));
        paramMessage = (byte[])paramMessage.obj;
        paramMessage = this.jdField_a_of_type_ComTencentMobileqqQassistantWakeWakeVadDataPool.a(paramMessage);
      } while ((paramMessage == null) || (paramMessage.isEmpty()));
      this.jdField_a_of_type_ComTencentMobileqqQassistantWakeHelloQQHelper.a(paramMessage);
      return false;
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
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(1004);
      AssistantUtils.a("HelloQQWake", "MSG_IS_IN_BACKGROUND_ROTATION");
      if (AssistantUtils.a())
      {
        AssistantUtils.a("HelloQQWake", "MSG_IS_IN_BACKGROUND_ROTATION isBackground true");
        b("MSG_IS_IN_BACKGROUND_ROTATION");
      }
    } while (!this.jdField_b_of_type_Boolean);
    paramMessage = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(1004);
    this.jdField_b_of_type_AndroidOsHandler.sendMessageDelayed(paramMessage, 10000L);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.wake.WakeManager
 * JD-Core Version:    0.7.0.1
 */