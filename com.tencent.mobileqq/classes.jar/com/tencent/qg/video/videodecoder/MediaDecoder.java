package com.tencent.qg.video.videodecoder;

import com.tencent.biz.qqstory.support.logging.SLog;

public class MediaDecoder
{
  private volatile long jdField_a_of_type_Long;
  private final MediaCodecAudioRender jdField_a_of_type_ComTencentQgVideoVideodecoderMediaCodecAudioRender;
  private MediaCodecRender.MediaContext jdField_a_of_type_ComTencentQgVideoVideodecoderMediaCodecRender$MediaContext;
  private final MediaCodecVideoRender jdField_a_of_type_ComTencentQgVideoVideodecoderMediaCodecVideoRender;
  private MediaDecoder.DecodeListener jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeListener;
  private MediaDecoder.DecodeRunnable jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeRunnable;
  private Thread jdField_a_of_type_JavaLangThread;
  private final boolean jdField_a_of_type_Boolean;
  private boolean b;
  private volatile boolean c;
  private volatile boolean d;
  private volatile boolean e;
  
  private boolean d()
  {
    return (this.jdField_a_of_type_Boolean) && (this.b);
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaCodecVideoRender.a() / 1000L;
  }
  
  public void a()
  {
    SLog.b("Q.qqstory.mediadecoderMediaDecoder", "stopDecode");
    this.e = false;
    MediaDecoder.DecodeRunnable localDecodeRunnable = this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeRunnable;
    if (localDecodeRunnable != null)
    {
      localDecodeRunnable.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeRunnable = null;
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public boolean a()
  {
    return this.e;
  }
  
  public void b()
  {
    SLog.b("Q.qqstory.mediadecoderMediaDecoder", "pauseDecode");
    if (this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeRunnable != null)
    {
      this.d = true;
      return;
    }
    SLog.d("Q.qqstory.mediadecoderMediaDecoder", "pauseDecode failed, can not find DecodeRunnable");
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaCodecRender$MediaContext.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeRunnable != null) {
      return this.d;
    }
    return false;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaCodecRender$MediaContext.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qg.video.videodecoder.MediaDecoder
 * JD-Core Version:    0.7.0.1
 */