package com.tencent.tkd.topicsdk.framework.eventdispatch;

import com.tencent.tkd.topicsdk.framework.ThreadManagerKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/framework/eventdispatch/DispatchManager;", "", "()V", "M_OBSERVERS_MAP", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Ljava/util/ArrayList;", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/IEventObserver;", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/IEvent;", "Lkotlin/collections/HashMap;", "Lkotlin/collections/ArrayList;", "addObserver", "", "eventCls", "observer", "dispatchEvent", "T", "event", "(Lcom/tencent/tkd/topicsdk/framework/eventdispatch/IEvent;)V", "isRunOnMainThread", "", "(Lcom/tencent/tkd/topicsdk/framework/eventdispatch/IEvent;Z)V", "dispatchEventInner", "removeObserver", "topicsdk-framework_release"}, k=1, mv={1, 1, 16})
public final class DispatchManager
{
  public static final DispatchManager a;
  private static final HashMap<Class<?>, ArrayList<IEventObserver<? extends IEvent>>> a;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkFrameworkEventdispatchDispatchManager = new DispatchManager();
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private final <T extends IEvent> void a(T paramT, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ThreadManagerKt.a((Function0)new DispatchManager.dispatchEvent.1(paramT));
      return;
    }
    b(paramT);
  }
  
  private final <T extends IEvent> void b(T paramT)
  {
    Object localObject = (ArrayList)jdField_a_of_type_JavaUtilHashMap.get(paramT.getClass());
    if (localObject != null)
    {
      Iterator localIterator = ((Iterable)localObject).iterator();
      while (localIterator.hasNext())
      {
        IEventObserver localIEventObserver = (IEventObserver)localIterator.next();
        localObject = localIEventObserver;
        if (!(localIEventObserver instanceof IEventObserver)) {
          localObject = null;
        }
        if (localObject != null) {
          ((IEventObserver)localObject).a(paramT);
        }
      }
    }
  }
  
  public final <T extends IEvent> void a(@NotNull T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramT, "event");
    a(paramT, true);
  }
  
  public final void a(@NotNull Class<?> paramClass, @NotNull IEventObserver<? extends IEvent> paramIEventObserver)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "eventCls");
    Intrinsics.checkParameterIsNotNull(paramIEventObserver, "observer");
    ThreadManagerKt.a((Function0)new DispatchManager.addObserver.1(paramClass, paramIEventObserver));
  }
  
  public final void b(@NotNull Class<?> paramClass, @NotNull IEventObserver<? extends IEvent> paramIEventObserver)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "eventCls");
    Intrinsics.checkParameterIsNotNull(paramIEventObserver, "observer");
    ThreadManagerKt.a((Function0)new DispatchManager.removeObserver.1(paramClass, paramIEventObserver));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.framework.eventdispatch.DispatchManager
 * JD-Core Version:    0.7.0.1
 */