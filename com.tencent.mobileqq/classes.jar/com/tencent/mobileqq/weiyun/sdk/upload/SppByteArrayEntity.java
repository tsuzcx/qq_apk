package com.tencent.mobileqq.weiyun.sdk.upload;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.entity.ByteArrayEntity;

public class SppByteArrayEntity
  extends ByteArrayEntity
{
  protected final int a;
  protected final int b;
  
  public SppByteArrayEntity(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    super(paramArrayOfByte);
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public InputStream getContent()
  {
    return new ByteArrayInputStream(this.content, this.a, this.b);
  }
  
  public long getContentLength()
  {
    return this.b;
  }
  
  public void writeTo(OutputStream paramOutputStream)
  {
    if (paramOutputStream != null)
    {
      paramOutputStream.write(this.content, this.a, this.b);
      paramOutputStream.flush();
      return;
    }
    throw new IllegalArgumentException("Output stream may not be null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.sdk.upload.SppByteArrayEntity
 * JD-Core Version:    0.7.0.1
 */