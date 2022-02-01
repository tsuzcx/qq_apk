package cooperation.qqcircle.report.dengta;

import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import java.util.HashMap;
import java.util.Set;

public class QCircleDengTaUtil
{
  public static void dumpParams(String paramString, HashMap<String, String> paramHashMap)
  {
    if ((paramHashMap != null) && (paramHashMap.keySet().size() == 0)) {}
  }
  
  public static int getNetType()
  {
    switch ()
    {
    default: 
      return 9;
    case 0: 
      switch (AppNetConnInfo.getMobileInfo())
      {
      default: 
        return 9;
      case 1: 
        return 2;
      case 2: 
        return 3;
      case 3: 
        return 4;
      }
      return 5;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.report.dengta.QCircleDengTaUtil
 * JD-Core Version:    0.7.0.1
 */