package com.tencent.mobileqq.flutter.vistaimage;

import android.graphics.drawable.Drawable;
import com.qflutter.vistaimage.IVistaImage.LoadBitmapCallback;
import com.tencent.qphone.base.util.QLog;
import rx.functions.Action1;

class VistaImageDefaultHandler$2
  implements Action1<Drawable>
{
  VistaImageDefaultHandler$2(VistaImageDefaultHandler paramVistaImageDefaultHandler, IVistaImage.LoadBitmapCallback paramLoadBitmapCallback, String paramString) {}
  
  public void a(Drawable paramDrawable)
  {
    IVistaImage.LoadBitmapCallback localLoadBitmapCallback = this.a;
    if (localLoadBitmapCallback == null)
    {
      QLog.w("VistaImageDefaultHandler", 1, "[onLoadDrawable] invalid callback");
      return;
    }
    if (paramDrawable != null)
    {
      localLoadBitmapCallback.onLoaded(this.b, paramDrawable, false, null);
      return;
    }
    localLoadBitmapCallback.onFailed(this.b, -3, "load drawable failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.vistaimage.VistaImageDefaultHandler.2
 * JD-Core Version:    0.7.0.1
 */