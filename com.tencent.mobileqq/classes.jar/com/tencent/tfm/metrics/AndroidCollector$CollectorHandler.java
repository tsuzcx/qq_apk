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
    Object localObject2 = (Map)this.logMergeMap.get(paramLogItem.name);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new HashMap();
      this.logMergeMap.put(paramLogItem.name, localObject1);
    }
    localObject2 = paramLogItem.getAggregationKey();
    LogItem localLogItem = (LogItem)((Map)localObject1).get(localObject2);
    if (localLogItem == null)
    {
      ((Map)localObject1).put(localObject2, paramLogItem);
      return;
    }
    if (BeanConvert.mergeLogItem(localLogItem, paramLogItem))
    {
      localLogItem.timestamp = paramLogItem.timestamp;
      return;
    }
    ((Map)localObject1).remove(localObject2);
    ELog.warn("merge stat log failed, removed stat log of %s: %s", new Object[] { paramLogItem.name, localObject2 });
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
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1) {
        return;
      }
      report();
      removeMessages(1);
      sendEmptyMessageDelayed(1, AndroidCollector.access$100(this.this$0));
      return;
    }
    pushLog((LogItem)paramMessage.obj);
  }
  
  public void schedule()
  {
    sendEmptyMessageDelayed(1, AndroidCollector.access$100(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tfm.metrics.AndroidCollector.CollectorHandler
 * JD-Core Version:    0.7.0.1
 */