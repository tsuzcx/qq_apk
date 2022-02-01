package com.tencent.mobileqq.filemanager.msgbackup;

import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.api.IFMSettings;
import com.tencent.mobileqq.filemanager.api.IFileManagerUtil;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QQFileUtils;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class OfflineFileMsgBackupHandler
  extends FileMsgBackupHandler
{
  public OfflineFileMsgBackupHandler(BaseQQAppInterface paramBaseQQAppInterface)
  {
    super(paramBaseQQAppInterface);
  }
  
  private String a(FileManagerEntity paramFileManagerEntity, int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    String str = FMSettings.a().getDefaultThumbPath();
    Object localObject = new File(str);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(a(paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5, paramInt));
    paramFileManagerEntity = ((StringBuilder)localObject).toString();
    if (a(paramString, paramFileManagerEntity))
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("getThumbSavePath. thumbPath[");
        paramString.append(paramFileManagerEntity);
        paramString.append("]");
        QLog.i("OfflineFileMsgBackupHandler<QFile>", 4, paramString.toString());
      }
      return paramFileManagerEntity;
    }
    QLog.i("OfflineFileMsgBackupHandler<QFile>", 1, "getThumbSavePath. move file failed.");
    return "";
  }
  
  private String a(String paramString1, String paramString2, int paramInt)
  {
    String str2 = FMSettings.a().getDefaultThumbPath();
    String str1 = QQFileUtils.a(paramInt, com.tencent.securitysdk.utils.MD5.a(paramString1));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str2);
    localStringBuilder.append(str1);
    paramString1 = str1;
    if (!FileUtil.a(localStringBuilder.toString()))
    {
      paramString1 = str1;
      if (!TextUtils.isEmpty(paramString2)) {
        paramString1 = QQFileUtils.a(paramInt, com.tencent.securitysdk.utils.MD5.a(paramString2));
      }
    }
    return paramString1;
  }
  
  private void a(FileManagerEntity paramFileManagerEntity, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("md5"))
      {
        paramFileManagerEntity.strFileMd5 = paramString.getString("md5");
        return;
      }
      if (paramString.has("md510")) {
        paramFileManagerEntity.str10Md5 = paramString.getString("md510");
      }
      return;
    }
    catch (JSONException paramFileManagerEntity) {}
  }
  
  private boolean a(MessageRecord paramMessageRecord, List<MsgBackupResEntity> paramList)
  {
    Object localObject2 = paramMessageRecord.getExtInfoFromExtStr("_backup_ForwardUuid");
    if (paramMessageRecord.isMultiMsg) {
      localObject2 = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardUuid");
    }
    boolean bool2 = TextUtils.isEmpty((CharSequence)localObject2);
    boolean bool1 = false;
    if (bool2)
    {
      a("OfflineFileMsgBackupHandler<QFile>", "updateOfflineFileRecord", String.valueOf(paramMessageRecord.msgseq), "error. file id is null.");
      return false;
    }
    IMsgBackupTempApi localIMsgBackupTempApi = (IMsgBackupTempApi)QRoute.api(IMsgBackupTempApi.class);
    Object localObject3 = localIMsgBackupTempApi.queryFileManagerEntityByFileUuidForMemory(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, (String)localObject2);
    Object localObject1 = localObject3;
    if (localObject3 == null) {
      localObject1 = localIMsgBackupTempApi.queryEntityForDbByFileId(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, (String)localObject2);
    }
    if (localObject1 != null)
    {
      long l;
      if (paramMessageRecord.isMultiMsg)
      {
        ((FileManagerEntity)localObject1).uniseq = paramMessageRecord.uniseq;
      }
      else if (localIMsgBackupTempApi.getMessageRecord(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.shmsgseq, paramMessageRecord.msgtype) == null)
      {
        l = paramMessageRecord.msgseq;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("old msg is not exist create bind. uniseq[");
        ((StringBuilder)localObject2).append(paramMessageRecord.uniseq);
        ((StringBuilder)localObject2).append("]");
        a("OfflineFileMsgBackupHandler<QFile>", "updateOfflineFileRecord", String.valueOf(l), ((StringBuilder)localObject2).toString());
        ((FileManagerEntity)localObject1).uniseq = paramMessageRecord.uniseq;
      }
      ((FileManagerEntity)localObject1).status = -1;
      bool1 = true;
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject2 = (MsgBackupResEntity)paramList.next();
          if ((a((MsgBackupResEntity)localObject2)) && (b(paramMessageRecord, (MsgBackupResEntity)localObject2)))
          {
            localObject3 = a((MsgBackupResEntity)localObject2);
            if (!TextUtils.isEmpty((CharSequence)localObject3)) {
              if (((MsgBackupResEntity)localObject2).msgSubType == 12)
              {
                if (!FileUtils.fileExistsAndNotEmpty(((FileManagerEntity)localObject1).strLargeThumPath))
                {
                  localObject2 = a((FileManagerEntity)localObject1, 7, (String)localObject3);
                  if ((!FileUtils.fileExistsAndNotEmpty(((FileManagerEntity)localObject1).strLargeThumPath)) && (FileUtils.fileExistsAndNotEmpty((String)localObject2)))
                  {
                    ((FileManagerEntity)localObject1).strLargeThumPath = ((String)localObject2);
                    l = paramMessageRecord.msgseq;
                    localObject3 = new StringBuilder();
                    ((StringBuilder)localObject3).append("update large thumb path. path[");
                    ((StringBuilder)localObject3).append((String)localObject2);
                    ((StringBuilder)localObject3).append("]");
                    a("OfflineFileMsgBackupHandler<QFile>", "updateOfflineFileRecord", String.valueOf(l), ((StringBuilder)localObject3).toString());
                  }
                }
              }
              else if ((((MsgBackupResEntity)localObject2).msgSubType == 11) && (!FileUtils.fileExistsAndNotEmpty(((FileManagerEntity)localObject1).getFilePath())))
              {
                localObject3 = a((String)localObject3, ((FileManagerEntity)localObject1).fileName);
                if (FileUtils.fileExistsAndNotEmpty((String)localObject3))
                {
                  ((FileManagerEntity)localObject1).setFilePath((String)localObject3);
                  ((FileManagerEntity)localObject1).status = 1;
                  a((FileManagerEntity)localObject1, ((MsgBackupResEntity)localObject2).extraDataStr);
                  b((FileManagerEntity)localObject1, ((MsgBackupResEntity)localObject2).extraDataStr);
                  l = paramMessageRecord.msgseq;
                  localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append("update origin file path. path[");
                  ((StringBuilder)localObject2).append((String)localObject3);
                  ((StringBuilder)localObject2).append("]");
                  a("OfflineFileMsgBackupHandler<QFile>", "updateOfflineFileRecord", String.valueOf(l), ((StringBuilder)localObject2).toString());
                }
                else
                {
                  a("OfflineFileMsgBackupHandler<QFile>", "updateOfflineFileRecord", String.valueOf(paramMessageRecord.msgseq), "recover origin file path error. back up file path is null");
                }
              }
            }
          }
        }
      }
      localIMsgBackupTempApi.updateFileEntity(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, (FileManagerEntity)localObject1);
    }
    return bool1;
  }
  
  private void b(FileManagerEntity paramFileManagerEntity, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("sha"))
      {
        paramFileManagerEntity.strFileSHA = paramString.getString("sha");
        return;
      }
      if (paramString.has("sha3")) {
        paramFileManagerEntity.strFileSha3 = paramString.getString("sha3");
      }
      return;
    }
    catch (JSONException paramFileManagerEntity) {}
  }
  
  private void c(MessageRecord paramMessageRecord, List<MsgBackupResEntity> paramList)
  {
    long l = paramMessageRecord.msgseq;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("fileInfo[");
    ((StringBuilder)localObject1).append(paramMessageRecord.getExtInfoString());
    ((StringBuilder)localObject1).append("]");
    a("OfflineFileMsgBackupHandler<QFile>", "createOfflineFileRecord", String.valueOf(l), ((StringBuilder)localObject1).toString());
    Object localObject2;
    if (paramMessageRecord.isMultiMsg)
    {
      a("OfflineFileMsgBackupHandler<QFile>", "createOfflineFileRecord", String.valueOf(paramMessageRecord.msgseq), "create multi file info.");
      localObject1 = QQFileManagerUtil.a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, (ChatMessage)paramMessageRecord);
    }
    else
    {
      a("OfflineFileMsgBackupHandler<QFile>", "createOfflineFileRecord", String.valueOf(paramMessageRecord.msgseq), "create normal file info.");
      localObject1 = new FileManagerEntity();
      ((FileManagerEntity)localObject1).nSessionId = QQFileManagerUtil.a().longValue();
      ((FileManagerEntity)localObject1).uniseq = paramMessageRecord.uniseq;
      ((FileManagerEntity)localObject1).selfUin = paramMessageRecord.selfuin;
      ((FileManagerEntity)localObject1).isReaded = false;
      ((FileManagerEntity)localObject1).peerUin = paramMessageRecord.frienduin;
      ((FileManagerEntity)localObject1).peerType = paramMessageRecord.istroop;
      ((FileManagerEntity)localObject1).peerNick = QQFileManagerUtil.a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, ((FileManagerEntity)localObject1).peerUin, null, ((FileManagerEntity)localObject1).peerType);
      ((FileManagerEntity)localObject1).Uuid = paramMessageRecord.getExtInfoFromExtStr("_backup_ForwardUuid");
      ((FileManagerEntity)localObject1).fileName = paramMessageRecord.getExtInfoFromExtStr("_backup_ForwardFileName");
      localObject2 = paramMessageRecord.getExtInfoFromExtStr("_backup_ForwardSize");
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        ((FileManagerEntity)localObject1).fileSize = Long.parseLong((String)localObject2);
      }
      if (paramMessageRecord.isSend())
      {
        ((FileManagerEntity)localObject1).nOpType = 0;
        ((FileManagerEntity)localObject1).bSend = true;
      }
      else
      {
        ((FileManagerEntity)localObject1).nOpType = 1;
        ((FileManagerEntity)localObject1).bSend = false;
      }
      localObject2 = paramMessageRecord.getExtInfoFromExtStr("_backup_ForwardFilePath");
      if (FileUtils.fileExistsAndNotEmpty((String)localObject2))
      {
        ((FileManagerEntity)localObject1).setFilePath((String)localObject2);
        ((FileManagerEntity)localObject1).setCloudType(3);
      }
      else
      {
        ((FileManagerEntity)localObject1).setCloudType(1);
      }
      ((FileManagerEntity)localObject1).strFileMd5 = paramMessageRecord.getExtInfoFromExtStr("_backup_ForwardMd5");
      ((FileManagerEntity)localObject1).strFileSHA = paramMessageRecord.getExtInfoFromExtStr("_backup_ForwardSha");
      localObject2 = paramMessageRecord.getExtInfoFromExtStr("_backup_ForwardImgWidth");
    }
    try
    {
      ((FileManagerEntity)localObject1).imgWidth = Integer.parseInt((String)localObject2);
      localObject2 = paramMessageRecord.getExtInfoFromExtStr("_backup_ForwardImgHeight");
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      try
      {
        ((FileManagerEntity)localObject1).imgHeight = Integer.parseInt((String)localObject2);
        label390:
        if (localObject1 != null)
        {
          ((FileManagerEntity)localObject1).status = -1;
          if (TextUtils.isEmpty(((FileManagerEntity)localObject1).Uuid)) {
            ((FileManagerEntity)localObject1).status = 16;
          }
          ((FileManagerEntity)localObject1).srvTime = (paramMessageRecord.time * 1000L);
          if ((paramList != null) && (!paramList.isEmpty()))
          {
            paramList = paramList.iterator();
            while (paramList.hasNext())
            {
              localObject2 = (MsgBackupResEntity)paramList.next();
              if ((a((MsgBackupResEntity)localObject2)) && (b(paramMessageRecord, (MsgBackupResEntity)localObject2)))
              {
                Object localObject3 = a((MsgBackupResEntity)localObject2);
                if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                  if (((MsgBackupResEntity)localObject2).msgSubType == 12)
                  {
                    localObject2 = a((FileManagerEntity)localObject1, 7, (String)localObject3);
                    if (FileUtils.fileExistsAndNotEmpty((String)localObject2))
                    {
                      ((FileManagerEntity)localObject1).strLargeThumPath = ((String)localObject2);
                      l = paramMessageRecord.msgseq;
                      localObject3 = new StringBuilder();
                      ((StringBuilder)localObject3).append("save large thumb path. path[");
                      ((StringBuilder)localObject3).append((String)localObject2);
                      ((StringBuilder)localObject3).append("]");
                      a("OfflineFileMsgBackupHandler<QFile>", "createOfflineFileRecord", String.valueOf(l), ((StringBuilder)localObject3).toString());
                    }
                  }
                  else if (((MsgBackupResEntity)localObject2).msgSubType == 11)
                  {
                    localObject3 = a((String)localObject3, ((FileManagerEntity)localObject1).fileName);
                    if (FileUtils.fileExistsAndNotEmpty((String)localObject3))
                    {
                      ((FileManagerEntity)localObject1).setFilePath((String)localObject3);
                      ((FileManagerEntity)localObject1).status = 1;
                      a((FileManagerEntity)localObject1, ((MsgBackupResEntity)localObject2).extraDataStr);
                      b((FileManagerEntity)localObject1, ((MsgBackupResEntity)localObject2).extraDataStr);
                      l = paramMessageRecord.msgseq;
                      localObject2 = new StringBuilder();
                      ((StringBuilder)localObject2).append("save origin path. path[");
                      ((StringBuilder)localObject2).append((String)localObject3);
                      ((StringBuilder)localObject2).append("]");
                      a("OfflineFileMsgBackupHandler<QFile>", "createOfflineFileRecord", String.valueOf(l), ((StringBuilder)localObject2).toString());
                    }
                  }
                }
              }
            }
          }
          paramMessageRecord = (IMsgBackupTempApi)QRoute.api(IMsgBackupTempApi.class);
          paramMessageRecord.insertToMemMap(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, (FileManagerEntity)localObject1);
          paramMessageRecord.insertToFMList(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, (FileManagerEntity)localObject1);
        }
        return;
        localNumberFormatException1 = localNumberFormatException1;
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        break label390;
      }
    }
  }
  
  protected String a(MessageRecord paramMessageRecord, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("msgType", 5);
        localJSONObject.put("msgSubType", paramInt);
        Object localObject1 = ((IMsgBackupTempApi)QRoute.api(IMsgBackupTempApi.class)).queryFileEntityByUniseq(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, paramMessageRecord.uniseq, paramMessageRecord.frienduin, paramMessageRecord.istroop);
        if (localObject1 == null)
        {
          a("OfflineFileMsgBackupHandler<QFile>", "buildResourceInfo", String.valueOf(paramMessageRecord.msgseq), "file entity is null.");
          return "{}";
        }
        int i = ((FileManagerEntity)localObject1).peerType;
        paramInt = 1;
        if (i == 0)
        {
          localJSONObject.put("uint32_file_type", "1");
        }
        else if (((FileManagerEntity)localObject1).peerType == 3000)
        {
          localJSONObject.put("uint32_file_type", "2");
        }
        else if (((FileManagerEntity)localObject1).peerType == 1)
        {
          localJSONObject.put("uint32_file_type", "3");
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("buildResourceInfo: can not handle peerType[");
          ((StringBuilder)localObject2).append(((FileManagerEntity)localObject1).peerType);
          ((StringBuilder)localObject2).append("] msgInfo[");
          QLog.i("OfflineFileMsgBackupHandler<QFile>", 1, ((StringBuilder)localObject2).toString());
        }
        localJSONObject.put("uint64_sender_uin", paramMessageRecord.senderuin);
        localJSONObject.put("uint64_receiver_uin", paramMessageRecord.frienduin);
        Object localObject2 = ((FileManagerEntity)localObject1).Uuid;
        boolean bool = TextUtils.isEmpty((CharSequence)localObject2);
        StringBuilder localStringBuilder;
        if (!bool)
        {
          if (QLog.isDevelopLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("buildResourceInfo fileUuid[");
            localStringBuilder.append((String)localObject2);
            localStringBuilder.append("]");
            QLog.i("OfflineFileMsgBackupHandler<QFile>", 1, localStringBuilder.toString());
          }
          localJSONObject.put("bytes_file_uuid", localObject2);
        }
        localObject2 = ((FileManagerEntity)localObject1).fileName;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          if (QLog.isDevelopLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("buildResourceInfo fileName[");
            localStringBuilder.append((String)localObject2);
            localStringBuilder.append("]");
            QLog.i("OfflineFileMsgBackupHandler<QFile>", 1, localStringBuilder.toString());
          }
          localJSONObject.put("str_file_name", localObject2);
        }
        long l = ((FileManagerEntity)localObject1).fileSize;
        if (QLog.isDevelopLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("buildResourceInfo fileSize[");
          ((StringBuilder)localObject2).append(l);
          ((StringBuilder)localObject2).append("]");
          QLog.i("OfflineFileMsgBackupHandler<QFile>", 1, ((StringBuilder)localObject2).toString());
        }
        localJSONObject.put("uint64_file_size", l);
        localObject2 = ((FileManagerEntity)localObject1).strFileMd5;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          if (QLog.isDevelopLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("buildResourceInfo fileMd5[");
            localStringBuilder.append((String)localObject2);
            localStringBuilder.append("]");
            QLog.i("OfflineFileMsgBackupHandler<QFile>", 1, localStringBuilder.toString());
          }
          localJSONObject.put("md5", localObject2);
        }
        localObject2 = ((FileManagerEntity)localObject1).str10Md5;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          if (QLog.isDevelopLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("buildResourceInfo file10Md5[");
            localStringBuilder.append((String)localObject2);
            localStringBuilder.append("]");
            QLog.i("OfflineFileMsgBackupHandler<QFile>", 1, localStringBuilder.toString());
          }
          localJSONObject.put("md510", localObject2);
        }
        localObject2 = ((FileManagerEntity)localObject1).strFileSHA;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          if (QLog.isDevelopLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("buildResourceInfo sha[");
            localStringBuilder.append((String)localObject2);
            localStringBuilder.append("]");
            QLog.i("OfflineFileMsgBackupHandler<QFile>", 1, localStringBuilder.toString());
          }
          localJSONObject.put("sha", localObject2);
        }
        localObject2 = ((FileManagerEntity)localObject1).strFileSha3;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          if (QLog.isDevelopLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("buildResourceInfo sha3[");
            localStringBuilder.append((String)localObject2);
            localStringBuilder.append("]");
            QLog.i("OfflineFileMsgBackupHandler<QFile>", 1, localStringBuilder.toString());
          }
          localJSONObject.put("sha3", localObject2);
        }
        i = ((FileManagerEntity)localObject1).imgWidth;
        if (i != 0)
        {
          if (QLog.isDevelopLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("buildResourceInfo imgWidth[");
            ((StringBuilder)localObject2).append(i);
            ((StringBuilder)localObject2).append("]");
            QLog.i("OfflineFileMsgBackupHandler<QFile>", 1, ((StringBuilder)localObject2).toString());
          }
          localJSONObject.put("uint32_img_width", i);
        }
        i = ((FileManagerEntity)localObject1).imgHeight;
        if (i != 0)
        {
          if (QLog.isDevelopLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("buildResourceInfo imgWidth[");
            ((StringBuilder)localObject1).append(i);
            ((StringBuilder)localObject1).append("]");
            QLog.i("OfflineFileMsgBackupHandler<QFile>", 1, ((StringBuilder)localObject1).toString());
          }
          localJSONObject.put("uint32_img_height", i);
        }
        if (paramMessageRecord.isMultiMsg)
        {
          localJSONObject.put("nest_forward", paramInt);
          paramMessageRecord = localJSONObject.toString();
          return paramMessageRecord;
        }
      }
      catch (JSONException paramMessageRecord)
      {
        return "{}";
      }
      paramInt = 0;
    }
  }
  
  public String a(MsgBackupResEntity paramMsgBackupResEntity)
  {
    Object localObject3 = a(paramMsgBackupResEntity.extraDataStr);
    Object localObject2;
    Object localObject1;
    if (paramMsgBackupResEntity.msgSubType == 12)
    {
      localObject2 = (String)((HashMap)localObject3).get("md5");
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = (String)((HashMap)localObject3).get("md510");
      }
      localObject2 = (String)((HashMap)localObject3).get("bytes_file_uuid");
      if (QLog.isDebugVersion())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("getTempFilePath: md5[");
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append("] fileId[");
        ((StringBuilder)localObject3).append((String)localObject2);
        ((StringBuilder)localObject3).append("]");
        QLog.i("<QFile_Backup>", 1, ((StringBuilder)localObject3).toString());
      }
      localObject1 = a((String)localObject2, (String)localObject1, 7);
      localObject2 = jdField_a_of_type_JavaLangString;
    }
    else if (paramMsgBackupResEntity.msgSubType == 11)
    {
      localObject1 = (String)((HashMap)localObject3).get("str_file_name");
      if (QLog.isDebugVersion())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getTempFilePath: offline fileName[");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("]");
        QLog.i("<QFile_Backup>", 1, ((StringBuilder)localObject2).toString());
      }
      localObject2 = (String)((HashMap)localObject3).get("bytes_file_uuid");
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append((String)localObject2);
      localObject1 = com.tencent.qphone.base.util.MD5.toMD5(((StringBuilder)localObject3).toString());
      if (QLog.isDebugVersion())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getTempFilePath: offline temp msg backup fileName[");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("]");
        QLog.i("<QFile_Backup>", 1, ((StringBuilder)localObject2).toString());
      }
      localObject2 = b;
    }
    else
    {
      localObject1 = "";
      localObject2 = localObject1;
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("resType[");
    ((StringBuilder)localObject3).append(paramMsgBackupResEntity.msgType);
    ((StringBuilder)localObject3).append("] tempPath[");
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append("]");
    a("OfflineFileMsgBackupHandler<QFile>", "getTempFilePath", "", ((StringBuilder)localObject3).toString());
    paramMsgBackupResEntity = new StringBuilder();
    paramMsgBackupResEntity.append((String)localObject2);
    paramMsgBackupResEntity.append((String)localObject1);
    return paramMsgBackupResEntity.toString();
  }
  
  public void a(MessageRecord paramMessageRecord, List<MsgBackupResEntity> paramList)
  {
    Object localObject1;
    if (QLog.isDebugVersion())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Export: type[offline] contactUin[");
      ((StringBuilder)localObject1).append(paramMessageRecord.frienduin);
      ((StringBuilder)localObject1).append("] senderUin[");
      ((StringBuilder)localObject1).append(paramMessageRecord.senderuin);
      ((StringBuilder)localObject1).append("] uniSeq[");
      ((StringBuilder)localObject1).append(paramMessageRecord.uniseq);
      ((StringBuilder)localObject1).append("] msgSeq[");
      ((StringBuilder)localObject1).append(paramMessageRecord.msgseq);
      ((StringBuilder)localObject1).append("]");
      QLog.i("<QFile_Backup>", 1, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = (IMsgBackupTempApi)QRoute.api(IMsgBackupTempApi.class);
    if (paramMessageRecord.isMultiMsg)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Export: handle a multi mr. msgSeq[");
      ((StringBuilder)localObject1).append(paramMessageRecord.msgseq);
      ((StringBuilder)localObject1).append("]");
      QLog.i("<QFile_Backup>", 1, ((StringBuilder)localObject1).toString());
      localObject1 = ((IMsgBackupTempApi)localObject2).changeRealChatMessage((ChatMessage)paramMessageRecord);
    }
    else
    {
      localObject1 = paramMessageRecord;
    }
    localObject2 = ((IMsgBackupTempApi)localObject2).queryFileEntityByUniseq(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, ((MessageRecord)localObject1).uniseq, ((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).istroop);
    if (localObject2 == null)
    {
      QLog.i("OfflineFileMsgBackupHandler<QFile>", 1, "handleExport: get offline file entity null. ");
      return;
    }
    int i = ((IFileManagerUtil)QRoute.api(IFileManagerUtil.class)).getFileType(((FileManagerEntity)localObject2).fileName);
    long l;
    if ((i == 0) || (i == 2))
    {
      Object localObject3 = ((FileManagerEntity)localObject2).strLargeThumPath;
      if (FileUtils.fileExistsAndNotEmpty((String)localObject3))
      {
        localObject3 = a(paramMessageRecord, 12, (String)localObject3);
        paramList.add(localObject3);
        l = paramMessageRecord.msgseq;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("add resource. resType[");
        localStringBuilder.append(((MsgBackupResEntity)localObject3).msgType);
        localStringBuilder.append("]");
        a("OfflineFileMsgBackupHandler<QFile>", "handleExport", String.valueOf(l), localStringBuilder.toString());
      }
    }
    localObject2 = ((FileManagerEntity)localObject2).getFilePath();
    if (FileUtils.fileExistsAndNotEmpty((String)localObject2))
    {
      localObject2 = a(paramMessageRecord, 11, (String)localObject2);
      paramList.add(localObject2);
      l = paramMessageRecord.msgseq;
      paramMessageRecord = new StringBuilder();
      paramMessageRecord.append("add resource. resType[");
      paramMessageRecord.append(((MsgBackupResEntity)localObject2).msgType);
      paramMessageRecord.append("]");
      a("OfflineFileMsgBackupHandler<QFile>", "handleExport", String.valueOf(l), paramMessageRecord.toString());
    }
    if ((QLog.isDebugVersion()) && (paramList != null))
    {
      paramMessageRecord = new StringBuilder();
      paramMessageRecord.append("Export --step: msgSeq[");
      paramMessageRecord.append(((MessageRecord)localObject1).msgseq);
      paramMessageRecord.append("resourceSize[");
      paramMessageRecord.append(paramList.size());
      paramMessageRecord.append("]");
      QLog.i("<QFile_Backup>", 1, paramMessageRecord.toString());
      paramMessageRecord = paramList.iterator();
      while (paramMessageRecord.hasNext())
      {
        paramList = (MsgBackupResEntity)paramMessageRecord.next();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Export --step: backup entity [");
        ((StringBuilder)localObject1).append(paramList.toLogString());
        ((StringBuilder)localObject1).append("]");
        QLog.i("<QFile_Backup>", 1, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  public boolean a(MessageRecord paramMessageRecord, MsgBackupResEntity paramMsgBackupResEntity)
  {
    boolean bool = false;
    if (paramMsgBackupResEntity == null) {
      return false;
    }
    paramMessageRecord = (String)a(paramMsgBackupResEntity.extraDataStr).get("bytes_file_uuid");
    if (TextUtils.isEmpty(paramMessageRecord))
    {
      QLog.i("<QFile_Backup>", 1, "checkNeedDownloadRes: offline fileId is null");
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkNeedDownloadRes: offline fileId[");
    localStringBuilder.append(paramMessageRecord);
    localStringBuilder.append("]");
    QLog.i("<QFile_Backup>", 1, localStringBuilder.toString());
    paramMessageRecord = ((IMsgBackupTempApi)QRoute.api(IMsgBackupTempApi.class)).queryEntityForDbByFileId(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, paramMessageRecord);
    if (paramMessageRecord == null) {
      return true;
    }
    if (paramMsgBackupResEntity.msgSubType == 12)
    {
      bool = FileUtils.fileExistsAndNotEmpty(paramMessageRecord.strLargeThumPath);
      paramMessageRecord = new StringBuilder();
      paramMessageRecord.append("checkNeedDownloadRes: offline large thumb exist[");
      paramMessageRecord.append(bool);
      paramMessageRecord.append("]");
      QLog.i("<QFile_Backup>", 1, paramMessageRecord.toString());
      return bool ^ true;
    }
    if (paramMsgBackupResEntity.msgSubType == 11)
    {
      bool = FileUtils.fileExistsAndNotEmpty(paramMessageRecord.getFilePath());
      paramMessageRecord = new StringBuilder();
      paramMessageRecord.append("checkNeedDownloadRes: offline origin file exist[");
      paramMessageRecord.append(bool);
      paramMessageRecord.append("]");
      QLog.i("<QFile_Backup>", 1, paramMessageRecord.toString());
      bool ^= true;
    }
    return bool;
  }
  
  public void b(MessageRecord paramMessageRecord, List<MsgBackupResEntity> paramList)
  {
    if (QLog.isDebugVersion())
    {
      QLog.i("<QFile_Backup>", 1, "Import: type[offline]");
      if (paramList != null)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Import --step: msgSeq[");
        ((StringBuilder)localObject).append(paramMessageRecord.msgseq);
        ((StringBuilder)localObject).append("resourceSize[");
        ((StringBuilder)localObject).append(paramList.size());
        ((StringBuilder)localObject).append("]");
        QLog.i("<QFile_Backup>", 1, ((StringBuilder)localObject).toString());
        localObject = paramList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          MsgBackupResEntity localMsgBackupResEntity = (MsgBackupResEntity)((Iterator)localObject).next();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Import --step: backup entity [");
          localStringBuilder.append(localMsgBackupResEntity.toLogString());
          localStringBuilder.append("]");
          QLog.i("<QFile_Backup>", 1, localStringBuilder.toString());
        }
      }
    }
    if (a(paramMessageRecord, paramList))
    {
      a("OfflineFileMsgBackupHandler<QFile>", "handleImport", String.valueOf(paramMessageRecord.msgseq), "update offline file record.");
    }
    else
    {
      c(paramMessageRecord, paramList);
      a("OfflineFileMsgBackupHandler<QFile>", "handleImport", String.valueOf(paramMessageRecord.msgseq), "create offline file record.");
    }
    a(paramMessageRecord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.msgbackup.OfflineFileMsgBackupHandler
 * JD-Core Version:    0.7.0.1
 */