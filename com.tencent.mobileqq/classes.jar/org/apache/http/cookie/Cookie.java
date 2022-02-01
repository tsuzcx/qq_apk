package org.apache.http.cookie;

import java.util.Date;

@Deprecated
public abstract interface Cookie
{
  public abstract String getComment();
  
  public abstract String getCommentURL();
  
  public abstract String getDomain();
  
  public abstract Date getExpiryDate();
  
  public abstract String getName();
  
  public abstract String getPath();
  
  public abstract int[] getPorts();
  
  public abstract String getValue();
  
  public abstract int getVersion();
  
  public abstract boolean isExpired(Date paramDate);
  
  public abstract boolean isPersistent();
  
  public abstract boolean isSecure();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.cookie.Cookie
 * JD-Core Version:    0.7.0.1
 */