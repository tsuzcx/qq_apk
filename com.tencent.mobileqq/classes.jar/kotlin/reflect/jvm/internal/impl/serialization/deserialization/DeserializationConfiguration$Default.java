package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

public final class DeserializationConfiguration$Default
  implements DeserializationConfiguration
{
  public static final Default INSTANCE = new Default();
  
  public boolean getReleaseCoroutines()
  {
    return DeserializationConfiguration.DefaultImpls.getReleaseCoroutines(this);
  }
  
  public boolean getReportErrorsOnPreReleaseDependencies()
  {
    return DeserializationConfiguration.DefaultImpls.getReportErrorsOnPreReleaseDependencies(this);
  }
  
  public boolean getSkipMetadataVersionCheck()
  {
    return DeserializationConfiguration.DefaultImpls.getSkipMetadataVersionCheck(this);
  }
  
  public boolean getTypeAliasesAllowed()
  {
    return DeserializationConfiguration.DefaultImpls.getTypeAliasesAllowed(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration.Default
 * JD-Core Version:    0.7.0.1
 */