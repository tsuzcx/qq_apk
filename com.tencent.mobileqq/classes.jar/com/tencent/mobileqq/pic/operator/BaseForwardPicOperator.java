package com.tencent.mobileqq.pic.operator;

import android.graphics.BitmapFactory.Options;
import com.tencent.image.GifDrawable;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicDownloadInfo;
import com.tencent.mobileqq.pic.PicFowardInfo;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.pic.PicUploadInfo.RetryInfo;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.PicFowardDbRecordData;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.mobileqq.transfile.TranDbRecord.PicDbRecord;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.transfile.api.impl.TransFileControllerImpl;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakUtils;
import java.io.File;
import java.util.ArrayList;

public abstract class BaseForwardPicOperator
  extends BasePicOperator
{
  public MessageRecord a(PicFowardInfo paramPicFowardInfo)
  {
    if ((paramPicFowardInfo == null) || (!paramPicFowardInfo.jdField_a_of_type_Boolean)) {
      return null;
    }
    long l = System.currentTimeMillis();
    PicUploadInfo localPicUploadInfo = paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo;
    PicFowardDbRecordData localPicFowardDbRecordData = new PicFowardDbRecordData();
    localPicFowardDbRecordData.fowardThumbPath = localPicUploadInfo.h;
    MessageForPic localMessageForPic = MessageRecordFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localPicUploadInfo.c, localPicUploadInfo.d, localPicUploadInfo.b);
    localMessageForPic.path = localPicUploadInfo.g;
    localMessageForPic.type = 1;
    Object localObject = new File(localPicUploadInfo.g);
    if (((File)localObject).exists())
    {
      if (GifDrawable.isGifFile((File)localObject)) {
        localMessageForPic.imageType = 2000;
      }
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      ((BitmapFactory.Options)localObject).inSampleSize = 1;
      SafeBitmapFactory.decodeFile(localPicUploadInfo.g, (BitmapFactory.Options)localObject);
      localMessageForPic.width = ((BitmapFactory.Options)localObject).outWidth;
      localMessageForPic.height = ((BitmapFactory.Options)localObject).outHeight;
      if (RichMediaUtil.isPicLandscape(localPicUploadInfo.g))
      {
        localMessageForPic.width = ((BitmapFactory.Options)localObject).outHeight;
        localMessageForPic.height = ((BitmapFactory.Options)localObject).outWidth;
        if (QLog.isColorLevel()) {
          Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "packForwardMsg", " pic is Landscape,swap w,h; options.outWidth = " + ((BitmapFactory.Options)localObject).outWidth + ",options.outHeight = " + ((BitmapFactory.Options)localObject).outHeight + ",mr.width = " + localMessageForPic.width + ",mr.height = " + localMessageForPic.height);
        }
      }
      localMessageForPic.md5 = localPicUploadInfo.f;
    }
    localMessageForPic.fileSizeFlag = paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.l;
    paramPicFowardInfo = paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo;
    if (paramPicFowardInfo != null)
    {
      if (paramPicFowardInfo.f != null) {
        localMessageForPic.md5 = paramPicFowardInfo.f;
      }
      if (paramPicFowardInfo.jdField_a_of_type_Long != 0L) {
        localPicFowardDbRecordData.fowardOrgId = paramPicFowardInfo.jdField_a_of_type_Long;
      }
      if (paramPicFowardInfo.c != null) {
        localPicFowardDbRecordData.fowardOrgUin = paramPicFowardInfo.c;
      }
      if (paramPicFowardInfo.b != -1) {
        localPicFowardDbRecordData.fowardOrgUinType = paramPicFowardInfo.b;
      }
      if (paramPicFowardInfo.g != null) {
        localPicFowardDbRecordData.fowardOrgUrl = paramPicFowardInfo.g;
      }
    }
    if (localPicUploadInfo.q != -1)
    {
      paramPicFowardInfo = new PicMessageExtraData();
      paramPicFowardInfo.imageBizType = localPicUploadInfo.q;
      localMessageForPic.picExtraData = paramPicFowardInfo;
    }
    localMessageForPic.picExtraFlag = TranDbRecord.PicDbRecord.EXTRA_FLAG_FOWARD_PHOTO;
    localMessageForPic.picExtraObject = localPicFowardDbRecordData;
    boolean bool;
    if (localPicUploadInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo$RetryInfo != null)
    {
      bool = true;
      if (bool)
      {
        localMessageForPic.msgseq = localPicUploadInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo$RetryInfo.jdField_a_of_type_Long;
        localMessageForPic.shmsgseq = localPicUploadInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo$RetryInfo.b;
        localMessageForPic.msgUid = localPicUploadInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo$RetryInfo.c;
      }
      localMessageForPic.localUUID = localPicUploadInfo.jdField_a_of_type_JavaLangString;
      Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "bindUrlKeyAndUniseq", localMessageForPic.localUUID + "|" + localMessageForPic.uniseq);
      localMessageForPic.imageType = PeakUtils.a(localPicUploadInfo.g);
      paramPicFowardInfo = localPicUploadInfo.jdField_a_of_type_JavaUtilArrayList;
      if ((paramPicFowardInfo == null) || (paramPicFowardInfo.isEmpty())) {
        break label766;
      }
      a(localPicUploadInfo, localMessageForPic);
      localMessageForPic.imageType = 1003;
    }
    for (;;)
    {
      localMessageForPic.serial();
      localPicUploadInfo.jdField_a_of_type_Long = localMessageForPic.uniseq;
      paramPicFowardInfo = (ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class);
      if (paramPicFowardInfo != null) {
        paramPicFowardInfo.addProcessor(localMessageForPic.frienduin + localMessageForPic.uniseq, new BaseTransProcessor((TransFileControllerImpl)paramPicFowardInfo));
      }
      a(localMessageForPic);
      Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "packForwardMsg", "cost:" + (System.currentTimeMillis() - l));
      Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "packForwardMsg", "retry:" + bool);
      return localMessageForPic;
      bool = false;
      break;
      label766:
      if (QLog.isColorLevel()) {
        QLog.d("peak_pgjpeg", 2, "Slice infos is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.BaseForwardPicOperator
 * JD-Core Version:    0.7.0.1
 */