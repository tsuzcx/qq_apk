package com.tencent.mobileqq.qqlive.trtc.ipc;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qqlive.data.config.ConfigData;
import com.tencent.mobileqq.qqlive.trtc.TRTCEngineProxy;
import com.tencent.mobileqq.qqlive.trtc.audio.TRTCFakeAudioSource;
import com.tencent.mobileqq.qqlive.trtc.room.TRTCFakeRoomCtrl;
import com.tencent.mobileqq.qqlive.trtc.video.source.screen.TRTCFakeScreenCaptureSource;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class TRTCClientIPCModule
  extends QIPCModule
{
  private final CopyOnWriteArrayList<ITRTCIPCHandler> a = new CopyOnWriteArrayList();
  private WeakReference<Context> b = null;
  private TRTCClientIPCModule.IPCConnectListenerImpl c = new TRTCClientIPCModule.IPCConnectListenerImpl(this, null);
  
  private TRTCClientIPCModule(String paramString)
  {
    super(paramString);
    this.a.add(new TRTCFakeAudioSource());
    this.a.add(new TRTCFakeRoomCtrl());
    this.a.add(new TRTCFakeScreenCaptureSource());
  }
  
  public static TRTCClientIPCModule a()
  {
    return TRTCClientIPCModule.InstanceHolder.a;
  }
  
  private void a(Bundle paramBundle)
  {
    Object localObject = this.b;
    if (localObject != null) {
      localObject = (Context)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    if ((paramBundle != null) && (localObject != null))
    {
      paramBundle.setClassLoader(ConfigData.class.getClassLoader());
      paramBundle = (ConfigData)paramBundle.getParcelable("key_trtc_config_data");
      TRTCEngineProxy.a().a((Context)localObject, paramBundle, new TRTCClientIPCModule.2(this));
    }
  }
  
  public static void a(String paramString, Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("call server ");
      paramBundle.append(paramString);
      QLog.d("TRTCClientIPCModule", 2, paramBundle.toString());
    }
    QIPCClientHelper.getInstance().getClient().callServer("QQLiveServerIPCModule", paramString, localBundle, null);
  }
  
  private boolean b(String paramString, Bundle paramBundle)
  {
    if ("Action_Client_Init_SDK".equals(paramString))
    {
      a(paramBundle);
    }
    else
    {
      if (!"Action_Client_Destroy_SDK".equals(paramString)) {
        break label34;
      }
      TRTCEngineProxy.a().b();
    }
    return true;
    label34:
    return false;
  }
  
  private void c()
  {
    if (this.c.a()) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("qq innerInit live connect, [");
    ((StringBuilder)localObject).append(this.c.a.get());
    ((StringBuilder)localObject).append("]");
    QLog.d("TRTCClientIPCModule", 1, ((StringBuilder)localObject).toString());
    try
    {
      localObject = QIPCClientHelper.getInstance();
      EIPCClient localEIPCClient = ((QIPCClientHelper)localObject).getClient();
      localEIPCClient.unRegisterModule(this);
      ((QIPCClientHelper)localObject).register(this);
      localEIPCClient.addListener(this.c);
      localEIPCClient.connect(this.c);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("TRTCClientIPCModule", 1, "LiteLiveSDKClientIPCModule create error", localThrowable);
    }
  }
  
  private void c(String paramString, Bundle paramBundle)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      ITRTCIPCHandler localITRTCIPCHandler = (ITRTCIPCHandler)localIterator.next();
      if (localITRTCIPCHandler.a(paramString, paramBundle)) {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("handle ");
          paramString.append(localITRTCIPCHandler.toString());
          QLog.d("TRTCClientIPCModule", 2, paramString.toString());
        }
      }
    }
  }
  
  public void a(Context paramContext)
  {
    this.c = new TRTCClientIPCModule.IPCConnectListenerImpl(this, null);
    this.b = new WeakReference(paramContext.getApplicationContext());
    c();
  }
  
  public void b()
  {
    this.a.clear();
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("TRTCClientIPCModule", 1, "onCall action is empty!");
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("======onCall=====action = ");
    localStringBuilder.append(paramString);
    QLog.i("TRTCClientIPCModule", 1, localStringBuilder.toString());
    ThreadManager.getUIHandler().post(new TRTCClientIPCModule.1(this, paramString, paramBundle));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.trtc.ipc.TRTCClientIPCModule
 * JD-Core Version:    0.7.0.1
 */