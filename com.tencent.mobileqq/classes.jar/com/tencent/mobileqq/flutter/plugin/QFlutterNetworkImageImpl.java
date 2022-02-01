package com.tencent.mobileqq.flutter.plugin;

import android.graphics.Bitmap;
import com.qflutter.qflutter_network_image.LoadBitmapCallback;
import com.qflutter.qflutter_network_image.QFlutterNetworkImageInterface;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class QFlutterNetworkImageImpl
  implements QFlutterNetworkImageInterface
{
  private static String a;
  private Map<String, Bitmap> b = new ConcurrentHashMap();
  
  public static void a(String paramString)
  {
    a = paramString;
  }
  
  public String getLibPath()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[getLibPath] libPath=");
    localStringBuilder.append(a);
    QLog.d("QFlutterNetworkImageImpl", 2, localStringBuilder.toString());
    return a;
  }
  
  public void loadBitmap(String paramString, int paramInt1, int paramInt2, LoadBitmapCallback paramLoadBitmapCallback)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[loadBitmap] url=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", decodeWidth=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", decodeHeight=");
      localStringBuilder.append(paramInt2);
      QLog.d("QFlutterNetworkImageImpl", 2, localStringBuilder.toString());
    }
    paramString = new Option().setUrl(paramString).setPredecode(true);
    if ((paramInt1 > 0) && (paramInt2 > 0)) {
      paramString.setRequestWidth(paramInt1).setRequestHeight(paramInt2);
    }
    QCircleFeedPicLoader.g().loadImage(paramString, new QFlutterNetworkImageImpl.1(this, paramLoadBitmapCallback));
  }
  
  public void releaseBitmap(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[releaseBitmap] url=");
      localStringBuilder.append(paramString);
      QLog.d("QFlutterNetworkImageImpl", 2, localStringBuilder.toString());
    }
    paramString = (Bitmap)this.b.remove(paramString);
    if ((paramString == null) || (paramString.isRecycled())) {
      QLog.w("QFlutterNetworkImageImpl", 1, "[releaseBitmap] bitmap is not supposed to be recycled or null, some problems occurred");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.plugin.QFlutterNetworkImageImpl
 * JD-Core Version:    0.7.0.1
 */