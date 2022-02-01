package com.tencent.mobileqq.qqexpand.flutter.channel.redpoint;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.qqexpand.flutter.channel.ExpandChannelReportUtil;
import com.tencent.mobileqq.qqexpand.ipc.ExpandFlutterIPCClient;
import com.tencent.mobileqq.qqexpand.ipc.IExpandIpcFlutterNotifyListener.ExpandIpcFlutterNotifyListener;
import com.tencent.mobileqq.qqexpand.utils.ILog;
import com.tencent.mobileqq.qqexpand.utils.LogUtils;
import com.tencent.qphone.base.util.QLog;
import io.flutter.plugin.common.EventChannel.EventSink;
import io.flutter.plugin.common.EventChannel.StreamHandler;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/flutter/channel/redpoint/ExpandRedPointApiChannel$OnRedDotChangeStreamHandler;", "Lcom/tencent/mobileqq/qqexpand/ipc/IExpandIpcFlutterNotifyListener$ExpandIpcFlutterNotifyListener;", "Lio/flutter/plugin/common/EventChannel$StreamHandler;", "()V", "expandIPCClient", "Lcom/tencent/mobileqq/qqexpand/ipc/ExpandFlutterIPCClient;", "kotlin.jvm.PlatformType", "getExpandIPCClient", "()Lcom/tencent/mobileqq/qqexpand/ipc/ExpandFlutterIPCClient;", "setExpandIPCClient", "(Lcom/tencent/mobileqq/qqexpand/ipc/ExpandFlutterIPCClient;)V", "handler", "Landroid/os/Handler;", "sinkList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lio/flutter/plugin/common/EventChannel$EventSink;", "getSinkList", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "setSinkList", "(Ljava/util/concurrent/CopyOnWriteArrayList;)V", "sinkMap", "Ljava/util/HashMap;", "", "getSinkMap", "()Ljava/util/HashMap;", "setSinkMap", "(Ljava/util/HashMap;)V", "destroy", "", "dispatchRedPoint", "value", "", "finalize", "onCancel", "o", "onListen", "eventSink", "onRedPointUpdate", "redPointNum", "", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandRedPointApiChannel$OnRedDotChangeStreamHandler
  extends IExpandIpcFlutterNotifyListener.ExpandIpcFlutterNotifyListener
  implements EventChannel.StreamHandler
{
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private ExpandFlutterIPCClient jdField_a_of_type_ComTencentMobileqqQqexpandIpcExpandFlutterIPCClient = ExpandFlutterIPCClient.a();
  @NotNull
  private HashMap<Object, EventChannel.EventSink> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  @NotNull
  private CopyOnWriteArrayList<EventChannel.EventSink> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  
  public ExpandRedPointApiChannel$OnRedDotChangeStreamHandler()
  {
    this.jdField_a_of_type_ComTencentMobileqqQqexpandIpcExpandFlutterIPCClient.a((IExpandIpcFlutterNotifyListener.ExpandIpcFlutterNotifyListener)this);
  }
  
  private final void a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.isEmpty()) {
      ExpandChannelReportUtil.a("com.tencent.qflutter/expand/event.expand_red_dot.onRedDotChange", "OnRedDotChange", "event");
    }
    this.jdField_a_of_type_AndroidOsHandler.post((Runnable)new ExpandRedPointApiChannel.OnRedDotChangeStreamHandler.dispatchRedPoint.1(this, paramLong));
  }
  
  @NotNull
  public final CopyOnWriteArrayList<EventChannel.EventSink> a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  }
  
  public void a(int paramInt)
  {
    a(paramInt);
  }
  
  public final void b()
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_ComTencentMobileqqQqexpandIpcExpandFlutterIPCClient.b((IExpandIpcFlutterNotifyListener.ExpandIpcFlutterNotifyListener)this);
  }
  
  protected final void finalize()
  {
    this.jdField_a_of_type_ComTencentMobileqqQqexpandIpcExpandFlutterIPCClient.b((IExpandIpcFlutterNotifyListener.ExpandIpcFlutterNotifyListener)this);
  }
  
  public void onCancel(@NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "o");
    Object localObject = LogUtils.a;
    if (QLog.isColorLevel())
    {
      localObject = ((LogUtils)localObject).a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cancel! onListen OnRedDotChange callback from flutter! o=");
      localStringBuilder.append(paramObject);
      ((ILog)localObject).a("ExpandRedPointApiChannel", 2, localStringBuilder.toString());
    }
    paramObject = (EventChannel.EventSink)this.jdField_a_of_type_JavaUtilHashMap.remove(paramObject);
    if (paramObject != null)
    {
      paramObject.endOfStream();
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramObject);
    }
  }
  
  public void onListen(@Nullable Object paramObject, @NotNull EventChannel.EventSink paramEventSink)
  {
    Intrinsics.checkParameterIsNotNull(paramEventSink, "eventSink");
    Object localObject = LogUtils.a;
    if (QLog.isColorLevel())
    {
      localObject = ((LogUtils)localObject).a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onListen OnRedDotChange callback from flutter! o=");
      localStringBuilder.append(paramObject);
      ((ILog)localObject).a("ExpandRedPointApiChannel", 2, localStringBuilder.toString());
    }
    if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramObject))
    {
      ((Map)this.jdField_a_of_type_JavaUtilHashMap).put(paramObject, paramEventSink);
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.addIfAbsent(paramEventSink);
      return;
    }
    paramEventSink = LogUtils.a;
    if (QLog.isColorLevel())
    {
      paramEventSink = paramEventSink.a();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onListen OnRedDotChange callback from flutter! o=");
      ((StringBuilder)localObject).append(paramObject);
      ((StringBuilder)localObject).append(", already exist!");
      paramEventSink.a("ExpandRedPointApiChannel", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.channel.redpoint.ExpandRedPointApiChannel.OnRedDotChangeStreamHandler
 * JD-Core Version:    0.7.0.1
 */