package com.tencent.mobileqq.mini.apkg;

import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.BaseApplication;

class ApkgBaseInfo$2
  implements Runnable
{
  ApkgBaseInfo$2(ApkgBaseInfo paramApkgBaseInfo, int paramInt, DomainConfig paramDomainConfig) {}
  
  public void run()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ApkgBaseInfo.access$000()[this.val$domainType]);
    localStringBuilder.append(HardCodeUtil.a(2131898536));
    localStringBuilder.append(this.val$requestDomainConfig);
    Toast.makeText(localBaseApplication, localStringBuilder.toString(), 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.ApkgBaseInfo.2
 * JD-Core Version:    0.7.0.1
 */