package com.tencent.mobileqq.pic.operator;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager;

public class EssencePicOperator
  extends UploadPicOperator
{
  protected TransferRequest a(PicReq paramPicReq, PicUploadInfo paramPicUploadInfo)
  {
    paramPicUploadInfo = super.a(paramPicReq, paramPicUploadInfo);
    if ((paramPicReq != null) && (paramPicUploadInfo != null) && (paramPicUploadInfo.mUinType == 1)) {
      ((TroopEssenceMsgManager)this.a.getManager(QQManagerFactory.TROOP_ESSENCE_MSG_MANAGER)).a(paramPicUploadInfo.mPeerUin, paramPicUploadInfo.mUniseq);
    }
    return paramPicUploadInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.EssencePicOperator
 * JD-Core Version:    0.7.0.1
 */