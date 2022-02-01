package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_SHARE.MiniProgramShare.StGetGroupShareInfoReq;
import NS_MINI_SHARE.MiniProgramShare.StGetGroupShareInfoRsp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;

public class MiniAppGetGroupShareInfoRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_app_share.GetGroupShareInfo";
  public static final String TAG = "MiniAppGetGroupShareInfoRequest";
  private static final String unikey = "MiniAppGetGroupShareInfoRequest";
  private MiniProgramShare.StGetGroupShareInfoReq req = new MiniProgramShare.StGetGroupShareInfoReq();
  
  public MiniAppGetGroupShareInfoRequest(COMM.StCommonExt paramStCommonExt, String paramString1, String paramString2)
  {
    if (paramStCommonExt != null) {
      this.req.extInfo.set(paramStCommonExt);
    }
    this.req.appid.set(paramString1);
    this.req.shareTicket.set(paramString2);
  }
  
  public static MiniProgramShare.StGetGroupShareInfoRsp onResponse(byte[] paramArrayOfByte)
  {
    Object localObject = new MiniProgramShare.StGetGroupShareInfoRsp();
    try
    {
      ((MiniProgramShare.StGetGroupShareInfoRsp)localObject).mergeFrom(decode(paramArrayOfByte));
      return localObject;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onResponse fail.");
        ((StringBuilder)localObject).append(paramArrayOfByte);
        QLog.d("MiniAppGetGroupShareInfoRequest", 2, ((StringBuilder)localObject).toString());
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
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppGetGroupShareInfoRequest
 * JD-Core Version:    0.7.0.1
 */