package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StContentAccelerateReq;
import NS_MINI_INTERFACE.INTERFACE.StContentAccelerateRsp;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ContentAccelerateRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_accelerate_proxy.ContentAccelerate";
  public static final String TAG = "ContentAccelerateRequest";
  private INTERFACE.StContentAccelerateReq req = new INTERFACE.StContentAccelerateReq();
  
  public ContentAccelerateRequest(COMM.StCommonExt paramStCommonExt, String paramString1, String paramString2, int paramInt, Map<String, String> paramMap)
  {
    this.req.appid.set(paramString1);
    this.req.dataUrl.set(paramString2);
    this.req.needCode.set(paramInt);
    if (paramMap != null)
    {
      paramString1 = new ArrayList();
      paramString2 = paramMap.entrySet().iterator();
      while (paramString2.hasNext())
      {
        paramMap = (Map.Entry)paramString2.next();
        COMM.Entry localEntry = new COMM.Entry();
        localEntry.key.set((String)paramMap.getKey());
        localEntry.value.set((String)paramMap.getValue());
        paramString1.add(localEntry);
      }
      this.req.reqHeaders.set(paramString1);
    }
    if (paramStCommonExt != null) {
      this.req.extInfo.set(paramStCommonExt);
    }
  }
  
  public static INTERFACE.StContentAccelerateRsp onResponse(byte[] paramArrayOfByte)
  {
    INTERFACE.StContentAccelerateRsp localStContentAccelerateRsp = new INTERFACE.StContentAccelerateRsp();
    try
    {
      localStContentAccelerateRsp.mergeFrom(decode(paramArrayOfByte));
      return localStContentAccelerateRsp;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContentAccelerateRequest", 2, "onResponse fail." + paramArrayOfByte);
      }
    }
    return null;
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.ContentAccelerateRequest
 * JD-Core Version:    0.7.0.1
 */