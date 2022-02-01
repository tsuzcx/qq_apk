package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import com.tencent.mobileqq.uftransfer.proto.UFTProtoRequestor.C2CSetUploadSucResponseCallback;
import com.tencent.mobileqq.uftransfer.task.UFTBaseOp.OpRetData;

class UFTC2CSetUploadSucOp$1
  implements UFTProtoRequestor.C2CSetUploadSucResponseCallback
{
  UFTC2CSetUploadSucOp$1(UFTC2CSetUploadSucOp paramUFTC2CSetUploadSucOp) {}
  
  public void a(boolean paramBoolean, int paramInt, String paramString)
  {
    if (UFTC2CSetUploadSucOp.a(this.a)) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(this.a.i());
    ((StringBuilder)localObject).append("] on set upload suc result. reqSuc:");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(" errCode:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" errmsg:");
    ((StringBuilder)localObject).append(paramString);
    UFTLog.b("[UFTTransfer] UFTC2CSetUploadSucOp", 1, ((StringBuilder)localObject).toString());
    localObject = new UFTBaseOp.OpRetData();
    ((UFTBaseOp.OpRetData)localObject).a(paramInt);
    ((UFTBaseOp.OpRetData)localObject).a(paramString);
    UFTC2CSetUploadSucOp.a(this.a, (UFTBaseOp.OpRetData)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTC2CSetUploadSucOp.1
 * JD-Core Version:    0.7.0.1
 */