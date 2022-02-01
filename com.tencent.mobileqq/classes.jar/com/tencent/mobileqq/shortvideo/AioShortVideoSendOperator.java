package com.tencent.mobileqq.shortvideo;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IConfessMsgUtil;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.msg.api.IMessageRecordFactory;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageConstants;
import tencent.im.msg.im_msg_body.RichText;

public class AioShortVideoSendOperator
  extends BaseShortVideoUpOperator
{
  public AioShortVideoSendOperator() {}
  
  public AioShortVideoSendOperator(BaseQQAppInterface paramBaseQQAppInterface)
  {
    super(paramBaseQQAppInterface);
  }
  
  private int a(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    if (paramInt == 1) {
      return 1;
    }
    if (paramInt == 3000) {
      return 2;
    }
    return 3;
  }
  
  public MessageRecord a(ShortVideoForwardInfo paramShortVideoForwardInfo)
  {
    long l = System.currentTimeMillis();
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)((IMessageRecordFactory)QRoute.api(IMessageRecordFactory.class)).createSendMSg_ShortVideo(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, paramShortVideoForwardInfo.jdField_c_of_type_JavaLangString, paramShortVideoForwardInfo.jdField_d_of_type_JavaLangString, paramShortVideoForwardInfo.jdField_b_of_type_Int);
    localMessageForShortVideo.videoFileName = paramShortVideoForwardInfo.jdField_h_of_type_JavaLangString;
    Object localObject1 = paramShortVideoForwardInfo.jdField_a_of_type_JavaLangString;
    Object localObject2 = "";
    if (localObject1 == null) {
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
    int i = 0;
    localMessageForShortVideo.videoFileProgress = 0;
    if (paramShortVideoForwardInfo.jdField_b_of_type_Int == 0) {
      localMessageForShortVideo.fileType = 6;
    } else if (paramShortVideoForwardInfo.jdField_b_of_type_Int == 3000) {
      localMessageForShortVideo.fileType = 17;
    } else if (paramShortVideoForwardInfo.jdField_b_of_type_Int == 1) {
      localMessageForShortVideo.fileType = 9;
    }
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
    if (paramShortVideoForwardInfo.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoForwardInfo$RetryInfo != null) {
      i = 1;
    }
    if (i != 0)
    {
      localMessageForShortVideo.msgseq = paramShortVideoForwardInfo.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoForwardInfo$RetryInfo.jdField_a_of_type_Long;
      localMessageForShortVideo.shmsgseq = paramShortVideoForwardInfo.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoForwardInfo$RetryInfo.jdField_b_of_type_Long;
      localMessageForShortVideo.msgUid = paramShortVideoForwardInfo.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoForwardInfo$RetryInfo.jdField_c_of_type_Long;
    }
    if (localMessageForShortVideo.busiType == 2) {
      localMessageForShortVideo.msg = ShortVideoConstants.MESSAGE_FOR_SHORT_VIDEO_PTV;
    } else {
      localMessageForShortVideo.msg = ShortVideoConstants.MESSAGEFORSHORTVIDEO_MSG;
    }
    if (paramShortVideoForwardInfo.jdField_n_of_type_JavaLangString == null) {
      localObject1 = "";
    } else {
      localObject1 = paramShortVideoForwardInfo.jdField_n_of_type_JavaLangString;
    }
    localMessageForShortVideo.hotVideoIconUrl = ((String)localObject1);
    if (paramShortVideoForwardInfo.p == null) {
      localObject1 = "";
    } else {
      localObject1 = paramShortVideoForwardInfo.p;
    }
    localMessageForShortVideo.hotVideoTitle = ((String)localObject1);
    if (paramShortVideoForwardInfo.jdField_q_of_type_JavaLangString == null) {
      localObject1 = "";
    } else {
      localObject1 = paramShortVideoForwardInfo.jdField_q_of_type_JavaLangString;
    }
    localMessageForShortVideo.hotVideoUrl = ((String)localObject1);
    if (paramShortVideoForwardInfo.jdField_o_of_type_JavaLangString == null) {
      localObject1 = localObject2;
    } else {
      localObject1 = paramShortVideoForwardInfo.jdField_o_of_type_JavaLangString;
    }
    localMessageForShortVideo.hotVideoSubIconUrl = ((String)localObject1);
    localMessageForShortVideo.specialVideoType = paramShortVideoForwardInfo.jdField_q_of_type_Int;
    localMessageForShortVideo.msgTailType = paramShortVideoForwardInfo.jdField_r_of_type_Int;
    localMessageForShortVideo.redBagType = paramShortVideoForwardInfo.jdField_s_of_type_Int;
    localMessageForShortVideo.shortVideoId = paramShortVideoForwardInfo.jdField_r_of_type_JavaLangString;
    localMessageForShortVideo.isStoryVideo = paramShortVideoForwardInfo.jdField_c_of_type_Boolean;
    if (!TextUtils.isEmpty(paramShortVideoForwardInfo.jdField_s_of_type_JavaLangString))
    {
      localMessageForShortVideo.templateId = paramShortVideoForwardInfo.jdField_s_of_type_JavaLangString;
      localMessageForShortVideo.templateName = paramShortVideoForwardInfo.t;
    }
    localMessageForShortVideo.serial();
    paramShortVideoForwardInfo.jdField_a_of_type_Long = localMessageForShortVideo.uniseq;
    paramShortVideoForwardInfo = this.jdField_b_of_type_JavaLangString;
    localObject1 = this.jdField_a_of_type_JavaLangString;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("cost:");
    ((StringBuilder)localObject2).append(System.currentTimeMillis() - l);
    Logger.a(paramShortVideoForwardInfo, (String)localObject1, "packForwardMsg", ((StringBuilder)localObject2).toString());
    paramShortVideoForwardInfo = this.jdField_b_of_type_JavaLangString;
    localObject1 = this.jdField_a_of_type_JavaLangString;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("mr: ");
    ((StringBuilder)localObject2).append(localMessageForShortVideo.toString());
    Logger.a(paramShortVideoForwardInfo, (String)localObject1, "packForwardMsg", ((StringBuilder)localObject2).toString());
    return localMessageForShortVideo;
  }
  
  public MessageRecord a(ShortVideoUploadInfo paramShortVideoUploadInfo)
  {
    long l = System.currentTimeMillis();
    boolean bool = paramShortVideoUploadInfo.jdField_e_of_type_Boolean;
    int i = 1;
    Object localObject1;
    if (bool)
    {
      localObject1 = (MessageForShortVideo)((IMessageRecordFactory)QRoute.api(IMessageRecordFactory.class)).createSendMSg_BlessPTV(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, paramShortVideoUploadInfo.jdField_c_of_type_JavaLangString, paramShortVideoUploadInfo.jdField_d_of_type_JavaLangString, paramShortVideoUploadInfo.jdField_b_of_type_Int);
      ((MessageForShortVideo)localObject1).subBusiType = 1;
      ((MessageForShortVideo)localObject1).videoFileName = paramShortVideoUploadInfo.jdField_h_of_type_JavaLangString;
    }
    else if (paramShortVideoUploadInfo.jdField_f_of_type_Boolean)
    {
      localObject2 = (MessageForShortVideo)((IMessageRecordFactory)QRoute.api(IMessageRecordFactory.class)).createSendMSg_ShortVideo(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, paramShortVideoUploadInfo.jdField_c_of_type_JavaLangString, paramShortVideoUploadInfo.jdField_d_of_type_JavaLangString, paramShortVideoUploadInfo.jdField_b_of_type_Int);
      ((MessageForShortVideo)localObject2).subBusiType = 0;
      ((MessageForShortVideo)localObject2).hotVideoIconUrl = paramShortVideoUploadInfo.jdField_m_of_type_JavaLangString;
      ((MessageForShortVideo)localObject2).hotVideoTitle = paramShortVideoUploadInfo.jdField_o_of_type_JavaLangString;
      ((MessageForShortVideo)localObject2).hotVideoUrl = paramShortVideoUploadInfo.p;
      ((MessageForShortVideo)localObject2).hotVideoSubIconUrl = paramShortVideoUploadInfo.jdField_n_of_type_JavaLangString;
      ((MessageForShortVideo)localObject2).videoFileName = paramShortVideoUploadInfo.jdField_q_of_type_JavaLangString;
      ((MessageForShortVideo)localObject2).videoAttr = 0;
      ((MessageForShortVideo)localObject2).videoKandianType = 0;
      if (((MessageForShortVideo)localObject2).videoFileName != null)
      {
        localObject1 = localObject2;
        if (((MessageForShortVideo)localObject2).videoFileName.length() != 0) {}
      }
      else
      {
        localObject3 = new StringBuilder();
        if ((paramShortVideoUploadInfo.jdField_e_of_type_JavaLangString != null) && (paramShortVideoUploadInfo.jdField_e_of_type_JavaLangString.length() != 0)) {
          localObject1 = paramShortVideoUploadInfo.jdField_e_of_type_JavaLangString;
        } else {
          localObject1 = "HotVideo";
        }
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append(".mp4");
        ((MessageForShortVideo)localObject2).videoFileName = ((StringBuilder)localObject3).toString();
        localObject1 = localObject2;
      }
    }
    else
    {
      localObject1 = (MessageForShortVideo)((IMessageRecordFactory)QRoute.api(IMessageRecordFactory.class)).createSendMSg_ShortVideo(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, paramShortVideoUploadInfo.jdField_c_of_type_JavaLangString, paramShortVideoUploadInfo.jdField_d_of_type_JavaLangString, paramShortVideoUploadInfo.jdField_b_of_type_Int);
      ((MessageForShortVideo)localObject1).subBusiType = 0;
      ((MessageForShortVideo)localObject1).videoFileName = paramShortVideoUploadInfo.jdField_h_of_type_JavaLangString;
    }
    ((MessageForShortVideo)localObject1).specialVideoType = paramShortVideoUploadInfo.jdField_j_of_type_Int;
    ((MessageForShortVideo)localObject1).msgTailType = paramShortVideoUploadInfo.jdField_k_of_type_Int;
    ((MessageForShortVideo)localObject1).redBagType = paramShortVideoUploadInfo.jdField_l_of_type_Int;
    ((MessageForShortVideo)localObject1).shortVideoId = paramShortVideoUploadInfo.jdField_r_of_type_JavaLangString;
    if (paramShortVideoUploadInfo.jdField_a_of_type_JavaLangString == null) {
      paramShortVideoUploadInfo.jdField_a_of_type_JavaLangString = "";
    }
    ((MessageForShortVideo)localObject1).uuid = paramShortVideoUploadInfo.jdField_a_of_type_JavaLangString;
    if (paramShortVideoUploadInfo.jdField_e_of_type_JavaLangString == null) {
      paramShortVideoUploadInfo.jdField_e_of_type_JavaLangString = "";
    }
    ((MessageForShortVideo)localObject1).md5 = paramShortVideoUploadInfo.jdField_e_of_type_JavaLangString;
    ((MessageForShortVideo)localObject1).videoFileFormat = 2;
    ((MessageForShortVideo)localObject1).videoFileSize = paramShortVideoUploadInfo.jdField_e_of_type_Int;
    ((MessageForShortVideo)localObject1).videoFileTime = paramShortVideoUploadInfo.jdField_f_of_type_Int;
    ((MessageForShortVideo)localObject1).thumbWidth = paramShortVideoUploadInfo.jdField_c_of_type_Int;
    ((MessageForShortVideo)localObject1).thumbHeight = paramShortVideoUploadInfo.jdField_d_of_type_Int;
    ((MessageForShortVideo)localObject1).mThumbFilePath = paramShortVideoUploadInfo.jdField_j_of_type_JavaLangString;
    ((MessageForShortVideo)localObject1).mVideoFileSourceDir = paramShortVideoUploadInfo.jdField_k_of_type_JavaLangString;
    ((MessageForShortVideo)localObject1).videoFileStatus = 999;
    ((MessageForShortVideo)localObject1).videoFileProgress = 0;
    ((MessageForShortVideo)localObject1).extraflag = 32772;
    ((MessageForShortVideo)localObject1).thumbMD5 = paramShortVideoUploadInfo.jdField_g_of_type_JavaLangString;
    if ((paramShortVideoUploadInfo.jdField_l_of_type_JavaLangString == null) || (paramShortVideoUploadInfo.jdField_l_of_type_JavaLangString.length() == 0)) {
      paramShortVideoUploadInfo.jdField_l_of_type_JavaLangString = "camera";
    }
    ((MessageForShortVideo)localObject1).fileSource = paramShortVideoUploadInfo.jdField_l_of_type_JavaLangString;
    ((MessageForShortVideo)localObject1).lastModified = 0L;
    ((MessageForShortVideo)localObject1).mediacodecEncode = paramShortVideoUploadInfo.jdField_d_of_type_Boolean;
    if (((MessageForShortVideo)localObject1).istroop == 0) {
      ((MessageForShortVideo)localObject1).fileType = 6;
    } else if (((MessageForShortVideo)localObject1).istroop == 3000) {
      ((MessageForShortVideo)localObject1).fileType = 17;
    } else if (((MessageForShortVideo)localObject1).istroop == 1) {
      ((MessageForShortVideo)localObject1).fileType = 9;
    }
    if (paramShortVideoUploadInfo.jdField_b_of_type_Int == 1008) {
      ((MessageForShortVideo)localObject1).busiType = 1007;
    } else if (2 == paramShortVideoUploadInfo.jdField_a_of_type_Int) {
      ((MessageForShortVideo)localObject1).busiType = 1;
    } else if (3 == paramShortVideoUploadInfo.jdField_a_of_type_Int) {
      ((MessageForShortVideo)localObject1).busiType = 2;
    } else {
      ((MessageForShortVideo)localObject1).busiType = 0;
    }
    if (paramShortVideoUploadInfo.jdField_b_of_type_Int == 0) {
      ((IConfessMsgUtil)QRoute.api(IConfessMsgUtil.class)).bindC2CFirstMsgConfessInfo(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, (MessageRecord)localObject1, paramShortVideoUploadInfo.jdField_c_of_type_JavaLangString);
    } else if (paramShortVideoUploadInfo.jdField_b_of_type_Int == 1) {
      ((IConfessMsgUtil)QRoute.api(IConfessMsgUtil.class)).bindGroupFirstMsgConfessInfo(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, (MessageRecord)localObject1, paramShortVideoUploadInfo.jdField_c_of_type_JavaLangString);
    }
    ((MessageForShortVideo)localObject1).fromChatType = -1;
    ((MessageForShortVideo)localObject1).toChatType = -1;
    ((MessageForShortVideo)localObject1).uiOperatorFlag = 1;
    ((MessageForShortVideo)localObject1).supportProgressive = paramShortVideoUploadInfo.jdField_c_of_type_Boolean;
    ((MessageForShortVideo)localObject1).fileWidth = paramShortVideoUploadInfo.jdField_h_of_type_Int;
    ((MessageForShortVideo)localObject1).fileHeight = paramShortVideoUploadInfo.jdField_i_of_type_Int;
    ((MessageForShortVideo)localObject1).syncToStory = paramShortVideoUploadInfo.jdField_h_of_type_Boolean;
    Object localObject3 = MessageConstants.jdField_n_of_type_JavaLangString;
    if (((MessageForShortVideo)localObject1).syncToStory) {
      localObject2 = "1";
    } else {
      localObject2 = "0";
    }
    ((MessageForShortVideo)localObject1).saveExtInfoToExtStr((String)localObject3, (String)localObject2);
    ((MessageForShortVideo)localObject1).sendRawVideo = paramShortVideoUploadInfo.jdField_i_of_type_Boolean;
    if (paramShortVideoUploadInfo.jdField_i_of_type_Boolean) {
      ((MessageForShortVideo)localObject1).saveExtInfoToExtStr(MessageConstants.C, "1");
    }
    if (paramShortVideoUploadInfo.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo$RetryInfo == null) {
      i = 0;
    }
    if (i != 0)
    {
      ((MessageForShortVideo)localObject1).msgseq = paramShortVideoUploadInfo.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo$RetryInfo.jdField_a_of_type_Long;
      ((MessageForShortVideo)localObject1).shmsgseq = paramShortVideoUploadInfo.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo$RetryInfo.jdField_b_of_type_Long;
      ((MessageForShortVideo)localObject1).msgUid = paramShortVideoUploadInfo.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo$RetryInfo.jdField_c_of_type_Long;
    }
    if (((MessageForShortVideo)localObject1).busiType == 2) {
      ((MessageForShortVideo)localObject1).msg = ShortVideoConstants.MESSAGE_FOR_SHORT_VIDEO_PTV;
    } else {
      ((MessageForShortVideo)localObject1).msg = ShortVideoConstants.MESSAGEFORSHORTVIDEO_MSG;
    }
    if (!TextUtils.isEmpty(paramShortVideoUploadInfo.jdField_s_of_type_JavaLangString))
    {
      ((MessageForShortVideo)localObject1).templateId = paramShortVideoUploadInfo.jdField_s_of_type_JavaLangString;
      ((MessageForShortVideo)localObject1).templateName = paramShortVideoUploadInfo.t;
    }
    ((MessageForShortVideo)localObject1).serial();
    paramShortVideoUploadInfo.jdField_a_of_type_Long = ((MessageForShortVideo)localObject1).uniseq;
    paramShortVideoUploadInfo = this.jdField_b_of_type_JavaLangString;
    Object localObject2 = this.jdField_a_of_type_JavaLangString;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("cost:");
    ((StringBuilder)localObject3).append(System.currentTimeMillis() - l);
    Logger.a(paramShortVideoUploadInfo, (String)localObject2, "packmsg", ((StringBuilder)localObject3).toString());
    paramShortVideoUploadInfo = this.jdField_b_of_type_JavaLangString;
    localObject2 = this.jdField_a_of_type_JavaLangString;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("mr: ");
    ((StringBuilder)localObject3).append(((MessageForShortVideo)localObject1).toLogString());
    ((StringBuilder)localObject3).append("-");
    ((StringBuilder)localObject3).append(((MessageForShortVideo)localObject1).toString());
    Logger.a(paramShortVideoUploadInfo, (String)localObject2, "packMsg", ((StringBuilder)localObject3).toString());
    return localObject1;
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "attachRichText2Msg", "");
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForRichText)) {
      ((MessageForRichText)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).richText = paramRichText;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  }
  
  public ShortVideoForwardInfo a(Object paramObject, ShortVideoReq paramShortVideoReq)
  {
    if (paramObject == null)
    {
      Logger.b("AioShortVideoOperator", this.jdField_a_of_type_JavaLangString, "createShortVideoForwardInfo", "input == null");
      return null;
    }
    if (paramShortVideoReq == null)
    {
      Logger.b("AioShortVideoOperator", this.jdField_a_of_type_JavaLangString, "createShortVideoForwardInfo", "ShortVideoReq == null");
      return null;
    }
    boolean bool5 = paramObject instanceof Intent;
    String str4 = "";
    Object localObject7;
    String str2;
    String str3;
    int i4;
    Object localObject14;
    int i2;
    Object localObject5;
    int n;
    int i1;
    Object localObject9;
    Object localObject10;
    Object localObject11;
    Object localObject8;
    int i3;
    String str1;
    Object localObject12;
    Object localObject13;
    int i5;
    int i6;
    int i7;
    int i8;
    Object localObject4;
    Object localObject3;
    Object localObject2;
    int i9;
    int i10;
    long l;
    boolean bool2;
    boolean bool1;
    Object localObject6;
    boolean bool3;
    int i;
    if (bool5)
    {
      localObject7 = (Intent)paramObject;
      str2 = ((Intent)localObject7).getStringExtra("uin");
      str3 = ((Intent)localObject7).getStringExtra("troop_uin");
      i4 = ((Intent)localObject7).getIntExtra("uintype", -1);
      localObject14 = ((Intent)localObject7).getStringExtra("from_uin");
      i2 = ((Intent)localObject7).getIntExtra("from_uin_type", -1);
      localObject5 = ((Intent)localObject7).getStringExtra("from_session_uin");
      ((Intent)localObject7).getIntExtra("from_busi_type", -1);
      n = ((Intent)localObject7).getIntExtra("file_send_size", 0);
      i1 = ((Intent)localObject7).getIntExtra("file_send_duration", -1);
      localObject9 = ((Intent)localObject7).getStringExtra("file_send_path");
      localObject10 = ((Intent)localObject7).getStringExtra("thumbfile_send_path");
      localObject11 = ((Intent)localObject7).getStringExtra("file_shortvideo_md5");
      localObject8 = ((Intent)localObject7).getStringExtra("file_shortvideo_local_md5");
      i3 = ((Intent)localObject7).getIntExtra("thumbfile_send_width", 0);
      m = ((Intent)localObject7).getIntExtra("thumbfile_send_height", 0);
      str1 = ((Intent)localObject7).getStringExtra("thumbfile_md5");
      str4 = ((Intent)localObject7).getStringExtra("file_source");
      localObject12 = ((Intent)localObject7).getStringExtra("file_uuid");
      localObject13 = ((Intent)localObject7).getStringExtra("file_name");
      i5 = ((Intent)localObject7).getIntExtra("file_format", 2);
      i6 = ((Intent)localObject7).getIntExtra("file_thumb_Size", 0);
      boolean bool4 = ((Intent)localObject7).getBooleanExtra("support_progressive", false);
      i7 = ((Intent)localObject7).getIntExtra("file_width", 0);
      i8 = ((Intent)localObject7).getIntExtra("file_height", 0);
      localObject4 = ((Intent)localObject7).getStringExtra("hot_video_icon");
      localObject3 = ((Intent)localObject7).getStringExtra("hot_video_title");
      localObject2 = ((Intent)localObject7).getStringExtra("hot_video_url");
      localObject1 = ((Intent)localObject7).getStringExtra("hot_video_icon_sub");
      i9 = ((Intent)localObject7).getIntExtra("special_video_type", 0);
      i10 = ((Intent)localObject7).getIntExtra("short_video_msg_tail_type", 0);
      l = ((Intent)localObject7).getLongExtra("from_msg_uniseq", 0L);
      bool2 = ((Intent)localObject7).getBooleanExtra("key_story_video_to_recent", false);
      if (((Intent)localObject7).getIntExtra("forward_source_business_type", -1) == 100200) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localObject6 = ((Intent)localObject7).getStringExtra("widgetinfo");
      localObject7 = ((Intent)localObject7).getStringExtra("key_camera_material_name");
      bool3 = bool1;
      j = 0;
      i = 0;
      k = 0;
      bool1 = bool4;
    }
    else if ((paramObject instanceof MessageForShortVideo))
    {
      localObject5 = (MessageForShortVideo)paramObject;
      str2 = ((MessageForShortVideo)localObject5).frienduin;
      str3 = ((MessageForShortVideo)localObject5).frienduin;
      i4 = ((MessageForShortVideo)localObject5).istroop;
      n = ((MessageForShortVideo)localObject5).videoFileSize;
      i1 = ((MessageForShortVideo)localObject5).videoFileTime;
      localObject9 = ((MessageForShortVideo)localObject5).videoFileName;
      localObject10 = SVUtils.a(((MessageForShortVideo)localObject5).thumbMD5, "jpg");
      localObject11 = ((MessageForShortVideo)localObject5).md5;
      localObject8 = ((MessageForShortVideo)localObject5).mLocalMd5;
      i3 = ((MessageForShortVideo)localObject5).thumbWidth;
      m = ((MessageForShortVideo)localObject5).thumbHeight;
      str1 = ((MessageForShortVideo)localObject5).thumbMD5;
      str4 = ((MessageForShortVideo)localObject5).fileSource;
      localObject12 = ((MessageForShortVideo)localObject5).uuid;
      i5 = ((MessageForShortVideo)localObject5).videoFileFormat;
      i6 = ((MessageForShortVideo)localObject5).thumbFileSize;
      j = ((MessageForShortVideo)localObject5).fromChatType;
      k = ((MessageForShortVideo)localObject5).toChatType;
      i = ((MessageForShortVideo)localObject5).busiType;
      localObject14 = SVUtils.a((MessageForShortVideo)localObject5);
      bool1 = ((MessageForShortVideo)localObject5).supportProgressive;
      i7 = ((MessageForShortVideo)localObject5).fileWidth;
      i8 = ((MessageForShortVideo)localObject5).fileHeight;
      i9 = ((MessageForShortVideo)localObject5).specialVideoType;
      i10 = ((MessageForShortVideo)localObject5).msgTailType;
      l = ((MessageForShortVideo)localObject5).uniseq;
      bool2 = ((MessageForShortVideo)localObject5).isStoryVideo;
      if (((MessageForShortVideo)localObject5).checkIsHotVideo())
      {
        localObject2 = ((MessageForShortVideo)localObject5).hotVideoIconUrl;
        localObject4 = ((MessageForShortVideo)localObject5).hotVideoTitle;
        localObject3 = ((MessageForShortVideo)localObject5).hotVideoUrl;
        localObject1 = ((MessageForShortVideo)localObject5).hotVideoSubIconUrl;
      }
      else
      {
        localObject2 = "";
        localObject4 = localObject2;
        localObject3 = localObject4;
        localObject1 = localObject3;
      }
      localObject6 = ((MessageForShortVideo)localObject5).templateId;
      String str5 = ((MessageForShortVideo)localObject5).templateName;
      localObject13 = localObject9;
      localObject7 = localObject4;
      localObject15 = localObject3;
      bool3 = false;
      i2 = -1;
      localObject5 = "0";
      localObject4 = localObject2;
      localObject3 = localObject7;
      localObject2 = localObject15;
      localObject7 = str5;
    }
    else
    {
      l = 0L;
      str2 = "0";
      str3 = str2;
      localObject5 = str3;
      localObject14 = localObject5;
      str1 = "";
      localObject8 = str1;
      localObject9 = localObject8;
      localObject10 = localObject9;
      localObject11 = localObject10;
      localObject4 = localObject11;
      localObject3 = localObject4;
      localObject2 = localObject3;
      localObject1 = localObject2;
      localObject12 = localObject1;
      localObject13 = localObject12;
      localObject6 = localObject13;
      localObject7 = localObject6;
      m = 0;
      n = 0;
      i1 = 0;
      i3 = 0;
      i4 = 0;
      j = 0;
      i = 0;
      i5 = 2;
      i6 = 0;
      bool1 = false;
      i7 = 0;
      i8 = 0;
      bool2 = false;
      i9 = 0;
      i10 = 0;
      bool3 = false;
      i2 = -1;
      k = 0;
    }
    if (TextUtils.isEmpty((CharSequence)localObject11))
    {
      Logger.b(paramShortVideoReq.jdField_b_of_type_JavaLangString, paramShortVideoReq.jdField_a_of_type_JavaLangString, "createShortVideoForwardInfo", "md5 shouldn't be empty ");
      return null;
    }
    Object localObject15 = new ShortVideoForwardInfo();
    ((ShortVideoForwardInfo)localObject15).jdField_c_of_type_JavaLangString = str2;
    ((ShortVideoForwardInfo)localObject15).jdField_h_of_type_JavaLangString = ((String)localObject9);
    ((ShortVideoForwardInfo)localObject15).jdField_i_of_type_JavaLangString = ((String)localObject10);
    ((ShortVideoForwardInfo)localObject15).jdField_b_of_type_Int = i4;
    ((ShortVideoForwardInfo)localObject15).jdField_d_of_type_JavaLangString = str3;
    ((ShortVideoForwardInfo)localObject15).jdField_i_of_type_Int = n;
    ((ShortVideoForwardInfo)localObject15).jdField_j_of_type_Int = i1;
    ((ShortVideoForwardInfo)localObject15).jdField_e_of_type_JavaLangString = ((String)localObject11);
    ((ShortVideoForwardInfo)localObject15).jdField_f_of_type_JavaLangString = ((String)localObject8);
    ((ShortVideoForwardInfo)localObject15).jdField_g_of_type_Int = i3;
    ((ShortVideoForwardInfo)localObject15).jdField_h_of_type_Int = m;
    ((ShortVideoForwardInfo)localObject15).jdField_k_of_type_Int = paramShortVideoReq.jdField_a_of_type_Int;
    ((ShortVideoForwardInfo)localObject15).jdField_a_of_type_JavaLangObject = paramObject;
    ((ShortVideoForwardInfo)localObject15).jdField_g_of_type_JavaLangString = str1;
    ((ShortVideoForwardInfo)localObject15).jdField_j_of_type_JavaLangString = str4;
    ((ShortVideoForwardInfo)localObject15).jdField_a_of_type_JavaLangString = ((String)localObject12);
    ((ShortVideoForwardInfo)localObject15).jdField_k_of_type_JavaLangString = ((String)localObject13);
    ((ShortVideoForwardInfo)localObject15).jdField_l_of_type_Int = i5;
    ((ShortVideoForwardInfo)localObject15).jdField_m_of_type_Int = i6;
    ((ShortVideoForwardInfo)localObject15).jdField_b_of_type_Boolean = bool1;
    ((ShortVideoForwardInfo)localObject15).jdField_n_of_type_Int = i7;
    ((ShortVideoForwardInfo)localObject15).jdField_o_of_type_Int = i8;
    ((ShortVideoForwardInfo)localObject15).jdField_l_of_type_JavaLangString = ((String)localObject14);
    if (localObject5 == null) {
      localObject5 = "0";
    }
    ((ShortVideoForwardInfo)localObject15).jdField_m_of_type_JavaLangString = ((String)localObject5);
    ((ShortVideoForwardInfo)localObject15).jdField_b_of_type_Long = l;
    ((ShortVideoForwardInfo)localObject15).jdField_c_of_type_Boolean = bool2;
    if (localObject4 == null) {
      localObject4 = "";
    }
    ((ShortVideoForwardInfo)localObject15).jdField_n_of_type_JavaLangString = ((String)localObject4);
    if (localObject3 == null) {
      localObject3 = "";
    }
    ((ShortVideoForwardInfo)localObject15).p = ((String)localObject3);
    if (localObject2 == null) {
      localObject2 = "";
    }
    ((ShortVideoForwardInfo)localObject15).jdField_q_of_type_JavaLangString = ((String)localObject2);
    if (localObject1 == null) {
      localObject1 = "";
    }
    ((ShortVideoForwardInfo)localObject15).jdField_o_of_type_JavaLangString = ((String)localObject1);
    ((ShortVideoForwardInfo)localObject15).jdField_q_of_type_Int = i9;
    ((ShortVideoForwardInfo)localObject15).jdField_r_of_type_Int = i10;
    if (2 == paramShortVideoReq.jdField_b_of_type_Int)
    {
      ((ShortVideoForwardInfo)localObject15).jdField_s_of_type_Int = 0;
      ((ShortVideoForwardInfo)localObject15).jdField_r_of_type_JavaLangString = "";
    }
    ((ShortVideoForwardInfo)localObject15).jdField_d_of_type_Boolean = bool3;
    ((ShortVideoForwardInfo)localObject15).jdField_s_of_type_JavaLangString = ((String)localObject6);
    ((ShortVideoForwardInfo)localObject15).t = ((String)localObject7);
    if (bool5) {
      k = a(i2);
    }
    for (int j = a(i4);; j = m)
    {
      m = j;
      break label1341;
      if ((!(paramObject instanceof MessageForShortVideo)) || (k != -1)) {
        break;
      }
      m = a(i4);
      k = j;
    }
    int m = k;
    int k = j;
    label1341:
    if (i2 == 1008)
    {
      n = 1007;
      j = i;
      i = n;
    }
    else
    {
      n = paramShortVideoReq.jdField_b_of_type_Int;
      j = 2;
      if (2 == n)
      {
        i = 1;
        j = 1;
      }
      else if (3 == paramShortVideoReq.jdField_b_of_type_Int)
      {
        i = 2;
      }
      else if (5 == paramShortVideoReq.jdField_b_of_type_Int)
      {
        j = i;
      }
      else
      {
        i = 0;
        j = 0;
      }
    }
    ((ShortVideoForwardInfo)localObject15).jdField_c_of_type_Int = k;
    ((ShortVideoForwardInfo)localObject15).jdField_d_of_type_Int = m;
    ((ShortVideoForwardInfo)localObject15).jdField_e_of_type_Int = i;
    ((ShortVideoForwardInfo)localObject15).jdField_f_of_type_Int = j;
    paramObject = paramShortVideoReq.jdField_b_of_type_JavaLangString;
    paramShortVideoReq = paramShortVideoReq.jdField_a_of_type_JavaLangString;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(((ShortVideoForwardInfo)localObject15).a());
    Logger.a(paramObject, paramShortVideoReq, "createShortVideoForwardInfo", ((StringBuilder)localObject1).toString());
    return localObject15;
  }
  
  public ShortVideoUploadInfo a(Object paramObject, ShortVideoReq paramShortVideoReq)
  {
    if (paramObject == null)
    {
      Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "createShortVideoUploadInfo", "unknow obj");
      return null;
    }
    boolean bool1 = paramObject instanceof Intent;
    Object localObject4 = "0";
    Object localObject6 = "";
    Object localObject16;
    Object localObject3;
    int m;
    long l1;
    int n;
    int k;
    Object localObject5;
    Object localObject7;
    Object localObject2;
    int i;
    int j;
    Object localObject1;
    Object localObject8;
    int i1;
    int i2;
    boolean bool3;
    Object localObject9;
    Object localObject10;
    Object localObject11;
    Object localObject12;
    Object localObject13;
    long l2;
    int i3;
    Object localObject14;
    int i4;
    boolean bool4;
    Object localObject15;
    boolean bool2;
    if (bool1)
    {
      localObject16 = (Intent)paramObject;
      localObject4 = ((Intent)localObject16).getStringExtra("uin");
      localObject3 = ((Intent)localObject16).getStringExtra("troop_uin");
      m = ((Intent)localObject16).getIntExtra("uintype", 1003);
      l1 = ((Intent)localObject16).getLongExtra("file_send_size", 0L);
      n = ((Intent)localObject16).getIntExtra("file_send_business_type", 0);
      k = ((Intent)localObject16).getIntExtra("file_send_duration", -1);
      localObject5 = ((Intent)localObject16).getStringExtra("file_send_path");
      localObject7 = ((Intent)localObject16).getStringExtra("thumbfile_send_path");
      localObject2 = ((Intent)localObject16).getStringExtra("file_shortvideo_md5");
      i = ((Intent)localObject16).getIntExtra("thumbfile_send_width", 0);
      j = ((Intent)localObject16).getIntExtra("thumbfile_send_height", 0);
      localObject1 = ((Intent)localObject16).getStringExtra("thumbfile_md5");
      localObject6 = ((Intent)localObject16).getStringExtra("file_source");
      localObject8 = ((Intent)localObject16).getStringExtra("file_video_source_dir");
      bool1 = ((Intent)localObject16).getBooleanExtra("support_progressive", false);
      i1 = ((Intent)localObject16).getIntExtra("file_width", 0);
      i2 = ((Intent)localObject16).getIntExtra("file_height", 0);
      bool3 = ((Intent)localObject16).getBooleanExtra("mediacodec_encode_enable", false);
      localObject9 = ((Intent)localObject16).getStringExtra("hot_video_icon");
      localObject10 = ((Intent)localObject16).getStringExtra("hot_video_title");
      localObject11 = ((Intent)localObject16).getStringExtra("hot_video_url");
      localObject12 = ((Intent)localObject16).getStringExtra("hot_video_icon_sub");
      localObject13 = ((Intent)localObject16).getStringExtra("file_uuid");
      l2 = ((Intent)localObject16).getLongExtra("file_thumb_Size", 0L);
      i3 = ((Intent)localObject16).getIntExtra("special_video_type", 0);
      localObject14 = ((Intent)localObject16).getStringExtra("hot_video_name");
      i4 = ((Intent)localObject16).getIntExtra("short_video_msg_tail_type", 0);
      bool4 = ((Intent)localObject16).getBooleanExtra("file_raw_size", false);
      localObject15 = ((Intent)localObject16).getStringExtra("widgetinfo");
      localObject16 = ((Intent)localObject16).getStringExtra("key_camera_material_name");
      bool2 = false;
    }
    else if ((paramObject instanceof MessageForShortVideo))
    {
      localObject9 = (MessageForShortVideo)paramObject;
      String str2 = ((MessageForShortVideo)localObject9).frienduin;
      String str3 = ((MessageForShortVideo)localObject9).frienduin;
      m = ((MessageForShortVideo)localObject9).istroop;
      l1 = ((MessageForShortVideo)localObject9).videoFileSize;
      n = paramShortVideoReq.jdField_b_of_type_Int;
      k = ((MessageForShortVideo)localObject9).videoFileTime;
      localObject10 = ((MessageForShortVideo)localObject9).videoFileName;
      String str1 = SVUtils.a(((MessageForShortVideo)localObject9).thumbMD5, "jpg");
      localObject17 = ((MessageForShortVideo)localObject9).md5;
      i = ((MessageForShortVideo)localObject9).thumbWidth;
      j = ((MessageForShortVideo)localObject9).thumbHeight;
      String str4 = ((MessageForShortVideo)localObject9).thumbMD5;
      localObject7 = ((MessageForShortVideo)localObject9).fileSource;
      localObject8 = ((MessageForShortVideo)localObject9).mVideoFileSourceDir;
      bool1 = ((MessageForShortVideo)localObject9).supportProgressive;
      i1 = ((MessageForShortVideo)localObject9).fileWidth;
      i2 = ((MessageForShortVideo)localObject9).fileHeight;
      bool2 = ((MessageForShortVideo)localObject9).syncToStory;
      bool3 = ((MessageForShortVideo)localObject9).mediacodecEncode;
      if (((MessageForShortVideo)localObject9).checkIsHotVideo())
      {
        localObject6 = ((MessageForShortVideo)localObject9).hotVideoIconUrl;
        localObject5 = ((MessageForShortVideo)localObject9).hotVideoTitle;
        localObject4 = ((MessageForShortVideo)localObject9).hotVideoUrl;
        localObject3 = ((MessageForShortVideo)localObject9).hotVideoSubIconUrl;
        localObject2 = ((MessageForShortVideo)localObject9).videoFileName;
        localObject1 = ((MessageForShortVideo)localObject9).uuid;
      }
      else
      {
        localObject6 = "";
        localObject5 = localObject6;
        localObject4 = localObject5;
        localObject3 = localObject4;
        localObject2 = localObject3;
        localObject1 = null;
      }
      i3 = ((MessageForShortVideo)localObject9).specialVideoType;
      i4 = ((MessageForShortVideo)localObject9).msgTailType;
      bool4 = ((MessageForShortVideo)localObject9).sendRawVideo;
      localObject15 = ((MessageForShortVideo)localObject9).templateId;
      localObject16 = ((MessageForShortVideo)localObject9).templateName;
      localObject9 = localObject6;
      localObject6 = localObject10;
      localObject10 = localObject5;
      localObject11 = localObject4;
      localObject12 = localObject3;
      localObject14 = localObject2;
      localObject13 = localObject1;
      l2 = -1L;
      localObject1 = str4;
      localObject2 = localObject17;
      localObject3 = str3;
      localObject4 = str2;
      localObject5 = localObject6;
      localObject6 = localObject7;
      localObject7 = str1;
    }
    else
    {
      l1 = 0L;
      localObject3 = "0";
      localObject1 = "";
      localObject2 = localObject1;
      localObject5 = localObject2;
      localObject7 = localObject5;
      localObject8 = localObject7;
      localObject9 = localObject8;
      localObject10 = localObject9;
      localObject11 = localObject10;
      localObject12 = localObject11;
      localObject14 = localObject12;
      localObject15 = localObject14;
      localObject16 = localObject15;
      i = 0;
      j = 0;
      k = 0;
      m = 0;
      n = 0;
      bool1 = false;
      i1 = 0;
      i2 = 0;
      bool2 = false;
      bool3 = false;
      localObject13 = null;
      l2 = -1L;
      i3 = 0;
      i4 = 0;
      bool4 = false;
    }
    Object localObject17 = new ShortVideoUploadInfo();
    ((ShortVideoUploadInfo)localObject17).jdField_c_of_type_JavaLangString = ((String)localObject4);
    ((ShortVideoUploadInfo)localObject17).jdField_h_of_type_JavaLangString = ((String)localObject5);
    ((ShortVideoUploadInfo)localObject17).jdField_j_of_type_JavaLangString = ((String)localObject7);
    ((ShortVideoUploadInfo)localObject17).jdField_b_of_type_Int = m;
    ((ShortVideoUploadInfo)localObject17).jdField_d_of_type_JavaLangString = ((String)localObject3);
    ((ShortVideoUploadInfo)localObject17).jdField_e_of_type_Int = ((int)l1);
    ((ShortVideoUploadInfo)localObject17).jdField_f_of_type_Int = k;
    ((ShortVideoUploadInfo)localObject17).jdField_e_of_type_JavaLangString = ((String)localObject2);
    ((ShortVideoUploadInfo)localObject17).jdField_c_of_type_Int = i;
    ((ShortVideoUploadInfo)localObject17).jdField_d_of_type_Int = j;
    ((ShortVideoUploadInfo)localObject17).jdField_g_of_type_Int = paramShortVideoReq.jdField_a_of_type_Int;
    ((ShortVideoUploadInfo)localObject17).jdField_a_of_type_JavaLangObject = paramObject;
    ((ShortVideoUploadInfo)localObject17).jdField_g_of_type_JavaLangString = ((String)localObject1);
    ((ShortVideoUploadInfo)localObject17).jdField_l_of_type_JavaLangString = ((String)localObject6);
    ((ShortVideoUploadInfo)localObject17).jdField_k_of_type_JavaLangString = ((String)localObject8);
    ((ShortVideoUploadInfo)localObject17).jdField_a_of_type_Int = n;
    ((ShortVideoUploadInfo)localObject17).jdField_c_of_type_Boolean = bool1;
    ((ShortVideoUploadInfo)localObject17).jdField_h_of_type_Int = i1;
    ((ShortVideoUploadInfo)localObject17).jdField_i_of_type_Int = i2;
    ((ShortVideoUploadInfo)localObject17).jdField_h_of_type_Boolean = bool2;
    ((ShortVideoUploadInfo)localObject17).jdField_d_of_type_Boolean = bool3;
    ((ShortVideoUploadInfo)localObject17).jdField_m_of_type_JavaLangString = ((String)localObject9);
    ((ShortVideoUploadInfo)localObject17).jdField_o_of_type_JavaLangString = ((String)localObject10);
    ((ShortVideoUploadInfo)localObject17).p = ((String)localObject11);
    ((ShortVideoUploadInfo)localObject17).jdField_n_of_type_JavaLangString = ((String)localObject12);
    ((ShortVideoUploadInfo)localObject17).jdField_a_of_type_JavaLangString = ((String)localObject13);
    ((ShortVideoUploadInfo)localObject17).jdField_b_of_type_Long = l2;
    ((ShortVideoUploadInfo)localObject17).jdField_j_of_type_Int = i3;
    ((ShortVideoUploadInfo)localObject17).jdField_q_of_type_JavaLangString = ((String)localObject14);
    ((ShortVideoUploadInfo)localObject17).jdField_k_of_type_Int = i4;
    ((ShortVideoUploadInfo)localObject17).jdField_i_of_type_Boolean = bool4;
    ((ShortVideoUploadInfo)localObject17).jdField_s_of_type_JavaLangString = ((String)localObject15);
    ((ShortVideoUploadInfo)localObject17).t = ((String)localObject16);
    Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "createShortVideoUploadInfo", "");
    return localObject17;
  }
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface = paramBaseQQAppInterface;
  }
  
  public void a(UpCallBack.SendResult paramSendResult)
  {
    Object localObject = this.jdField_b_of_type_JavaLangString;
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resut:");
    localStringBuilder.append(paramSendResult);
    Logger.a((String)localObject, str, "updateMsg", localStringBuilder.toString());
    if (paramSendResult != null)
    {
      localObject = (MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      ((MessageForShortVideo)localObject).videoFileSize = ((int)paramSendResult.jdField_a_of_type_Long);
      ((MessageForShortVideo)localObject).uuid = paramSendResult.jdField_c_of_type_JavaLangString;
      ((MessageForShortVideo)localObject).md5 = paramSendResult.jdField_d_of_type_JavaLangString;
      ((MessageForShortVideo)localObject).thumbFileSize = ((int)paramSendResult.jdField_c_of_type_Long);
      ((MessageForShortVideo)localObject).videoAttr = paramSendResult.jdField_c_of_type_Int;
      ((MessageForShortVideo)localObject).videoKandianType = paramSendResult.jdField_d_of_type_Int;
      ((MessageForShortVideo)localObject).serial();
      paramSendResult = (IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IMessageFacade.class);
      if (paramSendResult != null) {
        paramSendResult.updateMsgContentByUniseq(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, ((MessageForShortVideo)localObject).msgData);
      }
    }
  }
  
  public void a(ShortVideoReq paramShortVideoReq)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq = paramShortVideoReq;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.AioShortVideoSendOperator
 * JD-Core Version:    0.7.0.1
 */