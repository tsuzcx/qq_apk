package com.tencent.mobileqq.qqlive.trtc.render;

import android.content.Context;
import android.os.Looper;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqlive.trtc.engine.TRTCEngineContext;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rtmp.ui.TXCloudVideoView;
import mqq.os.MqqHandler;

public class TRTCRenderCtrl
  implements ILocalRender
{
  private final TRTCEngineContext a;
  private TXCloudVideoView b;
  private java.lang.ref.WeakReference<ViewGroup> c;
  
  public TRTCRenderCtrl(TRTCEngineContext paramTRTCEngineContext)
  {
    this.a = paramTRTCEngineContext;
  }
  
  private boolean b(java.lang.ref.WeakReference<ViewGroup> paramWeakReference)
  {
    return (paramWeakReference != null) && (paramWeakReference.get() != null);
  }
  
  private void c()
  {
    Context localContext = (Context)this.a.b.get();
    if (localContext == null) {
      QLog.e("TRTCRenderCtrl", 1, "getTRTCPreview failed!");
    }
    if (this.b == null)
    {
      this.b = new TXCloudVideoView(localContext);
      this.b.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }
  }
  
  private void c(java.lang.ref.WeakReference<ViewGroup> paramWeakReference)
  {
    if (this.b == null) {
      c();
    }
    java.lang.ref.WeakReference localWeakReference = this.c;
    if (localWeakReference != null) {
      ((ViewGroup)localWeakReference.get()).removeView(this.b);
    }
    this.c = paramWeakReference;
    paramWeakReference = this.c;
    if (paramWeakReference != null)
    {
      paramWeakReference = (ViewGroup)paramWeakReference.get();
      if (paramWeakReference != null) {
        paramWeakReference.addView(this.b);
      }
    }
  }
  
  private boolean d()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }
  
  public void a()
  {
    if ((b(this.c)) && (this.b != null))
    {
      ((ViewGroup)this.c.get()).removeView(this.b);
      this.b = null;
      this.c = null;
    }
  }
  
  public void a(java.lang.ref.WeakReference<ViewGroup> paramWeakReference)
  {
    if ((this.c == null) && (paramWeakReference == null)) {
      return;
    }
    if ((b(paramWeakReference)) && (b(this.c)) && (((ViewGroup)paramWeakReference.get()).equals(this.c.get()))) {
      return;
    }
    if (d())
    {
      c(paramWeakReference);
      return;
    }
    ThreadManager.getUIHandler().post(new TRTCRenderCtrl.1(this, paramWeakReference));
  }
  
  public TXCloudVideoView b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.trtc.render.TRTCRenderCtrl
 * JD-Core Version:    0.7.0.1
 */