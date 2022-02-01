package com.tencent.mobileqq.transfile;

import android.content.Intent;
import ayeu;
import bcef;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import lkd;

class TransFileController$1
  implements Runnable
{
  TransFileController$1(TransFileController paramTransFileController, String paramString, Intent paramIntent, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject = new CompressInfo(this.val$filePath, 0);
    ((CompressInfo)localObject).f = 0;
    ayeu.a((CompressInfo)localObject);
    String str = "";
    boolean bool;
    int i;
    if (this.val$intent != null)
    {
      bool = this.val$intent.getBooleanExtra("PhotoConst.SYNCQZONE", false);
      str = this.val$intent.getStringExtra("PhotoConst.SOURCE_FROM");
      if ("FROM_SELECT_PHOTO".equals(str)) {
        i = 1;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby_people_card.upload_local_photo", 2, ".uploadPhoto(), img_path = " + ((CompressInfo)localObject).e + ",isSyncQZone=" + bool);
      }
      TransferRequest localTransferRequest;
      if (!StringUtil.isEmpty(((CompressInfo)localObject).e))
      {
        localTransferRequest = new TransferRequest();
        localTransferRequest.mIsUp = true;
        localTransferRequest.mLocalPath = ((CompressInfo)localObject).e;
        localTransferRequest.mFileType = 22;
        localObject = new lkd();
        if (!bool) {
          break label310;
        }
      }
      label310:
      for (byte b = 1;; b = 0)
      {
        ((lkd)localObject).a(b);
        localTransferRequest.mExtentionInfo = ((lkd)localObject).a();
        localTransferRequest.mUpCallBack = new TransFileController.1.1(this, bool, str);
        this.this$0.transferAsync(localTransferRequest);
        if (bool)
        {
          int j = this.val$intent.getIntExtra("PhotoConst.SYNCQZONE_CHECKSTATE", 1);
          bcef.b(this.val$app, "dc00898", "", "", "0X8007C16", "0X8007C16", j, 0, "", "", "", "");
        }
        bcef.b(this.val$app, "dc00898", "", "", "0X8007C17", "0X8007C17", i, 0, "", "", "", "");
        return;
        if ("FROM_TAKE_PHOTO".equals(str))
        {
          i = 2;
          break;
        }
        i = 3;
        break;
      }
      i = 3;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.TransFileController.1
 * JD-Core Version:    0.7.0.1
 */