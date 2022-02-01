package com.tencent.mobileqq.haoliyou;

import android.net.Uri;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class JumpForwardSecurityCheck$1
  implements UriParserPathHelper.IOnFileCopyFinishListener
{
  JumpForwardSecurityCheck$1(JumpForwardSecurityCheck paramJumpForwardSecurityCheck, int paramInt, String paramString) {}
  
  public void a(Uri paramUri)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("system share.prepareFileInfoAndReq : onFaild= ");
    localStringBuilder.append(paramUri);
    QLog.e("CheckForward.Security", 1, localStringBuilder.toString());
    this.c.a.finish();
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    paramString2 = new StringBuilder();
    paramString2.append("system share.prepareFileInfoAndReq : onFinish= ");
    paramString2.append(paramString1);
    QLog.d("CheckForward.Security", 1, paramString2.toString());
    try
    {
      if (this.a == 2)
      {
        paramString2 = new ArrayList();
        paramString2.add(paramString1);
        this.c.a(paramString2, this.b);
        return;
      }
      if (this.a == 4)
      {
        paramString2 = new ArrayList();
        paramString2.add(paramString1);
        this.c.b(paramString2, this.b);
        return;
      }
      if (this.a == 3)
      {
        this.c.a(paramString1, this.b);
        return;
      }
    }
    catch (Throwable paramString1)
    {
      QLog.e("CheckForward.Security", 1, "system share.prepareFileInfoAndReq exception=", paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.haoliyou.JumpForwardSecurityCheck.1
 * JD-Core Version:    0.7.0.1
 */