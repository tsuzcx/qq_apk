package com.tencent.smtt.export.external.interfaces;

import java.nio.ByteBuffer;

public abstract class UrlRequest
{
  public abstract void cancel();
  
  public abstract void followRedirect();
  
  public abstract boolean isDone();
  
  public abstract void read(ByteBuffer paramByteBuffer);
  
  public abstract void start();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.export.external.interfaces.UrlRequest
 * JD-Core Version:    0.7.0.1
 */