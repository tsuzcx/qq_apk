package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import yqg;
import yqi;

class ArtFilterUploadProcessor$1
  implements ITransactionCallback
{
  ArtFilterUploadProcessor$1(ArtFilterUploadProcessor paramArtFilterUploadProcessor) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    this.this$0.endOringinnalPicTime = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterUploadProcessor", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (this.this$0.endOringinnalPicTime - this.this$0.startOringinPicTime) + "ms");
    }
    this.this$0.file.bdhExtendInfo = paramArrayOfByte;
    if (this.this$0.styleId != -1) {
      this.this$0.returnResult(paramInt, "uploadImgError");
    }
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    this.this$0.endOringinnalPicTime = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterUploadProcessor", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (this.this$0.endOringinnalPicTime - this.this$0.startOringinPicTime) + "ms ,fileSize:" + this.this$0.mFileSize);
    }
    if (this.this$0.artFilterModule.b.equals(this.this$0.mFilterUploadInfo.a))
    {
      this.this$0.artFilterModule.a = this.this$0.endOringinnalPicTime;
      if (this.this$0.styleId != -1) {
        this.this$0.sendFilterToBDHServer();
      }
    }
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart() {}
  
  public void onUpdateProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ArtFilterUploadProcessor.1
 * JD-Core Version:    0.7.0.1
 */