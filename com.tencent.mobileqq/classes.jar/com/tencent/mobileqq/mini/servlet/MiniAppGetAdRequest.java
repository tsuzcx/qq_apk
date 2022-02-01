package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_AD.MiniAppAd.ContextInfo;
import NS_MINI_AD.MiniAppAd.DebugInfo;
import NS_MINI_AD.MiniAppAd.DeviceInfo;
import NS_MINI_AD.MiniAppAd.PositionInfo;
import NS_MINI_AD.MiniAppAd.StGetAdReq;
import NS_MINI_AD.MiniAppAd.StGetAdRsp;
import NS_MINI_AD.MiniAppAd.UserInfo;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;

public class MiniAppGetAdRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_app_ad.GetAd";
  public static final String TAG = "MiniAppGetAdRequest";
  private static final String unikey = "MiniAppGetAdRequest";
  private MiniAppAd.StGetAdReq req = new MiniAppAd.StGetAdReq();
  
  public MiniAppGetAdRequest(COMM.StCommonExt paramStCommonExt, MiniAppAd.UserInfo paramUserInfo, MiniAppAd.PositionInfo paramPositionInfo, MiniAppAd.DeviceInfo paramDeviceInfo, MiniAppAd.ContextInfo paramContextInfo, MiniAppAd.DebugInfo paramDebugInfo, String paramString1, boolean paramBoolean, String paramString2, String paramString3, int paramInt)
  {
    if (paramStCommonExt != null) {
      this.req.extInfo.set(paramStCommonExt);
    }
    if (paramUserInfo != null) {
      this.req.user_info.set(paramUserInfo);
    }
    if (paramPositionInfo != null) {
      this.req.position_info.add(paramPositionInfo);
    }
    if (paramDeviceInfo != null) {
      this.req.device_info.set(paramDeviceInfo);
    }
    if (paramContextInfo != null) {
      this.req.context_info.set(paramContextInfo);
    }
    if (paramDebugInfo != null) {
      this.req.debug_info.set(paramDebugInfo);
    }
    this.req.gdt_cookie.set(paramString1);
    this.req.support_https.set(paramBoolean);
    this.req.busi_cookie.set(paramString2);
    this.req.appid.set(paramString3);
    this.req.ad_type.set(paramInt);
  }
  
  public static MiniAppAd.StGetAdRsp onResponse(byte[] paramArrayOfByte)
  {
    MiniAppAd.StGetAdRsp localStGetAdRsp = new MiniAppAd.StGetAdRsp();
    try
    {
      localStGetAdRsp.mergeFrom(decode(paramArrayOfByte));
      return localStGetAdRsp;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MiniAppGetAdRequest", 2, "onResponse fail." + paramArrayOfByte);
      }
    }
    return null;
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppGetAdRequest
 * JD-Core Version:    0.7.0.1
 */