package com.tencent.mobileqq.mini.network.http.httpRequest;

import NS_MINI_INTERFACE.INTERFACE.StCheckNavigateRightReq;
import NS_MINI_INTERFACE.INTERFACE.StCheckNavigateRightRsp;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import android.util.Log;
import bhjl;
import com.tencent.mobileqq.mini.network.http.HttpProtoBufRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class HttpCheckNavigateRightRequest
  extends HttpProtoBufRequest
{
  public static final String CMD_STRING = "CheckNavigateRight";
  public static final String TAG = "HttpCheckNavigateRightRequest";
  private INTERFACE.StCheckNavigateRightReq req = new INTERFACE.StCheckNavigateRightReq();
  
  public HttpCheckNavigateRightRequest(String paramString1, String paramString2)
  {
    this.req.appId.set(paramString1);
    this.req.targetAppId.set(paramString2);
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
  
  public String getCmdName()
  {
    return "CheckNavigateRight";
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
    INTERFACE.StCheckNavigateRightRsp localStCheckNavigateRightRsp = new INTERFACE.StCheckNavigateRightRsp();
    try
    {
      localStQWebRsp.mergeFrom(bhjl.b(paramArrayOfByte));
      localStCheckNavigateRightRsp.mergeFrom(localStQWebRsp.busiBuff.get().toByteArray());
      QLog.d("HttpCheckNavigateRightRequest", 1, "[miniapp-http].onResponse, retCode: " + localStQWebRsp.retCode.get() + ", errMsg: " + localStQWebRsp.errMsg.get().toStringUtf8());
      if (localStCheckNavigateRightRsp != null)
      {
        paramArrayOfByte = new JSONObject();
        paramInt = localStCheckNavigateRightRsp.actionCode.get();
        paramArrayOfByte.put("action_code", paramInt);
        paramArrayOfByte.put("skip_local_check", localStCheckNavigateRightRsp.skipLocalCheck.get());
        if (paramInt == 0) {
          paramArrayOfByte.put("reason", localStCheckNavigateRightRsp.wording.get());
        } else {
          paramArrayOfByte.put("wording", localStCheckNavigateRightRsp.wording.get());
        }
      }
    }
    catch (Exception paramArrayOfByte)
    {
      QLog.e("HttpCheckNavigateRightRequest", 1, "onResponse fail." + Log.getStackTraceString(paramArrayOfByte));
      return null;
    }
    QLog.e("HttpCheckNavigateRightRequest", 1, "onResponse fail.rsp = null");
    return null;
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.network.http.httpRequest.HttpCheckNavigateRightRequest
 * JD-Core Version:    0.7.0.1
 */