package com.tencent.mobileqq.data;

import android.text.TextUtils;
import atlf;
import auea;
import bhbx;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import localpb.dataline.DatalineMsgData.MsgData;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="time,msgid")
public class DataLineMsgRecord
  extends MessageRecord
  implements Cloneable
{
  public static final int APP_STATUS_INSTALLED = 1;
  public static final int APP_STATUS_NONE = 0;
  public static final int DATALINE_MSG_VERSION_CODE = 104;
  public static final int FILE_MSG_STATUS_COMING = 1;
  public static final int FILE_MSG_STATUS_NONE = 0;
  public static final int FILE_MSG_STATUS_PAUSED = 2;
  public static final int IPAD_DEV_TYPE = 1;
  public static final int MSG_TYPE_DATALINE_APP = -2335;
  public static final int MSG_TYPE_DATALINE_FILE = -2005;
  public static final int MSG_TYPE_DATALINE_GRAY = -5000;
  public static final int MSG_TYPE_DATALINE_MSG_VIDEO = -2009;
  public static final int MSG_TYPE_DATALINE_PIC = -2000;
  public static final int MSG_TYPE_DATALINE_PROMPT = -2334;
  public static final int MSG_TYPE_DATALINE_TEXT = -1000;
  public static final int MSG_TYPE_DATALINE_VIDEO = -2009;
  public static final int PC_DEV_TYPE = 0;
  public static final int SESSION_STATE_DONE = 1;
  public static final int SESSION_STATE_INIT = 0;
  public static final int SESSION_STATE_REVING = 2;
  @notColumn
  public boolean bIsApkFile;
  @notColumn
  public boolean bIsMoloImage;
  @notColumn
  public boolean bIsResendOrRecvFile = false;
  @notColumn
  public boolean bIsSended;
  @notColumn
  public boolean bIsTransfering;
  @notColumn
  public boolean bNoInsertFm;
  public int busId;
  @notColumn
  public int dataline_type;
  @notColumn
  public long entityID;
  @notColumn
  public int fileFrom;
  @notColumn
  public long fileMsgStatus;
  @notColumn
  public String fileUuid;
  public String filename;
  public long filesize;
  public int forwardTroopFileEntrance;
  public int groupId;
  public int groupIndex;
  public int groupSize;
  @notColumn
  public boolean isReportPause = false;
  public boolean issuc;
  public byte[] md5;
  @notColumn
  public int nAppStatus;
  @notColumn
  public int nOpType;
  @notColumn
  public long nServerIp;
  @notColumn
  public long nServerPort;
  @notColumn
  public int nSessionState;
  @notColumn
  public long nWeiyunSessionId = 0L;
  @notColumn
  public int nWeiyunSrcType;
  public String path;
  public float progress;
  public String serverPath;
  public long sessionid;
  @notColumn
  public String strMoloIconUrl;
  @notColumn
  public String strMoloKey;
  @notColumn
  public String strMoloSource;
  @notColumn
  public String strMoloSrcIconUrl;
  @notColumn
  public String strWeiyunDir;
  @notColumn
  public String strWeiyunId;
  @notColumn
  public String strWeiyunMd5;
  @notColumn
  public String strWeiyunSha;
  public String thumbPath;
  @notColumn
  public long uOwnerUin;
  @notColumn
  public byte[] vTokenKey;
  @notColumn
  public byte[] vUrlNotify;
  
  public DataLineMsgRecord()
  {
    this(0);
  }
  
  public DataLineMsgRecord(int paramInt)
  {
    this.selfuin = String.valueOf(AppConstants.DATALINE_PC_UIN);
    this.frienduin = this.selfuin;
    this.senderuin = this.selfuin;
    this.istroop = 6000;
    this.versionCode = 106;
    this.dataline_type = paramInt;
    this.fileFrom = 0;
    this.nOpType = -1;
    this.bIsSended = false;
    this.bNoInsertFm = false;
    this.nWeiyunSrcType = 0;
    this.nSessionState = 0;
  }
  
  public static int getDevTypeBySeId(long paramLong)
  {
    return (int)(paramLong >> 60);
  }
  
  public static int getDevTypeBySet(DataLineMsgSet paramDataLineMsgSet)
  {
    long l2 = 0L;
    long l1 = l2;
    if (paramDataLineMsgSet != null)
    {
      paramDataLineMsgSet = paramDataLineMsgSet.values().iterator();
      l1 = l2;
      if (paramDataLineMsgSet.hasNext()) {
        l1 = ((DataLineMsgRecord)paramDataLineMsgSet.next()).sessionid;
      }
    }
    return getDevTypeBySeId(l1);
  }
  
  public static String getSqlStatment(String paramString, int paramInt)
  {
    String str = tableName();
    paramString = new StringBuilder();
    paramString.append("select * from " + str);
    paramString.append(" order by _id desc limit 60");
    str = paramString.toString();
    paramString.delete(0, paramString.length());
    paramString.append("select * from (" + str + ") order by _id asc");
    return paramString.toString();
  }
  
  public static byte[] longToByte(long paramLong)
  {
    return new byte[] { (byte)(int)paramLong, (byte)(int)(paramLong >> 8), (byte)(int)(paramLong >> 16), (byte)(int)(paramLong >> 24), (byte)(int)(paramLong >> 32), (byte)(int)(paramLong >> 40), (byte)(int)(paramLong >> 48), (byte)(int)(paramLong >> 56) };
  }
  
  public static byte[] packMsgData(DataLineMsgRecord paramDataLineMsgRecord, int paramInt)
  {
    int i = 1;
    if ((paramDataLineMsgRecord.msg == null) || (paramInt == 106)) {}
    try
    {
      localObject1 = new DatalineMsgData.MsgData();
      ((DatalineMsgData.MsgData)localObject1).str_msg.set(paramDataLineMsgRecord.msg);
      ((DatalineMsgData.MsgData)localObject1).uint64_filemsgstatus.set(paramDataLineMsgRecord.fileMsgStatus);
      ((DatalineMsgData.MsgData)localObject1).uint64_weiyunsessionid.set(paramDataLineMsgRecord.nWeiyunSessionId);
      if (paramDataLineMsgRecord.strMoloKey != null) {
        ((DatalineMsgData.MsgData)localObject1).str_molokey.set(paramDataLineMsgRecord.strMoloKey);
      }
      if (paramDataLineMsgRecord.strMoloIconUrl != null) {
        ((DatalineMsgData.MsgData)localObject1).str_moloiconurl.set(paramDataLineMsgRecord.strMoloIconUrl);
      }
      if (paramDataLineMsgRecord.strMoloSource != null) {
        ((DatalineMsgData.MsgData)localObject1).str_molosource.set(paramDataLineMsgRecord.strMoloSource);
      }
      if (paramDataLineMsgRecord.strMoloSrcIconUrl != null) {
        ((DatalineMsgData.MsgData)localObject1).str_molosrcurl.set(paramDataLineMsgRecord.strMoloSrcIconUrl);
      }
      ((DatalineMsgData.MsgData)localObject1).fixed32_ip.set((int)paramDataLineMsgRecord.nServerIp);
      ((DatalineMsgData.MsgData)localObject1).uint32_port.set((int)paramDataLineMsgRecord.nServerPort);
      if (paramDataLineMsgRecord.vUrlNotify != null) {
        ((DatalineMsgData.MsgData)localObject1).bytes_url_notify.set(ByteStringMicro.copyFrom(paramDataLineMsgRecord.vUrlNotify));
      }
      if (paramDataLineMsgRecord.vTokenKey != null) {
        ((DatalineMsgData.MsgData)localObject1).bytes_tokenkey.set(ByteStringMicro.copyFrom(paramDataLineMsgRecord.vTokenKey));
      }
      localObject2 = ((DatalineMsgData.MsgData)localObject1).uint32_isapkfile;
      if (!paramDataLineMsgRecord.bIsApkFile) {
        break label602;
      }
      paramInt = 1;
    }
    catch (UnsupportedEncodingException paramDataLineMsgRecord)
    {
      for (;;)
      {
        try
        {
          Object localObject1;
          Object localObject2;
          ((ByteArrayOutputStream)localObject1).write(longToByte(paramDataLineMsgRecord.fileMsgStatus));
          ((ByteArrayOutputStream)localObject1).write(longToByte(paramDataLineMsgRecord.nWeiyunSessionId));
          ((ByteArrayOutputStream)localObject1).write(paramDataLineMsgRecord.msg.getBytes("UTF-8"));
          paramDataLineMsgRecord.msgData = ((byte[])((ByteArrayOutputStream)localObject1).toByteArray().clone());
          ((ByteArrayOutputStream)localObject1).close();
          return null;
          if (paramInt == 104)
          {
            localObject1 = longToByte(paramDataLineMsgRecord.fileMsgStatus);
            localObject2 = paramDataLineMsgRecord.msg.getBytes("UTF-8");
            paramDataLineMsgRecord.msgData = new byte[localObject2.length + 8];
            System.arraycopy(localObject1, 0, paramDataLineMsgRecord.msgData, 0, localObject1.length);
            System.arraycopy(localObject2, 0, paramDataLineMsgRecord.msgData, localObject1.length, localObject2.length);
            continue;
            paramDataLineMsgRecord = paramDataLineMsgRecord;
            paramDataLineMsgRecord.printStackTrace();
            continue;
          }
          if (paramInt <= 0) {
            continue;
          }
          paramDataLineMsgRecord.msgData = paramDataLineMsgRecord.msg.getBytes("UTF-8");
          continue;
        }
        catch (IOException paramDataLineMsgRecord)
        {
          continue;
        }
        paramInt = 0;
        continue;
        paramInt = 0;
      }
    }
    ((PBUInt32Field)localObject2).set(paramInt);
    localObject2 = ((DatalineMsgData.MsgData)localObject1).uint32_ismoloimage;
    if (paramDataLineMsgRecord.bIsMoloImage)
    {
      paramInt = i;
      ((PBUInt32Field)localObject2).set(paramInt);
      ((DatalineMsgData.MsgData)localObject1).uint32_fileFrom.set(paramDataLineMsgRecord.fileFrom);
      if (paramDataLineMsgRecord.fileUuid != null) {
        ((DatalineMsgData.MsgData)localObject1).str_fileUuid.set(paramDataLineMsgRecord.fileUuid);
      }
      ((DatalineMsgData.MsgData)localObject1).uint32_nOpType.set(paramDataLineMsgRecord.nOpType);
      ((DatalineMsgData.MsgData)localObject1).uint64_entityID.set(paramDataLineMsgRecord.entityID);
      ((DatalineMsgData.MsgData)localObject1).uint64_OwnerUin.set(paramDataLineMsgRecord.uOwnerUin);
      ((DatalineMsgData.MsgData)localObject1).uint32_busId.set(paramDataLineMsgRecord.busId);
      ((DatalineMsgData.MsgData)localObject1).uint32_forwardTroopFileEntranc.set(paramDataLineMsgRecord.forwardTroopFileEntrance);
      ((DatalineMsgData.MsgData)localObject1).bool_sended.set(paramDataLineMsgRecord.bIsSended);
      if (!TextUtils.isEmpty(paramDataLineMsgRecord.strWeiyunId)) {
        ((DatalineMsgData.MsgData)localObject1).str_weiyunid.set(paramDataLineMsgRecord.strWeiyunId);
      }
      if (!TextUtils.isEmpty(paramDataLineMsgRecord.strWeiyunDir)) {
        ((DatalineMsgData.MsgData)localObject1).str_weiyundirkey.set(paramDataLineMsgRecord.strWeiyunDir);
      }
      ((DatalineMsgData.MsgData)localObject1).uint32_weiyunsrctype.set(paramDataLineMsgRecord.nWeiyunSrcType);
      if (!TextUtils.isEmpty(paramDataLineMsgRecord.strWeiyunMd5)) {
        ((DatalineMsgData.MsgData)localObject1).str_weiyunmd5.set(paramDataLineMsgRecord.strWeiyunMd5);
      }
      if (!TextUtils.isEmpty(paramDataLineMsgRecord.strWeiyunSha)) {
        ((DatalineMsgData.MsgData)localObject1).str_weiyunsha.set(paramDataLineMsgRecord.strWeiyunSha);
      }
      return ((DatalineMsgData.MsgData)localObject1).toByteArray();
      if (paramInt == 105) {
        localObject1 = new ByteArrayOutputStream();
      }
    }
  }
  
  public static String tableName()
  {
    return "mr_data_line";
  }
  
  public static String tableName(int paramInt)
  {
    if (paramInt == 1) {
      return "mr_data_line_ipad";
    }
    return "mr_data_line";
  }
  
  public static void unpackMsgData(DataLineMsgRecord paramDataLineMsgRecord, byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool2 = true;
    long l2 = 0L;
    Object localObject1 = null;
    int i = 0;
    if (paramInt == 106) {}
    for (;;)
    {
      Object localObject2;
      try
      {
        localObject2 = new DatalineMsgData.MsgData();
        try
        {
          ((DatalineMsgData.MsgData)localObject2).mergeFrom(paramArrayOfByte);
          if (((DatalineMsgData.MsgData)localObject2).str_msg.has())
          {
            paramArrayOfByte = ((DatalineMsgData.MsgData)localObject2).str_msg.get();
            paramDataLineMsgRecord.msg = paramArrayOfByte;
            if (!((DatalineMsgData.MsgData)localObject2).uint64_filemsgstatus.has()) {
              break label937;
            }
            l1 = ((DatalineMsgData.MsgData)localObject2).uint64_filemsgstatus.get();
            paramDataLineMsgRecord.fileMsgStatus = l1;
            if (!((DatalineMsgData.MsgData)localObject2).uint64_weiyunsessionid.has()) {
              break label943;
            }
            l1 = ((DatalineMsgData.MsgData)localObject2).uint64_weiyunsessionid.get();
            paramDataLineMsgRecord.nWeiyunSessionId = l1;
            if (!((DatalineMsgData.MsgData)localObject2).str_molokey.has()) {
              break label949;
            }
            paramArrayOfByte = ((DatalineMsgData.MsgData)localObject2).str_molokey.get();
            paramDataLineMsgRecord.strMoloKey = paramArrayOfByte;
            if (!((DatalineMsgData.MsgData)localObject2).str_moloiconurl.has()) {
              break label954;
            }
            paramArrayOfByte = ((DatalineMsgData.MsgData)localObject2).str_moloiconurl.get();
            paramDataLineMsgRecord.strMoloIconUrl = paramArrayOfByte;
            if (!((DatalineMsgData.MsgData)localObject2).str_molosource.has()) {
              break label959;
            }
            paramArrayOfByte = ((DatalineMsgData.MsgData)localObject2).str_molosource.get();
            paramDataLineMsgRecord.strMoloSource = paramArrayOfByte;
            if (!((DatalineMsgData.MsgData)localObject2).str_molosrcurl.has()) {
              break label964;
            }
            paramArrayOfByte = ((DatalineMsgData.MsgData)localObject2).str_molosrcurl.get();
            paramDataLineMsgRecord.strMoloSrcIconUrl = paramArrayOfByte;
            if (!((DatalineMsgData.MsgData)localObject2).uint32_isapkfile.has()) {
              break label975;
            }
            if (((DatalineMsgData.MsgData)localObject2).uint32_isapkfile.get() != 1) {
              break label969;
            }
            bool1 = true;
            paramDataLineMsgRecord.bIsApkFile = bool1;
            if (!((DatalineMsgData.MsgData)localObject2).fixed32_ip.has()) {
              break label981;
            }
            l1 = ((DatalineMsgData.MsgData)localObject2).fixed32_ip.get();
            paramDataLineMsgRecord.nServerIp = l1;
            if (!((DatalineMsgData.MsgData)localObject2).uint32_port.has()) {
              break label987;
            }
            l1 = ((DatalineMsgData.MsgData)localObject2).uint32_port.get();
            paramDataLineMsgRecord.nServerPort = l1;
            if (!((DatalineMsgData.MsgData)localObject2).bytes_url_notify.has()) {
              break label993;
            }
            paramArrayOfByte = ((DatalineMsgData.MsgData)localObject2).bytes_url_notify.get().toByteArray();
            paramDataLineMsgRecord.vUrlNotify = paramArrayOfByte;
            if (!((DatalineMsgData.MsgData)localObject2).bytes_tokenkey.has()) {
              break label998;
            }
            paramArrayOfByte = ((DatalineMsgData.MsgData)localObject2).bytes_tokenkey.get().toByteArray();
            paramDataLineMsgRecord.vTokenKey = paramArrayOfByte;
            if (!((DatalineMsgData.MsgData)localObject2).uint32_ismoloimage.has()) {
              break label1009;
            }
            if (((DatalineMsgData.MsgData)localObject2).uint32_ismoloimage.get() != 1) {
              break label1003;
            }
            bool1 = bool2;
            paramDataLineMsgRecord.bIsMoloImage = bool1;
            if (!((DatalineMsgData.MsgData)localObject2).uint32_fileFrom.has()) {
              break label1015;
            }
            paramInt = ((DatalineMsgData.MsgData)localObject2).uint32_fileFrom.get();
            paramDataLineMsgRecord.fileFrom = paramInt;
            if (!((DatalineMsgData.MsgData)localObject2).str_fileUuid.has()) {
              break label1020;
            }
            paramArrayOfByte = ((DatalineMsgData.MsgData)localObject2).str_fileUuid.get();
            paramDataLineMsgRecord.fileUuid = paramArrayOfByte;
            if (!((DatalineMsgData.MsgData)localObject2).uint32_nOpType.has()) {
              break label1025;
            }
            paramInt = ((DatalineMsgData.MsgData)localObject2).uint32_nOpType.get();
            paramDataLineMsgRecord.nOpType = paramInt;
            if (!((DatalineMsgData.MsgData)localObject2).uint64_entityID.has()) {
              break label1030;
            }
            l1 = ((DatalineMsgData.MsgData)localObject2).uint64_entityID.get();
            paramDataLineMsgRecord.entityID = l1;
            l1 = l2;
            if (((DatalineMsgData.MsgData)localObject2).uint64_OwnerUin.has()) {
              l1 = ((DatalineMsgData.MsgData)localObject2).uint64_OwnerUin.get();
            }
            paramDataLineMsgRecord.uOwnerUin = l1;
            if (!((DatalineMsgData.MsgData)localObject2).uint32_busId.has()) {
              break label1036;
            }
            paramInt = ((DatalineMsgData.MsgData)localObject2).uint32_busId.get();
            paramDataLineMsgRecord.busId = paramInt;
            if (!((DatalineMsgData.MsgData)localObject2).uint32_forwardTroopFileEntranc.has()) {
              break label1041;
            }
            paramInt = ((DatalineMsgData.MsgData)localObject2).uint32_forwardTroopFileEntranc.get();
            paramDataLineMsgRecord.forwardTroopFileEntrance = paramInt;
            if (!((DatalineMsgData.MsgData)localObject2).bool_sended.has()) {
              break label1046;
            }
            bool1 = ((DatalineMsgData.MsgData)localObject2).bool_sended.get();
            paramDataLineMsgRecord.bIsSended = bool1;
            if (!((DatalineMsgData.MsgData)localObject2).str_weiyunid.has()) {
              break label1052;
            }
            paramArrayOfByte = ((DatalineMsgData.MsgData)localObject2).str_weiyunid.get();
            paramDataLineMsgRecord.strWeiyunId = paramArrayOfByte;
            if (!((DatalineMsgData.MsgData)localObject2).str_weiyundirkey.has()) {
              break label1057;
            }
            paramArrayOfByte = ((DatalineMsgData.MsgData)localObject2).str_weiyundirkey.get();
            paramDataLineMsgRecord.strWeiyunDir = paramArrayOfByte;
            paramInt = i;
            if (((DatalineMsgData.MsgData)localObject2).uint32_weiyunsrctype.has()) {
              paramInt = ((DatalineMsgData.MsgData)localObject2).uint32_weiyunsrctype.get();
            }
            paramDataLineMsgRecord.nWeiyunSrcType = paramInt;
            if (!((DatalineMsgData.MsgData)localObject2).str_weiyunmd5.has()) {
              break label1062;
            }
            paramArrayOfByte = ((DatalineMsgData.MsgData)localObject2).str_weiyunmd5.get();
            paramDataLineMsgRecord.strWeiyunMd5 = paramArrayOfByte;
            paramArrayOfByte = (byte[])localObject1;
            if (((DatalineMsgData.MsgData)localObject2).str_weiyunsha.has()) {
              paramArrayOfByte = ((DatalineMsgData.MsgData)localObject2).str_weiyunsha.get();
            }
            paramDataLineMsgRecord.strWeiyunSha = paramArrayOfByte;
            return;
          }
        }
        catch (InvalidProtocolBufferMicroException paramDataLineMsgRecord)
        {
          paramDataLineMsgRecord.printStackTrace();
          return;
        }
        paramArrayOfByte = "";
      }
      catch (UnsupportedEncodingException paramDataLineMsgRecord)
      {
        paramDataLineMsgRecord.printStackTrace();
        return;
      }
      continue;
      if (paramInt == 105)
      {
        localObject2 = new byte[8];
        localObject1 = new ByteArrayInputStream(paramArrayOfByte);
        try
        {
          ((ByteArrayInputStream)localObject1).read((byte[])localObject2);
          paramDataLineMsgRecord.fileMsgStatus = bhbx.a((byte[])localObject2);
          ((ByteArrayInputStream)localObject1).read((byte[])localObject2);
          paramDataLineMsgRecord.nWeiyunSessionId = bhbx.a((byte[])localObject2);
          paramArrayOfByte = new byte[paramArrayOfByte.length - 16];
          ((ByteArrayInputStream)localObject1).read(paramArrayOfByte);
          paramDataLineMsgRecord.msg = new String(paramArrayOfByte, "UTF-8");
          ((ByteArrayInputStream)localObject1).close();
          return;
        }
        catch (IOException paramDataLineMsgRecord)
        {
          return;
        }
      }
      if (paramInt == 104)
      {
        localObject1 = new byte[8];
        localObject2 = new byte[paramArrayOfByte.length - 8];
        System.arraycopy(paramArrayOfByte, 0, localObject1, 0, 8);
        System.arraycopy(paramArrayOfByte, 8, localObject2, 0, localObject2.length);
        paramDataLineMsgRecord.fileMsgStatus = bhbx.a((byte[])localObject1);
        paramDataLineMsgRecord.msg = new String((byte[])localObject2, "UTF-8");
        return;
      }
      if (paramInt > 0)
      {
        paramDataLineMsgRecord.msg = new String(paramArrayOfByte, "UTF-8");
        paramDataLineMsgRecord.fileMsgStatus = 0L;
      }
      return;
      label937:
      long l1 = 0L;
      continue;
      label943:
      l1 = 0L;
      continue;
      label949:
      paramArrayOfByte = null;
      continue;
      label954:
      paramArrayOfByte = null;
      continue;
      label959:
      paramArrayOfByte = null;
      continue;
      label964:
      paramArrayOfByte = null;
      continue;
      label969:
      boolean bool1 = false;
      continue;
      label975:
      bool1 = false;
      continue;
      label981:
      l1 = 0L;
      continue;
      label987:
      l1 = 0L;
      continue;
      label993:
      paramArrayOfByte = null;
      continue;
      label998:
      paramArrayOfByte = null;
      continue;
      label1003:
      bool1 = false;
      continue;
      label1009:
      bool1 = false;
      continue;
      label1015:
      paramInt = 0;
      continue;
      label1020:
      paramArrayOfByte = null;
      continue;
      label1025:
      paramInt = -1;
      continue;
      label1030:
      l1 = 0L;
      continue;
      label1036:
      paramInt = 0;
      continue;
      label1041:
      paramInt = 0;
      continue;
      label1046:
      bool1 = false;
      continue;
      label1052:
      paramArrayOfByte = null;
      continue;
      label1057:
      paramArrayOfByte = null;
      continue;
      label1062:
      paramArrayOfByte = null;
    }
  }
  
  public boolean canForward()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (FileUtils.fileExistsAndNotEmpty(this.path))
    {
      bool1 = bool2;
      if (this.strMoloKey == null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public DataLineMsgRecord clone()
  {
    try
    {
      DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)super.clone();
      return localDataLineMsgRecord;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
  
  public void doPrewrite()
  {
    prewrite();
  }
  
  public Class<? extends Entity> getClassForTable()
  {
    return DataLineMsgRecord.class;
  }
  
  public String getTableName()
  {
    if ((this.dataline_type == 1) || (this.sessionid >> 60 == 1L)) {
      return "mr_data_line_ipad";
    }
    return "mr_data_line";
  }
  
  public boolean isForward()
  {
    return (this.nOpType == 31) || (this.nOpType == 29);
  }
  
  public void postRead()
  {
    unpackMsgData(this, this.msgData, this.versionCode);
  }
  
  public void prewrite()
  {
    this.msgData = packMsgData(this, this.versionCode);
  }
  
  public FileManagerEntity trans2Entity()
  {
    FileManagerEntity localFileManagerEntity = null;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (this.entityID != 0L) {
      localFileManagerEntity = localQQAppInterface.getFileManagerDataCenter().a(this.entityID);
    }
    if (localFileManagerEntity == null)
    {
      localFileManagerEntity = new FileManagerEntity();
      localFileManagerEntity.nSessionId = auea.a().longValue();
      this.entityID = localFileManagerEntity.nSessionId;
      switch (this.nOpType)
      {
      }
      for (;;)
      {
        localFileManagerEntity.peerUin = this.selfuin;
        localFileManagerEntity.peerType = this.istroop;
        localFileManagerEntity.fileName = this.filename;
        localFileManagerEntity.fileSize = this.filesize;
        localFileManagerEntity.busId = this.busId;
        localFileManagerEntity.forwardTroopFileEntrance = this.forwardTroopFileEntrance;
        localFileManagerEntity.nOpType = this.nOpType;
        localFileManagerEntity.status = 0;
        localFileManagerEntity.uniseq = this.sessionid;
        localFileManagerEntity.datalineEntitySessionId = this.sessionid;
        localQQAppInterface.getFileManagerDataCenter().d(localFileManagerEntity);
        return localFileManagerEntity;
        localFileManagerEntity.TroopUin = this.uOwnerUin;
        localFileManagerEntity.strTroopFilePath = this.fileUuid;
        localFileManagerEntity.setCloudType(4);
        continue;
        localFileManagerEntity.selfUin = String.valueOf(this.uOwnerUin);
        localFileManagerEntity.Uuid = this.fileUuid;
        localFileManagerEntity.setCloudType(1);
      }
    }
    return localFileManagerEntity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.DataLineMsgRecord
 * JD-Core Version:    0.7.0.1
 */