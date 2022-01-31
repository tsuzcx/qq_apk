package com.tencent.qqmini.sdk.core.proxy.service;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StUserAuthInfo;
import NS_MINI_SHARE.MiniProgramShare.StAdaptShareInfoReq;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import bgxl;
import bhco;
import bhcp;
import bhcq;
import bhcr;
import bhcs;
import bhct;
import bhcu;
import bhcv;
import bhcw;
import bhcx;
import bhcy;
import bhcz;
import bhda;
import bhdb;
import bhdc;
import bhdd;
import bhde;
import bhdf;
import bhdg;
import bhdh;
import bhdi;
import bhdj;
import bhdk;
import bhdl;
import bhdm;
import bhdn;
import bhdo;
import bhdp;
import bhdq;
import bhdr;
import bhds;
import bhdt;
import bhdu;
import bhdv;
import bhdw;
import bhdx;
import bhdy;
import bhdz;
import bhea;
import bheb;
import bhec;
import bhed;
import bhee;
import bhef;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.core.auth.UserAuthInfo;
import com.tencent.qqmini.sdk.core.auth.UserSettingInfo;
import com.tencent.qqmini.sdk.core.auth.ui.PermissionSettingFragment;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy.AuthListResult;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy.SoLoaderOption;
import com.tencent.qqmini.sdk.core.proxy.IMediaPlayer;
import com.tencent.qqmini.sdk.core.proxy.IMediaPlayerUtil;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.proxy.RequestProxy;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.model.PluginInfo;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.qqmini.sdk.utils.StorageUtil;
import cooperation.vip.pb.TianShuAccess.AdItem;
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
  
  private void handleRequest(bhdw parambhdw, AsyncResult paramAsyncResult)
  {
    MiniAppProxy localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    try
    {
      byte[] arrayOfByte = parambhdw.b();
      QMLog.w("ChannelProxyDefault", "sendData " + parambhdw);
      localMiniAppProxy.sendData(arrayOfByte, new ChannelProxyDefault.4(this, parambhdw, paramAsyncResult));
      return;
    }
    catch (Exception parambhdw)
    {
      do
      {
        QMLog.e("ChannelProxyDefault", "handleRequest Exception", parambhdw);
      } while (paramAsyncResult == null);
      parambhdw = new JSONObject();
    }
    try
    {
      parambhdw.put("retCode", -1);
      parambhdw.put("errMsg", "数据编码错误");
      label94:
      paramAsyncResult.onReceiveResult(false, parambhdw);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label94;
    }
  }
  
  public void JudgeTiming(String paramString1, int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, String paramString2, int paramInt5, String paramString3, int paramInt6, COMM.StCommonExt paramStCommonExt, AsyncResult paramAsyncResult)
  {
    handleRequest(new bhds(paramString1, paramInt1, paramInt2, paramInt3, paramLong, paramInt4, paramString2, paramInt5, paramString3, paramInt6, paramStCommonExt), paramAsyncResult);
  }
  
  public void ReportExecute(String paramString1, int paramInt, String paramString2, String paramString3, AsyncResult paramAsyncResult)
  {
    handleRequest(new bhdz(paramString1, paramInt, paramString2, paramString3), paramAsyncResult);
  }
  
  public boolean addPublicAccount(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    return false;
  }
  
  public void batchGetContact(ArrayList<String> paramArrayList, AsyncResult paramAsyncResult)
  {
    handleRequest(new bhco(paramArrayList), paramAsyncResult);
  }
  
  public void checkNavigateRight(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    handleRequest(new bhcq(paramString1, paramString2), paramAsyncResult);
  }
  
  public void checkOfferId(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    handleRequest(new bhcr(null, paramString1, paramString2), paramAsyncResult);
  }
  
  public void checkSession(String paramString, AsyncResult paramAsyncResult)
  {
    handleRequest(new bhcs(paramString), paramAsyncResult);
  }
  
  public void dataReport(byte[] paramArrayOfByte, AsyncResult paramAsyncResult)
  {
    handleRequest(new bhct(paramArrayOfByte), paramAsyncResult);
  }
  
  public void downloadQQBrowser(String paramString) {}
  
  public void getAppInfoById(String paramString1, String paramString2, String paramString3, AsyncResult paramAsyncResult)
  {
    handleRequest(new bhcw(null, paramString1, 1, 0, paramString2, paramString3), paramAsyncResult);
  }
  
  public void getAppInfoByLink(String paramString, int paramInt, AsyncResult paramAsyncResult)
  {
    handleRequest(new bhcx(paramString, paramInt), paramAsyncResult);
  }
  
  public void getAuthList(String paramString, ChannelProxy.AuthListResult paramAuthListResult)
  {
    paramString = new bhcy(null, paramString);
    MiniAppProxy localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    handleRequest(paramString, new ChannelProxyDefault.1(this, paramAuthListResult));
  }
  
  public String getDeviceInfo()
  {
    return QUAUtil.getSimpleDeviceInfo(AppLoaderFactory.g().getMiniAppEnv().getContext());
  }
  
  public void getFormId(String paramString, AsyncResult paramAsyncResult)
  {
    handleRequest(new bhdb(paramString), paramAsyncResult);
  }
  
  public void getFriendCloudStorage(String paramString, String[] paramArrayOfString, AsyncResult paramAsyncResult)
  {
    handleRequest(new bhdc(paramArrayOfString, paramString), paramAsyncResult);
  }
  
  public void getGdtAd(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, HashMap<String, String> paramHashMap, AsyncResult paramAsyncResult)
  {
    handleRequest(new bhcv(paramString1, paramInt, paramString2, paramString3, paramString4, paramHashMap), paramAsyncResult);
  }
  
  public void getGroupCloudStorage(String paramString1, String paramString2, String[] paramArrayOfString, AsyncResult paramAsyncResult)
  {
    handleRequest(new bhdd(paramArrayOfString, paramString2, paramString1), paramAsyncResult);
  }
  
  public void getGroupShareInfo(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    handleRequest(new bhdt(null, paramString1, paramString2), paramAsyncResult);
  }
  
  public IMediaPlayer getMediaPlayer()
  {
    return new DefaultMediaPlayer();
  }
  
  public IMediaPlayerUtil getMediaPlayerUtil()
  {
    return new ChannelProxyDefault.5(this);
  }
  
  public void getMidasConsumeResult(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString3, String paramString4, AsyncResult paramAsyncResult)
  {
    handleRequest(new bhdv(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramString3, paramString4), paramAsyncResult);
  }
  
  public void getMiniAppStoreAppList(int paramInt, AsyncResult paramAsyncResult)
  {
    handleRequest(new bhda(paramInt), paramAsyncResult);
  }
  
  public void getNativeAppInfoForJump(String paramString1, String paramString2, String paramString3, int paramInt, AsyncResult paramAsyncResult)
  {
    handleRequest(new bhdf(null, paramString1, paramString2, paramString3, paramInt), paramAsyncResult);
  }
  
  public void getPhoneNumber(String paramString, AsyncResult paramAsyncResult)
  {
    handleRequest(new bhef(paramString), paramAsyncResult);
  }
  
  public void getPotentialFriendList(COMM.StCommonExt paramStCommonExt, String paramString, AsyncResult paramAsyncResult)
  {
    handleRequest(new bhdh(paramStCommonExt, paramString), paramAsyncResult);
  }
  
  public void getRobotUin(String paramString, AsyncResult paramAsyncResult)
  {
    handleRequest(new bhdj(null, paramString), paramAsyncResult);
  }
  
  public void getSDKOpenKeyToken(COMM.StCommonExt paramStCommonExt, AsyncResult paramAsyncResult)
  {
    handleRequest(new bhdk(paramStCommonExt), paramAsyncResult);
  }
  
  public void getShareInfo(MiniProgramShare.StAdaptShareInfoReq paramStAdaptShareInfoReq, AsyncResult paramAsyncResult)
  {
    handleRequest(new bhdl(paramStAdaptShareInfoReq), paramAsyncResult);
  }
  
  public void getTcbTicket(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    handleRequest(new bhdm(null, paramString1, paramString2), paramAsyncResult);
  }
  
  public ChannelProxy.SoLoaderOption getTissueSoLoaderOption()
  {
    return null;
  }
  
  public void getUserCloudStorage(String paramString, String[] paramArrayOfString, AsyncResult paramAsyncResult)
  {
    handleRequest(new bhcz(paramArrayOfString, paramString), paramAsyncResult);
  }
  
  public void getUserHealthData(String paramString, AsyncResult paramAsyncResult)
  {
    handleRequest(new bhdo(null, paramString), paramAsyncResult);
  }
  
  public void getUserInfo(String paramString1, boolean paramBoolean, String paramString2, AsyncResult paramAsyncResult)
  {
    handleRequest(new bhdi(paramString1, paramBoolean, paramString2), paramAsyncResult);
  }
  
  public void getUserInfoExtra(String paramString, AsyncResult paramAsyncResult)
  {
    handleRequest(new bhdp(paramString), paramAsyncResult);
  }
  
  public void getUserInfoOpenData(String paramString1, String paramString2, String[] paramArrayOfString, AsyncResult paramAsyncResult)
  {
    handleRequest(new bhcp(paramString1, paramString2, paramArrayOfString), paramAsyncResult);
  }
  
  public void getUserInteractiveStorage(COMM.StCommonExt paramStCommonExt, String paramString, String[] paramArrayOfString, AsyncResult paramAsyncResult)
  {
    handleRequest(new bhdq(paramStCommonExt, paramString, paramArrayOfString), paramAsyncResult);
  }
  
  public void getUserSetting(String paramString1, String paramString2, String paramString3, AsyncResult paramAsyncResult)
  {
    handleRequest(new bhdr(paramString1, paramString2, paramString3), paramAsyncResult);
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
  
  public boolean isGooglePlayVersion()
  {
    return false;
  }
  
  public boolean jump2PublicAccount(Context paramContext, String paramString1, String paramString2)
  {
    return false;
  }
  
  public void login(String paramString, AsyncResult paramAsyncResult)
  {
    handleRequest(new bhde(paramString), paramAsyncResult);
  }
  
  public void modifyFriendInteractiveStorage(COMM.StCommonExt paramStCommonExt, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, HashMap<String, String> paramHashMap, AsyncResult paramAsyncResult)
  {
    handleRequest(new bhdu(paramStCommonExt, paramString1, paramString2, paramString3, paramInt, paramString4, paramHashMap), paramAsyncResult);
  }
  
  public boolean openGroup(Context paramContext, String paramString, AsyncResult paramAsyncResult)
  {
    return false;
  }
  
  public boolean openPermissionSettingsActivity(Context paramContext, String paramString1, String paramString2)
  {
    PermissionSettingFragment.launchForResult((Activity)paramContext, paramString1, paramString2, 5);
    return true;
  }
  
  public boolean openRobotProfileCard(Context paramContext, String paramString1, String paramString2)
  {
    return false;
  }
  
  public void queryCurrency(String paramString1, String paramString2, int paramInt1, int paramInt2, AsyncResult paramAsyncResult)
  {
    handleRequest(new bhdx(null, paramString2, paramString1, paramInt1, paramInt2), paramAsyncResult);
  }
  
  public void removeUserCloudStorage(String paramString, String[] paramArrayOfString, AsyncResult paramAsyncResult)
  {
    handleRequest(new bhdy(paramArrayOfString, paramString), paramAsyncResult);
  }
  
  public void report(byte[] paramArrayOfByte, String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    handleRequest(new bhcu(paramArrayOfByte, paramString1, paramString2), paramAsyncResult);
  }
  
  public void reportShare(COMM.StCommonExt paramStCommonExt, long paramLong, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, AsyncResult paramAsyncResult)
  {
    handleRequest(new bhea(paramLong, paramString1, paramInt1, paramInt2, paramInt3, paramInt4, paramString2), paramAsyncResult);
  }
  
  public void setAuth(String paramString, UserAuthInfo paramUserAuthInfo, AsyncResult paramAsyncResult)
  {
    INTERFACE.StUserAuthInfo localStUserAuthInfo = new INTERFACE.StUserAuthInfo();
    localStUserAuthInfo.scope.set(paramUserAuthInfo.scope);
    if (!TextUtils.isEmpty(paramUserAuthInfo.desc)) {
      localStUserAuthInfo.desc.set(paramUserAuthInfo.desc);
    }
    localStUserAuthInfo.authState.set(paramUserAuthInfo.authState);
    handleRequest(new bheb(null, paramString, localStUserAuthInfo), paramAsyncResult);
  }
  
  public void setPersonalizeInfo(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, AsyncResult paramAsyncResult)
  {
    handleRequest(new bhec(null, paramString1, paramString2, paramInt, paramString3, paramString4), paramAsyncResult);
  }
  
  public void setUserCloudStorage(String paramString, HashMap<String, String> paramHashMap, AsyncResult paramAsyncResult)
  {
    handleRequest(new bhed(paramHashMap, paramString), paramAsyncResult);
  }
  
  public boolean startAddFriendActivity(Context paramContext, String paramString1, String paramString2)
  {
    return false;
  }
  
  public boolean startTransparentBrowserActivityForResult(Activity paramActivity, String paramString, int paramInt)
  {
    return false;
  }
  
  public boolean tianshuReport(TianShuAccess.AdItem paramAdItem, String paramString, int paramInt)
  {
    return false;
  }
  
  public boolean tianshuRequestAdv(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, AsyncResult paramAsyncResult)
  {
    return false;
  }
  
  public void transForRoomId(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    handleRequest(new bhdn(paramString1, paramString2), paramAsyncResult);
  }
  
  public boolean updateBaseLib(String paramString, boolean paramBoolean1, boolean paramBoolean2, AsyncResult paramAsyncResult)
  {
    QMLog.i("ChannelProxyDefault", "[MiniEng] doUpdateBaseLib nocheck=" + paramBoolean1 + ", force=" + paramBoolean2);
    if ((!paramBoolean1) && (!paramBoolean2))
    {
      long l = StorageUtil.getPreference().getLong("baselib_min_update_time", 0L);
      if (System.currentTimeMillis() - l <= 0L)
      {
        QMLog.i("ChannelProxyDefault", "[MiniEng] updateBaseLib 在时间间隔内，暂时不更新");
        return false;
      }
    }
    handleRequest(new bhdg(paramString, 0), paramAsyncResult);
    return true;
  }
  
  public boolean updateEntryList(String paramString)
  {
    return false;
  }
  
  public void updateUserSetting(String paramString, UserSettingInfo paramUserSettingInfo, AsyncResult paramAsyncResult) {}
  
  public void uploadUserLog(String paramString) {}
  
  public void useUserApp(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, COMM.StCommonExt paramStCommonExt, AsyncResult paramAsyncResult)
  {
    handleRequest(new bhee(paramStCommonExt, paramString1, paramInt1, paramInt2, paramString2, paramString3), paramAsyncResult);
  }
  
  public void verifyPlugin(String paramString, ArrayList<PluginInfo> paramArrayList, AsyncResult paramAsyncResult) {}
  
  public boolean wnsCgiRequest(JSONObject paramJSONObject, AsyncResult paramAsyncResult)
  {
    if (paramJSONObject == null)
    {
      if (paramAsyncResult != null) {
        paramAsyncResult.onReceiveResult(false, new JSONObject());
      }
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
            break label723;
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
        QMLog.e("ChannelProxyDefault", "performWnsCgiRequest ", paramJSONObject);
        if (paramAsyncResult != null) {
          paramAsyncResult.onReceiveResult(false, null);
        }
        return false;
      }
      String str1 = paramJSONObject.optString("url");
      if ((0 == 0) && (paramJSONObject.has("data"))) {}
      label528:
      label670:
      label707:
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
          bgxl.a().a();
          localObject2 = localObject1;
          localObject3 = str1;
          paramJSONObject = new String(bgxl.a().a());
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
            QMLog.e("ChannelProxyDefault", "get gtk fail.", paramJSONObject);
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
          if (!"get".equalsIgnoreCase(str2)) {
            break label528;
          }
          localObject2 = localObject1;
          localObject3 = str1;
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            break label491;
          }
          localObject2 = localObject1;
          localObject3 = str1;
          paramJSONObject = "g_tk=" + i;
          localObject2 = paramJSONObject;
          localObject3 = str1;
          QMLog.d("ChannelProxyDefault", "wns body : " + paramJSONObject);
          localObject4 = str1;
          localObject5 = paramJSONObject;
        }
        for (;;)
        {
          paramJSONObject = (JSONObject)localObject5;
          localObject1 = (RequestProxy)ProxyManager.get(RequestProxy.class);
          if (paramJSONObject == null) {
            break label707;
          }
          paramJSONObject = paramJSONObject.getBytes();
          ((RequestProxy)localObject1).request((String)localObject4, paramJSONObject, localObject6, str2, 60000, new ChannelProxyDefault.3(this, paramAsyncResult, bool1, bool2));
          return true;
          label491:
          localObject2 = localObject1;
          localObject3 = str1;
          paramJSONObject = (String)localObject1 + "&g_tk=" + i;
          break;
          localObject5 = localObject1;
          localObject4 = str1;
          localObject2 = localObject1;
          localObject3 = str1;
          if ("post".equalsIgnoreCase(str2))
          {
            localObject2 = localObject1;
            localObject3 = str1;
            if (!str1.contains("?")) {
              break label670;
            }
            localObject2 = localObject1;
            localObject3 = str1;
            paramJSONObject = str1 + "&g_tk=" + i;
            localObject2 = localObject1;
            localObject3 = paramJSONObject;
            QMLog.d("ChannelProxyDefault", "url : " + paramJSONObject);
            localObject5 = localObject1;
            localObject4 = paramJSONObject;
          }
        }
      }
      label723:
      localObject1 = null;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.ChannelProxyDefault
 * JD-Core Version:    0.7.0.1
 */