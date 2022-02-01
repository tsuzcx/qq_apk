package com.tencent.mobileqq.config.business.qvip;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;

public abstract class BaseQVipConfigProcessor<T>
  extends IQConfigProcessor<T>
{
  @NonNull
  public abstract T a();
  
  @NonNull
  public abstract T a(@NonNull QConfItem[] paramArrayOfQConfItem);
  
  @NonNull
  public abstract T b();
  
  public boolean isAccountRelated()
  {
    return true;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  @NonNull
  public T migrateOldOrDefaultContent(int paramInt)
  {
    Object localObject1 = null;
    if (paramInt == 1) {
      localObject1 = b();
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        AssertUtils.a(getClass().getName() + ".migrateOldOrDefaultContent return null!! type=" + paramInt, new Object[0]);
        localObject2 = a();
      }
      return localObject2;
      if (paramInt == 0) {
        localObject1 = a();
      } else {
        AssertUtils.a(getClass().getName() + ".migrateOldOrDefaultContent illegal type: " + paramInt, new Object[0]);
      }
    }
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  @Nullable
  public T onParsed(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem == null) || (paramArrayOfQConfItem.length <= 0))
    {
      SLog.e("QVipConfigProcessor", getClass().getName() + ".onParsed error: confFiles is empty");
      paramArrayOfQConfItem = a();
      if (paramArrayOfQConfItem != null) {}
      for (boolean bool = true;; bool = false)
      {
        AssertUtils.a(bool, getClass().getName() + ".onParsed error: confFiles is empty");
        return paramArrayOfQConfItem;
      }
    }
    SLog.d("QVipConfigProcessor", getClass().getName() + ".parsed content count=" + paramArrayOfQConfItem.length);
    return a(paramArrayOfQConfItem);
  }
  
  public void onReqFailed(int paramInt)
  {
    SLog.e("QVipConfigProcessor", getClass().getName() + ".onReqFailed: " + paramInt);
  }
  
  public void onUpdate(T paramT)
  {
    SLog.d("QVipConfigProcessor", getClass().getName() + ".onUpdate: " + paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qvip.BaseQVipConfigProcessor
 * JD-Core Version:    0.7.0.1
 */