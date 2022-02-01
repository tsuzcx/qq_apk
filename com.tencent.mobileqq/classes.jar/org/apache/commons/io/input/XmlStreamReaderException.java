package org.apache.commons.io.input;

import java.io.IOException;

public class XmlStreamReaderException
  extends IOException
{
  private static final long serialVersionUID = 1L;
  private final String bomEncoding;
  private final String contentTypeEncoding;
  private final String contentTypeMime;
  private final String xmlEncoding;
  private final String xmlGuessEncoding;
  
  public XmlStreamReaderException(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this(paramString1, null, null, paramString2, paramString3, paramString4);
  }
  
  public XmlStreamReaderException(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    super(paramString1);
    this.contentTypeMime = paramString2;
    this.contentTypeEncoding = paramString3;
    this.bomEncoding = paramString4;
    this.xmlGuessEncoding = paramString5;
    this.xmlEncoding = paramString6;
  }
  
  public String getBomEncoding()
  {
    return this.bomEncoding;
  }
  
  public String getContentTypeEncoding()
  {
    return this.contentTypeEncoding;
  }
  
  public String getContentTypeMime()
  {
    return this.contentTypeMime;
  }
  
  public String getXmlEncoding()
  {
    return this.xmlEncoding;
  }
  
  public String getXmlGuessEncoding()
  {
    return this.xmlGuessEncoding;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.apache.commons.io.input.XmlStreamReaderException
 * JD-Core Version:    0.7.0.1
 */