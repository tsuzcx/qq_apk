package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.uftransfer.proto.UFTDiscUploadRsp;
import com.tencent.mobileqq.uftransfer.proto.UFTProtoRequestor.DiscReqUploadResponseCallback;

class UFTDiscFetchUploadUrlOp$1
  implements UFTProtoRequestor.DiscReqUploadResponseCallback
{
  UFTDiscFetchUploadUrlOp$1(UFTDiscFetchUploadUrlOp paramUFTDiscFetchUploadUrlOp) {}
  
  public void a(boolean paramBoolean, UFTDiscUploadRsp paramUFTDiscUploadRsp)
  {
    if (UFTDiscFetchUploadUrlOp.a(this.a)) {
      return;
    }
    this.a.a(paramBoolean, paramUFTDiscUploadRsp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTDiscFetchUploadUrlOp.1
 * JD-Core Version:    0.7.0.1
 */