package com.tencent.mobileqq.util;

import android.animation.AnimatorSet;
import android.graphics.Bitmap;
import com.tencent.mobileqq.ocr.view.TDProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.concurrent.atomic.AtomicBoolean;

final class ScreenShotUtil$6
  implements ScreenShotUtil.ScreenLongShotCallback<T>
{
  ScreenShotUtil$6(AtomicBoolean paramAtomicBoolean, TDProgressDialog paramTDProgressDialog, ScreenShotUtil.ScreenLongShotCallback paramScreenLongShotCallback, WebView paramWebView, AnimatorSet paramAnimatorSet) {}
  
  public T a(Bitmap paramBitmap)
  {
    if (this.a.get())
    {
      QLog.e("ScreenShotUtil", 1, "onScreenshotFinish isCanceled");
      this.b.dismiss();
      return null;
    }
    if (paramBitmap == null)
    {
      QLog.e("ScreenShotUtil", 1, "onScreenshotFinish bitmap is null");
      this.b.dismiss();
      return null;
    }
    return this.c.a(paramBitmap);
  }
  
  public void a(Exception paramException)
  {
    this.c.a(paramException);
    this.b.dismiss();
  }
  
  public void a(T paramT, Bitmap paramBitmap)
  {
    if (this.a.get())
    {
      QLog.e("ScreenShotUtil", 1, "postBitmap isCanceled");
      this.b.dismiss();
      return;
    }
    if (paramT == null)
    {
      QLog.e("ScreenShotUtil", 1, "postBitmap t is null");
      this.b.dismiss();
      return;
    }
    if (paramBitmap == null)
    {
      QLog.e("ScreenShotUtil", 1, "postBitmap bitmap is null");
      this.b.dismiss();
      this.c.a(new NullPointerException("postBitmap bitmap is null"));
      return;
    }
    if ((this.d.getContext() != null) && (this.b.isShowing()))
    {
      if (this.e.isRunning()) {
        this.e.end();
      }
      this.b.dismiss();
    }
    this.c.a(paramT, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.ScreenShotUtil.6
 * JD-Core Version:    0.7.0.1
 */