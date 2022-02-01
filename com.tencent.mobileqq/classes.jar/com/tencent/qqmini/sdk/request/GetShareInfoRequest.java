package com.tencent.qqmini.sdk.request;

import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import NS_MINI_SHARE.MiniProgramShare.StAdaptShareInfoReq;
import NS_MINI_SHARE.MiniProgramShare.StAdaptShareInfoRsp;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

public class GetShareInfoRequest
  extends ProtoBufRequest
{
  public static final String JSON_DATA = "jsonData";
  public static final String MINI_APP_NEED_ONLY_PREVIEW = "miniAppNeedOnlyPreview";
  public static final String NEED_SHARE_CALLBACK = "needShareCallBack";
  public static final long SHARE_APPID_MISMATCHING = -1000710003L;
  public static final long SHARE_OUT_OF_LIMIT = -100070004L;
  private static final String TAG = "GetShareInfoRequest";
  private MiniProgramShare.StAdaptShareInfoReq req;
  
  public GetShareInfoRequest(MiniProgramShare.StAdaptShareInfoReq paramStAdaptShareInfoReq)
  {
    this.req = paramStAdaptShareInfoReq;
  }
  
  protected byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
  
  protected String getCmdName()
  {
    return "AdaptShareInfo";
  }
  
  protected String getModule()
  {
    return "mini_app_share";
  }
  
  public JSONObject getResponse(byte[] paramArrayOfByte, JSONObject paramJSONObject)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    MiniProgramShare.StAdaptShareInfoRsp localStAdaptShareInfoRsp = new MiniProgramShare.StAdaptShareInfoRsp();
    long l;
    int i;
    boolean bool1;
    boolean bool2;
    try
    {
      localStAdaptShareInfoRsp.mergeFrom(paramArrayOfByte);
      l = paramJSONObject.getLong("retCode");
      paramJSONObject.getString("errMsg");
      paramArrayOfByte = localStAdaptShareInfoRsp.extInfo;
      i = 0;
      if ((paramArrayOfByte == null) || (localStAdaptShareInfoRsp.extInfo.mapInfo == null)) {
        break label255;
      }
      bool1 = false;
      bool2 = bool1;
      if (i >= localStAdaptShareInfoRsp.extInfo.mapInfo.size()) {
        break label258;
      }
      paramArrayOfByte = (COMM.Entry)localStAdaptShareInfoRsp.extInfo.mapInfo.get(i);
      bool2 = bool1;
      if (!"needShareCallBack".equals(paramArrayOfByte.key.get())) {
        break label244;
      }
      bool2 = bool1;
      if (!"true".equals(paramArrayOfByte.value.get())) {
        break label244;
      }
      bool2 = true;
    }
    catch (Exception paramArrayOfByte)
    {
      label142:
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("onResponse fail.");
      paramJSONObject.append(paramArrayOfByte);
      QMLog.d("GetShareInfoRequest", paramJSONObject.toString());
      return null;
    }
    paramArrayOfByte = new JSONObject(localStAdaptShareInfoRsp.jsonData.get());
    paramArrayOfByte.put("needShareCallBack", bool2);
    return paramArrayOfByte;
    for (;;)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("onGetShareInfo isSuccess=false, retCode=");
      paramArrayOfByte.append(l);
      QMLog.e("GetShareInfoRequest", paramArrayOfByte.toString());
      paramJSONObject.put("needShareCallBack", bool2);
      return paramJSONObject;
      label244:
      i += 1;
      bool1 = bool2;
      break;
      label255:
      bool2 = false;
      label258:
      if (l != -100070004L) {
        if (l != -1000710003L) {
          break label142;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.GetShareInfoRequest
 * JD-Core Version:    0.7.0.1
 */