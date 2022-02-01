package com.tencent.qqprotect.qsec;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqprotect.sfcfg.TXSafeCheckUtil;
import java.io.File;

public class ICloudAVEngine$ApkDetectBundle
  extends ICloudAVEngine.DetectBundle
{
  public ICloudAVEngine$ApkDetectBundle(String paramString)
  {
    this.a = 1;
    this.b = 1;
    this.f = paramString;
  }
  
  public String a()
  {
    if (TextUtils.isEmpty(this.f)) {
      return null;
    }
    try
    {
      Object localObject = BaseApplication.getContext().getPackageManager().getPackageInfo(this.f, 192);
      if (localObject != null)
      {
        if ((((PackageInfo)localObject).signatures != null) && (((PackageInfo)localObject).signatures.length > 0)) {
          this.h = SecUtil.getSignatureHash(localObject.signatures[0].toByteArray());
        }
        if (((PackageInfo)localObject).applicationInfo != null)
        {
          this.d = ((PackageInfo)localObject).applicationInfo.sourceDir;
          this.c = ((int)new File(this.d).length());
          this.g = ((PackageInfo)localObject).applicationInfo.loadLabel(BaseApplication.getContext().getPackageManager()).toString();
          localObject = new byte[16];
          TXSafeCheckUtil.a(this.d, "META-INF/MANIFEST.MF", (byte[])localObject);
          this.e = SecUtil.toHexString((byte[])localObject);
        }
      }
      localObject = this.e;
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.ICloudAVEngine.ApkDetectBundle
 * JD-Core Version:    0.7.0.1
 */