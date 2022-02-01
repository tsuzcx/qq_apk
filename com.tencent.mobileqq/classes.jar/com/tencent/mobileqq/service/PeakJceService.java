package com.tencent.mobileqq.service;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.servlet.AudioTransServlet;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import dov.com.qq.im.ae.config.CameraPeakDataService;
import dov.com.qq.im.aeeditor.manage.AEEditorDataService;

public class PeakJceService
  extends PeakJceServiceBase
{
  PeakAppInterface a;
  
  public PeakJceService(PeakAppInterface paramPeakAppInterface)
  {
    this.a = paramPeakAppInterface;
  }
  
  public AppInterface a()
  {
    return this.a;
  }
  
  protected void a()
  {
    try
    {
      super.a();
      a(new CameraPeakDataService());
      a(new AEEditorDataService());
      super.b();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    a(paramToServiceMsg, AudioTransServlet.class);
  }
  
  public void a(boolean paramBoolean, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    super.a(paramBoolean, paramToServiceMsg, paramFromServiceMsg, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.service.PeakJceService
 * JD-Core Version:    0.7.0.1
 */