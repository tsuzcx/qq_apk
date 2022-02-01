package org.apache.commons.lang;

import java.util.Arrays;

public class IncompleteArgumentException
  extends IllegalArgumentException
{
  private static final long serialVersionUID = 4954193403612068178L;
  
  public IncompleteArgumentException(String paramString)
  {
    super(localStringBuffer.toString());
  }
  
  public IncompleteArgumentException(String paramString, String[] paramArrayOfString)
  {
    super(localStringBuffer.toString());
  }
  
  private static final String safeArrayToString(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject == null) {
      return null;
    }
    return Arrays.asList(paramArrayOfObject).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.IncompleteArgumentException
 * JD-Core Version:    0.7.0.1
 */