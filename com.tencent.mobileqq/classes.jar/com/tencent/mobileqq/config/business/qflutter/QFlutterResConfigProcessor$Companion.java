package com.tencent.mobileqq.config.business.qflutter;

import com.tencent.biz.expand.utils.LogUtils;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/config/business/qflutter/QFlutterResConfigProcessor$Companion;", "", "()V", "CONFIG_ID", "", "TAG", "", "getConfig", "Lcom/tencent/mobileqq/config/business/qflutter/QFlutterResConfig;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class QFlutterResConfigProcessor$Companion
{
  @JvmStatic
  @NotNull
  public final QFlutterResConfig a()
  {
    QFlutterResConfig localQFlutterResConfig = (QFlutterResConfig)QConfigManager.a().a(706);
    if (localQFlutterResConfig != null) {}
    for (;;)
    {
      LogUtils localLogUtils = LogUtils.a;
      if (QLog.isColorLevel()) {
        QLog.d("QFlutterResConfigProcessor", 2, "getConfig " + localQFlutterResConfig);
      }
      return localQFlutterResConfig;
      localQFlutterResConfig = new QFlutterResConfig();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qflutter.QFlutterResConfigProcessor.Companion
 * JD-Core Version:    0.7.0.1
 */