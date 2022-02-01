package com.tencent.tav.decoder.factory;

import android.support.annotation.Nullable;
import com.tencent.tav.decoder.IAudioDecoder;
import com.tencent.tav.decoder.IVideoDecoder;
import com.tencent.tav.decoder.IVideoDecoder.Params;

public abstract interface IDecoderFactory
{
  @Nullable
  public abstract IAudioDecoder createAudioDecoder(IVideoDecoder.Params paramParams);
  
  @Nullable
  public abstract IVideoDecoder createVideoDecoder(IVideoDecoder.Params paramParams);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.decoder.factory.IDecoderFactory
 * JD-Core Version:    0.7.0.1
 */