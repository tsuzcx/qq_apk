package com.tencent.mobileqq.filemanager.msgbackup;

import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.api.IFileManagerUtil;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi;
import com.tencent.mobileqq.msgbackup.util.MsgBackupConstant;
import com.tencent.mobileqq.msgbackup.util.MsgBackupUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public abstract class FileMsgBackupHandler
{
  public static final String a;
  public static final String b;
  protected BaseQQAppInterface c;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(MsgBackupConstant.a);
    localStringBuilder.append("fileThumb/");
    a = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(MsgBackupConstant.a);
    localStringBuilder.append("file/");
    b = localStringBuilder.toString();
  }
  
  public FileMsgBackupHandler(BaseQQAppInterface paramBaseQQAppInterface)
  {
    this.c = paramBaseQQAppInterface;
  }
  
  private void b(String paramString)
  {
    if (QLog.isDebugVersion()) {
      QLog.i("FileMsgBackupHandler<QFile>", 1, paramString);
    }
  }
  
  protected MsgBackupResEntity a(MessageRecord paramMessageRecord, int paramInt, String paramString)
  {
    MsgBackupResEntity localMsgBackupResEntity = new MsgBackupResEntity();
    MsgBackupUtil.a(paramMessageRecord, localMsgBackupResEntity);
    localMsgBackupResEntity.extraDataStr = a(((IMsgBackupTempApi)QRoute.api(IMsgBackupTempApi.class)).changeRealChatMessage((ChatMessage)paramMessageRecord), paramInt);
    localMsgBackupResEntity.filePath = paramString;
    localMsgBackupResEntity.msgType = 5;
    localMsgBackupResEntity.msgSubType = paramInt;
    if (FileUtils.fileExistsAndNotEmpty(paramString)) {
      localMsgBackupResEntity.fileSize = FileUtils.getFileSizes(paramString);
    }
    return localMsgBackupResEntity;
  }
  
  protected String a(MessageRecord paramMessageRecord, int paramInt)
  {
    return "";
  }
  
  public abstract String a(MsgBackupResEntity paramMsgBackupResEntity);
  
  protected String a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return "";
    }
    IFileManagerUtil localIFileManagerUtil = (IFileManagerUtil)QRoute.api(IFileManagerUtil.class);
    String str = localIFileManagerUtil.getFMDownloadPath();
    Object localObject = new File(str);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(paramString2);
    str = ((StringBuilder)localObject).toString();
    paramString2 = str;
    if (FileUtils.fileExistsAndNotEmpty(str)) {
      paramString2 = localIFileManagerUtil.recreateFilePath(str);
    }
    if (b(paramString1, paramString2))
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("getRawFileSavePath. rawPath[");
        paramString1.append(paramString2);
        paramString1.append("]");
        QLog.i("FileMsgBackupHandler<QFile>", 4, paramString1.toString());
      }
      return paramString2;
    }
    QLog.i("FileMsgBackupHandler<QFile>", 1, "getRawFileSavePath. move file failed.");
    return "";
  }
  
  protected HashMap<String, String> a(String paramString)
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
          b(localStringBuilder.toString());
          localHashMap.put("uint64_sender_uin", localObject);
          if (paramString.has("uint64_receiver_uin"))
          {
            localObject = paramString.getString("uint64_receiver_uin");
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("decodeResExtInfo recvUin[");
            localStringBuilder.append((String)localObject);
            localStringBuilder.append("]");
            b(localStringBuilder.toString());
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
            b(((StringBuilder)localObject).toString());
            localHashMap.put("uint32_file_type", String.valueOf(i));
          }
          if (paramString.has("bytes_file_uuid"))
          {
            localObject = paramString.getString("bytes_file_uuid");
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("decodeResExtInfo fileUuid[");
            localStringBuilder.append((String)localObject);
            localStringBuilder.append("]");
            b(localStringBuilder.toString());
            localHashMap.put("bytes_file_uuid", localObject);
          }
          if (paramString.has("str_file_name"))
          {
            localObject = paramString.getString("str_file_name");
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("decodeResExtInfo fileName[");
            localStringBuilder.append((String)localObject);
            localStringBuilder.append("]");
            b(localStringBuilder.toString());
            localHashMap.put("str_file_name", localObject);
          }
          if (paramString.has("uint64_file_size"))
          {
            long l = paramString.getLong("uint64_file_size");
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("decodeResExtInfo fileSize[");
            ((StringBuilder)localObject).append(l);
            ((StringBuilder)localObject).append("]");
            b(((StringBuilder)localObject).toString());
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
              b(localStringBuilder.toString());
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
              b(localStringBuilder.toString());
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
              b(localStringBuilder.toString());
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
              b(localStringBuilder.toString());
              localHashMap.put("sha3", localObject);
            }
          }
          if (paramString.has("uint32_img_width"))
          {
            i = paramString.getInt("uint32_img_width");
            if (i != 0)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("decodeResExtInfo imgWidth[");
              ((StringBuilder)localObject).append(i);
              ((StringBuilder)localObject).append("]");
              b(((StringBuilder)localObject).toString());
              localHashMap.put("uint32_img_width", String.valueOf(i));
            }
          }
          if (paramString.has("uint32_img_height"))
          {
            i = paramString.getInt("uint32_img_height");
            if (i != 0)
            {
              paramString = new StringBuilder();
              paramString.append("decodeResExtInfo imgHeight[");
              paramString.append(i);
              paramString.append("]");
              b(paramString.toString());
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
  
  protected void a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return;
    }
    paramMessageRecord.removeExtInfoToExtStr("_backup_ForwardFileType");
    paramMessageRecord.removeExtInfoToExtStr("_backup_ForwardSenderUin");
    paramMessageRecord.removeExtInfoToExtStr("_backup_ForwardReceiverUin");
    paramMessageRecord.removeExtInfoToExtStr("_backup_ForwardUuid");
    paramMessageRecord.removeExtInfoToExtStr("_backup_ForwardFileName");
    paramMessageRecord.removeExtInfoToExtStr("_backup_ForwardSize");
    paramMessageRecord.removeExtInfoToExtStr("_backup_ForwardSha");
    paramMessageRecord.removeExtInfoToExtStr("_backup_ForwardMd5");
    paramMessageRecord.removeExtInfoToExtStr("_backup_ForwardDeadTime");
    paramMessageRecord.removeExtInfoToExtStr("_backup_ForwardImgWidth");
    paramMessageRecord.removeExtInfoToExtStr("_backup_ForwardImgHeight");
    paramMessageRecord.removeExtInfoToExtStr("_backup_ForwardDuration");
    paramMessageRecord.removeExtInfoToExtStr("_backup_ForwardBusType");
    paramMessageRecord.removeExtInfoToExtStr("_backup_ForwardFilePath");
    paramMessageRecord.removeExtInfoToExtStr("_backup_ForwardFileStatus");
    paramMessageRecord.removeExtInfoToExtStr("_backup_ForwardFaildReason");
    paramMessageRecord.removeExtInfoToExtStr("_backup_ForwardLasSuccess");
    paramMessageRecord.removeExtInfoToExtStr("_backup_ForwardStatusPaused");
  }
  
  public abstract void a(MessageRecord paramMessageRecord, List<MsgBackupResEntity> paramList);
  
  protected void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(paramString2);
      localStringBuilder2.append(": ");
      localStringBuilder1.append(localStringBuilder2.toString());
      if (!TextUtils.isEmpty(paramString3))
      {
        localStringBuilder1.append("msg[");
        localStringBuilder1.append(paramString3);
        localStringBuilder1.append("] ");
      }
      localStringBuilder1.append(paramString4);
      QLog.i(paramString1, 4, localStringBuilder1.toString());
    }
  }
  
  public abstract boolean a(MessageRecord paramMessageRecord, MsgBackupResEntity paramMsgBackupResEntity);
  
  public abstract void b(MessageRecord paramMessageRecord, List<MsgBackupResEntity> paramList);
  
  protected boolean b(MessageRecord paramMessageRecord, MsgBackupResEntity paramMsgBackupResEntity)
  {
    if (paramMessageRecord.isMultiMsg)
    {
      paramMsgBackupResEntity = (String)a(paramMsgBackupResEntity.extraDataStr).get("bytes_file_uuid");
      paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardUuid");
      if ((!TextUtils.isEmpty(paramMsgBackupResEntity)) && (!TextUtils.isEmpty(paramMessageRecord)) && (paramMsgBackupResEntity.equals(paramMessageRecord)))
      {
        if (QLog.isDebugVersion())
        {
          paramMsgBackupResEntity = new StringBuilder();
          paramMsgBackupResEntity.append("isResourceRelateToMsg: multi msg match res. fileId[");
          paramMsgBackupResEntity.append(paramMessageRecord);
          paramMsgBackupResEntity.append("] ");
          QLog.i("FileMsgBackupHandler<QFile>", 1, paramMsgBackupResEntity.toString());
        }
        return true;
      }
      return false;
    }
    return true;
  }
  
  protected boolean b(MsgBackupResEntity paramMsgBackupResEntity)
  {
    if (paramMsgBackupResEntity == null) {
      return false;
    }
    return (paramMsgBackupResEntity.msgType == 5) && ((paramMsgBackupResEntity.msgSubType == 12) || (paramMsgBackupResEntity.msgSubType == 11));
  }
  
  protected boolean b(String paramString1, String paramString2)
  {
    if (!FileUtils.fileExistsAndNotEmpty(paramString1))
    {
      QLog.i("FileMsgBackupHandler<QFile>", 1, "moveFileSavePath. tempPath is null");
      return false;
    }
    if (TextUtils.isEmpty(paramString2))
    {
      QLog.i("FileMsgBackupHandler<QFile>", 1, "moveFileSavePath. targetPath is null");
      return false;
    }
    return FileUtils.moveFile(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.msgbackup.FileMsgBackupHandler
 * JD-Core Version:    0.7.0.1
 */