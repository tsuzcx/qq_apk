package com.tencent.mobileqq.shortvideo;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.QQAppInterface;
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
      localMessageForShortVideo.supportProgressive = paramShortVideoForwardInfo.jdField_b_of_type_Boolean;
      localMessageForShortVideo.fileWidth = paramShortVideoForwardInfo.jdField_n_of_type_Int;
      localMessageForShortVideo.fileHeight = paramShortVideoForwardInfo.jdField_o_of_type_Int;
      if (paramShortVideoForwardInfo.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoForwardInfo$RetryInfo == null) {
        break label647;
      }
      i = 1;
      if (i != 0)
      {
        localMessageForShortVideo.msgseq = paramShortVideoForwardInfo.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoForwardInfo$RetryInfo.jdField_a_of_type_Long;
        localMessageForShortVideo.shmsgseq = paramShortVideoForwardInfo.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoForwardInfo$RetryInfo.jdField_b_of_type_Long;
        localMessageForShortVideo.msgUid = paramShortVideoForwardInfo.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoForwardInfo$RetryInfo.jdField_c_of_type_Long;
      }
      if (localMessageForShortVideo.busiType != 2) {
        break label652;
      }
      localMessageForShortVideo.msg = ShortVideoConstants.MESSAGE_FOR_SHORT_VIDEO_PTV;
      if (paramShortVideoForwardInfo.jdField_n_of_type_JavaLangString != null) {
        break label663;
      }
      str = "";
      label352:
      localMessageForShortVideo.hotVideoIconUrl = str;
      if (paramShortVideoForwardInfo.p != null) {
        break label672;
      }
      str = "";
      label370:
      localMessageForShortVideo.hotVideoTitle = str;
      if (paramShortVideoForwardInfo.jdField_q_of_type_JavaLangString != null) {
        break label681;
      }
      str = "";
      label388:
      localMessageForShortVideo.hotVideoUrl = str;
      if (paramShortVideoForwardInfo.jdField_o_of_type_JavaLangString != null) {
        break label690;
      }
      str = "";
      label406:
      localMessageForShortVideo.hotVideoSubIconUrl = str;
      localMessageForShortVideo.specialVideoType = paramShortVideoForwardInfo.jdField_q_of_type_Int;
      localMessageForShortVideo.msgTailType = paramShortVideoForwardInfo.jdField_r_of_type_Int;
      localMessageForShortVideo.redBagType = paramShortVideoForwardInfo.jdField_s_of_type_Int;
      localMessageForShortVideo.shortVideoId = paramShortVideoForwardInfo.jdField_r_of_type_JavaLangString;
      localMessageForShortVideo.isStoryVideo = paramShortVideoForwardInfo.jdField_c_of_type_Boolean;
      if (localMessageForShortVideo.redBagType == LocalMediaInfo.REDBAG_TYPE_GET) {
        if (!VideoRedbagData.queryRewardStat(localMessageForShortVideo.shortVideoId)) {
          break label699;
        }
      }
    }
    label647:
    label652:
    label663:
    label672:
    label681:
    label690:
    label699:
    for (int i = 1;; i = 0)
    {
      localMessageForShortVideo.redBagStat = i;
      if (!TextUtils.isEmpty(paramShortVideoForwardInfo.jdField_s_of_type_JavaLangString))
      {
        localMessageForShortVideo.templateId = paramShortVideoForwardInfo.jdField_s_of_type_JavaLangString;
        localMessageForShortVideo.templateName = paramShortVideoForwardInfo.t;
      }
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
      i = 0;
      break label284;
      localMessageForShortVideo.msg = ShortVideoConstants.MESSAGEFORSHORTVIDEO_MSG;
      break label341;
      str = paramShortVideoForwardInfo.jdField_n_of_type_JavaLangString;
      break label352;
      str = paramShortVideoForwardInfo.p;
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
    if (paramShortVideoUploadInfo.jdField_e_of_type_Boolean)
    {
      localMessageForShortVideo = MessageRecordFactory.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramShortVideoUploadInfo.jdField_c_of_type_JavaLangString, paramShortVideoUploadInfo.jdField_d_of_type_JavaLangString, paramShortVideoUploadInfo.jdField_b_of_type_Int);
      localMessageForShortVideo.subBusiType = 1;
      localMessageForShortVideo.videoFileName = paramShortVideoUploadInfo.jdField_h_of_type_JavaLangString;
    }
    label281:
    label299:
    label319:
    label970:
    label994:
    label1001:
    label1006:
    label1017:
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
      localMessageForShortVideo.mediacodecEncode = paramShortVideoUploadInfo.jdField_d_of_type_Boolean;
      Object localObject;
      String str;
      int i;
      if (localMessageForShortVideo.istroop == 0)
      {
        localMessageForShortVideo.fileType = 6;
        if (paramShortVideoUploadInfo.jdField_b_of_type_Int != 1008) {
          break label927;
        }
        localMessageForShortVideo.busiType = 1007;
        if (paramShortVideoUploadInfo.jdField_b_of_type_Int != 0) {
          break label970;
        }
        ConfessMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForShortVideo, paramShortVideoUploadInfo.jdField_c_of_type_JavaLangString);
        localMessageForShortVideo.fromChatType = -1;
        localMessageForShortVideo.toChatType = -1;
        localMessageForShortVideo.uiOperatorFlag = 1;
        localMessageForShortVideo.supportProgressive = paramShortVideoUploadInfo.jdField_c_of_type_Boolean;
        localMessageForShortVideo.fileWidth = paramShortVideoUploadInfo.jdField_h_of_type_Int;
        localMessageForShortVideo.fileHeight = paramShortVideoUploadInfo.jdField_i_of_type_Int;
        localMessageForShortVideo.syncToStory = paramShortVideoUploadInfo.jdField_h_of_type_Boolean;
        localObject = MessageConstants.jdField_n_of_type_JavaLangString;
        if (!localMessageForShortVideo.syncToStory) {
          break label994;
        }
        str = "1";
        localMessageForShortVideo.saveExtInfoToExtStr((String)localObject, str);
        localMessageForShortVideo.sendRawVideo = paramShortVideoUploadInfo.jdField_i_of_type_Boolean;
        if (paramShortVideoUploadInfo.jdField_i_of_type_Boolean) {
          localMessageForShortVideo.saveExtInfoToExtStr(MessageConstants.C, "1");
        }
        if (paramShortVideoUploadInfo.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo$RetryInfo == null) {
          break label1001;
        }
        i = 1;
        if (i != 0)
        {
          localMessageForShortVideo.msgseq = paramShortVideoUploadInfo.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo$RetryInfo.jdField_a_of_type_Long;
          localMessageForShortVideo.shmsgseq = paramShortVideoUploadInfo.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo$RetryInfo.jdField_b_of_type_Long;
          localMessageForShortVideo.msgUid = paramShortVideoUploadInfo.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo$RetryInfo.jdField_c_of_type_Long;
        }
        if (localMessageForShortVideo.busiType != 2) {
          break label1006;
        }
      }
      for (localMessageForShortVideo.msg = ShortVideoConstants.MESSAGE_FOR_SHORT_VIDEO_PTV;; localMessageForShortVideo.msg = ShortVideoConstants.MESSAGEFORSHORTVIDEO_MSG)
      {
        if (!TextUtils.isEmpty(paramShortVideoUploadInfo.jdField_s_of_type_JavaLangString))
        {
          localMessageForShortVideo.templateId = paramShortVideoUploadInfo.jdField_s_of_type_JavaLangString;
          localMessageForShortVideo.templateName = paramShortVideoUploadInfo.t;
        }
        localMessageForShortVideo.serial();
        paramShortVideoUploadInfo.jdField_a_of_type_Long = localMessageForShortVideo.uniseq;
        Logger.a(this.jdField_g_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, "packmsg", "cost:" + (System.currentTimeMillis() - l));
        Logger.a(this.jdField_g_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, "packMsg", "mr: " + localMessageForShortVideo.toLogString() + "-" + localMessageForShortVideo.toString());
        return localMessageForShortVideo;
        if (paramShortVideoUploadInfo.jdField_f_of_type_Boolean)
        {
          localMessageForShortVideo = MessageRecordFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramShortVideoUploadInfo.jdField_c_of_type_JavaLangString, paramShortVideoUploadInfo.jdField_d_of_type_JavaLangString, paramShortVideoUploadInfo.jdField_b_of_type_Int);
          localMessageForShortVideo.subBusiType = 0;
          localMessageForShortVideo.hotVideoIconUrl = paramShortVideoUploadInfo.jdField_m_of_type_JavaLangString;
          localMessageForShortVideo.hotVideoTitle = paramShortVideoUploadInfo.jdField_o_of_type_JavaLangString;
          localMessageForShortVideo.hotVideoUrl = paramShortVideoUploadInfo.p;
          localMessageForShortVideo.hotVideoSubIconUrl = paramShortVideoUploadInfo.jdField_n_of_type_JavaLangString;
          localMessageForShortVideo.videoFileName = paramShortVideoUploadInfo.jdField_q_of_type_JavaLangString;
          localMessageForShortVideo.videoAttr = 0;
          localMessageForShortVideo.videoKandianType = 0;
          if ((localMessageForShortVideo.videoFileName != null) && (localMessageForShortVideo.videoFileName.length() != 0)) {
            break label1017;
          }
          localObject = new StringBuilder();
          if ((paramShortVideoUploadInfo.jdField_e_of_type_JavaLangString == null) || (paramShortVideoUploadInfo.jdField_e_of_type_JavaLangString.length() == 0)) {}
          for (str = "HotVideo";; str = paramShortVideoUploadInfo.jdField_e_of_type_JavaLangString)
          {
            localMessageForShortVideo.videoFileName = (str + ".mp4");
            break;
          }
        }
        if (paramShortVideoUploadInfo.jdField_g_of_type_Boolean)
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
        if (paramShortVideoUploadInfo.jdField_b_of_type_Int != 1) {
          break label319;
        }
        ConfessMsgUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForShortVideo, paramShortVideoUploadInfo.jdField_c_of_type_JavaLangString);
        break label319;
        str = "0";
        break label391;
        i = 0;
        break label436;
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
    Object localObject19 = "0";
    Object localObject18 = "0";
    int i9 = 0;
    int i11 = 0;
    int i10 = 0;
    Object localObject17 = "";
    Object localObject16 = "";
    Object localObject15 = "";
    Object localObject14 = "";
    int i8 = 0;
    int i7 = 0;
    Object localObject13 = "";
    Object localObject11 = "";
    Object localObject10 = "";
    int i6 = 2;
    boolean bool3 = false;
    int i3 = 0;
    int i2 = 0;
    Object localObject5 = "";
    Object localObject4 = "";
    Object localObject2 = "";
    Object localObject3 = "";
    int i12 = 0;
    Object localObject6 = "";
    Object localObject1;
    Object localObject9;
    int i4;
    Object localObject12;
    int i5;
    Object localObject20;
    int i1;
    int n;
    long l;
    boolean bool2;
    boolean bool1;
    Object localObject7;
    int i;
    if ((paramObject instanceof Intent))
    {
      localObject1 = (Intent)paramObject;
      localObject19 = ((Intent)localObject1).getStringExtra("uin");
      localObject18 = ((Intent)localObject1).getStringExtra("troop_uin");
      i9 = ((Intent)localObject1).getIntExtra("uintype", -1);
      localObject9 = ((Intent)localObject1).getStringExtra("from_uin");
      i4 = ((Intent)localObject1).getIntExtra("from_uin_type", -1);
      localObject5 = ((Intent)localObject1).getStringExtra("from_session_uin");
      ((Intent)localObject1).getIntExtra("from_busi_type", -1);
      i11 = ((Intent)localObject1).getIntExtra("file_send_size", 0);
      i10 = ((Intent)localObject1).getIntExtra("file_send_duration", -1);
      localObject17 = ((Intent)localObject1).getStringExtra("file_send_path");
      localObject16 = ((Intent)localObject1).getStringExtra("thumbfile_send_path");
      localObject15 = ((Intent)localObject1).getStringExtra("file_shortvideo_md5");
      localObject14 = ((Intent)localObject1).getStringExtra("file_shortvideo_local_md5");
      i8 = ((Intent)localObject1).getIntExtra("thumbfile_send_width", 0);
      i7 = ((Intent)localObject1).getIntExtra("thumbfile_send_height", 0);
      localObject13 = ((Intent)localObject1).getStringExtra("thumbfile_md5");
      localObject12 = ((Intent)localObject1).getStringExtra("file_source");
      localObject11 = ((Intent)localObject1).getStringExtra("file_uuid");
      localObject10 = ((Intent)localObject1).getStringExtra("file_name");
      i6 = ((Intent)localObject1).getIntExtra("file_format", 2);
      i5 = ((Intent)localObject1).getIntExtra("file_thumb_Size", 0);
      bool3 = ((Intent)localObject1).getBooleanExtra("support_progressive", false);
      i3 = ((Intent)localObject1).getIntExtra("file_width", 0);
      i2 = ((Intent)localObject1).getIntExtra("file_height", 0);
      localObject4 = ((Intent)localObject1).getStringExtra("hot_video_icon");
      localObject3 = ((Intent)localObject1).getStringExtra("hot_video_title");
      localObject20 = ((Intent)localObject1).getStringExtra("hot_video_url");
      localObject2 = ((Intent)localObject1).getStringExtra("hot_video_icon_sub");
      i1 = ((Intent)localObject1).getIntExtra("special_video_type", 0);
      n = ((Intent)localObject1).getIntExtra("short_video_msg_tail_type", 0);
      l = ((Intent)localObject1).getLongExtra("from_msg_uniseq", 0L);
      bool2 = ((Intent)localObject1).getBooleanExtra("key_story_video_to_recent", false);
      if (((Intent)localObject1).getIntExtra("forward_source_business_type", -1) == 100200)
      {
        bool1 = true;
        localObject7 = ((Intent)localObject1).getStringExtra("widgetinfo");
        localObject6 = ((Intent)localObject1).getStringExtra("key_camera_material_name");
        i = ((Intent)localObject1).getIntExtra("param_key_redbag_type", 0);
        if (i != LocalMediaInfo.REDBAG_TYPE_GET) {
          break label2290;
        }
        if ((((String)localObject5).equals("0")) || (!((String)localObject5).equals(localObject19))) {
          break label611;
        }
        localObject1 = ((Intent)localObject1).getStringExtra("param_key_redbag_video_id");
      }
    }
    for (;;)
    {
      label561:
      Object localObject8 = localObject1;
      localObject1 = localObject20;
      int j = 0;
      int m = 0;
      int k = 0;
      for (;;)
      {
        label611:
        String str1;
        String str2;
        int i15;
        int i16;
        int i17;
        if (TextUtils.isEmpty((CharSequence)localObject15))
        {
          Logger.b(paramShortVideoReq.jdField_b_of_type_JavaLangString, paramShortVideoReq.jdField_a_of_type_JavaLangString, "createShortVideoForwardInfo", "md5 shouldn't be empty ");
          return null;
          bool1 = false;
          break;
          localObject1 = a((String)localObject19, i9);
          break label561;
          if (!(paramObject instanceof MessageForShortVideo)) {
            break label2219;
          }
          localObject15 = (MessageForShortVideo)paramObject;
          str1 = ((MessageForShortVideo)localObject15).frienduin;
          str2 = ((MessageForShortVideo)localObject15).frienduin;
          i15 = ((MessageForShortVideo)localObject15).istroop;
          i16 = ((MessageForShortVideo)localObject15).videoFileSize;
          i17 = ((MessageForShortVideo)localObject15).videoFileTime;
          localObject1 = ((MessageForShortVideo)localObject15).videoFileName;
          localObject7 = ShortVideoUtils.getShortVideoThumbPicPath(((MessageForShortVideo)localObject15).thumbMD5, "jpg");
          localObject8 = ((MessageForShortVideo)localObject15).md5;
          localObject9 = ((MessageForShortVideo)localObject15).mLocalMd5;
          i = ((MessageForShortVideo)localObject15).thumbWidth;
          j = ((MessageForShortVideo)localObject15).thumbHeight;
          localObject10 = ((MessageForShortVideo)localObject15).thumbMD5;
          localObject11 = ((MessageForShortVideo)localObject15).fileSource;
          localObject6 = ((MessageForShortVideo)localObject15).uuid;
          k = ((MessageForShortVideo)localObject15).videoFileFormat;
          m = ((MessageForShortVideo)localObject15).thumbFileSize;
          n = ((MessageForShortVideo)localObject15).fromChatType;
          i1 = ((MessageForShortVideo)localObject15).toChatType;
          i2 = ((MessageForShortVideo)localObject15).busiType;
          localObject12 = ShortVideoUtils.getFromUinForForward((MessageForShortVideo)localObject15);
          bool1 = ((MessageForShortVideo)localObject15).supportProgressive;
          i3 = ((MessageForShortVideo)localObject15).fileWidth;
          i4 = ((MessageForShortVideo)localObject15).fileHeight;
          i5 = ((MessageForShortVideo)localObject15).specialVideoType;
          i7 = ((MessageForShortVideo)localObject15).msgTailType;
          l = ((MessageForShortVideo)localObject15).uniseq;
          bool2 = ((MessageForShortVideo)localObject15).isStoryVideo;
          if (((MessageForShortVideo)localObject15).CheckIsHotVideo())
          {
            localObject5 = ((MessageForShortVideo)localObject15).hotVideoIconUrl;
            localObject2 = ((MessageForShortVideo)localObject15).hotVideoTitle;
            localObject3 = ((MessageForShortVideo)localObject15).hotVideoUrl;
            localObject4 = ((MessageForShortVideo)localObject15).hotVideoSubIconUrl;
          }
          localObject13 = ((MessageForShortVideo)localObject15).templateId;
          localObject14 = ((MessageForShortVideo)localObject15).templateName;
          i8 = i12;
          if (paramShortVideoReq.jdField_b_of_type_Int == 5) {
            break label2012;
          }
          i6 = ((MessageForShortVideo)localObject15).redBagType;
          i8 = i6;
          if (i6 != LocalMediaInfo.REDBAG_TYPE_GET) {
            break label2012;
          }
          if ((!"0".equals("0")) && ("0".equals(str1)))
          {
            localObject19 = ((MessageForShortVideo)localObject15).shortVideoId;
            localObject21 = localObject14;
            bool4 = false;
            i14 = i6;
            localObject22 = localObject13;
            bool3 = bool1;
            str3 = "0";
            localObject20 = localObject12;
            i6 = i2;
            i10 = i1;
            i11 = n;
            i12 = m;
            i13 = k;
            localObject18 = localObject1;
            i18 = -1;
            localObject12 = localObject11;
            localObject13 = localObject10;
            i8 = j;
            i9 = i;
            localObject14 = localObject9;
            localObject15 = localObject8;
            localObject16 = localObject7;
            localObject17 = localObject1;
            localObject11 = localObject6;
            localObject6 = localObject21;
            localObject7 = localObject22;
            bool1 = bool4;
            localObject8 = localObject19;
            i = i14;
            n = i7;
            i1 = i5;
            localObject1 = localObject3;
            localObject3 = localObject2;
            localObject2 = localObject4;
            localObject4 = localObject5;
            i2 = i4;
            localObject5 = str3;
            localObject9 = localObject20;
            j = i6;
            m = i10;
            k = i11;
            i5 = i12;
            i6 = i13;
            localObject10 = localObject18;
            i4 = i18;
            i7 = i8;
            i8 = i9;
            i10 = i17;
            i11 = i16;
            i9 = i15;
            localObject18 = str2;
            localObject19 = str1;
            continue;
          }
          localObject19 = a(str1, i15);
          localObject21 = localObject14;
          bool4 = false;
          i14 = i6;
          localObject22 = localObject13;
          bool3 = bool1;
          str3 = "0";
          localObject20 = localObject12;
          i6 = i2;
          i10 = i1;
          i11 = n;
          i12 = m;
          i13 = k;
          localObject18 = localObject1;
          i18 = -1;
          localObject12 = localObject11;
          localObject13 = localObject10;
          i8 = j;
          i9 = i;
          localObject14 = localObject9;
          localObject15 = localObject8;
          localObject16 = localObject7;
          localObject17 = localObject1;
          localObject11 = localObject6;
          localObject6 = localObject21;
          localObject7 = localObject22;
          bool1 = bool4;
          localObject8 = localObject19;
          i = i14;
          n = i7;
          i1 = i5;
          localObject1 = localObject3;
          localObject3 = localObject2;
          localObject2 = localObject4;
          localObject4 = localObject5;
          i2 = i4;
          localObject5 = str3;
          localObject9 = localObject20;
          j = i6;
          m = i10;
          k = i11;
          i5 = i12;
          i6 = i13;
          localObject10 = localObject18;
          i4 = i18;
          i7 = i8;
          i8 = i9;
          i10 = i17;
          i11 = i16;
          i9 = i15;
          localObject18 = str2;
          localObject19 = str1;
          continue;
        }
        localObject20 = new ShortVideoForwardInfo();
        ((ShortVideoForwardInfo)localObject20).jdField_c_of_type_JavaLangString = ((String)localObject19);
        ((ShortVideoForwardInfo)localObject20).jdField_h_of_type_JavaLangString = ((String)localObject17);
        ((ShortVideoForwardInfo)localObject20).jdField_i_of_type_JavaLangString = ((String)localObject16);
        ((ShortVideoForwardInfo)localObject20).jdField_b_of_type_Int = i9;
        ((ShortVideoForwardInfo)localObject20).jdField_d_of_type_JavaLangString = ((String)localObject18);
        ((ShortVideoForwardInfo)localObject20).jdField_i_of_type_Int = i11;
        ((ShortVideoForwardInfo)localObject20).jdField_j_of_type_Int = i10;
        ((ShortVideoForwardInfo)localObject20).jdField_e_of_type_JavaLangString = ((String)localObject15);
        ((ShortVideoForwardInfo)localObject20).jdField_f_of_type_JavaLangString = ((String)localObject14);
        ((ShortVideoForwardInfo)localObject20).jdField_g_of_type_Int = i8;
        ((ShortVideoForwardInfo)localObject20).jdField_h_of_type_Int = i7;
        ((ShortVideoForwardInfo)localObject20).jdField_k_of_type_Int = paramShortVideoReq.jdField_a_of_type_Int;
        ((ShortVideoForwardInfo)localObject20).jdField_a_of_type_JavaLangObject = paramObject;
        ((ShortVideoForwardInfo)localObject20).jdField_g_of_type_JavaLangString = ((String)localObject13);
        ((ShortVideoForwardInfo)localObject20).jdField_j_of_type_JavaLangString = ((String)localObject12);
        ((ShortVideoForwardInfo)localObject20).jdField_a_of_type_JavaLangString = ((String)localObject11);
        ((ShortVideoForwardInfo)localObject20).jdField_k_of_type_JavaLangString = ((String)localObject10);
        ((ShortVideoForwardInfo)localObject20).jdField_l_of_type_Int = i6;
        ((ShortVideoForwardInfo)localObject20).jdField_m_of_type_Int = i5;
        ((ShortVideoForwardInfo)localObject20).jdField_b_of_type_Boolean = bool3;
        ((ShortVideoForwardInfo)localObject20).jdField_n_of_type_Int = i3;
        ((ShortVideoForwardInfo)localObject20).jdField_o_of_type_Int = i2;
        ((ShortVideoForwardInfo)localObject20).jdField_l_of_type_JavaLangString = ((String)localObject9);
        if (localObject5 != null)
        {
          ((ShortVideoForwardInfo)localObject20).jdField_m_of_type_JavaLangString = ((String)localObject5);
          ((ShortVideoForwardInfo)localObject20).jdField_b_of_type_Long = l;
          ((ShortVideoForwardInfo)localObject20).jdField_c_of_type_Boolean = bool2;
          localObject5 = localObject4;
          if (localObject4 == null) {
            localObject5 = "";
          }
          ((ShortVideoForwardInfo)localObject20).jdField_n_of_type_JavaLangString = ((String)localObject5);
          localObject4 = localObject3;
          if (localObject3 == null) {
            localObject4 = "";
          }
          ((ShortVideoForwardInfo)localObject20).p = ((String)localObject4);
          localObject3 = localObject1;
          if (localObject1 == null) {
            localObject3 = "";
          }
          ((ShortVideoForwardInfo)localObject20).jdField_q_of_type_JavaLangString = ((String)localObject3);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          ((ShortVideoForwardInfo)localObject20).jdField_o_of_type_JavaLangString = ((String)localObject1);
          ((ShortVideoForwardInfo)localObject20).jdField_q_of_type_Int = i1;
          ((ShortVideoForwardInfo)localObject20).jdField_r_of_type_Int = n;
          if (2 == paramShortVideoReq.jdField_b_of_type_Int)
          {
            ((ShortVideoForwardInfo)localObject20).jdField_s_of_type_Int = i;
            ((ShortVideoForwardInfo)localObject20).jdField_r_of_type_JavaLangString = ((String)localObject8);
          }
          ((ShortVideoForwardInfo)localObject20).jdField_d_of_type_Boolean = bool1;
          ((ShortVideoForwardInfo)localObject20).jdField_s_of_type_JavaLangString = ((String)localObject7);
          ((ShortVideoForwardInfo)localObject20).t = ((String)localObject6);
          if (!(paramObject instanceof Intent)) {
            break label1872;
          }
          if (i4 != 0) {
            break label1799;
          }
          k = 0;
          label1701:
          if (i9 != 0) {
            break label1831;
          }
          i = 0;
          n = k;
          label1712:
          if (i4 != 1008) {
            break label1954;
          }
          k = 1007;
        }
        for (;;)
        {
          ((ShortVideoForwardInfo)localObject20).jdField_c_of_type_Int = n;
          ((ShortVideoForwardInfo)localObject20).jdField_d_of_type_Int = i;
          ((ShortVideoForwardInfo)localObject20).jdField_e_of_type_Int = k;
          ((ShortVideoForwardInfo)localObject20).jdField_f_of_type_Int = j;
          Logger.a(paramShortVideoReq.jdField_b_of_type_JavaLangString, paramShortVideoReq.jdField_a_of_type_JavaLangString, "createShortVideoForwardInfo", "" + ((ShortVideoForwardInfo)localObject20).a());
          return localObject20;
          localObject5 = "0";
          break;
          label1799:
          if (i4 == 1)
          {
            k = 1;
            break label1701;
          }
          if (i4 == 3000)
          {
            k = 2;
            break label1701;
          }
          k = 3;
          break label1701;
          label1831:
          if (i9 == 1)
          {
            i = 1;
            n = k;
            break label1712;
          }
          if (i9 == 3000)
          {
            i = 2;
            n = k;
            break label1712;
          }
          i = 3;
          n = k;
          break label1712;
          label1872:
          i = m;
          n = k;
          if (!(paramObject instanceof MessageForShortVideo)) {
            break label1712;
          }
          i = m;
          n = k;
          if (m != -1) {
            break label1712;
          }
          if (i9 == 0)
          {
            i = 0;
            n = k;
            break label1712;
          }
          if (i9 == 1)
          {
            i = 1;
            n = k;
            break label1712;
          }
          if (i9 == 3000)
          {
            i = 2;
            n = k;
            break label1712;
          }
          i = 3;
          n = k;
          break label1712;
          label1954:
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
        label2012:
        localObject20 = localObject14;
        Object localObject22 = "";
        boolean bool4 = false;
        int i14 = i8;
        Object localObject21 = localObject13;
        bool3 = bool1;
        String str3 = "0";
        localObject19 = localObject12;
        i6 = i2;
        i10 = i1;
        i11 = n;
        i12 = m;
        int i13 = k;
        localObject18 = localObject1;
        int i18 = -1;
        localObject12 = localObject11;
        localObject13 = localObject10;
        i8 = j;
        i9 = i;
        localObject14 = localObject9;
        localObject15 = localObject8;
        localObject16 = localObject7;
        localObject17 = localObject1;
        localObject11 = localObject6;
        localObject6 = localObject20;
        localObject7 = localObject21;
        bool1 = bool4;
        localObject8 = localObject22;
        i = i14;
        n = i7;
        i1 = i5;
        localObject1 = localObject3;
        localObject3 = localObject2;
        localObject2 = localObject4;
        localObject4 = localObject5;
        i2 = i4;
        localObject5 = str3;
        localObject9 = localObject19;
        j = i6;
        m = i10;
        k = i11;
        i5 = i12;
        i6 = i13;
        localObject10 = localObject18;
        i4 = i18;
        i7 = i8;
        i8 = i9;
        i10 = i17;
        i11 = i16;
        i9 = i15;
        localObject18 = str2;
        localObject19 = str1;
        continue;
        label2219:
        localObject8 = "";
        bool1 = false;
        n = 0;
        i1 = 0;
        localObject4 = "";
        localObject2 = "";
        l = 0L;
        localObject1 = "";
        localObject3 = "";
        bool2 = false;
        localObject7 = "";
        i = 0;
        localObject9 = "0";
        localObject5 = "0";
        m = 0;
        k = 0;
        i5 = 0;
        j = 0;
        localObject12 = "";
        i4 = -1;
      }
      label2290:
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
    String str7 = "0";
    String str6 = "0";
    int i5 = 0;
    long l2 = 0L;
    int i4 = 0;
    int i3 = 0;
    String str5 = "";
    String str4 = "";
    String str3 = "";
    String str2 = "";
    int i2 = 0;
    int i1 = 0;
    Object localObject10 = "";
    Object localObject9 = "";
    boolean bool4 = false;
    int n = 0;
    int m = 0;
    boolean bool3 = false;
    Object localObject1 = "";
    Object localObject2 = "";
    Object localObject3;
    boolean bool2;
    Object localObject8;
    Object localObject6;
    Object localObject5;
    Object localObject7;
    Object localObject4;
    long l1;
    int k;
    String str1;
    int j;
    int i;
    boolean bool1;
    Object localObject11;
    if ((paramObject instanceof Intent))
    {
      localObject3 = (Intent)paramObject;
      str7 = ((Intent)localObject3).getStringExtra("uin");
      str6 = ((Intent)localObject3).getStringExtra("troop_uin");
      i5 = ((Intent)localObject3).getIntExtra("uintype", 1003);
      l2 = ((Intent)localObject3).getLongExtra("file_send_size", 0L);
      i4 = ((Intent)localObject3).getIntExtra("file_send_business_type", 0);
      i3 = ((Intent)localObject3).getIntExtra("file_send_duration", -1);
      str5 = ((Intent)localObject3).getStringExtra("file_send_path");
      str4 = ((Intent)localObject3).getStringExtra("thumbfile_send_path");
      str2 = ((Intent)localObject3).getStringExtra("file_shortvideo_md5");
      i2 = ((Intent)localObject3).getIntExtra("thumbfile_send_width", 0);
      i1 = ((Intent)localObject3).getIntExtra("thumbfile_send_height", 0);
      localObject10 = ((Intent)localObject3).getStringExtra("thumbfile_md5");
      localObject9 = ((Intent)localObject3).getStringExtra("file_source");
      str3 = ((Intent)localObject3).getStringExtra("file_video_source_dir");
      bool4 = ((Intent)localObject3).getBooleanExtra("support_progressive", false);
      n = ((Intent)localObject3).getIntExtra("file_width", 0);
      m = ((Intent)localObject3).getIntExtra("file_height", 0);
      bool3 = ((Intent)localObject3).getBooleanExtra("video_sync_to_story", false);
      bool2 = ((Intent)localObject3).getBooleanExtra("mediacodec_encode_enable", false);
      localObject8 = ((Intent)localObject3).getStringExtra("hot_video_icon");
      localObject6 = ((Intent)localObject3).getStringExtra("hot_video_title");
      localObject5 = ((Intent)localObject3).getStringExtra("hot_video_url");
      localObject7 = ((Intent)localObject3).getStringExtra("hot_video_icon_sub");
      localObject4 = ((Intent)localObject3).getStringExtra("file_uuid");
      l1 = ((Intent)localObject3).getLongExtra("file_thumb_Size", 0L);
      k = ((Intent)localObject3).getIntExtra("special_video_type", 0);
      str1 = ((Intent)localObject3).getStringExtra("hot_video_name");
      j = ((Intent)localObject3).getIntExtra("short_video_msg_tail_type", 0);
      i = ((Intent)localObject3).getIntExtra("param_key_redbag_type", 0);
      if (i == LocalMediaInfo.REDBAG_TYPE_GET) {
        localObject1 = a(str7, i5);
      }
      bool1 = ((Intent)localObject3).getBooleanExtra("file_raw_size", false);
      localObject2 = ((Intent)localObject3).getStringExtra("widgetinfo");
      localObject11 = ((Intent)localObject3).getStringExtra("key_camera_material_name");
      localObject3 = localObject1;
      localObject1 = localObject11;
    }
    for (;;)
    {
      localObject11 = new ShortVideoUploadInfo();
      ((ShortVideoUploadInfo)localObject11).jdField_c_of_type_JavaLangString = str7;
      ((ShortVideoUploadInfo)localObject11).jdField_h_of_type_JavaLangString = str5;
      ((ShortVideoUploadInfo)localObject11).jdField_j_of_type_JavaLangString = str4;
      ((ShortVideoUploadInfo)localObject11).jdField_b_of_type_Int = i5;
      ((ShortVideoUploadInfo)localObject11).jdField_d_of_type_JavaLangString = str6;
      ((ShortVideoUploadInfo)localObject11).jdField_e_of_type_Int = ((int)l2);
      ((ShortVideoUploadInfo)localObject11).jdField_f_of_type_Int = i3;
      ((ShortVideoUploadInfo)localObject11).jdField_e_of_type_JavaLangString = str2;
      ((ShortVideoUploadInfo)localObject11).jdField_c_of_type_Int = i2;
      ((ShortVideoUploadInfo)localObject11).jdField_d_of_type_Int = i1;
      ((ShortVideoUploadInfo)localObject11).jdField_g_of_type_Int = paramShortVideoReq.jdField_a_of_type_Int;
      ((ShortVideoUploadInfo)localObject11).jdField_a_of_type_JavaLangObject = paramObject;
      ((ShortVideoUploadInfo)localObject11).jdField_g_of_type_JavaLangString = ((String)localObject10);
      ((ShortVideoUploadInfo)localObject11).jdField_l_of_type_JavaLangString = ((String)localObject9);
      ((ShortVideoUploadInfo)localObject11).jdField_k_of_type_JavaLangString = str3;
      ((ShortVideoUploadInfo)localObject11).jdField_a_of_type_Int = i4;
      ((ShortVideoUploadInfo)localObject11).jdField_c_of_type_Boolean = bool4;
      ((ShortVideoUploadInfo)localObject11).jdField_h_of_type_Int = n;
      ((ShortVideoUploadInfo)localObject11).jdField_i_of_type_Int = m;
      ((ShortVideoUploadInfo)localObject11).jdField_h_of_type_Boolean = bool3;
      ((ShortVideoUploadInfo)localObject11).jdField_d_of_type_Boolean = bool2;
      ((ShortVideoUploadInfo)localObject11).jdField_m_of_type_JavaLangString = ((String)localObject8);
      ((ShortVideoUploadInfo)localObject11).jdField_o_of_type_JavaLangString = ((String)localObject6);
      ((ShortVideoUploadInfo)localObject11).p = ((String)localObject5);
      ((ShortVideoUploadInfo)localObject11).jdField_n_of_type_JavaLangString = ((String)localObject7);
      ((ShortVideoUploadInfo)localObject11).jdField_a_of_type_JavaLangString = ((String)localObject4);
      ((ShortVideoUploadInfo)localObject11).jdField_b_of_type_Long = l1;
      ((ShortVideoUploadInfo)localObject11).jdField_j_of_type_Int = k;
      ((ShortVideoUploadInfo)localObject11).jdField_q_of_type_JavaLangString = str1;
      ((ShortVideoUploadInfo)localObject11).jdField_k_of_type_Int = j;
      ((ShortVideoUploadInfo)localObject11).jdField_l_of_type_Int = i;
      ((ShortVideoUploadInfo)localObject11).jdField_r_of_type_JavaLangString = ((String)localObject3);
      ((ShortVideoUploadInfo)localObject11).jdField_i_of_type_Boolean = bool1;
      ((ShortVideoUploadInfo)localObject11).jdField_s_of_type_JavaLangString = ((String)localObject2);
      ((ShortVideoUploadInfo)localObject11).t = ((String)localObject1);
      Logger.a(this.jdField_g_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, "createShortVideoUploadInfo", "");
      return localObject11;
      if ((paramObject instanceof MessageForShortVideo))
      {
        localObject6 = (MessageForShortVideo)paramObject;
        str7 = ((MessageForShortVideo)localObject6).frienduin;
        str6 = ((MessageForShortVideo)localObject6).frienduin;
        i5 = ((MessageForShortVideo)localObject6).istroop;
        l2 = ((MessageForShortVideo)localObject6).videoFileSize;
        i4 = paramShortVideoReq.jdField_b_of_type_Int;
        i3 = ((MessageForShortVideo)localObject6).videoFileTime;
        str5 = ((MessageForShortVideo)localObject6).videoFileName;
        str4 = ShortVideoUtils.getShortVideoThumbPicPath(((MessageForShortVideo)localObject6).thumbMD5, "jpg");
        str2 = ((MessageForShortVideo)localObject6).md5;
        i2 = ((MessageForShortVideo)localObject6).thumbWidth;
        i1 = ((MessageForShortVideo)localObject6).thumbHeight;
        localObject11 = ((MessageForShortVideo)localObject6).thumbMD5;
        String str8 = ((MessageForShortVideo)localObject6).fileSource;
        str3 = ((MessageForShortVideo)localObject6).mVideoFileSourceDir;
        bool4 = ((MessageForShortVideo)localObject6).supportProgressive;
        n = ((MessageForShortVideo)localObject6).fileWidth;
        m = ((MessageForShortVideo)localObject6).fileHeight;
        bool3 = ((MessageForShortVideo)localObject6).syncToStory;
        bool2 = ((MessageForShortVideo)localObject6).mediacodecEncode;
        if (((MessageForShortVideo)localObject6).CheckIsHotVideo())
        {
          localObject4 = ((MessageForShortVideo)localObject6).hotVideoIconUrl;
          localObject2 = ((MessageForShortVideo)localObject6).hotVideoTitle;
          localObject1 = ((MessageForShortVideo)localObject6).hotVideoUrl;
          localObject3 = ((MessageForShortVideo)localObject6).hotVideoSubIconUrl;
          str1 = ((MessageForShortVideo)localObject6).videoFileName;
          localObject5 = ((MessageForShortVideo)localObject6).uuid;
        }
        for (;;)
        {
          k = ((MessageForShortVideo)localObject6).specialVideoType;
          j = ((MessageForShortVideo)localObject6).msgTailType;
          i = ((MessageForShortVideo)localObject6).redBagType;
          String str9 = ((MessageForShortVideo)localObject6).shortVideoId;
          bool1 = ((MessageForShortVideo)localObject6).sendRawVideo;
          localObject9 = ((MessageForShortVideo)localObject6).templateId;
          String str10 = ((MessageForShortVideo)localObject6).templateName;
          l1 = -1L;
          localObject8 = localObject4;
          localObject7 = localObject3;
          localObject6 = localObject2;
          localObject10 = localObject1;
          localObject3 = str9;
          localObject1 = str10;
          localObject2 = localObject9;
          localObject4 = localObject5;
          localObject5 = localObject10;
          localObject9 = str8;
          localObject10 = localObject11;
          break;
          localObject5 = null;
          str1 = "";
          localObject1 = "";
          localObject2 = "";
          localObject3 = "";
          localObject4 = "";
        }
      }
      l1 = -1L;
      localObject8 = "";
      bool2 = false;
      localObject4 = null;
      localObject7 = "";
      k = 0;
      bool1 = false;
      localObject6 = "";
      j = 0;
      localObject5 = "";
      i = 0;
      str1 = "";
      localObject3 = "";
      localObject11 = "";
      localObject1 = localObject2;
      localObject2 = localObject11;
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
      localMessageForShortVideo.videoKandianType = paramSendResult.jdField_d_of_type_Int;
      localMessageForShortVideo.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, localMessageForShortVideo.msgData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.AioShortVideoOperator
 * JD-Core Version:    0.7.0.1
 */