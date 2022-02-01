package com.tencent.mobileqq.flutter.vistaimage;

import android.net.Uri;
import android.text.TextUtils;
import com.qflutter.tencent_vista_image.IVistaImage;
import com.qflutter.tencent_vista_image.IVistaImage.LoadBitmapCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VistaImageProxy
  implements IVistaImage
{
  private Map<String, IVistaImage> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  
  static
  {
    if (!VistaImageProxy.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  private VistaImageProxy()
  {
    this.jdField_a_of_type_JavaUtilMap.put("qcircle", QCircleSchemeHandler.getInstance());
  }
  
  private IVistaImage a(String paramString)
  {
    Uri localUri = Uri.parse(paramString);
    paramString = localUri.getScheme();
    if ((TextUtils.isEmpty(paramString)) || ("http".equals(paramString)) || ("https".equals(paramString)) || ("wezone".equals(localUri.getHost()))) {
      paramString = "qcircle";
    }
    return (IVistaImage)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public static VistaImageProxy a()
  {
    return VistaImageProxy.SingleHolder.a;
  }
  
  public void loadBitmap(String paramString, int paramInt1, int paramInt2, int paramInt3, IVistaImage.LoadBitmapCallback paramLoadBitmapCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VistaImageImpl", 2, "[loadBitmap] uri=" + paramString + ", requiredWidth=" + paramInt1 + ", requiredHeight=" + paramInt2);
    }
    IVistaImage localIVistaImage = a(paramString);
    if ((!jdField_a_of_type_Boolean) && (localIVistaImage == null)) {
      throw new AssertionError();
    }
    localIVistaImage.loadBitmap(paramString, paramInt1, paramInt2, paramInt3, paramLoadBitmapCallback);
  }
  
  public void releaseBitmap(String paramString)
  {
    IVistaImage localIVistaImage = a(paramString);
    if ((!jdField_a_of_type_Boolean) && (localIVistaImage == null)) {
      throw new AssertionError();
    }
    localIVistaImage.releaseBitmap(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.vistaimage.VistaImageProxy
 * JD-Core Version:    0.7.0.1
 */