package com.tencent.mobileqq.service.config;

import MAAccessClient.AccessReq;
import MAAccessClient.AccessRsp;
import MAAccessClient.CheckSinglePkgSigReq;
import MAAccessClient.GetSinglePkgSigReq;
import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import protocol.KQQConfig.GetResourceReq;
import protocol.KQQConfig.GetResourceResp;
import protocol.KQQConfig.SDKUpgradeReq;
import protocol.KQQConfig.SDKUpgradeRes;
import protocol.KQQConfig.UpgradeInfo;

public class ConfigService
  extends BaseProtocolCoder
{
  private static final String[] a = { "ConfigServantObj", "ConfigService", "MAAControl", "ResourceConfig" };
  
  private AccessReq a(byte[] paramArrayOfByte)
  {
    AccessReq localAccessReq = new AccessReq();
    localAccessReq.gray = 0;
    String str2 = DeviceInfoUtil.b();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localAccessReq.imei = str1;
    str2 = DeviceInfoUtil.w();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localAccessReq.manufacture = str1;
    str2 = DeviceInfoUtil.u();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localAccessReq.mode = str1;
    str2 = DeviceInfoUtil.v();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localAccessReq.rom = str1;
    localAccessReq.body = paramArrayOfByte;
    localAccessReq.platform = 1;
    if (QLog.isDevelopLevel())
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("createAccessReq:\nimei:");
      paramArrayOfByte.append(localAccessReq.imei);
      paramArrayOfByte.append("\ngray:");
      paramArrayOfByte.append(localAccessReq.gray);
      QLog.d("UpgradeController", 4, paramArrayOfByte.toString());
    }
    return localAccessReq;
  }
  
  private Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (GetResourceResp)decodePacket(paramFromServiceMsg.getWupBuffer(), "res", new GetResourceResp());
  }
  
  private Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, String paramString)
  {
    return (AccessRsp)decodePacket(paramFromServiceMsg.getWupBuffer(), paramString, new AccessRsp());
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("ConfigServantObj");
    paramUniPacket.setFuncName("ClientReq");
    paramUniPacket.put("iCmdType", Integer.valueOf(1));
    SDKUpgradeReq localSDKUpgradeReq = new SDKUpgradeReq();
    localSDKUpgradeReq.cProtocolVer = 1;
    localSDKUpgradeReq.iActionType = paramToServiceMsg.extraData.getInt("iActionType");
    localSDKUpgradeReq.iWidth = paramToServiceMsg.extraData.getInt("iWidth");
    localSDKUpgradeReq.iHeight = paramToServiceMsg.extraData.getInt("iHeight");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Get Config: ");
      ((StringBuilder)localObject).append(localSDKUpgradeReq.iActionType);
      ((StringBuilder)localObject).append(localSDKUpgradeReq.iActionType);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(localSDKUpgradeReq.iWidth);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(localSDKUpgradeReq.iHeight);
      QLog.d("UpgradeController", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(paramToServiceMsg.getUin());
    localSDKUpgradeReq.vUin = ((ArrayList)localObject);
    localSDKUpgradeReq.bSdkUpdateFlag = false;
    localObject = new ArrayList();
    ((ArrayList)localObject).add(Integer.valueOf(AppSetting.d()));
    localSDKUpgradeReq.vAppid = ((ArrayList)localObject);
    paramUniPacket.put("SDKUpgradeReq", localSDKUpgradeReq);
    paramToServiceMsg.setTimeout(20000L);
    return true;
  }
  
  private Object b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (SDKUpgradeRes)decodePacket(paramFromServiceMsg.getWupBuffer(), "SDKUpgradeRes", new SDKUpgradeRes());
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("Get Upgrade Config Resp: ");
      paramFromServiceMsg.append(paramToServiceMsg);
      QLog.d("UpgradeController", 2, paramFromServiceMsg.toString());
      if (paramToServiceMsg != null)
      {
        if ((paramToServiceMsg.vUpgradeInfo != null) && (paramToServiceMsg.vUpgradeInfo.size() > 0))
        {
          paramFromServiceMsg = (UpgradeInfo)paramToServiceMsg.vUpgradeInfo.get(0);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Get UpgradeInfo: ");
          localStringBuilder.append(paramFromServiceMsg);
          QLog.d("UpgradeController", 2, localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("iAppid: ");
          localStringBuilder.append(paramFromServiceMsg.iAppid);
          QLog.d("UpgradeController", 2, localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("bAppType: ");
          localStringBuilder.append(paramFromServiceMsg.bAppType);
          QLog.d("UpgradeController", 2, localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("iUpgradeType: ");
          localStringBuilder.append(paramFromServiceMsg.iUpgradeType);
          QLog.d("UpgradeController", 2, localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("iUpgradeSdkId: ");
          localStringBuilder.append(paramFromServiceMsg.iUpgradeSdkId);
          QLog.d("UpgradeController", 2, localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("strTitle: ");
          localStringBuilder.append(paramFromServiceMsg.strTitle);
          QLog.d("UpgradeController", 2, localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("strUpgradeDesc: ");
          localStringBuilder.append(paramFromServiceMsg.strUpgradeDesc);
          QLog.d("UpgradeController", 2, localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("strUrl: ");
          localStringBuilder.append(paramFromServiceMsg.strUrl);
          QLog.d("UpgradeController", 2, localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("iActionType=0: ");
          localStringBuilder.append(paramFromServiceMsg.iActionType);
          QLog.d("UpgradeController", 2, localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("bNewSwitch: ");
          localStringBuilder.append(paramFromServiceMsg.bNewSwitch);
          QLog.d("UpgradeController", 2, localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("iNewTimeStamp: ");
          localStringBuilder.append(paramFromServiceMsg.iNewTimeStamp);
          QLog.d("UpgradeController", 2, localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("strUpgradePageUrl: ");
          localStringBuilder.append(paramFromServiceMsg.strUpgradePageUrl);
          QLog.d("UpgradeController", 2, localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("iIncrementUpgrade: ");
          localStringBuilder.append(paramFromServiceMsg.iIncrementUpgrade);
          QLog.d("UpgradeController", 2, localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("iTipsType: ");
          localStringBuilder.append(paramFromServiceMsg.iTipsType);
          QLog.d("UpgradeController", 2, localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("strBannerPicUrl: ");
          localStringBuilder.append(paramFromServiceMsg.strBannerPicUrl);
          QLog.d("UpgradeController", 2, localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("strNewUpgradeDescURL: ");
          localStringBuilder.append(paramFromServiceMsg.strNewUpgradeDescURL);
          QLog.d("UpgradeController", 2, localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("iDisplayDay: ");
          localStringBuilder.append(paramFromServiceMsg.iDisplayDay);
          QLog.d("UpgradeController", 2, localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("iTipsWaitDay: ");
          localStringBuilder.append(paramFromServiceMsg.iTipsWaitDay);
          QLog.d("UpgradeController", 2, localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("strProgressName: ");
          localStringBuilder.append(paramFromServiceMsg.strProgressName);
          QLog.d("UpgradeController", 2, localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("strNewTipsDescURL: ");
          localStringBuilder.append(paramFromServiceMsg.strNewTipsDescURL);
          QLog.d("UpgradeController", 2, localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("strNewSoftwareURL: ");
          localStringBuilder.append(paramFromServiceMsg.strNewSoftwareURL);
          QLog.d("UpgradeController", 2, localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("bGray: ");
          localStringBuilder.append(paramFromServiceMsg.bGray);
          QLog.d("UpgradeController", 2, localStringBuilder.toString());
          return paramToServiceMsg;
        }
        QLog.d("UpgradeController", 2, "Not vUpgradeInfo");
      }
    }
    return paramToServiceMsg;
  }
  
  private boolean b(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("ConfigServantObj");
    paramUniPacket.setFuncName("GetResourceReq");
    ArrayList localArrayList = (ArrayList)paramToServiceMsg.extraData.getSerializable("getResourceReqInfos");
    GetResourceReq localGetResourceReq = new GetResourceReq();
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      localGetResourceReq.vecResReqInfo = localArrayList;
      localGetResourceReq.sLanCodeType = 1;
    }
    paramUniPacket.put("req", localGetResourceReq);
    if (QLog.isColorLevel())
    {
      paramUniPacket = new StringBuilder();
      paramUniPacket.append("encode request,servantName is:ConfigServantObj,funcName is:GetResourceReq,AppSeq is:");
      paramUniPacket.append(paramToServiceMsg.getAppSeq());
      QLog.d("ThemeDownloadTrace", 2, paramUniPacket.toString());
    }
    return true;
  }
  
  private boolean c(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("ConfigServantObj");
    paramUniPacket.setFuncName("GetResourceReq");
    CheckSinglePkgSigReq localCheckSinglePkgSigReq = new CheckSinglePkgSigReq();
    localCheckSinglePkgSigReq.pkgName = BaseApplicationImpl.sApplication.getPackageName();
    String str = paramToServiceMsg.extraData.getString("ac");
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    localCheckSinglePkgSigReq.pkgSig = ((String)localObject);
    localCheckSinglePkgSigReq.versionCode = ApkUtils.a(BaseApplicationImpl.sApplication);
    localCheckSinglePkgSigReq.marketVer = paramToServiceMsg.extraData.getInt("mv");
    localCheckSinglePkgSigReq.sysVer = DeviceInfoUtil.d();
    paramToServiceMsg = localCheckSinglePkgSigReq.toByteArray();
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("CheckSinglePkgSigReq:\nversionCode:");
      ((StringBuilder)localObject).append(localCheckSinglePkgSigReq.versionCode);
      QLog.d("UpgradeController", 4, ((StringBuilder)localObject).toString());
    }
    paramUniPacket.put("MAAControl.CheckSinglePkgSig", a(paramToServiceMsg));
    return true;
  }
  
  private boolean d(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("ConfigServantObj");
    paramUniPacket.setFuncName("GetResourceReq");
    GetSinglePkgSigReq localGetSinglePkgSigReq = new GetSinglePkgSigReq();
    localGetSinglePkgSigReq.pkgName = paramToServiceMsg.extraData.getString("pn");
    localGetSinglePkgSigReq.versionCode = paramToServiceMsg.extraData.getInt("vc");
    localGetSinglePkgSigReq.marketVer = paramToServiceMsg.extraData.getInt("mv");
    localGetSinglePkgSigReq.sysVer = paramToServiceMsg.extraData.getInt("sv");
    paramUniPacket.put("MAAControl.GetSinglePkgSig", a(localGetSinglePkgSigReq.toByteArray()));
    return true;
  }
  
  public String[] cmdHeaderPrefix()
  {
    return a;
  }
  
  public Object decode(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if ("ResourceConfig.GetResourceReq".equals(str)) {
      return a(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("ConfigService.ClientReq".equals(str)) {
      return b(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("MAAControl.CheckSinglePkgSig".equals(str)) {
      return a(paramToServiceMsg, paramFromServiceMsg, str);
    }
    if ("MAAControl.GetSinglePkgSig".equals(str)) {
      return a(paramToServiceMsg, paramFromServiceMsg, str);
    }
    return null;
  }
  
  public boolean encodeReqMsg(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    String str = paramToServiceMsg.getServiceCmd();
    if ("ConfigService.ClientReq".equals(str)) {
      return a(paramToServiceMsg, paramUniPacket);
    }
    if ("ResourceConfig.GetResourceReq".equals(str)) {
      return b(paramToServiceMsg, paramUniPacket);
    }
    if ("MAAControl.CheckSinglePkgSig".equals(str)) {
      return c(paramToServiceMsg, paramUniPacket);
    }
    if ("MAAControl.GetSinglePkgSig".equals(str)) {
      return d(paramToServiceMsg, paramUniPacket);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.config.ConfigService
 * JD-Core Version:    0.7.0.1
 */