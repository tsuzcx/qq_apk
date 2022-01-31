package com.tencent.qg.video.videodecoder;

import bcpb;
import bcpe;
import bcpf;
import bcpg;
import bcph;
import bcpi;
import bjgq;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder;
import urk;

public class MediaDecoder
{
  private volatile long jdField_a_of_type_Long = -1L;
  private final bcpb jdField_a_of_type_Bcpb;
  private bcpf jdField_a_of_type_Bcpf;
  private final bcpg jdField_a_of_type_Bcpg;
  private bcpi jdField_a_of_type_Bcpi;
  private MediaDecoder.DecodeRunnable jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeRunnable;
  private Thread jdField_a_of_type_JavaLangThread;
  private final boolean jdField_a_of_type_Boolean;
  private boolean b = true;
  private volatile boolean c;
  private volatile boolean d;
  private volatile boolean e;
  
  public MediaDecoder(String paramString, int paramInt1, bcpi parambcpi, boolean paramBoolean, int paramInt2)
  {
    urk.a("Q.qqstory.mediadecoderMediaDecoder", "Construct MediaDecoder , src = %s , supportMusic = %s", paramString, Boolean.valueOf(paramBoolean));
    this.jdField_a_of_type_Bcpf = new bcpf();
    this.jdField_a_of_type_Bcpf.jdField_a_of_type_Long = paramInt2;
    this.jdField_a_of_type_Boolean = paramBoolean;
    bcpe localbcpe = new bcpe();
    localbcpe.jdField_a_of_type_JavaLangString = "video/";
    localbcpe.b = paramString;
    this.jdField_a_of_type_Bcpg = new bcpg(this.jdField_a_of_type_Bcpf, localbcpe, paramInt1, new bcph(this, parambcpi));
    bjgq localbjgq;
    if (this.jdField_a_of_type_Boolean)
    {
      localbcpe = new bcpe();
      localbcpe.jdField_a_of_type_JavaLangString = "audio/";
      localbcpe.b = paramString;
      localbjgq = new bjgq();
      localbjgq.jdField_a_of_type_JavaLangString = paramString;
      localbjgq.jdField_a_of_type_Awkz = AudioEncoder.a(paramString, null, 0);
    }
    for (this.jdField_a_of_type_Bcpb = new bcpb(this.jdField_a_of_type_Bcpf, localbcpe, localbjgq);; this.jdField_a_of_type_Bcpb = null)
    {
      this.jdField_a_of_type_Bcpi = parambcpi;
      this.jdField_a_of_type_Bcpg.a(parambcpi);
      return;
    }
  }
  
  private boolean d()
  {
    return (this.jdField_a_of_type_Boolean) && (this.b);
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Bcpg.a() / 1000L;
  }
  
  public void a()
  {
    urk.b("Q.qqstory.mediadecoderMediaDecoder", "start decode");
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
    urk.b("Q.qqstory.mediadecoderMediaDecoder", "stopDecode");
    this.e = false;
    if (this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeRunnable != null)
    {
      this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeRunnable.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeRunnable = null;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Bcpf.jdField_a_of_type_Boolean = paramBoolean;
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
    urk.b("Q.qqstory.mediadecoderMediaDecoder", "pauseDecode");
    if (this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeRunnable != null)
    {
      this.d = true;
      return;
    }
    urk.d("Q.qqstory.mediadecoderMediaDecoder", "pauseDecode failed, can not find DecodeRunnable");
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Bcpf.jdField_a_of_type_Boolean;
  }
  
  public void d()
  {
    urk.b("Q.qqstory.mediadecoderMediaDecoder", "resumeDecode");
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
    urk.d("Q.qqstory.mediadecoderMediaDecoder", "resumeDecode failed, can not find DecodeRunnable");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.qg.video.videodecoder.MediaDecoder
 * JD-Core Version:    0.7.0.1
 */