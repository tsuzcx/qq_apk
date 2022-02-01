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
    if ((paramLogItem1 == null) || (paramLogItem2 == null)) {}
    int i;
    StatValue localStatValue1;
    StatValue localStatValue2;
    do
    {
      do
      {
        return false;
      } while ((!paramLogItem1.name.equals(paramLogItem2.name)) || (paramLogItem2.values.length != paramLogItem1.values.length));
      i = 0;
      if (i >= paramLogItem1.values.length) {
        break;
      }
      localStatValue1 = paramLogItem1.values[i];
      localStatValue2 = paramLogItem2.values[i];
    } while (localStatValue1.policy != localStatValue2.policy);
    switch (BeanConvert.1.$SwitchMap$com$tencent$tfm$metrics$api$StatPolicy[localStatValue1.policy.ordinal()])
    {
    }
    for (;;)
    {
      int j = localStatValue1.count;
      localStatValue2.count += j;
      i += 1;
      break;
      localStatValue1.value += localStatValue2.value;
      continue;
      if (localStatValue1.value < localStatValue2.value)
      {
        localStatValue1.value = localStatValue2.value;
        continue;
        if (localStatValue1.value > localStatValue2.value)
        {
          localStatValue1.value = localStatValue2.value;
          continue;
          localStatValue1.value = localStatValue2.value;
        }
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tfm.metrics.bean.BeanConvert
 * JD-Core Version:    0.7.0.1
 */