package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.uftransfer.task.UFTBaseOp.OpRetData;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTBaseTaskInfo;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTUploadTaskRunNotesInfo;

class UFTC2CUploadTask$4
  extends UFTBaseUploadFileOp.UFTUploadFileOpCallback
{
  UFTC2CUploadTask$4(UFTC2CUploadTask paramUFTC2CUploadTask) {}
  
  public void a(int paramInt, String paramString1, long paramLong, String paramString2, Object paramObject)
  {
    if ((!UFTC2CUploadTask.e(this.a)) && (paramInt != 0))
    {
      paramString1 = new UFTUploadTaskCompParam(4, paramString1, paramString2, false, paramObject);
      paramString1.a = this.a.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTC2CUploadFileOp.d();
      paramString1.b = this.a.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTC2CUploadFileOp.e();
      this.a.c(paramLong, paramInt, paramString1);
    }
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (!UFTC2CUploadTask.f(this.a))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.i(paramLong1);
      this.a.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTUploadCbWrapper.a(UFTC2CUploadTask.b(this.a), UFTC2CUploadTask.a(this.a).b(), paramLong1, paramLong3);
    }
  }
  
  public void a(UFTBaseOp.OpRetData paramOpRetData)
  {
    if (!UFTC2CUploadTask.d(this.a)) {
      this.a.a((UFTBaseUploadFileOp.UploadFileOpRetData)paramOpRetData);
    }
  }
  
  public void a(String paramString)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a(paramString);
    this.a.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.b(this.a.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.b() + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTC2CUploadTask.4
 * JD-Core Version:    0.7.0.1
 */