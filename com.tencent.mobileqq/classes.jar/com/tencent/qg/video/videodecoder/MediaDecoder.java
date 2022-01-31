package com.tencent.qg.video.videodecoder;

import bfto;
import bftr;
import bfts;
import bftt;
import bftu;
import bftv;
import bnjc;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder;
import wsv;

public class MediaDecoder
{
  private volatile long jdField_a_of_type_Long = -1L;
  private final bfto jdField_a_of_type_Bfto;
  private bfts jdField_a_of_type_Bfts;
  private final bftt jdField_a_of_type_Bftt;
  private bftv jdField_a_of_type_Bftv;
  private MediaDecoder.DecodeRunnable jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeRunnable;
  private Thread jdField_a_of_type_JavaLangThread;
  private final boolean jdField_a_of_type_Boolean;
  private boolean b = true;
  private volatile boolean c;
  private volatile boolean d;
  private volatile boolean e;
  
  public MediaDecoder(String paramString, int paramInt1, bftv parambftv, boolean paramBoolean, int paramInt2)
  {
    wsv.a("Q.qqstory.mediadecoderMediaDecoder", "Construct MediaDecoder , src = %s , supportMusic = %s", paramString, Boolean.valueOf(paramBoolean));
    this.jdField_a_of_type_Bfts = new bfts();
    this.jdField_a_of_type_Bfts.jdField_a_of_type_Long = paramInt2;
    this.jdField_a_of_type_Boolean = paramBoolean;
    bftr localbftr = new bftr();
    localbftr.jdField_a_of_type_JavaLangString = "video/";
    localbftr.b = paramString;
    this.jdField_a_of_type_Bftt = new bftt(this.jdField_a_of_type_Bfts, localbftr, paramInt1, new bftu(this, parambftv));
    bnjc localbnjc;
    if (this.jdField_a_of_type_Boolean)
    {
      localbftr = new bftr();
      localbftr.jdField_a_of_type_JavaLangString = "audio/";
      localbftr.b = paramString;
      localbnjc = new bnjc();
      localbnjc.jdField_a_of_type_JavaLangString = paramString;
      localbnjc.jdField_a_of_type_Azfn = AudioEncoder.a(paramString, null, 0);
    }
    for (this.jdField_a_of_type_Bfto = new bfto(this.jdField_a_of_type_Bfts, localbftr, localbnjc);; this.jdField_a_of_type_Bfto = null)
    {
      this.jdField_a_of_type_Bftv = parambftv;
      this.jdField_a_of_type_Bftt.a(parambftv);
      return;
    }
  }
  
  private boolean d()
  {
    return (this.jdField_a_of_type_Boolean) && (this.b);
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Bftt.a() / 1000L;
  }
  
  public void a()
  {
    wsv.b("Q.qqstory.mediadecoderMediaDecoder", "start decode");
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
    wsv.b("Q.qqstory.mediadecoderMediaDecoder", "stopDecode");
    this.e = false;
    if (this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeRunnable != null)
    {
      this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeRunnable.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeRunnable = null;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Bfts.jdField_a_of_type_Boolean = paramBoolean;
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
    wsv.b("Q.qqstory.mediadecoderMediaDecoder", "pauseDecode");
    if (this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeRunnable != null)
    {
      this.d = true;
      return;
    }
    wsv.d("Q.qqstory.mediadecoderMediaDecoder", "pauseDecode failed, can not find DecodeRunnable");
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Bfts.jdField_a_of_type_Boolean;
  }
  
  public void d()
  {
    wsv.b("Q.qqstory.mediadecoderMediaDecoder", "resumeDecode");
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
    wsv.d("Q.qqstory.mediadecoderMediaDecoder", "resumeDecode failed, can not find DecodeRunnable");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qg.video.videodecoder.MediaDecoder
 * JD-Core Version:    0.7.0.1
 */