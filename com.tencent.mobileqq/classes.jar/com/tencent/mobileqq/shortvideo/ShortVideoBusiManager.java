package com.tencent.mobileqq.shortvideo;

import com.tencent.device.file.DevLittleVideoOperator;
import com.tencent.device.file.DevShortVideoOperator;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.data.MessageForBlessPTV;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ShortVideoBusiManager
{
  public static long a;
  public static boolean a;
  public static long b;
  
  static BaseShortVideoOprerator a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
    case 2: 
    case 3: 
    case 5: 
    case 6: 
      return new AioShortVideoOperator(paramQQAppInterface);
    case 1: 
      return new DevShortVideoOperator(paramQQAppInterface);
    }
    return new DevLittleVideoOperator(paramQQAppInterface);
  }
  
  static InfoBuilder a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
    case 2: 
    case 3: 
    case 5: 
    case 6: 
      return new AioShortVideoOperator();
    case 1: 
      return new DevShortVideoOperator();
    }
    return new DevLittleVideoOperator();
  }
  
  public static ShortVideoForwardInfo a(int paramInt, Object paramObject, ShortVideoReq paramShortVideoReq)
  {
    InfoBuilder localInfoBuilder = a(paramInt);
    if (localInfoBuilder == null) {
      return null;
    }
    return localInfoBuilder.a(paramObject, paramShortVideoReq);
  }
  
  public static ShortVideoReq a(int paramInt1, int paramInt2)
  {
    ShortVideoReq localShortVideoReq = new ShortVideoReq();
    localShortVideoReq.jdField_a_of_type_Int = paramInt1;
    localShortVideoReq.jdField_b_of_type_Int = paramInt2;
    return localShortVideoReq;
  }
  
  public static ShortVideoReq a(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo, int paramInt)
  {
    if (paramMessageForShortVideo.videoFileStatus == 5002)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoBusiManager", 2, "createShortVideoReqByMsg expired");
      }
      return null;
    }
    ShortVideoReq localShortVideoReq = a(2, paramMessageForShortVideo.busiType);
    ShortVideoDownloadInfo localShortVideoDownloadInfo = paramMessageForShortVideo.getDownloadInfo(localShortVideoReq.jdField_b_of_type_Int);
    localShortVideoDownloadInfo.h = ShortVideoUtils.getShortVideoSavePath(paramMessageForShortVideo, "mp4");
    localShortVideoDownloadInfo.f = paramInt;
    if (paramMessageForShortVideo.busiType == 0) {
      localShortVideoDownloadInfo.b = true;
    }
    paramQQAppInterface = paramQQAppInterface.getMessageFacade();
    if ((paramQQAppInterface.a()) && (paramQQAppInterface.a().equals(paramMessageForShortVideo.frienduin)))
    {
      localShortVideoDownloadInfo.g = 2;
      if ((paramMessageForShortVideo.istroop != 0) && (paramMessageForShortVideo.istroop != 1008)) {
        break label154;
      }
      localShortVideoDownloadInfo.e = 1001;
    }
    for (;;)
    {
      localShortVideoReq.a(localShortVideoDownloadInfo);
      localShortVideoReq.a(paramMessageForShortVideo);
      return localShortVideoReq;
      localShortVideoDownloadInfo.g = 1;
      break;
      label154:
      if (paramMessageForShortVideo.istroop == 3000) {
        localShortVideoDownloadInfo.e = 1005;
      } else if (paramMessageForShortVideo.istroop == 1) {
        localShortVideoDownloadInfo.e = 1003;
      }
    }
  }
  
  public static ShortVideoUploadInfo a(int paramInt, Object paramObject, ShortVideoReq paramShortVideoReq)
  {
    InfoBuilder localInfoBuilder = a(paramInt);
    if (localInfoBuilder == null) {
      return null;
    }
    return localInfoBuilder.a(paramObject, paramShortVideoReq);
  }
  
  public static ShortVideoUploadInfo a(Object paramObject, ShortVideoReq paramShortVideoReq)
  {
    InfoBuilder localInfoBuilder = a(paramShortVideoReq.jdField_b_of_type_Int);
    if (localInfoBuilder == null) {
      return null;
    }
    return localInfoBuilder.a(paramObject, paramShortVideoReq);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, FileMsg paramFileMsg, TransferRequest paramTransferRequest)
  {
    if ((paramFileMsg == null) || (paramTransferRequest == null)) {
      Logger.b("ShortVideoBusiManager", "updataMessageDataBaseContent", "fileMsg or req is null");
    }
    label497:
    do
    {
      MessageRecord localMessageRecord;
      MessageForShortVideo localMessageForShortVideo;
      do
      {
        do
        {
          return;
          if (paramTransferRequest.mRec != null) {
            localMessageRecord = paramTransferRequest.mRec;
          }
          while (localMessageRecord == null)
          {
            Logger.b("ShortVideoBusiManager", "updataMessageDataBaseContent", "msg null");
            return;
            localMessageRecord = paramQQAppInterface.getMessageFacade().a(paramTransferRequest.mPeerUin, paramTransferRequest.mUinType, paramTransferRequest.mUniseq);
            Logger.a("ShortVideoBusiManager", "updataMessageDataBaseContent", "findmsgbyMsgId,need fix");
          }
        } while (!(localMessageRecord instanceof MessageForShortVideo));
        localMessageForShortVideo = (MessageForShortVideo)localMessageRecord;
        if (paramFileMsg.fileSize == 0L) {}
        for (int i = 0;; i = (int)(100L * paramFileMsg.transferedSize / paramFileMsg.fileSize))
        {
          if (localMessageForShortVideo.videoFileProgress < 0) {
            localMessageForShortVideo.videoFileProgress = 0;
          }
          int j = localMessageForShortVideo.videoFileProgress;
          if (((localMessageForShortVideo.videoFileStatus == 1002) || (localMessageForShortVideo.videoFileStatus == 2002)) && (localMessageForShortVideo.videoFileStatus == paramFileMsg.status) && (i - j < 10)) {
            break;
          }
          if (localMessageForShortVideo.videoFileStatus == 1003) {
            localMessageForShortVideo.videoFileProgress = 100;
          }
          if ((paramFileMsg.fileType == 6) || (paramFileMsg.fileType == 17) || (paramFileMsg.fileType == 9) || (paramFileMsg.fileType == 20))
          {
            if (paramFileMsg.status == 2002) {
              localMessageForShortVideo.transferedSize = ((int)paramFileMsg.transferedSize);
            }
            if (paramFileMsg.status == 2003) {
              localMessageForShortVideo.transferedSize = 0;
            }
          }
          if (((localMessageForShortVideo.videoFileStatus == 2004) || (localMessageForShortVideo.videoFileStatus == 1004)) && ((paramFileMsg.status == 1002) || (paramFileMsg.status == 2002))) {
            break;
          }
          localMessageForShortVideo.videoFileStatus = paramFileMsg.status;
          localMessageForShortVideo.fileType = paramFileMsg.fileType;
          if ((paramFileMsg.fileType != 7) && (paramFileMsg.fileType != 16) && (paramFileMsg.fileType != 18)) {
            localMessageForShortVideo.videoFileProgress = i;
          }
          if ((localMessageForShortVideo.mPreUpload) && (paramFileMsg.status == 1003) && (paramTransferRequest.mMd5 != null)) {
            localMessageForShortVideo.md5 = paramTransferRequest.mMd5;
          }
          if (paramFileMsg.status == 2003) {
            localMessageForShortVideo.lastModified = new File(paramTransferRequest.mOutFilePath).lastModified();
          }
          localMessageForShortVideo.serial();
          if ((localMessageForShortVideo.isMultiMsg != true) && (paramTransferRequest.mBusiType != 1010)) {
            break label497;
          }
          if ((localMessageForShortVideo.videoFileStatus == 1002) || (localMessageForShortVideo.videoFileStatus == 2002)) {
            break;
          }
          paramQQAppInterface = paramQQAppInterface.getMultiMessageProxy();
          if (paramQQAppInterface == null) {
            break;
          }
          paramQQAppInterface.a(localMessageForShortVideo, null);
          return;
        }
      } while ((localMessageForShortVideo instanceof MessageForBlessPTV));
      paramQQAppInterface.getMessageFacade().a(paramTransferRequest.mPeerUin, paramTransferRequest.mUinType, localMessageRecord.uniseq, localMessageForShortVideo.msgData);
    } while ((paramFileMsg.status != 1003) && (paramFileMsg.status != 2003));
    paramQQAppInterface.getMsgHandler().notifyUI(999, true, paramTransferRequest.mPeerUin);
    Logger.a("ShortVideoBusiManager", "updataMessageDataBaseContent", "app.getMsgHandler().notifyUI");
  }
  
  public static void a(ShortVideoReq paramShortVideoReq, QQAppInterface paramQQAppInterface)
  {
    if (paramShortVideoReq == null)
    {
      Logger.b("ShortVideoBusiManager", "launch", "error,req == null");
      return;
    }
    BaseShortVideoOprerator localBaseShortVideoOprerator = a(paramShortVideoReq.jdField_b_of_type_Int, paramQQAppInterface);
    if (localBaseShortVideoOprerator == null)
    {
      Logger.b("ShortVideoBusiManager", "launch", "error,busiInterface == null,req.busiType:" + paramShortVideoReq.jdField_b_of_type_Int);
      return;
    }
    localBaseShortVideoOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    localBaseShortVideoOprerator.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq = paramShortVideoReq;
    localBaseShortVideoOprerator.f = paramShortVideoReq.jdField_a_of_type_JavaLangString;
    localBaseShortVideoOprerator.g = paramShortVideoReq.jdField_b_of_type_JavaLangString;
    localBaseShortVideoOprerator.a(paramShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoUiCallBack);
    Logger.a("ShortVideoBusiManager", "launch", "cmd:" + ShortVideoUtils.getReqCmdStr(paramShortVideoReq.jdField_a_of_type_Int) + ", reqBusiType" + paramShortVideoReq.jdField_b_of_type_Int + ", uuid:" + paramShortVideoReq.jdField_a_of_type_JavaLangString);
    switch (paramShortVideoReq.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      localBaseShortVideoOprerator.a(paramShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo);
      return;
    case 2: 
      localBaseShortVideoOprerator.a(paramShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo);
      return;
    case 1: 
      localBaseShortVideoOprerator.a(paramShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo);
      return;
    case 3: 
      localBaseShortVideoOprerator.a(paramShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoForwardInfo);
      return;
    case 4: 
      localBaseShortVideoOprerator.a(paramShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoForwardInfo);
      return;
    }
    localBaseShortVideoOprerator.a(paramShortVideoReq.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoBusiManager
 * JD-Core Version:    0.7.0.1
 */