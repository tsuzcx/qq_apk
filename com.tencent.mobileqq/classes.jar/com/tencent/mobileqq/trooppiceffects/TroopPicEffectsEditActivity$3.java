package com.tencent.mobileqq.trooppiceffects;

import ayeb;
import ayeu;
import bflb;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TransferRequest.PicUpExtraInfo;

class TroopPicEffectsEditActivity$3
  implements Runnable
{
  TroopPicEffectsEditActivity$3(TroopPicEffectsEditActivity paramTroopPicEffectsEditActivity, ayeb paramayeb) {}
  
  public void run()
  {
    this.this$0.app.getHwEngine().preConnect();
    Object localObject = new CompressInfo(this.a.g, 0);
    ((CompressInfo)localObject).f = 0;
    ayeu.a((CompressInfo)localObject);
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mSelfUin = this.this$0.app.getAccount();
    localTransferRequest.mPeerUin = this.this$0.b;
    localTransferRequest.mSecondId = this.this$0.app.getCurrentAccountUin();
    localTransferRequest.mUinType = 1;
    localTransferRequest.mFileType = 1;
    localTransferRequest.mIsUp = true;
    localTransferRequest.mBusiType = this.a.a;
    localTransferRequest.mLocalPath = ((CompressInfo)localObject).e;
    localTransferRequest.mMd5 = this.a.f;
    localObject = new TransferRequest.PicUpExtraInfo();
    localTransferRequest.mExtraObj = localObject;
    ((TransferRequest.PicUpExtraInfo)localObject).mIsRaw = false;
    localTransferRequest.mUpCallBack = new bflb(this.this$0);
    localTransferRequest.mIsPresend = this.a.c;
    localTransferRequest.myPresendInvalid = this.a.e;
    localTransferRequest.mFileType = 55;
    localTransferRequest.mUniseq = System.currentTimeMillis();
    this.this$0.app.getTransFileController().transferAsync(localTransferRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity.3
 * JD-Core Version:    0.7.0.1
 */