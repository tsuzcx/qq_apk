package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE.StBatchGetContactReq;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class BatchGetContactRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_app_info.BatchGetContact";
  public static final String TAG = "VerifyPluginRequest";
  private INTERFACE.StBatchGetContactReq req = new INTERFACE.StBatchGetContactReq();
  
  public BatchGetContactRequest(List<String> paramList)
  {
    this.req.appids.set(paramList);
  }
  
  public static INTERFACE.StBatchGetContactReq onResponse(byte[] paramArrayOfByte)
  {
    INTERFACE.StBatchGetContactReq localStBatchGetContactReq = new INTERFACE.StBatchGetContactReq();
    try
    {
      localStBatchGetContactReq.mergeFrom(decode(paramArrayOfByte));
      return localStBatchGetContactReq;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VerifyPluginRequest", 2, "onResponse fail." + paramArrayOfByte);
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
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.BatchGetContactRequest
 * JD-Core Version:    0.7.0.1
 */