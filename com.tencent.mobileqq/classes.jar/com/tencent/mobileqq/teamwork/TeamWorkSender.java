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
  private QQAppInterface a;
  private TeamWorkFileImportObserver b;
  private AbsStructMsg c;
  private MessageForStructing d;
  
  public TeamWorkSender(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    a();
    this.a.addObserver(this.b);
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
      paramString = HardCodeUtil.a(2131912108);
      str = "https://pub.idqqimg.com/pc/misc/files/20180403/29c998e16c094b10a96b3e0d1589c2f6.png";
    }
    else
    {
      paramString = HardCodeUtil.a(2131912104);
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
    localIntent.putExtra("app_name", HardCodeUtil.a(2131912127));
    localIntent.putExtra("brief_key", paramContext.getString(2131894173, new Object[] { localObject1 }));
    return StructMsgFactory.a(localIntent.getExtras());
  }
  
  private TeamWorkFileImportInfo a(MessageRecord paramMessageRecord)
  {
    try
    {
      TeamWorkFileImportInfo localTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
      localTeamWorkFileImportInfo.c = paramMessageRecord.getExtInfoFromExtStr("fileName");
      QLog.i("TeamWorkSender", 1, "dmytest");
      localTeamWorkFileImportInfo.d = paramMessageRecord.getExtInfoFromExtStr("filePath");
      localTeamWorkFileImportInfo.b = paramMessageRecord.getExtInfoFromExtStr("peerUin");
      localTeamWorkFileImportInfo.g = paramMessageRecord.getExtInfoFromExtStr("troopFilePath");
      localTeamWorkFileImportInfo.j = paramMessageRecord.getExtInfoFromExtStr("troopUin");
      localTeamWorkFileImportInfo.n = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("entranceFrom"));
      localTeamWorkFileImportInfo.J = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("fileImportType"));
      localTeamWorkFileImportInfo.K = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("fileSize"));
      localTeamWorkFileImportInfo.o = Boolean.parseBoolean(paramMessageRecord.getExtInfoFromExtStr("isFromAIO"));
      localTeamWorkFileImportInfo.s = Boolean.parseBoolean(paramMessageRecord.getExtInfoFromExtStr("isMessageConvert"));
      localTeamWorkFileImportInfo.m = Boolean.parseBoolean(paramMessageRecord.getExtInfoFromExtStr("isNeedDownLoadUrl"));
      localTeamWorkFileImportInfo.q = Boolean.parseBoolean(paramMessageRecord.getExtInfoFromExtStr("isOpenTeamWork"));
      localTeamWorkFileImportInfo.r = Boolean.parseBoolean(paramMessageRecord.getExtInfoFromExtStr("isUserClick"));
      localTeamWorkFileImportInfo.e = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("msgUniseq"));
      localTeamWorkFileImportInfo.u = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("nFileType"));
      localTeamWorkFileImportInfo.f = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("nSessionId"));
      localTeamWorkFileImportInfo.a = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("peerType"));
      localTeamWorkFileImportInfo.h = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("troopFileBusId"));
      localTeamWorkFileImportInfo.L = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("structUniseq"));
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
    localTeamWorkFileImportInfo.d = paramFileManagerEntity.getFilePath();
    localTeamWorkFileImportInfo.c = paramFileManagerEntity.fileName;
    localTeamWorkFileImportInfo.u = paramFileManagerEntity.nFileType;
    localTeamWorkFileImportInfo.o = false;
    localTeamWorkFileImportInfo.n = 4;
    localTeamWorkFileImportInfo.K = paramFileManagerEntity.fileSize;
    localTeamWorkFileImportInfo.a = paramFileManagerEntity.peerType;
    localTeamWorkFileImportInfo.b = paramFileManagerEntity.peerUin;
    localTeamWorkFileImportInfo.j = String.valueOf(paramFileManagerEntity.TroopUin);
    localTeamWorkFileImportInfo.h = paramFileManagerEntity.busId;
    localTeamWorkFileImportInfo.g = paramFileManagerEntity.strTroopFilePath;
    localTeamWorkFileImportInfo.e = paramFileManagerEntity.uniseq;
    if (paramFileManagerEntity.status != 16) {
      localTeamWorkFileImportInfo.m = true;
    }
    return localTeamWorkFileImportInfo;
  }
  
  private TeamWorkFileImportInfo a(String paramString)
  {
    TeamWorkFileImportInfo localTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
    localTeamWorkFileImportInfo.d = paramString;
    localTeamWorkFileImportInfo.c = FileManagerUtil.a(paramString);
    localTeamWorkFileImportInfo.u = FileManagerUtil.c(paramString);
    localTeamWorkFileImportInfo.o = false;
    localTeamWorkFileImportInfo.n = 4;
    localTeamWorkFileImportInfo.K = FileManagerUtil.h(paramString);
    localTeamWorkFileImportInfo.m = false;
    return localTeamWorkFileImportInfo;
  }
  
  private String a(int paramInt)
  {
    HardCodeUtil.a(2131912106);
    switch (paramInt)
    {
    case -109: 
    case -105: 
    case -104: 
    default: 
      return HardCodeUtil.a(2131912082);
    case -102: 
    case -101: 
    case -100: 
      return HardCodeUtil.a(2131912072);
    case -103: 
      return HardCodeUtil.a(2131912102);
    case -107: 
      return HardCodeUtil.a(2131912064);
    case -108: 
      return HardCodeUtil.a(2131912116);
    case -110: 
      return HardCodeUtil.a(2131912103);
    case -111: 
      return HardCodeUtil.a(2131912085);
    case -114: 
      return HardCodeUtil.a(2131912125);
    case -115: 
    case -113: 
    case -112: 
      return HardCodeUtil.a(2131912069);
    }
    return HardCodeUtil.a(2131912100);
  }
  
  private void a()
  {
    this.b = new TeamWorkSender.1(this);
  }
  
  private void a(MessageRecord paramMessageRecord, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    paramMessageRecord.saveExtInfoToExtStr("fileName", paramTeamWorkFileImportInfo.c);
    paramMessageRecord.saveExtInfoToExtStr("filePath", paramTeamWorkFileImportInfo.d);
    paramMessageRecord.saveExtInfoToExtStr("peerUin", paramTeamWorkFileImportInfo.b);
    String str;
    if (paramTeamWorkFileImportInfo.g != null) {
      str = paramTeamWorkFileImportInfo.g;
    } else {
      str = "";
    }
    paramMessageRecord.saveExtInfoToExtStr("troopFilePath", str);
    paramMessageRecord.saveExtInfoToExtStr("troopUin", paramTeamWorkFileImportInfo.j);
    paramMessageRecord.saveExtInfoToExtStr("entranceFrom", String.valueOf(paramTeamWorkFileImportInfo.n));
    paramMessageRecord.saveExtInfoToExtStr("fileImportType", String.valueOf(paramTeamWorkFileImportInfo.J));
    paramMessageRecord.saveExtInfoToExtStr("fileSize", String.valueOf(paramTeamWorkFileImportInfo.K));
    paramMessageRecord.saveExtInfoToExtStr("isFromAIO", String.valueOf(paramTeamWorkFileImportInfo.o));
    paramMessageRecord.saveExtInfoToExtStr("isMessageConvert", String.valueOf(paramTeamWorkFileImportInfo.s));
    paramMessageRecord.saveExtInfoToExtStr("isNeedDownLoadUrl", String.valueOf(paramTeamWorkFileImportInfo.m));
    paramMessageRecord.saveExtInfoToExtStr("isOpenTeamWork", String.valueOf(paramTeamWorkFileImportInfo.q));
    paramMessageRecord.saveExtInfoToExtStr("isUserClick", String.valueOf(paramTeamWorkFileImportInfo.r));
    paramMessageRecord.saveExtInfoToExtStr("msgUniseq", String.valueOf(paramTeamWorkFileImportInfo.e));
    paramMessageRecord.saveExtInfoToExtStr("nFileType", String.valueOf(paramTeamWorkFileImportInfo.u));
    paramMessageRecord.saveExtInfoToExtStr("nSessionId", String.valueOf(paramTeamWorkFileImportInfo.f));
    paramMessageRecord.saveExtInfoToExtStr("peerType", String.valueOf(paramTeamWorkFileImportInfo.a));
    paramMessageRecord.saveExtInfoToExtStr("troopFileBusId", String.valueOf(paramTeamWorkFileImportInfo.h));
    paramMessageRecord.saveExtInfoToExtStr("structUniseq", String.valueOf(paramTeamWorkFileImportInfo.L));
    paramMessageRecord.saveExtInfoToExtStr("strSendUin", paramTeamWorkFileImportInfo.z);
    paramMessageRecord.saveExtInfoToExtStr("import_file_message_flag", "import_file_message_flag_value");
  }
  
  private void a(AbsStructMsg paramAbsStructMsg, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString, int paramInt)
  {
    String str2 = this.a.getCurrentAccountUin();
    int i = MobileQQService.seq;
    MobileQQService.seq = i + 1;
    long l = i;
    QQAppInterface localQQAppInterface = this.a;
    String str1;
    if (TextUtils.isEmpty(paramString)) {
      str1 = str2;
    } else {
      str1 = paramString;
    }
    this.d = MessageRecordFactory.c(localQQAppInterface, str2, paramString, str1, paramInt, l, paramAbsStructMsg);
    paramTeamWorkFileImportInfo.L = this.d.uniseq;
    a(this.d, paramTeamWorkFileImportInfo);
    paramString = this.d;
    paramString.issend = 1;
    paramString.extraflag = 32772;
    paramAbsStructMsg.addFlag(1);
    paramAbsStructMsg.addFlag(2);
    this.a.getMsgCache().a(this.d, 0);
    this.a.getMessageFacade().a(this.d, str2);
    paramAbsStructMsg = (ITeamWorkFileImportHandler)this.a.getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_FILE_IMPORT_HANDLER);
    if (!TextUtils.isEmpty(paramAbsStructMsg.getUrlFromConvertedMap(paramTeamWorkFileImportInfo))) {
      paramAbsStructMsg.getUrlFromConvertedMap(paramTeamWorkFileImportInfo);
    }
    if (!paramAbsStructMsg.isFileImporting(paramTeamWorkFileImportInfo))
    {
      paramAbsStructMsg.addFileImportJob(paramTeamWorkFileImportInfo);
      paramAbsStructMsg = new StringBuilder();
      paramAbsStructMsg.append("start import file:");
      paramAbsStructMsg.append(this.d.uniseq);
      QLog.i("TeamWorkSender", 1, paramAbsStructMsg.toString());
      if (QLog.isColorLevel())
      {
        paramAbsStructMsg = new StringBuilder();
        paramAbsStructMsg.append("start Import File: ");
        paramAbsStructMsg.append(paramTeamWorkFileImportInfo.c);
        QLog.i("TeamWorkSender", 1, paramAbsStructMsg.toString());
      }
    }
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2, int paramInt)
  {
    this.c = a(BaseActivity.sTopActivity, paramFileManagerEntity.fileName);
    paramFileManagerEntity = a(paramFileManagerEntity);
    paramString1 = this.c;
    if (paramString1 != null)
    {
      a(paramString1, paramFileManagerEntity, paramString2, paramInt);
      FileManagerReporter.a("0X800942C");
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    paramString2 = FileManagerUtil.a(paramString1);
    this.c = a(BaseActivity.sTopActivity, paramString2);
    paramString1 = a(paramString1);
    paramString1.a = paramInt;
    paramString1.b = paramString3;
    paramString2 = this.c;
    if (paramString2 != null)
    {
      a(paramString2, paramString1, paramString3, paramInt);
      FileManagerReporter.a("0X800942C");
    }
  }
  
  public boolean a(MessageForStructing paramMessageForStructing, SessionInfo paramSessionInfo)
  {
    this.c = paramMessageForStructing.structingMsg;
    this.d = paramMessageForStructing;
    paramSessionInfo = a(paramMessageForStructing);
    if (paramSessionInfo == null) {
      return false;
    }
    if (paramSessionInfo.L == 0L) {
      paramSessionInfo.L = this.c.uniseq;
    }
    ITeamWorkFileImportHandler localITeamWorkFileImportHandler = (ITeamWorkFileImportHandler)this.a.getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_FILE_IMPORT_HANDLER);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkSender
 * JD-Core Version:    0.7.0.1
 */