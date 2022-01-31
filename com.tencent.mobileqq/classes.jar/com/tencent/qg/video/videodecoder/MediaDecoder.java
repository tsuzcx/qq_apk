package com.tencent.qg.video.videodecoder;

import bdtc;
import bdtf;
import bdtg;
import bdth;
import bdti;
import bdtj;
import bkxb;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder;
import veg;

public class MediaDecoder
{
  private volatile long jdField_a_of_type_Long = -1L;
  private final bdtc jdField_a_of_type_Bdtc;
  private bdtg jdField_a_of_type_Bdtg;
  private final bdth jdField_a_of_type_Bdth;
  private bdtj jdField_a_of_type_Bdtj;
  private MediaDecoder.DecodeRunnable jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeRunnable;
  private Thread jdField_a_of_type_JavaLangThread;
  private final boolean jdField_a_of_type_Boolean;
  private boolean b = true;
  private volatile boolean c;
  private volatile boolean d;
  private volatile boolean e;
  
  public MediaDecoder(String paramString, int paramInt1, bdtj parambdtj, boolean paramBoolean, int paramInt2)
  {
    veg.a("Q.qqstory.mediadecoderMediaDecoder", "Construct MediaDecoder , src = %s , supportMusic = %s", paramString, Boolean.valueOf(paramBoolean));
    this.jdField_a_of_type_Bdtg = new bdtg();
    this.jdField_a_of_type_Bdtg.jdField_a_of_type_Long = paramInt2;
    this.jdField_a_of_type_Boolean = paramBoolean;
    bdtf localbdtf = new bdtf();
    localbdtf.jdField_a_of_type_JavaLangString = "video/";
    localbdtf.b = paramString;
    this.jdField_a_of_type_Bdth = new bdth(this.jdField_a_of_type_Bdtg, localbdtf, paramInt1, new bdti(this, parambdtj));
    bkxb localbkxb;
    if (this.jdField_a_of_type_Boolean)
    {
      localbdtf = new bdtf();
      localbdtf.jdField_a_of_type_JavaLangString = "audio/";
      localbdtf.b = paramString;
      localbkxb = new bkxb();
      localbkxb.jdField_a_of_type_JavaLangString = paramString;
      localbkxb.jdField_a_of_type_Axkf = AudioEncoder.a(paramString, null, 0);
    }
    for (this.jdField_a_of_type_Bdtc = new bdtc(this.jdField_a_of_type_Bdtg, localbdtf, localbkxb);; this.jdField_a_of_type_Bdtc = null)
    {
      this.jdField_a_of_type_Bdtj = parambdtj;
      this.jdField_a_of_type_Bdth.a(parambdtj);
      return;
    }
  }
  
  private boolean d()
  {
    return (this.jdField_a_of_type_Boolean) && (this.b);
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Bdth.a() / 1000L;
  }
  
  public void a()
  {
    veg.b("Q.qqstory.mediadecoderMediaDecoder", "start decode");
    this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeRunnable = new MediaDecoder.DecodeRunnable(this, null);
    this.jdField_a_of_type_JavaLangThread = ThreadManager.newFreeThread(this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeRunnable, "MediaDecoder-Thread", 8);
    this.jdField_a_of_type_JavaLangThread.start();
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
    veg.b("Q.qqstory.mediadecoderMediaDecoder", "stopDecode");
    this.e = false;
    if (this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeRunnable != null)
    {
      this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeRunnable.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeRunnable = null;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Bdtg.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeRunnable != null) {
      return this.d;
    }
    return false;
  }
  
  public void c()
  {
    veg.b("Q.qqstory.mediadecoderMediaDecoder", "pauseDecode");
    if (this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeRunnable != null)
    {
      this.d = true;
      return;
    }
    veg.d("Q.qqstory.mediadecoderMediaDecoder", "pauseDecode failed, can not find DecodeRunnable");
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Bdtg.jdField_a_of_type_Boolean;
  }
  
  public void d()
  {
    veg.b("Q.qqstory.mediadecoderMediaDecoder", "resumeDecode");
    MediaDecoder.DecodeRunnable localDecodeRunnable = this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeRunnable;
    if (localDecodeRunnable != null)
    {
      this.d = false;
      synchronized (MediaDecoder.DecodeRunnable.a(localDecodeRunnable))
      {
        MediaDecoder.DecodeRunnable.a(localDecodeRunnable).notifyAll();
        return;
      }
    }
    veg.d("Q.qqstory.mediadecoderMediaDecoder", "resumeDecode failed, can not find DecodeRunnable");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.qg.video.videodecoder.MediaDecoder
 * JD-Core Version:    0.7.0.1
 */