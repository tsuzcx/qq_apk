package com.tencent.plato.mqq.network;

import alkc;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.RequestBody;
import okio.BufferedSink;
import okio.Okio;
import okio.Sink;

public class ProgressRequestBody
  extends RequestBody
{
  private final RequestBody jdField_a_of_type_ComSquareupOkhttpRequestBody;
  private final ProgressListener jdField_a_of_type_ComTencentPlatoMqqNetworkProgressListener;
  private BufferedSink jdField_a_of_type_OkioBufferedSink;
  
  private Sink a(Sink paramSink)
  {
    return new alkc(this, paramSink);
  }
  
  public long contentLength()
  {
    return this.jdField_a_of_type_ComSquareupOkhttpRequestBody.contentLength();
  }
  
  public MediaType contentType()
  {
    return this.jdField_a_of_type_ComSquareupOkhttpRequestBody.contentType();
  }
  
  public void writeTo(BufferedSink paramBufferedSink)
  {
    if (this.jdField_a_of_type_OkioBufferedSink == null) {
      this.jdField_a_of_type_OkioBufferedSink = Okio.buffer(a(paramBufferedSink));
    }
    this.jdField_a_of_type_ComSquareupOkhttpRequestBody.writeTo(this.jdField_a_of_type_OkioBufferedSink);
    this.jdField_a_of_type_OkioBufferedSink.flush();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.plato.mqq.network.ProgressRequestBody
 * JD-Core Version:    0.7.0.1
 */