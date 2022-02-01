package org.apache.http.message;

import java.util.List;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;

@Deprecated
public class BasicListHeaderIterator
  implements HeaderIterator
{
  protected final List allHeaders;
  protected int currentIndex;
  protected String headerName;
  protected int lastIndex;
  
  public BasicListHeaderIterator(List paramList, String paramString)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected boolean filterHeader(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected int findNext(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean hasNext()
  {
    throw new RuntimeException("Stub!");
  }
  
  public final Object next()
  {
    throw new RuntimeException("Stub!");
  }
  
  public Header nextHeader()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void remove()
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.message.BasicListHeaderIterator
 * JD-Core Version:    0.7.0.1
 */