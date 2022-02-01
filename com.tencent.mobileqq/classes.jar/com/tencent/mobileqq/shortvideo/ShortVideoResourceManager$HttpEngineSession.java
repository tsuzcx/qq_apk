package com.tencent.mobileqq.shortvideo;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ShortVideoResourceManager$HttpEngineSession
{
  HttpNetReq a;
  ArrayList<ShortVideoResourceManager.INet_ShortVideoResource> b = new ArrayList(1);
  String c;
  int d;
  int e = 0;
  
  ShortVideoResourceManager$HttpEngineSession(ShortVideoResourceManager paramShortVideoResourceManager, HttpNetReq paramHttpNetReq)
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
      QLog.d("ShortVideoResourceManager", 2, localStringBuilder.toString());
    }
    this.e = 1;
    ((IHttpEngineService)ShortVideoResourceManager.a(this.f).getRuntimeService(IHttpEngineService.class, "all")).sendReq(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.HttpEngineSession
 * JD-Core Version:    0.7.0.1
 */