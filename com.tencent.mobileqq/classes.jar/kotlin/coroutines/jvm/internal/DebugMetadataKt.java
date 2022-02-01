package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"COROUTINES_DEBUG_METADATA_VERSION", "", "checkDebugMetadataVersion", "", "expected", "actual", "getDebugMetadataAnnotation", "Lkotlin/coroutines/jvm/internal/DebugMetadata;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "getLabel", "getSpilledVariableFieldMapping", "", "", "(Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;)[Ljava/lang/String;", "getStackTraceElementImpl", "Ljava/lang/StackTraceElement;", "getStackTraceElement", "kotlin-stdlib"}, k=2, mv={1, 1, 16})
public final class DebugMetadataKt
{
  private static final int COROUTINES_DEBUG_METADATA_VERSION = 1;
  
  private static final void checkDebugMetadataVersion(int paramInt1, int paramInt2)
  {
    if (paramInt2 <= paramInt1) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Debug metadata version mismatch. Expected: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", got ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(". Please update the Kotlin standard library.");
    throw ((Throwable)new IllegalStateException(localStringBuilder.toString().toString()));
  }
  
  private static final DebugMetadata getDebugMetadataAnnotation(@NotNull BaseContinuationImpl paramBaseContinuationImpl)
  {
    return (DebugMetadata)paramBaseContinuationImpl.getClass().getAnnotation(DebugMetadata.class);
  }
  
  private static final int getLabel(@NotNull BaseContinuationImpl paramBaseContinuationImpl)
  {
    try
    {
      Object localObject = paramBaseContinuationImpl.getClass().getDeclaredField("label");
      Intrinsics.checkExpressionValueIsNotNull(localObject, "field");
      ((Field)localObject).setAccessible(true);
      localObject = ((Field)localObject).get(paramBaseContinuationImpl);
      paramBaseContinuationImpl = (BaseContinuationImpl)localObject;
      if (!(localObject instanceof Integer)) {
        paramBaseContinuationImpl = null;
      }
      paramBaseContinuationImpl = (Integer)paramBaseContinuationImpl;
      int i;
      if (paramBaseContinuationImpl != null) {
        i = paramBaseContinuationImpl.intValue();
      } else {
        i = 0;
      }
      return i - 1;
    }
    catch (Exception paramBaseContinuationImpl)
    {
      label61:
      break label61;
    }
    return -1;
  }
  
  @SinceKotlin(version="1.3")
  @JvmName(name="getSpilledVariableFieldMapping")
  @Nullable
  public static final String[] getSpilledVariableFieldMapping(@NotNull BaseContinuationImpl paramBaseContinuationImpl)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseContinuationImpl, "$this$getSpilledVariableFieldMapping");
    DebugMetadata localDebugMetadata = getDebugMetadataAnnotation(paramBaseContinuationImpl);
    if (localDebugMetadata != null)
    {
      checkDebugMetadataVersion(1, localDebugMetadata.v());
      ArrayList localArrayList = new ArrayList();
      int j = getLabel(paramBaseContinuationImpl);
      paramBaseContinuationImpl = localDebugMetadata.i();
      int k = paramBaseContinuationImpl.length;
      int i = 0;
      while (i < k)
      {
        if (paramBaseContinuationImpl[i] == j)
        {
          localArrayList.add(localDebugMetadata.s()[i]);
          localArrayList.add(localDebugMetadata.n()[i]);
        }
        i += 1;
      }
      paramBaseContinuationImpl = ((Collection)localArrayList).toArray(new String[0]);
      if (paramBaseContinuationImpl != null) {
        return (String[])paramBaseContinuationImpl;
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }
    return null;
  }
  
  @SinceKotlin(version="1.3")
  @JvmName(name="getStackTraceElement")
  @Nullable
  public static final StackTraceElement getStackTraceElement(@NotNull BaseContinuationImpl paramBaseContinuationImpl)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseContinuationImpl, "$this$getStackTraceElementImpl");
    DebugMetadata localDebugMetadata = getDebugMetadataAnnotation(paramBaseContinuationImpl);
    if (localDebugMetadata != null)
    {
      checkDebugMetadataVersion(1, localDebugMetadata.v());
      int i = getLabel(paramBaseContinuationImpl);
      if (i < 0) {
        i = -1;
      } else {
        i = localDebugMetadata.l()[i];
      }
      paramBaseContinuationImpl = ModuleNameRetriever.INSTANCE.getModuleName(paramBaseContinuationImpl);
      if (paramBaseContinuationImpl == null)
      {
        paramBaseContinuationImpl = localDebugMetadata.c();
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramBaseContinuationImpl);
        localStringBuilder.append('/');
        localStringBuilder.append(localDebugMetadata.c());
        paramBaseContinuationImpl = localStringBuilder.toString();
      }
      return new StackTraceElement(paramBaseContinuationImpl, localDebugMetadata.m(), localDebugMetadata.f(), i);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.coroutines.jvm.internal.DebugMetadataKt
 * JD-Core Version:    0.7.0.1
 */