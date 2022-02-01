package com.tencent.youtu.sdkkitframework.common;

import android.media.MediaCodec.BufferInfo;
import java.nio.ByteBuffer;

class YtVideoEncoder$MediaData
{
  MediaCodec.BufferInfo bufferInfo;
  ByteBuffer byteBuffer;
  int index = 0;
  int trackIndex;
  
  public YtVideoEncoder$MediaData(YtVideoEncoder paramYtVideoEncoder, int paramInt1, int paramInt2, ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    this.index = paramInt1;
    this.trackIndex = paramInt2;
    this.byteBuffer = paramByteBuffer;
    this.bufferInfo = paramBufferInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.common.YtVideoEncoder.MediaData
 * JD-Core Version:    0.7.0.1
 */