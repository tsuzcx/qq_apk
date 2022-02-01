package com.tencent.mobileqq.jsp;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.identification.FaceLoginHelper.IConfInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class IdentificationApiPlugin$2
  implements FaceLoginHelper.IConfInterface
{
  IdentificationApiPlugin$2(IdentificationApiPlugin paramIdentificationApiPlugin) {}
  
  public void a(int paramInt, String paramString)
  {
    QLog.e("IdentificationApiPlugin", 1, "getAppConf error, code : " + paramInt + " errorMsg : " + paramString);
    if (IdentificationApiPlugin.a(this.a) == null)
    {
      QLog.e("IdentificationApiPlugin", 1, "getConfFailed, activity is null");
      return;
    }
    ThreadManager.getUIHandler().post(new IdentificationApiPlugin.2.2(this, paramString));
  }
  
  public void a(FaceDetectForThirdPartyManager.AppConf paramAppConf)
  {
    if (IdentificationApiPlugin.a(this.a) == null)
    {
      QLog.e("IdentificationApiPlugin", 1, "getConfSuccess, activity is null");
      return;
    }
    ThreadManager.getUIHandler().post(new IdentificationApiPlugin.2.1(this, paramAppConf));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.IdentificationApiPlugin.2
 * JD-Core Version:    0.7.0.1
 */