package com.tencent.mobileqq.pic.operator;

import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.PicBusUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IForwardOrderManager;
import com.tencent.mobileqq.msg.api.IMessageFacade;
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
import com.tencent.mobileqq.pic.api.IPicPreDownload;
import com.tencent.mobileqq.pic.api.impl.PicPreDownloadImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.qphone.base.util.QLog;
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
    if (paramPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) {
      l = paramPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uniseq;
    } else {
      l = 0L;
    }
    Integer localInteger2 = Integer.valueOf(-1);
    Integer localInteger1;
    if (paramPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)
    {
      Map localMap = paramPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.forwardId;
      localInteger1 = localInteger2;
      if (localMap != null)
      {
        localInteger1 = localInteger2;
        if (localMap.size() > 0) {
          localInteger1 = (Integer)localMap.remove(paramPicReq);
        }
      }
    }
    else
    {
      localInteger1 = Integer.valueOf(paramPicReq.c);
    }
    if ((localInteger1 != null) && (localInteger1.intValue() > 0)) {
      ((IForwardOrderManager)QRoute.api(IForwardOrderManager.class)).mapUniSeqId(paramLong, l, localInteger1.intValue());
    }
  }
  
  private boolean a(PicFowardInfo paramPicFowardInfo)
  {
    if (paramPicFowardInfo != null)
    {
      String str1 = this.b;
      String str2 = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("info:");
      localStringBuilder.append(paramPicFowardInfo);
      Logger.a(str1, str2, "checkFowardPicInfo", localStringBuilder.toString());
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
    String str1;
    Object localObject1;
    String str2;
    String str3;
    int j;
    String str4;
    long l1;
    int k;
    String str5;
    int m;
    long l2;
    PicFowardInfo localPicFowardInfo;
    if ((paramIntent != null) && ((paramIntent instanceof Intent)))
    {
      str1 = paramIntent.getStringExtra("forward_filepath");
      localObject1 = paramIntent.getStringExtra("FORWARD_URL_KEY");
      int i = paramIntent.getIntExtra("FORWARD_UIN_TYPE", -1);
      String str6 = paramIntent.getStringExtra("SENDER_TROOP_UIN");
      String str7 = paramIntent.getStringExtra("FORWARD_PEER_UIN");
      str2 = paramIntent.getStringExtra("FORWARD_SELF_UIN");
      Object localObject2 = paramIntent.getStringExtra("forward_urldrawable_thumb_url");
      str3 = paramIntent.getStringExtra("forward_download_image_org_uin");
      j = paramIntent.getIntExtra("forward_download_image_org_uin_type", -1);
      str4 = paramIntent.getStringExtra("forward_download_image_server_path");
      l1 = paramIntent.getLongExtra("forward_download_image_item_id", 0L);
      k = paramIntent.getIntExtra("FORWARD_PHOTO_FILE_SIZE_FLAG", 0);
      str5 = paramIntent.getStringExtra("forward_photo_md5");
      m = paramIntent.getIntExtra("forward_photo_isSend", -1);
      l2 = paramIntent.getLongExtra("forward_photo_group_fileid", 0L);
      long l3 = paramIntent.getLongExtra("forward_image_width", 0L);
      long l4 = paramIntent.getLongExtra("forward_image_height", 0L);
      long l5 = paramIntent.getLongExtra("forward_file_size", 0L);
      int n = paramIntent.getIntExtra("forward_image_type", 0);
      int i1 = paramIntent.getIntExtra("forward_photo_imagebiz_type", -1);
      localPicFowardInfo = new PicFowardInfo();
      paramIntent = new PicUploadInfo.Builder();
      paramIntent.d(1009);
      paramIntent.a(str1);
      paramIntent.c(str2);
      paramIntent.c(10);
      paramIntent.g((int)l3);
      paramIntent.h((int)l4);
      String str8 = this.b;
      String str9 = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("image_width = ");
      localStringBuilder.append(l3);
      localStringBuilder.append(",image_height = ");
      localStringBuilder.append(l4);
      Logger.a(str8, str9, "createForwardPicInfo(Intent obj)", localStringBuilder.toString());
      paramIntent.a((int)l5);
      paramIntent.i(k);
      paramIntent.j(n);
      localObject2 = AbsDownloader.getFile((String)localObject2);
      if (localObject2 != null) {
        paramIntent.b(((File)localObject2).getAbsolutePath());
      }
      paramIntent.e(i);
      paramIntent.e(str6);
      paramIntent.d(str7);
      paramIntent.f(str5);
      paramIntent.b(l1);
      paramIntent.m(i1);
      localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo = paramIntent.a();
      localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangString = ((String)localObject1);
      if (k == 1) {
        localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_e_of_type_JavaLangString = "chatraw";
      } else {
        localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_e_of_type_JavaLangString = "chatimg";
      }
      paramIntent = localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo;
      if (PicBusUtil.a(str1)) {
        LogTag.a();
      }
    }
    try
    {
      paramIntent.jdField_a_of_type_JavaUtilArrayList = PicBusUtil.a(str1);
    }
    catch (OutOfMemoryError paramIntent)
    {
      label458:
      break label458;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("OutOfMemoryError occurred in PeakUtils.getSliceInfos， ");
      paramIntent = str1;
      ((StringBuilder)localObject1).append(paramIntent);
      ((StringBuilder)localObject1).append("'s size is ");
      ((StringBuilder)localObject1).append(FileUtils.getFileSizes(paramIntent));
      QLog.w("peak_pgjpeg", 2, ((StringBuilder)localObject1).toString());
    }
    paramIntent = new StringBuilder();
    paramIntent.append("PeakUtils.getSliceInfos(");
    paramIntent.append(str1);
    paramIntent.append(")");
    LogTag.a("peak_pgjpeg", paramIntent.toString());
    if (!FileUtils.fileExistsAndNotEmpty(str1))
    {
      paramIntent = new PicDownloadInfo.Builder();
      paramIntent.a(1009);
      paramIntent.a(str2);
      paramIntent.b(str3);
      paramIntent.b(j);
      paramIntent.c(str4);
      paramIntent.a(l1);
      paramIntent.d(str5);
      paramIntent.c(m);
      localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo = paramIntent.a();
      localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_e_of_type_JavaLangString = "chatimg";
      localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_e_of_type_Int = k;
      localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_b_of_type_Long = l2;
    }
    Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo", "");
    return localPicFowardInfo;
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
        return;
      }
      a(4, this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo);
    }
  }
  
  public void a(PicReq paramPicReq)
  {
    PicFowardInfo localPicFowardInfo = paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo;
    if (!a(localPicFowardInfo))
    {
      a(4, localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo);
      return;
    }
    if (FileUtils.fileExistsAndNotEmpty(localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.g))
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
    if ((localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.f != null) && (localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.c != 0L) && (localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.j != 0) && (localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.k != 0))
    {
      b(paramPicReq);
      return;
    }
    localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_a_of_type_Int = 3;
    localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_e_of_type_JavaLangString = "chatimg";
    int i;
    if (localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.l == 1) {
      i = 7;
    } else {
      i = 6;
    }
    paramPicReq = PicBusiManager.a(i, 3);
    paramPicReq.a((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo);
    d(paramPicReq);
  }
  
  public void a(UpCallBack.SendResult paramSendResult)
  {
    if (paramSendResult != null)
    {
      Object localObject = this.b;
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resut:");
      localStringBuilder.append(paramSendResult);
      Logger.a((String)localObject, str, "updateMsg", localStringBuilder.toString());
      localObject = (MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      ((MessageForPic)localObject).size = paramSendResult.jdField_a_of_type_Long;
      ((MessageForPic)localObject).uuid = paramSendResult.c;
      ((MessageForPic)localObject).groupFileID = paramSendResult.jdField_b_of_type_Long;
      ((MessageForPic)localObject).md5 = paramSendResult.d;
      ((MessageForPic)localObject).serial();
      ((IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "")).updateMsgContentByUniseq(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, ((MessageForPic)localObject).msgData);
    }
  }
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    if (paramSendResult == null)
    {
      a(3, null);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqPicPicReq != null) && (this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_Int == 3))
    {
      if (paramSendResult.jdField_a_of_type_Int == 0)
      {
        a(paramSendResult);
        localObject = ((PicPreDownloadImpl)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IPicPreDownload.class, "")).picStatisticsManager;
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
        int i;
        if (this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.l == 1) {
          i = 7;
        } else {
          i = 6;
        }
        Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "onSend", "fastForward md5 missed,is to Download the pic");
        ((IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "")).removeMsgByMessageRecord(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, false);
        paramSendResult = PicBusiManager.a(i, 3);
        this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a(this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo);
        paramSendResult.a((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo);
        d(paramSendResult);
        return;
      }
      Object localObject = new PicInfoInterface.ErrInfo();
      ((PicInfoInterface.ErrInfo)localObject).b = paramSendResult.jdField_a_of_type_JavaLangString;
      ((PicInfoInterface.ErrInfo)localObject).jdField_a_of_type_JavaLangString = String.valueOf(paramSendResult.jdField_b_of_type_Int);
      a(4, (PicInfoInterface.ErrInfo)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.ForwardPicOperator
 * JD-Core Version:    0.7.0.1
 */