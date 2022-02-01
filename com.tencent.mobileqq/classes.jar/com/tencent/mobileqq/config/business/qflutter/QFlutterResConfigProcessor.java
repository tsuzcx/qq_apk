package com.tencent.mobileqq.config.business.qflutter;

import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.flutter.download.QFlutterDownloader;
import com.tencent.mobileqq.qqexpand.utils.ILog;
import com.tencent.mobileqq.qqexpand.utils.LogUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/config/business/qflutter/QFlutterResConfigProcessor;", "Lcom/tencent/mobileqq/config/IQConfigProcessor;", "Lcom/tencent/mobileqq/config/business/qflutter/QFlutterResConfig;", "()V", "clazz", "Ljava/lang/Class;", "isNeedCompressed", "", "isNeedStoreLargeFile", "migrateOldOrDefaultContent", "type", "", "migrateOldVersion", "onParsed", "config", "", "Lcom/tencent/mobileqq/config/QConfItem;", "([Lcom/tencent/mobileqq/config/QConfItem;)Lcom/tencent/mobileqq/config/business/qflutter/QFlutterResConfig;", "onReqFailed", "", "failCode", "onUpdate", "newConf", "Companion", "OptionList", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class QFlutterResConfigProcessor
  extends IQConfigProcessor<QFlutterResConfig>
{
  public static final QFlutterResConfigProcessor.Companion a = new QFlutterResConfigProcessor.Companion(null);
  
  public QFlutterResConfigProcessor()
  {
    LogUtils localLogUtils = LogUtils.a;
    if (QLog.isColorLevel()) {
      localLogUtils.a().a("QFlutterResConfigProcessor", 2, "init... branchName = feature/_8.4.17_ExtendFriend, version = 8.7.0");
    }
  }
  
  @JvmStatic
  @NotNull
  public static final QFlutterResConfig a()
  {
    return a.a();
  }
  
  @JvmStatic
  @NotNull
  public static final QFlutterResConfigProcessor.OptionList a(@NotNull ExpandModuleKey paramExpandModuleKey)
  {
    return a.a(paramExpandModuleKey);
  }
  
  @JvmStatic
  public static final boolean a(@NotNull ExpandModuleKey paramExpandModuleKey)
  {
    return a.a(paramExpandModuleKey);
  }
  
  @NotNull
  public QFlutterResConfig a(int paramInt)
  {
    return new QFlutterResConfig();
  }
  
  @NotNull
  public QFlutterResConfig a(@NotNull QConfItem[] paramArrayOfQConfItem)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfQConfItem, "config");
    return QFlutterResConfig.jdField_a_of_type_ComTencentMobileqqConfigBusinessQflutterQFlutterResConfig$Companion.a(paramArrayOfQConfItem);
  }
  
  public void a(@NotNull QFlutterResConfig paramQFlutterResConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramQFlutterResConfig, "newConf");
    Object localObject = LogUtils.a;
    if (QLog.isColorLevel())
    {
      localObject = ((LogUtils)localObject).a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Config updated to ... ");
      localStringBuilder.append(paramQFlutterResConfig);
      ((ILog)localObject).a("QFlutterResConfigProcessor", 2, localStringBuilder.toString());
    }
    QFlutterResConfig.jdField_a_of_type_ComTencentMobileqqConfigBusinessQflutterQFlutterResConfig = paramQFlutterResConfig;
    QFlutterDownloader.g();
  }
  
  @NotNull
  public Class<QFlutterResConfig> clazz()
  {
    return QFlutterResConfig.class;
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
    Object localObject = LogUtils.a;
    if (QLog.isColorLevel())
    {
      localObject = ((LogUtils)localObject).a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Config update but failed: errCode = ");
      localStringBuilder.append(paramInt);
      ((ILog)localObject).a("QFlutterResConfigProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public int type()
  {
    return 706;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qflutter.QFlutterResConfigProcessor
 * JD-Core Version:    0.7.0.1
 */