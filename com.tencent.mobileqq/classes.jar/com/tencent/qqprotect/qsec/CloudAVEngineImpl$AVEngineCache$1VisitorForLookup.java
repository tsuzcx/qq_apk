package com.tencent.qqprotect.qsec;

final class CloudAVEngineImpl$AVEngineCache$1VisitorForLookup
  extends CloudAVEngineImpl.AVEngineCache.CacheFileVisitor
{
  public ICloudAVEngine.ResultBundle a = null;
  private String c;
  
  public CloudAVEngineImpl$AVEngineCache$1VisitorForLookup(CloudAVEngineImpl.AVEngineCache paramAVEngineCache, String paramString)
  {
    super(null);
    this.c = paramString;
  }
  
  public boolean a(String paramString, ICloudAVEngine.ResultBundle paramResultBundle)
  {
    if (paramString.equalsIgnoreCase(this.c))
    {
      this.a = paramResultBundle;
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.CloudAVEngineImpl.AVEngineCache.1VisitorForLookup
 * JD-Core Version:    0.7.0.1
 */