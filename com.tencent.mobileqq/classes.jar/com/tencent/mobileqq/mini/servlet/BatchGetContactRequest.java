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
    Object localObject = new INTERFACE.StBatchGetContactReq();
    try
    {
      ((INTERFACE.StBatchGetContactReq)localObject).mergeFrom(decode(paramArrayOfByte));
      return localObject;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onResponse fail.");
        ((StringBuilder)localObject).append(paramArrayOfByte);
        QLog.d("VerifyPluginRequest", 2, ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.BatchGetContactRequest
 * JD-Core Version:    0.7.0.1
 */