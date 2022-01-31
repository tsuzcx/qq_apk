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
  
  private boolean b(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("QQService.CliLogSvc.MainServantObj");
    paramUniPacket.setFuncName("UploadReq");
    paramToServiceMsg = paramToServiceMsg.extraData.getStringArray("data");
    strupbuff localstrupbuff = new strupbuff();
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    int j = paramToServiceMsg.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramToServiceMsg[i].getBytes());
      i += 1;
    }
    localHashMap.put("PLUG_PB", localArrayList);
    localstrupbuff.setLogstring(localHashMap);
    paramUniPacket.put("Data", localstrupbuff);
    return true;
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if ("CliLogSvc.UploadReq".equals(paramToServiceMsg.getServiceCmd())) {
      return b(paramToServiceMsg, paramUniPacket);
    }
    return false;
  }
  
  public String[] a()
  {
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.service.report.ReportService
 * JD-Core Version:    0.7.0.1
 */