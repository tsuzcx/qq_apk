package com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl;

import com.tencent.mobileqq.kandian.base.image.ImageRequest;
import com.tencent.mobileqq.kandian.base.image.RIJImageTypeOptHelper;
import com.tencent.mobileqq.kandian.base.image.api.IImageManager;
import com.tencent.mobileqq.kandian.base.image.imageloader.RIJImageOptReport;
import com.tencent.mobileqq.kandian.biz.common.FluencyOptUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.tkd.comment.publisher.qq.bridge.QQUrlImageBridge;
import com.tencent.tkd.comment.publisher.qq.bridge.QQUrlImageBridge.Callback;
import java.net.MalformedURLException;
import java.net.URL;

public class QQUrlImageBridgeImpl
  implements QQUrlImageBridge
{
  public void loadUrlImage(String paramString, int paramInt1, int paramInt2, QQUrlImageBridge.Callback paramCallback)
  {
    try
    {
      URL localURL2 = FluencyOptUtils.a.a(paramString);
      URL localURL1 = localURL2;
      if (localURL2 == null)
      {
        localURL1 = new URL(paramString);
        FluencyOptUtils.a.a(localURL1);
      }
      paramString = new ImageRequest();
      RIJImageTypeOptHelper.a.a(paramString, localURL1.toString());
      paramString.a = paramInt1;
      paramString.b = paramInt2;
      RIJImageOptReport.a(1, paramString);
      ((IImageManager)QRoute.api(IImageManager.class)).loadImage(paramString, new QQUrlImageBridgeImpl.1(this, paramCallback));
      return;
    }
    catch (MalformedURLException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl.QQUrlImageBridgeImpl
 * JD-Core Version:    0.7.0.1
 */