package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;

public final class PrimitiveTypeUtilKt
{
  @NotNull
  public static final Collection<KotlinType> getAllSignedLiteralTypes(@NotNull ModuleDescriptor paramModuleDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramModuleDescriptor, "$this$allSignedLiteralTypes");
    return (Collection)CollectionsKt.listOf(new SimpleType[] { paramModuleDescriptor.getBuiltIns().getIntType(), paramModuleDescriptor.getBuiltIns().getLongType(), paramModuleDescriptor.getBuiltIns().getByteType(), paramModuleDescriptor.getBuiltIns().getShortType() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.constants.PrimitiveTypeUtilKt
 * JD-Core Version:    0.7.0.1
 */