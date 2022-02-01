package com.tencent.mobileqq.troop.filemanager.thumbnail;

import android.text.TextUtils;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.troop.utils.TroopTechReportUtils.TroopFileReportResultCode;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;

class TroopFileThumbnailFetchWorker$1
  implements Runnable
{
  TroopFileThumbnailFetchWorker$1(TroopFileThumbnailFetchWorker paramTroopFileThumbnailFetchWorker) {}
  
  public void run()
  {
    int i;
    if (this.this$0.d)
    {
      i = TroopFileTransferUtil.Log.b;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.this$0.c);
      ((StringBuilder)localObject).append("] start. had stoped");
      TroopFileTransferUtil.Log.b("TroopFileDownloadWorker", i, ((StringBuilder)localObject).toString());
      return;
    }
    this.this$0.f();
    Object localObject = this.this$0;
    ((TroopFileThumbnailFetchWorker)localObject).j = ((TroopFileThumbnailFetchWorker)localObject).b.getThumbnailFile(this.this$0.a, this.this$0.k);
    localObject = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.this$0.j);
    localStringBuilder.append(".ttmp");
    ((TroopFileThumbnailFetchWorker)localObject).i = localStringBuilder.toString();
    if (FileUtils.fileExistsAndNotEmpty(this.this$0.j))
    {
      i = TroopFileTransferUtil.Log.b;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.this$0.c);
      ((StringBuilder)localObject).append("] thumb had exsited");
      TroopFileTransferUtil.Log.b("TroopFileDownloadWorker", i, ((StringBuilder)localObject).toString());
      this.this$0.a(true);
      return;
    }
    if (!NetworkUtil.isNetworkAvailable(BaseApplication.getContext()))
    {
      i = TroopFileTransferUtil.Log.b;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.this$0.c);
      ((StringBuilder)localObject).append("] no network");
      TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", i, ((StringBuilder)localObject).toString());
      this.this$0.c(TroopTechReportUtils.TroopFileReportResultCode.k);
      return;
    }
    if (TextUtils.isEmpty(this.this$0.b.FilePath))
    {
      i = TroopFileTransferUtil.Log.b;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.this$0.c);
      ((StringBuilder)localObject).append("] filepath is null");
      TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", i, ((StringBuilder)localObject).toString());
      this.this$0.c(TroopTechReportUtils.TroopFileReportResultCode.w);
      return;
    }
    this.this$0.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailFetchWorker.1
 * JD-Core Version:    0.7.0.1
 */