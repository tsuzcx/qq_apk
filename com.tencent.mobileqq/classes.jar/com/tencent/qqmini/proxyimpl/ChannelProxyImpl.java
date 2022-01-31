package com.tencent.qqmini.proxyimpl;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StJudgeTimingReq;
import NS_MINI_INTERFACE.INTERFACE.StJudgeTimingRsp;
import NS_MINI_INTERFACE.INTERFACE.StReportExecuteReq;
import NS_MINI_INTERFACE.INTERFACE.StReportExecuteRsp;
import NS_MINI_INTERFACE.INTERFACE.StUserAuthInfo;
import NS_MINI_INTERFACE.INTERFACE.StUserSettingInfo;
import NS_MINI_SHARE.MiniProgramShare.StAdaptShareInfoReq;
import akfo;
import android.os.Bundle;
import android.text.TextUtils;
import beif;
import beih;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.servlet.MiniAppSSOCmdHelper;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy.AuthListResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

public class ChannelProxyImpl
  implements ChannelProxy
{
  private static final String TAG = "ChannelProxyImpl";
  
  private static MiniAppCmdInterface createCmdInterface(AsyncResult paramAsyncResult)
  {
    return new ChannelProxyImpl.4(paramAsyncResult);
  }
  
  public void JudgeTiming(String paramString1, int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, String paramString2, int paramInt5, String paramString3, AsyncResult paramAsyncResult)
  {
    INTERFACE.StJudgeTimingReq localStJudgeTimingReq = new INTERFACE.StJudgeTimingReq();
    localStJudgeTimingReq.appid.set(paramString1);
    localStJudgeTimingReq.appType.set(paramInt1);
    localStJudgeTimingReq.scene.set(paramInt2);
    localStJudgeTimingReq.factType.set(paramInt3);
    localStJudgeTimingReq.reportTime.set(paramLong);
    localStJudgeTimingReq.totalTime.set(paramInt4);
    localStJudgeTimingReq.launchId.set(paramString2);
    localStJudgeTimingReq.afterCertify.set(paramInt5);
    localStJudgeTimingReq.via.set(paramString3);
    MiniAppSSOCmdHelper.sendSSOCmdRequest("LightAppSvc.mini_app_growguard.JudgeTiming", paramString1, localStJudgeTimingReq, INTERFACE.StJudgeTimingRsp.class, new ChannelProxyImpl.2(this, paramAsyncResult));
  }
  
  public void ReportExecute(String paramString1, int paramInt, String paramString2, String paramString3, AsyncResult paramAsyncResult)
  {
    INTERFACE.StReportExecuteReq localStReportExecuteReq = new INTERFACE.StReportExecuteReq();
    localStReportExecuteReq.appid.set(paramString1);
    localStReportExecuteReq.execTime.set(paramInt);
    localStReportExecuteReq.instrTraceId.set(paramString2);
    localStReportExecuteReq.ruleName.set(paramString3);
    MiniAppSSOCmdHelper.sendSSOCmdRequest("LightAppSvc.mini_app_growguard.ReportExecute", paramString1, localStReportExecuteReq, INTERFACE.StReportExecuteRsp.class, new ChannelProxyImpl.3(this, paramAsyncResult));
  }
  
  public void batchGetContact(ArrayList<String> paramArrayList, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().batchGetContact(paramArrayList, createCmdInterface(paramAsyncResult));
  }
  
  public void checkNavigateRight(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().checkNavigateRight(paramString1, paramString2, null, createCmdInterface(paramAsyncResult));
  }
  
  public void checkOfferId(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().checkOfferId(paramString1, paramString2, null, createCmdInterface(paramAsyncResult));
  }
  
  public void checkSession(String paramString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().checkSession(paramString, createCmdInterface(paramAsyncResult));
  }
  
  public void dataReport(byte[] paramArrayOfByte, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().performDataReport(paramArrayOfByte, createCmdInterface(paramAsyncResult));
  }
  
  public void getAppInfoById(String paramString1, String paramString2, String paramString3, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getAppInfoByIdForSDK(null, paramString1, paramString2, paramString3, createCmdInterface(paramAsyncResult));
  }
  
  public void getAppInfoByLink(String paramString, int paramInt, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getAppInfoByLinkForSDK(paramString, paramInt, createCmdInterface(paramAsyncResult));
  }
  
  public void getAuthList(String paramString, ChannelProxy.AuthListResult paramAuthListResult)
  {
    MiniAppCmdUtil.getInstance().getAuthList(null, paramString, new ChannelProxyImpl.1(this, paramAuthListResult));
  }
  
  public void getFormId(String paramString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getFormId(paramString, createCmdInterface(paramAsyncResult));
  }
  
  public void getFriendCloudStorage(String paramString, String[] paramArrayOfString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getFriendCloudStorage(paramString, paramArrayOfString, createCmdInterface(paramAsyncResult));
  }
  
  public void getGdtAd(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, HashMap<String, String> paramHashMap, AsyncResult paramAsyncResult) {}
  
  public void getGroupCloudStorage(String paramString1, String paramString2, String[] paramArrayOfString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getGroupCloudStorage(paramString1, paramString2, paramArrayOfString, createCmdInterface(paramAsyncResult));
  }
  
  public void getGroupShareInfo(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getGroupShareInfo(paramString1, paramString2, null, createCmdInterface(paramAsyncResult));
  }
  
  public void getMidasConsumeResult(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getMidasConsumeResult(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, null, createCmdInterface(paramAsyncResult));
  }
  
  public void getMiniAppStoreAppList(int paramInt, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getMiniAppStoreAppList(paramInt, createCmdInterface(paramAsyncResult));
  }
  
  public void getNativeAppInfoForJump(String paramString1, String paramString2, String paramString3, int paramInt, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getNativeAppInfoForJump(null, paramString1, paramString2, paramString3, paramInt, createCmdInterface(paramAsyncResult));
  }
  
  public void getPhoneNumber(String paramString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getPhoneNumber(paramString, createCmdInterface(paramAsyncResult));
  }
  
  public void getPotentialFriendList(COMM.StCommonExt paramStCommonExt, String paramString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getPotentialFriendList(paramStCommonExt, paramString, createCmdInterface(paramAsyncResult));
  }
  
  public void getRobotUin(String paramString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getRobotUin(paramString, createCmdInterface(paramAsyncResult));
  }
  
  public void getSDKOpenKeyToken(COMM.StCommonExt paramStCommonExt, AsyncResult paramAsyncResult) {}
  
  public void getShareInfo(MiniProgramShare.StAdaptShareInfoReq paramStAdaptShareInfoReq, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getShareInfo(paramStAdaptShareInfoReq, createCmdInterface(paramAsyncResult));
  }
  
  public void getTcbTicket(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getTcbTicket(paramString1, null, paramString2, createCmdInterface(paramAsyncResult));
  }
  
  public void getUserCloudStorage(String paramString, String[] paramArrayOfString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getUserCloudStorage(paramString, paramArrayOfString, createCmdInterface(paramAsyncResult));
  }
  
  public void getUserHealthData(String paramString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getUserHealthData(paramString, null, createCmdInterface(paramAsyncResult));
  }
  
  public void getUserInfo(String paramString1, boolean paramBoolean, String paramString2, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getUserInfo(paramString1, paramBoolean, paramString2, createCmdInterface(paramAsyncResult));
  }
  
  public void getUserInfoExtra(String paramString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getUserInfoExtra(paramString, createCmdInterface(paramAsyncResult));
  }
  
  public void getUserInfoOpenData(String paramString1, String paramString2, String[] paramArrayOfString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getUserInfoOpenData(paramString1, paramString2, paramArrayOfString, createCmdInterface(paramAsyncResult));
  }
  
  public void getUserInteractiveStorage(COMM.StCommonExt paramStCommonExt, String paramString, String[] paramArrayOfString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getUserInteractiveStorage(paramStCommonExt, paramString, paramArrayOfString, createCmdInterface(paramAsyncResult));
  }
  
  public void getUserSetting(String paramString1, String paramString2, String paramString3, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getUserSetting(paramString1, paramString2, paramString3, createCmdInterface(paramAsyncResult));
  }
  
  public void httpReport(Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.containsKey("data")))
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = (akfo)((QQAppInterface)localObject).a(5);
        if (localObject != null) {
          ((akfo)localObject).a(paramBundle);
        }
      }
    }
  }
  
  public void login(String paramString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getLoginCode(paramString, createCmdInterface(paramAsyncResult));
  }
  
  public void modifyFriendInteractiveStorage(COMM.StCommonExt paramStCommonExt, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, HashMap<String, String> paramHashMap, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().modifyFriendInteractiveStorage(paramStCommonExt, paramString1, paramString2, paramString3, paramInt, paramString4, paramHashMap, createCmdInterface(paramAsyncResult));
  }
  
  public void queryCurrency(String paramString1, String paramString2, int paramInt1, int paramInt2, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getMidasQueryResult(paramString1, paramString2, paramInt1, paramInt2, null, createCmdInterface(paramAsyncResult));
  }
  
  public void removeUserCloudStorage(String paramString, String[] paramArrayOfString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().removeUserCloudStorage(paramString, paramArrayOfString, createCmdInterface(paramAsyncResult));
  }
  
  public void report(byte[] paramArrayOfByte, String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().performReport(paramArrayOfByte, createCmdInterface(paramAsyncResult), "LightAppSvc." + paramString1 + "." + paramString2);
  }
  
  public void setAuth(String paramString, beif parambeif, AsyncResult paramAsyncResult)
  {
    INTERFACE.StUserAuthInfo localStUserAuthInfo = new INTERFACE.StUserAuthInfo();
    localStUserAuthInfo.scope.set(parambeif.jdField_a_of_type_JavaLangString);
    if (!TextUtils.isEmpty(parambeif.b)) {
      localStUserAuthInfo.desc.set(parambeif.b);
    }
    localStUserAuthInfo.authState.set(parambeif.jdField_a_of_type_Int);
    MiniAppCmdUtil.getInstance().setAuth(null, paramString, localStUserAuthInfo, createCmdInterface(paramAsyncResult));
  }
  
  public void setPersonalizeInfo(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().setPersonalizeInfo(paramString1, paramString2, paramInt, paramString3, paramString4, createCmdInterface(paramAsyncResult));
  }
  
  public void setUserCloudStorage(String paramString, HashMap<String, String> paramHashMap, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().setUserCloudStorage(paramString, paramHashMap, createCmdInterface(paramAsyncResult));
  }
  
  public void transForRoomId(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().transForRoomId(paramString1, paramString2, createCmdInterface(paramAsyncResult));
  }
  
  public boolean updateBaseLib(String paramString, boolean paramBoolean1, boolean paramBoolean2, AsyncResult paramAsyncResult)
  {
    return MiniAppCmdUtil.getInstance().updateBaseLibForSDK(paramString, paramBoolean1, paramBoolean2, createCmdInterface(paramAsyncResult));
  }
  
  public void updateUserSetting(String paramString, beih parambeih, AsyncResult paramAsyncResult)
  {
    INTERFACE.StUserSettingInfo localStUserSettingInfo = new INTERFACE.StUserSettingInfo();
    localStUserSettingInfo.settingItem.set(parambeih.jdField_a_of_type_JavaLangString);
    localStUserSettingInfo.authState.set(parambeih.jdField_a_of_type_Int);
    localStUserSettingInfo.desc.set(parambeih.b);
    MiniAppCmdUtil.getInstance().updateUserSetting(null, paramString, localStUserSettingInfo, createCmdInterface(paramAsyncResult));
  }
  
  public void useUserApp(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, COMM.StCommonExt paramStCommonExt, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().useUserApp(paramString1, paramInt1, paramInt2, paramString2, paramString3, paramStCommonExt, createCmdInterface(paramAsyncResult));
  }
  
  public void verifyPlugin(String paramString, ArrayList<com.tencent.qqmini.sdk.launcher.model.PluginInfo> paramArrayList, AsyncResult paramAsyncResult)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      com.tencent.qqmini.sdk.launcher.model.PluginInfo localPluginInfo = (com.tencent.qqmini.sdk.launcher.model.PluginInfo)paramArrayList.next();
      com.tencent.mobileqq.mini.apkg.PluginInfo localPluginInfo1 = new com.tencent.mobileqq.mini.apkg.PluginInfo();
      localPluginInfo1.setInnerVersion(localPluginInfo.a());
      localPluginInfo1.setPluginId(localPluginInfo.a());
      localArrayList.add(localPluginInfo1);
    }
    MiniAppCmdUtil.getInstance().verifyPlugin(paramString, localArrayList, createCmdInterface(paramAsyncResult));
  }
  
  public boolean wnsCgiRequest(JSONObject paramJSONObject, AsyncResult paramAsyncResult)
  {
    return MiniAppUtils.performWnsCgiRequest(paramJSONObject, paramAsyncResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ChannelProxyImpl
 * JD-Core Version:    0.7.0.1
 */