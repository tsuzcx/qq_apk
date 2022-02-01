package org.apache.http;

@Deprecated
public abstract interface Header
{
  public abstract HeaderElement[] getElements();
  
  public abstract String getName();
  
  public abstract String getValue();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.Header
 * JD-Core Version:    0.7.0.1
 */