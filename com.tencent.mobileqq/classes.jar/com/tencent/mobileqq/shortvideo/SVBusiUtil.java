package com.tencent.mobileqq.shortvideo;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.MessageForBlessPTV;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.msg.api.IMessageHandler;
import com.tencent.mobileqq.msg.api.IMultiMsgProxy;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class SVBusiUtil
{
  public static long a;
  public static boolean b;
  public static long c;
  
  public static int a(FileMsg paramFileMsg)
  {
    if (paramFileMsg.fileSize == 0L) {
      return 0;
    }
    return (int)(paramFileMsg.transferedSize * 100L / paramFileMsg.fileSize);
  }
  
  public static MessageRecord a(BaseQQAppInterface paramBaseQQAppInterface, TransferRequest paramTransferRequest)
  {
    if (paramTransferRequest.mRec != null) {
      return paramTransferRequest.mRec;
    }
    paramBaseQQAppInterface = ((IMessageFacade)paramBaseQQAppInterface.getRuntimeService(IMessageFacade.class)).getMsgItemByUniseq(paramTransferRequest.mPeerUin, paramTransferRequest.mUinType, paramTransferRequest.mUniseq);
    Logger.a("SVBusiUtil", "updataMessageDataBaseContent", "findmsgbyMsgId,need fix");
    return paramBaseQQAppInterface;
  }
  
  public static ShortVideoReq a(int paramInt1, int paramInt2)
  {
    ShortVideoReq localShortVideoReq = new ShortVideoReq();
    localShortVideoReq.a = paramInt1;
    localShortVideoReq.b = paramInt2;
    return localShortVideoReq;
  }
  
  public static ShortVideoReq a(BaseQQAppInterface paramBaseQQAppInterface, MessageForShortVideo paramMessageForShortVideo, int paramInt)
  {
    if (paramMessageForShortVideo.videoFileStatus == 5002)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SVBusiUtil", 2, "createShortVideoReqByMsg expired");
      }
      return null;
    }
    ShortVideoReq localShortVideoReq = a(2, paramMessageForShortVideo.busiType);
    ShortVideoDownloadInfo localShortVideoDownloadInfo = paramMessageForShortVideo.getDownloadInfo(localShortVideoReq.b);
    localShortVideoDownloadInfo.o = SVUtils.a(paramMessageForShortVideo, "mp4");
    localShortVideoDownloadInfo.r = paramInt;
    if (paramMessageForShortVideo.busiType == 0) {
      localShortVideoDownloadInfo.t = true;
    }
    paramBaseQQAppInterface = (IMessageFacade)paramBaseQQAppInterface.getRuntimeService(IMessageFacade.class);
    if ((paramBaseQQAppInterface.isChatting()) && (paramBaseQQAppInterface.getCurrChatUin().equals(paramMessageForShortVideo.frienduin))) {
      localShortVideoDownloadInfo.s = 2;
    } else {
      localShortVideoDownloadInfo.s = 1;
    }
    if ((paramMessageForShortVideo.istroop != 0) && (paramMessageForShortVideo.istroop != 1008))
    {
      if (paramMessageForShortVideo.istroop == 3000) {
        localShortVideoDownloadInfo.q = 1005;
      } else if (paramMessageForShortVideo.istroop == 1) {
        localShortVideoDownloadInfo.q = 1003;
      } else if (paramMessageForShortVideo.istroop == 10014) {
        localShortVideoDownloadInfo.q = 1003;
      }
    }
    else {
      localShortVideoDownloadInfo.q = 1001;
    }
    localShortVideoReq.a(localShortVideoDownloadInfo);
    localShortVideoReq.a(paramMessageForShortVideo);
    return localShortVideoReq;
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, FileMsg paramFileMsg, TransferRequest paramTransferRequest)
  {
    if ((paramFileMsg != null) && (paramTransferRequest != null))
    {
      MessageRecord localMessageRecord = a(paramBaseQQAppInterface, paramTransferRequest);
      if (localMessageRecord == null)
      {
        Logger.b("SVBusiUtil", "updataMessageDataBaseContent", "msg null");
        return;
      }
      if ((localMessageRecord instanceof MessageForShortVideo))
      {
        MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)localMessageRecord;
        int i = a(paramFileMsg);
        if (localMessageForShortVideo.videoFileProgress < 0) {
          localMessageForShortVideo.videoFileProgress = 0;
        }
        if (!a(paramFileMsg, localMessageForShortVideo, i, localMessageForShortVideo.videoFileProgress)) {
          return;
        }
        if (localMessageForShortVideo.videoFileStatus == 1003) {
          localMessageForShortVideo.videoFileProgress = 100;
        }
        b(paramFileMsg, localMessageForShortVideo);
        if (a(paramFileMsg, localMessageForShortVideo)) {
          return;
        }
        localMessageForShortVideo.videoFileStatus = paramFileMsg.status;
        localMessageForShortVideo.fileType = paramFileMsg.fileType;
        a(paramFileMsg, localMessageForShortVideo, i);
        a(paramFileMsg, paramTransferRequest, localMessageForShortVideo);
        if (paramFileMsg.status == 2003) {
          localMessageForShortVideo.lastModified = new File(paramTransferRequest.mOutFilePath).lastModified();
        }
        localMessageForShortVideo.serial();
        if ((localMessageForShortVideo.isMultiMsg != true) && (paramTransferRequest.mBusiType != 1010))
        {
          if (!(localMessageForShortVideo instanceof MessageForBlessPTV))
          {
            ((IMessageFacade)paramBaseQQAppInterface.getRuntimeService(IMessageFacade.class)).updateMsgContentByUniseq(paramTransferRequest.mPeerUin, paramTransferRequest.mUinType, localMessageRecord.uniseq, localMessageForShortVideo.msgData);
            if ((paramFileMsg.status == 1003) || (paramFileMsg.status == 2003))
            {
              ((IMessageHandler)paramBaseQQAppInterface.getRuntimeService(IMessageHandler.class, "")).notifyUI(paramBaseQQAppInterface, 999, true, paramTransferRequest.mPeerUin);
              Logger.a("SVBusiUtil", "updataMessageDataBaseContent", "app.getMsgHandler().notifyUI");
            }
          }
        }
        else if ((localMessageForShortVideo.videoFileStatus != 1002) && (localMessageForShortVideo.videoFileStatus != 2002)) {
          ((IMultiMsgProxy)QRoute.api(IMultiMsgProxy.class)).updateMultiMsg(paramBaseQQAppInterface, localMessageForShortVideo);
        }
      }
      return;
    }
    Logger.b("SVBusiUtil", "updataMessageDataBaseContent", "fileMsg or req is null");
  }
  
  public static void a(FileMsg paramFileMsg, MessageForShortVideo paramMessageForShortVideo, int paramInt)
  {
    if ((paramFileMsg.fileType != 7) && (paramFileMsg.fileType != 16) && (paramFileMsg.fileType != 18)) {
      paramMessageForShortVideo.videoFileProgress = paramInt;
    }
  }
  
  public static void a(FileMsg paramFileMsg, TransferRequest paramTransferRequest, MessageForShortVideo paramMessageForShortVideo)
  {
    if ((paramMessageForShortVideo.mPreUpload) && (paramFileMsg.status == 1003) && (paramTransferRequest.mMd5 != null)) {
      paramMessageForShortVideo.md5 = paramTransferRequest.mMd5;
    }
  }
  
  public static boolean a(FileMsg paramFileMsg, MessageForShortVideo paramMessageForShortVideo)
  {
    return ((paramMessageForShortVideo.videoFileStatus == 2004) || (paramMessageForShortVideo.videoFileStatus == 1004)) && ((paramFileMsg.status == 1002) || (paramFileMsg.status == 2002));
  }
  
  public static boolean a(FileMsg paramFileMsg, MessageForShortVideo paramMessageForShortVideo, int paramInt1, int paramInt2)
  {
    return ((paramMessageForShortVideo.videoFileStatus != 1002) && (paramMessageForShortVideo.videoFileStatus != 2002)) || (paramMessageForShortVideo.videoFileStatus != paramFileMsg.status) || (paramInt1 - paramInt2 >= 10);
  }
  
  public static void b(FileMsg paramFileMsg, MessageForShortVideo paramMessageForShortVideo)
  {
    if ((paramFileMsg.fileType == 6) || (paramFileMsg.fileType == 17) || (paramFileMsg.fileType == 9) || (paramFileMsg.fileType == 20) || (paramFileMsg.fileType == 67))
    {
      if (paramFileMsg.status == 2002) {
        paramMessageForShortVideo.transferedSize = ((int)paramFileMsg.transferedSize);
      }
      if (paramFileMsg.status == 2003) {
        paramMessageForShortVideo.transferedSize = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.SVBusiUtil
 * JD-Core Version:    0.7.0.1
 */