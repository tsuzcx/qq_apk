package com.tencent.qg.video.videodecoder;

import bdtt;
import bdtw;
import bdtx;
import bdty;
import bdtz;
import bdua;
import bkxs;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder;
import ved;

public class MediaDecoder
{
  private volatile long jdField_a_of_type_Long = -1L;
  private final bdtt jdField_a_of_type_Bdtt;
  private bdtx jdField_a_of_type_Bdtx;
  private final bdty jdField_a_of_type_Bdty;
  private bdua jdField_a_of_type_Bdua;
  private MediaDecoder.DecodeRunnable jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeRunnable;
  private Thread jdField_a_of_type_JavaLangThread;
  private final boolean jdField_a_of_type_Boolean;
  private boolean b = true;
  private volatile boolean c;
  private volatile boolean d;
  private volatile boolean e;
  
  public MediaDecoder(String paramString, int paramInt1, bdua parambdua, boolean paramBoolean, int paramInt2)
  {
    ved.a("Q.qqstory.mediadecoderMediaDecoder", "Construct MediaDecoder , src = %s , supportMusic = %s", paramString, Boolean.valueOf(paramBoolean));
    this.jdField_a_of_type_Bdtx = new bdtx();
    this.jdField_a_of_type_Bdtx.jdField_a_of_type_Long = paramInt2;
    this.jdField_a_of_type_Boolean = paramBoolean;
    bdtw localbdtw = new bdtw();
    localbdtw.jdField_a_of_type_JavaLangString = "video/";
    localbdtw.b = paramString;
    this.jdField_a_of_type_Bdty = new bdty(this.jdField_a_of_type_Bdtx, localbdtw, paramInt1, new bdtz(this, parambdua));
    bkxs localbkxs;
    if (this.jdField_a_of_type_Boolean)
    {
      localbdtw = new bdtw();
      localbdtw.jdField_a_of_type_JavaLangString = "audio/";
      localbdtw.b = paramString;
      localbkxs = new bkxs();
      localbkxs.jdField_a_of_type_JavaLangString = paramString;
      localbkxs.jdField_a_of_type_Axkh = AudioEncoder.a(paramString, null, 0);
    }
    for (this.jdField_a_of_type_Bdtt = new bdtt(this.jdField_a_of_type_Bdtx, localbdtw, localbkxs);; this.jdField_a_of_type_Bdtt = null)
    {
      this.jdField_a_of_type_Bdua = parambdua;
      this.jdField_a_of_type_Bdty.a(parambdua);
      return;
    }
  }
  
  private boolean d()
  {
    return (this.jdField_a_of_type_Boolean) && (this.b);
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Bdty.a() / 1000L;
  }
  
  public void a()
  {
    ved.b("Q.qqstory.mediadecoderMediaDecoder", "start decode");
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
    ved.b("Q.qqstory.mediadecoderMediaDecoder", "stopDecode");
    this.e = false;
    if (this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeRunnable != null)
    {
      this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeRunnable.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeRunnable = null;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Bdtx.jdField_a_of_type_Boolean = paramBoolean;
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
    ved.b("Q.qqstory.mediadecoderMediaDecoder", "pauseDecode");
    if (this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeRunnable != null)
    {
      this.d = true;
      return;
    }
    ved.d("Q.qqstory.mediadecoderMediaDecoder", "pauseDecode failed, can not find DecodeRunnable");
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Bdtx.jdField_a_of_type_Boolean;
  }
  
  public void d()
  {
    ved.b("Q.qqstory.mediadecoderMediaDecoder", "resumeDecode");
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
    ved.d("Q.qqstory.mediadecoderMediaDecoder", "resumeDecode failed, can not find DecodeRunnable");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.qg.video.videodecoder.MediaDecoder
 * JD-Core Version:    0.7.0.1
 */