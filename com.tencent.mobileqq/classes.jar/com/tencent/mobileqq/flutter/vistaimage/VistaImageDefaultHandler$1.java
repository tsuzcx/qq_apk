package com.tencent.mobileqq.flutter.vistaimage;

import com.qflutter.vistaimage.IVistaImage.LoadBitmapCallback;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class VistaImageDefaultHandler$1
  implements URLDrawable.URLDrawableListener
{
  VistaImageDefaultHandler$1(VistaImageDefaultHandler paramVistaImageDefaultHandler, IVistaImage.LoadBitmapCallback paramLoadBitmapCallback, String paramString) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = new StringBuilder();
    paramURLDrawable.append("[onLoadFailed] URLDrawable load http canceled, ");
    paramURLDrawable.append(this.b);
    QLog.w("VistaImageDefaultHandler", 1, paramURLDrawable.toString());
    paramURLDrawable = this.a;
    if (paramURLDrawable != null) {
      paramURLDrawable.onFailed(this.b, -2, "URLDrawable load canceled");
    }
    VistaImageDefaultHandler.a(this.c).remove(this.b);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    paramURLDrawable = new StringBuilder();
    paramURLDrawable.append("[onLoadFailed] URLDrawable load http failed, ");
    paramURLDrawable.append(this.b);
    QLog.w("VistaImageDefaultHandler", 1, paramURLDrawable.toString(), paramThrowable);
    paramURLDrawable = this.a;
    if (paramURLDrawable != null) {
      paramURLDrawable.onFailed(this.b, -1, "URLDrawable load failed");
    }
    VistaImageDefaultHandler.a(this.c).remove(this.b);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    IVistaImage.LoadBitmapCallback localLoadBitmapCallback = this.a;
    if (localLoadBitmapCallback != null) {
      localLoadBitmapCallback.onLoaded(this.b, paramURLDrawable, false, null);
    }
    VistaImageDefaultHandler.a(this.c).remove(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.vistaimage.VistaImageDefaultHandler.1
 * JD-Core Version:    0.7.0.1
 */