package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.uftransfer.task.UFTBaseOp.OpRetData;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTBaseTaskInfo;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTUploadTaskRunNotesInfo;
import com.tencent.mobileqq.uftransfer.utility.UFTTransferUtility;

class UFTTroopUploadTask$4
  extends UFTBaseUploadFileOp.UFTUploadFileOpCallback
{
  UFTTroopUploadTask$4(UFTTroopUploadTask paramUFTTroopUploadTask) {}
  
  public void a()
  {
    if (!UFTTroopUploadTask.g(this.a)) {
      return;
    }
    UFTBaseUploadFileOp.UploadFileOpRetData localUploadFileOpRetData = new UFTBaseUploadFileOp.UploadFileOpRetData();
    localUploadFileOpRetData.a(-29120);
    localUploadFileOpRetData.a("upload out date");
    this.a.b(localUploadFileOpRetData);
  }
  
  public void a(int paramInt, String paramString1, long paramLong, String paramString2, Object paramObject)
  {
    if ((!UFTTroopUploadTask.e(this.a)) && (paramInt != 0))
    {
      int j = UFTTransferUtility.a(paramString1);
      int i = j;
      if (j == 0) {
        i = UFTTransferUtility.b(paramString2);
      }
      int k = UFTTransferUtility.c(paramString1);
      int m = UFTTroopReportData.a(paramInt, k);
      if (paramInt == 9050) {
        j = 4;
      } else {
        j = 3;
      }
      paramString1 = new UFTTroopUploadTask.UFTToopUploadTaskCompParam(4, paramString1, paramString2, false, paramObject);
      paramString1.a(j, m, 3, paramInt);
      paramString1.a(k);
      paramString1.b(i);
      paramString1.a = this.a.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTTroopUploadFileOp.d();
      paramString1.b = this.a.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTTroopUploadFileOp.e();
      this.a.b(paramLong, paramString1);
    }
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (!UFTTroopUploadTask.f(this.a))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.i(paramLong1);
      this.a.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTUploadCbWrapper.a(UFTTroopUploadTask.c(this.a), UFTTroopUploadTask.a(this.a).b(), paramLong1, paramLong3);
    }
  }
  
  public void a(UFTBaseOp.OpRetData paramOpRetData)
  {
    if (!UFTTroopUploadTask.d(this.a)) {
      this.a.b((UFTBaseUploadFileOp.UploadFileOpRetData)paramOpRetData);
    }
  }
  
  public void a(String paramString)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a(paramString);
    this.a.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.b(this.a.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.b() + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTTroopUploadTask.4
 * JD-Core Version:    0.7.0.1
 */