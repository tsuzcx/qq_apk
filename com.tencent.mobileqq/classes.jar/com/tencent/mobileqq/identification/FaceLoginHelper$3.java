package com.tencent.mobileqq.identification;

import android.os.Bundle;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager.AppConf;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class FaceLoginHelper$3
  implements EIPCResultCallback
{
  FaceLoginHelper$3(FaceLoginHelper.IConfInterface paramIConfInterface) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    String str = null;
    QLog.d("FaceLoginHelper", 1, "callServer error_code:" + paramEIPCResult.code);
    FaceDetectForThirdPartyManager.AppConf localAppConf;
    switch (paramEIPCResult.code)
    {
    default: 
      str = HardCodeUtil.a(2131714394);
      localAppConf = null;
    }
    while ((paramEIPCResult.code != 0) || (paramEIPCResult.data == null))
    {
      this.a.a(paramEIPCResult.code, str);
      return;
      if (paramEIPCResult.data != null)
      {
        localAppConf = (FaceDetectForThirdPartyManager.AppConf)paramEIPCResult.data.getSerializable("FaceRecognition.AppConf");
        QLog.d("FaceLoginHelper", 1, "callServer error_code:" + localAppConf);
      }
      else
      {
        str = HardCodeUtil.a(2131714394);
        localAppConf = null;
        continue;
        str = HardCodeUtil.a(2131692221);
        localAppConf = null;
      }
    }
    this.a.a(localAppConf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.identification.FaceLoginHelper.3
 * JD-Core Version:    0.7.0.1
 */