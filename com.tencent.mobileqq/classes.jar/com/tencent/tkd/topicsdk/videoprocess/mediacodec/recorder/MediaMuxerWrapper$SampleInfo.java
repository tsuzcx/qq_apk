package com.tencent.tkd.topicsdk.videoprocess.mediacodec.recorder;

import android.media.MediaCodec.BufferInfo;

class MediaMuxerWrapper$SampleInfo
{
  private final int a;
  private final int b;
  private final long c;
  private final int d;
  
  private MediaMuxerWrapper$SampleInfo(int paramInt1, int paramInt2, MediaCodec.BufferInfo paramBufferInfo)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramBufferInfo.presentationTimeUs;
    this.d = paramBufferInfo.flags;
  }
  
  private void a(MediaCodec.BufferInfo paramBufferInfo, int paramInt)
  {
    paramBufferInfo.set(paramInt, this.b, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.mediacodec.recorder.MediaMuxerWrapper.SampleInfo
 * JD-Core Version:    0.7.0.1
 */