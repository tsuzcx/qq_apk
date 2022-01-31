package com.tencent.plato.mqq.network;

import alkd;
import android.support.annotation.Nullable;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.ResponseBody;
import java.io.IOException;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;

public class ProgressResponseBody
  extends ResponseBody
{
  private long jdField_a_of_type_Long;
  private final ResponseBody jdField_a_of_type_ComSquareupOkhttpResponseBody;
  private final ProgressListener jdField_a_of_type_ComTencentPlatoMqqNetworkProgressListener;
  @Nullable
  private BufferedSource jdField_a_of_type_OkioBufferedSource;
  
  private Source a(Source paramSource)
  {
    return new alkd(this, paramSource);
  }
  
  public long contentLength()
  {
    try
    {
      long l = this.jdField_a_of_type_ComSquareupOkhttpResponseBody.contentLength();
      return l;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return 0L;
  }
  
  public MediaType contentType()
  {
    return this.jdField_a_of_type_ComSquareupOkhttpResponseBody.contentType();
  }
  
  public BufferedSource source()
  {
    if (this.jdField_a_of_type_OkioBufferedSource == null) {}
    try
    {
      this.jdField_a_of_type_OkioBufferedSource = Okio.buffer(a(this.jdField_a_of_type_ComSquareupOkhttpResponseBody.source()));
      return this.jdField_a_of_type_OkioBufferedSource;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.plato.mqq.network.ProgressResponseBody
 * JD-Core Version:    0.7.0.1
 */