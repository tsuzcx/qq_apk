package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qqmini.proxyimpl.tavkitplugin.SendMsgTavEvent;
import com.tencent.tav.coremedia.CMTime;

class TavImageGeneratorProxy$1
  implements TavImageGenerator.ImageGeneratorListener
{
  TavImageGeneratorProxy$1(TavImageGeneratorProxy paramTavImageGeneratorProxy, SendMsgTavEvent paramSendMsgTavEvent) {}
  
  public void a(@NonNull CMTime paramCMTime, @Nullable Bitmap paramBitmap)
  {
    TavImageGeneratorProxy.a(this.b, paramBitmap, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavImageGeneratorProxy.1
 * JD-Core Version:    0.7.0.1
 */