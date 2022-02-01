package com.tencent.mobileqq.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class MessageForShortVideo$1
  implements Parcelable.Creator<MessageForShortVideo>
{
  public MessageForShortVideo a(Parcel paramParcel)
  {
    MessageForShortVideo localMessageForShortVideo = new MessageForShortVideo();
    localMessageForShortVideo.uniseq = paramParcel.readLong();
    localMessageForShortVideo.istroop = paramParcel.readInt();
    localMessageForShortVideo.selfuin = paramParcel.readString();
    localMessageForShortVideo.frienduin = paramParcel.readString();
    localMessageForShortVideo.senderuin = paramParcel.readString();
    localMessageForShortVideo.uuid = paramParcel.readString();
    localMessageForShortVideo.md5 = paramParcel.readString();
    localMessageForShortVideo.videoFileName = paramParcel.readString();
    localMessageForShortVideo.videoFileSize = paramParcel.readInt();
    localMessageForShortVideo.videoFileFormat = paramParcel.readInt();
    localMessageForShortVideo.videoFileTime = paramParcel.readInt();
    localMessageForShortVideo.thumbWidth = paramParcel.readInt();
    localMessageForShortVideo.thumbHeight = paramParcel.readInt();
    localMessageForShortVideo.videoFileStatus = paramParcel.readInt();
    localMessageForShortVideo.videoFileProgress = paramParcel.readInt();
    localMessageForShortVideo.fileType = paramParcel.readInt();
    localMessageForShortVideo.thumbMD5 = paramParcel.readString();
    localMessageForShortVideo.fileSource = paramParcel.readString();
    localMessageForShortVideo.lastModified = paramParcel.readLong();
    localMessageForShortVideo.thumbFileSize = paramParcel.readInt();
    localMessageForShortVideo.busiType = paramParcel.readInt();
    localMessageForShortVideo.fromChatType = paramParcel.readInt();
    localMessageForShortVideo.toChatType = paramParcel.readInt();
    localMessageForShortVideo.uiOperatorFlag = paramParcel.readInt();
    localMessageForShortVideo.mVideoFileSourceDir = paramParcel.readString();
    int i = paramParcel.readByte();
    boolean bool2 = true;
    boolean bool1;
    if (i != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localMessageForShortVideo.supportProgressive = bool1;
    localMessageForShortVideo.fileWidth = paramParcel.readInt();
    localMessageForShortVideo.fileHeight = paramParcel.readInt();
    localMessageForShortVideo.transferedSize = paramParcel.readInt();
    localMessageForShortVideo.subBusiType = paramParcel.readInt();
    localMessageForShortVideo.videoAttr = paramParcel.readInt();
    localMessageForShortVideo.binarySet = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localMessageForShortVideo.mediacodecEncode = bool1;
    localMessageForShortVideo.hotVideoIconUrl = paramParcel.readString();
    localMessageForShortVideo.hotVideoSubIconUrl = paramParcel.readString();
    localMessageForShortVideo.hotVideoTitle = paramParcel.readString();
    localMessageForShortVideo.hotVideoUrl = paramParcel.readString();
    localMessageForShortVideo.specialVideoType = paramParcel.readInt();
    localMessageForShortVideo.msgTailType = paramParcel.readInt();
    localMessageForShortVideo.redBagType = paramParcel.readInt();
    localMessageForShortVideo.shortVideoId = paramParcel.readString();
    localMessageForShortVideo.redBagStat = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localMessageForShortVideo.syncToStory = bool1;
    localMessageForShortVideo.videoKandianType = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    localMessageForShortVideo.sendRawVideo = bool1;
    localMessageForShortVideo.templateId = paramParcel.readString();
    localMessageForShortVideo.templateName = paramParcel.readString();
    return localMessageForShortVideo;
  }
  
  public MessageForShortVideo[] a(int paramInt)
  {
    return new MessageForShortVideo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForShortVideo.1
 * JD-Core Version:    0.7.0.1
 */