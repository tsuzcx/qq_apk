package com.tencent.rmonitor.property;

import android.util.SparseArray;
import com.tencent.rmonitor.base.plugin.listener.IBaseListener;
import com.tencent.rmonitor.base.plugin.listener.IBatteryListener;
import com.tencent.rmonitor.base.plugin.listener.ICustomSetListener;
import com.tencent.rmonitor.base.plugin.listener.IDBTracerListener;
import com.tencent.rmonitor.base.plugin.listener.IDeviceInfoListener;
import com.tencent.rmonitor.base.plugin.listener.IDropFrameListener;
import com.tencent.rmonitor.base.plugin.listener.IIoTracerListener;
import com.tencent.rmonitor.base.plugin.listener.ILooperListener;
import com.tencent.rmonitor.base.plugin.listener.IMemoryCeilingListener;
import com.tencent.rmonitor.base.plugin.listener.IMemoryLeakListener;
import com.tencent.rmonitor.base.plugin.listener.IResourceListener;
import com.tencent.rmonitor.base.plugin.listener.ListenerManager;

public class PropertyMng
{
  private static PropertyMng a;
  private final SparseArray<IStringPropertySetter> b = new SparseArray(8);
  private final SparseArray<IPropertySetter> c = new SparseArray(12);
  private final SparseArray<IPropertyUpdater> d = new SparseArray(3);
  
  private PropertyMng()
  {
    PropertyMng.LoggerPropertySetter localLoggerPropertySetter = new PropertyMng.LoggerPropertySetter();
    this.b.put(104, localLoggerPropertySetter);
    this.b.put(102, new PropertyMng.UserIdSetter());
    this.b.put(101, new PropertyMng.AppIdSetter());
    this.b.put(103, new PropertyMng.AppVersionSetter());
    this.b.put(106, new PropertyMng.DeviceIdSetter());
    this.b.put(105, new PropertyMng.QapmHostSetter());
    this.b.put(108, new PropertyMng.ConfigFlagSetter());
    this.c.put(109, new PropertyMng.CollectSensitiveInfoSetter());
    this.c.put(104, localLoggerPropertySetter);
    this.c.put(107, new PropertyMng.ApplicationSetter());
    b();
  }
  
  public static PropertyMng a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new PropertyMng();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void b()
  {
    this.d.put(200, new PropertyMng.ConfigUpdaterSetter());
    this.d.put(207, new ListenerSetter(IIoTracerListener.class, ListenerManager.g));
    this.d.put(213, new ListenerSetter(IDBTracerListener.class, ListenerManager.j));
    this.d.put(204, new ListenerSetter(IResourceListener.class, ListenerManager.d));
    this.d.put(201, new ListenerSetter(IMemoryLeakListener.class, ListenerManager.a));
    this.d.put(202, new ListenerSetter(IMemoryCeilingListener.class, ListenerManager.b));
    this.d.put(203, new ListenerSetter(IDropFrameListener.class, ListenerManager.c));
    this.d.put(205, new ListenerSetter(ILooperListener.class, ListenerManager.e));
    this.d.put(206, new ListenerSetter(ICustomSetListener.class, ListenerManager.f));
    this.d.put(210, new ListenerSetter(IBaseListener.class, ListenerManager.h));
    this.d.put(208, new ListenerSetter(IBaseListener.class, ListenerManager.i));
    this.d.put(209, new ListenerSetter(IBaseListener.class, ListenerManager.k));
    this.d.put(211, new ListenerSetter(IDeviceInfoListener.class, ListenerManager.l));
    this.d.put(212, new ListenerSetter(IBatteryListener.class, ListenerManager.m));
  }
  
  public IStringPropertySetter a(int paramInt)
  {
    return (IStringPropertySetter)this.b.get(paramInt);
  }
  
  public IPropertySetter b(int paramInt)
  {
    return (IPropertySetter)this.c.get(paramInt);
  }
  
  public IPropertyUpdater c(int paramInt)
  {
    return (IPropertyUpdater)this.d.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.property.PropertyMng
 * JD-Core Version:    0.7.0.1
 */