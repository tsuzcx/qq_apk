package com.tencent.mobileqq.pic.operator;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.pic.PicUploadInfo.Builder;
import com.tencent.mobileqq.pic.PicUploadInfo.RetryInfo;
import com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgManager;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.GeneralConfigUtils;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

public class AioQzonePicOperator
  extends UploadPicOperator
{
  private boolean a(PhotoSendParams paramPhotoSendParams)
  {
    if ((paramPhotoSendParams == null) || (TextUtils.isEmpty(paramPhotoSendParams.rawMd5)) || (TextUtils.isEmpty(paramPhotoSendParams.thumbPath)) || (!FileUtils.b(paramPhotoSendParams.thumbPath)) || (TextUtils.isEmpty(paramPhotoSendParams.rawDownloadUrl)))
    {
      String str;
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        str = this.b;
        localStringBuilder = new StringBuilder().append("AioQzonePicOperator checkParams:");
        if (paramPhotoSendParams == null) {
          break label92;
        }
      }
      label92:
      for (paramPhotoSendParams = paramPhotoSendParams.toString();; paramPhotoSendParams = "")
      {
        QLog.e(str, 2, paramPhotoSendParams);
        return false;
      }
    }
    return true;
  }
  
  public MessageRecord a(PicUploadInfo paramPicUploadInfo)
  {
    long l = System.currentTimeMillis();
    if ((paramPicUploadInfo != null) && (a(paramPicUploadInfo.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams)))
    {
      MessageForPic localMessageForPic = MessageRecordFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramPicUploadInfo.c, paramPicUploadInfo.d, paramPicUploadInfo.jdField_b_of_type_Int);
      localMessageForPic.busiType = paramPicUploadInfo.jdField_a_of_type_Int;
      localMessageForPic.path = paramPicUploadInfo.jdField_g_of_type_JavaLangString;
      localMessageForPic.size = 0L;
      localMessageForPic.type = 1;
      localMessageForPic.isRead = true;
      localMessageForPic.extraflag = 32772;
      if (paramPicUploadInfo.jdField_g_of_type_Int == 1) {
        localMessageForPic.fileSizeFlag = 1;
      }
      boolean bool;
      label228:
      String str2;
      if (paramPicUploadInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo$RetryInfo != null)
      {
        bool = true;
        if (bool)
        {
          localMessageForPic.msgseq = paramPicUploadInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo$RetryInfo.jdField_a_of_type_Long;
          localMessageForPic.shmsgseq = paramPicUploadInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo$RetryInfo.jdField_b_of_type_Long;
          localMessageForPic.msgUid = paramPicUploadInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo$RetryInfo.c;
        }
        localMessageForPic.localUUID = paramPicUploadInfo.jdField_a_of_type_JavaLangString;
        Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "bindUrlKeyAndUniseq", localMessageForPic.localUUID + "|" + localMessageForPic.uniseq);
        localMessageForPic.md5 = paramPicUploadInfo.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawMd5;
        if (!GeneralConfigUtils.a()) {
          break label508;
        }
        localMessageForPic.bigThumbMsgUrl = paramPicUploadInfo.jdField_h_of_type_JavaLangString;
        localMessageForPic.thumbWidth = paramPicUploadInfo.e;
        localMessageForPic.thumbHeight = paramPicUploadInfo.f;
        localMessageForPic.width = paramPicUploadInfo.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawWidth;
        localMessageForPic.height = paramPicUploadInfo.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawHeight;
        localMessageForPic.extLong = paramPicUploadInfo.jdField_i_of_type_Int;
        localMessageForPic.extStr = paramPicUploadInfo.jdField_i_of_type_JavaLangString;
        localMessageForPic.msgVia = paramPicUploadInfo.n;
        localMessageForPic.sync2Story = paramPicUploadInfo.jdField_g_of_type_Boolean;
        localMessageForPic.isQzonePic = paramPicUploadInfo.jdField_h_of_type_Boolean;
        str2 = MessageConstants.r;
        if (!localMessageForPic.isQzonePic) {
          break label520;
        }
      }
      label520:
      for (String str1 = "1";; str1 = "0")
      {
        localMessageForPic.saveExtInfoToExtStr(str2, str1);
        localMessageForPic.saveExtInfoToExtStr(MessageConstants.s, paramPicUploadInfo.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawDownloadUrl);
        localMessageForPic.saveExtInfoToExtStr(MessageConstants.t, String.valueOf(paramPicUploadInfo.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.fileSize));
        localMessageForPic.imageType = 1000;
        localMessageForPic.serial();
        paramPicUploadInfo.jdField_a_of_type_Long = localMessageForPic.uniseq;
        Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "packmsg", "cost:" + (System.currentTimeMillis() - l));
        a(localMessageForPic);
        localMessageForPic.DSKey = paramPicUploadInfo.jdField_b_of_type_Long;
        Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "packMsg", "retry:" + bool + " info.DLSendKey:" + paramPicUploadInfo.jdField_b_of_type_Long);
        return localMessageForPic;
        bool = false;
        break;
        label508:
        localMessageForPic.thumbMsgUrl = paramPicUploadInfo.jdField_h_of_type_JavaLangString;
        break label228;
      }
    }
    return null;
  }
  
  public PicUploadInfo a(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      Object localObject = paramIntent.getStringExtra("uin");
      String str = paramIntent.getStringExtra("troop_uin");
      int i = paramIntent.getIntExtra("uintype", 1003);
      int j = paramIntent.getIntExtra("PhotoConst.SEND_SIZE_SPEC", 0);
      int k = paramIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", -1);
      int m = paramIntent.getIntExtra("entrance", 0);
      int n = paramIntent.getIntExtra("key_confess_topicid", 0);
      boolean bool = paramIntent.getBooleanExtra("video_sync_to_story", false);
      paramIntent = (PhotoSendParams)paramIntent.getParcelableExtra("PhotoConst.photo_send_qzone_pic_file_params");
      if (!a(paramIntent)) {
        return null;
      }
      PicUploadInfo.Builder localBuilder = new PicUploadInfo.Builder();
      localBuilder.d((String)localObject);
      localBuilder.e(i);
      localBuilder.e(str);
      localBuilder.d(k);
      localBuilder.f(j);
      localBuilder.l(n);
      localBuilder.k(m);
      localBuilder.a(bool);
      localBuilder.f(paramIntent.rawMd5);
      localBuilder.a(paramIntent.fileSize);
      localObject = localBuilder.a();
      ((PicUploadInfo)localObject).jdField_h_of_type_Boolean = true;
      ((PicUploadInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams = paramIntent;
      Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "createPicUploadInfo", "");
      return localObject;
    }
    Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "createPicUploadInfo", "unknow obj");
    return null;
  }
  
  protected void a(MessageForPic paramMessageForPic)
  {
    long l = System.currentTimeMillis();
    URLDrawableHelper.getDrawable(paramMessageForPic, 65537, null, null).downloadImediatly();
    Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "preload thumb", "cost:" + (System.currentTimeMillis() - l));
  }
  
  protected void a(MessageRecord paramMessageRecord)
  {
    ((OrderMediaMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MEDIA_MSG_ORDER_SEND_MANAGER)).a(paramMessageRecord, ((MessageForPic)paramMessageRecord).path);
  }
  
  public void a(PicReq paramPicReq)
  {
    Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "sendPic.start", "");
    if (a(paramPicReq.a))
    {
      b(paramPicReq);
      return;
    }
    a(3, paramPicReq.a.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo);
  }
  
  protected void b(PicReq paramPicReq)
  {
    ThreadManager.post(new AioQzonePicOperator.1(this, paramPicReq.a, paramPicReq), 8, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.AioQzonePicOperator
 * JD-Core Version:    0.7.0.1
 */