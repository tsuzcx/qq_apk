package com.tencent.rmonitor.property;

import com.tencent.rmonitor.base.plugin.listener.IBaseListener;
import com.tencent.rmonitor.base.plugin.listener.MonitorListenerMng;

public class ListenerSetter<T extends IBaseListener>
  implements IPropertyUpdater
{
  private final Class<T> a;
  private final MonitorListenerMng<T> b;
  
  public ListenerSetter(Class<T> paramClass, MonitorListenerMng<T> paramMonitorListenerMng)
  {
    this.a = paramClass;
    this.b = paramMonitorListenerMng;
  }
  
  public boolean a(Object paramObject)
  {
    if (this.a.isInstance(paramObject))
    {
      this.b.a((IBaseListener)this.a.cast(paramObject));
      return true;
    }
    return false;
  }
  
  public boolean b(Object paramObject)
  {
    if (this.a.isInstance(paramObject))
    {
      this.b.b((IBaseListener)this.a.cast(paramObject));
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.property.ListenerSetter
 * JD-Core Version:    0.7.0.1
 */