package com.tencent.mobileqq.shortvideo;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.shortvideo.redbag.VideoRedbagData;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import mqq.app.AppRuntime;
import tencent.im.msg.im_msg_body.RichText;

public class AioShortVideoOperator
  extends BaseShortVideoOprerator
{
  public AioShortVideoOperator() {}
  
  public AioShortVideoOperator(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public static String a(String paramString, int paramInt)
  {
    String str1 = BaseApplicationImpl.sApplication.getRuntime().getAccount();
    int j;
    int i;
    if (str1 != null)
    {
      j = str1.length();
      if (j < 10)
      {
        i = 0;
        while (i < 10 - j)
        {
          str1 = "0".concat(str1);
          i += 1;
        }
      }
    }
    label265:
    for (;;)
    {
      String str2 = paramString;
      if (paramString != null)
      {
        j = paramString.length();
        if (j < 10)
        {
          i = 0;
          for (;;)
          {
            str2 = paramString;
            if (i >= 10 - j) {
              break;
            }
            paramString = "0".concat(paramString);
            i += 1;
          }
          if (j <= 10) {
            break label265;
          }
          str1 = str1.substring(j - 10, j);
          continue;
        }
        str2 = paramString;
        if (j > 10) {
          str2 = paramString.substring(j - 10, j);
        }
      }
      if (paramInt == 0) {
        paramInt = 0;
      }
      for (;;)
      {
        long l = MessageCache.a();
        paramString = new SimpleDateFormat("yyyyMMdd").format(new Date(1000L * l));
        paramString = paramString + str1 + l + paramInt + str2;
        if (QLog.isColorLevel()) {
          QLog.d("AioShortVideoOperator", 2, new Object[] { "VideoRedbag, createRedbagVideoId, videoid = ", paramString });
        }
        return paramString;
        if (paramInt == 3000) {
          paramInt = 2;
        } else if (paramInt == 1) {
          paramInt = 1;
        } else {
          paramInt = 0;
        }
      }
    }
  }
  
  public MessageRecord a(ShortVideoForwardInfo paramShortVideoForwardInfo)
  {
    long l = System.currentTimeMillis();
    MessageForShortVideo localMessageForShortVideo = MessageRecordFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramShortVideoForwardInfo.jdField_c_of_type_JavaLangString, paramShortVideoForwardInfo.jdField_d_of_type_JavaLangString, paramShortVideoForwardInfo.jdField_b_of_type_Int);
    localMessageForShortVideo.videoFileName = paramShortVideoForwardInfo.jdField_h_of_type_JavaLangString;
    if (paramShortVideoForwardInfo.jdField_a_of_type_JavaLangString == null) {
      paramShortVideoForwardInfo.jdField_a_of_type_JavaLangString = "";
    }
    localMessageForShortVideo.uuid = paramShortVideoForwardInfo.jdField_a_of_type_JavaLangString;
    if (paramShortVideoForwardInfo.jdField_e_of_type_JavaLangString == null) {
      paramShortVideoForwardInfo.jdField_e_of_type_JavaLangString = "";
    }
    localMessageForShortVideo.md5 = paramShortVideoForwardInfo.jdField_e_of_type_JavaLangString;
    localMessageForShortVideo.mLocalMd5 = paramShortVideoForwardInfo.jdField_f_of_type_JavaLangString;
    localMessageForShortVideo.videoFileName = paramShortVideoForwardInfo.jdField_k_of_type_JavaLangString;
    localMessageForShortVideo.videoFileFormat = paramShortVideoForwardInfo.jdField_l_of_type_Int;
    localMessageForShortVideo.videoFileSize = paramShortVideoForwardInfo.jdField_i_of_type_Int;
    localMessageForShortVideo.videoFileTime = paramShortVideoForwardInfo.jdField_j_of_type_Int;
    localMessageForShortVideo.thumbWidth = paramShortVideoForwardInfo.jdField_g_of_type_Int;
    localMessageForShortVideo.thumbHeight = paramShortVideoForwardInfo.jdField_h_of_type_Int;
    localMessageForShortVideo.videoFileStatus = 999;
    localMessageForShortVideo.videoFileProgress = 0;
    label284:
    label341:
    String str;
    if (paramShortVideoForwardInfo.jdField_b_of_type_Int == 0)
    {
      localMessageForShortVideo.fileType = 6;
      localMessageForShortVideo.thumbMD5 = paramShortVideoForwardInfo.jdField_g_of_type_JavaLangString;
      if (paramShortVideoForwardInfo.jdField_j_of_type_JavaLangString == null) {
        paramShortVideoForwardInfo.jdField_j_of_type_JavaLangString = "";
      }
      localMessageForShortVideo.fileSource = paramShortVideoForwardInfo.jdField_j_of_type_JavaLangString;
      localMessageForShortVideo.lastModified = 0L;
      localMessageForShortVideo.thumbFileSize = paramShortVideoForwardInfo.jdField_m_of_type_Int;
      localMessageForShortVideo.busiType = paramShortVideoForwardInfo.jdField_f_of_type_Int;
      localMessageForShortVideo.fromChatType = paramShortVideoForwardInfo.jdField_c_of_type_Int;
      localMessageForShortVideo.toChatType = paramShortVideoForwardInfo.jdField_d_of_type_Int;
      localMessageForShortVideo.uiOperatorFlag = 2;
      localMessageForShortVideo.supportProgressive = paramShortVideoForwardInfo.jdField_a_of_type_Boolean;
      localMessageForShortVideo.fileWidth = paramShortVideoForwardInfo.jdField_n_of_type_Int;
      localMessageForShortVideo.fileHeight = paramShortVideoForwardInfo.jdField_o_of_type_Int;
      if (paramShortVideoForwardInfo.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoForwardInfo$RetryInfo == null) {
        break label610;
      }
      i = 1;
      if (i != 0)
      {
        localMessageForShortVideo.msgseq = paramShortVideoForwardInfo.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoForwardInfo$RetryInfo.jdField_a_of_type_Long;
        localMessageForShortVideo.shmsgseq = paramShortVideoForwardInfo.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoForwardInfo$RetryInfo.jdField_b_of_type_Long;
        localMessageForShortVideo.msgUid = paramShortVideoForwardInfo.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoForwardInfo$RetryInfo.jdField_c_of_type_Long;
      }
      if (localMessageForShortVideo.busiType != 2) {
        break label615;
      }
      localMessageForShortVideo.msg = "[视频对讲]";
      if (paramShortVideoForwardInfo.jdField_n_of_type_JavaLangString != null) {
        break label626;
      }
      str = "";
      label352:
      localMessageForShortVideo.hotVideoIconUrl = str;
      if (paramShortVideoForwardInfo.jdField_p_of_type_JavaLangString != null) {
        break label635;
      }
      str = "";
      label370:
      localMessageForShortVideo.hotVideoTitle = str;
      if (paramShortVideoForwardInfo.jdField_q_of_type_JavaLangString != null) {
        break label644;
      }
      str = "";
      label388:
      localMessageForShortVideo.hotVideoUrl = str;
      if (paramShortVideoForwardInfo.jdField_o_of_type_JavaLangString != null) {
        break label653;
      }
      str = "";
      label406:
      localMessageForShortVideo.hotVideoSubIconUrl = str;
      localMessageForShortVideo.specialVideoType = paramShortVideoForwardInfo.jdField_p_of_type_Int;
      localMessageForShortVideo.msgTailType = paramShortVideoForwardInfo.jdField_q_of_type_Int;
      localMessageForShortVideo.redBagType = paramShortVideoForwardInfo.jdField_r_of_type_Int;
      localMessageForShortVideo.shortVideoId = paramShortVideoForwardInfo.jdField_r_of_type_JavaLangString;
      if (localMessageForShortVideo.redBagType == LocalMediaInfo.REDBAG_TYPE_GET) {
        if (!VideoRedbagData.queryRewardStat(localMessageForShortVideo.shortVideoId)) {
          break label662;
        }
      }
    }
    label644:
    label653:
    label662:
    for (int i = 1;; i = 0)
    {
      localMessageForShortVideo.redBagStat = i;
      localMessageForShortVideo.serial();
      paramShortVideoForwardInfo.jdField_a_of_type_Long = localMessageForShortVideo.uniseq;
      Logger.a(this.jdField_g_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, "packForwardMsg", "cost:" + (System.currentTimeMillis() - l));
      Logger.a(this.jdField_g_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, "packForwardMsg", "mr: " + localMessageForShortVideo.toString());
      return localMessageForShortVideo;
      if (paramShortVideoForwardInfo.jdField_b_of_type_Int == 3000)
      {
        localMessageForShortVideo.fileType = 17;
        break;
      }
      if (paramShortVideoForwardInfo.jdField_b_of_type_Int != 1) {
        break;
      }
      localMessageForShortVideo.fileType = 9;
      break;
      label610:
      i = 0;
      break label284;
      label615:
      localMessageForShortVideo.msg = "[视频]";
      break label341;
      label626:
      str = paramShortVideoForwardInfo.jdField_n_of_type_JavaLangString;
      break label352;
      label635:
      str = paramShortVideoForwardInfo.jdField_p_of_type_JavaLangString;
      break label370;
      str = paramShortVideoForwardInfo.jdField_q_of_type_JavaLangString;
      break label388;
      str = paramShortVideoForwardInfo.jdField_o_of_type_JavaLangString;
      break label406;
    }
  }
  
  public MessageRecord a(ShortVideoUploadInfo paramShortVideoUploadInfo)
  {
    long l = System.currentTimeMillis();
    MessageForShortVideo localMessageForShortVideo;
    if (paramShortVideoUploadInfo.jdField_d_of_type_Boolean)
    {
      localMessageForShortVideo = MessageRecordFactory.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramShortVideoUploadInfo.jdField_c_of_type_JavaLangString, paramShortVideoUploadInfo.jdField_d_of_type_JavaLangString, paramShortVideoUploadInfo.jdField_b_of_type_Int);
      localMessageForShortVideo.subBusiType = 1;
      localMessageForShortVideo.videoFileName = paramShortVideoUploadInfo.jdField_h_of_type_JavaLangString;
    }
    label281:
    label932:
    for (;;)
    {
      localMessageForShortVideo.specialVideoType = paramShortVideoUploadInfo.jdField_j_of_type_Int;
      localMessageForShortVideo.msgTailType = paramShortVideoUploadInfo.jdField_k_of_type_Int;
      localMessageForShortVideo.redBagType = paramShortVideoUploadInfo.jdField_l_of_type_Int;
      localMessageForShortVideo.shortVideoId = paramShortVideoUploadInfo.jdField_r_of_type_JavaLangString;
      if (paramShortVideoUploadInfo.jdField_a_of_type_JavaLangString == null) {
        paramShortVideoUploadInfo.jdField_a_of_type_JavaLangString = "";
      }
      localMessageForShortVideo.uuid = paramShortVideoUploadInfo.jdField_a_of_type_JavaLangString;
      if (paramShortVideoUploadInfo.jdField_e_of_type_JavaLangString == null) {
        paramShortVideoUploadInfo.jdField_e_of_type_JavaLangString = "";
      }
      localMessageForShortVideo.md5 = paramShortVideoUploadInfo.jdField_e_of_type_JavaLangString;
      localMessageForShortVideo.videoFileFormat = 2;
      localMessageForShortVideo.videoFileSize = paramShortVideoUploadInfo.jdField_e_of_type_Int;
      localMessageForShortVideo.videoFileTime = paramShortVideoUploadInfo.jdField_f_of_type_Int;
      localMessageForShortVideo.thumbWidth = paramShortVideoUploadInfo.jdField_c_of_type_Int;
      localMessageForShortVideo.thumbHeight = paramShortVideoUploadInfo.jdField_d_of_type_Int;
      localMessageForShortVideo.mThumbFilePath = paramShortVideoUploadInfo.jdField_j_of_type_JavaLangString;
      localMessageForShortVideo.mVideoFileSourceDir = paramShortVideoUploadInfo.jdField_k_of_type_JavaLangString;
      localMessageForShortVideo.videoFileStatus = 999;
      localMessageForShortVideo.videoFileProgress = 0;
      localMessageForShortVideo.extraflag = 32772;
      localMessageForShortVideo.thumbMD5 = paramShortVideoUploadInfo.jdField_g_of_type_JavaLangString;
      if ((paramShortVideoUploadInfo.jdField_l_of_type_JavaLangString == null) || (paramShortVideoUploadInfo.jdField_l_of_type_JavaLangString.length() == 0)) {
        paramShortVideoUploadInfo.jdField_l_of_type_JavaLangString = "camera";
      }
      localMessageForShortVideo.fileSource = paramShortVideoUploadInfo.jdField_l_of_type_JavaLangString;
      localMessageForShortVideo.lastModified = 0L;
      localMessageForShortVideo.mediacodecEncode = paramShortVideoUploadInfo.jdField_c_of_type_Boolean;
      label299:
      Object localObject;
      String str;
      int i;
      if (localMessageForShortVideo.istroop == 0)
      {
        localMessageForShortVideo.fileType = 6;
        if (paramShortVideoUploadInfo.jdField_b_of_type_Int != 1008) {
          break label866;
        }
        localMessageForShortVideo.busiType = 1007;
        if (paramShortVideoUploadInfo.jdField_b_of_type_Int == 0) {
          ConfessMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForShortVideo, paramShortVideoUploadInfo.jdField_c_of_type_JavaLangString);
        }
        localMessageForShortVideo.fromChatType = -1;
        localMessageForShortVideo.toChatType = -1;
        localMessageForShortVideo.uiOperatorFlag = 1;
        localMessageForShortVideo.supportProgressive = paramShortVideoUploadInfo.jdField_b_of_type_Boolean;
        localMessageForShortVideo.fileWidth = paramShortVideoUploadInfo.jdField_h_of_type_Int;
        localMessageForShortVideo.fileHeight = paramShortVideoUploadInfo.jdField_i_of_type_Int;
        localMessageForShortVideo.syncToStory = paramShortVideoUploadInfo.jdField_g_of_type_Boolean;
        localObject = MessageConstants.jdField_o_of_type_JavaLangString;
        if (!localMessageForShortVideo.syncToStory) {
          break label909;
        }
        str = "1";
        localMessageForShortVideo.saveExtInfoToExtStr((String)localObject, str);
        if (paramShortVideoUploadInfo.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo$RetryInfo == null) {
          break label916;
        }
        i = 1;
        if (i != 0)
        {
          localMessageForShortVideo.msgseq = paramShortVideoUploadInfo.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo$RetryInfo.jdField_a_of_type_Long;
          localMessageForShortVideo.shmsgseq = paramShortVideoUploadInfo.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo$RetryInfo.jdField_b_of_type_Long;
          localMessageForShortVideo.msgUid = paramShortVideoUploadInfo.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo$RetryInfo.jdField_c_of_type_Long;
        }
        if (localMessageForShortVideo.busiType != 2) {
          break label921;
        }
      }
      for (localMessageForShortVideo.msg = "[视频对讲]";; localMessageForShortVideo.msg = "[视频]")
      {
        localMessageForShortVideo.serial();
        paramShortVideoUploadInfo.jdField_a_of_type_Long = localMessageForShortVideo.uniseq;
        Logger.a(this.jdField_g_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, "packmsg", "cost:" + (System.currentTimeMillis() - l));
        Logger.a(this.jdField_g_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, "packMsg", "mr: " + localMessageForShortVideo.toLogString() + "-" + localMessageForShortVideo.toString());
        return localMessageForShortVideo;
        if (paramShortVideoUploadInfo.jdField_e_of_type_Boolean)
        {
          localMessageForShortVideo = MessageRecordFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramShortVideoUploadInfo.jdField_c_of_type_JavaLangString, paramShortVideoUploadInfo.jdField_d_of_type_JavaLangString, paramShortVideoUploadInfo.jdField_b_of_type_Int);
          localMessageForShortVideo.subBusiType = 0;
          localMessageForShortVideo.hotVideoIconUrl = paramShortVideoUploadInfo.jdField_m_of_type_JavaLangString;
          localMessageForShortVideo.hotVideoTitle = paramShortVideoUploadInfo.jdField_o_of_type_JavaLangString;
          localMessageForShortVideo.hotVideoUrl = paramShortVideoUploadInfo.jdField_p_of_type_JavaLangString;
          localMessageForShortVideo.hotVideoSubIconUrl = paramShortVideoUploadInfo.jdField_n_of_type_JavaLangString;
          localMessageForShortVideo.videoFileName = paramShortVideoUploadInfo.jdField_q_of_type_JavaLangString;
          localMessageForShortVideo.videoAttr = 0;
          if ((localMessageForShortVideo.videoFileName != null) && (localMessageForShortVideo.videoFileName.length() != 0)) {
            break label932;
          }
          localObject = new StringBuilder();
          if ((paramShortVideoUploadInfo.jdField_e_of_type_JavaLangString == null) || (paramShortVideoUploadInfo.jdField_e_of_type_JavaLangString.length() == 0)) {}
          for (str = "HotVideo";; str = paramShortVideoUploadInfo.jdField_e_of_type_JavaLangString)
          {
            localMessageForShortVideo.videoFileName = (str + ".mp4");
            break;
          }
        }
        if (paramShortVideoUploadInfo.jdField_f_of_type_Boolean)
        {
          localMessageForShortVideo = MessageRecordFactory.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramShortVideoUploadInfo.jdField_c_of_type_JavaLangString, paramShortVideoUploadInfo.jdField_d_of_type_JavaLangString, paramShortVideoUploadInfo.jdField_b_of_type_Int);
          localMessageForShortVideo.subBusiType = 2;
          localMessageForShortVideo.videoFileName = paramShortVideoUploadInfo.jdField_h_of_type_JavaLangString;
          break;
        }
        localMessageForShortVideo = MessageRecordFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramShortVideoUploadInfo.jdField_c_of_type_JavaLangString, paramShortVideoUploadInfo.jdField_d_of_type_JavaLangString, paramShortVideoUploadInfo.jdField_b_of_type_Int);
        localMessageForShortVideo.subBusiType = 0;
        localMessageForShortVideo.videoFileName = paramShortVideoUploadInfo.jdField_h_of_type_JavaLangString;
        break;
        if (localMessageForShortVideo.istroop == 3000)
        {
          localMessageForShortVideo.fileType = 17;
          break label281;
        }
        if (localMessageForShortVideo.istroop != 1) {
          break label281;
        }
        localMessageForShortVideo.fileType = 9;
        break label281;
        label866:
        if (2 == paramShortVideoUploadInfo.jdField_a_of_type_Int)
        {
          localMessageForShortVideo.busiType = 1;
          break label299;
        }
        if (3 == paramShortVideoUploadInfo.jdField_a_of_type_Int)
        {
          localMessageForShortVideo.busiType = 2;
          break label299;
        }
        localMessageForShortVideo.busiType = 0;
        break label299;
        str = "0";
        break label391;
        i = 0;
        break label409;
      }
    }
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    Logger.a(this.jdField_g_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, "attachRichText2Msg", "");
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForRichText)) {
      ((MessageForRichText)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).richText = paramRichText;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  }
  
  public ShortVideoForwardInfo a(Object paramObject, ShortVideoReq paramShortVideoReq)
  {
    if (paramObject == null)
    {
      Logger.b("AioShortVideoOperator", this.jdField_f_of_type_JavaLangString, "createShortVideoForwardInfo", "input == null");
      return null;
    }
    if (paramShortVideoReq == null)
    {
      Logger.b("AioShortVideoOperator", this.jdField_f_of_type_JavaLangString, "createShortVideoForwardInfo", "ShortVideoReq == null");
      return null;
    }
    Object localObject16 = "0";
    Object localObject15 = "0";
    int i9 = 0;
    int i11 = 0;
    int i10 = 0;
    Object localObject13 = "";
    Object localObject12 = "";
    Object localObject11 = "";
    Object localObject10 = "";
    int i8 = 0;
    int i7 = 0;
    String str1 = "";
    Object localObject8 = "";
    Object localObject7 = "";
    int i6 = 2;
    boolean bool = false;
    int i3 = 0;
    int i2 = 0;
    Object localObject3 = "";
    Object localObject5 = "";
    Object localObject2 = "";
    Object localObject4 = "";
    int i12 = 0;
    Object localObject14 = "";
    Object localObject1;
    Object localObject6;
    int i4;
    Object localObject9;
    int i5;
    Object localObject17;
    int i1;
    int n;
    int i;
    if ((paramObject instanceof Intent))
    {
      localObject1 = (Intent)paramObject;
      localObject16 = ((Intent)localObject1).getStringExtra("uin");
      localObject15 = ((Intent)localObject1).getStringExtra("troop_uin");
      i9 = ((Intent)localObject1).getIntExtra("uintype", -1);
      localObject6 = ((Intent)localObject1).getStringExtra("from_uin");
      i4 = ((Intent)localObject1).getIntExtra("from_uin_type", -1);
      localObject5 = ((Intent)localObject1).getStringExtra("from_session_uin");
      ((Intent)localObject1).getIntExtra("from_busi_type", -1);
      i11 = ((Intent)localObject1).getIntExtra("file_send_size", 0);
      i10 = ((Intent)localObject1).getIntExtra("file_send_duration", -1);
      localObject13 = ((Intent)localObject1).getStringExtra("file_send_path");
      localObject12 = ((Intent)localObject1).getStringExtra("thumbfile_send_path");
      localObject11 = ((Intent)localObject1).getStringExtra("file_shortvideo_md5");
      localObject10 = ((Intent)localObject1).getStringExtra("file_shortvideo_local_md5");
      i8 = ((Intent)localObject1).getIntExtra("thumbfile_send_width", 0);
      i7 = ((Intent)localObject1).getIntExtra("thumbfile_send_height", 0);
      str1 = ((Intent)localObject1).getStringExtra("thumbfile_md5");
      localObject9 = ((Intent)localObject1).getStringExtra("file_source");
      localObject8 = ((Intent)localObject1).getStringExtra("file_uuid");
      localObject7 = ((Intent)localObject1).getStringExtra("file_name");
      i6 = ((Intent)localObject1).getIntExtra("file_format", 2);
      i5 = ((Intent)localObject1).getIntExtra("file_thumb_Size", 0);
      bool = ((Intent)localObject1).getBooleanExtra("support_progressive", false);
      i3 = ((Intent)localObject1).getIntExtra("file_width", 0);
      i2 = ((Intent)localObject1).getIntExtra("file_height", 0);
      localObject4 = ((Intent)localObject1).getStringExtra("hot_video_icon");
      localObject3 = ((Intent)localObject1).getStringExtra("hot_video_title");
      localObject17 = ((Intent)localObject1).getStringExtra("hot_video_url");
      localObject2 = ((Intent)localObject1).getStringExtra("hot_video_icon_sub");
      i1 = ((Intent)localObject1).getIntExtra("special_video_type", 0);
      n = ((Intent)localObject1).getIntExtra("short_video_msg_tail_type", 0);
      i = ((Intent)localObject1).getIntExtra("param_key_redbag_type", 0);
      if (i != LocalMediaInfo.REDBAG_TYPE_GET) {
        break label2071;
      }
      if ((!((String)localObject5).equals("0")) && (((String)localObject5).equals(localObject16))) {
        localObject1 = ((Intent)localObject1).getStringExtra("param_key_redbag_video_id");
      }
    }
    for (;;)
    {
      localObject14 = localObject1;
      localObject1 = localObject17;
      int j = 0;
      int m = 0;
      int k = 0;
      for (;;)
      {
        String str2;
        String str3;
        int i15;
        int i16;
        int i17;
        if (TextUtils.isEmpty((CharSequence)localObject11))
        {
          Logger.b(paramShortVideoReq.jdField_b_of_type_JavaLangString, paramShortVideoReq.jdField_a_of_type_JavaLangString, "createShortVideoForwardInfo", "md5 shouldn't be empty ");
          return null;
          localObject1 = a((String)localObject16, i9);
          break;
          if (!(paramObject instanceof MessageForShortVideo)) {
            break label2017;
          }
          localObject12 = (MessageForShortVideo)paramObject;
          str2 = ((MessageForShortVideo)localObject12).frienduin;
          str3 = ((MessageForShortVideo)localObject12).frienduin;
          i15 = ((MessageForShortVideo)localObject12).istroop;
          i16 = ((MessageForShortVideo)localObject12).videoFileSize;
          i17 = ((MessageForShortVideo)localObject12).videoFileTime;
          localObject1 = ((MessageForShortVideo)localObject12).videoFileName;
          localObject7 = ShortVideoUtils.a(((MessageForShortVideo)localObject12).thumbMD5, "jpg");
          localObject8 = ((MessageForShortVideo)localObject12).md5;
          localObject9 = ((MessageForShortVideo)localObject12).mLocalMd5;
          i = ((MessageForShortVideo)localObject12).thumbWidth;
          j = ((MessageForShortVideo)localObject12).thumbHeight;
          str1 = ((MessageForShortVideo)localObject12).thumbMD5;
          localObject10 = ((MessageForShortVideo)localObject12).fileSource;
          localObject6 = ((MessageForShortVideo)localObject12).uuid;
          k = ((MessageForShortVideo)localObject12).videoFileFormat;
          m = ((MessageForShortVideo)localObject12).thumbFileSize;
          n = ((MessageForShortVideo)localObject12).fromChatType;
          i1 = ((MessageForShortVideo)localObject12).toChatType;
          i2 = ((MessageForShortVideo)localObject12).busiType;
          localObject11 = ShortVideoUtils.b((MessageForShortVideo)localObject12);
          bool = ((MessageForShortVideo)localObject12).supportProgressive;
          i3 = ((MessageForShortVideo)localObject12).fileWidth;
          i4 = ((MessageForShortVideo)localObject12).fileHeight;
          i5 = ((MessageForShortVideo)localObject12).specialVideoType;
          i6 = ((MessageForShortVideo)localObject12).msgTailType;
          if (((MessageForShortVideo)localObject12).CheckIsHotVideo())
          {
            localObject3 = ((MessageForShortVideo)localObject12).hotVideoIconUrl;
            localObject2 = ((MessageForShortVideo)localObject12).hotVideoTitle;
            localObject4 = ((MessageForShortVideo)localObject12).hotVideoUrl;
            localObject5 = ((MessageForShortVideo)localObject12).hotVideoSubIconUrl;
          }
          i8 = i12;
          if (paramShortVideoReq.jdField_b_of_type_Int == 5) {
            break label1837;
          }
          i7 = ((MessageForShortVideo)localObject12).redBagType;
          i8 = i7;
          if (i7 != LocalMediaInfo.REDBAG_TYPE_GET) {
            break label1837;
          }
          if ((!"0".equals("0")) && ("0".equals(str2)))
          {
            localObject14 = ((MessageForShortVideo)localObject12).shortVideoId;
            i9 = i7;
            localObject18 = localObject4;
            localObject4 = localObject3;
            str4 = "0";
            localObject17 = localObject11;
            i10 = i2;
            i11 = i1;
            i12 = n;
            i13 = m;
            i14 = k;
            localObject16 = localObject1;
            i18 = -1;
            i7 = j;
            i8 = i;
            localObject11 = localObject9;
            localObject12 = localObject8;
            localObject13 = localObject7;
            localObject15 = localObject1;
            localObject8 = localObject6;
            i = i9;
            n = i6;
            i1 = i5;
            localObject1 = localObject18;
            localObject3 = localObject2;
            localObject2 = localObject5;
            i2 = i4;
            localObject5 = str4;
            localObject6 = localObject17;
            j = i10;
            m = i11;
            k = i12;
            i5 = i13;
            i6 = i14;
            localObject7 = localObject16;
            i4 = i18;
            localObject9 = localObject10;
            localObject10 = localObject11;
            localObject11 = localObject12;
            localObject12 = localObject13;
            localObject13 = localObject15;
            i10 = i17;
            i11 = i16;
            i9 = i15;
            localObject15 = str3;
            localObject16 = str2;
            continue;
          }
          localObject14 = a(str2, i15);
          i9 = i7;
          localObject18 = localObject4;
          localObject4 = localObject3;
          str4 = "0";
          localObject17 = localObject11;
          i10 = i2;
          i11 = i1;
          i12 = n;
          i13 = m;
          i14 = k;
          localObject16 = localObject1;
          i18 = -1;
          i7 = j;
          i8 = i;
          localObject11 = localObject9;
          localObject12 = localObject8;
          localObject13 = localObject7;
          localObject15 = localObject1;
          localObject8 = localObject6;
          i = i9;
          n = i6;
          i1 = i5;
          localObject1 = localObject18;
          localObject3 = localObject2;
          localObject2 = localObject5;
          i2 = i4;
          localObject5 = str4;
          localObject6 = localObject17;
          j = i10;
          m = i11;
          k = i12;
          i5 = i13;
          i6 = i14;
          localObject7 = localObject16;
          i4 = i18;
          localObject9 = localObject10;
          localObject10 = localObject11;
          localObject11 = localObject12;
          localObject12 = localObject13;
          localObject13 = localObject15;
          i10 = i17;
          i11 = i16;
          i9 = i15;
          localObject15 = str3;
          localObject16 = str2;
          continue;
        }
        localObject17 = new ShortVideoForwardInfo();
        ((ShortVideoForwardInfo)localObject17).jdField_c_of_type_JavaLangString = ((String)localObject16);
        ((ShortVideoForwardInfo)localObject17).jdField_h_of_type_JavaLangString = ((String)localObject13);
        ((ShortVideoForwardInfo)localObject17).jdField_i_of_type_JavaLangString = ((String)localObject12);
        ((ShortVideoForwardInfo)localObject17).jdField_b_of_type_Int = i9;
        ((ShortVideoForwardInfo)localObject17).jdField_d_of_type_JavaLangString = ((String)localObject15);
        ((ShortVideoForwardInfo)localObject17).jdField_i_of_type_Int = i11;
        ((ShortVideoForwardInfo)localObject17).jdField_j_of_type_Int = i10;
        ((ShortVideoForwardInfo)localObject17).jdField_e_of_type_JavaLangString = ((String)localObject11);
        ((ShortVideoForwardInfo)localObject17).jdField_f_of_type_JavaLangString = ((String)localObject10);
        ((ShortVideoForwardInfo)localObject17).jdField_g_of_type_Int = i8;
        ((ShortVideoForwardInfo)localObject17).jdField_h_of_type_Int = i7;
        ((ShortVideoForwardInfo)localObject17).jdField_k_of_type_Int = paramShortVideoReq.jdField_a_of_type_Int;
        ((ShortVideoForwardInfo)localObject17).jdField_a_of_type_JavaLangObject = paramObject;
        ((ShortVideoForwardInfo)localObject17).jdField_g_of_type_JavaLangString = str1;
        ((ShortVideoForwardInfo)localObject17).jdField_j_of_type_JavaLangString = ((String)localObject9);
        ((ShortVideoForwardInfo)localObject17).jdField_a_of_type_JavaLangString = ((String)localObject8);
        ((ShortVideoForwardInfo)localObject17).jdField_k_of_type_JavaLangString = ((String)localObject7);
        ((ShortVideoForwardInfo)localObject17).jdField_l_of_type_Int = i6;
        ((ShortVideoForwardInfo)localObject17).jdField_m_of_type_Int = i5;
        ((ShortVideoForwardInfo)localObject17).jdField_a_of_type_Boolean = bool;
        ((ShortVideoForwardInfo)localObject17).jdField_n_of_type_Int = i3;
        ((ShortVideoForwardInfo)localObject17).jdField_o_of_type_Int = i2;
        ((ShortVideoForwardInfo)localObject17).jdField_l_of_type_JavaLangString = ((String)localObject6);
        if (localObject5 != null)
        {
          ((ShortVideoForwardInfo)localObject17).jdField_m_of_type_JavaLangString = ((String)localObject5);
          localObject5 = localObject4;
          if (localObject4 == null) {
            localObject5 = "";
          }
          ((ShortVideoForwardInfo)localObject17).jdField_n_of_type_JavaLangString = ((String)localObject5);
          localObject4 = localObject3;
          if (localObject3 == null) {
            localObject4 = "";
          }
          ((ShortVideoForwardInfo)localObject17).jdField_p_of_type_JavaLangString = ((String)localObject4);
          localObject3 = localObject1;
          if (localObject1 == null) {
            localObject3 = "";
          }
          ((ShortVideoForwardInfo)localObject17).jdField_q_of_type_JavaLangString = ((String)localObject3);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          ((ShortVideoForwardInfo)localObject17).jdField_o_of_type_JavaLangString = ((String)localObject1);
          ((ShortVideoForwardInfo)localObject17).jdField_p_of_type_Int = i1;
          ((ShortVideoForwardInfo)localObject17).jdField_q_of_type_Int = n;
          if (2 == paramShortVideoReq.jdField_b_of_type_Int)
          {
            ((ShortVideoForwardInfo)localObject17).jdField_r_of_type_Int = i;
            ((ShortVideoForwardInfo)localObject17).jdField_r_of_type_JavaLangString = ((String)localObject14);
          }
          if (!(paramObject instanceof Intent)) {
            break label1697;
          }
          if (i4 != 0) {
            break label1624;
          }
          k = 0;
          label1526:
          if (i9 != 0) {
            break label1656;
          }
          i = 0;
          n = k;
          label1537:
          if (i4 != 1008) {
            break label1779;
          }
          k = 1007;
        }
        for (;;)
        {
          ((ShortVideoForwardInfo)localObject17).jdField_c_of_type_Int = n;
          ((ShortVideoForwardInfo)localObject17).jdField_d_of_type_Int = i;
          ((ShortVideoForwardInfo)localObject17).jdField_e_of_type_Int = k;
          ((ShortVideoForwardInfo)localObject17).jdField_f_of_type_Int = j;
          Logger.a(paramShortVideoReq.jdField_b_of_type_JavaLangString, paramShortVideoReq.jdField_a_of_type_JavaLangString, "createShortVideoForwardInfo", "" + ((ShortVideoForwardInfo)localObject17).a());
          return localObject17;
          localObject5 = "0";
          break;
          label1624:
          if (i4 == 1)
          {
            k = 1;
            break label1526;
          }
          if (i4 == 3000)
          {
            k = 2;
            break label1526;
          }
          k = 3;
          break label1526;
          label1656:
          if (i9 == 1)
          {
            i = 1;
            n = k;
            break label1537;
          }
          if (i9 == 3000)
          {
            i = 2;
            n = k;
            break label1537;
          }
          i = 3;
          n = k;
          break label1537;
          label1697:
          i = m;
          n = k;
          if (!(paramObject instanceof MessageForShortVideo)) {
            break label1537;
          }
          i = m;
          n = k;
          if (m != -1) {
            break label1537;
          }
          if (i9 == 0)
          {
            i = 0;
            n = k;
            break label1537;
          }
          if (i9 == 1)
          {
            i = 1;
            n = k;
            break label1537;
          }
          if (i9 == 3000)
          {
            i = 2;
            n = k;
            break label1537;
          }
          i = 3;
          n = k;
          break label1537;
          label1779:
          if (2 == paramShortVideoReq.jdField_b_of_type_Int)
          {
            j = 1;
            k = 1;
          }
          else if (3 == paramShortVideoReq.jdField_b_of_type_Int)
          {
            j = 2;
            k = 2;
          }
          else if (5 == paramShortVideoReq.jdField_b_of_type_Int)
          {
            k = j;
          }
          else
          {
            j = 0;
            k = 0;
          }
        }
        label1837:
        i9 = i8;
        Object localObject18 = localObject4;
        localObject4 = localObject3;
        String str4 = "0";
        localObject17 = localObject11;
        i10 = i2;
        i11 = i1;
        i12 = n;
        int i13 = m;
        int i14 = k;
        localObject16 = localObject1;
        int i18 = -1;
        i7 = j;
        i8 = i;
        localObject11 = localObject9;
        localObject12 = localObject8;
        localObject13 = localObject7;
        localObject15 = localObject1;
        localObject8 = localObject6;
        i = i9;
        n = i6;
        i1 = i5;
        localObject1 = localObject18;
        localObject3 = localObject2;
        localObject2 = localObject5;
        i2 = i4;
        localObject5 = str4;
        localObject6 = localObject17;
        j = i10;
        m = i11;
        k = i12;
        i5 = i13;
        i6 = i14;
        localObject7 = localObject16;
        i4 = i18;
        localObject9 = localObject10;
        localObject10 = localObject11;
        localObject11 = localObject12;
        localObject12 = localObject13;
        localObject13 = localObject15;
        i10 = i17;
        i11 = i16;
        i9 = i15;
        localObject15 = str3;
        localObject16 = str2;
        continue;
        label2017:
        localObject2 = "";
        localObject1 = "";
        n = 0;
        i = 0;
        i1 = 0;
        localObject4 = "";
        localObject3 = "";
        localObject6 = "0";
        localObject5 = "0";
        m = 0;
        k = 0;
        i5 = 0;
        j = 0;
        localObject9 = "";
        i4 = -1;
      }
      label2071:
      localObject1 = "";
    }
  }
  
  public ShortVideoUploadInfo a(Object paramObject, ShortVideoReq paramShortVideoReq)
  {
    if (paramObject == null)
    {
      Logger.a(this.jdField_g_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, "createShortVideoUploadInfo", "unknow obj");
      return null;
    }
    String str6 = "0";
    String str5 = "0";
    int i5 = 0;
    long l2 = 0L;
    int i4 = 0;
    int i3 = 0;
    String str4 = "";
    String str3 = "";
    String str2 = "";
    String str1 = "";
    int i2 = 0;
    int i1 = 0;
    Object localObject9 = "";
    Object localObject8 = "";
    boolean bool3 = false;
    int n = 0;
    int m = 0;
    boolean bool2 = false;
    boolean bool1 = false;
    Object localObject1;
    Object localObject7;
    Object localObject5;
    Object localObject4;
    Object localObject6;
    Object localObject2;
    long l1;
    int k;
    Object localObject3;
    int j;
    int i;
    if ((paramObject instanceof Intent))
    {
      localObject1 = (Intent)paramObject;
      str6 = ((Intent)localObject1).getStringExtra("uin");
      str5 = ((Intent)localObject1).getStringExtra("troop_uin");
      i5 = ((Intent)localObject1).getIntExtra("uintype", 1003);
      l2 = ((Intent)localObject1).getLongExtra("file_send_size", 0L);
      i4 = ((Intent)localObject1).getIntExtra("file_send_business_type", 0);
      i3 = ((Intent)localObject1).getIntExtra("file_send_duration", -1);
      str4 = ((Intent)localObject1).getStringExtra("file_send_path");
      str3 = ((Intent)localObject1).getStringExtra("thumbfile_send_path");
      str1 = ((Intent)localObject1).getStringExtra("file_shortvideo_md5");
      i2 = ((Intent)localObject1).getIntExtra("thumbfile_send_width", 0);
      i1 = ((Intent)localObject1).getIntExtra("thumbfile_send_height", 0);
      localObject9 = ((Intent)localObject1).getStringExtra("thumbfile_md5");
      localObject8 = ((Intent)localObject1).getStringExtra("file_source");
      str2 = ((Intent)localObject1).getStringExtra("file_video_source_dir");
      bool3 = ((Intent)localObject1).getBooleanExtra("support_progressive", false);
      n = ((Intent)localObject1).getIntExtra("file_width", 0);
      m = ((Intent)localObject1).getIntExtra("file_height", 0);
      bool2 = ((Intent)localObject1).getBooleanExtra("video_sync_to_story", false);
      bool1 = ((Intent)localObject1).getBooleanExtra("mediacodec_encode_enable", false);
      localObject7 = ((Intent)localObject1).getStringExtra("hot_video_icon");
      localObject5 = ((Intent)localObject1).getStringExtra("hot_video_title");
      localObject4 = ((Intent)localObject1).getStringExtra("hot_video_url");
      localObject6 = ((Intent)localObject1).getStringExtra("hot_video_icon_sub");
      localObject2 = ((Intent)localObject1).getStringExtra("file_uuid");
      l1 = ((Intent)localObject1).getLongExtra("file_thumb_Size", 0L);
      k = ((Intent)localObject1).getIntExtra("special_video_type", 0);
      localObject3 = ((Intent)localObject1).getStringExtra("hot_video_name");
      j = ((Intent)localObject1).getIntExtra("short_video_msg_tail_type", 0);
      i = ((Intent)localObject1).getIntExtra("param_key_redbag_type", 0);
      if (i != LocalMediaInfo.REDBAG_TYPE_GET) {
        break label1030;
      }
      localObject1 = a(str6, i5);
    }
    for (;;)
    {
      Object localObject10 = new ShortVideoUploadInfo();
      ((ShortVideoUploadInfo)localObject10).jdField_c_of_type_JavaLangString = str6;
      ((ShortVideoUploadInfo)localObject10).jdField_h_of_type_JavaLangString = str4;
      ((ShortVideoUploadInfo)localObject10).jdField_j_of_type_JavaLangString = str3;
      ((ShortVideoUploadInfo)localObject10).jdField_b_of_type_Int = i5;
      ((ShortVideoUploadInfo)localObject10).jdField_d_of_type_JavaLangString = str5;
      ((ShortVideoUploadInfo)localObject10).jdField_e_of_type_Int = ((int)l2);
      ((ShortVideoUploadInfo)localObject10).jdField_f_of_type_Int = i3;
      ((ShortVideoUploadInfo)localObject10).jdField_e_of_type_JavaLangString = str1;
      ((ShortVideoUploadInfo)localObject10).jdField_c_of_type_Int = i2;
      ((ShortVideoUploadInfo)localObject10).jdField_d_of_type_Int = i1;
      ((ShortVideoUploadInfo)localObject10).jdField_g_of_type_Int = paramShortVideoReq.jdField_a_of_type_Int;
      ((ShortVideoUploadInfo)localObject10).jdField_a_of_type_JavaLangObject = paramObject;
      ((ShortVideoUploadInfo)localObject10).jdField_g_of_type_JavaLangString = ((String)localObject9);
      ((ShortVideoUploadInfo)localObject10).jdField_l_of_type_JavaLangString = ((String)localObject8);
      ((ShortVideoUploadInfo)localObject10).jdField_k_of_type_JavaLangString = str2;
      ((ShortVideoUploadInfo)localObject10).jdField_a_of_type_Int = i4;
      ((ShortVideoUploadInfo)localObject10).jdField_b_of_type_Boolean = bool3;
      ((ShortVideoUploadInfo)localObject10).jdField_h_of_type_Int = n;
      ((ShortVideoUploadInfo)localObject10).jdField_i_of_type_Int = m;
      ((ShortVideoUploadInfo)localObject10).jdField_g_of_type_Boolean = bool2;
      ((ShortVideoUploadInfo)localObject10).jdField_c_of_type_Boolean = bool1;
      ((ShortVideoUploadInfo)localObject10).jdField_m_of_type_JavaLangString = ((String)localObject7);
      ((ShortVideoUploadInfo)localObject10).jdField_o_of_type_JavaLangString = ((String)localObject5);
      ((ShortVideoUploadInfo)localObject10).jdField_p_of_type_JavaLangString = ((String)localObject4);
      ((ShortVideoUploadInfo)localObject10).jdField_n_of_type_JavaLangString = ((String)localObject6);
      ((ShortVideoUploadInfo)localObject10).jdField_a_of_type_JavaLangString = ((String)localObject2);
      ((ShortVideoUploadInfo)localObject10).jdField_b_of_type_Long = l1;
      ((ShortVideoUploadInfo)localObject10).jdField_j_of_type_Int = k;
      ((ShortVideoUploadInfo)localObject10).jdField_q_of_type_JavaLangString = ((String)localObject3);
      ((ShortVideoUploadInfo)localObject10).jdField_k_of_type_Int = j;
      ((ShortVideoUploadInfo)localObject10).jdField_l_of_type_Int = i;
      ((ShortVideoUploadInfo)localObject10).jdField_r_of_type_JavaLangString = ((String)localObject1);
      Logger.a(this.jdField_g_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, "createShortVideoUploadInfo", "");
      return localObject10;
      if ((paramObject instanceof MessageForShortVideo))
      {
        localObject7 = (MessageForShortVideo)paramObject;
        str6 = ((MessageForShortVideo)localObject7).frienduin;
        str5 = ((MessageForShortVideo)localObject7).frienduin;
        i5 = ((MessageForShortVideo)localObject7).istroop;
        l2 = ((MessageForShortVideo)localObject7).videoFileSize;
        i4 = paramShortVideoReq.jdField_b_of_type_Int;
        i3 = ((MessageForShortVideo)localObject7).videoFileTime;
        str4 = ((MessageForShortVideo)localObject7).videoFileName;
        str3 = ShortVideoUtils.a(((MessageForShortVideo)localObject7).thumbMD5, "jpg");
        str1 = ((MessageForShortVideo)localObject7).md5;
        i2 = ((MessageForShortVideo)localObject7).thumbWidth;
        i1 = ((MessageForShortVideo)localObject7).thumbHeight;
        localObject10 = ((MessageForShortVideo)localObject7).thumbMD5;
        String str7 = ((MessageForShortVideo)localObject7).fileSource;
        str2 = ((MessageForShortVideo)localObject7).mVideoFileSourceDir;
        bool3 = ((MessageForShortVideo)localObject7).supportProgressive;
        n = ((MessageForShortVideo)localObject7).fileWidth;
        m = ((MessageForShortVideo)localObject7).fileHeight;
        bool2 = ((MessageForShortVideo)localObject7).syncToStory;
        bool1 = ((MessageForShortVideo)localObject7).mediacodecEncode;
        if (((MessageForShortVideo)localObject7).CheckIsHotVideo())
        {
          localObject2 = ((MessageForShortVideo)localObject7).hotVideoIconUrl;
          localObject4 = ((MessageForShortVideo)localObject7).hotVideoTitle;
          localObject5 = ((MessageForShortVideo)localObject7).hotVideoUrl;
          localObject3 = ((MessageForShortVideo)localObject7).hotVideoSubIconUrl;
          localObject6 = ((MessageForShortVideo)localObject7).videoFileName;
          localObject1 = ((MessageForShortVideo)localObject7).uuid;
        }
        for (;;)
        {
          k = ((MessageForShortVideo)localObject7).specialVideoType;
          j = ((MessageForShortVideo)localObject7).msgTailType;
          i = ((MessageForShortVideo)localObject7).redBagType;
          String str8 = ((MessageForShortVideo)localObject7).shortVideoId;
          localObject7 = localObject4;
          localObject8 = localObject3;
          localObject9 = localObject2;
          localObject2 = localObject1;
          l1 = -1L;
          localObject1 = str8;
          localObject3 = localObject6;
          localObject4 = localObject5;
          localObject5 = localObject7;
          localObject6 = localObject8;
          localObject7 = localObject9;
          localObject8 = str7;
          localObject9 = localObject10;
          break;
          localObject1 = null;
          localObject6 = "";
          localObject5 = "";
          localObject4 = "";
          localObject3 = "";
          localObject2 = "";
        }
      }
      i = 0;
      localObject1 = "";
      localObject4 = "";
      localObject5 = "";
      l1 = -1L;
      localObject6 = "";
      localObject7 = "";
      localObject2 = null;
      localObject3 = "";
      j = 0;
      k = 0;
      continue;
      label1030:
      localObject1 = "";
    }
  }
  
  public void a(UpCallBack.SendResult paramSendResult)
  {
    Logger.a(this.jdField_g_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, "updateMsg", "resut:" + paramSendResult);
    if (paramSendResult != null)
    {
      MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      localMessageForShortVideo.videoFileSize = ((int)paramSendResult.jdField_a_of_type_Long);
      localMessageForShortVideo.uuid = paramSendResult.jdField_c_of_type_JavaLangString;
      localMessageForShortVideo.md5 = paramSendResult.jdField_d_of_type_JavaLangString;
      localMessageForShortVideo.thumbFileSize = ((int)paramSendResult.jdField_c_of_type_Long);
      localMessageForShortVideo.videoAttr = paramSendResult.jdField_c_of_type_Int;
      localMessageForShortVideo.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, localMessageForShortVideo.msgData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.AioShortVideoOperator
 * JD-Core Version:    0.7.0.1
 */