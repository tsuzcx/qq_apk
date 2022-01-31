package com.tencent.mobileqq.microapp.apkg;

import Wallet.ApkgConfig;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public final class a$a
  implements Serializable
{
  public ApkgConfig a;
  public List b;
  
  public a$a() {}
  
  public a$a(ApkgConfig paramApkgConfig)
  {
    this.a = paramApkgConfig;
  }
  
  public void a(ApkgConfig paramApkgConfig)
  {
    ApkgConfig localApkgConfig = this.a;
    this.a = paramApkgConfig;
    if ((localApkgConfig != null) && (localApkgConfig.mini_version != paramApkgConfig.mini_version))
    {
      if (this.b == null) {
        this.b = new LinkedList();
      }
      this.b.add(paramApkgConfig);
      if (this.b.size() > 1)
      {
        paramApkgConfig = (ApkgConfig)this.b.get(0);
        this.b.remove(0);
        a.a(paramApkgConfig);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.apkg.a.a
 * JD-Core Version:    0.7.0.1
 */