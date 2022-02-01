package com.tencent.mobileqq.filemanager.activity.recentfile;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.api.IQQFileDataCenter;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanager.data.ThumbnailInfo;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.weiyun.api.IOpenWeiyunVipHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class QfileBaseRecentFileTabView$7
  extends FMObserver
{
  QfileBaseRecentFileTabView$7(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  protected void a(int paramInt, long paramLong, String paramString)
  {
    super.a(paramInt, paramLong, paramString);
    QQFileManagerUtil.a(paramLong, paramInt, paramString);
    ((IOpenWeiyunVipHelper)QRoute.api(IOpenWeiyunVipHelper.class)).showWeiYunSpaceOrFlowLimitDialog(this.a.C, paramInt);
  }
  
  protected void a(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    super.a(paramLong, paramString1, paramInt, paramString2);
    QQFileManagerUtil.b(paramLong);
    this.a.i();
  }
  
  protected void a(ThumbnailInfo paramThumbnailInfo)
  {
    if (paramThumbnailInfo == null) {
      return;
    }
    if ((paramThumbnailInfo.c instanceof FileManagerEntity))
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramThumbnailInfo.c;
      if ((paramThumbnailInfo.d != null) && (paramThumbnailInfo.d.length() > 0))
      {
        localFileManagerEntity.strThumbPath = paramThumbnailInfo.d;
        ((IQQFileDataCenter)QfileBaseRecentFileTabView.s(this.a).getRuntimeService(IQQFileDataCenter.class, "")).updateFileEntity(localFileManagerEntity);
        this.a.i();
      }
    }
  }
  
  protected void a(Boolean paramBoolean, List<OfflineFileInfo> paramList) {}
  
  protected void a(Integer paramInteger, long paramLong, String paramString)
  {
    QfileBaseRecentFileTabView.d(this.a, new QfileBaseRecentFileTabView.7.3(this));
    QQFileManagerUtil.a(paramLong, paramInteger.intValue(), paramString);
    ((IOpenWeiyunVipHelper)QRoute.api(IOpenWeiyunVipHelper.class)).showWeiYunSpaceOrFlowLimitDialog(this.a.C, paramInteger.intValue());
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    QfileBaseRecentFileTabView.b(this.a, new QfileBaseRecentFileTabView.7.1(this));
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    Object localObject = ((IQQFileDataCenter)QfileBaseRecentFileTabView.t(this.a).getRuntimeService(IQQFileDataCenter.class)).queryFileEntity(paramLong1, paramString1, paramInt1, paramLong2);
    if (localObject == null)
    {
      paramString2 = QfileBaseRecentFileTabView.a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OnFileCome,but query FileEntity null,uniseq[");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append("], nSessionId[");
      ((StringBuilder)localObject).append(paramLong2);
      ((StringBuilder)localObject).append("], strUin[");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("], peerType[");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("]");
      QLog.e(paramString2, 1, ((StringBuilder)localObject).toString());
      return;
    }
    if (!paramBoolean)
    {
      ((FileManagerEntity)localObject).bDelInFM = false;
      QQFileManagerUtil.a(paramLong2, paramInt2, paramString2);
      ((IOpenWeiyunVipHelper)QRoute.api(IOpenWeiyunVipHelper.class)).showWeiYunSpaceOrFlowLimitDialog(this.a.C, paramInt2);
    }
    else
    {
      paramInt1 = ((FileManagerEntity)localObject).nOpType;
      if ((paramInt1 == 4) || (paramInt1 == 20) || (paramInt1 == 6)) {
        QQFileManagerUtil.b(paramLong2);
      }
    }
    if ((this.a.b == null) || (this.a.b.trim().length() == 0) || (((FileManagerEntity)localObject).getCloudType() != 2)) {
      this.a.c((FileManagerEntity)localObject);
    }
    ((IQQFileDataCenter)QfileBaseRecentFileTabView.u(this.a).getRuntimeService(IQQFileDataCenter.class, "")).updateFileEntity((FileManagerEntity)localObject);
  }
  
  protected void b()
  {
    super.b();
    QfileBaseRecentFileTabView.e(this.a, new QfileBaseRecentFileTabView.7.4(this));
  }
  
  protected void b(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    Object localObject = ((IQQFileDataCenter)QfileBaseRecentFileTabView.v(this.a).getRuntimeService(IQQFileDataCenter.class)).queryFileEntity(paramLong1, paramString, paramInt, paramLong2);
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = QfileBaseRecentFileTabView.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("OnFileCome,but query FileEntity null,uniseq[");
        localStringBuilder.append(paramLong1);
        localStringBuilder.append("], nSessionId[");
        localStringBuilder.append(paramLong2);
        localStringBuilder.append("], strUin[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("], peerType[");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("]");
        QLog.e((String)localObject, 2, localStringBuilder.toString());
      }
      return;
    }
    this.a.c((FileManagerEntity)localObject);
    ((IQQFileDataCenter)QfileBaseRecentFileTabView.w(this.a).getRuntimeService(IQQFileDataCenter.class, "")).updateFileEntity((FileManagerEntity)localObject);
    QfileBaseRecentFileTabView.c(this.a, new QfileBaseRecentFileTabView.7.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView.7
 * JD-Core Version:    0.7.0.1
 */