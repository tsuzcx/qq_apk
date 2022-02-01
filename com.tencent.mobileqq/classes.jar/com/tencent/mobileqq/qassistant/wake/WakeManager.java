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
  public volatile boolean a;
  public volatile boolean b;
  public boolean c = false;
  public volatile boolean d;
  public volatile boolean e;
  public volatile boolean f;
  public volatile boolean g;
  public volatile boolean h;
  long i;
  public boolean j = false;
  private WakeManager.WakeLoadCallBack k = new WakeManager.WakeLoadCallBack();
  private volatile Handler l;
  private volatile HandlerThread m;
  private volatile HelloQQHelper n;
  private volatile WakeVadDataPool o;
  private Handler p = null;
  private WakeServiceCallBack q;
  private ProfileCommonObserver r;
  private AudioNewController s;
  private boolean t = false;
  
  private WakeManager()
  {
    AssistantUtils.a("HelloQQWake", "WakeManager()");
  }
  
  public static WakeManager a()
  {
    return WakeManager.WakeManagerHolder.a();
  }
  
  public static String i()
  {
    try
    {
      String str = AssistantUtils.c().getAccount();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("enable");
      localStringBuilder.append(str);
      str = localStringBuilder.toString();
      return str;
    }
    catch (Exception localException) {}
    return "enable";
  }
  
  private void j()
  {
    try
    {
      if (l())
      {
        if (this.l == null) {
          this.l = new Handler(Looper.getMainLooper());
        }
        if (this.m == null)
        {
          this.m = new HandlerThread("QQWAKE_THREAD");
          this.m.start();
        }
        if (this.p == null) {
          this.p = new Handler(this.m.getLooper(), this);
        }
        if (this.o == null) {
          this.o = new WakeVadDataPool();
        }
        if (this.k == null) {
          this.k = new WakeManager.WakeLoadCallBack();
        }
        if (this.q == null) {
          this.q = WakeServiceCallBack.a();
        }
        if (((this.n == null) || (!this.n.e())) && (LoadManager.a(this.k)))
        {
          if (this.n == null) {
            this.n = new HelloQQHelper();
          }
          this.n.a(new WakeManager.ServiceHelloQQCallback(this));
          this.n.a(this.m.getLooper());
        }
        this.c = true;
        if (d()) {
          a("WakeManager init");
        }
      }
      return;
    }
    finally {}
  }
  
  private boolean k()
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
    if (!h())
    {
      AssistantUtils.a("HelloQQWake", "canStart() enable is false");
      return false;
    }
    if (!QQWakeAIEngine.c)
    {
      AssistantUtils.a("HelloQQWake", "canStart() QQWakeAIEngine.sCanInit is  false");
      return false;
    }
    if (!this.t)
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
  
  private boolean l()
  {
    if (!LoadManager.a(this.k))
    {
      AssistantUtils.a("HelloQQWake", "canInit() no model");
      return false;
    }
    if (!this.a)
    {
      AssistantUtils.a("HelloQQWake", "canInit() canOpenInSp false");
      return false;
    }
    int i1;
    if (MobileQQ.sProcessId == 1) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 == 0)
    {
      AssistantUtils.a("HelloQQWake", "canInit() not in MainProcess");
      return false;
    }
    if ((Build.VERSION.SDK_INT >= 23) && (MobileQQ.sMobileQQ.checkSelfPermission("android.permission.RECORD_AUDIO") != 0)) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    if (i1 == 0)
    {
      AssistantUtils.a("HelloQQWake", "canInit() no record permission");
      return false;
    }
    if (!AssistantUtils.c().isLogin())
    {
      AssistantUtils.a("HelloQQWake", "canInit() not login");
      return false;
    }
    return true;
  }
  
  private boolean m()
  {
    return b().b;
  }
  
  private boolean n()
  {
    boolean bool = ((KeyguardManager)AssistantUtils.d().getApplicationContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MSG_IS_IN_BACKGROUND_ROTATION isBackgroundStop:");
    localStringBuilder.append(AssistantUtils.c().isBackgroundStop);
    localStringBuilder.append(",isScreenLocked:");
    localStringBuilder.append(bool);
    AssistantUtils.a("HelloQQWake", localStringBuilder.toString());
    return (AssistantUtils.c().isBackgroundStop) || (bool);
  }
  
  private void o()
  {
    AudioNewController localAudioNewController = b();
    if (localAudioNewController != null)
    {
      this.b = localAudioNewController.a(new WakeManager.4(this, p()));
      if (!this.b) {
        AssistantUtils.a("HelloQQWake", "Recorder init failure");
      }
    }
  }
  
  private long p()
  {
    return 100L;
  }
  
  private boolean q()
  {
    return MobileQQ.sProcessId == 1;
  }
  
  public void a(QBaseActivity paramQBaseActivity, String paramString)
  {
    try
    {
      WakeServiceCallBack localWakeServiceCallBack;
      if (QQAssistantGuider.b) {
        localWakeServiceCallBack = WakeServiceCallBackWithTips.c();
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
      if (k()) {
        if ((this.d) && (QQAssistantGuiderUtil.a()))
        {
          if ((q()) && (paramQBaseActivity != null))
          {
            paramString = new StringBuilder();
            paramString.append("startRecord() guider: ");
            paramString.append(paramQBaseActivity.getActivityName());
            AssistantUtils.a("HelloQQWake", paramString.toString());
            if (!QQAssistantGuider.c) {
              paramQBaseActivity.runOnUiThread(new WakeManager.2(this, paramQBaseActivity));
            }
            QQAssistantGuider.c = true;
            ReportController.b(null, "dc00898", "", "", "0X800B162", "0X800B162", 0, 0, "", "", "", "");
          }
        }
        else if (d())
        {
          AssistantUtils.a("HelloQQWake", "startRecord() no guider");
          this.q = paramWakeServiceCallBack;
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
          j();
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
    this.a = paramBoolean;
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
  
  public AudioNewController b()
  {
    if (this.s == null) {
      this.s = new AudioNewController();
    }
    return this.s;
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
  
  public WakeManager c()
  {
    AssistantUtils.a("HelloQQWake", "init()");
    Object localObject = MobileQQ.sMobileQQ.getSharedPreferences("qq_assistant_sp_key", 0);
    this.a = ((SharedPreferences)localObject).getBoolean("qq_assistant_wake_open", false);
    this.d = ((SharedPreferences)localObject).getBoolean(i(), false);
    this.e = ((SharedPreferences)localObject).getBoolean("ban", false);
    this.j = SoLoadUtil.a();
    FriendSortHelper.c(((SharedPreferences)localObject).getString("confidence", String.valueOf(0.85F)));
    if (h())
    {
      localObject = AssistantUtils.a();
      if (localObject != null) {
        ((IVoiceAssistantCore)localObject).initVoiceAssistant();
      }
    }
    this.b = false;
    this.f = false;
    this.g = false;
    this.h = false;
    localObject = AssistantUtils.b();
    if (localObject != null)
    {
      this.r = new WakeManager.1(this);
      ((AppInterface)localObject).addObserver(this.r);
    }
    this.t = true;
    return this;
  }
  
  public boolean d()
  {
    if (!this.c)
    {
      AssistantUtils.a("HelloQQWake", "allInit() wakeInit false");
      return false;
    }
    if ((this.n != null) && (this.n.e()))
    {
      AssistantUtils.a("HelloQQWake", "allInit() wakeInit true");
      return true;
    }
    AssistantUtils.a("HelloQQWake", "allInit() HelloQQHelper.isInit() false");
    return false;
  }
  
  public void e()
  {
    if (this.p != null)
    {
      AssistantUtils.a("HelloQQWake", "release() MSG_RELEASE");
      this.p.sendEmptyMessage(1003);
    }
  }
  
  public void f()
  {
    Handler localHandler = this.p;
    if (localHandler != null) {
      localHandler.sendEmptyMessage(1000);
    }
  }
  
  public void g()
  {
    Handler localHandler = this.p;
    if (localHandler != null) {
      localHandler.sendEmptyMessage(1001);
    }
  }
  
  public boolean h()
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
    if (this.j)
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
      localStringBuilder.append(DeviceInfoUtil.j());
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
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1004: 
      this.p.removeMessages(1004);
      AssistantUtils.a("HelloQQWake", "MSG_IS_IN_BACKGROUND_ROTATION");
      if (n())
      {
        AssistantUtils.a("HelloQQWake", "MSG_IS_IN_BACKGROUND_ROTATION isBackground true");
        b("MSG_IS_IN_BACKGROUND_ROTATION");
      }
      if (this.b)
      {
        paramMessage = this.p.obtainMessage(1004);
        this.p.sendMessageDelayed(paramMessage, 10000L);
        return false;
      }
      break;
    case 1003: 
      AssistantUtils.a("HelloQQWake", "releaseQQWake()");
      if (this.n != null)
      {
        AssistantUtils.a("HelloQQWake", "releaseQQWake() in");
        this.n.d();
        this.n = null;
      }
      if (this.o != null) {
        this.o.a();
      }
      this.c = false;
      return false;
    case 1002: 
      if (((paramMessage.obj instanceof byte[])) && (this.o != null) && (this.n != null))
      {
        paramMessage = (byte[])paramMessage.obj;
        paramMessage = this.o.a(paramMessage);
        if ((paramMessage != null) && (!paramMessage.isEmpty()))
        {
          this.n.a(paramMessage);
          return false;
        }
      }
      break;
    case 1001: 
      paramMessage = new StringBuilder();
      paramMessage.append("WakeService stopRecord isMonitor:");
      paramMessage.append(this.b);
      AssistantUtils.a("HelloQQWake", paramMessage.toString());
      if (this.b)
      {
        this.b = false;
        b().b();
        if (this.n != null)
        {
          this.n.f();
          return false;
        }
      }
      break;
    case 1000: 
      AssistantUtils.a("HelloQQWake", "WakeService MSG_START_RECORD");
      if ((!this.b) || (!m()))
      {
        if (this.n != null) {
          this.n.f();
        }
        o();
        paramMessage = new StringBuilder();
        paramMessage.append("WakeService MSG_START_RECORD isMonitor：");
        paramMessage.append(this.b);
        AssistantUtils.a("HelloQQWake", paramMessage.toString());
        if (this.b)
        {
          paramMessage = this.p.obtainMessage(1004);
          this.p.sendMessageDelayed(paramMessage, 10000L);
        }
        this.l.post(new WakeManager.3(this));
      }
      break;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.wake.WakeManager
 * JD-Core Version:    0.7.0.1
 */