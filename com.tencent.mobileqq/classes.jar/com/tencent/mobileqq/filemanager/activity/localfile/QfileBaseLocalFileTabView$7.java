package com.tencent.mobileqq.filemanager.activity.localfile;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ThumbnailInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import cooperation.weiyun.vip.OpenWeiyunVipHelper;

class QfileBaseLocalFileTabView$7
  extends FMObserver
{
  QfileBaseLocalFileTabView$7(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView) {}
  
  public void a(int paramInt, long paramLong, String paramString)
  {
    super.a(paramInt, paramLong, paramString);
    FileManagerUtil.a(paramLong, paramInt, paramString);
    OpenWeiyunVipHelper.a(this.a.a, paramInt);
  }
  
  public void a(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    super.a(paramLong, paramString1, paramInt, paramString2);
    FileManagerUtil.a(paramLong);
  }
  
  public void a(ThumbnailInfo paramThumbnailInfo)
  {
    if (paramThumbnailInfo == null) {}
    FileManagerEntity localFileManagerEntity;
    do
    {
      do
      {
        return;
      } while (!(paramThumbnailInfo.a instanceof FileManagerEntity));
      localFileManagerEntity = (FileManagerEntity)paramThumbnailInfo.a;
    } while ((paramThumbnailInfo.b == null) || (paramThumbnailInfo.b.length() <= 0));
    localFileManagerEntity.strThumbPath = paramThumbnailInfo.b;
    QfileBaseLocalFileTabView.c(this.a).getFileManagerDataCenter().c(localFileManagerEntity);
    this.a.i();
  }
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    QfileBaseLocalFileTabView.a(this.a, new QfileBaseLocalFileTabView.7.1(this));
  }
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    QfileBaseLocalFileTabView.b(this.a, new QfileBaseLocalFileTabView.7.2(this, paramLong2, paramBoolean, paramInt2, paramString2));
  }
  
  public void b()
  {
    super.b();
    QfileBaseLocalFileTabView.c(this.a, new QfileBaseLocalFileTabView.7.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView.7
 * JD-Core Version:    0.7.0.1
 */