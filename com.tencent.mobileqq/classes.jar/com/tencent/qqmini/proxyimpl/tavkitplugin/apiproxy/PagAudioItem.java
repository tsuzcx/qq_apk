package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerLayerInfo.TAVStickerUserData;
import com.tencent.tavsticker.utils.FileIoUtils;
import java.nio.ByteBuffer;
import java.util.List;

class PagAudioItem
{
  private final CMTime jdField_a_of_type_ComTencentTavCoremediaCMTime;
  private final String jdField_a_of_type_JavaLangString;
  private final List<TAVStickerLayerInfo.TAVStickerUserData> jdField_a_of_type_JavaUtilList;
  
  PagAudioItem(String paramString, CMTime paramCMTime, List<TAVStickerLayerInfo.TAVStickerUserData> paramList)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentTavCoremediaCMTime = paramCMTime;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  static PagAudioItem a(TAVSticker paramTAVSticker, MiniAppFileManager paramMiniAppFileManager)
  {
    List localList = paramTAVSticker.getAudioUserDatas();
    long l = (paramTAVSticker.getAudioStartTime() * 1000.0F * 1000.0F);
    return new PagAudioItem(paramMiniAppFileManager.getWxFilePath(a(paramTAVSticker.getAudioData(), paramMiniAppFileManager.getTmpPath(".pcm"))), CMTime.fromUs(l), localList);
  }
  
  private static String a(ByteBuffer paramByteBuffer, String paramString)
  {
    int j = paramByteBuffer.capacity();
    if (j <= 0) {
      localObject = "";
    }
    int i;
    do
    {
      return localObject;
      i = 0;
      paramByteBuffer.position(0);
      localObject = paramString;
    } while (i >= j);
    if (j - i > 8192) {}
    for (Object localObject = new byte[8192];; localObject = new byte[j - i])
    {
      paramByteBuffer.get((byte[])localObject);
      i = paramByteBuffer.position();
      FileIoUtils.writeFileFromBytesByStream(paramString, (byte[])localObject, true);
      break;
    }
  }
  
  CMTime a()
  {
    return this.jdField_a_of_type_ComTencentTavCoremediaCMTime;
  }
  
  String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  List<TAVStickerLayerInfo.TAVStickerUserData> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.PagAudioItem
 * JD-Core Version:    0.7.0.1
 */