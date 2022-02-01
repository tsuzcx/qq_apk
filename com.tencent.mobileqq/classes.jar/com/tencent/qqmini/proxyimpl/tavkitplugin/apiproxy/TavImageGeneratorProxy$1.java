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
    TavImageGeneratorProxy.a(this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavImageGeneratorProxy, paramBitmap, this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginSendMsgTavEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavImageGeneratorProxy.1
 * JD-Core Version:    0.7.0.1
 */