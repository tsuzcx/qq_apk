package org.apache.http;

import org.apache.http.util.CharArrayBuffer;

@Deprecated
public abstract interface FormattedHeader
  extends Header
{
  public abstract CharArrayBuffer getBuffer();
  
  public abstract int getValuePos();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.FormattedHeader
 * JD-Core Version:    0.7.0.1
 */