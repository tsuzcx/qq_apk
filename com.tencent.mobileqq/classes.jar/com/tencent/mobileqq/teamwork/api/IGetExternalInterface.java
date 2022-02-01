package com.tencent.mobileqq.teamwork.api;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONObject;

@QAPI(process={"all"})
public abstract interface IGetExternalInterface
  extends QRouteApi
{
  public static final String TIM_GROUP_TM_REDDOT = "TIM_GROUP_TM_REDDOT";
  
  public abstract Dialog actionSheetHelperCreateDialog(Context paramContext, View paramView);
  
  public abstract void addAioParamForSystem(Intent paramIntent);
  
  public abstract void addAioParamForX5(Intent paramIntent);
  
  public abstract void addMessage(AppInterface paramAppInterface, MessageRecord paramMessageRecord, String paramString);
  
  public abstract JSONObject checkFormCache(JSONObject paramJSONObject, String paramString);
  
  public abstract MessageRecord createMsgRecordByMsgType(int paramInt);
  
  public abstract void endUrlLoad(Intent paramIntent, String paramString);
  
  public abstract void fileManagerUtilOpenUrl(Context paramContext, String paramString);
  
  public abstract void forwardTencentDocs(AppRuntime paramAppRuntime, Activity paramActivity, List<FileManagerEntity> paramList, IGetExternalInterface.ForwardTencentDocsCallback paramForwardTencentDocsCallback);
  
  public abstract String getBuddyName(AppInterface paramAppInterface, String paramString, boolean paramBoolean);
  
  public abstract boolean getCommonConfigBooleanValue(Context paramContext, String paramString1, String paramString2, boolean paramBoolean);
  
  public abstract Intent getFileBrowserActivityClassIntent(Activity paramActivity);
  
  public abstract int getFileType(String paramString);
  
  public abstract long getGroupUin(Context paramContext);
  
  public abstract boolean getPreloadWebProcess();
  
  public abstract boolean getReportPerformance();
  
  public abstract long getWebAcceleratorCostTime();
  
  public abstract WebResourceResponse getWebResponse(String paramString);
  
  public abstract String getWebViewUAForQQ(String paramString1, String paramString2, boolean paramBoolean);
  
  public abstract JSONObject importFormWithLocalFile(JSONObject paramJSONObject, String paramString1, String paramString2);
  
  public abstract JSONObject importFormWithUrl(JSONObject paramJSONObject, String paramString);
  
  public abstract boolean isInstanceGroupTeamWorkListActivity(Context paramContext);
  
  public abstract boolean isInstanceMessageForFile(MessageRecord paramMessageRecord);
  
  public abstract boolean isInstanceTeamWorkDocEditBrowserFragment(Object paramObject);
  
  public abstract boolean isQQAppInterface(AppInterface paramAppInterface);
  
  public abstract boolean isTroopAdmin(AppInterface paramAppInterface, long paramLong, String paramString);
  
  public abstract void jumpTimLogin(Bundle paramBundle, AppInterface paramAppInterface);
  
  public abstract void paramInitFinish(Intent paramIntent);
  
  public abstract MessageRecord queryMsgItemByUniseq(AppInterface paramAppInterface, String paramString, int paramInt, long paramLong);
  
  public abstract void sendDocsDataBack(String paramString, TouchWebView paramTouchWebView);
  
  public abstract void sendServiceIpcReq(Bundle paramBundle);
  
  public abstract void setRedDotForTimGroupTMShow(AppInterface paramAppInterface, Context paramContext, String paramString1, String paramString2, boolean paramBoolean);
  
  public abstract void soLibraryCheckerExecute(Context paramContext);
  
  public abstract String soLibraryCheckerGetSoPath(Context paramContext);
  
  public abstract boolean soLibraryCheckerSoLibExists(Context paramContext);
  
  public abstract void webAcceleratorSmartSchedule();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.IGetExternalInterface
 * JD-Core Version:    0.7.0.1
 */