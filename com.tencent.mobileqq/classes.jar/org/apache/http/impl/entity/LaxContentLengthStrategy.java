package org.apache.http.impl.entity;

import org.apache.http.HttpMessage;
import org.apache.http.entity.ContentLengthStrategy;

@Deprecated
public class LaxContentLengthStrategy
  implements ContentLengthStrategy
{
  public LaxContentLengthStrategy()
  {
    throw new RuntimeException("Stub!");
  }
  
  public long determineLength(HttpMessage paramHttpMessage)
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.impl.entity.LaxContentLengthStrategy
 * JD-Core Version:    0.7.0.1
 */