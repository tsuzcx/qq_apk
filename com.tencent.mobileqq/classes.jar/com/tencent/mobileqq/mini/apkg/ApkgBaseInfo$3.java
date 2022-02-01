package com.tencent.mobileqq.mini.apkg;

import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.BaseApplication;

class ApkgBaseInfo$3
  implements Runnable
{
  ApkgBaseInfo$3(ApkgBaseInfo paramApkgBaseInfo, String paramString) {}
  
  public void run()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ApkgBaseInfo.access$000()[5]);
    localStringBuilder.append(HardCodeUtil.a(2131700505));
    localStringBuilder.append(this.val$ip);
    Toast.makeText(localBaseApplication, localStringBuilder.toString(), 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.ApkgBaseInfo.3
 * JD-Core Version:    0.7.0.1
 */