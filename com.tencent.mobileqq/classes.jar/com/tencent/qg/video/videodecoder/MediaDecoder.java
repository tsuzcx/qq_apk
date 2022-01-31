package com.tencent.qg.video.videodecoder;

import bfxv;
import bfxy;
import bfxz;
import bfya;
import bfyb;
import bfyc;
import bnno;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder;
import wxe;

public class MediaDecoder
{
  private volatile long jdField_a_of_type_Long = -1L;
  private final bfxv jdField_a_of_type_Bfxv;
  private bfxz jdField_a_of_type_Bfxz;
  private final bfya jdField_a_of_type_Bfya;
  private bfyc jdField_a_of_type_Bfyc;
  private MediaDecoder.DecodeRunnable jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeRunnable;
  private Thread jdField_a_of_type_JavaLangThread;
  private final boolean jdField_a_of_type_Boolean;
  private boolean b = true;
  private volatile boolean c;
  private volatile boolean d;
  private volatile boolean e;
  
  public MediaDecoder(String paramString, int paramInt1, bfyc parambfyc, boolean paramBoolean, int paramInt2)
  {
    wxe.a("Q.qqstory.mediadecoderMediaDecoder", "Construct MediaDecoder , src = %s , supportMusic = %s", paramString, Boolean.valueOf(paramBoolean));
    this.jdField_a_of_type_Bfxz = new bfxz();
    this.jdField_a_of_type_Bfxz.jdField_a_of_type_Long = paramInt2;
    this.jdField_a_of_type_Boolean = paramBoolean;
    bfxy localbfxy = new bfxy();
    localbfxy.jdField_a_of_type_JavaLangString = "video/";
    localbfxy.b = paramString;
    this.jdField_a_of_type_Bfya = new bfya(this.jdField_a_of_type_Bfxz, localbfxy, paramInt1, new bfyb(this, parambfyc));
    bnno localbnno;
    if (this.jdField_a_of_type_Boolean)
    {
      localbfxy = new bfxy();
      localbfxy.jdField_a_of_type_JavaLangString = "audio/";
      localbfxy.b = paramString;
      localbnno = new bnno();
      localbnno.jdField_a_of_type_JavaLangString = paramString;
      localbnno.jdField_a_of_type_Azjw = AudioEncoder.a(paramString, null, 0);
    }
    for (this.jdField_a_of_type_Bfxv = new bfxv(this.jdField_a_of_type_Bfxz, localbfxy, localbnno);; this.jdField_a_of_type_Bfxv = null)
    {
      this.jdField_a_of_type_Bfyc = parambfyc;
      this.jdField_a_of_type_Bfya.a(parambfyc);
      return;
    }
  }
  
  private boolean d()
  {
    return (this.jdField_a_of_type_Boolean) && (this.b);
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Bfya.a() / 1000L;
  }
  
  public void a()
  {
    wxe.b("Q.qqstory.mediadecoderMediaDecoder", "start decode");
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
    wxe.b("Q.qqstory.mediadecoderMediaDecoder", "stopDecode");
    this.e = false;
    if (this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeRunnable != null)
    {
      this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeRunnable.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeRunnable = null;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Bfxz.jdField_a_of_type_Boolean = paramBoolean;
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
    wxe.b("Q.qqstory.mediadecoderMediaDecoder", "pauseDecode");
    if (this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeRunnable != null)
    {
      this.d = true;
      return;
    }
    wxe.d("Q.qqstory.mediadecoderMediaDecoder", "pauseDecode failed, can not find DecodeRunnable");
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Bfxz.jdField_a_of_type_Boolean;
  }
  
  public void d()
  {
    wxe.b("Q.qqstory.mediadecoderMediaDecoder", "resumeDecode");
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
    wxe.d("Q.qqstory.mediadecoderMediaDecoder", "resumeDecode failed, can not find DecodeRunnable");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qg.video.videodecoder.MediaDecoder
 * JD-Core Version:    0.7.0.1
 */