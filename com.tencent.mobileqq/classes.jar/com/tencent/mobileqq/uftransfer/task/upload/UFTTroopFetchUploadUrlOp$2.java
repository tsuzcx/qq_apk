package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.uftransfer.proto.UFTProtoRequestor.TroopReqUploadResponseCallback;
import com.tencent.mobileqq.uftransfer.proto.UFTTroopUploadRsp;

class UFTTroopFetchUploadUrlOp$2
  implements UFTProtoRequestor.TroopReqUploadResponseCallback
{
  UFTTroopFetchUploadUrlOp$2(UFTTroopFetchUploadUrlOp paramUFTTroopFetchUploadUrlOp) {}
  
  public void a(boolean paramBoolean, UFTTroopUploadRsp paramUFTTroopUploadRsp)
  {
    if (UFTTroopFetchUploadUrlOp.b(this.a)) {
      return;
    }
    this.a.a(paramBoolean, paramUFTTroopUploadRsp, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTTroopFetchUploadUrlOp.2
 * JD-Core Version:    0.7.0.1
 */