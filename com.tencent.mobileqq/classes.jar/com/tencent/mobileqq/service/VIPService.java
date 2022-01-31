package com.tencent.mobileqq.service;

import MQQ.GuanjiaReportReq;
import MQQ.GuanjiaReportRsp;
import MQQ.PrivExtV2Req;
import MQQ.PrivExtV2Rsp;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.vip.CUKingCardHelper;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQDeviceInfo;

public class VIPService
  extends BaseProtocolCoder
{
  private static final String[] a = { "ClubInfoSvc" };
  
  private Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg == null) {
      return null;
    }
    paramToServiceMsg = new UniPacket(true);
    try
    {
      paramToServiceMsg.setEncodeName("utf-8");
      paramToServiceMsg.decode(paramFromServiceMsg.getWupBuffer());
      paramToServiceMsg = paramToServiceMsg.getByClass("rsp", paramObject);
      return paramToServiceMsg;
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.e("VIPService", 1, "decodeWUP: ", paramToServiceMsg);
    }
    return null;
  }
  
  private boolean b(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("MQQ.PrivInfoServer.PrivInfoObj");
    paramUniPacket.setFuncName("queryPrivInfoExtV2");
    Object localObject1 = paramToServiceMsg.extraData.getString(VipInfoHandler.a);
    Object localObject2 = paramToServiceMsg.extraData.getString(VipInfoHandler.c);
    boolean bool3 = VasExtensionManager.a();
    PrivExtV2Req localPrivExtV2Req = new PrivExtV2Req();
    localPrivExtV2Req.sUin = ((String)localObject1);
    localPrivExtV2Req.sKey = ((String)localObject2);
    localPrivExtV2Req.iGetType = 0;
    localObject2 = BaseApplicationImpl.getApplication().getSharedPreferences("CUKingCardFile_" + (String)localObject1, 4);
    String str3 = CUKingCardHelper.a(0, BaseApplicationImpl.getContext());
    localObject1 = CUKingCardHelper.a(1, BaseApplicationImpl.getContext());
    String str2 = ((SharedPreferences)localObject2).getString("imsiOne", "");
    String str1 = ((SharedPreferences)localObject2).getString("imsiTwo", "");
    long l1 = ((SharedPreferences)localObject2).getLong("kingCardLastRequest", 0L);
    long l2 = ((SharedPreferences)localObject2).getInt("kingCardRequestInterval", 0);
    long l3 = System.currentTimeMillis() / 1000L;
    if (!TextUtils.isEmpty(str3))
    {
      localPrivExtV2Req.sImsi1 = str3;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label457;
      }
    }
    boolean bool1;
    for (;;)
    {
      for (;;)
      {
        localPrivExtV2Req.sImsi2 = ((String)localObject1);
        int k = ((SharedPreferences)localObject2).getInt("kingCardSdk", -1);
        if ((!bool3) || (k < 0)) {
          break label464;
        }
        localPrivExtV2Req.sImsi2 = "";
        localPrivExtV2Req.sImsi1 = "";
        localPrivExtV2Req.iWkOrderState1 = k;
        bool2 = false;
        bool1 = false;
        localPrivExtV2Req.iToastVer = ((SharedPreferences)localObject2).getInt("toast_version", 0);
        localPrivExtV2Req.iPopupVer = ((SharedPreferences)localObject2).getInt("popup_version_v2", 0);
        if (QLog.isColorLevel()) {
          QLog.i("VIPService", 2, "handleGetVipInfoReq, iPopupVer: " + localPrivExtV2Req.iPopupVer + " iToastVer:" + localPrivExtV2Req.iToastVer + " canUseTMS:" + bool3 + " sdkCardStatus:" + k + ", send sim1: " + bool1 + ", send sim2:" + bool2);
        }
        paramToServiceMsg.extraData.putBoolean(VipInfoHandler.h, bool1);
        paramToServiceMsg.extraData.putBoolean(VipInfoHandler.i, bool2);
        paramUniPacket.put("req", localPrivExtV2Req);
        return true;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localPrivExtV2Req.sImsi1 = ((String)localObject1);
          localObject1 = null;
          break;
        }
        try
        {
          localPrivExtV2Req.sImsi1 = QQDeviceInfo.b("a4bd32");
        }
        catch (Exception localException)
        {
          QLog.e("VIPService", 1, "handleGetVipInfoReq", localException);
        }
      }
      break;
      label457:
      localObject1 = "";
    }
    label464:
    if ((TextUtils.isEmpty(localPrivExtV2Req.sImsi1)) && (TextUtils.isEmpty(localPrivExtV2Req.sImsi2))) {
      localPrivExtV2Req.iGetType = 1;
    }
    int j = 0;
    int i;
    if (((!TextUtils.isEmpty(localPrivExtV2Req.sImsi1)) && (!localPrivExtV2Req.sImsi1.equals(str2))) || (TextUtils.isEmpty(localPrivExtV2Req.sImsi1)))
    {
      localObject1 = ((SharedPreferences)localObject2).edit();
      ((SharedPreferences.Editor)localObject1).putString("imsiOne", "");
      ((SharedPreferences.Editor)localObject1).putInt("kingCard", -1);
      ((SharedPreferences.Editor)localObject1).commit();
      i = 1;
      label573:
      if (((TextUtils.isEmpty(localPrivExtV2Req.sImsi2)) || (localPrivExtV2Req.sImsi2.equals(str1))) && (!TextUtils.isEmpty(localPrivExtV2Req.sImsi2))) {
        break label826;
      }
      localObject1 = ((SharedPreferences)localObject2).edit();
      ((SharedPreferences.Editor)localObject1).putString("imsiTwo", "");
      ((SharedPreferences.Editor)localObject1).putInt("kingCard2", -1);
      ((SharedPreferences.Editor)localObject1).commit();
      j = 1;
      label652:
      if (TextUtils.isEmpty(localPrivExtV2Req.sImsi1)) {
        break label853;
      }
      bool1 = true;
      label666:
      if (TextUtils.isEmpty(localPrivExtV2Req.sImsi2)) {
        break label859;
      }
    }
    label826:
    label853:
    label859:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (bool1) {
        paramToServiceMsg.extraData.putString(VipInfoHandler.j, localPrivExtV2Req.sImsi1);
      }
      if (bool2) {
        paramToServiceMsg.extraData.putString(VipInfoHandler.k, localPrivExtV2Req.sImsi2);
      }
      localPrivExtV2Req.iWkOrderState1 = ((SharedPreferences)localObject2).getInt("kingCard", -1);
      localPrivExtV2Req.iWkOrderState2 = ((SharedPreferences)localObject2).getInt("kingCard2", -1);
      if (j != 0)
      {
        localObject1 = ((SharedPreferences)localObject2).edit();
        ((SharedPreferences.Editor)localObject1).putInt("toast_version", 0);
        ((SharedPreferences.Editor)localObject1).putInt("popup_version_v2", 0);
        ((SharedPreferences.Editor)localObject1).commit();
      }
      break;
      i = j;
      if (l3 - l1 >= l2) {
        break label573;
      }
      localPrivExtV2Req.sImsi1 = "";
      i = j;
      break label573;
      j = i;
      if (l3 - l1 >= l2) {
        break label652;
      }
      localPrivExtV2Req.sImsi2 = "";
      j = i;
      break label652;
      bool1 = false;
      break label666;
    }
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ("ClubInfoSvc.queryPrivExt".equals(paramToServiceMsg.getServiceCmd())) {
      return a(paramToServiceMsg, paramFromServiceMsg, new PrivExtV2Rsp());
    }
    if ("ClubInfoSvc.guanjiaReport".equals(paramToServiceMsg.getServiceCmd())) {
      return a(paramToServiceMsg, paramFromServiceMsg, new GuanjiaReportRsp());
    }
    return null;
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    boolean bool = false;
    if ("ClubInfoSvc.queryPrivExt".equals(paramToServiceMsg.getServiceCmd())) {
      bool = b(paramToServiceMsg, paramUniPacket);
    }
    while (!"ClubInfoSvc.guanjiaReport".equals(paramToServiceMsg.getServiceCmd())) {
      return bool;
    }
    paramUniPacket.setServantName("MQQ.PrivInfoServer.PrivInfoObj");
    paramUniPacket.setFuncName("guanjiaDoReport");
    String str = paramToServiceMsg.extraData.getString(VipInfoHandler.a);
    GuanjiaReportReq localGuanjiaReportReq = new GuanjiaReportReq();
    localGuanjiaReportReq.sPkgName = "mobileQQ";
    localGuanjiaReportReq.uin = Long.parseLong(str);
    localGuanjiaReportReq.iImplat = 109;
    localGuanjiaReportReq.sPhoneNum = paramToServiceMsg.extraData.getString(VipInfoHandler.d);
    localGuanjiaReportReq.bKingCard = paramToServiceMsg.extraData.getBoolean(VipInfoHandler.e);
    localGuanjiaReportReq.iCardType = paramToServiceMsg.extraData.getInt(VipInfoHandler.f);
    localGuanjiaReportReq.iCardStatus = paramToServiceMsg.extraData.getInt(VipInfoHandler.g);
    localGuanjiaReportReq.bReportFlag = false;
    paramUniPacket.put("req", localGuanjiaReportReq);
    return true;
  }
  
  public String[] a()
  {
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.service.VIPService
 * JD-Core Version:    0.7.0.1
 */