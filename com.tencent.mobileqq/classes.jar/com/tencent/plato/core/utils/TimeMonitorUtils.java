package com.tencent.plato.core.utils;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class TimeMonitorUtils
{
  public static final String DEFAULT_STEP_NAME = "innerTag:";
  public static final String STEP_BRIDGE_TO_MAIN_END = "bridge_to_main_end";
  public static final String STEP_BRIDGE_TO_MAIN_START = "bridge_to_main_start";
  public static final String STEP_JS_END = "js_end";
  public static final String STEP_JS_START = "js_start";
  public static final String STEP_LAYOUT_END = "layout_end";
  public static final String STEP_LAYOUT_START = "layout_start";
  public static final String STEP_OP_END = "op_end";
  public static final String STEP_OP_START = "op_start";
  public static final String STEP_RENDER_END = "render_end";
  public static final String STEP_RENDER_START = "render_start";
  public static final String TIME_MONITOR_TAG = "TimeMonitor";
  private static long innerTagCount = 0L;
  private static String mMonitorName = null;
  private ConcurrentHashMap<String, ConcurrentHashMap<String, Long>> timeRecoards = new ConcurrentHashMap();
  
  public static TimeMonitorUtils getInstance()
  {
    return TimeMonitorInstance.instance;
  }
  
  public void clearMonitorName()
  {
    mMonitorName = null;
  }
  
  public void clearStepTime()
  {
    if ((this.timeRecoards != null) && (this.timeRecoards.contains(getMonitorName()))) {
      this.timeRecoards.remove(getMonitorName());
    }
  }
  
  public String getInnerTag()
  {
    String str = "innerTag:" + innerTagCount;
    if (innerTagCount == 9223372036854775807L)
    {
      innerTagCount = 0L;
      return str;
    }
    innerTagCount += 1L;
    return str;
  }
  
  public String getMonitorName()
  {
    if (mMonitorName == null) {
      mMonitorName = getInstance().getInnerTag();
    }
    return mMonitorName;
  }
  
  public Map<String, Long> getTimeCost(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if ((!TextUtils.isEmpty(paramString)) && (this.timeRecoards != null) && (this.timeRecoards.containsKey(paramString)))
    {
      paramString = (ConcurrentHashMap)this.timeRecoards.get(paramString);
      long l6 = 0L;
      long l7 = 0L;
      long l4 = 0L;
      long l5 = 0L;
      long l2 = 0L;
      long l3 = 0L;
      Iterator localIterator = paramString.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        long l1 = ((Long)paramString.get(str)).longValue();
        int i = -1;
        switch (str.hashCode())
        {
        }
        for (;;)
        {
          switch (i)
          {
          default: 
            break;
          case 0: 
            l6 = l1;
            break;
            if (str.equals("js_start"))
            {
              i = 0;
              continue;
              if (str.equals("js_end"))
              {
                i = 1;
                continue;
                if (str.equals("layout_start"))
                {
                  i = 2;
                  continue;
                  if (str.equals("layout_end"))
                  {
                    i = 3;
                    continue;
                    if (str.equals("render_start"))
                    {
                      i = 4;
                      continue;
                      if (str.equals("render_end")) {
                        i = 5;
                      }
                    }
                  }
                }
              }
            }
            break;
          }
        }
        l7 = l1;
        continue;
        l4 = l1;
        continue;
        l5 = l1;
        continue;
        l2 = l1;
        continue;
        l3 = l1;
      }
      localHashMap.put("timecost_dom", Long.valueOf(l7 - l6));
      localHashMap.put("timecost_layout", Long.valueOf(l5 - l4));
      localHashMap.put("timecost_render", Long.valueOf(l3 - l2));
      localHashMap.put("timecost_total", Long.valueOf(l3 - l6));
    }
    return localHashMap;
  }
  
  public void printMonitorTime(String paramString)
  {
    if ((this.timeRecoards != null) && (this.timeRecoards.containsKey(paramString)))
    {
      Iterator localIterator1 = this.timeRecoards.keySet().iterator();
      while (localIterator1.hasNext())
      {
        Object localObject = (String)localIterator1.next();
        if (((String)localObject).equals(paramString))
        {
          localObject = (ConcurrentHashMap)this.timeRecoards.get(localObject);
          long l10 = 0L;
          long l11 = 0L;
          long l8 = 0L;
          long l9 = 0L;
          long l6 = 0L;
          long l7 = 0L;
          long l2 = 0L;
          long l3 = 0L;
          long l4 = 0L;
          long l5 = 0L;
          Iterator localIterator2 = ((ConcurrentHashMap)localObject).keySet().iterator();
          while (localIterator2.hasNext())
          {
            String str = (String)localIterator2.next();
            long l1 = ((Long)((ConcurrentHashMap)localObject).get(str)).longValue();
            int i = -1;
            switch (str.hashCode())
            {
            }
            for (;;)
            {
              switch (i)
              {
              default: 
                break;
              case 0: 
                l10 = l1;
                break;
                if (str.equals("js_start"))
                {
                  i = 0;
                  continue;
                  if (str.equals("js_end"))
                  {
                    i = 1;
                    continue;
                    if (str.equals("layout_start"))
                    {
                      i = 2;
                      continue;
                      if (str.equals("layout_end"))
                      {
                        i = 3;
                        continue;
                        if (str.equals("op_start"))
                        {
                          i = 4;
                          continue;
                          if (str.equals("op_end"))
                          {
                            i = 5;
                            continue;
                            if (str.equals("bridge_to_main_start"))
                            {
                              i = 6;
                              continue;
                              if (str.equals("bridge_to_main_end"))
                              {
                                i = 7;
                                continue;
                                if (str.equals("render_start"))
                                {
                                  i = 8;
                                  continue;
                                  if (str.equals("render_end")) {
                                    i = 9;
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
                break;
              }
            }
            l11 = l1;
            continue;
            l8 = l1;
            continue;
            l9 = l1;
            continue;
            l6 = l1;
            continue;
            l7 = l1;
            continue;
            l2 = l1;
            continue;
            l3 = l1;
            continue;
            l4 = l1;
            continue;
            l5 = l1;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(" perf log -- #").append(paramString).append("#").append("\r\n");
          ((StringBuilder)localObject).append("total:").append(l5 - l10).append(",").append("\r\n");
          ((StringBuilder)localObject).append("{").append("\r\n");
          ((StringBuilder)localObject).append("js+dom:").append(l11 - l10).append(",").append("\r\n");
          ((StringBuilder)localObject).append("layout:").append(l9 - l8).append(",").append("\r\n");
          ((StringBuilder)localObject).append("collectblock:").append(l7 - l6).append(",").append("\r\n");
          ((StringBuilder)localObject).append("disp(bridge -> main):").append(l3 - l2).append(",").append("\r\n");
          ((StringBuilder)localObject).append("render:").append(l5 - l4).append(",").append("\r\n");
          ((StringBuilder)localObject).append("},").append("\r\n");
          ((StringBuilder)localObject).append("startTimeStamp:").append(l10).append(",").append("\r\n");
          ((StringBuilder)localObject).append("endTimeStamp:").append(l5);
          PLog.e("TimeMonitor", ((StringBuilder)localObject).toString());
        }
      }
      this.timeRecoards.remove(paramString);
    }
  }
  
  public void saveStepTime(String paramString, long paramLong)
  {
    saveStepTime(null, paramString, paramLong);
  }
  
  public void saveStepTime(String paramString1, String paramString2, long paramLong)
  {
    String str;
    if (this.timeRecoards != null)
    {
      str = paramString1;
      if (paramString1 == null) {
        str = getMonitorName();
      }
      if (this.timeRecoards.containsKey(str))
      {
        paramString1 = (ConcurrentHashMap)this.timeRecoards.get(str);
        if (paramString1 != null) {
          paramString1.put(paramString2, Long.valueOf(paramLong));
        }
      }
    }
    else
    {
      return;
    }
    paramString1 = new ConcurrentHashMap();
    paramString1.put(paramString2, Long.valueOf(paramLong));
    this.timeRecoards.put(str, paramString1);
  }
  
  public void setTimeMonitorName(String paramString)
  {
    mMonitorName = paramString;
  }
  
  private static class TimeMonitorInstance
  {
    private static final TimeMonitorUtils instance = new TimeMonitorUtils(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.core.utils.TimeMonitorUtils
 * JD-Core Version:    0.7.0.1
 */