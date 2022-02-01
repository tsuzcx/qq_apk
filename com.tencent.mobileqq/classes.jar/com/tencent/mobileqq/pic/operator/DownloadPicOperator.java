package com.tencent.mobileqq.pic.operator;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.mixedmsg.api.IMsgMixed;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.DownCallBack.DownResult;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicDownloadInfo;
import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;
import com.tencent.mobileqq.pic.PicPreDownloadUtils;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicResult;
import com.tencent.mobileqq.pic.ReportInfo;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.pic.api.IPicPreDownload;
import com.tencent.mobileqq.pic.api.impl.PicPreDownloadImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.api.IMsgStructing;
import com.tencent.mobileqq.transfile.BaseDownloadProcessor;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.C2CPicDownloadProcessor;
import com.tencent.mobileqq.transfile.GroupPicDownloadProcessor;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TransferRequest.PicDownExtraInfo;
import com.tencent.mobileqq.transfile.TransferResult;
import com.tencent.mobileqq.transfile.UrlDownloader;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class DownloadPicOperator
  extends BasePicOperator
  implements DownCallBack
{
  DownCallBack jdField_a_of_type_ComTencentMobileqqPicDownCallBack = this;
  private TransferResult jdField_a_of_type_ComTencentMobileqqTransfileTransferResult;
  
  private void a(TransferRequest paramTransferRequest, BaseTransProcessor paramBaseTransProcessor)
  {
    try
    {
      if (paramTransferRequest.mResult.mResult == -2)
      {
        RichMediaUtil.log(paramTransferRequest.mUinType, paramTransferRequest.mIsUp, paramTransferRequest.mFileType, String.valueOf(paramTransferRequest.mUniseq), "callwait", "");
        paramBaseTransProcessor.wait();
        RichMediaUtil.log(paramTransferRequest.mUinType, paramTransferRequest.mIsUp, paramTransferRequest.mFileType, String.valueOf(paramTransferRequest.mUniseq), "waitfin", "");
        return;
      }
    }
    catch (InterruptedException paramTransferRequest)
    {
      paramTransferRequest.printStackTrace();
    }
  }
  
  private void c(DownCallBack.DownResult paramDownResult)
  {
    if ((paramDownResult != null) && (this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) && (paramDownResult.jdField_b_of_type_JavaLangString != null))
    {
      MessageForPic localMessageForPic = this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
      paramDownResult = new File(paramDownResult.jdField_b_of_type_JavaLangString);
      if ((localMessageForPic.imageType != 2000) && (GifDrawable.isGifFile(paramDownResult)))
      {
        localMessageForPic.imageType = 2000;
        localMessageForPic.serial();
        if (localMessageForPic.subMsgId == MessageForPic.defaultSuMsgId)
        {
          paramDownResult = ((IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "")).queryMsgItemByUniseq(localMessageForPic.frienduin, localMessageForPic.istroop, localMessageForPic.uniseq);
          if (((IMsgStructing)QRoute.api(IMsgStructing.class)).isMessageForStructing(paramDownResult))
          {
            ((IMsgStructing)QRoute.api(IMsgStructing.class)).updateMsgAfterDownload(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramDownResult, localMessageForPic);
            return;
          }
          Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "Update GIF flag of MessageForPic");
          ((IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "")).updateMsgContentByUniseq(localMessageForPic.frienduin, localMessageForPic.istroop, localMessageForPic.uniseq, localMessageForPic.msgData);
          return;
        }
        paramDownResult = ((IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "")).queryMsgItemByUniseq(localMessageForPic.frienduin, localMessageForPic.istroop, localMessageForPic.uniseq);
        if (((IMsgMixed)QRoute.api(IMsgMixed.class)).isMessageForMixedMsg(paramDownResult)) {
          ((IMsgMixed)QRoute.api(IMsgMixed.class)).updateMsgAfterDownload(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramDownResult, localMessageForPic);
        }
      }
    }
  }
  
  TransferRequest a(PicDownloadInfo paramPicDownloadInfo, String paramString)
  {
    paramPicDownloadInfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mIsUp = false;
    localTransferRequest.mUinType = paramPicDownloadInfo.jdField_b_of_type_Int;
    boolean bool;
    if (paramPicDownloadInfo.jdField_e_of_type_Int == 1) {
      bool = true;
    } else {
      bool = false;
    }
    localTransferRequest.mFileType = ((IPicHelper)QRoute.api(IPicHelper.class)).getFileSizeType(paramString, bool);
    localTransferRequest.mUniseq = paramPicDownloadInfo.jdField_a_of_type_Long;
    localTransferRequest.mSubMsgId = paramPicDownloadInfo.jdField_g_of_type_Int;
    localTransferRequest.mSelfUin = paramPicDownloadInfo.jdField_b_of_type_JavaLangString;
    localTransferRequest.mPeerUin = paramPicDownloadInfo.jdField_c_of_type_JavaLangString;
    localTransferRequest.mServerPath = paramPicDownloadInfo.jdField_g_of_type_JavaLangString;
    localTransferRequest.mLocalPath = null;
    localTransferRequest.mDownCallBack = this.jdField_a_of_type_ComTencentMobileqqPicDownCallBack;
    localTransferRequest.useOutputstream = false;
    localTransferRequest.bEnableEnc = paramPicDownloadInfo.jdField_d_of_type_Boolean;
    localTransferRequest.mOutFilePath = paramPicDownloadInfo.c();
    if ((this.jdField_a_of_type_ComTencentMobileqqPicPicReq != null) && (this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)) {
      localTransferRequest.mRec = this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
    }
    paramString = this.jdField_b_of_type_JavaLangString;
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("outFilePath:");
    localStringBuilder.append(localTransferRequest.mOutFilePath);
    localStringBuilder.append("info.protocol:");
    localStringBuilder.append(paramPicDownloadInfo.jdField_e_of_type_JavaLangString);
    Logger.a(paramString, str, "convert2TranferRequest", localStringBuilder.toString());
    paramString = new TransferRequest.PicDownExtraInfo();
    localTransferRequest.mExtraObj = paramString;
    a(paramPicDownloadInfo, localTransferRequest, paramString);
    localTransferRequest.mMd5 = paramPicDownloadInfo.f;
    localTransferRequest.mGroupFileID = paramPicDownloadInfo.jdField_b_of_type_Long;
    localTransferRequest.mDbRecVersion = paramPicDownloadInfo.jdField_d_of_type_Int;
    localTransferRequest.mBusiType = paramPicDownloadInfo.jdField_a_of_type_Int;
    localTransferRequest.mNeedReport = true;
    localTransferRequest.mDownMode = paramPicDownloadInfo.jdField_h_of_type_Int;
    localTransferRequest.mMsgTime = paramPicDownloadInfo.jdField_c_of_type_Long;
    return localTransferRequest;
  }
  
  TransferRequest a(PicReq paramPicReq)
  {
    PicDownloadInfo localPicDownloadInfo = paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo;
    if (!a(localPicDownloadInfo))
    {
      paramPicReq = new DownCallBack.DownResult();
      paramPicReq.jdField_a_of_type_Int = -1;
      paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo = localPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo;
      this.jdField_a_of_type_ComTencentMobileqqPicDownCallBack.a(paramPicReq);
      return null;
    }
    MessageForPic localMessageForPic = paramPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
    int j = paramPicReq.jdField_d_of_type_Int;
    TransferRequest localTransferRequest = a(localPicDownloadInfo, localPicDownloadInfo.jdField_e_of_type_JavaLangString);
    String str = localTransferRequest.mOutFilePath;
    long l = new File(str).length();
    int i = 0;
    if ((1537 == j) && (l > 0L) && (l < paramPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size))
    {
      paramPicReq = new DownCallBack.DownResult();
      paramPicReq.jdField_a_of_type_Int = 0;
      paramPicReq.jdField_b_of_type_JavaLangString = localTransferRequest.mOutFilePath;
      paramPicReq.jdField_c_of_type_JavaLangString = localTransferRequest.mMd5;
      paramPicReq.jdField_c_of_type_Int = localTransferRequest.mFileType;
      paramPicReq.jdField_d_of_type_Int = localPicDownloadInfo.jdField_h_of_type_Int;
      paramPicReq.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqPicDownCallBack.a(paramPicReq);
      if (QLog.isDevelopLevel())
      {
        paramPicReq = new StringBuilder();
        paramPicReq.append("BasePicOperator.downloadBigPic():head download second pass ");
        paramPicReq.append(str);
        QLog.d("peak_pgjpeg", 4, paramPicReq.toString());
      }
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (l == 0L)
    {
      localTransferRequest.mRequestOffset = 0;
      if (localMessageForPic.mDownloadLength == paramPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size)
      {
        localTransferRequest.mRequestLength = 0;
      }
      else
      {
        if (j != 1536) {
          i = localMessageForPic.mDownloadLength;
        }
        localTransferRequest.mRequestLength = i;
      }
      localStringBuilder.append("nofile:");
    }
    else
    {
      if (l >= paramPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size) {
        break label517;
      }
      localTransferRequest.mRequestOffset = localMessageForPic.mDownloadLength;
      localTransferRequest.mRequestLength = 0;
      localStringBuilder.append("part1:");
    }
    paramPicReq = new StringBuilder();
    paramPicReq.append("mRequestOffset is ");
    paramPicReq.append(localTransferRequest.mRequestOffset);
    paramPicReq.append(", mRequestLength is ");
    paramPicReq.append(localTransferRequest.mRequestLength);
    paramPicReq.append(", ");
    localStringBuilder.append(paramPicReq.toString());
    paramPicReq = new StringBuilder();
    paramPicReq.append("outPath is ");
    paramPicReq.append(str);
    localStringBuilder.append(paramPicReq.toString());
    if (QLog.isDevelopLevel()) {
      QLog.d("peak_pgjpeg", 4, localStringBuilder.toString());
    }
    localTransferRequest.mRequestDisplayLength = localMessageForPic.mShowLength;
    localTransferRequest.mDisplayOutFilePath = localPicDownloadInfo.d();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount())) {
      b((ITransFileController)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITransFileController.class, ""), localTransferRequest);
    }
    return localTransferRequest;
    label517:
    paramPicReq = new DownCallBack.DownResult();
    paramPicReq.jdField_a_of_type_Int = 0;
    paramPicReq.jdField_b_of_type_JavaLangString = localTransferRequest.mOutFilePath;
    paramPicReq.jdField_c_of_type_JavaLangString = localTransferRequest.mMd5;
    paramPicReq.jdField_c_of_type_Int = localTransferRequest.mFileType;
    paramPicReq.jdField_d_of_type_Int = localPicDownloadInfo.jdField_h_of_type_Int;
    paramPicReq.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqPicDownCallBack.a(paramPicReq);
    if (QLog.isDevelopLevel())
    {
      paramPicReq = new StringBuilder();
      paramPicReq.append("BasePicOperator.downloadBigPic():complete download second pass");
      paramPicReq.append(str);
      QLog.d("peak_pgjpeg", 4, paramPicReq.toString());
    }
    return null;
  }
  
  public TransferResult a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTransfileTransferResult;
  }
  
  public TransferResult a(ITransFileController paramITransFileController, TransferRequest paramTransferRequest)
  {
    paramTransferRequest.mIsUp = false;
    paramTransferRequest.mResult = new TransferResult();
    if (paramITransFileController.isWorking().get())
    {
      if (paramTransferRequest.mFileType == 131076) {
        paramITransFileController = new UrlDownloader((BaseTransFileController)paramITransFileController, paramTransferRequest);
      } else if ((paramTransferRequest.mUinType != 1) && (paramTransferRequest.mUinType != 3000)) {
        paramITransFileController = new C2CPicDownloadProcessor((BaseTransFileController)paramITransFileController, paramTransferRequest);
      } else {
        paramITransFileController = new GroupPicDownloadProcessor((BaseTransFileController)paramITransFileController, paramTransferRequest);
      }
      a(paramTransferRequest, paramITransFileController, BaseTransFileController.makeReceiveKey(paramTransferRequest), true);
    }
    else
    {
      paramITransFileController = paramTransferRequest.mResult;
      paramITransFileController.mResult = -1;
      paramITransFileController.mErrCode = 9366L;
      paramITransFileController.mErrDesc = "transfilecontroller closed";
    }
    return paramTransferRequest.mResult;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_d_of_type_Int == 1280)
    {
      b(this.jdField_a_of_type_ComTencentMobileqqPicPicReq);
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqPicPicReq);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    PicResult localPicResult = new PicResult();
    localPicResult.jdField_a_of_type_Int = 0;
    localPicResult.jdField_a_of_type_JavaLangObject = Integer.valueOf(paramInt);
    localPicResult.c = paramBoolean;
    a(1, 0, localPicResult);
  }
  
  public void a(DownCallBack.DownResult paramDownResult)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPicPicReq != null)
    {
      c(paramDownResult);
      b(paramDownResult);
      if (paramDownResult == null)
      {
        paramDownResult = new PicInfoInterface.ErrInfo();
        paramDownResult.jdField_b_of_type_JavaLangString = "result == null";
        paramDownResult.jdField_a_of_type_JavaLangString = "onDownload";
        a(0, paramDownResult);
        return;
      }
      Object localObject1 = this.jdField_b_of_type_JavaLangString;
      Object localObject2 = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("result:");
      localStringBuilder.append(paramDownResult.jdField_a_of_type_Int);
      Logger.a((String)localObject1, (String)localObject2, "onDownload", localStringBuilder.toString());
      localObject1 = new PicResult();
      ((PicResult)localObject1).jdField_a_of_type_Int = paramDownResult.jdField_a_of_type_Int;
      ((PicResult)localObject1).jdField_a_of_type_JavaLangObject = paramDownResult;
      ((PicResult)localObject1).jdField_a_of_type_Boolean = paramDownResult.jdField_a_of_type_Boolean;
      if (paramDownResult.jdField_a_of_type_Int == 0)
      {
        a(0, (PicResult)localObject1);
        return;
      }
      if (paramDownResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo == null)
      {
        localObject1 = new PicInfoInterface.ErrInfo();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramDownResult.jdField_b_of_type_Int);
        ((StringBuilder)localObject2).append("_");
        ((StringBuilder)localObject2).append(paramDownResult.jdField_a_of_type_JavaLangString);
        ((PicInfoInterface.ErrInfo)localObject1).jdField_b_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
        ((PicInfoInterface.ErrInfo)localObject1).jdField_a_of_type_JavaLangString = "onDownload";
        a(0, (PicInfoInterface.ErrInfo)localObject1);
        return;
      }
      a(0, paramDownResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo);
    }
  }
  
  void a(PicDownloadInfo paramPicDownloadInfo, TransferRequest paramTransferRequest, TransferRequest.PicDownExtraInfo paramPicDownExtraInfo)
  {
    if (paramTransferRequest.mFileType == 65537)
    {
      if (paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo != null)
      {
        paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_d_of_type_Int = paramPicDownloadInfo.jdField_h_of_type_Int;
        paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_c_of_type_Int = PicPreDownloadUtils.a();
        paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_b_of_type_Long = (System.currentTimeMillis() - paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Long);
        paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Int = 1;
      }
      paramPicDownExtraInfo.mUrlFromMsg = paramPicDownloadInfo.jdField_h_of_type_JavaLangString;
      return;
    }
    if (paramTransferRequest.mFileType == 1)
    {
      paramPicDownExtraInfo.mUrlFromMsg = paramPicDownloadInfo.i;
      if (paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo != null)
      {
        paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_e_of_type_Int = paramPicDownloadInfo.jdField_h_of_type_Int;
        paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo.f = PicPreDownloadUtils.a();
        paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_c_of_type_Long = (System.currentTimeMillis() - paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Long);
        paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Int = 2;
      }
    }
    else if (paramTransferRequest.mFileType == 131075)
    {
      paramPicDownExtraInfo.mUrlFromMsg = paramPicDownloadInfo.j;
      if (paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo != null)
      {
        paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_e_of_type_Int = paramPicDownloadInfo.jdField_h_of_type_Int;
        paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo.f = PicPreDownloadUtils.a();
        paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_c_of_type_Long = (System.currentTimeMillis() - paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Long);
        paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Int = 2;
      }
    }
  }
  
  public void a(PicReq paramPicReq)
  {
    Object localObject1 = this.jdField_b_of_type_JavaLangString;
    Object localObject2 = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start ");
    localStringBuilder.append(Thread.currentThread().getId());
    Logger.a((String)localObject1, (String)localObject2, "downloadPic", localStringBuilder.toString());
    localObject1 = paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo;
    if (a((PicDownloadInfo)localObject1))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject2).append("|");
      ((StringBuilder)localObject2).append(((PicDownloadInfo)localObject1).jdField_a_of_type_Long);
      this.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
      if (!((PicDownloadInfo)localObject1).jdField_e_of_type_JavaLangString.equals("chatimg"))
      {
        paramPicReq = a((PicDownloadInfo)localObject1, ((PicDownloadInfo)localObject1).jdField_e_of_type_JavaLangString);
        if (!new File(paramPicReq.mOutFilePath).exists())
        {
          b((ITransFileController)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITransFileController.class, ""), paramPicReq);
          return;
        }
        localObject2 = new DownCallBack.DownResult();
        ((DownCallBack.DownResult)localObject2).jdField_a_of_type_Int = 0;
        ((DownCallBack.DownResult)localObject2).jdField_b_of_type_JavaLangString = paramPicReq.mOutFilePath;
        ((DownCallBack.DownResult)localObject2).jdField_c_of_type_JavaLangString = paramPicReq.mMd5;
        ((DownCallBack.DownResult)localObject2).jdField_c_of_type_Int = paramPicReq.mFileType;
        ((DownCallBack.DownResult)localObject2).jdField_d_of_type_Int = ((PicDownloadInfo)localObject1).jdField_h_of_type_Int;
        this.jdField_a_of_type_ComTencentMobileqqPicDownCallBack.a((DownCallBack.DownResult)localObject2);
        return;
      }
      a(paramPicReq);
      return;
    }
    paramPicReq = new DownCallBack.DownResult();
    paramPicReq.jdField_a_of_type_Int = -1;
    paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo = ((PicDownloadInfo)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo;
    this.jdField_a_of_type_ComTencentMobileqqPicDownCallBack.a(paramPicReq);
  }
  
  void a(TransferRequest paramTransferRequest, BaseTransProcessor paramBaseTransProcessor, String paramString, boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = "sync ";
    } else {
      str = "aync ";
    }
    if (paramBoolean) {
      ((PicPreDownloadImpl)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IPicPreDownload.class, "")).picPreDownloader.a(paramString);
    }
    ConcurrentHashMap localConcurrentHashMap = ((ITransFileController)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITransFileController.class, "")).getProcessMap();
    ??? = (IHttpCommunicatorListener)localConcurrentHashMap.get(paramString);
    if (??? != null) {
      if (!(??? instanceof BaseDownloadProcessor)) {
        break label639;
      }
    }
    for (;;)
    {
      synchronized ((BaseDownloadProcessor)???)
      {
        l1 = ((BaseDownloadProcessor)???).getFileStatus();
        TransferRequest localTransferRequest = ((BaseDownloadProcessor)???).getTransferRequest();
        i = paramTransferRequest.mUinType;
        bool = paramTransferRequest.mIsUp;
        j = paramTransferRequest.mFileType;
        long l2 = paramTransferRequest.mUniseq;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("startDownloadProcessor");
        str = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("status:");
        localStringBuilder.append(l1);
        localStringBuilder.append(",key:");
        localStringBuilder.append(paramString);
        RichMediaUtil.log(i, bool, j, String.valueOf(l2), str, localStringBuilder.toString());
        if ((l1 != -1L) && (l1 != 2002L))
        {
          if (l1 != 2001L) {
            break label640;
          }
          continue;
          if (l1 != 2003L) {
            continue;
          }
          paramTransferRequest.mResult = localTransferRequest.mResult;
          if (paramTransferRequest.mDownCallBack != null)
          {
            paramBaseTransProcessor = new DownCallBack.DownResult();
            paramBaseTransProcessor.jdField_a_of_type_Int = 0;
            paramBaseTransProcessor.jdField_b_of_type_JavaLangString = paramTransferRequest.mOutFilePath;
            paramBaseTransProcessor.jdField_c_of_type_JavaLangString = paramTransferRequest.mMd5;
            paramBaseTransProcessor.jdField_c_of_type_Int = paramTransferRequest.mFileType;
            paramBaseTransProcessor.jdField_d_of_type_Int = paramTransferRequest.mDownMode;
            paramTransferRequest.mDownCallBack.a(paramBaseTransProcessor);
          }
          return;
          if (paramBaseTransProcessor == null) {
            continue;
          }
          localConcurrentHashMap.put(paramString, paramBaseTransProcessor);
          paramBaseTransProcessor.setKey(paramString);
          if (paramBaseTransProcessor.checkParam() != 0) {
            continue;
          }
          PicPreDownloadUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramTransferRequest);
          paramBaseTransProcessor.start();
          if (!paramBoolean) {
            continue;
          }
          try
          {
            RichMediaUtil.log(paramTransferRequest.mUinType, paramTransferRequest.mIsUp, paramTransferRequest.mFileType, String.valueOf(paramTransferRequest.mUniseq), "callwait", "");
            ???.wait();
          }
          catch (InterruptedException paramTransferRequest)
          {
            paramTransferRequest.printStackTrace();
          }
        }
        paramTransferRequest.mResult = localTransferRequest.mResult;
        if (paramTransferRequest.mDownCallBack != null) {
          ((BaseDownloadProcessor)???).mDownCallBacks.add(paramTransferRequest.mDownCallBack);
        }
        if (paramBoolean) {
          a(paramTransferRequest, (BaseTransProcessor)???);
        }
        return;
      }
      int i = paramTransferRequest.mUinType;
      boolean bool = paramTransferRequest.mIsUp;
      int j = paramTransferRequest.mFileType;
      long l1 = paramTransferRequest.mUniseq;
      ??? = new StringBuilder();
      ((StringBuilder)???).append(str);
      ((StringBuilder)???).append("startDownloadProcessor");
      str = ((StringBuilder)???).toString();
      ??? = new StringBuilder();
      ((StringBuilder)???).append("firs time ,key:");
      ((StringBuilder)???).append(paramString);
      RichMediaUtil.log(i, bool, j, String.valueOf(l1), str, ((StringBuilder)???).toString());
      localConcurrentHashMap.put(paramString, paramBaseTransProcessor);
      paramBaseTransProcessor.setKey(paramString);
      if (paramBaseTransProcessor.checkParam() == 0)
      {
        PicPreDownloadUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramTransferRequest);
        paramBaseTransProcessor.start();
        if (paramBoolean) {
          try
          {
            a(paramTransferRequest, paramBaseTransProcessor);
            return;
          }
          finally {}
        }
      }
      label639:
      return;
      label640:
      if (l1 != 2004L) {
        if (l1 != 2005L) {}
      }
    }
  }
  
  boolean a(PicDownloadInfo paramPicDownloadInfo)
  {
    if (paramPicDownloadInfo != null)
    {
      String str1 = this.jdField_b_of_type_JavaLangString;
      String str2 = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("info:");
      localStringBuilder.append(paramPicDownloadInfo);
      Logger.a(str1, str2, "checkPicDownloadInfo", localStringBuilder.toString());
      return paramPicDownloadInfo.a();
    }
    Logger.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkPicDownloadInfo", "info == null");
    return false;
  }
  
  public TransferResult b(ITransFileController paramITransFileController, TransferRequest paramTransferRequest)
  {
    paramTransferRequest.mIsUp = false;
    paramTransferRequest.mResult = new TransferResult();
    Object localObject = paramITransFileController.isWorking();
    if (((AtomicBoolean)localObject).get())
    {
      synchronized (paramITransFileController.isWorking())
      {
        if (((AtomicBoolean)localObject).get())
        {
          localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
          if (localObject == null) {}
        }
        try
        {
          if (paramTransferRequest.mFileType == 131076) {
            paramITransFileController = new UrlDownloader((BaseTransFileController)paramITransFileController, paramTransferRequest);
          } else if ((paramTransferRequest.mUinType != 1) && (paramTransferRequest.mUinType != 3000)) {
            paramITransFileController = new C2CPicDownloadProcessor((BaseTransFileController)paramITransFileController, paramTransferRequest);
          } else {
            paramITransFileController = new GroupPicDownloadProcessor((BaseTransFileController)paramITransFileController, paramTransferRequest);
          }
          a(paramTransferRequest, paramITransFileController, BaseTransFileController.makeReceiveKey(paramTransferRequest), false);
        }
        catch (NullPointerException paramITransFileController)
        {
          label155:
          break label155;
        }
        paramITransFileController = paramTransferRequest.mResult;
        paramITransFileController.mResult = -1;
        paramITransFileController.mErrCode = 9366L;
        paramITransFileController.mErrDesc = "transfilecontroller closed";
        paramITransFileController = paramTransferRequest.mResult;
        return paramITransFileController;
        paramITransFileController = paramTransferRequest.mResult;
        paramITransFileController.mResult = -1;
        paramITransFileController.mErrCode = 9366L;
        paramITransFileController.mErrDesc = "transfilecontroller closed";
        paramITransFileController = paramTransferRequest.mResult;
        return paramITransFileController;
      }
    }
    else
    {
      paramITransFileController = paramTransferRequest.mResult;
      paramITransFileController.mResult = -1;
      paramITransFileController.mErrCode = 9366L;
      paramITransFileController.mErrDesc = "transfilecontroller closed";
      return paramTransferRequest.mResult;
    }
  }
  
  void b(DownCallBack.DownResult paramDownResult)
  {
    ThreadManagerV2.excute(new DownloadPicOperator.1(this, paramDownResult), 128, null, true);
  }
  
  void b(PicReq paramPicReq)
  {
    Object localObject1 = paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo;
    Object localObject2 = ((PicDownloadInfo)localObject1).jdField_e_of_type_JavaLangString;
    paramPicReq = paramPicReq.jdField_a_of_type_JavaLangObject;
    Object localObject3 = this.jdField_b_of_type_JavaLangString;
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start ");
    localStringBuilder.append(Thread.currentThread().getId());
    Logger.a((String)localObject3, str, "downloadPicSync", localStringBuilder.toString());
    if (a((PicDownloadInfo)localObject1))
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject3).append("|");
      ((StringBuilder)localObject3).append(((PicDownloadInfo)localObject1).jdField_a_of_type_Long);
      this.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject3).toString();
      localObject3 = (ITransFileController)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITransFileController.class, "");
      localObject1 = a((PicDownloadInfo)localObject1, (String)localObject2);
      if ((((TransferRequest)localObject1).mExtraObj != null) && ((((TransferRequest)localObject1).mExtraObj instanceof TransferRequest.PicDownExtraInfo)) && (paramPicReq != null) && ((paramPicReq instanceof URLDrawableHandler))) {
        ((TransferRequest.PicDownExtraInfo)((TransferRequest)localObject1).mExtraObj).mHandler = ((URLDrawableHandler)paramPicReq);
      }
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferResult = a((ITransFileController)localObject3, (TransferRequest)localObject1);
      return;
    }
    paramPicReq = new DownCallBack.DownResult();
    paramPicReq.jdField_a_of_type_Int = -1;
    paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo = ((PicDownloadInfo)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo;
    this.jdField_a_of_type_ComTencentMobileqqPicDownCallBack.a(paramPicReq);
    paramPicReq = new TransferResult();
    paramPicReq.mResult = -1;
    paramPicReq.mErrCode = 9302L;
    if (((PicDownloadInfo)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo != null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("downloadPicSync,");
      ((StringBuilder)localObject2).append(((PicDownloadInfo)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.jdField_b_of_type_JavaLangString);
      paramPicReq.mErrDesc = ((StringBuilder)localObject2).toString();
    }
    else
    {
      paramPicReq.mErrDesc = "downloadPicSync param check error";
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransferResult = paramPicReq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.DownloadPicOperator
 * JD-Core Version:    0.7.0.1
 */