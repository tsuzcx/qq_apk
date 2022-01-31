package com.tencent.qqmini.sdk.core.proxy.service;

import NS_MINI_INTERFACE.INTERFACE.StUserAuthInfo;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import bddn;
import bddp;
import bdnw;
import bdsy;
import bdsz;
import bdta;
import bdtb;
import bdtc;
import bdtd;
import bdte;
import bdtf;
import bdtg;
import bdth;
import bdti;
import bdtj;
import bdtk;
import bdtl;
import bdtm;
import bdtn;
import bdto;
import bdtp;
import bdtq;
import bdtr;
import bdts;
import bdtt;
import bdtu;
import bdtv;
import bdtw;
import bdtx;
import bdty;
import bdtz;
import bdua;
import bdub;
import bduc;
import bdud;
import bdue;
import bduf;
import bdzf;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy.AuthListResult;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.PluginInfo;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

public class ChannelProxyDefault
  implements ChannelProxy
{
  private static final String TAG = "ChannelProxyDefault";
  
  private void handleRequest(bdtz parambdtz, AsyncResult paramAsyncResult)
  {
    MiniAppProxy localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    Object localObject = null;
    try
    {
      byte[] arrayOfByte = parambdtz.b();
      localObject = arrayOfByte;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        bdnw.d("ChannelProxyDefault", "handleRequest Exception", localException);
      }
    }
    localMiniAppProxy.sendData(localObject, new ChannelProxyDefault.2(this, paramAsyncResult, parambdtz));
  }
  
  public void batchGetContact(ArrayList<String> paramArrayList, AsyncResult paramAsyncResult)
  {
    handleRequest(new bdsy(paramArrayList), paramAsyncResult);
  }
  
  public void checkNavigateRight(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    handleRequest(new bdta(paramString1, paramString2), paramAsyncResult);
  }
  
  public void checkOfferId(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    handleRequest(new bdtb(null, paramString1, paramString2), paramAsyncResult);
  }
  
  public void checkSession(String paramString, AsyncResult paramAsyncResult)
  {
    handleRequest(new bdtc(paramString), paramAsyncResult);
  }
  
  public void dataReport(byte[] paramArrayOfByte, AsyncResult paramAsyncResult)
  {
    handleRequest(new bdtd(paramArrayOfByte), paramAsyncResult);
  }
  
  public void getAppInfoById(String paramString1, String paramString2, String paramString3, AsyncResult paramAsyncResult)
  {
    handleRequest(new bdtf(null, paramString1, 1, 0, paramString2, paramString3), paramAsyncResult);
  }
  
  public void getAppInfoByLink(String paramString, int paramInt, AsyncResult paramAsyncResult)
  {
    handleRequest(new bdtg(paramString, paramInt), paramAsyncResult);
  }
  
  public void getAuthList(String paramString, ChannelProxy.AuthListResult paramAuthListResult)
  {
    paramString = new bdth(null, paramString);
    MiniAppProxy localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    handleRequest(paramString, new ChannelProxyDefault.1(this, paramAuthListResult));
  }
  
  public void getFormId(String paramString, AsyncResult paramAsyncResult)
  {
    handleRequest(new bdtk(paramString), paramAsyncResult);
  }
  
  public void getFriendCloudStorage(String paramString, String[] paramArrayOfString, AsyncResult paramAsyncResult)
  {
    handleRequest(new bdtl(paramArrayOfString, paramString), paramAsyncResult);
  }
  
  public void getGroupCloudStorage(String paramString1, String paramString2, String[] paramArrayOfString, AsyncResult paramAsyncResult)
  {
    handleRequest(new bdtm(paramArrayOfString, paramString2, paramString1), paramAsyncResult);
  }
  
  public void getGroupShareInfo(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    handleRequest(new bdtx(null, paramString1, paramString2), paramAsyncResult);
  }
  
  public void getMidasConsumeResult(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, AsyncResult paramAsyncResult)
  {
    handleRequest(new bdty(paramString1, null, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5), paramAsyncResult);
  }
  
  public void getMiniAppStoreAppList(int paramInt, AsyncResult paramAsyncResult)
  {
    handleRequest(new bdtj(paramInt), paramAsyncResult);
  }
  
  public void getNativeAppInfoForJump(String paramString1, String paramString2, String paramString3, int paramInt, AsyncResult paramAsyncResult)
  {
    handleRequest(new bdto(null, paramString1, paramString2, paramString3, paramInt), paramAsyncResult);
  }
  
  public void getPhoneNumber(String paramString, AsyncResult paramAsyncResult)
  {
    handleRequest(new bduf(paramString), paramAsyncResult);
  }
  
  public void getRobotUin(String paramString, AsyncResult paramAsyncResult)
  {
    handleRequest(new bdtr(null, paramString), paramAsyncResult);
  }
  
  public void getTcbTicket(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    handleRequest(new bdts(null, paramString1, paramString2), paramAsyncResult);
  }
  
  public void getUserCloudStorage(String paramString, String[] paramArrayOfString, AsyncResult paramAsyncResult)
  {
    handleRequest(new bdti(paramArrayOfString, paramString), paramAsyncResult);
  }
  
  public void getUserHealthData(String paramString, AsyncResult paramAsyncResult)
  {
    handleRequest(new bdtu(null, paramString), paramAsyncResult);
  }
  
  public void getUserInfo(String paramString1, boolean paramBoolean, String paramString2, AsyncResult paramAsyncResult)
  {
    handleRequest(new bdtq(paramString1, paramBoolean, paramString2), paramAsyncResult);
  }
  
  public void getUserInfoExtra(String paramString, AsyncResult paramAsyncResult)
  {
    handleRequest(new bdtv(paramString), paramAsyncResult);
  }
  
  public void getUserInfoOpenData(String paramString1, String paramString2, String[] paramArrayOfString, AsyncResult paramAsyncResult)
  {
    handleRequest(new bdsz(paramString1, paramString2, paramArrayOfString), paramAsyncResult);
  }
  
  public void getUserSetting(String paramString1, String paramString2, String paramString3, AsyncResult paramAsyncResult)
  {
    handleRequest(new bdtw(paramString1, paramString2, paramString3), paramAsyncResult);
  }
  
  public void httpReport(Bundle paramBundle) {}
  
  public void login(String paramString, AsyncResult paramAsyncResult)
  {
    handleRequest(new bdtn(paramString), paramAsyncResult);
  }
  
  public void queryCurrency(String paramString1, String paramString2, int paramInt1, int paramInt2, AsyncResult paramAsyncResult)
  {
    handleRequest(new bdua(null, paramString2, paramString1, paramInt1, paramInt2), paramAsyncResult);
  }
  
  public void removeUserCloudStorage(String paramString, String[] paramArrayOfString, AsyncResult paramAsyncResult)
  {
    handleRequest(new bdub(paramArrayOfString, paramString), paramAsyncResult);
  }
  
  public void report(byte[] paramArrayOfByte, String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    handleRequest(new bdte(paramArrayOfByte, paramString1, paramString2), paramAsyncResult);
  }
  
  public void setAuth(String paramString, bddn parambddn, AsyncResult paramAsyncResult)
  {
    INTERFACE.StUserAuthInfo localStUserAuthInfo = new INTERFACE.StUserAuthInfo();
    localStUserAuthInfo.scope.set(parambddn.jdField_a_of_type_JavaLangString);
    if (!TextUtils.isEmpty(parambddn.b)) {
      localStUserAuthInfo.desc.set(parambddn.b);
    }
    localStUserAuthInfo.authState.set(parambddn.jdField_a_of_type_Int);
    handleRequest(new bduc(null, paramString, localStUserAuthInfo), paramAsyncResult);
  }
  
  public void setPersonalizeInfo(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, AsyncResult paramAsyncResult)
  {
    handleRequest(new bdud(null, paramString1, paramString2, paramInt, paramString3, paramString4), paramAsyncResult);
  }
  
  public void setUserCloudStorage(String paramString, HashMap<String, String> paramHashMap, AsyncResult paramAsyncResult)
  {
    handleRequest(new bdue(paramHashMap, paramString), paramAsyncResult);
  }
  
  public void transForRoomId(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    handleRequest(new bdtt(paramString1, paramString2), paramAsyncResult);
  }
  
  public boolean updateBaseLib(String paramString, boolean paramBoolean1, boolean paramBoolean2, AsyncResult paramAsyncResult)
  {
    bdnw.b("ChannelProxyDefault", "[MiniEng] doUpdateBaseLib nocheck=" + paramBoolean1 + ", force=" + paramBoolean2);
    if ((!paramBoolean1) && (!paramBoolean2))
    {
      long l = bdzf.a().getLong("baselib_min_update_time", 0L);
      if (System.currentTimeMillis() - l <= 0L)
      {
        bdnw.b("ChannelProxyDefault", "[MiniEng] updateBaseLib 在时间间隔内，暂时不更新");
        return false;
      }
    }
    handleRequest(new bdtp(paramString, 0), paramAsyncResult);
    return true;
  }
  
  public void updateUserSetting(String paramString, bddp parambddp, AsyncResult paramAsyncResult) {}
  
  public void verifyPlugin(String paramString, ArrayList<PluginInfo> paramArrayList, AsyncResult paramAsyncResult) {}
  
  public boolean wnsCgiRequest(JSONObject paramJSONObject, AsyncResult paramAsyncResult)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.ChannelProxyDefault
 * JD-Core Version:    0.7.0.1
 */