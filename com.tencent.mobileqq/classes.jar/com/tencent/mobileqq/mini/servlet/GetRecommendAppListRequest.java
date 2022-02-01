package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.DeviceInfo;
import NS_MINI_INTERFACE.INTERFACE.StGetRecommendAppListReq;
import NS_MINI_INTERFACE.INTERFACE.StGetRecommendAppListRsp;
import NS_MINI_INTERFACE.INTERFACE.StRecommendApp;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class GetRecommendAppListRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_app_userapp.GetRecommendAppList";
  public static final String KEY_RSP = "response";
  public static final String TAG = "GetRecommendAppListRequest";
  private INTERFACE.StGetRecommendAppListReq req = new INTERFACE.StGetRecommendAppListReq();
  
  public GetRecommendAppListRequest(COMM.StCommonExt paramStCommonExt, String paramString, int paramInt, long paramLong, ArrayList<INTERFACE.StRecommendApp> paramArrayList, INTERFACE.DeviceInfo paramDeviceInfo)
  {
    this.req.appId.set(paramString);
    this.req.verType.set(paramInt);
    this.req.useTime.set(paramLong);
    this.req.oldRecommendList.set(paramArrayList);
    this.req.deviceInfo.set(paramDeviceInfo);
    if (paramStCommonExt != null) {
      this.req.extInfo.set(paramStCommonExt);
    }
  }
  
  public static INTERFACE.StGetRecommendAppListRsp onResponse(byte[] paramArrayOfByte)
  {
    Object localObject = new INTERFACE.StGetRecommendAppListRsp();
    try
    {
      ((INTERFACE.StGetRecommendAppListRsp)localObject).mergeFrom(decode(paramArrayOfByte));
      return localObject;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onResponse fail.");
        ((StringBuilder)localObject).append(paramArrayOfByte);
        QLog.d("GetRecommendAppListRequest", 2, ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.GetRecommendAppListRequest
 * JD-Core Version:    0.7.0.1
 */