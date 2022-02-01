package org.apache.http;

import java.util.Iterator;

@Deprecated
public abstract interface HeaderIterator
  extends Iterator
{
  public abstract boolean hasNext();
  
  public abstract Header nextHeader();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.HeaderIterator
 * JD-Core Version:    0.7.0.1
 */