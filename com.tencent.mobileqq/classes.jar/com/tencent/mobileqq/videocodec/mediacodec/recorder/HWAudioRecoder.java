package com.tencent.mobileqq.videocodec.mediacodec.recorder;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@TargetApi(18)
public class HWAudioRecoder
{
  private int jdField_a_of_type_Int = 1024;
  private long jdField_a_of_type_Long;
  private final MediaCodec.BufferInfo jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo = new MediaCodec.BufferInfo();
  private MediaExtractor jdField_a_of_type_AndroidMediaMediaExtractor;
  private final DecodeConfig jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig;
  private HWAudioRecoder.TrackResult jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWAudioRecoder$TrackResult;
  private final MediaMuxerWrapper jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderMediaMuxerWrapper;
  private ByteBuffer jdField_a_of_type_JavaNioByteBuffer;
  private boolean b;
  private volatile boolean c;
  private volatile boolean d;
  
  public HWAudioRecoder(DecodeConfig paramDecodeConfig, MediaMuxerWrapper paramMediaMuxerWrapper)
  {
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderMediaMuxerWrapper = paramMediaMuxerWrapper;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig = paramDecodeConfig;
    this.jdField_a_of_type_Long = (paramDecodeConfig.endTimeMillSecond * 1000L);
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaExtractor = new MediaExtractor();
      this.jdField_a_of_type_AndroidMediaMediaExtractor.setDataSource(paramDecodeConfig.inputFilePath);
      this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWAudioRecoder$TrackResult = a(this.jdField_a_of_type_AndroidMediaMediaExtractor);
      if (this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWAudioRecoder$TrackResult.jdField_a_of_type_Int >= 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("HWAudioRecoder", 1, "audio track normal");
        }
        this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderMediaMuxerWrapper.a(1, this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWAudioRecoder$TrackResult.jdField_a_of_type_AndroidMediaMediaFormat);
        this.jdField_a_of_type_AndroidMediaMediaExtractor.selectTrack(this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWAudioRecoder$TrackResult.jdField_a_of_type_Int);
        if (this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWAudioRecoder$TrackResult.jdField_a_of_type_AndroidMediaMediaFormat.containsKey("max-input-size")) {
          this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWAudioRecoder$TrackResult.jdField_a_of_type_AndroidMediaMediaFormat.getInteger("max-input-size");
        }
        if (this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWAudioRecoder$TrackResult.jdField_b_of_type_Int >= 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderMediaMuxerWrapper.a(2);
          this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderMediaMuxerWrapper.a(2, this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWAudioRecoder$TrackResult.jdField_b_of_type_AndroidMediaMediaFormat);
          this.jdField_a_of_type_AndroidMediaMediaExtractor.selectTrack(this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWAudioRecoder$TrackResult.jdField_b_of_type_Int);
          if (this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWAudioRecoder$TrackResult.jdField_b_of_type_AndroidMediaMediaFormat.containsKey("max-input-size"))
          {
            int i = this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWAudioRecoder$TrackResult.jdField_b_of_type_AndroidMediaMediaFormat.getInteger("max-input-size");
            if (i > this.jdField_a_of_type_Int) {
              this.jdField_a_of_type_Int = i;
            }
          }
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderMediaMuxerWrapper.a(0);
        this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderMediaMuxerWrapper.a(1, null);
        if (QLog.isColorLevel()) {
          QLog.d("HWAudioRecoder", 1, "no audio track");
        }
      }
      this.jdField_a_of_type_JavaNioByteBuffer = ByteBuffer.allocateDirect(this.jdField_a_of_type_Int).order(ByteOrder.nativeOrder());
      this.jdField_a_of_type_AndroidMediaMediaExtractor.seekTo(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.startTimeMillSecond * 1000L, 0);
      return;
    }
    catch (Exception paramDecodeConfig)
    {
      QLog.e("HWAudioRecoder", 1, "getAudioTrack,", paramDecodeConfig);
    }
  }
  
  public HWAudioRecoder.TrackResult a(MediaExtractor paramMediaExtractor)
  {
    HWAudioRecoder.TrackResult localTrackResult = new HWAudioRecoder.TrackResult();
    int j = paramMediaExtractor.getTrackCount();
    long l2 = 0L;
    int i = 0;
    while (i < j)
    {
      MediaFormat localMediaFormat = paramMediaExtractor.getTrackFormat(i);
      String str = localMediaFormat.getString("mime");
      long l1 = l2;
      if (localTrackResult.jdField_a_of_type_Int < 0)
      {
        l1 = l2;
        if (str.startsWith("audio/"))
        {
          l2 += 1L;
          if (l2 == 1L)
          {
            localTrackResult.jdField_a_of_type_Int = i;
            localTrackResult.jdField_a_of_type_JavaLangString = str;
            localTrackResult.jdField_a_of_type_AndroidMediaMediaFormat = localMediaFormat;
          }
          else if (l2 == 2L)
          {
            localTrackResult.jdField_b_of_type_Int = i;
            localTrackResult.jdField_b_of_type_JavaLangString = str;
            localTrackResult.jdField_b_of_type_AndroidMediaMediaFormat = localMediaFormat;
          }
          l1 = l2;
          if (l2 >= 2L) {
            break;
          }
        }
      }
      i += 1;
      l2 = l1;
    }
    boolean bool;
    if (localTrackResult.jdField_a_of_type_Int >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.b = bool;
    QLog.d("HWAudioRecoder", 1, new Object[] { "getAudioTrack, ", Integer.valueOf(localTrackResult.jdField_a_of_type_Int), " ", Integer.valueOf(localTrackResult.jdField_b_of_type_Int) });
    return localTrackResult;
  }
  
  public void a()
  {
    QLog.d("HWAudioRecoder", 1, "stopRecording audio");
    while ((!a()) && (b())) {}
    QLog.d("HWAudioRecoder", 1, "stopRecording audio, indeed");
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderMediaMuxerWrapper.a();
    MediaExtractor localMediaExtractor = this.jdField_a_of_type_AndroidMediaMediaExtractor;
    if (localMediaExtractor != null)
    {
      localMediaExtractor.release();
      this.jdField_a_of_type_AndroidMediaMediaExtractor = null;
    }
  }
  
  public boolean a()
  {
    if (!this.b) {
      return true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWAudioRecoder$TrackResult.jdField_b_of_type_Int < 0) {
      return this.c;
    }
    return (this.c) && (this.d);
  }
  
  public boolean b()
  {
    if (this.b)
    {
      if (a()) {
        return false;
      }
      int j = this.jdField_a_of_type_AndroidMediaMediaExtractor.getSampleTrackIndex();
      int i = 2;
      if (j < 0)
      {
        this.jdField_a_of_type_JavaNioByteBuffer.clear();
        this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.set(0, 0, 0L, 4);
        this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderMediaMuxerWrapper.a(1, this.jdField_a_of_type_JavaNioByteBuffer, this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo);
        this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderMediaMuxerWrapper.a(2, this.jdField_a_of_type_JavaNioByteBuffer, this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo);
        this.c = true;
        this.d = true;
        return true;
      }
      if (j == this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWAudioRecoder$TrackResult.jdField_a_of_type_Int) {
        i = 1;
      } else {
        if (j != this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWAudioRecoder$TrackResult.jdField_b_of_type_Int) {
          break label325;
        }
      }
      this.jdField_a_of_type_JavaNioByteBuffer.clear();
      int k = this.jdField_a_of_type_AndroidMediaMediaExtractor.readSampleData(this.jdField_a_of_type_JavaNioByteBuffer, 0);
      long l1 = this.jdField_a_of_type_AndroidMediaMediaExtractor.getSampleTime();
      if ((!jdField_a_of_type_Boolean) && (k > this.jdField_a_of_type_Int)) {
        throw new AssertionError();
      }
      if (k >= 0)
      {
        long l2 = this.jdField_a_of_type_Long;
        if ((l2 <= 0L) || (l1 <= l2))
        {
          if ((this.jdField_a_of_type_AndroidMediaMediaExtractor.getSampleFlags() & 0x1) != 0) {
            j = 1;
          } else {
            j = 0;
          }
          this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.set(0, k, this.jdField_a_of_type_AndroidMediaMediaExtractor.getSampleTime(), j);
          this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderMediaMuxerWrapper.a(i, this.jdField_a_of_type_JavaNioByteBuffer, this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo);
          this.jdField_a_of_type_AndroidMediaMediaExtractor.advance();
          return true;
        }
      }
      this.jdField_a_of_type_JavaNioByteBuffer.clear();
      this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.set(0, 0, 0L, 4);
      this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderMediaMuxerWrapper.a(i, this.jdField_a_of_type_JavaNioByteBuffer, this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo);
      if (j == this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWAudioRecoder$TrackResult.jdField_a_of_type_Int)
      {
        this.c = true;
        return true;
      }
      this.d = true;
      return true;
    }
    label325:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.mediacodec.recorder.HWAudioRecoder
 * JD-Core Version:    0.7.0.1
 */