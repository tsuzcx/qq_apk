package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.os.SystemClock;

public class ReadInJoyWebRenderEngine$RenderHtmlData
{
  final long a;
  public final String a;
  long b;
  public final String b;
  
  ReadInJoyWebRenderEngine$RenderHtmlData(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
  }
  
  ReadInJoyWebRenderEngine$RenderHtmlData(String paramString1, String paramString2, long paramLong)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    this.jdField_b_of_type_Long = paramLong;
  }
  
  boolean a()
  {
    if (this.jdField_b_of_type_Long > 0L) {
      return SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long > this.jdField_b_of_type_Long;
    }
    return SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long > 300000L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyWebRenderEngine.RenderHtmlData
 * JD-Core Version:    0.7.0.1
 */