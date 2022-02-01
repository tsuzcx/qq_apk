package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.transfile.quic.QuicNetResMgr;
import com.tencent.qphone.base.util.QLog;

public class QQShortVideoQuicNetProcessor
  extends IQConfigProcessor<QQShortVideoQuicNetProcessor.ShortVideoQuicNetConfBean>
{
  public static QQShortVideoQuicNetProcessor.ShortVideoQuicNetConfBean a()
  {
    return (QQShortVideoQuicNetProcessor.ShortVideoQuicNetConfBean)QConfigManager.a().a(685);
  }
  
  @NonNull
  public QQShortVideoQuicNetProcessor.ShortVideoQuicNetConfBean a(int paramInt)
  {
    return new QQShortVideoQuicNetProcessor.ShortVideoQuicNetConfBean();
  }
  
  @Nullable
  public QQShortVideoQuicNetProcessor.ShortVideoQuicNetConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return QQShortVideoQuicNetProcessor.ShortVideoQuicNetConfBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(QQShortVideoQuicNetProcessor.ShortVideoQuicNetConfBean paramShortVideoQuicNetConfBean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQShortVideoQuicNetProcessor", 2, "QQShortVideoQuicNetProcessor onUpdate");
    }
    QuicNetResMgr.getInstance().downloadQuicRes(paramShortVideoQuicNetConfBean);
  }
  
  public Class<QQShortVideoQuicNetProcessor.ShortVideoQuicNetConfBean> clazz()
  {
    return QQShortVideoQuicNetProcessor.ShortVideoQuicNetConfBean.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
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
    return 685;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.QQShortVideoQuicNetProcessor
 * JD-Core Version:    0.7.0.1
 */