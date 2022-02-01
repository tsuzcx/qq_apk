package com.tencent.mobileqq.mini.network.http.httpRequest;

import NS_MINI_INTERFACE.INTERFACE.StGetAppInfoByLinkReq;
import NS_MINI_INTERFACE.INTERFACE.StGetAppInfoByLinkRsp;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import android.util.Log;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.network.http.HttpProtoBufRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.WupUtil;
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
  
  protected String getCmdName()
  {
    return "GetAppInfoByLink";
  }
  
  protected String getModule()
  {
    return "mini_app_info";
  }
  
  public JSONObject onResponse(int paramInt, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    Object localObject1 = new PROTOCAL.StQWebRsp();
    Object localObject2 = new INTERFACE.StGetAppInfoByLinkRsp();
    try
    {
      ((PROTOCAL.StQWebRsp)localObject1).mergeFrom(WupUtil.b(paramArrayOfByte));
      ((INTERFACE.StGetAppInfoByLinkRsp)localObject2).mergeFrom(((PROTOCAL.StQWebRsp)localObject1).busiBuff.get().toByteArray());
      paramArrayOfByte = new JSONObject();
      MiniAppInfo localMiniAppInfo = MiniAppInfo.from(((INTERFACE.StGetAppInfoByLinkRsp)localObject2).appInfo);
      String str = ((INTERFACE.StGetAppInfoByLinkRsp)localObject2).shareTicket.get();
      paramArrayOfByte.put("appInfo", localMiniAppInfo);
      paramArrayOfByte.put("appInfo_pd", ((INTERFACE.StGetAppInfoByLinkRsp)localObject2).appInfo);
      paramArrayOfByte.put("shareTicket", str);
      paramArrayOfByte.put("retCode", ((PROTOCAL.StQWebRsp)localObject1).retCode.get());
      paramArrayOfByte.put("errMsg", ((PROTOCAL.StQWebRsp)localObject1).errMsg.get().toStringUtf8());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[miniapp-http].onResponse, retCode: ");
      ((StringBuilder)localObject2).append(((PROTOCAL.StQWebRsp)localObject1).retCode.get());
      ((StringBuilder)localObject2).append(", errMsg: ");
      ((StringBuilder)localObject2).append(((PROTOCAL.StQWebRsp)localObject1).errMsg.get().toStringUtf8());
      QLog.d("HttpGetAppInfoByLinkRequest", 1, ((StringBuilder)localObject2).toString());
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onResponse, exception: ");
      ((StringBuilder)localObject1).append(Log.getStackTraceString(paramArrayOfByte));
      QLog.d("HttpGetAppInfoByLinkRequest", 1, ((StringBuilder)localObject1).toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.network.http.httpRequest.HttpGetAppInfoByLinkRequest
 * JD-Core Version:    0.7.0.1
 */