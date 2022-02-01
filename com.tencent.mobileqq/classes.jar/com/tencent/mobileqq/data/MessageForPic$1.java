package com.tencent.mobileqq.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.pic.ReportInfo;

final class MessageForPic$1
  implements Parcelable.Creator<MessageForPic>
{
  public MessageForPic a(Parcel paramParcel)
  {
    MessageForPic localMessageForPic = new MessageForPic();
    localMessageForPic.path = paramParcel.readString();
    localMessageForPic.size = paramParcel.readLong();
    localMessageForPic.type = paramParcel.readInt();
    int i = paramParcel.readInt();
    boolean bool2 = false;
    if (i == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localMessageForPic.isRead = bool1;
    localMessageForPic.uuid = paramParcel.readString();
    localMessageForPic.groupFileID = paramParcel.readLong();
    localMessageForPic.md5 = paramParcel.readString();
    localMessageForPic.serverStoreSource = paramParcel.readString();
    localMessageForPic.thumbMsgUrl = paramParcel.readString();
    localMessageForPic.bigThumbMsgUrl = paramParcel.readString();
    localMessageForPic.thumbWidth = paramParcel.readInt();
    localMessageForPic.thumbHeight = paramParcel.readInt();
    localMessageForPic.bigMsgUrl = paramParcel.readString();
    localMessageForPic.rawMsgUrl = paramParcel.readString();
    localMessageForPic.fileSizeFlag = paramParcel.readInt();
    localMessageForPic.picExtraFlag = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localMessageForPic.isMixed = bool1;
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localMessageForPic.isShareAppActionMsg = bool1;
    localMessageForPic.action = paramParcel.readString();
    localMessageForPic.shareAppID = paramParcel.readLong();
    localMessageForPic.actMsgContentValue = paramParcel.readString();
    localMessageForPic.localUUID = paramParcel.readString();
    localMessageForPic.subMsgId = paramParcel.readInt();
    localMessageForPic.isReport = paramParcel.readInt();
    localMessageForPic.subVersion = paramParcel.readInt();
    localMessageForPic.busiType = paramParcel.readInt();
    localMessageForPic.width = paramParcel.readLong();
    localMessageForPic.height = paramParcel.readLong();
    localMessageForPic.imageType = paramParcel.readInt();
    localMessageForPic.frienduin = paramParcel.readString();
    localMessageForPic.selfuin = paramParcel.readString();
    localMessageForPic.senderuin = paramParcel.readString();
    localMessageForPic.istroop = paramParcel.readInt();
    localMessageForPic.versionCode = paramParcel.readInt();
    localMessageForPic.uniseq = paramParcel.readLong();
    localMessageForPic.issend = paramParcel.readInt();
    localMessageForPic.time = paramParcel.readLong();
    localMessageForPic.msgtype = paramParcel.readInt();
    localMessageForPic.preDownState = paramParcel.readInt();
    localMessageForPic.preDownNetworkType = paramParcel.readInt();
    localMessageForPic.previewed = paramParcel.readInt();
    localMessageForPic.mNotPredownloadReason = paramParcel.readInt();
    localMessageForPic.reportInfo = ((ReportInfo)paramParcel.readParcelable(ReportInfo.class.getClassLoader()));
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localMessageForPic.sync2Story = bool1;
    boolean bool1 = bool2;
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    }
    localMessageForPic.isQzonePic = bool1;
    return localMessageForPic;
  }
  
  public MessageForPic[] a(int paramInt)
  {
    return new MessageForPic[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForPic.1
 * JD-Core Version:    0.7.0.1
 */