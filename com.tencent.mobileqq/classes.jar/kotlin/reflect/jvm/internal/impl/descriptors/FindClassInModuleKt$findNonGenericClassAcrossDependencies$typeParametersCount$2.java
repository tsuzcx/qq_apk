package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import org.jetbrains.annotations.NotNull;

final class FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$2
  extends Lambda
  implements Function1<ClassId, Integer>
{
  public static final 2 INSTANCE = new 2();
  
  FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$2()
  {
    super(1);
  }
  
  public final int invoke(@NotNull ClassId paramClassId)
  {
    Intrinsics.checkParameterIsNotNull(paramClassId, "it");
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt.findNonGenericClassAcrossDependencies.typeParametersCount.2
 * JD-Core Version:    0.7.0.1
 */