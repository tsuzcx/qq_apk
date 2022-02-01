package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerLayerInfo.TAVStickerUserData;
import com.tencent.tavsticker.utils.FileIoUtils;
import java.nio.ByteBuffer;
import java.util.List;

class PagAudioItem
{
  private final String a;
  private final CMTime b;
  private final List<TAVStickerLayerInfo.TAVStickerUserData> c;
  
  PagAudioItem(String paramString, CMTime paramCMTime, List<TAVStickerLayerInfo.TAVStickerUserData> paramList)
  {
    this.a = paramString;
    this.b = paramCMTime;
    this.c = paramList;
  }
  
  static PagAudioItem a(TAVSticker paramTAVSticker, IMiniAppFileManager paramIMiniAppFileManager)
  {
    List localList = paramTAVSticker.getAudioUserDatas();
    long l = (paramTAVSticker.getAudioStartTime() * 1000.0F * 1000.0F);
    return new PagAudioItem(paramIMiniAppFileManager.getWxFilePath(a(paramTAVSticker.getAudioData(), paramIMiniAppFileManager.getTmpPath(".pcm"))), CMTime.fromUs(l), localList);
  }
  
  private static String a(ByteBuffer paramByteBuffer, String paramString)
  {
    int j = paramByteBuffer.capacity();
    if (j <= 0) {
      return "";
    }
    int i = 0;
    paramByteBuffer.position(0);
    while (i < j)
    {
      i = j - i;
      byte[] arrayOfByte;
      if (i > 8192) {
        arrayOfByte = new byte[8192];
      } else {
        arrayOfByte = new byte[i];
      }
      paramByteBuffer.get(arrayOfByte);
      i = paramByteBuffer.position();
      FileIoUtils.writeFileFromBytesByStream(paramString, arrayOfByte, true);
    }
    return paramString;
  }
  
  String a()
  {
    return this.a;
  }
  
  CMTime b()
  {
    return this.b;
  }
  
  List<TAVStickerLayerInfo.TAVStickerUserData> c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.PagAudioItem
 * JD-Core Version:    0.7.0.1
 */