package com.tencent.qqcamerakit.capture;

import android.os.Handler;
import android.os.Looper;
import com.tencent.qqcamerakit.common.Observable;

public class CameraObservable
  extends Observable
{
  public Handler a;
  
  public CameraObservable(Handler paramHandler)
  {
    if (paramHandler != null)
    {
      this.a = paramHandler;
      return;
    }
    this.a = new Handler(Looper.getMainLooper());
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Object... paramVarArgs)
  {
    Handler localHandler = this.a;
    if (localHandler != null) {
      localHandler.post(new CameraObservable.1(this, paramInt1, paramInt2, paramString, paramVarArgs));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqcamerakit.capture.CameraObservable
 * JD-Core Version:    0.7.0.1
 */