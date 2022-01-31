package com.tencent.mobileqq.data;

import alpo;
import android.annotation.TargetApi;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import apav;
import ayvj;
import ayyx;
import bepe;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import localpb.richMsg.RichMsg.VideoFile;
import tencent.im.msg.hummer.resv.videoFile.ResvAttr;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype27;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.VideoFile;

public class MessageForShortVideo
  extends MessageForRichText
  implements Parcelable
{
  public static final int BUSI_TYPE_MULTI_FORWARD_VIDEO = 1010;
  public static final int BUSI_TYPE_PUBACCOUNT_PERM_VIDEO = 1009;
  public static final int BUSI_TYPE_PUBACCOUNT_TEMP_VIDEO = 1007;
  public static final int BUSI_TYPE_SHORT_VIDEO = 1;
  public static final int BUSI_TYPE_SHORT_VIDEO_PTV = 2;
  public static final int BUSI_TYPE_VIDEO = 0;
  public static final Parcelable.Creator<MessageForShortVideo> CREATOR = new apav();
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
  public int forwardID;
  public int fromChatType = -1;
  public String hotVideoIconUrl = "";
  public String hotVideoSubIconUrl = "";
  public String hotVideoTitle = "";
  public String hotVideoUrl = "";
  public boolean isAllowAutoDown = true;
  public boolean isPause;
  public boolean isStoryVideo;
  public long lastModified;
  public String mLocalMd5;
  public boolean mPreUpload;
  public bepe mProgressPie;
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
  public boolean sendRawVideo;
  public String shortVideoId = "";
  public int specialVideoType;
  public int subBusiType;
  public boolean supportProgressive;
  public boolean syncToStory;
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
    while ((isSendFromLocal()) && (((this.uiOperatorFlag == 2) && ((this.videoFileStatus == 5002) || (this.videoFileStatus == 5001))) || (this.videoFileStatus == 998) || (this.videoFileStatus == 1005) || (this.extraflag == 32768) || ((this.videoFileStatus == 1004) && (this.busiType == 0)))) {
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
        continue;
        str2 = "";
        continue;
        str2 = "";
        continue;
        this.syncToStory = false;
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
      this.videoKandianType = localVideoFile.uint32_long_video_kandian_type.get();
      this.binarySet = localVideoFile.uint32_video_binary_set.get();
      this.mediacodecEncode = localVideoFile.bool_is_mediacodec_encode.get();
      if (localVideoFile.bytes_hotvideo_icon.has())
      {
        str1 = localVideoFile.bytes_hotvideo_icon.get().toStringUtf8();
        this.hotVideoIconUrl = str1;
        if (!localVideoFile.bytes_hotvideo_title.has()) {
          break label687;
        }
        str1 = localVideoFile.bytes_hotvideo_title.get().toStringUtf8();
        this.hotVideoTitle = str1;
        if (!localVideoFile.bytes_hotvideo_url.has()) {
          break label693;
        }
        str1 = localVideoFile.bytes_hotvideo_url.get().toStringUtf8();
        this.hotVideoUrl = str1;
        if (!localVideoFile.bytes_hotvideo_icon_sub.has()) {
          break label699;
        }
        str1 = localVideoFile.bytes_hotvideo_icon_sub.get().toStringUtf8();
        this.hotVideoSubIconUrl = str1;
        if (!localVideoFile.uint32_special_video_type.has()) {
          break label705;
        }
        i = localVideoFile.uint32_special_video_type.get();
        this.specialVideoType = i;
        this.msgTailType = localVideoFile.uint32_msg_tail_type.get();
        this.redBagType = localVideoFile.uint32_red_envelope_type.get();
        if (!localVideoFile.bytes_shortVideoId.has()) {
          break label710;
        }
        str1 = localVideoFile.bytes_shortVideoId.get().toStringUtf8();
        this.shortVideoId = str1;
        this.redBagStat = localVideoFile.red_envelope_pay_stat.get();
        this.isStoryVideo = localVideoFile.bool_story_video_send_to_recent.get();
        if (!localVideoFile.bytes_camera_video_templateid.has()) {
          break label716;
        }
        str1 = localVideoFile.bytes_camera_video_templateid.get().toStringUtf8();
        this.templateId = str1;
        if (!localVideoFile.bytes_camera_video_templatename.has()) {
          break label722;
        }
        str1 = localVideoFile.bytes_camera_video_templatename.get().toStringUtf8();
        this.templateName = str1;
      }
    }
    else
    {
      if (!"1".equals(getExtInfoFromExtStr(ayvj.n))) {
        break label728;
      }
      this.syncToStory = true;
      this.sendRawVideo = "1".equals(getExtInfoFromExtStr(ayvj.z));
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
  
  public ayyx getDownloadInfo(int paramInt)
  {
    ayyx localayyx = new ayyx();
    localayyx.jdField_a_of_type_Int = paramInt;
    localayyx.jdField_a_of_type_Long = this.uniseq;
    localayyx.jdField_b_of_type_Int = this.istroop;
    localayyx.jdField_b_of_type_JavaLangString = this.selfuin;
    localayyx.jdField_c_of_type_JavaLangString = this.frienduin;
    localayyx.jdField_d_of_type_JavaLangString = this.senderuin;
    localayyx.jdField_a_of_type_JavaLangString = this.uuid;
    localayyx.e = this.md5;
    localayyx.jdField_c_of_type_Int = this.videoFileTime;
    localayyx.jdField_d_of_type_Int = this.videoFileFormat;
    localayyx.jdField_c_of_type_Int = this.videoFileTime;
    localayyx.g = this.thumbMD5;
    return localayyx;
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
    im_msg_body.RichText localRichText = null;
    if ((this instanceof MessageForLightVideo)) {
      localRichText = parseLightVideo(this);
    }
    do
    {
      return localRichText;
      if (this.busiType == 0) {
        return parseMessageForVideo(this);
      }
      if (this.busiType == 1) {
        return parseMessageForVideo(this);
      }
    } while (this.busiType != 2);
    return parseMessageForVideo(this);
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
        break label633;
      }
      str = this.md5;
      label55:
      localPBBytesField.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(str)));
      localPBBytesField = localVideoFile.bytes_local_file_md5;
      if (this.mLocalMd5 == null) {
        break label639;
      }
      str = this.mLocalMd5;
      label83:
      localPBBytesField.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(str)));
      localPBBytesField = localVideoFile.bytes_file_uuid;
      if (this.uuid == null) {
        break label645;
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
        break label651;
      }
      str = this.thumbMD5;
      label224:
      localPBBytesField.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(str)));
      localPBBytesField = localVideoFile.bytes_source;
      if (this.fileSource == null) {
        break label657;
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
        break label663;
      }
      str = this.mVideoFileSourceDir;
      label343:
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
      localVideoFile.bytes_shortVideoId.set(ByteStringMicro.copyFromUtf8(this.shortVideoId));
      localVideoFile.red_envelope_pay_stat.set(this.redBagStat);
      localVideoFile.bool_story_video_send_to_recent.set(this.isStoryVideo);
      localPBBytesField = localVideoFile.bytes_camera_video_templateid;
      if (this.templateId == null) {
        break label669;
      }
      str = this.templateId;
      label592:
      localPBBytesField.set(ByteStringMicro.copyFromUtf8(str));
      localPBBytesField = localVideoFile.bytes_camera_video_templatename;
      if (this.templateName == null) {
        break label675;
      }
    }
    label645:
    label651:
    label657:
    label663:
    label669:
    label675:
    for (String str = this.templateName;; str = "")
    {
      localPBBytesField.set(ByteStringMicro.copyFromUtf8(str));
      return localVideoFile;
      str = "";
      break;
      label633:
      str = "";
      break label55;
      label639:
      str = "";
      break label83;
      str = "";
      break label111;
      str = "";
      break label224;
      str = "";
      break label252;
      str = "";
      break label343;
      str = "";
      break label592;
    }
  }
  
  public String getSummaryMsg()
  {
    if (TextUtils.isEmpty(this.msg)) {
      return alpo.a(2131706996);
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
  
  public im_msg_body.RichText parseLightVideo(MessageForShortVideo paramMessageForShortVideo)
  {
    im_msg_body.RichText localRichText = new im_msg_body.RichText();
    im_msg_body.Elem localElem = new im_msg_body.Elem();
    im_msg_body.CommonElem localCommonElem = new im_msg_body.CommonElem();
    hummer_commelem.MsgElemInfo_servtype27 localMsgElemInfo_servtype27 = new hummer_commelem.MsgElemInfo_servtype27();
    paramMessageForShortVideo = parseMsgBodyVideoFile(paramMessageForShortVideo);
    localMsgElemInfo_servtype27.video_file.set(paramMessageForShortVideo);
    localCommonElem.bytes_pb_elem.set(ByteStringMicro.copyFrom(localMsgElemInfo_servtype27.toByteArray()));
    localCommonElem.uint32_service_type.set(27);
    localCommonElem.uint32_business_type.set(1);
    localElem.common_elem.set(localCommonElem);
    localRichText.elems.add(localElem);
    return localRichText;
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
    localStringBuilder.append("\n |-").append("videoKandianType:").append(this.videoKandianType);
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
    localStringBuilder.append("\n |-").append("sendRawVideo").append(this.sendRawVideo);
    localStringBuilder.append("\n |-").append("isStoryVideo").append(this.isStoryVideo);
    localStringBuilder.append("\n |-").append("templateId").append(this.templateId);
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
        break label412;
      }
      paramInt = 1;
      label274:
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
      if (!this.syncToStory) {
        break label417;
      }
      paramInt = 1;
      label361:
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.videoKandianType);
      if (!this.sendRawVideo) {
        break label422;
      }
    }
    label412:
    label417:
    label422:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.templateId);
      paramParcel.writeString(this.templateName);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label274;
      paramInt = 0;
      break label361;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForShortVideo
 * JD-Core Version:    0.7.0.1
 */