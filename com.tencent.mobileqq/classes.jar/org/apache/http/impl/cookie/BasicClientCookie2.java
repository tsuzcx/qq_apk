package org.apache.http.impl.cookie;

import java.util.Date;
import org.apache.http.cookie.SetCookie2;

@Deprecated
public class BasicClientCookie2
  extends BasicClientCookie
  implements SetCookie2
{
  public BasicClientCookie2(String paramString1, String paramString2)
  {
    super(paramString1, paramString1);
    throw new RuntimeException("Stub!");
  }
  
  public Object clone()
  {
    throw new RuntimeException("Stub!");
  }
  
  public String getCommentURL()
  {
    throw new RuntimeException("Stub!");
  }
  
  public int[] getPorts()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isExpired(Date paramDate)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isPersistent()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setCommentURL(String paramString)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setDiscard(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setPorts(int[] paramArrayOfInt)
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.impl.cookie.BasicClientCookie2
 * JD-Core Version:    0.7.0.1
 */