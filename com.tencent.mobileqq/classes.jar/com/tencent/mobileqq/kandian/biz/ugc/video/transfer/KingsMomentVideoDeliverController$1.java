package com.tencent.mobileqq.kandian.biz.ugc.video.transfer;

import android.os.Message;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;

class KingsMomentVideoDeliverController$1
  extends TransProcessorHandler
{
  KingsMomentVideoDeliverController$1(KingsMomentVideoDeliverController paramKingsMomentVideoDeliverController) {}
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    if ((localFileMsg != null) && (localFileMsg.fileType == 24))
    {
      if (localFileMsg.commandId != 10) {
        return;
      }
      if (localFileMsg.uniseq != this.a.a.mUniseq) {
        return;
      }
      if (localFileMsg.fileMd5.equals(KingsMomentVideoDeliverController.a(this.a))) {
        return;
      }
      int i = paramMessage.what;
      if (i != 1002)
      {
        if (i != 1003)
        {
          if (i != 1005) {
            return;
          }
          QLog.d("KingsMomentVideoDeliveControllerr", 1, "upload king moment cover failed");
          KingsMomentVideoDeliverController.a(this.a, 13);
          return;
        }
        QLog.d("KingsMomentVideoDeliveControllerr", 1, "mPicTransProcessorHandler send finished!");
        KingsMomentVideoDeliverController.a(this.a, localFileMsg.fileMd5);
        KingsMomentVideoDeliverController.b(this.a, localFileMsg.fileUrl);
        paramMessage = new StringBuilder();
        paramMessage.append("mPicTransProcessorHandler mImageMd5=");
        paramMessage.append(KingsMomentVideoDeliverController.a(this.a));
        paramMessage.append(", mImageUrl=");
        paramMessage.append(KingsMomentVideoDeliverController.b(this.a));
        QLog.d("KingsMomentVideoDeliveControllerr", 1, paramMessage.toString());
        paramMessage = this.a;
        KingsMomentVideoDeliverController.a(paramMessage, 0, KingsMomentVideoDeliverController.b(paramMessage), KingsMomentVideoDeliverController.a(this.a), null, null, null);
        return;
      }
      paramMessage = new StringBuilder();
      paramMessage.append("mVideoTransProcessorHandler transfer=");
      paramMessage.append(localFileMsg.transferedSize);
      paramMessage.append(", total=");
      paramMessage.append(localFileMsg.fileSize);
      QLog.d("KingsMomentVideoDeliveControllerr", 1, paramMessage.toString());
      KingsMomentVideoDeliverController.a(this.a, (float)localFileMsg.transferedSize * 100.0F / (float)localFileMsg.fileSize);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.video.transfer.KingsMomentVideoDeliverController.1
 * JD-Core Version:    0.7.0.1
 */