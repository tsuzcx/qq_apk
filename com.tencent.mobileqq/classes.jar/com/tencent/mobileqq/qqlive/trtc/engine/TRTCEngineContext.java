package com.tencent.mobileqq.qqlive.trtc.engine;

import android.content.Context;
import com.tencent.mobileqq.qqlive.data.config.ConfigData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trtc.TRTCCloud;
import mqq.util.WeakReference;

public class TRTCEngineContext
{
  public TRTCCloud a;
  public WeakReference<Context> b;
  public ConfigData c;
  
  public Context a()
  {
    WeakReference localWeakReference = this.b;
    if (localWeakReference != null) {
      return (Context)localWeakReference.get();
    }
    return null;
  }
  
  public void b()
  {
    QLog.d("TRTCEngineContext", 1, "destroy TRTCEngineContext");
    this.a = null;
    this.b = null;
    this.c = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.trtc.engine.TRTCEngineContext
 * JD-Core Version:    0.7.0.1
 */