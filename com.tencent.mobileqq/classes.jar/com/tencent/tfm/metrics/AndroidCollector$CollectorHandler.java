package com.tencent.tfm.metrics;

import android.os.Handler;
import android.os.Message;
import com.tencent.tfm.metrics.api.MetricsLogBean;
import com.tencent.tfm.metrics.api.Reporter;
import com.tencent.tfm.metrics.bean.BeanConvert;
import com.tencent.tfm.metrics.bean.LogItem;
import com.tencent.tfm.metrics.utils.ELog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class AndroidCollector$CollectorHandler
  extends Handler
{
  private Map<String, Map<String, LogItem>> logMergeMap = new HashMap();
  
  AndroidCollector$CollectorHandler(AndroidCollector paramAndroidCollector) {}
  
  private void pushLog(LogItem paramLogItem)
  {
    Object localObject = (Map)this.logMergeMap.get(paramLogItem.name);
    if (localObject == null)
    {
      localObject = new HashMap();
      this.logMergeMap.put(paramLogItem.name, localObject);
    }
    for (;;)
    {
      String str = paramLogItem.getAggregationKey();
      LogItem localLogItem = (LogItem)((Map)localObject).get(str);
      if (localLogItem == null)
      {
        ((Map)localObject).put(str, paramLogItem);
        return;
      }
      if (BeanConvert.mergeLogItem(localLogItem, paramLogItem))
      {
        localLogItem.timestamp = paramLogItem.timestamp;
        return;
      }
      ((Map)localObject).remove(str);
      ELog.warn("merge stat log failed, removed stat log of %s: %s", new Object[] { paramLogItem.name, str });
      return;
    }
  }
  
  private void report()
  {
    Object localObject = BeanConvert.convert2UploadBean(this.logMergeMap);
    if ((AndroidCollector.access$200(this.this$0) != null) && (((MetricsLogBean)localObject).log.size() > 0)) {
      AndroidCollector.access$200(this.this$0).report((MetricsLogBean)localObject);
    }
    localObject = this.logMergeMap.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((Map)((Iterator)localObject).next()).clear();
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      pushLog((LogItem)paramMessage.obj);
      return;
    }
    report();
    removeMessages(1);
    sendEmptyMessageDelayed(1, AndroidCollector.access$100(this.this$0));
  }
  
  public void schedule()
  {
    sendEmptyMessageDelayed(1, AndroidCollector.access$100(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tfm.metrics.AndroidCollector.CollectorHandler
 * JD-Core Version:    0.7.0.1
 */