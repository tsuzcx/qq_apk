package com.tencent.mobileqq.filemanager.data;

import android.text.TextUtils;
import arof;
import awbv;
import awdg;
import awdj;
import ayvc;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.qphone.base.util.QLog;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="nSessionId")
public class FileManagerEntity
  extends awbv
  implements Cloneable
{
  public long TroopUin;
  public String Uuid;
  public String WeiYunDirKey;
  public String WeiYunFileId;
  public boolean bCannotPlay;
  public boolean bDelInAio;
  public boolean bDelInFM;
  public boolean bOnceSuccess;
  public boolean bSend;
  @awdg
  public boolean bSetVerify;
  public byte[] bombData;
  public int busId;
  public int cloudType;
  @awdg
  public long datalineEntitySessionId;
  public long dbVer;
  public int errCode;
  public float fOlRecvProgressOnNotify;
  public float fOlRecvSpeed;
  public float fProgress;
  public String fileName;
  public long fileSize;
  public int forwardTroopFileEntrance;
  public String httpsDomain;
  public int imgHeight;
  public int imgWidth;
  @awdg
  public boolean isCheckPrivateDir;
  @awdg
  public boolean isFromrMolo;
  public boolean isReaded;
  public boolean isZipInnerFile;
  @awdg
  public long lastSuccessTime;
  public long lastTime;
  public long localModifyTime;
  @awdg
  public Object mContext;
  @awdg
  public String mExcitingSpeed;
  @awdg
  public int mThumbRetryCount;
  public long mTroopFileVideoReqInterval;
  @awdg
  public String miniAppDownloadId;
  public long msgSeq;
  public long msgTime;
  public long msgUid;
  public int nFileType;
  public long nOLfileSessionId;
  public int nOlSenderProgress;
  public int nOpType = -1;
  public long nRelatedSessionId;
  @awdj
  public long nSessionId = 0L;
  public int nWeiYunSrcType;
  @awdg
  public long peerDin;
  public String peerNick;
  public int peerType = 0;
  public String peerUin;
  @awdg
  public int qlmsgSrc;
  @awdg
  public FileManagerEntity relatedEntity;
  public String selfUin;
  public long srvTime = ayvc.a() * 1000L;
  public int status;
  public String str10Md5;
  public String strApkPackageName;
  @awdg
  public String strDataLineMPFileID;
  public String strFileMd5;
  public String strFilePath;
  public String strFileSHA;
  public String strFileSha3;
  public String strLargeThumPath;
  public String strMiddleThumPath;
  public String strQRUrl;
  public String strServerPath;
  public String strSrcName;
  public String strThumbPath;
  public String strTroopFileID;
  public String strTroopFilePath;
  public String strTroopFileSha1;
  public String strTroopFileUuid;
  public long structMsgSeq;
  public int thumbInvalidCode;
  public String tmpSessionFromPhone;
  public String tmpSessionRelatedUin;
  @awdg
  public byte[] tmpSessionSig;
  public String tmpSessionToPhone;
  public long tmpSessionType;
  @awdg
  public int transSpeed;
  public long uniseq = -1L;
  public String zipFileId;
  public String zipFilePath;
  public String zipInnerPath;
  public int zipType;
  
  public FileManagerEntity()
  {
    setCloudType(-1);
    this.fileSize = 0L;
    this.status = -1;
    this.nFileType = -1;
    this.fProgress = 0.0F;
    this.isReaded = false;
    this.nWeiYunSrcType = 0;
    this.lastTime = 0L;
    this.bDelInAio = false;
    this.bDelInFM = false;
    this.bSend = true;
    this.nOlSenderProgress = -1;
    this.fOlRecvSpeed = 0.0F;
    this.fOlRecvProgressOnNotify = 0.0F;
    this.dbVer = 50L;
    this.msgSeq = 0L;
    this.msgUid = 0L;
    this.nRelatedSessionId = 0L;
    this.msgTime = 0L;
    this.nOLfileSessionId = 0L;
    this.busId = 0;
    this.TroopUin = 0L;
    this.errCode = 0;
    this.transSpeed = 0;
    this.qlmsgSrc = 0;
    this.tmpSessionType = 0L;
    this.bCannotPlay = false;
    this.bOnceSuccess = false;
    this.mThumbRetryCount = 0;
  }
  
  public static String tableName()
  {
    return "mr_fileManager";
  }
  
  public FileManagerEntity clone()
  {
    try
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)super.clone();
      return localFileManagerEntity;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
  
  public void copyFrom(FileManagerEntity paramFileManagerEntity)
  {
    try
    {
      if (paramFileManagerEntity.bombData != null) {
        this.bombData = ((byte[])paramFileManagerEntity.bombData.clone());
      }
      this.fileName = paramFileManagerEntity.fileName;
      this.fileSize = paramFileManagerEntity.fileSize;
      this.fProgress = paramFileManagerEntity.fProgress;
      this.isReaded = paramFileManagerEntity.isReaded;
      this.uniseq = paramFileManagerEntity.uniseq;
      this.nFileType = paramFileManagerEntity.nFileType;
      this.nOpType = paramFileManagerEntity.nOpType;
      this.peerNick = paramFileManagerEntity.peerNick;
      this.peerType = paramFileManagerEntity.peerType;
      this.peerUin = paramFileManagerEntity.peerUin;
      this.selfUin = paramFileManagerEntity.selfUin;
      this.srvTime = paramFileManagerEntity.srvTime;
      this.status = paramFileManagerEntity.status;
      setFilePath(paramFileManagerEntity.getFilePath());
      setCloudType(paramFileManagerEntity.getCloudType());
      this.strServerPath = paramFileManagerEntity.strServerPath;
      this.strLargeThumPath = paramFileManagerEntity.strLargeThumPath;
      this.strMiddleThumPath = paramFileManagerEntity.strMiddleThumPath;
      this.strThumbPath = paramFileManagerEntity.strThumbPath;
      this.Uuid = paramFileManagerEntity.Uuid;
      this.WeiYunFileId = paramFileManagerEntity.WeiYunFileId;
      this.WeiYunDirKey = paramFileManagerEntity.WeiYunDirKey;
      this.nWeiYunSrcType = paramFileManagerEntity.nWeiYunSrcType;
      this.lastTime = paramFileManagerEntity.lastTime;
      this.bSend = paramFileManagerEntity.bSend;
      this.nOlSenderProgress = paramFileManagerEntity.nOlSenderProgress;
      this.fOlRecvSpeed = paramFileManagerEntity.fOlRecvSpeed;
      this.fOlRecvProgressOnNotify = paramFileManagerEntity.fOlRecvProgressOnNotify;
      this.dbVer = paramFileManagerEntity.dbVer;
      this.strSrcName = paramFileManagerEntity.strSrcName;
      this.msgSeq = paramFileManagerEntity.msgSeq;
      this.msgUid = paramFileManagerEntity.msgUid;
      this.nRelatedSessionId = paramFileManagerEntity.nRelatedSessionId;
      this.msgTime = paramFileManagerEntity.msgTime;
      this.nOLfileSessionId = paramFileManagerEntity.nOLfileSessionId;
      this.strFileMd5 = paramFileManagerEntity.strFileMd5;
      this.strTroopFileID = paramFileManagerEntity.strTroopFileID;
      this.strTroopFilePath = paramFileManagerEntity.strTroopFilePath;
      this.busId = paramFileManagerEntity.busId;
      this.TroopUin = paramFileManagerEntity.TroopUin;
      this.structMsgSeq = paramFileManagerEntity.structMsgSeq;
      this.errCode = paramFileManagerEntity.errCode;
      this.strFileSHA = paramFileManagerEntity.strFileSHA;
      this.tmpSessionType = paramFileManagerEntity.tmpSessionType;
      this.tmpSessionRelatedUin = paramFileManagerEntity.tmpSessionRelatedUin;
      this.tmpSessionFromPhone = paramFileManagerEntity.tmpSessionFromPhone;
      this.tmpSessionToPhone = paramFileManagerEntity.tmpSessionToPhone;
      this.imgWidth = paramFileManagerEntity.imgWidth;
      this.imgHeight = paramFileManagerEntity.imgHeight;
      this.bCannotPlay = paramFileManagerEntity.bCannotPlay;
      this.lastSuccessTime = paramFileManagerEntity.lastSuccessTime;
      this.zipInnerPath = paramFileManagerEntity.zipInnerPath;
      this.isZipInnerFile = paramFileManagerEntity.isZipInnerFile;
      this.httpsDomain = paramFileManagerEntity.httpsDomain;
      return;
    }
    finally {}
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FileManagerEntity)) {}
    while (((FileManagerEntity)paramObject).nSessionId != this.nSessionId) {
      return false;
    }
    return true;
  }
  
  public int getCloudType()
  {
    return this.cloudType;
  }
  
  public String getFilePath()
  {
    return this.strFilePath;
  }
  
  public String getTableName()
  {
    return "mr_fileManager";
  }
  
  public boolean hasNoThumb()
  {
    if (arof.b(this.strLargeThumPath)) {}
    while ((arof.b(this.strMiddleThumPath)) || (arof.b(this.strThumbPath))) {
      return true;
    }
    return false;
  }
  
  public boolean isFromProcessingBuddyForward2DatalineItem()
  {
    return (this.nOpType == 29) && ((this.status == 2) || (this.status == 0));
  }
  
  public boolean isFromProcessingForward2DatalineItem()
  {
    return (this.nOpType == 31) && ((this.status == 2) || (this.status == 0));
  }
  
  public boolean isFromProcessingForward2c2cOrDiscItem()
  {
    return ((this.nOpType == 24) || (this.nOpType == 25)) && ((this.status == 2) || (this.status == 0));
  }
  
  public boolean isSend()
  {
    return (this.nOpType == 0) || (this.nOpType == 3) || (this.nOpType == 4) || (this.nOpType == 6) || (this.nOpType == 7) || (this.nOpType == 20) || (this.nOpType == 21) || (this.nOpType == 22) || (this.nOpType == 24) || (this.nOpType == 25) || (this.nOpType == 26) || (this.nOpType == 27) || (this.nOpType == 28) || (this.nOpType == 29) || (this.nOpType == 31) || (this.nOpType == 32);
  }
  
  public boolean sendCloudUnsuccessful()
  {
    if (this.status == 1) {}
    while ((!isSend()) || (this.status == -1)) {
      return false;
    }
    return true;
  }
  
  public void setCloudType(int paramInt)
  {
    this.cloudType = paramInt;
    if ((this.cloudType == 3) && (TextUtils.isEmpty(this.strFilePath)) && (this.bSetVerify))
    {
      QLog.w("FileManagerEntity<FileAssistant>", 1, "local file set entity filepath is null!");
      this.bSetVerify = false;
    }
    this.bSetVerify = false;
  }
  
  public void setFilePath(String paramString)
  {
    this.strFilePath = paramString;
    if ((TextUtils.isEmpty(this.strFilePath)) && (this.bSetVerify))
    {
      QLog.w("FileManagerEntity<FileAssistant>", 1, "set entity strFilePath is null!");
      this.bSetVerify = false;
    }
    if ((TextUtils.isEmpty(this.strFilePath)) && (!this.bSetVerify)) {
      this.bSetVerify = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.FileManagerEntity
 * JD-Core Version:    0.7.0.1
 */