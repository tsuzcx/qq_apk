package com.tencent.mobileqq.filemanager.openbrowser;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ThumbnailInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.mediabrowser.IMediaBrowserProviderCallBack;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Map;

class MediaFileBrowseProcessorBase$4
  extends FMObserver
{
  MediaFileBrowseProcessorBase$4(MediaFileBrowseProcessorBase paramMediaFileBrowseProcessorBase) {}
  
  protected void a(ThumbnailInfo paramThumbnailInfo)
  {
    String str = String.valueOf(paramThumbnailInfo.e);
    if (!this.a.f.containsKey(str)) {
      return;
    }
    int j = ((Integer)this.a.f.get(str)).intValue();
    int i;
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramThumbnailInfo.d))) {
      i = 1;
    } else {
      i = 2;
    }
    this.a.d.a(j, 0, 18, i, paramThumbnailInfo.d, false);
  }
  
  protected void a(ThumbnailInfo paramThumbnailInfo, int paramInt)
  {
    Object localObject = String.valueOf(paramThumbnailInfo.e);
    if (!this.a.f.containsKey(localObject)) {
      return;
    }
    int i = ((Integer)this.a.f.get(localObject)).intValue();
    localObject = this.a.a.getFileManagerDataCenter().a(paramThumbnailInfo.e);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onThumbDownLoadProgress: error, entity[");
      ((StringBuilder)localObject).append(paramThumbnailInfo.e);
      ((StringBuilder)localObject).append("] is null");
      QLog.i("MediaFileBrowseProcessorBase", 2, ((StringBuilder)localObject).toString());
      return;
    }
    this.a.d.a(i, 0, 18, paramInt, ((FileManagerEntity)localObject).fileSize, false);
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (this.a.d == null)
    {
      QLog.i("MediaFileBrowseProcessorBase", 2, "onFileTransferProgress: error, callback is null");
      return;
    }
    if (!this.a.f.containsKey(String.valueOf(paramLong2))) {
      return;
    }
    paramString = this.a.a.getFileManagerDataCenter().a(paramLong2);
    if (paramString == null)
    {
      paramString = new StringBuilder();
      paramString.append("OnFileTransferProgress: error, entity[");
      paramString.append(paramLong2);
      paramString.append("] is null");
      QLog.i("MediaFileBrowseProcessorBase", 2, paramString.toString());
      return;
    }
    paramInt = ((Integer)this.a.f.get(String.valueOf(paramLong2))).intValue();
    if (paramString.nFileType == 0) {
      this.a.d.a(paramInt, 0, 20, (int)(paramString.fProgress * 10000.0F), paramString.fileSize, false);
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (this.a.d == null)
    {
      QLog.i("MediaFileBrowseProcessorBase", 2, "onFileTransferEnd: error, callback is null");
      return;
    }
    if (!this.a.f.containsKey(String.valueOf(paramLong2))) {
      return;
    }
    paramInt1 = ((Integer)this.a.f.get(String.valueOf(paramLong2))).intValue();
    paramString1 = this.a.a.getFileManagerDataCenter().a(paramLong2);
    if (paramString1 == null)
    {
      paramString1 = new StringBuilder();
      paramString1.append("onFileTransferEnd: error, entity[");
      paramString1.append(paramLong2);
      paramString1.append("] is null");
      QLog.i("MediaFileBrowseProcessorBase", 2, paramString1.toString());
      return;
    }
    if (paramBoolean)
    {
      if (paramString1.nFileType == 0)
      {
        this.a.d.a(paramInt1, 0, 20, 1, paramString1.getFilePath(), false);
        return;
      }
      if (paramString1.nFileType == 2)
      {
        if (this.a.g.contains(Long.valueOf(paramLong1)))
        {
          paramString2 = BaseApplicationImpl.sApplication.getBaseContext();
          if (paramString2 != null) {
            FileManagerUtil.a(paramString2, paramString1.getFilePath());
          } else {
            QLog.i("MediaFileBrowseProcessorBase<QFile>", 1, "AIO gallery service error, get context is null [c2c file save album].");
          }
          this.a.g.remove(Long.valueOf(paramLong1));
        }
        this.a.d.a(paramInt1, 0, 269484034, 1, paramString1.getFilePath(), false);
      }
    }
    else
    {
      if ((paramInt2 == -7003) || (paramInt2 == -6101)) {
        paramString1.status = 16;
      }
      if (paramString1.nFileType == 0)
      {
        this.a.d.a(paramInt1, 0, 20, 2, paramString2, false);
        return;
      }
      if (paramString1.nFileType == 2) {
        this.a.d.a(paramInt1, 0, 269484034, 2, paramString2, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.openbrowser.MediaFileBrowseProcessorBase.4
 * JD-Core Version:    0.7.0.1
 */