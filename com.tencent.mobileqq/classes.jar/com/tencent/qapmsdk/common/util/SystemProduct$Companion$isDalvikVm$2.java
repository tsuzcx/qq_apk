package com.tencent.qapmsdk.common.util;

import com.tencent.qapmsdk.common.logger.Logger;
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
    Object localObject1 = Reflect.Companion;
    Object localObject2 = Thread.currentThread();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "Thread.currentThread()");
    localObject2 = ((Reflect.Companion)localObject1).getThreadPrivateField(localObject2, "nativePeer");
    localObject1 = localObject2;
    if (!(localObject2 instanceof Long)) {
      localObject1 = null;
    }
    localObject1 = (Long)localObject1;
    if (localObject1 != null)
    {
      ((Number)localObject1).longValue();
      Logger.INSTANCE.i(new String[] { "QAPM_common_SystemProduct", "ART Mode" });
    }
    localObject1 = Reflect.Companion;
    localObject2 = Thread.currentThread();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "Thread.currentThread()");
    localObject1 = ((Reflect.Companion)localObject1).getThreadPrivateField(localObject2, "vmThread");
    if (localObject1 != null)
    {
      localObject2 = Reflect.Companion.getInstancePrivateField(localObject1, "vmData");
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
        Logger.INSTANCE.d(new String[] { "QAPM_common_SystemProduct", "Dalvik Mode" });
        return true;
      }
    }
    Logger.INSTANCE.d(new String[] { "QAPM_common_SystemProduct", "default ART Mode" });
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.common.util.SystemProduct.Companion.isDalvikVm.2
 * JD-Core Version:    0.7.0.1
 */