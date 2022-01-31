package com.tencent.qqmini.sdk.core.proxy;

import android.os.Bundle;
import bddn;
import bddp;
import com.tencent.qqmini.sdk.launcher.model.PluginInfo;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

public abstract interface ChannelProxy
{
  public abstract void batchGetContact(ArrayList<String> paramArrayList, AsyncResult paramAsyncResult);
  
  public abstract void checkNavigateRight(String paramString1, String paramString2, AsyncResult paramAsyncResult);
  
  public abstract void checkOfferId(String paramString1, String paramString2, AsyncResult paramAsyncResult);
  
  public abstract void checkSession(String paramString, AsyncResult paramAsyncResult);
  
  public abstract void dataReport(byte[] paramArrayOfByte, AsyncResult paramAsyncResult);
  
  public abstract void getAppInfoById(String paramString1, String paramString2, String paramString3, AsyncResult paramAsyncResult);
  
  public abstract void getAppInfoByLink(String paramString, int paramInt, AsyncResult paramAsyncResult);
  
  public abstract void getAuthList(String paramString, ChannelProxy.AuthListResult paramAuthListResult);
  
  public abstract void getFormId(String paramString, AsyncResult paramAsyncResult);
  
  public abstract void getFriendCloudStorage(String paramString, String[] paramArrayOfString, AsyncResult paramAsyncResult);
  
  public abstract void getGroupCloudStorage(String paramString1, String paramString2, String[] paramArrayOfString, AsyncResult paramAsyncResult);
  
  public abstract void getGroupShareInfo(String paramString1, String paramString2, AsyncResult paramAsyncResult);
  
  public abstract void getMidasConsumeResult(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, AsyncResult paramAsyncResult);
  
  public abstract void getMiniAppStoreAppList(int paramInt, AsyncResult paramAsyncResult);
  
  public abstract void getNativeAppInfoForJump(String paramString1, String paramString2, String paramString3, int paramInt, AsyncResult paramAsyncResult);
  
  public abstract void getPhoneNumber(String paramString, AsyncResult paramAsyncResult);
  
  public abstract void getRobotUin(String paramString, AsyncResult paramAsyncResult);
  
  public abstract void getTcbTicket(String paramString1, String paramString2, AsyncResult paramAsyncResult);
  
  public abstract void getUserCloudStorage(String paramString, String[] paramArrayOfString, AsyncResult paramAsyncResult);
  
  public abstract void getUserHealthData(String paramString, AsyncResult paramAsyncResult);
  
  public abstract void getUserInfo(String paramString1, boolean paramBoolean, String paramString2, AsyncResult paramAsyncResult);
  
  public abstract void getUserInfoExtra(String paramString, AsyncResult paramAsyncResult);
  
  public abstract void getUserInfoOpenData(String paramString1, String paramString2, String[] paramArrayOfString, AsyncResult paramAsyncResult);
  
  public abstract void getUserSetting(String paramString1, String paramString2, String paramString3, AsyncResult paramAsyncResult);
  
  public abstract void httpReport(Bundle paramBundle);
  
  public abstract void login(String paramString, AsyncResult paramAsyncResult);
  
  public abstract void queryCurrency(String paramString1, String paramString2, int paramInt1, int paramInt2, AsyncResult paramAsyncResult);
  
  public abstract void removeUserCloudStorage(String paramString, String[] paramArrayOfString, AsyncResult paramAsyncResult);
  
  public abstract void report(byte[] paramArrayOfByte, String paramString1, String paramString2, AsyncResult paramAsyncResult);
  
  public abstract void setAuth(String paramString, bddn parambddn, AsyncResult paramAsyncResult);
  
  public abstract void setPersonalizeInfo(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, AsyncResult paramAsyncResult);
  
  public abstract void setUserCloudStorage(String paramString, HashMap<String, String> paramHashMap, AsyncResult paramAsyncResult);
  
  public abstract void transForRoomId(String paramString1, String paramString2, AsyncResult paramAsyncResult);
  
  public abstract boolean updateBaseLib(String paramString, boolean paramBoolean1, boolean paramBoolean2, AsyncResult paramAsyncResult);
  
  public abstract void updateUserSetting(String paramString, bddp parambddp, AsyncResult paramAsyncResult);
  
  public abstract void verifyPlugin(String paramString, ArrayList<PluginInfo> paramArrayList, AsyncResult paramAsyncResult);
  
  public abstract boolean wnsCgiRequest(JSONObject paramJSONObject, AsyncResult paramAsyncResult);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.ChannelProxy
 * JD-Core Version:    0.7.0.1
 */