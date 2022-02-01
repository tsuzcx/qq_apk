package com.tencent.mobileqq.config.business.tendoc;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import mqq.app.AppRuntime;

public class TencentDocHistoryTabToastProcessor
  extends IQConfigProcessor<TencentDocHistoryTabToastBean>
{
  public static TencentDocHistoryTabToastBean a()
  {
    return (TencentDocHistoryTabToastBean)QConfigManager.a().a(483);
  }
  
  @NonNull
  public TencentDocHistoryTabToastBean a(int paramInt)
  {
    return new TencentDocHistoryTabToastBean();
  }
  
  @Nullable
  public TencentDocHistoryTabToastBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return TencentDocHistoryTabToastBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(TencentDocHistoryTabToastBean paramTencentDocHistoryTabToastBean)
  {
    BaseApplicationImpl.getApplication().getRuntime().getPreferences().edit().putInt("key_tencent_doc_history_tab_tips_count", 0).apply();
  }
  
  public Class<TencentDocHistoryTabToastBean> clazz()
  {
    return TencentDocHistoryTabToastBean.class;
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
    return 483;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocHistoryTabToastProcessor
 * JD-Core Version:    0.7.0.1
 */