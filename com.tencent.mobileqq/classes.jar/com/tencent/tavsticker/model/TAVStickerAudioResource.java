package com.tencent.tavsticker.model;

import com.tencent.tav.coremedia.CMTime;
import java.nio.ByteBuffer;

public class TAVStickerAudioResource
  extends TAVStickerResource
{
  private CMTime audioStartTime = CMTime.CMTimeZero;
  
  public TAVStickerAudioResource(TAVResourceType paramTAVResourceType, String paramString, ByteBuffer paramByteBuffer, CMTime paramCMTime)
  {
    super(paramTAVResourceType, paramString, paramByteBuffer);
    this.audioStartTime = paramCMTime;
  }
  
  public CMTime getAudioStartTime()
  {
    return this.audioStartTime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavsticker.model.TAVStickerAudioResource
 * JD-Core Version:    0.7.0.1
 */