package com.tencent.mobileqq.shortvideo.mediadevice;

import aihc;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.shortvideo.common.Observable;

public class CameraProxy$CameraPreviewObservable
  extends Observable
{
  public Handler a;
  
  public CameraProxy$CameraPreviewObservable(Handler paramHandler)
  {
    if (paramHandler != null)
    {
      this.a = paramHandler;
      return;
    }
    this.a = new Handler(Looper.getMainLooper());
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (this.a == null) {
      return;
    }
    this.a.post(new aihc(this, paramInt, paramVarArgs));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.CameraPreviewObservable
 * JD-Core Version:    0.7.0.1
 */