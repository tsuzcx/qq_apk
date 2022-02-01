package com.tencent.mobileqq.pic.operator;

import android.graphics.BitmapFactory.Options;
import com.tencent.common.app.AppInterface;
import com.tencent.image.GifDrawable;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.PicBusUtil;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.msg.api.IMessageRecordFactory;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicDownloadInfo;
import com.tencent.mobileqq.pic.PicFowardInfo;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.pic.PicUploadInfo.RetryInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.PicFowardDbRecordData;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

public abstract class BaseForwardPicOperator
  extends BasePicOperator
{
  public MessageRecord a(PicFowardInfo paramPicFowardInfo)
  {
    if ((paramPicFowardInfo != null) && (paramPicFowardInfo.jdField_a_of_type_Boolean))
    {
      long l = System.currentTimeMillis();
      Object localObject1 = paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo;
      Object localObject2 = new PicFowardDbRecordData();
      ((PicFowardDbRecordData)localObject2).fowardThumbPath = ((PicUploadInfo)localObject1).h;
      MessageForPic localMessageForPic = (MessageForPic)((IMessageRecordFactory)QRoute.api(IMessageRecordFactory.class)).createSendMSg_Pic(this.jdField_a_of_type_ComTencentCommonAppAppInterface, ((PicUploadInfo)localObject1).c, ((PicUploadInfo)localObject1).d, ((PicUploadInfo)localObject1).b);
      localMessageForPic.path = ((PicUploadInfo)localObject1).g;
      boolean bool = true;
      localMessageForPic.type = 1;
      Object localObject3 = new File(((PicUploadInfo)localObject1).g);
      if (((File)localObject3).exists())
      {
        if (GifDrawable.isGifFile((File)localObject3)) {
          localMessageForPic.imageType = 2000;
        }
        localObject3 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject3).inJustDecodeBounds = true;
        ((BitmapFactory.Options)localObject3).inSampleSize = 1;
        SafeBitmapFactory.decodeFile(((PicUploadInfo)localObject1).g, (BitmapFactory.Options)localObject3);
        localMessageForPic.width = ((BitmapFactory.Options)localObject3).outWidth;
        localMessageForPic.height = ((BitmapFactory.Options)localObject3).outHeight;
        if (RichMediaUtil.isPicLandscape(((PicUploadInfo)localObject1).g))
        {
          localMessageForPic.width = ((BitmapFactory.Options)localObject3).outHeight;
          localMessageForPic.height = ((BitmapFactory.Options)localObject3).outWidth;
          if (QLog.isColorLevel())
          {
            String str1 = this.b;
            String str2 = this.jdField_a_of_type_JavaLangString;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(" pic is Landscape,swap w,h; options.outWidth = ");
            localStringBuilder.append(((BitmapFactory.Options)localObject3).outWidth);
            localStringBuilder.append(",options.outHeight = ");
            localStringBuilder.append(((BitmapFactory.Options)localObject3).outHeight);
            localStringBuilder.append(",mr.width = ");
            localStringBuilder.append(localMessageForPic.width);
            localStringBuilder.append(",mr.height = ");
            localStringBuilder.append(localMessageForPic.height);
            Logger.a(str1, str2, "packForwardMsg", localStringBuilder.toString());
          }
        }
        localMessageForPic.md5 = ((PicUploadInfo)localObject1).f;
      }
      localMessageForPic.fileSizeFlag = paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.l;
      paramPicFowardInfo = paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo;
      if (paramPicFowardInfo != null)
      {
        if (paramPicFowardInfo.f != null) {
          localMessageForPic.md5 = paramPicFowardInfo.f;
        }
        if (paramPicFowardInfo.jdField_a_of_type_Long != 0L) {
          ((PicFowardDbRecordData)localObject2).fowardOrgId = paramPicFowardInfo.jdField_a_of_type_Long;
        }
        if (paramPicFowardInfo.c != null) {
          ((PicFowardDbRecordData)localObject2).fowardOrgUin = paramPicFowardInfo.c;
        }
        if (paramPicFowardInfo.b != -1) {
          ((PicFowardDbRecordData)localObject2).fowardOrgUinType = paramPicFowardInfo.b;
        }
        if (paramPicFowardInfo.g != null) {
          ((PicFowardDbRecordData)localObject2).fowardOrgUrl = paramPicFowardInfo.g;
        }
      }
      if (((PicUploadInfo)localObject1).q != -1)
      {
        paramPicFowardInfo = new PicMessageExtraData();
        paramPicFowardInfo.imageBizType = ((PicUploadInfo)localObject1).q;
        localMessageForPic.picExtraData = paramPicFowardInfo;
      }
      localMessageForPic.picExtraFlag = 10;
      localMessageForPic.picExtraObject = localObject2;
      if (((PicUploadInfo)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo$RetryInfo == null) {
        bool = false;
      }
      if (bool)
      {
        localMessageForPic.msgseq = ((PicUploadInfo)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo$RetryInfo.jdField_a_of_type_Long;
        localMessageForPic.shmsgseq = ((PicUploadInfo)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo$RetryInfo.b;
        localMessageForPic.msgUid = ((PicUploadInfo)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo$RetryInfo.c;
      }
      localMessageForPic.localUUID = ((PicUploadInfo)localObject1).jdField_a_of_type_JavaLangString;
      paramPicFowardInfo = this.b;
      localObject2 = this.jdField_a_of_type_JavaLangString;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(localMessageForPic.localUUID);
      ((StringBuilder)localObject3).append("|");
      ((StringBuilder)localObject3).append(localMessageForPic.uniseq);
      Logger.a(paramPicFowardInfo, (String)localObject2, "bindUrlKeyAndUniseq", ((StringBuilder)localObject3).toString());
      localMessageForPic.imageType = PicBusUtil.a(((PicUploadInfo)localObject1).g);
      paramPicFowardInfo = ((PicUploadInfo)localObject1).jdField_a_of_type_JavaUtilArrayList;
      if ((paramPicFowardInfo != null) && (!paramPicFowardInfo.isEmpty()))
      {
        b((PicUploadInfo)localObject1, localMessageForPic);
        localMessageForPic.imageType = 1003;
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("peak_pgjpeg", 2, "Slice infos is null");
      }
      localMessageForPic.serial();
      ((PicUploadInfo)localObject1).jdField_a_of_type_Long = localMessageForPic.uniseq;
      paramPicFowardInfo = (ITransFileController)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITransFileController.class, "");
      if (paramPicFowardInfo != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(localMessageForPic.frienduin);
        ((StringBuilder)localObject1).append(localMessageForPic.uniseq);
        paramPicFowardInfo.addProcessor(((StringBuilder)localObject1).toString(), new BaseTransProcessor((BaseTransFileController)paramPicFowardInfo));
      }
      a(localMessageForPic);
      paramPicFowardInfo = this.b;
      localObject1 = this.jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("cost:");
      ((StringBuilder)localObject2).append(System.currentTimeMillis() - l);
      Logger.a(paramPicFowardInfo, (String)localObject1, "packForwardMsg", ((StringBuilder)localObject2).toString());
      paramPicFowardInfo = this.b;
      localObject1 = this.jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("retry:");
      ((StringBuilder)localObject2).append(bool);
      Logger.a(paramPicFowardInfo, (String)localObject1, "packForwardMsg", ((StringBuilder)localObject2).toString());
      return localMessageForPic;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.BaseForwardPicOperator
 * JD-Core Version:    0.7.0.1
 */