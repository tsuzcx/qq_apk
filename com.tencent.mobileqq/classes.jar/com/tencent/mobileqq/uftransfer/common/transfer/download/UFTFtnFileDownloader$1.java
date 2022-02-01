package com.tencent.mobileqq.uftransfer.common.transfer.download;

import com.tencent.mobileqq.uftransfer.depend.UFTDependFeatureApi;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;

class UFTFtnFileDownloader$1
  implements Runnable
{
  public void run()
  {
    Object localObject;
    if (this.this$0.jdField_a_of_type_Boolean)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.this$0.jdField_a_of_type_Long);
      ((StringBuilder)localObject).append("] download. had stoped");
      UFTLog.c("[UFTTransfer] UFTFtnFileDownloader", 1, ((StringBuilder)localObject).toString());
      return;
    }
    if (this.this$0.b()) {
      return;
    }
    if (!this.this$0.d())
    {
      localObject = this.this$0;
      ((UFTFtnFileDownloader)localObject).a(true, -5001, ((UFTFtnFileDownloader)localObject).c, "file open exception", "", null);
      return;
    }
    if (!UFTDependFeatureApi.a())
    {
      localObject = this.this$0;
      ((UFTFtnFileDownloader)localObject).a(true, 9004, ((UFTFtnFileDownloader)localObject).c, "no network", "", null);
      return;
    }
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferDownloadUFTFtnDownloader == null)
    {
      localObject = this.this$0;
      ((UFTFtnFileDownloader)localObject).a(true, -5004, ((UFTFtnFileDownloader)localObject).c, "create downloader fail", "", null);
      return;
    }
    if (!this.this$0.c())
    {
      localObject = this.this$0;
      ((UFTFtnFileDownloader)localObject).a(true, 9049, ((UFTFtnFileDownloader)localObject).c, "download filedata fail", "", null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.common.transfer.download.UFTFtnFileDownloader.1
 * JD-Core Version:    0.7.0.1
 */