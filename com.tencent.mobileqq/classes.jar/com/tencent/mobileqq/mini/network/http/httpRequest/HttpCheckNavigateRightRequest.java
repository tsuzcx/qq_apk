package com.tencent.mobileqq.mini.network.http.httpRequest;

import NS_MINI_INTERFACE.INTERFACE.StCheckNavigateRightReq;
import NS_MINI_INTERFACE.INTERFACE.StCheckNavigateRightRsp;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import android.util.Log;
import com.tencent.mobileqq.mini.network.http.HttpProtoBufRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.WupUtil;
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
  
  protected byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
  
  protected String getCmdName()
  {
    return "CheckNavigateRight";
  }
  
  protected String getModule()
  {
    return "mini_app_info";
  }
  
  protected JSONObject onResponse(int paramInt, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    PROTOCAL.StQWebRsp localStQWebRsp = new PROTOCAL.StQWebRsp();
    Object localObject = new INTERFACE.StCheckNavigateRightRsp();
    try
    {
      localStQWebRsp.mergeFrom(WupUtil.b(paramArrayOfByte));
      ((INTERFACE.StCheckNavigateRightRsp)localObject).mergeFrom(localStQWebRsp.busiBuff.get().toByteArray());
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("[miniapp-http].onResponse, retCode: ");
      paramArrayOfByte.append(localStQWebRsp.retCode.get());
      paramArrayOfByte.append(", errMsg: ");
      paramArrayOfByte.append(localStQWebRsp.errMsg.get().toStringUtf8());
      QLog.d("HttpCheckNavigateRightRequest", 1, paramArrayOfByte.toString());
      paramArrayOfByte = new JSONObject();
      paramInt = ((INTERFACE.StCheckNavigateRightRsp)localObject).actionCode.get();
      paramArrayOfByte.put("action_code", paramInt);
      paramArrayOfByte.put("skip_local_check", ((INTERFACE.StCheckNavigateRightRsp)localObject).skipLocalCheck.get());
      if (paramInt == 0)
      {
        paramArrayOfByte.put("reason", ((INTERFACE.StCheckNavigateRightRsp)localObject).wording.get());
        return paramArrayOfByte;
      }
      paramArrayOfByte.put("wording", ((INTERFACE.StCheckNavigateRightRsp)localObject).wording.get());
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onResponse fail.");
      ((StringBuilder)localObject).append(Log.getStackTraceString(paramArrayOfByte));
      QLog.e("HttpCheckNavigateRightRequest", 1, ((StringBuilder)localObject).toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.network.http.httpRequest.HttpCheckNavigateRightRequest
 * JD-Core Version:    0.7.0.1
 */