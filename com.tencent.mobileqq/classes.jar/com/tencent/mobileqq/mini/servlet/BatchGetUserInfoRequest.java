package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE.StBatchGetUserInfoReq;
import NS_MINI_INTERFACE.INTERFACE.StBatchGetUserInfoRsp;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;

public class BatchGetUserInfoRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_user_info.BatchGetUserInfo";
  private static final String TAG = "BatchGetUserInfoRequest";
  private static final String unikey = "BatchGetUserInfo";
  private INTERFACE.StBatchGetUserInfoReq req = new INTERFACE.StBatchGetUserInfoReq();
  
  public BatchGetUserInfoRequest(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    this.req.appid.set(paramString1);
    if (!TextUtils.isEmpty(paramString2)) {
      this.req.lang.set(paramString2);
    }
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      paramString1 = paramArrayOfString[i];
      this.req.openIds.add(paramString1);
      i += 1;
    }
  }
  
  public static INTERFACE.StBatchGetUserInfoRsp onResponse(byte[] paramArrayOfByte)
  {
    Object localObject = new INTERFACE.StBatchGetUserInfoRsp();
    try
    {
      ((INTERFACE.StBatchGetUserInfoRsp)localObject).mergeFrom(decode(paramArrayOfByte));
      return localObject;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onResponse fail.");
        ((StringBuilder)localObject).append(paramArrayOfByte);
        QLog.d("BatchGetUserInfoRequest", 2, ((StringBuilder)localObject).toString());
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
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.BatchGetUserInfoRequest
 * JD-Core Version:    0.7.0.1
 */