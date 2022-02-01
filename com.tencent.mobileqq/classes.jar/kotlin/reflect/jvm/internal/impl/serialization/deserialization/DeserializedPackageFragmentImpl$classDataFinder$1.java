package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import org.jetbrains.annotations.NotNull;

final class DeserializedPackageFragmentImpl$classDataFinder$1
  extends Lambda
  implements Function1<ClassId, SourceElement>
{
  DeserializedPackageFragmentImpl$classDataFinder$1(DeserializedPackageFragmentImpl paramDeserializedPackageFragmentImpl)
  {
    super(1);
  }
  
  @NotNull
  public final SourceElement invoke(@NotNull ClassId paramClassId)
  {
    Intrinsics.checkParameterIsNotNull(paramClassId, "it");
    paramClassId = DeserializedPackageFragmentImpl.access$getContainerSource$p(this.this$0);
    if (paramClassId != null) {
      return (SourceElement)paramClassId;
    }
    paramClassId = SourceElement.NO_SOURCE;
    Intrinsics.checkExpressionValueIsNotNull(paramClassId, "SourceElement.NO_SOURCE");
    return paramClassId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragmentImpl.classDataFinder.1
 * JD-Core Version:    0.7.0.1
 */