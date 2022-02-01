package com.tencent.mobileqq.vas.config.business.qvip;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.vas.util.AssertUtils;

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
    Object localObject1;
    if (paramInt == 1)
    {
      localObject1 = b();
    }
    else if (paramInt == 0)
    {
      localObject1 = a();
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(getClass().getName());
      ((StringBuilder)localObject1).append(".migrateOldOrDefaultContent illegal type: ");
      ((StringBuilder)localObject1).append(paramInt);
      AssertUtils.a(((StringBuilder)localObject1).toString(), new Object[0]);
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(getClass().getName());
      ((StringBuilder)localObject1).append(".migrateOldOrDefaultContent return null!! type=");
      ((StringBuilder)localObject1).append(paramInt);
      AssertUtils.a(((StringBuilder)localObject1).toString(), new Object[0]);
      localObject2 = a();
    }
    return localObject2;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  @Nullable
  public T onParsed(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(getClass().getName());
      localStringBuilder.append(".parsed content count=");
      localStringBuilder.append(paramArrayOfQConfItem.length);
      SLog.d("QVipConfigProcessor", localStringBuilder.toString());
      return a(paramArrayOfQConfItem);
    }
    paramArrayOfQConfItem = new StringBuilder();
    paramArrayOfQConfItem.append(getClass().getName());
    paramArrayOfQConfItem.append(".onParsed error: confFiles is empty");
    SLog.e("QVipConfigProcessor", paramArrayOfQConfItem.toString());
    paramArrayOfQConfItem = a();
    boolean bool;
    if (paramArrayOfQConfItem != null) {
      bool = true;
    } else {
      bool = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getName());
    localStringBuilder.append(".onParsed error: confFiles is empty");
    AssertUtils.a(bool, localStringBuilder.toString());
    return paramArrayOfQConfItem;
  }
  
  public void onReqFailed(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getName());
    localStringBuilder.append(".onReqFailed: ");
    localStringBuilder.append(paramInt);
    SLog.e("QVipConfigProcessor", localStringBuilder.toString());
  }
  
  public void onUpdate(T paramT)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getName());
    localStringBuilder.append(".onUpdate: ");
    localStringBuilder.append(paramT);
    SLog.d("QVipConfigProcessor", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor
 * JD-Core Version:    0.7.0.1
 */