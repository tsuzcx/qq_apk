package com.tencent.mobileqq.service;

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
import com.tencent.mobileqq.vip.CUKingCardHelper;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQDeviceInfo;

public class VIPService
  extends BaseProtocolCoder
{
  private static final String[] a = { "ClubInfoSvc" };
  
  private Object b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg == null) {
      return null;
    }
    paramToServiceMsg = new UniPacket(true);
    try
    {
      paramToServiceMsg.setEncodeName("utf-8");
      paramToServiceMsg.decode(paramFromServiceMsg.getWupBuffer());
      paramToServiceMsg = (PrivExtV2Rsp)paramToServiceMsg.getByClass("rsp", new PrivExtV2Rsp());
      return paramToServiceMsg;
    }
    catch (RuntimeException paramToServiceMsg)
    {
      paramToServiceMsg.printStackTrace();
      return null;
    }
    catch (Exception paramToServiceMsg) {}
    return null;
  }
  
  private boolean b(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("MQQ.PrivInfoServer.PrivInfoObj");
    paramUniPacket.setFuncName("queryPrivInfoExtV2");
    Object localObject1 = paramToServiceMsg.extraData.getString("k_uin");
    Object localObject2 = paramToServiceMsg.extraData.getString("k_skey");
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
    label192:
    label377:
    boolean bool1;
    if (!TextUtils.isEmpty(str3))
    {
      localPrivExtV2Req.sImsi1 = str3;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label646;
      }
      localPrivExtV2Req.sImsi2 = ((String)localObject1);
      if ((TextUtils.isEmpty(localPrivExtV2Req.sImsi1)) && (TextUtils.isEmpty(localPrivExtV2Req.sImsi2))) {
        localPrivExtV2Req.iGetType = 1;
      }
      if (((TextUtils.isEmpty(localPrivExtV2Req.sImsi1)) || (localPrivExtV2Req.sImsi1.equals(str2))) && (!TextUtils.isEmpty(localPrivExtV2Req.sImsi1))) {
        break label653;
      }
      localObject1 = ((SharedPreferences)localObject2).edit();
      ((SharedPreferences.Editor)localObject1).putString("imsiOne", "");
      ((SharedPreferences.Editor)localObject1).putInt("kingCard", -1);
      ((SharedPreferences.Editor)localObject1).commit();
      label302:
      if (((TextUtils.isEmpty(localPrivExtV2Req.sImsi2)) || (localPrivExtV2Req.sImsi2.equals(str1))) && (!TextUtils.isEmpty(localPrivExtV2Req.sImsi2))) {
        break label673;
      }
      localObject1 = ((SharedPreferences)localObject2).edit();
      ((SharedPreferences.Editor)localObject1).putString("imsiTwo", "");
      ((SharedPreferences.Editor)localObject1).putInt("kingCard2", -1);
      ((SharedPreferences.Editor)localObject1).commit();
      if (TextUtils.isEmpty(localPrivExtV2Req.sImsi1)) {
        break label693;
      }
      bool1 = true;
      label391:
      if (TextUtils.isEmpty(localPrivExtV2Req.sImsi2)) {
        break label699;
      }
    }
    label646:
    label653:
    label673:
    label693:
    label699:
    for (boolean bool2 = true;; bool2 = false)
    {
      for (;;)
      {
        if (bool1) {
          paramToServiceMsg.extraData.putString(VipInfoHandler.f, localPrivExtV2Req.sImsi1);
        }
        if (bool2) {
          paramToServiceMsg.extraData.putString(VipInfoHandler.g, localPrivExtV2Req.sImsi2);
        }
        localPrivExtV2Req.iWkOrderState1 = ((SharedPreferences)localObject2).getInt("kingCard", -1);
        localPrivExtV2Req.iWkOrderState2 = ((SharedPreferences)localObject2).getInt("kingCard2", -1);
        localPrivExtV2Req.iToastVer = ((SharedPreferences)localObject2).getInt("toast_version", 0);
        localPrivExtV2Req.iPopupVer = ((SharedPreferences)localObject2).getInt("popup_version_v2", 0);
        if (QLog.isColorLevel()) {
          QLog.i("VIPService", 2, "handleGetVipInfoReq, send CUKing Card version: " + localPrivExtV2Req.iPopupVer + ", send sim1: " + bool1 + ", send sim2:" + bool2);
        }
        paramToServiceMsg.extraData.putBoolean(VipInfoHandler.d, bool1);
        paramToServiceMsg.extraData.putBoolean(VipInfoHandler.e, bool2);
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
      localObject1 = "";
      break label192;
      if (l3 - l1 >= l2) {
        break label302;
      }
      localPrivExtV2Req.sImsi1 = "";
      break label302;
      if (l3 - l1 >= l2) {
        break label377;
      }
      localPrivExtV2Req.sImsi2 = "";
      break label377;
      bool1 = false;
      break label391;
    }
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ("ClubInfoSvc.queryPrivExt".equals(paramToServiceMsg.getServiceCmd())) {
      return b(paramToServiceMsg, paramFromServiceMsg);
    }
    return null;
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if ("ClubInfoSvc.queryPrivExt".equals(paramToServiceMsg.getServiceCmd())) {
      return b(paramToServiceMsg, paramUniPacket);
    }
    return false;
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