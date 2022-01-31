package cooperation.qzone.util;

import com.tencent.qphone.base.util.QLog;

public class SafeUtil
{
  public static int a(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      a("toInt convert error:" + paramString);
      return 0;
    }
    catch (Exception paramString)
    {
      a("toInt convert error:" + paramString.getMessage());
    }
    return 0;
  }
  
  private static final void a(String paramString)
  {
    try
    {
      QLog.e("SafeUtil", 1, paramString);
      return;
    }
    catch (Exception paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.util.SafeUtil
 * JD-Core Version:    0.7.0.1
 */