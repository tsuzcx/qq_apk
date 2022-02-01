package com.tencent.mobileqq.teamwork.api.impl;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment;
import com.tencent.mobileqq.activity.aio.AIOOpenWebMonitor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.jsp.DocxApiPlugin;
import com.tencent.mobileqq.managers.TimJumpLoginManager;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.teamwork.TeamWorkHandlerUtils;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface.ForwardTencentDocsCallback;
import com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.SoLibraryChecker;
import com.tencent.mobileqq.webview.swift.SwiftReuseTouchWebView;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class GetExternalInterfaceImpl
  implements IGetExternalInterface
{
  public Dialog actionSheetHelperCreateDialog(Context paramContext, View paramView)
  {
    return ActionSheetHelper.b(paramContext, paramView);
  }
  
  public void addAioParamForSystem(Intent paramIntent)
  {
    AIOOpenWebMonitor.b(paramIntent, "use_x5", "2");
  }
  
  public void addAioParamForX5(Intent paramIntent)
  {
    AIOOpenWebMonitor.b(paramIntent, "use_x5", "1");
  }
  
  public void addMessage(AppInterface paramAppInterface, MessageRecord paramMessageRecord, String paramString)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {
      ((QQAppInterface)paramAppInterface).getMessageFacade().a(paramMessageRecord, paramString);
    }
  }
  
  public JSONObject checkFormCache(JSONObject paramJSONObject, String paramString)
  {
    return TeamWorkHandlerUtils.b(paramJSONObject, paramString);
  }
  
  public MessageRecord createMsgRecordByMsgType(int paramInt)
  {
    return MessageRecordFactory.a(paramInt);
  }
  
  public void endUrlLoad(Intent paramIntent, String paramString)
  {
    AIOOpenWebMonitor.b(paramIntent, paramString);
  }
  
  public void fileManagerUtilOpenUrl(Context paramContext, String paramString)
  {
    FileManagerUtil.c(paramContext, paramString);
  }
  
  public void forwardTencentDocs(AppRuntime paramAppRuntime, Activity paramActivity, List<FileManagerEntity> paramList, IGetExternalInterface.ForwardTencentDocsCallback paramForwardTencentDocsCallback)
  {
    if (paramAppRuntime != null) {
      ReportController.b(paramAppRuntime, "dc00898", "", "", "0X800A082", "0X800A082", 0, 0, "", "", "", "");
    }
    if ((paramList != null) && (paramList.size() == 1))
    {
      paramAppRuntime = (FileManagerEntity)paramList.get(0);
      try
      {
        paramList = new JSONObject(new String(paramAppRuntime.bombData));
        paramAppRuntime = new Bundle();
        paramAppRuntime.putInt("forward_type", -3);
        paramAppRuntime.putInt("structmsg_service_id", paramList.getInt("structmsg_service_id"));
        paramAppRuntime.putByteArray("stuctmsg_bytes", Base64.decode(paramList.getString("stuctmsg_bytes"), 0));
        paramAppRuntime.putLong("structmsg_uniseq", paramList.getLong("structmsg_uniseq"));
        paramAppRuntime.putInt("accostType", paramList.getInt("accostType"));
        paramAppRuntime.putBoolean("forwardDirect", true);
        paramList = new Intent();
        paramList.putExtra("forward_type", -3);
        paramList.putExtras(paramAppRuntime);
        ForwardBaseOption.a(paramActivity, paramList, 103);
        return;
      }
      catch (JSONException paramAppRuntime)
      {
        paramAppRuntime.printStackTrace();
        return;
      }
    }
    if ((paramList != null) && (paramList.size() != 0))
    {
      paramAppRuntime = new ArrayList(paramList.size());
      paramActivity = paramList.iterator();
      while (paramActivity.hasNext())
      {
        paramList = (FileManagerEntity)paramActivity.next();
        try
        {
          JSONObject localJSONObject = new JSONObject(new String(paramList.bombData));
          MessageForStructing localMessageForStructing = new MessageForStructing();
          localMessageForStructing.structingMsg = StructMsgFactory.a(Base64.decode(localJSONObject.getString("stuctmsg_bytes"), 0));
          localMessageForStructing.senderuin = String.valueOf(paramList.peerUin);
          localMessageForStructing.issend = 1;
          localMessageForStructing.msgtype = -2011;
          paramAppRuntime.add(localMessageForStructing);
        }
        catch (JSONException paramList)
        {
          paramList.printStackTrace();
        }
      }
      if (paramForwardTencentDocsCallback != null) {
        paramForwardTencentDocsCallback.a(paramAppRuntime);
      }
      return;
    }
    if (paramForwardTencentDocsCallback != null) {
      paramForwardTencentDocsCallback.a(new ArrayList());
    }
  }
  
  public String getBuddyName(AppInterface paramAppInterface, String paramString, boolean paramBoolean)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {
      return ContactUtils.a((QQAppInterface)paramAppInterface, paramString, paramBoolean);
    }
    return null;
  }
  
  public boolean getCommonConfigBooleanValue(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    return SharedPreUtils.d(paramContext, paramString1, paramString2, paramBoolean);
  }
  
  public Intent getFileBrowserActivityClassIntent(Activity paramActivity)
  {
    return new Intent(paramActivity, FileBrowserActivity.class);
  }
  
  public int getFileType(String paramString)
  {
    return FileManagerUtil.c(paramString);
  }
  
  public long getGroupUin(Context paramContext)
  {
    if (isInstanceGroupTeamWorkListActivity(paramContext)) {
      return ((GroupTeamWorkListActivity)paramContext).m;
    }
    return 0L;
  }
  
  public boolean getPreloadWebProcess()
  {
    return SwiftBrowserStatistics.aD;
  }
  
  public boolean getReportPerformance()
  {
    return SwiftBrowserStatistics.aL;
  }
  
  public long getWebAcceleratorCostTime()
  {
    return 0L;
  }
  
  public WebResourceResponse getWebResponse(String paramString)
  {
    return (WebResourceResponse)((IPublicAccountH5AbilityPlugin)QRoute.api(IPublicAccountH5AbilityPlugin.class)).getWebResponse(paramString);
  }
  
  public String getWebViewUAForQQ(String paramString1, String paramString2, boolean paramBoolean)
  {
    return SwiftWebViewUtils.a(paramString1, paramString2, paramBoolean);
  }
  
  public JSONObject importFormWithLocalFile(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    return TeamWorkHandlerUtils.a(paramJSONObject, paramString1, paramString2);
  }
  
  public JSONObject importFormWithUrl(JSONObject paramJSONObject, String paramString)
  {
    return TeamWorkHandlerUtils.a(paramJSONObject, paramString);
  }
  
  public boolean isInstanceGroupTeamWorkListActivity(Context paramContext)
  {
    return paramContext instanceof GroupTeamWorkListActivity;
  }
  
  public boolean isInstanceMessageForFile(MessageRecord paramMessageRecord)
  {
    return paramMessageRecord instanceof MessageForFile;
  }
  
  public boolean isInstanceTeamWorkDocEditBrowserFragment(Object paramObject)
  {
    return paramObject instanceof TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment;
  }
  
  public boolean isQQAppInterface(AppInterface paramAppInterface)
  {
    return paramAppInterface instanceof QQAppInterface;
  }
  
  public boolean isTroopAdmin(AppInterface paramAppInterface, long paramLong, String paramString)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {
      return TroopUtils.a((QQAppInterface)paramAppInterface, paramLong, paramString);
    }
    return false;
  }
  
  public void jumpTimLogin(Bundle paramBundle, AppInterface paramAppInterface)
  {
    if (paramAppInterface != null) {
      ((TimJumpLoginManager)paramAppInterface.getManager(QQManagerFactory.TIM_JUMP_LOGIN_MANAGER)).a(paramBundle);
    }
  }
  
  public void paramInitFinish(Intent paramIntent)
  {
    AIOOpenWebMonitor.b(paramIntent);
  }
  
  public MessageRecord queryMsgItemByUniseq(AppInterface paramAppInterface, String paramString, int paramInt, long paramLong)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {
      return ((QQAppInterface)paramAppInterface).getMessageFacade().b(paramString, paramInt, paramLong);
    }
    return null;
  }
  
  public void sendDocsDataBack(String paramString, TouchWebView paramTouchWebView)
  {
    DocxApiPlugin.a(paramString, paramTouchWebView);
  }
  
  public void sendServiceIpcReq(Bundle paramBundle)
  {
    paramBundle = DataFactory.a("ipc_cmd_convert_team_work_url_2_doc", "", -1, paramBundle);
    ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(paramBundle);
  }
  
  public void setRedDotForTimGroupTMShow(AppInterface paramAppInterface, Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramAppInterface != null) {
      ((TroopInfoManager)paramAppInterface.getManager(QQManagerFactory.TROOPINFO_MANAGER)).a(paramContext, paramString1, paramString2, paramBoolean);
    }
  }
  
  public void soLibraryCheckerExecute(Context paramContext)
  {
    new SoLibraryChecker(paramContext, "3171", "libWXVoice.so", "WXVoice").a();
  }
  
  public String soLibraryCheckerGetSoPath(Context paramContext)
  {
    return SoLibraryChecker.a(paramContext, "libWXVoice.so");
  }
  
  public boolean soLibraryCheckerSoLibExists(Context paramContext)
  {
    return SoLibraryChecker.b(paramContext, "libWXVoice.so");
  }
  
  public void webAcceleratorSmartSchedule()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("_accelerator_mode_", 3);
    if (SwiftReuseTouchWebView.c == 0) {
      SwiftWebAccelerator.a().a(localBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.impl.GetExternalInterfaceImpl
 * JD-Core Version:    0.7.0.1
 */