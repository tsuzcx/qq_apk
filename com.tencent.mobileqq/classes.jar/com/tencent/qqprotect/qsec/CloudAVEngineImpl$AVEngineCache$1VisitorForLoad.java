package com.tencent.qqprotect.qsec;

import com.tencent.qphone.base.util.QLog;
import java.util.Date;

final class CloudAVEngineImpl$AVEngineCache$1VisitorForLoad
  extends CloudAVEngineImpl.AVEngineCache.CacheFileVisitor
{
  CloudAVEngineImpl$AVEngineCache$1VisitorForLoad(CloudAVEngineImpl.AVEngineCache paramAVEngineCache)
  {
    super(null);
  }
  
  public boolean a(String paramString, ICloudAVEngine.ResultBundle paramResultBundle)
  {
    if (this.a.size() >= this.a.maxSize())
    {
      CloudAVEngineImpl.AVEngineCache.a(this.a, false);
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, "Cache not load completely.");
      }
      return false;
    }
    if (paramResultBundle.d > new Date().getTime())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, String.format("Add cache entry, key: %s, %s", new Object[] { paramString, paramResultBundle.toString() }));
      }
      this.a.put(paramString, paramResultBundle);
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QSec.AVEngine", 2, String.format("Discard expired entry, key: %s, %s", new Object[] { paramString, paramResultBundle.toString() }));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.CloudAVEngineImpl.AVEngineCache.1VisitorForLoad
 * JD-Core Version:    0.7.0.1
 */