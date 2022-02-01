package com.tencent.qqlive.module.videoreport.dtreport.verifydata;

import android.util.Pair;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class VerifyDataHelper
{
  private static final String KEEP_FIELD_A = "^[Aa][0-9].*";
  private static final String KEEP_FIELD_DT = "dt_";
  private static final String KEEP_FIELD_RQD = "rqd_";
  private static final String TAG = "DT_DataCheck";
  public static final String WARNING = " 参数key不能为空，且不能以^[Aa][0-9].*, dt_, rqd_开头";
  
  public static void checkMap(Map<String, ?> paramMap)
  {
    paramMap = isValidMap(paramMap);
    if (!((Boolean)paramMap.second).booleanValue())
    {
      paramMap = (String)paramMap.first;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("invalid input key:");
      localStringBuilder.append(paramMap);
      localStringBuilder.append(",");
      localStringBuilder.append(" 参数key不能为空，且不能以^[Aa][0-9].*, dt_, rqd_开头");
      doCrash(localStringBuilder.toString());
    }
  }
  
  private static void doCrash(String paramString)
  {
    if (!VideoReport.isDebugMode()) {
      return;
    }
    Log.e("DT_DataCheck", paramString);
    throw new RuntimeException(paramString);
  }
  
  private static boolean isValidKey(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return false;
      }
      bool1 = bool2;
      if (!paramString.startsWith("dt_"))
      {
        bool1 = bool2;
        if (!paramString.startsWith("rqd_"))
        {
          bool1 = bool2;
          if (!Pattern.matches("^[Aa][0-9].*", paramString)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private static Pair<String, Boolean> isValidMap(Map<String, ?> paramMap)
  {
    Boolean localBoolean = Boolean.valueOf(false);
    if (paramMap == null) {
      return new Pair("map is null", localBoolean);
    }
    if (paramMap.size() > 0)
    {
      paramMap = paramMap.keySet().iterator();
      while (paramMap.hasNext())
      {
        String str = (String)paramMap.next();
        if (!isValidKey(str)) {
          return new Pair(str, localBoolean);
        }
      }
    }
    return new Pair("", Boolean.valueOf(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.verifydata.VerifyDataHelper
 * JD-Core Version:    0.7.0.1
 */