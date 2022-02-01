package com.tencent.mobileqq.qwallet.hb.grap.draw.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.msg.api.IMessageRecordFactory;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;

public class ScribbleBaseOperator
{
  public BaseQQAppInterface a;
  
  public ScribbleBaseOperator(BaseQQAppInterface paramBaseQQAppInterface)
  {
    this.a = paramBaseQQAppInterface;
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
  
  public boolean a(MessageForScribble paramMessageForScribble)
  {
    ThreadManager.post(new ScribbleBaseOperator.1(this, paramMessageForScribble), 8, null, false);
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
    ((ITransFileController)this.a.getRuntimeService(ITransFileController.class)).transferAsync(localTransferRequest);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.draw.impl.ScribbleBaseOperator
 * JD-Core Version:    0.7.0.1
 */