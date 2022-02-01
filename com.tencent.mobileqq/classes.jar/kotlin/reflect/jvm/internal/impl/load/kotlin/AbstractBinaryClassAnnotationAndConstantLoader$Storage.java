package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

final class AbstractBinaryClassAnnotationAndConstantLoader$Storage<A, C>
{
  @NotNull
  private final Map<MemberSignature, List<A>> memberAnnotations;
  @NotNull
  private final Map<MemberSignature, C> propertyConstants;
  
  public AbstractBinaryClassAnnotationAndConstantLoader$Storage(@NotNull Map<MemberSignature, ? extends List<? extends A>> paramMap, @NotNull Map<MemberSignature, ? extends C> paramMap1)
  {
    this.memberAnnotations = paramMap;
    this.propertyConstants = paramMap1;
  }
  
  @NotNull
  public final Map<MemberSignature, List<A>> getMemberAnnotations()
  {
    return this.memberAnnotations;
  }
  
  @NotNull
  public final Map<MemberSignature, C> getPropertyConstants()
  {
    return this.propertyConstants;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader.Storage
 * JD-Core Version:    0.7.0.1
 */