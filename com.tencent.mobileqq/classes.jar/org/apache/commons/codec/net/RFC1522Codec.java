package org.apache.commons.codec.net;

@Deprecated
abstract class RFC1522Codec
{
  RFC1522Codec()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected String decodeText(String paramString)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected abstract byte[] doDecoding(byte[] paramArrayOfByte);
  
  protected abstract byte[] doEncoding(byte[] paramArrayOfByte);
  
  protected String encodeText(String paramString1, String paramString2)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected abstract String getEncoding();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.commons.codec.net.RFC1522Codec
 * JD-Core Version:    0.7.0.1
 */