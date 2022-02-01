package com.tencent.mobileqq.qqlive.report;

import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class QQLiveReportCallbackWrapper
  implements IQQLiveReportCallback, IQQLiveReportCallbackRegister
{
  private final CopyOnWriteArrayList<IQQLiveReportCallback> a = new CopyOnWriteArrayList();
  
  public void a()
  {
    this.a.clear();
  }
  
  public void a(String paramString, HashMap<String, String> paramHashMap)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((IQQLiveReportCallback)localIterator.next()).a(paramString, paramHashMap);
    }
  }
  
  public void registerReportCallback(IQQLiveReportCallback paramIQQLiveReportCallback)
  {
    if (paramIQQLiveReportCallback == null) {
      return;
    }
    if (!this.a.contains(paramIQQLiveReportCallback)) {
      this.a.add(paramIQQLiveReportCallback);
    }
  }
  
  public void unRegisterReportCallback(IQQLiveReportCallback paramIQQLiveReportCallback)
  {
    if (paramIQQLiveReportCallback == null) {
      return;
    }
    this.a.remove(paramIQQLiveReportCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.report.QQLiveReportCallbackWrapper
 * JD-Core Version:    0.7.0.1
 */