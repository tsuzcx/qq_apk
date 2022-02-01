package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.os.SystemClock;

public class ReadInJoyWebRenderEngine$RenderHtmlData
{
  public final String a;
  public final String b;
  final long c;
  long d;
  
  ReadInJoyWebRenderEngine$RenderHtmlData(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = SystemClock.elapsedRealtime();
  }
  
  ReadInJoyWebRenderEngine$RenderHtmlData(String paramString1, String paramString2, long paramLong)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = SystemClock.elapsedRealtime();
    this.d = paramLong;
  }
  
  boolean a()
  {
    if (this.d > 0L) {
      return SystemClock.elapsedRealtime() - this.c > this.d;
    }
    return SystemClock.elapsedRealtime() - this.c > 300000L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyWebRenderEngine.RenderHtmlData
 * JD-Core Version:    0.7.0.1
 */