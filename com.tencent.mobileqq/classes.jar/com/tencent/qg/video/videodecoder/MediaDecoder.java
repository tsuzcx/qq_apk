package com.tencent.qg.video.videodecoder;

import bjfh;
import bjfk;
import bjfl;
import bjfm;
import bjfn;
import bjfo;
import bqei;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder;
import yqp;

public class MediaDecoder
{
  private volatile long jdField_a_of_type_Long = -1L;
  private final bjfh jdField_a_of_type_Bjfh;
  private bjfl jdField_a_of_type_Bjfl;
  private final bjfm jdField_a_of_type_Bjfm;
  private bjfo jdField_a_of_type_Bjfo;
  private MediaDecoder.DecodeRunnable jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeRunnable;
  private Thread jdField_a_of_type_JavaLangThread;
  private final boolean jdField_a_of_type_Boolean;
  private boolean b = true;
  private volatile boolean c;
  private volatile boolean d;
  private volatile boolean e;
  
  public MediaDecoder(String paramString, int paramInt1, bjfo parambjfo, boolean paramBoolean, int paramInt2)
  {
    yqp.a("Q.qqstory.mediadecoderMediaDecoder", "Construct MediaDecoder , src = %s , supportMusic = %s", paramString, Boolean.valueOf(paramBoolean));
    this.jdField_a_of_type_Bjfl = new bjfl();
    this.jdField_a_of_type_Bjfl.jdField_a_of_type_Long = paramInt2;
    this.jdField_a_of_type_Boolean = paramBoolean;
    bjfk localbjfk = new bjfk();
    localbjfk.jdField_a_of_type_JavaLangString = "video/";
    localbjfk.b = paramString;
    this.jdField_a_of_type_Bjfm = new bjfm(this.jdField_a_of_type_Bjfl, localbjfk, paramInt1, new bjfn(this, parambjfo));
    bqei localbqei;
    if (this.jdField_a_of_type_Boolean)
    {
      localbjfk = new bjfk();
      localbjfk.jdField_a_of_type_JavaLangString = "audio/";
      localbjfk.b = paramString;
      localbqei = new bqei();
      localbqei.jdField_a_of_type_JavaLangString = paramString;
      localbqei.jdField_a_of_type_Bckv = AudioEncoder.a(paramString, null, 0);
    }
    for (this.jdField_a_of_type_Bjfh = new bjfh(this.jdField_a_of_type_Bjfl, localbjfk, localbqei);; this.jdField_a_of_type_Bjfh = null)
    {
      this.jdField_a_of_type_Bjfo = parambjfo;
      this.jdField_a_of_type_Bjfm.a(parambjfo);
      return;
    }
  }
  
  private boolean d()
  {
    return (this.jdField_a_of_type_Boolean) && (this.b);
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Bjfm.a() / 1000L;
  }
  
  public void a()
  {
    yqp.b("Q.qqstory.mediadecoderMediaDecoder", "start decode");
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
    yqp.b("Q.qqstory.mediadecoderMediaDecoder", "stopDecode");
    this.e = false;
    if (this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeRunnable != null)
    {
      this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeRunnable.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeRunnable = null;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Bjfl.jdField_a_of_type_Boolean = paramBoolean;
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
    yqp.b("Q.qqstory.mediadecoderMediaDecoder", "pauseDecode");
    if (this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeRunnable != null)
    {
      this.d = true;
      return;
    }
    yqp.d("Q.qqstory.mediadecoderMediaDecoder", "pauseDecode failed, can not find DecodeRunnable");
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Bjfl.jdField_a_of_type_Boolean;
  }
  
  public void d()
  {
    yqp.b("Q.qqstory.mediadecoderMediaDecoder", "resumeDecode");
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
    yqp.d("Q.qqstory.mediadecoderMediaDecoder", "resumeDecode failed, can not find DecodeRunnable");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qg.video.videodecoder.MediaDecoder
 * JD-Core Version:    0.7.0.1
 */