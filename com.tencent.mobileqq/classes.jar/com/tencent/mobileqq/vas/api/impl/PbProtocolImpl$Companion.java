package com.tencent.mobileqq.vas.api.impl;

import NS_QWEB_PROTOCAL.PROTOCAL.StQWebReq;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.vas.util.VasUtil;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.QUA;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/api/impl/PbProtocolImpl$Companion;", "", "()V", "TAG", "", "seq", "", "generateDeviceInfo", "generateTraceId", "getRequestWrapper", "Lcom/tencent/mobileqq/pb/MessageMicro;", "reqBytes", "", "parseReponseInfo", "rspBytes", "parseResponseWrapper", "", "wupBuff", "([B)[Ljava/lang/Object;", "vas-impl_release"}, k=1, mv={1, 1, 16})
public final class PbProtocolImpl$Companion
{
  @JvmStatic
  @NotNull
  public final MessageMicro<?> a(@Nullable byte[] paramArrayOfByte)
  {
    paramArrayOfByte = ByteStringMicro.copyFrom(paramArrayOfByte);
    PROTOCAL.StQWebReq localStQWebReq = new PROTOCAL.StQWebReq();
    Object localObject = localStQWebReq.Seq;
    PbProtocolImpl.access$setSeq$cp(PbProtocolImpl.access$getSeq$cp() + 1L);
    ((PBUInt64Field)localObject).set(PbProtocolImpl.access$getSeq$cp());
    localStQWebReq.qua.set(QUA.getQUA3());
    localObject = localStQWebReq.deviceInfo;
    Companion localCompanion = (Companion)this;
    ((PBStringField)localObject).set(localCompanion.a());
    localStQWebReq.busiBuff.set(paramArrayOfByte);
    localStQWebReq.traceid.set(localCompanion.b());
    return (MessageMicro)localStQWebReq;
  }
  
  @JvmStatic
  @Nullable
  public final String a()
  {
    Object localObject2 = PlatformInfor.g().getDeviceInfor();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "PlatformInfor.g().getDeviceInfor()");
    Object localObject1 = localObject2;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((String)localObject2).length() > 0)
      {
        localObject1 = new StringBuilder((String)localObject2);
        ((StringBuilder)localObject1).append('&');
        ((StringBuilder)localObject1).append("timezone=");
        localObject2 = TimeZone.getDefault();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "TimeZone.getDefault()");
        ((StringBuilder)localObject1).append(((TimeZone)localObject2).getID());
        localObject2 = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("qqcircle");
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "QRoute.api(ILbsManagerSe…CachedLbsInfo(\"qqcircle\")");
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
  
  @JvmStatic
  @NotNull
  public final Object[] a(@Nullable byte[] paramArrayOfByte)
  {
    PROTOCAL.StQWebRsp localStQWebRsp = new PROTOCAL.StQWebRsp();
    localStQWebRsp.mergeFrom(paramArrayOfByte);
    return new Object[] { Long.valueOf(localStQWebRsp.retCode.get()), localStQWebRsp.errMsg.get().toStringUtf8(), localStQWebRsp.busiBuff.get() };
  }
  
  @JvmStatic
  @Nullable
  public final String b()
  {
    String str = VasUtil.a();
    Intrinsics.checkExpressionValueIsNotNull(str, "VasUtil.getCurrentUin()");
    StringBuilder localStringBuilder = new StringBuilder(50);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("MMddHHmmss");
    Random localRandom = new Random();
    localRandom.setSeed(System.currentTimeMillis());
    localStringBuilder.append(str);
    localStringBuilder.append("_");
    localStringBuilder.append(localSimpleDateFormat.format(new Date()));
    localStringBuilder.append(System.currentTimeMillis() % 1000);
    localStringBuilder.append("_");
    localStringBuilder.append(localRandom.nextInt(90000) + 10000);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.api.impl.PbProtocolImpl.Companion
 * JD-Core Version:    0.7.0.1
 */