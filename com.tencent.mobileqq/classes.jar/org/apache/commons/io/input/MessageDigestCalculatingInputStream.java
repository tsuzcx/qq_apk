package org.apache.commons.io.input;

import java.io.InputStream;
import java.security.MessageDigest;

public class MessageDigestCalculatingInputStream
  extends ObservableInputStream
{
  private final MessageDigest messageDigest;
  
  public MessageDigestCalculatingInputStream(InputStream paramInputStream)
  {
    this(paramInputStream, MessageDigest.getInstance("MD5"));
  }
  
  public MessageDigestCalculatingInputStream(InputStream paramInputStream, String paramString)
  {
    this(paramInputStream, MessageDigest.getInstance(paramString));
  }
  
  public MessageDigestCalculatingInputStream(InputStream paramInputStream, MessageDigest paramMessageDigest)
  {
    super(paramInputStream);
    this.messageDigest = paramMessageDigest;
    add(new MessageDigestCalculatingInputStream.MessageDigestMaintainingObserver(paramMessageDigest));
  }
  
  public MessageDigest getMessageDigest()
  {
    return this.messageDigest;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.apache.commons.io.input.MessageDigestCalculatingInputStream
 * JD-Core Version:    0.7.0.1
 */