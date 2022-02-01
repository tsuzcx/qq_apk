package com.tencent.mobileqq.wink.request.base;

import NS_QWEB_PROTOCAL.PROTOCAL.StQWebReq;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.data.QCircleExposeDataBean;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.utils.WupUtil;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.QUA;
import java.util.TimeZone;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public abstract class VSBaseRequest
  extends BaseRequest
{
  private final String QUA3 = QUA.getQUA3();
  private final AppRuntime mAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
  private long mNetworkTimeCost;
  private String mSsoFailMsg;
  private int mSsoResultCode;
  private int mSsoSeq;
  private final ThreadLocal<StringBuilder> mStringBuilder = new VSBaseRequest.1(this);
  
  private String a()
  {
    Object localObject = PlatformInfor.g().getDeviceInfor();
    this.mStringBuilder.set(new StringBuilder());
    StringBuilder localStringBuilder = (StringBuilder)this.mStringBuilder.get();
    if ((localObject != null) && (((String)localObject).length() > 0) && (localStringBuilder != null))
    {
      localStringBuilder.setLength(0);
      localStringBuilder.trimToSize();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append('&');
      localStringBuilder.append("timezone=");
      localStringBuilder.append(TimeZone.getDefault().getID());
      localObject = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("qqcircle");
      if ((localObject != null) && (((SosoLbsInfo)localObject).mLocation != null))
      {
        localStringBuilder.append('&');
        localStringBuilder.append("latitude=");
        localStringBuilder.append(getLatitude((SosoLbsInfo)localObject));
        localStringBuilder.append('&');
        localStringBuilder.append("longitude=");
        localStringBuilder.append(getLongitude((SosoLbsInfo)localObject));
      }
      localStringBuilder.append('&');
      localStringBuilder.append("vh265=");
      if ("".equals(QCircleExposeDataBean.sIsSupportHEVC)) {
        localObject = Integer.valueOf(0);
      } else {
        localObject = QCircleExposeDataBean.sIsSupportHEVC;
      }
      localStringBuilder.append(localObject);
      return localStringBuilder.toString();
    }
    this.mStringBuilder.set(null);
    this.mStringBuilder.remove();
    return localObject;
  }
  
  protected byte[] getFinalRequestData(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = getRequestWrapper(ByteStringMicro.copyFrom(paramArrayOfByte));
    if (paramArrayOfByte != null) {
      return paramArrayOfByte;
    }
    return new byte[0];
  }
  
  protected String getLatitude(SosoLbsInfo paramSosoLbsInfo)
  {
    return String.valueOf(paramSosoLbsInfo.mLocation.mLat02);
  }
  
  protected String getLongitude(SosoLbsInfo paramSosoLbsInfo)
  {
    return String.valueOf(paramSosoLbsInfo.mLocation.mLon02);
  }
  
  public long getNetworkTimeCost()
  {
    return this.mNetworkTimeCost;
  }
  
  protected byte[] getRequestWrapper(ByteStringMicro paramByteStringMicro)
  {
    PROTOCAL.StQWebReq localStQWebReq = new PROTOCAL.StQWebReq();
    localStQWebReq.Seq.set(getCurrentSeq());
    localStQWebReq.qua.set(this.QUA3);
    localStQWebReq.deviceInfo.set(a());
    localStQWebReq.busiBuff.set(paramByteStringMicro);
    localStQWebReq.traceid.set(this.mTraceId);
    return localStQWebReq.toByteArray();
  }
  
  public String getSsoFailMsg()
  {
    return this.mSsoFailMsg;
  }
  
  public int getSsoResultCode()
  {
    return this.mSsoResultCode;
  }
  
  public int getSsoSeq()
  {
    return this.mSsoSeq;
  }
  
  public Object[] parseResponseHeadInfo(byte[] paramArrayOfByte)
  {
    PROTOCAL.StQWebRsp localStQWebRsp = new PROTOCAL.StQWebRsp();
    try
    {
      localStQWebRsp.mergeFrom(WupUtil.b(paramArrayOfByte));
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    long l = localStQWebRsp.retCode.get();
    paramArrayOfByte = localStQWebRsp.errMsg.get().toStringUtf8();
    byte[] arrayOfByte = localStQWebRsp.busiBuff.get().toByteArray();
    reportCmdSuccessRate(localStQWebRsp);
    return new Object[] { Long.valueOf(l), paramArrayOfByte, arrayOfByte };
  }
  
  public void reportCmdSuccessRate(PROTOCAL.StQWebRsp paramStQWebRsp) {}
  
  public void setNetworkTimeCost(long paramLong)
  {
    this.mNetworkTimeCost = paramLong;
  }
  
  public void setSsoFailMsg(String paramString)
  {
    this.mSsoFailMsg = paramString;
  }
  
  public void setSsoResultCode(int paramInt)
  {
    this.mSsoResultCode = paramInt;
  }
  
  public void setSsoSeq(int paramInt)
  {
    this.mSsoSeq = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.request.base.VSBaseRequest
 * JD-Core Version:    0.7.0.1
 */