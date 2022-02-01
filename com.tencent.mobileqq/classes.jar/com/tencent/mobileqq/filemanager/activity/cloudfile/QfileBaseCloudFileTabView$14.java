package com.tencent.mobileqq.filemanager.activity.cloudfile;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.api.IQQFileDataCenter;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ThumbnailInfo;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.weiyun.api.IWeiyunApi;
import java.util.ArrayList;
import java.util.Iterator;

class QfileBaseCloudFileTabView$14
  extends FMObserver
{
  QfileBaseCloudFileTabView$14(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
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
        ((IQQFileDataCenter)QfileBaseCloudFileTabView.o(this.a).getRuntimeService(IQQFileDataCenter.class, "")).updateFileEntity(localFileManagerEntity);
        this.a.i();
      }
    }
    else if ((paramThumbnailInfo.c instanceof WeiYunFileInfo))
    {
      this.a.i();
    }
  }
  
  protected void a(String paramString1, String paramString2, Integer paramInteger, String paramString3, boolean paramBoolean)
  {
    ((IWeiyunApi)QRoute.api(IWeiyunApi.class)).removeDeletedCloudFile(paramString1);
    QQFileManagerUtil.a(paramInteger.intValue(), paramString2);
    this.a.C.a(false);
  }
  
  protected void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString2 = ((IWeiyunApi)QRoute.api(IWeiyunApi.class)).removeDeletedCloudFile(paramString1);
    if ((!this.a.b(paramString2)) && (this.a.i != null) && (this.a.i.size() > 0))
    {
      paramString2 = this.a.i.iterator();
      while (paramString2.hasNext())
      {
        WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)paramString2.next();
        if (localWeiYunFileInfo.a.equalsIgnoreCase(paramString1) == true) {
          this.a.b(localWeiYunFileInfo);
        }
      }
    }
    this.a.C.a(false);
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    QfileBaseCloudFileTabView.a(this.a, new QfileBaseCloudFileTabView.14.1(this));
  }
  
  protected void b()
  {
    super.b();
    QfileBaseCloudFileTabView.b(this.a, new QfileBaseCloudFileTabView.14.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView.14
 * JD-Core Version:    0.7.0.1
 */