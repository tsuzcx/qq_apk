package org.apache.http.message;

import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.util.CharArrayBuffer;

@Deprecated
public class BasicHeaderValueFormatter
  implements HeaderValueFormatter
{
  public static final BasicHeaderValueFormatter DEFAULT;
  public static final String SEPARATORS = " ;,:@()<>\\\"/[]?={}\t";
  public static final String UNSAFE_CHARS = "\"\\";
  
  public BasicHeaderValueFormatter()
  {
    throw new RuntimeException("Stub!");
  }
  
  public static final String formatElements(HeaderElement[] paramArrayOfHeaderElement, boolean paramBoolean, HeaderValueFormatter paramHeaderValueFormatter)
  {
    throw new RuntimeException("Stub!");
  }
  
  public static final String formatHeaderElement(HeaderElement paramHeaderElement, boolean paramBoolean, HeaderValueFormatter paramHeaderValueFormatter)
  {
    throw new RuntimeException("Stub!");
  }
  
  public static final String formatNameValuePair(NameValuePair paramNameValuePair, boolean paramBoolean, HeaderValueFormatter paramHeaderValueFormatter)
  {
    throw new RuntimeException("Stub!");
  }
  
  public static final String formatParameters(NameValuePair[] paramArrayOfNameValuePair, boolean paramBoolean, HeaderValueFormatter paramHeaderValueFormatter)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void doFormatValue(CharArrayBuffer paramCharArrayBuffer, String paramString, boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected int estimateElementsLen(HeaderElement[] paramArrayOfHeaderElement)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected int estimateHeaderElementLen(HeaderElement paramHeaderElement)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected int estimateNameValuePairLen(NameValuePair paramNameValuePair)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected int estimateParametersLen(NameValuePair[] paramArrayOfNameValuePair)
  {
    throw new RuntimeException("Stub!");
  }
  
  public CharArrayBuffer formatElements(CharArrayBuffer paramCharArrayBuffer, HeaderElement[] paramArrayOfHeaderElement, boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public CharArrayBuffer formatHeaderElement(CharArrayBuffer paramCharArrayBuffer, HeaderElement paramHeaderElement, boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public CharArrayBuffer formatNameValuePair(CharArrayBuffer paramCharArrayBuffer, NameValuePair paramNameValuePair, boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public CharArrayBuffer formatParameters(CharArrayBuffer paramCharArrayBuffer, NameValuePair[] paramArrayOfNameValuePair, boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected boolean isSeparator(char paramChar)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected boolean isUnsafe(char paramChar)
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.message.BasicHeaderValueFormatter
 * JD-Core Version:    0.7.0.1
 */