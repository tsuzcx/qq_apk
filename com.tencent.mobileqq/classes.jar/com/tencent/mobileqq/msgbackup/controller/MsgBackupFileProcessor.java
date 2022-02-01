package com.tencent.mobileqq.msgbackup.controller;

import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.msgbackup.FileMsgBackupHandler;
import com.tencent.mobileqq.filemanager.msgbackup.OfflineFileMsgBackupHandler;
import com.tencent.mobileqq.filemanager.msgbackup.TroopFileMsgBackupHandler;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public class MsgBackupFileProcessor
  implements IMsgBackupRichProcessor
{
  private BaseQQAppInterface jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface;
  private OfflineFileMsgBackupHandler jdField_a_of_type_ComTencentMobileqqFilemanagerMsgbackupOfflineFileMsgBackupHandler;
  private TroopFileMsgBackupHandler jdField_a_of_type_ComTencentMobileqqFilemanagerMsgbackupTroopFileMsgBackupHandler;
  
  public MsgBackupFileProcessor(BaseQQAppInterface paramBaseQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface = paramBaseQQAppInterface;
  }
  
  private FileMsgBackupHandler a(int paramInt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("getMsgBackupHandler: chatTYpe[");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append("]");
    QLog.i("MsgBackupFileProcessor<QFile>", 1, ((StringBuilder)localObject1).toString());
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerMsgbackupOfflineFileMsgBackupHandler == null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerMsgbackupOfflineFileMsgBackupHandler = new OfflineFileMsgBackupHandler(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface);
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerMsgbackupOfflineFileMsgBackupHandler;
    }
    else if (paramInt == 2)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerMsgbackupOfflineFileMsgBackupHandler == null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerMsgbackupOfflineFileMsgBackupHandler = new OfflineFileMsgBackupHandler(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface);
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerMsgbackupOfflineFileMsgBackupHandler;
    }
    else if (paramInt == 3)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerMsgbackupTroopFileMsgBackupHandler == null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerMsgbackupTroopFileMsgBackupHandler = new TroopFileMsgBackupHandler(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface);
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerMsgbackupTroopFileMsgBackupHandler;
    }
    else
    {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      QLog.i("MsgBackupFileProcessor<QFile>", 1, "getMsgBackupHandler: target backup handle is null");
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerMsgbackupOfflineFileMsgBackupHandler == null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerMsgbackupOfflineFileMsgBackupHandler = new OfflineFileMsgBackupHandler(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface);
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerMsgbackupOfflineFileMsgBackupHandler;
    }
    return localObject2;
  }
  
  private FileMsgBackupHandler a(MessageRecord paramMessageRecord)
  {
    boolean bool = paramMessageRecord.isMultiMsg;
    Object localObject = null;
    if (bool)
    {
      paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileType");
      if (!TextUtils.isEmpty(paramMessageRecord))
      {
        if (Integer.parseInt(paramMessageRecord) == 3)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerMsgbackupTroopFileMsgBackupHandler == null) {
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerMsgbackupTroopFileMsgBackupHandler = new TroopFileMsgBackupHandler(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface);
          }
          paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqFilemanagerMsgbackupTroopFileMsgBackupHandler;
        }
        else
        {
          if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerMsgbackupOfflineFileMsgBackupHandler == null) {
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerMsgbackupOfflineFileMsgBackupHandler = new OfflineFileMsgBackupHandler(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface);
          }
          paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqFilemanagerMsgbackupOfflineFileMsgBackupHandler;
        }
        localObject = paramMessageRecord;
      }
    }
    else if ((paramMessageRecord instanceof MessageForFile))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerMsgbackupOfflineFileMsgBackupHandler == null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerMsgbackupOfflineFileMsgBackupHandler = new OfflineFileMsgBackupHandler(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerMsgbackupOfflineFileMsgBackupHandler;
    }
    else if ((paramMessageRecord instanceof MessageForTroopFile))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerMsgbackupTroopFileMsgBackupHandler == null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerMsgbackupTroopFileMsgBackupHandler = new TroopFileMsgBackupHandler(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerMsgbackupTroopFileMsgBackupHandler;
    }
    if (localObject == null) {
      QLog.i("MsgBackupFileProcessor<QFile>", 1, "getMsgBackupHandler: target backup handle is null");
    }
    return localObject;
  }
  
  private HashMap<String, String> a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (TextUtils.isEmpty(paramString)) {
      return localHashMap;
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        boolean bool = paramString.has("uint64_sender_uin");
        if (bool)
        {
          Object localObject = paramString.getString("uint64_sender_uin");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("decodeResExtInfo senderUin[");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append("]");
          a("MsgBackupFileProcessor<QFile>", localStringBuilder.toString());
          localHashMap.put("uint64_sender_uin", localObject);
          if (paramString.has("uint64_receiver_uin"))
          {
            localObject = paramString.getString("uint64_receiver_uin");
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("decodeResExtInfo recvUin[");
            localStringBuilder.append((String)localObject);
            localStringBuilder.append("]");
            a("MsgBackupFileProcessor<QFile>", localStringBuilder.toString());
            localHashMap.put("uint64_receiver_uin", localObject);
          }
          int i;
          if (paramString.has("uint32_file_type"))
          {
            i = paramString.getInt("uint32_file_type");
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("decodeResExtInfo peerType[");
            ((StringBuilder)localObject).append(i);
            ((StringBuilder)localObject).append("]");
            a("MsgBackupFileProcessor<QFile>", ((StringBuilder)localObject).toString());
            localHashMap.put("uint32_file_type", String.valueOf(i));
          }
          if (paramString.has("bytes_file_uuid"))
          {
            localObject = paramString.getString("bytes_file_uuid");
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("decodeResExtInfo fileUuid[");
            localStringBuilder.append((String)localObject);
            localStringBuilder.append("]");
            a("MsgBackupFileProcessor<QFile>", localStringBuilder.toString());
            localHashMap.put("bytes_file_uuid", localObject);
          }
          if (paramString.has("str_file_name"))
          {
            localObject = paramString.getString("str_file_name");
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("decodeResExtInfo fileName[");
            localStringBuilder.append((String)localObject);
            localStringBuilder.append("]");
            a("MsgBackupFileProcessor<QFile>", localStringBuilder.toString());
            localHashMap.put("str_file_name", localObject);
          }
          if (paramString.has("uint64_file_size"))
          {
            long l = paramString.getLong("uint64_file_size");
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("decodeResExtInfo fileSize[");
            ((StringBuilder)localObject).append(l);
            ((StringBuilder)localObject).append("]");
            a("MsgBackupFileProcessor<QFile>", ((StringBuilder)localObject).toString());
            localHashMap.put("uint64_file_size", String.valueOf(l));
          }
          if (paramString.has("md5"))
          {
            localObject = paramString.getString("md5");
            if (!TextUtils.isEmpty((CharSequence)localObject))
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("decodeResExtInfo fileMd5[");
              localStringBuilder.append((String)localObject);
              localStringBuilder.append("]");
              a("MsgBackupFileProcessor<QFile>", localStringBuilder.toString());
              localHashMap.put("md5", localObject);
            }
          }
          if (paramString.has("md510"))
          {
            localObject = paramString.getString("md510");
            if (!TextUtils.isEmpty((CharSequence)localObject))
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("decodeResExtInfo file10Md5[");
              localStringBuilder.append((String)localObject);
              localStringBuilder.append("]");
              a("MsgBackupFileProcessor<QFile>", localStringBuilder.toString());
              localHashMap.put("md510", localObject);
            }
          }
          if (paramString.has("sha"))
          {
            localObject = paramString.getString("sha");
            if (!TextUtils.isEmpty((CharSequence)localObject))
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("decodeResExtInfo sha[");
              localStringBuilder.append((String)localObject);
              localStringBuilder.append("]");
              a("MsgBackupFileProcessor<QFile>", localStringBuilder.toString());
              localHashMap.put("sha", localObject);
            }
          }
          if (paramString.has("sha3"))
          {
            localObject = paramString.getString("sha3");
            if (!TextUtils.isEmpty((CharSequence)localObject))
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("decodeResExtInfo sha3[");
              localStringBuilder.append((String)localObject);
              localStringBuilder.append("]");
              a("MsgBackupFileProcessor<QFile>", localStringBuilder.toString());
              localHashMap.put("sha3", localObject);
            }
          }
          bool = paramString.has("uint32_img_width");
          if (bool)
          {
            i = paramString.getInt("uint32_img_width");
            if (i != 0)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("decodeResExtInfo imgWidth[");
              ((StringBuilder)localObject).append(i);
              ((StringBuilder)localObject).append("]");
              a("MsgBackupFileProcessor<QFile>", ((StringBuilder)localObject).toString());
              localHashMap.put("uint32_img_width", String.valueOf(i));
            }
          }
          if (paramString.has("uint32_img_height"))
          {
            i = paramString.getInt("uint32_img_height");
            if (i != 0)
            {
              paramString = new StringBuilder();
              paramString.append("decodeResExtInfo imgWidth[");
              paramString.append(i);
              paramString.append("]");
              a("MsgBackupFileProcessor<QFile>", paramString.toString());
              localHashMap.put("uint32_img_height", String.valueOf(i));
            }
          }
          return localHashMap;
        }
      }
      catch (Exception paramString)
      {
        return localHashMap;
      }
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("MsgBackupFileProcessor<QFile>", 1, paramString2);
    }
  }
  
  public ResDownloadObject a(MessageRecord paramMessageRecord, MsgBackupResEntity paramMsgBackupResEntity)
  {
    ResDownloadObject localResDownloadObject = new ResDownloadObject();
    if (paramMsgBackupResEntity == null)
    {
      QLog.i("MsgBackupFileProcessor<QFile>", 1, "isNeedDownloadRes: res entity is null.");
      localResDownloadObject.a = false;
      return localResDownloadObject;
    }
    if (paramMsgBackupResEntity.msgType != 5)
    {
      QLog.i("MsgBackupFileProcessor<QFile>", 1, "isNeedDownloadRes: res entity is null.");
      localResDownloadObject.a = false;
      return localResDownloadObject;
    }
    String str = (String)a(paramMsgBackupResEntity.extraDataStr).get("uint32_file_type");
    if (TextUtils.isEmpty(str))
    {
      paramMessageRecord = new StringBuilder();
      paramMessageRecord.append("isNeedDownloadRes: can not find chatType from extInfo. resInfo[");
      paramMessageRecord.append(paramMsgBackupResEntity.toLogString());
      paramMessageRecord.append("]");
      QLog.i("MsgBackupFileProcessor<QFile>", 1, paramMessageRecord.toString());
      localResDownloadObject.a = false;
      return localResDownloadObject;
    }
    localResDownloadObject.a = a(Integer.parseInt(str)).a(paramMessageRecord, paramMsgBackupResEntity);
    return localResDownloadObject;
  }
  
  public String a(MessageRecord paramMessageRecord, MsgBackupResEntity paramMsgBackupResEntity)
  {
    paramMessageRecord = new File(FileMsgBackupHandler.b);
    if (!paramMessageRecord.exists()) {
      paramMessageRecord.mkdirs();
    }
    paramMessageRecord = new File(FileMsgBackupHandler.a);
    if (!paramMessageRecord.exists()) {
      paramMessageRecord.mkdirs();
    }
    return a(Integer.parseInt((String)a(paramMsgBackupResEntity.extraDataStr).get("uint32_file_type"))).a(paramMsgBackupResEntity);
  }
  
  public void a(MessageRecord paramMessageRecord, List<MsgBackupResEntity> paramList)
  {
    FileMsgBackupHandler localFileMsgBackupHandler = a(paramMessageRecord);
    if (localFileMsgBackupHandler != null) {
      localFileMsgBackupHandler.a(paramMessageRecord, paramList);
    }
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForTroopFile)) {
      return true;
    }
    return (paramMessageRecord instanceof MessageForFile);
  }
  
  public boolean a(MsgBackupResEntity paramMsgBackupResEntity)
  {
    return (paramMsgBackupResEntity != null) && (paramMsgBackupResEntity.msgType == 5);
  }
  
  public void b(MessageRecord paramMessageRecord, List<MsgBackupResEntity> paramList)
  {
    FileMsgBackupHandler localFileMsgBackupHandler = a(paramMessageRecord);
    if (localFileMsgBackupHandler != null) {
      localFileMsgBackupHandler.b(paramMessageRecord, paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.controller.MsgBackupFileProcessor
 * JD-Core Version:    0.7.0.1
 */