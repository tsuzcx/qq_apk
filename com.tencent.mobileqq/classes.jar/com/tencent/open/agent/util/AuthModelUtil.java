package com.tencent.open.agent.util;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.config.business.OpenSdkIFrameProcessor;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.open.agent.entity.IconUrlSize;
import com.tencent.open.agent.entity.VirtualAccountInfo;
import com.tencent.open.model.AccountInfo;
import com.tencent.open.model.GetVirtualListResult;
import com.tencent.open.model.VirtualInfo;
import com.tencent.open.virtual.OpenSdkVirtualUtil;
import com.tencent.protofile.getappinfo.GetAppInfoProto.MsgIconsurl;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.WtloginManager;
import mqq.observer.SSOAccountObserver;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import tencent.im.login.GatewayVerify.RspBody;
import tencent.im.login.GatewayVerify.RspLftInfo;

public class AuthModelUtil
{
  public static AccountInfo a(WtloginManager paramWtloginManager, String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    paramWtloginManager = OpenSdkVirtualUtil.a(paramWtloginManager, paramString);
    paramString = new AccountInfo();
    paramString.a = paramWtloginManager;
    if (paramInt == 4096) {
      paramWtloginManager = new String(paramArrayOfByte);
    } else {
      paramWtloginManager = null;
    }
    paramString.b = paramWtloginManager;
    paramString.c = paramBundle.getByteArray("st_temp");
    paramString.d = paramBundle.getByteArray("st_temp_key");
    return paramString;
  }
  
