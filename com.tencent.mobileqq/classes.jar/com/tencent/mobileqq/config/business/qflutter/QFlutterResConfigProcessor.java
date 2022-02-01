package com.tencent.mobileqq.config.business.qflutter;

import com.tencent.biz.expand.utils.LogUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.earlydownload.xmldata.QFlutterAppData;
import com.tencent.mobileqq.earlydownload.xmldata.QFlutterEngineData;
import com.tencent.mobileqq.flutter.download.QFlutterDownloader;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/config/business/qflutter/QFlutterResConfigProcessor;", "Lcom/tencent/mobileqq/config/IQConfigProcessor;", "Lcom/tencent/mobileqq/config/business/qflutter/QFlutterResConfig;", "()V", "clazz", "Ljava/lang/Class;", "isNeedCompressed", "", "isNeedStoreLargeFile", "migrateOldOrDefaultContent", "type", "", "migrateOldVersion", "onParsed", "config", "", "Lcom/tencent/mobileqq/config/QConfItem;", "([Lcom/tencent/mobileqq/config/QConfItem;)Lcom/tencent/mobileqq/config/business/qflutter/QFlutterResConfig;", "onReqFailed", "", "failCode", "onUpdate", "newConf", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class QFlutterResConfigProcessor
  extends IQConfigProcessor<QFlutterResConfig>
{
  public static final QFlutterResConfigProcessor.Companion a = new QFlutterResConfigProcessor.Companion(null);
  
  public QFlutterResConfigProcessor()
  {
    LogUtils localLogUtils = LogUtils.a;
    if (QLog.isColorLevel()) {
      QLog.d("QFlutterResConfigProcessor", 2, "init... branchName = feature/_8.4.17_ExtendFriend, version = 8.5.5");
    }
  }
  
  @JvmStatic
  @NotNull
  public static final QFlutterResConfig a()
  {
    return a.a();
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
    LogUtils localLogUtils = LogUtils.a;
    if (QLog.isColorLevel()) {
      QLog.d("QFlutterResConfigProcessor", 2, "Config updated to ... " + paramQFlutterResConfig);
    }
    QFlutterResConfig.jdField_a_of_type_ComTencentMobileqqConfigBusinessQflutterQFlutterResConfig = paramQFlutterResConfig;
    paramQFlutterResConfig = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(paramQFlutterResConfig, "BaseApplicationImpl.getApplication()");
    paramQFlutterResConfig = paramQFlutterResConfig.getRuntime();
    if ((paramQFlutterResConfig instanceof QQAppInterface))
    {
      QFlutterEngineData.createDownloader((QQAppInterface)paramQFlutterResConfig).f();
      QFlutterAppData.createDownloader((QQAppInterface)paramQFlutterResConfig).f();
    }
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
    LogUtils localLogUtils = LogUtils.a;
    if (QLog.isColorLevel()) {
      QLog.d("QFlutterResConfigProcessor", 2, "Config update but failed: errCode = " + paramInt);
    }
  }
  
  public int type()
  {
    return 706;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qflutter.QFlutterResConfigProcessor
 * JD-Core Version:    0.7.0.1
 */