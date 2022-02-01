package com.tencent.mobileqq.trooppiceffects;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TransferRequest.PicUpExtraInfo;
import com.tencent.mobileqq.transfile.api.ITransFileController;

class TroopPicEffectsEditActivity$3
  implements Runnable
{
  TroopPicEffectsEditActivity$3(TroopPicEffectsEditActivity paramTroopPicEffectsEditActivity, PicUploadInfo paramPicUploadInfo) {}
  
  public void run()
  {
    this.this$0.app.getHwEngine().preConnect();
    Object localObject = new CompressInfo(this.a.n, 0);
    ((CompressInfo)localObject).o = 0;
    ((ICompressOperator)QRoute.api(ICompressOperator.class)).start((CompressInfo)localObject);
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mSelfUin = this.this$0.app.getAccount();
    localTransferRequest.mPeerUin = this.this$0.g;
    localTransferRequest.mSecondId = this.this$0.app.getCurrentAccountUin();
    localTransferRequest.mUinType = 1;
    localTransferRequest.mFileType = 1;
    localTransferRequest.mIsUp = true;
    localTransferRequest.mBusiType = this.a.b;
    localTransferRequest.mLocalPath = ((CompressInfo)localObject).l;
    localTransferRequest.mMd5 = this.a.m;
    localObject = new TransferRequest.PicUpExtraInfo();
    localTransferRequest.mExtraObj = localObject;
    ((TransferRequest.PicUpExtraInfo)localObject).mIsRaw = false;
    localTransferRequest.mUpCallBack = new TroopPicEffectsEditActivity.UploadPicCallback(this.this$0);
    localTransferRequest.mIsPresend = this.a.w;
    localTransferRequest.myPresendInvalid = this.a.y;
    localTransferRequest.mFileType = 55;
    localTransferRequest.mUniseq = System.currentTimeMillis();
    ((ITransFileController)this.this$0.app.getRuntimeService(ITransFileController.class)).transferAsync(localTransferRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity.3
 * JD-Core Version:    0.7.0.1
 */