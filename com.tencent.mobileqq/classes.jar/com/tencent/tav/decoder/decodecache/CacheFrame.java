package com.tencent.tav.decoder.decodecache;

import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.ITexturePool;

class CacheFrame
{
  public CMTime frameTime = CMTime.CMTimeInvalid;
  public CMTime realFrameTime = CMTime.CMTimeInvalid;
  public CMSampleBuffer sampleBuffer = null;
  public ITexturePool texturePool;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.decoder.decodecache.CacheFrame
 * JD-Core Version:    0.7.0.1
 */