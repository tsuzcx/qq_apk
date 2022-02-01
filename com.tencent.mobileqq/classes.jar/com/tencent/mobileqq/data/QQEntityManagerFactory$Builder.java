package com.tencent.mobileqq.data;

import com.tencent.mobileqq.data.entitymanager.Interceptor;
import com.tencent.mobileqq.data.entitymanager.OnDBTableVerifyFailListener;
import com.tencent.mobileqq.data.entitymanager.Provider;
import com.tencent.mobileqq.data.entitymanager.upgrade.DBUpgradeEntity;
import com.tencent.mobileqq.data.entitymanager.upgrade.IAfterDBUpgradeListener;
import com.tencent.mobileqq.data.entitymanager.upgrade.IOnDBUpgradeListener;
import com.tencent.mobileqq.persistence.Entity;
import java.util.List;

public final class QQEntityManagerFactory$Builder
{
  IAfterDBUpgradeListener mAfterDBUpgradeListener;
  List<Interceptor<Void>> mCorruptionInterceptorList;
  List<DBUpgradeEntity> mDBUpgradeEntityList;
  Provider<Integer> mDBVersionProvider;
  String mName;
  OnDBTableVerifyFailListener mOnDBTableVerifyFailListener;
  IOnDBUpgradeListener mOnDBUpgradeListener;
  List<Interceptor<Class>> mTableColumnCheckInterceptorList;
  List<Entity> mTableEntityList;
  List<Class<? extends Entity>> mVerifyClassList;
  
  public QQEntityManagerFactory$Builder(String paramString, Provider<Integer> paramProvider)
  {
    this.mName = paramString;
    this.mDBVersionProvider = paramProvider;
  }
  
  public Builder afterDBUpgradeListener(IAfterDBUpgradeListener paramIAfterDBUpgradeListener)
  {
    this.mAfterDBUpgradeListener = paramIAfterDBUpgradeListener;
    return this;
  }
  
  public QQEntityManagerFactory build()
  {
    return new QQEntityManagerFactory(this, null);
  }
  
  public Builder corruptionInterceptors(List<Interceptor<Void>> paramList)
  {
    this.mCorruptionInterceptorList = paramList;
    return this;
  }
  
  public Builder dbUpgradeEntityList(List<DBUpgradeEntity> paramList)
  {
    this.mDBUpgradeEntityList = paramList;
    return this;
  }
  
  public Builder onDBTableVerifyFailListener(OnDBTableVerifyFailListener paramOnDBTableVerifyFailListener)
  {
    this.mOnDBTableVerifyFailListener = paramOnDBTableVerifyFailListener;
    return this;
  }
  
  public Builder onDBUpgradeListener(IOnDBUpgradeListener paramIOnDBUpgradeListener)
  {
    this.mOnDBUpgradeListener = paramIOnDBUpgradeListener;
    return this;
  }
  
  public Builder tableColumnCheckInterceptors(List<Interceptor<Class>> paramList)
  {
    this.mTableColumnCheckInterceptorList = paramList;
    return this;
  }
  
  public Builder tableEntityList(List<Entity> paramList)
  {
    this.mTableEntityList = paramList;
    return this;
  }
  
  public Builder verifyClassList(List<Class<? extends Entity>> paramList)
  {
    this.mVerifyClassList = paramList;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.QQEntityManagerFactory.Builder
 * JD-Core Version:    0.7.0.1
 */