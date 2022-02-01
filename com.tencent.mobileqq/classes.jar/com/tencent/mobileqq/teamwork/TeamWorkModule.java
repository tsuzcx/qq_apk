package com.tencent.mobileqq.teamwork;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class TeamWorkModule
  extends QIPCModule
{
  private static TeamWorkModule a = null;
  
  private TeamWorkModule()
  {
    super("TeamWorkModule");
  }
  
  public static TeamWorkModule a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new TeamWorkModule();
      }
      return a;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TeamWorkModule", 2, "[onCall] action = " + paramString + ", params = " + paramBundle + ", callbackId=" + paramInt);
    }
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    if (!QQAppInterface.class.isInstance(localObject)) {
      if (QLog.isColorLevel()) {
        QLog.e("TeamWorkModule", 2, "[onCall] get app failed.");
      }
    }
    do
    {
      String str1;
      String str2;
      do
      {
        return null;
        if (!"send_to_chat_msg".equals(paramString)) {
          break;
        }
        paramString = StructMsgFactory.a(paramBundle);
        paramInt = paramBundle.getInt("uin_type");
        str1 = paramBundle.getString("to_uin");
        str2 = paramBundle.getString("docs_gray_tips_info_json");
        paramBundle = paramBundle.getString("detail_url");
      } while ((localObject == null) || (paramString == null));
      paramString.mExtraData = "aioPlusPanelTencentDoc";
      ShareMsgHelper.a((QQAppInterface)localObject, str1, paramInt, paramString, null, str2, paramBundle);
      return null;
    } while (!"action_download_export_file".equals(paramString));
    boolean bool = paramBundle.getBoolean("isSuccess");
    paramString = paramBundle.getString("docUrl");
    localObject = (TeamWorkFileExportHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_FILE_EXPORT_HANDLER);
    if (bool)
    {
      ((TeamWorkFileExportHandler)localObject).notifyUI(2, true, new Object[] { paramBundle.getString("url"), paramBundle.getString("fileName"), paramString, paramBundle.getString("cookie") });
      return null;
    }
    ((TeamWorkFileExportHandler)localObject).notifyUI(1, true, new Object[] { HardCodeUtil.a(2131714653), paramString });
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkModule
 * JD-Core Version:    0.7.0.1
 */