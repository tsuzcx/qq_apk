package dov.com.qq.im.ae.download.old;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class AEOldShortVideoResManager$HttpEngineSession
{
  HttpNetReq a;
  ArrayList<AEOldShortVideoResManager.INet_ShortVideoResource> b = new ArrayList(1);
  String c;
  int d;
  int e = 0;
  
  AEOldShortVideoResManager$HttpEngineSession(AEOldShortVideoResManager paramAEOldShortVideoResManager, HttpNetReq paramHttpNetReq)
  {
    this.a = paramHttpNetReq;
    this.e = 0;
  }
  
  void a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("HttpEngineTask[start]: ");
      localStringBuilder.append(this);
      QLog.d("AEOldShortVideoResManager", 2, localStringBuilder.toString());
    }
    this.e = 1;
    ((IHttpEngineService)AEOldShortVideoResManager.a(this.f).getRuntimeService(IHttpEngineService.class, "all")).sendReq(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     dov.com.qq.im.ae.download.old.AEOldShortVideoResManager.HttpEngineSession
 * JD-Core Version:    0.7.0.1
 */