package com.tencent.mobileqq.config.business;

import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/config/business/BrowserOpenConfProcessor;", "Lcom/tencent/mobileqq/config/IQConfigProcessor;", "Lcom/tencent/mobileqq/config/business/BrowserOpenBean;", "()V", "clazz", "Ljava/lang/Class;", "isNeedCompressed", "", "isNeedStoreLargeFile", "migrateOldOrDefaultContent", "type", "", "migrateOldVersion", "onParsed", "confFiles", "", "Lcom/tencent/mobileqq/config/QConfItem;", "([Lcom/tencent/mobileqq/config/QConfItem;)Lcom/tencent/mobileqq/config/business/BrowserOpenBean;", "onReqFailed", "", "failCode", "onUpdate", "newConf", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class BrowserOpenConfProcessor
  extends IQConfigProcessor<BrowserOpenBean>
{
  @NotNull
  public BrowserOpenBean a(int paramInt)
  {
    return new BrowserOpenBean();
  }
  
  @Nullable
  public BrowserOpenBean a(@NotNull QConfItem[] paramArrayOfQConfItem)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfQConfItem, "confFiles");
    if ((paramArrayOfQConfItem.length > 0) && (paramArrayOfQConfItem[0] != null))
    {
      BrowserOpenBean localBrowserOpenBean = BrowserOpenConfProcessorKt.a(paramArrayOfQConfItem[0].a);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed ");
        localStringBuilder.append(paramArrayOfQConfItem[0].a);
        QLog.d("[BrowserOpt] H5BrowserOpenConfProcessor", 2, localStringBuilder.toString());
      }
      return localBrowserOpenBean;
    }
    if (QLog.isColorLevel()) {
      QLog.d("[BrowserOpt] H5BrowserOpenConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public void a(@NotNull BrowserOpenBean paramBrowserOpenBean)
  {
    Intrinsics.checkParameterIsNotNull(paramBrowserOpenBean, "newConf");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate ");
      localStringBuilder.append(paramBrowserOpenBean);
      QLog.d("[BrowserOpt] H5BrowserOpenConfProcessor", 2, localStringBuilder.toString());
    }
  }
  
  @NotNull
  public Class<BrowserOpenBean> clazz()
  {
    return BrowserOpenBean.class;
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
    return 627;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.BrowserOpenConfProcessor
 * JD-Core Version:    0.7.0.1
 */