package com.tencent.mobileqq.intervideo.yiqikan;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class WatchTogetherClientIPCModule
  extends QIPCModule
{
  private static volatile WatchTogetherClientIPCModule a;
  private Handler b = new Handler(Looper.getMainLooper());
  
  public WatchTogetherClientIPCModule(String paramString)
  {
    super(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("WatchTogetherClientIPCModule", 2, "WatchTogetherClientIPCModule register");
    }
  }
  
  public static WatchTogetherClientIPCModule a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new WatchTogetherClientIPCModule("WatchTogetherClientIPCModule");
        }
      }
      finally {}
    }
    return a;
  }
  
  private boolean b()
  {
    return Thread.currentThread() == Looper.getMainLooper().getThread();
  }
  
  public void a(String paramString, WatchTogetherFloatingData paramWatchTogetherFloatingData)
  {
    if (b())
    {
      if ("ACTION_SHOW_WATCH_FLOATING_WINDOWS".equalsIgnoreCase(paramString))
      {
        WatchFloatingWindowController.c().a(BaseApplicationImpl.getContext(), paramWatchTogetherFloatingData);
        return;
      }
      if ("ACTION_QUIT_WATCH_FLOATING_WINDOWS".equalsIgnoreCase(paramString))
      {
        WatchFloatingWindowController.c().a(paramWatchTogetherFloatingData.getCurUin(), paramWatchTogetherFloatingData.getCurType(), true);
        return;
      }
      if ("ACTION_CLOSE_OR_QUIT_WATCH_FLOATING_WINDOWS".equals(paramString)) {
        WatchFloatingWindowController.c().b();
      }
    }
    else
    {
      this.b.post(new WatchTogetherClientIPCModule.1(this, paramString, paramWatchTogetherFloatingData));
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("call TogetherBusinessIPCModule action=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("WatchTogetherClientIPCModule", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new EIPCResult();
    if ("ACTION_SHOW_WATCH_FLOATING_WINDOWS".equalsIgnoreCase(paramString))
    {
      if (paramBundle != null)
      {
        paramBundle = (WatchTogetherFloatingData)paramBundle.getSerializable("BUNDLE_KEY_UI_DATA");
        if (paramBundle != null)
        {
          a(paramString, paramBundle);
          ((EIPCResult)localObject).code = 0;
        }
        else
        {
          ((EIPCResult)localObject).code = -102;
        }
      }
      else
      {
        ((EIPCResult)localObject).code = -102;
      }
    }
    else if ("ACTION_QUIT_WATCH_FLOATING_WINDOWS".equalsIgnoreCase(paramString))
    {
      if (paramBundle != null)
      {
        paramBundle = (WatchTogetherFloatingData)paramBundle.getSerializable("BUNDLE_KEY_UI_DATA");
        if (paramBundle != null)
        {
          a(paramString, paramBundle);
          ((EIPCResult)localObject).code = 0;
        }
        else
        {
          ((EIPCResult)localObject).code = -102;
        }
      }
      else
      {
        ((EIPCResult)localObject).code = -102;
      }
    }
    else if ("ACTION_CLOSE_OR_QUIT_WATCH_FLOATING_WINDOWS".equals(paramString))
    {
      a(paramString, new WatchTogetherFloatingData());
      ((EIPCResult)localObject).code = 0;
    }
    callbackResult(paramInt, (EIPCResult)localObject);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherClientIPCModule
 * JD-Core Version:    0.7.0.1
 */