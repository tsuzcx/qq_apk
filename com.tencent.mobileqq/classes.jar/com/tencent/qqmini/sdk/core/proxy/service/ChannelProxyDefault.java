package com.tencent.qqmini.sdk.core.proxy.service;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StUserAuthInfo;
import NS_MINI_SHARE.MiniProgramShare.StAdaptShareInfoReq;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import beif;
import beih;
import betc;
import beut;
import bezm;
import bezn;
import bezo;
import bezp;
import bezq;
import bezr;
import bezs;
import bezt;
import bezu;
import bezv;
import bezw;
import bezx;
import bezy;
import bezz;
import bfaa;
import bfab;
import bfac;
import bfad;
import bfae;
import bfaf;
import bfag;
import bfah;
import bfai;
import bfaj;
import bfak;
import bfal;
import bfam;
import bfan;
import bfao;
import bfap;
import bfaq;
import bfar;
import bfas;
import bfat;
import bfau;
import bfav;
import bfaw;
import bfax;
import bfay;
import bfaz;
import bfba;
import bfbb;
import bfbc;
import bfhm;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy.AuthListResult;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.proxy.RequestProxy;
import com.tencent.qqmini.sdk.launcher.model.PluginInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class ChannelProxyDefault
  implements ChannelProxy
{
  private static final String TAG = "ChannelProxyDefault";
  
  private int getGTK(String paramString)
  {
    int i = 5381;
    if (!TextUtils.isEmpty(paramString))
    {
      int k = paramString.length();
      int j = 5381;
      i = 0;
      while (i < k)
      {
        j += (j << 5) + paramString.charAt(i);
        i += 1;
      }
      i = 0x7FFFFFFF & j;
    }
    return i;
  }
  
  private void handleRequest(bfau parambfau, AsyncResult paramAsyncResult)
  {
    MiniAppProxy localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    try
    {
      byte[] arrayOfByte = parambfau.b();
      betc.c("ChannelProxyDefault", "sendData " + parambfau);
      localMiniAppProxy.sendData(arrayOfByte, new ChannelProxyDefault.4(this, parambfau, paramAsyncResult));
      return;
    }
    catch (Exception parambfau)
    {
      do
      {
        betc.d("ChannelProxyDefault", "handleRequest Exception", parambfau);
      } while (paramAsyncResult == null);
      parambfau = new JSONObject();
    }
    try
    {
      parambfau.put("retCode", -1);
      parambfau.put("errMsg", "数据编码错误");
      label94:
      paramAsyncResult.onReceiveResult(false, parambfau);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label94;
    }
  }
  
  public void JudgeTiming(String paramString1, int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, String paramString2, int paramInt5, String paramString3, AsyncResult paramAsyncResult)
  {
    handleRequest(new bfaq(paramString1, paramInt1, paramInt2, paramInt3, paramLong, paramInt4, paramString2, paramInt5, paramString3), paramAsyncResult);
  }
  
  public void ReportExecute(String paramString1, int paramInt, String paramString2, String paramString3, AsyncResult paramAsyncResult)
  {
    handleRequest(new bfax(paramString1, paramInt, paramString2, paramString3), paramAsyncResult);
  }
  
  public void batchGetContact(ArrayList<String> paramArrayList, AsyncResult paramAsyncResult)
  {
    handleRequest(new bezm(paramArrayList), paramAsyncResult);
  }
  
  public void checkNavigateRight(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    handleRequest(new bezo(paramString1, paramString2), paramAsyncResult);
  }
  
  public void checkOfferId(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    handleRequest(new bezp(null, paramString1, paramString2), paramAsyncResult);
  }
  
  public void checkSession(String paramString, AsyncResult paramAsyncResult)
  {
    handleRequest(new bezq(paramString), paramAsyncResult);
  }
  
  public void dataReport(byte[] paramArrayOfByte, AsyncResult paramAsyncResult)
  {
    handleRequest(new bezr(paramArrayOfByte), paramAsyncResult);
  }
  
  public void getAppInfoById(String paramString1, String paramString2, String paramString3, AsyncResult paramAsyncResult)
  {
    handleRequest(new bezu(null, paramString1, 1, 0, paramString2, paramString3), paramAsyncResult);
  }
  
  public void getAppInfoByLink(String paramString, int paramInt, AsyncResult paramAsyncResult)
  {
    handleRequest(new bezv(paramString, paramInt), paramAsyncResult);
  }
  
  public void getAuthList(String paramString, ChannelProxy.AuthListResult paramAuthListResult)
  {
    paramString = new bezw(null, paramString);
    MiniAppProxy localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    handleRequest(paramString, new ChannelProxyDefault.1(this, paramAuthListResult));
  }
  
  public void getFormId(String paramString, AsyncResult paramAsyncResult)
  {
    handleRequest(new bezz(paramString), paramAsyncResult);
  }
  
  public void getFriendCloudStorage(String paramString, String[] paramArrayOfString, AsyncResult paramAsyncResult)
  {
    handleRequest(new bfaa(paramArrayOfString, paramString), paramAsyncResult);
  }
  
  public void getGdtAd(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, HashMap<String, String> paramHashMap, AsyncResult paramAsyncResult)
  {
    handleRequest(new bezt(paramString1, paramInt, paramString2, paramString3, paramString4, paramHashMap), paramAsyncResult);
  }
  
  public void getGroupCloudStorage(String paramString1, String paramString2, String[] paramArrayOfString, AsyncResult paramAsyncResult)
  {
    handleRequest(new bfab(paramArrayOfString, paramString2, paramString1), paramAsyncResult);
  }
  
  public void getGroupShareInfo(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    handleRequest(new bfar(null, paramString1, paramString2), paramAsyncResult);
  }
  
  public void getMidasConsumeResult(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, AsyncResult paramAsyncResult)
  {
    handleRequest(new bfat(paramString1, null, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5), paramAsyncResult);
  }
  
  public void getMiniAppStoreAppList(int paramInt, AsyncResult paramAsyncResult)
  {
    handleRequest(new bezy(paramInt), paramAsyncResult);
  }
  
  public void getNativeAppInfoForJump(String paramString1, String paramString2, String paramString3, int paramInt, AsyncResult paramAsyncResult)
  {
    handleRequest(new bfad(null, paramString1, paramString2, paramString3, paramInt), paramAsyncResult);
  }
  
  public void getPhoneNumber(String paramString, AsyncResult paramAsyncResult)
  {
    handleRequest(new bfbc(paramString), paramAsyncResult);
  }
  
  public void getPotentialFriendList(COMM.StCommonExt paramStCommonExt, String paramString, AsyncResult paramAsyncResult)
  {
    handleRequest(new bfaf(paramStCommonExt, paramString), paramAsyncResult);
  }
  
  public void getRobotUin(String paramString, AsyncResult paramAsyncResult)
  {
    handleRequest(new bfah(null, paramString), paramAsyncResult);
  }
  
  public void getSDKOpenKeyToken(COMM.StCommonExt paramStCommonExt, AsyncResult paramAsyncResult)
  {
    handleRequest(new bfai(paramStCommonExt), paramAsyncResult);
  }
  
  public void getShareInfo(MiniProgramShare.StAdaptShareInfoReq paramStAdaptShareInfoReq, AsyncResult paramAsyncResult)
  {
    handleRequest(new bfaj(paramStAdaptShareInfoReq), paramAsyncResult);
  }
  
  public void getTcbTicket(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    handleRequest(new bfak(null, paramString1, paramString2), paramAsyncResult);
  }
  
  public void getUserCloudStorage(String paramString, String[] paramArrayOfString, AsyncResult paramAsyncResult)
  {
    handleRequest(new bezx(paramArrayOfString, paramString), paramAsyncResult);
  }
  
  public void getUserHealthData(String paramString, AsyncResult paramAsyncResult)
  {
    handleRequest(new bfam(null, paramString), paramAsyncResult);
  }
  
  public void getUserInfo(String paramString1, boolean paramBoolean, String paramString2, AsyncResult paramAsyncResult)
  {
    handleRequest(new bfag(paramString1, paramBoolean, paramString2), paramAsyncResult);
  }
  
  public void getUserInfoExtra(String paramString, AsyncResult paramAsyncResult)
  {
    handleRequest(new bfan(paramString), paramAsyncResult);
  }
  
  public void getUserInfoOpenData(String paramString1, String paramString2, String[] paramArrayOfString, AsyncResult paramAsyncResult)
  {
    handleRequest(new bezn(paramString1, paramString2, paramArrayOfString), paramAsyncResult);
  }
  
  public void getUserInteractiveStorage(COMM.StCommonExt paramStCommonExt, String paramString, String[] paramArrayOfString, AsyncResult paramAsyncResult)
  {
    handleRequest(new bfao(paramStCommonExt, paramString, paramArrayOfString), paramAsyncResult);
  }
  
  public void getUserSetting(String paramString1, String paramString2, String paramString3, AsyncResult paramAsyncResult)
  {
    handleRequest(new bfap(paramString1, paramString2, paramString3), paramAsyncResult);
  }
  
  public void httpReport(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    String str = paramBundle.getString("log_key");
    paramBundle = paramBundle.getStringArray("data");
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramBundle.length)
    {
      localStringBuilder.append(paramBundle[i]);
      if (i < paramBundle.length - 1) {
        localStringBuilder.append('|');
      }
      i += 1;
    }
    ((RequestProxy)ProxyManager.get(RequestProxy.class)).request("https://q.qq.com/report/dc/" + str, localStringBuilder.toString().getBytes(), null, "POST", 60, new ChannelProxyDefault.2(this));
  }
  
  public void login(String paramString, AsyncResult paramAsyncResult)
  {
    handleRequest(new bfac(paramString), paramAsyncResult);
  }
  
  public void modifyFriendInteractiveStorage(COMM.StCommonExt paramStCommonExt, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, HashMap<String, String> paramHashMap, AsyncResult paramAsyncResult)
  {
    handleRequest(new bfas(paramStCommonExt, paramString1, paramString2, paramString3, paramInt, paramString4, paramHashMap), paramAsyncResult);
  }
  
  public void queryCurrency(String paramString1, String paramString2, int paramInt1, int paramInt2, AsyncResult paramAsyncResult)
  {
    handleRequest(new bfav(null, paramString2, paramString1, paramInt1, paramInt2), paramAsyncResult);
  }
  
  public void removeUserCloudStorage(String paramString, String[] paramArrayOfString, AsyncResult paramAsyncResult)
  {
    handleRequest(new bfaw(paramArrayOfString, paramString), paramAsyncResult);
  }
  
  public void report(byte[] paramArrayOfByte, String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    handleRequest(new bezs(paramArrayOfByte, paramString1, paramString2), paramAsyncResult);
  }
  
  public void setAuth(String paramString, beif parambeif, AsyncResult paramAsyncResult)
  {
    INTERFACE.StUserAuthInfo localStUserAuthInfo = new INTERFACE.StUserAuthInfo();
    localStUserAuthInfo.scope.set(parambeif.jdField_a_of_type_JavaLangString);
    if (!TextUtils.isEmpty(parambeif.b)) {
      localStUserAuthInfo.desc.set(parambeif.b);
    }
    localStUserAuthInfo.authState.set(parambeif.jdField_a_of_type_Int);
    handleRequest(new bfay(null, paramString, localStUserAuthInfo), paramAsyncResult);
  }
  
  public void setPersonalizeInfo(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, AsyncResult paramAsyncResult)
  {
    handleRequest(new bfaz(null, paramString1, paramString2, paramInt, paramString3, paramString4), paramAsyncResult);
  }
  
  public void setUserCloudStorage(String paramString, HashMap<String, String> paramHashMap, AsyncResult paramAsyncResult)
  {
    handleRequest(new bfba(paramHashMap, paramString), paramAsyncResult);
  }
  
  public void transForRoomId(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    handleRequest(new bfal(paramString1, paramString2), paramAsyncResult);
  }
  
  public boolean updateBaseLib(String paramString, boolean paramBoolean1, boolean paramBoolean2, AsyncResult paramAsyncResult)
  {
    betc.b("ChannelProxyDefault", "[MiniEng] doUpdateBaseLib nocheck=" + paramBoolean1 + ", force=" + paramBoolean2);
    if ((!paramBoolean1) && (!paramBoolean2))
    {
      long l = bfhm.a().getLong("baselib_min_update_time", 0L);
      if (System.currentTimeMillis() - l <= 0L)
      {
        betc.b("ChannelProxyDefault", "[MiniEng] updateBaseLib 在时间间隔内，暂时不更新");
        return false;
      }
    }
    handleRequest(new bfae(paramString, 0), paramAsyncResult);
    return true;
  }
  
  public void updateUserSetting(String paramString, beih parambeih, AsyncResult paramAsyncResult) {}
  
  public void useUserApp(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, COMM.StCommonExt paramStCommonExt, AsyncResult paramAsyncResult)
  {
    handleRequest(new bfbb(paramStCommonExt, paramString1, paramInt1, paramInt2, paramString2, paramString3), paramAsyncResult);
  }
  
  public void verifyPlugin(String paramString, ArrayList<PluginInfo> paramArrayList, AsyncResult paramAsyncResult) {}
  
  public boolean wnsCgiRequest(JSONObject paramJSONObject, AsyncResult paramAsyncResult)
  {
    if (paramJSONObject == null)
    {
      if (paramAsyncResult != null) {
        paramAsyncResult.onReceiveResult(false, new JSONObject());
      }
      paramAsyncResult.onReceiveResult(false, new JSONObject());
      return false;
    }
    for (;;)
    {
      Object localObject2;
      Object localObject3;
      Object localObject6;
      Object localObject4;
      try
      {
        if (paramJSONObject.has("header"))
        {
          localObject2 = paramJSONObject.optJSONObject("header");
          localObject3 = ((JSONObject)localObject2).keys();
          if (0 != 0) {
            break label737;
          }
          localObject1 = new HashMap();
          localObject6 = localObject1;
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = (String)((Iterator)localObject3).next();
            ((Map)localObject1).put(localObject4, ((JSONObject)localObject2).optString((String)localObject4));
            continue;
          }
        }
        else
        {
          localObject6 = null;
        }
      }
      catch (Throwable paramJSONObject)
      {
        betc.d("ChannelProxyDefault", "performWnsCgiRequest ", paramJSONObject);
        if (paramAsyncResult != null) {
          paramAsyncResult.onReceiveResult(false, null);
        }
        return false;
      }
      String str1 = paramJSONObject.optString("url");
      if ((0 == 0) && (paramJSONObject.has("data"))) {}
      label542:
      label684:
      label721:
      for (Object localObject1 = paramJSONObject.optString("data");; localObject1 = null)
      {
        String str2 = paramJSONObject.optString("method", "GET");
        boolean bool1 = paramJSONObject.optString("dataType").equalsIgnoreCase("json");
        boolean bool2 = paramJSONObject.optString("responseType").equals("base64");
        if (TextUtils.isEmpty(str1))
        {
          if (paramAsyncResult == null) {
            break;
          }
          paramAsyncResult.onReceiveResult(false, null);
          break;
        }
        if (TextUtils.isEmpty(str2))
        {
          if (paramAsyncResult != null) {
            paramAsyncResult.onReceiveResult(false, null);
          }
          return false;
        }
        localObject2 = localObject1;
        localObject3 = str1;
        try
        {
          beut.a().a();
          localObject2 = localObject1;
          localObject3 = str1;
          paramJSONObject = new String(beut.a().a());
          localObject2 = localObject1;
          localObject3 = str1;
          if (TextUtils.isEmpty(paramJSONObject)) {
            continue;
          }
          localObject2 = localObject1;
          localObject3 = str1;
          i = getGTK(paramJSONObject);
        }
        catch (Throwable paramJSONObject)
        {
          for (;;)
          {
            Object localObject5;
            betc.d("ChannelProxyDefault", "get gtk fail.", paramJSONObject);
            paramJSONObject = (JSONObject)localObject2;
            localObject4 = localObject3;
            continue;
            localObject2 = localObject1;
            localObject3 = str1;
            paramJSONObject = str1 + "?g_tk=" + i;
            continue;
            paramJSONObject = null;
            continue;
            int i = -1;
          }
        }
        localObject5 = localObject1;
        localObject4 = str1;
        if (i != -1)
        {
          localObject2 = localObject1;
          localObject3 = str1;
          if (!"post".equalsIgnoreCase(str2)) {
            break label542;
          }
          localObject2 = localObject1;
          localObject3 = str1;
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            break label505;
          }
          localObject2 = localObject1;
          localObject3 = str1;
          paramJSONObject = "g_tk=" + i;
          localObject2 = paramJSONObject;
          localObject3 = str1;
          betc.a("ChannelProxyDefault", "wns body : " + paramJSONObject);
          localObject4 = str1;
          localObject5 = paramJSONObject;
        }
        for (;;)
        {
          paramJSONObject = (JSONObject)localObject5;
          localObject1 = (RequestProxy)ProxyManager.get(RequestProxy.class);
          if (paramJSONObject == null) {
            break label721;
          }
          paramJSONObject = paramJSONObject.getBytes();
          ((RequestProxy)localObject1).request((String)localObject4, paramJSONObject, localObject6, str2, 60000, new ChannelProxyDefault.3(this, paramAsyncResult, bool1, bool2));
          return true;
          label505:
          localObject2 = localObject1;
          localObject3 = str1;
          paramJSONObject = (String)localObject1 + "&g_tk=" + i;
          break;
          localObject5 = localObject1;
          localObject4 = str1;
          localObject2 = localObject1;
          localObject3 = str1;
          if ("get".equalsIgnoreCase(str2))
          {
            localObject2 = localObject1;
            localObject3 = str1;
            if (!str1.contains("?")) {
              break label684;
            }
            localObject2 = localObject1;
            localObject3 = str1;
            paramJSONObject = str1 + "&g_tk=" + i;
            localObject2 = localObject1;
            localObject3 = paramJSONObject;
            betc.a("ChannelProxyDefault", "url : " + paramJSONObject);
            localObject5 = localObject1;
            localObject4 = paramJSONObject;
          }
        }
      }
      label737:
      localObject1 = null;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.ChannelProxyDefault
 * JD-Core Version:    0.7.0.1
 */