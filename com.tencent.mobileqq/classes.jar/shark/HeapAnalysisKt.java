package shark;

import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"androidManufacturer", "", "androidSdkInt", "", "leakCanaryVersion", "shark"}, k=2, mv={1, 4, 1})
public final class HeapAnalysisKt
{
  private static final int d()
  {
    try
    {
      Object localObject = Class.forName("android.os.Build$VERSION").getDeclaredField("SDK_INT").get(null);
      if (localObject != null) {
        return ((Integer)localObject).intValue();
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    }
    catch (Exception localException)
    {
      label37:
      break label37;
    }
    return -1;
  }
  
  private static final String e()
  {
    try
    {
      Object localObject = Class.forName("android.os.Build").getDeclaredField("MANUFACTURER").get(null);
      if (localObject != null) {
        return (String)localObject;
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
    }
    catch (Exception localException)
    {
      label34:
      break label34;
    }
    return "Unknown";
  }
  
  private static final String f()
  {
    try
    {
      Object localObject = Class.forName("leakcanary.internal.InternalLeakCanary").getDeclaredField("version");
      Intrinsics.checkExpressionValueIsNotNull(localObject, "versionField");
      ((Field)localObject).setAccessible(true);
      localObject = ((Field)localObject).get(null);
      if (localObject != null) {
        return (String)localObject;
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
    }
    catch (Exception localException)
    {
      label47:
      break label47;
    }
    return "Unknown";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HeapAnalysisKt
 * JD-Core Version:    0.7.0.1
 */