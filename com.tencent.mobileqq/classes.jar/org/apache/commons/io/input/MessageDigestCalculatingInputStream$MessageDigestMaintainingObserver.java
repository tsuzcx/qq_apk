package org.apache.commons.io.input;

import java.security.MessageDigest;

public class MessageDigestCalculatingInputStream$MessageDigestMaintainingObserver
  extends ObservableInputStream.Observer
{
  private final MessageDigest md;
  
  public MessageDigestCalculatingInputStream$MessageDigestMaintainingObserver(MessageDigest paramMessageDigest)
  {
    this.md = paramMessageDigest;
  }
  
  void data(int paramInt)
  {
    this.md.update((byte)paramInt);
  }
  
  void data(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.md.update(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.input.MessageDigestCalculatingInputStream.MessageDigestMaintainingObserver
 * JD-Core Version:    0.7.0.1
 */