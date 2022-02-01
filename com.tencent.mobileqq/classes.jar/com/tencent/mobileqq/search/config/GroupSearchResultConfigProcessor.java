package com.tencent.mobileqq.search.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class GroupSearchResultConfigProcessor
  extends IQConfigProcessor<GroupSearchResultConfigBean>
{
  @NonNull
  public GroupSearchResultConfigBean a(int paramInt)
  {
    return new GroupSearchResultConfigBean();
  }
  
  @Nullable
  public GroupSearchResultConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    return GroupSearchResultConfigBean.a(paramArrayOfQConfItem);
  }
  
  public void a(GroupSearchResultConfigBean paramGroupSearchResultConfigBean)
  {
    QLog.i("search_manager_configGroupSearchResultConfigProcessor", 1, "onUpdate");
  }
  
  public Class<GroupSearchResultConfigBean> clazz()
  {
    return GroupSearchResultConfigBean.class;
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
  
  public void onReqFailed(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReqFailed failCode=");
    localStringBuilder.append(paramInt);
    QLog.i("search_manager_configGroupSearchResultConfigProcessor", 1, localStringBuilder.toString());
  }
  
  public int type()
  {
    return 749;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.config.GroupSearchResultConfigProcessor
 * JD-Core Version:    0.7.0.1
 */