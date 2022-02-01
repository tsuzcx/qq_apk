package com.tencent.mobileqq.utils.abtest;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ExpMgrListProcessor
  extends IQConfigProcessor<ExpMgrListProcessor.ExpMgrListData>
{
  private static final ConcurrentHashMap<Integer, String> a = new ConcurrentHashMap();
  
  public static ConcurrentHashMap<Integer, String> a()
  {
    return a;
  }
  
  public static void b()
  {
    ExpMgrListProcessor.ExpMgrListData localExpMgrListData = (ExpMgrListProcessor.ExpMgrListData)QConfigManager.b().b(742);
    if (localExpMgrListData != null) {
      ExpMgrListProcessor.ExpMgrListData.a(localExpMgrListData);
    }
  }
  
  @NonNull
  public ExpMgrListProcessor.ExpMgrListData a(int paramInt)
  {
    return new ExpMgrListProcessor.ExpMgrListData();
  }
  
  @Nullable
  public ExpMgrListProcessor.ExpMgrListData a(QConfItem[] paramArrayOfQConfItem)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onParsed conf length:");
    localStringBuilder.append(paramArrayOfQConfItem.length);
    ABTestUtil.a("QQExpListProcessor", localStringBuilder.toString());
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      paramArrayOfQConfItem = paramArrayOfQConfItem[0];
      paramArrayOfQConfItem = new ExpMgrListProcessor.ExpMgrListData(paramArrayOfQConfItem.a, paramArrayOfQConfItem.b);
      ExpMgrListProcessor.ExpMgrListData.a(paramArrayOfQConfItem);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onParsed expListContent:");
      localStringBuilder.append(paramArrayOfQConfItem.a());
      ABTestUtil.a("QQExpListProcessor", localStringBuilder.toString());
      return paramArrayOfQConfItem;
    }
    return null;
  }
  
  public void a(ExpMgrListProcessor.ExpMgrListData paramExpMgrListData)
  {
    if (paramExpMgrListData != null) {
      ExpMgrListProcessor.ExpMgrListData.a(paramExpMgrListData);
    }
    if (ABTestController.a().b())
    {
      ABTestController.a().a(a);
      return;
    }
    paramExpMgrListData = MobileQQ.sMobileQQ.waitAppRuntime(null);
    ABTestController.a().c();
    ABTestController.a().a(MobileQQ.sMobileQQ, paramExpMgrListData.getAccount());
  }
  
  public Class<ExpMgrListProcessor.ExpMgrListData> clazz()
  {
    return ExpMgrListProcessor.ExpMgrListData.class;
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
    localStringBuilder.append("onReqFailed code:");
    localStringBuilder.append(paramInt);
    ABTestUtil.a("QQExpListProcessor", localStringBuilder.toString());
  }
  
  public int type()
  {
    return 742;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.abtest.ExpMgrListProcessor
 * JD-Core Version:    0.7.0.1
 */