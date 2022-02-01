package com.tencent.tav.decoder.muxer;

import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.coremedia.CMSampleBuffer;

public abstract interface IVideoEncoder
{
  public abstract boolean prepare(ExportConfig paramExportConfig);
  
  public abstract void release();
  
  public abstract void setMediaMuxer(IMediaMuxer paramIMediaMuxer);
  
  public abstract boolean start();
  
  public abstract void stop();
  
  public abstract boolean writeSample(CMSampleBuffer paramCMSampleBuffer, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.decoder.muxer.IVideoEncoder
 * JD-Core Version:    0.7.0.1
 */