package com.tencent.rmonitor.common.util;

import com.tencent.rmonitor.common.logger.Logger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 15})
final class SystemProduct$Companion$isDalvikVm$2
  extends Lambda
  implements Function0<Boolean>
{
  public static final 2 INSTANCE = new 2();
  
  SystemProduct$Companion$isDalvikVm$2()
  {
    super(0);
  }
  
  public final boolean invoke()
  {
    Object localObject1 = Reflect.a;
    Object localObject2 = Thread.currentThread();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "Thread.currentThread()");
    localObject2 = ((Reflect)localObject1).a(localObject2, "nativePeer");
    localObject1 = localObject2;
    if (!(localObject2 instanceof Long)) {
      localObject1 = null;
    }
    localObject1 = (Long)localObject1;
    if (localObject1 != null)
    {
      ((Number)localObject1).longValue();
      Logger.b.i(new String[] { "RMonitor_common_SystemProduct", "ART Mode" });
    }
    localObject1 = Reflect.a;
    localObject2 = Thread.currentThread();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "Thread.currentThread()");
    localObject1 = ((Reflect)localObject1).a(localObject2, "vmThread");
    if (localObject1 != null)
    {
      localObject2 = Reflect.a.b(localObject1, "vmData");
      localObject1 = localObject2;
      if (!(localObject2 instanceof Integer)) {
        localObject1 = null;
      }
      localObject1 = (Integer)localObject1;
      int i;
      if (localObject1 != null) {
        i = ((Number)localObject1).intValue();
      } else {
        i = 0;
      }
      if (i != 0)
      {
        Logger.b.d(new String[] { "RMonitor_common_SystemProduct", "Dalvik Mode" });
        return true;
      }
    }
    Logger.b.d(new String[] { "RMonitor_common_SystemProduct", "default ART Mode" });
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.common.util.SystemProduct.Companion.isDalvikVm.2
 * JD-Core Version:    0.7.0.1
 */