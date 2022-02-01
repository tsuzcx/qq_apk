package com.tencent.mobileqq.shortvideo.mediadevice;

import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.shortvideo.common.TCTimer;
import com.tencent.mobileqq.shortvideo.error.ErrorCenter;

public class RecordManager
{
  public static String a;
  public static RecordManager b = new RecordManager();
  private TCTimer c;
  
  private RecordManager()
  {
    a = getClass().getSimpleName();
  }
  
  public static RecordManager a()
  {
    return b;
  }
  
  public AVCodec b()
  {
    return AVCodec.get();
  }
  
  public ErrorCenter c()
  {
    return ErrorCenter.a();
  }
  
  public TCTimer d()
  {
    if (this.c == null) {
      this.c = new TCTimer(40, CodecParam.RECORD_MAX_TIME);
    }
    return this.c;
  }
  
  public void e()
  {
    this.c = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.RecordManager
 * JD-Core Version:    0.7.0.1
 */