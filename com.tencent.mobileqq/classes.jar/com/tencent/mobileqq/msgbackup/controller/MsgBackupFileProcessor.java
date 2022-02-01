package com.tencent.mobileqq.msgbackup.controller;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
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
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private OfflineFileMsgBackupHandler jdField_a_of_type_ComTencentMobileqqFilemanagerMsgbackupOfflineFileMsgBackupHandler;
  private TroopFileMsgBackupHandler jdField_a_of_type_ComTencentMobileqqFilemanagerMsgbackupTroopFileMsgBackupHandler;
  
  public MsgBackupFileProcessor(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private FileMsgBackupHandler a(int paramInt)
  {
    QLog.i("MsgBackupFileProcessor<QFile>", 1, "getMsgBackupHandler: chatTYpe[" + paramInt + "]");
    Object localObject1 = null;
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerMsgbackupOfflineFileMsgBackupHandler == null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerMsgbackupOfflineFileMsgBackupHandler = new OfflineFileMsgBackupHandler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerMsgbackupOfflineFileMsgBackupHandler;
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        QLog.i("MsgBackupFileProcessor<QFile>", 1, "getMsgBackupHandler: target backup handle is null");
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerMsgbackupOfflineFileMsgBackupHandler == null) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerMsgbackupOfflineFileMsgBackupHandler = new OfflineFileMsgBackupHandler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerMsgbackupOfflineFileMsgBackupHandler;
      }
      return localObject2;
      if (paramInt == 2)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerMsgbackupOfflineFileMsgBackupHandler == null) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerMsgbackupOfflineFileMsgBackupHandler = new OfflineFileMsgBackupHandler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerMsgbackupOfflineFileMsgBackupHandler;
      }
      else if (paramInt == 3)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerMsgbackupTroopFileMsgBackupHandler == null) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerMsgbackupTroopFileMsgBackupHandler = new TroopFileMsgBackupHandler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerMsgbackupTroopFileMsgBackupHandler;
      }
    }
  }
  
  private FileMsgBackupHandler a(MessageRecord paramMessageRecord)
  {
    Object localObject = null;
    if (paramMessageRecord.isMultiMsg)
    {
      paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileType");
      if (!TextUtils.isEmpty(paramMessageRecord))
      {
        if (Integer.parseInt(paramMessageRecord) != 3) {
          break label72;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerMsgbackupTroopFileMsgBackupHandler == null) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerMsgbackupTroopFileMsgBackupHandler = new TroopFileMsgBackupHandler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerMsgbackupTroopFileMsgBackupHandler;
      }
    }
    for (;;)
    {
      if (localObject == null) {
        QLog.i("MsgBackupFileProcessor<QFile>", 1, "getMsgBackupHandler: target backup handle is null");
      }
      return localObject;
      label72:
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerMsgbackupOfflineFileMsgBackupHandler == null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerMsgbackupOfflineFileMsgBackupHandler = new OfflineFileMsgBackupHandler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerMsgbackupOfflineFileMsgBackupHandler;
      continue;
      if ((paramMessageRecord instanceof MessageForFile))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerMsgbackupOfflineFileMsgBackupHandler == null) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerMsgbackupOfflineFileMsgBackupHandler = new OfflineFileMsgBackupHandler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerMsgbackupOfflineFileMsgBackupHandler;
      }
      else if ((paramMessageRecord instanceof MessageForTroopFile))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerMsgbackupTroopFileMsgBackupHandler == null) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerMsgbackupTroopFileMsgBackupHandler = new TroopFileMsgBackupHandler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerMsgbackupTroopFileMsgBackupHandler;
      }
    }
  }
  
  private HashMap<String, String> a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return localHashMap;
      try
      {
        paramString = new JSONObject(paramString);
        String str;
        if (paramString.has("uint64_sender_uin"))
        {
          str = paramString.getString("uint64_sender_uin");
          a("MsgBackupFileProcessor<QFile>", "decodeResExtInfo senderUin[" + str + "]");
          localHashMap.put("uint64_sender_uin", str);
        }
        if (paramString.has("uint64_receiver_uin"))
        {
          str = paramString.getString("uint64_receiver_uin");
          a("MsgBackupFileProcessor<QFile>", "decodeResExtInfo recvUin[" + str + "]");
          localHashMap.put("uint64_receiver_uin", str);
        }
        int i;
        if (paramString.has("uint32_file_type"))
        {
          i = paramString.getInt("uint32_file_type");
          a("MsgBackupFileProcessor<QFile>", "decodeResExtInfo peerType[" + i + "]");
          localHashMap.put("uint32_file_type", String.valueOf(i));
        }
        if (paramString.has("bytes_file_uuid"))
        {
          str = paramString.getString("bytes_file_uuid");
          a("MsgBackupFileProcessor<QFile>", "decodeResExtInfo fileUuid[" + str + "]");
          localHashMap.put("bytes_file_uuid", str);
        }
        if (paramString.has("str_file_name"))
        {
          str = paramString.getString("str_file_name");
          a("MsgBackupFileProcessor<QFile>", "decodeResExtInfo fileName[" + str + "]");
          localHashMap.put("str_file_name", str);
        }
        if (paramString.has("uint64_file_size"))
        {
          long l = paramString.getLong("uint64_file_size");
          a("MsgBackupFileProcessor<QFile>", "decodeResExtInfo fileSize[" + l + "]");
          localHashMap.put("uint64_file_size", String.valueOf(l));
        }
        if (paramString.has("md5"))
        {
          str = paramString.getString("md5");
          if (!TextUtils.isEmpty(str))
          {
            a("MsgBackupFileProcessor<QFile>", "decodeResExtInfo fileMd5[" + str + "]");
            localHashMap.put("md5", str);
          }
        }
        if (paramString.has("md510"))
        {
          str = paramString.getString("md510");
          if (!TextUtils.isEmpty(str))
          {
            a("MsgBackupFileProcessor<QFile>", "decodeResExtInfo file10Md5[" + str + "]");
            localHashMap.put("md510", str);
          }
        }
        if (paramString.has("sha"))
        {
          str = paramString.getString("sha");
          if (!TextUtils.isEmpty(str))
          {
            a("MsgBackupFileProcessor<QFile>", "decodeResExtInfo sha[" + str + "]");
            localHashMap.put("sha", str);
          }
        }
        if (paramString.has("sha3"))
        {
          str = paramString.getString("sha3");
          if (!TextUtils.isEmpty(str))
          {
            a("MsgBackupFileProcessor<QFile>", "decodeResExtInfo sha3[" + str + "]");
            localHashMap.put("sha3", str);
          }
        }
        if (paramString.has("uint32_img_width"))
        {
          i = paramString.getInt("uint32_img_width");
          if (i != 0)
          {
            a("MsgBackupFileProcessor<QFile>", "decodeResExtInfo imgWidth[" + i + "]");
            localHashMap.put("uint32_img_width", String.valueOf(i));
          }
        }
        if (paramString.has("uint32_img_height"))
        {
          i = paramString.getInt("uint32_img_height");
          if (i != 0)
          {
            a("MsgBackupFileProcessor<QFile>", "decodeResExtInfo imgWidth[" + i + "]");
            localHashMap.put("uint32_img_height", String.valueOf(i));
            return localHashMap;
          }
        }
      }
      catch (Exception paramString) {}
    }
    return localHashMap;
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
      QLog.i("MsgBackupFileProcessor<QFile>", 1, "isNeedDownloadRes: can not find chatType from extInfo. resInfo[" + paramMsgBackupResEntity.toLogString() + "]");
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
    if ((paramMessageRecord instanceof MessageForTroopFile)) {}
    while ((paramMessageRecord instanceof MessageForFile)) {
      return true;
    }
    return false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.controller.MsgBackupFileProcessor
 * JD-Core Version:    0.7.0.1
 */