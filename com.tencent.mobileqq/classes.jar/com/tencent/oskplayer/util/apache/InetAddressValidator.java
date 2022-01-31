package com.tencent.oskplayer.util.apache;

import java.io.Serializable;

public class InetAddressValidator
  implements Serializable
{
  private static final String IPV4_REGEX = "^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$";
  private static final InetAddressValidator VALIDATOR = new InetAddressValidator();
  private static final long serialVersionUID = -919201640201914789L;
  private final RegexValidator ipv4Validator = new RegexValidator("^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$");
  
  public static InetAddressValidator getInstance()
  {
    return VALIDATOR;
  }
  
  public boolean isValid(String paramString)
  {
    return isValidInet4Address(paramString);
  }
  
  public boolean isValidInet4Address(String paramString)
  {
    paramString = this.ipv4Validator.match(paramString);
    if (paramString == null) {}
    for (;;)
    {
      return false;
      int i = 0;
      String str;
      if (i <= 3)
      {
        str = paramString[i];
        if ((str == null) || (str.length() <= 0)) {
          continue;
        }
      }
      try
      {
        int j = Integer.parseInt(str);
        if (j <= 255) {
          i += 1;
        }
      }
      catch (NumberFormatException paramString) {}
    }
    return true;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.oskplayer.util.apache.InetAddressValidator
 * JD-Core Version:    0.7.0.1
 */