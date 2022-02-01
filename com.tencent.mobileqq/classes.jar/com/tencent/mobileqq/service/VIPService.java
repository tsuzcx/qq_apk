package com.tencent.mobileqq.service;

import MQQ.GuanjiaReportReq;
import MQQ.GuanjiaReportRsp;
import MQQ.PrivExtV2Req;
import MQQ.PrivExtV2Rsp;
import MQQ.VAResourcesReq;
import MQQ.VAResourcesRsp;
import QC.UniGetRsp;
import QC.UniSetRsp;
import VIP.GetCustomOnlineStatusReq;
import VIP.GetCustomOnlineStatusRsp;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.data.NamePlateCfgInfo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.treasurecard.api.IVasFTManager;
import com.tencent.mobileqq.vas.util.PrettyAccountUtil;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.vip.QVipConfigManager;
import com.tencent.mobileqq.vip.CUKingCardHelper;
import com.tencent.mobileqq.vip.CUKingCardUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.util.QQDeviceInfo;
import cooperation.ilive.manager.IliveDbManager;
import cooperation.ilive.manager.IliveRedManager;
import cooperation.qzone.QUA;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public class VIPService
  extends BaseProtocolCoder
{
  private static final String[] a = { "ClubInfoSvc", "VipCustom", "QCUniBusinessLogic" };
  
  private long a(String paramString)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    long l2 = 0L;
    long l1 = l2;
    if (localObject != null)
    {
      l1 = l2;
      if ((localObject instanceof QQAppInterface))
      {
        localObject = (QQAppInterface)localObject;
        l1 = QVipConfigManager.a((AppRuntime)localObject, "name_plate_config_version", 0L);
        if (TextUtils.isEmpty(NamePlateCfgInfo.getVipNamePlateCfgInfo((QQAppInterface)localObject, paramString))) {
          return 0L;
        }
      }
    }
    return l1;
  }
  
  private <T> T a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, T paramT)
  {
    if (paramFromServiceMsg == null) {
      return null;
    }
    paramToServiceMsg = new UniPacket(true);
    try
    {
      paramToServiceMsg.setEncodeName("utf-8");
      paramToServiceMsg.decode(paramFromServiceMsg.getWupBuffer());
      paramToServiceMsg = paramToServiceMsg.getByClass("rsp", paramT);
      return paramToServiceMsg;
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.e("VIPService", 1, "decodeWUP: ", paramToServiceMsg);
    }
    return null;
  }
  
  private void a(PrivExtV2Req paramPrivExtV2Req)
  {
    HashMap localHashMap = new HashMap();
    int k = CUKingCardUtils.a();
    int j = VasUtil.a().getVasFtManager().treasureCardState("");
    int i = k;
    if (k == -1) {
      i = 0;
    }
    localHashMap.put(Integer.valueOf(1), Integer.valueOf(i));
    i = j;
    if (j == -1) {
      i = 0;
    }
    localHashMap.put(Integer.valueOf(2), Integer.valueOf(i));
    paramPrivExtV2Req.mobile_info = localHashMap;
  }
  
  private void a(PrivExtV2Req paramPrivExtV2Req, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals("vip_drawer")))
    {
      paramPrivExtV2Req.trace_info = IliveDbManager.getIliveDrawerData("drawer_trace_info");
      paramString = IliveRedManager.getIliveRecomRedInfo();
      if (paramString != null)
      {
        paramPrivExtV2Req.recom_ext_info = ((String)paramString.first);
        if (paramPrivExtV2Req.extendInfo == null) {
          paramPrivExtV2Req.extendInfo = new HashMap();
        }
        paramPrivExtV2Req.extendInfo.put("room_schema", paramString.second);
        paramString = new StringBuilder();
        paramString.append("handleGetVipInfoReq getVipInfo set trace_info ");
        paramString.append(paramPrivExtV2Req.trace_info);
        QLog.e("VIPService", 1, paramString.toString());
      }
    }
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("MQQ.PrivInfoServer.PrivInfoObj");
    paramUniPacket.setFuncName("queryLhResources");
    paramToServiceMsg = paramToServiceMsg.extraData.getString(VipInfoHandler.a);
    VAResourcesReq localVAResourcesReq = new VAResourcesReq();
    localVAResourcesReq.sUin = paramToServiceMsg;
    localVAResourcesReq.resourcesFlag = 1;
    localVAResourcesReq.lastVisitTime = PrettyAccountUtil.a;
    paramUniPacket.put("req", localVAResourcesReq);
    return true;
  }
  
  private boolean b(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("MQQ.PrivInfoServer.PrivInfoObj");
    paramUniPacket.setFuncName("queryPrivInfoExtV2");
    String str3 = paramToServiceMsg.extraData.getString(VipInfoHandler.a);
    Object localObject1 = paramToServiceMsg.extraData.getString(VipInfoHandler.c);
    long l1 = paramToServiceMsg.extraData.getLong(VipInfoHandler.m);
    boolean bool3 = VasExtensionManager.a();
    PrivExtV2Req localPrivExtV2Req = new PrivExtV2Req();
    localPrivExtV2Req.sUin = str3;
    localPrivExtV2Req.sKey = ((String)localObject1);
    localPrivExtV2Req.iGetType = 0;
    localPrivExtV2Req.qua = QUA.getQUA3();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Ilive handleGetVipInfoReq qua = ");
    ((StringBuilder)localObject1).append(QUA.getQUA3());
    QLog.e("VIPService", 1, ((StringBuilder)localObject1).toString());
    localObject1 = BaseApplicationImpl.getApplication();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("CUKingCardFile_");
    ((StringBuilder)localObject2).append(str3);
    localObject2 = ((BaseApplicationImpl)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 4);
    String str4 = CUKingCardHelper.b(0, BaseApplicationImpl.getContext());
    localObject1 = CUKingCardHelper.b(1, BaseApplicationImpl.getContext());
    String str2 = ((SharedPreferences)localObject2).getString("imsiOne", "");
    String str1 = ((SharedPreferences)localObject2).getString("imsiTwo", "");
    long l2 = ((SharedPreferences)localObject2).getLong("kingCardLastRequest", 0L);
    long l3 = ((SharedPreferences)localObject2).getInt("kingCardRequestInterval", 0);
    long l4 = System.currentTimeMillis() / 1000L;
    localPrivExtV2Req.lastVisitTime = l1;
    localPrivExtV2Req.iItemCfgVer = a(str3);
    if (!TextUtils.isEmpty(str4))
    {
      localPrivExtV2Req.sImsi1 = str4;
    }
    else if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localPrivExtV2Req.sImsi1 = ((String)localObject1);
      localObject1 = null;
    }
    else
    {
      try
      {
        localPrivExtV2Req.sImsi1 = QQDeviceInfo.getIMSI("a4bd32");
      }
      catch (Exception localException)
      {
        QLog.e("VIPService", 1, "handleGetVipInfoReq", localException);
      }
    }
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject1 = "";
    }
    localPrivExtV2Req.sImsi2 = ((String)localObject1);
    a(localPrivExtV2Req, paramToServiceMsg.extraData.getString(VipInfoHandler.d));
    int k = ((SharedPreferences)localObject2).getInt("kingCardSdk", -1);
    boolean bool1;
    boolean bool2;
    if ((bool3) && (k >= 0))
    {
      localPrivExtV2Req.sImsi2 = "";
      localPrivExtV2Req.sImsi1 = "";
      localPrivExtV2Req.iWkOrderState1 = k;
      bool1 = false;
      bool2 = false;
    }
    else
    {
      if ((TextUtils.isEmpty(localPrivExtV2Req.sImsi1)) && (TextUtils.isEmpty(localPrivExtV2Req.sImsi2))) {
        localPrivExtV2Req.iGetType = 1;
      }
      int i;
      if (((!TextUtils.isEmpty(localPrivExtV2Req.sImsi1)) && (!localPrivExtV2Req.sImsi1.equals(str2))) || (TextUtils.isEmpty(localPrivExtV2Req.sImsi1)))
      {
        localObject1 = ((SharedPreferences)localObject2).edit();
        ((SharedPreferences.Editor)localObject1).putString("imsiOne", "");
        ((SharedPreferences.Editor)localObject1).putInt("kingCard", -1);
        ((SharedPreferences.Editor)localObject1).commit();
        i = 1;
      }
      else
      {
        if (l4 - l2 < l3) {
          localPrivExtV2Req.sImsi1 = "";
        }
        i = 0;
      }
      if (!TextUtils.isEmpty(localPrivExtV2Req.sImsi2)) {
        if (!localPrivExtV2Req.sImsi2.equals(str1)) {
          break label597;
        }
      }
      label597:
      int j;
      if (TextUtils.isEmpty(localPrivExtV2Req.sImsi2))
      {
        localObject1 = ((SharedPreferences)localObject2).edit();
        ((SharedPreferences.Editor)localObject1).putString("imsiTwo", "");
        ((SharedPreferences.Editor)localObject1).putInt("kingCard2", -1);
        ((SharedPreferences.Editor)localObject1).commit();
        j = 1;
      }
      else
      {
        j = i;
        if (l4 - l2 < l3)
        {
          localPrivExtV2Req.sImsi2 = "";
          j = i;
        }
      }
      bool1 = TextUtils.isEmpty(localPrivExtV2Req.sImsi1) ^ true;
      bool2 = TextUtils.isEmpty(localPrivExtV2Req.sImsi2) ^ true;
      if (bool1) {
        paramToServiceMsg.extraData.putString(VipInfoHandler.k, localPrivExtV2Req.sImsi1);
      }
      if (bool2) {
        paramToServiceMsg.extraData.putString(VipInfoHandler.l, localPrivExtV2Req.sImsi2);
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
    }
    localPrivExtV2Req.iToastVer = ((SharedPreferences)localObject2).getInt("toast_version", 0);
    localPrivExtV2Req.iPopupVer = ((SharedPreferences)localObject2).getInt("popup_version_v2", 0);
    localPrivExtV2Req.pullPayRuleCfgTime = QVipConfigManager.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "last_pull_pay_rule", 0L);
    localPrivExtV2Req.clientLangugeId = 0;
    a(localPrivExtV2Req);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("handleGetVipInfoReq, pullPayRuleCfgTime=");
    ((StringBuilder)localObject1).append(localPrivExtV2Req.pullPayRuleCfgTime);
    QLog.e("VIPService", 1, ((StringBuilder)localObject1).toString());
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleGetVipInfoReq, iPopupVer: ");
      ((StringBuilder)localObject1).append(localPrivExtV2Req.iPopupVer);
      ((StringBuilder)localObject1).append(" iToastVer:");
      ((StringBuilder)localObject1).append(localPrivExtV2Req.iToastVer);
      ((StringBuilder)localObject1).append(" canUseTMS:");
      ((StringBuilder)localObject1).append(bool3);
      ((StringBuilder)localObject1).append(" sdkCardStatus:");
      ((StringBuilder)localObject1).append(k);
      ((StringBuilder)localObject1).append(", send sim1: ");
      ((StringBuilder)localObject1).append(bool1);
      ((StringBuilder)localObject1).append(", send sim2:");
      ((StringBuilder)localObject1).append(bool2);
      QLog.i("VIPService", 2, ((StringBuilder)localObject1).toString());
    }
    paramToServiceMsg.extraData.putBoolean(VipInfoHandler.i, bool1);
    paramToServiceMsg.extraData.putBoolean(VipInfoHandler.j, bool2);
    paramUniPacket.put("req", localPrivExtV2Req);
    return true;
  }
  
  public String[] cmdHeaderPrefix()
  {
    return a;
  }
  
  public Object decode(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ("ClubInfoSvc.queryPrivExt".equals(paramToServiceMsg.getServiceCmd()))
    {
      if (paramToServiceMsg.extraData.getInt(VipInfoHandler.b) == 6) {
        return a(paramToServiceMsg, paramFromServiceMsg, new VAResourcesRsp());
      }
      return a(paramToServiceMsg, paramFromServiceMsg, new PrivExtV2Rsp());
    }
    if ("ClubInfoSvc.guanjiaReport".equals(paramToServiceMsg.getServiceCmd())) {
      return a(paramToServiceMsg, paramFromServiceMsg, new GuanjiaReportRsp());
    }
    if ("VipCustom.GetCustomOnlineStatus".equals(paramToServiceMsg.getServiceCmd()))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("CustomOnlineStatusManager", 4, "decode");
      }
      return a(paramToServiceMsg, paramFromServiceMsg, new GetCustomOnlineStatusRsp());
    }
    if ("QCUniBusinessLogic.uniSet".equals(paramToServiceMsg.getServiceCmd())) {
      return a(paramToServiceMsg, paramFromServiceMsg, new UniSetRsp());
    }
    if ("QCUniBusinessLogic.uniGet".equals(paramToServiceMsg.getServiceCmd())) {
      return a(paramToServiceMsg, paramFromServiceMsg, new UniGetRsp());
    }
    return null;
  }
  
  public boolean encodeReqMsg(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if ("ClubInfoSvc.queryPrivExt".equals(paramToServiceMsg.getServiceCmd()))
    {
      if (paramToServiceMsg.extraData.getInt(VipInfoHandler.b) == 6) {
        return a(paramToServiceMsg, paramUniPacket);
      }
      return b(paramToServiceMsg, paramUniPacket);
    }
    Object localObject;
    if ("ClubInfoSvc.guanjiaReport".equals(paramToServiceMsg.getServiceCmd()))
    {
      paramUniPacket.setServantName("MQQ.PrivInfoServer.PrivInfoObj");
      paramUniPacket.setFuncName("guanjiaDoReport");
      localObject = paramToServiceMsg.extraData.getString(VipInfoHandler.a);
      GuanjiaReportReq localGuanjiaReportReq = new GuanjiaReportReq();
      localGuanjiaReportReq.sPkgName = "mobileQQ";
      localGuanjiaReportReq.uin = Long.parseLong((String)localObject);
      localGuanjiaReportReq.iImplat = 109;
      localGuanjiaReportReq.sPhoneNum = paramToServiceMsg.extraData.getString(VipInfoHandler.e);
      localGuanjiaReportReq.bKingCard = paramToServiceMsg.extraData.getBoolean(VipInfoHandler.f);
      localGuanjiaReportReq.iCardType = paramToServiceMsg.extraData.getInt(VipInfoHandler.g);
      localGuanjiaReportReq.iCardStatus = paramToServiceMsg.extraData.getInt(VipInfoHandler.h);
      localGuanjiaReportReq.bReportFlag = false;
      paramUniPacket.put("req", localGuanjiaReportReq);
      return true;
    }
    if ("VipCustom.GetCustomOnlineStatus".equals(paramToServiceMsg.getServiceCmd()))
    {
      paramUniPacket.setServantName("VIP.CustomOnlineStatusServer.CustomOnlineStatusObj");
      paramUniPacket.setFuncName("GetCustomOnlineStatus");
      localObject = new GetCustomOnlineStatusReq();
      ((GetCustomOnlineStatusReq)localObject).lUin = paramToServiceMsg.extraData.getLong(VipInfoHandler.n);
      ((GetCustomOnlineStatusReq)localObject).sIMei = MsfSdkUtils.getIMEIForMain("bussiness_id_customize_online_status");
      paramUniPacket.put("req", localObject);
      if (QLog.isDevelopLevel()) {
        QLog.d("CustomOnlineStatusManager", 4, "encodeReqMsg");
      }
      return true;
    }
    if ("QCUniBusinessLogic.uniSet".equals(paramToServiceMsg.getServiceCmd()))
    {
      paramUniPacket.setServantName("QC.UniBusinessLogicServer.UniBusinessLogicObj");
      paramUniPacket.setFuncName("uniSet");
      paramUniPacket.put("stReq", paramToServiceMsg.extraData.getSerializable("req"));
      return true;
    }
    if ("QCUniBusinessLogic.uniGet".equals(paramToServiceMsg.getServiceCmd()))
    {
      paramUniPacket.setServantName("QC.UniBusinessLogicServer.UniBusinessLogicObj");
      paramUniPacket.setFuncName("uniGet");
      paramUniPacket.put("stReq", paramToServiceMsg.extraData.getSerializable("req"));
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.VIPService
 * JD-Core Version:    0.7.0.1
 */