package com.tencent.mobileqq.qqlive.trtc.video.source.screen;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveScreenCaptureParams;
import com.tencent.mobileqq.qqlive.data.trtc.TRTCVideoQualityParams;
import com.tencent.mobileqq.qqlive.trtc.utils.TRTCConvertHelper;
import com.tencent.mobileqq.qqlive.trtc.utils.TRTCThreadHelper;
import com.tencent.mobileqq.qqlive.trtc.video.source.TRTCVideoBaseSourceImpl;
import com.tencent.mobileqq.qqlive.utils.VideoQualityUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trtc.TRTCCloud;
import mqq.util.WeakReference;

public class TRTCScreenCaptureSource
  extends TRTCVideoBaseSourceImpl
  implements ITRTCInnerCaptureEventListener, ITRTCScreenCaptureSource
{
  private QQLiveScreenCaptureParams f;
  private IRTCScreenCaptureEventListener g = null;
  
  public void a()
  {
    QLog.i("TRTCScreenCaptureSource", 1, "onScreenCaptureStarted.");
    IRTCScreenCaptureEventListener localIRTCScreenCaptureEventListener = this.g;
    if (localIRTCScreenCaptureEventListener == null)
    {
      QLog.i("TRTCScreenCaptureSource", 1, "onScreenCaptureStarted: listener==null. [Miss]");
      return;
    }
    TRTCThreadHelper.a(this.d, new TRTCScreenCaptureSource.2(this, localIRTCScreenCaptureEventListener));
  }
  
  public void a(int paramInt)
  {
    QLog.i("TRTCScreenCaptureSource", 1, "onScreenCapturePaused.");
    IRTCScreenCaptureEventListener localIRTCScreenCaptureEventListener = this.g;
    if (localIRTCScreenCaptureEventListener == null)
    {
      QLog.i("TRTCScreenCaptureSource", 1, "onScreenCapturePaused: listener==null. [Miss]");
      return;
    }
    TRTCThreadHelper.a(this.d, new TRTCScreenCaptureSource.3(this, localIRTCScreenCaptureEventListener, paramInt));
  }
  
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onScreenCaptureError: code ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", msg ");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("TRTCScreenCaptureSource", 1, ((StringBuilder)localObject).toString());
    localObject = this.g;
    if (localObject == null)
    {
      QLog.i("TRTCScreenCaptureSource", 1, "onScreenCaptureError: listener==null. [Miss]");
      return;
    }
    TRTCThreadHelper.a(this.d, new TRTCScreenCaptureSource.1(this, (IRTCScreenCaptureEventListener)localObject, paramInt, paramString, paramBundle));
  }
  
  public void a(TRTCVideoQualityParams paramTRTCVideoQualityParams, QQLiveScreenCaptureParams paramQQLiveScreenCaptureParams)
  {
    di_();
    TRTCVideoQualityParams localTRTCVideoQualityParams = paramTRTCVideoQualityParams;
    if (paramTRTCVideoQualityParams == null) {
      localTRTCVideoQualityParams = this.e;
    }
    this.e = localTRTCVideoQualityParams;
    this.f = paramQQLiveScreenCaptureParams;
    paramTRTCVideoQualityParams = (Context)this.c.get();
    if ((this.e == null) && (paramTRTCVideoQualityParams != null)) {
      this.e = VideoQualityUtils.b(paramTRTCVideoQualityParams, true, true);
    }
    QLog.i("TRTCScreenCaptureSource", 1, "startScreenCapture.");
    paramTRTCVideoQualityParams = TRTCConvertHelper.a(this.e);
    paramQQLiveScreenCaptureParams = TRTCConvertHelper.a(this.f);
    this.b.startScreenCapture(paramTRTCVideoQualityParams, paramQQLiveScreenCaptureParams);
  }
  
  public void a(IRTCScreenCaptureEventListener paramIRTCScreenCaptureEventListener)
  {
    this.g = paramIRTCScreenCaptureEventListener;
  }
  
  public void b(int paramInt)
  {
    QLog.i("TRTCScreenCaptureSource", 1, "onScreenCaptureResumed.");
    IRTCScreenCaptureEventListener localIRTCScreenCaptureEventListener = this.g;
    if (localIRTCScreenCaptureEventListener == null)
    {
      QLog.i("TRTCScreenCaptureSource", 1, "onScreenCaptureResumed: listener==null. [Miss]");
      return;
    }
    TRTCThreadHelper.a(this.d, new TRTCScreenCaptureSource.4(this, localIRTCScreenCaptureEventListener, paramInt));
  }
  
  public void c(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onScreenCaptureStopped: ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.i("TRTCScreenCaptureSource", 1, ((StringBuilder)localObject).toString());
    localObject = this.g;
    if (localObject == null)
    {
      QLog.i("TRTCScreenCaptureSource", 1, "onScreenCaptureStopped: listener==null. [Miss]");
      return;
    }
    TRTCThreadHelper.a(this.d, new TRTCScreenCaptureSource.5(this, (IRTCScreenCaptureEventListener)localObject, paramInt));
  }
  
  public void e()
  {
    try
    {
      di_();
      super.e();
      this.g = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void f()
  {
    this.b.stopScreenCapture();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.trtc.video.source.screen.TRTCScreenCaptureSource
 * JD-Core Version:    0.7.0.1
 */