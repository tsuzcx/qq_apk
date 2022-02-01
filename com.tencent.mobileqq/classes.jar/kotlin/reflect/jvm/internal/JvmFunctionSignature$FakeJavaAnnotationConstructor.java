package kotlin.reflect.jvm.internal;

import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$FakeJavaAnnotationConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "getJClass", "()Ljava/lang/Class;", "methods", "", "Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", "getMethods", "()Ljava/util/List;", "asString", "", "kotlin-reflection"}, k=1, mv={1, 1, 16})
public final class JvmFunctionSignature$FakeJavaAnnotationConstructor
  extends JvmFunctionSignature
{
  @NotNull
  private final Class<?> jClass;
  @NotNull
  private final List<Method> methods;
  
  public JvmFunctionSignature$FakeJavaAnnotationConstructor(@NotNull Class<?> paramClass)
  {
    super(null);
    this.jClass = paramClass;
    paramClass = this.jClass.getDeclaredMethods();
    Intrinsics.checkExpressionValueIsNotNull(paramClass, "jClass.declaredMethods");
    this.methods = ArraysKt.sortedWith(paramClass, (Comparator)new JvmFunctionSignature.FakeJavaAnnotationConstructor..special..inlined.sortedBy.1());
  }
  
  @NotNull
  public String asString()
  {
    return CollectionsKt.joinToString$default((Iterable)this.methods, (CharSequence)"", (CharSequence)"<init>(", (CharSequence)")V", 0, null, (Function1)JvmFunctionSignature.FakeJavaAnnotationConstructor.asString.1.INSTANCE, 24, null);
  }
  
  @NotNull
  public final List<Method> getMethods()
  {
    return this.methods;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.JvmFunctionSignature.FakeJavaAnnotationConstructor
 * JD-Core Version:    0.7.0.1
 */