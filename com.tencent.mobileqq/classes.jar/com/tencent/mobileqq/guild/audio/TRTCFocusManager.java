package com.tencent.mobileqq.guild.audio;

import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.guild.api.IGuildTRTCFocusApi.TRTCFocusListener;
import com.tencent.mobileqq.guild.api.IGuildTRTCFocusApi.TRTCRequestFocusCallback;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class TRTCFocusManager
{
  private static TRTCFocusManager a;
  private volatile int b = 0;
  private volatile WeakReference<IGuildTRTCFocusApi.TRTCFocusListener> c;
  private volatile IGuildTRTCFocusApi.TRTCFocusListener d;
  private volatile IGuildTRTCFocusApi.TRTCRequestFocusCallback e;
  private volatile Handler f;
  private Runnable g = new TRTCFocusManager.1(this);
  
  public static TRTCFocusManager a()
  {
    try
    {
      if (a == null) {
        a = new TRTCFocusManager();
      }
      TRTCFocusManager localTRTCFocusManager = a;
      return localTRTCFocusManager;
    }
    finally {}
  }
  
  private void a(@NonNull IGuildTRTCFocusApi.TRTCRequestFocusCallback paramTRTCRequestFocusCallback, @Nullable Handler paramHandler)
  {
    paramTRTCRequestFocusCallback = new TRTCFocusManager.2(this, paramTRTCRequestFocusCallback);
    if (paramHandler != null)
    {
      paramHandler.post(paramTRTCRequestFocusCallback);
      return;
    }
    ThreadManager.getSubThreadHandler().post(paramTRTCRequestFocusCallback);
  }
  
  public void a(@NonNull IGuildTRTCFocusApi.TRTCFocusListener paramTRTCFocusListener)
  {
    if ((this.c != null) && (this.c.get() == paramTRTCFocusListener))
    {
      if (this.b == 1)
      {
        a(this.e, this.f);
        return;
      }
      if (this.b == 2)
      {
        this.c = null;
        this.b = 0;
        return;
      }
      paramTRTCFocusListener = new StringBuilder();
      paramTRTCFocusListener.append("illegal onReleaseTRTCFocus,curState is ");
      paramTRTCFocusListener.append(this.b);
      QLog.d("TRTCFocusManager", 1, paramTRTCFocusListener.toString());
      return;
    }
    QLog.d("TRTCFocusManager", 1, "illegal onReleaseTRTCFocus,focusListener not match");
  }
  
  public void a(@NonNull IGuildTRTCFocusApi.TRTCFocusListener paramTRTCFocusListener, @NonNull IGuildTRTCFocusApi.TRTCRequestFocusCallback paramTRTCRequestFocusCallback, @Nullable Handler paramHandler)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start requestTRTCFocus,focusListener:");
      localStringBuilder.append(paramTRTCFocusListener);
      QLog.d("TRTCFocusManager", 2, localStringBuilder.toString());
    }
    if (this.b == 0)
    {
      this.b = 1;
      this.d = paramTRTCFocusListener;
      this.e = paramTRTCRequestFocusCallback;
      a(paramTRTCRequestFocusCallback, paramHandler);
      return;
    }
    if (this.b == 1)
    {
      ThreadManager.getSubThreadHandler().removeCallbacks(this.g);
      if (this.e != null) {
        this.e.a(false);
      }
    }
    this.b = 1;
    this.d = paramTRTCFocusListener;
    this.e = paramTRTCRequestFocusCallback;
    if (this.c != null)
    {
      paramTRTCFocusListener = (IGuildTRTCFocusApi.TRTCFocusListener)this.c.get();
      if (paramTRTCFocusListener == null)
      {
        a(paramTRTCRequestFocusCallback, paramHandler);
        return;
      }
      this.f = paramHandler;
      paramTRTCFocusListener.a();
      ThreadManager.getSubThreadHandler().postDelayed(this.g, 3000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.TRTCFocusManager
 * JD-Core Version:    0.7.0.1
 */