package cooperation.qzone.util;

import com.tencent.qphone.base.util.QLog;

public class SafeUtil
{
  private static final void log(String paramString)
  {
    try
    {
      QLog.e("SafeUtil", 1, paramString);
      return;
    }
    catch (Exception paramString) {}
  }
  
  public static int toInt(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("toInt convert error:");
      localStringBuilder.append(paramString.getMessage());
      log(localStringBuilder.toString());
      return 0;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("toInt convert error:");
      localStringBuilder.append(paramString);
      log(localStringBuilder.toString());
      return 0;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label41:
      break label41;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.util.SafeUtil
 * JD-Core Version:    0.7.0.1
 */