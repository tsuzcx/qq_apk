package com.tencent.mobileqq.qqlive.prepare.covercrop;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.qqlive.callback.upload.IQQLiveUploadBitmapCallback;
import com.tencent.mobileqq.qqlive.data.upload.QQLiveUploadBitmapResult;
import com.tencent.qphone.base.util.QLog;

class QQLivePhotoCropFragment$6
  implements IQQLiveUploadBitmapCallback
{
  QQLivePhotoCropFragment$6(QQLivePhotoCropFragment paramQQLivePhotoCropFragment) {}
  
  public void a(QQLiveUploadBitmapResult paramQQLiveUploadBitmapResult)
  {
    Intent localIntent = new Intent();
    if (paramQQLiveUploadBitmapResult != null)
    {
      if (paramQQLiveUploadBitmapResult.isSuccess)
      {
        QQLivePhotoCropFragment.c(this.a).roomLogo16v9 = paramQQLiveUploadBitmapResult.url;
        QQLivePhotoCropFragment.c(this.a).roomLogoTime16v9 = paramQQLiveUploadBitmapResult.timeStamp;
        localIntent.putExtra("COVER_INFO_KEY", QQLivePhotoCropFragment.c(this.a));
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("upload bitmap success cover url ");
        localStringBuilder.append(paramQQLiveUploadBitmapResult.url);
        QLog.d("QQLivePhotoCropFragment", 1, localStringBuilder.toString());
      }
      else
      {
        localIntent.putExtra("upload_error_code", paramQQLiveUploadBitmapResult.retCode);
        localIntent.putExtra("upload_error_message", paramQQLiveUploadBitmapResult.errorMsg);
      }
    }
    else
    {
      localIntent.putExtra("upload_error_code", -1);
      QLog.d("QQLivePhotoCropFragment", 1, "upload bitmap fail");
    }
    paramQQLiveUploadBitmapResult = this.a.getQBaseActivity();
    if ((paramQQLiveUploadBitmapResult != null) && (!paramQQLiveUploadBitmapResult.isFinishing())) {
      paramQQLiveUploadBitmapResult.setResult(-1, localIntent);
    }
    QQLivePhotoCropFragment.a(this.a);
    QQLivePhotoCropFragment.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.prepare.covercrop.QQLivePhotoCropFragment.6
 * JD-Core Version:    0.7.0.1
 */