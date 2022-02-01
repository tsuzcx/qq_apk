package com.tencent.qcircle.cooperation.config;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.flashshow.api.events.FSAccountChangeEvent;
import java.util.ArrayList;

public class QCircleConfigCache
  implements SimpleEventReceiver
{
  private static QCircleConfigCache a;
  private Boolean b;
  
  private QCircleConfigCache()
  {
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public static QCircleConfigCache a()
  {
    try
    {
      if (a == null) {
        a = new QCircleConfigCache();
      }
      QCircleConfigCache localQCircleConfigCache = a;
      return localQCircleConfigCache;
    }
    finally {}
  }
  
  private void c()
  {
    this.b = null;
  }
  
  public void a(Boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public Boolean b()
  {
    return this.b;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(FSAccountChangeEvent.class);
    return localArrayList;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof FSAccountChangeEvent)) {
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.cooperation.config.QCircleConfigCache
 * JD-Core Version:    0.7.0.1
 */