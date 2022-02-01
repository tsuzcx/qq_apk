package com.tencent.mobileqq.pic.operator;

import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.pic.api.IDep;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.TransferRequest;

public class EssencePicOperator
  extends UploadPicOperator
{
  protected TransferRequest a(PicReq paramPicReq, PicUploadInfo paramPicUploadInfo)
  {
    paramPicUploadInfo = super.a(paramPicReq, paramPicUploadInfo);
    if ((paramPicReq != null) && (paramPicUploadInfo != null) && (paramPicUploadInfo.mUinType == 1)) {
      ((IDep)QRoute.api(IDep.class)).addWaitingEssenceMsg(paramPicUploadInfo.mPeerUin, paramPicUploadInfo.mUniseq);
    }
    return paramPicUploadInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.EssencePicOperator
 * JD-Core Version:    0.7.0.1
 */