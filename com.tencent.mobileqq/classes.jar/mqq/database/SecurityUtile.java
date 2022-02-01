package mqq.database;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;

class SecurityUtile
{
  private static char[] codeKey = { 0, 1, 0, 1 };
  private static int codeKeyLen = 0;
  
  public static String decode(String paramString)
  {
    return xor(paramString);
  }
  
  public static String encode(String paramString)
  {
    return xor(paramString);
  }
  
  public static void setKey(Context paramContext)
  {
    localObject = null;
    if (0 != 0) {
      throw new NullPointerException();
    }
    try
    {
      str = ((TelephonyManager)paramContext.getApplicationContext().getSystemService("phone")).getDeviceId();
      if (str != null)
      {
        localObject = str;
        if (str.length() >= codeKey.length) {
          break label106;
        }
      }
      localObject = str;
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getMacAddress();
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        String str;
        paramContext = (Context)localObject;
        continue;
        paramContext = str;
      }
    }
    if (paramContext != null)
    {
      localObject = paramContext;
      if (paramContext.length() >= codeKey.length) {}
    }
    else
    {
      localObject = "361910168";
    }
    codeKey = ((String)localObject).toCharArray();
    codeKeyLen = codeKey.length;
  }
  
  private static String xor(String paramString)
  {
    int i = 0;
    int j = 0;
    if (paramString == null) {
      return null;
    }
    paramString = paramString.toCharArray();
    char[] arrayOfChar = new char[paramString.length];
    if (codeKeyLen >= paramString.length)
    {
      i = j;
      while (i < paramString.length)
      {
        arrayOfChar[i] = ((char)(paramString[i] ^ codeKey[i]));
        i += 1;
      }
    }
    while (i < paramString.length)
    {
      arrayOfChar[i] = ((char)(paramString[i] ^ codeKey[(i % codeKeyLen)]));
      i += 1;
    }
    if (arrayOfChar.length == 0) {
      return "";
    }
    return new String(arrayOfChar);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.database.SecurityUtile
 * JD-Core Version:    0.7.0.1
 */