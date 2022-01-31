package com.tencent.mobileqq.mini.http.httpRequest;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StGetAppInfoByIdReq;
import NS_MINI_INTERFACE.INTERFACE.StGetAppInfoByIdRsp;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import android.util.Log;
import bbma;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.http.HttpProtoBufRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class HttpGetAppInfoByIdRequest
  extends HttpProtoBufRequest
{
  public static final String CMD_STRING = "GetAppInfoById";
  public static final String TAG = "GetAppInfoByIdRequest";
  private INTERFACE.StGetAppInfoByIdReq req = new INTERFACE.StGetAppInfoByIdReq();
  
  public HttpGetAppInfoByIdRequest(COMM.StCommonExt paramStCommonExt, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    this.req.appid.set(paramString1);
    this.req.needVersionInfo.set(paramInt1);
    this.req.checkDevRight.set(paramInt2);
    this.req.firstPath.set(paramString2);
    this.req.envVersion.set(paramString3);
    if (paramStCommonExt != null) {
      this.req.extInfo.set(paramStCommonExt);
    }
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
  
  public String getCmdName()
  {
    return "GetAppInfoById";
  }
  
  public String getModule()
  {
    return "mini_app_info";
  }
  
  public JSONObject onResponse(int paramInt, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    PROTOCAL.StQWebRsp localStQWebRsp = new PROTOCAL.StQWebRsp();
    INTERFACE.StGetAppInfoByIdRsp localStGetAppInfoByIdRsp = new INTERFACE.StGetAppInfoByIdRsp();
    try
    {
      localStQWebRsp.mergeFrom(bbma.b(paramArrayOfByte));
      localStGetAppInfoByIdRsp.mergeFrom(localStQWebRsp.busiBuff.get().toByteArray());
      QLog.d("GetAppInfoByIdRequest", 1, "[miniapp-http].onResponse, retCode: " + localStQWebRsp.retCode.get() + ", errMsg: " + localStQWebRsp.errMsg.get().toStringUtf8());
      if (localStGetAppInfoByIdRsp != null)
      {
        paramArrayOfByte = new JSONObject();
        paramArrayOfByte.put("mini_app_info_data", MiniAppInfo.from(localStGetAppInfoByIdRsp.appInfo));
        paramArrayOfByte.put("retCode", localStQWebRsp.retCode.get());
        paramArrayOfByte.put("errMsg", localStQWebRsp.errMsg.get().toStringUtf8());
        return paramArrayOfByte;
      }
      QLog.e("GetAppInfoByIdRequest", 1, "onResponse fail.rsp = null");
      return null;
    }
    catch (Exception paramArrayOfByte)
    {
      QLog.e("GetAppInfoByIdRequest", 1, "onResponse fail." + Log.getStackTraceString(paramArrayOfByte));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.http.httpRequest.HttpGetAppInfoByIdRequest
 * JD-Core Version:    0.7.0.1
 */