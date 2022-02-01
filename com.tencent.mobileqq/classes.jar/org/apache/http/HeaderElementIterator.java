package org.apache.http;

import java.util.Iterator;

@Deprecated
public abstract interface HeaderElementIterator
  extends Iterator
{
  public abstract boolean hasNext();
  
  public abstract HeaderElement nextElement();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.HeaderElementIterator
 * JD-Core Version:    0.7.0.1
 */