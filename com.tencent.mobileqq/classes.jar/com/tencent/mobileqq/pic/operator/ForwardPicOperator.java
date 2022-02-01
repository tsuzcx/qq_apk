package com.tencent.mobileqq.pic.operator;

import android.content.Intent;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.forward.ForwardOrderManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.DownCallBack.DownResult;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicDownloadInfo.Builder;
import com.tencent.mobileqq.pic.PicFowardInfo;
import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicResult;
import com.tencent.mobileqq.pic.PicStatisticsManager;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.pic.PicUploadInfo.Builder;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.TranDbRecord.PicDbRecord;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakUtils;
import java.io.File;
import java.util.Map;
import tencent.im.msg.im_msg_body.RichText;

public class ForwardPicOperator
  extends BaseForwardPicOperator
  implements DownCallBack, UpCallBack, IPicInfoBuilder.ForwardInfoBuilder
{
  private void a(PicReq paramPicReq, long paramLong)
  {
    long l;
    Map localMap;
    if (paramPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)
    {
      l = paramPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uniseq;
      Integer localInteger2 = Integer.valueOf(-1);
      if (paramPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic == null) {
        break label108;
      }
      localMap = paramPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.forwardId;
      localInteger1 = localInteger2;
      if (localMap != null)
      {
        localInteger1 = localInteger2;
        if (localMap.size() <= 0) {}
      }
    }
    label108:
    for (Integer localInteger1 = (Integer)localMap.remove(paramPicReq);; localInteger1 = Integer.valueOf(paramPicReq.c))
    {
      if ((localInteger1 != null) && (localInteger1.intValue() > 0)) {
        ForwardOrderManager.a().a(paramLong, l, localInteger1.intValue());
      }
      return;
      l = 0L;
      break;
    }
  }
  
  private boolean a(PicFowardInfo paramPicFowardInfo)
  {
    if (paramPicFowardInfo != null)
    {
      Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "checkFowardPicInfo", "info:" + paramPicFowardInfo);
      return paramPicFowardInfo.a();
    }
    Logger.b(this.b, this.jdField_a_of_type_JavaLangString, "checkFowardPicInfo", "info == null");
    return false;
  }
  
  private void b(PicReq paramPicReq)
  {
    ThreadManager.post(new ForwardPicOperator.1(this, paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo, paramPicReq), 8, null, true);
  }
  
  private void c(PicReq paramPicReq)
  {
    ThreadManager.post(new ForwardPicOperator.2(this, paramPicReq), 8, null, true);
  }
  
  private void d(PicReq paramPicReq)
  {
    paramPicReq = a(paramPicReq);
    if ((paramPicReq instanceof DownloadPicOperator))
    {
      paramPicReq = (DownloadPicOperator)paramPicReq;
      paramPicReq.jdField_a_of_type_ComTencentMobileqqPicDownCallBack = this;
      paramPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      paramPicReq.a();
    }
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "attachRichText2Msg", "");
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForRichText))) {
      ((MessageForRichText)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).richText = paramRichText;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  }
  
  public PicFowardInfo a(Intent paramIntent)
  {
    if ((paramIntent != null) && ((paramIntent instanceof Intent)))
    {
      Object localObject1 = paramIntent.getStringExtra("forward_filepath");
      Object localObject2 = paramIntent.getStringExtra("FORWARD_URL_KEY");
      int i = paramIntent.getIntExtra("FORWARD_UIN_TYPE", -1);
      String str5 = paramIntent.getStringExtra("SENDER_TROOP_UIN");
      String str6 = paramIntent.getStringExtra("FORWARD_PEER_UIN");
      String str1 = paramIntent.getStringExtra("FORWARD_SELF_UIN");
      Object localObject3 = paramIntent.getStringExtra("forward_urldrawable_thumb_url");
      String str2 = paramIntent.getStringExtra("forward_download_image_org_uin");
      int j = paramIntent.getIntExtra("forward_download_image_org_uin_type", -1);
      String str3 = paramIntent.getStringExtra("forward_download_image_server_path");
      long l1 = paramIntent.getLongExtra("forward_download_image_item_id", 0L);
      int k = paramIntent.getIntExtra("FORWARD_PHOTO_FILE_SIZE_FLAG", 0);
      String str4 = paramIntent.getStringExtra("forward_photo_md5");
      int m = paramIntent.getIntExtra("forward_photo_isSend", -1);
      long l2 = paramIntent.getLongExtra("forward_photo_group_fileid", 0L);
      long l3 = paramIntent.getLongExtra("forward_image_width", 0L);
      long l4 = paramIntent.getLongExtra("forward_image_height", 0L);
      long l5 = paramIntent.getLongExtra("forward_file_size", 0L);
      int n = paramIntent.getIntExtra("forward_image_type", 0);
      int i1 = paramIntent.getIntExtra("forward_photo_imagebiz_type", -1);
      paramIntent = new PicFowardInfo();
      PicUploadInfo.Builder localBuilder = new PicUploadInfo.Builder();
      localBuilder.d(1009);
      localBuilder.a((String)localObject1);
      localBuilder.c(str1);
      localBuilder.c(TranDbRecord.PicDbRecord.EXTRA_FLAG_FOWARD_PHOTO);
      localBuilder.g((int)l3);
      localBuilder.h((int)l4);
      Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo(Intent obj)", "image_width = " + l3 + ",image_height = " + l4);
      localBuilder.a((int)l5);
      localBuilder.i(k);
      localBuilder.j(n);
      localObject3 = AbsDownloader.getFile((String)localObject3);
      if (localObject3 != null) {
        localBuilder.b(((File)localObject3).getAbsolutePath());
      }
      localBuilder.e(i);
      localBuilder.e(str5);
      localBuilder.d(str6);
      localBuilder.f(str4);
      localBuilder.b(l1);
      localBuilder.m(i1);
      paramIntent.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo = localBuilder.a();
      paramIntent.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangString = ((String)localObject2);
      if (k == 1) {
        paramIntent.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_e_of_type_JavaLangString = "chatraw";
      }
      for (;;)
      {
        localObject2 = paramIntent.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo;
        if (PeakUtils.a((String)localObject1)) {
          LogTag.a();
        }
        try
        {
          ((PicUploadInfo)localObject2).jdField_a_of_type_JavaUtilArrayList = PeakUtils.a((String)localObject1);
          LogTag.a("peak_pgjpeg", "PeakUtils.getSliceInfos(" + (String)localObject1 + ")");
          if (!FileUtils.b((String)localObject1))
          {
            localObject1 = new PicDownloadInfo.Builder();
            ((PicDownloadInfo.Builder)localObject1).a(1009);
            ((PicDownloadInfo.Builder)localObject1).a(str1);
            ((PicDownloadInfo.Builder)localObject1).b(str2);
            ((PicDownloadInfo.Builder)localObject1).b(j);
            ((PicDownloadInfo.Builder)localObject1).c(str3);
            ((PicDownloadInfo.Builder)localObject1).a(l1);
            ((PicDownloadInfo.Builder)localObject1).d(str4);
            ((PicDownloadInfo.Builder)localObject1).c(m);
            paramIntent.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo = ((PicDownloadInfo.Builder)localObject1).a();
            paramIntent.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_e_of_type_JavaLangString = "chatimg";
            paramIntent.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_e_of_type_Int = k;
            paramIntent.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_b_of_type_Long = l2;
          }
          Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo", "");
          return paramIntent;
          paramIntent.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_e_of_type_JavaLangString = "chatimg";
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("peak_pgjpeg", 2, "OutOfMemoryError occurred in PeakUtils.getSliceInfos， " + (String)localObject1 + "'s size is " + FileUtils.a((String)localObject1));
            }
          }
        }
      }
    }
    Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo", "unknow obj");
    return null;
  }
  
  public void a()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqPicPicReq);
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(DownCallBack.DownResult paramDownResult)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPicPicReq != null) && (this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_Int == 3))
    {
      if (paramDownResult.jdField_a_of_type_Int == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.g = paramDownResult.b;
        Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "onDownload", "dowanload pic success,is to forward the pic");
        c(this.jdField_a_of_type_ComTencentMobileqqPicPicReq);
      }
    }
    else {
      return;
    }
    a(4, this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo);
  }
  
  public void a(PicReq paramPicReq)
  {
    PicFowardInfo localPicFowardInfo = paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo;
    if (!a(localPicFowardInfo))
    {
      a(4, localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo);
      return;
    }
    if (FileUtils.b(localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.g))
    {
      localPicFowardInfo.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a(localPicFowardInfo);
      c(paramPicReq);
      return;
    }
    if (localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.b())
    {
      File localFile = localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.a();
      if (localFile != null) {
        localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.g = localFile.toString();
      }
      localPicFowardInfo.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a(localPicFowardInfo);
      c(paramPicReq);
      return;
    }
    localPicFowardInfo.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a(localPicFowardInfo);
    if ((localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.f == null) || (localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.c == 0L) || (localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.j == 0) || (localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.k == 0))
    {
      localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_a_of_type_Int = 3;
      localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_e_of_type_JavaLangString = "chatimg";
      if (localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.l == 1) {}
      for (int i = 7;; i = 6)
      {
        paramPicReq = PicBusiManager.a(i, 3);
        paramPicReq.a((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo);
        d(paramPicReq);
        return;
      }
    }
    b(paramPicReq);
  }
  
  public void a(UpCallBack.SendResult paramSendResult)
  {
    if (paramSendResult != null)
    {
      Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "updateMsg", "resut:" + paramSendResult);
      MessageForPic localMessageForPic = (MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      localMessageForPic.size = paramSendResult.jdField_a_of_type_Long;
      localMessageForPic.uuid = paramSendResult.c;
      localMessageForPic.groupFileID = paramSendResult.jdField_b_of_type_Long;
      localMessageForPic.md5 = paramSendResult.d;
      localMessageForPic.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, localMessageForPic.msgData);
    }
  }
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    if (paramSendResult == null) {
      a(3, null);
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqPicPicReq == null) || (this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_Int != 3)) {
      return;
    }
    if (paramSendResult.jdField_a_of_type_Int == 0)
    {
      a(paramSendResult);
      localObject = (PicStatisticsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PICTURE_STATISTICS_MANAGER);
      if (localObject != null) {
        ((PicStatisticsManager)localObject).a(13058, paramSendResult.jdField_a_of_type_Long);
      }
      localObject = new PicResult();
      ((PicResult)localObject).jdField_a_of_type_Int = 0;
      ((PicResult)localObject).jdField_a_of_type_JavaLangObject = paramSendResult;
      a(4, (PicResult)localObject);
      return;
    }
    if (paramSendResult.jdField_b_of_type_Int == 9333)
    {
      this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_a_of_type_Int = 3;
      this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_e_of_type_JavaLangString = "chatimg";
      if (this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.l == 1) {}
      for (int i = 7;; i = 6)
      {
        Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "onSend", "fastForward md5 missed,is to Download the pic");
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, false);
        paramSendResult = PicBusiManager.a(i, 3);
        this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a(this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo);
        paramSendResult.a((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo);
        d(paramSendResult);
        return;
      }
    }
    Object localObject = new PicInfoInterface.ErrInfo();
    ((PicInfoInterface.ErrInfo)localObject).b = paramSendResult.jdField_a_of_type_JavaLangString;
    ((PicInfoInterface.ErrInfo)localObject).jdField_a_of_type_JavaLangString = String.valueOf(paramSendResult.jdField_b_of_type_Int);
    a(4, (PicInfoInterface.ErrInfo)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.ForwardPicOperator
 * JD-Core Version:    0.7.0.1
 */