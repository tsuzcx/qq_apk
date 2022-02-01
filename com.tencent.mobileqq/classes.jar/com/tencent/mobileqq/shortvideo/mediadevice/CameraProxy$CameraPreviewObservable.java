package com.tencent.mobileqq.shortvideo.mediadevice;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.shortvideo.common.Observable;

public class CameraProxy$CameraPreviewObservable
  extends Observable
{
  public Handler b;
  
  public CameraProxy$CameraPreviewObservable(Handler paramHandler)
  {
    if (paramHandler != null)
    {
      this.b = paramHandler;
      return;
    }
    this.b = new Handler(Looper.getMainLooper());
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    Handler localHandler = this.b;
    if (localHandler == null) {
      return;
    }
    localHandler.post(new CameraProxy.CameraPreviewObservable.1(this, paramInt, paramVarArgs));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.CameraPreviewObservable
 * JD-Core Version:    0.7.0.1
 */