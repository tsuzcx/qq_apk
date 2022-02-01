package cooperation.ilive.util;

import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ElapseStat
{
  private static HashMap<String, Long> a = new HashMap();
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      a.put(paramString, Long.valueOf(System.currentTimeMillis()));
    }
  }
  
  public static void b(String paramString)
  {
    if ((QLog.isColorLevel()) && (a.containsKey(paramString)))
    {
      if (a.get(paramString) == null) {
        return;
      }
      long l = ((Long)a.get(paramString)).longValue();
      a.remove(paramString);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(" elpase:");
      localStringBuilder.append(System.currentTimeMillis() - l);
      QLog.d("ElapseStat", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.util.ElapseStat
 * JD-Core Version:    0.7.0.1
 */