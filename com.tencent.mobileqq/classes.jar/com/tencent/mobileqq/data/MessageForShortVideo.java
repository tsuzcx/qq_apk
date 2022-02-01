package com.tencent.mobileqq.data;

import android.annotation.TargetApi;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.msgbackup.util.MsgBackupRichTextParse;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.pic.LoggerInterface;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.shortvideo.SVUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoDownloadInfo;
import localpb.richMsg.RichMsg.VideoFile;
import tencent.im.msg.hummer.resv.videoFile.ResvAttr;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.VideoFile;

public class MessageForShortVideo
  extends MessageForRichText
  implements Parcelable, MsgBackupRichTextParse, LoggerInterface
{
  public static final int BUSI_TYPE_GUILD_VIDEO = 4601;
  public static final int BUSI_TYPE_MULTI_FORWARD_VIDEO = 1010;
  public static final int BUSI_TYPE_PUBACCOUNT_PERM_VIDEO = 1009;
  public static final int BUSI_TYPE_PUBACCOUNT_TEMP_VIDEO = 1007;
  public static final int BUSI_TYPE_SHORT_VIDEO = 1;
  public static final int BUSI_TYPE_SHORT_VIDEO_PTV = 2;
  public static final int BUSI_TYPE_VIDEO = 0;
  public static final Parcelable.Creator<MessageForShortVideo> CREATOR = new MessageForShortVideo.1();
  public static final int EXTRA_FLAG_FORWARD = 2;
  public static final int EXTRA_FLAG_UPLOAD = 1;
  public static final int FORWARD_CHAT_TYPE_DISCUS = 2;
  public static final int FORWARD_CHAT_TYPE_FRIEND = 0;
  public static final int FORWARD_CHAT_TYPE_NONE = -1;
  public static final int FORWARD_CHAT_TYPE_STRANGERS = 3;
  public static final int FORWARD_CHAT_TYPE_TROOP = 1;
  public static final int PREDOWNLOADED = 0;
  public static final int REPEAT_PLAY = 1;
  public static final int SUB_BUSI_TYPE_GUILD_LONG_VIDEO = 4601;
  public static final int SUB_BUSI_TYPE_GUILD_SHORT_VIDEO = 4602;
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
  public boolean collectFromForward = false;
  public int fileHeight;
  public String fileSource;
  public int fileType;
  public int fileWidth;
  public int forwardID;
  public int fromChatType = -1;
  public String hotVideoIconUrl = "";
  public String hotVideoSubIconUrl = "";
  public String hotVideoTitle = "";
  public String hotVideoUrl = "";
  public boolean isAllowAutoDown = true;
  public boolean isPause = false;
  public boolean isStoryVideo = false;
  public long lastModified;
  public String mLocalMd5;
  public boolean mPreUpload;
  public Runnable mShowProgressTask;
  public String mThumbFilePath;
  public String mVideoFileSourceDir;
  public String md5;
  public boolean mediacodecEncode;
  public int msgTailType = 0;
  public int progress;
  public Runnable progressTask;
  public int redBagStat = 0;
  public int redBagType = 0;
  public boolean sendRawVideo = false;
  public String shortVideoId = "";
  public int specialVideoType = 0;
  public int subBusiType;
  public boolean supportProgressive;
  public boolean syncToStory = false;
  public String templateId = "";
  public String templateName = "";
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
  public int videoKandianType;
  
  private String formatToPeople(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "no";
    case 11: 
      return "mts";
    case 10: 
      return "ts";
    case 9: 
      return "mod";
    case 8: 
      return "mov";
    case 7: 
      return "afs";
    case 6: 
      return "rm";
    case 5: 
      return "rmvb";
    case 4: 
      return "mkv";
    case 3: 
      return "wmv";
    case 2: 
      return "mp4";
    }
    return "avi";
  }
  
  public boolean checkForward()
  {
    if (this.istroop == 9501) {
      return false;
    }
    if (isSendFromLocal())
    {
      if (this.uiOperatorFlag == 2)
      {
        i = this.videoFileStatus;
        if ((i == 5002) || (i == 5001)) {
          return false;
        }
      }
      int i = this.videoFileStatus;
      if ((i == 998) || (i == 1005) || (this.extraflag == 32768) || ((this.videoFileStatus == 1004) && (this.busiType == 0))) {
        return false;
      }
    }
    return true;
  }
  
  public boolean checkIsDanceVideo()
  {
    return this.specialVideoType == 2;
  }
  
  @TargetApi(9)
  public boolean checkIsHotVideo()
  {
    return this.specialVideoType == 1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void doParse()
  {
    RichMsg.VideoFile localVideoFile = new RichMsg.VideoFile();
    int i;
    try
    {
      localVideoFile.mergeFrom(this.msgData);
      i = 1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      i = 0;
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
      this.videoKandianType = localVideoFile.uint32_long_video_kandian_type.get();
      this.binarySet = localVideoFile.uint32_video_binary_set.get();
      this.mediacodecEncode = localVideoFile.bool_is_mediacodec_encode.get();
      boolean bool = localVideoFile.bytes_hotvideo_icon.has();
      String str = "";
      if (bool) {
        localObject = localVideoFile.bytes_hotvideo_icon.get().toStringUtf8();
      } else {
        localObject = "";
      }
      this.hotVideoIconUrl = ((String)localObject);
      if (localVideoFile.bytes_hotvideo_title.has()) {
        localObject = localVideoFile.bytes_hotvideo_title.get().toStringUtf8();
      } else {
        localObject = "";
      }
      this.hotVideoTitle = ((String)localObject);
      if (localVideoFile.bytes_hotvideo_url.has()) {
        localObject = localVideoFile.bytes_hotvideo_url.get().toStringUtf8();
      } else {
        localObject = "";
      }
      this.hotVideoUrl = ((String)localObject);
      if (localVideoFile.bytes_hotvideo_icon_sub.has()) {
        localObject = localVideoFile.bytes_hotvideo_icon_sub.get().toStringUtf8();
      } else {
        localObject = "";
      }
      this.hotVideoSubIconUrl = ((String)localObject);
      if (localVideoFile.uint32_special_video_type.has()) {
        i = localVideoFile.uint32_special_video_type.get();
      } else {
        i = 0;
      }
      this.specialVideoType = i;
      this.msgTailType = localVideoFile.uint32_msg_tail_type.get();
      this.redBagType = localVideoFile.uint32_red_envelope_type.get();
      if (localVideoFile.bytes_shortVideoId.has()) {
        localObject = localVideoFile.bytes_shortVideoId.get().toStringUtf8();
      } else {
        localObject = "";
      }
      this.shortVideoId = ((String)localObject);
      this.redBagStat = localVideoFile.red_envelope_pay_stat.get();
      this.isStoryVideo = localVideoFile.bool_story_video_send_to_recent.get();
      if (localVideoFile.bytes_camera_video_templateid.has()) {
        localObject = localVideoFile.bytes_camera_video_templateid.get().toStringUtf8();
      } else {
        localObject = "";
      }
      this.templateId = ((String)localObject);
      Object localObject = str;
      if (localVideoFile.bytes_camera_video_templatename.has()) {
        localObject = localVideoFile.bytes_camera_video_templatename.get().toStringUtf8();
      }
      this.templateName = ((String)localObject);
    }
    if ("1".equals(getExtInfoFromExtStr(MessageConstants.n))) {
      this.syncToStory = true;
    } else {
      this.syncToStory = false;
    }
    this.sendRawVideo = "1".equals(getExtInfoFromExtStr(MessageConstants.C));
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
    localShortVideoDownloadInfo.b = paramInt;
    localShortVideoDownloadInfo.g = this.uniseq;
    localShortVideoDownloadInfo.c = this.istroop;
    localShortVideoDownloadInfo.d = this.selfuin;
    localShortVideoDownloadInfo.e = this.frienduin;
    localShortVideoDownloadInfo.f = this.senderuin;
    localShortVideoDownloadInfo.a = this.uuid;
    localShortVideoDownloadInfo.i = this.md5;
    paramInt = this.videoFileTime;
    localShortVideoDownloadInfo.l = paramInt;
    localShortVideoDownloadInfo.m = this.videoFileFormat;
    localShortVideoDownloadInfo.l = paramInt;
    localShortVideoDownloadInfo.k = this.thumbMD5;
    return localShortVideoDownloadInfo;
  }
  
  public String getMd5()
  {
    if (!TextUtils.isEmpty(this.md5)) {
      return this.md5;
    }
    return this.mLocalMd5;
  }
  
  public im_msg_body.RichText getRichText()
  {
    int i = this.busiType;
    if (i == 0) {
      return parseMessageForVideo(this);
    }
    if (i == 1) {
      return parseMessageForVideo(this);
    }
    if (i == 2) {
      return parseMessageForVideo(this);
    }
    return null;
  }
  
  public RichMsg.VideoFile getSerialPB()
  {
    RichMsg.VideoFile localVideoFile = new RichMsg.VideoFile();
    localVideoFile.setHasFlag(true);
    PBBytesField localPBBytesField = localVideoFile.bytes_file_name;
    String str = this.videoFileName;
    if (str == null) {
      str = "";
    }
    localPBBytesField.set(ByteStringMicro.copyFromUtf8(str));
    localPBBytesField = localVideoFile.bytes_file_md5;
    str = this.md5;
    if (str == null) {
      str = "";
    }
    localPBBytesField.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(str)));
    localPBBytesField = localVideoFile.bytes_local_file_md5;
    str = this.mLocalMd5;
    if (str == null) {
      str = "";
    }
    localPBBytesField.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(str)));
    localPBBytesField = localVideoFile.bytes_file_uuid;
    str = this.uuid;
    if (str == null) {
      str = "";
    }
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
    str = this.thumbMD5;
    if (str == null) {
      str = "";
    }
    localPBBytesField.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(str)));
    localPBBytesField = localVideoFile.bytes_source;
    str = this.fileSource;
    if (str == null) {
      str = "";
    }
    localPBBytesField.set(ByteStringMicro.copyFromUtf8(str));
    localVideoFile.file_lastmodified.set(this.lastModified);
    localVideoFile.uint32_thumb_file_size.set(this.thumbFileSize);
    localVideoFile.uint32_busi_type.set(this.busiType);
    localVideoFile.uin32_from_chat_type.set(this.fromChatType);
    localVideoFile.uin32_to_chat_type.set(this.toChatType);
    localVideoFile.uin32_uiOperatorFlag.set(this.uiOperatorFlag);
    localPBBytesField = localVideoFile.bytes_video_file_source_dir;
    str = this.mVideoFileSourceDir;
    if (str == null) {
      str = "";
    }
    localPBBytesField.set(ByteStringMicro.copyFromUtf8(str));
    localVideoFile.bool_support_progressive.set(this.supportProgressive);
    localVideoFile.uint32_file_width.set(this.fileWidth);
    localVideoFile.uint32_file_height.set(this.fileHeight);
    localVideoFile.uint32_transfered_size.set(this.transferedSize);
    localVideoFile.uint32_sub_busi_type.set(this.subBusiType);
    localVideoFile.uint32_video_attr.set(this.videoAttr);
    localVideoFile.uint32_long_video_kandian_type.set(this.videoKandianType);
    localVideoFile.uint32_video_binary_set.set(this.binarySet);
    localVideoFile.bool_is_mediacodec_encode.set(this.mediacodecEncode);
    localVideoFile.bytes_hotvideo_title.set(ByteStringMicro.copyFromUtf8(this.hotVideoTitle));
    localVideoFile.bytes_hotvideo_url.set(ByteStringMicro.copyFromUtf8(this.hotVideoUrl));
    localVideoFile.bytes_hotvideo_icon.set(ByteStringMicro.copyFromUtf8(this.hotVideoIconUrl));
    localVideoFile.bytes_hotvideo_icon_sub.set(ByteStringMicro.copyFromUtf8(this.hotVideoSubIconUrl));
    localVideoFile.uint32_special_video_type.set(this.specialVideoType);
    localVideoFile.uint32_msg_tail_type.set(this.msgTailType);
    localVideoFile.uint32_red_envelope_type.set(this.redBagType);
    if (this.shortVideoId != null) {
      localVideoFile.bytes_shortVideoId.set(ByteStringMicro.copyFromUtf8(this.shortVideoId));
    }
    localVideoFile.red_envelope_pay_stat.set(this.redBagStat);
    localVideoFile.bool_story_video_send_to_recent.set(this.isStoryVideo);
    localPBBytesField = localVideoFile.bytes_camera_video_templateid;
    str = this.templateId;
    if (str == null) {
      str = "";
    }
    localPBBytesField.set(ByteStringMicro.copyFromUtf8(str));
    localPBBytesField = localVideoFile.bytes_camera_video_templatename;
    str = this.templateName;
    if (str == null) {
      str = "";
    }
    localPBBytesField.set(ByteStringMicro.copyFromUtf8(str));
    return localVideoFile;
  }
  
  public String getSummaryMsg()
  {
    if (TextUtils.isEmpty(this.msg)) {
      return HardCodeUtil.a(2131904500);
    }
    return this.msg;
  }
  
  public boolean isCancelStatus()
  {
    return this.videoFileStatus == 1004;
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  public boolean needVipBubble()
  {
    return false;
  }
  
  public im_msg_body.RichText parseMessageForVideo(MessageForShortVideo paramMessageForShortVideo)
  {
    im_msg_body.RichText localRichText = new im_msg_body.RichText();
    im_msg_body.Elem localElem = new im_msg_body.Elem();
    paramMessageForShortVideo = parseMsgBodyVideoFile(paramMessageForShortVideo);
    localElem.video_file.set(paramMessageForShortVideo);
    localRichText.elems.add(localElem);
    return localRichText;
  }
  
  public im_msg_body.VideoFile parseMsgBodyVideoFile(MessageForShortVideo paramMessageForShortVideo)
  {
    im_msg_body.VideoFile localVideoFile = new im_msg_body.VideoFile();
    localVideoFile.bytes_file_name.set(ByteStringMicro.copyFromUtf8(paramMessageForShortVideo.videoFileName));
    localVideoFile.bytes_file_md5.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(paramMessageForShortVideo.md5)));
    localVideoFile.bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(paramMessageForShortVideo.uuid));
    localVideoFile.uint32_file_format.set(paramMessageForShortVideo.videoFileFormat);
    localVideoFile.uint32_file_size.set(paramMessageForShortVideo.videoFileSize);
    localVideoFile.uint32_file_time.set(paramMessageForShortVideo.videoFileTime);
    localVideoFile.uint32_thumb_width.set(paramMessageForShortVideo.thumbWidth);
    localVideoFile.uint32_thumb_height.set(paramMessageForShortVideo.thumbHeight);
    localVideoFile.bytes_thumb_file_md5.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(paramMessageForShortVideo.thumbMD5)));
    localVideoFile.bytes_source.set(ByteStringMicro.copyFromUtf8(paramMessageForShortVideo.fileSource));
    localVideoFile.uint32_thumb_file_size.set(paramMessageForShortVideo.thumbFileSize);
    localVideoFile.uint32_busi_type.set(paramMessageForShortVideo.busiType);
    localVideoFile.uint32_from_chat_type.set(paramMessageForShortVideo.fromChatType);
    localVideoFile.uint32_to_chat_type.set(paramMessageForShortVideo.toChatType);
    localVideoFile.bool_support_progressive.set(paramMessageForShortVideo.supportProgressive);
    localVideoFile.uint32_file_width.set(paramMessageForShortVideo.fileWidth);
    localVideoFile.uint32_file_height.set(paramMessageForShortVideo.fileHeight);
    localVideoFile.uint32_sub_busi_type.set(paramMessageForShortVideo.subBusiType);
    localVideoFile.uint32_video_attr.set(paramMessageForShortVideo.videoAttr);
    videoFile.ResvAttr localResvAttr = new videoFile.ResvAttr();
    localResvAttr.uint32_msg_tail_type.set(paramMessageForShortVideo.msgTailType);
    localResvAttr.bytes_hotvideo_icon.set(ByteStringMicro.copyFromUtf8(paramMessageForShortVideo.hotVideoIconUrl));
    localResvAttr.bytes_hotvideo_title.set(ByteStringMicro.copyFromUtf8(paramMessageForShortVideo.hotVideoTitle));
    localResvAttr.bytes_hotvideo_url.set(ByteStringMicro.copyFromUtf8(paramMessageForShortVideo.hotVideoUrl));
    localResvAttr.bytes_hotvideo_icon_sub.set(ByteStringMicro.copyFromUtf8(paramMessageForShortVideo.hotVideoSubIconUrl));
    localResvAttr.uint32_special_video_type.set(paramMessageForShortVideo.specialVideoType);
    localResvAttr.uint32_long_video_kandian_type.set(paramMessageForShortVideo.videoKandianType);
    localVideoFile.bytes_pb_reserve.set(ByteStringMicro.copyFrom(localResvAttr.toByteArray()));
    return localVideoFile;
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
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("\nMessageForShortVideo");
    localStringBuilder1.append(" isLocalSend:");
    localStringBuilder1.append(bool);
    localStringBuilder1.append(" busiType:");
    localStringBuilder1.append(this.busiType);
    localStringBuilder1.append("\n |-");
    localStringBuilder1.append("uniseq:");
    localStringBuilder1.append(this.uniseq);
    localStringBuilder1.append(",(uuid:");
    localStringBuilder1.append(this.uuid);
    localStringBuilder1.append(")");
    localStringBuilder1.append("\n |-");
    localStringBuilder1.append("videoFile");
    localStringBuilder1.append("(");
    localStringBuilder1.append(formatToPeople(this.videoFileFormat));
    localStringBuilder1.append("):");
    localStringBuilder1.append(this.videoFileName);
    localStringBuilder1.append("\n |-");
    localStringBuilder1.append("md5:");
    localStringBuilder1.append(this.md5);
    localStringBuilder1.append("(local:");
    localStringBuilder1.append(this.mLocalMd5);
    localStringBuilder1.append(")");
    localStringBuilder1.append("\n |-");
    localStringBuilder1.append("videoFileSize:");
    localStringBuilder1.append(this.videoFileSize);
    localStringBuilder1.append("\n |-");
    localStringBuilder1.append("isLocalSend:");
    localStringBuilder1.append(bool);
    localStringBuilder1.append("\n |-");
    localStringBuilder1.append("videoFileName:");
    localStringBuilder1.append(this.videoFileName);
    localStringBuilder1.append("\n |-");
    localStringBuilder1.append("mVideoFileSourceDir:");
    localStringBuilder1.append(this.mVideoFileSourceDir);
    localStringBuilder1.append("\n |-");
    localStringBuilder1.append("fileType:");
    localStringBuilder1.append(SVUtils.a(this.fileType));
    localStringBuilder1.append("\n |-");
    localStringBuilder1.append("videoFileStatus:");
    localStringBuilder1.append(SVUtils.b(this.videoFileStatus));
    localStringBuilder1.append("\n |-");
    localStringBuilder1.append("videoFileProgress:");
    localStringBuilder1.append(this.videoFileProgress);
    localStringBuilder1.append("\n |-");
    localStringBuilder1.append("mThumbFile");
    localStringBuilder1.append("(");
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(this.thumbWidth);
    localStringBuilder2.append("*");
    localStringBuilder2.append(this.thumbHeight);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append("):");
    localStringBuilder1.append(this.mThumbFilePath);
    localStringBuilder1.append("\n |-");
    localStringBuilder1.append("thumbMD5:");
    localStringBuilder1.append(this.thumbMD5);
    localStringBuilder1.append("\n |-");
    localStringBuilder1.append("thumbFileSize:");
    localStringBuilder1.append(this.thumbFileSize);
    localStringBuilder1.append("\n |-");
    localStringBuilder1.append("mPreUpload:");
    localStringBuilder1.append(this.mPreUpload);
    localStringBuilder1.append("\n |-");
    localStringBuilder1.append("FromTo:");
    localStringBuilder1.append(this.fromChatType);
    localStringBuilder1.append(" to ");
    localStringBuilder1.append(this.toChatType);
    localStringBuilder1.append(" uiOperatorFlag:");
    localStringBuilder1.append(this.uiOperatorFlag);
    localStringBuilder1.append("\n |-");
    localStringBuilder1.append("uiOperatorFlag:");
    localStringBuilder1.append(this.uiOperatorFlag);
    localStringBuilder1.append("\n |-");
    localStringBuilder1.append("supportProgressive:");
    localStringBuilder1.append(this.supportProgressive);
    localStringBuilder1.append("\n |-");
    localStringBuilder1.append("fileWidth:");
    localStringBuilder1.append(this.fileWidth);
    localStringBuilder1.append("\n |-");
    localStringBuilder1.append("fileHeight:");
    localStringBuilder1.append(this.fileHeight);
    localStringBuilder1.append("\n |-");
    localStringBuilder1.append("transferedSize:");
    localStringBuilder1.append(this.transferedSize);
    localStringBuilder1.append("\n |-");
    localStringBuilder1.append("subBusiType:");
    localStringBuilder1.append(this.subBusiType);
    localStringBuilder1.append("\n |-");
    localStringBuilder1.append("videoAttr:");
    localStringBuilder1.append(this.videoAttr);
    localStringBuilder1.append("\n |-");
    localStringBuilder1.append("videoKandianType:");
    localStringBuilder1.append(this.videoKandianType);
    localStringBuilder1.append("\n |-");
    localStringBuilder1.append("binarySet:");
    localStringBuilder1.append(this.binarySet);
    localStringBuilder1.append("\n |-");
    localStringBuilder1.append("mediacodecEncode:");
    localStringBuilder1.append(this.mediacodecEncode);
    localStringBuilder1.append("\n |-");
    localStringBuilder1.append("hotVideoIconUrl:");
    localStringBuilder1.append(this.hotVideoIconUrl);
    localStringBuilder1.append("\n |-");
    localStringBuilder1.append("hotVideoTitle:");
    localStringBuilder1.append(this.hotVideoTitle);
    localStringBuilder1.append("\n |-");
    localStringBuilder1.append("hotVideoUrl:");
    localStringBuilder1.append(this.hotVideoUrl);
    localStringBuilder1.append("\n |-");
    localStringBuilder1.append("hotVideoSubIconUrl:");
    localStringBuilder1.append(this.hotVideoSubIconUrl);
    localStringBuilder1.append("\n |-");
    localStringBuilder1.append("specialVideoType:");
    localStringBuilder1.append(this.specialVideoType);
    localStringBuilder1.append("\n |-");
    localStringBuilder1.append("uint32_msg_tail_type");
    localStringBuilder1.append(this.msgTailType);
    localStringBuilder1.append("\n |-");
    localStringBuilder1.append("redbagType");
    localStringBuilder1.append(this.redBagType);
    localStringBuilder1.append("\n |-");
    localStringBuilder1.append("shortVideoId");
    localStringBuilder1.append(this.shortVideoId);
    localStringBuilder1.append("\n |-");
    localStringBuilder1.append("redBagStat");
    localStringBuilder1.append(this.redBagStat);
    localStringBuilder1.append("\n |-");
    localStringBuilder1.append("sendRawVideo");
    localStringBuilder1.append(this.sendRawVideo);
    localStringBuilder1.append("\n |-");
    localStringBuilder1.append("isStoryVideo");
    localStringBuilder1.append(this.isStoryVideo);
    localStringBuilder1.append("\n |-");
    localStringBuilder1.append("templateId");
    localStringBuilder1.append(this.templateId);
    return localStringBuilder1.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(toLogString());
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
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
    paramParcel.writeByte((byte)this.supportProgressive);
    paramParcel.writeInt(this.fileWidth);
    paramParcel.writeInt(this.fileHeight);
    paramParcel.writeInt(this.transferedSize);
    paramParcel.writeInt(this.subBusiType);
    paramParcel.writeInt(this.videoAttr);
    paramParcel.writeInt(this.binarySet);
    paramParcel.writeByte((byte)this.mediacodecEncode);
    paramParcel.writeString(this.hotVideoIconUrl);
    paramParcel.writeString(this.hotVideoSubIconUrl);
    paramParcel.writeString(this.hotVideoTitle);
    paramParcel.writeString(this.hotVideoUrl);
    paramParcel.writeInt(this.specialVideoType);
    paramParcel.writeInt(this.msgTailType);
    paramParcel.writeInt(this.redBagType);
    paramParcel.writeString(this.shortVideoId);
    paramParcel.writeInt(this.redBagStat);
    paramParcel.writeByte((byte)this.syncToStory);
    paramParcel.writeInt(this.videoKandianType);
    paramParcel.writeByte((byte)this.sendRawVideo);
    paramParcel.writeString(this.templateId);
    paramParcel.writeString(this.templateName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForShortVideo
 * JD-Core Version:    0.7.0.1
 */