package com.tencent.mobileqq.qcircle.api.requests;

import NS_COMM.COMM.Entry;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebReq;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.IQCircleConfigApi;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleAlphaUserReportDataBuilder;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class QCircleBaseRequest
  extends VSBaseRequest
{
  private static final String KEY_GW_RP_TRANSFER = "gwRPTransfer";
  
  private String getGwRpTransfer(PROTOCAL.StQWebRsp paramStQWebRsp)
  {
    if (paramStQWebRsp != null)
    {
      if (paramStQWebRsp.Extinfo.isEmpty()) {
        return null;
      }
      paramStQWebRsp = paramStQWebRsp.Extinfo.get().iterator();
      while (paramStQWebRsp.hasNext())
      {
        COMM.Entry localEntry = (COMM.Entry)paramStQWebRsp.next();
        if ((localEntry != null) && ("gwRPTransfer".equals(localEntry.key.get()))) {
          return localEntry.value.get();
        }
      }
    }
    return null;
  }
  
  protected String getAttachInfo()
  {
    return null;
  }
  
  protected int getCount()
  {
    return 0;
  }
  
  protected HashMap<String, String> getExtras()
  {
    return null;
  }
  
  protected String getFeedId()
  {
    return null;
  }
  
  protected String getInfo()
  {
    return null;
  }
  
  protected double getRate()
  {
    return 0.0D;
  }
  
  protected String getRefer()
  {
    return null;
  }
  
  protected byte[] getRequestWrapper(ByteStringMicro paramByteStringMicro)
  {
    PROTOCAL.StQWebReq localStQWebReq = new PROTOCAL.StQWebReq();
    try
    {
      localStQWebReq.mergeFrom(super.getRequestWrapper(paramByteStringMicro));
    }
    catch (InvalidProtocolBufferMicroException paramByteStringMicro)
    {
      paramByteStringMicro.printStackTrace();
    }
    paramByteStringMicro = new COMM.Entry();
    paramByteStringMicro.key.set("fc-appid");
    paramByteStringMicro.value.set("92");
    localStQWebReq.Extinfo.add(paramByteStringMicro);
    paramByteStringMicro = new COMM.Entry();
    paramByteStringMicro.key.set("sw-plugin-qua");
    paramByteStringMicro.value.set(((IQCircleConfigApi)QRoute.api(IQCircleConfigApi.class)).getPluginQUA());
    localStQWebReq.Extinfo.add(paramByteStringMicro);
    paramByteStringMicro = new COMM.Entry();
    paramByteStringMicro.key.set("environment_id");
    paramByteStringMicro.value.set(QCircleHostGlobalInfo.getCurMsfServerId());
    localStQWebReq.Extinfo.add(paramByteStringMicro);
    return localStQWebReq.toByteArray();
  }
  
  protected String getRetCode()
  {
    return null;
  }
  
  protected String getState()
  {
    return null;
  }
  
  protected String getType()
  {
    return null;
  }
  
  protected String getUrl()
  {
    return null;
  }
  
  protected String getUser()
  {
    return null;
  }
  
  public void reportCmdSuccessRate(PROTOCAL.StQWebRsp paramStQWebRsp)
  {
    long l;
    String str;
    if (getSsoResultCode() == 1000)
    {
      l = paramStQWebRsp.retCode.get();
      str = paramStQWebRsp.errMsg.get().toStringUtf8();
    }
    else
    {
      l = getSsoResultCode();
      str = getSsoFailMsg();
    }
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).reportCmdSuccessRateEvent(new QCircleAlphaUserReportDataBuilder().setCmd(getCmdName()).setSvrRetCode(String.valueOf(l)).setRetCode(getRetCode()).setInfo(getInfo()).setMsg(str).setTimeCost(getNetworkTimeCost()).setUrl(getUrl()).setRate(getRate()).setType(getType()).setRefer(getRefer()).setAttachInfo(getAttachInfo()).setExtraInfo(getTraceId()).setCount(getCount()).setState(getState()).setFeedId(getFeedId()).setUser(getUser()).setExtras(getExtras()).setGwRpTransfer(getGwRpTransfer(paramStQWebRsp)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.requests.QCircleBaseRequest
 * JD-Core Version:    0.7.0.1
 */