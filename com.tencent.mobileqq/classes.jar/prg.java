import android.text.TextUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import java.io.IOException;
import java.io.StringReader;
import java.math.BigInteger;
import java.util.Properties;

public class prg
{
  private static final BigInteger a = BigInteger.ONE.shiftLeft(64);
  
  public static String a(long paramLong)
  {
    long l = (paramLong >>> 1) / 5L;
    return Long.toString(l) + (paramLong - 10L * l);
  }
  
  public static String a(String paramString)
  {
    if (DeviceInfoUtil.getPortraitHeight() > 720L) {
      return a(paramString, 18);
    }
    return a(paramString, 24);
  }
  
  public static String a(String paramString, int paramInt)
  {
    String str = paramString;
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      i = 0;
      j = 0;
      if (i >= paramString.length()) {
        break label143;
      }
      int k = paramString.charAt(i);
      if (((97 > k) || (k > 122)) && ((65 > k) || (k > 90)) && ((48 > k) || (k > 57))) {
        break label129;
      }
      j += 1;
      label75:
      if (j <= paramInt) {
        break label136;
      }
    }
    label129:
    label136:
    label143:
    for (int j = 1;; j = 0)
    {
      str = paramString;
      if (j != 0)
      {
        j = i;
        if (i == paramInt) {
          j = i - 1;
        }
        str = paramString.substring(0, j) + "…";
      }
      return str;
      j += 2;
      break label75;
      i += 1;
      break;
    }
  }
  
  public static BigInteger a(long paramLong)
  {
    BigInteger localBigInteger = BigInteger.valueOf(paramLong);
    if (paramLong >= 0L) {
      return localBigInteger;
    }
    return localBigInteger.add(a);
  }
  
  public static Properties a(String paramString)
  {
    Properties localProperties = new Properties();
    try
    {
      localProperties.load(new StringReader(paramString));
      return localProperties;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     prg
 * JD-Core Version:    0.7.0.1
 */