package dov.com.tencent.mobileqq.shortvideo;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import tencent.im.msg.im_msg_body.RichText;

public class AioShortVideoOperator
  extends BaseShortVideoOprerator
{
  public AioShortVideoOperator() {}
  
  public AioShortVideoOperator(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public MessageRecord a(ShortVideoForwardInfo paramShortVideoForwardInfo)
  {
    int i = 1;
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
    localMessageForShortVideo.videoFileName = paramShortVideoForwardInfo.k;
    localMessageForShortVideo.videoFileFormat = paramShortVideoForwardInfo.l;
    localMessageForShortVideo.videoFileSize = paramShortVideoForwardInfo.jdField_i_of_type_Int;
    localMessageForShortVideo.videoFileTime = paramShortVideoForwardInfo.jdField_j_of_type_Int;
    localMessageForShortVideo.thumbWidth = paramShortVideoForwardInfo.jdField_g_of_type_Int;
    localMessageForShortVideo.thumbHeight = paramShortVideoForwardInfo.jdField_h_of_type_Int;
    localMessageForShortVideo.videoFileStatus = 999;
    localMessageForShortVideo.videoFileProgress = 0;
    if (paramShortVideoForwardInfo.jdField_b_of_type_Int == 0)
    {
      localMessageForShortVideo.fileType = 6;
      localMessageForShortVideo.thumbMD5 = paramShortVideoForwardInfo.jdField_g_of_type_JavaLangString;
      if (paramShortVideoForwardInfo.jdField_j_of_type_JavaLangString == null) {
        paramShortVideoForwardInfo.jdField_j_of_type_JavaLangString = "";
      }
      localMessageForShortVideo.fileSource = paramShortVideoForwardInfo.jdField_j_of_type_JavaLangString;
      localMessageForShortVideo.lastModified = 0L;
      localMessageForShortVideo.thumbFileSize = paramShortVideoForwardInfo.m;
      localMessageForShortVideo.busiType = paramShortVideoForwardInfo.jdField_f_of_type_Int;
      localMessageForShortVideo.fromChatType = paramShortVideoForwardInfo.jdField_c_of_type_Int;
      localMessageForShortVideo.toChatType = paramShortVideoForwardInfo.jdField_d_of_type_Int;
      localMessageForShortVideo.uiOperatorFlag = 2;
      localMessageForShortVideo.supportProgressive = paramShortVideoForwardInfo.jdField_b_of_type_Boolean;
      localMessageForShortVideo.fileWidth = paramShortVideoForwardInfo.n;
      localMessageForShortVideo.fileHeight = paramShortVideoForwardInfo.o;
      if (paramShortVideoForwardInfo.jdField_a_of_type_DovComTencentMobileqqShortvideoShortVideoForwardInfo$RetryInfo == null) {
        break label468;
      }
      label284:
      if (i != 0)
      {
        localMessageForShortVideo.msgseq = paramShortVideoForwardInfo.jdField_a_of_type_DovComTencentMobileqqShortvideoShortVideoForwardInfo$RetryInfo.jdField_a_of_type_Long;
        localMessageForShortVideo.shmsgseq = paramShortVideoForwardInfo.jdField_a_of_type_DovComTencentMobileqqShortvideoShortVideoForwardInfo$RetryInfo.b;
        localMessageForShortVideo.msgUid = paramShortVideoForwardInfo.jdField_a_of_type_DovComTencentMobileqqShortvideoShortVideoForwardInfo$RetryInfo.jdField_c_of_type_Long;
      }
      if (localMessageForShortVideo.busiType != 2) {
        break label473;
      }
    }
    label468:
    label473:
    for (localMessageForShortVideo.msg = ShortVideoConstants.MESSAGE_FOR_SHORT_VIDEO_PTV;; localMessageForShortVideo.msg = ShortVideoConstants.MESSAGEFORSHORTVIDEO_MSG)
    {
      localMessageForShortVideo.serial();
      paramShortVideoForwardInfo.jdField_a_of_type_Long = localMessageForShortVideo.uniseq;
      Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "packForwardMsg", "cost:" + (System.currentTimeMillis() - l));
      Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "packForwardMsg", "mr: " + localMessageForShortVideo.toString());
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
    }
  }
  
  public MessageRecord a(ShortVideoUploadInfo paramShortVideoUploadInfo)
  {
    long l = System.currentTimeMillis();
    MessageForShortVideo localMessageForShortVideo;
    label234:
    label252:
    String str1;
    label324:
    int i;
    if (paramShortVideoUploadInfo.jdField_e_of_type_Boolean)
    {
      localMessageForShortVideo = MessageRecordFactory.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramShortVideoUploadInfo.jdField_c_of_type_JavaLangString, paramShortVideoUploadInfo.jdField_d_of_type_JavaLangString, paramShortVideoUploadInfo.jdField_b_of_type_Int);
      localMessageForShortVideo.subBusiType = 1;
      localMessageForShortVideo.videoFileName = paramShortVideoUploadInfo.jdField_h_of_type_JavaLangString;
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
      localMessageForShortVideo.mThumbFilePath = paramShortVideoUploadInfo.jdField_i_of_type_JavaLangString;
      localMessageForShortVideo.mVideoFileSourceDir = paramShortVideoUploadInfo.jdField_j_of_type_JavaLangString;
      localMessageForShortVideo.videoFileStatus = 999;
      localMessageForShortVideo.videoFileProgress = 0;
      localMessageForShortVideo.extraflag = 32772;
      localMessageForShortVideo.thumbMD5 = paramShortVideoUploadInfo.jdField_g_of_type_JavaLangString;
      if (paramShortVideoUploadInfo.k == null) {
        paramShortVideoUploadInfo.k = "";
      }
      localMessageForShortVideo.fileSource = paramShortVideoUploadInfo.k;
      localMessageForShortVideo.lastModified = 0L;
      localMessageForShortVideo.mediacodecEncode = paramShortVideoUploadInfo.jdField_d_of_type_Boolean;
      if (localMessageForShortVideo.istroop != 0) {
        break label552;
      }
      localMessageForShortVideo.fileType = 6;
      if (paramShortVideoUploadInfo.jdField_b_of_type_Int != 1008) {
        break label592;
      }
      localMessageForShortVideo.busiType = 1007;
      localMessageForShortVideo.fromChatType = -1;
      localMessageForShortVideo.toChatType = -1;
      localMessageForShortVideo.uiOperatorFlag = 1;
      localMessageForShortVideo.supportProgressive = paramShortVideoUploadInfo.jdField_c_of_type_Boolean;
      localMessageForShortVideo.fileWidth = paramShortVideoUploadInfo.jdField_h_of_type_Int;
      localMessageForShortVideo.fileHeight = paramShortVideoUploadInfo.jdField_i_of_type_Int;
      localMessageForShortVideo.syncToStory = paramShortVideoUploadInfo.jdField_f_of_type_Boolean;
      String str2 = MessageConstants.n;
      if (!localMessageForShortVideo.syncToStory) {
        break label635;
      }
      str1 = "1";
      localMessageForShortVideo.saveExtInfoToExtStr(str2, str1);
      if (paramShortVideoUploadInfo.jdField_a_of_type_DovComTencentMobileqqShortvideoShortVideoUploadInfo$RetryInfo == null) {
        break label643;
      }
      i = 1;
      label342:
      if (i != 0)
      {
        localMessageForShortVideo.msgseq = paramShortVideoUploadInfo.jdField_a_of_type_DovComTencentMobileqqShortvideoShortVideoUploadInfo$RetryInfo.jdField_a_of_type_Long;
        localMessageForShortVideo.shmsgseq = paramShortVideoUploadInfo.jdField_a_of_type_DovComTencentMobileqqShortvideoShortVideoUploadInfo$RetryInfo.b;
        localMessageForShortVideo.msgUid = paramShortVideoUploadInfo.jdField_a_of_type_DovComTencentMobileqqShortvideoShortVideoUploadInfo$RetryInfo.jdField_c_of_type_Long;
      }
      if (localMessageForShortVideo.busiType != 2) {
        break label648;
      }
      localMessageForShortVideo.msg = ShortVideoConstants.MESSAGE_FOR_SHORT_VIDEO_PTV;
      label399:
      if (!paramShortVideoUploadInfo.jdField_h_of_type_Boolean) {
        break label659;
      }
      localMessageForShortVideo.saveExtInfoToExtStr("video_send_aio_key_is_qim", "true");
    }
    for (;;)
    {
      localMessageForShortVideo.serial();
      paramShortVideoUploadInfo.jdField_a_of_type_Long = localMessageForShortVideo.uniseq;
      Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "packmsg", "cost:" + (System.currentTimeMillis() - l));
      Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "packMsg", "mr: " + localMessageForShortVideo.toLogString() + "-" + localMessageForShortVideo.toString());
      return localMessageForShortVideo;
      localMessageForShortVideo = MessageRecordFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramShortVideoUploadInfo.jdField_c_of_type_JavaLangString, paramShortVideoUploadInfo.jdField_d_of_type_JavaLangString, paramShortVideoUploadInfo.jdField_b_of_type_Int);
      localMessageForShortVideo.subBusiType = 0;
      break;
      label552:
      if (localMessageForShortVideo.istroop == 3000)
      {
        localMessageForShortVideo.fileType = 17;
        break label234;
      }
      if (localMessageForShortVideo.istroop != 1) {
        break label234;
      }
      localMessageForShortVideo.fileType = 9;
      break label234;
      label592:
      if (2 == paramShortVideoUploadInfo.jdField_a_of_type_Int)
      {
        localMessageForShortVideo.busiType = 1;
        break label252;
      }
      if (3 == paramShortVideoUploadInfo.jdField_a_of_type_Int)
      {
        localMessageForShortVideo.busiType = 2;
        break label252;
      }
      localMessageForShortVideo.busiType = 0;
      break label252;
      label635:
      str1 = "0";
      break label324;
      label643:
      i = 0;
      break label342;
      label648:
      localMessageForShortVideo.msg = ShortVideoConstants.MESSAGEFORSHORTVIDEO_MSG;
      break label399;
      label659:
      localMessageForShortVideo.saveExtInfoToExtStr("video_send_aio_key_is_qim", "false");
    }
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "attachRichText2Msg", "");
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForRichText)) {
      ((MessageForRichText)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).richText = paramRichText;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  }
  
  public void a(UpCallBack.SendResult paramSendResult)
  {
    Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "updateMsg", "resut:" + paramSendResult);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.AioShortVideoOperator
 * JD-Core Version:    0.7.0.1
 */