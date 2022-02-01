package kotlin.reflect.full;

import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class KClasses$allSupertypes$1$1$1$1
  extends Lambda
  implements Function0
{
  public static final 1 INSTANCE = new 1();
  
  KClasses$allSupertypes$1$1$1$1()
  {
    super(0);
  }
  
  @NotNull
  public final Void invoke()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("An operation is not implemented: ");
    localStringBuilder.append("Java type for supertype");
    throw ((Throwable)new NotImplementedError(localStringBuilder.toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.full.KClasses.allSupertypes.1.1.1.1
 * JD-Core Version:    0.7.0.1
 */