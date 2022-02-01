package com.tencent.mobileqq.search.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.search.base.util.SearchConfigManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class SearchConfigProcessor
  extends IQConfigProcessor<SearchConfigBean>
{
  @NonNull
  public SearchConfigBean a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[migrateOldOrDefaultContent] type=");
    localStringBuilder.append(paramInt);
    QLog.i("search_manager_configSearchConfigProcessor", 1, localStringBuilder.toString());
    return new SearchConfigBean();
  }
  
  @Nullable
  public SearchConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    return SearchConfigBean.a(paramArrayOfQConfItem);
  }
  
  public void a(SearchConfigBean paramSearchConfigBean)
  {
    Object localObject = null;
    if (paramSearchConfigBean == null) {
      paramSearchConfigBean = null;
    } else {
      paramSearchConfigBean = paramSearchConfigBean.a;
    }
    if (TextUtils.isEmpty(paramSearchConfigBean))
    {
      QLog.i("search_manager_configSearchConfigProcessor", 1, "[onUpdate] configContent is empty");
      return;
    }
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localAppRuntime != null) {
      localObject = localAppRuntime.getCurrentUin();
    }
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      SearchConfigManager.a((String)localObject, paramSearchConfigBean);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onUpdate] configContent =");
    ((StringBuilder)localObject).append(paramSearchConfigBean);
    QLog.i("search_manager_configSearchConfigProcessor", 1, ((StringBuilder)localObject).toString());
  }
  
  public Class<SearchConfigBean> clazz()
  {
    return SearchConfigBean.class;
  }
  
  public boolean isNeedCompressed()
  {
    return false;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public boolean isNeedUpgradeReset()
  {
    return true;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onReqFailed] failCode=");
    localStringBuilder.append(paramInt);
    QLog.i("search_manager_configSearchConfigProcessor", 1, localStringBuilder.toString());
  }
  
  public int type()
  {
    return 50;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.config.SearchConfigProcessor
 * JD-Core Version:    0.7.0.1
 */