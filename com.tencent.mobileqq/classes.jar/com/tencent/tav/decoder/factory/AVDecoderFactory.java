package com.tencent.tav.decoder.factory;

import android.support.annotation.Nullable;
import com.tencent.tav.decoder.AudioDecoder;
import com.tencent.tav.decoder.IAudioDecoder;
import com.tencent.tav.decoder.IVideoDecoder;
import com.tencent.tav.decoder.IVideoDecoder.Params;
import com.tencent.tav.decoder.ImageDecoder;
import com.tencent.tav.decoder.VideoDecoder;

public class AVDecoderFactory
  implements IDecoderFactory
{
  private static IDecoderFactory instance = new AVDecoderFactory();
  
  public static IDecoderFactory getInstance()
  {
    return instance;
  }
  
  public static void setInstance(IDecoderFactory paramIDecoderFactory)
  {
    instance = paramIDecoderFactory;
  }
  
  @Nullable
  public IAudioDecoder createAudioDecoder(IVideoDecoder.Params paramParams)
  {
    if (paramParams.sourceType == 2) {
      return new AudioDecoder(paramParams);
    }
    return null;
  }
  
  @Nullable
  public IVideoDecoder createVideoDecoder(IVideoDecoder.Params paramParams)
  {
    if (paramParams.sourceType == 3) {
      return new ImageDecoder(paramParams);
    }
    if (paramParams.sourceType == 1) {
      return new VideoDecoder(paramParams);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.decoder.factory.AVDecoderFactory
 * JD-Core Version:    0.7.0.1
 */