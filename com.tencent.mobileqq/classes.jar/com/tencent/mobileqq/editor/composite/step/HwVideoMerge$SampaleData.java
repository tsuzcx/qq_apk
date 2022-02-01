package com.tencent.mobileqq.editor.composite.step;

import android.media.MediaCodec.BufferInfo;
import java.nio.ByteBuffer;

class HwVideoMerge$SampaleData
{
  public int audioTrack;
  public MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
  public ByteBuffer inputBuffer;
  public int videoTrack;
  
  public void init(int paramInt1, int paramInt2)
  {
    this.inputBuffer = ByteBuffer.allocate(paramInt1 * paramInt2 * 3 / 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.editor.composite.step.HwVideoMerge.SampaleData
 * JD-Core Version:    0.7.0.1
 */