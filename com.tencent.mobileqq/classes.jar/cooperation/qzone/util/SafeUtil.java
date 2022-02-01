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
    catch (NumberFormatException localNumberFormatException)
    {
      log("toInt convert error:" + paramString);
      return 0;
    }
    catch (Exception paramString)
    {
      log("toInt convert error:" + paramString.getMessage());
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.util.SafeUtil
 * JD-Core Version:    0.7.0.1
 */