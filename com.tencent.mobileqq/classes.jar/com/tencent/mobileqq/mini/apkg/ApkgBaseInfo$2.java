package com.tencent.mobileqq.mini.apkg;

import ajyc;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;

class ApkgBaseInfo$2
  implements Runnable
{
  ApkgBaseInfo$2(ApkgBaseInfo paramApkgBaseInfo, int paramInt, DomainConfig paramDomainConfig) {}
  
  public void run()
  {
    Toast.makeText(BaseApplicationImpl.getContext(), ApkgBaseInfo.access$000()[this.val$domainType] + ajyc.a(2131700274) + this.val$requestDomainConfig, 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.ApkgBaseInfo.2
 * JD-Core Version:    0.7.0.1
 */