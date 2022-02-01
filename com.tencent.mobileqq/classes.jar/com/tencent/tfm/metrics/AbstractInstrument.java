package com.tencent.tfm.metrics;

import com.tencent.tfm.metrics.api.DimensionProvider;
import com.tencent.tfm.metrics.bean.LogItem;
import com.tencent.tfm.metrics.utils.StringUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractInstrument
{
  protected String name;
  
  protected AbstractInstrument(String paramString)
  {
    this.name = paramString;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  protected void record(LogItem paramLogItem)
  {
    ICollector localICollector = MetricsSDK.getInstance().getCollector();
    if (localICollector != null)
    {
      Object localObject = MetricsSDK.getInstance().getDimensionProvider();
      List localList = ((DimensionProvider)localObject).getDimensionKeys();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((DimensionProvider)localObject).getDimensionValue((String)localIterator.next()));
      }
      localArrayList.addAll(Arrays.asList(paramLogItem.dimensions));
      localObject = new String[paramLogItem.dimensions.length + localList.size()];
      localArrayList.toArray((Object[])localObject);
      paramLogItem.dimensions = ((String[])localObject);
      int i = 0;
      while (i < paramLogItem.dimensions.length)
      {
        paramLogItem.dimensions[i] = StringUtils.dealUploadValue(paramLogItem.dimensions[i]);
        i += 1;
      }
      localICollector.push(paramLogItem);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tfm.metrics.AbstractInstrument
 * JD-Core Version:    0.7.0.1
 */