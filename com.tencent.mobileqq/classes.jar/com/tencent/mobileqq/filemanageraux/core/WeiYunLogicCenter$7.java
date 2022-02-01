package com.tencent.mobileqq.filemanageraux.core;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.weiyun.api.download.IDownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class WeiYunLogicCenter$7
  implements IDownloadListener
{
  WeiYunLogicCenter$7(WeiYunLogicCenter paramWeiYunLogicCenter, String paramString, int paramInt, Object paramObject) {}
  
  public void a(String paramString, long paramLong, float paramFloat) {}
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, int paramInt)
  {
    int i;
    if ((paramBoolean) && (paramString1 != null) && (!TextUtils.isEmpty(paramString2)) && (new File(paramString2).exists())) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("getWeiYunThumb onSucceed. filePath[");
        paramString1.append(paramString2);
        paramString1.append("]");
        QLog.d("WeiYunLogicCenter<FileAssistant>", 2, paramString1.toString());
      }
      WeiYunLogicCenter.c(this.d).getFileManagerNotifyCenter().a(true, 39, new Object[] { this.a, Integer.valueOf(this.b), paramString2, this.c });
      return;
    }
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("getWeiYunThumb onFailed: errcode[");
      paramString1.append(paramInt);
      paramString1.append("], errmsg[");
      paramString1.append(paramString3);
      paramString1.append("]");
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, paramString1.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.core.WeiYunLogicCenter.7
 * JD-Core Version:    0.7.0.1
 */