package com.tencent.mobileqq.filemanager.msgbackup;

import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopFileMsgBackupHandler
  extends FileMsgBackupHandler
{
  public TroopFileMsgBackupHandler(BaseQQAppInterface paramBaseQQAppInterface)
  {
    super(paramBaseQQAppInterface);
  }
  
  private String a(long paramLong, String paramString1, String paramString2, int paramInt)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return "";
    }
    paramString2 = ((IMsgBackupTempApi)QRoute.api(IMsgBackupTempApi.class)).getTroopThumbnailFilePath(paramLong, paramInt, paramString2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_FILE_SAVE_TROOPTMP_PATH);
    localStringBuilder.append(paramString2);
    paramString2 = localStringBuilder.toString();
    if (b(paramString1, paramString2))
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("getThumbSavePath. thumbPath[");
        paramString1.append(paramString2);
        paramString1.append("]");
        QLog.i("TroopFileMsgBackupHandler<QFile>", 4, paramString1.toString());
      }
      return paramString2;
    }
    QLog.i("TroopFileMsgBackupHandler<QFile>", 1, "getThumbSavePath. move file failed.");
    return "";
  }
  
  private boolean c(MessageRecord paramMessageRecord, List<MsgBackupResEntity> paramList)
  {
    if (paramMessageRecord == null)
    {
      QLog.e("TroopFileMsgBackupHandler<QFile>", 1, "updateTroopFileRecord: get updateTroopFileRecord failed. get troop file msg is null.");
      return false;
    }
    IMsgBackupTempApi localIMsgBackupTempApi = (IMsgBackupTempApi)QRoute.api(IMsgBackupTempApi.class);
    MessageForTroopFile localMessageForTroopFile;
    if (paramMessageRecord.isMultiMsg) {
      localMessageForTroopFile = (MessageForTroopFile)localIMsgBackupTempApi.changeRealChatMessage((ChatMessage)paramMessageRecord);
    } else {
      localMessageForTroopFile = (MessageForTroopFile)paramMessageRecord;
    }
    if (localIMsgBackupTempApi.isNeedHandleTroopFileRecord(this.c, localMessageForTroopFile))
    {
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        Iterator localIterator = paramList.iterator();
        String str = "";
        paramList = str;
        while (localIterator.hasNext())
        {
          MsgBackupResEntity localMsgBackupResEntity = (MsgBackupResEntity)localIterator.next();
          if ((b(localMsgBackupResEntity)) && (b(paramMessageRecord, localMsgBackupResEntity)))
          {
            Object localObject = a(localMsgBackupResEntity);
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              if (localMsgBackupResEntity.msgSubType == 12)
              {
                if (!FileUtils.fileExistsAndNotEmpty(localIMsgBackupTempApi.getLargeThumbPath2(this.c, localMessageForTroopFile.frienduin, localMessageForTroopFile))) {
                  try
                  {
                    long l = Long.parseLong(localMessageForTroopFile.frienduin);
                    str = a(l, (String)localObject, localIMsgBackupTempApi.getTroopFileItemId(this.c, localMessageForTroopFile), 640);
                  }
                  catch (Exception localException)
                  {
                    localObject = new StringBuilder();
                    ((StringBuilder)localObject).append("updateTroopFileRecord: troopUin exception. ");
                    ((StringBuilder)localObject).append(localException);
                    QLog.i("TroopFileMsgBackupHandler<QFile>", 1, ((StringBuilder)localObject).toString());
                  }
                }
              }
              else if ((localException.msgSubType == 11) && (!FileUtils.fileExistsAndNotEmpty(localIMsgBackupTempApi.getLocalFilePath2(this.c, localMessageForTroopFile.frienduin, localMessageForTroopFile)))) {
                paramList = a((String)localObject, localIMsgBackupTempApi.getTroopFileItemFileName(this.c, localMessageForTroopFile));
              }
            }
          }
        }
        if (FileUtils.fileExistsAndNotEmpty(paramList)) {
          localIMsgBackupTempApi.saveItemRawPath(this.c, localMessageForTroopFile, paramList);
        }
        if (FileUtils.fileExistsAndNotEmpty(str)) {
          localIMsgBackupTempApi.saveItemLargeThrumbPath(this.c, localMessageForTroopFile, str);
        }
      }
      return true;
    }
    return false;
  }
  
  private void d(MessageRecord paramMessageRecord, List<MsgBackupResEntity> paramList)
  {
    if (paramMessageRecord == null)
    {
      QLog.e("TroopFileMsgBackupHandler<QFile>", 1, "createTroopFileRecord: failed. get troop file msg is null.");
      return;
    }
    IMsgBackupTempApi localIMsgBackupTempApi = (IMsgBackupTempApi)QRoute.api(IMsgBackupTempApi.class);
    MessageForTroopFile localMessageForTroopFile;
    if (paramMessageRecord.isMultiMsg) {
      localMessageForTroopFile = (MessageForTroopFile)localIMsgBackupTempApi.changeRealChatMessage((ChatMessage)paramMessageRecord);
    } else {
      localMessageForTroopFile = (MessageForTroopFile)paramMessageRecord;
    }
    long l = Long.parseLong(localMessageForTroopFile.frienduin);
    if ((localIMsgBackupTempApi.isNeedHandleCreateTroopFileInfo(this.c, l, localMessageForTroopFile)) && (paramList != null) && (!paramList.isEmpty()))
    {
      Iterator localIterator = paramList.iterator();
      String str1 = "";
      paramList = "";
      while (localIterator.hasNext())
      {
        MsgBackupResEntity localMsgBackupResEntity = (MsgBackupResEntity)localIterator.next();
        if ((b(localMsgBackupResEntity)) && (b(paramMessageRecord, localMsgBackupResEntity)))
        {
          String str2 = a(localMsgBackupResEntity);
          if (!TextUtils.isEmpty(str2)) {
            if (localMsgBackupResEntity.msgSubType == 12) {
              paramList = a(l, str2, UUID.nameUUIDFromBytes(localIMsgBackupTempApi.getFileIdByte(this.c, l, localMessageForTroopFile)).toString(), 640);
            } else if (localMsgBackupResEntity.msgSubType == 11) {
              str1 = a(str2, localIMsgBackupTempApi.getCreateFileName(this.c, l, localMessageForTroopFile));
            }
          }
        }
      }
      localIMsgBackupTempApi.saveTroopFileInfo(this.c, l, localMessageForTroopFile, str1, paramList);
    }
  }
  
  protected String a(MessageRecord paramMessageRecord, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("msgType", 5);
      localJSONObject.put("msgSubType", paramInt);
      Object localObject1 = (MessageForTroopFile)paramMessageRecord;
      boolean bool = QLog.isDevelopLevel();
      paramInt = 1;
      if (bool)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("buildResourceInfo fileType[");
        ((StringBuilder)localObject2).append(3);
        ((StringBuilder)localObject2).append("]");
        QLog.i("TroopFileMsgBackupHandler<QFile>", 1, ((StringBuilder)localObject2).toString());
      }
      localJSONObject.put("uint32_file_type", 3);
      localJSONObject.put("uint64_sender_uin", paramMessageRecord.senderuin);
      localJSONObject.put("uint64_receiver_uin", paramMessageRecord.frienduin);
      Object localObject2 = ((MessageForTroopFile)localObject1).url;
      StringBuilder localStringBuilder;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        if (QLog.isDevelopLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("buildResourceInfo fileUuid[");
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append("]");
          QLog.i("TroopFileMsgBackupHandler<QFile>", 1, localStringBuilder.toString());
        }
        localJSONObject.put("bytes_file_uuid", localObject2);
      }
      localObject2 = ((MessageForTroopFile)localObject1).fileName;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        if (QLog.isDevelopLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("buildResourceInfo fileName[");
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append("]");
          QLog.i("TroopFileMsgBackupHandler<QFile>", 1, localStringBuilder.toString());
        }
        localJSONObject.put("str_file_name", localObject2);
      }
      long l = ((MessageForTroopFile)localObject1).fileSize;
      if (QLog.isDevelopLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("buildResourceInfo fileSize[");
        ((StringBuilder)localObject2).append(l);
        ((StringBuilder)localObject2).append("]");
        QLog.i("TroopFileMsgBackupHandler<QFile>", 1, ((StringBuilder)localObject2).toString());
      }
      localJSONObject.put("uint64_file_size", l);
      localObject2 = ((MessageForTroopFile)localObject1).sha1;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        if (QLog.isDevelopLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("buildResourceInfo strSHA1[");
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append("]");
          QLog.i("TroopFileMsgBackupHandler<QFile>", 1, localStringBuilder.toString());
        }
        localJSONObject.put("sha", localObject2);
      }
      int i = ((MessageForTroopFile)localObject1).width;
      if (i != 0)
      {
        if (QLog.isDevelopLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("buildResourceInfo imgWidth[");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append("]");
          QLog.i("TroopFileMsgBackupHandler<QFile>", 1, ((StringBuilder)localObject2).toString());
        }
        localJSONObject.put("uint32_img_width", i);
      }
      i = ((MessageForTroopFile)localObject1).height;
      if (i != 0)
      {
        if (QLog.isDevelopLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("buildResourceInfo imgHeight[");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append("]");
          QLog.i("TroopFileMsgBackupHandler<QFile>", 1, ((StringBuilder)localObject2).toString());
        }
        localJSONObject.put("uint32_img_height", i);
      }
      localObject2 = (IMsgBackupTempApi)QRoute.api(IMsgBackupTempApi.class);
      i = ((IMsgBackupTempApi)localObject2).getFileImageWidth(this.c, (MessageForTroopFile)localObject1);
      int j = ((IMsgBackupTempApi)localObject2).getFileImageHeight(this.c, (MessageForTroopFile)localObject1);
      if ((i > 0) && (j > 0))
      {
        localJSONObject.put("uint32_img_width", i);
        localJSONObject.put("uint32_img_height", j);
      }
      l = ((MessageForTroopFile)localObject1).lastTime;
      if (l != 0L)
      {
        if (QLog.isDevelopLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("buildResourceInfo deadTime[");
          ((StringBuilder)localObject2).append(l);
          ((StringBuilder)localObject2).append("]");
          QLog.i("TroopFileMsgBackupHandler<QFile>", 1, ((StringBuilder)localObject2).toString());
        }
        localJSONObject.put("int64_dead_time", l);
      }
      l = ((MessageForTroopFile)localObject1).duration;
      if (l != 0L)
      {
        if (QLog.isDevelopLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("buildResourceInfo videoDur[");
          ((StringBuilder)localObject2).append(l);
          ((StringBuilder)localObject2).append("]");
          QLog.i("TroopFileMsgBackupHandler<QFile>", 1, ((StringBuilder)localObject2).toString());
        }
        localJSONObject.put("uint64_video_duration", l);
      }
      i = ((MessageForTroopFile)localObject1).bisID;
      if (i != 0)
      {
        if (QLog.isDevelopLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("buildResourceInfo bizId[");
          ((StringBuilder)localObject1).append(i);
          ((StringBuilder)localObject1).append("]");
          QLog.i("TroopFileMsgBackupHandler<QFile>", 1, ((StringBuilder)localObject1).toString());
        }
        localJSONObject.put("uint32_bus_id", i);
      }
      if (!paramMessageRecord.isMultiMsg) {
        break label887;
      }
    }
    catch (JSONException paramMessageRecord)
    {
      for (;;)
      {
        continue;
        paramInt = 0;
      }
    }
    localJSONObject.put("nest_forward", paramInt);
    paramMessageRecord = localJSONObject.toString();
    return paramMessageRecord;
    return "{}";
  }
  
  public String a(MsgBackupResEntity paramMsgBackupResEntity)
  {
    Object localObject1 = a(paramMsgBackupResEntity.extraDataStr);
    Object localObject2 = (IMsgBackupTempApi)QRoute.api(IMsgBackupTempApi.class);
    if (paramMsgBackupResEntity.msgSubType == 12)
    {
      localObject3 = (String)((HashMap)localObject1).get("uint64_receiver_uin");
      long l = 0L;
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        l = Long.parseLong((String)localObject3);
      } else {
        QLog.i("<QFile_Backup>", 1, "getTempFilePath: troop file uin is null");
      }
      localObject1 = (String)((HashMap)localObject1).get("bytes_file_uuid");
      if (QLog.isDebugVersion())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getTempFilePath: troop file uin[");
        localStringBuilder.append((String)localObject3);
        localStringBuilder.append("] fileId[");
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append("]");
        QLog.i("<QFile_Backup>", 1, localStringBuilder.toString());
      }
      localObject1 = ((IMsgBackupTempApi)localObject2).getTroopThumbnailFile(l, (String)localObject1);
      localObject2 = a;
    }
    else if (paramMsgBackupResEntity.msgSubType == 11)
    {
      localObject2 = (String)((HashMap)localObject1).get("str_file_name");
      if (QLog.isDebugVersion())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("getTempFilePath: troop fileName[");
        ((StringBuilder)localObject3).append((String)localObject2);
        ((StringBuilder)localObject3).append("]");
        QLog.i("<QFile_Backup>", 1, ((StringBuilder)localObject3).toString());
      }
      localObject1 = (String)((HashMap)localObject1).get("bytes_file_uuid");
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append((String)localObject1);
      localObject1 = MD5.toMD5(((StringBuilder)localObject3).toString());
      if (QLog.isDebugVersion())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getTempFilePath: troop temp msg backup fileName[");
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
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("resType[");
    ((StringBuilder)localObject3).append(paramMsgBackupResEntity.msgType);
    ((StringBuilder)localObject3).append("] tempPath[");
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append("]");
    a("TroopFileMsgBackupHandler<QFile>", "getTempFilePath", "", ((StringBuilder)localObject3).toString());
    paramMsgBackupResEntity = new StringBuilder();
    paramMsgBackupResEntity.append((String)localObject2);
    paramMsgBackupResEntity.append((String)localObject1);
    return paramMsgBackupResEntity.toString();
  }
  
  public void a(MessageRecord paramMessageRecord, List<MsgBackupResEntity> paramList)
  {
    if (QLog.isDebugVersion())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Export: type[troop] contactUin[");
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
    Object localObject1 = (IMsgBackupTempApi)QRoute.api(IMsgBackupTempApi.class);
    if (!((IMsgBackupTempApi)localObject1).isNeedHandle(this.c, paramMessageRecord))
    {
      QLog.e("TroopFileMsgBackupHandler<QFile>", 1, "handleExport: get TroopFileStatusInfo failed.");
      return;
    }
    int i = ((IMsgBackupTempApi)localObject1).getFileType(this.c, paramMessageRecord);
    Object localObject2;
    long l;
    if ((i == 0) || (i == 2))
    {
      localObject2 = ((IMsgBackupTempApi)localObject1).getLargeThumbPath(this.c, paramMessageRecord);
      if (FileUtils.fileExistsAndNotEmpty((String)localObject2))
      {
        localObject2 = a(paramMessageRecord, 12, (String)localObject2);
        paramList.add(localObject2);
        l = paramMessageRecord.msgseq;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("add resource. resType[");
        localStringBuilder.append(((MsgBackupResEntity)localObject2).msgType);
        localStringBuilder.append("]");
        a("TroopFileMsgBackupHandler<QFile>", "handleExport", String.valueOf(l), localStringBuilder.toString());
      }
    }
    localObject1 = ((IMsgBackupTempApi)localObject1).getLocalFilePath(this.c, paramMessageRecord);
    if (FileUtils.fileExistsAndNotEmpty((String)localObject1))
    {
      localObject1 = a(paramMessageRecord, 11, (String)localObject1);
      paramList.add(localObject1);
      l = paramMessageRecord.msgseq;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("add resource. resType[");
      ((StringBuilder)localObject2).append(((MsgBackupResEntity)localObject1).msgType);
      ((StringBuilder)localObject2).append("]");
      a("TroopFileMsgBackupHandler<QFile>", "handleExport", String.valueOf(l), ((StringBuilder)localObject2).toString());
    }
    if ((QLog.isDebugVersion()) && (paramList != null))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Export --step: msgSeq[");
      ((StringBuilder)localObject1).append(paramMessageRecord.msgseq);
      ((StringBuilder)localObject1).append("resourceSize[");
      ((StringBuilder)localObject1).append(paramList.size());
      ((StringBuilder)localObject1).append("]");
      QLog.i("<QFile_Backup>", 1, ((StringBuilder)localObject1).toString());
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
    if (paramMsgBackupResEntity == null) {
      return false;
    }
    IMsgBackupTempApi localIMsgBackupTempApi = (IMsgBackupTempApi)QRoute.api(IMsgBackupTempApi.class);
    Object localObject1 = a(paramMsgBackupResEntity.extraDataStr);
    Object localObject2 = (String)((HashMap)localObject1).get("bytes_file_uuid");
    localObject1 = (String)((HashMap)localObject1).get("uint64_receiver_uin");
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      QLog.i("<QFile_Backup>", 1, "checkNeedDownloadRes: troop fileId is null");
      return false;
    }
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      QLog.i("<QFile_Backup>", 1, "checkNeedDownloadRes: troop uin is null");
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkNeedDownloadRes: troop fileId[");
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append("]");
    QLog.i("<QFile_Backup>", 1, localStringBuilder.toString());
    localObject2 = this.c;
    paramMessageRecord = (MessageForTroopFile)paramMessageRecord;
    localObject2 = localIMsgBackupTempApi.getLargeThumbPath2((BaseQQAppInterface)localObject2, (String)localObject1, paramMessageRecord);
    paramMessageRecord = localIMsgBackupTempApi.getLocalFilePath2(this.c, (String)localObject1, paramMessageRecord);
    boolean bool;
    if (paramMsgBackupResEntity.msgSubType == 12)
    {
      bool = FileUtils.fileExistsAndNotEmpty((String)localObject2);
      paramMessageRecord = new StringBuilder();
      paramMessageRecord.append("checkNeedDownloadRes: offline large thumb exist[");
      paramMessageRecord.append(bool);
      paramMessageRecord.append("]");
      QLog.i("<QFile_Backup>", 1, paramMessageRecord.toString());
      return bool ^ true;
    }
    if (paramMsgBackupResEntity.msgSubType == 11)
    {
      bool = FileUtils.fileExistsAndNotEmpty(paramMessageRecord);
      paramMessageRecord = new StringBuilder();
      paramMessageRecord.append("checkNeedDownloadRes: troop origin file exist[");
      paramMessageRecord.append(bool);
      paramMessageRecord.append("]");
      QLog.i("<QFile_Backup>", 1, paramMessageRecord.toString());
      return bool ^ true;
    }
    return false;
  }
  
  public void b(MessageRecord paramMessageRecord, List<MsgBackupResEntity> paramList)
  {
    if (QLog.isDebugVersion())
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Import: type[troop] contactUin[");
      ((StringBuilder)localObject).append(paramMessageRecord.frienduin);
      ((StringBuilder)localObject).append("] senderUin[");
      ((StringBuilder)localObject).append(paramMessageRecord.senderuin);
      ((StringBuilder)localObject).append("] uniSeq[");
      ((StringBuilder)localObject).append(paramMessageRecord.uniseq);
      ((StringBuilder)localObject).append("] msgSeq[");
      ((StringBuilder)localObject).append(paramMessageRecord.msgseq);
      ((StringBuilder)localObject).append("]");
      QLog.i("<QFile_Backup>", 1, ((StringBuilder)localObject).toString());
      if (paramList != null)
      {
        localObject = new StringBuilder();
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
    if (c(paramMessageRecord, paramList))
    {
      a("TroopFileMsgBackupHandler<QFile>", "handleImport", String.valueOf(paramMessageRecord.msgseq), "update troop file record.");
    }
    else
    {
      d(paramMessageRecord, paramList);
      a("TroopFileMsgBackupHandler<QFile>", "handleImport", String.valueOf(paramMessageRecord.msgseq), "create troop file record.");
    }
    a(paramMessageRecord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.msgbackup.TroopFileMsgBackupHandler
 * JD-Core Version:    0.7.0.1
 */