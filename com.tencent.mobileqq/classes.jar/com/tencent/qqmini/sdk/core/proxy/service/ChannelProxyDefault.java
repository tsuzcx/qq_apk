package com.tencent.qqmini.sdk.core.proxy.service;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StUserAuthInfo;
import NS_MINI_SHARE.MiniProgramShare.StAdaptShareInfoReq;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import beho;
import behq;
import besl;
import beuc;
import beyv;
import beyw;
import beyx;
import beyy;
import beyz;
import beza;
import bezb;
import bezc;
import bezd;
import beze;
import bezf;
import bezg;
import bezh;
import bezi;
import bezj;
import bezk;
import bezl;
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
import bfgv;
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
  
  private void handleRequest(bfad parambfad, AsyncResult paramAsyncResult)
  {
    MiniAppProxy localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    try
    {
      byte[] arrayOfByte = parambfad.b();
      besl.c("ChannelProxyDefault", "sendData " + parambfad);
      localMiniAppProxy.sendData(arrayOfByte, new ChannelProxyDefault.4(this, parambfad, paramAsyncResult));
      return;
    }
    catch (Exception parambfad)
    {
      do
      {
        besl.d("ChannelProxyDefault", "handleRequest Exception", parambfad);
      } while (paramAsyncResult == null);
      parambfad = new JSONObject();
    }
    try
    {
      parambfad.put("retCode", -1);
      parambfad.put("errMsg", "数据编码错误");
      label94:
      paramAsyncResult.onReceiveResult(false, parambfad);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label94;
    }
  }
  
  public void JudgeTiming(String paramString1, int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, String paramString2, int paramInt5, String paramString3, AsyncResult paramAsyncResult)
  {
    handleRequest(new bezz(paramString1, paramInt1, paramInt2, paramInt3, paramLong, paramInt4, paramString2, paramInt5, paramString3), paramAsyncResult);
  }
  
  public void ReportExecute(String paramString1, int paramInt, String paramString2, String paramString3, AsyncResult paramAsyncResult)
  {
    handleRequest(new bfag(paramString1, paramInt, paramString2, paramString3), paramAsyncResult);
  }
  
  public void batchGetContact(ArrayList<String> paramArrayList, AsyncResult paramAsyncResult)
  {
    handleRequest(new beyv(paramArrayList), paramAsyncResult);
  }
  
  public void checkNavigateRight(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    handleRequest(new beyx(paramString1, paramString2), paramAsyncResult);
  }
  
  public void checkOfferId(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    handleRequest(new beyy(null, paramString1, paramString2), paramAsyncResult);
  }
  
  public void checkSession(String paramString, AsyncResult paramAsyncResult)
  {
    handleRequest(new beyz(paramString), paramAsyncResult);
  }
  
  public void dataReport(byte[] paramArrayOfByte, AsyncResult paramAsyncResult)
  {
    handleRequest(new beza(paramArrayOfByte), paramAsyncResult);
  }
  
  public void getAppInfoById(String paramString1, String paramString2, String paramString3, AsyncResult paramAsyncResult)
  {
    handleRequest(new bezd(null, paramString1, 1, 0, paramString2, paramString3), paramAsyncResult);
  }
  
  public void getAppInfoByLink(String paramString, int paramInt, AsyncResult paramAsyncResult)
  {
    handleRequest(new beze(paramString, paramInt), paramAsyncResult);
  }
  
  public void getAuthList(String paramString, ChannelProxy.AuthListResult paramAuthListResult)
  {
    paramString = new bezf(null, paramString);
    MiniAppProxy localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    handleRequest(paramString, new ChannelProxyDefault.1(this, paramAuthListResult));
  }
  
  public void getFormId(String paramString, AsyncResult paramAsyncResult)
  {
    handleRequest(new bezi(paramString), paramAsyncResult);
  }
  
  public void getFriendCloudStorage(String paramString, String[] paramArrayOfString, AsyncResult paramAsyncResult)
  {
    handleRequest(new bezj(paramArrayOfString, paramString), paramAsyncResult);
  }
  
  public void getGdtAd(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, HashMap<String, String> paramHashMap, AsyncResult paramAsyncResult)
  {
    handleRequest(new bezc(paramString1, paramInt, paramString2, paramString3, paramString4, paramHashMap), paramAsyncResult);
  }
  
  public void getGroupCloudStorage(String paramString1, String paramString2, String[] paramArrayOfString, AsyncResult paramAsyncResult)
  {
    handleRequest(new bezk(paramArrayOfString, paramString2, paramString1), paramAsyncResult);
  }
  
  public void getGroupShareInfo(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    handleRequest(new bfaa(null, paramString1, paramString2), paramAsyncResult);
  }
  
  public void getMidasConsumeResult(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, AsyncResult paramAsyncResult)
  {
    handleRequest(new bfac(paramString1, null, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5), paramAsyncResult);
  }
  
  public void getMiniAppStoreAppList(int paramInt, AsyncResult paramAsyncResult)
  {
    handleRequest(new bezh(paramInt), paramAsyncResult);
  }
  
  public void getNativeAppInfoForJump(String paramString1, String paramString2, String paramString3, int paramInt, AsyncResult paramAsyncResult)
  {
    handleRequest(new bezm(null, paramString1, paramString2, paramString3, paramInt), paramAsyncResult);
  }
  
  public void getPhoneNumber(String paramString, AsyncResult paramAsyncResult)
  {
    handleRequest(new bfal(paramString), paramAsyncResult);
  }
  
  public void getPotentialFriendList(COMM.StCommonExt paramStCommonExt, String paramString, AsyncResult paramAsyncResult)
  {
    handleRequest(new bezo(paramStCommonExt, paramString), paramAsyncResult);
  }
  
  public void getRobotUin(String paramString, AsyncResult paramAsyncResult)
  {
    handleRequest(new bezq(null, paramString), paramAsyncResult);
  }
  
  public void getSDKOpenKeyToken(COMM.StCommonExt paramStCommonExt, AsyncResult paramAsyncResult)
  {
    handleRequest(new bezr(paramStCommonExt), paramAsyncResult);
  }
  
  public void getShareInfo(MiniProgramShare.StAdaptShareInfoReq paramStAdaptShareInfoReq, AsyncResult paramAsyncResult)
  {
    handleRequest(new bezs(paramStAdaptShareInfoReq), paramAsyncResult);
  }
  
  public void getTcbTicket(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    handleRequest(new bezt(null, paramString1, paramString2), paramAsyncResult);
  }
  
  public void getUserCloudStorage(String paramString, String[] paramArrayOfString, AsyncResult paramAsyncResult)
  {
    handleRequest(new bezg(paramArrayOfString, paramString), paramAsyncResult);
  }
  
  public void getUserHealthData(String paramString, AsyncResult paramAsyncResult)
  {
    handleRequest(new bezv(null, paramString), paramAsyncResult);
  }
  
  public void getUserInfo(String paramString1, boolean paramBoolean, String paramString2, AsyncResult paramAsyncResult)
  {
    handleRequest(new bezp(paramString1, paramBoolean, paramString2), paramAsyncResult);
  }
  
  public void getUserInfoExtra(String paramString, AsyncResult paramAsyncResult)
  {
    handleRequest(new bezw(paramString), paramAsyncResult);
  }
  
  public void getUserInfoOpenData(String paramString1, String paramString2, String[] paramArrayOfString, AsyncResult paramAsyncResult)
  {
    handleRequest(new beyw(paramString1, paramString2, paramArrayOfString), paramAsyncResult);
  }
  
  public void getUserInteractiveStorage(COMM.StCommonExt paramStCommonExt, String paramString, String[] paramArrayOfString, AsyncResult paramAsyncResult)
  {
    handleRequest(new bezx(paramStCommonExt, paramString, paramArrayOfString), paramAsyncResult);
  }
  
  public void getUserSetting(String paramString1, String paramString2, String paramString3, AsyncResult paramAsyncResult)
  {
    handleRequest(new bezy(paramString1, paramString2, paramString3), paramAsyncResult);
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
    handleRequest(new bezl(paramString), paramAsyncResult);
  }
  
  public void modifyFriendInteractiveStorage(COMM.StCommonExt paramStCommonExt, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, HashMap<String, String> paramHashMap, AsyncResult paramAsyncResult)
  {
    handleRequest(new bfab(paramStCommonExt, paramString1, paramString2, paramString3, paramInt, paramString4, paramHashMap), paramAsyncResult);
  }
  
  public void queryCurrency(String paramString1, String paramString2, int paramInt1, int paramInt2, AsyncResult paramAsyncResult)
  {
    handleRequest(new bfae(null, paramString2, paramString1, paramInt1, paramInt2), paramAsyncResult);
  }
  
  public void removeUserCloudStorage(String paramString, String[] paramArrayOfString, AsyncResult paramAsyncResult)
  {
    handleRequest(new bfaf(paramArrayOfString, paramString), paramAsyncResult);
  }
  
  public void report(byte[] paramArrayOfByte, String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    handleRequest(new bezb(paramArrayOfByte, paramString1, paramString2), paramAsyncResult);
  }
  
  public void setAuth(String paramString, beho parambeho, AsyncResult paramAsyncResult)
  {
    INTERFACE.StUserAuthInfo localStUserAuthInfo = new INTERFACE.StUserAuthInfo();
    localStUserAuthInfo.scope.set(parambeho.jdField_a_of_type_JavaLangString);
    if (!TextUtils.isEmpty(parambeho.b)) {
      localStUserAuthInfo.desc.set(parambeho.b);
    }
    localStUserAuthInfo.authState.set(parambeho.jdField_a_of_type_Int);
    handleRequest(new bfah(null, paramString, localStUserAuthInfo), paramAsyncResult);
  }
  
  public void setPersonalizeInfo(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, AsyncResult paramAsyncResult)
  {
    handleRequest(new bfai(null, paramString1, paramString2, paramInt, paramString3, paramString4), paramAsyncResult);
  }
  
  public void setUserCloudStorage(String paramString, HashMap<String, String> paramHashMap, AsyncResult paramAsyncResult)
  {
    handleRequest(new bfaj(paramHashMap, paramString), paramAsyncResult);
  }
  
  public void transForRoomId(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    handleRequest(new bezu(paramString1, paramString2), paramAsyncResult);
  }
  
  public boolean updateBaseLib(String paramString, boolean paramBoolean1, boolean paramBoolean2, AsyncResult paramAsyncResult)
  {
    besl.b("ChannelProxyDefault", "[MiniEng] doUpdateBaseLib nocheck=" + paramBoolean1 + ", force=" + paramBoolean2);
    if ((!paramBoolean1) && (!paramBoolean2))
    {
      long l = bfgv.a().getLong("baselib_min_update_time", 0L);
      if (System.currentTimeMillis() - l <= 0L)
      {
        besl.b("ChannelProxyDefault", "[MiniEng] updateBaseLib 在时间间隔内，暂时不更新");
        return false;
      }
    }
    handleRequest(new bezn(paramString, 0), paramAsyncResult);
    return true;
  }
  
  public void updateUserSetting(String paramString, behq parambehq, AsyncResult paramAsyncResult) {}
  
  public void useUserApp(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, COMM.StCommonExt paramStCommonExt, AsyncResult paramAsyncResult)
  {
    handleRequest(new bfak(paramStCommonExt, paramString1, paramInt1, paramInt2, paramString2, paramString3), paramAsyncResult);
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
        besl.d("ChannelProxyDefault", "performWnsCgiRequest ", paramJSONObject);
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
          beuc.a().a();
          localObject2 = localObject1;
          localObject3 = str1;
          paramJSONObject = new String(beuc.a().a());
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
            besl.d("ChannelProxyDefault", "get gtk fail.", paramJSONObject);
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
          besl.a("ChannelProxyDefault", "wns body : " + paramJSONObject);
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
            besl.a("ChannelProxyDefault", "url : " + paramJSONObject);
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