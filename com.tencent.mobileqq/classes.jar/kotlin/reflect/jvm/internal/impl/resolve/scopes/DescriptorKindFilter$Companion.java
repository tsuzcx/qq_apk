package kotlin.reflect.jvm.internal.impl.resolve.scopes;

public final class DescriptorKindFilter$Companion
{
  private final int nextMask()
  {
    int i = DescriptorKindFilter.access$getNextMaskValue$cp();
    DescriptorKindFilter.access$setNextMaskValue$cp(DescriptorKindFilter.access$getNextMaskValue$cp() << 1);
    return i;
  }
  
  public final int getALL_KINDS_MASK()
  {
    return DescriptorKindFilter.access$getALL_KINDS_MASK$cp();
  }
  
  public final int getCLASSIFIERS_MASK()
  {
    return DescriptorKindFilter.access$getCLASSIFIERS_MASK$cp();
  }
  
  public final int getFUNCTIONS_MASK()
  {
    return DescriptorKindFilter.access$getFUNCTIONS_MASK$cp();
  }
  
  public final int getNON_SINGLETON_CLASSIFIERS_MASK()
  {
    return DescriptorKindFilter.access$getNON_SINGLETON_CLASSIFIERS_MASK$cp();
  }
  
  public final int getPACKAGES_MASK()
  {
    return DescriptorKindFilter.access$getPACKAGES_MASK$cp();
  }
  
  public final int getSINGLETON_CLASSIFIERS_MASK()
  {
    return DescriptorKindFilter.access$getSINGLETON_CLASSIFIERS_MASK$cp();
  }
  
  public final int getTYPE_ALIASES_MASK()
  {
    return DescriptorKindFilter.access$getTYPE_ALIASES_MASK$cp();
  }
  
  public final int getVARIABLES_MASK()
  {
    return DescriptorKindFilter.access$getVARIABLES_MASK$cp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter.Companion
 * JD-Core Version:    0.7.0.1
 */