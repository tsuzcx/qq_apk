package cooperation.qqdataline.ipc;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bljk;
import com.dataline.mpfile.MpfileTaskRecord;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.MessageRecord;

public class MessageRecordParcel
  implements Parcelable
{
  public static final Parcelable.Creator<MessageRecordParcel> CREATOR = new bljk();
  private MessageRecord a;
  
  public MessageRecordParcel(MessageRecord paramMessageRecord)
  {
    this.a = paramMessageRecord;
  }
  
  private static void a(Bundle paramBundle, MpfileTaskRecord paramMpfileTaskRecord)
  {
    paramBundle.putLong("MpfileTaskRecord.sessionId", paramMpfileTaskRecord.sessionId);
    if (paramMpfileTaskRecord.fileId != null) {
      paramBundle.putString("MpfileTaskRecord.fileId", paramMpfileTaskRecord.fileId);
    }
    if (paramMpfileTaskRecord.fileName != null) {
      paramBundle.putString("MpfileTaskRecord.fileName", paramMpfileTaskRecord.fileName);
    }
    paramBundle.putLong("MpfileTaskRecord.currentSize", paramMpfileTaskRecord.currentSize);
    paramBundle.putLong("MpfileTaskRecord.totalSize", paramMpfileTaskRecord.totalSize);
    if (paramMpfileTaskRecord.fileTime != null) {
      paramBundle.putString("MpfileTaskRecord.fileTime", paramMpfileTaskRecord.fileTime);
    }
    if (paramMpfileTaskRecord.filePath != null) {
      paramBundle.putString("MpfileTaskRecord.filePath", paramMpfileTaskRecord.filePath);
    }
    if (paramMpfileTaskRecord.fileTempPath != null) {
      paramBundle.putString("MpfileTaskRecord.fileTempPath", paramMpfileTaskRecord.fileTempPath);
    }
    paramBundle.putLong("MpfileTaskRecord.din", paramMpfileTaskRecord.din);
  }
  
  private static void a(Bundle paramBundle, DataLineMsgRecord paramDataLineMsgRecord)
  {
    paramBundle.putBoolean("DataLineMsgRecord.issuc", paramDataLineMsgRecord.issuc);
    paramBundle.putFloat("DataLineMsgRecord.progress", paramDataLineMsgRecord.progress);
    if (paramDataLineMsgRecord.path != null) {
      paramBundle.putString("DataLineMsgRecord.path", paramDataLineMsgRecord.path);
    }
    if (paramDataLineMsgRecord.thumbPath != null) {
      paramBundle.putString("DataLineMsgRecord.thumbPath", paramDataLineMsgRecord.thumbPath);
    }
    if (paramDataLineMsgRecord.filename != null) {
      paramBundle.putString("DataLineMsgRecord.filename", paramDataLineMsgRecord.filename);
    }
    paramBundle.putLong("DataLineMsgRecord.filesize", paramDataLineMsgRecord.filesize);
    if (paramDataLineMsgRecord.serverPath != null) {
      paramBundle.putString("DataLineMsgRecord.serverPath", paramDataLineMsgRecord.serverPath);
    }
    if (paramDataLineMsgRecord.md5 != null) {
      paramBundle.putByteArray("DataLineMsgRecord.md5", paramDataLineMsgRecord.md5);
    }
    paramBundle.putLong("DataLineMsgRecord.sessionid", paramDataLineMsgRecord.sessionid);
    paramBundle.putInt("DataLineMsgRecord.groupId", paramDataLineMsgRecord.groupId);
    paramBundle.putInt("DataLineMsgRecord.groupSize", paramDataLineMsgRecord.groupSize);
    paramBundle.putInt("DataLineMsgRecord.groupIndex", paramDataLineMsgRecord.groupIndex);
    paramBundle.putBoolean("DataLineMsgRecord.isReportPause", paramDataLineMsgRecord.isReportPause);
    paramBundle.putLong("DataLineMsgRecord.nServerIp", paramDataLineMsgRecord.nServerIp);
    paramBundle.putLong("DataLineMsgRecord.nServerPort", paramDataLineMsgRecord.nServerPort);
    if (paramDataLineMsgRecord.vUrlNotify != null) {
      paramBundle.putByteArray("DataLineMsgRecord.vUrlNotify", paramDataLineMsgRecord.vUrlNotify);
    }
    if (paramDataLineMsgRecord.vTokenKey != null) {
      paramBundle.putByteArray("DataLineMsgRecord.vTokenKey", paramDataLineMsgRecord.vTokenKey);
    }
    paramBundle.putBoolean("DataLineMsgRecord.bIsResendOrRecvFile", paramDataLineMsgRecord.bIsResendOrRecvFile);
    paramBundle.putLong("DataLineMsgRecord.fileMsgStatus", paramDataLineMsgRecord.fileMsgStatus);
    paramBundle.putLong("DataLineMsgRecord.nWeiyunSessionId", paramDataLineMsgRecord.nWeiyunSessionId);
    if (paramDataLineMsgRecord.strMoloKey != null) {
      paramBundle.putString("DataLineMsgRecord.strMoloKey", paramDataLineMsgRecord.strMoloKey);
    }
    if (paramDataLineMsgRecord.strMoloIconUrl != null) {
      paramBundle.putString("DataLineMsgRecord.strMoloIconUrl", paramDataLineMsgRecord.strMoloIconUrl);
    }
    if (paramDataLineMsgRecord.strMoloSource != null) {
      paramBundle.putString("DataLineMsgRecord.strMoloSource", paramDataLineMsgRecord.strMoloSource);
    }
    if (paramDataLineMsgRecord.strMoloSrcIconUrl != null) {
      paramBundle.putString("DataLineMsgRecord.strMoloSrcIconUrl", paramDataLineMsgRecord.strMoloSrcIconUrl);
    }
    paramBundle.putInt("DataLineMsgRecord.nAppStatus", paramDataLineMsgRecord.nAppStatus);
    paramBundle.putBoolean("DataLineMsgRecord.bIsApkFile", paramDataLineMsgRecord.bIsApkFile);
    paramBundle.putBoolean("DataLineMsgRecord.bIsMoloImage", paramDataLineMsgRecord.bIsMoloImage);
    paramBundle.putLong("DataLineMsgRecord.entityID", paramDataLineMsgRecord.entityID);
  }
  
  private static void a(Bundle paramBundle, MessageRecord paramMessageRecord)
  {
    paramBundle.putLong("Entity._id", paramMessageRecord.getId());
    paramBundle.putInt("Entity._status", paramMessageRecord.getStatus());
    if (paramMessageRecord.selfuin != null) {
      paramBundle.putString("MessageRecord.selfuin", paramMessageRecord.selfuin);
    }
    if (paramMessageRecord.frienduin != null) {
      paramBundle.putString("MessageRecord.frienduin", paramMessageRecord.frienduin);
    }
    if (paramMessageRecord.senderuin != null) {
      paramBundle.putString("MessageRecord.senderuin", paramMessageRecord.senderuin);
    }
    paramBundle.putLong("MessageRecord.time", paramMessageRecord.time);
    if (paramMessageRecord.msg != null) {
      paramBundle.putString("MessageRecord.msg", paramMessageRecord.msg);
    }
    paramBundle.putInt("MessageRecord.msgtype", paramMessageRecord.msgtype);
    paramBundle.putBoolean("MessageRecord.isread", paramMessageRecord.isread);
    paramBundle.putInt("MessageRecord.issend", paramMessageRecord.issend);
    paramBundle.putLong("MessageRecord.msgseq", paramMessageRecord.msgseq);
    paramBundle.putLong("MessageRecord.shmsgseq", paramMessageRecord.shmsgseq);
    paramBundle.putInt("MessageRecord.istroop", paramMessageRecord.istroop);
    paramBundle.putInt("MessageRecord.extraflag", paramMessageRecord.extraflag);
    paramBundle.putInt("MessageRecord.sendFailCode", paramMessageRecord.sendFailCode);
    paramBundle.putLong("MessageRecord.msgId", paramMessageRecord.msgId);
    if (paramMessageRecord.msgData != null) {
      paramBundle.putByteArray("MessageRecord.msgData", paramMessageRecord.msgData);
    }
    paramBundle.putInt("MessageRecord.longMsgIndex", paramMessageRecord.longMsgIndex);
    paramBundle.putInt("MessageRecord.longMsgCount", paramMessageRecord.longMsgCount);
    paramBundle.putInt("MessageRecord.longMsgId", paramMessageRecord.longMsgId);
    paramBundle.putLong("MessageRecord.msgUid", paramMessageRecord.msgUid);
    paramBundle.putLong("MessageRecord.uniseq", paramMessageRecord.uniseq);
    if (paramMessageRecord.extStr != null) {
      paramBundle.putString("MessageRecord.extStr", paramMessageRecord.extStr);
    }
    paramBundle.putBoolean("MessageRecord.isMultiMsg", paramMessageRecord.isMultiMsg);
    paramBundle.putInt("MessageRecord.extInt", paramMessageRecord.extInt);
    paramBundle.putInt("MessageRecord.extLong", paramMessageRecord.extLong);
    paramBundle.putBoolean("MessageRecord.isValid", paramMessageRecord.isValid);
    paramBundle.putInt("MessageRecord.versionCode", paramMessageRecord.versionCode);
    paramBundle.putLong("MessageRecord.vipBubbleID", paramMessageRecord.vipBubbleID);
  }
  
  private static MessageRecordParcel b(Parcel paramParcel)
  {
    Object localObject = paramParcel.readString();
    if (((String)localObject).equals("DataLineMsgRecord"))
    {
      localObject = new DataLineMsgRecord();
      paramParcel = paramParcel.readBundle();
      b(paramParcel, (MessageRecord)localObject);
      b(paramParcel, (DataLineMsgRecord)localObject);
      paramParcel = (Parcel)localObject;
    }
    for (;;)
    {
      if (paramParcel != null)
      {
        return new MessageRecordParcel(paramParcel);
        if (((String)localObject).equals("MpfileTaskRecord"))
        {
          localObject = new MpfileTaskRecord();
          paramParcel = paramParcel.readBundle();
          b(paramParcel, (MessageRecord)localObject);
          b(paramParcel, (MpfileTaskRecord)localObject);
          paramParcel = (Parcel)localObject;
        }
      }
      else
      {
        return null;
      }
      paramParcel = null;
    }
  }
  
  private static void b(Bundle paramBundle, MpfileTaskRecord paramMpfileTaskRecord)
  {
    paramMpfileTaskRecord.sessionId = paramBundle.getLong("MpfileTaskRecord.sessionId");
    paramMpfileTaskRecord.fileId = paramBundle.getString("MpfileTaskRecord.fileId");
    paramMpfileTaskRecord.fileName = paramBundle.getString("MpfileTaskRecord.fileName");
    paramMpfileTaskRecord.currentSize = paramBundle.getLong("MpfileTaskRecord.currentSize");
    paramMpfileTaskRecord.totalSize = paramBundle.getLong("MpfileTaskRecord.totalSize");
    paramMpfileTaskRecord.fileTime = paramBundle.getString("MpfileTaskRecord.fileTime");
    paramMpfileTaskRecord.filePath = paramBundle.getString("MpfileTaskRecord.filePath");
    paramMpfileTaskRecord.fileTempPath = paramBundle.getString("MpfileTaskRecord.fileTempPath");
    paramMpfileTaskRecord.din = paramBundle.getLong("MpfileTaskRecord.din");
  }
  
  private static void b(Bundle paramBundle, DataLineMsgRecord paramDataLineMsgRecord)
  {
    paramDataLineMsgRecord.issuc = paramBundle.getBoolean("DataLineMsgRecord.issuc");
    paramDataLineMsgRecord.progress = paramBundle.getFloat("DataLineMsgRecord.progress");
    paramDataLineMsgRecord.path = paramBundle.getString("DataLineMsgRecord.path");
    paramDataLineMsgRecord.thumbPath = paramBundle.getString("DataLineMsgRecord.thumbPath");
    paramDataLineMsgRecord.filename = paramBundle.getString("DataLineMsgRecord.filename");
    paramDataLineMsgRecord.filesize = paramBundle.getLong("DataLineMsgRecord.filesize");
    paramDataLineMsgRecord.serverPath = paramBundle.getString("DataLineMsgRecord.serverPath");
    paramDataLineMsgRecord.md5 = paramBundle.getByteArray("DataLineMsgRecord.md5");
    paramDataLineMsgRecord.sessionid = paramBundle.getLong("DataLineMsgRecord.sessionid");
    paramDataLineMsgRecord.groupId = paramBundle.getInt("DataLineMsgRecord.groupId");
    paramDataLineMsgRecord.groupSize = paramBundle.getInt("DataLineMsgRecord.groupSize");
    paramDataLineMsgRecord.groupIndex = paramBundle.getInt("DataLineMsgRecord.groupIndex");
    paramDataLineMsgRecord.isReportPause = paramBundle.getBoolean("DataLineMsgRecord.isReportPause");
    paramDataLineMsgRecord.nServerIp = paramBundle.getLong("DataLineMsgRecord.nServerIp");
    paramDataLineMsgRecord.nServerPort = paramBundle.getLong("DataLineMsgRecord.nServerPort");
    paramDataLineMsgRecord.vUrlNotify = paramBundle.getByteArray("DataLineMsgRecord.vUrlNotify");
    paramDataLineMsgRecord.vTokenKey = paramBundle.getByteArray("DataLineMsgRecord.vTokenKey");
    paramDataLineMsgRecord.bIsResendOrRecvFile = paramBundle.getBoolean("DataLineMsgRecord.bIsResendOrRecvFile");
    paramDataLineMsgRecord.fileMsgStatus = paramBundle.getLong("DataLineMsgRecord.fileMsgStatus");
    paramDataLineMsgRecord.nWeiyunSessionId = paramBundle.getLong("DataLineMsgRecord.nWeiyunSessionId");
    paramDataLineMsgRecord.strMoloKey = paramBundle.getString("DataLineMsgRecord.strMoloKey");
    paramDataLineMsgRecord.strMoloIconUrl = paramBundle.getString("DataLineMsgRecord.strMoloIconUrl");
    paramDataLineMsgRecord.strMoloSource = paramBundle.getString("DataLineMsgRecord.strMoloSource");
    paramDataLineMsgRecord.strMoloSrcIconUrl = paramBundle.getString("DataLineMsgRecord.strMoloSrcIconUrl");
    paramDataLineMsgRecord.nAppStatus = paramBundle.getInt("DataLineMsgRecord.nAppStatus");
    paramDataLineMsgRecord.bIsApkFile = paramBundle.getBoolean("DataLineMsgRecord.bIsApkFile");
    paramDataLineMsgRecord.bIsMoloImage = paramBundle.getBoolean("DataLineMsgRecord.bIsMoloImage");
    paramDataLineMsgRecord.entityID = paramBundle.getLong("DataLineMsgRecord.entityID");
  }
  
  private static void b(Bundle paramBundle, MessageRecord paramMessageRecord)
  {
    paramMessageRecord.setId(paramBundle.getLong("Entity._id"));
    paramMessageRecord.setStatus(paramBundle.getInt("Entity._status"));
    paramMessageRecord.selfuin = paramBundle.getString("MessageRecord.selfuin");
    paramMessageRecord.frienduin = paramBundle.getString("MessageRecord.frienduin");
    paramMessageRecord.senderuin = paramBundle.getString("MessageRecord.senderuin");
    paramMessageRecord.time = paramBundle.getLong("MessageRecord.time");
    paramMessageRecord.msg = paramBundle.getString("MessageRecord.msg");
    paramMessageRecord.msgtype = paramBundle.getInt("MessageRecord.msgtype");
    paramMessageRecord.isread = paramBundle.getBoolean("MessageRecord.isread");
    paramMessageRecord.issend = paramBundle.getInt("MessageRecord.issend");
    paramMessageRecord.msgseq = paramBundle.getLong("MessageRecord.msgseq");
    paramMessageRecord.shmsgseq = paramBundle.getLong("MessageRecord.shmsgseq");
    paramMessageRecord.istroop = paramBundle.getInt("MessageRecord.istroop");
    paramMessageRecord.extraflag = paramBundle.getInt("MessageRecord.extraflag");
    paramMessageRecord.sendFailCode = paramBundle.getInt("MessageRecord.sendFailCode");
    paramMessageRecord.msgId = paramBundle.getLong("MessageRecord.msgId");
    paramMessageRecord.msgData = paramBundle.getByteArray("MessageRecord.msgData");
    paramMessageRecord.longMsgIndex = paramBundle.getInt("MessageRecord.longMsgIndex");
    paramMessageRecord.longMsgCount = paramBundle.getInt("MessageRecord.longMsgCount");
    paramMessageRecord.longMsgId = paramBundle.getInt("MessageRecord.longMsgId");
    paramMessageRecord.msgUid = paramBundle.getLong("MessageRecord.msgUid");
    paramMessageRecord.uniseq = paramBundle.getLong("MessageRecord.uniseq");
    paramMessageRecord.extStr = paramBundle.getString("MessageRecord.extStr");
    paramMessageRecord.isMultiMsg = paramBundle.getBoolean("MessageRecord.isMultiMsg");
    paramMessageRecord.extInt = paramBundle.getInt("MessageRecord.extInt");
    paramMessageRecord.extLong = paramBundle.getInt("MessageRecord.extLong");
    paramMessageRecord.isValid = paramBundle.getBoolean("MessageRecord.isValid");
    paramMessageRecord.versionCode = paramBundle.getInt("MessageRecord.versionCode");
    paramMessageRecord.vipBubbleID = paramBundle.getLong("MessageRecord.vipBubbleID");
  }
  
  public MessageRecord a()
  {
    return this.a;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if ((this.a instanceof DataLineMsgRecord))
    {
      paramParcel.writeString("DataLineMsgRecord");
      localBundle = new Bundle();
      a(localBundle, this.a);
      a(localBundle, (DataLineMsgRecord)this.a);
      paramParcel.writeBundle(localBundle);
    }
    while (!(this.a instanceof MpfileTaskRecord)) {
      return;
    }
    paramParcel.writeString("MpfileTaskRecord");
    Bundle localBundle = new Bundle();
    a(localBundle, this.a);
    a(localBundle, (MpfileTaskRecord)this.a);
    paramParcel.writeBundle(localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqdataline.ipc.MessageRecordParcel
 * JD-Core Version:    0.7.0.1
 */