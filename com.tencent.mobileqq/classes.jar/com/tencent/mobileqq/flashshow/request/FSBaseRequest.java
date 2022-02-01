package com.tencent.mobileqq.flashshow.request;

import NS_COMM.COMM.Entry;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebReq;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.richframework.common.RFWCommonGlobalInfo;

public abstract class FSBaseRequest
  extends VSBaseRequest
{
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
    paramByteStringMicro.value.set("95");
    localStQWebReq.Extinfo.add(paramByteStringMicro);
    paramByteStringMicro = new COMM.Entry();
    paramByteStringMicro.key.set("environment_id");
    paramByteStringMicro.value.set(RFWCommonGlobalInfo.a());
    localStQWebReq.Extinfo.add(paramByteStringMicro);
    return localStQWebReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.request.FSBaseRequest
 * JD-Core Version:    0.7.0.1
 */