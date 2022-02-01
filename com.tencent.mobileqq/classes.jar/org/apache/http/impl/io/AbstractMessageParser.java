package org.apache.http.impl.io;

import org.apache.http.Header;
import org.apache.http.HttpMessage;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.message.LineParser;
import org.apache.http.params.HttpParams;

@Deprecated
public abstract class AbstractMessageParser
  implements HttpMessageParser
{
  protected final LineParser lineParser;
  
  public AbstractMessageParser(SessionInputBuffer paramSessionInputBuffer, LineParser paramLineParser, HttpParams paramHttpParams)
  {
    throw new RuntimeException("Stub!");
  }
  
  public static Header[] parseHeaders(SessionInputBuffer paramSessionInputBuffer, int paramInt1, int paramInt2, LineParser paramLineParser)
  {
    throw new RuntimeException("Stub!");
  }
  
  public HttpMessage parse()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected abstract HttpMessage parseHead(SessionInputBuffer paramSessionInputBuffer);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.impl.io.AbstractMessageParser
 * JD-Core Version:    0.7.0.1
 */