package com.tencent.mobileqq.mini.network.http.httpRequest;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import NS_MINI_INTERFACE.INTERFACE.StGetAppInfoByIdReq;
import NS_MINI_INTERFACE.INTERFACE.StGetAppInfoByIdRsp;
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

public class HttpGetAppInfoByIdRequest
  extends HttpProtoBufRequest
{
  public static final String CMD_STRING = "GetAppInfoById";
  public static final String TAG = "GetAppInfoByIdRequest";
  private INTERFACE.StGetAppInfoByIdReq req = new INTERFACE.StGetAppInfoByIdReq();
  
  public HttpGetAppInfoByIdRequest(COMM.StCommonExt paramStCommonExt, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4)
  {
    this.req.appid.set(paramString1);
    this.req.needVersionInfo.set(paramInt1);
    this.req.checkDevRight.set(paramInt2);
    if (paramString2 != null) {
      this.req.firstPath.set(paramString2);
    }
    if (paramString3 != null) {
      this.req.envVersion.set(paramString3);
    }
    paramString2 = this.req.fromAppid;
    paramString1 = paramString4;
    if (paramString4 == null) {
      paramString1 = "";
    }
    paramString2.set(paramString1);
    if (paramStCommonExt != null) {
      this.req.extInfo.set(paramStCommonExt);
    }
  }
  
  protected byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
  
  protected String getCmdName()
  {
    return "GetAppInfoById";
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
    Object localObject = new PROTOCAL.StQWebRsp();
    INTERFACE.StGetAppInfoByIdRsp localStGetAppInfoByIdRsp = new INTERFACE.StGetAppInfoByIdRsp();
    try
    {
      ((PROTOCAL.StQWebRsp)localObject).mergeFrom(WupUtil.b(paramArrayOfByte));
      localStGetAppInfoByIdRsp.mergeFrom(((PROTOCAL.StQWebRsp)localObject).busiBuff.get().toByteArray());
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("[miniapp-http].onResponse, retCode: ");
      paramArrayOfByte.append(((PROTOCAL.StQWebRsp)localObject).retCode.get());
      paramArrayOfByte.append(", errMsg: ");
      paramArrayOfByte.append(((PROTOCAL.StQWebRsp)localObject).errMsg.get().toStringUtf8());
      QLog.d("GetAppInfoByIdRequest", 1, paramArrayOfByte.toString());
      paramArrayOfByte = new JSONObject();
      paramArrayOfByte.put("mini_app_info_data", MiniAppInfo.from(localStGetAppInfoByIdRsp.appInfo));
      paramArrayOfByte.put("mini_app_info_pb_data", localStGetAppInfoByIdRsp.appInfo.toByteArray());
      paramArrayOfByte.put("retCode", ((PROTOCAL.StQWebRsp)localObject).retCode.get());
      paramArrayOfByte.put("errMsg", ((PROTOCAL.StQWebRsp)localObject).errMsg.get().toStringUtf8());
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onResponse fail.");
      ((StringBuilder)localObject).append(Log.getStackTraceString(paramArrayOfByte));
      QLog.e("GetAppInfoByIdRequest", 1, ((StringBuilder)localObject).toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.network.http.httpRequest.HttpGetAppInfoByIdRequest
 * JD-Core Version:    0.7.0.1
 */