package dov.com.tencent.mobileqq.shortvideo;

import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.qphone.base.util.QLog;
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
      localMessageForShortVideo.supportProgressive = paramShortVideoForwardInfo.jdField_a_of_type_Boolean;
      localMessageForShortVideo.fileWidth = paramShortVideoForwardInfo.n;
      localMessageForShortVideo.fileHeight = paramShortVideoForwardInfo.o;
      if (paramShortVideoForwardInfo.jdField_a_of_type_DovComTencentMobileqqShortvideoShortVideoForwardInfo$RetryInfo == null) {
        break label467;
      }
      label284:
      if (i != 0)
      {
        localMessageForShortVideo.msgseq = paramShortVideoForwardInfo.jdField_a_of_type_DovComTencentMobileqqShortvideoShortVideoForwardInfo$RetryInfo.jdField_a_of_type_Long;
        localMessageForShortVideo.shmsgseq = paramShortVideoForwardInfo.jdField_a_of_type_DovComTencentMobileqqShortvideoShortVideoForwardInfo$RetryInfo.b;
        localMessageForShortVideo.msgUid = paramShortVideoForwardInfo.jdField_a_of_type_DovComTencentMobileqqShortvideoShortVideoForwardInfo$RetryInfo.jdField_c_of_type_Long;
      }
      if (localMessageForShortVideo.busiType != 2) {
        break label472;
      }
    }
    label467:
    label472:
    for (localMessageForShortVideo.msg = "[视频对讲]";; localMessageForShortVideo.msg = "[视频]")
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
    int i = 1;
    long l = System.currentTimeMillis();
    MessageForShortVideo localMessageForShortVideo;
    if (paramShortVideoUploadInfo.jdField_d_of_type_Boolean)
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
      localMessageForShortVideo.mediacodecEncode = paramShortVideoUploadInfo.jdField_c_of_type_Boolean;
      if (localMessageForShortVideo.istroop != 0) {
        break label524;
      }
      localMessageForShortVideo.fileType = 6;
      label236:
      if (paramShortVideoUploadInfo.jdField_b_of_type_Int != 1008) {
        break label564;
      }
      localMessageForShortVideo.busiType = 1007;
      label254:
      localMessageForShortVideo.fromChatType = -1;
      localMessageForShortVideo.toChatType = -1;
      localMessageForShortVideo.uiOperatorFlag = 1;
      localMessageForShortVideo.supportProgressive = paramShortVideoUploadInfo.jdField_b_of_type_Boolean;
      localMessageForShortVideo.fileWidth = paramShortVideoUploadInfo.jdField_h_of_type_Int;
      localMessageForShortVideo.fileHeight = paramShortVideoUploadInfo.jdField_i_of_type_Int;
      localMessageForShortVideo.syncToStory = paramShortVideoUploadInfo.jdField_e_of_type_Boolean;
      if (paramShortVideoUploadInfo.jdField_a_of_type_DovComTencentMobileqqShortvideoShortVideoUploadInfo$RetryInfo == null) {
        break label607;
      }
      label315:
      if (i != 0)
      {
        localMessageForShortVideo.msgseq = paramShortVideoUploadInfo.jdField_a_of_type_DovComTencentMobileqqShortvideoShortVideoUploadInfo$RetryInfo.jdField_a_of_type_Long;
        localMessageForShortVideo.shmsgseq = paramShortVideoUploadInfo.jdField_a_of_type_DovComTencentMobileqqShortvideoShortVideoUploadInfo$RetryInfo.b;
        localMessageForShortVideo.msgUid = paramShortVideoUploadInfo.jdField_a_of_type_DovComTencentMobileqqShortvideoShortVideoUploadInfo$RetryInfo.jdField_c_of_type_Long;
      }
      if (localMessageForShortVideo.busiType != 2) {
        break label612;
      }
      localMessageForShortVideo.msg = "[视频对讲]";
      label371:
      if (!paramShortVideoUploadInfo.jdField_g_of_type_Boolean) {
        break label622;
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
      label524:
      if (localMessageForShortVideo.istroop == 3000)
      {
        localMessageForShortVideo.fileType = 17;
        break label236;
      }
      if (localMessageForShortVideo.istroop != 1) {
        break label236;
      }
      localMessageForShortVideo.fileType = 9;
      break label236;
      label564:
      if (2 == paramShortVideoUploadInfo.jdField_a_of_type_Int)
      {
        localMessageForShortVideo.busiType = 1;
        break label254;
      }
      if (3 == paramShortVideoUploadInfo.jdField_a_of_type_Int)
      {
        localMessageForShortVideo.busiType = 2;
        break label254;
      }
      localMessageForShortVideo.busiType = 0;
      break label254;
      label607:
      i = 0;
      break label315;
      label612:
      localMessageForShortVideo.msg = "[视频]";
      break label371;
      label622:
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
  
  public ShortVideoUploadInfo a(Object paramObject, ShortVideoReq paramShortVideoReq)
  {
    if (paramObject == null)
    {
      Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "createShortVideoUploadInfo", "unknow obj");
      return null;
    }
    String str8 = "0";
    String str7 = "0";
    int i2 = 0;
    long l = 0L;
    int i1 = 0;
    int n = 0;
    String str6 = "";
    String str5 = "";
    String str4 = "";
    String str3 = "";
    int m = 0;
    int k = 0;
    String str2 = "";
    String str1 = "";
    boolean bool4 = false;
    int j = 0;
    int i = 0;
    Object localObject2 = "";
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    Object localObject1;
    if ((paramObject instanceof Intent))
    {
      localObject1 = (Intent)paramObject;
      str8 = ((Intent)localObject1).getStringExtra("uin");
      str7 = ((Intent)localObject1).getStringExtra("troop_uin");
      i2 = ((Intent)localObject1).getIntExtra("uintype", 1003);
      l = ((Intent)localObject1).getLongExtra("file_send_size", 0L);
      i1 = ((Intent)localObject1).getIntExtra("file_send_business_type", 0);
      n = ((Intent)localObject1).getIntExtra("file_send_duration", -1);
      str6 = ((Intent)localObject1).getStringExtra("file_send_path");
      str5 = ((Intent)localObject1).getStringExtra("thumbfile_send_path");
      str3 = ((Intent)localObject1).getStringExtra("file_shortvideo_md5");
      m = ((Intent)localObject1).getIntExtra("thumbfile_send_width", 0);
      k = ((Intent)localObject1).getIntExtra("thumbfile_send_height", 0);
      str2 = ((Intent)localObject1).getStringExtra("thumbfile_md5");
      str1 = ((Intent)localObject1).getStringExtra("file_source");
      str4 = ((Intent)localObject1).getStringExtra("file_video_source_dir");
      bool4 = ((Intent)localObject1).getBooleanExtra("support_progressive", false);
      j = ((Intent)localObject1).getIntExtra("file_width", 0);
      i = ((Intent)localObject1).getIntExtra("file_height", 0);
      bool3 = ((Intent)localObject1).getBooleanExtra("video_sync_to_story", false);
      bool2 = ((Intent)localObject1).getBooleanExtra("mediacodec_encode_enable", false);
      bool1 = ((Intent)localObject1).getBooleanExtra("video_send_aio_key_is_qim", false);
      localObject1 = ((Intent)localObject1).getStringExtra("dynamic_text");
    }
    for (;;)
    {
      localObject2 = new ShortVideoUploadInfo();
      ((ShortVideoUploadInfo)localObject2).jdField_c_of_type_JavaLangString = str8;
      ((ShortVideoUploadInfo)localObject2).jdField_h_of_type_JavaLangString = str6;
      ((ShortVideoUploadInfo)localObject2).jdField_i_of_type_JavaLangString = str5;
      ((ShortVideoUploadInfo)localObject2).jdField_b_of_type_Int = i2;
      ((ShortVideoUploadInfo)localObject2).jdField_d_of_type_JavaLangString = str7;
      ((ShortVideoUploadInfo)localObject2).jdField_e_of_type_Int = ((int)l);
      ((ShortVideoUploadInfo)localObject2).jdField_f_of_type_Int = n;
      ((ShortVideoUploadInfo)localObject2).jdField_e_of_type_JavaLangString = str3;
      ((ShortVideoUploadInfo)localObject2).jdField_c_of_type_Int = m;
      ((ShortVideoUploadInfo)localObject2).jdField_d_of_type_Int = k;
      ((ShortVideoUploadInfo)localObject2).jdField_g_of_type_Int = paramShortVideoReq.jdField_a_of_type_Int;
      ((ShortVideoUploadInfo)localObject2).jdField_a_of_type_JavaLangObject = paramObject;
      ((ShortVideoUploadInfo)localObject2).jdField_g_of_type_JavaLangString = str2;
      ((ShortVideoUploadInfo)localObject2).k = str1;
      ((ShortVideoUploadInfo)localObject2).jdField_j_of_type_JavaLangString = str4;
      ((ShortVideoUploadInfo)localObject2).jdField_a_of_type_Int = i1;
      ((ShortVideoUploadInfo)localObject2).jdField_b_of_type_Boolean = bool4;
      ((ShortVideoUploadInfo)localObject2).jdField_h_of_type_Int = j;
      ((ShortVideoUploadInfo)localObject2).jdField_i_of_type_Int = i;
      ((ShortVideoUploadInfo)localObject2).jdField_e_of_type_Boolean = bool3;
      ((ShortVideoUploadInfo)localObject2).jdField_c_of_type_Boolean = bool2;
      ((ShortVideoUploadInfo)localObject2).jdField_g_of_type_Boolean = bool1;
      ((ShortVideoUploadInfo)localObject2).l = ((String)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("AioShortVideoOperator", 2, "ISQIM AioShortVideoOperator#createShortVideoUploadInfo, isQIM = " + ((ShortVideoUploadInfo)localObject2).jdField_g_of_type_Boolean);
      }
      Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "createShortVideoUploadInfo", "");
      return localObject2;
      localObject1 = localObject2;
      if ((paramObject instanceof MessageForShortVideo))
      {
        localObject1 = (MessageForShortVideo)paramObject;
        str8 = ((MessageForShortVideo)localObject1).frienduin;
        str7 = ((MessageForShortVideo)localObject1).frienduin;
        i2 = ((MessageForShortVideo)localObject1).istroop;
        l = ((MessageForShortVideo)localObject1).videoFileSize;
        i1 = paramShortVideoReq.jdField_b_of_type_Int;
        n = ((MessageForShortVideo)localObject1).videoFileTime;
        str6 = ((MessageForShortVideo)localObject1).videoFileName;
        str5 = ShortVideoUtils.a(((MessageForShortVideo)localObject1).thumbMD5, "jpg");
        str3 = ((MessageForShortVideo)localObject1).md5;
        m = ((MessageForShortVideo)localObject1).thumbWidth;
        k = ((MessageForShortVideo)localObject1).thumbHeight;
        str2 = ((MessageForShortVideo)localObject1).thumbMD5;
        str1 = ((MessageForShortVideo)localObject1).fileSource;
        str4 = ((MessageForShortVideo)localObject1).mVideoFileSourceDir;
        bool4 = ((MessageForShortVideo)localObject1).supportProgressive;
        j = ((MessageForShortVideo)localObject1).fileWidth;
        i = ((MessageForShortVideo)localObject1).fileHeight;
        bool3 = ((MessageForShortVideo)localObject1).syncToStory;
        bool2 = ((MessageForShortVideo)localObject1).mediacodecEncode;
        if ("true".equals(((MessageForShortVideo)localObject1).getExtInfoFromExtStr("video_send_aio_key_is_qim")))
        {
          bool1 = true;
          localObject1 = localObject2;
        }
        else
        {
          bool1 = false;
          localObject1 = localObject2;
        }
      }
    }
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
      localMessageForShortVideo.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, localMessageForShortVideo.msgData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.AioShortVideoOperator
 * JD-Core Version:    0.7.0.1
 */