package org.hamcrest;

import java.io.IOException;

public class StringDescription
  extends BaseDescription
{
  private final Appendable out;
  
  public StringDescription()
  {
    this(new StringBuilder());
  }
  
  public StringDescription(Appendable paramAppendable)
  {
    this.out = paramAppendable;
  }
  
  public static String asString(SelfDescribing paramSelfDescribing)
  {
    return toString(paramSelfDescribing);
  }
  
  public static String toString(SelfDescribing paramSelfDescribing)
  {
    return new StringDescription().appendDescriptionOf(paramSelfDescribing).toString();
  }
  
  protected void append(char paramChar)
  {
    try
    {
      this.out.append(paramChar);
      return;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException("Could not write description", localIOException);
    }
  }
  
  protected void append(String paramString)
  {
    try
    {
      this.out.append(paramString);
      return;
    }
    catch (IOException paramString)
    {
      throw new RuntimeException("Could not write description", paramString);
    }
  }
  
  public String toString()
  {
    return this.out.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     org.hamcrest.StringDescription
 * JD-Core Version:    0.7.0.1
 */