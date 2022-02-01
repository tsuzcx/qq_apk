package com.tencent.mobileqq.guild.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.Logger.ILog;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/guild/config/QQGuildShareConfigProcessor;", "Lcom/tencent/mobileqq/config/IQConfigProcessor;", "Lcom/tencent/mobileqq/guild/config/QQGuildShareConfigBean;", "()V", "clazz", "Ljava/lang/Class;", "isNeedCompressed", "", "isNeedStoreLargeFile", "migrateOldOrDefaultContent", "type", "", "migrateOldVersion", "onParsed", "confFiles", "", "Lcom/tencent/mobileqq/config/QConfItem;", "([Lcom/tencent/mobileqq/config/QConfItem;)Lcom/tencent/mobileqq/guild/config/QQGuildShareConfigBean;", "onReqFailed", "", "failCode", "onUpdate", "newConf", "Companion", "ConfigBeanDTO", "qqguild-impl_release"}, k=1, mv={1, 1, 16})
public final class QQGuildShareConfigProcessor
  extends IQConfigProcessor<QQGuildShareConfigBean>
{
  public static final QQGuildShareConfigProcessor.Companion a = new QQGuildShareConfigProcessor.Companion(null);
  
  @NotNull
  public QQGuildShareConfigBean a(int paramInt)
  {
    return new QQGuildShareConfigBean(false, null, 3, null);
  }
  
  @NotNull
  public QQGuildShareConfigBean a(@NotNull QConfItem[] paramArrayOfQConfItem)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfQConfItem, "confFiles");
    Gson localGson = new GsonBuilder().create();
    Object localObject1 = (QQGuildShareConfigBean)null;
    int j = paramArrayOfQConfItem.length;
    long l1 = -9223372036854775808L;
    int i = 0;
    Object localObject2;
    while (i < j)
    {
      localObject2 = paramArrayOfQConfItem[i];
      Object localObject3 = a;
      Intrinsics.checkExpressionValueIsNotNull(localGson, "gson");
      localObject3 = QQGuildShareConfigProcessor.Companion.a((QQGuildShareConfigProcessor.Companion)localObject3, localGson, (QConfItem)localObject2);
      localObject2 = localObject1;
      long l2 = l1;
      if (localObject3 != null)
      {
        localObject2 = localObject1;
        l2 = l1;
        if (((QQGuildShareConfigProcessor.ConfigBeanDTO)localObject3).getTime() > l1)
        {
          l2 = ((QQGuildShareConfigProcessor.ConfigBeanDTO)localObject3).getTime();
          localObject2 = new QQGuildShareConfigBean(((QQGuildShareConfigProcessor.ConfigBeanDTO)localObject3).getKaShouldNavigate(), ((QQGuildShareConfigProcessor.ConfigBeanDTO)localObject3).getKaNavigateUrl());
        }
      }
      i += 1;
      localObject1 = localObject2;
      l1 = l2;
    }
    paramArrayOfQConfItem = (QConfItem[])localObject1;
    if (localObject1 == null) {
      paramArrayOfQConfItem = new QQGuildShareConfigBean(false, null, 3, null);
    }
    localObject1 = Logger.a;
    if (QLog.isColorLevel())
    {
      localObject1 = ((Logger)localObject1).a();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onParsed result: ");
      ((StringBuilder)localObject2).append(paramArrayOfQConfItem);
      ((Logger.ILog)localObject1).a("QQGuildShareConfigProcessor", 2, ((StringBuilder)localObject2).toString());
    }
    QQGuildShareConfigBean.a.a(paramArrayOfQConfItem);
    return paramArrayOfQConfItem;
  }
  
  public void a(@Nullable QQGuildShareConfigBean paramQQGuildShareConfigBean)
  {
    Object localObject = Logger.a;
    if (QLog.isColorLevel())
    {
      localObject = ((Logger)localObject).a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate: ");
      localStringBuilder.append(paramQQGuildShareConfigBean);
      ((Logger.ILog)localObject).a("QQGuildShareConfigProcessor", 2, localStringBuilder.toString());
    }
  }
  
  @NotNull
  public Class<QQGuildShareConfigBean> clazz()
  {
    return QQGuildShareConfigBean.class;
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
    return 770;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.config.QQGuildShareConfigProcessor
 * JD-Core Version:    0.7.0.1
 */