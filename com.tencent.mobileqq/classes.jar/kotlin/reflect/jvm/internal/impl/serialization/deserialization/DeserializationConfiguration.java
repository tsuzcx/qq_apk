package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

public abstract interface DeserializationConfiguration
{
  public abstract boolean getReleaseCoroutines();
  
  public abstract boolean getReportErrorsOnPreReleaseDependencies();
  
  public abstract boolean getSkipMetadataVersionCheck();
  
  public abstract boolean getTypeAliasesAllowed();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration
 * JD-Core Version:    0.7.0.1
 */