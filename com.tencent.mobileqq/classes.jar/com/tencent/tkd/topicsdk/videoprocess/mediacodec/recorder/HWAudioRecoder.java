package com.tencent.tkd.topicsdk.videoprocess.mediacodec.recorder;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import com.tencent.tkd.topicsdk.framework.TLog;
import java.nio.ByteBuffer;

@TargetApi(18)
public class HWAudioRecoder
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private final MediaCodec.BufferInfo jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo;
  private MediaExtractor jdField_a_of_type_AndroidMediaMediaExtractor;
  private HWAudioRecoder.TrackResult jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWAudioRecoder$TrackResult;
  private final MediaMuxerWrapper jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderMediaMuxerWrapper;
  private ByteBuffer jdField_a_of_type_JavaNioByteBuffer;
  private boolean b;
  private volatile boolean c;
  private volatile boolean d;
  
  static
  {
    if (!HWAudioRecoder.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public void a()
  {
    TLog.b("HWAudioRecoder", "stopRecording audio");
    while ((!a()) && (b())) {}
    TLog.b("HWAudioRecoder", "stopRecording audio, indeed");
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderMediaMuxerWrapper.a();
    if (this.jdField_a_of_type_AndroidMediaMediaExtractor != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaExtractor.release();
      this.jdField_a_of_type_AndroidMediaMediaExtractor = null;
    }
  }
  
  public boolean a()
  {
    if (!this.b) {}
    do
    {
      return true;
      if (this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWAudioRecoder$TrackResult.b < 0) {
        return this.c;
      }
    } while ((this.c) && (this.d));
    return false;
  }
  
  public boolean b()
  {
    int i = 2;
    if ((!this.b) || (a())) {
      return false;
    }
    int j = this.jdField_a_of_type_AndroidMediaMediaExtractor.getSampleTrackIndex();
    if (j < 0)
    {
      this.jdField_a_of_type_JavaNioByteBuffer.clear();
      this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.set(0, 0, 0L, 4);
      this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderMediaMuxerWrapper.a(1, this.jdField_a_of_type_JavaNioByteBuffer, this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo);
      this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderMediaMuxerWrapper.a(2, this.jdField_a_of_type_JavaNioByteBuffer, this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo);
      this.c = true;
      this.d = true;
      return true;
    }
    if (j == this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWAudioRecoder$TrackResult.jdField_a_of_type_Int) {
      i = 1;
    }
    int k;
    long l;
    while (j == this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWAudioRecoder$TrackResult.b)
    {
      this.jdField_a_of_type_JavaNioByteBuffer.clear();
      k = this.jdField_a_of_type_AndroidMediaMediaExtractor.readSampleData(this.jdField_a_of_type_JavaNioByteBuffer, 0);
      l = this.jdField_a_of_type_AndroidMediaMediaExtractor.getSampleTime();
      if ((jdField_a_of_type_Boolean) || (k <= this.jdField_a_of_type_Int)) {
        break;
      }
      throw new AssertionError();
    }
    return false;
    if ((k < 0) || ((this.jdField_a_of_type_Long > 0L) && (l > this.jdField_a_of_type_Long)))
    {
      this.jdField_a_of_type_JavaNioByteBuffer.clear();
      this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.set(0, 0, 0L, 4);
      this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderMediaMuxerWrapper.a(i, this.jdField_a_of_type_JavaNioByteBuffer, this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo);
      if (j == this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWAudioRecoder$TrackResult.jdField_a_of_type_Int)
      {
        this.c = true;
        return true;
      }
      this.d = true;
      return true;
    }
    if ((this.jdField_a_of_type_AndroidMediaMediaExtractor.getSampleFlags() & 0x1) != 0)
    {
      j = 1;
      if (j == 0) {
        break label322;
      }
    }
    label322:
    for (j = 1;; j = 0)
    {
      this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.set(0, k, this.jdField_a_of_type_AndroidMediaMediaExtractor.getSampleTime(), j);
      this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderMediaMuxerWrapper.a(i, this.jdField_a_of_type_JavaNioByteBuffer, this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo);
      this.jdField_a_of_type_AndroidMediaMediaExtractor.advance();
      return true;
      j = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.mediacodec.recorder.HWAudioRecoder
 * JD-Core Version:    0.7.0.1
 */