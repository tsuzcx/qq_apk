package com.tencent.qqprotect.qsec;

import android.util.Base64;
import android.util.LruCache;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.common.CommTvRpt;
import com.tencent.util.Pair;
import java.io.File;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

final class CloudAVEngineImpl$AVEngineCache
  extends LruCache<String, ICloudAVEngine.ResultBundle>
{
  private static final byte[] a = { 90, 39, 2, -61, -88, -75, -36, 105, -102, 55, 18, 69, -72, -11, -84, 50 };
  private static final byte[] b = { -86, 39, 34, -61, -88, -75, -84, 105, 74, 39, 2, 35, -85, -74, -68, 105 };
  private File c;
  private File d;
  private boolean e = true;
  private boolean f = false;
  private List<Pair<String, ICloudAVEngine.ResultBundle>> g = new LinkedList();
  
  public CloudAVEngineImpl$AVEngineCache(String paramString, int paramInt)
  {
    super(paramInt);
    this.c = new File(paramString);
    paramString = new StringBuilder();
    paramString.append(this.c.getPath());
    paramString.append(".bak");
    this.d = new File(paramString.toString());
    d();
  }
  
  private void a(CloudAVEngineImpl.AVEngineCache.CacheFileVisitor paramCacheFileVisitor)
  {
    if (this.d.exists())
    {
      this.c.delete();
      this.d.renameTo(this.c);
    }
    if ((this.c.exists()) && (this.c.isFile()))
    {
      int i = 0;
      if (this.c.length() > 10485760L)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Cache file too big: ");
          localStringBuilder.append(this.c.length());
          QLog.d("QSec.AVEngine", 2, localStringBuilder.toString());
        }
        i = 1;
      }
      new CloudAVEngineImpl.AVEngineCache.CacheFileReader(this.c, paramCacheFileVisitor).a();
      if (i != 0)
      {
        CommTvRpt.a(2, 2);
        this.c.delete();
      }
    }
  }
  
  private void a(String paramString, ICloudAVEngine.ResultBundle paramResultBundle, XmlSerializer paramXmlSerializer)
  {
    if (paramResultBundle.d > new Date().getTime())
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Write entry: ");
        localStringBuilder.append(paramResultBundle.toString());
        QLog.d("QSec.AVEngine", 2, localStringBuilder.toString());
      }
      try
      {
        paramXmlSerializer.startTag(null, "CacheEntry");
        paramXmlSerializer.attribute(null, "Key", paramString);
        paramXmlSerializer.attribute(null, "AttrType", Integer.toString(paramResultBundle.a));
        paramXmlSerializer.attribute(null, "Category", Integer.toString(paramResultBundle.b));
        paramXmlSerializer.attribute(null, "SubCategory", Integer.toString(paramResultBundle.c));
        paramXmlSerializer.attribute(null, "Action", Integer.toString(paramResultBundle.e));
        paramXmlSerializer.attribute(null, "ExpireTime", Long.toString(paramResultBundle.d));
        if (paramResultBundle.g != null) {
          paramXmlSerializer.attribute(null, "ExtraInfo", Base64.encodeToString(paramResultBundle.g, 0));
        }
        paramXmlSerializer.endTag(null, "CacheEntry");
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("Discard expired entry for write: ");
      paramString.append(paramResultBundle.toString());
      QLog.d("QSec.AVEngine", 2, paramString.toString());
    }
  }
  
  private ICloudAVEngine.ResultBundle b(String paramString)
  {
    paramString = new CloudAVEngineImpl.AVEngineCache.1VisitorForLookup(this, paramString);
    a(paramString);
    return paramString.a;
  }
  
  private void d()
  {
    a(new CloudAVEngineImpl.AVEngineCache.1VisitorForLoad(this));
  }
  
  private boolean e()
  {
    if (this.c.exists()) {
      if (!this.d.exists())
      {
        if (!this.c.renameTo(this.d)) {
          return false;
        }
      }
      else {
        this.c.delete();
      }
    }
    new CloudAVEngineImpl.AVEngineCache.CacheFileReader(this.d, new CloudAVEngineImpl.AVEngineCache.1VisitorForRebuild(this, this.c)).a();
    return true;
  }
  
  public ICloudAVEngine.ResultBundle a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    Object localObject1 = (ICloudAVEngine.ResultBundle)super.get(paramString);
    Object localObject2;
    if (localObject1 != null)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Hit memory cache for key: ");
        ((StringBuilder)localObject2).append(paramString);
        QLog.d("QSec.AVEngine", 2, ((StringBuilder)localObject2).toString());
      }
      if (((ICloudAVEngine.ResultBundle)localObject1).d < new Date().getTime())
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Memory cache expired for key: ");
          ((StringBuilder)localObject1).append(paramString);
          QLog.d("QSec.AVEngine", 2, ((StringBuilder)localObject1).toString());
        }
        remove(paramString);
        return null;
      }
      return localObject1;
    }
    if ((!this.e) || (this.f == true))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Look from cache file for key: ");
        ((StringBuilder)localObject1).append(paramString);
        QLog.d("QSec.AVEngine", 2, ((StringBuilder)localObject1).toString());
      }
      localObject2 = b(paramString);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Hit file cache for key: ");
          ((StringBuilder)localObject1).append(paramString);
          QLog.d("QSec.AVEngine", 2, ((StringBuilder)localObject1).toString());
        }
        if (((ICloudAVEngine.ResultBundle)localObject2).d < new Date().getTime())
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("File cache expired for key: ");
            ((StringBuilder)localObject1).append(paramString);
            QLog.d("QSec.AVEngine", 2, ((StringBuilder)localObject1).toString());
          }
          return null;
        }
        put(paramString, localObject2);
        localObject1 = localObject2;
      }
    }
    return localObject1;
  }
  
  public void a()
  {
    if (this.g.size() > 0) {
      e();
    }
  }
  
  public void a(String paramString, ICloudAVEngine.ResultBundle paramResultBundle)
  {
    if ((paramString != null) && (paramResultBundle != null))
    {
      if (put(paramString, paramResultBundle) == null) {
        this.g.add(new Pair(paramString, paramResultBundle));
      }
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, String.format("Put to cache, key: %s, result: %s ", new Object[] { paramString, paramResultBundle.toString() }));
      }
      if (this.g.size() >= 5)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QSec.AVEngine", 2, "Trigger rebuild cache file");
        }
        e();
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString, ICloudAVEngine.ResultBundle paramResultBundle1, ICloudAVEngine.ResultBundle paramResultBundle2)
  {
    super.entryRemoved(paramBoolean, paramString, paramResultBundle1, paramResultBundle2);
    if (!paramBoolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QSec.AVEngine", 2, "Memory cache overflow.");
    }
    this.f = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.CloudAVEngineImpl.AVEngineCache
 * JD-Core Version:    0.7.0.1
 */