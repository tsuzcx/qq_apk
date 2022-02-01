package com.tencent.mobileqq.service.report;

import CliLogSvc.strupbuff;
import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ReportService
  extends BaseProtocolCoder
{
  private static final String[] a = { "CliLogSvc" };
  
  private boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("QQService.CliLogSvc.MainServantObj");
    paramUniPacket.setFuncName("UploadReq");
    String[] arrayOfString = paramToServiceMsg.extraData.getStringArray("data");
    strupbuff localstrupbuff = new strupbuff();
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(arrayOfString[i].getBytes());
      i += 1;
    }
    if (paramToServiceMsg.extraData.containsKey("log_key")) {
      paramToServiceMsg = paramToServiceMsg.extraData.getString("log_key");
    } else {
      paramToServiceMsg = "PLUG_PB";
    }
    localHashMap.put(paramToServiceMsg, localArrayList);
    localstrupbuff.setLogstring(localHashMap);
    paramUniPacket.put("Data", localstrupbuff);
    return true;
  }
  
  public String[] cmdHeaderPrefix()
  {
    return a;
  }
  
  public boolean encodeReqMsg(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if ("CliLogSvc.UploadReq".equals(paramToServiceMsg.getServiceCmd())) {
      return a(paramToServiceMsg, paramUniPacket);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.report.ReportService
 * JD-Core Version:    0.7.0.1
 */