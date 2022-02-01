package com.tencent.mobileqq.data;

import apab;

public class MessageForDeviceFile
  extends ChatMessage
{
  public static final int DATATYPE_FILE_FILE = 1;
  public static final int DATATYPE_FILE_IMAGE = 2;
  public static final int MSG_STATUS_FAILED = 1;
  public static final int MSG_STATUS_RECVING = 3;
  public static final int MSG_STATUS_SENDING = 2;
  public static final int MSG_STATUS_SUCC = 0;
  private static final String TAG = "MessageForDeviceFile";
  public int color = 1;
  public int copies = 1;
  public int duplexMode = 1;
  public long entityID;
  public int fileFrom;
  public String filePath;
  public long fileSize;
  public String fileUuid;
  public int groupId;
  public int groupIndex;
  public int groupSize;
  public byte[] md5;
  public int mediaSize = 1;
  public int mediaType = 1;
  public int msgStatus;
  public int nFileMsgType;
  public int nFileStatus;
  public int nOpType;
  public long nServerIp;
  public long nServerPort;
  public int orientation = 1;
  public float progress;
  public int quality = 1;
  public int scaling = 1;
  public String serverPath;
  public String srcFileName;
  public String strCoverKey;
  public String strCoverKey2;
  public String strFileKey2;
  public String strMediaKey;
  public String strServiceName;
  public String thumbPath;
  public int uChannelType;
  public long uOwnerUin;
  public long uSessionID;
  public int uint32_dst_app_id;
  public int uint32_dst_inst_id;
  public int uint32_dst_ter_type;
  public int uint32_dst_uin_type;
  public int uint32_src_app_id;
  public int uint32_src_inst_id;
  public int uint32_src_ter_type;
  public int uint32_src_uin_type;
  public long uint64_dst_uin;
  public long uint64_src_uin;
  public byte[] vOfflineFileUUID;
  public byte[] vServiceInfo;
  public byte[] vTokenKey;
  public byte[] vUrlNotify;
  
  protected void doParse()
  {
    try
    {
      MessageForDeviceFile.DeviceFileMsgSerial localDeviceFileMsgSerial = (MessageForDeviceFile.DeviceFileMsgSerial)apab.a(this.msgData);
      if (localDeviceFileMsgSerial != null)
      {
        this.strServiceName = localDeviceFileMsgSerial.strServiceName;
        this.nFileMsgType = localDeviceFileMsgSerial.nFileMsgType;
        this.filePath = localDeviceFileMsgSerial.filePath;
        this.srcFileName = localDeviceFileMsgSerial.srcFileName;
        this.fileSize = localDeviceFileMsgSerial.fileSize;
        this.nFileStatus = localDeviceFileMsgSerial.nFileStatus;
        this.progress = localDeviceFileMsgSerial.progress;
        this.uSessionID = localDeviceFileMsgSerial.uSessionID;
        this.msgStatus = localDeviceFileMsgSerial.msgStatus;
        this.msg = localDeviceFileMsgSerial.strRecentMsg;
        this.strCoverKey = localDeviceFileMsgSerial.strCoverKey;
        this.strCoverKey2 = localDeviceFileMsgSerial.strCoverKey2;
        this.strMediaKey = localDeviceFileMsgSerial.strMediaKey;
        this.strFileKey2 = localDeviceFileMsgSerial.strFileKey2;
        this.groupId = localDeviceFileMsgSerial.groupId;
        this.groupIndex = localDeviceFileMsgSerial.groupIndex;
        this.groupSize = localDeviceFileMsgSerial.groupSize;
        this.nServerIp = localDeviceFileMsgSerial.nServerIp;
        this.nServerPort = localDeviceFileMsgSerial.nServerPort;
        this.vUrlNotify = localDeviceFileMsgSerial.vUrlNotify;
        this.vTokenKey = localDeviceFileMsgSerial.vTokenKey;
        this.serverPath = localDeviceFileMsgSerial.serverPath;
        this.fileFrom = localDeviceFileMsgSerial.fileFrom;
        this.fileUuid = localDeviceFileMsgSerial.fileUuid;
        this.thumbPath = localDeviceFileMsgSerial.thumbPath;
        this.md5 = localDeviceFileMsgSerial.md5;
        this.uOwnerUin = localDeviceFileMsgSerial.uOwnerUin;
        this.vOfflineFileUUID = localDeviceFileMsgSerial.vOfflineFileUUID;
        this.uChannelType = localDeviceFileMsgSerial.uChannelType;
        this.uint32_src_app_id = localDeviceFileMsgSerial.uint32_src_app_id;
        this.uint32_src_inst_id = localDeviceFileMsgSerial.uint32_src_inst_id;
        this.uint32_dst_app_id = localDeviceFileMsgSerial.uint32_dst_app_id;
        this.uint32_dst_inst_id = localDeviceFileMsgSerial.uint32_dst_inst_id;
        this.uint64_dst_uin = localDeviceFileMsgSerial.uint64_dst_uin;
        this.uint64_src_uin = localDeviceFileMsgSerial.uint64_src_uin;
        this.uint32_src_uin_type = localDeviceFileMsgSerial.uint32_src_uin_type;
        this.uint32_dst_uin_type = localDeviceFileMsgSerial.uint32_dst_uin_type;
        this.uint32_src_ter_type = localDeviceFileMsgSerial.uint32_src_ter_type;
        this.uint32_dst_ter_type = localDeviceFileMsgSerial.uint32_dst_ter_type;
        this.vServiceInfo = localDeviceFileMsgSerial.vServiceInfo;
        this.nOpType = localDeviceFileMsgSerial.nOpType;
        this.copies = localDeviceFileMsgSerial.copies;
        this.duplexMode = localDeviceFileMsgSerial.duplexMode;
        this.mediaSize = localDeviceFileMsgSerial.mediaSize;
        this.mediaType = localDeviceFileMsgSerial.mediaType;
        this.scaling = localDeviceFileMsgSerial.scaling;
        this.orientation = localDeviceFileMsgSerial.orientation;
        this.color = localDeviceFileMsgSerial.color;
        this.quality = localDeviceFileMsgSerial.quality;
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        Object localObject = null;
      }
    }
  }
  
  public void postRead()
  {
    parse();
  }
  
  public void prewrite()
  {
    serial();
  }
  
  public void serial()
  {
    MessageForDeviceFile.DeviceFileMsgSerial localDeviceFileMsgSerial = new MessageForDeviceFile.DeviceFileMsgSerial(null);
    localDeviceFileMsgSerial.strServiceName = this.strServiceName;
    localDeviceFileMsgSerial.nFileMsgType = this.nFileMsgType;
    localDeviceFileMsgSerial.filePath = this.filePath;
    localDeviceFileMsgSerial.srcFileName = this.srcFileName;
    localDeviceFileMsgSerial.fileSize = this.fileSize;
    localDeviceFileMsgSerial.nFileStatus = this.nFileStatus;
    localDeviceFileMsgSerial.progress = this.progress;
    localDeviceFileMsgSerial.uSessionID = this.uSessionID;
    localDeviceFileMsgSerial.msgStatus = this.msgStatus;
    localDeviceFileMsgSerial.strRecentMsg = this.msg;
    localDeviceFileMsgSerial.strCoverKey = this.strCoverKey;
    localDeviceFileMsgSerial.strFileKey2 = this.strFileKey2;
    localDeviceFileMsgSerial.strMediaKey = this.strMediaKey;
    localDeviceFileMsgSerial.strCoverKey2 = this.strCoverKey2;
    localDeviceFileMsgSerial.groupId = this.groupId;
    localDeviceFileMsgSerial.groupIndex = this.groupIndex;
    localDeviceFileMsgSerial.groupSize = this.groupSize;
    localDeviceFileMsgSerial.nServerIp = this.nServerIp;
    localDeviceFileMsgSerial.nServerPort = this.nServerPort;
    localDeviceFileMsgSerial.vUrlNotify = this.vUrlNotify;
    localDeviceFileMsgSerial.vTokenKey = this.vTokenKey;
    localDeviceFileMsgSerial.serverPath = this.serverPath;
    localDeviceFileMsgSerial.fileFrom = this.fileFrom;
    localDeviceFileMsgSerial.fileUuid = this.fileUuid;
    localDeviceFileMsgSerial.thumbPath = this.thumbPath;
    localDeviceFileMsgSerial.md5 = this.md5;
    localDeviceFileMsgSerial.uOwnerUin = this.uOwnerUin;
    localDeviceFileMsgSerial.vOfflineFileUUID = this.vOfflineFileUUID;
    localDeviceFileMsgSerial.uChannelType = this.uChannelType;
    localDeviceFileMsgSerial.uint32_src_app_id = this.uint32_src_app_id;
    localDeviceFileMsgSerial.uint32_src_inst_id = this.uint32_src_inst_id;
    localDeviceFileMsgSerial.uint32_dst_app_id = this.uint32_dst_app_id;
    localDeviceFileMsgSerial.uint32_dst_inst_id = this.uint32_dst_inst_id;
    localDeviceFileMsgSerial.uint64_dst_uin = this.uint64_dst_uin;
    localDeviceFileMsgSerial.uint64_src_uin = this.uint64_src_uin;
    localDeviceFileMsgSerial.uint32_src_uin_type = this.uint32_src_uin_type;
    localDeviceFileMsgSerial.uint32_dst_uin_type = this.uint32_dst_uin_type;
    localDeviceFileMsgSerial.uint32_src_ter_type = this.uint32_src_ter_type;
    localDeviceFileMsgSerial.uint32_dst_ter_type = this.uint32_dst_ter_type;
    localDeviceFileMsgSerial.vServiceInfo = this.vServiceInfo;
    localDeviceFileMsgSerial.nOpType = this.nOpType;
    localDeviceFileMsgSerial.copies = this.copies;
    localDeviceFileMsgSerial.duplexMode = this.duplexMode;
    localDeviceFileMsgSerial.mediaSize = this.mediaSize;
    localDeviceFileMsgSerial.mediaType = this.mediaType;
    localDeviceFileMsgSerial.scaling = this.scaling;
    localDeviceFileMsgSerial.orientation = this.orientation;
    localDeviceFileMsgSerial.color = this.color;
    localDeviceFileMsgSerial.quality = this.quality;
    try
    {
      this.msgData = apab.a(localDeviceFileMsgSerial);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForDeviceFile
 * JD-Core Version:    0.7.0.1
 */