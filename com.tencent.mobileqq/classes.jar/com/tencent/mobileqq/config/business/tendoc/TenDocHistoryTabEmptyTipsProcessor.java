package com.tencent.mobileqq.config.business.tendoc;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;

public class TenDocHistoryTabEmptyTipsProcessor
  extends IQConfigProcessor<TenDocHistoryTabEmptyTipsBean>
{
  public static TenDocHistoryTabEmptyTipsBean a()
  {
    return (TenDocHistoryTabEmptyTipsBean)QConfigManager.b().b(521);
  }
  
  @NonNull
  public TenDocHistoryTabEmptyTipsBean a(int paramInt)
  {
    return new TenDocHistoryTabEmptyTipsBean();
  }
  
  @Nullable
  public TenDocHistoryTabEmptyTipsBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return TenDocHistoryTabEmptyTipsBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(TenDocHistoryTabEmptyTipsBean paramTenDocHistoryTabEmptyTipsBean) {}
  
  public Class<TenDocHistoryTabEmptyTipsBean> clazz()
  {
    return TenDocHistoryTabEmptyTipsBean.class;
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
    return 521;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TenDocHistoryTabEmptyTipsProcessor
 * JD-Core Version:    0.7.0.1
 */