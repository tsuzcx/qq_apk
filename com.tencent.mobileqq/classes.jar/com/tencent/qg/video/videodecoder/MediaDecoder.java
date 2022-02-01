package com.tencent.qg.video.videodecoder;

import bkgh;
import bkgk;
import bkgl;
import bkgm;
import bkgn;
import bkgo;
import brft;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder;
import yuk;

public class MediaDecoder
{
  private volatile long jdField_a_of_type_Long = -1L;
  private final bkgh jdField_a_of_type_Bkgh;
  private bkgl jdField_a_of_type_Bkgl;
  private final bkgm jdField_a_of_type_Bkgm;
  private bkgo jdField_a_of_type_Bkgo;
  private MediaDecoder.DecodeRunnable jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeRunnable;
  private Thread jdField_a_of_type_JavaLangThread;
  private final boolean jdField_a_of_type_Boolean;
  private boolean b = true;
  private volatile boolean c;
  private volatile boolean d;
  private volatile boolean e;
  
  public MediaDecoder(String paramString, int paramInt1, bkgo parambkgo, boolean paramBoolean, int paramInt2)
  {
    yuk.a("Q.qqstory.mediadecoderMediaDecoder", "Construct MediaDecoder , src = %s , supportMusic = %s", paramString, Boolean.valueOf(paramBoolean));
    this.jdField_a_of_type_Bkgl = new bkgl();
    this.jdField_a_of_type_Bkgl.jdField_a_of_type_Long = paramInt2;
    this.jdField_a_of_type_Boolean = paramBoolean;
    bkgk localbkgk = new bkgk();
    localbkgk.jdField_a_of_type_JavaLangString = "video/";
    localbkgk.b = paramString;
    this.jdField_a_of_type_Bkgm = new bkgm(this.jdField_a_of_type_Bkgl, localbkgk, paramInt1, new bkgn(this, parambkgo));
    brft localbrft;
    if (this.jdField_a_of_type_Boolean)
    {
      localbkgk = new bkgk();
      localbkgk.jdField_a_of_type_JavaLangString = "audio/";
      localbkgk.b = paramString;
      localbrft = new brft();
      localbrft.jdField_a_of_type_JavaLangString = paramString;
      localbrft.jdField_a_of_type_Bddn = AudioEncoder.a(paramString, null, 0);
    }
    for (this.jdField_a_of_type_Bkgh = new bkgh(this.jdField_a_of_type_Bkgl, localbkgk, localbrft);; this.jdField_a_of_type_Bkgh = null)
    {
      this.jdField_a_of_type_Bkgo = parambkgo;
      this.jdField_a_of_type_Bkgm.a(parambkgo);
      return;
    }
  }
  
  private boolean d()
  {
    return (this.jdField_a_of_type_Boolean) && (this.b);
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Bkgm.a() / 1000L;
  }
  
  public void a()
  {
    yuk.b("Q.qqstory.mediadecoderMediaDecoder", "start decode");
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
    yuk.b("Q.qqstory.mediadecoderMediaDecoder", "stopDecode");
    this.e = false;
    if (this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeRunnable != null)
    {
      this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeRunnable.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeRunnable = null;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Bkgl.jdField_a_of_type_Boolean = paramBoolean;
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
    yuk.b("Q.qqstory.mediadecoderMediaDecoder", "pauseDecode");
    if (this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeRunnable != null)
    {
      this.d = true;
      return;
    }
    yuk.d("Q.qqstory.mediadecoderMediaDecoder", "pauseDecode failed, can not find DecodeRunnable");
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Bkgl.jdField_a_of_type_Boolean;
  }
  
  public void d()
  {
    yuk.b("Q.qqstory.mediadecoderMediaDecoder", "resumeDecode");
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
    yuk.d("Q.qqstory.mediadecoderMediaDecoder", "resumeDecode failed, can not find DecodeRunnable");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qg.video.videodecoder.MediaDecoder
 * JD-Core Version:    0.7.0.1
 */