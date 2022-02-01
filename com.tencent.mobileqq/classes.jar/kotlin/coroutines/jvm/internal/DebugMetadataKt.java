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
    if (paramInt2 > paramInt1) {
      throw ((Throwable)new IllegalStateException(("Debug metadata version mismatch. Expected: " + paramInt1 + ", got " + paramInt2 + ". Please update the Kotlin standard library.").toString()));
    }
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
      if (paramBaseContinuationImpl != null) {}
      for (int i = paramBaseContinuationImpl.intValue();; i = 0) {
        return i - 1;
      }
      return -1;
    }
    catch (Exception paramBaseContinuationImpl) {}
  }
  
  @SinceKotlin(version="1.3")
  @JvmName(name="getSpilledVariableFieldMapping")
  @Nullable
  public static final String[] getSpilledVariableFieldMapping(@NotNull BaseContinuationImpl paramBaseContinuationImpl)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseContinuationImpl, "$this$getSpilledVariableFieldMapping");
    DebugMetadata localDebugMetadata = getDebugMetadataAnnotation(paramBaseContinuationImpl);
    ArrayList localArrayList;
    if (localDebugMetadata != null)
    {
      checkDebugMetadataVersion(1, localDebugMetadata.v());
      localArrayList = new ArrayList();
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
    }
    return null;
    paramBaseContinuationImpl = ((Collection)localArrayList).toArray(new String[0]);
    if (paramBaseContinuationImpl == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }
    return (String[])paramBaseContinuationImpl;
  }
  
  @SinceKotlin(version="1.3")
  @JvmName(name="getStackTraceElement")
  @Nullable
  public static final StackTraceElement getStackTraceElement(@NotNull BaseContinuationImpl paramBaseContinuationImpl)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseContinuationImpl, "$this$getStackTraceElementImpl");
    DebugMetadata localDebugMetadata = getDebugMetadataAnnotation(paramBaseContinuationImpl);
    int i;
    if (localDebugMetadata != null)
    {
      checkDebugMetadataVersion(1, localDebugMetadata.v());
      i = getLabel(paramBaseContinuationImpl);
      if (i >= 0) {
        break label79;
      }
      i = -1;
      paramBaseContinuationImpl = ModuleNameRetriever.INSTANCE.getModuleName(paramBaseContinuationImpl);
      if (paramBaseContinuationImpl != null) {
        break label91;
      }
    }
    label79:
    label91:
    for (paramBaseContinuationImpl = localDebugMetadata.c();; paramBaseContinuationImpl = paramBaseContinuationImpl + '/' + localDebugMetadata.c())
    {
      return new StackTraceElement(paramBaseContinuationImpl, localDebugMetadata.m(), localDebugMetadata.f(), i);
      return null;
      i = localDebugMetadata.l()[i];
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.coroutines.jvm.internal.DebugMetadataKt
 * JD-Core Version:    0.7.0.1
 */