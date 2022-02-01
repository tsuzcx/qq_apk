package org.apache.http.message;

import org.apache.http.HeaderIterator;
import org.apache.http.TokenIterator;

@Deprecated
public class BasicTokenIterator
  implements TokenIterator
{
  public static final String HTTP_SEPARATORS = " ,;=()<>@:\\\"/[]?{}\t";
  protected String currentHeader;
  protected String currentToken;
  protected final HeaderIterator headerIt;
  protected int searchPos;
  
  public BasicTokenIterator(HeaderIterator paramHeaderIterator)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected String createToken(String paramString, int paramInt1, int paramInt2)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected int findNext(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected int findTokenEnd(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected int findTokenSeparator(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected int findTokenStart(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean hasNext()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected boolean isHttpSeparator(char paramChar)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected boolean isTokenChar(char paramChar)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected boolean isTokenSeparator(char paramChar)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected boolean isWhitespace(char paramChar)
  {
    throw new RuntimeException("Stub!");
  }
  
  public final Object next()
  {
    throw new RuntimeException("Stub!");
  }
  
  public String nextToken()
  {
    throw new RuntimeException("Stub!");
  }
  
  public final void remove()
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.message.BasicTokenIterator
 * JD-Core Version:    0.7.0.1
 */