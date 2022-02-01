package kotlin.reflect.jvm.internal.impl.resolve.scopes;

public final class DescriptorKindExclude$NonExtensions
  extends DescriptorKindExclude
{
  public static final NonExtensions INSTANCE = new NonExtensions();
  private static final int fullyExcludedDescriptorKinds = DescriptorKindFilter.Companion.getALL_KINDS_MASK() & ((DescriptorKindFilter.Companion.getFUNCTIONS_MASK() | DescriptorKindFilter.Companion.getVARIABLES_MASK()) ^ 0xFFFFFFFF);
  
  public int getFullyExcludedDescriptorKinds()
  {
    return fullyExcludedDescriptorKinds;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindExclude.NonExtensions
 * JD-Core Version:    0.7.0.1
 */