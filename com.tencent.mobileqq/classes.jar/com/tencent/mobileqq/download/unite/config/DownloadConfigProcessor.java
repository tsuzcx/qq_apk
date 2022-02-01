package com.tencent.mobileqq.download.unite.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class DownloadConfigProcessor
  extends IQConfigProcessor<DownloadConfigBean>
{
  public static DownloadConfigBean a()
  {
    return (DownloadConfigBean)QConfigManager.b().b(692);
  }
  
  @NonNull
  public DownloadConfigBean a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[UniteDownload] DownloadConfigProcessor", 2, new Object[] { "[config] migrateOldOrDefaultContent: invoked. ", " type: ", Integer.valueOf(paramInt) });
    }
    return new DownloadConfigBean();
  }
  
  @Nullable
  public DownloadConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.i("[UniteDownload] DownloadConfigProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return DownloadConfigBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(DownloadConfigBean paramDownloadConfigBean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[UniteDownload] DownloadConfigProcessor", 2, new Object[] { "[config] onUpdate: invoked. ", " newConf: ", paramDownloadConfigBean });
    }
  }
  
  public Class<DownloadConfigBean> clazz()
  {
    return DownloadConfigBean.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 692;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.download.unite.config.DownloadConfigProcessor
 * JD-Core Version:    0.7.0.1
 */