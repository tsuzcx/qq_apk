package com.tencent.mobileqq.shortvideo;

import com.tencent.device.file.DevLittleVideoSendOperator;
import com.tencent.device.file.DevShortVideoSendOperator;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.api.IShortVideoFactory;
import com.tencent.mobileqq.shortvideo.api.IShortVideoOperator;

public class ShortVideoBusiManager
{
  public static ShortVideoUploadInfo a(int paramInt, Object paramObject, ShortVideoReq paramShortVideoReq)
  {
    return a(paramInt, null).a(paramObject, paramShortVideoReq);
  }
  
  public static ShortVideoUploadInfo a(Object paramObject, ShortVideoReq paramShortVideoReq)
  {
    return a(paramShortVideoReq.b, null).a(paramObject, paramShortVideoReq);
  }
  
  static IShortVideoOperator a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 4: 
      if (paramQQAppInterface == null) {
        return new DevLittleVideoSendOperator();
      }
      return new DevLittleVideoSendOperator(paramQQAppInterface);
    case 1: 
      if (paramQQAppInterface == null) {
        return new DevShortVideoSendOperator();
      }
      return new DevShortVideoSendOperator(paramQQAppInterface);
    }
    return ((IShortVideoFactory)QRoute.api(IShortVideoFactory.class)).getAioShortVideoSendOperator(paramQQAppInterface);
  }
  
  public static void a(ShortVideoReq paramShortVideoReq, QQAppInterface paramQQAppInterface)
  {
    if (paramShortVideoReq == null)
    {
      Logger.b("ShortVideoBusiManager", "launch", "error,req == null");
      return;
    }
    if (paramShortVideoReq.a == 2)
    {
      localObject = new BaseSVReceiveOperator(paramQQAppInterface);
      a(paramShortVideoReq, paramQQAppInterface, (IShortVideoOperator)localObject);
      ((BaseSVReceiveOperator)localObject).a(paramShortVideoReq.e);
      return;
    }
    Object localObject = a(paramShortVideoReq.b, paramQQAppInterface);
    if (localObject == null)
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("error,operator == null,req.busiType:");
      paramQQAppInterface.append(paramShortVideoReq.b);
      Logger.b("ShortVideoBusiManager", "launch", paramQQAppInterface.toString());
      return;
    }
    a(paramShortVideoReq, paramQQAppInterface, (IShortVideoOperator)localObject);
    int i = paramShortVideoReq.a;
    if ((i != 0) && (i != 1))
    {
      if ((i != 3) && (i != 4))
      {
        if (i != 5) {
          return;
        }
        ((IShortVideoOperator)localObject).a(paramShortVideoReq.h);
        return;
      }
      ((IShortVideoOperator)localObject).b(paramShortVideoReq.g);
      return;
    }
    ((IShortVideoOperator)localObject).b(paramShortVideoReq.f);
  }
  
  private static void a(ShortVideoReq paramShortVideoReq, QQAppInterface paramQQAppInterface, IShortVideoOperator paramIShortVideoOperator)
  {
    paramIShortVideoOperator.a(paramQQAppInterface);
    paramIShortVideoOperator.a(paramShortVideoReq);
    paramIShortVideoOperator.a(paramShortVideoReq.c);
    paramIShortVideoOperator.b(paramShortVideoReq.d);
    paramIShortVideoOperator.a(paramShortVideoReq.i);
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("cmd:");
    paramQQAppInterface.append(SVUtils.c(paramShortVideoReq.a));
    paramQQAppInterface.append(", reqBusiType");
    paramQQAppInterface.append(paramShortVideoReq.b);
    paramQQAppInterface.append(", uuid:");
    paramQQAppInterface.append(paramShortVideoReq.c);
    Logger.a("ShortVideoBusiManager", "launch", paramQQAppInterface.toString());
  }
  
  public static ShortVideoForwardInfo b(int paramInt, Object paramObject, ShortVideoReq paramShortVideoReq)
  {
    return a(paramInt, null).b(paramObject, paramShortVideoReq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoBusiManager
 * JD-Core Version:    0.7.0.1
 */