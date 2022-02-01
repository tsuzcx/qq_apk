package com.tencent.mobileqq.filemanager.fileviewer.data;

import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.mobileqq.filemanager.app.FileTransferObserver;
import com.tencent.mobileqq.filemanager.core.FileVideoDownloadManager.FileVideoManagerCallback;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class VideoForDisc$1
  extends FileTransferObserver
{
  VideoForDisc$1(VideoForDisc paramVideoForDisc, FileVideoDownloadManager.FileVideoManagerCallback paramFileVideoManagerCallback) {}
  
  protected void a(boolean paramBoolean, long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, long paramLong2, Bundle paramBundle)
  {
    paramString1 = new StringBuilder();
    paramString1.append("[");
    paramString1.append(this.b.a.nSessionId);
    paramString1.append("],[getOnlinePlay Url]  ID[");
    paramString1.append(paramLong2);
    paramString1.append("] OnDiscDownloadInfo");
    QLog.i("VideoForDisc<QFile>", 2, paramString1.toString());
    if (paramLong1 != -100001L)
    {
      if ((paramLong1 == -25081L) || (paramLong1 == -6101L) || (paramLong1 == -7003L)) {
        break label292;
      }
      if (!paramBoolean)
      {
        this.b.a(false);
        this.a.a((int)0L, BaseApplication.getContext().getResources().getString(2131887903));
        return;
      }
    }
    if ((paramString3 != null) && (paramString3.length() != 0))
    {
      paramString1 = new StringBuilder();
      paramString1.append("http://");
      paramString1.append(paramString3);
      paramString1.append(":");
      paramString1.append(String.valueOf(paramInt1));
      paramString1.append("/ftn_handler/");
      paramString1.append(paramString4);
      paramString1 = paramString1.toString();
      if (QLog.isColorLevel()) {
        QLog.d("VideoForDisc<QFile>", 1, paramString1);
      }
      this.a.a(paramString1, paramString5);
      return;
    }
    paramLong2 = 9360L;
    if (paramLong1 == 0L) {
      paramLong2 = 9048L;
    }
    this.a.a((int)paramLong2, BaseApplication.getContext().getResources().getString(2131887903));
    return;
    label292:
    this.b.a(true);
    this.a.a((int)paramLong1, BaseApplication.getContext().getResources().getString(2131889822));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.data.VideoForDisc.1
 * JD-Core Version:    0.7.0.1
 */