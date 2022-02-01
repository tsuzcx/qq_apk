package kotlin.reflect.jvm.internal.calls;

import java.util.Arrays;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "", "entry", "", "invoke"}, k=3, mv={1, 1, 16})
final class AnnotationConstructorCallerKt$createAnnotationInstance$toString$2$1$1
  extends Lambda
  implements Function1<Map.Entry<? extends String, ? extends Object>, String>
{
  public static final 1 INSTANCE = new 1();
  
  AnnotationConstructorCallerKt$createAnnotationInstance$toString$2$1$1()
  {
    super(1);
  }
  
  @NotNull
  public final String invoke(@NotNull Map.Entry<String, ? extends Object> paramEntry)
  {
    Intrinsics.checkParameterIsNotNull(paramEntry, "entry");
    String str = (String)paramEntry.getKey();
    paramEntry = paramEntry.getValue();
    if ((paramEntry instanceof boolean[])) {
      paramEntry = Arrays.toString((boolean[])paramEntry);
    } else if ((paramEntry instanceof char[])) {
      paramEntry = Arrays.toString((char[])paramEntry);
    } else if ((paramEntry instanceof byte[])) {
      paramEntry = Arrays.toString((byte[])paramEntry);
    } else if ((paramEntry instanceof short[])) {
      paramEntry = Arrays.toString((short[])paramEntry);
    } else if ((paramEntry instanceof int[])) {
      paramEntry = Arrays.toString((int[])paramEntry);
    } else if ((paramEntry instanceof float[])) {
      paramEntry = Arrays.toString((float[])paramEntry);
    } else if ((paramEntry instanceof long[])) {
      paramEntry = Arrays.toString((long[])paramEntry);
    } else if ((paramEntry instanceof double[])) {
      paramEntry = Arrays.toString((double[])paramEntry);
    } else if ((paramEntry instanceof Object[])) {
      paramEntry = Arrays.toString((Object[])paramEntry);
    } else {
      paramEntry = paramEntry.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append('=');
    localStringBuilder.append(paramEntry);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt.createAnnotationInstance.toString.2.1.1
 * JD-Core Version:    0.7.0.1
 */