package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"ANDROID_DETECTED", "", "getANDROID_DETECTED", "()Z", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class FastServiceLoaderKt
{
  private static final boolean ANDROID_DETECTED;
  
  static
  {
    Object localObject2;
    try
    {
      Object localObject1 = Result.Companion;
      localObject1 = Result.constructor-impl(Class.forName("android.os.Build"));
    }
    catch (Throwable localThrowable)
    {
      Result.Companion localCompanion = Result.Companion;
      localObject2 = Result.constructor-impl(ResultKt.createFailure(localThrowable));
    }
    ANDROID_DETECTED = Result.isSuccess-impl(localObject2);
  }
  
  public static final boolean getANDROID_DETECTED()
  {
    return ANDROID_DETECTED;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.internal.FastServiceLoaderKt
 * JD-Core Version:    0.7.0.1
 */