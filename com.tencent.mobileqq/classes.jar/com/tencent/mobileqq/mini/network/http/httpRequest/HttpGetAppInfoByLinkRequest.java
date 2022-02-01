package com.tencent.mobileqq.mini.network.http.httpRequest;

import NS_MINI_INTERFACE.INTERFACE.StGetAppInfoByLinkReq;
import NS_MINI_INTERFACE.INTERFACE.StGetAppInfoByLinkRsp;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import android.util.Log;
import bguc;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.network.http.HttpProtoBufRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class HttpGetAppInfoByLinkRequest
  extends HttpProtoBufRequest
{
  public static final String CMD_STRING = "GetAppInfoByLink";
  private static final String TAG = "HttpGetAppInfoByLinkRequest";
  private INTERFACE.StGetAppInfoByLinkReq req = new INTERFACE.StGetAppInfoByLinkReq();
  
  public HttpGetAppInfoByLinkRequest(String paramString, int paramInt)
  {
    this.req.link.set(paramString);
    this.req.linkType.set(paramInt);
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
  
  public String getCmdName()
  {
    return "GetAppInfoByLink";
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
    Object localObject = new INTERFACE.StGetAppInfoByLinkRsp();
    try
    {
      localStQWebRsp.mergeFrom(bguc.b(paramArrayOfByte));
      ((INTERFACE.StGetAppInfoByLinkRsp)localObject).mergeFrom(localStQWebRsp.busiBuff.get().toByteArray());
      paramArrayOfByte = new JSONObject();
      MiniAppInfo localMiniAppInfo = MiniAppInfo.from(((INTERFACE.StGetAppInfoByLinkRsp)localObject).appInfo);
      localObject = ((INTERFACE.StGetAppInfoByLinkRsp)localObject).shareTicket.get();
      paramArrayOfByte.put("appInfo", localMiniAppInfo);
      paramArrayOfByte.put("shareTicket", localObject);
      paramArrayOfByte.put("retCode", localStQWebRsp.retCode.get());
      paramArrayOfByte.put("errMsg", localStQWebRsp.errMsg.get().toStringUtf8());
      QLog.d("HttpGetAppInfoByLinkRequest", 1, "[miniapp-http].onResponse, retCode: " + localStQWebRsp.retCode.get() + ", errMsg: " + localStQWebRsp.errMsg.get().toStringUtf8());
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      QLog.d("HttpGetAppInfoByLinkRequest", 1, "onResponse, exception: " + Log.getStackTraceString(paramArrayOfByte));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.network.http.httpRequest.HttpGetAppInfoByLinkRequest
 * JD-Core Version:    0.7.0.1
 */