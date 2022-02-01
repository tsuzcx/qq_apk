package com.tencent.qqprotect.qsec;

final class CloudAVEngineImpl$AVEngineCache$1VisitorForLookup
  extends CloudAVEngineImpl.AVEngineCache.CacheFileVisitor
{
  public ICloudAVEngine.ResultBundle a;
  private String jdField_a_of_type_JavaLangString;
  
  public CloudAVEngineImpl$AVEngineCache$1VisitorForLookup(CloudAVEngineImpl.AVEngineCache paramAVEngineCache, String paramString)
  {
    super(null);
    this.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$ResultBundle = null;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public boolean a(String paramString, ICloudAVEngine.ResultBundle paramResultBundle)
  {
    if (paramString.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$ResultBundle = paramResultBundle;
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.CloudAVEngineImpl.AVEngineCache.1VisitorForLookup
 * JD-Core Version:    0.7.0.1
 */