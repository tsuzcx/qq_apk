package com.tencent.mobileqq.nearby.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.Cmd2HandlerMap;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.nearby.api.IService;
import com.tencent.mobileqq.nearby.api.NearbyServlet;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.service.lbs.NearbyProtocolCoder;
import java.util.Map;
import java.util.Random;
import mqq.app.MSFServlet;

public class ServiceImpl
  extends MobileQQServiceBase
  implements IService
{
  INearbyAppInterface a;
  Random b = new Random();
  
  public ServiceImpl(INearbyAppInterface paramINearbyAppInterface)
  {
    this.a = paramINearbyAppInterface;
    seq = Math.abs(this.b.nextInt());
  }
  
  public AppInterface getAppInterface()
  {
    return (AppInterface)this.a;
  }
  
  protected Map<String, String[]> getCompatibleCmd2HandlerMap()
  {
    return Cmd2HandlerMap.a();
  }
  
  protected Class<? extends MSFServlet> getServlet()
  {
    return NearbyServlet.class;
  }
  
  protected void initCoders()
  {
    try
    {
      super.addCoder(new NearbyProtocolCoder((AppInterface)this.a));
      super.setCodersInit();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.impl.ServiceImpl
 * JD-Core Version:    0.7.0.1
 */