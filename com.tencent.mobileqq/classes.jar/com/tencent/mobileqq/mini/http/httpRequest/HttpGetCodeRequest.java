package com.tencent.mobileqq.mini.http.httpRequest;

import NS_MINI_INTERFACE.INTERFACE.StGetCodeReq;
import NS_MINI_INTERFACE.INTERFACE.StGetCodeRsp;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import android.util.Log;
import bdku;
import com.tencent.mobileqq.mini.http.HttpProtoBufRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class HttpGetCodeRequest
  extends HttpProtoBufRequest
{
  public static final String CMD_STRING = "GetCode";
  private static final String TAG = "HttpGetCodeRequest";
  private INTERFACE.StGetCodeReq req = new INTERFACE.StGetCodeReq();
  
  public HttpGetCodeRequest(String paramString)
  {
    this.req.appid.set(paramString);
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
  
  public String getCmdName()
  {
    return "GetCode";
  }
  
  public String getModule()
  {
    return "mini_program_auth";
  }
  
  public JSONObject onResponse(int paramInt, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    PROTOCAL.StQWebRsp localStQWebRsp = new PROTOCAL.StQWebRsp();
    INTERFACE.StGetCodeRsp localStGetCodeRsp = new INTERFACE.StGetCodeRsp();
    try
    {
      localStQWebRsp.mergeFrom(bdku.b(paramArrayOfByte));
      localStGetCodeRsp.mergeFrom(localStQWebRsp.busiBuff.get().toByteArray());
      QLog.d("HttpGetCodeRequest", 1, "[miniapp-http].onResponse, retCode: " + localStQWebRsp.retCode.get() + ", errMsg: " + localStQWebRsp.errMsg.get().toStringUtf8());
      if (localStGetCodeRsp != null)
      {
        paramArrayOfByte = new JSONObject();
        paramArrayOfByte.put("code", localStGetCodeRsp.code.get());
        return paramArrayOfByte;
      }
      QLog.e("HttpGetCodeRequest", 1, "onResponse, rsp is null.");
      return null;
    }
    catch (Exception paramArrayOfByte)
    {
      QLog.e("HttpGetCodeRequest", 1, "onResponse, exception: " + Log.getStackTraceString(paramArrayOfByte));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.http.httpRequest.HttpGetCodeRequest
 * JD-Core Version:    0.7.0.1
 */