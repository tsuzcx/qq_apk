package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class ClassMapperLite$map$1$1
  extends Lambda
  implements Function2<String, String, Unit>
{
  ClassMapperLite$map$1$1(Map paramMap)
  {
    super(2);
  }
  
  public final void invoke(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "kotlinSimpleName");
    Intrinsics.checkParameterIsNotNull(paramString2, "javaInternalName");
    Map localMap = this.$this_apply;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("kotlin/");
    localStringBuilder.append(paramString1);
    paramString1 = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append('L');
    localStringBuilder.append(paramString2);
    localStringBuilder.append(';');
    localMap.put(paramString1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.ClassMapperLite.map.1.1
 * JD-Core Version:    0.7.0.1
 */