  public static String a(Bundle paramBundle)
  {
    Object localObject = paramBundle.keySet();
    ((Set)localObject).remove("sdkp");
    ((Set)localObject).remove("sdkv");
    ((Set)localObject).remove("sign");
    ((Set)localObject).remove("time");
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = ((Set)localObject).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localObject = paramBundle.get(str);
      if (localObject != null) {
        localObject = localObject.toString();
      } else {
        localObject = "";
      }
      localStringBuilder.append(str);
      localStringBuilder.append("=");
      localStringBuilder.append(URLEncoder.encode((String)localObject));
      localStringBuilder.append("&");
    }
    if (localStringBuilder.length() > 0) {
      localStringBuilder.delete(localStringBuilder.length() - 1, localStringBuilder.length());
    }
    return localStringBuilder.toString();
  }
  
  public static List<IconUrlSize> a(PBRepeatMessageField<GetAppInfoProto.MsgIconsurl> paramPBRepeatMessageField)
  {
    ArrayList localArrayList = new ArrayList();
    if (!paramPBRepeatMessageField.has()) {
      return localArrayList;
    }
    int j = paramPBRepeatMessageField.size();
    int i = 0;
    while (i < j)
    {
      GetAppInfoProto.MsgIconsurl localMsgIconsurl = (GetAppInfoProto.MsgIconsurl)paramPBRepeatMessageField.get(i);
      localArrayList.add(new IconUrlSize(localMsgIconsurl.url, localMsgIconsurl.size));
      i += 1;
    }
    return localArrayList;
  }
  
  public static List<VirtualAccountInfo> a(GetVirtualListResult paramGetVirtualListResult, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramGetVirtualListResult.c != null) && (!paramGetVirtualListResult.c.isEmpty()))
    {
      Iterator localIterator = paramGetVirtualListResult.c.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (VirtualInfo)localIterator.next();
        if (((VirtualInfo)localObject).c == null) {
          break;
        }
        if (((VirtualInfo)localObject).b == null) {
          return localArrayList;
        }
        localObject = new VirtualAccountInfo((VirtualInfo)localObject);
        boolean bool;
        if ((((VirtualAccountInfo)localObject).c == paramGetVirtualListResult.b) && (paramBoolean)) {
          bool = true;
        } else {
          bool = false;
        }
        ((VirtualAccountInfo)localObject).d = bool;
        localArrayList.add(localObject);
      }
      return localArrayList;
    }
    SSOLog.a("AuthModelUtil", new Object[] { "getVirtualAccountInfoList list empty" });
    return localArrayList;
  }
  
  public static void a(Intent paramIntent, Bundle paramBundle, String paramString)
  {
    QLog.d("AuthModelUtil", 1, "handleAgentAppId");
    if (a(paramIntent, paramBundle)) {
      return;
    }
    long l2 = paramBundle.getLong("dstAppid");
    long l1 = l2;
    if (l2 == 0L) {
      l1 = 1600001540L;
    }
    paramBundle = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramBundle = String.valueOf(l1);
    }
    paramIntent.putExtra("im_block_sso_appid", paramBundle);
    paramIntent = new StringBuilder();
    paramIntent.append("put IM_BLOCK_SSO_APPID: ");
    paramIntent.append(paramBundle);
    QLog.d("AuthModelUtil", 1, paramIntent.toString());
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, SSOAccountObserver paramSSOAccountObserver)
  {
    QLog.d("AuthModelUtil", 1, new Object[] { "doWtLoginOnOpenSdk appId=", paramString1, ", uin=", AuthorityUtil.a(paramString2), ", observer=", paramSSOAccountObserver });
    if (!b(paramString1, paramString2, paramString3, paramSSOAccountObserver)) {
      return;
    }
    try
    {
      AppRuntime localAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
      QLog.d("AuthModelUtil", 1, new Object[] { "doWtLoginOnOpenSdk app = ", localAppRuntime });
      if (localAppRuntime == null)
      {
        paramSSOAccountObserver.onFailed(paramString1, 1100, -1012, new Bundle());
        return;
      }
      Bundle localBundle = new Bundle();
      if (OpenSdkIFrameProcessor.a()) {
        localBundle.putInt("puzzle_verify_code", 130);
      }
      localBundle.putByteArray("connect_data", AuthorityUtil.b(paramString1));
      localAppRuntime.ssoLogin(paramString2, paramString3, 4096, paramSSOAccountObserver, localBundle);
      return;
    }
    catch (Exception paramString2)
    {
      QLog.e("AuthModelUtil", 1, "Exception ", paramString2);
      paramSSOAccountObserver.onFailed(paramString1, 1100, -1012, new Bundle());
    }
  }
  
  private static boolean a(Intent paramIntent, Bundle paramBundle)
  {
    if ((paramIntent != null) && (paramBundle != null)) {
      return false;
    }
    QLog.e("AuthModelUtil", 1, "handleAgentAppId params empty");
    return true;
  }
  
  private static boolean a(WUserSigInfo paramWUserSigInfo)
  {
    if (paramWUserSigInfo == null) {
      return true;
    }
    paramWUserSigInfo = paramWUserSigInfo.loginResultTLVMap;
    if (paramWUserSigInfo == null) {
      return true;
    }
    paramWUserSigInfo = (tlv_t)paramWUserSigInfo.get(Integer.valueOf(1347));
    if (paramWUserSigInfo == null) {
      return true;
    }
    if (paramWUserSigInfo.get_data() == null) {
      return true;
    }
    QLog.d("AuthModelUtil", 1, "SigData is valid");
    return false;
  }
  
  public static void b(Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      SSOLog.b("AuthModelUtil", new Object[] { "createSign null == params" });
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(System.currentTimeMillis() / 1000L);
    ((StringBuilder)localObject1).append("");
    String str2 = ((StringBuilder)localObject1).toString();
    String str1 = paramBundle.getString("package_name");
    localObject1 = paramBundle.getString("sign");
    try
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(str1);
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(((String)localObject1).replace(":", "").toLowerCase());
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(str2);
      str1 = ((StringBuilder)localObject2).toString();
      localObject2 = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject2).update(str1.getBytes());
      str1 = HexUtil.bytes2HexStr(((MessageDigest)localObject2).digest());
      localObject1 = str1;
    }
    catch (Exception localException)
    {
      SSOLog.c("AuthModelUtil", "Exception", localException);
    }
    paramBundle.putString("sign", (String)localObject1);
    paramBundle.putString("time", str2);
  }
  
  private static boolean b(String paramString1, String paramString2, String paramString3, SSOAccountObserver paramSSOAccountObserver)
  {
    if (paramSSOAccountObserver == null)
    {
      QLog.d("AuthModelUtil", 1, "checkParamsValid null == observer");
      return false;
    }
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString1)))
    {
      if (!"com.tencent.mobileqq:openSdk".equals(MobileQQ.sMobileQQ.getQQProcessName()))
      {
        QLog.d("AuthModelUtil", 1, new Object[] { "checkParamsValid process = ", MobileQQ.sMobileQQ.getQQProcessName() });
        paramSSOAccountObserver.onFailed(paramString1, 1100, -1012, new Bundle());
        return false;
      }
      return true;
    }
    QLog.d("AuthModelUtil", 1, "checkParamsValid invalid params");
    paramSSOAccountObserver.onFailed(paramString1, 1100, -1012, new Bundle());
    return false;
  }
  
  public static boolean c(Bundle paramBundle)
  {
    QLog.d("AuthModelUtil", 1, "checkIMBlockByBundle");
    if (d(paramBundle)) {
      return false;
    }
    paramBundle = (WUserSigInfo)paramBundle.getParcelable("userSigInfo");
    if (a(paramBundle)) {
      return false;
    }
    try
    {
      paramBundle = ((tlv_t)paramBundle.loginResultTLVMap.get(Integer.valueOf(1347))).get_data();
      GatewayVerify.RspBody localRspBody = new GatewayVerify.RspBody();
      localRspBody.mergeFrom(paramBundle);
      if (localRspBody.msg_rsp_lft_info.uint32_lft_forbid_area.get() == 1)
      {
        QLog.d("AuthModelUtil", 1, "checkIMBlockByBundle FORBID_AREA_IM");
        return true;
      }
      QLog.d("AuthModelUtil", 1, "checkIMBlockByBundle FORBID_AREA_ALL");
      return false;
    }
    catch (Exception paramBundle)
    {
      QLog.e("AuthModelUtil", 1, "GatewayVerify.RspBody error: ", paramBundle);
    }
    return false;
  }
  
  private static boolean d(Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.getParcelable("userSigInfo") != null)) {
      return false;
    }
    QLog.d("AuthModelUtil", 1, "checkIMBlockByBundle not support im block check");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.util.AuthModelUtil
 * JD-Core Version:    0.7.0.1
 */