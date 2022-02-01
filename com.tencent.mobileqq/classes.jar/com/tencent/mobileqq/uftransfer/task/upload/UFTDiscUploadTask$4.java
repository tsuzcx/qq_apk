package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.uftransfer.task.UFTBaseOp.OpRetData;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTBaseTaskInfo;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTUploadTaskRunNotesInfo;

class UFTDiscUploadTask$4
  extends UFTBaseUploadFileOp.UFTUploadFileOpCallback
{
  UFTDiscUploadTask$4(UFTDiscUploadTask paramUFTDiscUploadTask) {}
  
  public void a(int paramInt, String paramString1, long paramLong, String paramString2, Object paramObject)
  {
    if ((!UFTDiscUploadTask.e(this.a)) && (paramInt != 0)) {
      this.a.b(paramLong, paramInt, paramString1, paramString2);
    }
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (!UFTDiscUploadTask.f(this.a))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.i(paramLong1);
      this.a.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTUploadCbWrapper.a(UFTDiscUploadTask.b(this.a), UFTDiscUploadTask.a(this.a).b(), paramLong1, paramLong3);
    }
  }
  
  public void a(UFTBaseOp.OpRetData paramOpRetData)
  {
    if (!UFTDiscUploadTask.d(this.a))
    {
      paramOpRetData = (UFTBaseUploadFileOp.UploadFileOpRetData)paramOpRetData;
      this.a.a(paramOpRetData.a(), paramOpRetData.a(), paramOpRetData.a(), paramOpRetData.c());
    }
  }
  
  public void a(String paramString)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a(paramString);
    this.a.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.b(this.a.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.b() + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTDiscUploadTask.4
 * JD-Core Version:    0.7.0.1
 */