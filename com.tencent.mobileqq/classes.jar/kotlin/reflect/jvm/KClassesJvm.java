package kotlin.reflect.jvm;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.KClassImpl;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"jvmName", "", "Lkotlin/reflect/KClass;", "getJvmName", "(Lkotlin/reflect/KClass;)Ljava/lang/String;", "kotlin-reflection"}, k=2, mv={1, 1, 16})
@JvmName(name="KClassesJvm")
public final class KClassesJvm
{
  @NotNull
  public static final String getJvmName(@NotNull KClass<?> paramKClass)
  {
    Intrinsics.checkParameterIsNotNull(paramKClass, "$this$jvmName");
    paramKClass = ((KClassImpl)paramKClass).getJClass().getName();
    Intrinsics.checkExpressionValueIsNotNull(paramKClass, "(this as KClassImpl).jClass.name");
    return paramKClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.KClassesJvm
 * JD-Core Version:    0.7.0.1
 */