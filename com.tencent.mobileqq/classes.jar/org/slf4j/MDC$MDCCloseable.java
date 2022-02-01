package org.slf4j;

import java.io.Closeable;

public class MDC$MDCCloseable
  implements Closeable
{
  private final String key;
  
  private MDC$MDCCloseable(String paramString)
  {
    this.key = paramString;
  }
  
  public void close()
  {
    MDC.remove(this.key);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.slf4j.MDC.MDCCloseable
 * JD-Core Version:    0.7.0.1
 */