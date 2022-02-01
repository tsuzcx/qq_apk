package com.tencent.qqprotect.qsec;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Iterator;
import java.util.List;

public class PackageScanner
  implements IScanner
{
  private boolean a = false;
  private OnScanListener b = null;
  
  public PackageScanner(OnScanListener paramOnScanListener)
  {
    this.b = paramOnScanListener;
  }
  
  private void c()
  {
    if (this.a) {
      return;
    }
    this.a = true;
    OnScanListener localOnScanListener = this.b;
    if (localOnScanListener != null) {
      localOnScanListener.a(b(), null);
    }
  }
  
  private void d()
  {
    Object localObject = BaseApplication.getContext().getPackageManager();
    if (localObject != null)
    {
      localObject = ((PackageManager)localObject).getInstalledPackages(8192).iterator();
      while (((Iterator)localObject).hasNext())
      {
        PackageInfo localPackageInfo = (PackageInfo)((Iterator)localObject).next();
        if (!this.a) {
          return;
        }
        OnScanListener localOnScanListener = this.b;
        if (localOnScanListener != null) {
          localOnScanListener.b(b(), localPackageInfo);
        }
      }
    }
  }
  
  private void e()
  {
    if (!this.a) {
      return;
    }
    this.a = false;
    OnScanListener localOnScanListener = this.b;
    if (localOnScanListener != null) {
      localOnScanListener.c(b(), null);
    }
  }
  
  public void a()
  {
    if (this.a) {
      return;
    }
    try
    {
      c();
      d();
      label16:
      e();
      return;
    }
    catch (Exception localException)
    {
      break label16;
    }
  }
  
  public String b()
  {
    return "App";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.PackageScanner
 * JD-Core Version:    0.7.0.1
 */