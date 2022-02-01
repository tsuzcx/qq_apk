package com.tencent.mobileqq.jsp;

import com.tencent.mobileqq.identification.AppConf;
import com.tencent.mobileqq.identification.FaceConf;
import com.tencent.mobileqq.identification.FaceLoginHelper.IConfInterface;
import com.tencent.qphone.base.util.QLog;

class IdentificationApiPlugin$2
  implements FaceLoginHelper.IConfInterface
{
  IdentificationApiPlugin$2(IdentificationApiPlugin paramIdentificationApiPlugin) {}
  
  public void a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getAppConf error, code : ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" errorMsg : ");
    localStringBuilder.append(paramString);
    QLog.e("IdentificationApiPlugin", 1, localStringBuilder.toString());
    if (IdentificationApiPlugin.a(this.a) == null)
    {
      QLog.e("IdentificationApiPlugin", 1, "getConfFailed, activity is null");
      return;
    }
    this.a.a(paramInt, paramString);
  }
  
  public void a(AppConf paramAppConf)
  {
    if (IdentificationApiPlugin.a(this.a) == null)
    {
      QLog.e("IdentificationApiPlugin", 1, "getConfSuccess, activity is null");
      return;
    }
    this.a.a.setAppConf(paramAppConf);
    paramAppConf = this.a;
    paramAppConf.a(paramAppConf.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.IdentificationApiPlugin.2
 * JD-Core Version:    0.7.0.1
 */