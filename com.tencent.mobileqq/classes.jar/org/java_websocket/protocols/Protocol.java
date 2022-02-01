package org.java_websocket.protocols;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Protocol
  implements IProtocol
{
  private static final Pattern patternComma = Pattern.compile(",");
  private static final Pattern patternSpace = Pattern.compile(" ");
  private final String providedProtocol;
  
  public Protocol(String paramString)
  {
    if (paramString != null)
    {
      this.providedProtocol = paramString;
      return;
    }
    throw new IllegalArgumentException();
  }
  
  public boolean acceptProvidedProtocol(String paramString)
  {
    paramString = patternSpace.matcher(paramString).replaceAll("");
    paramString = patternComma.split(paramString);
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramString[i];
      if (this.providedProtocol.equals(localObject)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public IProtocol copyInstance()
  {
    return new Protocol(getProvidedProtocol());
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      paramObject = (Protocol)paramObject;
      return this.providedProtocol.equals(paramObject.providedProtocol);
    }
    return false;
  }
  
  public String getProvidedProtocol()
  {
    return this.providedProtocol;
  }
  
  public int hashCode()
  {
    return this.providedProtocol.hashCode();
  }
  
  public String toString()
  {
    return getProvidedProtocol();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     org.java_websocket.protocols.Protocol
 * JD-Core Version:    0.7.0.1
 */