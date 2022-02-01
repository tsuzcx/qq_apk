package com.tencent.mobileqq.vip;

import NS_QWEB_PROTOCAL.PROTOCAL.StQWebReq;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.vas.api.AbsProtocol;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.QUA;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

public class PbProtocol
  extends AbsProtocol
{
  private static long a;
  
  @NotNull
  public static MessageMicro a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = ByteStringMicro.copyFrom(paramArrayOfByte);
    PROTOCAL.StQWebReq localStQWebReq = new PROTOCAL.StQWebReq();
    PBUInt64Field localPBUInt64Field = localStQWebReq.Seq;
    long l = a + 1L;
    a = l;
    localPBUInt64Field.set(l);
    localStQWebReq.qua.set(QUA.getQUA3());
    localStQWebReq.deviceInfo.set(a());
    localStQWebReq.busiBuff.set(paramArrayOfByte);
    localStQWebReq.traceid.set(b());
    return localStQWebReq;
  }
  
  public static String a()
  {
    Object localObject2 = PlatformInfor.g().getDeviceInfor();
    Object localObject1 = localObject2;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((String)localObject2).length() > 0)
      {
        localObject1 = new StringBuilder((String)localObject2);
        ((StringBuilder)localObject1).append('&');
        ((StringBuilder)localObject1).append("timezone=");
        ((StringBuilder)localObject1).append(TimeZone.getDefault().getID());
        localObject2 = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("qqcircle");
        if ((localObject2 != null) && (((SosoLbsInfo)localObject2).mLocation != null))
        {
          ((StringBuilder)localObject1).append('&');
          ((StringBuilder)localObject1).append("latitude=");
          ((StringBuilder)localObject1).append(String.valueOf(((SosoLbsInfo)localObject2).mLocation.mLat02));
          ((StringBuilder)localObject1).append('&');
          ((StringBuilder)localObject1).append("longitude=");
          ((StringBuilder)localObject1).append(String.valueOf(((SosoLbsInfo)localObject2).mLocation.mLon02));
        }
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    return localObject1;
  }
  
  public static void a(String paramString, MessageMicro paramMessageMicro, Class paramClass, BusinessObserver paramBusinessObserver)
  {
    ((IApolloExtensionHandler)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(paramString, paramMessageMicro, paramClass, paramBusinessObserver);
  }
  
  public static void a(String paramString1, String paramString2, BusinessObserver paramBusinessObserver)
  {
    ((IApolloExtensionHandler)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(paramString1, paramString2, paramBusinessObserver);
  }
  
  public static void a(String paramString, byte[] paramArrayOfByte, BusinessObserver paramBusinessObserver)
  {
    ((IApolloExtensionHandler)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(paramString, paramArrayOfByte, paramBusinessObserver);
  }
  
  public static String b()
  {
    String str = BaseApplicationImpl.sApplication.getRuntime().getAccount();
    StringBuilder localStringBuilder = new StringBuilder(50);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("MMddHHmmss");
    Random localRandom = new Random();
    localRandom.setSeed(System.currentTimeMillis());
    localStringBuilder.append(str);
    localStringBuilder.append("_");
    localStringBuilder.append(localSimpleDateFormat.format(new Date()));
    localStringBuilder.append(System.currentTimeMillis() % 1000L);
    localStringBuilder.append("_");
    localStringBuilder.append(localRandom.nextInt(90000) + 10000);
    return localStringBuilder.toString();
  }
  
  public static byte[] b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    try
    {
      paramArrayOfByte = c(paramArrayOfByte);
      ((Long)paramArrayOfByte[0]).longValue();
      String str = (String)paramArrayOfByte[1];
      paramArrayOfByte = ((ByteStringMicro)paramArrayOfByte[2]).toByteArray();
      return paramArrayOfByte;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public static Object[] c(byte[] paramArrayOfByte)
  {
    PROTOCAL.StQWebRsp localStQWebRsp = new PROTOCAL.StQWebRsp();
    localStQWebRsp.mergeFrom(paramArrayOfByte);
    return new Object[] { Long.valueOf(localStQWebRsp.retCode.get()), localStQWebRsp.errMsg.get().toStringUtf8(), localStQWebRsp.busiBuff.get() };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vip.PbProtocol
 * JD-Core Version:    0.7.0.1
 */