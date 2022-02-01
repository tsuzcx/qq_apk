package com.tencent.open.appcircle.protocol;

import com.qq.taf.jce.JceStruct;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.tmassistant.common.ProtocolPackage;
import com.tencent.tmassistant.common.jce.ReqHead;
import com.tencent.tmassistant.common.jce.Request;
import com.tencent.tmassistant.common.jce.SdkInfo;
import com.tencent.tmassistant.common.jce.Ticket;
import com.tencent.tmassistant.common.jce.TicketWtLogin;
import com.tencent.tmassistantbase.network.PostHttpRequest;

public abstract class BaseRequest
  extends PostHttpRequest
{
  public int a(JceStruct paramJceStruct)
  {
    try
    {
      paramJceStruct = ProtocolPackage.buildRequest(paramJceStruct);
    }
    catch (Throwable paramJceStruct)
    {
      label8:
      Object localObject;
      Ticket localTicket;
      int i;
      break label8;
    }
    paramJceStruct = null;
    if (paramJceStruct == null) {
      return -1;
    }
    localObject = new SdkInfo();
    ((SdkInfo)localObject).versionCode = 1;
    ((SdkInfo)localObject).versionName = CommonDataAdapter.a().g();
    ((SdkInfo)localObject).name = "AppNews";
    ((SdkInfo)localObject).channel = "";
    ((SdkInfo)localObject).builderNum = "";
    paramJceStruct.head.sdkInfo = ((SdkInfo)localObject);
    localObject = new TicketWtLogin();
    ((TicketWtLogin)localObject).uin = CommonDataAdapter.a().c();
    ((TicketWtLogin)localObject).A2 = CommonDataAdapter.a().f().getBytes();
    localTicket = new Ticket();
    localTicket.value = ProtocolPackage.jceStructToUTF8Byte((JceStruct)localObject);
    localTicket.type = 1;
    paramJceStruct.head.ticket = localTicket;
    i = paramJceStruct.head.requestId;
    sendRequest(ProtocolPackage.buildPostData(paramJceStruct));
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appcircle.protocol.BaseRequest
 * JD-Core Version:    0.7.0.1
 */