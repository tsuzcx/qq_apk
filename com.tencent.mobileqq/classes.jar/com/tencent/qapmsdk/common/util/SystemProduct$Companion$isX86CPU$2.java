package com.tencent.qapmsdk.common.util;

import com.tencent.qapmsdk.common.logger.Logger;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 15})
final class SystemProduct$Companion$isX86CPU$2
  extends Lambda
  implements Function0<Boolean>
{
  public static final 2 INSTANCE = new 2();
  
  SystemProduct$Companion$isX86CPU$2()
  {
    super(0);
  }
  
  public final boolean invoke()
  {
    try
    {
      Object localObject1 = Class.forName("android.os.SystemProperties");
      Object localObject2 = ((Class)localObject1).getMethod("get", new Class[] { String.class, String.class }).invoke(localObject1, new Object[] { "ro.product.cpu.abi", "" });
      localObject1 = localObject2;
      if (!(localObject2 instanceof String)) {
        localObject1 = null;
      }
      localObject1 = (String)localObject1;
      if (localObject1 != null)
      {
        boolean bool = StringsKt.contains$default((CharSequence)localObject1, (CharSequence)"x86", false, 2, null);
        return bool;
      }
    }
    catch (Exception localException)
    {
      Logger.INSTANCE.exception("QAPM_common_SystemProduct", (Throwable)localException);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.common.util.SystemProduct.Companion.isX86CPU.2
 * JD-Core Version:    0.7.0.1
 */