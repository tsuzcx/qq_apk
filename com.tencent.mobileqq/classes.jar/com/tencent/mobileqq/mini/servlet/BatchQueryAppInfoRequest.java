package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StBatchQueryAppInfoReq;
import NS_MINI_INTERFACE.INTERFACE.StBatchQueryAppInfoRsp;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class BatchQueryAppInfoRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_app_info.BatchQueryAppInfo";
  public static final String TAG = "BatchQueryAppInfoRequest";
  private INTERFACE.StBatchQueryAppInfoReq req = new INTERFACE.StBatchQueryAppInfoReq();
  
  public BatchQueryAppInfoRequest(COMM.StCommonExt paramStCommonExt, List<String> paramList)
  {
    this.req.appIds.set(paramList);
    if (paramStCommonExt != null) {
      this.req.extInfo.set(paramStCommonExt);
    }
  }
  
  public static INTERFACE.StBatchQueryAppInfoRsp onResponse(byte[] paramArrayOfByte)
  {
    Object localObject = new INTERFACE.StBatchQueryAppInfoRsp();
    try
    {
      ((INTERFACE.StBatchQueryAppInfoRsp)localObject).mergeFrom(decode(paramArrayOfByte));
      return localObject;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onResponse fail.");
        ((StringBuilder)localObject).append(paramArrayOfByte);
        QLog.d("BatchQueryAppInfoRequest", 2, ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.BatchQueryAppInfoRequest
 * JD-Core Version:    0.7.0.1
 */