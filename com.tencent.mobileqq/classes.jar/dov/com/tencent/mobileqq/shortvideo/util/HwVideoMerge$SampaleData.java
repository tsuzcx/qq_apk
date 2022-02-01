package dov.com.tencent.mobileqq.shortvideo.util;

import android.media.MediaCodec.BufferInfo;
import java.nio.ByteBuffer;

class HwVideoMerge$SampaleData
{
  public int a;
  public MediaCodec.BufferInfo a;
  public ByteBuffer a;
  public int b;
  
  private HwVideoMerge$SampaleData()
  {
    this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo = new MediaCodec.BufferInfo();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaNioByteBuffer = ByteBuffer.allocate(paramInt1 * paramInt2 * 3 / 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.util.HwVideoMerge.SampaleData
 * JD-Core Version:    0.7.0.1
 */