package com.tencent.tfm.metrics.bean;

import com.tencent.tfm.metrics.StatValue;
import com.tencent.tfm.metrics.api.MetricsLogBean;
import com.tencent.tfm.metrics.api.MetricsLogBean.Content;
import com.tencent.tfm.metrics.api.MetricsLogBean.Log;
import com.tencent.tfm.metrics.api.MetricsLogBean.Value;
import com.tencent.tfm.metrics.api.StatPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class BeanConvert
{
  public static MetricsLogBean convert2UploadBean(Map<String, Map<String, LogItem>> paramMap)
  {
    if (paramMap == null) {
      return null;
    }
    MetricsLogBean localMetricsLogBean = new MetricsLogBean();
    localMetricsLogBean.log = new ArrayList();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (((Map)localEntry.getValue()).size() > 0) {
        localMetricsLogBean.log.add(convertLog(localEntry));
      }
    }
    return localMetricsLogBean;
  }
  
  private static MetricsLogBean.Content convertContent(LogItem paramLogItem)
  {
    MetricsLogBean.Content localContent = new MetricsLogBean.Content();
    localContent.dimensions = Arrays.asList(paramLogItem.dimensions);
    localContent.time = paramLogItem.timestamp;
    localContent.values = new ArrayList();
    paramLogItem = paramLogItem.values;
    int j = paramLogItem.length;
    int i = 0;
    while (i < j)
    {
      StatValue localStatValue = paramLogItem[i];
      localContent.values.add(convertValue(localStatValue));
      i += 1;
    }
    return localContent;
  }
  
  private static MetricsLogBean.Log convertLog(Map.Entry<String, Map<String, LogItem>> paramEntry)
  {
    MetricsLogBean.Log localLog = new MetricsLogBean.Log();
    localLog.logname = ((String)paramEntry.getKey());
    localLog.content = new ArrayList();
    paramEntry = ((Map)paramEntry.getValue()).values().iterator();
    while (paramEntry.hasNext())
    {
      LogItem localLogItem = (LogItem)paramEntry.next();
      localLog.content.add(convertContent(localLogItem));
    }
    return localLog;
  }
  
  private static MetricsLogBean.Value convertValue(StatValue paramStatValue)
  {
    MetricsLogBean.Value localValue = new MetricsLogBean.Value();
    localValue.count = paramStatValue.count;
    localValue.policy = paramStatValue.policy.name();
    localValue.value = paramStatValue.value;
    return localValue;
  }
  
  public static boolean mergeLogItem(LogItem paramLogItem1, LogItem paramLogItem2)
  {
    if (paramLogItem1 != null)
    {
      if (paramLogItem2 == null) {
        return false;
      }
      if (paramLogItem1.name.equals(paramLogItem2.name))
      {
        if (paramLogItem2.values.length != paramLogItem1.values.length) {
          return false;
        }
        int i = 0;
        while (i < paramLogItem1.values.length)
        {
          StatValue localStatValue1 = paramLogItem1.values[i];
          StatValue localStatValue2 = paramLogItem2.values[i];
          if (localStatValue1.policy != localStatValue2.policy) {
            return false;
          }
          int j = BeanConvert.1.$SwitchMap$com$tencent$tfm$metrics$api$StatPolicy[localStatValue1.policy.ordinal()];
          if ((j != 1) && (j != 2))
          {
            if (j != 3)
            {
              if (j != 4)
              {
                if (j == 5) {
                  localStatValue1.value = localStatValue2.value;
                }
              }
              else if (localStatValue1.value > localStatValue2.value) {
                localStatValue1.value = localStatValue2.value;
              }
            }
            else if (localStatValue1.value < localStatValue2.value) {
              localStatValue1.value = localStatValue2.value;
            }
          }
          else {
            localStatValue1.value += localStatValue2.value;
          }
          localStatValue1.count += localStatValue2.count;
          i += 1;
        }
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tfm.metrics.bean.BeanConvert
 * JD-Core Version:    0.7.0.1
 */