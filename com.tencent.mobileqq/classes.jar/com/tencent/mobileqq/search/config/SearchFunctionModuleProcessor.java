package com.tencent.mobileqq.search.config;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.search.FunctionModuleConfigManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class SearchFunctionModuleProcessor
  extends IQConfigProcessor<SearchFunctionModuleBean>
{
  public SearchFunctionModuleBean a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[migrateOldOrDefaultContent] type=");
    localStringBuilder.append(paramInt);
    QLog.i("search_manager_configSearchFunctionModuleProcessor", 1, localStringBuilder.toString());
    return new SearchFunctionModuleBean();
  }
  
  public SearchFunctionModuleBean a(QConfItem[] paramArrayOfQConfItem)
  {
    return SearchFunctionModuleBean.a(paramArrayOfQConfItem);
  }
  
  public void a(SearchFunctionModuleBean paramSearchFunctionModuleBean)
  {
    FunctionModuleConfigManager localFunctionModuleConfigManager = null;
    if (paramSearchFunctionModuleBean == null) {
      paramSearchFunctionModuleBean = null;
    } else {
      paramSearchFunctionModuleBean = paramSearchFunctionModuleBean.a;
    }
    if (TextUtils.isEmpty(paramSearchFunctionModuleBean))
    {
      QLog.i("search_manager_configSearchFunctionModuleProcessor", 1, "[onUpdate] fileUrl is empty");
      return;
    }
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((localObject instanceof QQAppInterface)) {
      localFunctionModuleConfigManager = (FunctionModuleConfigManager)((QQAppInterface)localObject).getManager(QQManagerFactory.FUNCTION_MODULE_MANAGER);
    }
    if (localFunctionModuleConfigManager != null) {
      localFunctionModuleConfigManager.b(paramSearchFunctionModuleBean);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onUpdate] fileUrl =");
    ((StringBuilder)localObject).append(paramSearchFunctionModuleBean);
    ((StringBuilder)localObject).append(",manager=");
    boolean bool;
    if (localFunctionModuleConfigManager != null) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)localObject).append(bool);
    QLog.i("search_manager_configSearchFunctionModuleProcessor", 1, ((StringBuilder)localObject).toString());
  }
  
  public Class<SearchFunctionModuleBean> clazz()
  {
    return SearchFunctionModuleBean.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
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
    QLog.i("search_manager_configSearchFunctionModuleProcessor", 1, localStringBuilder.toString());
  }
  
  public int type()
  {
    return 190;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.config.SearchFunctionModuleProcessor
 * JD-Core Version:    0.7.0.1
 */