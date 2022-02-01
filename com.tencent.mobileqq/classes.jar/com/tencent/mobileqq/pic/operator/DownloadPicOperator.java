package com.tencent.mobileqq.pic.operator;

import android.text.TextUtils;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawableHandler;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
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
import com.tencent.mobileqq.statistics.GeneralConfigUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.transfile.BaseDownloadProcessor;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.C2CPicDownloadProcessor;
import com.tencent.mobileqq.transfile.GroupPicDownloadProcessor;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TransferRequest.PicDownExtraInfo;
import com.tencent.mobileqq.transfile.TransferResult;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.UrlDownloader;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.transfile.api.impl.TransFileControllerImpl;
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
      }
      return;
    }
    catch (InterruptedException paramTransferRequest)
    {
      paramTransferRequest.printStackTrace();
    }
  }
  
  private void c(DownCallBack.DownResult paramDownResult)
  {
    MessageForPic localMessageForPic;
    if ((paramDownResult != null) && (this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) && (paramDownResult.jdField_b_of_type_JavaLangString != null))
    {
      localMessageForPic = this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
      paramDownResult = new File(paramDownResult.jdField_b_of_type_JavaLangString);
      if ((localMessageForPic.imageType != 2000) && (GifDrawable.isGifFile(paramDownResult)))
      {
        localMessageForPic.imageType = 2000;
        localMessageForPic.serial();
        if (localMessageForPic.subMsgId != MessageForPic.defaultSuMsgId) {
          break label231;
        }
        paramDownResult = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(localMessageForPic.frienduin, localMessageForPic.istroop, localMessageForPic.uniseq);
        if (!(paramDownResult instanceof MessageForStructing)) {
          break label189;
        }
        paramDownResult = (MessageForStructing)paramDownResult;
        if ((paramDownResult.structingMsg instanceof StructMsgForImageShare))
        {
          StructMsgItemImage localStructMsgItemImage = ((StructMsgForImageShare)paramDownResult.structingMsg).getFirstImageElement();
          if (localStructMsgItemImage != null)
          {
            Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "Update GIF flag of StructMsgForImageShare");
            localStructMsgItemImage.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = localMessageForPic;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(localMessageForPic.frienduin, localMessageForPic.istroop, localMessageForPic.uniseq, paramDownResult.structingMsg.getBytes());
          }
        }
      }
    }
    label189:
    label231:
    do
    {
      do
      {
        return;
        Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "Update GIF flag of MessageForPic");
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(localMessageForPic.frienduin, localMessageForPic.istroop, localMessageForPic.uniseq, localMessageForPic.msgData);
        return;
        paramDownResult = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(localMessageForPic.frienduin, localMessageForPic.istroop, localMessageForPic.uniseq);
      } while (!(paramDownResult instanceof MessageForMixedMsg));
      paramDownResult = ((MessageForMixedMsg)paramDownResult).upateMessageForPic(localMessageForPic);
    } while (paramDownResult == null);
    Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "Update GIF flag of MessageForMixedMsg");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(localMessageForPic.frienduin, localMessageForPic.istroop, localMessageForPic.uniseq, paramDownResult);
  }
  
  TransferRequest a(PicDownloadInfo paramPicDownloadInfo, String paramString)
  {
    paramPicDownloadInfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mIsUp = false;
    localTransferRequest.mUinType = paramPicDownloadInfo.jdField_b_of_type_Int;
    if (paramPicDownloadInfo.jdField_e_of_type_Int == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localTransferRequest.mFileType = URLDrawableHelper.getFileSizeType(paramString, bool);
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
      Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "convert2TranferRequest", "outFilePath:" + localTransferRequest.mOutFilePath + "info.protocol:" + paramPicDownloadInfo.jdField_e_of_type_JavaLangString);
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
    int i = paramPicReq.jdField_d_of_type_Int;
    TransferRequest localTransferRequest = a(localPicDownloadInfo, localPicDownloadInfo.jdField_e_of_type_JavaLangString);
    String str = localTransferRequest.mOutFilePath;
    long l = new File(str).length();
    if ((1537 == i) && (l > 0L) && (l < paramPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size))
    {
      paramPicReq = new DownCallBack.DownResult();
      paramPicReq.jdField_a_of_type_Int = 0;
      paramPicReq.jdField_b_of_type_JavaLangString = localTransferRequest.mOutFilePath;
      paramPicReq.jdField_c_of_type_JavaLangString = localTransferRequest.mMd5;
      paramPicReq.jdField_c_of_type_Int = localTransferRequest.mFileType;
      paramPicReq.jdField_d_of_type_Int = localPicDownloadInfo.jdField_h_of_type_Int;
      paramPicReq.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqPicDownCallBack.a(paramPicReq);
      if (QLog.isDevelopLevel()) {
        QLog.d("peak_pgjpeg", 4, "BasePicOperator.downloadBigPic():head download second pass " + str);
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
        localStringBuilder.append("nofile:");
      }
    }
    for (;;)
    {
      localStringBuilder.append("mRequestOffset is " + localTransferRequest.mRequestOffset + ", mRequestLength is " + localTransferRequest.mRequestLength + ", ");
      localStringBuilder.append("outPath is " + str);
      if (QLog.isDevelopLevel()) {
        QLog.d("peak_pgjpeg", 4, localStringBuilder.toString());
      }
      localTransferRequest.mRequestDisplayLength = localMessageForPic.mShowLength;
      localTransferRequest.mDisplayOutFilePath = localPicDownloadInfo.d();
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())) {
        b((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class), localTransferRequest);
      }
      return localTransferRequest;
      if (i != 1536) {}
      for (i = localMessageForPic.mDownloadLength;; i = 0)
      {
        localTransferRequest.mRequestLength = i;
        break;
      }
      if (l >= paramPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size) {
        break label489;
      }
      localTransferRequest.mRequestOffset = localMessageForPic.mDownloadLength;
      localTransferRequest.mRequestLength = 0;
      localStringBuilder.append("part1:");
    }
    label489:
    paramPicReq = new DownCallBack.DownResult();
    paramPicReq.jdField_a_of_type_Int = 0;
    paramPicReq.jdField_b_of_type_JavaLangString = localTransferRequest.mOutFilePath;
    paramPicReq.jdField_c_of_type_JavaLangString = localTransferRequest.mMd5;
    paramPicReq.jdField_c_of_type_Int = localTransferRequest.mFileType;
    paramPicReq.jdField_d_of_type_Int = localPicDownloadInfo.jdField_h_of_type_Int;
    paramPicReq.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqPicDownCallBack.a(paramPicReq);
    if (QLog.isDevelopLevel()) {
      QLog.d("peak_pgjpeg", 4, "BasePicOperator.downloadBigPic():complete download second pass" + str);
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
    paramITransFileController = (TransFileControllerImpl)paramITransFileController;
    if (paramITransFileController.isWorking().get()) {
      if (paramTransferRequest.mFileType == 131076)
      {
        paramITransFileController = new UrlDownloader(paramITransFileController, paramTransferRequest);
        a(paramTransferRequest, paramITransFileController, TransFileControllerImpl.makeReceiveKey(paramTransferRequest), true);
      }
    }
    for (;;)
    {
      return paramTransferRequest.mResult;
      if ((paramTransferRequest.mUinType == 1) || (paramTransferRequest.mUinType == 3000))
      {
        paramITransFileController = new GroupPicDownloadProcessor(paramITransFileController, paramTransferRequest);
        break;
      }
      paramITransFileController = new C2CPicDownloadProcessor(paramITransFileController, paramTransferRequest);
      break;
      paramITransFileController = paramTransferRequest.mResult;
      paramITransFileController.mResult = -1;
      paramITransFileController.mErrCode = 9366L;
      paramITransFileController.mErrDesc = "transfilecontroller closed";
    }
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
      }
    }
    else
    {
      return;
    }
    Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "result:" + paramDownResult.jdField_a_of_type_Int);
    Object localObject = new PicResult();
    ((PicResult)localObject).jdField_a_of_type_Int = paramDownResult.jdField_a_of_type_Int;
    ((PicResult)localObject).jdField_a_of_type_JavaLangObject = paramDownResult;
    ((PicResult)localObject).jdField_a_of_type_Boolean = paramDownResult.jdField_a_of_type_Boolean;
    if (paramDownResult.jdField_a_of_type_Int == 0)
    {
      a(0, (PicResult)localObject);
      return;
    }
    if (paramDownResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo == null)
    {
      localObject = new PicInfoInterface.ErrInfo();
      ((PicInfoInterface.ErrInfo)localObject).jdField_b_of_type_JavaLangString = (paramDownResult.jdField_b_of_type_Int + "_" + paramDownResult.jdField_a_of_type_JavaLangString);
      ((PicInfoInterface.ErrInfo)localObject).jdField_a_of_type_JavaLangString = "onDownload";
      a(0, (PicInfoInterface.ErrInfo)localObject);
      return;
    }
    a(0, paramDownResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo);
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
      if (GeneralConfigUtils.a()) {
        paramPicDownExtraInfo.mUrlFromMsg = paramPicDownloadInfo.k;
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          paramPicDownExtraInfo.mUrlFromMsg = paramPicDownloadInfo.jdField_h_of_type_JavaLangString;
          return;
          if (paramTransferRequest.mFileType != 1) {
            break;
          }
          paramPicDownExtraInfo.mUrlFromMsg = paramPicDownloadInfo.i;
        } while (paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo == null);
        paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_e_of_type_Int = paramPicDownloadInfo.jdField_h_of_type_Int;
        paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo.f = PicPreDownloadUtils.a();
        paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_c_of_type_Long = (System.currentTimeMillis() - paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Long);
        paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Int = 2;
        return;
      } while (paramTransferRequest.mFileType != 131075);
      paramPicDownExtraInfo.mUrlFromMsg = paramPicDownloadInfo.j;
    } while (paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo == null);
    paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_e_of_type_Int = paramPicDownloadInfo.jdField_h_of_type_Int;
    paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo.f = PicPreDownloadUtils.a();
    paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_c_of_type_Long = (System.currentTimeMillis() - paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Long);
    paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Int = 2;
  }
  
  public void a(PicReq paramPicReq)
  {
    Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "downloadPic", "start " + Thread.currentThread().getId());
    PicDownloadInfo localPicDownloadInfo = paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo;
    if (a(localPicDownloadInfo))
    {
      this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + "|" + localPicDownloadInfo.jdField_a_of_type_Long);
      if (!localPicDownloadInfo.jdField_e_of_type_JavaLangString.equals("chatimg"))
      {
        paramPicReq = a(localPicDownloadInfo, localPicDownloadInfo.jdField_e_of_type_JavaLangString);
        if (!new File(paramPicReq.mOutFilePath).exists())
        {
          b((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class), paramPicReq);
          return;
        }
        DownCallBack.DownResult localDownResult = new DownCallBack.DownResult();
        localDownResult.jdField_a_of_type_Int = 0;
        localDownResult.jdField_b_of_type_JavaLangString = paramPicReq.mOutFilePath;
        localDownResult.jdField_c_of_type_JavaLangString = paramPicReq.mMd5;
        localDownResult.jdField_c_of_type_Int = paramPicReq.mFileType;
        localDownResult.jdField_d_of_type_Int = localPicDownloadInfo.jdField_h_of_type_Int;
        this.jdField_a_of_type_ComTencentMobileqqPicDownCallBack.a(localDownResult);
        return;
      }
      a(paramPicReq);
      return;
    }
    paramPicReq = new DownCallBack.DownResult();
    paramPicReq.jdField_a_of_type_Int = -1;
    paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo = localPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo;
    this.jdField_a_of_type_ComTencentMobileqqPicDownCallBack.a(paramPicReq);
  }
  
  void a(TransferRequest paramTransferRequest, BaseTransProcessor paramBaseTransProcessor, String paramString, boolean paramBoolean)
  {
    String str;
    ConcurrentHashMap localConcurrentHashMap;
    if (paramBoolean)
    {
      str = "sync ";
      if (paramBoolean) {
        ((PicPreDownloader)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_PIC_PREDOWNLOAD)).a(paramString);
      }
      localConcurrentHashMap = ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).getProcessMap();
      ??? = (IHttpCommunicatorListener)localConcurrentHashMap.get(paramString);
      if (??? == null) {
        break label445;
      }
      if (!(??? instanceof BaseDownloadProcessor)) {}
    }
    label445:
    do
    {
      do
      {
        long l;
        TransferRequest localTransferRequest;
        do
        {
          synchronized ((BaseDownloadProcessor)???)
          {
            l = ((BaseDownloadProcessor)???).getFileStatus();
            localTransferRequest = ((BaseDownloadProcessor)???).getTransferRequest();
            RichMediaUtil.log(paramTransferRequest.mUinType, paramTransferRequest.mIsUp, paramTransferRequest.mFileType, String.valueOf(paramTransferRequest.mUniseq), str + "startDownloadProcessor", "status:" + l + ",key:" + paramString);
            if ((l == -1L) || (l == 2002L) || (l == 2001L))
            {
              paramTransferRequest.mResult = localTransferRequest.mResult;
              if (paramTransferRequest.mDownCallBack != null) {
                ((BaseDownloadProcessor)???).mDownCallBacks.add(paramTransferRequest.mDownCallBack);
              }
              if (paramBoolean) {
                a(paramTransferRequest, (BaseTransProcessor)???);
              }
            }
            for (;;)
            {
              return;
              str = "aync ";
              break;
              if ((l == 2004L) || (l == 2005L))
              {
                if (paramBaseTransProcessor == null) {
                  continue;
                }
                localConcurrentHashMap.put(paramString, paramBaseTransProcessor);
                paramBaseTransProcessor.setKey(paramString);
                if (paramBaseTransProcessor.checkParam() != 0) {
                  continue;
                }
                PicPreDownloadUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTransferRequest);
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
            }
          }
        } while (l != 2003L);
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
        RichMediaUtil.log(paramTransferRequest.mUinType, paramTransferRequest.mIsUp, paramTransferRequest.mFileType, String.valueOf(paramTransferRequest.mUniseq), str + "startDownloadProcessor", "firs time ,key:" + paramString);
        localConcurrentHashMap.put(paramString, paramBaseTransProcessor);
        paramBaseTransProcessor.setKey(paramString);
      } while (paramBaseTransProcessor.checkParam() != 0);
      PicPreDownloadUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTransferRequest);
      paramBaseTransProcessor.start();
    } while (!paramBoolean);
    try
    {
      a(paramTransferRequest, paramBaseTransProcessor);
      return;
    }
    finally {}
  }
  
  boolean a(PicDownloadInfo paramPicDownloadInfo)
  {
    if (paramPicDownloadInfo != null)
    {
      Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkPicDownloadInfo", "info:" + paramPicDownloadInfo);
      return paramPicDownloadInfo.a();
    }
    Logger.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkPicDownloadInfo", "info == null");
    return false;
  }
  
  public TransferResult b(ITransFileController paramITransFileController, TransferRequest paramTransferRequest)
  {
    paramTransferRequest.mIsUp = false;
    paramTransferRequest.mResult = new TransferResult();
    paramITransFileController = (TransFileControllerImpl)paramITransFileController;
    AtomicBoolean localAtomicBoolean2 = paramITransFileController.isWorking();
    if (localAtomicBoolean2.get()) {}
    for (;;)
    {
      synchronized (paramITransFileController.isWorking())
      {
        if ((!localAtomicBoolean2.get()) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
        {
          paramITransFileController = paramTransferRequest.mResult;
          paramITransFileController.mResult = -1;
          paramITransFileController.mErrCode = 9366L;
          paramITransFileController.mErrDesc = "transfilecontroller closed";
          paramITransFileController = paramTransferRequest.mResult;
          return paramITransFileController;
        }
        try
        {
          if (paramTransferRequest.mFileType == 131076)
          {
            paramITransFileController = new UrlDownloader(paramITransFileController, paramTransferRequest);
            a(paramTransferRequest, paramITransFileController, TransFileControllerImpl.makeReceiveKey(paramTransferRequest), false);
            return paramTransferRequest.mResult;
          }
          if ((paramTransferRequest.mUinType == 1) || (paramTransferRequest.mUinType == 3000))
          {
            paramITransFileController = new GroupPicDownloadProcessor(paramITransFileController, paramTransferRequest);
            continue;
            paramITransFileController = finally;
          }
        }
        catch (NullPointerException paramITransFileController)
        {
          paramITransFileController = paramTransferRequest.mResult;
          paramITransFileController.mResult = -1;
          paramITransFileController.mErrCode = 9366L;
          paramITransFileController.mErrDesc = "transfilecontroller closed";
          paramITransFileController = paramTransferRequest.mResult;
          return paramITransFileController;
        }
      }
      paramITransFileController = new C2CPicDownloadProcessor(paramITransFileController, paramTransferRequest);
      continue;
      paramITransFileController = paramTransferRequest.mResult;
      paramITransFileController.mResult = -1;
      paramITransFileController.mErrCode = 9366L;
      paramITransFileController.mErrDesc = "transfilecontroller closed";
    }
  }
  
  void b(DownCallBack.DownResult paramDownResult)
  {
    ThreadManagerV2.excute(new DownloadPicOperator.1(this, paramDownResult), 128, null, true);
  }
  
  void b(PicReq paramPicReq)
  {
    Object localObject = paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo;
    String str = ((PicDownloadInfo)localObject).jdField_e_of_type_JavaLangString;
    paramPicReq = paramPicReq.jdField_a_of_type_JavaLangObject;
    Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "downloadPicSync", "start " + Thread.currentThread().getId());
    if (a((PicDownloadInfo)localObject))
    {
      this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + "|" + ((PicDownloadInfo)localObject).jdField_a_of_type_Long);
      ITransFileController localITransFileController = (ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class);
      localObject = a((PicDownloadInfo)localObject, str);
      if ((((TransferRequest)localObject).mExtraObj != null) && ((((TransferRequest)localObject).mExtraObj instanceof TransferRequest.PicDownExtraInfo)) && (paramPicReq != null) && ((paramPicReq instanceof URLDrawableHandler))) {
        ((TransferRequest.PicDownExtraInfo)((TransferRequest)localObject).mExtraObj).mHandler = ((URLDrawableHandler)paramPicReq);
      }
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferResult = a(localITransFileController, (TransferRequest)localObject);
      return;
    }
    paramPicReq = new DownCallBack.DownResult();
    paramPicReq.jdField_a_of_type_Int = -1;
    paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo = ((PicDownloadInfo)localObject).jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo;
    this.jdField_a_of_type_ComTencentMobileqqPicDownCallBack.a(paramPicReq);
    paramPicReq = new TransferResult();
    paramPicReq.mResult = -1;
    paramPicReq.mErrCode = 9302L;
    if (((PicDownloadInfo)localObject).jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo != null) {}
    for (paramPicReq.mErrDesc = ("downloadPicSync," + ((PicDownloadInfo)localObject).jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.jdField_b_of_type_JavaLangString);; paramPicReq.mErrDesc = "downloadPicSync param check error")
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferResult = paramPicReq;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.DownloadPicOperator
 * JD-Core Version:    0.7.0.1
 */