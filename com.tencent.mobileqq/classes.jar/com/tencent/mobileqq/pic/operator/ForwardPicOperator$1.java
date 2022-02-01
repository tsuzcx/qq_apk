package com.tencent.mobileqq.pic.operator;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicFowardInfo;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TransferRequest.PicUpExtraInfo;
import com.tencent.mobileqq.transfile.api.ITransFileController;

class ForwardPicOperator$1
  implements Runnable
{
  ForwardPicOperator$1(ForwardPicOperator paramForwardPicOperator, PicFowardInfo paramPicFowardInfo, PicReq paramPicReq) {}
  
  public void run()
  {
    Logger.a(this.this$0.b, this.this$0.a, "doFastForward", "start");
    if (this.this$0.i == null)
    {
      this.a.a("doFastForward", "rec==null");
      this.this$0.a(4, this.a.H);
      return;
    }
    Object localObject1 = (MessageForPic)this.this$0.i;
    ((MessageForPic)localObject1).path = this.a.b.n;
    ForwardPicOperator.a(this.this$0, this.b, ((MessageForPic)localObject1).uniseq);
    if (this.b.i != null) {
      ((MessageForPic)localObject1).picExtraData = this.b.i;
    }
    Object localObject2 = ((MessageForPic)localObject1).path;
    boolean bool = false;
    localObject2 = new CompressInfo((String)localObject2, 0);
    ((ICompressOperator)QRoute.api(ICompressOperator.class)).startThumbnail((CompressInfo)localObject2);
    if (((CompressInfo)localObject2).l != null)
    {
      ((MessageForPic)localObject1).thumbMsgUrl = ((CompressInfo)localObject2).l;
      ((MessageForPic)localObject1).thumbWidth = ((CompressInfo)localObject2).m;
      ((MessageForPic)localObject1).thumbHeight = ((CompressInfo)localObject2).n;
    }
    ((MessageForPic)localObject1).serial();
    ((IMessageFacade)this.this$0.e.getRuntimeService(IMessageFacade.class, "")).updateMsgContentByUniseq(((MessageForPic)localObject1).frienduin, ((MessageForPic)localObject1).istroop, ((MessageForPic)localObject1).uniseq, ((MessageForPic)localObject1).msgData);
    localObject1 = new TransferRequest();
    ((TransferRequest)localObject1).mSelfUin = this.this$0.e.getAccount();
    ((TransferRequest)localObject1).mPeerUin = this.this$0.i.frienduin;
    ((TransferRequest)localObject1).mSecondId = this.this$0.i.senderuin;
    ((TransferRequest)localObject1).mUinType = this.this$0.i.istroop;
    ((TransferRequest)localObject1).mFileType = 1;
    ((TransferRequest)localObject1).mUniseq = this.this$0.i.uniseq;
    ((TransferRequest)localObject1).mIsUp = true;
    ((TransferRequest)localObject1).mBusiType = this.a.b.b;
    ((TransferRequest)localObject1).mLocalPath = this.a.b.n;
    localObject2 = new TransferRequest.PicUpExtraInfo();
    if (this.a.b.F == 1) {
      bool = true;
    }
    ((TransferRequest.PicUpExtraInfo)localObject2).mIsRaw = bool;
    ((TransferRequest)localObject1).mExtraObj = localObject2;
    ((TransferRequest)localObject1).mUpCallBack = this.this$0;
    ((TransferRequest)localObject1).mIsFastForward = true;
    if ((this.a.b.m != null) && (this.a.b.C != 0) && (this.a.b.D != 0) && (this.a.b.E != 0L))
    {
      ((TransferRequest)localObject1).mMd5 = this.a.b.m;
      Logger.a(this.this$0.b, this.this$0.a, "doFastForward", " Get width/height/filesize from UploadInfo");
      ((TransferRequest)localObject1).mFastForwardWidth = this.a.b.C;
      ((TransferRequest)localObject1).mFastForwardHeight = this.a.b.D;
      ((TransferRequest)localObject1).mFastForwardFileSize = this.a.b.E;
      localObject2 = (ITransFileController)this.this$0.e.getRuntimeService(ITransFileController.class, "");
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(((TransferRequest)localObject1).mPeerUin);
      ((StringBuilder)localObject3).append(((TransferRequest)localObject1).mUniseq);
      ((ITransFileController)localObject2).removeProcessor(((StringBuilder)localObject3).toString());
      ((ITransFileController)localObject2).transferAsync((TransferRequest)localObject1);
      localObject2 = this.this$0;
      ((ForwardPicOperator)localObject2).a(((ForwardPicOperator)localObject2).i, this.a.b.T);
      localObject2 = this.this$0.b;
      localObject3 = this.this$0.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("end, req.mFastForwardWidth = ");
      localStringBuilder.append(((TransferRequest)localObject1).mFastForwardWidth);
      localStringBuilder.append(",req.mFastForwardHeight = ");
      localStringBuilder.append(((TransferRequest)localObject1).mFastForwardHeight);
      Logger.a((String)localObject2, (String)localObject3, "doFastForward", localStringBuilder.toString());
      return;
    }
    this.a.a("doFastForward", "upInfo uncomplete!");
    this.this$0.a(4, this.a.H);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.ForwardPicOperator.1
 * JD-Core Version:    0.7.0.1
 */