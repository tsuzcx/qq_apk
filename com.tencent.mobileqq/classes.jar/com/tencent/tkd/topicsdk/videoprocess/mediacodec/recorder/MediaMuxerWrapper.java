package com.tencent.tkd.topicsdk.videoprocess.mediacodec.recorder;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.topicsdk.videoprocess.mediacodec.encoder.Mp4ReEncoder;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import java.util.List;

@TargetApi(18)
public class MediaMuxerWrapper
{
  private int jdField_a_of_type_Int;
  private MediaFormat jdField_a_of_type_AndroidMediaMediaFormat;
  public final MediaMuxer a;
  private final Mp4ReEncoder jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderMp4ReEncoder;
  private final HWEncodeListener jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWEncodeListener;
  private final String jdField_a_of_type_JavaLangString;
  private ByteBuffer jdField_a_of_type_JavaNioByteBuffer;
  private final List<MediaMuxerWrapper.SampleInfo> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private MediaFormat jdField_b_of_type_AndroidMediaMediaFormat;
  private int jdField_c_of_type_Int;
  private MediaFormat jdField_c_of_type_AndroidMediaMediaFormat;
  private int d;
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new AssertionError();
    case 0: 
      return this.jdField_b_of_type_Int;
    case 1: 
      return this.jdField_c_of_type_Int;
    }
    return this.d;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaFormat == null) {}
    while (((this.jdField_b_of_type_AndroidMediaMediaFormat == null) && (this.jdField_a_of_type_Int > 0)) || ((this.jdField_a_of_type_Int == 2) && (this.jdField_c_of_type_AndroidMediaMediaFormat == null))) {
      return;
    }
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaMuxer.addTrack(this.jdField_a_of_type_AndroidMediaMediaFormat);
    TLog.b("MediaMuxerWrapper", "Added track #" + this.jdField_b_of_type_Int + " with " + this.jdField_a_of_type_AndroidMediaMediaFormat.getString("mime") + " to muxer");
    if (this.jdField_b_of_type_AndroidMediaMediaFormat != null)
    {
      this.jdField_c_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaMuxer.addTrack(this.jdField_b_of_type_AndroidMediaMediaFormat);
      TLog.b("MediaMuxerWrapper", "Added track #" + this.jdField_c_of_type_Int + " with " + this.jdField_b_of_type_AndroidMediaMediaFormat.getString("mime") + " to muxer");
    }
    if (this.jdField_c_of_type_AndroidMediaMediaFormat != null)
    {
      this.d = this.jdField_a_of_type_AndroidMediaMediaMuxer.addTrack(this.jdField_b_of_type_AndroidMediaMediaFormat);
      TLog.b("MediaMuxerWrapper", "Added second audiotrack #" + this.jdField_c_of_type_Int + " with " + this.jdField_c_of_type_AndroidMediaMediaFormat.getString("mime") + " to muxer");
    }
    this.jdField_a_of_type_AndroidMediaMediaMuxer.start();
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_JavaNioByteBuffer == null) {
      this.jdField_a_of_type_JavaNioByteBuffer = ByteBuffer.allocate(0);
    }
    this.jdField_a_of_type_JavaNioByteBuffer.flip();
    TLog.b("MediaMuxerWrapper", "Output format determined, writing " + this.jdField_a_of_type_JavaUtilList.size() + " samples / " + this.jdField_a_of_type_JavaNioByteBuffer.limit() + " bytes to muxer.");
    MediaCodec.BufferInfo localBufferInfo = new MediaCodec.BufferInfo();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    MediaMuxerWrapper.SampleInfo localSampleInfo;
    for (int i = 0; localIterator.hasNext(); i = MediaMuxerWrapper.SampleInfo.b(localSampleInfo) + i)
    {
      localSampleInfo = (MediaMuxerWrapper.SampleInfo)localIterator.next();
      MediaMuxerWrapper.SampleInfo.a(localSampleInfo, localBufferInfo, i);
      this.jdField_a_of_type_AndroidMediaMediaMuxer.writeSampleData(a(MediaMuxerWrapper.SampleInfo.a(localSampleInfo)), this.jdField_a_of_type_JavaNioByteBuffer, localBufferInfo);
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaNioByteBuffer = null;
  }
  
  public void a()
  {
    try
    {
      TLog.b("MediaMuxerWrapper", "release");
      if (this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderMp4ReEncoder.a())
      {
        TLog.b("MediaMuxerWrapper", "release indeed");
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_AndroidMediaMediaMuxer.stop();
        }
        this.jdField_a_of_type_AndroidMediaMediaMuxer.release();
        if (this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWEncodeListener != null) {
          this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWEncodeListener.a(this.jdField_a_of_type_JavaLangString);
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(int paramInt, MediaFormat paramMediaFormat)
  {
    TLog.b("MediaMuxerWrapper", "setOutputFormat " + paramInt);
    switch (paramInt)
    {
    default: 
      throw new AssertionError();
    case 0: 
      this.jdField_a_of_type_AndroidMediaMediaFormat = paramMediaFormat;
    }
    for (;;)
    {
      b();
      return;
      this.jdField_b_of_type_AndroidMediaMediaFormat = paramMediaFormat;
      continue;
      this.jdField_c_of_type_AndroidMediaMediaFormat = paramMediaFormat;
    }
  }
  
  public void a(int paramInt, ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    try
    {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidMediaMediaMuxer.writeSampleData(a(paramInt), paramByteBuffer, paramBufferInfo);
        return;
      }
      paramByteBuffer.limit(paramBufferInfo.offset + paramBufferInfo.size);
      paramByteBuffer.position(paramBufferInfo.offset);
      if (this.jdField_a_of_type_JavaNioByteBuffer == null) {
        this.jdField_a_of_type_JavaNioByteBuffer = ByteBuffer.allocateDirect(65536).order(ByteOrder.nativeOrder());
      }
      this.jdField_a_of_type_JavaNioByteBuffer.put(paramByteBuffer);
      this.jdField_a_of_type_JavaUtilList.add(new MediaMuxerWrapper.SampleInfo(paramInt, paramBufferInfo.size, paramBufferInfo, null));
      return;
    }
    catch (Exception paramByteBuffer)
    {
      TLog.c("MediaMuxerWrapper", "writeSampleData error, ", paramByteBuffer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.mediacodec.recorder.MediaMuxerWrapper
 * JD-Core Version:    0.7.0.1
 */