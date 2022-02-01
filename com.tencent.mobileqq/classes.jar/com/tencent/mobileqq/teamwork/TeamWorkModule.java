package com.tencent.mobileqq.teamwork;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.openbrowser.FileBrowserParam;
import com.tencent.mobileqq.filemanager.openbrowser.FileModelAdapter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFileExportHandler;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class TeamWorkModule
  extends QIPCModule
{
  private static TeamWorkModule a;
  
  private TeamWorkModule()
  {
    super("TeamWorkModule");
  }
  
  public static TeamWorkModule a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new TeamWorkModule();
        }
      }
      finally {}
    }
    return a;
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[onCall] action = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", params = ");
      ((StringBuilder)localObject).append(paramBundle);
      ((StringBuilder)localObject).append(", callbackId=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("TeamWorkModule", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    if (!QQAppInterface.class.isInstance(localObject))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TeamWorkModule", 2, "[onCall] get app failed.");
      }
      return null;
    }
    if ("send_to_chat_msg".equals(paramString))
    {
      paramString = StructMsgFactory.a(paramBundle);
      paramInt = paramBundle.getInt("uin_type");
      String str1 = paramBundle.getString("to_uin");
      String str2 = paramBundle.getString("docs_gray_tips_info_json");
      paramBundle = paramBundle.getString("detail_url");
      if ((localObject != null) && (paramString != null))
      {
        paramString.mExtraData = "aioPlusPanelTencentDoc";
        ShareMsgHelper.a((QQAppInterface)localObject, str1, paramInt, paramString, null, str2, paramBundle);
        return null;
      }
    }
    else
    {
      if ("action_download_export_file".equals(paramString))
      {
        boolean bool = paramBundle.getBoolean("isSuccess");
        paramString = paramBundle.getString("docUrl");
        localObject = (ITeamWorkFileExportHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_FILE_EXPORT_HANDLER);
        if (bool)
        {
          ((ITeamWorkFileExportHandler)localObject).notifyUI(2, true, new Object[] { paramBundle.getString("url"), paramBundle.getString("fileName"), paramString, paramBundle.getString("cookie") });
          return null;
        }
        ((ITeamWorkFileExportHandler)localObject).notifyUI(1, true, new Object[] { HardCodeUtil.a(2131714582), paramString });
        return null;
      }
      if ("action_start_export_file".equals(paramString))
      {
        paramString = new StringBuilder();
        paramString.append("downloadExportedFile QBaseActivity.sTopActivity =  ");
        paramString.append(QBaseActivity.sTopActivity);
        QLog.d("TeamWorkModule", 1, paramString.toString());
        localObject = paramBundle.getString("fileName");
        paramString = new FileManagerEntity();
        paramString.fileName = ((String)localObject);
        paramString.nFileType = FileManagerUtil.a((String)localObject);
        paramString.nFileType = ((IGetExternalInterface)QRoute.api(IGetExternalInterface.class)).getFileType(paramString.fileName);
        paramString.nSessionId = CommonUtils.a().longValue();
        paramString.cloudType = 9;
        localObject = new Bundle();
        paramBundle.putBoolean("isMiniProgram", true);
        paramString = new FileModelAdapter((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString);
        paramString.a((Bundle)localObject);
        paramBundle = new FileBrowserParam().a(0);
        ((IFileBrowserService)QRoute.api(IFileBrowserService.class)).browserFile(BaseApplicationImpl.getContext(), paramString, paramBundle);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkModule
 * JD-Core Version:    0.7.0.1
 */