package com.tencent.mobileqq.data;

import abnu;
import android.annotation.TargetApi;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.pic.LoggerInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoDownloadInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.widget.ProgressPieDrawable;
import localpb.richMsg.RichMsg.VideoFile;

public class MessageForShortVideo
  extends MessageForRichText
  implements Parcelable, LoggerInterface
{
  public static final int BUSI_TYPE_MULTI_FORWARD_VIDEO = 1010;
  public static final int BUSI_TYPE_PUBACCOUNT_PERM_VIDEO = 1009;
  public static final int BUSI_TYPE_PUBACCOUNT_TEMP_VIDEO = 1007;
  public static final int BUSI_TYPE_SHORT_VIDEO = 1;
  public static final int BUSI_TYPE_SHORT_VIDEO_PTV = 2;
  public static final int BUSI_TYPE_VIDEO = 0;
  public static final Parcelable.Creator CREATOR = new abnu();
  public static final int EXTRA_FLAG_FORWARD = 2;
  public static final int EXTRA_FLAG_UPLOAD = 1;
  public static final int FORWARD_CHAT_TYPE_DISCUS = 2;
  public static final int FORWARD_CHAT_TYPE_FRIEND = 0;
  public static final int FORWARD_CHAT_TYPE_NONE = -1;
  public static final int FORWARD_CHAT_TYPE_STRANGERS = 3;
  public static final int FORWARD_CHAT_TYPE_TROOP = 1;
  public static final int PREDOWNLOADED = 0;
  public static final int REPEAT_PLAY = 1;
  public static final int VIDEO_FORMAT_AFS = 7;
  public static final int VIDEO_FORMAT_AVI = 1;
  public static final int VIDEO_FORMAT_MKV = 4;
  public static final int VIDEO_FORMAT_MOD = 9;
  public static final int VIDEO_FORMAT_MOV = 8;
  public static final int VIDEO_FORMAT_MP4 = 2;
  public static final int VIDEO_FORMAT_MTS = 11;
  public static final int VIDEO_FORMAT_RM = 6;
  public static final int VIDEO_FORMAT_RMVB = 5;
  public static final int VIDEO_FORMAT_TS = 10;
  public static final int VIDEO_FORMAT_WMV = 3;
  public int binarySet;
  public int busiType;
  public boolean collectFromForward;
  public int fileHeight;
  public String fileSource;
  public int fileType;
  public int fileWidth;
  public int fromChatType = -1;
  public String hotVideoIconUrl = "";
  public String hotVideoSubIconUrl = "";
  public String hotVideoTitle = "";
  public String hotVideoUrl = "";
  public boolean isAllowAutoDown = true;
  public long lastModified;
  public String mLocalMd5;
  public boolean mPreUpload;
  public ProgressPieDrawable mProgressPie;
  public Runnable mShowProgressTask;
  public String mThumbFilePath;
  public String mVideoFileSourceDir;
  public String md5;
  public boolean mediacodecEncode;
  public int msgTailType;
  public int progress;
  public Runnable progressTask;
  public int redBagStat;
  public int redBagType;
  public String shortVideoId = "";
  public int specialVideoType;
  public int subBusiType;
  public boolean supportProgressive;
  public boolean syncToStory;
  public int thumbFileSize;
  public int thumbHeight;
  public String thumbMD5;
  public int thumbWidth;
  public int toChatType = -1;
  public int transferedSize;
  public int uiOperatorFlag;
  public String uuid;
  public int videoAttr;
  public int videoFileFormat;
  public String videoFileName;
  public int videoFileProgress;
  public int videoFileSize;
  public int videoFileStatus;
  public int videoFileTime;
  
  private String formatToPeople(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "no";
    case 1: 
      return "avi";
    case 2: 
      return "mp4";
    case 3: 
      return "wmv";
    case 4: 
      return "mkv";
    case 5: 
      return "rmvb";
    case 6: 
      return "rm";
    case 7: 
      return "afs";
    case 8: 
      return "mov";
    case 9: 
      return "mod";
    case 10: 
      return "ts";
    }
    return "mts";
  }
  
  public boolean CheckIsDanceVideo()
  {
    return this.specialVideoType == 2;
  }
  
  @TargetApi(9)
  public boolean CheckIsHotVideo()
  {
    return this.specialVideoType == 1;
  }
  
  public boolean checkForward()
  {
    if (this.istroop == 9501) {}
    while ((isSendFromLocal()) && (((this.uiOperatorFlag == 2) && ((this.videoFileStatus == 5002) || (this.videoFileStatus == 5001))) || (this.videoFileStatus == 998) || (this.videoFileStatus == 1005) || (this.extraflag == 32768))) {
      return false;
    }
    return true;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void doParse()
  {
    RichMsg.VideoFile localVideoFile = new RichMsg.VideoFile();
    try
    {
      localVideoFile.mergeFrom(this.msgData);
      i = 1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str1;
        localException.printStackTrace();
        int i = 0;
        continue;
        String str2 = "";
        continue;
        str2 = "";
        continue;
        str2 = "";
        continue;
        str2 = "";
        continue;
        i = 0;
        continue;
        str2 = "";
      }
    }
    if (i != 0)
    {
      this.videoFileName = localVideoFile.bytes_file_name.get().toStringUtf8();
      this.uuid = localVideoFile.bytes_file_uuid.get().toStringUtf8();
      this.md5 = HexUtil.bytes2HexStr(localVideoFile.bytes_file_md5.get().toByteArray());
      this.mLocalMd5 = HexUtil.bytes2HexStr(localVideoFile.bytes_local_file_md5.get().toByteArray());
      this.videoFileFormat = localVideoFile.uint32_file_format.get();
      this.videoFileSize = localVideoFile.uint32_file_size.get();
      this.videoFileTime = localVideoFile.uint32_file_time.get();
      this.thumbWidth = localVideoFile.uint32_thumb_width.get();
      this.thumbHeight = localVideoFile.uint32_thumb_height.get();
      this.videoFileStatus = localVideoFile.uint32_file_status.get();
      this.videoFileProgress = localVideoFile.uint32_file_progress.get();
      this.fileType = localVideoFile.uint32_file_type.get();
      this.thumbMD5 = HexUtil.bytes2HexStr(localVideoFile.bytes_thumb_file_md5.get().toByteArray());
      this.fileSource = localVideoFile.bytes_source.get().toStringUtf8();
      this.lastModified = localVideoFile.file_lastmodified.get();
      this.thumbFileSize = localVideoFile.uint32_thumb_file_size.get();
      this.busiType = localVideoFile.uint32_busi_type.get();
      this.fromChatType = localVideoFile.uin32_from_chat_type.get();
      this.toChatType = localVideoFile.uin32_to_chat_type.get();
      this.uiOperatorFlag = localVideoFile.uin32_uiOperatorFlag.get();
      this.mVideoFileSourceDir = localVideoFile.bytes_video_file_source_dir.get().toStringUtf8();
      this.supportProgressive = localVideoFile.bool_support_progressive.get();
      this.fileWidth = localVideoFile.uint32_file_width.get();
      this.fileHeight = localVideoFile.uint32_file_height.get();
      this.transferedSize = localVideoFile.uint32_transfered_size.get();
      this.subBusiType = localVideoFile.uint32_sub_busi_type.get();
      this.videoAttr = localVideoFile.uint32_video_attr.get();
      this.binarySet = localVideoFile.uint32_video_binary_set.get();
      this.mediacodecEncode = localVideoFile.bool_is_mediacodec_encode.get();
      if (localVideoFile.bytes_hotvideo_icon.has())
      {
        str1 = localVideoFile.bytes_hotvideo_icon.get().toStringUtf8();
        this.hotVideoIconUrl = str1;
        if (!localVideoFile.bytes_hotvideo_title.has()) {
          break label575;
        }
        str1 = localVideoFile.bytes_hotvideo_title.get().toStringUtf8();
        this.hotVideoTitle = str1;
        if (!localVideoFile.bytes_hotvideo_url.has()) {
          break label581;
        }
        str1 = localVideoFile.bytes_hotvideo_url.get().toStringUtf8();
        this.hotVideoUrl = str1;
        if (!localVideoFile.bytes_hotvideo_icon_sub.has()) {
          break label587;
        }
        str1 = localVideoFile.bytes_hotvideo_icon_sub.get().toStringUtf8();
        this.hotVideoSubIconUrl = str1;
        if (!localVideoFile.uint32_special_video_type.has()) {
          break label593;
        }
        i = localVideoFile.uint32_special_video_type.get();
        this.specialVideoType = i;
        this.msgTailType = localVideoFile.uint32_msg_tail_type.get();
        this.redBagType = localVideoFile.uint32_red_envelope_type.get();
        if (!localVideoFile.bytes_shortVideoId.has()) {
          break label598;
        }
        str1 = localVideoFile.bytes_shortVideoId.get().toStringUtf8();
        this.shortVideoId = str1;
        this.redBagStat = localVideoFile.red_envelope_pay_stat.get();
      }
    }
    else
    {
      return;
    }
  }
  
  public byte getBitValue(int paramInt)
  {
    return (byte)(this.binarySet >> paramInt & 0x1);
  }
  
  public byte[] getBytes()
  {
    prewrite();
    return this.msgData;
  }
  
  public ShortVideoDownloadInfo getDownloadInfo(int paramInt)
  {
    ShortVideoDownloadInfo localShortVideoDownloadInfo = new ShortVideoDownloadInfo();
    localShortVideoDownloadInfo.jdField_a_of_type_Int = paramInt;
    localShortVideoDownloadInfo.jdField_a_of_type_Long = this.uniseq;
    localShortVideoDownloadInfo.jdField_b_of_type_Int = this.istroop;
    localShortVideoDownloadInfo.jdField_b_of_type_JavaLangString = this.selfuin;
    localShortVideoDownloadInfo.jdField_c_of_type_JavaLangString = this.frienduin;
    localShortVideoDownloadInfo.jdField_d_of_type_JavaLangString = this.senderuin;
    localShortVideoDownloadInfo.jdField_a_of_type_JavaLangString = this.uuid;
    localShortVideoDownloadInfo.e = this.md5;
    localShortVideoDownloadInfo.jdField_c_of_type_Int = this.videoFileTime;
    localShortVideoDownloadInfo.jdField_d_of_type_Int = this.videoFileFormat;
    localShortVideoDownloadInfo.jdField_c_of_type_Int = this.videoFileTime;
    localShortVideoDownloadInfo.g = this.thumbMD5;
    return localShortVideoDownloadInfo;
  }
  
  public String getMd5()
  {
    if (!TextUtils.isEmpty(this.md5)) {
      return this.md5;
    }
    return this.mLocalMd5;
  }
  
  public RichMsg.VideoFile getSerialPB()
  {
    RichMsg.VideoFile localVideoFile = new RichMsg.VideoFile();
    localVideoFile.setHasFlag(true);
    PBBytesField localPBBytesField = localVideoFile.bytes_file_name;
    if (this.videoFileName != null)
    {
      str = this.videoFileName;
      localPBBytesField.set(ByteStringMicro.copyFromUtf8(str));
      localPBBytesField = localVideoFile.bytes_file_md5;
      if (this.md5 == null) {
        break label561;
      }
      str = this.md5;
      label55:
      localPBBytesField.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(str)));
      localPBBytesField = localVideoFile.bytes_local_file_md5;
      if (this.mLocalMd5 == null) {
        break label567;
      }
      str = this.mLocalMd5;
      label83:
      localPBBytesField.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(str)));
      localPBBytesField = localVideoFile.bytes_file_uuid;
      if (this.uuid == null) {
        break label573;
      }
      str = this.uuid;
      label111:
      localPBBytesField.set(ByteStringMicro.copyFromUtf8(str));
      localVideoFile.uint32_file_format.set(this.videoFileFormat);
      localVideoFile.uint32_file_size.set(this.videoFileSize);
      localVideoFile.uint32_file_time.set(this.videoFileTime);
      localVideoFile.uint32_thumb_width.set(this.thumbWidth);
      localVideoFile.uint32_thumb_height.set(this.thumbHeight);
      localVideoFile.uint32_file_status.set(this.videoFileStatus);
      localVideoFile.uint32_file_progress.set(this.videoFileProgress);
      localVideoFile.uint32_file_type.set(this.fileType);
      localPBBytesField = localVideoFile.bytes_thumb_file_md5;
      if (this.thumbMD5 == null) {
        break label579;
      }
      str = this.thumbMD5;
      label224:
      localPBBytesField.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(str)));
      localPBBytesField = localVideoFile.bytes_source;
      if (this.fileSource == null) {
        break label585;
      }
      str = this.fileSource;
      label252:
      localPBBytesField.set(ByteStringMicro.copyFromUtf8(str));
      localVideoFile.file_lastmodified.set(this.lastModified);
      localVideoFile.uint32_thumb_file_size.set(this.thumbFileSize);
      localVideoFile.uint32_busi_type.set(this.busiType);
      localVideoFile.uin32_from_chat_type.set(this.fromChatType);
      localVideoFile.uin32_to_chat_type.set(this.toChatType);
      localVideoFile.uin32_uiOperatorFlag.set(this.uiOperatorFlag);
      localPBBytesField = localVideoFile.bytes_video_file_source_dir;
      if (this.mVideoFileSourceDir == null) {
        break label591;
      }
    }
    label561:
    label567:
    label573:
    label579:
    label585:
    label591:
    for (String str = this.mVideoFileSourceDir;; str = "")
    {
      localPBBytesField.set(ByteStringMicro.copyFromUtf8(str));
      localVideoFile.bool_support_progressive.set(this.supportProgressive);
      localVideoFile.uint32_file_width.set(this.fileWidth);
      localVideoFile.uint32_file_height.set(this.fileHeight);
      localVideoFile.uint32_transfered_size.set(this.transferedSize);
      localVideoFile.uint32_sub_busi_type.set(this.subBusiType);
      localVideoFile.uint32_video_attr.set(this.videoAttr);
      localVideoFile.uint32_video_binary_set.set(this.binarySet);
      localVideoFile.bool_is_mediacodec_encode.set(this.mediacodecEncode);
      localVideoFile.bytes_hotvideo_title.set(ByteStringMicro.copyFromUtf8(this.hotVideoTitle));
      localVideoFile.bytes_hotvideo_url.set(ByteStringMicro.copyFromUtf8(this.hotVideoUrl));
      localVideoFile.bytes_hotvideo_icon.set(ByteStringMicro.copyFromUtf8(this.hotVideoIconUrl));
      localVideoFile.bytes_hotvideo_icon_sub.set(ByteStringMicro.copyFromUtf8(this.hotVideoSubIconUrl));
      localVideoFile.uint32_special_video_type.set(this.specialVideoType);
      localVideoFile.uint32_msg_tail_type.set(this.msgTailType);
      localVideoFile.uint32_red_envelope_type.set(this.redBagType);
      localVideoFile.bytes_shortVideoId.set(ByteStringMicro.copyFromUtf8(this.shortVideoId));
      localVideoFile.red_envelope_pay_stat.set(this.redBagStat);
      return localVideoFile;
      str = "";
      break;
      str = "";
      break label55;
      str = "";
      break label83;
      str = "";
      break label111;
      str = "";
      break label224;
      str = "";
      break label252;
    }
  }
  
  public String getSummaryMsg()
  {
    if (TextUtils.isEmpty(this.msg)) {
      return "[短视频]";
    }
    return this.msg;
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  public boolean needVipBubble()
  {
    return false;
  }
  
  protected void postRead()
  {
    parse();
  }
  
  protected void prewrite()
  {
    serial();
  }
  
  public void serial()
  {
    try
    {
      this.msgData = getSerialPB().toByteArray();
      return;
    }
    finally {}
  }
  
  public void setBitValue(int paramInt, byte paramByte)
  {
    paramInt = (byte)(1 << paramInt);
    if (paramByte > 0)
    {
      this.binarySet = (paramInt | this.binarySet);
      return;
    }
    this.binarySet = ((paramInt ^ 0xFFFFFFFF) & this.binarySet);
  }
  
  public String toLogString()
  {
    boolean bool = isSendFromLocal();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nMessageForShortVideo").append(" isLocalSend:").append(bool).append(" busiType:").append(this.busiType);
    localStringBuilder.append("\n |-").append("uniseq:").append(this.uniseq).append("(uuid:").append(this.uuid).append(")");
    localStringBuilder.append("\n |-").append("videoFile").append("(").append(formatToPeople(this.videoFileFormat)).append("):").append(this.videoFileName);
    localStringBuilder.append("\n |-").append("md5:").append(this.md5).append("(local:").append(this.mLocalMd5).append(")");
    localStringBuilder.append("\n |-").append("videoFileSize:").append(this.videoFileSize);
    localStringBuilder.append("\n |-").append("isLocalSend:").append(bool);
    localStringBuilder.append("\n |-").append("videoFileName:").append(this.videoFileName);
    localStringBuilder.append("\n |-").append("mVideoFileSourceDir:").append(this.mVideoFileSourceDir);
    localStringBuilder.append("\n |-").append("fileType:").append(ShortVideoUtils.a(this.fileType));
    localStringBuilder.append("\n |-").append("videoFileStatus:").append(ShortVideoUtils.b(this.videoFileStatus));
    localStringBuilder.append("\n |-").append("videoFileProgress:").append(this.videoFileProgress);
    localStringBuilder.append("\n |-").append("mThumbFile").append("(").append(this.thumbWidth + "*" + this.thumbHeight).append("):").append(this.mThumbFilePath);
    localStringBuilder.append("\n |-").append("thumbMD5:").append(this.thumbMD5);
    localStringBuilder.append("\n |-").append("thumbFileSize:").append(this.thumbFileSize);
    localStringBuilder.append("\n |-").append("mPreUpload:").append(this.mPreUpload);
    localStringBuilder.append("\n |-").append("FromTo:").append(this.fromChatType).append(" to ").append(this.toChatType).append(" uiOperatorFlag:").append(this.uiOperatorFlag);
    localStringBuilder.append("\n |-").append("uiOperatorFlag:").append(this.uiOperatorFlag);
    localStringBuilder.append("\n |-").append("supportProgressive:").append(this.supportProgressive);
    localStringBuilder.append("\n |-").append("fileWidth:").append(this.fileWidth);
    localStringBuilder.append("\n |-").append("fileHeight:").append(this.fileHeight);
    localStringBuilder.append("\n |-").append("transferedSize:").append(this.transferedSize);
    localStringBuilder.append("\n |-").append("subBusiType:").append(this.subBusiType);
    localStringBuilder.append("\n |-").append("videoAttr:").append(this.videoAttr);
    localStringBuilder.append("\n |-").append("binarySet:").append(this.binarySet);
    localStringBuilder.append("\n |-").append("mediacodecEncode:").append(this.mediacodecEncode);
    localStringBuilder.append("\n |-").append("hotVideoIconUrl:").append(this.hotVideoIconUrl);
    localStringBuilder.append("\n |-").append("hotVideoTitle:").append(this.hotVideoTitle);
    localStringBuilder.append("\n |-").append("hotVideoUrl:").append(this.hotVideoUrl);
    localStringBuilder.append("\n |-").append("hotVideoSubIconUrl:").append(this.hotVideoSubIconUrl);
    localStringBuilder.append("\n |-").append("specialVideoType:").append(this.specialVideoType);
    localStringBuilder.append("\n |-").append("uint32_msg_tail_type").append(this.msgTailType);
    localStringBuilder.append("\n |-").append("redbagType").append(this.redBagType);
    localStringBuilder.append("\n |-").append("shortVideoId").append(this.shortVideoId);
    localStringBuilder.append("\n |-").append("redBagStat").append(this.redBagStat);
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(toLogString());
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeLong(this.uniseq);
    paramParcel.writeInt(this.istroop);
    paramParcel.writeString(this.selfuin);
    paramParcel.writeString(this.frienduin);
    paramParcel.writeString(this.senderuin);
    paramParcel.writeString(this.uuid);
    paramParcel.writeString(this.md5);
    paramParcel.writeString(this.videoFileName);
    paramParcel.writeInt(this.videoFileSize);
    paramParcel.writeInt(this.videoFileFormat);
    paramParcel.writeInt(this.videoFileTime);
    paramParcel.writeInt(this.thumbWidth);
    paramParcel.writeInt(this.thumbHeight);
    paramParcel.writeInt(this.videoFileStatus);
    paramParcel.writeInt(this.videoFileProgress);
    paramParcel.writeInt(this.fileType);
    paramParcel.writeString(this.thumbMD5);
    paramParcel.writeString(this.fileSource);
    paramParcel.writeLong(this.lastModified);
    paramParcel.writeInt(this.thumbFileSize);
    paramParcel.writeInt(this.busiType);
    paramParcel.writeInt(this.fromChatType);
    paramParcel.writeInt(this.toChatType);
    paramParcel.writeInt(this.uiOperatorFlag);
    paramParcel.writeString(this.mVideoFileSourceDir);
    if (this.supportProgressive)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.fileWidth);
      paramParcel.writeInt(this.fileHeight);
      paramParcel.writeInt(this.transferedSize);
      paramParcel.writeInt(this.subBusiType);
      paramParcel.writeInt(this.videoAttr);
      paramParcel.writeInt(this.binarySet);
      if (!this.mediacodecEncode) {
        break label358;
      }
    }
    label358:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.hotVideoIconUrl);
      paramParcel.writeString(this.hotVideoSubIconUrl);
      paramParcel.writeString(this.hotVideoTitle);
      paramParcel.writeString(this.hotVideoUrl);
      paramParcel.writeInt(this.specialVideoType);
      paramParcel.writeInt(this.msgTailType);
      paramParcel.writeInt(this.redBagType);
      paramParcel.writeString(this.shortVideoId);
      paramParcel.writeInt(this.redBagStat);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForShortVideo
 * JD-Core Version:    0.7.0.1
 */