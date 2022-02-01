package com.tencent.mobileqq.scribble;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.msg.api.IMessageRecordFactory;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class ScribbleBaseOperator
{
  public AppRuntime a;
  
  public ScribbleBaseOperator(AppRuntime paramAppRuntime)
  {
    this.a = paramAppRuntime;
  }
  
  public MessageForScribble a(MessageForScribble paramMessageForScribble)
  {
    MessageForScribble localMessageForScribble = (MessageForScribble)((IMessageRecordFactory)QRoute.api(IMessageRecordFactory.class)).createResendMsg(paramMessageForScribble);
    if (localMessageForScribble == null) {
      QLog.e("CreateResendScribbleMsg", 2, "null msg");
    }
    if (localMessageForScribble != null)
    {
      localMessageForScribble.offSet = paramMessageForScribble.offSet;
      localMessageForScribble.gifId = paramMessageForScribble.gifId;
      localMessageForScribble.localFildPath = paramMessageForScribble.localFildPath;
      localMessageForScribble.combineFileMd5 = paramMessageForScribble.combineFileMd5;
      localMessageForScribble.isread = true;
      localMessageForScribble.fileUploadStatus = 0;
    }
    return localMessageForScribble;
  }
  
  public MessageForScribble a(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, int paramInt3)
  {
    MessageForScribble localMessageForScribble = (MessageForScribble)((IMessageRecordFactory)QRoute.api(IMessageRecordFactory.class)).createMsgRecordByMsgType(-7001);
    ((IMessageRecordFactory)QRoute.api(IMessageRecordFactory.class)).setSendingMsgRecordBaseInfo(this.a, localMessageForScribble, paramString3, paramString3, paramInt2);
    localMessageForScribble.msgtype = -7001;
    localMessageForScribble.offSet = paramInt1;
    localMessageForScribble.gifId = paramInt3;
    localMessageForScribble.localFildPath = paramString1;
    localMessageForScribble.combineFileMd5 = paramString2;
    localMessageForScribble.selfuin = this.a.getCurrentAccountUin();
    localMessageForScribble.senderuin = localMessageForScribble.selfuin;
    localMessageForScribble.issend = 1;
    localMessageForScribble.fileUploadStatus = 0;
    return localMessageForScribble;
  }
  
  public boolean a(MessageForScribble paramMessageForScribble, DownCallBack paramDownCallBack)
  {
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mIsUp = false;
    localTransferRequest.mFileType = 262153;
    localTransferRequest.mSelfUin = paramMessageForScribble.selfuin;
    localTransferRequest.mPeerUin = paramMessageForScribble.frienduin;
    localTransferRequest.mUinType = paramMessageForScribble.istroop;
    localTransferRequest.mUniseq = paramMessageForScribble.uniseq;
    localTransferRequest.mDownCallBack = paramDownCallBack;
    localTransferRequest.mRec = paramMessageForScribble;
    ((ITransFileController)this.a.getRuntimeService(ITransFileController.class, "")).transferAsync(localTransferRequest);
    return true;
  }
  
  public boolean a(MessageForScribble paramMessageForScribble, String paramString, UpCallBack paramUpCallBack)
  {
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mIsUp = true;
    localTransferRequest.mFileType = 262153;
    localTransferRequest.mSelfUin = paramMessageForScribble.selfuin;
    localTransferRequest.mPeerUin = paramMessageForScribble.frienduin;
    localTransferRequest.mUinType = paramMessageForScribble.istroop;
    localTransferRequest.mUniseq = paramMessageForScribble.uniseq;
    localTransferRequest.mUpCallBack = paramUpCallBack;
    localTransferRequest.mLocalPath = paramString;
    localTransferRequest.mRec = paramMessageForScribble;
    paramMessageForScribble.fileUploadStatus = 3;
    ((ITransFileController)this.a.getRuntimeService(ITransFileController.class, "")).transferAsync(localTransferRequest);
    return true;
  }
  
  public boolean b(MessageForScribble paramMessageForScribble)
  {
    ThreadManager.post(new ScribbleBaseOperator.1(this, paramMessageForScribble), 8, null, false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.scribble.ScribbleBaseOperator
 * JD-Core Version:    0.7.0.1
 */