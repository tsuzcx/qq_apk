package com.tencent.mobileqq.shortvideo;

import com.tencent.device.file.DevLittleVideoOperator;
import com.tencent.device.file.DevShortVideoOperator;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.app.message.QQMessageFacade;
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
    localShortVideoDownloadInfo.h = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    localShortVideoDownloadInfo.f = paramInt;
    if (paramMessageForShortVideo.busiType == 0) {
      localShortVideoDownloadInfo.a = true;
    }
    paramQQAppInterface = paramQQAppInterface.a();
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
    label479:
    do
    {
      MessageRecord localMessageRecord;
      MessageForShortVideo localMessageForShortVideo;
      do
      {
        do
        {
          return;
          if (paramTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
            localMessageRecord = paramTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
          }
          while (localMessageRecord == null)
          {
            Logger.b("ShortVideoBusiManager", "updataMessageDataBaseContent", "msg null");
            return;
            localMessageRecord = paramQQAppInterface.a().a(paramTransferRequest.c, paramTransferRequest.jdField_a_of_type_Int, paramTransferRequest.jdField_a_of_type_Long);
            Logger.a("ShortVideoBusiManager", "updataMessageDataBaseContent", "findmsgbyMsgId,need fix");
          }
        } while (!(localMessageRecord instanceof MessageForShortVideo));
        localMessageForShortVideo = (MessageForShortVideo)localMessageRecord;
        if (paramFileMsg.jdField_a_of_type_Long == 0L) {}
        for (int i = 0;; i = (int)(100L * paramFileMsg.e / paramFileMsg.jdField_a_of_type_Long))
        {
          if (localMessageForShortVideo.videoFileProgress < 0) {
            localMessageForShortVideo.videoFileProgress = 0;
          }
          int j = localMessageForShortVideo.videoFileProgress;
          if (((localMessageForShortVideo.videoFileStatus == 1002) || (localMessageForShortVideo.videoFileStatus == 2002)) && (localMessageForShortVideo.videoFileStatus == paramFileMsg.d) && (i - j < 10)) {
            break;
          }
          if ((paramFileMsg.jdField_b_of_type_Int == 6) || (paramFileMsg.jdField_b_of_type_Int == 17) || (paramFileMsg.jdField_b_of_type_Int == 9) || (paramFileMsg.jdField_b_of_type_Int == 20))
          {
            if (paramFileMsg.d == 2002) {
              localMessageForShortVideo.transferedSize = ((int)paramFileMsg.e);
            }
            if (paramFileMsg.d == 2003) {
              localMessageForShortVideo.transferedSize = 0;
            }
          }
          if (((localMessageForShortVideo.videoFileStatus == 2004) || (localMessageForShortVideo.videoFileStatus == 1004)) && ((paramFileMsg.d == 1002) || (paramFileMsg.d == 2002))) {
            break;
          }
          localMessageForShortVideo.videoFileStatus = paramFileMsg.d;
          localMessageForShortVideo.fileType = paramFileMsg.jdField_b_of_type_Int;
          if ((paramFileMsg.jdField_b_of_type_Int != 7) && (paramFileMsg.jdField_b_of_type_Int != 16) && (paramFileMsg.jdField_b_of_type_Int != 18)) {
            localMessageForShortVideo.videoFileProgress = i;
          }
          if ((localMessageForShortVideo.mPreUpload) && (paramFileMsg.d == 1003) && (paramTransferRequest.f != null)) {
            localMessageForShortVideo.md5 = paramTransferRequest.f;
          }
          if (paramFileMsg.d == 2003) {
            localMessageForShortVideo.lastModified = new File(paramTransferRequest.h).lastModified();
          }
          localMessageForShortVideo.serial();
          if ((localMessageForShortVideo.isMultiMsg != true) && (paramTransferRequest.e != 1010)) {
            break label479;
          }
          if ((localMessageForShortVideo.videoFileStatus == 1002) || (localMessageForShortVideo.videoFileStatus == 2002)) {
            break;
          }
          paramQQAppInterface = paramQQAppInterface.a();
          if (paramQQAppInterface == null) {
            break;
          }
          paramQQAppInterface.a(localMessageForShortVideo, null);
          return;
        }
      } while ((localMessageForShortVideo instanceof MessageForBlessPTV));
      paramQQAppInterface.a().a(paramTransferRequest.c, paramTransferRequest.jdField_a_of_type_Int, localMessageRecord.uniseq, localMessageForShortVideo.msgData);
    } while ((paramFileMsg.d != 1003) && (paramFileMsg.d != 2003));
    paramQQAppInterface.a().a(999, true, paramTransferRequest.c);
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
    Logger.a("ShortVideoBusiManager", "launch", "cmd:" + ShortVideoUtils.c(paramShortVideoReq.jdField_a_of_type_Int) + ", reqBusiType" + paramShortVideoReq.jdField_b_of_type_Int + ", uuid:" + paramShortVideoReq.jdField_a_of_type_JavaLangString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoBusiManager
 * JD-Core Version:    0.7.0.1
 */