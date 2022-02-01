package com.tencent.mobileqq.filemanager.fileviewer.model;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ThumbnailInfo;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.weiyun.api.IOpenWeiyunVipHelper;
import com.tencent.qphone.base.util.QLog;

class C2CFileModel$C2CFileObserver
  extends FMObserver
{
  private C2CFileModel$C2CFileObserver(C2CFileModel paramC2CFileModel) {}
  
  protected void a(int paramInt, long paramLong, String paramString)
  {
    ((IOpenWeiyunVipHelper)QRoute.api(IOpenWeiyunVipHelper.class)).showWeiYunSpaceOrFlowLimitDialog(this.a.i, paramInt);
    if (paramLong != this.a.c.r().nSessionId) {
      return;
    }
    FileManagerUtil.a(paramLong, paramInt, paramString);
  }
  
  protected void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2, Bundle paramBundle)
  {
    if (paramLong != this.a.c.r().nSessionId) {
      return;
    }
    if ((this.a.y != null) && (paramInt1 == 0)) {
      this.a.y.a(paramInt2, paramString1, paramString2, paramBundle);
    }
  }
  
  protected void a(long paramLong1, long paramLong2)
  {
    super.a(paramLong1, paramLong2);
    if ((paramLong1 == this.a.c.a()) && (this.a.k != null)) {
      this.a.k.b();
    }
  }
  
  protected void a(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (paramLong2 != this.a.c.a()) {
      return;
    }
    if (this.a.q != null) {
      this.a.q.d();
    }
  }
  
  protected void a(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    if (paramLong != this.a.c.r().nSessionId) {
      return;
    }
    if ((paramString2 != null) && (paramString2.length() > 0) && (paramInt != 0)) {
      FileManagerUtil.l(paramString2);
    }
  }
  
  protected void a(ThumbnailInfo paramThumbnailInfo)
  {
    if ((!TextUtils.isEmpty(paramThumbnailInfo.a)) && (!TextUtils.isEmpty(paramThumbnailInfo.d)))
    {
      if (this.a.s != null) {
        this.a.s.a(paramThumbnailInfo.a, paramThumbnailInfo.d);
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OnThumbDownLoad error : [fileId] = ");
      localStringBuilder.append(paramThumbnailInfo.a);
      localStringBuilder.append(" [path] = ");
      localStringBuilder.append(paramThumbnailInfo.d);
      QLog.i("C2CFileModel<FileAssistant>", 2, localStringBuilder.toString());
    }
  }
  
  protected void a(Integer paramInteger, long paramLong, String paramString)
  {
    FileManagerUtil.a(paramLong, paramInteger.intValue(), paramString);
  }
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, String paramString1, String paramString2)
  {
    if (!paramBoolean) {
      return;
    }
    paramInt = this.a.z();
    if (paramInt == 4)
    {
      if (this.a.s != null) {
        this.a.s.a(String.valueOf(paramLong), paramString2);
      }
    }
    else if (paramInt == 0)
    {
      if ((this.a.C() == paramLong) && (this.a.s != null)) {
        this.a.s.a(String.valueOf(paramLong), paramString2);
      }
    }
    else if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("OnZipImageThumbDownloadCompleted : sessionId[");
      paramString1.append(paramLong);
      paramString1.append("]  thumbPath[");
      paramString1.append(paramString2);
      paramString1.append("] but current file browser can not handle");
      QLog.i("C2CFileModel<FileAssistant>", 2, paramString1.toString());
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt, String paramString1, long paramLong1, long paramLong2, String paramString2, long paramLong3)
  {
    if (!paramBoolean) {
      FileManagerUtil.a(paramLong3, paramInt, paramString1);
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (paramLong2 != this.a.c.a()) {
      return;
    }
    paramString = this.a.c.r();
    if (paramString == null) {
      return;
    }
    if ((paramString.getCloudType() == 0) && (paramString.nOpType == 10)) {
      return;
    }
    if (this.a.q != null) {
      this.a.q.a(paramString.fProgress);
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OnFileTransferEnd : isSuccess[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], uniseq[");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("], nSessionId[");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(paramString1);
      localStringBuilder.append("], peerType[");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("]");
      QLog.d("C2CFileModel<FileAssistant>", 2, localStringBuilder.toString());
    }
    ((IOpenWeiyunVipHelper)QRoute.api(IOpenWeiyunVipHelper.class)).showWeiYunSpaceOrFlowLimitDialog(this.a.i, paramInt2);
    if (paramLong2 != this.a.c.a()) {
      return;
    }
    if (this.a.q == null) {
      return;
    }
    if (!paramBoolean)
    {
      FileManagerUtil.a(paramLong2, paramInt2, paramString2);
      this.a.q.g();
      return;
    }
    if (this.a.z() == 2)
    {
      new Handler().postDelayed(new C2CFileModel.C2CFileObserver.1(this), 1000L);
      return;
    }
    this.a.q.f();
  }
  
  protected void c(int paramInt, String paramString)
  {
    FileManagerUtil.l(paramString);
  }
  
  protected void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.C2CFileModel.C2CFileObserver
 * JD-Core Version:    0.7.0.1
 */