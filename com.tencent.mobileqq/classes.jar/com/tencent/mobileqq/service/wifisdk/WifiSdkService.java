package com.tencent.mobileqq.service.wifisdk;

import MCommon.Sharkfin;
import MConch.CSPullConchs;
import MConch.SCPullConchs;
import MShark.CSGUIDRegist;
import MShark.SCGUIDRegist;
import MWIFI.CSGet3rdCloudCheck;
import MWIFI.SCGet3rdCloudCheck;
import android.content.Context;
import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.qq.jce.wup.WupHexUtil;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qmethodmonitor.monitor.NetworkMonitor;
import com.tencent.mobileqq.wifi.WifiSdkSharedPreUtils;
import com.tencent.mobileqq.wifi.WifiSdkUtil;
import com.tencent.mobileqq.wifi.WifiSecurityCheckInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQDeviceInfo;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class WifiSdkService
  extends BaseProtocolCoder
{
  private QQAppInterface a = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
  
  private Sharkfin a(String paramString)
  {
    Sharkfin localSharkfin = new Sharkfin();
    localSharkfin.sessionId = "";
    localSharkfin.buildno = 6601;
    localSharkfin.apn = 0;
    localSharkfin.netType = 0;
    localSharkfin.authType = 0;
    localSharkfin.guid = paramString;
    localSharkfin.accountId = 0L;
    localSharkfin.bootType = 0;
    localSharkfin.wsGuid = "";
    localSharkfin.ext1 = "";
    return localSharkfin;
  }
  
  private CSPullConchs a()
  {
    CSPullConchs localCSPullConchs = new CSPullConchs();
    localCSPullConchs.cmdId = -1;
    return localCSPullConchs;
  }
  
  private CSGet3rdCloudCheck a(Context paramContext, ToServiceMsg paramToServiceMsg)
  {
    int i = WifiSdkUtil.b(paramContext);
    Object localObject4 = null;
    if (i == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("WifiSdk", 2, "encodeReqMsg, networkType is none");
      }
      return null;
    }
    CSGet3rdCloudCheck localCSGet3rdCloudCheck = new CSGet3rdCloudCheck();
    if (i == 1)
    {
      paramContext = (WifiManager)paramContext.getSystemService("wifi");
      if (paramContext == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("WifiSdk", 2, "encodeReqMsg, systmeWifiMgr is null");
        }
        return null;
      }
      Object localObject2 = NetworkMonitor.getConnectionInfo(paramContext);
      if (localObject2 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("WifiSdk", 2, "encodeReqMsg, currentWifi is null");
        }
        return null;
      }
      Object localObject1 = ((android.net.wifi.WifiInfo)localObject2).getSSID();
      localObject2 = ((android.net.wifi.WifiInfo)localObject2).getBSSID();
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
      {
        paramToServiceMsg.addAttribute("bssid", localObject2);
        paramToServiceMsg.addAttribute("ssid", localObject1);
        localCSGet3rdCloudCheck.networkType = 1;
        localCSGet3rdCloudCheck.wifiInfo = new MWIFI.WifiInfo();
        localCSGet3rdCloudCheck.wifiInfo.ssid = ((String)localObject1);
        localCSGet3rdCloudCheck.wifiInfo.bssid = ((String)localObject2);
        Object localObject3;
        try
        {
          localObject1 = paramContext.getDhcpInfo();
          if (localObject1 != null)
          {
            paramContext = WifiSdkUtil.a(((DhcpInfo)localObject1).dns1);
            try
            {
              localObject3 = WifiSdkUtil.a(((DhcpInfo)localObject1).dns2);
              localObject1 = paramContext;
            }
            catch (Exception localException1)
            {
              break label245;
            }
          }
          else
          {
            localObject1 = null;
            localObject3 = localObject4;
          }
        }
        catch (Exception localException2)
        {
          paramContext = null;
          label245:
          localObject1 = paramContext;
          localObject3 = localObject4;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("encodeReqMsg, get dns info exception: ");
            ((StringBuilder)localObject1).append(localException2.getMessage());
            QLog.i("WifiSdk", 2, ((StringBuilder)localObject1).toString());
            localObject3 = localObject4;
            localObject1 = paramContext;
          }
        }
        localCSGet3rdCloudCheck.vecDns = new ArrayList(2);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localCSGet3rdCloudCheck.vecDns.add(localObject1);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          localCSGet3rdCloudCheck.vecDns.add(localObject3);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("WifiSdk", 2, "encodeReqMsg, ssid or bssid is null");
        }
        return null;
      }
    }
    else
    {
      localCSGet3rdCloudCheck.networkType = i;
      localCSGet3rdCloudCheck.operType = WifiSdkUtil.a(paramContext);
    }
    paramContext = QQDeviceInfo.getIMEI("f5cc92");
    if (!TextUtils.isEmpty(paramContext)) {
      localCSGet3rdCloudCheck.imei = paramContext;
    }
    localCSGet3rdCloudCheck.mac = WifiSdkUtil.a();
    localCSGet3rdCloudCheck.vid = WifiSdkUtil.b();
    paramToServiceMsg.addAttribute("network_type", Integer.valueOf(localCSGet3rdCloudCheck.networkType));
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("encodeReqMsg, imei: ");
      paramContext.append(localCSGet3rdCloudCheck.imei);
      paramContext.append(" mac: ");
      paramContext.append(localCSGet3rdCloudCheck.mac);
      paramContext.append(" vid: ");
      paramContext.append(localCSGet3rdCloudCheck.vid);
      QLog.i("WifiSdk", 2, paramContext.toString());
    }
    return localCSGet3rdCloudCheck;
  }
  
  private SCGet3rdCloudCheck a(ToServiceMsg paramToServiceMsg, SCGet3rdCloudCheck paramSCGet3rdCloudCheck)
  {
    if ((paramSCGet3rdCloudCheck != null) && (paramToServiceMsg != null))
    {
      if (((Integer)paramToServiceMsg.getAttribute("network_type", Integer.valueOf(-1))).intValue() == 1)
      {
        Object localObject1 = this.a.getApplication().getApplicationContext();
        if (WifiSdkUtil.b((Context)localObject1) != 1)
        {
          if (QLog.isColorLevel()) {
            QLog.i("WifiSdk", 2, "handleWifiSecurityCheckInfo, networkType is invaild");
          }
          return null;
        }
        Object localObject2 = NetworkMonitor.getConnectionInfo((WifiManager)((Context)localObject1).getSystemService("wifi"));
        localObject1 = ((android.net.wifi.WifiInfo)localObject2).getSSID();
        localObject2 = ((android.net.wifi.WifiInfo)localObject2).getBSSID();
        String str = (String)paramToServiceMsg.getAttribute("ssid", "");
        paramToServiceMsg = (String)paramToServiceMsg.getAttribute("bssid", "");
        if ((!TextUtils.equals((CharSequence)localObject1, str)) && (!TextUtils.equals((CharSequence)localObject2, paramToServiceMsg)))
        {
          if (QLog.isColorLevel()) {
            QLog.i("WifiSdk", 2, "handleWifiSecurityCheckInfo, ssid and bssid is not the same");
          }
          return null;
        }
      }
      if (TextUtils.isEmpty(paramSCGet3rdCloudCheck.tips))
      {
        if (QLog.isColorLevel()) {
          QLog.i("WifiSdk", 2, "handleWifiSecurityCheckInfo, tips is null");
        }
        return null;
      }
      return paramSCGet3rdCloudCheck;
    }
    if (QLog.isColorLevel()) {
      QLog.i("WifiSdk", 2, "handleWifiSecurityCheckInfo, response or request is null");
    }
    return null;
  }
  
  public CSGUIDRegist a(Context paramContext)
  {
    CSGUIDRegist localCSGUIDRegist = new CSGUIDRegist();
    localCSGUIDRegist.imei = QQDeviceInfo.getIMEI("f5cc92");
    localCSGUIDRegist.imsi = QQDeviceInfo.getIMSI("f5cc92");
    localCSGUIDRegist.mac = WifiSdkUtil.a();
    localCSGUIDRegist.lc = "FF4A5386F7B20DCB";
    localCSGUIDRegist.buildno = 6601;
    localCSGUIDRegist.channelid = "102769";
    localCSGUIDRegist.pkgname = paramContext.getPackageName();
    localCSGUIDRegist.build_brand = Build.BRAND;
    localCSGUIDRegist.build_version_incremental = Build.VERSION.INCREMENTAL;
    localCSGUIDRegist.build_version_release = Build.VERSION.RELEASE;
    localCSGUIDRegist.isbuildin = false;
    localCSGUIDRegist.platform = 2;
    localCSGUIDRegist.product = 106;
    localCSGUIDRegist.subplatform = 201;
    localCSGUIDRegist.ua = Build.MODEL;
    return localCSGUIDRegist;
  }
  
  public String[] cmdHeaderPrefix()
  {
    return new String[] { "WifiCloudCheckSvc" };
  }
  
  public Object decode(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("decode, serviceCmd: ");
      ((StringBuilder)localObject1).append(paramToServiceMsg.getServiceCmd());
      QLog.i("WifiSdk", 2, ((StringBuilder)localObject1).toString());
    }
    try
    {
      if ("WifiCloudCheckSvc.req".equals(paramToServiceMsg.getServiceCmd()))
      {
        int k = ((Integer)paramToServiceMsg.getAttribute("request_type", Integer.valueOf(-1))).intValue();
        localObject1 = paramFromServiceMsg.getWupBuffer();
        paramFromServiceMsg = new byte[localObject1.length - 4];
        int j = localObject1.length;
        int i = 0;
        System.arraycopy(localObject1, 4, paramFromServiceMsg, 0, j - 4);
        if (QLog.isColorLevel())
        {
          localObject1 = WupHexUtil.bytes2HexStr(paramFromServiceMsg);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("decode, full data: ");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.i("WifiSdk", 2, ((StringBuilder)localObject2).toString());
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("decode, requestType: ");
          ((StringBuilder)localObject2).append(k);
          QLog.i("WifiSdk", 2, ((StringBuilder)localObject2).toString());
          if (localObject1 != null)
          {
            localObject2 = ((String)localObject1).toLowerCase();
            int m = ((String)localObject2).length();
            localObject1 = new StringBuilder();
            j = 0;
            while ((i < m) && (j < m))
            {
              j = i + 2;
              ((StringBuilder)localObject1).append(((String)localObject2).substring(i, j));
              ((StringBuilder)localObject1).append(" ");
              i = j;
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("decode, full data: ");
            ((StringBuilder)localObject2).append(((StringBuilder)localObject1).toString());
            QLog.i("WifiSdk", 2, ((StringBuilder)localObject2).toString());
          }
        }
        if (k != 1)
        {
          if (k != 2)
          {
            if (k != 3) {
              return null;
            }
            paramToServiceMsg = new UniPacket(true);
            paramToServiceMsg.setEncodeName("utf-8");
            paramToServiceMsg.decode(paramFromServiceMsg);
            return (SCPullConchs)paramToServiceMsg.get("SCPullConchs", null);
          }
          paramToServiceMsg = new UniPacket(true);
          paramToServiceMsg.setEncodeName("utf-8");
          paramToServiceMsg.decode(paramFromServiceMsg);
          paramToServiceMsg = (SCGUIDRegist)paramToServiceMsg.get("SCGUIDRegist", null);
          if (paramToServiceMsg == null) {
            return null;
          }
          return paramToServiceMsg.guid;
        }
        localObject1 = new UniPacket(true);
        ((UniPacket)localObject1).setEncodeName("utf-8");
        ((UniPacket)localObject1).decode(paramFromServiceMsg);
        paramFromServiceMsg = (SCGet3rdCloudCheck)((UniPacket)localObject1).get("SCGet3rdCloudCheck", null);
        Object localObject2 = new WifiSecurityCheckInfo();
        ((WifiSecurityCheckInfo)localObject2).b = ((SCPullConchs)((UniPacket)localObject1).get("SCPullConchs", null));
        ((WifiSecurityCheckInfo)localObject2).a = a(paramToServiceMsg, paramFromServiceMsg);
        return localObject2;
      }
    }
    catch (Throwable paramToServiceMsg)
    {
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("decode exception: ");
        paramFromServiceMsg.append(paramToServiceMsg.getMessage());
        QLog.i("WifiSdk", 2, paramFromServiceMsg.toString());
      }
    }
    return null;
  }
  
  public boolean encodeReqMsg(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("encodeReqMsg, serviceCmd: ");
      ((StringBuilder)localObject).append(paramToServiceMsg.getServiceCmd());
      QLog.i("WifiSdk", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      if ("WifiCloudCheckSvc.req".equals(paramToServiceMsg.getServiceCmd()))
      {
        localObject = this.a.getApplication().getApplicationContext();
        int i = ((Integer)paramToServiceMsg.getAttribute("request_type", Integer.valueOf(-1))).intValue();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("encodeReqMsg, requestType: ");
          localStringBuilder.append(i);
          QLog.i("WifiSdk", 2, localStringBuilder.toString());
        }
        if (i != 1)
        {
          if (i != 2)
          {
            if (i == 3) {
              paramUniPacket.put("CSPullConchs", a());
            }
          }
          else {
            paramUniPacket.put("CSGUIDRegist", a((Context)localObject));
          }
        }
        else
        {
          paramToServiceMsg = a((Context)localObject, paramToServiceMsg);
          if (paramToServiceMsg != null) {
            paramUniPacket.put("CSGet3rdCloudCheck", paramToServiceMsg);
          }
          paramUniPacket.put("CSPullConchs", a());
        }
        paramUniPacket.setServantName("WifiSdkObj");
        paramUniPacket.setFuncName("req");
        paramToServiceMsg = WifiSdkSharedPreUtils.a(this.a.getApp(), this.a.getCurrentAccountUin());
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("encodeReqMsg, guid: ");
          ((StringBuilder)localObject).append(paramToServiceMsg);
          QLog.i("WifiSdk", 1, ((StringBuilder)localObject).toString());
        }
        paramUniPacket.put("Sharkfin", a(paramToServiceMsg));
        return true;
      }
    }
    catch (Exception paramToServiceMsg)
    {
      if (QLog.isColorLevel())
      {
        paramUniPacket = new StringBuilder();
        paramUniPacket.append("encodeReqMsg exception: ");
        paramUniPacket.append(paramToServiceMsg.getMessage());
        QLog.i("WifiSdk", 2, paramUniPacket.toString());
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.wifisdk.WifiSdkService
 * JD-Core Version:    0.7.0.1
 */