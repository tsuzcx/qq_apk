package kotlin.reflect.jvm.internal.impl.resolve.scopes;

public abstract class DescriptorKindExclude
{
  public abstract int getFullyExcludedDescriptorKinds();
  
  public String toString()
  {
    return getClass().getSimpleName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindExclude
 * JD-Core Version:    0.7.0.1
 */