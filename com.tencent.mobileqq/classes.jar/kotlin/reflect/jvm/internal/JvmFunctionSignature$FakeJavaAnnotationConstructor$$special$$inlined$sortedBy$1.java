package kotlin.reflect.jvm.internal;

import java.lang.reflect.Method;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k=3, mv={1, 1, 16})
public final class JvmFunctionSignature$FakeJavaAnnotationConstructor$$special$$inlined$sortedBy$1<T>
  implements Comparator<T>
{
  public final int compare(T paramT1, T paramT2)
  {
    paramT1 = (Method)paramT1;
    Intrinsics.checkExpressionValueIsNotNull(paramT1, "it");
    paramT1 = (Comparable)paramT1.getName();
    paramT2 = (Method)paramT2;
    Intrinsics.checkExpressionValueIsNotNull(paramT2, "it");
    return ComparisonsKt.compareValues(paramT1, (Comparable)paramT2.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.JvmFunctionSignature.FakeJavaAnnotationConstructor..special..inlined.sortedBy.1
 * JD-Core Version:    0.7.0.1
 */