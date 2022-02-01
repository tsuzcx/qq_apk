package com.tencent.mobileqq.flutter.vistaimage;

import android.net.Uri;
import android.text.TextUtils;
import com.qflutter.vistaimage.IVistaImage;
import com.qflutter.vistaimage.IVistaImage.LoadBitmapCallback;
import com.tencent.mobileqq.qcircle.api.IQCircleClassApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VistaImageProxy
  implements IVistaImage
{
  private Map<String, IVistaImage> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  
  private VistaImageProxy()
  {
    this.jdField_a_of_type_JavaUtilMap.put("qcircle", ((IQCircleClassApi)QRoute.api(IQCircleClassApi.class)).getQCircleVistaImageInstance());
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
  
  public void clear()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((IVistaImage)localIterator.next()).clear();
    }
  }
  
  public void loadBitmap(String paramString, int paramInt1, int paramInt2, int paramInt3, IVistaImage.LoadBitmapCallback paramLoadBitmapCallback)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[loadBitmap] uri=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", requiredWidth=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", requiredHeight=");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("VistaImageImpl", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = a(paramString);
    if ((!jdField_a_of_type_Boolean) && (localObject == null)) {
      throw new AssertionError();
    }
    ((IVistaImage)localObject).loadBitmap(paramString, paramInt1, paramInt2, paramInt3, paramLoadBitmapCallback);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.vistaimage.VistaImageProxy
 * JD-Core Version:    0.7.0.1
 */