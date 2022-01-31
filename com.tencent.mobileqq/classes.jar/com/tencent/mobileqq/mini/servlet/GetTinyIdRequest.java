package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE.StTrans4TinyidReq;
import NS_MINI_INTERFACE.INTERFACE.StTrans4TinyidRsp;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;

public class GetTinyIdRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_user_info.Trans4Tinyid";
  public static final String TAG = "GetTinyIdRequest";
  private INTERFACE.StTrans4TinyidReq req = new INTERFACE.StTrans4TinyidReq();
  
  public GetTinyIdRequest(String paramString)
  {
    this.req.appids.set(Collections.singletonList(paramString));
  }
  
  public static INTERFACE.StTrans4TinyidRsp onResponse(byte[] paramArrayOfByte)
  {
    INTERFACE.StTrans4TinyidRsp localStTrans4TinyidRsp = new INTERFACE.StTrans4TinyidRsp();
    try
    {
      localStTrans4TinyidRsp.mergeFrom(decode(paramArrayOfByte));
      return localStTrans4TinyidRsp;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GetTinyIdRequest", 2, "onResponse fail." + paramArrayOfByte);
      }
    }
    return null;
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.GetTinyIdRequest
 * JD-Core Version:    0.7.0.1
 */