package org.apache.commons.io;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LineIterator
  implements Closeable, Iterator<String>
{
  private final BufferedReader bufferedReader;
  private String cachedLine;
  private boolean finished = false;
  
  public LineIterator(Reader paramReader)
  {
    if (paramReader == null) {
      throw new IllegalArgumentException("Reader must not be null");
    }
    if ((paramReader instanceof BufferedReader))
    {
      this.bufferedReader = ((BufferedReader)paramReader);
      return;
    }
    this.bufferedReader = new BufferedReader(paramReader);
  }
  
  @Deprecated
  public static void closeQuietly(LineIterator paramLineIterator)
  {
    if (paramLineIterator != null) {}
    try
    {
      paramLineIterator.close();
      return;
    }
    catch (IOException paramLineIterator) {}
  }
  
  public void close()
  {
    this.finished = true;
    this.cachedLine = null;
    if (this.bufferedReader != null) {
      this.bufferedReader.close();
    }
  }
  
  public boolean hasNext()
  {
    if (this.cachedLine != null) {
      return true;
    }
    if (this.finished) {
      return false;
    }
    try
    {
      String str;
      do
      {
        str = this.bufferedReader.readLine();
        if (str == null)
        {
          this.finished = true;
          return false;
        }
      } while (!isValidLine(str));
      this.cachedLine = str;
      return true;
    }
    catch (IOException localIOException1) {}
    try
    {
      close();
      throw new IllegalStateException(localIOException1);
    }
    catch (IOException localIOException2)
    {
      for (;;)
      {
        localIOException1.addSuppressed(localIOException2);
      }
    }
  }
  
  protected boolean isValidLine(String paramString)
  {
    return true;
  }
  
  public String next()
  {
    return nextLine();
  }
  
  public String nextLine()
  {
    if (!hasNext()) {
      throw new NoSuchElementException("No more lines");
    }
    String str = this.cachedLine;
    this.cachedLine = null;
    return str;
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Remove unsupported on LineIterator");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.apache.commons.io.LineIterator
 * JD-Core Version:    0.7.0.1
 */