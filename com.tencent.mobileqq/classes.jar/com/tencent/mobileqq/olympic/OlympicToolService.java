package com.tencent.mobileqq.olympic;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.Cmd2HandlerMap;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.Random;
import mqq.app.MSFServlet;

public class OlympicToolService
  extends MobileQQServiceBase
{
  OlympicToolAppInterface a;
  Random b = new Random();
  
  OlympicToolService(OlympicToolAppInterface paramOlympicToolAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.i("OlympicToolService", 2, "new OlympicToolService");
    }
    this.a = paramOlympicToolAppInterface;
    seq = Math.abs(this.b.nextInt());
  }
  
  public AppInterface getAppInterface()
  {
    return this.a;
  }
  
  protected Map<String, String[]> getCompatibleCmd2HandlerMap()
  {
    return Cmd2HandlerMap.a();
  }
  
  protected Class<? extends MSFServlet> getServlet()
  {
    return OlympicToolServlet.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.OlympicToolService
 * JD-Core Version:    0.7.0.1
 */