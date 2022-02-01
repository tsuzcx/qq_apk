package com.tencent.mobileqq.richmedia.mediacodec.encoder;

import android.media.MediaFormat;

public abstract interface MuxerDataListener
{
  public abstract void a();
  
  public abstract void a(MediaFormat paramMediaFormat);
  
  public abstract void a(HWVideoEncoder.MuxerData paramMuxerData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.encoder.MuxerDataListener
 * JD-Core Version:    0.7.0.1
 */