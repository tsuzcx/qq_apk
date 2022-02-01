package org.apache.http.entity;

import java.io.OutputStream;

@Deprecated
public abstract interface ContentProducer
{
  public abstract void writeTo(OutputStream paramOutputStream);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.entity.ContentProducer
 * JD-Core Version:    0.7.0.1
 */