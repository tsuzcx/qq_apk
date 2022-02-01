package com.tencent.mobileqq.teamwork;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.QLog;

public class TeamWorkSender
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MessageForStructing jdField_a_of_type_ComTencentMobileqqDataMessageForStructing;
  private AbsStructMsg jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
  private TeamWorkFileImportObserver jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportObserver;
  
  public TeamWorkSender(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportObserver);
  }
  
  private AbsStructMsg a(Context paramContext, String paramString)
  {
    Object localObject2 = FileManagerUtil.a(paramString);
    String str = FileUtil.a(paramString);
    if (".doc|.docx|.xls|.xlsx|".indexOf(str) < 0)
    {
      paramContext = new StringBuilder();
      paramContext.append(paramString);
      paramContext.append(" is not docs support file");
      QLog.e("TeamWorkSender", 1, paramContext.toString());
      return null;
    }
    if (".doc|.docx".contains(str))
    {
      paramString = HardCodeUtil.a(2131714599);
      str = "https://pub.idqqimg.com/pc/misc/files/20180403/29c998e16c094b10a96b3e0d1589c2f6.png";
    }
    else
    {
      paramString = HardCodeUtil.a(2131714595);
      str = "https://pub.idqqimg.com/pc/misc/files/20180403/da40f07bd79e4796b712b44023911be0.png";
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("key_flag_from_plugin", true);
    localIntent.setClass(paramContext, ForwardRecentActivity.class);
    localIntent.putExtra("isFromShare", true);
    localIntent.putExtra("forward_type", 1001);
    localIntent.putExtra("pluginName", "web_share");
    localIntent.putExtra("req_type", 95);
    localIntent.putExtra("image_url_remote", str);
    localIntent.putExtra("pubUin", "");
    localIntent.putExtra("struct_uin", "");
    Object localObject1 = localObject2;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((String)localObject2).length() > 45)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(((String)localObject2).substring(0, 45));
        ((StringBuilder)localObject1).append("…");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    localIntent.putExtra("title", (String)localObject1);
    localObject2 = paramString;
    if (paramString != null)
    {
      localObject2 = paramString;
      if (paramString.length() > 60)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramString.substring(0, 60));
        ((StringBuilder)localObject2).append("…");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
    }
    localIntent.putExtra("desc", (String)localObject2);
    localIntent.putExtra("forward_thumb", str);
    localIntent.putExtra("struct_share_key_content_action", "web");
    localIntent.putExtra("req_share_id", -1L);
    localIntent.putExtra("struct_share_key_source_action", "web");
    localIntent.putExtra("struct_share_key_source_url", "https://docs.qq.com/desktop/m/index.html?_wv=2");
    localIntent.putExtra("struct_share_key_source_icon", "https://docs.qq.com/desktop/favicon.ico");
    localIntent.putExtra("app_name", HardCodeUtil.a(2131714618));
    localIntent.putExtra("brief_key", paramContext.getString(2131696401, new Object[] { localObject1 }));
    return StructMsgFactory.a(localIntent.getExtras());
  }
  
  private TeamWorkFileImportInfo a(MessageRecord paramMessageRecord)
  {
    try
    {
      TeamWorkFileImportInfo localTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
      localTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString = paramMessageRecord.getExtInfoFromExtStr("fileName");
      QLog.i("TeamWorkSender", 1, "dmytest");
      localTeamWorkFileImportInfo.c = paramMessageRecord.getExtInfoFromExtStr("filePath");
      localTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString = paramMessageRecord.getExtInfoFromExtStr("peerUin");
      localTeamWorkFileImportInfo.jdField_d_of_type_JavaLangString = paramMessageRecord.getExtInfoFromExtStr("troopFilePath");
      localTeamWorkFileImportInfo.jdField_e_of_type_JavaLangString = paramMessageRecord.getExtInfoFromExtStr("troopUin");
      localTeamWorkFileImportInfo.jdField_d_of_type_Int = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("entranceFrom"));
      localTeamWorkFileImportInfo.jdField_j_of_type_Int = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("fileImportType"));
      localTeamWorkFileImportInfo.jdField_d_of_type_Long = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("fileSize"));
      localTeamWorkFileImportInfo.jdField_b_of_type_Boolean = Boolean.parseBoolean(paramMessageRecord.getExtInfoFromExtStr("isFromAIO"));
      localTeamWorkFileImportInfo.f = Boolean.parseBoolean(paramMessageRecord.getExtInfoFromExtStr("isMessageConvert"));
      localTeamWorkFileImportInfo.jdField_a_of_type_Boolean = Boolean.parseBoolean(paramMessageRecord.getExtInfoFromExtStr("isNeedDownLoadUrl"));
      localTeamWorkFileImportInfo.jdField_d_of_type_Boolean = Boolean.parseBoolean(paramMessageRecord.getExtInfoFromExtStr("isOpenTeamWork"));
      localTeamWorkFileImportInfo.jdField_e_of_type_Boolean = Boolean.parseBoolean(paramMessageRecord.getExtInfoFromExtStr("isUserClick"));
      localTeamWorkFileImportInfo.jdField_a_of_type_Long = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("msgUniseq"));
      localTeamWorkFileImportInfo.jdField_e_of_type_Int = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("nFileType"));
      localTeamWorkFileImportInfo.jdField_b_of_type_Long = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("nSessionId"));
      localTeamWorkFileImportInfo.jdField_a_of_type_Int = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("peerType"));
      localTeamWorkFileImportInfo.jdField_b_of_type_Int = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("troopFileBusId"));
      localTeamWorkFileImportInfo.jdField_e_of_type_Long = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("structUniseq"));
      return localTeamWorkFileImportInfo;
    }
    catch (Exception paramMessageRecord)
    {
      label260:
      break label260;
    }
    QLog.e("TeamWorkSender", 1, "parse mr info is error");
    return null;
  }
  
  private TeamWorkFileImportInfo a(FileManagerEntity paramFileManagerEntity)
  {
    TeamWorkFileImportInfo localTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
    localTeamWorkFileImportInfo.c = paramFileManagerEntity.getFilePath();
    localTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString = paramFileManagerEntity.fileName;
    localTeamWorkFileImportInfo.jdField_e_of_type_Int = paramFileManagerEntity.nFileType;
    localTeamWorkFileImportInfo.jdField_b_of_type_Boolean = false;
    localTeamWorkFileImportInfo.jdField_d_of_type_Int = 4;
    localTeamWorkFileImportInfo.jdField_d_of_type_Long = paramFileManagerEntity.fileSize;
    localTeamWorkFileImportInfo.jdField_a_of_type_Int = paramFileManagerEntity.peerType;
    localTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString = paramFileManagerEntity.peerUin;
    localTeamWorkFileImportInfo.jdField_e_of_type_JavaLangString = String.valueOf(paramFileManagerEntity.TroopUin);
    localTeamWorkFileImportInfo.jdField_b_of_type_Int = paramFileManagerEntity.busId;
    localTeamWorkFileImportInfo.jdField_d_of_type_JavaLangString = paramFileManagerEntity.strTroopFilePath;
    localTeamWorkFileImportInfo.jdField_a_of_type_Long = paramFileManagerEntity.uniseq;
    if (paramFileManagerEntity.status != 16) {
      localTeamWorkFileImportInfo.jdField_a_of_type_Boolean = true;
    }
    return localTeamWorkFileImportInfo;
  }
  
  private TeamWorkFileImportInfo a(String paramString)
  {
    TeamWorkFileImportInfo localTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
    localTeamWorkFileImportInfo.c = paramString;
    localTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString = FileManagerUtil.a(paramString);
    localTeamWorkFileImportInfo.jdField_e_of_type_Int = FileManagerUtil.a(paramString);
    localTeamWorkFileImportInfo.jdField_b_of_type_Boolean = false;
    localTeamWorkFileImportInfo.jdField_d_of_type_Int = 4;
    localTeamWorkFileImportInfo.jdField_d_of_type_Long = FileManagerUtil.a(paramString);
    localTeamWorkFileImportInfo.jdField_a_of_type_Boolean = false;
    return localTeamWorkFileImportInfo;
  }
  
  private String a(int paramInt)
  {
    HardCodeUtil.a(2131714597);
    switch (paramInt)
    {
    case -109: 
    case -105: 
    case -104: 
    default: 
      return HardCodeUtil.a(2131714573);
    case -102: 
    case -101: 
    case -100: 
      return HardCodeUtil.a(2131714563);
    case -103: 
      return HardCodeUtil.a(2131714593);
    case -107: 
      return HardCodeUtil.a(2131714555);
    case -108: 
      return HardCodeUtil.a(2131714607);
    case -110: 
      return HardCodeUtil.a(2131714594);
    case -111: 
      return HardCodeUtil.a(2131714576);
    case -114: 
      return HardCodeUtil.a(2131714616);
    case -115: 
    case -113: 
    case -112: 
      return HardCodeUtil.a(2131714560);
    }
    return HardCodeUtil.a(2131714591);
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportObserver = new TeamWorkSender.1(this);
  }
  
  private void a(MessageRecord paramMessageRecord, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    paramMessageRecord.saveExtInfoToExtStr("fileName", paramTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString);
    paramMessageRecord.saveExtInfoToExtStr("filePath", paramTeamWorkFileImportInfo.c);
    paramMessageRecord.saveExtInfoToExtStr("peerUin", paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString);
    String str;
    if (paramTeamWorkFileImportInfo.jdField_d_of_type_JavaLangString != null) {
      str = paramTeamWorkFileImportInfo.jdField_d_of_type_JavaLangString;
    } else {
      str = "";
    }
    paramMessageRecord.saveExtInfoToExtStr("troopFilePath", str);
    paramMessageRecord.saveExtInfoToExtStr("troopUin", paramTeamWorkFileImportInfo.jdField_e_of_type_JavaLangString);
    paramMessageRecord.saveExtInfoToExtStr("entranceFrom", String.valueOf(paramTeamWorkFileImportInfo.jdField_d_of_type_Int));
    paramMessageRecord.saveExtInfoToExtStr("fileImportType", String.valueOf(paramTeamWorkFileImportInfo.jdField_j_of_type_Int));
    paramMessageRecord.saveExtInfoToExtStr("fileSize", String.valueOf(paramTeamWorkFileImportInfo.jdField_d_of_type_Long));
    paramMessageRecord.saveExtInfoToExtStr("isFromAIO", String.valueOf(paramTeamWorkFileImportInfo.jdField_b_of_type_Boolean));
    paramMessageRecord.saveExtInfoToExtStr("isMessageConvert", String.valueOf(paramTeamWorkFileImportInfo.f));
    paramMessageRecord.saveExtInfoToExtStr("isNeedDownLoadUrl", String.valueOf(paramTeamWorkFileImportInfo.jdField_a_of_type_Boolean));
    paramMessageRecord.saveExtInfoToExtStr("isOpenTeamWork", String.valueOf(paramTeamWorkFileImportInfo.jdField_d_of_type_Boolean));
    paramMessageRecord.saveExtInfoToExtStr("isUserClick", String.valueOf(paramTeamWorkFileImportInfo.jdField_e_of_type_Boolean));
    paramMessageRecord.saveExtInfoToExtStr("msgUniseq", String.valueOf(paramTeamWorkFileImportInfo.jdField_a_of_type_Long));
    paramMessageRecord.saveExtInfoToExtStr("nFileType", String.valueOf(paramTeamWorkFileImportInfo.jdField_e_of_type_Int));
    paramMessageRecord.saveExtInfoToExtStr("nSessionId", String.valueOf(paramTeamWorkFileImportInfo.jdField_b_of_type_Long));
    paramMessageRecord.saveExtInfoToExtStr("peerType", String.valueOf(paramTeamWorkFileImportInfo.jdField_a_of_type_Int));
    paramMessageRecord.saveExtInfoToExtStr("troopFileBusId", String.valueOf(paramTeamWorkFileImportInfo.jdField_b_of_type_Int));
    paramMessageRecord.saveExtInfoToExtStr("structUniseq", String.valueOf(paramTeamWorkFileImportInfo.jdField_e_of_type_Long));
    paramMessageRecord.saveExtInfoToExtStr("strSendUin", paramTeamWorkFileImportInfo.jdField_j_of_type_JavaLangString);
    paramMessageRecord.saveExtInfoToExtStr("import_file_message_flag", "import_file_message_flag_value");
  }
  
  private void a(AbsStructMsg paramAbsStructMsg, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString, int paramInt)
  {
    String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    int i = MobileQQService.seq;
    MobileQQService.seq = i + 1;
    long l = i;
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    String str1;
    if (TextUtils.isEmpty(paramString)) {
      str1 = str2;
    } else {
      str1 = paramString;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = MessageRecordFactory.a(localQQAppInterface, str2, paramString, str1, paramInt, l, paramAbsStructMsg);
    paramTeamWorkFileImportInfo.jdField_e_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.uniseq;
    a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing, paramTeamWorkFileImportInfo);
    paramString = this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing;
    paramString.issend = 1;
    paramString.extraflag = 32772;
    paramAbsStructMsg.addFlag(1);
    paramAbsStructMsg.addFlag(2);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing, 0);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing, str2);
    paramAbsStructMsg = (ITeamWorkFileImportHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_FILE_IMPORT_HANDLER);
    if (!TextUtils.isEmpty(paramAbsStructMsg.getUrlFromConvertedMap(paramTeamWorkFileImportInfo))) {
      paramAbsStructMsg.getUrlFromConvertedMap(paramTeamWorkFileImportInfo);
    }
    if (!paramAbsStructMsg.isFileImporting(paramTeamWorkFileImportInfo))
    {
      paramAbsStructMsg.addFileImportJob(paramTeamWorkFileImportInfo);
      paramAbsStructMsg = new StringBuilder();
      paramAbsStructMsg.append("start import file:");
      paramAbsStructMsg.append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.uniseq);
      QLog.i("TeamWorkSender", 1, paramAbsStructMsg.toString());
      if (QLog.isColorLevel())
      {
        paramAbsStructMsg = new StringBuilder();
        paramAbsStructMsg.append("start Import File: ");
        paramAbsStructMsg.append(paramTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString);
        QLog.i("TeamWorkSender", 1, paramAbsStructMsg.toString());
      }
    }
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = a(BaseActivity.sTopActivity, paramFileManagerEntity.fileName);
    paramFileManagerEntity = a(paramFileManagerEntity);
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
    if (paramString1 != null)
    {
      a(paramString1, paramFileManagerEntity, paramString2, paramInt);
      FileManagerReporter.a("0X800942C");
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    paramString2 = FileManagerUtil.a(paramString1);
    this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = a(BaseActivity.sTopActivity, paramString2);
    paramString1 = a(paramString1);
    paramString1.jdField_a_of_type_Int = paramInt;
    paramString1.jdField_a_of_type_JavaLangString = paramString3;
    paramString2 = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
    if (paramString2 != null)
    {
      a(paramString2, paramString1, paramString3, paramInt);
      FileManagerReporter.a("0X800942C");
    }
  }
  
  public boolean a(MessageForStructing paramMessageForStructing, SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = paramMessageForStructing.structingMsg;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = paramMessageForStructing;
    paramSessionInfo = a(paramMessageForStructing);
    if (paramSessionInfo == null) {
      return false;
    }
    if (paramSessionInfo.jdField_e_of_type_Long == 0L) {
      paramSessionInfo.jdField_e_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.uniseq;
    }
    ITeamWorkFileImportHandler localITeamWorkFileImportHandler = (ITeamWorkFileImportHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_FILE_IMPORT_HANDLER);
    if (!TextUtils.isEmpty(localITeamWorkFileImportHandler.getUrlFromConvertedMap(paramSessionInfo))) {
      localITeamWorkFileImportHandler.getUrlFromConvertedMap(paramSessionInfo);
    }
    if (!localITeamWorkFileImportHandler.isFileImporting(paramSessionInfo)) {
      localITeamWorkFileImportHandler.addFileImportJob(paramSessionInfo);
    }
    paramSessionInfo = new StringBuilder();
    paramSessionInfo.append("structsg resend:");
    paramSessionInfo.append(paramMessageForStructing.uniseq);
    QLog.i("TeamWorkSender", 1, paramSessionInfo.toString());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkSender
 * JD-Core Version:    0.7.0.1
 */