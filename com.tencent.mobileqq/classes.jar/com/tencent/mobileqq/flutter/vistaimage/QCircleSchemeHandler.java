package com.tencent.mobileqq.flutter.vistaimage;

import com.qflutter.tencent_vista_image.IVistaImage;
import com.qflutter.tencent_vista_image.IVistaImage.LoadBitmapCallback;
import com.tencent.qphone.base.util.QLog;

public class QCircleSchemeHandler
  implements IVistaImage
{
  public static final String TAG = "QCircleSchemeHandler";
  private IVistaImage impl;
  
  public static QCircleSchemeHandler getInstance()
  {
    return QCircleSchemeHandler.SingleHolder.a;
  }
  
  public void attachImpl(IVistaImage paramIVistaImage)
  {
    this.impl = paramIVistaImage;
  }
  
  public void loadBitmap(String paramString, int paramInt1, int paramInt2, int paramInt3, IVistaImage.LoadBitmapCallback paramLoadBitmapCallback)
  {
    if (this.impl != null) {
      this.impl.loadBitmap(paramString, paramInt1, paramInt2, paramInt3, paramLoadBitmapCallback);
    }
    do
    {
      return;
      QLog.e("QCircleSchemeHandler", 1, "no VistaImage implementation attached");
    } while (paramLoadBitmapCallback == null);
    paramLoadBitmapCallback.onFailed(paramString, -1, "no VistaImage implementation attached");
  }
  
  public void releaseBitmap(String paramString)
  {
    if (this.impl != null) {
      this.impl.releaseBitmap(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.vistaimage.QCircleSchemeHandler
 * JD-Core Version:    0.7.0.1
 */