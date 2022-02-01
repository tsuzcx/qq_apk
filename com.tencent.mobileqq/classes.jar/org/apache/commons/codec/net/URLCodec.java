package org.apache.commons.codec.net;

import java.util.BitSet;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;

@Deprecated
public class URLCodec
  implements BinaryDecoder, BinaryEncoder, StringDecoder, StringEncoder
{
  protected static byte ESCAPE_CHAR;
  protected static final BitSet WWW_FORM_URL;
  protected String charset;
  
  public URLCodec()
  {
    throw new RuntimeException("Stub!");
  }
  
  public URLCodec(String paramString)
  {
    throw new RuntimeException("Stub!");
  }
  
  public static final byte[] decodeUrl(byte[] paramArrayOfByte)
  {
    throw new RuntimeException("Stub!");
  }
  
  public static final byte[] encodeUrl(BitSet paramBitSet, byte[] paramArrayOfByte)
  {
    throw new RuntimeException("Stub!");
  }
  
  public Object decode(Object paramObject)
  {
    throw new RuntimeException("Stub!");
  }
  
  public String decode(String paramString)
  {
    throw new RuntimeException("Stub!");
  }
  
  public String decode(String paramString1, String paramString2)
  {
    throw new RuntimeException("Stub!");
  }
  
  public byte[] decode(byte[] paramArrayOfByte)
  {
    throw new RuntimeException("Stub!");
  }
  
  public Object encode(Object paramObject)
  {
    throw new RuntimeException("Stub!");
  }
  
  public String encode(String paramString)
  {
    throw new RuntimeException("Stub!");
  }
  
  public String encode(String paramString1, String paramString2)
  {
    throw new RuntimeException("Stub!");
  }
  
  public byte[] encode(byte[] paramArrayOfByte)
  {
    throw new RuntimeException("Stub!");
  }
  
  public String getDefaultCharset()
  {
    throw new RuntimeException("Stub!");
  }
  
  @Deprecated
  public String getEncoding()
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.commons.codec.net.URLCodec
 * JD-Core Version:    0.7.0.1
 */