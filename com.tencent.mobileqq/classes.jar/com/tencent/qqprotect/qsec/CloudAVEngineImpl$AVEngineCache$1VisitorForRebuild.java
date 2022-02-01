package com.tencent.qqprotect.qsec;

import android.util.Xml;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.xmlpull.v1.XmlSerializer;

final class CloudAVEngineImpl$AVEngineCache$1VisitorForRebuild
  extends CloudAVEngineImpl.AVEngineCache.CacheFileVisitor
{
  File a;
  private XmlSerializer c;
  private OutputStream d;
  
  public CloudAVEngineImpl$AVEngineCache$1VisitorForRebuild(CloudAVEngineImpl.AVEngineCache paramAVEngineCache, File paramFile)
  {
    super(null);
    this.a = paramFile;
  }
  
  public void a()
  {
    try
    {
      Object localObject1 = this.c;
      Object localObject2;
      Object localObject3;
      if (localObject1 == null)
      {
        localObject1 = new IvParameterSpec(CloudAVEngineImpl.AVEngineCache.b());
        localObject2 = new SecretKeySpec(CloudAVEngineImpl.AVEngineCache.c(), "AES");
        localObject3 = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        ((Cipher)localObject3).init(1, (Key)localObject2, (AlgorithmParameterSpec)localObject1);
        this.d = new CipherOutputStream(new BufferedOutputStream(new FileOutputStream(this.a)), (Cipher)localObject3);
        this.c = Xml.newSerializer();
        this.c.setOutput(this.d, "UTF-8");
        this.c.startDocument("UTF-8", Boolean.valueOf(true));
        this.c.startTag(null, "AVCloudCache");
        this.c.attribute(null, "Ver", Integer.toString(1));
      }
      if (CloudAVEngineImpl.AVEngineCache.a(this.b).size() > 0)
      {
        localObject1 = CloudAVEngineImpl.AVEngineCache.a(this.b).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Pair)((Iterator)localObject1).next();
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("Add new cache entry: ");
            ((StringBuilder)localObject3).append(((ICloudAVEngine.ResultBundle)((Pair)localObject2).second).toString());
            QLog.d("QSec.AVEngine", 2, ((StringBuilder)localObject3).toString());
          }
          CloudAVEngineImpl.AVEngineCache.a(this.b, (String)((Pair)localObject2).first, (ICloudAVEngine.ResultBundle)((Pair)localObject2).second, this.c);
        }
        CloudAVEngineImpl.AVEngineCache.a(this.b).clear();
      }
      this.c.endTag(null, "AVCloudCache");
      this.c.endDocument();
      CloudAVEngineImpl.AVEngineCache.b(this.b).delete();
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    OutputStream localOutputStream = this.d;
    if (localOutputStream != null) {}
    try
    {
      localOutputStream.close();
      return;
    }
    catch (Exception localException2) {}
  }
  
  public boolean a(String paramString, ICloudAVEngine.ResultBundle paramResultBundle)
  {
    try
    {
      if (this.c == null)
      {
        IvParameterSpec localIvParameterSpec = new IvParameterSpec(CloudAVEngineImpl.AVEngineCache.b());
        SecretKeySpec localSecretKeySpec = new SecretKeySpec(CloudAVEngineImpl.AVEngineCache.c(), "AES");
        Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        localCipher.init(1, localSecretKeySpec, localIvParameterSpec);
        this.d = new CipherOutputStream(new BufferedOutputStream(new FileOutputStream(this.a)), localCipher);
        this.c = Xml.newSerializer();
        this.c.setOutput(this.d, "UTF-8");
        this.c.startDocument("UTF-8", Boolean.valueOf(true));
        this.c.startTag(null, "AVCloudCache");
        this.c.attribute(null, "Ver", Integer.toString(1));
      }
      CloudAVEngineImpl.AVEngineCache.a(this.b, paramString, paramResultBundle, this.c);
      return true;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      this.c = null;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.CloudAVEngineImpl.AVEngineCache.1VisitorForRebuild
 * JD-Core Version:    0.7.0.1
 */