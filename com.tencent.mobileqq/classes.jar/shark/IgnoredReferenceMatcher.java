package shark;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/IgnoredReferenceMatcher;", "Lshark/ReferenceMatcher;", "pattern", "Lshark/ReferencePattern;", "(Lshark/ReferencePattern;)V", "getPattern", "()Lshark/ReferencePattern;", "toString", "", "shark"}, k=1, mv={1, 4, 1})
public final class IgnoredReferenceMatcher
  extends ReferenceMatcher
{
  @NotNull
  private final ReferencePattern a;
  
  @NotNull
  public ReferencePattern a()
  {
    return this.a;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ignored ref: ");
    localStringBuilder.append(a());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.IgnoredReferenceMatcher
 * JD-Core Version:    0.7.0.1
 */