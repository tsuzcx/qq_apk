package com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl;

import com.tencent.mobileqq.kandian.base.image.ImageManager;
import com.tencent.mobileqq.kandian.base.image.ImageRequest;
import com.tencent.mobileqq.kandian.base.image.RIJImageTypeOptHelper;
import com.tencent.mobileqq.kandian.base.image.imageloader.RIJImageOptReport;
import com.tencent.mobileqq.kandian.biz.common.FluencyOptUtils;
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
      URL localURL2 = FluencyOptUtils.a.b(paramString);
      URL localURL1 = localURL2;
      if (localURL2 == null)
      {
        localURL1 = new URL(paramString);
        FluencyOptUtils.a.a(localURL1);
      }
      paramString = new ImageRequest();
      RIJImageTypeOptHelper.a.a(paramString, localURL1.toString());
      paramString.b = paramInt1;
      paramString.c = paramInt2;
      RIJImageOptReport.a(1, paramString);
      ImageManager.get().loadImage(paramString, new QQUrlImageBridgeImpl.1(this, paramCallback));
      return;
    }
    catch (MalformedURLException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl.QQUrlImageBridgeImpl
 * JD-Core Version:    0.7.0.1
 */