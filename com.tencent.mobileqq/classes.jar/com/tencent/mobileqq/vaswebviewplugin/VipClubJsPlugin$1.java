package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class VipClubJsPlugin$1
  implements EIPCResultCallback
{
  VipClubJsPlugin$1(VipClubJsPlugin paramVipClubJsPlugin) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GLDrawableDownloadHelper", 2, "requestDownloadDepends success");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.VipClubJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */