package com.tencent.mobileqq.filemanager.activity.recentfile;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanager.data.ThumbnailInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.vip.OpenWeiyunVipHelper;
import java.util.List;

class QfileBaseRecentFileTabView$10
  extends FMObserver
{
  QfileBaseRecentFileTabView$10(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public void a(int paramInt, long paramLong, String paramString)
  {
    super.a(paramInt, paramLong, paramString);
    FileManagerUtil.a(paramLong, paramInt, paramString);
    OpenWeiyunVipHelper.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, paramInt);
  }
  
  public void a(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    super.a(paramLong, paramString1, paramInt, paramString2);
    FileManagerUtil.a(paramLong);
    this.a.i();
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
    QfileBaseRecentFileTabView.C(this.a).getFileManagerDataCenter().c(localFileManagerEntity);
    this.a.i();
  }
  
  public void a(Boolean paramBoolean, List<OfflineFileInfo> paramList)
  {
    QfileBaseRecentFileTabView.a(this.a, paramBoolean, paramList);
  }
  
  public void a(Integer paramInteger, long paramLong, String paramString)
  {
    QfileBaseRecentFileTabView.e(this.a, new QfileBaseRecentFileTabView.10.4(this));
    FileManagerUtil.a(paramLong, paramInteger.intValue(), paramString);
    OpenWeiyunVipHelper.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, paramInteger.intValue());
  }
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    QfileBaseRecentFileTabView.b(this.a, new QfileBaseRecentFileTabView.10.1(this));
  }
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    FileManagerEntity localFileManagerEntity = QfileBaseRecentFileTabView.D(this.a).getFileManagerDataCenter().a(paramLong1, paramString1, paramInt1, paramLong2);
    if (localFileManagerEntity == null)
    {
      QLog.e(QfileBaseRecentFileTabView.jdField_a_of_type_JavaLangString, 1, "OnFileCome,but query FileEntity null,uniseq[" + paramLong1 + "], nSessionId[" + paramLong2 + "], strUin[" + FileManagerUtil.e(paramString1) + "], peerType[" + paramInt1 + "]");
      return;
    }
    if (!paramBoolean)
    {
      localFileManagerEntity.bDelInFM = false;
      FileManagerUtil.a(paramLong2, paramInt2, paramString2);
      OpenWeiyunVipHelper.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, paramInt2);
    }
    for (;;)
    {
      if ((this.a.b == null) || (this.a.b.trim().length() == 0) || (localFileManagerEntity.getCloudType() != 2)) {
        this.a.b(localFileManagerEntity);
      }
      QfileBaseRecentFileTabView.E(this.a).getFileManagerDataCenter().c(localFileManagerEntity);
      QfileBaseRecentFileTabView.c(this.a, new QfileBaseRecentFileTabView.10.2(this, paramLong2));
      return;
      paramInt1 = localFileManagerEntity.nOpType;
      if ((paramInt1 == 4) || (paramInt1 == 20) || (paramInt1 == 6)) {
        FileManagerUtil.a(paramLong2);
      }
    }
  }
  
  public void b()
  {
    super.b();
    QfileBaseRecentFileTabView.f(this.a, new QfileBaseRecentFileTabView.10.5(this));
  }
  
  public void b(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    FileManagerEntity localFileManagerEntity = QfileBaseRecentFileTabView.G(this.a).getFileManagerDataCenter().a(paramLong1, paramString, paramInt, paramLong2);
    if (localFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(QfileBaseRecentFileTabView.jdField_a_of_type_JavaLangString, 2, "OnFileCome,but query FileEntity null,uniseq[" + paramLong1 + "], nSessionId[" + paramLong2 + "], strUin[" + FileManagerUtil.e(paramString) + "], peerType[" + paramInt + "]");
      }
      return;
    }
    this.a.b(localFileManagerEntity);
    QfileBaseRecentFileTabView.H(this.a).getFileManagerDataCenter().c(localFileManagerEntity);
    QfileBaseRecentFileTabView.d(this.a, new QfileBaseRecentFileTabView.10.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView.10
 * JD-Core Version:    0.7.0.1
 */