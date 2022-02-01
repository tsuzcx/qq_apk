package com.tencent.mobileqq.videocodec.mediacodec.recorder;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.tencent.mobileqq.videocodec.mediacodec.Mp4ReEncoder;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@TargetApi(18)
public class MediaMuxerWrapper
{
  private int jdField_a_of_type_Int = 1;
  private MediaFormat jdField_a_of_type_AndroidMediaMediaFormat;
  public final MediaMuxer a;
  private final Mp4ReEncoder jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecMp4ReEncoder;
  private final HWEncodeListener jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWEncodeListener;
  private final String jdField_a_of_type_JavaLangString;
  private ByteBuffer jdField_a_of_type_JavaNioByteBuffer;
  private final List<MediaMuxerWrapper.SampleInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private MediaFormat jdField_b_of_type_AndroidMediaMediaFormat;
  private int jdField_c_of_type_Int;
  private MediaFormat jdField_c_of_type_AndroidMediaMediaFormat;
  private int d;
  
  public MediaMuxerWrapper(Mp4ReEncoder paramMp4ReEncoder, String paramString, HWEncodeListener paramHWEncodeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecMp4ReEncoder = paramMp4ReEncoder;
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWEncodeListener = paramHWEncodeListener;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidMediaMediaMuxer = new MediaMuxer(paramString, 0);
  }
  
  private int a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt == 2) {
          return this.d;
        }
        throw new AssertionError();
      }
      return this.jdField_c_of_type_Int;
    }
    return this.jdField_b_of_type_Int;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaFormat == null) {
      return;
    }
    if ((this.jdField_b_of_type_AndroidMediaMediaFormat == null) && (this.jdField_a_of_type_Int > 0)) {
      return;
    }
    if ((this.jdField_a_of_type_Int == 2) && (this.jdField_c_of_type_AndroidMediaMediaFormat == null)) {
      return;
    }
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaMuxer.addTrack(this.jdField_a_of_type_AndroidMediaMediaFormat);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Added track #");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
    ((StringBuilder)localObject).append(" with ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidMediaMediaFormat.getString("mime"));
    ((StringBuilder)localObject).append(" to muxer");
    QLog.d("MediaMuxerWrapper", 1, ((StringBuilder)localObject).toString());
    localObject = this.jdField_b_of_type_AndroidMediaMediaFormat;
    if (localObject != null)
    {
      this.jdField_c_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaMuxer.addTrack((MediaFormat)localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Added track #");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_Int);
      ((StringBuilder)localObject).append(" with ");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_AndroidMediaMediaFormat.getString("mime"));
      ((StringBuilder)localObject).append(" to muxer");
      QLog.d("MediaMuxerWrapper", 1, ((StringBuilder)localObject).toString());
    }
    localObject = this.jdField_c_of_type_AndroidMediaMediaFormat;
    int i = 0;
    if (localObject != null)
    {
      this.d = this.jdField_a_of_type_AndroidMediaMediaMuxer.addTrack(this.jdField_b_of_type_AndroidMediaMediaFormat);
      QLog.d("MediaMuxerWrapper", 1, new Object[] { "Added second audiotrack #", Integer.valueOf(this.jdField_c_of_type_Int), " with ", this.jdField_c_of_type_AndroidMediaMediaFormat.getString("mime"), " to muxer" });
    }
    this.jdField_a_of_type_AndroidMediaMediaMuxer.start();
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_JavaNioByteBuffer == null) {
      this.jdField_a_of_type_JavaNioByteBuffer = ByteBuffer.allocate(0);
    }
    this.jdField_a_of_type_JavaNioByteBuffer.flip();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Output format determined, writing ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilList.size());
    ((StringBuilder)localObject).append(" samples / ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaNioByteBuffer.limit());
    ((StringBuilder)localObject).append(" bytes to muxer.");
    QLog.d("MediaMuxerWrapper", 1, ((StringBuilder)localObject).toString());
    localObject = new MediaCodec.BufferInfo();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      MediaMuxerWrapper.SampleInfo localSampleInfo = (MediaMuxerWrapper.SampleInfo)localIterator.next();
      MediaMuxerWrapper.SampleInfo.a(localSampleInfo, (MediaCodec.BufferInfo)localObject, i);
      this.jdField_a_of_type_AndroidMediaMediaMuxer.writeSampleData(a(MediaMuxerWrapper.SampleInfo.a(localSampleInfo)), this.jdField_a_of_type_JavaNioByteBuffer, (MediaCodec.BufferInfo)localObject);
      i += MediaMuxerWrapper.SampleInfo.b(localSampleInfo);
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaNioByteBuffer = null;
  }
  
  public void a()
  {
    try
    {
      QLog.d("MediaMuxerWrapper", 1, "release");
      if (this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecMp4ReEncoder.a())
      {
        QLog.d("MediaMuxerWrapper", 1, "release indeed");
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_AndroidMediaMediaMuxer.stop();
        }
        this.jdField_a_of_type_AndroidMediaMediaMuxer.release();
        if (this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWEncodeListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWEncodeListener.onEncodeFinish(this.jdField_a_of_type_JavaLangString);
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, MediaFormat paramMediaFormat)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setOutputFormat ");
    localStringBuilder.append(paramInt);
    QLog.d("MediaMuxerWrapper", 1, localStringBuilder.toString());
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt == 2) {
          this.jdField_c_of_type_AndroidMediaMediaFormat = paramMediaFormat;
        } else {
          throw new AssertionError();
        }
      }
      else {
        this.jdField_b_of_type_AndroidMediaMediaFormat = paramMediaFormat;
      }
    }
    else {
      this.jdField_a_of_type_AndroidMediaMediaFormat = paramMediaFormat;
    }
    b();
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
      QLog.e("MediaMuxerWrapper", 1, "writeSampleData error, ", paramByteBuffer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.mediacodec.recorder.MediaMuxerWrapper
 * JD-Core Version:    0.7.0.1
 */