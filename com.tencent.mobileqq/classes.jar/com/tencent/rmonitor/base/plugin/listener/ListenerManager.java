package com.tencent.rmonitor.base.plugin.listener;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/plugin/listener/ListenerManager;", "", "()V", "batteryListener", "Lcom/tencent/rmonitor/base/plugin/listener/MonitorListenerMng;", "Lcom/tencent/rmonitor/base/plugin/listener/IBatteryListener;", "bigBitmapListener", "Lcom/tencent/rmonitor/base/plugin/listener/IBaseListener;", "customSetListener", "Lcom/tencent/rmonitor/base/plugin/listener/ICustomSetListener;", "dbTracerListener", "Lcom/tencent/rmonitor/base/plugin/listener/IDBTracerListener;", "deviceInfoListener", "Lcom/tencent/rmonitor/base/plugin/listener/IDeviceInfoListener;", "dropFrameListener", "Lcom/tencent/rmonitor/base/plugin/listener/IDropFrameListener;", "fdLeakListener", "ioTracerListener", "Lcom/tencent/rmonitor/base/plugin/listener/IIoTracerListener;", "looperListener", "Lcom/tencent/rmonitor/base/plugin/listener/ILooperListener;", "memoryCeilingListener", "Lcom/tencent/rmonitor/base/plugin/listener/IMemoryCeilingListener;", "memoryLeakListener", "Lcom/tencent/rmonitor/base/plugin/listener/IMemoryLeakListener;", "natMemListener", "resourceListener", "Lcom/tencent/rmonitor/base/plugin/listener/IResourceListener;", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class ListenerManager
{
  @JvmField
  @NotNull
  public static final MonitorListenerMng<IMemoryLeakListener> a = new MonitorListenerMng();
  @JvmField
  @NotNull
  public static final MonitorListenerMng<IMemoryCeilingListener> b = new MonitorListenerMng();
  @JvmField
  @NotNull
  public static final MonitorListenerMng<IDropFrameListener> c = new MonitorListenerMng();
  @JvmField
  @NotNull
  public static final MonitorListenerMng<IResourceListener> d = new MonitorListenerMng();
  @JvmField
  @NotNull
  public static final MonitorListenerMng<ILooperListener> e = new MonitorListenerMng();
  @JvmField
  @NotNull
  public static final MonitorListenerMng<ICustomSetListener> f = new MonitorListenerMng();
  @JvmField
  @NotNull
  public static final MonitorListenerMng<IIoTracerListener> g = new MonitorListenerMng();
  @JvmField
  @NotNull
  public static final MonitorListenerMng<IBaseListener> h = new MonitorListenerMng();
  @JvmField
  @NotNull
  public static final MonitorListenerMng<IBaseListener> i = new MonitorListenerMng();
  @JvmField
  @NotNull
  public static MonitorListenerMng<IDBTracerListener> j = new MonitorListenerMng();
  @JvmField
  @NotNull
  public static final MonitorListenerMng<IBaseListener> k = new MonitorListenerMng();
  @JvmField
  @NotNull
  public static final MonitorListenerMng<IDeviceInfoListener> l = new MonitorListenerMng();
  @JvmField
  @NotNull
  public static final MonitorListenerMng<IBatteryListener> m = new MonitorListenerMng();
  public static final ListenerManager n = new ListenerManager();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.plugin.listener.ListenerManager
 * JD-Core Version:    0.7.0.1
 */