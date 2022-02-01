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
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TransferRequest.PicUpExtraInfo;
import com.tencent.mobileqq.transfile.api.ITransFileController;

class ForwardPicOperator$2
  implements Runnable
{
  ForwardPicOperator$2(ForwardPicOperator paramForwardPicOperator, PicReq paramPicReq) {}
  
  public void run()
  {
    PicFowardInfo localPicFowardInfo = this.a.h;
    Logger.a(this.this$0.b, this.this$0.a, "doForward", "start");
    if (this.this$0.i == null)
    {
      localPicFowardInfo.a("doForward", "rec==null");
      this.this$0.a(4, localPicFowardInfo.H);
      return;
    }
    Object localObject2 = (MessageForPic)this.this$0.i;
    ((MessageForPic)localObject2).path = localPicFowardInfo.b.n;
    ForwardPicOperator.a(this.this$0, this.a, ((MessageForPic)localObject2).uniseq);
    if (this.a.i != null) {
      ((MessageForPic)localObject2).picExtraData = this.a.i;
    }
    Object localObject1 = new CompressInfo(((MessageForPic)localObject2).path, 0);
    ((ICompressOperator)QRoute.api(ICompressOperator.class)).startThumbnail((CompressInfo)localObject1);
    if (((CompressInfo)localObject1).l != null)
    {
      ((MessageForPic)localObject2).thumbMsgUrl = ((CompressInfo)localObject1).l;
      ((MessageForPic)localObject2).thumbWidth = ((CompressInfo)localObject1).m;
      ((MessageForPic)localObject2).thumbHeight = ((CompressInfo)localObject1).n;
    }
    ((MessageForPic)localObject2).serial();
    ((IMessageFacade)this.this$0.e.getRuntimeService(IMessageFacade.class, "")).updateMsgContentByUniseq(((MessageForPic)localObject2).frienduin, ((MessageForPic)localObject2).istroop, ((MessageForPic)localObject2).uniseq, ((MessageForPic)localObject2).msgData);
    localObject1 = new TransferRequest();
    ((TransferRequest)localObject1).mSelfUin = this.this$0.e.getAccount();
    ((TransferRequest)localObject1).mPeerUin = this.this$0.i.frienduin;
    ((TransferRequest)localObject1).mSecondId = this.this$0.i.senderuin;
    ((TransferRequest)localObject1).mUinType = this.this$0.i.istroop;
    boolean bool = true;
    ((TransferRequest)localObject1).mFileType = 1;
    ((TransferRequest)localObject1).mUniseq = this.this$0.i.uniseq;
    ((TransferRequest)localObject1).mIsUp = true;
    ((TransferRequest)localObject1).mBusiType = localPicFowardInfo.b.b;
    ((TransferRequest)localObject1).mLocalPath = localPicFowardInfo.b.n;
    Object localObject3 = new TransferRequest.PicUpExtraInfo();
    if (localPicFowardInfo.b.F != 1) {
      bool = false;
    }
    ((TransferRequest.PicUpExtraInfo)localObject3).mIsRaw = bool;
    ((TransferRequest)localObject1).mRec = ((MessageRecord)localObject2);
    ((TransferRequest)localObject1).mExtraObj = localObject3;
    localObject2 = this.this$0;
    ((TransferRequest)localObject1).mUpCallBack = ((UpCallBack)localObject2);
    localObject2 = (ITransFileController)((ForwardPicOperator)localObject2).e.getRuntimeService(ITransFileController.class, "");
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(((TransferRequest)localObject1).mPeerUin);
    ((StringBuilder)localObject3).append(((TransferRequest)localObject1).mUniseq);
    ((ITransFileController)localObject2).removeProcessor(((StringBuilder)localObject3).toString());
    ((ITransFileController)localObject2).transferAsync((TransferRequest)localObject1);
    localObject1 = this.this$0;
    ((ForwardPicOperator)localObject1).a(((ForwardPicOperator)localObject1).i, localPicFowardInfo.b.T);
    Logger.a(this.this$0.b, this.this$0.a, "doForward", "end");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.ForwardPicOperator.2
 * JD-Core Version:    0.7.0.1
 */