package org.apache.http.impl;

import java.util.Locale;
import org.apache.http.ReasonPhraseCatalog;

@Deprecated
public class EnglishReasonPhraseCatalog
  implements ReasonPhraseCatalog
{
  public static final EnglishReasonPhraseCatalog INSTANCE;
  
  protected EnglishReasonPhraseCatalog()
  {
    throw new RuntimeException("Stub!");
  }
  
  public String getReason(int paramInt, Locale paramLocale)
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.impl.EnglishReasonPhraseCatalog
 * JD-Core Version:    0.7.0.1
 */