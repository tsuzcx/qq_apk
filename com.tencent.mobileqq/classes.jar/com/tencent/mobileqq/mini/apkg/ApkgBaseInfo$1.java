package com.tencent.mobileqq.mini.apkg;

import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;

class ApkgBaseInfo$1
  implements Runnable
{
  ApkgBaseInfo$1(ApkgBaseInfo paramApkgBaseInfo, int paramInt, String paramString) {}
  
  public void run()
  {
    Toast.makeText(BaseApplicationImpl.getContext(), ApkgBaseInfo.access$000()[this.val$domainType] + HardCodeUtil.a(2131700364) + this.val$lowCaseUrl, 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.ApkgBaseInfo.1
 * JD-Core Version:    0.7.0.1
 */