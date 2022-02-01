package com.tencent.mobileqq.mini.network.http.httpRequest;

import NS_MINI_INTERFACE.INTERFACE.StGetCodeReq;
import NS_MINI_INTERFACE.INTERFACE.StGetCodeRsp;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import android.util.Log;
import com.tencent.mobileqq.mini.network.http.HttpProtoBufRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.WupUtil;
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
  
  protected byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
  
  protected String getCmdName()
  {
    return "GetCode";
  }
  
  protected String getModule()
  {
    return "mini_program_auth";
  }
  
  protected JSONObject onResponse(int paramInt, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    PROTOCAL.StQWebRsp localStQWebRsp = new PROTOCAL.StQWebRsp();
    Object localObject = new INTERFACE.StGetCodeRsp();
    try
    {
      localStQWebRsp.mergeFrom(WupUtil.b(paramArrayOfByte));
      ((INTERFACE.StGetCodeRsp)localObject).mergeFrom(localStQWebRsp.busiBuff.get().toByteArray());
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("[miniapp-http].onResponse, retCode: ");
      paramArrayOfByte.append(localStQWebRsp.retCode.get());
      paramArrayOfByte.append(", errMsg: ");
      paramArrayOfByte.append(localStQWebRsp.errMsg.get().toStringUtf8());
      QLog.d("HttpGetCodeRequest", 1, paramArrayOfByte.toString());
      paramArrayOfByte = new JSONObject();
      paramArrayOfByte.put("code", ((INTERFACE.StGetCodeRsp)localObject).code.get());
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onResponse, exception: ");
      ((StringBuilder)localObject).append(Log.getStackTraceString(paramArrayOfByte));
      QLog.e("HttpGetCodeRequest", 1, ((StringBuilder)localObject).toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.network.http.httpRequest.HttpGetCodeRequest
 * JD-Core Version:    0.7.0.1
 */